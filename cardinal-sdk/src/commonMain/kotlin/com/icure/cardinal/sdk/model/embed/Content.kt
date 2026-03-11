package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.serialization.ByteArraySerializer
import com.icure.cardinal.sdk.serialization.InstantSerializer
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.ByteArray
import kotlin.Double
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlin.time.Instant

/**
 * Represents the value content of a medical service. A content can hold different types of values
 * such as strings, numbers, dates, measurements, medications, time series, or compound
 * sub-services.
 * /
 */
public sealed interface Content {
	/**
	 * A string value.
	 */
	public val stringValue: String?

	/**
	 * A numeric value.
	 */
	public val numberValue: Double?

	/**
	 * A boolean value.
	 */
	public val booleanValue: Boolean?

	/**
	 * An instant value.
	 */
	public val instantValue: Instant?

	/**
	 * Value as a fuzzy date, which may contain day, month, and/or year components.
	 */
	public val fuzzyDateValue: Long?

	/**
	 * A binary value encoded as a byte array.
	 */
	public val binaryValue: ByteArray?

	/**
	 * The identifier of a linked document.
	 */
	public val documentId: String?

	/**
	 * Values of measurements recorded, including value, range, severity, and unit.
	 */
	public val measureValue: Measure?

	/**
	 * The details of prescribed or suggested medication.
	 */
	public val medicationValue: Medication?

	/**
	 * A high frequency time-series containing timestamps in ms and their values.
	 */
	public val timeSeries: TimeSeries?

	/**
	 * A list of sub-services forming a compound value.
	 */
	public val compoundValue: List<Service>?

	/**
	 * A list of measures representing a ratio.
	 */
	public val ratio: List<Measure>?

	/**
	 * A list of measures representing a range.
	 */
	public val range: List<Measure>?
}

/**
 * Represents the value content of a medical service. A content can hold different types of values
 * such as strings, numbers, dates, measurements, medications, time series, or compound
 * sub-services.
 * /
 */
@Serializable
public data class DecryptedContent(
	/**
	 * A string value.
	 */
	override val stringValue: String? = null,
	/**
	 * A numeric value.
	 */
	override val numberValue: Double? = null,
	/**
	 * A boolean value.
	 */
	override val booleanValue: Boolean? = null,
	/**
	 * An instant value.
	 */
	@Serializable(with = InstantSerializer::class)
	override val instantValue: Instant? = null,
	/**
	 * Value as a fuzzy date, which may contain day, month, and/or year components.
	 */
	override val fuzzyDateValue: Long? = null,
	/**
	 * A binary value encoded as a byte array.
	 */
	@Serializable(with = ByteArraySerializer::class)
	override val binaryValue: ByteArray? = null,
	/**
	 * The identifier of a linked document.
	 */
	override val documentId: String? = null,
	/**
	 * Values of measurements recorded, including value, range, severity, and unit.
	 */
	override val measureValue: Measure? = null,
	/**
	 * The details of prescribed or suggested medication.
	 */
	override val medicationValue: Medication? = null,
	/**
	 * A high frequency time-series containing timestamps in ms and their values.
	 */
	override val timeSeries: TimeSeries? = null,
	/**
	 * A list of sub-services forming a compound value.
	 */
	override val compoundValue: List<DecryptedService>? = null,
	/**
	 * A list of measures representing a ratio.
	 */
	override val ratio: List<Measure>? = null,
	/**
	 * A list of measures representing a range.
	 */
	override val range: List<Measure>? = null,
) : Content

/**
 * Represents the value content of a medical service. A content can hold different types of values
 * such as strings, numbers, dates, measurements, medications, time series, or compound
 * sub-services.
 * /
 */
@Serializable
public data class EncryptedContent(
	/**
	 * A string value.
	 */
	override val stringValue: String? = null,
	/**
	 * A numeric value.
	 */
	override val numberValue: Double? = null,
	/**
	 * A boolean value.
	 */
	override val booleanValue: Boolean? = null,
	/**
	 * An instant value.
	 */
	@Serializable(with = InstantSerializer::class)
	override val instantValue: Instant? = null,
	/**
	 * Value as a fuzzy date, which may contain day, month, and/or year components.
	 */
	override val fuzzyDateValue: Long? = null,
	/**
	 * A binary value encoded as a byte array.
	 */
	@Serializable(with = ByteArraySerializer::class)
	override val binaryValue: ByteArray? = null,
	/**
	 * The identifier of a linked document.
	 */
	override val documentId: String? = null,
	/**
	 * Values of measurements recorded, including value, range, severity, and unit.
	 */
	override val measureValue: Measure? = null,
	/**
	 * The details of prescribed or suggested medication.
	 */
	override val medicationValue: Medication? = null,
	/**
	 * A high frequency time-series containing timestamps in ms and their values.
	 */
	override val timeSeries: TimeSeries? = null,
	/**
	 * A list of sub-services forming a compound value.
	 */
	override val compoundValue: List<EncryptedService>? = null,
	/**
	 * A list of measures representing a ratio.
	 */
	override val ratio: List<Measure>? = null,
	/**
	 * A list of measures representing a range.
	 */
	override val range: List<Measure>? = null,
) : Content
