package com.icure.cardinal.sdk.crypto.impl

import com.icure.cardinal.sdk.api.DataOwnerApi
import com.icure.cardinal.sdk.crypto.AccessControlKeysHeadersProvider
import com.icure.cardinal.sdk.crypto.BaseSecurityMetadataDecryptor
import com.icure.cardinal.sdk.crypto.BasicInternalCryptoApi
import com.icure.cardinal.sdk.crypto.CryptoStrategies
import com.icure.cardinal.sdk.crypto.DelegationsDeAnonymization
import com.icure.cardinal.sdk.crypto.EntityAccessInformationProvider
import com.icure.cardinal.sdk.crypto.EntityEncryptionService
import com.icure.cardinal.sdk.crypto.EntityValidationService
import com.icure.cardinal.sdk.crypto.ExchangeDataManager
import com.icure.cardinal.sdk.crypto.ExchangeKeysManager
import com.icure.cardinal.sdk.crypto.IncrementalSecurityMetadataDecryptor
import com.icure.cardinal.sdk.crypto.InternalCryptoServices
import com.icure.cardinal.sdk.crypto.JsonEncryptionService
import com.icure.cardinal.sdk.crypto.RecoveryDataEncryption
import com.icure.cardinal.sdk.crypto.SecureDelegationsManager
import com.icure.cardinal.sdk.crypto.UserEncryptionKeysManager
import com.icure.cardinal.sdk.storage.CardinalStorageFacade
import com.icure.kryptom.crypto.CryptoService
import com.icure.utils.InternalIcureApi


/**
 * Groups all the internal crypto services.
 */
@InternalIcureApi
class InternalCryptoApiImpl(
	override val entity: EntityEncryptionService,
	override val primitives: CryptoService,
	override val exchangeDataManager: ExchangeDataManager,
	override val exchangeKeysManager: ExchangeKeysManager,
	override val jsonEncryption: JsonEncryptionService,
	override val delegationsDeAnonymization: DelegationsDeAnonymization,
	override val dataOwnerApi: DataOwnerApi,
	override val userEncryptionKeysManager: UserEncryptionKeysManager,
	override val recoveryDataEncryption: RecoveryDataEncryption,
	override val headersProvider: AccessControlKeysHeadersProvider,
	override val strategies: CryptoStrategies,
	private val secureDelegationsManager: SecureDelegationsManager,
	override val incrementalSecurityMetadataDecryptor: IncrementalSecurityMetadataDecryptor,
	override val securityMetadataDecryptor: BaseSecurityMetadataDecryptor,
	override val storage: CardinalStorageFacade,
) : InternalCryptoServices {
	/**
	 * Deletes all cached data in crypto services and reloads as needed.
	 */
	override suspend fun forceReload() {
		dataOwnerApi.clearCurrentDataOwnerIdsCache()
		userEncryptionKeysManager.reloadKeys()
		exchangeDataManager.clearOrRepopulateCache()
		exchangeKeysManager.requestCacheReload()
		secureDelegationsManager.clearCachedDataOwnersInfo()
	}
}

@InternalIcureApi
class BasicInternalCryptoApiImpl(
	override val primitives: CryptoService,
	override val jsonEncryption: JsonEncryptionService,
	override val validationService: EntityValidationService,
	override val entityAccessInformationProvider: EntityAccessInformationProvider
) : BasicInternalCryptoApi
