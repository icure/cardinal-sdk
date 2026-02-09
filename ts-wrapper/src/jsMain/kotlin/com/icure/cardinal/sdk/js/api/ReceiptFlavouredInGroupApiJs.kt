// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.model.EntityReferenceInGroupJs
import com.icure.cardinal.sdk.js.model.GroupScopedJs
import com.icure.cardinal.sdk.js.model.ReceiptJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.synthetic.mapasobjectarray.EntityReferenceInGroupToReceiptShareOptionsMapObject_delegate_shareOptions
import kotlin.Array
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("ReceiptFlavouredInGroupApi")
public external interface ReceiptFlavouredInGroupApiJs<E : ReceiptJs> {
	public fun shareWith(
		`delegate`: EntityReferenceInGroupJs,
		receipt: GroupScopedJs<E>,
		options: dynamic,
	): Promise<GroupScopedJs<E>>

	public fun shareWithMany(receipt: GroupScopedJs<E>,
			delegates: Array<EntityReferenceInGroupToReceiptShareOptionsMapObject_delegate_shareOptions>):
			Promise<GroupScopedJs<E>>

	public fun createReceipt(entity: GroupScopedJs<E>): Promise<GroupScopedJs<E>>

	public fun createReceipts(entities: Array<GroupScopedJs<E>>): Promise<Array<GroupScopedJs<E>>>

	public fun undeleteReceiptById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
			Promise<GroupScopedJs<E>>

	public fun undeleteReceiptsByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
			Promise<Array<GroupScopedJs<E>>>

	public fun undeleteReceipt(receipt: GroupScopedJs<ReceiptJs>): Promise<GroupScopedJs<E>>

	public fun undeleteReceipts(receipts: Array<GroupScopedJs<E>>): Promise<Array<GroupScopedJs<E>>>

	public fun modifyReceipt(entity: GroupScopedJs<E>): Promise<GroupScopedJs<E>>

	public fun modifyReceipts(entities: Array<GroupScopedJs<E>>): Promise<Array<GroupScopedJs<E>>>

	public fun getReceipt(groupId: String, entityId: String): Promise<GroupScopedJs<E>?>

	public fun getReceipts(groupId: String, entityIds: Array<String>): Promise<Array<GroupScopedJs<E>>>
}
