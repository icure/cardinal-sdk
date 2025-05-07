package com.icure.cardinal.sdk.api.impl

import com.icure.cardinal.sdk.api.RecoveryApi
import com.icure.cardinal.sdk.api.raw.HttpResponse
import com.icure.cardinal.sdk.crypto.InternalCryptoServices
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.crypto.entities.ExchangeDataRecoveryDetails
import com.icure.cardinal.sdk.crypto.entities.RecoveryDataKey
import com.icure.cardinal.sdk.crypto.entities.RecoveryDataUseFailureReason
import com.icure.cardinal.sdk.crypto.entities.RecoveryKeyOptions
import com.icure.cardinal.sdk.crypto.entities.RecoveryKeySize
import com.icure.cardinal.sdk.crypto.entities.RecoveryResult
import com.icure.cardinal.sdk.crypto.entities.VerifiedRsaEncryptionKeysSet
import com.icure.cardinal.sdk.crypto.entities.map
import com.icure.cardinal.sdk.crypto.entities.toPublicKeyInfo
import com.icure.cardinal.sdk.model.RecoveryData
import com.icure.cardinal.sdk.model.embed.EncryptedContent
import com.icure.cardinal.sdk.model.specializations.SpkiHexString
import com.icure.cardinal.sdk.utils.InternalCardinalException
import com.icure.cardinal.sdk.utils.base64Encode
import com.icure.cardinal.sdk.utils.decode
import com.icure.cardinal.sdk.utils.getLogger
import com.icure.kryptom.crypto.RsaAlgorithm
import com.icure.kryptom.crypto.RsaKeypair
import com.icure.utils.InternalIcureApi
import io.ktor.http.isSuccess

