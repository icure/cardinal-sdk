// auto-generated file
package com.icure.cardinal.sdk.js.api.`impl`

import com.icure.cardinal.sdk.api.CryptoApi
import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.cardinal.sdk.crypto.entities.ExchangeDataInjectionDetails
import com.icure.cardinal.sdk.crypto.entities.ShamirUpdateRequest
import com.icure.cardinal.sdk.js.api.CryptoApiJs
import com.icure.cardinal.sdk.js.api.CryptoInGroupApiJs
import com.icure.cardinal.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNonNull
import com.icure.cardinal.sdk.js.api.ShamirKeysManagerApiJs
import com.icure.cardinal.sdk.js.crypto.entities.ExchangeDataInjectionDetailsJs
import com.icure.cardinal.sdk.js.crypto.entities.RawDecryptedExchangeDataJs
import com.icure.cardinal.sdk.js.crypto.entities.ShamirUpdateRequestJs
import com.icure.cardinal.sdk.js.crypto.entities.exchangeDataInjectionDetails_fromJs
import com.icure.cardinal.sdk.js.crypto.entities.rawDecryptedExchangeData_toJs
import com.icure.cardinal.sdk.js.crypto.entities.shamirUpdateRequest_fromJs
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToList
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.cardinal.sdk.js.model.CheckedConverters.listToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.mapToObject
import com.icure.cardinal.sdk.js.model.CheckedConverters.objectToMap
import com.icure.cardinal.sdk.js.model.CheckedConverters.setToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.js.model.CryptoActorStubWithTypeJs
import com.icure.cardinal.sdk.js.model.EntityReferenceInGroupJs
import com.icure.cardinal.sdk.js.model.base.CryptoActorJs
import com.icure.cardinal.sdk.js.model.base.cryptoActor_fromJs
import com.icure.cardinal.sdk.js.model.cryptoActorStubWithType_toJs
import com.icure.cardinal.sdk.js.model.entityReferenceInGroup_fromJs
import com.icure.cardinal.sdk.js.model.specializations.keypairFingerprintV1String_fromJs
import com.icure.cardinal.sdk.js.model.specializations.keypairFingerprintV1String_toJs
import com.icure.cardinal.sdk.js.model.specializations.pkcs8Bytes_toJs
import com.icure.cardinal.sdk.js.utils.Record
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.model.base.CryptoActor
import com.icure.cardinal.sdk.model.specializations.KeypairFingerprintV1String
import com.icure.cardinal.sdk.model.specializations.Pkcs8Bytes
import kotlin.Array
import kotlin.Boolean
import kotlin.ByteArray
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.Set
import kotlin.js.Promise
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise

