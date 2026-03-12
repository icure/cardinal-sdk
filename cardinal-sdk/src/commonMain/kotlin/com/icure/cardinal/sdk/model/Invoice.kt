package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.model.base.CodeStub
import com.icure.cardinal.sdk.model.base.HasEncryptionMetadata
import com.icure.cardinal.sdk.model.base.ICureDocument
import com.icure.cardinal.sdk.model.base.Identifier
import com.icure.cardinal.sdk.model.base.StoredDocument
import com.icure.cardinal.sdk.model.embed.DecryptedInvoicingCode
import com.icure.cardinal.sdk.model.embed.Delegation
import com.icure.cardinal.sdk.model.embed.Encryptable
import com.icure.cardinal.sdk.model.embed.EncryptedInvoicingCode
import com.icure.cardinal.sdk.model.embed.IdentityDocumentReader
import com.icure.cardinal.sdk.model.embed.InvoicingCode
import com.icure.cardinal.sdk.model.embed.Payment
import com.icure.cardinal.sdk.model.embed.PaymentType
import com.icure.cardinal.sdk.model.embed.SecurityMetadata
import com.icure.cardinal.sdk.model.specializations.Base64String
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Double
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.Set

/**
 * Represents an invoice. An invoice is used to bill patients, mutual funds, or paying agencies for
 * healthcare
 * services rendered. It is serialized in JSON and saved in the underlying iCure CouchDB database.
 * /
 */
