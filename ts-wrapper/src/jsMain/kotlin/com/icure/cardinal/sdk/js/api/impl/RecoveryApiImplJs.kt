// auto-generated file
package com.icure.cardinal.sdk.js.api.`impl`

import com.icure.cardinal.sdk.api.RecoveryApi
import com.icure.cardinal.sdk.crypto.entities.RawDecryptedExchangeData
import com.icure.cardinal.sdk.crypto.entities.RecoveryDataKey
import com.icure.cardinal.sdk.crypto.entities.RecoveryKeyOptions
import com.icure.cardinal.sdk.crypto.entities.RecoveryKeySize
import com.icure.cardinal.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNonNull
import com.icure.cardinal.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNullable
import com.icure.cardinal.sdk.js.api.RecoveryApiJs
import com.icure.cardinal.sdk.js.crypto.entities.RawDecryptedExchangeDataJs
import com.icure.cardinal.sdk.js.crypto.entities.RecoveryDataKeyJs
import com.icure.cardinal.sdk.js.crypto.entities.RecoveryKeyOptionsJs
import com.icure.cardinal.sdk.js.crypto.entities.RecoveryResultJs
import com.icure.cardinal.sdk.js.crypto.entities.rawDecryptedExchangeData_toJs
import com.icure.cardinal.sdk.js.crypto.entities.recoveryDataKey_fromJs
import com.icure.cardinal.sdk.js.crypto.entities.recoveryDataKey_toJs
import com.icure.cardinal.sdk.js.crypto.entities.recoveryKeyOptions_fromJs
import com.icure.cardinal.sdk.js.crypto.entities.recoveryResult_toJs
import com.icure.cardinal.sdk.js.model.CheckedConverters.intToNumber
import com.icure.cardinal.sdk.js.model.CheckedConverters.listToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.mapToObject
import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToInt
import com.icure.cardinal.sdk.js.model.specializations.spkiHexString_toJs
import com.icure.cardinal.sdk.js.utils.CancellablePromise
import com.icure.cardinal.sdk.js.utils.Record
import com.icure.cardinal.sdk.js.utils.cancellablePromise
import com.icure.cardinal.sdk.model.specializations.SpkiHexString
import com.icure.kryptom.crypto.RsaAlgorithm
import com.icure.kryptom.crypto.RsaKeypair
import com.icure.kryptom.crypto.`external`.XRsaKeypair
import com.icure.kryptom.crypto.`external`.toExternal
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.Int
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.js.Promise
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise

