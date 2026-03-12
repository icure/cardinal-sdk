package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.model.specializations.Base64String
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames
import kotlin.Boolean
import kotlin.Double
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.Map

/**
 * Represents an invoicing code within an invoice, containing tarification details, amounts,
 * prescriber information,
 * and lifecycle status flags. Each invoicing code corresponds to a billable medical act or service.
 * /
 */
public sealed interface InvoicingCode : Encryptable {
	/**
	 * The unique identifier of this invoicing code.
	 */
	public val id: String?

	/**
	 * The date of the invoicing code as a long (yyyyMMdd format).
	 */
	public val dateCode: Long?

	/**
	 * A logical identifier that remains stable when a code is resent to the insuring organization.
	 */
	public val logicalId: String?

	/**
	 * The label of the invoicing code.
	 */
	public val label: String?

	/**
	 * The identifier of the user who created this invoicing code.
	 */
	public val userId: String?

	/**
	 * The identifier of the associated contact.
	 */
	public val contactId: String?

	/**
	 * The identifier of the associated service.
	 */
	public val serviceId: String?

	/**
	 * The identifier of the associated tarification.
	 */
	public val pricingId: String?

	/**
	 * The code value, for obsolete codes or codes not linked to a tarification.
	 */
	public val code: String?

	/**
	 * The type of payment.
	 */
	public val paymentType: PaymentType?

	/**
	 * The amount already paid.
	 */
	public val paid: Double?

	/**
	 * The total amount (reimbursement + doctor supplement + intervention).
	 */
	public val totalAmount: Double?

	/**
	 * The reimbursement amount.
	 */
	public val reimbursement: Double?

	/**
	 * The patient intervention amount.
	 */
	public val patientIntervention: Double?

	/**
	 * The AMI (insurance) intervention amount.
	 */
	public val amiIntervention: Double?

	/**
	 * The doctor supplement amount.
	 */
	public val doctorSupplement: Double?

	/**
	 * The convention amount (reimbursement + intervention).
	 */
	public val conventionAmount: Double?

	/**
	 * The VAT amount.
	 */
	public val vat: Double?

	/**
	 * The error message from eTarif, if any.
	 */
	public val error: String?

	/**
	 * The contract identifier.
	 */
	public val contract: String?

	/**
	 * The contract date.
	 */
	public val contractDate: Long?

	/**
	 * The number of units.
	 */
	public val units: Int?

	/**
	 * The side indicator.
	 */
	public val side: Int?

	/**
	 * The time of day.
	 */
	public val timeOfDay: Int?

	/**
	 * The hour when the eID was read.
	 */
	public val eidReadingHour: Int?

	/**
	 * The value read from the eID.
	 */
	public val eidReadingValue: String?

	/**
	 * The override code for third-party payer.
	 */
	public val override3rdPayerCode: Int?

	/**
	 * The reason for overriding the third-party payer.
	 */
	public val override3rdPayerReason: String?

	/**
	 * The transplantation code.
	 */
	public val transplantationCode: Int?

	/**
	 * The prescriber norm code.
	 */
	public val prescriberNorm: Int?

	/**
	 * The label of the product.
	 */
	public val productLabel: String?

	/**
	 * The percent norm.
	 */
	public val percentNorm: Int?

	/**
	 * The NIHII number of the prescriber.
	 */
	public val prescriberNihii: String?

	/**
	 * A related code.
	 */
	public val relatedCode: String?

	/**
	 * The prescription date (yyyyMMdd).
	 */
	public val prescriptionDate: Long?

	/**
	 * The maximum derogation number.
	 */
	public val derogationMaxNumber: Int?

	/**
	 * The SSIN of the prescriber.
	 */
	public val prescriberSsin: String?

	/**
	 * The last name of the prescriber.
	 */
	public val prescriberLastName: String?

	/**
	 * The first name of the prescriber.
	 */
	public val prescriberFirstName: String?

	/**
	 * The CD-HCPARTY code of the prescriber.
	 */
	public val prescriberCdHcParty: String?

	/**
	 * The NIHII number of the location.
	 */
	public val locationNihii: String?

	/**
	 * The CD-HCPARTY code of the location.
	 */
	public val locationCdHcParty: String?

	/**
	 * The service code of the location.
	 */
	public val locationService: Int?

