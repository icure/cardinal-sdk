package com.icure.cardinal.sdk.crypto

import com.icure.cardinal.sdk.api.DataOwnerApi
import com.icure.cardinal.sdk.storage.CardinalStorageFacade
import com.icure.kryptom.crypto.CryptoService
import com.icure.utils.InternalIcureApi

@InternalIcureApi
interface InternalCryptoServices : BasicInternalCryptoApi{
	suspend fun forceReload()

	val entity: EntityEncryptionService
	val primitives: CryptoService
	val exchangeDataManager: ExchangeDataManager
	val exchangeKeysManager: ExchangeKeysManager
	val delegationsDeAnonymization: DelegationsDeAnonymization
	val dataOwnerApi: DataOwnerApi
	val userEncryptionKeysManager: UserEncryptionKeysManager
	val recoveryDataEncryption: RecoveryDataEncryption
	val headersProvider: AccessControlKeysHeadersProvider
	val strategies: CryptoStrategies
	val incrementalSecurityMetadataDecryptor: IncrementalSecurityMetadataDecryptor
	val securityMetadataDecryptor: BaseSecurityMetadataDecryptor
	val storage: CardinalStorageFacade

	override val validationService: EntityValidationService
		get() = entity

	override val entityAccessInformationProvider: EntityAccessInformationProvider
		get() = delegationsDeAnonymization
}

@InternalIcureApi
interface BasicInternalCryptoApi {
	val jsonEncryption: JsonEncryptionService
	val validationService: EntityValidationService
	val entityAccessInformationProvider: EntityAccessInformationProvider
}