@OptIn(DelicateCoroutinesApi::class)
internal class RecoveryApiImplJs(
	private val recoveryApi: RecoveryApi,
) : RecoveryApiJs {
	override fun createRecoveryInfoForAvailableKeyPairs(options: dynamic): Promise<RecoveryDataKeyJs> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val includeParentsKeysConverted: Boolean = convertingOptionOrDefaultNonNull(
				_options,
				"includeParentsKeys",
				false
			) { includeParentsKeys: Boolean ->
				includeParentsKeys
			}
			val lifetimeSecondsConverted: Int? = convertingOptionOrDefaultNullable(
				_options,
				"lifetimeSeconds",
				null
			) { lifetimeSeconds: Double? ->
				numberToInt(lifetimeSeconds, "lifetimeSeconds")
			}
			val recoveryKeyOptionsConverted: RecoveryKeyOptions? = convertingOptionOrDefaultNullable(
				_options,
				"recoveryKeyOptions",
				null
			) { recoveryKeyOptions: RecoveryKeyOptionsJs? ->
				recoveryKeyOptions?.let { nonNull1 ->
					recoveryKeyOptions_fromJs(nonNull1)
				}
			}
			val result = recoveryApi.createRecoveryInfoForAvailableKeyPairs(
				includeParentsKeysConverted,
				lifetimeSecondsConverted,
				recoveryKeyOptionsConverted,
			)
			recoveryDataKey_toJs(result)
		}
	}

	override fun recoverKeyPairs(recoveryKey: RecoveryDataKeyJs, autoDelete: Boolean):
			Promise<RecoveryResultJs<Record<String, Record<String, XRsaKeypair>>>> = GlobalScope.promise {
		val recoveryKeyConverted: RecoveryDataKey = recoveryDataKey_fromJs(recoveryKey)
		val autoDeleteConverted: Boolean = autoDelete
		val result = recoveryApi.recoverKeyPairs(
			recoveryKeyConverted,
			autoDeleteConverted,
		)
		recoveryResult_toJs(
			result,
			{ x1: Map<String, Map<SpkiHexString, RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm>>> ->
				mapToObject(
					x1,
					{ x2: String ->
						x2
					},
					{ x2: Map<SpkiHexString, RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm>> ->
						mapToObject(
							x2,
							{ x3: SpkiHexString ->
								spkiHexString_toJs(x3)
							},
							{ x3: RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm> ->
								x3.toExternal()
							},
						)
					},
				)
			},
		)
	}

	override fun recoverKeyPairsWaitingForCreation(
		recoveryKey: RecoveryDataKeyJs,
		autoDelete: Boolean,
		waitSeconds: Double,
	): CancellablePromise<RecoveryResultJs<Record<String, Record<String, XRsaKeypair>>>> =
			GlobalScope.cancellablePromise {
		val recoveryKeyConverted: RecoveryDataKey = recoveryDataKey_fromJs(recoveryKey)
		val autoDeleteConverted: Boolean = autoDelete
		val waitSecondsConverted: Int = numberToInt(waitSeconds, "waitSeconds")
		val result = recoveryApi.recoverKeyPairsWaitingForCreation(
			recoveryKeyConverted,
			autoDeleteConverted,
			waitSecondsConverted,
		)
		recoveryResult_toJs(
			result,
			{ x1: Map<String, Map<SpkiHexString, RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm>>> ->
				mapToObject(
					x1,
					{ x2: String ->
						x2
					},
					{ x2: Map<SpkiHexString, RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm>> ->
						mapToObject(
							x2,
							{ x3: SpkiHexString ->
								spkiHexString_toJs(x3)
							},
							{ x3: RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm> ->
								x3.toExternal()
							},
						)
					},
				)
			},
		)
	}

	override fun createExchangeDataRecoveryInfo(delegateId: String, options: dynamic):
			Promise<RecoveryDataKeyJs?> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val delegateIdConverted: String = delegateId
			val lifetimeSecondsConverted: Int? = convertingOptionOrDefaultNullable(
				_options,
				"lifetimeSeconds",
				null
			) { lifetimeSeconds: Double? ->
				numberToInt(lifetimeSeconds, "lifetimeSeconds")
			}
			val recoveryKeyOptionsConverted: RecoveryKeyOptions? = convertingOptionOrDefaultNullable(
				_options,
				"recoveryKeyOptions",
				null
			) { recoveryKeyOptions: RecoveryKeyOptionsJs? ->
				recoveryKeyOptions?.let { nonNull1 ->
					recoveryKeyOptions_fromJs(nonNull1)
				}
			}
			val includeBiDirectionalConverted: Boolean = convertingOptionOrDefaultNonNull(
				_options,
				"includeBiDirectional",
				false
			) { includeBiDirectional: Boolean ->
				includeBiDirectional
			}
			val includeAsParentConverted: Boolean = convertingOptionOrDefaultNonNull(
				_options,
				"includeAsParent",
				false
			) { includeAsParent: Boolean ->
				includeAsParent
			}
			val result = recoveryApi.createExchangeDataRecoveryInfo(
				delegateIdConverted,
				lifetimeSecondsConverted,
				recoveryKeyOptionsConverted,
				includeBiDirectionalConverted,
				includeAsParentConverted,
			)
			nullToUndefined(
				result?.let { nonNull1 ->
					recoveryDataKey_toJs(nonNull1)
				}
			)
		}
	}

	override fun recoverExchangeData(recoveryKey: RecoveryDataKeyJs): Promise<String?> =
			GlobalScope.promise {
		val recoveryKeyConverted: RecoveryDataKey = recoveryDataKey_fromJs(recoveryKey)
		val result = recoveryApi.recoverExchangeData(
			recoveryKeyConverted,
		)
		nullToUndefined(
			result?.let { nonNull1 ->
				nonNull1.name
			}
		)
	}

	override fun getRecoveryExchangeData(recoveryKey: RecoveryDataKeyJs, autoDelete: Boolean):
			Promise<RecoveryResultJs<Array<RawDecryptedExchangeDataJs>>> = GlobalScope.promise {
		val recoveryKeyConverted: RecoveryDataKey = recoveryDataKey_fromJs(recoveryKey)
		val autoDeleteConverted: Boolean = autoDelete
		val result = recoveryApi.getRecoveryExchangeData(
			recoveryKeyConverted,
			autoDeleteConverted,
		)
		recoveryResult_toJs(
			result,
			{ x1: List<RawDecryptedExchangeData> ->
				listToArray(
					x1,
					{ x2: RawDecryptedExchangeData ->
						rawDecryptedExchangeData_toJs(x2)
					},
				)
			},
		)
	}

	override fun purgeRecoveryInfo(recoveryKey: RecoveryDataKeyJs): Promise<Unit> =
			GlobalScope.promise {
		val recoveryKeyConverted: RecoveryDataKey = recoveryDataKey_fromJs(recoveryKey)
		recoveryApi.purgeRecoveryInfo(
			recoveryKeyConverted,
		)

	}

	override fun purgeAllRecoveryInfoFor(dataOwnerId: String): Promise<Double> = GlobalScope.promise {
		val dataOwnerIdConverted: String = dataOwnerId
		val result = recoveryApi.purgeAllRecoveryInfoFor(
			dataOwnerIdConverted,
		)
		intToNumber(result)
	}

	override fun purgeAllKeyPairRecoveryInfoFor(dataOwnerId: String): Promise<Double> =
			GlobalScope.promise {
		val dataOwnerIdConverted: String = dataOwnerId
		val result = recoveryApi.purgeAllKeyPairRecoveryInfoFor(
			dataOwnerIdConverted,
		)
		intToNumber(result)
	}

	override fun purgeAllExchangeDataRecoveryInfoFor(dataOwnerId: String): Promise<Double> =
			GlobalScope.promise {
		val dataOwnerIdConverted: String = dataOwnerId
		val result = recoveryApi.purgeAllExchangeDataRecoveryInfoFor(
			dataOwnerIdConverted,
		)
		intToNumber(result)
	}

	override fun preGenerateRecoveryKey(keySize: String): Promise<RecoveryDataKeyJs> =
			GlobalScope.promise {
		val keySizeConverted: RecoveryKeySize = RecoveryKeySize.valueOf(keySize)
		val result = recoveryApi.preGenerateRecoveryKey(
			keySizeConverted,
		)
		recoveryDataKey_toJs(result)
	}
}
