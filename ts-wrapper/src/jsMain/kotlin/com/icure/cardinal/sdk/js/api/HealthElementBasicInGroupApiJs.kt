// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.filters.BaseFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.BaseSortableFilterOptionsJs
import com.icure.cardinal.sdk.js.model.EncryptedHealthElementJs
import com.icure.cardinal.sdk.js.model.GroupScopedJs
import com.icure.cardinal.sdk.js.model.HealthElementJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.String
import kotlin.Unit
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("HealthElementBasicInGroupApi")
public external interface HealthElementBasicInGroupApiJs {
	public fun matchHealthElementsBy(groupId: String, filter: BaseFilterOptionsJs<HealthElementJs>):
			Promise<Array<String>>

	public fun matchHealthElementsBySorted(groupId: String,
			filter: BaseSortableFilterOptionsJs<HealthElementJs>): Promise<Array<String>>

	public fun filterHealthElementsBy(groupId: String, filter: BaseFilterOptionsJs<HealthElementJs>):
			Promise<PaginatedListIteratorJs<GroupScopedJs<EncryptedHealthElementJs>>>

	public fun filterHealthElementsBySorted(groupId: String,
			filter: BaseSortableFilterOptionsJs<HealthElementJs>):
			Promise<PaginatedListIteratorJs<GroupScopedJs<EncryptedHealthElementJs>>>

	public fun deleteHealthElementById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
			Promise<GroupScopedJs<StoredDocumentIdentifierJs>>

	public fun deleteHealthElementsByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
			Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>>

	public fun purgeHealthElementById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
			Promise<Unit>

	public fun purgeHealthElementsByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
			Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>>

	public fun deleteHealthElement(healthElement: GroupScopedJs<HealthElementJs>):
			Promise<GroupScopedJs<StoredDocumentIdentifierJs>>

	public fun deleteHealthElements(healthElements: Array<GroupScopedJs<HealthElementJs>>):
			Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>>

	public fun purgeHealthElement(healthElement: GroupScopedJs<HealthElementJs>): Promise<Unit>

	public fun purgeHealthElements(healthElements: Array<GroupScopedJs<HealthElementJs>>):
			Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>>

	public fun createHealthElement(entity: GroupScopedJs<EncryptedHealthElementJs>):
			Promise<GroupScopedJs<EncryptedHealthElementJs>>

	public fun createHealthElements(entities: Array<GroupScopedJs<EncryptedHealthElementJs>>):
			Promise<Array<GroupScopedJs<EncryptedHealthElementJs>>>

	public fun undeleteHealthElementById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
			Promise<GroupScopedJs<EncryptedHealthElementJs>>

	public
			fun undeleteHealthElementsByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
			Promise<Array<GroupScopedJs<EncryptedHealthElementJs>>>

	public fun undeleteHealthElement(healthElement: GroupScopedJs<HealthElementJs>):
			Promise<GroupScopedJs<EncryptedHealthElementJs>>

	public fun undeleteHealthElements(healthElements: Array<GroupScopedJs<EncryptedHealthElementJs>>):
			Promise<Array<GroupScopedJs<EncryptedHealthElementJs>>>

	public fun modifyHealthElement(entity: GroupScopedJs<EncryptedHealthElementJs>):
			Promise<GroupScopedJs<EncryptedHealthElementJs>>

	public fun modifyHealthElements(entities: Array<GroupScopedJs<EncryptedHealthElementJs>>):
			Promise<Array<GroupScopedJs<EncryptedHealthElementJs>>>

	public fun getHealthElement(groupId: String, entityId: String):
			Promise<GroupScopedJs<EncryptedHealthElementJs>?>

	public fun getHealthElements(groupId: String, entityIds: Array<String>):
			Promise<Array<GroupScopedJs<EncryptedHealthElementJs>>>
}
