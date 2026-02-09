// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.model.DecryptedInvoiceJs
import com.icure.cardinal.sdk.js.model.EncryptedInvoiceJs
import com.icure.cardinal.sdk.js.model.EntityReferenceInGroupJs
import com.icure.cardinal.sdk.js.model.GroupScopedJs
import com.icure.cardinal.sdk.js.model.InvoiceJs
import com.icure.cardinal.sdk.js.model.PatientJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.synthetic.mapasobjectarray.EntityReferenceInGroupToInvoiceShareOptionsMapObject_delegate_shareOptions
import kotlin.Array
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("InvoiceInGroupApi")
public external interface InvoiceInGroupApiJs {
	public val encrypted: InvoiceFlavouredInGroupApiJs<EncryptedInvoiceJs>

	public val tryAndRecover: InvoiceFlavouredInGroupApiJs<InvoiceJs>

	public fun withEncryptionMetadata(
		entityGroupId: String,
		base: DecryptedInvoiceJs?,
		patient: GroupScopedJs<PatientJs>?,
		options: dynamic,
	): Promise<GroupScopedJs<DecryptedInvoiceJs>>

	public fun getEncryptionKeysOf(invoice: GroupScopedJs<InvoiceJs>): Promise<Array<String>>

	public fun hasWriteAccess(invoice: GroupScopedJs<InvoiceJs>): Promise<Boolean>

	public fun decryptPatientIdOf(invoice: GroupScopedJs<InvoiceJs>):
			Promise<Array<EntityReferenceInGroupJs>>

	public fun createDelegationDeAnonymizationMetadata(entity: GroupScopedJs<InvoiceJs>,
			delegates: Array<EntityReferenceInGroupJs>): Promise<Unit>

	public fun decrypt(invoices: Array<GroupScopedJs<EncryptedInvoiceJs>>):
			Promise<Array<GroupScopedJs<DecryptedInvoiceJs>>>

	public fun tryDecrypt(invoices: Array<GroupScopedJs<EncryptedInvoiceJs>>):
			Promise<Array<GroupScopedJs<InvoiceJs>>>

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

	public fun shareWith(
		`delegate`: EntityReferenceInGroupJs,
		invoice: GroupScopedJs<DecryptedInvoiceJs>,
		options: dynamic,
	): Promise<GroupScopedJs<DecryptedInvoiceJs>>

	public fun shareWithMany(invoice: GroupScopedJs<DecryptedInvoiceJs>,
			delegates: Array<EntityReferenceInGroupToInvoiceShareOptionsMapObject_delegate_shareOptions>):
			Promise<GroupScopedJs<DecryptedInvoiceJs>>

	public fun createInvoice(entity: GroupScopedJs<DecryptedInvoiceJs>):
			Promise<GroupScopedJs<DecryptedInvoiceJs>>

	public fun createInvoices(entities: Array<GroupScopedJs<DecryptedInvoiceJs>>):
			Promise<Array<GroupScopedJs<DecryptedInvoiceJs>>>

	public fun undeleteInvoiceById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
			Promise<GroupScopedJs<DecryptedInvoiceJs>>

	public fun undeleteInvoicesByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
			Promise<Array<GroupScopedJs<DecryptedInvoiceJs>>>

	public fun undeleteInvoice(invoice: GroupScopedJs<InvoiceJs>):
			Promise<GroupScopedJs<DecryptedInvoiceJs>>

	public fun undeleteInvoices(invoices: Array<GroupScopedJs<DecryptedInvoiceJs>>):
			Promise<Array<GroupScopedJs<DecryptedInvoiceJs>>>

	public fun modifyInvoice(entity: GroupScopedJs<DecryptedInvoiceJs>):
			Promise<GroupScopedJs<DecryptedInvoiceJs>>

	public fun modifyInvoices(entities: Array<GroupScopedJs<DecryptedInvoiceJs>>):
			Promise<Array<GroupScopedJs<DecryptedInvoiceJs>>>

	public fun getInvoice(groupId: String, entityId: String):
			Promise<GroupScopedJs<DecryptedInvoiceJs>?>

	public fun getInvoices(groupId: String, entityIds: Array<String>):
			Promise<Array<GroupScopedJs<DecryptedInvoiceJs>>>
}
