/*
 * Human-typed pairing codes: the cryptographic scheme
 * ===================================================
 *
 * Setting
 * -------
 * Two parties pair over an asymmetric pair of channels.
 *
 *   A -> B  is out-of-band, authentic and tiny: A renders a code on a screen and a person types it into B.
 *           There is no network path from A to B.
 *   B -> A  is a one-way network channel carrying arbitrary bytes.
 *
 * B must deliver a secret to A such that only A can read it, and the typed code must be safe to eavesdrop:
 * someone reading it off the screen or over a shoulder must gain nothing. The secret has no value after five
 * minutes; the whole design depends on that (see "Security level" below).
 *
 * Why the code carries a public key. The code must carry everything B needs, because there is no other path
 * from A to B: displaying a short fingerprint and sending the real key over the network is impossible here.
 * And it must be a public key rather than a one-time secret: a code that is itself the secret (a hash commitment
 * the verifier checks) is a bearer token, and anyone who reads it authenticates in A's place. A public key read
 * off the screen is worth nothing without A's private key.
 *
 * Sequence
 * --------
 *
 *   A (initiator, shows the code)                     B (responder, types the code)
 *   =============================                     =============================
 *
 *   dA <- random scalar
 *   xA =  x(dA * G)
 *   code = Crockford32(v | xA | checksum)
 *        |
 *        |  36 characters carried by a person, screen to keyboard.
 *        |  Authentic, one-way, tiny, safe to overhear.
 *        +-------------------------------------------->  normalise; check version, checksum
 *                                                        reject xA unless it is on the curve
 *                                                        dB <- random scalar;  xB = x(dB * G)
 *                                                        shared = x(dB * PA)
 *                                                        k_enc|k_mac|k_auth = HKDF(shared, T)
 *                                                        S <- the secret to deliver
 *                                                                                        |
 *        envelope, over the network, recordable by anyone                                |
 *   <-----------------------------------------------------------------------------------+
 *        v | xB | iv+ciphertext | mac
 *
 *   check the window; check the offer is unspent
 *   reject xB unless it is on the curve
 *   shared = x(dA * PB)
 *   k_enc|k_mac|k_auth = HKDF(shared, T)
 *   verify mac in constant time BEFORE decrypting
 *   S = AES-256-CBC-dec(k_enc, iv+ciphertext)
 *   wipe dA; this offer is now spent
 *        |
 *        |  pubRSA (2048 bits) | tag, over the network.
 *        |  Public key, so authenticated but not encrypted.
 *        +-------------------------------------------->  verify tag in constant time
 *                                                        pubRSA now belongs to the device
 *                                                        the person was looking at
 *
 *   T   = LP("com.icure.pairing.v1.kdf", v, xA, xB)
 *   tag = HMAC-SHA256(k_auth, LP("com.icure.pairing.v1.keyconfirm", A->B, v, xA, xB, pubRSA))
 *
 * Scheme
 * ------
 * Notation: G is the secp160r1 base point; x(P) is the 20-byte big-endian x-coordinate of a point P;
 * LP(f1, f2, ...) is the concatenation of the fields, each prefixed with its length as 4 bytes big-endian.
 *
 *   A:  dA <- random scalar in [1, n-1]                     (ephemeral: one pairing, wiped after use)
 *       xA = x(dA * G)
 *       code = Crockford32( version(5 bits) || xA(160 bits) || checksum(15 bits) )        36 symbols, no padding
 *       checksum = top 15 bits of SHA-256(LP("com.icure.pairing.v1.code", version, xA))
 *       display the code; remember dA, xA, notBefore = now, notAfter = now + 5 min
 *
 *   B:  parse the typed code: normalise, check the version, check the checksum (a typo costs no curve work)
 *       reject xA unless it is the x-coordinate of a point on the curve  (mandatory: it came from a keyboard)
 *       dB <- random scalar;  xB = x(dB * G)
 *       shared = x(dB * PA)   where PA is a point with x-coordinate xA (either root, see below)
 *       transcript = LP("com.icure.pairing.v1.kdf", version, xA, xB)
 *       k_enc || k_mac = HKDF-SHA256(ikm = shared, salt = 32 zero bytes, info = transcript, L = 64)
 *       ivAndCiphertext = AES-256-CBC-PKCS7(k_enc, secret), fresh random IV prepended
 *       mac = HMAC-SHA256(k_mac, version || xB || ivAndCiphertext)
 *       envelope = version(1) || xB(20) || ivAndCiphertext || mac(32)      -> sent to A
 *
 *   A:  check the validity window, and that no envelope has been accepted for this offer yet
 *       parse the envelope; reject xB unless it is on the curve
 *       shared = x(dA * PB);  derive k_enc, k_mac from the same transcript
 *       verify mac in constant time BEFORE decrypting; on failure return MacFailed and keep the offer usable
 *       on success wipe dA (an offer accepts exactly one envelope), decrypt, return the secret
 *
 *   A:  pubRSA is now sent over the channel the pairing established, with a tag binding it to this pairing:
 *       tag = HMAC-SHA256(k_auth, LP("com.icure.pairing.v1.keyconfirm", direction, version, xA, xB, pubRSA))
 *   B:  recompute the tag and compare in constant time; a match means the key came from the device that
 *       displayed the code. See PairingSession.
 *
 * Key confirmation, and why the code is not literally a hash of the RSA key
 * ------------------------------------------------------------------------
 * The 36 characters have no spare bits, so a 2048-bit key cannot travel in them, and it does not need to. Only the
 * holder of dA decrypts the envelope, so only A learns S; anything later authenticated under a key derived from S
 * therefore comes from A. The code fingerprints the session, and the session vouches for the key.
 *
 * The tempting shortcut is to make the code a literal fingerprint by setting dA = SHA-256(pubRSA), so that B can
 * recompute xA from the key. Do not: pubRSA is public, so anyone holding it recovers dA by hashing, reads xB from
 * the envelope and decrypts S, retroactively, for every pairing A has ever done. It also makes A display the same
 * code forever. The reasoning is written up in section 2.6 of docs/PAIRING_PLAN.md in secp160r1-pairing.
 *
 * Each tag carries the sender's direction, so a tag cannot be reflected back at the side that produced it.
 *
 * x-only keys. Only x-coordinates travel. The two points with x-coordinate x are P and -P, and
 * x(k * P) = x(k * (-P)), so both parties reach the same shared x whichever root they reconstruct; decoding picks
 * the even root deterministically so both sides see the same transcript. This is what makes the key exactly
 * 32 symbols.
 *
 * Transcript binding. Both public keys and the version go into the HKDF info, so keys derived in one pairing are
 * useless in another (cross-session) or under another format version (cross-version). Length-prefixing every
 * digest input is what keeps a label separating its fields: with plain concatenation ("ab", "c") and ("a", "bc")
 * would hash identically.
 *
 * Encrypt-then-MAC, MAC first. A accepts the first envelope whose MAC verifies, not the first that arrives, so
 * an attacker who cannot forge a MAC cannot burn the single-use slot by flooding A with garbage.
 *
 * Security level
 * --------------
 * secp160r1 gives about 80 bits: recovering dA from xA costs about 2^80 group operations (Pollard rho). At 100
 * bits (a 20-symbol code) it would be 2^50, reachable within five minutes with a few thousand GPUs; at 160 bits
 * it is about 2^80, some 4,000 times beyond the window even at an implausible 10^18 operations per second. This
 * is the asymmetry a hash-based code lacks: for a public key the security is half the typed bits, for a bearer
 * code it is linear in them, which is why 20 symbols were enough for the old scheme and hopeless for this one.
 *
 * 2^80 is a margin against a five-minute deadline and nothing longer; the displayed key is public and recordable
 * forever. Hence, non-negotiably:
 *   - keys are ephemeral, one pairing each, never reused;
 *   - nothing durable may be derived from the transported secret. If it ever becomes a device key or seeds a
 *     long-lived session, move to a 256-bit curve and a 56-symbol code before anything else.
 * At this level the discrete logarithm is not the practical risk; a carry bug or a timing leak in hand-written
 * field arithmetic is. That is why the curve layer in kryptom is branch-free and pinned to an independent
 * reference implementation.
 *
 * What this does not protect
 * --------------------------
 *   - B is not authenticated to A. Anyone can encrypt to a public key, so A cannot tell whether the envelope
 *     came from B or from someone who read the code off the screen. Only A's identity is established.
 *   - An observer who reads the screen and also controls the network can substitute their own envelope; A then
 *     accepts a secret chosen by the attacker. Not fixable within this channel topology.
 *   - The checksum detects typos (a random error passes with probability 2^-15); it is not a signature. A forged
 *     code with a recomputed checksum parses, which is why point validation is mandatory.
 *   - Constant-time behaviour is best effort on the JVM and on JS.
 *
 */
