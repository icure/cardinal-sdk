// auto-generated file
@file:JsQualifier("model")

package com.icure.cardinal.sdk.js.model.embed

import kotlin.Array
import kotlin.Boolean
import kotlin.ByteArray
import kotlin.Double
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("Content")
public sealed external interface ContentJs : EncryptableJs {
	public val stringValue: String?

	public val numberValue: Double?

	public val booleanValue: Boolean?

	public val instantValue: Double?

	public val fuzzyDateValue: Double?

	public val binaryValue: ByteArray?

	public val documentId: String?

	public val measureValue: MeasureJs?

	public val medicationValue: MedicationJs?

	public val timeSeries: TimeSeriesJs?

	public val compoundValue: Array<out ServiceJs>?

	public val ratio: Array<out MeasureJs>?

	public val range: Array<out MeasureJs>?

	public val isEncrypted: Boolean
}

@JsName("DecryptedContent")
public external class DecryptedContentJs(
	partial: dynamic,
) : ContentJs {
	override val stringValue: String?

	override val numberValue: Double?

	override val booleanValue: Boolean?

	override val instantValue: Double?

	override val fuzzyDateValue: Double?

	override val binaryValue: ByteArray?

	override val documentId: String?

	override val measureValue: MeasureJs?

	override val medicationValue: MedicationJs?

	override val timeSeries: TimeSeriesJs?

	override val compoundValue: Array<DecryptedServiceJs>?

	override val ratio: Array<MeasureJs>?

	override val range: Array<MeasureJs>?

	override val encryptedSelf: String?

	override val isEncrypted: Boolean
}

@JsName("EncryptedContent")
public external class EncryptedContentJs(
	partial: dynamic,
) : ContentJs {
	override val stringValue: String?

	override val numberValue: Double?

	override val booleanValue: Boolean?

	override val instantValue: Double?

	override val fuzzyDateValue: Double?

	override val binaryValue: ByteArray?

	override val documentId: String?

	override val measureValue: MeasureJs?

	override val medicationValue: MedicationJs?

	override val timeSeries: TimeSeriesJs?

	override val compoundValue: Array<EncryptedServiceJs>?

	override val ratio: Array<MeasureJs>?

	override val range: Array<MeasureJs>?

	override val encryptedSelf: String?

	override val isEncrypted: Boolean
}
