// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.filters.FilterOptionsJs
import com.icure.cardinal.sdk.js.filters.SortableFilterOptionsJs
import com.icure.cardinal.sdk.js.model.EntityReferenceInGroupJs
import com.icure.cardinal.sdk.js.model.FormJs
import com.icure.cardinal.sdk.js.model.GroupScopedJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.synthetic.mapasobjectarray.EntityReferenceInGroupToFormShareOptionsMapObject_delegate_shareOptions
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("FormFlavouredInGroupApi")
public external interface FormFlavouredInGroupApiJs<E : FormJs> {
	public fun shareWith(
		`delegate`: EntityReferenceInGroupJs,
		form: GroupScopedJs<E>,
		options: dynamic,
	): Promise<GroupScopedJs<E>>

	public fun shareWithMany(form: GroupScopedJs<E>,
			delegates: Array<EntityReferenceInGroupToFormShareOptionsMapObject_delegate_shareOptions>):
			Promise<GroupScopedJs<E>>

	public fun filterFormsBy(groupId: String, filter: FilterOptionsJs<FormJs>):
			Promise<PaginatedListIteratorJs<GroupScopedJs<E>>>

	public fun filterFormsBySorted(groupId: String, filter: SortableFilterOptionsJs<FormJs>):
			Promise<PaginatedListIteratorJs<GroupScopedJs<E>>>

	public fun createForm(entity: GroupScopedJs<E>): Promise<GroupScopedJs<E>>

	public fun createForms(entities: Array<GroupScopedJs<E>>): Promise<Array<GroupScopedJs<E>>>

	public fun undeleteFormById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
			Promise<GroupScopedJs<E>>

	public fun undeleteFormsByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
			Promise<Array<GroupScopedJs<E>>>

	public fun undeleteForm(form: GroupScopedJs<FormJs>): Promise<GroupScopedJs<E>>

	public fun undeleteForms(forms: Array<GroupScopedJs<E>>): Promise<Array<GroupScopedJs<E>>>

	public fun modifyForm(entity: GroupScopedJs<E>): Promise<GroupScopedJs<E>>

	public fun modifyForms(entities: Array<GroupScopedJs<E>>): Promise<Array<GroupScopedJs<E>>>

	public fun getForm(groupId: String, entityId: String): Promise<GroupScopedJs<E>?>

	public fun getForms(groupId: String, entityIds: Array<String>): Promise<Array<GroupScopedJs<E>>>
}
