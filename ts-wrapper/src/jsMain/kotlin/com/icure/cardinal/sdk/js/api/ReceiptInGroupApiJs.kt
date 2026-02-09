// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.model.DecryptedReceiptJs
import com.icure.cardinal.sdk.js.model.EncryptedReceiptJs
import com.icure.cardinal.sdk.js.model.EntityReferenceInGroupJs
import com.icure.cardinal.sdk.js.model.GroupScopedJs
import com.icure.cardinal.sdk.js.model.PatientJs
import com.icure.cardinal.sdk.js.model.ReceiptJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.synthetic.mapasobjectarray.EntityReferenceInGroupToReceiptShareOptionsMapObject_delegate_shareOptions
import kotlin.Array
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("ReceiptInGroupApi")
public external interface ReceiptInGroupApiJs {
	public val encrypted: ReceiptFlavouredInGroupApiJs<EncryptedReceiptJs>

	public val tryAndRecover: ReceiptFlavouredInGroupApiJs<ReceiptJs>

	public fun withEncryptionMetadata(
		groupId: String,
		base: DecryptedReceiptJs?,
		patient: GroupScopedJs<PatientJs>?,
		options: dynamic,
	): Promise<GroupScopedJs<DecryptedReceiptJs>>

	public fun getEncryptionKeysOf(receipt: GroupScopedJs<ReceiptJs>): Promise<Array<String>>

	public fun hasWriteAccess(receipt: GroupScopedJs<ReceiptJs>): Promise<Boolean>

	public fun decryptPatientIdOf(receipt: GroupScopedJs<ReceiptJs>):
			Promise<Array<EntityReferenceInGroupJs>>

	public fun createDelegationDeAnonymizationMetadata(entity: GroupScopedJs<ReceiptJs>,
			delegates: Array<EntityReferenceInGroupJs>): Promise<Unit>

	public fun decrypt(receipts: Array<GroupScopedJs<EncryptedReceiptJs>>):
			Promise<Array<GroupScopedJs<DecryptedReceiptJs>>>

	public fun tryDecrypt(receipts: Array<GroupScopedJs<EncryptedReceiptJs>>):
			Promise<Array<GroupScopedJs<ReceiptJs>>>

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

	public fun shareWith(
		`delegate`: EntityReferenceInGroupJs,
		receipt: GroupScopedJs<DecryptedReceiptJs>,
		options: dynamic,
	): Promise<GroupScopedJs<DecryptedReceiptJs>>

	public fun shareWithMany(receipt: GroupScopedJs<DecryptedReceiptJs>,
			delegates: Array<EntityReferenceInGroupToReceiptShareOptionsMapObject_delegate_shareOptions>):
			Promise<GroupScopedJs<DecryptedReceiptJs>>

	public fun createReceipt(entity: GroupScopedJs<DecryptedReceiptJs>):
			Promise<GroupScopedJs<DecryptedReceiptJs>>

	public fun createReceipts(entities: Array<GroupScopedJs<DecryptedReceiptJs>>):
			Promise<Array<GroupScopedJs<DecryptedReceiptJs>>>

	public fun undeleteReceiptById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
			Promise<GroupScopedJs<DecryptedReceiptJs>>

	public fun undeleteReceiptsByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
			Promise<Array<GroupScopedJs<DecryptedReceiptJs>>>

	public fun undeleteReceipt(receipt: GroupScopedJs<ReceiptJs>):
			Promise<GroupScopedJs<DecryptedReceiptJs>>

	public fun undeleteReceipts(receipts: Array<GroupScopedJs<DecryptedReceiptJs>>):
			Promise<Array<GroupScopedJs<DecryptedReceiptJs>>>

	public fun modifyReceipt(entity: GroupScopedJs<DecryptedReceiptJs>):
			Promise<GroupScopedJs<DecryptedReceiptJs>>

	public fun modifyReceipts(entities: Array<GroupScopedJs<DecryptedReceiptJs>>):
			Promise<Array<GroupScopedJs<DecryptedReceiptJs>>>

	public fun getReceipt(groupId: String, entityId: String):
			Promise<GroupScopedJs<DecryptedReceiptJs>?>

	public fun getReceipts(groupId: String, entityIds: Array<String>):
			Promise<Array<GroupScopedJs<DecryptedReceiptJs>>>
}
