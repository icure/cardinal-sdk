// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.crypto.entities.ReceiptShareOptionsJs
import com.icure.cardinal.sdk.js.model.DecryptedReceiptJs
import com.icure.cardinal.sdk.js.model.EncryptedReceiptJs
import com.icure.cardinal.sdk.js.model.EntityReferenceInGroupJs
import com.icure.cardinal.sdk.js.model.PatientJs
import com.icure.cardinal.sdk.js.model.ReceiptJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.model.UserJs
import com.icure.cardinal.sdk.js.utils.Record
import kotlin.Array
import kotlin.Boolean
import kotlin.ByteArray
import kotlin.String
import kotlin.Unit
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("ReceiptApi")
public external interface ReceiptApiJs {
	public val encrypted: ReceiptFlavouredApiJs<EncryptedReceiptJs>

	public val tryAndRecover: ReceiptFlavouredApiJs<ReceiptJs>

	public val inGroup: ReceiptInGroupApiJs

	public fun withEncryptionMetadata(
		base: DecryptedReceiptJs?,
		patient: PatientJs?,
		options: dynamic,
	): Promise<DecryptedReceiptJs>

	public fun getAndDecryptReceiptAttachment(receipt: ReceiptJs, attachmentId: String):
			Promise<ByteArray>

	public fun encryptAndSetReceiptAttachment(
		receipt: ReceiptJs,
		blobType: String,
		attachment: ByteArray,
	): Promise<EncryptedReceiptJs>

	public fun getEncryptionKeysOf(receipt: ReceiptJs): Promise<Array<String>>

	public fun hasWriteAccess(receipt: ReceiptJs): Promise<Boolean>

	public fun decryptPatientIdOf(receipt: ReceiptJs): Promise<Array<EntityReferenceInGroupJs>>

	public fun createDelegationDeAnonymizationMetadata(entity: ReceiptJs, delegates: Array<String>):
			Promise<Unit>

	public fun logReceipt(
		user: UserJs,
		docId: String,
		refs: Array<String>,
		blobType: String,
		blob: ByteArray,
	): Promise<ReceiptJs>

	public fun decrypt(receipt: EncryptedReceiptJs): Promise<DecryptedReceiptJs>

	public fun tryDecrypt(receipt: EncryptedReceiptJs): Promise<ReceiptJs>

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

	public fun shareWith(
		delegateId: String,
		receipt: DecryptedReceiptJs,
		options: dynamic,
	): Promise<DecryptedReceiptJs>

	public fun shareWithMany(receipt: DecryptedReceiptJs,
			delegates: Record<String, ReceiptShareOptionsJs>): Promise<DecryptedReceiptJs>

	public fun createReceipt(entity: DecryptedReceiptJs): Promise<DecryptedReceiptJs>

	public fun createReceipts(entities: Array<DecryptedReceiptJs>): Promise<Array<DecryptedReceiptJs>>

	public fun undeleteReceiptById(id: String, rev: String): Promise<DecryptedReceiptJs>

	public fun undeleteReceiptsByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<DecryptedReceiptJs>>

	public fun undeleteReceipt(receipt: ReceiptJs): Promise<DecryptedReceiptJs>

	public fun undeleteReceipts(receipts: Array<ReceiptJs>): Promise<Array<DecryptedReceiptJs>>

	public fun modifyReceipt(entity: DecryptedReceiptJs): Promise<DecryptedReceiptJs>

	public fun modifyReceipts(entities: Array<DecryptedReceiptJs>): Promise<Array<DecryptedReceiptJs>>

	public fun getReceipt(entityId: String): Promise<DecryptedReceiptJs?>

	public fun getReceipts(entityIds: Array<String>): Promise<Array<DecryptedReceiptJs>>

	public fun listByReference(reference: String): Promise<Array<DecryptedReceiptJs>>
}
