@file:JsQualifier("crypto")
package com.icure.cardinal.sdk.js.crypto

import com.icure.cardinal.sdk.js.crypto.entities.RecoveryDataKeyJs
import com.icure.cardinal.sdk.js.crypto.entities.RecoveryResultJs
import com.icure.cardinal.sdk.js.externalsdk.CardinalApisJs
import com.icure.cardinal.sdk.js.model.CryptoActorStubWithTypeJs
import com.icure.cardinal.sdk.js.model.DataOwnerWithTypeJs
import com.icure.cardinal.sdk.js.utils.Record
import com.icure.cardinal.sdk.model.DataOwnerWithType
import com.icure.cardinal.sdk.model.specializations.SpkiHexString
import com.icure.kryptom.crypto.RsaAlgorithm
import com.icure.kryptom.crypto.RsaKeypair
import com.icure.kryptom.crypto.external.XCryptoService
import com.icure.kryptom.crypto.external.XRsaKeypair
import kotlin.js.Promise

@JsName("CryptoStrategies")
external interface CryptoStrategiesJs {
	fun recoverAndVerifySelfHierarchyKeys(
		currentDataOwnerId: String,
		keysData: Record<String, KeyDataRecoveryRequestJs>,
		cryptoPrimitives: XCryptoService,
		keyPairRecoverer: KeyPairRecovererJs
	): Promise<Record<String, RecoveredKeyDataJs>>

	fun generateNewKeyForDataOwner(
		self: DataOwnerWithTypeJs,
		cryptoPrimitives: XCryptoService
	): Promise<KeyGenerationRequestResultJs>

	fun verifyDelegatePublicKeys(
		delegate: CryptoActorStubWithTypeJs,
		publicKeys: Array<String>,
		cryptoPrimitives: XCryptoService,
		groupId: String?
	): Promise<Array<String>>

	// { [delegateId: string]: { [publicKey: SpkiHexString]: RsaEncryptionAlgorithm } } | undefined
	fun getDelegatesPublicKeys(
		delegates: Array<String>,
		groupId: String?,
	): Promise<Record<String, Record<String, String>>?>

	fun dataOwnerRequiresAnonymousDelegation(
		dataOwner: CryptoActorStubWithTypeJs,
		groupId: String?
	): Promise<Boolean>

	fun notifyNewKeyCreated(
		apis: CardinalApisJs,
		key: XRsaKeypair,
		cryptoPrimitives: XCryptoService,
	): Promise<Unit>
}

@JsName("KeyPairRecoverer")
external interface KeyPairRecovererJs {
	fun recoverWithRecoveryKey(
		recoveryKey: RecoveryDataKeyJs,
		autoDelete: Boolean
	): Promise<RecoveryResultJs<Record<String, Record<String, XRsaKeypair>>>>

	fun getRecoverableWithEncryptionKeys(
		dataOwner: DataOwnerWithTypeJs,
		recoveredKeys: Array<XRsaKeypair>
	): Promise<Array<String>>
}