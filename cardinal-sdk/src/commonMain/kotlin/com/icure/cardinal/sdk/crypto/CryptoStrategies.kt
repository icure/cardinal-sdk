package com.icure.cardinal.sdk.crypto

import com.icure.cardinal.sdk.CardinalApis
import com.icure.cardinal.sdk.model.CryptoActorStubWithType
import com.icure.cardinal.sdk.model.DataOwnerType
import com.icure.cardinal.sdk.model.DataOwnerWithType
import com.icure.cardinal.sdk.model.specializations.KeypairFingerprintV1String
import com.icure.cardinal.sdk.model.specializations.SpkiHexString
import com.icure.cardinal.sdk.serialization.RsaEncryptionAlgorithmAsIdentifierSerializer
import com.icure.kryptom.crypto.CryptoService
import com.icure.kryptom.crypto.RsaAlgorithm.RsaEncryptionAlgorithm
import com.icure.kryptom.crypto.RsaKeypair
import kotlinx.serialization.Serializable

/**
 * Allows customising the behavior of the crypto api to set keys management, keys recovery, keys trusting in a way that
 * better suits your needs.
 */
interface CryptoStrategies {
	/**
	 * A request to recover key data that was not found for a user.
	 */
	@Serializable
	data class KeyDataRecoveryRequest(
		/**
		 * The data owner for which the key data should be recovered.
		 */
		val dataOwnerDetails: DataOwnerWithType,
		/**
		 * All public keys (in hex-encoded spki format) of `dataOwner` for which the authenticity status (verified or unverified) is
		 * unknown (the key if missing from the storage or it has been recovered but its verification status cannot be asserted).
		 * This could include keys that were recovered automatically by the sdk and may have overlap with `unavailableKeys`.
		 */
		val unknownKeys: List<SpkiHexString>,
		/**
		 * All public keys (in hex-encoded spki format) of `dataOwner` for which the sdk could not recover a private key. May overlap
		 * (partially or completely) with `unknownKeys`.
		 */
		val unavailableKeys: List<UnavailableKeyInfo>
	)

	@Serializable
	data class UnavailableKeyInfo(
		/**
		 * The public key
		 */
		val publicKey: SpkiHexString,
		/**
		 * The algorithm of the keypair
		 */
		@Serializable(with = RsaEncryptionAlgorithmAsIdentifierSerializer::class)
		val keyAlgorithm: RsaEncryptionAlgorithm
	)

	/**
	 * Data recovered for a data owner.
	 */
	data class RecoveredKeyData(
		/**
		 * All keys recovered for the data owner, by fingerprint.
		 * Recovered keys are by default considered as verified, unless explicitly marked as unverified in
		 * `keyAuthenticity`.
		 */
		val recoveredKeys: Map<KeypairFingerprintV1String, RsaKeypair<RsaEncryptionAlgorithm>>,
		/**
		 * associates each public key fingerprint its authenticity. Note that if any of the keys from `unknownKeys` is
		 * completely missing from this object the key will be considered as unverified in this api instance (same as
		 * if associated to false), but this value won't be cached (will be again part of `unknownKeys` in future
		 * instances.
		 */
		val keyAuthenticity: Map<KeypairFingerprintV1String, Boolean>
	)

	/**
	 * Specifies how the SDK should behave when a new key pair is required for a data owner.
	 */
	sealed interface KeyGenerationRequestResult {
		/**
		 * Allows the SDK to generate a new key pair for the current data owner.
		 */
		data object Allow : KeyGenerationRequestResult

		/**
		 * The SDK must not generate a new key for the data owner. The SDK initialisation should fail with a predefined
		 * error.
		 */
		data object Deny : KeyGenerationRequestResult

		/**
		 * The SDK must not generate a new key for the data owner.
		 * The SDK initialisation will continue, but the initialised SDK will run in keyless mode.
		 * In keyless mode, exchange data has to be created explicitly before data can be shared.
		 */
		data object Keyless : KeyGenerationRequestResult

		/**
		 * The SDK must not generate a new key for the data owner.
		 * Instead, whenever a delegator is needed for an action (creating new encrypted data, or sharing existing data)
		 * the SDK will use the (direct) parent data owner and its key as delegator.
		 * This option is only available if the data owner has a parent and the SDK was initialized using hierarchical
		 * data owners.
		 * Note that this will not have an effect on the author/responsible fields of created data, the only observable
		 * effect is on the created exchange data and delegations.
		 */
		//TODO if the current data owner has some keys but not verified they will be ignored during decryption -> in
		// parent delegator mode all encryption AND decryption is done as if the user is the parent
		data object ParentDelegator : KeyGenerationRequestResult

		/**
		 * The SDK should use the provided key pair as a new key for the data owner.
		 */
		data class Use(val keyPair: RsaKeypair<RsaEncryptionAlgorithm.OaepWithSha256>) : KeyGenerationRequestResult
	}

