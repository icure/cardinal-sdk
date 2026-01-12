package com.icure.cardinal.sdk.js.crypto

import com.icure.cardinal.sdk.CardinalApis
import com.icure.cardinal.sdk.crypto.CryptoStrategies
import com.icure.cardinal.sdk.crypto.KeyPairRecoverer
import com.icure.cardinal.sdk.js.CardinalApisJsImpl
import com.icure.cardinal.sdk.js.crypto.entities.RecoveryDataKeyJs
import com.icure.cardinal.sdk.js.crypto.entities.RecoveryResultJs
import com.icure.cardinal.sdk.js.crypto.entities.recoveryDataKey_fromJs
import com.icure.cardinal.sdk.js.crypto.entities.recoveryResult_toJs
import com.icure.cardinal.sdk.js.model.CheckedConverters
import com.icure.cardinal.sdk.js.model.DataOwnerWithTypeJs
import com.icure.cardinal.sdk.js.model.cryptoActorStubWithType_toJs
import com.icure.cardinal.sdk.js.model.dataOwnerWithType_fromJs
import com.icure.cardinal.sdk.js.model.dataOwnerWithType_toJs
import com.icure.cardinal.sdk.js.utils.Record
import com.icure.cardinal.sdk.model.CryptoActorStubWithType
import com.icure.cardinal.sdk.model.DataOwnerWithType
import com.icure.cardinal.sdk.model.specializations.KeypairFingerprintV1String
import com.icure.cardinal.sdk.model.specializations.SpkiHexString
import com.icure.kryptom.crypto.CryptoService
import com.icure.kryptom.crypto.RsaAlgorithm
import com.icure.kryptom.crypto.RsaKeypair
import com.icure.kryptom.crypto.external.XCryptoService
import com.icure.kryptom.crypto.external.XRsaKeypair
import com.icure.kryptom.crypto.external.toExternal
import com.icure.kryptom.crypto.external.toKryptom
import com.icure.kryptom.crypto.external.toKryptomEncryption
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.await
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.promise
import kotlin.js.Promise

internal class CryptoStrategiesBridge(
	private val cryptoStrategiesJs: CryptoStrategiesJs,
	private val xCryptoService: XCryptoService
) : CryptoStrategies {
	override suspend fun recoverAndVerifySelfHierarchyKeys(
		keysData: List<CryptoStrategies.KeyDataRecoveryRequest>,
		cryptoPrimitives: CryptoService,
		keyPairRecoverer: KeyPairRecoverer
	): Map<String, CryptoStrategies.RecoveredKeyData> =
		coroutineScope {
			val jsResult = cryptoStrategiesJs.recoverAndVerifySelfHierarchyKeys(
				keysData.map { it.toJs() }.toTypedArray(),
				xCryptoService,
				KeyPairRecovererBridge(keyPairRecoverer, this)
			).await()
			CheckedConverters.objectToMap(
				jsResult,
				"recoverAndVerifySelfHierarchyKeys result",
				{ it },
				{ it.toKt() }
			)
		}

	override suspend fun generateNewKeyForDataOwner(
		self: DataOwnerWithType,
		cryptoPrimitives: CryptoService
	): CryptoStrategies.KeyGenerationRequestResult {
		val jsResult = cryptoStrategiesJs.generateNewKeyForDataOwner(
			dataOwnerWithType_toJs(self),
			xCryptoService
		).await()
		@Suppress("UNCHECKED_CAST_TO_EXTERNAL_INTERFACE")
		return when {
			jsResult === true ->
				CryptoStrategies.KeyGenerationRequestResult.Allow
			jsResult === false ->
				CryptoStrategies.KeyGenerationRequestResult.Deny
			jsResult === "keyless" ->
				CryptoStrategies.KeyGenerationRequestResult.Keyless
			jsResult === "parent-delegator" ->
				CryptoStrategies.KeyGenerationRequestResult.ParentDelegator
			jsTypeOf(jsResult.public) === "object" && jsTypeOf(jsResult.private) === "object" -> {
				val xKeypair = jsResult as XRsaKeypair
				require(xKeypair.private.algorithm == RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha256.identifier) {
					"Newly generated key should be for OaepWithSha256"
				}
				CryptoStrategies.KeyGenerationRequestResult.Use(xKeypair.toKryptom(RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha256))
			}
			else ->
				throw IllegalArgumentException("Unexpected value received from generateNewKeyForDataOwner: only boolean, the string \"keyless\" or a key are accepted. $jsResult")
		}
	}

	override suspend fun verifyDelegatePublicKeys(
		delegate: CryptoActorStubWithType,
		publicKeys: List<SpkiHexString>,
		cryptoPrimitives: CryptoService,
		groupId: String?
	): List<SpkiHexString> =
		cryptoStrategiesJs.verifyDelegatePublicKeys(
			cryptoActorStubWithType_toJs(delegate),
			publicKeys.map { it.s }.toTypedArray(),
			xCryptoService,
			groupId
		).await().map { SpkiHexString(it) }

	override suspend fun dataOwnerRequiresAnonymousDelegation(
		dataOwner: CryptoActorStubWithType,
		groupId: String?
	): Boolean =
		cryptoStrategiesJs.dataOwnerRequiresAnonymousDelegation(cryptoActorStubWithType_toJs(dataOwner), groupId).await()

	override suspend fun notifyNewKeyCreated(
		apis: CardinalApis,
		key: RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha256>,
		cryptoPrimitives: CryptoService
	) {
		cryptoStrategiesJs.notifyNewKeyCreated(
			CardinalApisJsImpl(apis),
			key.toExternal(),
			xCryptoService
		)
	}
}

