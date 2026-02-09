package com.icure.cardinal.sdk.subscription

import com.icure.cardinal.sdk.auth.services.JwtBasedAuthProvider
import com.icure.cardinal.sdk.model.base.Identifiable
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.model.filter.chain.FilterChain
import com.icure.cardinal.sdk.model.notification.SubscriptionEventType
import com.icure.cardinal.sdk.utils.InternalCardinalException
import com.icure.utils.InternalIcureApi
import io.ktor.client.HttpClient
import io.ktor.client.plugins.plugin
import io.ktor.client.plugins.websocket.DefaultClientWebSocketSession
import io.ktor.client.plugins.websocket.WebSockets
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.prepareRequest
import io.ktor.client.request.url
import io.ktor.http.HttpMethod
import io.ktor.util.PlatformUtils
import io.ktor.websocket.CloseReason
import io.ktor.websocket.DefaultWebSocketSession
import io.ktor.websocket.Frame
import io.ktor.websocket.close
import io.ktor.websocket.readText
import io.ktor.websocket.send
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.async
import kotlinx.coroutines.cancel
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.Json
import kotlin.math.pow
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.minutes
import kotlin.time.Duration.Companion.seconds

/**
 * WebSocket wrapper that handles the connection and reconnection logic for a WebSocket connection
 *
 * The purpose of this class is to abstract the WebSocket connection and reconnection logic and provide a simple API to interact with the WebSocket connection
 *
 * Message received by the WebSocket connection are stored in a queue and processed by a callback, this allows to handle the messages in a non-blocking way and to avoid blocking the WebSocket connection (which could lead to disconnections due to Ping/Pong timeouts)
 *
 * If the queue is full, the connection will be closed and a fatal error will be emitted
 *
 * */
