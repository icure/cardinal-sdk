@file:JsQualifier("options.AuthenticationMethod.UsingCredentials")
package com.icure.cardinal.sdk.js.options.external
@JsName("UsernamePassword")
external class AuthenticationMethodUsingCredentialsUsernamePasswordJs : AuthenticationMethodJs {
	val username: String
	val password: String
}
@JsName("UsernameLongToken")
external class AuthenticationMethodUsingCredentialsUsernameLongTokenJs : AuthenticationMethodJs {
	val username: String
	val token: String
}
@JsName("ExternalAuthenticationToken")
external class AuthenticationMethodUsingCredentialsExternalAuthenticationTokenJs : AuthenticationMethodJs {
	val configId: String
	val token: String
	val minimumAuthenticationClass: String?
}
@JsName("JwtCredentials")
external class AuthenticationMethodUsingCredentialsJwtCredentialsJs : AuthenticationMethodJs {
	val refresh: String
	val bearer: String?
}