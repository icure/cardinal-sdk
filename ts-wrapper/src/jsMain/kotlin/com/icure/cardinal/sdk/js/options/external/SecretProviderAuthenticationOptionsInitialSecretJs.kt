@file:JsQualifier("options.SecretProviderAuthenticationOptions.InitialSecret")
package com.icure.cardinal.sdk.js.options.external

@JsName("Password")
external class InitialSecretPasswordJs : InitialSecretJs {
	val password: String
}

@JsName("LongLivedToken")
external class InitialSecretLongLivedTokenJs : InitialSecretJs {
	val token: String
}

@JsName("ExternalAuthenticationToken")
external class ExternalAuthenticationTokenJs : InitialSecretJs {
	val token: String
	val configId: String
}
