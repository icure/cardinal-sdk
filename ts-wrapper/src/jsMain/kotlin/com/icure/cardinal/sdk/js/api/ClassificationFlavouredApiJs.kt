// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.crypto.entities.ClassificationShareOptionsJs
import com.icure.cardinal.sdk.js.filters.FilterOptionsJs
import com.icure.cardinal.sdk.js.filters.SortableFilterOptionsJs
import com.icure.cardinal.sdk.js.model.ClassificationJs
import com.icure.cardinal.sdk.js.model.PatientJs
import com.icure.cardinal.sdk.js.utils.Record
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("ClassificationFlavouredApi")
public external interface ClassificationFlavouredApiJs<E : ClassificationJs> {
	public fun shareWith(
		delegateId: String,
		classification: E,
		options: dynamic,
	): Promise<E>

	public fun shareWithMany(classification: E, delegates: Record<String, ClassificationShareOptionsJs>): Promise<E>

	public fun findClassificationsByHcPartyPatient(
		hcPartyId: String,
		patient: PatientJs,
		options: dynamic,
	): Promise<PaginatedListIteratorJs<E>>

	public fun filterClassificationsBy(filter: FilterOptionsJs<ClassificationJs>): Promise<PaginatedListIteratorJs<E>>

	public fun filterClassificationsBySorted(filter: SortableFilterOptionsJs<ClassificationJs>): Promise<PaginatedListIteratorJs<E>>

	public fun createClassification(entity: E): Promise<E>

	public fun modifyClassification(entity: E): Promise<E>

	public fun getClassification(entityId: String): Promise<E?>

	public fun getClassifications(entityIds: Array<String>): Promise<Array<E>>
}