@InternalIcureApi
internal class RecoveryApiImpl(
	private val crypto: InternalCryptoServices
): RecoveryApi {
	companion object {
		private val log = getLogger("RecoveryApiImpl")
	}

	override suspend fun createRecoveryInfoForAvailableKeyPairs(
		includeParentsKeys: Boolean,
		lifetimeSeconds: Int?,
		recoveryKeyOptions: RecoveryKeyOptions?
	): RecoveryDataKey {
		val selfId = crypto.dataOwnerApi.getCurrentDataOwnerId()
		val allAvailableKeys = crypto.userEncryptionKeysManager.getCurrentUserHierarchyAvailableKeypairs()
		val dataOwnersToInclude = if (includeParentsKeys) {
			listOf(allAvailableKeys.self, *allAvailableKeys.parents.toTypedArray())
		} else {
			listOf(allAvailableKeys.self)
		}
		val keyPairsToSave = dataOwnersToInclude.associate { dataOwnerKeyInfo ->
			dataOwnerKeyInfo.dataOwnerId to dataOwnerKeyInfo.keys.mapNotNull {
				if (it.isVerified || it.isDevice) {
					it.keyPair.key
				} else null
			}
		}
		return crypto.recoveryDataEncryption.createAndSaveKeyPairsRecoveryDataFor(selfId, keyPairsToSave, lifetimeSeconds, recoveryKeyOptions)
	}

	override suspend fun recoverKeyPairs(
		recoveryKey: RecoveryDataKey,
		autoDelete: Boolean
	): RecoveryResult<Map<String, Map<SpkiHexString, RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm>>>> =
		crypto.recoveryDataEncryption.getAndDecryptKeyPairsRecoveryData(recoveryKey, autoDelete)

	override suspend fun recoverKeyPairsWaitingForCreation(
		recoveryKey: RecoveryDataKey,
		autoDelete: Boolean,
		waitSeconds: Int
	): RecoveryResult<Map<String, Map<SpkiHexString, RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm>>>> =
		crypto.recoveryDataEncryption.waitAndDecryptKeyPairsRecoveryData(recoveryKey, autoDelete, waitSeconds)

	override suspend fun createExchangeDataRecoveryInfo(
		delegateId: String,
		lifetimeSeconds: Int?,
		recoveryKeyOptions: RecoveryKeyOptions?
	): RecoveryDataKey {
		val exchangeDataToDelegate = crypto.exchangeDataManager.base.getExchangeDataByDelegatorDelegatePair(
			null,
			crypto.dataOwnerApi.getCurrentDataOwnerReference(),
			EntityReferenceInGroup(delegateId, null)
		)
		val decryptionKeys = crypto.userEncryptionKeysManager.getDecryptionKeys(true)
		val decryptedInformation = exchangeDataToDelegate.mapNotNull { exchangeData ->
			crypto.exchangeDataManager.base.tryRawDecryptExchangeData(exchangeData, decryptionKeys)?.let { decryptedData ->
				ExchangeDataRecoveryDetails(
					exchangeDataId = exchangeData.id,
					rawExchangeKey = decryptedData.exchangeKey.base64Encode(),
					rawAccessControlSecret = decryptedData.accessControlSecret.base64Encode(),
					rawSharedSignatureKey = decryptedData.sharedSignatureKey.base64Encode()
				)
			}
		}
		return crypto.recoveryDataEncryption.createAndSaveExchangeDataRecoveryData(delegateId, decryptedInformation, lifetimeSeconds, recoveryKeyOptions)
	}

	override suspend fun recoverExchangeData(recoveryKey: RecoveryDataKey): RecoveryDataUseFailureReason? =
		crypto.recoveryDataEncryption.getAndDecryptExchangeDataRecoveryData(recoveryKey).map { recoveredExchangeData ->
			val selfEncryptionKeys = VerifiedRsaEncryptionKeysSet(
				crypto.userEncryptionKeysManager.getSelfVerifiedKeys().map { it.toPublicKeyInfo() }
			)
			recoveredExchangeData.forEach { exchangeDataInfo ->
				val retrievedData = crypto.exchangeDataManager.base.getExchangeDataByIds(null, listOf(exchangeDataInfo.exchangeDataId)).singleOrNull()
				if (retrievedData == null) {
					log.w { "Could not recover exchange data with id ${exchangeDataInfo.exchangeDataId} as it was not found. Ignoring" }
				} else {
					crypto.exchangeDataManager.base.updateExchangeDataWithRawDecryptedContent(
						retrievedData,
						selfEncryptionKeys,
						exchangeDataInfo.rawExchangeKey.decode(),
						exchangeDataInfo.rawAccessControlSecret.decode(),
						exchangeDataInfo.rawSharedSignatureKey.decode()
					)
				}
			}
		}.let {
			if (it is RecoveryResult.Failure) {
				it.reason
			} else {
				val deleteResult = crypto.recoveryDataEncryption.raw.deleteRecoveryData(crypto.recoveryDataEncryption.recoveryKeyToId(recoveryKey))
				if (!deleteResult.status.isSuccess()) {
					log.w { "Could not delete recovery data with id $recoveryKey after successful recovery: ${deleteResult.status}. Ignoring." }
				}
				crypto.exchangeDataManager.clearOrRepopulateCache()
				null
			}
		}

	override suspend fun purgeRecoveryInfo(recoveryKey: RecoveryDataKey) {
		crypto.recoveryDataEncryption.raw.deleteRecoveryData(
			crypto.recoveryDataEncryption.recoveryKeyToId(recoveryKey)
		).successBody()
	}

	override suspend fun purgeAllRecoveryInfoFor(dataOwnerId: String): Int =
		crypto.recoveryDataEncryption.raw.deleteAllRecoveryDataForRecipient(dataOwnerId).getCount()

	override suspend fun purgeAllKeyPairRecoveryInfoFor(dataOwnerId: String): Int =
		crypto.recoveryDataEncryption.raw.deleteAllRecoveryDataOfTypeForRecipient(
			RecoveryData.Type.KeypairRecovery,
			dataOwnerId
		).getCount()

	override suspend fun purgeAllExchangeDataRecoveryInfoFor(dataOwnerId: String): Int =
		crypto.recoveryDataEncryption.raw.deleteAllRecoveryDataOfTypeForRecipient(
			RecoveryData.Type.ExchangeKeyRecovery,
			dataOwnerId
		).getCount()

	private suspend fun HttpResponse<EncryptedContent>.getCount() =
		successBody().let {
			it.numberValue?.toInt() ?: throw InternalCardinalException("Could not parse count from response body: $it")
		}

	override suspend fun preGenerateRecoveryKey(keySize: RecoveryKeySize): RecoveryDataKey =
		crypto.recoveryDataEncryption.generateNewKey(keySize)
}