public sealed interface Invoice :
	StoredDocument,
	ICureDocument<String>,
	HasEncryptionMetadata,
	Encryptable {
	/**
	 * The Id of the Invoice. We encourage using either a v4 UUID or a HL7 Id.
	 */
	override val id: String

	/**
	 * The revision of the invoice in the database, used for conflict management / optimistic locking.
	 */
	override val rev: String?

	/**
	 * The identifiers of the invoice.
	 */
	public val identifier: List<Identifier>

	/**
	 * The timestamp (unix epoch in ms) of creation.
	 */
	override val created: Long?

	/**
	 * The timestamp (unix epoch in ms) of the latest modification.
	 */
	override val modified: Long?

	/**
	 * The id of the User that created this invoice.
	 */
	override val author: String?

	/**
	 * The id of the HealthcareParty that is responsible for this invoice.
	 */
	override val responsible: String?

	/**
	 * Tags that qualify the invoice as being member of a certain class.
	 */
	override val tags: Set<CodeStub>

	/**
	 * Codes that identify or qualify this particular invoice.
	 */
	override val codes: Set<CodeStub>

	/**
	 * Hard delete (unix epoch in ms) timestamp of the object.
	 */
	override val deletionDate: Long?

	/**
	 * The timestamp (unix epoch in ms) when the invoice was drafted.
	 */
	public val invoiceDate: Long?

	/**
	 * The timestamp (unix epoch in ms) when the invoice was sent.
	 */
	public val sentDate: Long?

	/**
	 * The timestamp (unix epoch in ms) when the invoice was printed.
	 */
	public val printedDate: Long?

	/**
	 * The list of invoicing codes associated with this invoice.
	 */
	public val invoicingCodes: List<InvoicingCode>

	/**
	 * Map of receipt references.
	 */
	public val receipts: Map<String, String>

	/**
	 * Id of the recipient of the invoice.
	 */
	public val recipientId: String?

	/**
	 * The invoice reference number.
	 */
	public val invoiceReference: String?

	/**
	 * The decision reference number.
	 */
	public val decisionReference: String?

	/**
	 * The third party reference.
	 */
	public val thirdPartyReference: String?

	/**
	 * Justification for third party payment.
	 */
	public val thirdPartyPaymentJustification: String?

	/**
	 * Reason for third party payment.
	 */
	public val thirdPartyPaymentReason: String?

	/**
	 * The reason for the invoice.
	 */
	public val reason: String?

	/**
	 * The group id for grouping related invoices.
	 */
	public val groupId: String?

	/**
	 * Type of payment (cash, wired, insurance, debit card, etc.).
	 */
	public val paymentType: PaymentType?

	/**
	 * The amount paid.
	 */
	public val paid: Double?

	/**
	 * List of payments made for this invoice.
	 */
	public val payments: List<Payment>?

	/**
	 * SSIN of the gnotion.
	 */
	public val gnotionSsin: String?

	/**
	 * Last name of the gnotion.
	 */
	public val gnotionLastName: String?

	/**
	 * First name of the gnotion.
	 */
	public val gnotionFirstName: String?

	/**
	 * CD-HCPARTY code of the gnotion.
	 */
	public val gnotionCdHcParty: String?

	/**
	 * The invoicing period.
	 */
	public val invoicePeriod: Int?

	/**
	 * The type of care provider.
	 */
	public val careProviderType: String?

	/**
	 * SSIN of the internship.
	 */
	public val internshipSsin: String?

	/**
	 * Last name of the internship supervisor.
	 */
	public val internshipLastName: String?

	/**
	 * First name of the internship supervisor.
	 */
	public val internshipFirstName: String?

	/**
	 * CD-HCPARTY code of the internship.
	 */
	public val internshipCdHcParty: String?

	/**
	 * CBE number of the internship.
	 */
	public val internshipCbe: String?

	/**
	 * SSIN of the supervisor.
	 */
	public val supervisorSsin: String?

	/**
	 * Last name of the supervisor.
	 */
	public val supervisorLastName: String?

	/**
	 * First name of the supervisor.
	 */
	public val supervisorFirstName: String?

	/**
	 * CD-HCPARTY code of the supervisor.
	 */
	public val supervisorCdHcParty: String?

	/**
	 * CBE number of the supervisor.
	 */
	public val supervisorCbe: String?

	/**
	 * Error message if any.
	 */
	public val error: String?

	/**
	 * Name of the encounter location.
	 */
	public val encounterLocationName: String?

	/**
	 * Norm of the encounter location.
	 */
	public val encounterLocationNorm: Int?

	/**
	 * Justification for long delay.
	 */
	public val longDelayJustification: Int?

	/**
	 * Id of the corrective invoice.
	 */
	public val correctiveInvoiceId: String?

	/**
	 * Id of the corrected invoice.
	 */
	public val correctedInvoiceId: String?

	/**
	 * Whether this invoice is a credit note.
	 */
	public val creditNote: Boolean?

	/**
	 * Id of the related invoice for the credit note.
	 */
	public val creditNoteRelatedInvoiceId: String?

	/**
	 * Identity document reader information.
	 */
	public val idDocument: IdentityDocumentReader?

	/**
	 * The admission date for hospitalization invoices.
	 */
	public val admissionDate: Long?

	/**
	 * Service code of the location.
	 */
	public val locationService: Int?

	/**
	 * The reason for cancellation.
	 */
	public val cancelReason: String?

	/**
	 * The date of cancellation.
	 */
	public val cancelDate: Long?

	/**
	 * Extra options for the invoice.
	 */
	public val options: Map<String, String>

	/**
	 * The secret patient key, encrypted in the patient's own AES key.
	 */
	override val secretForeignKeys: Set<String>

	/**
	 * The patient id encrypted in the delegates' AES keys.
	 */
	override val cryptedForeignKeys: Map<String, Set<Delegation>>

	/**
	 * The delegations giving access to connected healthcare information.
	 */
	override val delegations: Map<String, Set<Delegation>>

	/**
	 * The keys used to encrypt this entity when stored encrypted.
	 */
	override val encryptionKeys: Map<String, Set<Delegation>>

	/**
	 * The base64-encoded encrypted fields of this entity.
	 */
	override val encryptedSelf: Base64String?

	/**
	 * The security metadata of the entity.
	 */
	override val securityMetadata: SecurityMetadata?
}

/**
 * Represents an invoice. An invoice is used to bill patients, mutual funds, or paying agencies for
 * healthcare
 * services rendered. It is serialized in JSON and saved in the underlying iCure CouchDB database.
 * /
 */
