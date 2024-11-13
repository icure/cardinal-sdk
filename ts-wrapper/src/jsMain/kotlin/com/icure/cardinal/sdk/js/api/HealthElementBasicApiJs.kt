// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.filters.BaseFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.BaseSortableFilterOptionsJs
import com.icure.cardinal.sdk.js.model.EncryptedHealthElementJs
import com.icure.cardinal.sdk.js.model.HealthElementJs
import com.icure.cardinal.sdk.js.model.IdWithMandatoryRevJs
import com.icure.cardinal.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.cardinal.sdk.js.subscription.EntitySubscriptionJs
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.String
import kotlin.Unit
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("HealthElementBasicApi")
public external interface HealthElementBasicApiJs {
	public fun matchHealthElementsBy(filter: BaseFilterOptionsJs<HealthElementJs>):
			Promise<Array<String>>

	public fun matchHealthElementsBySorted(filter: BaseSortableFilterOptionsJs<HealthElementJs>):
			Promise<Array<String>>

	public fun filterHealthElementsBy(filter: BaseFilterOptionsJs<HealthElementJs>):
			Promise<PaginatedListIteratorJs<EncryptedHealthElementJs>>

	public fun filterHealthElementsBySorted(filter: BaseSortableFilterOptionsJs<HealthElementJs>):
			Promise<PaginatedListIteratorJs<EncryptedHealthElementJs>>

	public fun deleteHealthElementUnsafe(entityId: String): Promise<DocIdentifierJs>

	public fun deleteHealthElementsUnsafe(entityIds: Array<String>): Promise<Array<DocIdentifierJs>>

	public fun deleteHealthElementById(entityId: String, rev: String?): Promise<DocIdentifierJs>

	public fun deleteHealthElementsByIds(entityIds: Array<IdWithMandatoryRevJs>):
			Promise<Array<DocIdentifierJs>>

	public fun purgeHealthElementById(id: String, rev: String): Promise<Unit>

	public fun deleteHealthElement(healthElement: HealthElementJs): Promise<DocIdentifierJs>

	public fun deleteHealthElements(healthElements: Array<HealthElementJs>):
			Promise<Array<DocIdentifierJs>>

	public fun purgeHealthElement(healthElement: HealthElementJs): Promise<Unit>

	public fun undeleteHealthElementById(id: String, rev: String): Promise<EncryptedHealthElementJs>

	public fun undeleteHealthElement(healthElement: HealthElementJs): Promise<EncryptedHealthElementJs>

	public fun modifyHealthElement(entity: EncryptedHealthElementJs): Promise<EncryptedHealthElementJs>

	public fun modifyHealthElements(entities: Array<EncryptedHealthElementJs>):
			Promise<Array<EncryptedHealthElementJs>>

	public fun getHealthElement(entityId: String): Promise<EncryptedHealthElementJs>

	public fun getHealthElements(entityIds: Array<String>): Promise<Array<EncryptedHealthElementJs>>

	public fun subscribeToEvents(
		events: Array<String>,
		filter: BaseFilterOptionsJs<HealthElementJs>,
		options: dynamic,
	): Promise<EntitySubscriptionJs<EncryptedHealthElementJs>>
}
