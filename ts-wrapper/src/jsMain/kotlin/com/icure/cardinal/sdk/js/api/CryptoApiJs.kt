// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.crypto.entities.ExchangeDataInjectionDetailsJs
import com.icure.cardinal.sdk.js.crypto.entities.RawDecryptedExchangeDataJs
import com.icure.cardinal.sdk.js.utils.Record
import kotlin.Array
import kotlin.Boolean
import kotlin.ByteArray
import kotlin.String
import kotlin.Unit
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("CryptoApi")
public external interface CryptoApiJs {
	public val shamirKeysManager: ShamirKeysManagerApiJs

	public val inGroup: CryptoInGroupApiJs

	public fun getAccessControlKeys(entityType: String): Promise<Array<String>>

	public fun forceReload(): Promise<Unit>

	public fun currentDataOwnerKeys(options: dynamic):
			Promise<Record<String, Record<String, ByteArray>>>

	public fun keylessCreateExchangeDataTo(`delegate`: String): Promise<RawDecryptedExchangeDataJs>

	public fun injectExchangeData(
		groupId: String?,
		details: Array<ExchangeDataInjectionDetailsJs>,
		reEncryptWithOwnKeys: Boolean,
	): Promise<Unit>
}