package com.icure.cardinal.sdk.crypto.pairing

import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesService
import com.icure.kryptom.crypto.CryptoService
import com.icure.kryptom.crypto.HmacAlgorithm
import com.icure.kryptom.crypto.defaultCryptoService
import com.icure.pairing.crypto.HkdfSha256
import com.icure.pairing.ec.PureKotlinSecp160r1Service
import com.icure.pairing.ec.Secp160r1Service
import com.icure.pairing.utils.constantTimeEquals

/**
 * Default validity window of a pairing offer: five minutes.
 *
 * The whole security argument for the 160-bit curve rests on the transported secret losing all value within this
 * window (see [PairingInitiator]). Do not raise it without revisiting the curve choice first.
 */
const val PAIRING_DEFAULT_TTL_MILLIS: Long = 5 * 60 * 1000

/**
 * The state of one pairing attempt on the initiator's side, created by [PairingInitiator.begin].
 *
 * Display [code] to the person; keep the offer until an envelope is accepted or the window closes, then discard it.
 * Exactly one envelope can ever be accepted: [PairingInitiator.accept] wipes the private key on success and every
 * later call returns [AcceptResult.AlreadyUsed]. Offers are single-use and must never be re-displayed.
 *
 * Not thread-safe: calls to [PairingInitiator.accept] for the same offer must not run concurrently.
 */
