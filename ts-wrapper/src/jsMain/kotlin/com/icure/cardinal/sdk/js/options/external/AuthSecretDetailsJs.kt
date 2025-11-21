@file:JsQualifier("options.AuthSecretDetails")
package com.icure.cardinal.sdk.js.options.external

@JsName("PasswordDetails")
external class PasswordDetailsJs(
	secret: String
) : AuthSecretDetailsJs {
	val secret: String
}

@JsName("TwoFactorAuthTokenDetails")
external class TwoFactorAuthTokenDetailsJs(
	secret: String
) : AuthSecretDetailsJs {
	val secret: String
}

@JsName("ShortLivedTokenDetails")
external class ShortLivedTokenDetailsJs(
	secret: String,
	authenticationProcessInfo: AuthenticationProcessRequestJs
) : AuthSecretDetailsJs {
	val secret: String
	val authenticationProcessInfo: AuthenticationProcessRequestJs
}

@JsName("LongLivedTokenDetails")
external class LongLivedTokenDetailsJs(
	secret: String
) : AuthSecretDetailsJs {
	val secret: String
}

@JsName("ConfiguredExternalAuthenticationDetails")
external class ConfiguredExternalAuthenticationDetailsJs(
	configId: String,
	secret: String,
	minimumAuthenticationClass: String?,
) : AuthSecretDetailsJs {
	val configId: String
	val secret: String
	val minimumAuthenticationClass: String?
}
