// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.model.specializations.Base64String
import com.icure.cardinal.sdk.serialization.InstantSerializer
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Double
import kotlin.Long
import kotlin.String
import kotlin.time.Instant

/**
 * Represents a typed value that can hold one of several primitive types (boolean, integer, double,
 * string, or date).
 * The actual value is stored in the corresponding typed field based on the [type].
 * /
 */

sealed interface TypedValue : Encryptable {
	/**
	 * The type of the value stored.
	 */
	public val type: TypedValuesType?

	/**
	 * The boolean value, if type is BOOLEAN.
	 */
	public val booleanValue: Boolean?

	/**
	 * The integer value, if type is INTEGER.
	 */
	public val integerValue: Long?

	/**
	 * The double value, if type is DOUBLE.
	 */
	public val doubleValue: Double?

	/**
	 * The string value, if type is STRING, JSON, or CLOB.
	 */
	public val stringValue: String?

	/**
	 * The date value as an Instant, if type is DATE.
	 */
	public val dateValue: Instant?

	/**
	 * The base64-encoded encrypted content.
	 */
	override val encryptedSelf: Base64String?
	// region TypedValue-TypedValue

	// endregion
}

/**
 * Represents a typed value that can hold one of several primitive types (boolean, integer, double,
 * string, or date).
 * The actual value is stored in the corresponding typed field based on the [type].
 * /
 */
@Serializable
data class DecryptedTypedValue(
	/**
	 * The type of the value stored.
	 */
	override val type: TypedValuesType? = null,
	/**
	 * The boolean value, if type is BOOLEAN.
	 */
	override val booleanValue: Boolean? = null,
	/**
	 * The integer value, if type is INTEGER.
	 */
	override val integerValue: Long? = null,
	/**
	 * The double value, if type is DOUBLE.
	 */
	override val doubleValue: Double? = null,
	/**
	 * The string value, if type is STRING, JSON, or CLOB.
	 */
	override val stringValue: String? = null,
	/**
	 * The date value as an Instant, if type is DATE.
	 */
	@Serializable(with = InstantSerializer::class)
	override val dateValue: Instant? = null,
	/**
	 * The base64-encoded encrypted content.
	 */
	override val encryptedSelf: Base64String? = null,
) : TypedValue {
	// region TypedValue-DecryptedTypedValue

	// endregion
}

/**
 * Represents a typed value that can hold one of several primitive types (boolean, integer, double,
 * string, or date).
 * The actual value is stored in the corresponding typed field based on the [type].
 * /
 */
@Serializable
data class EncryptedTypedValue(
	/**
	 * The type of the value stored.
	 */
	override val type: TypedValuesType? = null,
	/**
	 * The boolean value, if type is BOOLEAN.
	 */
	override val booleanValue: Boolean? = null,
	/**
	 * The integer value, if type is INTEGER.
	 */
	override val integerValue: Long? = null,
	/**
	 * The double value, if type is DOUBLE.
	 */
	override val doubleValue: Double? = null,
	/**
	 * The string value, if type is STRING, JSON, or CLOB.
	 */
	override val stringValue: String? = null,
	/**
	 * The date value as an Instant, if type is DATE.
	 */
	@Serializable(with = InstantSerializer::class)
	override val dateValue: Instant? = null,
	/**
	 * The base64-encoded encrypted content.
	 */
	override val encryptedSelf: Base64String? = null,
) : TypedValue {
	// region TypedValue-EncryptedTypedValue

	// endregion
}
