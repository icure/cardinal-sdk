// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.crypto.entities.HealthElementShareOptionsJs
import com.icure.cardinal.sdk.js.filters.FilterOptionsJs
import com.icure.cardinal.sdk.js.filters.SortableFilterOptionsJs
import com.icure.cardinal.sdk.js.model.HealthElementJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.utils.Record
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("HealthElementFlavouredApi")
public external interface HealthElementFlavouredApiJs<E : HealthElementJs> {
	public fun shareWith(
		delegateId: String,
		healthElement: E,
		options: dynamic,
	): Promise<E>

	public fun shareWithMany(healthElement: E, delegates: Record<String, HealthElementShareOptionsJs>):
			Promise<E>

	public fun filterHealthElementsBy(filter: FilterOptionsJs<HealthElementJs>):
			Promise<PaginatedListIteratorJs<E>>

	public fun filterHealthElementsBySorted(filter: SortableFilterOptionsJs<HealthElementJs>):
			Promise<PaginatedListIteratorJs<E>>

	public fun createHealthElement(entity: E): Promise<E>

	public fun createHealthElements(entities: Array<E>): Promise<Array<E>>

	public fun undeleteHealthElementById(id: String, rev: String): Promise<E>

	public fun undeleteHealthElementsByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<E>>

	public fun undeleteHealthElement(healthElement: HealthElementJs): Promise<E>

	public fun undeleteHealthElements(healthElements: Array<HealthElementJs>): Promise<Array<E>>

	public fun modifyHealthElement(entity: E): Promise<E>

	public fun modifyHealthElements(entities: Array<E>): Promise<Array<E>>

	public fun getHealthElement(entityId: String): Promise<E?>

	public fun getHealthElements(entityIds: Array<String>): Promise<Array<E>>
}