	/**
	 * The Cardinal SDK has an internal mechanism to automatically store and load private keys using the [com.icure.cardinal.sdk.storage.StorageFacade] you have provided.
	 *
	 * Under certain circumstances, some keys of the users might be missing (for example when the user is trying to access the data from a new device or browser) or
	 * might be forged (for example if it has been created by an attacker that gained temporary access to the database).
	 *
	 * In this case, the SDK will call recoverAndVerifySelfHierarchyKeys during the initialisation process.
	 *
	 * recoverAndVerifySelfHierarchyKeys provides you with the keys that are missing from the point of view of the SDK
	 *
	 * # Basic operation: Key recovery
	 *
	 *
	 * The recovered keys will automatically be cached using the current SDK {@link KeyStorageFacade} and {@link StorageFacade}
	 *
	 * The input is a list containing an object for each data owner part of the current data owner hierarchy. The objects are ordered from the data
	 * for the topmost parent of the current data owner hierarchy (first element) to the data for the current data owner (last element).
	 *
	 * The returned value must be an object associating to each data owner id an object with:
	 * - `recoveredKeys`:
	 * - `keyAuthenticity`: an object
	 * @param keysData all information on unknown and unavailable keys for each data owner part of the current data owner hierarchy.
	 * @param cryptoPrimitives cryptographic primitives you can use to support the process.
	 * @param keyPairRecoverer a key pair recoverer you can use to support the process
	 * @return a map that associates to each given data owner id the recovered data.
	 */
	suspend fun recoverAndVerifySelfHierarchyKeys(
		keysData: List<KeyDataRecoveryRequest>,
		cryptoPrimitives: CryptoService,
		keyPairRecoverer: KeyPairRecoverer
	): Map<String, RecoveredKeyData> =
		keysData.associate { it.dataOwnerDetails.dataOwner.id to RecoveredKeyData(emptyMap(), emptyMap()) }

	/**
	 * The correct initialisation of the crypto API requires that at least 1 verified (or device) key pair is available for each data owner part of the
	 * current data owner hierarchy. If no verified key is available for any of the data owner parents the api initialisation will automatically fail,
	 * however if there is no verified key for the current data owner you can instead create a new crypto key.
	 * @param self the current data owner.
	 * @param cryptoPrimitives cryptographic primitives you can use to support the process.
	 * @return an instance of [KeyGenerationRequestResult] specifying how the SDK should behave.
	 * @throws Exception you can throw any exception, and it will simply propagate to the api initialisation method.
	 */
	suspend fun generateNewKeyForDataOwner(
		self: DataOwnerWithType,
		cryptoPrimitives: CryptoService
	): KeyGenerationRequestResult =
		KeyGenerationRequestResult.Allow

	/**
	 * Verifies if the public keys of a data owner which will be the delegate of a new exchange key do actually belong to the person the data owner
	 * represents. This method is not called when the delegate would be the current data owner for the api.
	 *
	 * The user will have to obtain the verified public keys of the delegate from outside iCure, for example by email with another hcp, by checking the
	 * personal website of the other user, or by scanning verification qr codes at the doctor office...
	 *
	 * As long as one of the public keys is verified the creation of a new exchange key will succeed. If no public key is verified the operation will
	 * fail.
	 * @param delegate the potential data owner delegate.
	 * @param publicKeys public keys requiring verification, in spki hex-encoded format.
	 * @param cryptoPrimitives cryptographic primitives you can use to support the process.
	 * @param groupId the id of the data owner's group, or null if the data owner is in the same group as the current user
	 * @return all verified public keys, in spki hex-encoded format.
	 */
	suspend fun verifyDelegatePublicKeys(
		delegate: CryptoActorStubWithType,
		publicKeys: List<SpkiHexString>,
		cryptoPrimitives: CryptoService,
		groupId: String?
	): List<SpkiHexString> =
		publicKeys

	/**
	 * Specifies if a data owner requires anonymous delegations, i.e. his id should not appear unencrypted in new secure delegations. This should always
	 * be the case for patient data owners.
	 * @param dataOwner a data owner.
	 * @param groupId the id of the data owner's group, or null if the data owner is in the same group as the current user
	 * @return true if the delegations for the provided data owner should be anonymous.
	 */
	suspend fun dataOwnerRequiresAnonymousDelegation(dataOwner: CryptoActorStubWithType, groupId: String?): Boolean =
		dataOwner.type != DataOwnerType.Hcp

	/**
	 * Notifies that a new key for the current data owner was created.
	 * This method is called after the initialization of the other SDK apis.
	 * @param apis the initialized cardinal apis.
	 * @param key the newly created key.
	 * @param cryptoPrimitives cryptographic primitives you can use to support the process.
	 */
	suspend fun notifyNewKeyCreated(
		apis: CardinalApis,
		key: RsaKeypair<RsaEncryptionAlgorithm.OaepWithSha256>,
		cryptoPrimitives: CryptoService,
	) {}
}
