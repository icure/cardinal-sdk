// auto-generated file
@file:JsQualifier("model")

package com.icure.cardinal.sdk.js.model.embed

import com.icure.cardinal.sdk.js.model.DecryptedPropertyStubJs
import com.icure.cardinal.sdk.js.model.EncryptedPropertyStubJs
import com.icure.cardinal.sdk.js.model.PropertyStubJs
import com.icure.cardinal.sdk.js.utils.Record
import kotlin.Array
import kotlin.Boolean
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("PatientHealthCareParty")
public sealed external interface PatientHealthCarePartyJs : EncryptableJs {
	public val type: String?

	public val healthcarePartyId: String?

	public val sendFormats: Record<String, out String>

	public val referralPeriods: Array<out ReferralPeriodJs>

	public val referral: Boolean

	public val properties: Array<out PropertyStubJs>?

	public val isEncrypted: Boolean
}

@JsName("DecryptedPatientHealthCareParty")
public external class DecryptedPatientHealthCarePartyJs(
	partial: dynamic,
) : PatientHealthCarePartyJs {
	override val type: String?

	override val healthcarePartyId: String?

	override val sendFormats: Record<String, String>

	override val referralPeriods: Array<ReferralPeriodJs>

	override val referral: Boolean

	override val properties: Array<DecryptedPropertyStubJs>?

	override val encryptedSelf: String?

	override val isEncrypted: Boolean
}

@JsName("EncryptedPatientHealthCareParty")
public external class EncryptedPatientHealthCarePartyJs(
	partial: dynamic,
) : PatientHealthCarePartyJs {
	override val type: String?

	override val healthcarePartyId: String?

	override val sendFormats: Record<String, String>

	override val referralPeriods: Array<ReferralPeriodJs>

	override val referral: Boolean

	override val properties: Array<EncryptedPropertyStubJs>?

	override val encryptedSelf: String?

	override val isEncrypted: Boolean
}
