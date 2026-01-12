package com.icure.cardinal.sdk.api

import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.cardinal.sdk.crypto.entities.ExchangeDataInjectionDetails
import com.icure.cardinal.sdk.crypto.entities.RawDecryptedExchangeData
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.model.specializations.KeypairFingerprintV1String
import com.icure.cardinal.sdk.model.specializations.Pkcs8Bytes
import com.icure.cardinal.sdk.utils.DefaultValue
import com.icure.kryptom.crypto.RsaAlgorithm


/**
 * Gives access to cryptographic operations that should be managed by the user, such as the creation of recovery data for keys.
 */
interface CryptoApi {
	val shamirKeysManager: ShamirKeysManagerApi
	val inGroup: CryptoInGroupApi

	/**
	 * @param entityType the type of entity to get access control keys for.
	 * @return a List containing all the access control keys for an entity type in the current group. This method returns a non-empty list
	 * only if the current data owner is not anonymous
	 */
	suspend fun getAccessControlKeys(entityType: EntityWithEncryptionMetadataTypeName): List<String>

	/**
	 * Clears the cache of the api and reloads the user keys and exchange keys.
	 * In some cases this method could allow users to retrieve and decrypt data that was shared with them after the api
	 * instantiation or last reload.
	 */
	suspend fun forceReload()

	/**
	 * Get the available keys for the current data and his parents (if using hierarchical data owners).
	 * The result is a map associating the current data owner or parent id to a map containing all the available keys
	 * for that data owner.
	 * The keys map associates the key fingerprint to the pkcs8 bytes of the private key.
	 * @param filterTrustedKeys if true (default) only keys fully trusted by this instance of the sdk will be returned.
	 * Otherwise, also unverified keys may be returned.
	 * @return the available keys
	 */
	suspend fun currentDataOwnerKeys(
		@DefaultValue("true")
		filterTrustedKeys: Boolean = true
	): Map<String, Map<KeypairFingerprintV1String, Pkcs8Bytes>>

	suspend fun keylessCreateExchangeDataTo(
		delegate: String
	): RawDecryptedExchangeData

	/**
	 * Allows injecting exchange data that would not be readable or decryptable by the SDK otherwise.
	 * IMPORTANT: the SDK will not check that the provided exchange data details are valid for the provided exchange data
	 * id. Providing invalid details could cause permanent corruption of data.
	 * @param details the details of the exchange data to inject. Set verified to true to allow this data to be used for
	 * encryption of new entity.
	 * @param reEncryptWithOwnKeys can only be true if the api wasn't initialized in keyless mode. If true the injected
	 * data will be re-encrypted with also the current data owner key, allowing to access it in future instances without
	 * having to re-inject it (as long as the instance has access to the current private key).
	 */
	suspend fun injectExchangeData(
		groupId: String?,
		details: List<ExchangeDataInjectionDetails>,
		reEncryptWithOwnKeys: Boolean
	)
}

interface CryptoInGroupApi {
	suspend fun keylessCreateExchangeDataTo(
		groupId: String?,
		delegate: EntityReferenceInGroup
	): RawDecryptedExchangeData

	/**
	 * @param groupId the id of the group where the access control keys will be used.
	 * @param entityType the type of entity to get access control keys for.
	 * @return a List containing all the access control keys for an entity type in a specific group. This method returns a non-empty list
	 * only if the current data owner is not anonymous
	 */
	suspend fun getAccessControlKeys(groupId: String?, entityType: EntityWithEncryptionMetadataTypeName): List<String>
}
