// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.crypto.entities.EntityAccessInformationJs
import com.icure.cardinal.sdk.js.model.CustomEntityBaseJs
import com.icure.cardinal.sdk.js.model.EncryptedCustomEntityBaseJs
import com.icure.cardinal.sdk.js.model.GroupScopedJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import kotlin.Array
import kotlin.String
import kotlin.Unit
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("CustomEntityBasicInGroupApi")
public external interface CustomEntityBasicInGroupApiJs {
	public fun deleteEntityById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>): Promise<GroupScopedJs<StoredDocumentIdentifierJs>>

	public fun deleteEntitiesByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>): Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>>

	public fun purgeEntityById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>): Promise<Unit>

	public fun purgeEntitiesByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>): Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>>

	public fun deleteEntity(entity: GroupScopedJs<CustomEntityBaseJs>): Promise<GroupScopedJs<StoredDocumentIdentifierJs>>

	public fun deleteEntities(entities: Array<GroupScopedJs<CustomEntityBaseJs>>): Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>>

	public fun purgeEntity(entity: GroupScopedJs<CustomEntityBaseJs>): Promise<Unit>

	public fun purgeEntities(entities: Array<GroupScopedJs<CustomEntityBaseJs>>): Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>>

	public fun getDataOwnersWithAccessTo(entity: GroupScopedJs<CustomEntityBaseJs>): Promise<EntityAccessInformationJs>

	public fun createEntity(entity: GroupScopedJs<EncryptedCustomEntityBaseJs>): Promise<GroupScopedJs<EncryptedCustomEntityBaseJs>>

	public fun createEntities(entities: Array<GroupScopedJs<EncryptedCustomEntityBaseJs>>): Promise<Array<GroupScopedJs<EncryptedCustomEntityBaseJs>>>

	public fun undeleteEntityById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>): Promise<GroupScopedJs<EncryptedCustomEntityBaseJs>>

	public fun undeleteEntitiesByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>): Promise<Array<GroupScopedJs<EncryptedCustomEntityBaseJs>>>

	public fun undeleteEntity(entity: GroupScopedJs<CustomEntityBaseJs>): Promise<GroupScopedJs<EncryptedCustomEntityBaseJs>>

	public fun undeleteEntities(entities: Array<GroupScopedJs<CustomEntityBaseJs>>): Promise<Array<GroupScopedJs<EncryptedCustomEntityBaseJs>>>

	public fun modifyEntity(entity: GroupScopedJs<EncryptedCustomEntityBaseJs>): Promise<GroupScopedJs<EncryptedCustomEntityBaseJs>>

	public fun modifyEntities(entities: Array<GroupScopedJs<EncryptedCustomEntityBaseJs>>): Promise<Array<GroupScopedJs<EncryptedCustomEntityBaseJs>>>

	public fun getEntity(groupId: String, entityId: String): Promise<GroupScopedJs<EncryptedCustomEntityBaseJs>?>

	public fun getEntities(groupId: String, entityIds: Array<String>): Promise<Array<GroupScopedJs<EncryptedCustomEntityBaseJs>>>
}
