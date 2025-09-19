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
import com.icure.cardinal.sdk.model.embed.InvoiceInterventionType
import com.icure.cardinal.sdk.model.embed.InvoiceType
import com.icure.cardinal.sdk.model.embed.InvoicingCode
import com.icure.cardinal.sdk.model.embed.MediumType
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

public sealed interface Invoice :
	StoredDocument,
	ICureDocument<String>,
	HasEncryptionMetadata,
	Encryptable {
	override val id: String

	override val rev: String?

	public val identifier: List<Identifier>

	override val created: Long?

	override val modified: Long?

	override val author: String?

	override val responsible: String?

	override val medicalLocationId: String?

	override val tags: Set<CodeStub>

	override val codes: Set<CodeStub>

	override val endOfLife: Long?

	override val deletionDate: Long?

	public val invoiceDate: Long?

	public val sentDate: Long?

	public val printedDate: Long?

	public val invoicingCodes: List<InvoicingCode>

	public val receipts: Map<String, String>

	public val recipientType: String?

	public val recipientId: String?

	public val invoiceReference: String?

	public val decisionReference: String?

	public val thirdPartyReference: String?

	public val thirdPartyPaymentJustification: String?

	public val thirdPartyPaymentReason: String?

	public val reason: String?

	public val invoiceType: InvoiceType?

	public val sentMediumType: MediumType?

	public val interventionType: InvoiceInterventionType?

	public val groupId: String?

	public val paymentType: PaymentType?

	public val paid: Double?

	public val payments: List<Payment>?

	public val gnotionNihii: String?

	public val gnotionSsin: String?

	public val gnotionLastName: String?

	public val gnotionFirstName: String?

	public val gnotionCdHcParty: String?

	public val invoicePeriod: Int?

	public val careProviderType: String?

	public val internshipNihii: String?

	public val internshipSsin: String?

	public val internshipLastName: String?

	public val internshipFirstName: String?

	public val internshipCdHcParty: String?

	public val internshipCbe: String?

	public val supervisorNihii: String?

	public val supervisorSsin: String?

	public val supervisorLastName: String?

	public val supervisorFirstName: String?

	public val supervisorCdHcParty: String?

	public val supervisorCbe: String?

	public val error: String?

	public val encounterLocationName: String?

	public val encounterLocationNihii: String?

	public val encounterLocationNorm: Int?

	public val longDelayJustification: Int?

	public val correctiveInvoiceId: String?

	public val correctedInvoiceId: String?

	public val creditNote: Boolean?

	public val creditNoteRelatedInvoiceId: String?

	public val idDocument: IdentityDocumentReader?

	public val admissionDate: Long?

	public val locationNihii: String?

	public val locationService: Int?

	public val cancelReason: String?

	public val cancelDate: Long?

	public val options: Map<String, String>

	override val secretForeignKeys: Set<String>

	override val cryptedForeignKeys: Map<String, Set<Delegation>>

	override val delegations: Map<String, Set<Delegation>>

	override val encryptionKeys: Map<String, Set<Delegation>>

	override val encryptedSelf: Base64String?

	override val securityMetadata: SecurityMetadata?
}

@Serializable
public data class DecryptedInvoice(
	override val id: String,
	override val rev: String? = null,
	@DefaultValue("emptyList()")
	override val identifier: List<Identifier> = emptyList(),
	override val created: Long? = null,
	override val modified: Long? = null,
	override val author: String? = null,
	override val responsible: String? = null,
	override val medicalLocationId: String? = null,
	@DefaultValue("emptySet()")
	override val tags: Set<CodeStub> = emptySet(),
	@DefaultValue("emptySet()")
	override val codes: Set<CodeStub> = emptySet(),
	override val endOfLife: Long? = null,
	override val deletionDate: Long? = null,
	override val invoiceDate: Long? = null,
	override val sentDate: Long? = null,
	override val printedDate: Long? = null,
	@DefaultValue("emptyList()")
	override val invoicingCodes: List<DecryptedInvoicingCode> = emptyList(),
	@DefaultValue("emptyMap()")
	override val receipts: Map<String, String> = emptyMap(),
	override val recipientType: String? = null,
	override val recipientId: String? = null,
	override val invoiceReference: String? = null,
	override val decisionReference: String? = null,
	override val thirdPartyReference: String? = null,
	override val thirdPartyPaymentJustification: String? = null,
	override val thirdPartyPaymentReason: String? = null,
	override val reason: String? = null,
	override val invoiceType: InvoiceType? = null,
	override val sentMediumType: MediumType? = null,
	override val interventionType: InvoiceInterventionType? = null,
	override val groupId: String? = null,
	override val paymentType: PaymentType? = null,
	override val paid: Double? = null,
	override val payments: List<Payment>? = null,
	override val gnotionNihii: String? = null,
	override val gnotionSsin: String? = null,
	override val gnotionLastName: String? = null,
	override val gnotionFirstName: String? = null,
	override val gnotionCdHcParty: String? = null,
	override val invoicePeriod: Int? = null,
	override val careProviderType: String? = null,
	override val internshipNihii: String? = null,
	override val internshipSsin: String? = null,
	override val internshipLastName: String? = null,
	override val internshipFirstName: String? = null,
	override val internshipCdHcParty: String? = null,
	override val internshipCbe: String? = null,
	override val supervisorNihii: String? = null,
	override val supervisorSsin: String? = null,
	override val supervisorLastName: String? = null,
	override val supervisorFirstName: String? = null,
	override val supervisorCdHcParty: String? = null,
	override val supervisorCbe: String? = null,
	override val error: String? = null,
	override val encounterLocationName: String? = null,
	override val encounterLocationNihii: String? = null,
	override val encounterLocationNorm: Int? = null,
	override val longDelayJustification: Int? = null,
	override val correctiveInvoiceId: String? = null,
	override val correctedInvoiceId: String? = null,
	override val creditNote: Boolean? = null,
	override val creditNoteRelatedInvoiceId: String? = null,
	override val idDocument: IdentityDocumentReader? = null,
	override val admissionDate: Long? = null,
	override val locationNihii: String? = null,
	override val locationService: Int? = null,
	override val cancelReason: String? = null,
	override val cancelDate: Long? = null,
	@DefaultValue("emptyMap()")
	override val options: Map<String, String> = emptyMap(),
	@DefaultValue("emptySet()")
	override val secretForeignKeys: Set<String> = emptySet(),
	@DefaultValue("emptyMap()")
	override val cryptedForeignKeys: Map<String, Set<Delegation>> = emptyMap(),
	@DefaultValue("emptyMap()")
	override val delegations: Map<String, Set<Delegation>> = emptyMap(),
	@DefaultValue("emptyMap()")
	override val encryptionKeys: Map<String, Set<Delegation>> = emptyMap(),
	override val encryptedSelf: Base64String? = null,
	override val securityMetadata: SecurityMetadata? = null,
) : Invoice