@OptIn(DelicateCoroutinesApi::class)
internal class CryptoApiImplJs(
	private val cryptoApi: CryptoApi,
) : CryptoApiJs {
	override val shamirKeysManager: ShamirKeysManagerApiJs = object : ShamirKeysManagerApiJs {
		override fun getExistingSplitsInfo(dataOwner: CryptoActorJs): Record<String, Array<String>> {
			val dataOwnerConverted: CryptoActor = cryptoActor_fromJs(dataOwner)
			val result = cryptoApi.shamirKeysManager.getExistingSplitsInfo(
				dataOwnerConverted,
			)
			return mapToObject(
				result,
				{ x1: KeypairFingerprintV1String ->
					keypairFingerprintV1String_toJs(x1)
				},
				{ x1: Set<String> ->
					setToArray(
						x1,
						{ x2: String ->
							x2
						},
					)
				},
			)
		}

		override fun updateSelfSplits(keySplitsToUpdate: Record<String, ShamirUpdateRequestJs>,
				keySplitsToDelete: Array<String>): Promise<CryptoActorStubWithTypeJs> = GlobalScope.promise {
			val keySplitsToUpdateConverted: Map<KeypairFingerprintV1String, ShamirUpdateRequest> =
					objectToMap(
				keySplitsToUpdate,
				"keySplitsToUpdate",
				{ x1: String ->
					keypairFingerprintV1String_fromJs(x1)
				},
				{ x1: ShamirUpdateRequestJs ->
					shamirUpdateRequest_fromJs(x1)
				},
			)
			val keySplitsToDeleteConverted: Set<KeypairFingerprintV1String> = arrayToSet(
				keySplitsToDelete,
				"keySplitsToDelete",
				{ x1: String ->
					keypairFingerprintV1String_fromJs(x1)
				},
			)
			val result = cryptoApi.shamirKeysManager.updateSelfSplits(
				keySplitsToUpdateConverted,
				keySplitsToDeleteConverted,
			)
			cryptoActorStubWithType_toJs(result)
		}
	}

	override val inGroup: CryptoInGroupApiJs = object : CryptoInGroupApiJs {
		override fun keylessCreateExchangeDataTo(groupId: String?, `delegate`: EntityReferenceInGroupJs):
				Promise<RawDecryptedExchangeDataJs> = GlobalScope.promise {
			val groupIdConverted: String? = undefinedToNull(groupId)
			val delegateConverted: EntityReferenceInGroup = entityReferenceInGroup_fromJs(delegate)
			val result = cryptoApi.inGroup.keylessCreateExchangeDataTo(
				groupIdConverted,
				delegateConverted,
			)
			rawDecryptedExchangeData_toJs(result)
		}

		override fun getAccessControlKeys(groupId: String?, entityType: String): Promise<Array<String>> =
				GlobalScope.promise {
			val groupIdConverted: String? = undefinedToNull(groupId)
			val entityTypeConverted: EntityWithEncryptionMetadataTypeName =
					EntityWithEncryptionMetadataTypeName.valueOf(entityType)
			val result = cryptoApi.inGroup.getAccessControlKeys(
				groupIdConverted,
				entityTypeConverted,
			)
			listToArray(
				result,
				{ x1: String ->
					x1
				},
			)
		}
	}

	override fun getAccessControlKeys(entityType: String): Promise<Array<String>> =
			GlobalScope.promise {
		val entityTypeConverted: EntityWithEncryptionMetadataTypeName =
				EntityWithEncryptionMetadataTypeName.valueOf(entityType)
		val result = cryptoApi.getAccessControlKeys(
			entityTypeConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun forceReload(): Promise<Unit> = GlobalScope.promise {
		cryptoApi.forceReload(
		)

	}

	override fun currentDataOwnerKeys(options: dynamic):
			Promise<Record<String, Record<String, ByteArray>>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val filterTrustedKeysConverted: Boolean = convertingOptionOrDefaultNonNull(
				_options,
				"filterTrustedKeys",
				true
			) { filterTrustedKeys: Boolean ->
				filterTrustedKeys
			}
			val result = cryptoApi.currentDataOwnerKeys(
				filterTrustedKeysConverted,
			)
			mapToObject(
				result,
				{ x1: String ->
					x1
				},
				{ x1: Map<KeypairFingerprintV1String, Pkcs8Bytes> ->
					mapToObject(
						x1,
						{ x2: KeypairFingerprintV1String ->
							keypairFingerprintV1String_toJs(x2)
						},
						{ x2: Pkcs8Bytes ->
							pkcs8Bytes_toJs(x2)
						},
					)
				},
			)
		}
	}

	override fun keylessCreateExchangeDataTo(`delegate`: String): Promise<RawDecryptedExchangeDataJs> =
			GlobalScope.promise {
		val delegateConverted: String = delegate
		val result = cryptoApi.keylessCreateExchangeDataTo(
			delegateConverted,
		)
		rawDecryptedExchangeData_toJs(result)
	}

	override fun injectExchangeData(
		groupId: String?,
		details: Array<ExchangeDataInjectionDetailsJs>,
		reEncryptWithOwnKeys: Boolean,
	): Promise<Unit> = GlobalScope.promise {
		val groupIdConverted: String? = undefinedToNull(groupId)
		val detailsConverted: List<ExchangeDataInjectionDetails> = arrayToList(
			details,
			"details",
			{ x1: ExchangeDataInjectionDetailsJs ->
				exchangeDataInjectionDetails_fromJs(x1)
			},
		)
		val reEncryptWithOwnKeysConverted: Boolean = reEncryptWithOwnKeys
		cryptoApi.injectExchangeData(
			groupIdConverted,
			detailsConverted,
			reEncryptWithOwnKeysConverted,
		)

	}
}
