// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.model.EntityReferenceInGroupJs
import com.icure.cardinal.sdk.js.model.GroupScopedJs
import com.icure.cardinal.sdk.js.model.InvoiceJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.synthetic.mapasobjectarray.EntityReferenceInGroupToInvoiceShareOptionsMapObject_delegate_shareOptions
import kotlin.Array
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("InvoiceFlavouredInGroupApi")
public external interface InvoiceFlavouredInGroupApiJs<E : InvoiceJs> {
	public fun shareWith(
		`delegate`: EntityReferenceInGroupJs,
		invoice: GroupScopedJs<E>,
		options: dynamic,
	): Promise<GroupScopedJs<E>>

	public fun shareWithMany(invoice: GroupScopedJs<E>,
			delegates: Array<EntityReferenceInGroupToInvoiceShareOptionsMapObject_delegate_shareOptions>):
			Promise<GroupScopedJs<E>>

	public fun createInvoice(entity: GroupScopedJs<E>): Promise<GroupScopedJs<E>>

	public fun createInvoices(entities: Array<GroupScopedJs<E>>): Promise<Array<GroupScopedJs<E>>>

	public fun undeleteInvoiceById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
			Promise<GroupScopedJs<E>>

	public fun undeleteInvoicesByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
			Promise<Array<GroupScopedJs<E>>>

	public fun undeleteInvoice(invoice: GroupScopedJs<InvoiceJs>): Promise<GroupScopedJs<E>>

	public fun undeleteInvoices(invoices: Array<GroupScopedJs<E>>): Promise<Array<GroupScopedJs<E>>>

	public fun modifyInvoice(entity: GroupScopedJs<E>): Promise<GroupScopedJs<E>>

	public fun modifyInvoices(entities: Array<GroupScopedJs<E>>): Promise<Array<GroupScopedJs<E>>>

	public fun getInvoice(groupId: String, entityId: String): Promise<GroupScopedJs<E>?>

	public fun getInvoices(groupId: String, entityIds: Array<String>): Promise<Array<GroupScopedJs<E>>>
}
