package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.serialization.ByteArraySerializer
import com.icure.cardinal.sdk.serialization.InstantSerializer
import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.ByteArray
import kotlin.Double
import kotlin.Long
import kotlin.String
import kotlin.collections.List

public sealed interface Content {
	public val stringValue: String?

	public val numberValue: Double?

	public val booleanValue: Boolean?

	public val instantValue: Instant?

	public val fuzzyDateValue: Long?

	public val binaryValue: ByteArray?

	public val documentId: String?

	public val measureValue: Measure?

	public val medicationValue: Medication?

	public val timeSeries: TimeSeries?

	public val compoundValue: List<Service>?

	public val ratio: List<Measure>?

	public val range: List<Measure>?
}

@Serializable
public data class DecryptedContent(
	override val stringValue: String? = null,
	override val numberValue: Double? = null,
	override val booleanValue: Boolean? = null,
	@Serializable(with = InstantSerializer::class)
	override val instantValue: Instant? = null,
	override val fuzzyDateValue: Long? = null,
	@Serializable(with = ByteArraySerializer::class)
	override val binaryValue: ByteArray? = null,
	override val documentId: String? = null,
	override val measureValue: Measure? = null,
	override val medicationValue: Medication? = null,
	override val timeSeries: TimeSeries? = null,
	override val compoundValue: List<DecryptedService>? = null,
	override val ratio: List<Measure>? = null,
	override val range: List<Measure>? = null,
) : Content

@Serializable
public data class EncryptedContent(
	override val stringValue: String? = null,
	override val numberValue: Double? = null,
	override val booleanValue: Boolean? = null,
	@Serializable(with = InstantSerializer::class)
	override val instantValue: Instant? = null,
	override val fuzzyDateValue: Long? = null,
	@Serializable(with = ByteArraySerializer::class)
	override val binaryValue: ByteArray? = null,
	override val documentId: String? = null,
	override val measureValue: Measure? = null,
	override val medicationValue: Medication? = null,
	override val timeSeries: TimeSeries? = null,
	override val compoundValue: List<EncryptedService>? = null,
	override val ratio: List<Measure>? = null,
	override val range: List<Measure>? = null,
) : Content
