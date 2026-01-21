package com.icure.cardinal.sdk.model.security

import com.icure.cardinal.sdk.model.embed.AuthenticationClass
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames
import kotlin.String
import com.icure.cardinal.sdk.model.specializations.Base64String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class ExternalJwtConfig(
	public val validationMethod: ValidationMethod,
	public val fieldSelector: FieldSelector,
	@DefaultValue("com.icure.cardinal.sdk.model.embed.AuthenticationClass.ExternalAuthentication")
	public val authenticationClass: AuthenticationClass = AuthenticationClass.ExternalAuthentication,
) {
	@Serializable
	public sealed interface ValidationMethod {
		@Serializable
		@SerialName("PublicKey")
		public data class PublicKey(
			public val key: String,
			@DefaultValue("null")
			public val signatureAlgorithm: String? = null,
			public val clientId: String? = null,
		) : ValidationMethod

		@Serializable
		@SerialName("Oidc")
		public data class Oidc(
			@JsonNames("issureLocation")
			public val issuerLocation: String,
			public val clientId: String? = null,
		) : ValidationMethod
	}

	@Serializable
	public sealed interface FieldSelector {
		@Serializable
		@SerialName("LocalId")
		public data class LocalId(
			public val fieldName: String,
		) : FieldSelector

		@Serializable
		@SerialName("Email")
		public data class Email(
			public val fieldName: String,
		) : FieldSelector

		@Serializable
		@SerialName("MobilePhone")
		public data class MobilePhone(
			public val fieldName: String,
		) : FieldSelector

		@Serializable
		@SerialName("Username")
		public data class Username(
			public val fieldName: String,
		) : FieldSelector

		@Serializable
		@SerialName("Identifier")
		public data class Identifier(
			public val identifierAssigner: String,
			public val fieldName: String,
		) : FieldSelector
	}
	// region ExternalJwtConfig-ExternalJwtConfig

	// endregion
}