class PairingOffer internal constructor(
	/** The 36-symbol code to display, formatted as 9 dash-separated groups of 4. */
	val code: String,
	/** Envelopes are refused before this instant (epoch milliseconds). */
	val notBeforeEpochMs: Long,
	/** Envelopes are refused from this instant on (epoch milliseconds, exclusive). */
	val notAfterEpochMs: Long,
	internal val version: Int,
	internal val publicKeyX: ByteArray,
	scalar: ByteArray,
) {
	private var privateScalar: ByteArray? = scalar

	/** True once an envelope has been accepted. The private key is gone and no further envelope can be accepted. */
	val isUsed: Boolean get() = privateScalar == null

	internal fun scalarOrNull(): ByteArray? = privateScalar

	/** Wipes the private key. Called once, when an envelope with a valid MAC has been received. */
	internal fun consume() {
		privateScalar?.fill(0)
		privateScalar = null
	}
}

/** Outcome of [PairingInitiator.accept]. */
sealed interface AcceptResult {
	/**
	 * The envelope was authentic for this offer and [secret] is what the responder sent. The offer is now used.
	 * @param session use it to authenticate later messages to the responder, such as an RSA public key.
	 */
	class Accepted(val secret: ByteArray, val session: PairingSession) : AcceptResult

	/** The bytes are not an envelope at all (too short, ciphertext not block-aligned, ...). The offer stays usable. */
	data class Malformed(val reason: String) : AcceptResult

	/** The envelope's version byte does not match the offer's version. The offer stays usable. */
	data class UnknownVersion(val version: Int) : AcceptResult

	/** The responder's public key in the envelope is not a point on the curve. The offer stays usable. */
	data object InvalidKey : AcceptResult

	/** The MAC does not verify: tampered, garbled, or built for another offer. The offer stays usable. */
	data object MacFailed : AcceptResult

	/** `nowEpochMs` is at or after [PairingOffer.notAfterEpochMs]. */
	data object Expired : AcceptResult

	/** `nowEpochMs` is before [PairingOffer.notBeforeEpochMs]. */
	data object NotYetValid : AcceptResult

	/** An envelope has already been accepted for this offer. */
	data object AlreadyUsed : AcceptResult
}

/** Outcome of [PairingResponder.respond]. */
sealed interface RespondResult {
	/**
	 * [envelope] is the byte string to send to the initiator over the network channel.
	 * @param session use it to verify later messages from the initiator, such as an RSA public key.
	 */
	class Responded(val envelope: ByteArray, val session: PairingSession) : RespondResult

