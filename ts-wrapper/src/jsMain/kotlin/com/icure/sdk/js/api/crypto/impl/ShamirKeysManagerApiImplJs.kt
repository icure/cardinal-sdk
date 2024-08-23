// auto-generated file
package com.icure.sdk.js.api.crypto.`impl`

import com.icure.sdk.api.ShamirKeysManagerApi
import com.icure.sdk.crypto.entities.ShamirUpdateRequest
import com.icure.sdk.js.api.crypto.ShamirKeysManagerApiJs
import com.icure.sdk.js.crypto.entities.ShamirUpdateRequestJs
import com.icure.sdk.js.crypto.entities.shamirUpdateRequest_fromJs
import com.icure.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.sdk.js.model.CheckedConverters.mapToObject
import com.icure.sdk.js.model.CheckedConverters.objectToMap
import com.icure.sdk.js.model.CheckedConverters.setToArray
import com.icure.sdk.js.model.CryptoActorStubWithTypeJs
import com.icure.sdk.js.model.base.CryptoActorJs
import com.icure.sdk.js.model.base.cryptoActor_fromJs
import com.icure.sdk.js.model.cryptoActorStubWithType_toJs
import com.icure.sdk.js.model.specializations.keypairFingerprintV1String_fromJs
import com.icure.sdk.js.model.specializations.keypairFingerprintV1String_toJs
import com.icure.sdk.js.utils.Record
import com.icure.sdk.model.base.CryptoActor
import com.icure.sdk.model.specializations.KeypairFingerprintV1String
import kotlin.Array
import kotlin.OptIn
import kotlin.String
import kotlin.collections.Map
import kotlin.collections.Set
import kotlin.js.Promise
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise

@OptIn(DelicateCoroutinesApi::class)
internal class ShamirKeysManagerApiImplJs(
	private val shamirKeysManagerApi: ShamirKeysManagerApi,
) : ShamirKeysManagerApiJs {
	override fun getExistingSplitsInfo(dataOwner: CryptoActorJs): Record<String, Array<String>> {
		val dataOwnerConverted: CryptoActor = cryptoActor_fromJs(dataOwner)
		val result = shamirKeysManagerApi.getExistingSplitsInfo(
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
		val result = shamirKeysManagerApi.updateSelfSplits(
			keySplitsToUpdateConverted,
			keySplitsToDeleteConverted,
		)
		cryptoActorStubWithType_toJs(result)
	}
}
