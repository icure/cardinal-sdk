// auto-generated file
package com.icure.cardinal.sdk.js.crypto.entities

import com.icure.cardinal.sdk.crypto.entities.RawDecryptedExchangeData
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun rawDecryptedExchangeData_toJs(obj: RawDecryptedExchangeData): RawDecryptedExchangeDataJs {
	val exchangeDataId = obj.exchangeDataId
	val exchangeKey = obj.exchangeKey
	val accessControlSecret = obj.accessControlSecret
	val sharedSignatureKey = obj.sharedSignatureKey
	return RawDecryptedExchangeDataJs(js("{" +
		"exchangeDataId:exchangeDataId," +
		"exchangeKey:exchangeKey," +
		"accessControlSecret:accessControlSecret," +
		"sharedSignatureKey:sharedSignatureKey" +
	"}"))
}

public fun rawDecryptedExchangeData_fromJs(obj: RawDecryptedExchangeDataJs): RawDecryptedExchangeData {
	val exchangeDataId = obj.exchangeDataId
	val exchangeKey = obj.exchangeKey
	val accessControlSecret = obj.accessControlSecret
	val sharedSignatureKey = obj.sharedSignatureKey
	return RawDecryptedExchangeData(
		exchangeDataId = exchangeDataId,
		exchangeKey = exchangeKey,
		accessControlSecret = accessControlSecret,
		sharedSignatureKey = sharedSignatureKey,
	)
}
