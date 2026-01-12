// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.crypto.entities.RawDecryptedExchangeDataJs
import com.icure.cardinal.sdk.js.model.EntityReferenceInGroupJs
import kotlin.Array
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("CryptoInGroupApi")
public external interface CryptoInGroupApiJs {
	public fun keylessCreateExchangeDataTo(groupId: String?, `delegate`: EntityReferenceInGroupJs):
			Promise<RawDecryptedExchangeDataJs>

	public fun getAccessControlKeys(groupId: String?, entityType: String): Promise<Array<String>>
}
