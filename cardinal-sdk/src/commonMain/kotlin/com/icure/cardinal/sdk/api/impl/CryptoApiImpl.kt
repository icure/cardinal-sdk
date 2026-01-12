package com.icure.cardinal.sdk.api.impl

import com.icure.cardinal.sdk.api.CryptoApi
import com.icure.cardinal.sdk.api.CryptoInGroupApi
import com.icure.cardinal.sdk.api.ShamirKeysManagerApi
import com.icure.cardinal.sdk.crypto.InternalCryptoServices
import com.icure.cardinal.sdk.crypto.entities.ExchangeDataInjectionDetails
import com.icure.cardinal.sdk.crypto.entities.RawDecryptedExchangeData
import com.icure.cardinal.sdk.crypto.impl.exportSpkiHex
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.model.extensions.publicKeysSpki
import com.icure.cardinal.sdk.model.specializations.KeypairFingerprintV1String
import com.icure.cardinal.sdk.model.specializations.Pkcs8Bytes
import com.icure.kryptom.crypto.RsaAlgorithm
import com.icure.kryptom.crypto.defaultCryptoService
import com.icure.utils.InternalIcureApi

@InternalIcureApi
internal class CryptoApiImpl(
	override val shamirKeysManager: ShamirKeysManagerApi,
	internal val internal: InternalCryptoServices
) : CryptoApi {
	override val inGroup: CryptoInGroupApi = object : CryptoInGroupApi {
		override suspend fun keylessCreateExchangeDataTo(
			groupId: String?,
			delegate: EntityReferenceInGroup
		) = doKeylessCreateExchangeDataTo(groupId, delegate)
	}

	override suspend fun forceReload() {
		internal.forceReload()
	}

	override suspend fun currentDataOwnerKeys(
		filterTrustedKeys: Boolean
	): Map<String, Map<KeypairFingerprintV1String, Pkcs8Bytes>> =
		internal.userEncryptionKeysManager.getCurrentUserHierarchyAvailableKeypairs().run {
			listOf(self) + parents
		}.associate { keyInfo ->
			keyInfo.dataOwnerId to keyInfo.keys.filter { cachedKeypairDetails ->
				!filterTrustedKeys || cachedKeypairDetails.isDevice || cachedKeypairDetails.isVerified
			}.associate { cachedKeypairDetails ->
				Pair(
					cachedKeypairDetails.keyPair.pubSpkiHexString.fingerprintV1(),
					Pkcs8Bytes(defaultCryptoService.rsa.exportPrivateKeyPkcs8(cachedKeypairDetails.keyPair.key.private))
				)
			}
		}

	override suspend fun keylessCreateExchangeDataTo(delegate: String) = doKeylessCreateExchangeDataTo(
		groupId = null,
		delegate = EntityReferenceInGroup(
			entityId = delegate,
			groupId = null
		)
	)

	private suspend fun doKeylessCreateExchangeDataTo(
		groupId: String?,
		delegate: EntityReferenceInGroup
	): RawDecryptedExchangeData {
		require(delegate.groupId == null && delegate.entityId != this.internal.dataOwnerApi.getCurrentDataOwnerId()) { "Can't create exchange data to yourself in keyless mode." }
		check(this.internal.userEncryptionKeysManager.delegatorActorVerifiedKeys().isEmpty()) { "This method can only be used in keyless mode." }

		val created = this.internal.exchangeDataManager.getOrCreateEncryptionDataTo(
			groupId = groupId,
			delegateReference = delegate,
			allowCreationWithoutDelegateKey = false,
			allowCreationWithoutDelegatorKey = true
		)
		return RawDecryptedExchangeData(
			exchangeDataId = created.exchangeData.id,
			accessControlSecret = this.internal.exchangeDataManager.base.exportAccessControlSecret(created.unencryptedContent.accessControlSecret),
			exchangeKey =  this.internal.exchangeDataManager.base.exportExchangeKey(created.unencryptedContent.exchangeKey),
			sharedSignatureKey =  this.internal.exchangeDataManager.base.exportSharedSignatureKey(created.unencryptedContent.sharedSignatureKey),
		)
	}

	override suspend fun injectExchangeData(
		groupId: String?,
		details: List<ExchangeDataInjectionDetails>,
		reEncryptWithOwnKeys: Boolean,
	) {
		this.internal.exchangeDataManager.injectDecryptedExchangeData(
			groupId = groupId,
			exchangeDataDetails = details,
			reEncryptWithOwnKeys = reEncryptWithOwnKeys
		)
	}
}
