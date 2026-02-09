// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.crypto.entities.FormShareOptionsJs
import com.icure.cardinal.sdk.js.filters.FilterOptionsJs
import com.icure.cardinal.sdk.js.filters.SortableFilterOptionsJs
import com.icure.cardinal.sdk.js.model.DecryptedFormJs
import com.icure.cardinal.sdk.js.model.EncryptedFormJs
import com.icure.cardinal.sdk.js.model.EntityReferenceInGroupJs
import com.icure.cardinal.sdk.js.model.FormJs
import com.icure.cardinal.sdk.js.model.FormTemplateJs
import com.icure.cardinal.sdk.js.model.PatientJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.utils.Record
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.Boolean
import kotlin.ByteArray
import kotlin.String
import kotlin.Unit
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("FormApi")
public external interface FormApiJs {
	public val encrypted: FormFlavouredApiJs<EncryptedFormJs>

	public val tryAndRecover: FormFlavouredApiJs<FormJs>

	public val inGroup: FormInGroupApiJs

	public fun withEncryptionMetadata(
		base: DecryptedFormJs?,
		patient: PatientJs,
		options: dynamic,
	): Promise<DecryptedFormJs>

	public fun getEncryptionKeysOf(form: FormJs): Promise<Array<String>>

	public fun hasWriteAccess(form: FormJs): Promise<Boolean>

	public fun decryptPatientIdOf(form: FormJs): Promise<Array<EntityReferenceInGroupJs>>

	public fun createDelegationDeAnonymizationMetadata(entity: FormJs, delegates: Array<String>):
			Promise<Unit>

	public fun decrypt(form: EncryptedFormJs): Promise<DecryptedFormJs>

	public fun tryDecrypt(form: EncryptedFormJs): Promise<FormJs>

	public fun matchFormsBy(filter: FilterOptionsJs<FormJs>): Promise<Array<String>>

	public fun matchFormsBySorted(filter: SortableFilterOptionsJs<FormJs>): Promise<Array<String>>

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

	public fun shareWith(
		delegateId: String,
		form: DecryptedFormJs,
		options: dynamic,
	): Promise<DecryptedFormJs>

	public fun shareWithMany(form: DecryptedFormJs, delegates: Record<String, FormShareOptionsJs>):
			Promise<DecryptedFormJs>

	public fun filterFormsBy(filter: FilterOptionsJs<FormJs>):
			Promise<PaginatedListIteratorJs<DecryptedFormJs>>

	public fun filterFormsBySorted(filter: SortableFilterOptionsJs<FormJs>):
			Promise<PaginatedListIteratorJs<DecryptedFormJs>>

	public fun createForm(entity: DecryptedFormJs): Promise<DecryptedFormJs>

	public fun createForms(entities: Array<DecryptedFormJs>): Promise<Array<DecryptedFormJs>>

	public fun modifyForm(entity: DecryptedFormJs): Promise<DecryptedFormJs>

	public fun modifyForms(entities: Array<DecryptedFormJs>): Promise<Array<DecryptedFormJs>>

	public fun undeleteFormById(id: String, rev: String): Promise<DecryptedFormJs>

	public fun undeleteFormsByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<DecryptedFormJs>>

	public fun undeleteForm(form: FormJs): Promise<DecryptedFormJs>

	public fun undeleteForms(forms: Array<FormJs>): Promise<Array<DecryptedFormJs>>

	public fun getForm(entityId: String): Promise<DecryptedFormJs?>

	public fun getForms(entityIds: Array<String>): Promise<Array<DecryptedFormJs>>

	public fun getLatestFormByUniqueId(uniqueId: String): Promise<DecryptedFormJs>
}
