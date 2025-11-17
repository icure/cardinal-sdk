// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.crypto.entities.RawDecryptedExchangeDataJs
import com.icure.cardinal.sdk.js.crypto.entities.RecoveryDataKeyJs
import com.icure.cardinal.sdk.js.crypto.entities.RecoveryResultJs
import com.icure.cardinal.sdk.js.utils.CancellablePromise
import com.icure.cardinal.sdk.js.utils.Record
import com.icure.kryptom.crypto.`external`.XRsaKeypair
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.Unit
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("RecoveryApi")
public external interface RecoveryApiJs {
	public fun createRecoveryInfoForAvailableKeyPairs(options: dynamic): Promise<RecoveryDataKeyJs>

	public fun recoverKeyPairs(recoveryKey: RecoveryDataKeyJs, autoDelete: Boolean):
			Promise<RecoveryResultJs<Record<String, Record<String, XRsaKeypair>>>>

	public fun recoverKeyPairsWaitingForCreation(
		recoveryKey: RecoveryDataKeyJs,
		autoDelete: Boolean,
		waitSeconds: Double,
	): CancellablePromise<RecoveryResultJs<Record<String, Record<String, XRsaKeypair>>>>

	public fun createExchangeDataRecoveryInfo(delegateId: String, options: dynamic):
			Promise<RecoveryDataKeyJs?>

	public fun recoverExchangeData(recoveryKey: RecoveryDataKeyJs): Promise<String?>

	public fun getRecoveryExchangeData(recoveryKey: RecoveryDataKeyJs, autoDelete: Boolean):
			Promise<RecoveryResultJs<Array<RawDecryptedExchangeDataJs>>>

	public fun purgeRecoveryInfo(recoveryKey: RecoveryDataKeyJs): Promise<Unit>

	public fun purgeAllRecoveryInfoFor(dataOwnerId: String): Promise<Double>

	public fun purgeAllKeyPairRecoveryInfoFor(dataOwnerId: String): Promise<Double>

	public fun purgeAllExchangeDataRecoveryInfoFor(dataOwnerId: String): Promise<Double>

	public fun preGenerateRecoveryKey(keySize: String): Promise<RecoveryDataKeyJs>
}
