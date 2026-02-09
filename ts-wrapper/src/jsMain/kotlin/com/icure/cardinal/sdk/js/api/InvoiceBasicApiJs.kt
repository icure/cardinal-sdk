// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.model.EncryptedInvoiceJs
import com.icure.cardinal.sdk.js.model.InvoiceJs
import com.icure.cardinal.sdk.js.model.PaginatedListJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.model.`data`.LabelledOccurenceJs
import com.icure.cardinal.sdk.js.model.embed.EncryptedInvoicingCodeJs
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.Unit
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("InvoiceBasicApi")
public external interface InvoiceBasicApiJs {
	public val inGroup: InvoiceBasicInGroupApiJs

	public fun deleteInvoiceById(entityId: String, rev: String): Promise<StoredDocumentIdentifierJs>

	public fun deleteInvoicesByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<StoredDocumentIdentifierJs>>

	public fun purgeInvoiceById(id: String, rev: String): Promise<Unit>

	public fun purgeInvoicesByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<StoredDocumentIdentifierJs>>

	public fun deleteInvoice(invoice: InvoiceJs): Promise<StoredDocumentIdentifierJs>

	public fun deleteInvoices(invoices: Array<InvoiceJs>): Promise<Array<StoredDocumentIdentifierJs>>

	public fun purgeInvoice(invoice: InvoiceJs): Promise<Unit>

	public fun purgeInvoices(invoices: Array<InvoiceJs>): Promise<Array<StoredDocumentIdentifierJs>>

	public fun getTarificationsCodesOccurrences(minOccurrence: Double):
			Promise<Array<LabelledOccurenceJs>>

	public fun createInvoice(entity: EncryptedInvoiceJs): Promise<EncryptedInvoiceJs>

	public fun createInvoices(entities: Array<EncryptedInvoiceJs>): Promise<Array<EncryptedInvoiceJs>>

	public fun undeleteInvoiceById(id: String, rev: String): Promise<EncryptedInvoiceJs>

	public fun undeleteInvoicesByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<EncryptedInvoiceJs>>

	public fun undeleteInvoice(invoice: InvoiceJs): Promise<EncryptedInvoiceJs>

	public fun undeleteInvoices(invoices: Array<InvoiceJs>): Promise<Array<EncryptedInvoiceJs>>

	public fun modifyInvoice(entity: EncryptedInvoiceJs): Promise<EncryptedInvoiceJs>

	public fun modifyInvoices(entities: Array<EncryptedInvoiceJs>): Promise<Array<EncryptedInvoiceJs>>

	public fun getInvoice(entityId: String): Promise<EncryptedInvoiceJs?>

	public fun getInvoices(entityIds: Array<String>): Promise<Array<EncryptedInvoiceJs>>

	public fun reassignInvoice(invoice: EncryptedInvoiceJs): Promise<EncryptedInvoiceJs>

	public fun mergeTo(invoiceId: String, ids: Array<String>): Promise<EncryptedInvoiceJs>

	public fun validate(
		invoiceId: String,
		scheme: String,
		forcedValue: String,
	): Promise<EncryptedInvoiceJs>

	public fun appendCodes(
		userId: String,
		type: String,
		sentMediumType: String,
		secretFKeys: String,
		invoicingCodes: Array<EncryptedInvoicingCodeJs>,
		options: dynamic,
	): Promise<Array<EncryptedInvoiceJs>>

	public fun removeCodes(
		userId: String,
		serviceId: String,
		secretFKeys: String,
		tarificationIds: Array<String>,
	): Promise<Array<EncryptedInvoiceJs>>

	public fun findInvoicesByAuthor(hcPartyId: String, options: dynamic):
			Promise<PaginatedListJs<EncryptedInvoiceJs>>

	public fun listInvoicesByHcPartyAndGroupId(hcPartyId: String, groupId: String):
			Promise<Array<EncryptedInvoiceJs>>

	public fun listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate(
		hcPartyId: String,
		sentMediumType: String,
		invoiceType: String,
		sent: Boolean,
		options: dynamic,
	): Promise<Array<EncryptedInvoiceJs>>

	public fun listInvoicesByContactIds(contactIds: Array<String>): Promise<Array<EncryptedInvoiceJs>>

	public fun listInvoicesByRecipientsIds(recipientsIds: Array<String>):
			Promise<Array<EncryptedInvoiceJs>>

	public fun listToInsurances(userIds: Array<String>): Promise<Array<EncryptedInvoiceJs>>

	public fun listToInsurancesUnsent(userIds: Array<String>): Promise<Array<EncryptedInvoiceJs>>

	public fun listToPatients(hcPartyId: String): Promise<Array<EncryptedInvoiceJs>>

	public fun listToPatientsUnsent(hcPartyId: String?): Promise<Array<EncryptedInvoiceJs>>

	public fun listInvoicesByIds(ids: Array<String>): Promise<Array<EncryptedInvoiceJs>>

	public fun listInvoicesByHcpartySendingModeStatusDate(
		hcPartyId: String,
		sendingMode: String,
		status: String,
		from: Double,
		to: Double,
	): Promise<Array<EncryptedInvoiceJs>>

	public fun listInvoicesByServiceIds(serviceIds: Array<String>): Promise<Array<EncryptedInvoiceJs>>

	public fun listAllHcpsByStatus(
		status: String,
		hcpIds: Array<String>,
		options: dynamic,
	): Promise<Array<EncryptedInvoiceJs>>
}
