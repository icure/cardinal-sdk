// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.crypto.entities.EntityAccessInformationJs
import com.icure.cardinal.sdk.js.model.CustomEntityBaseJs
import com.icure.cardinal.sdk.js.model.EncryptedCustomEntityBaseJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import kotlin.Array
import kotlin.Boolean
import kotlin.ByteArray
import kotlin.String
import kotlin.Unit
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("CustomEntityBasicApi")
public external interface CustomEntityBasicApiJs {
	public val inGroup: CustomEntityBasicInGroupApiJs

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

	public fun createEntity(entity: EncryptedCustomEntityBaseJs): Promise<EncryptedCustomEntityBaseJs>

	public fun createEntities(entities: Array<EncryptedCustomEntityBaseJs>): Promise<Array<EncryptedCustomEntityBaseJs>>

	public fun undeleteEntityById(id: String, rev: String): Promise<EncryptedCustomEntityBaseJs>

	public fun undeleteEntitiesByIds(entityIds: Array<StoredDocumentIdentifierJs>): Promise<Array<EncryptedCustomEntityBaseJs>>

	public fun undeleteEntity(entity: CustomEntityBaseJs): Promise<EncryptedCustomEntityBaseJs>

	public fun undeleteEntities(entities: Array<CustomEntityBaseJs>): Promise<Array<EncryptedCustomEntityBaseJs>>

	public fun modifyEntity(entity: EncryptedCustomEntityBaseJs): Promise<EncryptedCustomEntityBaseJs>

	public fun modifyEntities(entities: Array<EncryptedCustomEntityBaseJs>): Promise<Array<EncryptedCustomEntityBaseJs>>

	public fun getEntity(entityId: String): Promise<EncryptedCustomEntityBaseJs?>

	public fun getEntities(entityIds: Array<String>): Promise<Array<EncryptedCustomEntityBaseJs>>

	public fun setRawAttachment(
		entityId: String,
		rev: String,
		key: String,
		utis: Array<String>?,
		attachment: ByteArray,
		encrypted: Boolean,
	): Promise<EncryptedCustomEntityBaseJs>

	public fun setAttachment(
		entityId: String,
		rev: String,
		key: String,
		utis: Array<String>?,
		attachment: ByteArray,
	): Promise<EncryptedCustomEntityBaseJs>

	public fun deleteAttachment(
		entityId: String,
		rev: String,
		key: String,
	): Promise<EncryptedCustomEntityBaseJs>
}
