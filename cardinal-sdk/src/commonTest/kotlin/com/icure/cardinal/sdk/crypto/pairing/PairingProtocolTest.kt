package com.icure.cardinal.sdk.crypto.pairing

import com.icure.cardinal.sdk.utils.DEFAULT_ENABLED
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.AesService
import com.icure.kryptom.crypto.CryptoService
import com.icure.kryptom.crypto.RsaAlgorithm
import com.icure.kryptom.crypto.RsaService
import com.icure.kryptom.crypto.StrongRandom
import com.icure.kryptom.crypto.defaultCryptoService
import com.icure.kryptom.utils.hexToByteArray
import com.icure.kryptom.utils.toHexString
import com.icure.pairing.crypto.HkdfSha256
import com.icure.pairing.ec.PureKotlinSecp160r1Service
import com.icure.pairing.ec.Secp160r1Service
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.assertions.withClue
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.doubles.shouldBeGreaterThan
import io.kotest.matchers.doubles.shouldBeLessThan
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import io.kotest.matchers.types.shouldBeInstanceOf
import io.kotest.matchers.types.shouldNotBeInstanceOf
import kotlin.experimental.xor

/** An x-coordinate that is not on the curve (x = 3, see the `decompress` vectors in kryptom). */
private const val OFF_CURVE_X = "0000000000000000000000000000000000000003"

/**
 * ECDH vector 0 from secp160r1-pairing's `tools/secp160r1-ref/vectors.json`, inlined because that generator's Kotlin output
 * lives in that library's own test source set and is not visible here.
 */
private const val REF_XA = "fcc319a0e9ec857d81e2efdedb5d4ad952b4f082"
private const val REF_XB = "25cb07aec82d54ecc347040531fb622db3a74742"
private const val REF_SHARED = "b2c7954bc03d60a582a81570561a31dc11a0ded4"

/** Stand-in payload for the key-confirmation vectors, matching the Python reference. */
private val katPayload = ByteArray(300) { (it % 251).toByte() }

/** Counts decrypt calls, to prove the MAC is checked first. */
private class RecordingAes(private val delegate: AesService) : AesService by delegate {
	var decryptCalls = 0
	override suspend fun decrypt(ivAndEncryptedData: ByteArray, key: AesKey<*>): ByteArray {
		decryptCalls++
		return delegate.decrypt(ivAndEncryptedData, key)
	}
}

/** Returns all-zero bytes on the first draw, then real randomness. */
private class ZeroFirstRandom(private val delegate: StrongRandom) : StrongRandom {
	var calls = 0
	override fun fill(array: ByteArray) {
		calls++
		if (calls == 1) array.fill(0) else delegate.fill(array)
	}
}

