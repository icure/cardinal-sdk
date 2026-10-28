// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.crypto.entities.BulkShareByIdsResultJs
import com.icure.cardinal.sdk.js.crypto.entities.CustomEntityDelegateOptionsJs
import com.icure.cardinal.sdk.js.crypto.entities.CustomEntityShareOptionsJs
import com.icure.cardinal.sdk.js.crypto.entities.EntityAccessInformationJs
import com.icure.cardinal.sdk.js.model.CustomEntityBaseJs
import com.icure.cardinal.sdk.js.model.DecryptedCustomEntityBaseJs
import com.icure.cardinal.sdk.js.model.EncryptedCustomEntityBaseJs
import com.icure.cardinal.sdk.js.model.EntityReferenceInGroupJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.utils.Record
import kotlin.Array
import kotlin.Boolean
import kotlin.ByteArray
import kotlin.String
import kotlin.Unit
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("CustomEntityApi")
public external interface CustomEntityApiJs {
	public val encrypted: CustomEntityFlavouredApiJs<EncryptedCustomEntityBaseJs>

	public val tryAndRecover: CustomEntityFlavouredApiJs<CustomEntityBaseJs>

	public val inGroup: CustomEntityInGroupApiJs

	public fun withEncryptionMetadata(base: DecryptedCustomEntityBaseJs?, options: dynamic): Promise<DecryptedCustomEntityBaseJs>

	public fun withEncryptionMetadataAndDelegates(
		base: DecryptedCustomEntityBaseJs?,
		delegates: Record<String, CustomEntityDelegateOptionsJs>,
		options: dynamic,
	): Promise<DecryptedCustomEntityBaseJs>

	public fun getEncryptionKeysOf(entity: CustomEntityBaseJs): Promise<Array<String>>

	public fun getSecretIdsOf(entity: CustomEntityBaseJs): Promise<Record<String, Array<EntityReferenceInGroupJs>>>

	public fun hasWriteAccess(entity: CustomEntityBaseJs): Promise<Boolean>

	public fun decryptOwningEntityIdsOf(entity: CustomEntityBaseJs): Promise<Array<EntityReferenceInGroupJs>>

	public fun createDelegationDeAnonymizationMetadata(entity: CustomEntityBaseJs, delegates: Array<String>): Promise<Unit>

	public fun decrypt(entities: Array<EncryptedCustomEntityBaseJs>): Promise<Array<DecryptedCustomEntityBaseJs>>

	public fun tryDecrypt(entities: Array<EncryptedCustomEntityBaseJs>): Promise<Array<CustomEntityBaseJs>>

	public fun encryptOrValidate(entities: Array<CustomEntityBaseJs>): Promise<Array<EncryptedCustomEntityBaseJs>>

	public fun shareEntitiesByIds(entityIds: Array<String>, delegates: Record<String, CustomEntityShareOptionsJs>): Promise<BulkShareByIdsResultJs>

	public fun getAndTryDecryptAttachment(
		entity: CustomEntityBaseJs,
		key: String,
		options: dynamic,
	): Promise<ByteArray?>

	public fun getAndDecryptAttachment(
		entity: CustomEntityBaseJs,
		key: String,
		options: dynamic,
	): Promise<ByteArray>

	public fun tryDecryptAttachment(
		entity: CustomEntityBaseJs,
		encryptedAttachment: ByteArray,
		options: dynamic,
	): Promise<ByteArray?>

	public fun encryptAndSetAttachment(
		entity: CustomEntityBaseJs,
		key: String,
		utis: Array<String>?,
		attachment: ByteArray,
	): Promise<DecryptedCustomEntityBaseJs>

	public fun deleteEntityById(entityId: String, rev: String): Promise<StoredDocumentIdentifierJs>

	public fun deleteEntitiesByIds(entityIds: Array<StoredDocumentIdentifierJs>): Promise<Array<StoredDocumentIdentifierJs>>

	public fun purgeEntityById(id: String, rev: String): Promise<Unit>

	public fun purgeEntitiesByIds(entityIds: Array<StoredDocumentIdentifierJs>): Promise<Array<StoredDocumentIdentifierJs>>

	public fun deleteEntity(entity: CustomEntityBaseJs): Promise<StoredDocumentIdentifierJs>

	public fun deleteEntities(entities: Array<CustomEntityBaseJs>): Promise<Array<StoredDocumentIdentifierJs>>

	public fun purgeEntity(entity: CustomEntityBaseJs): Promise<Unit>

	public fun purgeEntities(entities: Array<CustomEntityBaseJs>): Promise<Array<StoredDocumentIdentifierJs>>

	public fun getRawAttachment(entityId: String, key: String): Promise<ByteArray>

	public fun getAttachment(entityId: String, key: String): Promise<ByteArray>

	public fun getDataOwnersWithAccessTo(entity: CustomEntityBaseJs): Promise<EntityAccessInformationJs>

	public fun shareWith(
		delegateId: String,
		entity: DecryptedCustomEntityBaseJs,
		options: dynamic,
	): Promise<DecryptedCustomEntityBaseJs>

	public fun shareWithMany(entity: DecryptedCustomEntityBaseJs, delegates: Record<String, CustomEntityShareOptionsJs>): Promise<DecryptedCustomEntityBaseJs>

	public fun createEntity(entity: DecryptedCustomEntityBaseJs): Promise<DecryptedCustomEntityBaseJs>

	public fun createEntities(entities: Array<DecryptedCustomEntityBaseJs>): Promise<Array<DecryptedCustomEntityBaseJs>>

	public fun undeleteEntityById(id: String, rev: String): Promise<DecryptedCustomEntityBaseJs>

	public fun undeleteEntitiesByIds(entityIds: Array<StoredDocumentIdentifierJs>): Promise<Array<DecryptedCustomEntityBaseJs>>

	public fun undeleteEntity(entity: CustomEntityBaseJs): Promise<DecryptedCustomEntityBaseJs>

	public fun undeleteEntities(entities: Array<CustomEntityBaseJs>): Promise<Array<DecryptedCustomEntityBaseJs>>

	public fun modifyEntity(entity: DecryptedCustomEntityBaseJs): Promise<DecryptedCustomEntityBaseJs>

	public fun modifyEntities(entities: Array<DecryptedCustomEntityBaseJs>): Promise<Array<DecryptedCustomEntityBaseJs>>

	public fun getEntity(entityId: String): Promise<DecryptedCustomEntityBaseJs?>

	public fun getEntities(entityIds: Array<String>): Promise<Array<DecryptedCustomEntityBaseJs>>

	public fun setRawAttachment(
		entityId: String,
		rev: String,
		key: String,
		utis: Array<String>?,
		attachment: ByteArray,
		encrypted: Boolean,
	): Promise<DecryptedCustomEntityBaseJs>

	public fun setAttachment(
		entityId: String,
		rev: String,
		key: String,
		utis: Array<String>?,
		attachment: ByteArray,
	): Promise<DecryptedCustomEntityBaseJs>

	public fun deleteAttachment(
		entityId: String,
		rev: String,
		key: String,
	): Promise<DecryptedCustomEntityBaseJs>
}
