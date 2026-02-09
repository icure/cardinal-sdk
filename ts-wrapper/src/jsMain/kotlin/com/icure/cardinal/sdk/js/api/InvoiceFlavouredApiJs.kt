// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.crypto.entities.InvoiceShareOptionsJs
import com.icure.cardinal.sdk.js.model.InvoiceJs
import com.icure.cardinal.sdk.js.model.PaginatedListJs
import com.icure.cardinal.sdk.js.model.PatientJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.model.embed.EncryptedInvoicingCodeJs
import com.icure.cardinal.sdk.js.utils.Record
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("InvoiceFlavouredApi")
public external interface InvoiceFlavouredApiJs<E : InvoiceJs> {
	public fun shareWith(
		delegateId: String,
		invoice: E,
		options: dynamic,
	): Promise<E>

	public fun shareWithMany(invoice: E, delegates: Record<String, InvoiceShareOptionsJs>): Promise<E>

	public fun findInvoicesByHcPartyPatient(
		hcPartyId: String,
		patient: PatientJs,
		options: dynamic,
	): Promise<PaginatedListIteratorJs<E>>

	public fun createInvoice(entity: E): Promise<E>

	public fun createInvoices(entities: Array<E>): Promise<Array<E>>

	public fun undeleteInvoiceById(id: String, rev: String): Promise<E>

	public fun undeleteInvoicesByIds(entityIds: Array<StoredDocumentIdentifierJs>): Promise<Array<E>>

	public fun undeleteInvoice(invoice: InvoiceJs): Promise<E>

	public fun undeleteInvoices(invoices: Array<InvoiceJs>): Promise<Array<E>>

	public fun modifyInvoice(entity: E): Promise<E>

	public fun modifyInvoices(entities: Array<E>): Promise<Array<E>>

	public fun getInvoice(entityId: String): Promise<E?>

	public fun getInvoices(entityIds: Array<String>): Promise<Array<E>>

	public fun reassignInvoice(invoice: E): Promise<E>

	public fun mergeTo(invoiceId: String, ids: Array<String>): Promise<E>

	public fun validate(
		invoiceId: String,
		scheme: String,
		forcedValue: String,
	): Promise<E>

	public fun appendCodes(
		userId: String,
		type: String,
		sentMediumType: String,
		secretFKeys: String,
		invoicingCodes: Array<EncryptedInvoicingCodeJs>,
		options: dynamic,
	): Promise<Array<E>>

	public fun removeCodes(
		userId: String,
		serviceId: String,
		secretFKeys: String,
		tarificationIds: Array<String>,
	): Promise<Array<E>>

	public fun findInvoicesByAuthor(hcPartyId: String, options: dynamic): Promise<PaginatedListJs<E>>

	public fun listInvoicesByHcPartyAndGroupId(hcPartyId: String, groupId: String): Promise<Array<E>>

	public fun listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate(
		hcPartyId: String,
		sentMediumType: String,
		invoiceType: String,
		sent: Boolean,
		options: dynamic,
	): Promise<Array<E>>

	public fun listInvoicesByContactIds(contactIds: Array<String>): Promise<Array<E>>

	public fun listInvoicesByRecipientsIds(recipientsIds: Array<String>): Promise<Array<E>>

	public fun listToInsurances(userIds: Array<String>): Promise<Array<E>>

	public fun listToInsurancesUnsent(userIds: Array<String>): Promise<Array<E>>

	public fun listToPatients(hcPartyId: String): Promise<Array<E>>

	public fun listToPatientsUnsent(hcPartyId: String?): Promise<Array<E>>

	public fun listInvoicesByIds(ids: Array<String>): Promise<Array<E>>

	public fun listInvoicesByHcpartySendingModeStatusDate(
		hcPartyId: String,
		sendingMode: String,
		status: String,
		from: Double,
		to: Double,
	): Promise<Array<E>>

	public fun listInvoicesByServiceIds(serviceIds: Array<String>): Promise<Array<E>>

	public fun listAllHcpsByStatus(
		status: String,
		hcpIds: Array<String>,
		options: dynamic,
	): Promise<Array<E>>
}
