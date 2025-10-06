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

@JsName("OAuthAuthenticationDetails")
external class OAuthAuthenticationDetailsJs(
	secret: String,
	oauthType: String
) : AuthSecretDetailsJs {
	val secret: String
	val oauthType: String
}

@JsName("ExternalJwtAuthenticationDetails")
external class ExternalJwtAuthenticationDetailsJs(
    secret: String,
    configId: String
) : AuthSecretDetailsJs {
    val secret: String
    val configId: String
}

@JsName("DigitalIdDetails")
external class DigitalIdDetailsJs(
	secret: String
) : AuthSecretDetailsJs {
	val secret: String
}