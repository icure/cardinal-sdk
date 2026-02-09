// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.filters.FilterOptionsJs
import com.icure.cardinal.sdk.js.filters.SortableFilterOptionsJs
import com.icure.cardinal.sdk.js.model.DecryptedFormJs
import com.icure.cardinal.sdk.js.model.EncryptedFormJs
import com.icure.cardinal.sdk.js.model.EntityReferenceInGroupJs
import com.icure.cardinal.sdk.js.model.FormJs
import com.icure.cardinal.sdk.js.model.FormTemplateJs
import com.icure.cardinal.sdk.js.model.GroupScopedJs
import com.icure.cardinal.sdk.js.model.PatientJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.synthetic.mapasobjectarray.EntityReferenceInGroupToFormShareOptionsMapObject_delegate_shareOptions
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("FormInGroupApi")
public external interface FormInGroupApiJs {
	public val encrypted: FormFlavouredInGroupApiJs<EncryptedFormJs>

	public val tryAndRecover: FormFlavouredInGroupApiJs<FormJs>

	public fun withEncryptionMetadata(
		entityGroupId: String,
		base: DecryptedFormJs?,
		patient: GroupScopedJs<PatientJs>?,
		options: dynamic,
	): Promise<GroupScopedJs<DecryptedFormJs>>

	public fun getEncryptionKeysOf(form: GroupScopedJs<FormJs>): Promise<Array<String>>

	public fun hasWriteAccess(form: GroupScopedJs<FormJs>): Promise<Boolean>

	public fun decryptPatientIdOf(form: GroupScopedJs<FormJs>):
			Promise<Array<EntityReferenceInGroupJs>>

	public fun createDelegationDeAnonymizationMetadata(entity: GroupScopedJs<FormJs>,
			delegates: Array<EntityReferenceInGroupJs>): Promise<Unit>

	public fun decrypt(forms: Array<GroupScopedJs<EncryptedFormJs>>):
			Promise<Array<GroupScopedJs<DecryptedFormJs>>>

	public fun tryDecrypt(forms: Array<GroupScopedJs<EncryptedFormJs>>):
			Promise<Array<GroupScopedJs<FormJs>>>

	public fun matchFormsBy(groupId: String, filter: FilterOptionsJs<FormJs>): Promise<Array<String>>

	public fun matchFormsBySorted(groupId: String, filter: SortableFilterOptionsJs<FormJs>):
			Promise<Array<String>>

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

	public fun shareWith(
		`delegate`: EntityReferenceInGroupJs,
		form: GroupScopedJs<DecryptedFormJs>,
		options: dynamic,
	): Promise<GroupScopedJs<DecryptedFormJs>>

	public fun shareWithMany(form: GroupScopedJs<DecryptedFormJs>,
			delegates: Array<EntityReferenceInGroupToFormShareOptionsMapObject_delegate_shareOptions>):
			Promise<GroupScopedJs<DecryptedFormJs>>

	public fun filterFormsBy(groupId: String, filter: FilterOptionsJs<FormJs>):
			Promise<PaginatedListIteratorJs<GroupScopedJs<DecryptedFormJs>>>

	public fun filterFormsBySorted(groupId: String, filter: SortableFilterOptionsJs<FormJs>):
			Promise<PaginatedListIteratorJs<GroupScopedJs<DecryptedFormJs>>>

	public fun createForm(entity: GroupScopedJs<DecryptedFormJs>):
			Promise<GroupScopedJs<DecryptedFormJs>>

	public fun createForms(entities: Array<GroupScopedJs<DecryptedFormJs>>):
			Promise<Array<GroupScopedJs<DecryptedFormJs>>>

	public fun undeleteFormById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
			Promise<GroupScopedJs<DecryptedFormJs>>

	public fun undeleteFormsByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
			Promise<Array<GroupScopedJs<DecryptedFormJs>>>

	public fun undeleteForm(form: GroupScopedJs<FormJs>): Promise<GroupScopedJs<DecryptedFormJs>>

	public fun undeleteForms(forms: Array<GroupScopedJs<DecryptedFormJs>>):
			Promise<Array<GroupScopedJs<DecryptedFormJs>>>

	public fun modifyForm(entity: GroupScopedJs<DecryptedFormJs>):
			Promise<GroupScopedJs<DecryptedFormJs>>

	public fun modifyForms(entities: Array<GroupScopedJs<DecryptedFormJs>>):
			Promise<Array<GroupScopedJs<DecryptedFormJs>>>

	public fun getForm(groupId: String, entityId: String): Promise<GroupScopedJs<DecryptedFormJs>?>

	public fun getForms(groupId: String, entityIds: Array<String>):
			Promise<Array<GroupScopedJs<DecryptedFormJs>>>
}
