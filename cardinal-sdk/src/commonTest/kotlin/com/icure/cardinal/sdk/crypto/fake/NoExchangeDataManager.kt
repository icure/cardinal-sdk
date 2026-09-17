package com.icure.cardinal.sdk.crypto.fake

import com.icure.cardinal.sdk.crypto.BaseExchangeDataManager
import com.icure.cardinal.sdk.crypto.ExchangeDataManager
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.cardinal.sdk.crypto.entities.ExchangeDataInjectionDetails
import com.icure.cardinal.sdk.crypto.entities.ExchangeDataWithPotentiallyDecryptedContent
import com.icure.cardinal.sdk.crypto.entities.ExchangeDataWithUnencryptedContent
import com.icure.cardinal.sdk.model.specializations.Base64String
import com.icure.cardinal.sdk.model.specializations.SecureDelegationKeyString
import com.icure.cardinal.sdk.model.specializations.SpkiHexString
import com.icure.utils.InternalIcureApi

@OptIn(InternalIcureApi::class)
object NoExchangeDataManager : ExchangeDataManager {
	override val base: BaseExchangeDataManager
		get() = TODO("Not yet implemented")

	override suspend fun giveAccessBackTo(otherDataOwner: String, newDataOwnerPublicKey: SpkiHexString) {
		TODO("Not yet implemented")
	}

	override suspend fun getOrCreateEncryptionDataTo(
		groupId: String?,
		delegateReference: EntityReferenceInGroup,
		allowCreationWithoutDelegateKey: Boolean,
		allowCreationWithoutDelegatorKey: Boolean
	): ExchangeDataWithUnencryptedContent {
		TODO("Not yet implemented")
	}

	override suspend fun getCachedDecryptionDataKeyByAccessControlHash(
		groupId: String?,
		hashes: Set<SecureDelegationKeyString>
	): Map<SecureDelegationKeyString, ExchangeDataWithUnencryptedContent> {
		TODO("Not yet implemented")
	}

	override suspend fun getDecryptionDataByExchangeDataGroupIds(
		groupId: String?,
		ids: Set<String>,
		waitOrRetrieveUncached: Boolean
	): Map<String, ExchangeDataWithPotentiallyDecryptedContent> {
		TODO("Not yet implemented")
	}

	override suspend fun clearOrRepopulateCache() {
		TODO("Not yet implemented")
	}

	override suspend fun getEncodedAccessControlKeysValue(
		groupId: String?,
		entityType: EntityWithEncryptionMetadataTypeName
	): List<Base64String>? {
		TODO("Not yet implemented")
	}

	override suspend fun injectDecryptedExchangeData(
		groupId: String?,
		exchangeDataDetails: List<ExchangeDataInjectionDetails>,
		reEncryptWithOwnKeys: Boolean,
	) {
		TODO("Not yet implemented")
	}
}
