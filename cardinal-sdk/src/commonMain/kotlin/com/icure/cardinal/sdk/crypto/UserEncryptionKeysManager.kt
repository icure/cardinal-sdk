package com.icure.cardinal.sdk.crypto

import com.icure.cardinal.sdk.crypto.entities.CachedKeypairDetails
import com.icure.cardinal.sdk.crypto.entities.CardinalKeyInfo
import com.icure.cardinal.sdk.crypto.entities.RsaDecryptionKeysSet
import com.icure.cardinal.sdk.model.CryptoActorStub
import com.icure.cardinal.sdk.model.base.DataOwnerHierarchyInfo
import com.icure.cardinal.sdk.model.specializations.KeypairFingerprintV2String
import com.icure.cardinal.sdk.model.specializations.SpkiHexString
import com.icure.kryptom.crypto.RsaAlgorithm
import com.icure.kryptom.crypto.RsaKeypair
import com.icure.utils.InternalIcureApi

/**
 * Allows to manage public and private keys for the current user and his parent hierarchy.
 */
@InternalIcureApi
interface UserEncryptionKeysManager {
	interface Factory {
		/**
		 * Details of a newly initialized encryption keys manager.
		 */
		@ConsistentCopyVisibility
		data class InitialisationDetails internal constructor(
			/**
			 * The newly created keys manager.
			 */
			val manager: UserEncryptionKeysManager,
			/**
			 * If the initialisation required a new key to be created, the newly created key, else undefined.
			 */
			val newKey: CardinalKeyInfo<RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha256>>?
		)

		/**
		 * Initializes a new manager, containing all keys for the current data owner.
		 */
		suspend fun initialize(): InitialisationDetails
	}

	/**
	 * Get all key pairs available to this sdk instance, keyed by data owner id.
	 * This normally will include:
	 * - The delegator actor key
	 * - Keys of the delegator actor parents if the SDK was initialized using hierarchical keys mode
	 * No guarantee on the order.
	 */
	fun getAvailableKeyPairs(): Map<String, List<CachedKeypairDetails>>

	/**
	 * Get a key pair with the provided fingerprint if present.
	 * @param fingerprint a key-pair/public-key fingerprint
	 * @return the pair associated to the fingerprint and a boolean indicating if the pair is verified, if present, else undefined
	 */
	fun getKeyPairForFingerprint(fingerprint: KeypairFingerprintV2String): CachedKeypairDetails?

	/**
	 * Get the data owner to use as delegator in this SDK instance when:
	 * - creating exchange data, or
	 * - creating security metadata
	 * This is normally the data owner associated to the current user of the SDK instance
	 */
	fun delegatorActorId(): String

	/**
	 * Get the hierarchy of data owners that can participate in the encryption / decryption of data, starting from the
	 * delegator data owner or its parent in [from].
	 * This hierarchy is restricted to only parent-type links
	 * @param from the id of a member of the current data owner hierarchy.
	 * @return an array starting at the topmost parent and ending at the provided parent id.
	 * @throws IllegalArgumentException If the provided id is not part of the hierarchy
	 */
	fun delegatorActorParentHierarchy(from: String? = null): DataOwnerHierarchyInfo

	/**
	 * Get full hierarchy of a data owner, including simple-type groups.
	 * If the SDK is not initialized in hierarchical mode parent-type links (and transitive links reachable only
	 * when passing through parent-type links) are ignored
	 */
	fun delegatorActorFullHierarchy(): DataOwnerHierarchyInfo

	/**
	 * If the data owner from [delegatorActorId] is an anonymous data owner, according to the crypto strategies
	 * configured for this SDK instance.
	 */
	fun delegatorActorIsAnonymous(): Boolean

	/**
	 * Get the verified key pairs of the data owner from [delegatorActorId].
	 * The returned keys can be safely used for encryption.
	 * The returned keys include all key pairs created on the current device and all recovered key pairs which have been
	 * verified through the crypto strategies.
	 * Guaranteed to be non-empty unless the SDK is in keyless mode, in which case the returned set will be empty.
	 */
	fun delegatorActorVerifiedKeys(): Set<CardinalKeyInfo<RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm>>>

	/**
	 * Get the verified keys / keys safe for encryption of a data owner if he is part of the current data owner hierarchy.
	 * Returns null if the data owner is not part of the current data owner hierarchy, else returns his verified keys available to this instance of the SDK (maybe be empty in some initialization settings).
	 */
	fun getVerifiedEncryptionKeysForDataOwnerIfInCurrentHierarchy(dataOwnerId: String): Set<CardinalKeyInfo<RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm>>>?

	/**
	 * Get all verified keys for a member of the current data owner hierarchy in no particular order.
	 * @param dataOwner the current data owner or a member of his hierarchy.
	 * @throws IllegalArgumentException if the provided data owner is not part of the current data owner hierarchy
	 */
	fun getVerifiedPublicKeysFor(dataOwner: CryptoActorStub): Set<SpkiHexString>

	/**
	 * Get all available decryption keys, for the current data owner and its parent.
	 * These keys should be used only for decryption as they may have not been verified.
	 */
	fun getAllDecryptionKeys(): RsaDecryptionKeysSet

	/**
	 * Get the decryption keys for a data owner if he is part of the current data owner hierarchy.
	 * Returns null if the data owner is not part of the current data owner hierarchy, else returns his decryption keys available to this instance of the SDK (maybe be empty in some initialization settings).
	 */
	fun getDecryptionKeysForDataOwnerIfInCurrentHierarchy(dataOwnerId: String): RsaDecryptionKeysSet?

	/**
	 * Forces to reload keys for the current data owner. This could be useful if the data owner has logged in from another device in order to
	 * update the transfer keys.
	 * Concurrent calls to this method are not allowed, however, it is possible (although discouraged) to continue using the previously
	 * cached keys through the other methods while this method is running.
	 * This method will complete only after keys have been reloaded successfully.
	 * @throws IllegalStateException if there are concurrent reloading requests.
	 */
	suspend fun reloadKeys()
}
