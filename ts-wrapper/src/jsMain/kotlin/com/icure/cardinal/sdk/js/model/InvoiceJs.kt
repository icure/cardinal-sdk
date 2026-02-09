// auto-generated file
@file:JsQualifier("model")

package com.icure.cardinal.sdk.js.model

import com.icure.cardinal.sdk.js.model.base.CodeStubJs
import com.icure.cardinal.sdk.js.model.base.HasEncryptionMetadataJs
import com.icure.cardinal.sdk.js.model.base.ICureDocumentJs
import com.icure.cardinal.sdk.js.model.base.IdentifierJs
import com.icure.cardinal.sdk.js.model.base.StoredDocumentJs
import com.icure.cardinal.sdk.js.model.embed.DecryptedInvoicingCodeJs
import com.icure.cardinal.sdk.js.model.embed.DelegationJs
import com.icure.cardinal.sdk.js.model.embed.EncryptableJs
import com.icure.cardinal.sdk.js.model.embed.EncryptedInvoicingCodeJs
import com.icure.cardinal.sdk.js.model.embed.IdentityDocumentReaderJs
import com.icure.cardinal.sdk.js.model.embed.InvoicingCodeJs
import com.icure.cardinal.sdk.js.model.embed.PaymentJs
import com.icure.cardinal.sdk.js.model.embed.SecurityMetadataJs
import com.icure.cardinal.sdk.js.utils.Record
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("Invoice")
public sealed external interface InvoiceJs : StoredDocumentJs, ICureDocumentJs<String>,
		HasEncryptionMetadataJs, EncryptableJs {
	public val identifier: Array<out IdentifierJs>

	public val invoiceDate: Double?

	public val sentDate: Double?

	public val printedDate: Double?

	public val invoicingCodes: Array<out InvoicingCodeJs>

	public val receipts: Record<String, out String>

	public val recipientId: String?

	public val invoiceReference: String?

	public val decisionReference: String?

	public val thirdPartyReference: String?

	public val thirdPartyPaymentJustification: String?

	public val thirdPartyPaymentReason: String?

	public val reason: String?

	public val groupId: String?

	public val paymentType: String?

	public val paid: Double?

	public val payments: Array<out PaymentJs>?

	public val gnotionSsin: String?

	public val gnotionLastName: String?

	public val gnotionFirstName: String?

	public val gnotionCdHcParty: String?

	public val invoicePeriod: Double?

	public val careProviderType: String?

	public val internshipSsin: String?

	public val internshipLastName: String?

	public val internshipFirstName: String?

	public val internshipCdHcParty: String?

	public val internshipCbe: String?

	public val supervisorSsin: String?

	public val supervisorLastName: String?

	public val supervisorFirstName: String?

	public val supervisorCdHcParty: String?

	public val supervisorCbe: String?

	public val error: String?

	public val encounterLocationName: String?

	public val encounterLocationNorm: Double?

	public val longDelayJustification: Double?

	public val correctiveInvoiceId: String?

	public val correctedInvoiceId: String?

	public val creditNote: Boolean?

	public val creditNoteRelatedInvoiceId: String?

	public val idDocument: IdentityDocumentReaderJs?

	public val admissionDate: Double?

	public val locationService: Double?

	public val cancelReason: String?

	public val cancelDate: Double?

	public val options: Record<String, out String>

	public val isEncrypted: Boolean
}

