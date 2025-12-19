package com.icure.cardinal.sdk.crypto

import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.cardinal.sdk.crypto.entities.ExchangeDataInjectionDetails
import com.icure.cardinal.sdk.crypto.entities.ExchangeDataWithPotentiallyDecryptedContent
import com.icure.cardinal.sdk.crypto.entities.ExchangeDataWithUnencryptedContent
import com.icure.cardinal.sdk.model.specializations.Base64String
import com.icure.cardinal.sdk.model.specializations.SecureDelegationKeyString
import com.icure.cardinal.sdk.model.specializations.SpkiHexString
import com.icure.utils.InternalIcureApi

/**
 * Exchange data manager which automatically handles decryption and cache
 */
@InternalIcureApi
interface ExchangeDataManager {
	val base: BaseExchangeDataManager

	/**
	 * Updates all exchange data between the current data owner and another data owner to allow the other data owner to access existing exchange data
	 * using a new public key.
	 * TODO currently supports only give access back to users in the same group
	 * TODO no support for delegator actor different from current data owner
	 * @param otherDataOwner the other data owner.
	 * @param newDataOwnerPublicKey a new public key of the other data owner. The key MUST BE VERIFIED.
	 */
	suspend fun giveAccessBackTo(otherDataOwner: String, newDataOwnerPublicKey: SpkiHexString)

	/**
	 * Gets any existing and verified exchange data from the current data owner to the provided delegate or creates new data if no verified data is
	 * available, then caches it.
	 * Data retrieved from this method is safe for encryption.
	 *
	 * @param delegateReference the id of the delegate.
	 * @param allowCreationWithoutDelegateKey if true, when creating new exchange data, even if no verified key is available for the delegate the method
	 * will create the new exchange data anyway (will not be usable by the delegate without additional steps).
	 * @return the access control secret and key of the data to use for encryption.
	 */
	suspend fun getOrCreateEncryptionDataTo(
		groupId: String?,
		delegateReference: EntityReferenceInGroup,
		allowCreationWithoutDelegateKey: Boolean,
		allowCreationWithoutDelegatorKey: Boolean,
	): ExchangeDataWithUnencryptedContent


	/**
	 * Retrieve the cached decrypted exchange data key associated with any of the provided hashes/entry keys of secure delegations.
	 * Note: data retrieved from this method may be NOT SAFE FOR ENCRYPTION.
	 * @param hashes hashes of access control secrets for a specific entity, as they appear in the key of secure delegation entries
	 * @return the exchange data and decrypted key associated to that hash if cached
	 */
	suspend fun getCachedDecryptionDataKeyByAccessControlHash(
		groupId: String?,
		hashes: Set<SecureDelegationKeyString>,
	): Map<SecureDelegationKeyString, ExchangeDataWithUnencryptedContent>

	/**
	 * Retrieves the exchange data with the provided id (from the cache if available or from the server otherwise if
	 * allowed by [retrieveIfNotCached]) and attempts to decrypt it, then caches the result.
	 * @param groupId the id of the group where the exchange data is stored.
	 * @param ids ids of the exchange datas to retrieve
	 * @param waitOrRetrieveUncached if false only data that has already been retrieved will be returned: it will not
	 * try to get any uncached exchange data, and it will not wait for existing but incomplete retrieve jobs to
	 * complete.
	 * @return a map containing the exchange data id associated with:
	 * - exchangeData: the exchange data with the provided id
	 * - exchangeKey: the exchange key corresponding to the provided exchange data if it could be decrypted, else undefined
	 * - accessControlSecret: the access control secret corresponding to the provided exchange data if it could be decrypted, else undefined
	 */
	suspend fun getDecryptionDataByIds(
		groupId: String?,
		ids: Set<String>,
		waitOrRetrieveUncached: Boolean,
	): Map<String, ExchangeDataWithPotentiallyDecryptedContent>

	/**
	 * Clears the cache or fully repopulates the cache if the current data owner can retrieve all of his exchange data according to the crypto
	 * strategies.
	 */
	suspend fun clearOrRepopulateCache()

	/**
	 * If the current data owner requires anonymous delegations this returns the base64 representation of the
	 * concatenation of all available access control keys for the current data owner.
	 * If the current data owner is explicit returns null.
	 */
	suspend fun getEncodedAccessControlKeysValue(
		groupId: String?,
		entityType: EntityWithEncryptionMetadataTypeName
	): List<Base64String>?

	/**
	 * Injects already decrypted exchange data, allowing it to be used by the sdk.
	 * @param exchangeDataDetails the exchange data to inject, with the decrypted content and verified status.
	 * Note that the SDK won't verify that the provided decrypted content actually matches what is stored in the exchange
	 * data.
	 * @param reEncryptWithOwnKeys if true all the provided exchange data that is not encrypted with any of the self
	 * verified keys of the user will be re-encrypted with them. In case the user is also the delegator and the data is
	 * verified the delegator signature will be updated.
	 */
	suspend fun injectDecryptedExchangeData(
		groupId: String?,
		exchangeDataDetails: List<ExchangeDataInjectionDetails>,
		reEncryptWithOwnKeys: Boolean
	)
}
