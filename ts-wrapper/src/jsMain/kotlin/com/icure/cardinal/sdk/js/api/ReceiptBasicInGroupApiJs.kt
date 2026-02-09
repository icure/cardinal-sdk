// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.model.EncryptedReceiptJs
import com.icure.cardinal.sdk.js.model.GroupScopedJs
import com.icure.cardinal.sdk.js.model.ReceiptJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import kotlin.Array
import kotlin.String
import kotlin.Unit
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("ReceiptBasicInGroupApi")
public external interface ReceiptBasicInGroupApiJs {
	public fun deleteReceiptById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
			Promise<GroupScopedJs<StoredDocumentIdentifierJs>>

	public fun deleteReceiptsByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
			Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>>

	public fun purgeReceiptById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>): Promise<Unit>

	public fun purgeReceiptsByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
			Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>>

	public fun deleteReceipt(receipt: GroupScopedJs<ReceiptJs>):
			Promise<GroupScopedJs<StoredDocumentIdentifierJs>>

	public fun deleteReceipts(receipts: Array<GroupScopedJs<ReceiptJs>>):
			Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>>

	public fun purgeReceipt(receipt: GroupScopedJs<ReceiptJs>): Promise<Unit>

	public fun purgeReceipts(receipts: Array<GroupScopedJs<ReceiptJs>>):
			Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>>

	public fun createReceipt(entity: GroupScopedJs<EncryptedReceiptJs>):
			Promise<GroupScopedJs<EncryptedReceiptJs>>

	public fun createReceipts(entities: Array<GroupScopedJs<EncryptedReceiptJs>>):
			Promise<Array<GroupScopedJs<EncryptedReceiptJs>>>

	public fun undeleteReceiptById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
			Promise<GroupScopedJs<EncryptedReceiptJs>>

	public fun undeleteReceiptsByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
			Promise<Array<GroupScopedJs<EncryptedReceiptJs>>>

	public fun undeleteReceipt(receipt: GroupScopedJs<ReceiptJs>):
			Promise<GroupScopedJs<EncryptedReceiptJs>>

	public fun undeleteReceipts(receipts: Array<GroupScopedJs<EncryptedReceiptJs>>):
			Promise<Array<GroupScopedJs<EncryptedReceiptJs>>>

	public fun modifyReceipt(entity: GroupScopedJs<EncryptedReceiptJs>):
			Promise<GroupScopedJs<EncryptedReceiptJs>>

	public fun modifyReceipts(entities: Array<GroupScopedJs<EncryptedReceiptJs>>):
			Promise<Array<GroupScopedJs<EncryptedReceiptJs>>>

	public fun getReceipt(groupId: String, entityId: String):
			Promise<GroupScopedJs<EncryptedReceiptJs>?>

	public fun getReceipts(groupId: String, entityIds: Array<String>):
			Promise<Array<GroupScopedJs<EncryptedReceiptJs>>>
}