@JsName("DecryptedInvoice")
public external class DecryptedInvoiceJs(
	partial: dynamic,
) : InvoiceJs {
	override val id: String

	override val rev: String?

	override val identifier: Array<IdentifierJs>

	override val created: Double?

	override val modified: Double?

	override val author: String?

	override val responsible: String?

	override val tags: Array<CodeStubJs>

	override val codes: Array<CodeStubJs>

	override val deletionDate: Double?

	override val invoiceDate: Double?

	override val sentDate: Double?

	override val printedDate: Double?

	override val invoicingCodes: Array<DecryptedInvoicingCodeJs>

	override val receipts: Record<String, String>

	override val recipientId: String?

	override val invoiceReference: String?

	override val decisionReference: String?

	override val thirdPartyReference: String?

	override val thirdPartyPaymentJustification: String?

	override val thirdPartyPaymentReason: String?

	override val reason: String?

	override val groupId: String?

	override val paymentType: String?

	override val paid: Double?

	override val payments: Array<PaymentJs>?

	override val gnotionSsin: String?

	override val gnotionLastName: String?

	override val gnotionFirstName: String?

	override val gnotionCdHcParty: String?

	override val invoicePeriod: Double?

	override val careProviderType: String?

	override val internshipSsin: String?

	override val internshipLastName: String?

	override val internshipFirstName: String?

	override val internshipCdHcParty: String?

	override val internshipCbe: String?

	override val supervisorSsin: String?

	override val supervisorLastName: String?

	override val supervisorFirstName: String?

	override val supervisorCdHcParty: String?

	override val supervisorCbe: String?

	override val error: String?

	override val encounterLocationName: String?

	override val encounterLocationNorm: Double?

	override val longDelayJustification: Double?

	override val correctiveInvoiceId: String?

	override val correctedInvoiceId: String?

	override val creditNote: Boolean?

	override val creditNoteRelatedInvoiceId: String?

	override val idDocument: IdentityDocumentReaderJs?

	override val admissionDate: Double?

	override val locationService: Double?

	override val cancelReason: String?

	override val cancelDate: Double?

	override val options: Record<String, String>

	override val secretForeignKeys: Array<String>

	override val cryptedForeignKeys: Record<String, Array<DelegationJs>>

	override val delegations: Record<String, Array<DelegationJs>>

	override val encryptionKeys: Record<String, Array<DelegationJs>>

	override val encryptedSelf: String?

	override val securityMetadata: SecurityMetadataJs?

	override val isEncrypted: Boolean
}

@JsName("EncryptedInvoice")
public external class EncryptedInvoiceJs(
	partial: dynamic,
) : InvoiceJs {
	override val id: String

	override val rev: String?

	override val identifier: Array<IdentifierJs>

	override val created: Double?

	override val modified: Double?

	override val author: String?

	override val responsible: String?

	override val tags: Array<CodeStubJs>

	override val codes: Array<CodeStubJs>

	override val deletionDate: Double?

	override val invoiceDate: Double?

	override val sentDate: Double?

	override val printedDate: Double?

	override val invoicingCodes: Array<EncryptedInvoicingCodeJs>

	override val receipts: Record<String, String>

	override val recipientId: String?

	override val invoiceReference: String?

	override val decisionReference: String?

	override val thirdPartyReference: String?

	override val thirdPartyPaymentJustification: String?

	override val thirdPartyPaymentReason: String?

	override val reason: String?

	override val groupId: String?

	override val paymentType: String?

	override val paid: Double?

	override val payments: Array<PaymentJs>?

	override val gnotionSsin: String?

	override val gnotionLastName: String?

	override val gnotionFirstName: String?

	override val gnotionCdHcParty: String?

	override val invoicePeriod: Double?

	override val careProviderType: String?

	override val internshipSsin: String?

	override val internshipLastName: String?

	override val internshipFirstName: String?

	override val internshipCdHcParty: String?

	override val internshipCbe: String?

	override val supervisorSsin: String?

	override val supervisorLastName: String?

	override val supervisorFirstName: String?

	override val supervisorCdHcParty: String?

	override val supervisorCbe: String?

	override val error: String?

	override val encounterLocationName: String?

	override val encounterLocationNorm: Double?

	override val longDelayJustification: Double?

	override val correctiveInvoiceId: String?

	override val correctedInvoiceId: String?

	override val creditNote: Boolean?

	override val creditNoteRelatedInvoiceId: String?

	override val idDocument: IdentityDocumentReaderJs?

	override val admissionDate: Double?

	override val locationService: Double?

	override val cancelReason: String?

	override val cancelDate: Double?

	override val options: Record<String, String>

	override val secretForeignKeys: Array<String>

	override val cryptedForeignKeys: Record<String, Array<DelegationJs>>

	override val delegations: Record<String, Array<DelegationJs>>

	override val encryptionKeys: Record<String, Array<DelegationJs>>

	override val encryptedSelf: String?

	override val securityMetadata: SecurityMetadataJs?

	override val isEncrypted: Boolean
}
