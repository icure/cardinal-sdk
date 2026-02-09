// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.model.EncryptedReceiptJs
import com.icure.cardinal.sdk.js.model.ReceiptJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import kotlin.Array
import kotlin.ByteArray
import kotlin.String
import kotlin.Unit
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("ReceiptBasicApi")
public external interface ReceiptBasicApiJs {
	public val inGroup: ReceiptBasicInGroupApiJs

	public fun deleteReceiptById(entityId: String, rev: String): Promise<StoredDocumentIdentifierJs>

	public fun deleteReceiptsByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<StoredDocumentIdentifierJs>>

	public fun purgeReceiptById(id: String, rev: String): Promise<Unit>

	public fun purgeReceiptsByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<StoredDocumentIdentifierJs>>

	public fun deleteReceipt(receipt: ReceiptJs): Promise<StoredDocumentIdentifierJs>

	public fun deleteReceipts(receipts: Array<ReceiptJs>): Promise<Array<StoredDocumentIdentifierJs>>

	public fun purgeReceipt(receipt: ReceiptJs): Promise<Unit>

	public fun purgeReceipts(receipts: Array<ReceiptJs>): Promise<Array<StoredDocumentIdentifierJs>>

	public fun getRawReceiptAttachment(receiptId: String, attachmentId: String): Promise<ByteArray>

	public fun setRawReceiptAttachment(
		receiptId: String,
		rev: String,
		blobType: String,
		attachment: ByteArray,
	): Promise<EncryptedReceiptJs>

	public fun createReceipt(entity: EncryptedReceiptJs): Promise<EncryptedReceiptJs>

	public fun createReceipts(entities: Array<EncryptedReceiptJs>): Promise<Array<EncryptedReceiptJs>>

	public fun undeleteReceiptById(id: String, rev: String): Promise<EncryptedReceiptJs>

	public fun undeleteReceiptsByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<EncryptedReceiptJs>>

	public fun undeleteReceipt(receipt: ReceiptJs): Promise<EncryptedReceiptJs>

	public fun undeleteReceipts(receipts: Array<ReceiptJs>): Promise<Array<EncryptedReceiptJs>>

	public fun modifyReceipt(entity: EncryptedReceiptJs): Promise<EncryptedReceiptJs>

	public fun modifyReceipts(entities: Array<EncryptedReceiptJs>): Promise<Array<EncryptedReceiptJs>>

	public fun getReceipt(entityId: String): Promise<EncryptedReceiptJs?>

	public fun getReceipts(entityIds: Array<String>): Promise<Array<EncryptedReceiptJs>>

	public fun listByReference(reference: String): Promise<Array<EncryptedReceiptJs>>
}