@Serializable
public data class EncryptedInvoice(
	override val id: String,
	override val rev: String? = null,
	@DefaultValue("emptyList()")
	override val identifier: List<Identifier> = emptyList(),
	override val created: Long? = null,
	override val modified: Long? = null,
	override val author: String? = null,
	override val responsible: String? = null,
	override val medicalLocationId: String? = null,
	@DefaultValue("emptySet()")
	override val tags: Set<CodeStub> = emptySet(),
	@DefaultValue("emptySet()")
	override val codes: Set<CodeStub> = emptySet(),
	override val endOfLife: Long? = null,
	override val deletionDate: Long? = null,
	override val invoiceDate: Long? = null,
	override val sentDate: Long? = null,
	override val printedDate: Long? = null,
	@DefaultValue("emptyList()")
	override val invoicingCodes: List<EncryptedInvoicingCode> = emptyList(),
	@DefaultValue("emptyMap()")
	override val receipts: Map<String, String> = emptyMap(),
	override val recipientType: String? = null,
	override val recipientId: String? = null,
	override val invoiceReference: String? = null,
	override val decisionReference: String? = null,
	override val thirdPartyReference: String? = null,
	override val thirdPartyPaymentJustification: String? = null,
	override val thirdPartyPaymentReason: String? = null,
	override val reason: String? = null,
	override val invoiceType: InvoiceType? = null,
	override val sentMediumType: MediumType? = null,
	override val interventionType: InvoiceInterventionType? = null,
	override val groupId: String? = null,
	override val paymentType: PaymentType? = null,
	override val paid: Double? = null,
	override val payments: List<Payment>? = null,
	override val gnotionNihii: String? = null,
	override val gnotionSsin: String? = null,
	override val gnotionLastName: String? = null,
	override val gnotionFirstName: String? = null,
	override val gnotionCdHcParty: String? = null,
	override val invoicePeriod: Int? = null,
	override val careProviderType: String? = null,
	override val internshipNihii: String? = null,
	override val internshipSsin: String? = null,
	override val internshipLastName: String? = null,
	override val internshipFirstName: String? = null,
	override val internshipCdHcParty: String? = null,
	override val internshipCbe: String? = null,
	override val supervisorNihii: String? = null,
	override val supervisorSsin: String? = null,
	override val supervisorLastName: String? = null,
	override val supervisorFirstName: String? = null,
	override val supervisorCdHcParty: String? = null,
	override val supervisorCbe: String? = null,
	override val error: String? = null,
	override val encounterLocationName: String? = null,
	override val encounterLocationNihii: String? = null,
	override val encounterLocationNorm: Int? = null,
	override val longDelayJustification: Int? = null,
	override val correctiveInvoiceId: String? = null,
	override val correctedInvoiceId: String? = null,
	override val creditNote: Boolean? = null,
	override val creditNoteRelatedInvoiceId: String? = null,
	override val idDocument: IdentityDocumentReader? = null,
	override val admissionDate: Long? = null,
	override val locationNihii: String? = null,
	override val locationService: Int? = null,
	override val cancelReason: String? = null,
	override val cancelDate: Long? = null,
	@DefaultValue("emptyMap()")
	override val options: Map<String, String> = emptyMap(),
	@DefaultValue("emptySet()")
	override val secretForeignKeys: Set<String> = emptySet(),
	@DefaultValue("emptyMap()")
	override val cryptedForeignKeys: Map<String, Set<Delegation>> = emptyMap(),
	@DefaultValue("emptyMap()")
	override val delegations: Map<String, Set<Delegation>> = emptyMap(),
	@DefaultValue("emptyMap()")
	override val encryptionKeys: Map<String, Set<Delegation>> = emptyMap(),
	override val encryptedSelf: Base64String? = null,
	override val securityMetadata: SecurityMetadata? = null,
) : Invoice
