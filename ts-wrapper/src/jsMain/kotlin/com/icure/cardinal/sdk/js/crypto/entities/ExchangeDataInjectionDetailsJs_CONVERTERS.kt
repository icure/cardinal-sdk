// auto-generated file
package com.icure.cardinal.sdk.js.crypto.entities

import com.icure.cardinal.sdk.crypto.entities.ExchangeDataInjectionDetails
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun exchangeDataInjectionDetails_toJs(obj: ExchangeDataInjectionDetails): ExchangeDataInjectionDetailsJs {
	val exchangeDataId = obj.exchangeDataId
	val accessControlSecret = obj.accessControlSecret
	val exchangeKey = obj.exchangeKey
	val sharedSignatureKey = obj.sharedSignatureKey
	val verified = obj.verified
	return ExchangeDataInjectionDetailsJs(js("{" +
		"exchangeDataId:exchangeDataId," +
		"accessControlSecret:accessControlSecret," +
		"exchangeKey:exchangeKey," +
		"sharedSignatureKey:sharedSignatureKey," +
		"verified:verified" +
	"}"))
}

public fun exchangeDataInjectionDetails_fromJs(obj: ExchangeDataInjectionDetailsJs): ExchangeDataInjectionDetails {
	val exchangeDataId = obj.exchangeDataId
	val accessControlSecret = obj.accessControlSecret
	val exchangeKey = obj.exchangeKey
	val sharedSignatureKey = obj.sharedSignatureKey
	val verified = obj.verified
	return ExchangeDataInjectionDetails(
		exchangeDataId = exchangeDataId,
		accessControlSecret = accessControlSecret,
		exchangeKey = exchangeKey,
		sharedSignatureKey = sharedSignatureKey,
		verified = verified,
	)
}