	/** The typed text is not a code: wrong length or a character outside the alphabet. */
	data class Malformed(val reason: String) : RespondResult

	/** The code is well-formed but its checksum does not match: almost certainly a typo. Ask the person to re-check. */
	data object ChecksumFailed : RespondResult

	/** The code's version symbol is not one this implementation understands. */
	data class UnknownVersion(val version: Int) : RespondResult

	/** The code passed its checksum but does not encode a point on the curve. It was not produced by [PairingInitiator]. */
	data object InvalidKey : RespondResult
}

/**
 * The party that displays the code and receives the secret: "A" in the scheme described at the top of this file.
 * Read that description before using this class. The two points that callers most often get wrong:
 *
 * - **B is not authenticated to A.** Anyone can encrypt to a public key, so A cannot tell whether the envelope
 *   came from B or from someone who read the code off the screen. If A needs to know who sent the secret, that is
 *   a separate mechanism.
 * - **The secret must not outlive five minutes**, and nothing durable may be derived from it. The curve's 80-bit
 *   security level is a margin against that deadline and nothing longer.
 *
 * Time is a parameter (`nowEpochMs`), never read from a clock inside this class: whether a device has a trusted
 * time source is the caller's knowledge, and it keeps the window testable.
 *
 * @param crypto the crypto service to use; the platform default unless testing.
 * @param curve the secp160r1 implementation; the pure-Kotlin one over [crypto]'s random unless testing.
 */
class PairingInitiator(
	private val crypto: CryptoService = defaultCryptoService,
	private val curve: Secp160r1Service = PureKotlinSecp160r1Service(crypto.strongRandom),
) {
	/**
	 * Starts a pairing: draws an ephemeral key pair and produces the code to display.
	 * @param nowEpochMs the current time, epoch milliseconds; start of the validity window.
	 * @param ttlMillis length of the validity window, [PAIRING_DEFAULT_TTL_MILLIS] by default. See the class
	 * documentation before raising it.
	 */
	suspend fun begin(nowEpochMs: Long, ttlMillis: Long = PAIRING_DEFAULT_TTL_MILLIS): PairingOffer {
		require(ttlMillis > 0) { "ttlMillis must be positive, got $ttlMillis" }
		val scalar = curve.randomScalar()
		val publicKeyX = curve.publicKeyX(scalar)
		return PairingOffer(
			code = PairingCode.encode(crypto.digest, publicKeyX, PairingCode.VERSION_1),
			notBeforeEpochMs = nowEpochMs,
			notAfterEpochMs = nowEpochMs + ttlMillis,
			version = PairingCode.VERSION_1,
			publicKeyX = publicKeyX,
			scalar = scalar,
		)
	}

	/**
	 * Processes an envelope received over the network for [offer].
	 *
	 * The first envelope whose MAC verifies is accepted and consumes the offer; envelopes that fail any check leave
	 * the offer usable, so an attacker who cannot forge a MAC cannot deny the pairing by flooding A with garbage.
	 * The MAC is verified, in constant time, before any decryption is attempted.
	 *
	 * @param offer the offer whose code the responder typed.
	 * @param envelope the bytes received from the network.
	 * @param nowEpochMs the current time, epoch milliseconds, checked against the offer's window.
	 */
	suspend fun accept(offer: PairingOffer, envelope: ByteArray, nowEpochMs: Long): AcceptResult {
		if (nowEpochMs < offer.notBeforeEpochMs) return AcceptResult.NotYetValid
		if (nowEpochMs >= offer.notAfterEpochMs) return AcceptResult.Expired
		val scalar = offer.scalarOrNull() ?: return AcceptResult.AlreadyUsed

		if (envelope.size < PairingEnvelope.MIN_LENGTH) {
			return AcceptResult.Malformed("Envelope too short: ${envelope.size} bytes, at least ${PairingEnvelope.MIN_LENGTH} expected")
		}
		val version = envelope[0].toInt() and 0xFF
		if (version != offer.version) return AcceptResult.UnknownVersion(version)
		val keyEnd = PairingEnvelope.VERSION_BYTES + Secp160r1Service.PUBLIC_KEY_BYTES
		val macStart = envelope.size - PairingEnvelope.MAC_BYTES
		val responderPublicKeyX = envelope.copyOfRange(PairingEnvelope.VERSION_BYTES, keyEnd)
		val ivAndCiphertext = envelope.copyOfRange(keyEnd, macStart)
		val mac = envelope.copyOfRange(macStart, envelope.size)
		if ((ivAndCiphertext.size - AesService.IV_BYTE_LENGTH) % PairingEnvelope.AES_BLOCK_BYTES != 0) {
			return AcceptResult.Malformed("Ciphertext length is not a whole number of blocks")
		}

		val shared = curve.ecdhX(scalar, responderPublicKeyX) ?: return AcceptResult.InvalidKey
		val keys = PairingEnvelope.deriveKeys(crypto, offer.version, offer.publicKeyX, responderPublicKeyX, shared)
		val expectedMac = PairingEnvelope.mac(crypto, keys.macKey, offer.version, responderPublicKeyX, ivAndCiphertext)
		if (!constantTimeEquals(expectedMac, mac)) return AcceptResult.MacFailed

		// The MAC verified, so this is the one envelope this offer accepts, whatever decryption yields.
		offer.consume()
		val secret = try {
			crypto.aes.decrypt(ivAndCiphertext, crypto.aes.loadKey(AesAlgorithm.CbcWithPkcs7Padding, keys.encryptionKey))
		} catch (e: Exception) {
			return AcceptResult.Malformed("MAC verified but decryption failed: ${e.message}")
		}
		return AcceptResult.Accepted(
			secret = secret,
			session = PairingSession(
				crypto = crypto,
				role = PairingRole.INITIATOR,
				version = offer.version,
				initiatorPublicKeyX = offer.publicKeyX,
				responderPublicKeyX = responderPublicKeyX,
				authenticationKey = keys.authenticationKey,
			),
		)
	}
}