class PairingProtocolTest : StringSpec({
	val crypto = defaultCryptoService
	val curve = PureKotlinSecp160r1Service(crypto.strongRandom)
	val initiator = PairingInitiator(crypto, curve)
	val responder = PairingResponder(crypto, curve)
	val now = 1_700_000_000_000L
	val secret = "the secret to transport".encodeToByteArray()
	val minEnvelope = 1 + Secp160r1Service.PUBLIC_KEY_BYTES + AesService.IV_BYTE_LENGTH + 16 + 32

	suspend fun envelopeFor(offer: PairingOffer, payload: ByteArray = secret): ByteArray =
		responder.respond(offer.code, payload).shouldBeInstanceOf<RespondResult.Responded>().envelope

	suspend fun acceptedSecret(offer: PairingOffer, envelope: ByteArray, at: Long = now + 1_000): String =
		initiator.accept(offer, envelope, at).shouldBeInstanceOf<AcceptResult.Accepted>().secret.toHexString()

	/** A completed pairing, as the two sides see it. */
	suspend fun pairedSessions(): Pair<PairingSession, PairingSession> {
		val offer = initiator.begin(now)
		val responded = responder.respond(offer.code, secret).shouldBeInstanceOf<RespondResult.Responded>()
		val accepted = initiator.accept(offer, responded.envelope, now + 1).shouldBeInstanceOf<AcceptResult.Accepted>()
		return accepted.session to responded.session
	}

	"happy path: the initiator recovers exactly the secret the responder sent".config(enabled = DEFAULT_ENABLED) {
		val offer = initiator.begin(now)
		offer.isUsed shouldBe false
		offer.notBeforeEpochMs shouldBe now
		offer.notAfterEpochMs - offer.notBeforeEpochMs shouldBe PAIRING_DEFAULT_TTL_MILLIS
		PAIRING_DEFAULT_TTL_MILLIS shouldBe 5 * 60 * 1000L
		PairingCode.decode(crypto.digest, offer.code).shouldBeInstanceOf<PairingCodeParseResult.Parsed>()
		val envelope = envelopeFor(offer)
		envelope[0] shouldBe 1.toByte()
		envelope.size shouldBe minEnvelope + 16 // the 23-byte secret pads to two blocks
		acceptedSecret(offer, envelope) shouldBe secret.toHexString()
		offer.isUsed shouldBe true
	}

	"secrets of any size travel intact, including empty and block-aligned ones".config(enabled = DEFAULT_ENABLED) {
		listOf(0, 1, 15, 16, 17, 100, 1000).forEach { size ->
			val payload = crypto.strongRandom.randomBytes(size)
			val offer = initiator.begin(now)
			withClue("size $size") { acceptedSecret(offer, envelopeFor(offer, payload)) shouldBe payload.toHexString() }
		}
	}

	"tampering with any field fails the MAC and leaves the offer usable".config(enabled = DEFAULT_ENABLED) {
		val offer = initiator.begin(now)
		val envelope = envelopeFor(offer)
		val keyStart = 1
		val ivStart = keyStart + Secp160r1Service.PUBLIC_KEY_BYTES
		val ciphertextStart = ivStart + AesService.IV_BYTE_LENGTH

		// A flipped bit in the responder key is a curve point only about half the time, so the refusal is either
		// MacFailed or InvalidKey; what matters is that it is refused and the offer stays usable.
		val flippedKey = envelope.copyOf().also { it[keyStart] = it[keyStart] xor 1 }
		withClue("responder key, bit flipped") {
			val result = initiator.accept(offer, flippedKey, now + 1)
			(result == AcceptResult.MacFailed || result == AcceptResult.InvalidKey) shouldBe true
			offer.isUsed shouldBe false
		}
		// A different but valid responder key must fail the MAC, deterministically.
		val otherKey = curve.publicKeyX(curve.randomScalar())
		val substitutedKey = envelope.copyOf().also { otherKey.copyInto(it, keyStart) }
		withClue("responder key, substituted by another valid key") {
			initiator.accept(offer, substitutedKey, now + 1) shouldBe AcceptResult.MacFailed
			offer.isUsed shouldBe false
		}

		mapOf("IV" to ivStart, "ciphertext" to ciphertextStart, "MAC" to envelope.size - 1).forEach { (field, index) ->
			val tampered = envelope.copyOf().also { it[index] = it[index] xor 1 }
			withClue(field) {
				initiator.accept(offer, tampered, now + 1) shouldBe AcceptResult.MacFailed
				offer.isUsed shouldBe false
			}
		}
		acceptedSecret(offer, envelope) shouldBe secret.toHexString()
	}

	"truncated and over-long envelopes are rejected without consuming the offer".config(enabled = DEFAULT_ENABLED) {
		val offer = initiator.begin(now)
		val envelope = envelopeFor(offer)
		val variants = mapOf(
			"one byte short" to envelope.copyOf(envelope.size - 1),
			"one block short" to envelope.copyOf(envelope.size - 16),
			"below the minimum" to envelope.copyOf(minEnvelope - 1),
			"empty" to ByteArray(0),
			"one byte long" to envelope + byteArrayOf(0),
			"one block long" to envelope + ByteArray(16),
		)
		variants.forEach { (name, bytes) ->
			withClue(name) {
				initiator.accept(offer, bytes, now + 1).shouldNotBeInstanceOf<AcceptResult.Accepted>()
				offer.isUsed shouldBe false
			}
		}
		initiator.accept(offer, envelope.copyOf(minEnvelope - 1), now + 1).shouldBeInstanceOf<AcceptResult.Malformed>()
		initiator.accept(offer, envelope.copyOf(envelope.size - 1), now + 1).shouldBeInstanceOf<AcceptResult.Malformed>()
		initiator.accept(offer, envelope.copyOf(envelope.size - 16), now + 1) shouldBe AcceptResult.MacFailed
		acceptedSecret(offer, envelope) shouldBe secret.toHexString()
	}

	"a wrong version byte in the envelope is rejected as an unknown version".config(enabled = DEFAULT_ENABLED) {
		val offer = initiator.begin(now)
		val envelope = envelopeFor(offer)
		initiator.accept(offer, envelope.copyOf().also { it[0] = 2 }, now + 1) shouldBe AcceptResult.UnknownVersion(2)
		initiator.accept(offer, envelope.copyOf().also { it[0] = 0 }, now + 1) shouldBe AcceptResult.UnknownVersion(0)
		offer.isUsed shouldBe false
		acceptedSecret(offer, envelope) shouldBe secret.toHexString()
	}

	"replaying an accepted envelope is refused".config(enabled = DEFAULT_ENABLED) {
		val offer = initiator.begin(now)
		val envelope = envelopeFor(offer)
		acceptedSecret(offer, envelope) shouldBe secret.toHexString()
		initiator.accept(offer, envelope, now + 2) shouldBe AcceptResult.AlreadyUsed
		initiator.accept(offer, envelopeFor(offer), now + 3) shouldBe AcceptResult.AlreadyUsed
		offer.isUsed shouldBe true
	}

	"garbage envelopes cannot consume the single-use slot".config(enabled = DEFAULT_ENABLED) {
		val offer = initiator.begin(now)
		val envelope = envelopeFor(offer)
		repeat(25) { i ->
			val garbage = crypto.strongRandom.randomBytes(minEnvelope + 16 * (i % 3)).also { it[0] = 1 }
			withClue("garbage #$i") {
				initiator.accept(offer, garbage, now + 1).shouldNotBeInstanceOf<AcceptResult.Accepted>()
				offer.isUsed shouldBe false
			}
		}
		acceptedSecret(offer, envelope) shouldBe secret.toHexString()
	}

	"an envelope built for one offer is refused by another".config(enabled = DEFAULT_ENABLED) {
		val first = initiator.begin(now)
		val second = initiator.begin(now)
		val forFirst = envelopeFor(first)
		initiator.accept(second, forFirst, now + 1) shouldBe AcceptResult.MacFailed
		second.isUsed shouldBe false
		acceptedSecret(first, forFirst) shouldBe secret.toHexString()
		acceptedSecret(second, envelopeFor(second)) shouldBe secret.toHexString()
	}

	"the validity window is enforced exactly at its boundaries".config(enabled = DEFAULT_ENABLED) {
		val offer = initiator.begin(now)
		val envelope = envelopeFor(offer)
		initiator.accept(offer, envelope, offer.notBeforeEpochMs - 1) shouldBe AcceptResult.NotYetValid
		initiator.accept(offer, envelope, offer.notAfterEpochMs) shouldBe AcceptResult.Expired
		initiator.accept(offer, envelope, offer.notAfterEpochMs + 1_000_000) shouldBe AcceptResult.Expired
		offer.isUsed shouldBe false
		acceptedSecret(offer, envelope, at = offer.notAfterEpochMs - 1) shouldBe secret.toHexString()

		val short = initiator.begin(now, ttlMillis = 1_000)
		short.notAfterEpochMs shouldBe now + 1_000
		acceptedSecret(short, envelopeFor(short), at = now) shouldBe secret.toHexString()
		shouldThrow<IllegalArgumentException> { initiator.begin(now, ttlMillis = 0) }
		shouldThrow<IllegalArgumentException> { initiator.begin(now, ttlMillis = -1) }
	}

	"an envelope whose responder key is off the curve yields InvalidKey, not a crash".config(enabled = DEFAULT_ENABLED) {
		val offer = initiator.begin(now)
		val envelope = envelopeFor(offer)
		val offCurve = envelope.copyOf().also { hexToByteArray(OFF_CURVE_X).copyInto(it, 1) }
		initiator.accept(offer, offCurve, now + 1) shouldBe AcceptResult.InvalidKey
		val aboveP = envelope.copyOf().also { ByteArray(20) { 0xFF.toByte() }.copyInto(it, 1) }
		initiator.accept(offer, aboveP, now + 1) shouldBe AcceptResult.InvalidKey
		offer.isUsed shouldBe false
		acceptedSecret(offer, envelope) shouldBe secret.toHexString()
	}

	"a code whose key is off the curve but passes its checksum yields InvalidKey".config(enabled = DEFAULT_ENABLED) {
		// Deliberately forged: the checksum matches, so only point validation stands between this and a key exchange
		// with an attacker-chosen field element.
		val forged = PairingCode.encode(crypto.digest, hexToByteArray(OFF_CURVE_X))
		responder.respond(forged, secret) shouldBe RespondResult.InvalidKey
		val aboveP = PairingCode.encode(crypto.digest, ByteArray(20) { 0xFF.toByte() })
		responder.respond(aboveP, secret) shouldBe RespondResult.InvalidKey
	}

	"the responder reports code problems distinctly".config(enabled = DEFAULT_ENABLED) {
		val code = initiator.begin(now).code
		val flat = code.replace("-", "")
		responder.respond("", secret).shouldBeInstanceOf<RespondResult.Malformed>()
		responder.respond(flat.dropLast(1), secret).shouldBeInstanceOf<RespondResult.Malformed>()
		responder.respond(flat.substring(0, 5) + "U" + flat.substring(6), secret).shouldBeInstanceOf<RespondResult.Malformed>()
		responder.respond("2" + flat.drop(1), secret) shouldBe RespondResult.UnknownVersion(2)
		val typo = flat.substring(0, 35) + CrockfordBase32.ALPHABET[(CrockfordBase32.symbolValue(flat[35]) + 1) % 32]
		responder.respond(typo, secret) shouldBe RespondResult.ChecksumFailed
		responder.respond(code.lowercase().replace("-", " "), secret).shouldBeInstanceOf<RespondResult.Responded>()
	}

	"key derivation and MAC match the independent reference for a fixed transcript".config(enabled = DEFAULT_ENABLED) {
		// Computed by secp160r1-pairing's tools/secp160r1-ref reference (Python hmac/hashlib) for ecdh vector 0. This is what
		// pins the transcript: dropping the version or either public key from it, or replacing length-prefixing
		// by plain concatenation, changes these values while leaving every round-trip test green.
		val xA = hexToByteArray(REF_XA)
		val xB = hexToByteArray(REF_XB)
		val shared = hexToByteArray(REF_SHARED)
		val keys = PairingEnvelope.deriveKeys(crypto, 1, xA, xB, shared)
		keys.authenticationKey.toHexString() shouldBe "2f0a5e23077774ed1254be12bdfd0a80caa6e2ad28e3c30fb2eccc5d38a98be8"
		val session = { role: PairingRole -> PairingSession(crypto, role, 1, xA, xB, keys.authenticationKey) }
		session(PairingRole.INITIATOR).authenticate(katPayload).toHexString() shouldBe
			"eba5b0ce7d7952e4dc1fe4785cbd5b74005f780c441444646427b113d441bfb2"
		session(PairingRole.RESPONDER).authenticate(katPayload).toHexString() shouldBe
			"dbeeaa2a3dcde3f741cb0f4cec71eb9cc48ba65c0f209928e00c6e0b54a0f754"
		keys.encryptionKey.toHexString() shouldBe "5e97889b95c9ee8d76d0f12b5dfb21d6ab1d1dfa585433fe6084d5f2eee4fe3e"
		keys.macKey.toHexString() shouldBe "832a2cd05aaa03215cbb4d254b5f2dac0616471718cd35ae113855739e84e8d8"
		val ivAndCiphertext = ByteArray(48) { it.toByte() }
		PairingEnvelope.mac(crypto, keys.macKey, 1, xB, ivAndCiphertext).toHexString() shouldBe
			"de763324b41e43cabe3c973afd773d570e1ff2771d2cc16a03e566c8deeb3a1b"
	}

	"the MAC is verified before any decryption is attempted".config(enabled = DEFAULT_ENABLED) {
		val recordingAes = RecordingAes(crypto.aes)
		val spyingCrypto = object : CryptoService by crypto {
			override val aes: AesService = recordingAes
		}
		val spiedInitiator = PairingInitiator(spyingCrypto, curve)
		val offer = spiedInitiator.begin(now)
		val envelope = envelopeFor(offer)
		val badMac = envelope.copyOf().also { it[it.lastIndex] = it[it.lastIndex] xor 1 }
		spiedInitiator.accept(offer, badMac, now + 1) shouldBe AcceptResult.MacFailed
		recordingAes.decryptCalls shouldBe 0
		spiedInitiator.accept(offer, envelope, now + 1).shouldBeInstanceOf<AcceptResult.Accepted>()
		recordingAes.decryptCalls shouldBe 1
	}

	"a real RSA public key is confirmed end to end".config(enabled = DEFAULT_ENABLED) {
		val offer = initiator.begin(now)
		val responded = responder.respond(offer.code, secret).shouldBeInstanceOf<RespondResult.Responded>()
		val accepted = initiator.accept(offer, responded.envelope, now + 1).shouldBeInstanceOf<AcceptResult.Accepted>()
		accepted.session.role shouldBe PairingRole.INITIATOR
		responded.session.role shouldBe PairingRole.RESPONDER

		// The motivating case: A hands B a 2048-bit RSA public key over the paired channel.
		val rsaKey = crypto.rsa.generateKeyPair(RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha256, RsaService.KeySize.Rsa2048)
		val spki = crypto.rsa.exportPublicKeySpki(rsaKey.public)
		val tag = accepted.session.authenticate(spki)
		tag.size shouldBe PairingSession.TAG_BYTES
		responded.session.verify(spki, tag) shouldBe true

		// And the reverse direction works too, for whatever B needs to send back.
		val fromResponder = responded.session.authenticate("hello".encodeToByteArray())
		accepted.session.verify("hello".encodeToByteArray(), fromResponder) shouldBe true
	}

	"a confirmation tag covers the payload exactly".config(enabled = DEFAULT_ENABLED) {
		val (a, b) = pairedSessions()
		val payload = crypto.strongRandom.randomBytes(294)
		val tag = a.authenticate(payload)
		b.verify(payload, tag) shouldBe true

		val flipped = payload.copyOf().also { it[100] = it[100] xor 1 }
		b.verify(flipped, tag) shouldBe false
		b.verify(payload.copyOf(293), tag) shouldBe false
		b.verify(payload + byteArrayOf(0), tag) shouldBe false
		b.verify(ByteArray(0), tag) shouldBe false
		b.verify(payload, tag.copyOf().also { it[31] = it[31] xor 1 }) shouldBe false
		b.verify(payload, tag.copyOf(31)) shouldBe false
		b.verify(payload, tag + byteArrayOf(0)) shouldBe false
		b.verify(payload, ByteArray(PairingSession.TAG_BYTES)) shouldBe false
	}

	"a tag cannot be reflected back at the side that produced it".config(enabled = DEFAULT_ENABLED) {
		val (a, b) = pairedSessions()
		val payload = "the payload".encodeToByteArray()
		a.verify(payload, a.authenticate(payload)) shouldBe false
		b.verify(payload, b.authenticate(payload)) shouldBe false
		a.authenticate(payload).toHexString() shouldNotBe b.authenticate(payload).toHexString()
	}

	"a tag from one pairing never verifies in another".config(enabled = DEFAULT_ENABLED) {
		val (a1, _) = pairedSessions()
		val (_, b2) = pairedSessions()
		val payload = "same payload, different pairing".encodeToByteArray()
		b2.verify(payload, a1.authenticate(payload)) shouldBe false
	}

	"the confirmation key is bound to the transcript, not just the shared secret".config(enabled = DEFAULT_ENABLED) {
		val xA = hexToByteArray(REF_XA)
		val xB = hexToByteArray(REF_XB)
		val shared = hexToByteArray(REF_SHARED)
		val base = PairingEnvelope.deriveKeys(crypto, 1, xA, xB, shared).authenticationKey.toHexString()
		PairingEnvelope.deriveKeys(crypto, 2, xA, xB, shared).authenticationKey.toHexString() shouldNotBe base
		PairingEnvelope.deriveKeys(crypto, 1, xB, xA, shared).authenticationKey.toHexString() shouldNotBe base
	}

	"the envelope keys did not move when the third key was added".config(enabled = DEFAULT_ENABLED) {
		// HKDF-Expand is prefix-stable, so key confirmation cost nothing on the wire. The vectors in the
		// known-answer test above were generated for a 64-byte output and still hold for 96.
		val keys = PairingEnvelope.deriveKeys(
			crypto, 1,
			hexToByteArray(REF_XA),
			hexToByteArray(REF_XB),
			hexToByteArray(REF_SHARED),
		)
		val shortOkm = HkdfSha256(crypto.digest).derive(
			ikm = hexToByteArray(REF_SHARED),
			salt = ByteArray(HkdfSha256.HASH_LENGTH),
			info = lengthPrefixed(
				"com.icure.pairing.v1.kdf".encodeToByteArray(),
				byteArrayOf(1),
				hexToByteArray(REF_XA),
				hexToByteArray(REF_XB),
			),
			length = 64,
		)
		(keys.encryptionKey + keys.macKey).toHexString() shouldBe shortOkm.toHexString()
	}

	"400 pairings produce 400 distinct codes with roughly uniform key symbols".config(enabled = DEFAULT_ENABLED) {
		val codes = (1..400).map { initiator.begin(now).code }
		codes.toSet().size shouldBe codes.size
		val counts = IntArray(32)
		codes.forEach { code ->
			code.replace("-", "").substring(1, 33).forEach { counts[CrockfordBase32.symbolValue(it)]++ }
		}
		val mean = codes.size * 32 / 32.0
		counts.forEachIndexed { symbol, count ->
			withClue("symbol ${CrockfordBase32.ALPHABET[symbol]} count $count") {
				count.toDouble() shouldBeGreaterThan 0.5 * mean
				count.toDouble() shouldBeLessThan 1.5 * mean
			}
		}
	}

	"an all-zero random draw is rejected rather than used as a key".config(enabled = DEFAULT_ENABLED) {
		val random = ZeroFirstRandom(crypto.strongRandom)
		val rigged = object : CryptoService by crypto {
			override val strongRandom: StrongRandom = random
		}
		val offer = PairingInitiator(rigged, PureKotlinSecp160r1Service(random)).begin(now)
		random.calls shouldBe 2
		offer.scalarOrNull()!!.any { it != 0.toByte() } shouldBe true
		acceptedSecret(offer, envelopeFor(offer)) shouldBe secret.toHexString()
	}
})
