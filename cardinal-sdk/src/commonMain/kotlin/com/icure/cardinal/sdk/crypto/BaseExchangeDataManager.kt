package com.icure.cardinal.sdk.crypto

import com.icure.cardinal.sdk.api.raw.RawExchangeDataApi
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.crypto.entities.DecryptionResult
import com.icure.cardinal.sdk.crypto.entities.ExchangeDataWithUnencryptedContent
import com.icure.cardinal.sdk.crypto.entities.RawDecryptedExchangeData
import com.icure.cardinal.sdk.crypto.entities.RsaDecryptionKeysSet
import com.icure.cardinal.sdk.crypto.entities.SelfVerifiedKeysSet
import com.icure.cardinal.sdk.crypto.entities.UnencryptedExchangeDataContent
import com.icure.cardinal.sdk.crypto.entities.VerifiedRsaEncryptionKeysSet
import com.icure.cardinal.sdk.model.ExchangeData
import com.icure.cardinal.sdk.model.specializations.AccessControlSecret
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.HmacAlgorithm
import com.icure.kryptom.crypto.HmacKey
import com.icure.utils.InternalIcureApi

/**
 * Functions to create and get exchange data.
 * The methods of this api require to pass the appropriate keys for encryption/decryption manually.
 */
@InternalIcureApi
interface BaseExchangeDataManager {
	val raw: RawExchangeDataApi

	/**
	 * Get all the exchange data where the current data owner is the delegator or the delegate.
	 * This method shouldn't be called with "explicit" data owners (usually HCPs), since they may have a prohibitively
	 * high amount of exchange data this method.
	 * This metho instead should only be used when the current data owner is an "anonymous" data owner (according to the crypto strategies).
	 * @return all the exchange data for the current data owner.
	 */
	suspend fun getAllExchangeDataForDataOwner(dataOwnerId: String, inGroup: String?): List<ExchangeData>

	/**
	 * Get all exchange data for the provided delegator-delegate pair.
	 * @param delegatorId id of a delegator data owner.
	 * @param delegateId id of a delegate data owner.
	 * @return all exchange data for the provided delegator-delegate pair.
	 */
	suspend fun getExchangeDataByDelegatorDelegatePair(
		inGroup: String?,
		delegatorReference: EntityReferenceInGroup,
		delegateReference: EntityReferenceInGroup,
	): List<ExchangeData>

	/**
	 * Get the exchange data with the provided id.
	 * @param exchangeDataId id of the exchange data.
	 * @return the exchange data with the provided id or undefined if no exchange data with such id could be found.
	 */
	suspend fun getExchangeDataByIds(
		inGroup: String?,
		exchangeDataIds: Collection<String>
	): List<ExchangeData>

	/**
	 * Verifies the authenticity of the exchange data by checking the signature.
	 * Note that all exchange data created by data owners other than the current data owner (including members of his hierarchy)
	 * will always be unverified.
	 * @param data information about the exchange data to verify.
	 * @param delegatorSignatureKeys verified keys used to ensure the authenticity of exchange data created by the current
	 * data owner.
	 * @param verifyAsDelegator if not null and matches the delegator of the provided data the method will also verify
	 * that the hmac key used for the signature was created by the delegator of the exchange data.
	 * If not null, and the exchange data's delegator doesn't match, the delegator signature didn't use the provided keys,
	 * or the verification fails this method returns false.
	 * @return the exchange data which could be verified given his signature and the available verification keys.
	 */
	suspend fun verifyExchangeData(
		data: ExchangeDataWithUnencryptedContent,
		delegatorSignatureKeys: SelfVerifiedKeysSet,
		verifyAsDelegator: String?
	): Boolean

	/**
	 * Extracts and decrypts the access control secret from the provided exchange data.
	 * These need to be hashed together with the entity class in order to get the actual access control key which will be
	 * sent to the server.
	 * @param exchangeData the exchange data from which to extract access control secrets.
	 * @param decryptionKeys rsa key pairs to use for decryption of the access control secret.
	 * @return an object composed of:
	 * - successfulDecryptions: array of all successfully decrypted access control keys
	 * - failedDecryptions: array containing all exchange data for which the access control key could not be decrypted (using the provided keys).
	 */
	suspend fun tryDecryptAccessControlSecret(
		exchangeData: List<ExchangeData>,
		decryptionKeys: RsaDecryptionKeysSet
	): DecryptionResult<ExchangeData, AccessControlSecret>

	/**
	 * Extract and decrypts the exchange keys from the provided exchange data.
	 * @param exchangeData the exchange data from which to extract exchange keys.
	 * @param decryptionKeys rsa key pairs to use for the decryption of the exchange keys.
	 * @return an object composed of:
	 * - successfulDecryptions: array containing the successfully decrypted exchange keys.
	 * - failedDecryptions: array containing all exchange data for which the access control key could not be decrypted (using the provided keys).
	 */
	suspend fun tryDecryptExchangeKeys(
		exchangeData: List<ExchangeData>,
		decryptionKeys: RsaDecryptionKeysSet
	): DecryptionResult<ExchangeData, AesKey<AesAlgorithm.CbcWithPkcs7Padding>>

