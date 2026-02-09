// auto-generated file
@file:JsQualifier("model.ExternalJwtConfig.ValidationMethod")

package com.icure.cardinal.sdk.js.model.security

import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("PublicKey")
public external class ExternalJwtConfigJs_ValidationMethodJs_PublicKeyJs(
	partial: dynamic,
) : ExternalJwtConfigJs_ValidationMethodJs {
	public val key: String

	public val signatureAlgorithm: String?

	public val clientId: String?

	override val ktClass: String
}

@JsName("Oidc")
public external class ExternalJwtConfigJs_ValidationMethodJs_OidcJs(
	partial: dynamic,
) : ExternalJwtConfigJs_ValidationMethodJs {
	public val issuerLocation: String

	public val clientId: String?

	override val ktClass: String
}
