@file:JsQualifier("sdk.CardinalBaseSdk")
package com.icure.cardinal.sdk.js.externalsdk

import kotlin.js.Promise

@JsName("BaseAuthenticationWithProcessStep")
external interface BaseAuthenticationWithProcessStepJs {
	fun completeAuthentication(validationCode: String): Promise<CardinalBaseSdkJs>
}

