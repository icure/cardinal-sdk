// auto-generated file
@file:JsQualifier("model")

package com.icure.cardinal.sdk.js.model.embed

import com.icure.cardinal.sdk.js.utils.Record
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("InvoicingCode")
public sealed external interface InvoicingCodeJs : EncryptableJs {
	public val id: String?

	public val dateCode: Double?

	public val logicalId: String?

	public val label: String?

	public val userId: String?

	public val contactId: String?

	public val serviceId: String?

	public val tarificationId: String?

	public val code: String?

	public val paymentType: String?

	public val paid: Double?

	public val totalAmount: Double?

	public val reimbursement: Double?

	public val patientIntervention: Double?

	public val amiIntervention: Double?

	public val doctorSupplement: Double?

	public val conventionAmount: Double?

	public val vat: Double?

	public val error: String?

	public val contract: String?

	public val contractDate: Double?

	public val units: Double?

	public val side: Double?

	public val timeOfDay: Double?

	public val eidReadingHour: Double?

	public val eidReadingValue: String?

	public val override3rdPayerCode: Double?

	public val override3rdPayerReason: String?

	public val transplantationCode: Double?

	public val prescriberNorm: Double?

	public val productLabel: String?

	public val percentNorm: Double?

	public val prescriberNihii: String?

	public val relatedCode: String?

	public val prescriptionDate: Double?

	public val derogationMaxNumber: Double?

	public val prescriberSsin: String?

	public val prescriberLastName: String?

	public val prescriberFirstName: String?

	public val prescriberCdHcParty: String?

	public val locationNihii: String?

	public val locationCdHcParty: String?

	public val locationService: Double?

	public val admissionDate: Double?

	public val canceled: Boolean?

	public val accepted: Boolean?

	public val pending: Boolean?

	public val resent: Boolean?

	public val archived: Boolean?

	public val lost: Boolean?

	public val insuranceJustification: Double?

	public val cancelPatientInterventionReason: Double?

	public val status: Double?

	public val codeLabel: String?

	public val options: Record<String, out String>

	public val isEncrypted: Boolean
}

@JsName("DecryptedInvoicingCode")
public external class DecryptedInvoicingCodeJs(
	partial: dynamic,
) : InvoicingCodeJs {
	override val id: String?

	override val dateCode: Double?

	override val logicalId: String?

	override val label: String?

	override val userId: String?

	override val contactId: String?

	override val serviceId: String?

	override val tarificationId: String?

	override val code: String?

	override val paymentType: String?

	override val paid: Double?

	override val totalAmount: Double?

	override val reimbursement: Double?

	override val patientIntervention: Double?

	override val amiIntervention: Double?

	override val doctorSupplement: Double?

	override val conventionAmount: Double?

	override val vat: Double?

	override val error: String?

	override val contract: String?

	override val contractDate: Double?

	override val units: Double?

	override val side: Double?

	override val timeOfDay: Double?

	override val eidReadingHour: Double?

	override val eidReadingValue: String?

	override val override3rdPayerCode: Double?

	override val override3rdPayerReason: String?

	override val transplantationCode: Double?

	override val prescriberNorm: Double?

	override val productLabel: String?

	override val percentNorm: Double?

	override val prescriberNihii: String?

	override val relatedCode: String?

	override val prescriptionDate: Double?

	override val derogationMaxNumber: Double?

	override val prescriberSsin: String?

	override val prescriberLastName: String?

	override val prescriberFirstName: String?

	override val prescriberCdHcParty: String?

	override val locationNihii: String?

	override val locationCdHcParty: String?

	override val locationService: Double?

	override val admissionDate: Double?

	override val canceled: Boolean?

	override val accepted: Boolean?

	override val pending: Boolean?

	override val resent: Boolean?

	override val archived: Boolean?

	override val lost: Boolean?

	override val insuranceJustification: Double?

	override val cancelPatientInterventionReason: Double?

	override val status: Double?

	override val codeLabel: String?

	override val options: Record<String, String>

	override val encryptedSelf: String?

	override val isEncrypted: Boolean
}

@JsName("EncryptedInvoicingCode")
public external class EncryptedInvoicingCodeJs(
	partial: dynamic,
) : InvoicingCodeJs {
	override val id: String?

	override val dateCode: Double?

	override val logicalId: String?

	override val label: String?

	override val userId: String?

	override val contactId: String?

	override val serviceId: String?

	override val tarificationId: String?

	override val code: String?

	override val paymentType: String?

	override val paid: Double?

	override val totalAmount: Double?

	override val reimbursement: Double?

	override val patientIntervention: Double?

	override val amiIntervention: Double?

	override val doctorSupplement: Double?

	override val conventionAmount: Double?

	override val vat: Double?

	override val error: String?

	override val contract: String?

	override val contractDate: Double?

	override val units: Double?

	override val side: Double?

	override val timeOfDay: Double?

	override val eidReadingHour: Double?

	override val eidReadingValue: String?

	override val override3rdPayerCode: Double?

	override val override3rdPayerReason: String?

	override val transplantationCode: Double?

	override val prescriberNorm: Double?

	override val productLabel: String?

	override val percentNorm: Double?

	override val prescriberNihii: String?

	override val relatedCode: String?

	override val prescriptionDate: Double?

	override val derogationMaxNumber: Double?

	override val prescriberSsin: String?

	override val prescriberLastName: String?

	override val prescriberFirstName: String?

	override val prescriberCdHcParty: String?

	override val locationNihii: String?

	override val locationCdHcParty: String?

	override val locationService: Double?

	override val admissionDate: Double?

	override val canceled: Boolean?

	override val accepted: Boolean?

	override val pending: Boolean?

	override val resent: Boolean?

	override val archived: Boolean?

	override val lost: Boolean?

	override val insuranceJustification: Double?

	override val cancelPatientInterventionReason: Double?

	override val status: Double?

	override val codeLabel: String?

	override val options: Record<String, String>

	override val encryptedSelf: String?

	override val isEncrypted: Boolean
}
