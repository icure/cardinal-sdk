package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.model.specializations.Base64String
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Double
import kotlin.Int
import kotlin.Long
import kotlin.String

public sealed interface InvoicingCode : Encryptable {
	public val id: String?

	public val dateCode: Long?

	public val logicalId: String?

	public val label: String?

	public val userId: String?

	public val contactId: String?

	public val serviceId: String?

	public val tarificationId: String?

	public val code: String?

	public val paymentType: PaymentType?

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

	public val contractDate: Long?

	public val units: Int?

	public val side: Int?

	public val timeOfDay: Int?

	public val eidReadingHour: Int?

	public val eidReadingValue: String?

	public val override3rdPayerCode: Int?

	public val override3rdPayerReason: String?

	public val transplantationCode: Int?

	public val prescriberNorm: Int?

	public val productLabel: String?

	public val percentNorm: Int?

	public val prescriberNihii: String?

	public val relatedCode: String?

	public val prescriptionDate: Long?

	public val derogationMaxNumber: Int?

	public val prescriberSsin: String?

	public val prescriberLastName: String?

	public val prescriberFirstName: String?

	public val prescriberCdHcParty: String?

	public val locationNihii: String?

	public val locationCdHcParty: String?

	public val locationService: Int?

	public val admissionDate: Long?

	public val canceled: Boolean?

	public val accepted: Boolean?

	public val pending: Boolean?

	public val resent: Boolean?

	public val archived: Boolean?

	public val lost: Boolean?

	public val insuranceJustification: Int?

	public val cancelPatientInterventionReason: Int?

	public val status: Long?

	public val codeLabel: String?

	override val encryptedSelf: Base64String?
}

@Serializable
public data class DecryptedInvoicingCode(
	override val id: String?,
	override val dateCode: Long? = null,
	override val logicalId: String? = null,
	override val label: String? = null,
	override val userId: String? = null,
	override val contactId: String? = null,
	override val serviceId: String? = null,
	override val tarificationId: String? = null,
	override val code: String? = null,
	override val paymentType: PaymentType? = null,
	override val paid: Double? = null,
	override val totalAmount: Double? = null,
	override val reimbursement: Double? = null,
	override val patientIntervention: Double? = null,
	override val amiIntervention: Double? = null,
	override val doctorSupplement: Double? = null,
	override val conventionAmount: Double? = null,
	override val vat: Double? = null,
	override val error: String? = null,
	override val contract: String? = null,
	override val contractDate: Long? = null,
	override val units: Int? = null,
	override val side: Int? = null,
	override val timeOfDay: Int? = null,
	override val eidReadingHour: Int? = null,
	override val eidReadingValue: String? = null,
	override val override3rdPayerCode: Int? = null,
	override val override3rdPayerReason: String? = null,
	override val transplantationCode: Int? = null,
	override val prescriberNorm: Int? = null,
	override val productLabel: String? = null,
	override val percentNorm: Int? = null,
	override val prescriberNihii: String? = null,
	override val relatedCode: String? = null,
	override val prescriptionDate: Long? = null,
	override val derogationMaxNumber: Int? = null,
	override val prescriberSsin: String? = null,
	override val prescriberLastName: String? = null,
	override val prescriberFirstName: String? = null,
	override val prescriberCdHcParty: String? = null,
	override val locationNihii: String? = null,
	override val locationCdHcParty: String? = null,
	override val locationService: Int? = null,
	override val admissionDate: Long? = null,
	override val canceled: Boolean? = null,
	override val accepted: Boolean? = null,
	override val pending: Boolean? = null,
	override val resent: Boolean? = null,
	override val archived: Boolean? = null,
	override val lost: Boolean? = null,
	override val insuranceJustification: Int? = null,
	override val cancelPatientInterventionReason: Int? = null,
	override val status: Long? = null,
	override val codeLabel: String? = null,
	override val encryptedSelf: Base64String? = null,
) : InvoicingCode

@Serializable
public data class EncryptedInvoicingCode(
	override val id: String?,
	override val dateCode: Long? = null,
	override val logicalId: String? = null,
	override val label: String? = null,
	override val userId: String? = null,
	override val contactId: String? = null,
	override val serviceId: String? = null,
	override val tarificationId: String? = null,
	override val code: String? = null,
	override val paymentType: PaymentType? = null,
	override val paid: Double? = null,
	override val totalAmount: Double? = null,
	override val reimbursement: Double? = null,
	override val patientIntervention: Double? = null,
	override val amiIntervention: Double? = null,
	override val doctorSupplement: Double? = null,
	override val conventionAmount: Double? = null,
	override val vat: Double? = null,
	override val error: String? = null,
	override val contract: String? = null,
	override val contractDate: Long? = null,
	override val units: Int? = null,
	override val side: Int? = null,
	override val timeOfDay: Int? = null,
	override val eidReadingHour: Int? = null,
	override val eidReadingValue: String? = null,
	override val override3rdPayerCode: Int? = null,
	override val override3rdPayerReason: String? = null,
	override val transplantationCode: Int? = null,
	override val prescriberNorm: Int? = null,
	override val productLabel: String? = null,
	override val percentNorm: Int? = null,
	override val prescriberNihii: String? = null,
	override val relatedCode: String? = null,
	override val prescriptionDate: Long? = null,
	override val derogationMaxNumber: Int? = null,
	override val prescriberSsin: String? = null,
	override val prescriberLastName: String? = null,
	override val prescriberFirstName: String? = null,
	override val prescriberCdHcParty: String? = null,
	override val locationNihii: String? = null,
	override val locationCdHcParty: String? = null,
	override val locationService: Int? = null,
	override val admissionDate: Long? = null,
	override val canceled: Boolean? = null,
	override val accepted: Boolean? = null,
	override val pending: Boolean? = null,
	override val resent: Boolean? = null,
	override val archived: Boolean? = null,
	override val lost: Boolean? = null,
	override val insuranceJustification: Int? = null,
	override val cancelPatientInterventionReason: Int? = null,
	override val status: Long? = null,
	override val codeLabel: String? = null,
	override val encryptedSelf: Base64String? = null,
) : InvoicingCode