@InternalIcureApi
internal class WebSocketSubscription<E : Identifiable<String>> private constructor (
	private val hostname: String,
	private val path: String,
	private val webSocketAuthProvider: JwtBasedAuthProvider,
	private val client: HttpClient,
	private val clientJson: Json,
	private val config: EntitySubscriptionConfiguration,
	private val entitySerializer: KSerializer<E>,
	private val subscriptionRequest: String
): EntitySubscription<E> {
	companion object {
		// Should be same as on backend
		private val DURATION_BETWEEN_PINGS = 20.seconds
		private val CLOSE_REASON_GRACE_PERIOD = 3.seconds
		private val NO_PING_FROM_SERVER = CloseReason(
			code = CloseReason.Codes.NORMAL.code,
			message = "Server ping timeout",
		)

		suspend fun <BaseType : Identifiable<String>, NotificationEntity : BaseType> initialize(
			hostname: String,
			path: String,
			webSocketAuthProvider: JwtBasedAuthProvider,
			client: HttpClient,
			clientJson: Json,
			config: EntitySubscriptionConfiguration?,
			entitySerializer: KSerializer<NotificationEntity>,
			events: Set<com.icure.cardinal.sdk.subscription.SubscriptionEventType>,
			filter: AbstractFilter<BaseType>,
			qualifiedName: String,
			subscriptionRequestSerializer: (com.icure.cardinal.sdk.model.notification.Subscription<BaseType>) -> String,
		): WebSocketSubscription<NotificationEntity> {
			val subscriptionRequest = subscriptionRequestSerializer(
				com.icure.cardinal.sdk.model.notification.Subscription(
					eventTypes = events.map {
						when (it) {
							com.icure.cardinal.sdk.subscription.SubscriptionEventType.Create -> SubscriptionEventType.Create
							com.icure.cardinal.sdk.subscription.SubscriptionEventType.Update -> SubscriptionEventType.Update
						}
					},
					filter = FilterChain(
						filter = filter,
					),
					entityClass = qualifiedName,
					accessControlKeys = null,
					useCardinalModelSerialization = true
				),
			)
			val subscription = WebSocketSubscription(
				hostname,
				path,
				webSocketAuthProvider,
				client,
				clientJson,
				config ?: EntitySubscriptionConfiguration(),
				entitySerializer,
				subscriptionRequest
			)
			subscription.startConnection()
			return subscription
		}
	}

	private val wrapperScope = CoroutineScope(Dispatchers.Default)
	private val waitCloseReasonScope = CoroutineScope(Dispatchers.Default + SupervisorJob())
	private val _eventChannel = Channel<EntitySubscriptionEvent<E>>(
		capacity = config.channelBufferCapacity,
		onBufferOverflow = when (config.onBufferFull) {
			EntitySubscriptionConfiguration.FullBufferBehaviour.Close -> BufferOverflow.SUSPEND
			EntitySubscriptionConfiguration.FullBufferBehaviour.DropOldest -> BufferOverflow.DROP_OLDEST
			EntitySubscriptionConfiguration.FullBufferBehaviour.Ignore -> BufferOverflow.SUSPEND
		}
	)

	private lateinit var session: DefaultWebSocketSession
	private var _closeReason: EntitySubscriptionCloseReason? = null

	private var retriesAttempt = 0
	private var lastPingJob: Job? = null

	private suspend fun send(data: String) {
		session.send(data)
	}

	override val eventChannel: ReceiveChannel<EntitySubscriptionEvent<E>>
		get() = _eventChannel

	override suspend fun close() {
		closeDefinitely(EntitySubscriptionCloseReason.IntentionallyClosed)
	}

	override val closeReason: EntitySubscriptionCloseReason?
		get() = _closeReason

	private suspend fun closeDefinitely(closeReason: EntitySubscriptionCloseReason) {
		_closeReason = closeReason
		when (closeReason) {
			EntitySubscriptionCloseReason.ChannelFull -> {}
			EntitySubscriptionCloseReason.ConnectionLost -> sendEvent(EntitySubscriptionEvent.ConnectionError.ConnectionLost)
			EntitySubscriptionCloseReason.IntentionallyClosed -> sendEvent(EntitySubscriptionEvent.ClosedByClient)
		}
		session.close(CloseReason(CloseReason.Codes.NORMAL, "Closed by the client"))
		session.incoming.cancel()
		session.cancel()
		wrapperScope.cancel()
		waitCloseReasonScope.cancel()
		_eventChannel.close(null)
	}

	/**
	 * This will launch a job that will check if a ping has been received in the last [DURATION_BETWEEN_PINGS]
	 *
	 * If no ping has been received in the last [DURATION_BETWEEN_PINGS] and the job is still active, the connection will be closed. This should ignite the reconnection mechanism.
	 *
	 * @return The job that has been launched
	 */
	private fun DefaultWebSocketSession.launchPingTimeoutChecker(
		closeReasonDeferred: Deferred<CloseReason?>
	): Job = launch {
		delay(DURATION_BETWEEN_PINGS)
		if (isActive) {
			sendEvent(EntitySubscriptionEvent.ConnectionError.MissedPing)
			session.close(NO_PING_FROM_SERVER)
			session.incoming.cancel()
			wrapperScope.launch {
				delay(CLOSE_REASON_GRACE_PERIOD)
				if (!closeReasonDeferred.isCompleted) {
					closeReasonDeferred.cancel(UncompletedCloseReasonException())
				}
			}
		}
	}

	/**
	 * Incoming messages loop that will handle the incoming messages and dispatch them to the queue or to the appropriate event.
	 *
	 * This loop will handle the ping/pong mechanism and will close the connection if no ping is received in the last [DURATION_BETWEEN_PINGS]
	 *
	 * Note: Control frames are not supported in this loop, they should not be emitted by Ktor's ReceiveChannel
	 */
	private suspend fun incomingMessagesLoop(
		closeReasonDeferred: Deferred<CloseReason?>
	) = kotlin.runCatching {
		for (frame in session.incoming) {
			retriesAttempt = 0
			when (frame) {
				is Frame.Text -> {
					val content = frame.readText()
					if (content == "ping") {
						lastPingJob?.cancel()
						send("pong")
						lastPingJob = session.launchPingTimeoutChecker(closeReasonDeferred)
					} else {
						sendEvent(try {
							EntitySubscriptionEvent.EntityNotification(clientJson.decodeFromString(entitySerializer, content))
						} catch (_: SerializationException) {
							EntitySubscriptionEvent.EntityError.DeserializationError
						})
					}
				}
				is Frame.Binary -> throw InternalCardinalException("Binary frames are not supported in incoming messages loop")
				is Frame.Close -> throw InternalCardinalException("Close frames are not supported in incoming messages loop")
				is Frame.Ping -> throw InternalCardinalException("Ping frames are not supported in incoming messages loop")
				is Frame.Pong -> throw InternalCardinalException("Pong frames are not supported in incoming messages loop")
				else -> throw InternalCardinalException("Unknown frame type ${frame.frameType}")
			}
		}
	}.onFailure {
		if (it !is CancellationException) sendEvent(EntitySubscriptionEvent.UnexpectedError("${it::class.simpleName} - ${it.message}"))
	}

	private fun waitForCloseReasonDeferred(): Deferred<CloseReason?> = waitCloseReasonScope.async {
		session.closeReason.await()
	}

	/**
	 * Suspends until the connection is closed and emits the close event
	 */
	private suspend fun waitForClose(closeReasonDeferred: Deferred<CloseReason?>) {
		val wsCloseReason = try {
			closeReasonDeferred.await()
		} catch (_: UncompletedCloseReasonException) {
			NO_PING_FROM_SERVER
		}
	 	if (_closeReason == null && wsCloseReason != NO_PING_FROM_SERVER) _eventChannel.send(EntitySubscriptionEvent.ConnectionError.ClosedByServer)
	}

	// same as webSocketSession but allows to specify if wss or ws should be used
	private suspend fun HttpClient.initWsOrWssSession(
		unsecure: Boolean,
		method: HttpMethod = HttpMethod.Get,
		host: String,
		path: String,
		block: HttpRequestBuilder.() -> Unit = {}
	): DefaultClientWebSocketSession {
		plugin(WebSockets)
		val sessionDeferred = CompletableDeferred<DefaultClientWebSocketSession>()
		val statement = prepareRequest {
			this.method = method
			url(
				if (unsecure) "ws" else "wss",
				host,
				null,
				path
			)
			block()
		}
		@Suppress("SuspendFunctionOnCoroutineScope")
		launch {
			try {
				statement.body<DefaultClientWebSocketSession, Unit> { session ->
					val sessionCompleted = CompletableDeferred<Unit>()
					sessionDeferred.complete(session)
					session.outgoing.invokeOnClose {
						if (it != null) {
							sessionCompleted.completeExceptionally(it)
						} else sessionCompleted.complete(Unit)
					}
					sessionCompleted.await()
				}
			} catch (cause: Throwable) {
				sessionDeferred.completeExceptionally(cause)
			}
		}
		return sessionDeferred.await()
	}

	private suspend fun startSession(): DefaultClientWebSocketSession {
		val jwtToken = webSocketAuthProvider.getAuthService().getToken().token
		return client.initWsOrWssSession(
			unsecure = hostname.startsWith("http://"),
			method = HttpMethod.Get,
			host = hostname
				.removePrefix("http://")
				.removePrefix("https://"),
			path = path
				.takeIf { PlatformUtils.IS_BROWSER }
				?.let { "$it?jwt=${jwtToken}" } ?: path,
		) {
			if (!PlatformUtils.IS_BROWSER) {
				headers["Authorization"] = "Bearer $jwtToken"
			}
		}
	}

	private suspend fun startConnection() {
		session = startSession()

		send(subscriptionRequest)
		sendEvent(EntitySubscriptionEvent.Connected)

		val closeReasonDeferred = waitForCloseReasonDeferred()

		session.launch {
			incomingMessagesLoop(closeReasonDeferred)
		}

		wrapperScope.launch {
			waitForClose(closeReasonDeferred)
			reconnect()
		}
	}

	private fun exponentialRetry(
		attempt: Int,
		baseDelay: Long,
		maxDelay: Long = 30.minutes.inWholeMilliseconds,
		factor: Double,
	): Long {
		val delay = (baseDelay * factor.pow(attempt)).toLong()
		return delay.coerceAtMost(maxDelay)
	}

	private tailrec suspend fun reconnect() {
		if (_closeReason != null) return
		session.incoming.cancel()
		session.cancel()

		if (retriesAttempt >= config.connectionMaxRetries) {
			closeDefinitely(EntitySubscriptionCloseReason.ConnectionLost)
		} else {
			delay(
				exponentialRetry(
					attempt = retriesAttempt++,
					baseDelay = config.reconnectionDelay.inWholeMilliseconds,
					factor = config.retryDelayExponentFactor,
				).milliseconds,
			)
			val sessionOrNull = try {
				startSession()
			} catch (_: Exception) {
				null
			}

			if(sessionOrNull != null) {
				session = sessionOrNull

				send(subscriptionRequest)
				sendEvent(EntitySubscriptionEvent.Reconnected)
				val closeReasonDeferred = waitForCloseReasonDeferred()

				session.launch {
					incomingMessagesLoop(closeReasonDeferred)
				}

				waitForClose(closeReasonDeferred)
			}
			reconnect()
		}
	}

	/**
	 * Emit an event to the listeners
	 *
	 * @param event The event to be emitted
	 *
	 */
	private suspend fun sendEvent(event: EntitySubscriptionEvent<E>) {
		val sendResult = _eventChannel.trySend(event)
		if (sendResult.isFailure && config.onBufferFull == EntitySubscriptionConfiguration.FullBufferBehaviour.Close) {
			closeDefinitely(EntitySubscriptionCloseReason.ChannelFull)
		}
	}

	private class UncompletedCloseReasonException : CancellationException("Close reason did not complete within a reasonable time")
}