	/**
	 * The admission date.
	 */
	public val admissionDate: Long?

	/**
	 * Whether this code has been canceled.
	 */
	public val canceled: Boolean?

	/**
	 * Whether this code has been accepted.
	 */
	public val accepted: Boolean?

	/**
	 * Whether this code is pending.
	 */
	public val pending: Boolean?

	/**
	 * Whether this code has been resent.
	 */
	public val resent: Boolean?

	/**
	 * Whether this code has been archived.
	 */
	public val archived: Boolean?

	/**
	 * Whether this code has been lost.
	 */
	public val lost: Boolean?

	/**
	 * The insurance justification code.
	 */
	public val insuranceJustification: Int?

	/**
	 * The reason for canceling patient intervention.
	 */
	public val cancelPatientInterventionReason: Int?

	/**
	 * The status bitmask of this invoicing code.
	 */
	public val status: Long?

	/**
	 * The label of the code.
	 */
	public val codeLabel: String?

	/**
	 * Additional options as key-value pairs.
	 */
	public val options: Map<String, String>

	/**
	 * The base64-encoded encrypted content.
	 */
	override val encryptedSelf: Base64String?
}

/**
 * Represents an invoicing code within an invoice, containing tarification details, amounts,
 * prescriber information,
 * and lifecycle status flags. Each invoicing code corresponds to a billable medical act or service.
 * /
 */
@Serializable
public data class DecryptedInvoicingCode(
	/**
	 * The unique identifier of this invoicing code.
	 */
	override val id: String?,
	/**
	 * The date of the invoicing code as a long (yyyyMMdd format).
	 */
	override val dateCode: Long? = null,
	/**
	 * A logical identifier that remains stable when a code is resent to the insuring organization.
	 */
	override val logicalId: String? = null,
	/**
	 * The label of the invoicing code.
	 */
	override val label: String? = null,
	/**
	 * The identifier of the user who created this invoicing code.
	 */
	override val userId: String? = null,
	/**
	 * The identifier of the associated contact.
	 */
	override val contactId: String? = null,
	/**
	 * The identifier of the associated service.
	 */
	override val serviceId: String? = null,
	/**
	 * The identifier of the associated tarification.
	 */
	@JsonNames("tarificationId")
	override val pricingId: String? = null,
	/**
	 * The code value, for obsolete codes or codes not linked to a tarification.
	 */
	override val code: String? = null,
	/**
	 * The type of payment.
	 */
	override val paymentType: PaymentType? = null,
	/**
	 * The amount already paid.
	 */
	override val paid: Double? = null,
	/**
	 * The total amount (reimbursement + doctor supplement + intervention).
	 */
	override val totalAmount: Double? = null,
	/**
	 * The reimbursement amount.
	 */
	override val reimbursement: Double? = null,
	/**
	 * The patient intervention amount.
	 */
	override val patientIntervention: Double? = null,
	/**
	 * The AMI (insurance) intervention amount.
	 */
	override val amiIntervention: Double? = null,
	/**
	 * The doctor supplement amount.
	 */
	override val doctorSupplement: Double? = null,
	/**
	 * The convention amount (reimbursement + intervention).
	 */
	override val conventionAmount: Double? = null,
	/**
	 * The VAT amount.
	 */
	override val vat: Double? = null,
	/**
	 * The error message from eTarif, if any.
	 */
	override val error: String? = null,
	/**
	 * The contract identifier.
	 */
	override val contract: String? = null,
	/**
	 * The contract date.
	 */
	override val contractDate: Long? = null,
	/**
	 * The number of units.
	 */
	override val units: Int? = null,
	/**
	 * The side indicator.
	 */
	override val side: Int? = null,
	/**
	 * The time of day.
	 */
	override val timeOfDay: Int? = null,
	/**
	 * The hour when the eID was read.
	 */
	override val eidReadingHour: Int? = null,
	/**
	 * The value read from the eID.
	 */
	override val eidReadingValue: String? = null,
	/**
	 * The override code for third-party payer.
	 */
	override val override3rdPayerCode: Int? = null,
	/**
	 * The reason for overriding the third-party payer.
	 */
	override val override3rdPayerReason: String? = null,
	/**
	 * The transplantation code.
	 */
	override val transplantationCode: Int? = null,
	/**
	 * The prescriber norm code.
	 */
	override val prescriberNorm: Int? = null,
	/**
	 * The label of the product.
	 */
	override val productLabel: String? = null,
	/**
	 * The percent norm.
	 */
	override val percentNorm: Int? = null,
	/**
	 * The NIHII number of the prescriber.
	 */
	override val prescriberNihii: String? = null,
	/**
	 * A related code.
	 */
	override val relatedCode: String? = null,
	/**
	 * The prescription date (yyyyMMdd).
	 */
	override val prescriptionDate: Long? = null,
	/**
	 * The maximum derogation number.
	 */
	override val derogationMaxNumber: Int? = null,
	/**
	 * The SSIN of the prescriber.
	 */
	override val prescriberSsin: String? = null,
	/**
	 * The last name of the prescriber.
	 */
	override val prescriberLastName: String? = null,
	/**
	 * The first name of the prescriber.
	 */
	override val prescriberFirstName: String? = null,
	/**
	 * The CD-HCPARTY code of the prescriber.
	 */
	override val prescriberCdHcParty: String? = null,
	/**
	 * The NIHII number of the location.
	 */
	override val locationNihii: String? = null,
	/**
	 * The CD-HCPARTY code of the location.
	 */
	override val locationCdHcParty: String? = null,
	/**
	 * The service code of the location.
	 */
	override val locationService: Int? = null,
	/**
	 * The admission date.
	 */
	override val admissionDate: Long? = null,
	/**
	 * Whether this code has been canceled.
	 */
	override val canceled: Boolean? = null,
	/**
	 * Whether this code has been accepted.
	 */
	override val accepted: Boolean? = null,
	/**
	 * Whether this code is pending.
	 */
	override val pending: Boolean? = null,
	/**
	 * Whether this code has been resent.
	 */
	override val resent: Boolean? = null,
	/**
	 * Whether this code has been archived.
	 */
	override val archived: Boolean? = null,
	/**
	 * Whether this code has been lost.
	 */
	override val lost: Boolean? = null,
	/**
	 * The insurance justification code.
	 */
	override val insuranceJustification: Int? = null,
	/**
	 * The reason for canceling patient intervention.
	 */
	override val cancelPatientInterventionReason: Int? = null,
	/**
	 * The status bitmask of this invoicing code.
	 */
	override val status: Long? = null,
	/**
	 * The label of the code.
	 */
	override val codeLabel: String? = null,
	/**
	 * Additional options as key-value pairs.
	 */
	@param:DefaultValue("emptyMap()")
	override val options: Map<String, String> = emptyMap(),
	/**
	 * The base64-encoded encrypted content.
	 */
	override val encryptedSelf: Base64String? = null,
) : InvoicingCode

