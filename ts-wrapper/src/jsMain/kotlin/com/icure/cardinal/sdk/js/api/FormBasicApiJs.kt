// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.filters.BaseFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.BaseSortableFilterOptionsJs
import com.icure.cardinal.sdk.js.model.EncryptedFormJs
import com.icure.cardinal.sdk.js.model.FormJs
import com.icure.cardinal.sdk.js.model.FormTemplateJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.ByteArray
import kotlin.String
import kotlin.Unit
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("FormBasicApi")
public external interface FormBasicApiJs {
	public val inGroup: FormBasicInGroupApiJs

	public fun matchFormsBy(filter: BaseFilterOptionsJs<FormJs>): Promise<Array<String>>

	public fun matchFormsBySorted(filter: BaseSortableFilterOptionsJs<FormJs>): Promise<Array<String>>

	public fun filterFormsBy(filter: BaseFilterOptionsJs<FormJs>):
			Promise<PaginatedListIteratorJs<EncryptedFormJs>>

	public fun filterFormsBySorted(filter: BaseSortableFilterOptionsJs<FormJs>):
			Promise<PaginatedListIteratorJs<EncryptedFormJs>>

	public fun deleteFormById(entityId: String, rev: String): Promise<StoredDocumentIdentifierJs>

	public fun deleteFormsByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<StoredDocumentIdentifierJs>>

	public fun purgeFormById(id: String, rev: String): Promise<Unit>

	public fun purgeFormsByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<StoredDocumentIdentifierJs>>

	public fun deleteForm(form: FormJs): Promise<StoredDocumentIdentifierJs>

	public fun deleteForms(forms: Array<FormJs>): Promise<Array<StoredDocumentIdentifierJs>>

	public fun purgeForm(form: FormJs): Promise<Unit>

	public fun purgeForms(forms: Array<FormJs>): Promise<Array<StoredDocumentIdentifierJs>>

	public fun getFormTemplate(formTemplateId: String, options: dynamic): Promise<FormTemplateJs>

	public fun getFormTemplates(formTemplateIds: Array<String>): Promise<Array<FormTemplateJs>>

	public fun createFormTemplate(formTemplate: FormTemplateJs): Promise<FormTemplateJs>

	public fun createFormTemplates(formTemplates: Array<FormTemplateJs>):
			Promise<Array<FormTemplateJs>>

	public fun modifyFormTemplate(formTemplate: FormTemplateJs): Promise<FormTemplateJs>

	public fun modifyFormTemplates(formTemplates: Array<FormTemplateJs>):
			Promise<Array<FormTemplateJs>>

	public fun deleteFormTemplateById(entityId: String, rev: String):
			Promise<StoredDocumentIdentifierJs>

	public fun deleteFormTemplatesByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<StoredDocumentIdentifierJs>>

	public fun deleteFormTemplate(formTemplate: FormTemplateJs): Promise<StoredDocumentIdentifierJs>

	public fun deleteFormTemplates(formTemplates: Array<FormTemplateJs>):
			Promise<Array<StoredDocumentIdentifierJs>>

	public fun undeleteFormTemplateById(id: String, rev: String): Promise<FormTemplateJs>

	public fun undeleteFormTemplatesByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<FormTemplateJs>>

	public fun undeleteFormTemplate(formTemplate: FormTemplateJs): Promise<FormTemplateJs>

	public fun undeleteFormTemplates(formTemplates: Array<FormTemplateJs>):
			Promise<Array<FormTemplateJs>>

	public fun purgeFormTemplateById(id: String, rev: String): Promise<Unit>

	public fun purgeFormTemplatesByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<StoredDocumentIdentifierJs>>

	public fun purgeFormTemplate(formTemplate: FormTemplateJs): Promise<Unit>

	public fun purgeFormTemplates(formTemplates: Array<FormTemplateJs>):
			Promise<Array<StoredDocumentIdentifierJs>>

	public fun setTemplateAttachment(formTemplateId: String, payload: ByteArray): Promise<String>

	public fun createForm(entity: EncryptedFormJs): Promise<EncryptedFormJs>

	public fun createForms(entities: Array<EncryptedFormJs>): Promise<Array<EncryptedFormJs>>

	public fun modifyForm(entity: EncryptedFormJs): Promise<EncryptedFormJs>

	public fun modifyForms(entities: Array<EncryptedFormJs>): Promise<Array<EncryptedFormJs>>

	public fun undeleteFormById(id: String, rev: String): Promise<EncryptedFormJs>

	public fun undeleteFormsByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<EncryptedFormJs>>

	public fun undeleteForm(form: FormJs): Promise<EncryptedFormJs>

	public fun undeleteForms(forms: Array<FormJs>): Promise<Array<EncryptedFormJs>>

	public fun getForm(entityId: String): Promise<EncryptedFormJs?>

	public fun getForms(entityIds: Array<String>): Promise<Array<EncryptedFormJs>>

	public fun getLatestFormByUniqueId(uniqueId: String): Promise<EncryptedFormJs>
}
