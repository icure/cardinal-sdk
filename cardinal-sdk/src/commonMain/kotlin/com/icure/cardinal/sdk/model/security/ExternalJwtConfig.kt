package com.icure.cardinal.sdk.model.security

import com.icure.cardinal.sdk.model.embed.AuthenticationClass
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames
import kotlin.String

/**
 * Configuration for authenticating users via an externally-issued JWT. Specifies how the token
 * should be validated and which JWT field is used to locate the matching iCure user.
 * /
 */
@Serializable
public data class ExternalJwtConfig(
	/**
	 * The method used to verify the external JWT signature (public-key or OIDC discovery).
	 */
	public val validationMethod: ValidationMethod,
	/**
	 * The JWT field selector that identifies which user field to match against.
	 */
	public val fieldSelector: FieldSelector,
	/**
	 * The authentication class assigned to sessions created through this configuration.
	 */
	@param:DefaultValue("com.icure.cardinal.sdk.model.embed.AuthenticationClass.ExternalAuthentication")
	public val authenticationClass: AuthenticationClass = AuthenticationClass.ExternalAuthentication,
) {
	/**
	 * Sealed interface representing the strategy used to validate the external JWT signature.
	 * /
	 */
	@Serializable
	public sealed interface ValidationMethod {
		/**
		 * Validates the JWT using a static public key.
		 * /
		 */
		@Serializable
		@SerialName("PublicKey")
		public data class PublicKey(
			/**
			 * The PEM-encoded or Base64-encoded public key material.
			 */
			public val key: String,
			/**
			 * The signature algorithm to use; defaults to the algorithm declared in the JWT header when
			 * null.
			 */
			@param:DefaultValue("null")
			public val signatureAlgorithm: String? = null,
			/**
			 * An optional client identifier to verify against the JWT audience claim.
			 */
			public val clientId: String? = null,
		) : ValidationMethod

		/**
		 *
		 *  Validates the JWT using OIDC discovery from the specified issuer location.
		 */
		@Serializable
		@SerialName("Oidc")
		public data class Oidc(
			/**
			 * The OIDC issuer URL used to retrieve the JWKS for signature verification.
			 */
			@JsonNames("issureLocation")
			public val issuerLocation: String,
			/**
			 * An optional client identifier to verify against the JWT audience claim.
			 */
			public val clientId: String? = null,
		) : ValidationMethod
	}

	/**
	 * Sealed interface representing the strategy used to extract the user-matching value from the
	 * external JWT claims.
	 * /
	 */
	@Serializable
	public sealed interface FieldSelector {
		/**
		 *
		 *  Selects users by matching a JWT field against the user's local identifier.
		 */
		@Serializable
		@SerialName("LocalId")
		public data class LocalId(
			/**
			 * The name of the JWT claim containing the local identifier value.
			 */
			public val fieldName: String,
		) : FieldSelector

		/**
		 *
		 *  Selects users by matching a JWT field against the user's email address.
		 */
		@Serializable
		@SerialName("Email")
		public data class Email(
			/**
			 * The name of the JWT claim containing the email value.
			 */
			public val fieldName: String,
		) : FieldSelector

		/**
		 *
		 *  Selects users by matching a JWT field against the user's mobile phone number.
		 */
		@Serializable
		@SerialName("MobilePhone")
		public data class MobilePhone(
			/**
			 * The name of the JWT claim containing the mobile phone value.
			 */
			public val fieldName: String,
		) : FieldSelector

		/**
		 *
		 *  Selects users by matching a JWT field against the user's username.
		 */
		@Serializable
		@SerialName("Username")
		public data class Username(
			/**
			 * The name of the JWT claim containing the username value.
			 */
			public val fieldName: String,
		) : FieldSelector

		/**
		 *
		 *  Selects users by matching a JWT field against a structured identifier with a specific
		 * assigner.
		 */
		@Serializable
		@SerialName("Identifier")
		public data class Identifier(
			/**
			 * The assigner system for the identifier to match against.
			 */
			public val identifierAssigner: String,
			/**
			 * The name of the JWT claim containing the identifier value.
			 */
			public val fieldName: String,
		) : FieldSelector
	}
}
