package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.model.specializations.Base64String
import com.icure.cardinal.sdk.serialization.InstantSerializer
import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Double
import kotlin.Long
import kotlin.String

public sealed interface TypedValue : Encryptable {
	public val type: TypedValuesType?

	public val booleanValue: Boolean?

	public val integerValue: Long?

	public val doubleValue: Double?

	public val stringValue: String?

	public val dateValue: Instant?

	override val encryptedSelf: Base64String?
}

@Serializable
public data class DecryptedTypedValue(
	override val type: TypedValuesType? = null,
	override val booleanValue: Boolean? = null,
	override val integerValue: Long? = null,
	override val doubleValue: Double? = null,
	override val stringValue: String? = null,
	@Serializable(with = InstantSerializer::class)
	override val dateValue: Instant? = null,
	override val encryptedSelf: Base64String? = null,
) : TypedValue

@Serializable
public data class EncryptedTypedValue(
	override val type: TypedValuesType? = null,
	override val booleanValue: Boolean? = null,
	override val integerValue: Long? = null,
	override val doubleValue: Double? = null,
	override val stringValue: String? = null,
	@Serializable(with = InstantSerializer::class)
	override val dateValue: Instant? = null,
	override val encryptedSelf: Base64String? = null,
) : TypedValue
