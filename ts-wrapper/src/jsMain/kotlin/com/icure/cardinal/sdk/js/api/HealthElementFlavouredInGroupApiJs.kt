// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.filters.FilterOptionsJs
import com.icure.cardinal.sdk.js.filters.SortableFilterOptionsJs
import com.icure.cardinal.sdk.js.model.EntityReferenceInGroupJs
import com.icure.cardinal.sdk.js.model.GroupScopedJs
import com.icure.cardinal.sdk.js.model.HealthElementJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.synthetic.mapasobjectarray.EntityReferenceInGroupToHealthElementShareOptionsMapObject_delegate_shareOptions
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("HealthElementFlavouredInGroupApi")
public external interface HealthElementFlavouredInGroupApiJs<E : HealthElementJs> {
	public fun shareWith(
		`delegate`: EntityReferenceInGroupJs,
		healthElement: GroupScopedJs<E>,
		options: dynamic,
	): Promise<GroupScopedJs<E>>

	public fun shareWithMany(healthElement: GroupScopedJs<E>,
			delegates: Array<EntityReferenceInGroupToHealthElementShareOptionsMapObject_delegate_shareOptions>):
			Promise<GroupScopedJs<E>>

	public fun filterHealthElementsBy(groupId: String, filter: FilterOptionsJs<HealthElementJs>):
			Promise<PaginatedListIteratorJs<GroupScopedJs<E>>>

	public fun filterHealthElementsBySorted(groupId: String,
			filter: SortableFilterOptionsJs<HealthElementJs>):
			Promise<PaginatedListIteratorJs<GroupScopedJs<E>>>

	public fun createHealthElement(entity: GroupScopedJs<E>): Promise<GroupScopedJs<E>>

	public fun createHealthElements(entities: Array<GroupScopedJs<E>>):
			Promise<Array<GroupScopedJs<E>>>

	public fun undeleteHealthElementById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
			Promise<GroupScopedJs<E>>

	public
			fun undeleteHealthElementsByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
			Promise<Array<GroupScopedJs<E>>>

	public fun undeleteHealthElement(healthElement: GroupScopedJs<HealthElementJs>):
			Promise<GroupScopedJs<E>>

	public fun undeleteHealthElements(healthElements: Array<GroupScopedJs<E>>):
			Promise<Array<GroupScopedJs<E>>>

	public fun modifyHealthElement(entity: GroupScopedJs<E>): Promise<GroupScopedJs<E>>

	public fun modifyHealthElements(entities: Array<GroupScopedJs<E>>):
			Promise<Array<GroupScopedJs<E>>>

	public fun getHealthElement(groupId: String, entityId: String): Promise<GroupScopedJs<E>?>

	public fun getHealthElements(groupId: String, entityIds: Array<String>):
			Promise<Array<GroupScopedJs<E>>>
}