/**
 * The party that types the code and sends the secret: "B" in the scheme described at the top of this file. Read
 * that description first: in particular, this party is **not** authenticated to the initiator.
 *
 * @param crypto the crypto service to use; the platform default unless testing.
 * @param curve the secp160r1 implementation; the pure-Kotlin one over [crypto]'s random unless testing.
 */
class PairingResponder(
	private val crypto: CryptoService = defaultCryptoService,
	private val curve: Secp160r1Service = PureKotlinSecp160r1Service(crypto.strongRandom),
) {
	/**
	 * Builds the envelope carrying [secret] for the initiator whose code the person typed.
	 *
	 * The checksum is verified before any curve work, so a typo is reported as [RespondResult.ChecksumFailed] without
	 * cost; the initiator's key is then validated against the curve before this party's ephemeral key is drawn.
	 *
	 * @param typedCode the code as typed, case and grouping optional.
	 * @param secret the bytes to deliver; they must lose all value within the initiator's validity window.
	 */
	suspend fun respond(typedCode: String, secret: ByteArray): RespondResult {
		val parsed = when (val result = PairingCode.decode(crypto.digest, typedCode)) {
			is PairingCodeParseResult.Parsed -> result
			is PairingCodeParseResult.Malformed -> return RespondResult.Malformed(result.reason)
			PairingCodeParseResult.ChecksumFailed -> return RespondResult.ChecksumFailed
			is PairingCodeParseResult.UnknownVersion -> return RespondResult.UnknownVersion(result.version)
		}
		val initiatorPublicKeyX = parsed.publicKeyX
		if (!curve.isValidPublicKeyX(initiatorPublicKeyX)) return RespondResult.InvalidKey

		val scalar = curve.randomScalar()
		val publicKeyX = curve.publicKeyX(scalar)
		val shared = curve.ecdhX(scalar, initiatorPublicKeyX) ?: return RespondResult.InvalidKey
		scalar.fill(0)

		val keys = PairingEnvelope.deriveKeys(crypto, parsed.version, initiatorPublicKeyX, publicKeyX, shared)
		val ivAndCiphertext = crypto.aes.encrypt(
			secret,
			crypto.aes.loadKey(AesAlgorithm.CbcWithPkcs7Padding, keys.encryptionKey),
		)
		val mac = PairingEnvelope.mac(crypto, keys.macKey, parsed.version, publicKeyX, ivAndCiphertext)
		return RespondResult.Responded(
			envelope = byteArrayOf(parsed.version.toByte()) + publicKeyX + ivAndCiphertext + mac,
			session = PairingSession(
				crypto = crypto,
				role = PairingRole.RESPONDER,
				version = parsed.version,
				initiatorPublicKeyX = initiatorPublicKeyX,
				responderPublicKeyX = publicKeyX,
				authenticationKey = keys.authenticationKey,
			),
		)
	}
}

