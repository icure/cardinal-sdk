// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.model.EncryptedInvoiceJs
import com.icure.cardinal.sdk.js.model.GroupScopedJs
import com.icure.cardinal.sdk.js.model.InvoiceJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import kotlin.Array
import kotlin.String
import kotlin.Unit
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("InvoiceBasicInGroupApi")
public external interface InvoiceBasicInGroupApiJs {
	public fun deleteInvoiceById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
			Promise<GroupScopedJs<StoredDocumentIdentifierJs>>

	public fun deleteInvoicesByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
			Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>>

	public fun purgeInvoiceById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>): Promise<Unit>

	public fun purgeInvoicesByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
			Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>>

	public fun deleteInvoice(invoice: GroupScopedJs<InvoiceJs>):
			Promise<GroupScopedJs<StoredDocumentIdentifierJs>>

	public fun deleteInvoices(invoices: Array<GroupScopedJs<InvoiceJs>>):
			Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>>

	public fun purgeInvoice(invoice: GroupScopedJs<InvoiceJs>): Promise<Unit>

	public fun purgeInvoices(invoices: Array<GroupScopedJs<InvoiceJs>>):
			Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>>

	public fun createInvoice(entity: GroupScopedJs<EncryptedInvoiceJs>):
			Promise<GroupScopedJs<EncryptedInvoiceJs>>

	public fun createInvoices(entities: Array<GroupScopedJs<EncryptedInvoiceJs>>):
			Promise<Array<GroupScopedJs<EncryptedInvoiceJs>>>

	public fun undeleteInvoiceById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
			Promise<GroupScopedJs<EncryptedInvoiceJs>>

	public fun undeleteInvoicesByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
			Promise<Array<GroupScopedJs<EncryptedInvoiceJs>>>

	public fun undeleteInvoice(invoice: GroupScopedJs<InvoiceJs>):
			Promise<GroupScopedJs<EncryptedInvoiceJs>>

	public fun undeleteInvoices(invoices: Array<GroupScopedJs<EncryptedInvoiceJs>>):
			Promise<Array<GroupScopedJs<EncryptedInvoiceJs>>>

	public fun modifyInvoice(entity: GroupScopedJs<EncryptedInvoiceJs>):
			Promise<GroupScopedJs<EncryptedInvoiceJs>>

	public fun modifyInvoices(entities: Array<GroupScopedJs<EncryptedInvoiceJs>>):
			Promise<Array<GroupScopedJs<EncryptedInvoiceJs>>>

	public fun getInvoice(groupId: String, entityId: String):
			Promise<GroupScopedJs<EncryptedInvoiceJs>?>

	public fun getInvoices(groupId: String, entityIds: Array<String>):
			Promise<Array<GroupScopedJs<EncryptedInvoiceJs>>>
}
