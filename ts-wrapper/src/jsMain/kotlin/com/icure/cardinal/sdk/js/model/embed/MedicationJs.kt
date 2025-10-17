// auto-generated file
@file:JsQualifier("model")

package com.icure.cardinal.sdk.js.model.embed

import com.icure.cardinal.sdk.js.model.base.CodeStubJs
import com.icure.cardinal.sdk.js.utils.Record
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("Medication")
public external class MedicationJs(
	partial: dynamic,
) {
	public val compoundPrescription: String?

	public val substanceProduct: SubstanceproductJs?

	public val medicinalProduct: MedicinalproductJs?

	public val numberOfPackages: Double?

	public val batch: String?

	public val expirationDate: Double?

	public val instructionForPatient: String?

	public val instructionForReimbursement: String?

	public val commentForDelivery: String?

	public val drugRoute: String?

	public val temporality: String?

	public val frequency: CodeStubJs?

	public val reimbursementReason: CodeStubJs?

	public val substitutionAllowed: Boolean?

	public val beginMoment: Double?

	public val endMoment: Double?

	public val deliveryMoment: Double?

	public val endExecutionMoment: Double?

	public val duration: DurationJs?

	public val renewal: RenewalJs?

	public val knownUsage: Boolean?

	public val regimen: Array<RegimenItemJs>?

	public val posology: String?

	public val agreements: Record<String, ParagraphAgreementJs>?

	public val medicationSchemeIdOnSafe: String?

	public val medicationSchemeSafeVersion: Double?

	public val medicationSchemeTimeStampOnSafe: Double?

	public val medicationSchemeDocumentId: String?

	public val safeIdName: String?

	public val idOnSafes: String?

	public val timestampOnSafe: Double?

	public val changeValidated: Boolean?

	public val newSafeMedication: Boolean?

	public val medicationUse: String?

	public val beginCondition: String?

	public val endCondition: String?

	public val origin: String?

	public val medicationChanged: Boolean?

	public val posologyChanged: Boolean?

	public val suspension: Array<SuspensionJs>?

	public val prescriptionRID: String?

	public val status: Double?

	public val stockLocation: DecryptedAddressJs?
}
