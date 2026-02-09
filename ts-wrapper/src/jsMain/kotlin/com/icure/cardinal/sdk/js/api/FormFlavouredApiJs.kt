// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.crypto.entities.FormShareOptionsJs
import com.icure.cardinal.sdk.js.filters.FilterOptionsJs
import com.icure.cardinal.sdk.js.filters.SortableFilterOptionsJs
import com.icure.cardinal.sdk.js.model.FormJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.utils.Record
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("FormFlavouredApi")
public external interface FormFlavouredApiJs<E : FormJs> {
	public fun shareWith(
		delegateId: String,
		form: E,
		options: dynamic,
	): Promise<E>

	public fun shareWithMany(form: E, delegates: Record<String, FormShareOptionsJs>): Promise<E>

	public fun filterFormsBy(filter: FilterOptionsJs<FormJs>): Promise<PaginatedListIteratorJs<E>>

	public fun filterFormsBySorted(filter: SortableFilterOptionsJs<FormJs>):
			Promise<PaginatedListIteratorJs<E>>

	public fun createForm(entity: E): Promise<E>

	public fun createForms(entities: Array<E>): Promise<Array<E>>

	public fun modifyForm(entity: E): Promise<E>

	public fun modifyForms(entities: Array<E>): Promise<Array<E>>

	public fun undeleteFormById(id: String, rev: String): Promise<E>

	public fun undeleteFormsByIds(entityIds: Array<StoredDocumentIdentifierJs>): Promise<Array<E>>

	public fun undeleteForm(form: FormJs): Promise<E>

	public fun undeleteForms(forms: Array<FormJs>): Promise<Array<E>>

	public fun getForm(entityId: String): Promise<E?>

	public fun getForms(entityIds: Array<String>): Promise<Array<E>>

	public fun getLatestFormByUniqueId(uniqueId: String): Promise<E>
}