@Serializable
public data class DecryptedInvoice(
	/**
	 * The Id of the Invoice. We encourage using either a v4 UUID or a HL7 Id.
	 */
	override val id: String,
	/**
	 * The revision of the invoice in the database, used for conflict management / optimistic locking.
	 */
	override val rev: String? = null,
	/**
	 * The identifiers of the invoice.
	 */
	@param:DefaultValue("emptyList()")
	override val identifier: List<Identifier> = emptyList(),
	/**
	 * The timestamp (unix epoch in ms) of creation.
	 */
	override val created: Long? = null,
	/**
	 * The timestamp (unix epoch in ms) of the latest modification.
	 */
	override val modified: Long? = null,
	/**
	 * The id of the User that created this invoice.
	 */
	override val author: String? = null,
	/**
	 * The id of the HealthcareParty that is responsible for this invoice.
	 */
	override val responsible: String? = null,
	/**
	 * Tags that qualify the invoice as being member of a certain class.
	 */
	@param:DefaultValue("emptySet()")
	override val tags: Set<CodeStub> = emptySet(),
	/**
	 * Codes that identify or qualify this particular invoice.
	 */
	@param:DefaultValue("emptySet()")
	override val codes: Set<CodeStub> = emptySet(),
	/**
	 * Hard delete (unix epoch in ms) timestamp of the object.
	 */
	override val deletionDate: Long? = null,
	/**
	 * The timestamp (unix epoch in ms) when the invoice was drafted.
	 */
	override val invoiceDate: Long? = null,
	/**
	 * The timestamp (unix epoch in ms) when the invoice was sent.
	 */
	override val sentDate: Long? = null,
	/**
	 * The timestamp (unix epoch in ms) when the invoice was printed.
	 */
	override val printedDate: Long? = null,
	/**
	 * The list of invoicing codes associated with this invoice.
	 */
	@param:DefaultValue("emptyList()")
	override val invoicingCodes: List<DecryptedInvoicingCode> = emptyList(),
	/**
	 * Map of receipt references.
	 */
	@param:DefaultValue("emptyMap()")
	override val receipts: Map<String, String> = emptyMap(),
	/**
	 * Id of the recipient of the invoice.
	 */
	override val recipientId: String? = null,
	/**
	 * The invoice reference number.
	 */
	override val invoiceReference: String? = null,
	/**
	 * The decision reference number.
	 */
	override val decisionReference: String? = null,
	/**
	 * The third party reference.
	 */
	override val thirdPartyReference: String? = null,
	/**
	 * Justification for third party payment.
	 */
	override val thirdPartyPaymentJustification: String? = null,
	/**
	 * Reason for third party payment.
	 */
	override val thirdPartyPaymentReason: String? = null,
	/**
	 * The reason for the invoice.
	 */
	override val reason: String? = null,
	/**
	 * The group id for grouping related invoices.
	 */
	override val groupId: String? = null,
	/**
	 * Type of payment (cash, wired, insurance, debit card, etc.).
	 */
	override val paymentType: PaymentType? = null,
	/**
	 * The amount paid.
	 */
	override val paid: Double? = null,
	/**
	 * List of payments made for this invoice.
	 */
	override val payments: List<Payment>? = null,
	/**
	 * SSIN of the gnotion.
	 */
	override val gnotionSsin: String? = null,
	/**
	 * Last name of the gnotion.
	 */
	override val gnotionLastName: String? = null,
	/**
	 * First name of the gnotion.
	 */
	override val gnotionFirstName: String? = null,
	/**
	 * CD-HCPARTY code of the gnotion.
	 */
	override val gnotionCdHcParty: String? = null,
	/**
	 * The invoicing period.
	 */
	override val invoicePeriod: Int? = null,
	/**
	 * The type of care provider.
	 */
	override val careProviderType: String? = null,
	/**
	 * SSIN of the internship.
	 */
	override val internshipSsin: String? = null,
	/**
	 * Last name of the internship supervisor.
	 */
	override val internshipLastName: String? = null,
	/**
	 * First name of the internship supervisor.
	 */
	override val internshipFirstName: String? = null,
	/**
	 * CD-HCPARTY code of the internship.
	 */
	override val internshipCdHcParty: String? = null,
	/**
	 * CBE number of the internship.
	 */
	override val internshipCbe: String? = null,
	/**
	 * SSIN of the supervisor.
	 */
	override val supervisorSsin: String? = null,
	/**
	 * Last name of the supervisor.
	 */
	override val supervisorLastName: String? = null,
	/**
	 * First name of the supervisor.
	 */
	override val supervisorFirstName: String? = null,
	/**
	 * CD-HCPARTY code of the supervisor.
	 */
	override val supervisorCdHcParty: String? = null,
	/**
	 * CBE number of the supervisor.
	 */
	override val supervisorCbe: String? = null,
	/**
	 * Error message if any.
	 */
	override val error: String? = null,
	/**
	 * Name of the encounter location.
	 */
	override val encounterLocationName: String? = null,
	/**
	 * Norm of the encounter location.
	 */
	override val encounterLocationNorm: Int? = null,
	/**
	 * Justification for long delay.
	 */
	override val longDelayJustification: Int? = null,
	/**
	 * Id of the corrective invoice.
	 */
	override val correctiveInvoiceId: String? = null,
	/**
	 * Id of the corrected invoice.
	 */
	override val correctedInvoiceId: String? = null,
	/**
	 * Whether this invoice is a credit note.
	 */
	override val creditNote: Boolean? = null,
	/**
	 * Id of the related invoice for the credit note.
	 */
	override val creditNoteRelatedInvoiceId: String? = null,
	/**
	 * Identity document reader information.
	 */
	override val idDocument: IdentityDocumentReader? = null,
	/**
	 * The admission date for hospitalization invoices.
	 */
	override val admissionDate: Long? = null,
	/**
	 * Service code of the location.
	 */
	override val locationService: Int? = null,
	/**
	 * The reason for cancellation.
	 */
	override val cancelReason: String? = null,
	/**
	 * The date of cancellation.
	 */
	override val cancelDate: Long? = null,
	/**
	 * Extra options for the invoice.
	 */
	@param:DefaultValue("emptyMap()")
	override val options: Map<String, String> = emptyMap(),
	/**
	 * The secret patient key, encrypted in the patient's own AES key.
	 */
	@param:DefaultValue("emptySet()")
	override val secretForeignKeys: Set<String> = emptySet(),
	/**
	 * The patient id encrypted in the delegates' AES keys.
	 */
	@param:DefaultValue("emptyMap()")
	override val cryptedForeignKeys: Map<String, Set<Delegation>> = emptyMap(),
	/**
	 * The delegations giving access to connected healthcare information.
	 */
	@param:DefaultValue("emptyMap()")
	override val delegations: Map<String, Set<Delegation>> = emptyMap(),
	/**
	 * The keys used to encrypt this entity when stored encrypted.
	 */
	@param:DefaultValue("emptyMap()")
	override val encryptionKeys: Map<String, Set<Delegation>> = emptyMap(),
	/**
	 * The base64-encoded encrypted fields of this entity.
	 */
	override val encryptedSelf: Base64String? = null,
	/**
	 * The security metadata of the entity.
	 */
	override val securityMetadata: SecurityMetadata? = null,
) : Invoice

