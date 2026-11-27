@file:JsQualifier("options.AuthenticationProcessRequest")
package com.icure.cardinal.sdk.js.options.external

@JsName("MessageGateway")
external class AuthenticationProcessRequestMessageGatewayJs(
	messageGwUrl: String,
	specId: String,
	requestId: String,
) : AuthenticationProcessRequestJs {
	val messageGwUrl: String
	val specId: String
	override val requestId: String
}

@JsName("Khermes")
external class AuthenticationProcessRequestKhermesJs(
	khermesUrl: String,
	processId: String,
	requestId: String,
) : AuthenticationProcessRequestJs {
	val khermesUrl: String
	val processId: String
	override val requestId: String
}
