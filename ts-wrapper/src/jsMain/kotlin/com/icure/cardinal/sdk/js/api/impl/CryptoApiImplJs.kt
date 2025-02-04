// auto-generated file
package com.icure.cardinal.sdk.js.api.`impl`

import com.icure.cardinal.sdk.api.CryptoApi
import com.icure.cardinal.sdk.crypto.entities.ShamirUpdateRequest
import com.icure.cardinal.sdk.js.api.CryptoApiJs
import com.icure.cardinal.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNonNull
import com.icure.cardinal.sdk.js.api.ShamirKeysManagerApiJs
import com.icure.cardinal.sdk.js.crypto.entities.ShamirUpdateRequestJs
import com.icure.cardinal.sdk.js.crypto.entities.shamirUpdateRequest_fromJs
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.cardinal.sdk.js.model.CheckedConverters.mapToObject
import com.icure.cardinal.sdk.js.model.CheckedConverters.objectToMap
import com.icure.cardinal.sdk.js.model.CheckedConverters.setToArray
import com.icure.cardinal.sdk.js.model.CryptoActorStubWithTypeJs
import com.icure.cardinal.sdk.js.model.base.CryptoActorJs
import com.icure.cardinal.sdk.js.model.base.cryptoActor_fromJs
import com.icure.cardinal.sdk.js.model.cryptoActorStubWithType_toJs
import com.icure.cardinal.sdk.js.model.specializations.keypairFingerprintV1String_fromJs
import com.icure.cardinal.sdk.js.model.specializations.keypairFingerprintV1String_toJs
import com.icure.cardinal.sdk.js.model.specializations.pkcs8Bytes_toJs
import com.icure.cardinal.sdk.js.utils.Record
import com.icure.cardinal.sdk.model.base.CryptoActor
import com.icure.cardinal.sdk.model.specializations.KeypairFingerprintV1String
import com.icure.cardinal.sdk.model.specializations.Pkcs8Bytes
import kotlin.Array
import kotlin.Boolean
import kotlin.ByteArray
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
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
}
