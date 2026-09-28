package com.icure.cardinal.sdk.subscription

import com.icure.cardinal.sdk.auth.JwtBearer
import com.icure.cardinal.sdk.auth.services.JwtBasedAuthProvider
import com.icure.cardinal.sdk.auth.services.TokenBasedAuthService
import com.icure.cardinal.sdk.model.EncryptedHealthElement
import com.icure.cardinal.sdk.model.HealthElement
import com.icure.cardinal.sdk.model.filter.healthelement.HealthElementByHcPartyFilter
import com.icure.cardinal.sdk.serialization.HealthElementAbstractFilterSerializer
import com.icure.cardinal.sdk.serialization.SubscriptionSerializer
import com.icure.cardinal.sdk.utils.Serialization
import com.icure.cardinal.sdk.utils.newPlatformHttpClient
import com.icure.utils.InternalIcureApi
import io.kotest.assertions.fail
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldBeEmpty
import io.kotest.matchers.shouldBe
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.withTimeoutOrNull
import java.io.DataInputStream
import java.net.ServerSocket
import java.net.Socket
import java.security.MessageDigest
import java.util.Base64
import java.util.Collections
import java.util.concurrent.atomic.AtomicInteger
import kotlin.concurrent.thread
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.seconds

/**
 * Reproduces a subscription that never reconnects after the connection is lost abruptly, i.e. the
 * TCP stream ends without a WebSocket close frame (proxy/load-balancer drop, pod restart, …).
 *
 * With the OkHttp engine such a drop surfaces as `onFailure(EOFException)`, which Ktor turns into
 * `session.closeReason.completeExceptionally(EOFException)`. [WebSocketSubscription.waitForClose] only
 * catches `UncompletedCloseReasonException`, so the EOFException escapes the `wrapperScope.launch`
 * that should call `reconnect()`: the coroutine crashes into the uncaught exception handler,
 * `reconnect()` never runs, and the event channel is never closed. Consumers see a single
 * `UnexpectedError` and then wait forever.
 *
 * Netty's embedded server always closes gracefully, so a raw [ServerSocket] does the WebSocket
 * handshake by hand: the first connection is dropped with a bare TCP FIN once the subscription request
 * has been received, later connections are held open (as a healthy backend would).
 */
