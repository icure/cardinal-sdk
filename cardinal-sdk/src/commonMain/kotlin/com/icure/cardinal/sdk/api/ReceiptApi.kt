package com.icure.cardinal.sdk.api

import com.icure.cardinal.sdk.crypto.entities.ReceiptShareOptions
import com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption
import com.icure.cardinal.sdk.crypto.entities.ShareMetadataBehaviour
import com.icure.cardinal.sdk.exceptions.RevisionConflictException
import com.icure.cardinal.sdk.model.DecryptedReceipt
import com.icure.cardinal.sdk.model.EncryptedReceipt
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.model.GroupScoped
import com.icure.cardinal.sdk.model.Receipt
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
import com.icure.cardinal.sdk.model.User
import com.icure.cardinal.sdk.model.embed.AccessLevel
import com.icure.cardinal.sdk.model.specializations.HexString
import com.icure.cardinal.sdk.model.toStoredDocumentIdentifier
import com.icure.cardinal.sdk.utils.DefaultValue
import com.icure.cardinal.sdk.utils.generation.JsMapAsObjectArray

/* This interface includes the API calls that do not need encryption keys and do not return or consume encrypted/decrypted items, they are completely agnostic towards the presence of encrypted items */
interface ReceiptBasicFlavourlessApi {
	/**
	 * Deletes a receipt. If you don't have write access to the receipt the method will fail.
	 * @param entityId id of the receipt.
	 * @param rev the latest known rev of the receipt to delete
	 * @return the id and revision of the deleted receipt.
	 * @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	suspend fun deleteReceiptById(entityId: String, rev: String): StoredDocumentIdentifier

	/**
	 * Deletes many receipts. Ids that do not correspond to an entity, or that correspond to an entity for which
	 * you don't have write access will be ignored.
	 * @param entityIds ids and revisions of the receipts to delete.
	 * @return the id and revision of the deleted receipts. If some entities could not be deleted (for example
	 * because you had no write access to them) they will not be included in this list.
	 */
	suspend fun deleteReceiptsByIds(entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier>

	/**
	 * Permanently deletes a receipt.
	 * @param id id of the receipt to purge
	 * @param rev latest revision of the receipt
	 * @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	suspend fun purgeReceiptById(id: String, rev: String)

	/**
	 * Permanently deletes many receipts.
	 * @param entityIds ids and revisions of the receipts to delete
	 * @return the id and revision of the deleted receipts. If some entities couldn't be deleted (for example
	 * because you had no write access to them) they will not be included in this list.
	 */
	suspend fun purgeReceiptsByIds(entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier>

	/**
	 * Deletes a receipt. If you don't have write access to the receipt the method will fail.
	 * @param receipt the receipt to delete
	 * @return the id and revision of the deleted receipt.
	 * @throws RevisionConflictException if the provided receipt doesn't match the latest known revision
	 */
	suspend fun deleteReceipt(receipt: Receipt): StoredDocumentIdentifier =
		deleteReceiptById(receipt.id, requireNotNull(receipt.rev) { "Can't delete a receipt that has no rev" })

	/**
	 * Deletes many receipts. Ignores receipt for which you don't have write access or that don't match the latest revision.
	 * @param receipts the receipts to delete
	 * @return the id and revision of the deleted receipts. If some entities couldn't be deleted they will not be
	 * included in this list.
	 */
	suspend fun deleteReceipts(receipts: List<Receipt>): List<StoredDocumentIdentifier> =
		deleteReceiptsByIds(receipts.map { receipt ->
			receipt.toStoredDocumentIdentifier()
		})

	/**
	 * Permanently deletes a receipt.
	 * @param receipt the receipt to purge.
	 * @throws RevisionConflictException if the provided receipt doesn't match the latest known revision
	 */
	suspend fun purgeReceipt(receipt: Receipt) {
		purgeReceiptById(receipt.id, requireNotNull(receipt.rev) { "Can't delete a receipt that has no rev" })
	}

	/**
	 * Permanently deletes many receipts.
	 * @param receipts the receipts to purge.
	 * @return the id and revision of the deleted receipts. If some entities couldn't be deleted (for example
	 * because you had no write access to them) they will not be included in this list.
	 */
	suspend fun purgeReceipts(receipts: List<Receipt>): List<StoredDocumentIdentifier> =
		purgeReceiptsByIds(receipts.map { it.toStoredDocumentIdentifier() })

	suspend fun getRawReceiptAttachment(receiptId: String, attachmentId: String): ByteArray
	suspend fun setRawReceiptAttachment(receiptId: String, rev: String, blobType: String, attachment: ByteArray): EncryptedReceipt
}

interface ReceiptBasicFlavourlessInGroupApi {
	/**
	 * In-group version of [ReceiptBasicFlavourlessApi.deleteReceiptById]
	 */
	suspend fun deleteReceiptById(entityId: GroupScoped<StoredDocumentIdentifier>): GroupScoped<StoredDocumentIdentifier>

	/**
	 * In-group version of [ReceiptBasicFlavourlessApi.deleteReceiptsByIds]
	 */
	suspend fun deleteReceiptsByIds(entityIds: List<GroupScoped<StoredDocumentIdentifier>>): List<GroupScoped<StoredDocumentIdentifier>>

	/**
	 * In-group version of [ReceiptBasicFlavourlessApi.purgeReceiptById]
	 */
	suspend fun purgeReceiptById(entityId: GroupScoped<StoredDocumentIdentifier>)

	/**
	 * In-group version of [ReceiptBasicFlavourlessApi.purgeReceiptsByIds]
	 */
	suspend fun purgeReceiptsByIds(entityIds: List<GroupScoped<StoredDocumentIdentifier>>): List<GroupScoped<StoredDocumentIdentifier>>

	/**
	 * In-group version of [ReceiptBasicFlavourlessApi.deleteReceipt]
	 */
	suspend fun deleteReceipt(receipt: GroupScoped<Receipt>): GroupScoped<StoredDocumentIdentifier> =
		deleteReceiptById(receipt.toStoredDocumentIdentifier())

	/**
	 * In-group version of [ReceiptBasicFlavourlessApi.deleteReceipts]
	 */
	suspend fun deleteReceipts(receipts: List<GroupScoped<Receipt>>): List<GroupScoped<StoredDocumentIdentifier>> =
		deleteReceiptsByIds(receipts.toStoredDocumentIdentifier())

	/**
	 * In-group version of [ReceiptBasicFlavourlessApi.purgeReceipt]
	 */
	suspend fun purgeReceipt(receipt: GroupScoped<Receipt>) {
		purgeReceiptById(receipt.toStoredDocumentIdentifier())
	}

	/**
	 * In-group version of [ReceiptBasicFlavourlessApi.purgeReceipts]
	 */
	suspend fun purgeReceipts(receipts: List<GroupScoped<Receipt>>): List<GroupScoped<StoredDocumentIdentifier>> =
		purgeReceiptsByIds(receipts.map { it.toStoredDocumentIdentifier() })
}

/* This interface includes the API calls can be used on decrypted items if encryption keys are available *or* encrypted items if no encryption keys are available */
interface ReceiptBasicFlavouredApi<E : Receipt> {
	/**
	 * Create a new receipt. The provided receipt must have the encryption metadata initialized.
	 * @param entity a receipt with initialized encryption metadata
	 * @return the created receipt with updated revision.
	 * @throws IllegalArgumentException if the encryption metadata of the input was not initialized.
	 */
	suspend fun createReceipt(entity: E): E

	/**
	 * Create multiple receipts. All the provided receipts must have the encryption metadata initialized, otherwise
	 * this method fails without doing anything.
	 * @param entities receipts with initialized encryption metadata
	 * @return the created receipts with updated revision.
	 * @throws IllegalArgumentException if the encryption metadata of any receipt in the input was not initialized.
	 */
	suspend fun createReceipts(entities: List<E>): List<E>

	/**
	 * Restores a receipt that was marked as deleted.
	 * @param id the id of the entity
	 * @param rev the latest revision of the entity.
	 * @return the restored entity.
	 * @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	suspend fun undeleteReceiptById(id: String, rev: String): E

	/**
	 * Restores a batch of receiptIds that were marked as deleted.
	 * @param entityIds the ids and the revisions of the receiptIds to restore.
	 * @return the restored receiptIds. If some entities couldn't be restored (because the user does not have access or the revision is not
	 * up-to-date), then those entities will not be restored and will not appear in this list.
	 */
	suspend fun undeleteReceiptsByIds(entityIds: List<StoredDocumentIdentifier>): List<E>

	/**
	 * Restores a receipt that was marked as deleted.
	 * @param receipt the receipt to undelete
	 * @return the restored receipt.
	 * @throws RevisionConflictException if the provided receipt doesn't match the latest known revision
	 */
	suspend fun undeleteReceipt(receipt: Receipt): E =
		undeleteReceiptById(receipt.id, requireNotNull(receipt.rev) { "Can't delete a receipt that has no rev" })

	/**
	 * Restores a batch of receipts that were marked as deleted.
	 * @param receipts the receipts to restore.
	 * @return the restored receipts. If some entities couldn't be restored (because the user does not have access or the revision is not
	 * up-to-date), then those entities will not be restored and will not appear in this list.
	 */
	suspend fun undeleteReceipts(receipts: List<Receipt>): List<E> =
		undeleteReceiptsByIds(receipts.map { it.toStoredDocumentIdentifier() })

	/**
	 * Modifies a receipt. You need to have write access to the entity.
	 * Flavoured method.
	 * @param entity a receipt with update content
	 * @return the receipt updated with the provided content and a new revision.
	 */
	suspend fun modifyReceipt(entity: E): E

	/**
	 * Modifies multiple receipts. Ignores all receipts for which you don't have write access.
	 * Flavoured method.
	 * @param entities receipts with update content
	 * @return the updated receipts with a new revision.
	 */
	suspend fun modifyReceipts(entities: List<E>): List<E>

	/**
	 * Get a receipt by its id. You must have read access to the entity. Fails if the id does not correspond to any
	 * entity, corresponds to an entity that is not a receipt, or corresponds to an entity for which you don't have
	 * read access.
	 * Flavoured method.
	 * @param entityId a receipt id.
	 * @return the receipt with id [entityId].
	 */
	suspend fun getReceipt(entityId: String): E?

	/**
	 * Get multiple receipts by their ids. Ignores all ids that do not correspond to an entity, correspond to
	 * an entity that is not a receipt, or correspond to an entity for which you don't have read access.
	 * Flavoured method.
	 * @param entityIds a list of receipts ids
	 * @return all receipts that you can access with one of the provided ids.
	 */
	suspend fun getReceipts(entityIds: List<String>): List<E>

	suspend fun listByReference(reference: String): List<E>
}

interface ReceiptBasicFlavouredInGroupApi<E : Receipt> {
	/**
	 * In-group version of [ReceiptApi.createReceipt]
	 */
	suspend fun createReceipt(entity: GroupScoped<E>): GroupScoped<E>

	/**
	 * In-group version of [ReceiptApi.createReceipts]
	 */
	suspend fun createReceipts(entities: List<GroupScoped<E>>): List<GroupScoped<E>>

	/**
	 * In-group version of [ReceiptBasicFlavouredApi.undeleteReceiptById]
	 */
	suspend fun undeleteReceiptById(entityId: GroupScoped<StoredDocumentIdentifier>): GroupScoped<E>

	/**
	 * In-group version of [ReceiptBasicFlavouredApi.undeleteReceiptsByIds]
	 */
	suspend fun undeleteReceiptsByIds(entityIds: List<GroupScoped<StoredDocumentIdentifier>>): List<GroupScoped<E>>

	/**
	 * In-group version of [ReceiptBasicFlavouredApi.undeleteReceipt]
	 */
	suspend fun undeleteReceipt(receipt: GroupScoped<Receipt>): GroupScoped<E> =
		undeleteReceiptById(receipt.toStoredDocumentIdentifier())

	/**
	 * In-group version of [ReceiptBasicFlavouredApi.undeleteReceipts]
	 */
	suspend fun undeleteReceipts(receipts: List<GroupScoped<E>>): List<GroupScoped<E>> =
		undeleteReceiptsByIds(receipts.map { it.toStoredDocumentIdentifier() })

	/**
	 * In-group version of [ReceiptBasicFlavouredApi.modifyReceipt]
	 */
	suspend fun modifyReceipt(entity: GroupScoped<E>): GroupScoped<E>

	/**
	 * In-group version of [ReceiptBasicFlavouredApi.modifyReceipts]
	 */
	suspend fun modifyReceipts(entities: List<GroupScoped<E>>): List<GroupScoped<E>>

	/**
	 * In-group version of [ReceiptBasicFlavouredApi.getReceipt]
	 */
	suspend fun getReceipt(groupId: String, entityId: String): GroupScoped<E>?

	/**
	 * In-group version of [ReceiptBasicFlavouredApi.getReceipts]
	 */
	suspend fun getReceipts(groupId: String, entityIds: List<String>): List<GroupScoped<E>>
}

/* The extra API calls declared in this interface are the ones that can be used on encrypted or decrypted items but only when the user is a data owner */
interface ReceiptFlavouredApi<E : Receipt> : ReceiptBasicFlavouredApi<E> {
	suspend fun shareWith(
		delegateId: String,
		receipt: E,
		@DefaultValue("null")
		options: ReceiptShareOptions? = null
	): E

	/**
	 * Shares an existing access log with other data owners, allowing them to access the non-encrypted data of the access log and optionally also the
	 * encrypted content, with read-only or read-write permissions.
	 * @param receipt the [Receipt] to share.
	 * @param delegates associates the id of data owners which will be granted access to the entity, to the following sharing options:
	 * - shareEncryptionKey: specifies if the encryption key of the access log should be shared with the delegate, giving access to all encrypted
	 * content of the entity, excluding other encrypted metadata (defaults to [ShareMetadataBehaviour.IfAvailable]).
	 * - sharePatientId: specifies if the id of the patient that this access log refers to should be shared with the delegate. Normally this would
	 * be the same as objectId, but it is encrypted separately from it allowing you to give access to the patient id without giving access to the other
	 * encrypted data of the access log (defaults to [ShareMetadataBehaviour.IfAvailable]).
	 * - requestedPermissions: the requested permissions for the delegate, defaults to [ShareMetadataBehaviour.IfAvailable].
	 * @return the updated entity.
	 * @throws IllegalStateException if the operation was not successful.
	 */
	suspend fun shareWithMany(
		receipt: E,
		delegates: Map<String, ReceiptShareOptions>
	): E
}

interface ReceiptFlavouredInGroupApi<E : Receipt> : ReceiptBasicFlavouredInGroupApi<E> {
	/**
	 * In-group version of [ReceiptFlavouredApi.shareWith]
	 */
	suspend fun shareWith(
		delegate: EntityReferenceInGroup,
		receipt: GroupScoped<E>,
		@DefaultValue("null")
		options: ReceiptShareOptions? = null
	): GroupScoped<E>

	/**
	 * In-group version of [ReceiptFlavouredApi.shareWithMany]
	 */
	suspend fun shareWithMany(
		receipt: GroupScoped<E>,
		delegates: @JsMapAsObjectArray(keyEntryName = "delegate", valueEntryName = "shareOptions") Map<EntityReferenceInGroup, ReceiptShareOptions>
	): GroupScoped<E>
}

/* The extra API calls declared in this interface are the ones that can only be used on decrypted items when encryption keys are available */
@Deprecated("The receipt API and model are highly specialised for the belgian market. They will be provided as a separate package in future")
interface ReceiptApi : ReceiptBasicFlavourlessApi, ReceiptFlavouredApi<DecryptedReceipt> {
	suspend fun withEncryptionMetadata(
		base: DecryptedReceipt?,
		patient: Patient?,
		@DefaultValue("null")
		user: User? = null,
		@DefaultValue("emptyMap()")
		delegates: Map<String, AccessLevel> = emptyMap(),
		@DefaultValue("com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption.UseAnySharedWithParent")
		secretId: SecretIdUseOption = SecretIdUseOption.UseAnySharedWithParent,
		@DefaultValue("null")
		alternateRootDelegateId: String? = null,
	): DecryptedReceipt
	suspend fun getAndDecryptReceiptAttachment(receipt: Receipt, attachmentId: String): ByteArray
	suspend fun encryptAndSetReceiptAttachment(receipt: Receipt, blobType: String, attachment: ByteArray): EncryptedReceipt
	suspend fun getEncryptionKeysOf(receipt: Receipt): Set<HexString>
	suspend fun hasWriteAccess(receipt: Receipt): Boolean
	suspend fun decryptPatientIdOf(receipt: Receipt): Set<EntityReferenceInGroup>
	suspend fun createDelegationDeAnonymizationMetadata(entity: Receipt, delegates: Set<String>)
	suspend fun logReceipt(user: User, docId: String, refs: List<String>, blobType: String, blob: ByteArray): Receipt
	suspend fun decrypt(receipt: EncryptedReceipt): DecryptedReceipt
	suspend fun tryDecrypt(receipt: EncryptedReceipt): Receipt

	val encrypted: ReceiptFlavouredApi<EncryptedReceipt>
	val tryAndRecover: ReceiptFlavouredApi<Receipt>
	val inGroup: ReceiptInGroupApi
}

@Deprecated("The receipt API and model are highly specialised for the belgian market. They will be provided as a separate package in future")
interface ReceiptInGroupApi : ReceiptBasicFlavourlessInGroupApi, ReceiptFlavouredInGroupApi<DecryptedReceipt> {

	val encrypted: ReceiptFlavouredInGroupApi<EncryptedReceipt>
	val tryAndRecover: ReceiptFlavouredInGroupApi<Receipt>

	/**
	 * In-group version of [ReceiptApi.withEncryptionMetadata]
	 */
	suspend fun withEncryptionMetadata(
		groupId: String,
		base: DecryptedReceipt?,
		patient: GroupScoped<Patient>?,
		@DefaultValue("null")
		user: User? = null,
		@DefaultValue("emptyMap()")
		delegates: Map<String, AccessLevel> = emptyMap(),
		@DefaultValue("com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption.UseAnySharedWithParent")
		secretId: SecretIdUseOption = SecretIdUseOption.UseAnySharedWithParent,
		@DefaultValue("null")
		alternateRootDelegateId: String? = null,
	): GroupScoped<DecryptedReceipt>

	/**
	 * In-group version of [ReceiptApi.getEncryptionKeysOf]
	 */
	suspend fun getEncryptionKeysOf(receipt: GroupScoped<Receipt>): Set<HexString>

	/**
	 * In-group version of [ReceiptApi.hasWriteAccess]
	 */
	suspend fun hasWriteAccess(receipt: GroupScoped<Receipt>): Boolean

	/**
	 * In-group version of [ReceiptApi.decryptPatientIdOf]
	 */
	suspend fun decryptPatientIdOf(receipt: GroupScoped<Receipt>): Set<EntityReferenceInGroup>

	/**
	 * In-group version of [ReceiptApi.createDelegationDeAnonymizationMetadata]
	 */
	suspend fun createDelegationDeAnonymizationMetadata(entity: GroupScoped<Receipt>, delegates: Set<EntityReferenceInGroup>)

	/**
	 * In-group version of [ReceiptApi.decrypt]
	 */
	suspend fun decrypt(receipts: List<GroupScoped<EncryptedReceipt>>): List<GroupScoped<DecryptedReceipt>>

	/**
	 * In-group version of [ReceiptApi.tryDecrypt]
	 */
	suspend fun tryDecrypt(receipts: List<GroupScoped<EncryptedReceipt>>): List<GroupScoped<Receipt>>
}

@Deprecated("The receipt API and model are highly specialised for the belgian market. They will be provided as a separate package in future")
interface ReceiptBasicApi : ReceiptBasicFlavourlessApi, ReceiptBasicFlavouredApi<EncryptedReceipt> {
	val inGroup: ReceiptBasicInGroupApi
}

@Deprecated("The receipt API and model are highly specialised for the belgian market. They will be provided as a separate package in future")
interface ReceiptBasicInGroupApi : ReceiptBasicFlavourlessInGroupApi, ReceiptBasicFlavouredInGroupApi<EncryptedReceipt>

