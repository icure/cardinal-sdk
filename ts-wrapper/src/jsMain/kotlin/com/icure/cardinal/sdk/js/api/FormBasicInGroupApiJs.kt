// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.filters.BaseFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.BaseSortableFilterOptionsJs
import com.icure.cardinal.sdk.js.model.EncryptedFormJs
import com.icure.cardinal.sdk.js.model.FormJs
import com.icure.cardinal.sdk.js.model.FormTemplateJs
import com.icure.cardinal.sdk.js.model.GroupScopedJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.String
import kotlin.Unit
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("FormBasicInGroupApi")
public external interface FormBasicInGroupApiJs {
	public fun matchFormsBy(groupId: String, filter: BaseFilterOptionsJs<FormJs>):
			Promise<Array<String>>

	public fun matchFormsBySorted(groupId: String, filter: BaseSortableFilterOptionsJs<FormJs>):
			Promise<Array<String>>

	public fun filterFormsBy(groupId: String, filter: BaseFilterOptionsJs<FormJs>):
			Promise<PaginatedListIteratorJs<GroupScopedJs<EncryptedFormJs>>>

	public fun filterFormsBySorted(groupId: String, filter: BaseSortableFilterOptionsJs<FormJs>):
			Promise<PaginatedListIteratorJs<GroupScopedJs<EncryptedFormJs>>>

	public fun deleteFormById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
			Promise<GroupScopedJs<StoredDocumentIdentifierJs>>

	public fun deleteFormsByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
			Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>>

	public fun purgeFormById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>): Promise<Unit>

	public fun purgeFormsByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
			Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>>

	public fun deleteForm(form: GroupScopedJs<FormJs>):
			Promise<GroupScopedJs<StoredDocumentIdentifierJs>>

	public fun deleteForms(forms: Array<GroupScopedJs<FormJs>>):
			Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>>

	public fun purgeForm(form: GroupScopedJs<FormJs>): Promise<Unit>

	public fun purgeForms(forms: Array<GroupScopedJs<FormJs>>):
			Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>>

	public fun createFormTemplate(formTemplate: GroupScopedJs<FormTemplateJs>):
			Promise<GroupScopedJs<FormTemplateJs>>

	public fun createFormTemplates(formTemplates: Array<GroupScopedJs<FormTemplateJs>>):
			Promise<Array<GroupScopedJs<FormTemplateJs>>>

	public fun getFormTemplate(groupId: String, formTemplateId: String):
			Promise<GroupScopedJs<FormTemplateJs>?>

	public fun getFormTemplates(groupId: String, formTemplatesIds: Array<String>):
			Promise<Array<GroupScopedJs<FormTemplateJs>>>

	public fun modifyFormTemplate(formTemplate: GroupScopedJs<FormTemplateJs>):
			Promise<GroupScopedJs<FormTemplateJs>>

	public fun modifyFormTemplates(formTemplates: Array<GroupScopedJs<FormTemplateJs>>):
			Promise<Array<GroupScopedJs<FormTemplateJs>>>

	public fun deleteFormTemplateById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
			Promise<GroupScopedJs<StoredDocumentIdentifierJs>>

	public fun deleteFormTemplateByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
			Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>>

	public fun deleteFormTemplate(formTemplate: GroupScopedJs<FormTemplateJs>):
			Promise<GroupScopedJs<StoredDocumentIdentifierJs>>

	public fun deleteFormTemplates(formTemplates: Array<GroupScopedJs<FormTemplateJs>>):
			Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>>

	public fun undeleteFormTemplateById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
			Promise<GroupScopedJs<FormTemplateJs>>

	public fun undeleteFormTemplateByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
			Promise<Array<GroupScopedJs<FormTemplateJs>>>

	public fun undeleteFormTemplate(formTemplate: GroupScopedJs<FormTemplateJs>):
			Promise<GroupScopedJs<FormTemplateJs>>

	public fun undeleteFormTemplates(formTemplates: Array<GroupScopedJs<FormTemplateJs>>):
			Promise<Array<GroupScopedJs<FormTemplateJs>>>

	public fun purgeFormTemplateById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
			Promise<Unit>

	public fun purgeFormTemplateByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
			Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>>

	public fun purgeFormTemplate(formTemplate: GroupScopedJs<FormTemplateJs>): Promise<Unit>

	public fun purgeFormTemplates(formTemplates: Array<GroupScopedJs<FormTemplateJs>>):
			Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>>

	public fun createForm(entity: GroupScopedJs<EncryptedFormJs>):
			Promise<GroupScopedJs<EncryptedFormJs>>

	public fun createForms(entities: Array<GroupScopedJs<EncryptedFormJs>>):
			Promise<Array<GroupScopedJs<EncryptedFormJs>>>

	public fun undeleteFormById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
			Promise<GroupScopedJs<EncryptedFormJs>>

	public fun undeleteFormsByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
			Promise<Array<GroupScopedJs<EncryptedFormJs>>>

	public fun undeleteForm(form: GroupScopedJs<FormJs>): Promise<GroupScopedJs<EncryptedFormJs>>

	public fun undeleteForms(forms: Array<GroupScopedJs<EncryptedFormJs>>):
			Promise<Array<GroupScopedJs<EncryptedFormJs>>>

	public fun modifyForm(entity: GroupScopedJs<EncryptedFormJs>):
			Promise<GroupScopedJs<EncryptedFormJs>>

	public fun modifyForms(entities: Array<GroupScopedJs<EncryptedFormJs>>):
			Promise<Array<GroupScopedJs<EncryptedFormJs>>>

	public fun getForm(groupId: String, entityId: String): Promise<GroupScopedJs<EncryptedFormJs>?>

	public fun getForms(groupId: String, entityIds: Array<String>):
			Promise<Array<GroupScopedJs<EncryptedFormJs>>>
}