@OptIn(DelicateCoroutinesApi::class)
@InternalIcureApi
class AbruptDisconnectWebSocketTest : StringSpec({
	val client = newPlatformHttpClient {
		install(ContentNegotiation) {
			json(json = Serialization.json)
		}
		install(HttpTimeout)
		install(io.ktor.client.plugins.websocket.WebSockets)
	}

	val serverSocket = ServerSocket(0)
	val acceptedConnections = AtomicInteger(0)
	val openSockets = Collections.synchronizedList(mutableListOf<Socket>())
	thread(isDaemon = true, name = "abrupt-ws-server") {
		while (!serverSocket.isClosed) {
			val socket = try {
				serverSocket.accept()
			} catch (_: Exception) {
				break
			}
			openSockets.add(socket)
			completeWebSocketHandshake(socket)
			// Wait for the subscription request so the client is past `initialize` and fully connected.
			skipClientFrame(socket)
			if (acceptedConnections.incrementAndGet() == 1) {
				// Leave the client time to finish `initialize` and enter its steady state, then end the
				// stream without a close frame: the client reads EOF mid-frame-header.
				Thread.sleep(200)
				socket.shutdownOutput()
			}
		}
	}

	afterSpec {
		client.close()
		serverSocket.close()
		openSockets.forEach { runCatching { it.close() } }
	}

	"Should reconnect after the connection is lost without a close frame" {
		val authService = mockk<TokenBasedAuthService<JwtBearer>> {
			coEvery { getToken() } returns JwtBearer("token")
		}
		val authProvider = mockk<JwtBasedAuthProvider> {
			coEvery { getAuthService() } returns authService
		}

		// Collect exceptions escaping SDK coroutines: they end up in the default uncaught handler.
		val uncaught = Collections.synchronizedList(mutableListOf<Throwable>())
		val previousHandler = Thread.getDefaultUncaughtExceptionHandler()
		Thread.setDefaultUncaughtExceptionHandler { _, e -> uncaught.add(e) }

		try {
			val connection = WebSocketSubscription.initialize(
				client = client,
				hostname = "http://localhost:${serverSocket.localPort}",
				path = "/",
				clientJson = Serialization.json,
				entitySerializer = EncryptedHealthElement.serializer(),
				events = setOf(SubscriptionEventType.Create),
				filter = HealthElementByHcPartyFilter(
					hcpId = "fake-uuid",
				),
				qualifiedName = HealthElement.KRAKEN_QUALIFIED_NAME,
				subscriptionRequestSerializer = {
					Serialization.json.encodeToString(
						SubscriptionSerializer(
							HealthElementAbstractFilterSerializer
						), it
					)
				},
				webSocketAuthProvider = authProvider,
				config = EntitySubscriptionConfiguration(reconnectionDelay = 100.milliseconds),
			)

			val events = mutableListOf<EntitySubscriptionEvent<*>>()
			withTimeoutOrNull(10.seconds) {
				do {
					events.add(connection.eventChannel.receive().also { println("Client received: $it") })
				} while (events.last() != EntitySubscriptionEvent.Reconnected)
			} ?: fail(
				"Didn't reconnect within 10 seconds after an abrupt disconnect.\n" +
					"  events received:    $events\n" +
					"  server connections: ${acceptedConnections.get()}\n" +
					"  closeReason:        ${connection.closeReason}\n" +
					"  channel closed:     ${connection.eventChannel.isClosedForReceive}\n" +
					"  uncaught exceptions: ${uncaught.map { "${it::class.qualifiedName}: ${it.message}" }}"
			)

			acceptedConnections.get() shouldBe 2
			uncaught.shouldBeEmpty()
			connection.close()
		} finally {
			Thread.setDefaultUncaughtExceptionHandler(previousHandler)
		}
	}
})

private const val WEBSOCKET_GUID = "258EAFA5-E914-47DA-95CA-C5AB0DC85B11"

/** Reads the client's upgrade request and answers with a valid `101 Switching Protocols`. */
private fun completeWebSocketHandshake(socket: Socket) {
	// Read the request byte by byte: a buffered reader could swallow the first WebSocket frame.
	val input = socket.getInputStream()
	val request = StringBuilder()
	while (!request.endsWith("\r\n\r\n")) {
		val byte = input.read()
		check(byte >= 0) { "Connection closed during the handshake" }
		request.append(byte.toChar())
	}
	val key = request.lineSequence().firstNotNullOfOrNull { line ->
		line.split(":", limit = 2)
			.takeIf { it.size == 2 && it[0].trim().equals("Sec-WebSocket-Key", ignoreCase = true) }
			?.get(1)
			?.trim()
	} ?: error("Missing Sec-WebSocket-Key in the upgrade request")
	val accept = Base64.getEncoder().encodeToString(
		MessageDigest.getInstance("SHA-1").digest((key + WEBSOCKET_GUID).toByteArray(Charsets.ISO_8859_1))
	)
	val response = "HTTP/1.1 101 Switching Protocols\r\n" +
		"Upgrade: websocket\r\n" +
		"Connection: Upgrade\r\n" +
		"Sec-WebSocket-Accept: $accept\r\n" +
		"\r\n"
	socket.getOutputStream().apply {
		write(response.toByteArray(Charsets.ISO_8859_1))
		flush()
	}
}

/** Reads and discards one (masked, client-to-server) WebSocket frame. */
private fun skipClientFrame(socket: Socket) {
	val input = DataInputStream(socket.getInputStream())
	input.readUnsignedByte() // FIN + opcode
	val lengthByte = input.readUnsignedByte()
	val masked = lengthByte and 0x80 != 0
	val length = when (val len = lengthByte and 0x7F) {
		126 -> input.readUnsignedShort().toLong()
		127 -> input.readLong()
		else -> len.toLong()
	}
	input.readFully(ByteArray(((if (masked) 4 else 0) + length).toInt()))
}