/**
 * Represents an invoice. An invoice is used to bill patients, mutual funds, or paying agencies for
 * healthcare
 * services rendered. It is serialized in JSON and saved in the underlying iCure CouchDB database.
 * /
 */
@Serializable
public data class EncryptedInvoice(
	/**
	 * The Id of the Invoice. We encourage using either a v4 UUID or a HL7 Id.
	 */
	override val id: String,
	/**
	 * The revision of the invoice in the database, used for conflict management / optimistic locking.
	 */
	override val rev: String? = null,
	/**
	 * The identifiers of the invoice.
	 */
	@param:DefaultValue("emptyList()")
	override val identifier: List<Identifier> = emptyList(),
	/**
	 * The timestamp (unix epoch in ms) of creation.
	 */
	override val created: Long? = null,
	/**
	 * The timestamp (unix epoch in ms) of the latest modification.
	 */
	override val modified: Long? = null,
	/**
	 * The id of the User that created this invoice.
	 */
	override val author: String? = null,
	/**
	 * The id of the HealthcareParty that is responsible for this invoice.
	 */
	override val responsible: String? = null,
	/**
	 * Tags that qualify the invoice as being member of a certain class.
	 */
	@param:DefaultValue("emptySet()")
	override val tags: Set<CodeStub> = emptySet(),
	/**
	 * Codes that identify or qualify this particular invoice.
	 */
	@param:DefaultValue("emptySet()")
	override val codes: Set<CodeStub> = emptySet(),
	/**
	 * Hard delete (unix epoch in ms) timestamp of the object.
	 */
	override val deletionDate: Long? = null,
	/**
	 * The timestamp (unix epoch in ms) when the invoice was drafted.
	 */
	override val invoiceDate: Long? = null,
	/**
	 * The timestamp (unix epoch in ms) when the invoice was sent.
	 */
	override val sentDate: Long? = null,
	/**
	 * The timestamp (unix epoch in ms) when the invoice was printed.
	 */
	override val printedDate: Long? = null,
	/**
	 * The list of invoicing codes associated with this invoice.
	 */
	@param:DefaultValue("emptyList()")
	override val invoicingCodes: List<EncryptedInvoicingCode> = emptyList(),
	/**
	 * Map of receipt references.
	 */
	@param:DefaultValue("emptyMap()")
	override val receipts: Map<String, String> = emptyMap(),
	/**
	 * Id of the recipient of the invoice.
	 */
	override val recipientId: String? = null,
	/**
	 * The invoice reference number.
	 */
	override val invoiceReference: String? = null,
	/**
	 * The decision reference number.
	 */
	override val decisionReference: String? = null,
	/**
	 * The third party reference.
	 */
	override val thirdPartyReference: String? = null,
	/**
	 * Justification for third party payment.
	 */
	override val thirdPartyPaymentJustification: String? = null,
	/**
	 * Reason for third party payment.
	 */
	override val thirdPartyPaymentReason: String? = null,
	/**
	 * The reason for the invoice.
	 */
	override val reason: String? = null,
	/**
	 * The group id for grouping related invoices.
	 */
	override val groupId: String? = null,
	/**
	 * Type of payment (cash, wired, insurance, debit card, etc.).
	 */
	override val paymentType: PaymentType? = null,
	/**
	 * The amount paid.
	 */
	override val paid: Double? = null,
	/**
	 * List of payments made for this invoice.
	 */
	override val payments: List<Payment>? = null,
	/**
	 * SSIN of the gnotion.
	 */
	override val gnotionSsin: String? = null,
	/**
	 * Last name of the gnotion.
	 */
	override val gnotionLastName: String? = null,
	/**
	 * First name of the gnotion.
	 */
	override val gnotionFirstName: String? = null,
	/**
	 * CD-HCPARTY code of the gnotion.
	 */
	override val gnotionCdHcParty: String? = null,
	/**
	 * The invoicing period.
	 */
	override val invoicePeriod: Int? = null,
	/**
	 * The type of care provider.
	 */
	override val careProviderType: String? = null,
	/**
	 * SSIN of the internship.
	 */
	override val internshipSsin: String? = null,
	/**
	 * Last name of the internship supervisor.
	 */
	override val internshipLastName: String? = null,
	/**
	 * First name of the internship supervisor.
	 */
	override val internshipFirstName: String? = null,
	/**
	 * CD-HCPARTY code of the internship.
	 */
	override val internshipCdHcParty: String? = null,
	/**
	 * CBE number of the internship.
	 */
	override val internshipCbe: String? = null,
	/**
	 * SSIN of the supervisor.
	 */
	override val supervisorSsin: String? = null,
	/**
	 * Last name of the supervisor.
	 */
	override val supervisorLastName: String? = null,
	/**
	 * First name of the supervisor.
	 */
	override val supervisorFirstName: String? = null,
	/**
	 * CD-HCPARTY code of the supervisor.
	 */
	override val supervisorCdHcParty: String? = null,
	/**
	 * CBE number of the supervisor.
	 */
	override val supervisorCbe: String? = null,
	/**
	 * Error message if any.
	 */
	override val error: String? = null,
	/**
	 * Name of the encounter location.
	 */
	override val encounterLocationName: String? = null,
	/**
	 * Norm of the encounter location.
	 */
	override val encounterLocationNorm: Int? = null,
	/**
	 * Justification for long delay.
	 */
	override val longDelayJustification: Int? = null,
	/**
	 * Id of the corrective invoice.
	 */
	override val correctiveInvoiceId: String? = null,
	/**
	 * Id of the corrected invoice.
	 */
	override val correctedInvoiceId: String? = null,
	/**
	 * Whether this invoice is a credit note.
	 */
	override val creditNote: Boolean? = null,
	/**
	 * Id of the related invoice for the credit note.
	 */
	override val creditNoteRelatedInvoiceId: String? = null,
	/**
	 * Identity document reader information.
	 */
	override val idDocument: IdentityDocumentReader? = null,
	/**
	 * The admission date for hospitalization invoices.
	 */
	override val admissionDate: Long? = null,
	/**
	 * Service code of the location.
	 */
	override val locationService: Int? = null,
	/**
	 * The reason for cancellation.
	 */
	override val cancelReason: String? = null,
	/**
	 * The date of cancellation.
	 */
	override val cancelDate: Long? = null,
	/**
	 * Extra options for the invoice.
	 */
	@param:DefaultValue("emptyMap()")
	override val options: Map<String, String> = emptyMap(),
	/**
	 * The secret patient key, encrypted in the patient's own AES key.
	 */
	@param:DefaultValue("emptySet()")
	override val secretForeignKeys: Set<String> = emptySet(),
	/**
	 * The patient id encrypted in the delegates' AES keys.
	 */
	@param:DefaultValue("emptyMap()")
	override val cryptedForeignKeys: Map<String, Set<Delegation>> = emptyMap(),
	/**
	 * The delegations giving access to connected healthcare information.
	 */
	@param:DefaultValue("emptyMap()")
	override val delegations: Map<String, Set<Delegation>> = emptyMap(),
	/**
	 * The keys used to encrypt this entity when stored encrypted.
	 */
	@param:DefaultValue("emptyMap()")
	override val encryptionKeys: Map<String, Set<Delegation>> = emptyMap(),
	/**
	 * The base64-encoded encrypted fields of this entity.
	 */
	override val encryptedSelf: Base64String? = null,
	/**
	 * The security metadata of the entity.
	 */
	override val securityMetadata: SecurityMetadata? = null,
) : Invoice
