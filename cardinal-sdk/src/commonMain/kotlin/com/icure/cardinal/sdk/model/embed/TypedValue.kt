package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.model.specializations.Base64String
import com.icure.cardinal.sdk.serialization.InstantSerializer
import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Double
import kotlin.Long
import kotlin.String
import kotlin.time.Instant

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
sealed interface TypedValue : Encryptable {
	public val type: TypedValuesType?

	public val booleanValue: Boolean?

	public val integerValue: Long?

	public val doubleValue: Double?

	public val stringValue: String?

	public val dateValue: Instant?

	override val encryptedSelf: Base64String?
	// region TypedValue-TypedValue

	// endregion
}

@Serializable
data class DecryptedTypedValue(
	override val type: TypedValuesType? = null,
	override val booleanValue: Boolean? = null,
	override val integerValue: Long? = null,
	override val doubleValue: Double? = null,
	override val stringValue: String? = null,
	@Serializable(with = InstantSerializer::class)
	override val dateValue: Instant? = null,
	override val encryptedSelf: Base64String? = null,
) : TypedValue {
	// region TypedValue-DecryptedTypedValue

	// endregion
}

@Serializable
data class EncryptedTypedValue(
	override val type: TypedValuesType? = null,
	override val booleanValue: Boolean? = null,
	override val integerValue: Long? = null,
	override val doubleValue: Double? = null,
	override val stringValue: String? = null,
	@Serializable(with = InstantSerializer::class)
	override val dateValue: Instant? = null,
	override val encryptedSelf: Base64String? = null,
) : TypedValue {
	// region TypedValue-EncryptedTypedValue

	// endregion
}
