// auto-generated file
package com.icure.cardinal.sdk.js.model.security

import com.icure.cardinal.sdk.js.model.CheckedConverters.intToNumber
import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToInt
import com.icure.cardinal.sdk.model.security.Enable2faRequest
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun enable2faRequest_toJs(obj: Enable2faRequest): Enable2faRequestJs {
	val secret = obj.secret
	val otpLength = intToNumber(obj.otpLength)
	val otp = obj.otp
	val algorithm = nullToUndefined(
		obj.algorithm?.let { nonNull1 ->
			nonNull1.name
		}
	)
	return Enable2faRequestJs(js("{" +
		"secret:secret," +
		"otpLength:otpLength," +
		"otp:otp," +
		"algorithm:algorithm" +
	"}"))
}

public fun enable2faRequest_fromJs(obj: Enable2faRequestJs): Enable2faRequest {
	val secret = obj.secret
	val otpLength = numberToInt(obj.otpLength, "obj.otpLength")
	val otp = obj.otp
	val algorithm = obj.algorithm?.let { nonNull1 ->
		Enable2faRequest.Algorithm.valueOf(nonNull1)
	}
	return Enable2faRequest(
		secret = secret,
		otpLength = otpLength,
		otp = otp,
		algorithm = algorithm,
	)
}