/**
 * Represents an invoicing code within an invoice, containing tarification details, amounts,
 * prescriber information,
 * and lifecycle status flags. Each invoicing code corresponds to a billable medical act or service.
 * /
 */
@Serializable
public data class EncryptedInvoicingCode(
	/**
	 * The unique identifier of this invoicing code.
	 */
	override val id: String?,
	/**
	 * The date of the invoicing code as a long (yyyyMMdd format).
	 */
	override val dateCode: Long? = null,
	/**
	 * A logical identifier that remains stable when a code is resent to the insuring organization.
	 */
	override val logicalId: String? = null,
	/**
	 * The label of the invoicing code.
	 */
	override val label: String? = null,
	/**
	 * The identifier of the user who created this invoicing code.
	 */
	override val userId: String? = null,
	/**
	 * The identifier of the associated contact.
	 */
	override val contactId: String? = null,
	/**
	 * The identifier of the associated service.
	 */
	override val serviceId: String? = null,
	/**
	 * The identifier of the associated tarification.
	 */
	@JsonNames("tarificationId")
	override val pricingId: String? = null,
	/**
	 * The code value, for obsolete codes or codes not linked to a tarification.
	 */
	override val code: String? = null,
	/**
	 * The type of payment.
	 */
	override val paymentType: PaymentType? = null,
	/**
	 * The amount already paid.
	 */
	override val paid: Double? = null,
	/**
	 * The total amount (reimbursement + doctor supplement + intervention).
	 */
	override val totalAmount: Double? = null,
	/**
	 * The reimbursement amount.
	 */
	override val reimbursement: Double? = null,
	/**
	 * The patient intervention amount.
	 */
	override val patientIntervention: Double? = null,
	/**
	 * The AMI (insurance) intervention amount.
	 */
	override val amiIntervention: Double? = null,
	/**
	 * The doctor supplement amount.
	 */
	override val doctorSupplement: Double? = null,
	/**
	 * The convention amount (reimbursement + intervention).
	 */
	override val conventionAmount: Double? = null,
	/**
	 * The VAT amount.
	 */
	override val vat: Double? = null,
	/**
	 * The error message from eTarif, if any.
	 */
	override val error: String? = null,
	/**
	 * The contract identifier.
	 */
	override val contract: String? = null,
	/**
	 * The contract date.
	 */
	override val contractDate: Long? = null,
	/**
	 * The number of units.
	 */
	override val units: Int? = null,
	/**
	 * The side indicator.
	 */
	override val side: Int? = null,
	/**
	 * The time of day.
	 */
	override val timeOfDay: Int? = null,
	/**
	 * The hour when the eID was read.
	 */
	override val eidReadingHour: Int? = null,
	/**
	 * The value read from the eID.
	 */
	override val eidReadingValue: String? = null,
	/**
	 * The override code for third-party payer.
	 */
	override val override3rdPayerCode: Int? = null,
	/**
	 * The reason for overriding the third-party payer.
	 */
	override val override3rdPayerReason: String? = null,
	/**
	 * The transplantation code.
	 */
	override val transplantationCode: Int? = null,
	/**
	 * The prescriber norm code.
	 */
	override val prescriberNorm: Int? = null,
	/**
	 * The label of the product.
	 */
	override val productLabel: String? = null,
	/**
	 * The percent norm.
	 */
	override val percentNorm: Int? = null,
	/**
	 * The NIHII number of the prescriber.
	 */
	override val prescriberNihii: String? = null,
	/**
	 * A related code.
	 */
	override val relatedCode: String? = null,
	/**
	 * The prescription date (yyyyMMdd).
	 */
	override val prescriptionDate: Long? = null,
	/**
	 * The maximum derogation number.
	 */
	override val derogationMaxNumber: Int? = null,
	/**
	 * The SSIN of the prescriber.
	 */
	override val prescriberSsin: String? = null,
	/**
	 * The last name of the prescriber.
	 */
	override val prescriberLastName: String? = null,
	/**
	 * The first name of the prescriber.
	 */
	override val prescriberFirstName: String? = null,
	/**
	 * The CD-HCPARTY code of the prescriber.
	 */
	override val prescriberCdHcParty: String? = null,
	/**
	 * The NIHII number of the location.
	 */
	override val locationNihii: String? = null,
	/**
	 * The CD-HCPARTY code of the location.
	 */
	override val locationCdHcParty: String? = null,
	/**
	 * The service code of the location.
	 */
	override val locationService: Int? = null,
	/**
	 * The admission date.
	 */
	override val admissionDate: Long? = null,
	/**
	 * Whether this code has been canceled.
	 */
	override val canceled: Boolean? = null,
	/**
	 * Whether this code has been accepted.
	 */
	override val accepted: Boolean? = null,
	/**
	 * Whether this code is pending.
	 */
	override val pending: Boolean? = null,
	/**
	 * Whether this code has been resent.
	 */
	override val resent: Boolean? = null,
	/**
	 * Whether this code has been archived.
	 */
	override val archived: Boolean? = null,
	/**
	 * Whether this code has been lost.
	 */
	override val lost: Boolean? = null,
	/**
	 * The insurance justification code.
	 */
	override val insuranceJustification: Int? = null,
	/**
	 * The reason for canceling patient intervention.
	 */
	override val cancelPatientInterventionReason: Int? = null,
	/**
	 * The status bitmask of this invoicing code.
	 */
	override val status: Long? = null,
	/**
	 * The label of the code.
	 */
	override val codeLabel: String? = null,
	/**
	 * Additional options as key-value pairs.
	 */
	@param:DefaultValue("emptyMap()")
	override val options: Map<String, String> = emptyMap(),
	/**
	 * The base64-encoded encrypted content.
	 */
	override val encryptedSelf: Base64String? = null,
) : InvoicingCode
