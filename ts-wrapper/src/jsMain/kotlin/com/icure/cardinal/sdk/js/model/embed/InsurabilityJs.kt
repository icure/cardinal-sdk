// auto-generated file
@file:JsQualifier("model")

package com.icure.cardinal.sdk.js.model.embed

import com.icure.cardinal.sdk.js.model.base.ExtendableJs
import com.icure.cardinal.sdk.js.utils.Record
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("Insurability")
public sealed external interface InsurabilityJs : EncryptableJs, ExtendableJs {
	public val parameters: Record<String, out String>

	public val hospitalisation: Boolean?

	public val ambulatory: Boolean?

	public val dental: Boolean?

	public val identificationNumber: String?

	public val insuranceId: String?

	public val startDate: Double?

	public val endDate: Double?

	public val titularyId: String?

	public val isEncrypted: Boolean
}

@JsName("DecryptedInsurability")
public external class DecryptedInsurabilityJs(
	partial: dynamic,
) : InsurabilityJs {
	override val parameters: Record<String, String>

	override val hospitalisation: Boolean?

	override val ambulatory: Boolean?

	override val dental: Boolean?

	override val identificationNumber: String?

	override val insuranceId: String?

	override val startDate: Double?

	override val endDate: Double?

	override val titularyId: String?

	override val encryptedSelf: String?

	override val extensions: dynamic

	override val isEncrypted: Boolean
}

@JsName("EncryptedInsurability")
public external class EncryptedInsurabilityJs(
	partial: dynamic,
) : InsurabilityJs {
	override val parameters: Record<String, String>

	override val hospitalisation: Boolean?

	override val ambulatory: Boolean?

	override val dental: Boolean?

	override val identificationNumber: String?

	override val insuranceId: String?

	override val startDate: Double?

	override val endDate: Double?

	override val titularyId: String?

	override val encryptedSelf: String?

	override val extensions: dynamic

	override val isEncrypted: Boolean
}
