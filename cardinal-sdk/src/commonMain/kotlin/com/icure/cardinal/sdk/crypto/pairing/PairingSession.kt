package com.icure.cardinal.sdk.crypto.pairing

import com.icure.kryptom.crypto.CryptoService
import com.icure.kryptom.crypto.HmacAlgorithm
import com.icure.pairing.utils.constantTimeEquals

/**
 * Which side of a pairing produced a message.
 *
 * The role goes into every authentication tag, so a tag one side produced cannot be reflected back and accepted by
 * that same side. This is the direction separation the protocol needs once the channel carries traffic both ways.
 */
enum class PairingRole {
	/** The side that displayed the code, "A". */
	INITIATOR,

	/** The side into which the code was typed, "B". */
	RESPONDER;

	internal val directionByte: Byte
		get() = when (this) {
			INITIATOR -> 0
			RESPONDER -> 1
		}

	internal val peer: PairingRole
		get() = when (this) {
			INITIATOR -> RESPONDER
			RESPONDER -> INITIATOR
		}
}

/**
 * What survives a completed pairing: the ability to authenticate messages to the other side, and to check theirs.
 *
 * ## What it is for
 *
 * The typed code establishes that whoever holds `dA` is the device the person was looking at. Only that device can
 * decrypt the responder's envelope, so after a successful pairing both sides hold a key that nobody else can derive.
 * [authenticate] and [verify] turn that into a usable guarantee for material too large to fit in 36 characters, an
 * RSA public key being the motivating case:
 *
 * ```
 * A: val tag = session.authenticate(rsaPublicKeySpki)      // send rsaPublicKeySpki and tag over the network
 * B: if (session.verify(rsaPublicKeySpki, tag)) { ... }    // the key belongs to the device that showed the code
 * ```
 *
 * A verifying tag means: this payload was sent by the party on the other end of *this* pairing, unmodified. The code
 * is thereby a fingerprint of the RSA key transitively, through the session, which is why the key never has to fit
 * in the code. Deriving the pairing scalar from the RSA key instead would publish that scalar and is forbidden; see
 * section 2.6 of `docs/PAIRING_PLAN.md` in secp160r1-pairing.
 *
 * ## What it is not
 *
 * - **Authentication only, no confidentiality.** The payload travels in the clear unless the caller encrypts it. That
 *   suits a public key. Anything secret needs its own encryption.
 * - **No replay protection within a session.** A tag stays valid for as long as the session object lives. If replay
 *   matters, put a counter or a nonce in the payload.
 * - **It does not repair the protocol's asymmetry.** The initiator still does not learn who the responder is; see the
 *   file header of `Pairing.kt`. The responder learns that the payload came from the device that displayed the code.
 *
 * A session is bound to one pairing: the version, both public keys and the derived key all enter every tag, so a tag
 * from one pairing never verifies in another.
 */
class PairingSession internal constructor(
	private val crypto: CryptoService,
	/** Which side this object belongs to. Tags this side produces carry it; [verify] expects the peer's. */
	val role: PairingRole,
	private val version: Int,
	private val initiatorPublicKeyX: ByteArray,
	private val responderPublicKeyX: ByteArray,
	private val authenticationKey: ByteArray,
) {
	companion object {
		/** Length of the tag [authenticate] returns. */
		const val TAG_BYTES = 32

		private val CONFIRMATION_LABEL = "com.icure.pairing.v1.keyconfirm".encodeToByteArray()
	}

	/**
	 * Produces the tag to send alongside [payload], proving to the other side that this pairing's peer sent it.
	 * @return a tag of [TAG_BYTES] bytes.
	 */
	suspend fun authenticate(payload: ByteArray): ByteArray = tagFor(role, payload)

	/**
	 * Checks a [tag] received from the other side against the [payload] it was supposed to cover.
	 *
	 * The comparison is constant-time, and a tag this side produced does not verify here: only the peer's direction is
	 * accepted. Treat [payload] as untrusted until this returns true.
	 */
	suspend fun verify(payload: ByteArray, tag: ByteArray): Boolean =
		constantTimeEquals(tagFor(role.peer, payload), tag)

	private suspend fun tagFor(sender: PairingRole, payload: ByteArray): ByteArray =
		crypto.hmac.sign(
			lengthPrefixed(
				CONFIRMATION_LABEL,
				byteArrayOf(sender.directionByte),
				byteArrayOf(version.toByte()),
				initiatorPublicKeyX,
				responderPublicKeyX,
				payload,
			),
			crypto.hmac.loadKey(HmacAlgorithm.HmacSha256, authenticationKey),
		)
}
