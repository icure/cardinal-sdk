// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.filters.BaseFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.BaseSortableFilterOptionsJs
import com.icure.cardinal.sdk.js.model.EncryptedFormJs
import com.icure.cardinal.sdk.js.model.FormJs
import com.icure.cardinal.sdk.js.model.FormTemplateJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.model.couchdb.DocIdentifierJs
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
	public fun matchFormsBy(filter: BaseFilterOptionsJs<FormJs>): Promise<Array<String>>

	public fun matchFormsBySorted(filter: BaseSortableFilterOptionsJs<FormJs>): Promise<Array<String>>

	public fun filterFormsBy(filter: BaseFilterOptionsJs<FormJs>):
			Promise<PaginatedListIteratorJs<EncryptedFormJs>>

	public fun filterFormsBySorted(filter: BaseSortableFilterOptionsJs<FormJs>):
			Promise<PaginatedListIteratorJs<EncryptedFormJs>>

	public fun deleteFormUnsafe(entityId: String): Promise<DocIdentifierJs>

	public fun deleteFormsUnsafe(entityIds: Array<String>): Promise<Array<DocIdentifierJs>>

	public fun deleteFormById(entityId: String, rev: String): Promise<DocIdentifierJs>

	public fun deleteFormsByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<DocIdentifierJs>>

	public fun purgeFormById(id: String, rev: String): Promise<Unit>

	public fun deleteForm(form: FormJs): Promise<DocIdentifierJs>

	public fun deleteForms(forms: Array<FormJs>): Promise<Array<DocIdentifierJs>>

	public fun purgeForm(form: FormJs): Promise<Unit>

	public fun getFormTemplate(formTemplateId: String, options: dynamic): Promise<FormTemplateJs>

	public fun listFormTemplatesBySpeciality(specialityCode: String, options: dynamic):
			Promise<Array<FormTemplateJs>>

	public fun getFormTemplates(options: dynamic): Promise<Array<FormTemplateJs>>

	public fun createFormTemplate(formTemplate: FormTemplateJs): Promise<FormTemplateJs>

	public fun deleteFormTemplate(formTemplateId: String): Promise<DocIdentifierJs>

	public fun updateFormTemplate(formTemplate: FormTemplateJs): Promise<FormTemplateJs>

	public fun setTemplateAttachment(formTemplateId: String, payload: ByteArray): Promise<String>

	public fun createForm(entity: EncryptedFormJs): Promise<EncryptedFormJs>

	public fun createForms(entities: Array<EncryptedFormJs>): Promise<Array<EncryptedFormJs>>

	public fun modifyForm(entity: EncryptedFormJs): Promise<EncryptedFormJs>

	public fun undeleteFormById(id: String, rev: String): Promise<EncryptedFormJs>

	public fun undeleteForm(form: FormJs): Promise<EncryptedFormJs>

	public fun modifyForms(entities: Array<EncryptedFormJs>): Promise<Array<EncryptedFormJs>>

	public fun getForm(entityId: String): Promise<EncryptedFormJs?>

	public fun getForms(entityIds: Array<String>): Promise<Array<EncryptedFormJs>>

	public fun getLatestFormByLogicalUuid(logicalUuid: String): Promise<EncryptedFormJs>

	public fun getLatestFormByUniqueId(uniqueId: String): Promise<EncryptedFormJs>

	public fun getFormsByLogicalUuid(logicalUuid: String): Promise<Array<EncryptedFormJs>>

	public fun getFormsByUniqueId(uniqueId: String): Promise<Array<EncryptedFormJs>>

	public fun getChildrenForms(hcPartyId: String, parentId: String): Promise<Array<EncryptedFormJs>>
}
