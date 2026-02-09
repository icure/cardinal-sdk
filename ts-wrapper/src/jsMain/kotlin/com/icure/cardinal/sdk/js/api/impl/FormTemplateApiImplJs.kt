// auto-generated file
package com.icure.cardinal.sdk.js.api.`impl`

import com.icure.cardinal.sdk.api.FormTemplateApi
import com.icure.cardinal.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNullable
import com.icure.cardinal.sdk.js.api.FormTemplateApiJs
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToList
import com.icure.cardinal.sdk.js.model.CheckedConverters.listToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.js.model.FormTemplateJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.model.formTemplate_fromJs
import com.icure.cardinal.sdk.js.model.formTemplate_toJs
import com.icure.cardinal.sdk.js.model.storedDocumentIdentifier_fromJs
import com.icure.cardinal.sdk.js.model.storedDocumentIdentifier_toJs
import com.icure.cardinal.sdk.model.FormTemplate
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
import kotlin.Array
import kotlin.Boolean
import kotlin.ByteArray
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlin.collections.List
import kotlin.js.Promise
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise

@OptIn(DelicateCoroutinesApi::class)
internal class FormTemplateApiImplJs(
	private val formTemplateApi: FormTemplateApi,
) : FormTemplateApiJs {
	override fun getFormTemplate(formTemplateId: String, options: dynamic): Promise<FormTemplateJs> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val formTemplateIdConverted: String = formTemplateId
			val rawConverted: Boolean? = convertingOptionOrDefaultNullable(
				_options,
				"raw",
				null
			) { raw: Boolean? ->
				undefinedToNull(raw)
			}
			val result = formTemplateApi.getFormTemplate(
				formTemplateIdConverted,
				rawConverted,
			)
			formTemplate_toJs(result)
		}
	}

	override fun getFormTemplates(formTemplateIds: Array<String>): Promise<Array<FormTemplateJs>> =
			GlobalScope.promise {
		val formTemplateIdsConverted: List<String> = arrayToList(
			formTemplateIds,
			"formTemplateIds",
			{ x1: String ->
				x1
			},
		)
		val result = formTemplateApi.getFormTemplates(
			formTemplateIdsConverted,
		)
		listToArray(
			result,
			{ x1: FormTemplate ->
				formTemplate_toJs(x1)
			},
		)
	}

	override fun createFormTemplate(formTemplate: FormTemplateJs): Promise<FormTemplateJs> =
			GlobalScope.promise {
		val formTemplateConverted: FormTemplate = formTemplate_fromJs(formTemplate)
		val result = formTemplateApi.createFormTemplate(
			formTemplateConverted,
		)
		formTemplate_toJs(result)
	}

	override fun createFormTemplates(formTemplates: Array<FormTemplateJs>):
			Promise<Array<FormTemplateJs>> = GlobalScope.promise {
		val formTemplatesConverted: List<FormTemplate> = arrayToList(
			formTemplates,
			"formTemplates",
			{ x1: FormTemplateJs ->
				formTemplate_fromJs(x1)
			},
		)
		val result = formTemplateApi.createFormTemplates(
			formTemplatesConverted,
		)
		listToArray(
			result,
			{ x1: FormTemplate ->
				formTemplate_toJs(x1)
			},
		)
	}

	override fun modifyFormTemplate(formTemplate: FormTemplateJs): Promise<FormTemplateJs> =
			GlobalScope.promise {
		val formTemplateConverted: FormTemplate = formTemplate_fromJs(formTemplate)
		val result = formTemplateApi.modifyFormTemplate(
			formTemplateConverted,
		)
		formTemplate_toJs(result)
	}

	override fun modifyFormTemplates(formTemplates: Array<FormTemplateJs>):
			Promise<Array<FormTemplateJs>> = GlobalScope.promise {
		val formTemplatesConverted: List<FormTemplate> = arrayToList(
			formTemplates,
			"formTemplates",
			{ x1: FormTemplateJs ->
				formTemplate_fromJs(x1)
			},
		)
		val result = formTemplateApi.modifyFormTemplates(
			formTemplatesConverted,
		)
		listToArray(
			result,
			{ x1: FormTemplate ->
				formTemplate_toJs(x1)
			},
		)
	}

	override fun deleteFormTemplateById(entityId: String, rev: String):
			Promise<StoredDocumentIdentifierJs> = GlobalScope.promise {
		val entityIdConverted: String = entityId
		val revConverted: String = rev
		val result = formTemplateApi.deleteFormTemplateById(
			entityIdConverted,
			revConverted,
		)
		storedDocumentIdentifier_toJs(result)
	}

	override fun deleteFormTemplatesByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<StoredDocumentIdentifierJs>> = GlobalScope.promise {
		val entityIdsConverted: List<StoredDocumentIdentifier> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: StoredDocumentIdentifierJs ->
				storedDocumentIdentifier_fromJs(x1)
			},
		)
		val result = formTemplateApi.deleteFormTemplatesByIds(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: StoredDocumentIdentifier ->
				storedDocumentIdentifier_toJs(x1)
			},
		)
	}

	override fun deleteFormTemplate(formTemplate: FormTemplateJs): Promise<StoredDocumentIdentifierJs>
			= GlobalScope.promise {
		val formTemplateConverted: FormTemplate = formTemplate_fromJs(formTemplate)
		val result = formTemplateApi.deleteFormTemplate(
			formTemplateConverted,
		)
		storedDocumentIdentifier_toJs(result)
	}

	override fun deleteFormTemplates(formTemplates: Array<FormTemplateJs>):
			Promise<Array<StoredDocumentIdentifierJs>> = GlobalScope.promise {
		val formTemplatesConverted: List<FormTemplate> = arrayToList(
			formTemplates,
			"formTemplates",
			{ x1: FormTemplateJs ->
				formTemplate_fromJs(x1)
			},
		)
		val result = formTemplateApi.deleteFormTemplates(
			formTemplatesConverted,
		)
		listToArray(
			result,
			{ x1: StoredDocumentIdentifier ->
				storedDocumentIdentifier_toJs(x1)
			},
		)
	}

	override fun undeleteFormTemplateById(id: String, rev: String): Promise<FormTemplateJs> =
			GlobalScope.promise {
		val idConverted: String = id
		val revConverted: String = rev
		val result = formTemplateApi.undeleteFormTemplateById(
			idConverted,
			revConverted,
		)
		formTemplate_toJs(result)
	}

	override fun undeleteFormTemplatesByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<FormTemplateJs>> = GlobalScope.promise {
		val entityIdsConverted: List<StoredDocumentIdentifier> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: StoredDocumentIdentifierJs ->
				storedDocumentIdentifier_fromJs(x1)
			},
		)
		val result = formTemplateApi.undeleteFormTemplatesByIds(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: FormTemplate ->
				formTemplate_toJs(x1)
			},
		)
	}

	override fun undeleteFormTemplate(formTemplate: FormTemplateJs): Promise<FormTemplateJs> =
			GlobalScope.promise {
		val formTemplateConverted: FormTemplate = formTemplate_fromJs(formTemplate)
		val result = formTemplateApi.undeleteFormTemplate(
			formTemplateConverted,
		)
		formTemplate_toJs(result)
	}

	override fun undeleteFormTemplates(formTemplates: Array<FormTemplateJs>):
			Promise<Array<FormTemplateJs>> = GlobalScope.promise {
		val formTemplatesConverted: List<FormTemplate> = arrayToList(
			formTemplates,
			"formTemplates",
			{ x1: FormTemplateJs ->
				formTemplate_fromJs(x1)
			},
		)
		val result = formTemplateApi.undeleteFormTemplates(
			formTemplatesConverted,
		)
		listToArray(
			result,
			{ x1: FormTemplate ->
				formTemplate_toJs(x1)
			},
		)
	}

	override fun purgeFormTemplateById(id: String, rev: String): Promise<Unit> = GlobalScope.promise {
		val idConverted: String = id
		val revConverted: String = rev
		formTemplateApi.purgeFormTemplateById(
			idConverted,
			revConverted,
		)

	}

	override fun purgeFormTemplatesByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<StoredDocumentIdentifierJs>> = GlobalScope.promise {
		val entityIdsConverted: List<StoredDocumentIdentifier> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: StoredDocumentIdentifierJs ->
				storedDocumentIdentifier_fromJs(x1)
			},
		)
		val result = formTemplateApi.purgeFormTemplatesByIds(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: StoredDocumentIdentifier ->
				storedDocumentIdentifier_toJs(x1)
			},
		)
	}

	override fun purgeFormTemplate(formTemplate: FormTemplateJs): Promise<Unit> = GlobalScope.promise {
		val formTemplateConverted: FormTemplate = formTemplate_fromJs(formTemplate)
		formTemplateApi.purgeFormTemplate(
			formTemplateConverted,
		)

	}

	override fun purgeFormTemplates(formTemplates: Array<FormTemplateJs>):
			Promise<Array<StoredDocumentIdentifierJs>> = GlobalScope.promise {
		val formTemplatesConverted: List<FormTemplate> = arrayToList(
			formTemplates,
			"formTemplates",
			{ x1: FormTemplateJs ->
				formTemplate_fromJs(x1)
			},
		)
		val result = formTemplateApi.purgeFormTemplates(
			formTemplatesConverted,
		)
		listToArray(
			result,
			{ x1: StoredDocumentIdentifier ->
				storedDocumentIdentifier_toJs(x1)
			},
		)
	}

	override fun setTemplateAttachment(formTemplateId: String, payload: ByteArray): Promise<String> =
			GlobalScope.promise {
		val formTemplateIdConverted: String = formTemplateId
		val payloadConverted: ByteArray = payload
		val result = formTemplateApi.setTemplateAttachment(
			formTemplateIdConverted,
			payloadConverted,
		)
		result
	}
}