private class KeyPairRecovererBridge(
	private val recoverer: KeyPairRecoverer,
	private val scope: CoroutineScope
): KeyPairRecovererJs {
	override fun recoverWithRecoveryKey(
		recoveryKey: RecoveryDataKeyJs,
		autoDelete: Boolean
	): Promise<RecoveryResultJs<Record<String, Record<String, XRsaKeypair>>>> = scope.promise {
		val ktResult = recoverer.recoverWithRecoveryKey(
			recoveryDataKey_fromJs(recoveryKey),
			autoDelete
		)
		recoveryResult_toJs(ktResult) { byDataOwnerMap ->
			CheckedConverters.mapToObject(
				byDataOwnerMap,
				{ it },
				{ byPublicKeyMap ->
					CheckedConverters.mapToObject(
						byPublicKeyMap,
						{ it.s },
						{ it.toExternal() }
					)
				}
			)
		}
	}

	override fun getRecoverableWithEncryptionKeys(
		dataOwner: DataOwnerWithTypeJs,
		recoveredKeys: Array<XRsaKeypair>
	): Promise<Array<String>> = scope.promise {
		val ktResult = recoverer.getRecoverableWithEncryptionKeys(
			dataOwnerWithType_fromJs(dataOwner),
			recoveredKeys.map { it.toKryptom(RsaAlgorithm.RsaEncryptionAlgorithm.fromIdentifier(it.private.algorithm)) },
		)
		CheckedConverters.setToArray(ktResult) { it.s }
	}
}

private fun CryptoStrategies.UnavailableKeyInfo.toJs(): UnavailableKeyInfoJs {
	val publicKeyJs = publicKey.s
	val keyAlgorithmJs = keyAlgorithm.identifier
	@Suppress("UNCHECKED_CAST_TO_EXTERNAL_INTERFACE")
	return js("{ publicKey: publicKeyJs, keyAlgorithm: keyAlgorithmJs }") as UnavailableKeyInfoJs
}

private fun CryptoStrategies.KeyDataRecoveryRequest.toJs(): KeyDataRecoveryRequestJs {
	val dataOwnerDetails = dataOwnerWithType_toJs(this.dataOwnerDetails)
	val unknownKeys = this.unknownKeys.map { it.s }.toTypedArray()
	val unavailableKeys = this.unavailableKeys.map { it.toJs() }.toTypedArray()
	@Suppress("UNCHECKED_CAST_TO_EXTERNAL_INTERFACE")
	return js("{ dataOwnerDetails: dataOwnerDetails, unknownKeys: unknownKeys, unavailableKeys: unavailableKeys}") as KeyDataRecoveryRequestJs
}
private fun RecoveredKeyDataJs.toKt() = CryptoStrategies.RecoveredKeyData(
	recoveredKeys = convertRecoveryKeyDataEntry(
		recoveredKeys,
		"recoveredKeys"
	) { RsaKeypair(it.private.toKryptomEncryption(), it.public.toKryptomEncryption()) },
	keyAuthenticity = convertRecoveryKeyDataEntry(
		keyAuthenticity,
		"keyAuthenticity"
	) { it }
)
private fun <V_JS, V_KT> convertRecoveryKeyDataEntry(
	data: Record<String, V_JS>,
	name: String,
	convertValue: (V_JS) -> V_KT
) = CheckedConverters.objectToMap(
	data,
	"RecoveredKeyData.$name",
	{ it },
	convertValue
).let { mapByString ->
	mapByString.mapKeys { (key, _) ->
		if (key.length > KeypairFingerprintV1String.LENGTH) {
			key.takeLast(32).also {
				require (!mapByString.containsKey(it)) {
					"Duplicate entry for key in RecoveredKeyData.$name, existing both as fingerprint and in full format: $it"
				}
			}.let(::KeypairFingerprintV1String)
		} else KeypairFingerprintV1String(key)
	}
}