	/**
	 * Extract and decrypts the shared signature key from the provided exchange data.
	 * @param exchangeData the exchange data from which to extract exchange keys.
	 * @param decryptionKeys rsa key pairs to use for the decryption of the exchange keys.
	 * @return an object composed of:
	 * - successfulDecryptions: array containing the successfully decrypted exchange keys.
	 * - failedDecryptions: array containing all exchange data for which the access control key could not be decrypted (using the provided keys).
	 */
	suspend fun tryDecryptSharedSignatureKeys(
		exchangeData: List<ExchangeData>,
		decryptionKeys: RsaDecryptionKeysSet
	): DecryptionResult<ExchangeData, HmacKey<HmacAlgorithm.HmacSha512>>

	/**
	 * Creates exchange data from the current data owner to the provided delegate, uploading the newly created exchange data to the cloud.
	 * This assumes that the keys have been verified.
	 * @param delegateId id of the delegate for the new exchange data.
	 * @param signatureKeys private keys to use for signing the created data.
	 * @param encryptionKeys public keys to use for the encryption of the exchange data (from delegator and delegate).
	 * @param exchangeDataId allows to specify the id for the new data to create. If null the id will be generated by this
	 * method.
	 * @return the newly created exchange data, and its decrypted exchange key and access control secret.
	 */
	suspend fun createExchangeData(
		inGroup: String?,
		delegatorReference: EntityReferenceInGroup,
		delegateReference: EntityReferenceInGroup,
		signatureKeys: SelfVerifiedKeysSet,
		encryptionKeys: VerifiedRsaEncryptionKeysSet,
		exchangeDataId: String? = null
	): ExchangeDataWithUnencryptedContent

	/**
	 * Decrypts the content of the provided exchange data using the provided keys. Does not interpret the decrypted
	 * content, leaving it as raw bytes.
	 * @param exchangeData exchange data to decrypt.
	 * @param decryptionKeys keys to use to extract the content of the exchange data.
	 * @return the decrypted content of the exchange data as raw bytes.
	 */
	suspend fun tryRawDecryptExchangeData(
		exchangeData: ExchangeData,
		decryptionKeys: RsaDecryptionKeysSet
	): RawDecryptedExchangeData?

	/**
	 * Updates existing exchange data and uploads it to the cloud in order to share it also with additional public keys, useful for example in cases
	 * where one of the data owners involved in the exchange data has lost one of his keys.
	 * If the content of the exchange data could not be decrypted using the provided keys the method will not update anything and will return undefined.
	 * This method assumes that the new encryption keys have been verified.
	 * @param exchangeData exchange data to update.
	 * @param decryptionKeys keys to use to extract the content of the exchange data which will be shared with the new keys.
	 * @param newEncryptionKeys new keys to add to the exchange data.
	 * @param delegatorSignatureKeys if not null and the delegator of the exchange data matches the provided id keys to use to update the delegator signature:
	 * - If there is already a signature from the delegator that can be verified with the provided keys, the signature will be updated to include also any of the provided keys that are missing.
	 * - If there is no signature from the delegator a new signature will be created using the provided keys.
	 * - If there is already a signature from the delegator but it can't be verified with the provided keys the method will not update the delegator signature.
	 * @return the updated exchange data, and its decrypted exchange key and access control secret, or null if the exchange data content could not
	 * be decrypted and the exchange data could not be updated.
	 */
	suspend fun tryUpdateExchangeData(
		exchangeData: ExchangeData,
		decryptionKeys: RsaDecryptionKeysSet,
		newEncryptionKeys: VerifiedRsaEncryptionKeysSet,
		delegatorSignatureKeys: Pair<EntityReferenceInGroup, SelfVerifiedKeysSet>?
	): ExchangeDataWithUnencryptedContent?

	/**
	 * Same as [tryUpdateExchangeData] but the decrypted content is already provided.
	 */
	suspend fun updateExchangeDataWithDecryptedContent(
		exchangeData: ExchangeData,
		newEncryptionKeys: VerifiedRsaEncryptionKeysSet,
		delegatorSignatureKeys: Pair<EntityReferenceInGroup, SelfVerifiedKeysSet>?,
		unencryptedExchangeDataContent: UnencryptedExchangeDataContent
	): ExchangeDataWithUnencryptedContent

	/**
	 * Same as [updateExchangeDataWithDecryptedContent] but the decrypted content is provided "raw".
	 */
	suspend fun updateExchangeDataWithRawDecryptedContent(
		exchangeData: ExchangeData,
		newEncryptionKeys: VerifiedRsaEncryptionKeysSet,
		delegatorSignatureKeys: Pair<EntityReferenceInGroup, SelfVerifiedKeysSet>?,
		rawExchangeKey: ByteArray,
		rawAccessControlSecret: ByteArray,
		rawSharedSignatureKey: ByteArray
	): ExchangeDataWithUnencryptedContent

	suspend fun exportExchangeKey(decryptedExchangeKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>): ByteArray
	suspend fun exportSharedSignatureKey(decryptedSharedSignatureKey: HmacKey<HmacAlgorithm>): ByteArray
	fun exportAccessControlSecret(decryptedAccessControlSecret: AccessControlSecret): ByteArray
	fun importAccessControlSecret(decryptedBytes: ByteArray): AccessControlSecret
	suspend fun importSharedSignatureKey(decryptedBytes: ByteArray): HmacKey<HmacAlgorithm.HmacSha512>
	suspend fun importExchangeKey(decryptedBytes: ByteArray): AesKey<AesAlgorithm.CbcWithPkcs7Padding>
}
