// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.model.CustomEntityBaseJs
import com.icure.cardinal.sdk.js.model.EntityReferenceInGroupJs
import com.icure.cardinal.sdk.js.model.GroupScopedJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.synthetic.mapasobjectarray.EntityReferenceInGroupToCustomEntityShareOptionsMapObject_delegate_shareOptions
import kotlin.Array
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("CustomEntityFlavouredInGroupApi")
public external interface CustomEntityFlavouredInGroupApiJs<E : CustomEntityBaseJs> {
	public fun shareWith(
		`delegate`: EntityReferenceInGroupJs,
		entity: GroupScopedJs<E>,
		options: dynamic,
	): Promise<GroupScopedJs<E>>

	public fun shareWithMany(entity: GroupScopedJs<E>, delegates: Array<EntityReferenceInGroupToCustomEntityShareOptionsMapObject_delegate_shareOptions>): Promise<GroupScopedJs<E>>

	public fun createEntity(entity: GroupScopedJs<E>): Promise<GroupScopedJs<E>>

	public fun createEntities(entities: Array<GroupScopedJs<E>>): Promise<Array<GroupScopedJs<E>>>

	public fun undeleteEntityById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>): Promise<GroupScopedJs<E>>

	public fun undeleteEntitiesByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>): Promise<Array<GroupScopedJs<E>>>

	public fun undeleteEntity(entity: GroupScopedJs<CustomEntityBaseJs>): Promise<GroupScopedJs<E>>

	public fun undeleteEntities(entities: Array<GroupScopedJs<CustomEntityBaseJs>>): Promise<Array<GroupScopedJs<E>>>

	public fun modifyEntity(entity: GroupScopedJs<E>): Promise<GroupScopedJs<E>>

	public fun modifyEntities(entities: Array<GroupScopedJs<E>>): Promise<Array<GroupScopedJs<E>>>

	public fun getEntity(groupId: String, entityId: String): Promise<GroupScopedJs<E>?>

	public fun getEntities(groupId: String, entityIds: Array<String>): Promise<Array<GroupScopedJs<E>>>
}
