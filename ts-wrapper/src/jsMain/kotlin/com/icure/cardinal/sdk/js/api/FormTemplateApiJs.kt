// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.model.FormTemplateJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import kotlin.Array
import kotlin.ByteArray
import kotlin.String
import kotlin.Unit
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("FormTemplateApi")
public external interface FormTemplateApiJs {
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
}