/**
 * Envelope layout and key derivation shared by both sides; the "Scheme" section of the file header is the
 * specification.
 *
 * ```
 * envelope   = versionByte(1) || xB(20) || ivAndCiphertext || mac(32)
 * transcript = LP("com.icure.pairing.v1.kdf", versionByte, xA, xB)
 * OKM        = HKDF-SHA256(ikm = sharedX, salt = 32 zero bytes, info = transcript, L = 96)
 * k_enc      = OKM[0..31]   (AES-256-CBC)
 * k_mac      = OKM[32..63]  (HMAC-SHA256, envelope)
 * k_auth     = OKM[64..95]  (HMAC-SHA256, key confirmation; see [PairingSession])
 * mac        = HMAC-SHA256(k_mac, versionByte || xB || ivAndCiphertext)
 * ```
 *
 * `ivAndCiphertext` is exactly what [AesService.encrypt] returns. Do not reduce the transcript to the shared secret
 * alone: the known-answer test in `PairingProtocolTest` pins it.
 */
internal object PairingEnvelope {
	const val VERSION_BYTES = 1
	const val MAC_BYTES = 32
	const val AES_BLOCK_BYTES = 16
	const val ENCRYPTION_KEY_BYTES = 32
	const val MAC_KEY_BYTES = 32
	const val AUTH_KEY_BYTES = 32

	/** Version, responder key, IV plus at least one ciphertext block, MAC. */
	const val MIN_LENGTH = VERSION_BYTES + Secp160r1Service.PUBLIC_KEY_BYTES + AesService.IV_BYTE_LENGTH + AES_BLOCK_BYTES + MAC_BYTES

	private val KDF_LABEL = "com.icure.pairing.v1.kdf".encodeToByteArray()

	class Keys(val encryptionKey: ByteArray, val macKey: ByteArray, val authenticationKey: ByteArray)

	suspend fun deriveKeys(
		crypto: CryptoService,
		version: Int,
		initiatorPublicKeyX: ByteArray,
		responderPublicKeyX: ByteArray,
		sharedX: ByteArray,
	): Keys {
		val transcript = lengthPrefixed(KDF_LABEL, byteArrayOf(version.toByte()), initiatorPublicKeyX, responderPublicKeyX)
		val okm = HkdfSha256(crypto.digest).derive(
			ikm = sharedX,
			salt = ByteArray(HkdfSha256.HASH_LENGTH),
			info = transcript,
			// HKDF-Expand is prefix-stable, so lengthening the output left k_enc and k_mac, and therefore the
			// envelope on the wire, exactly as they were before key confirmation existed.
			length = ENCRYPTION_KEY_BYTES + MAC_KEY_BYTES + AUTH_KEY_BYTES,
		)
		return Keys(
			encryptionKey = okm.copyOfRange(0, ENCRYPTION_KEY_BYTES),
			macKey = okm.copyOfRange(ENCRYPTION_KEY_BYTES, ENCRYPTION_KEY_BYTES + MAC_KEY_BYTES),
			authenticationKey = okm.copyOfRange(ENCRYPTION_KEY_BYTES + MAC_KEY_BYTES, okm.size),
		)
	}

	suspend fun mac(
		crypto: CryptoService,
		macKey: ByteArray,
		version: Int,
		responderPublicKeyX: ByteArray,
		ivAndCiphertext: ByteArray,
	): ByteArray {
		val key = crypto.hmac.loadKey(HmacAlgorithm.HmacSha256, macKey)
		return crypto.hmac.sign(byteArrayOf(version.toByte()) + responderPublicKeyX + ivAndCiphertext, key)
	}
}
