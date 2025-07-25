// auto-generated file
package com.icure.cardinal.sdk.js.api.`impl`

import com.icure.cardinal.sdk.api.FormBasicApi
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNullable
import com.icure.cardinal.sdk.js.api.FormBasicApiJs
import com.icure.cardinal.sdk.js.filters.BaseFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.BaseSortableFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.baseFilterOptions_fromJs
import com.icure.cardinal.sdk.js.filters.baseSortableFilterOptions_fromJs
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToList
import com.icure.cardinal.sdk.js.model.CheckedConverters.listToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.js.model.EncryptedFormJs
import com.icure.cardinal.sdk.js.model.FormJs
import com.icure.cardinal.sdk.js.model.FormTemplateJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.cardinal.sdk.js.model.couchdb.docIdentifier_toJs
import com.icure.cardinal.sdk.js.model.formTemplate_fromJs
import com.icure.cardinal.sdk.js.model.formTemplate_toJs
import com.icure.cardinal.sdk.js.model.form_fromJs
import com.icure.cardinal.sdk.js.model.form_toJs
import com.icure.cardinal.sdk.js.model.storedDocumentIdentifier_fromJs
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import com.icure.cardinal.sdk.js.utils.pagination.paginatedListIterator_toJs
import com.icure.cardinal.sdk.model.EncryptedForm
import com.icure.cardinal.sdk.model.Form
import com.icure.cardinal.sdk.model.FormTemplate
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
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
internal class FormBasicApiImplJs(
	private val formBasicApi: FormBasicApi,
) : FormBasicApiJs {
	override fun matchFormsBy(filter: BaseFilterOptionsJs<FormJs>): Promise<Array<String>> =
			GlobalScope.promise {
		val filterConverted: BaseFilterOptions<Form> = baseFilterOptions_fromJs(filter)
		val result = formBasicApi.matchFormsBy(
			filterConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun matchFormsBySorted(filter: BaseSortableFilterOptionsJs<FormJs>):
			Promise<Array<String>> = GlobalScope.promise {
		val filterConverted: BaseSortableFilterOptions<Form> = baseSortableFilterOptions_fromJs(filter)
		val result = formBasicApi.matchFormsBySorted(
			filterConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun filterFormsBy(filter: BaseFilterOptionsJs<FormJs>):
			Promise<PaginatedListIteratorJs<EncryptedFormJs>> = GlobalScope.promise {
		val filterConverted: BaseFilterOptions<Form> = baseFilterOptions_fromJs(filter)
		val result = formBasicApi.filterFormsBy(
			filterConverted,
		)
		paginatedListIterator_toJs(
			result,
			{ x1: EncryptedForm ->
				form_toJs(x1)
			},
		)
	}

	override fun filterFormsBySorted(filter: BaseSortableFilterOptionsJs<FormJs>):
			Promise<PaginatedListIteratorJs<EncryptedFormJs>> = GlobalScope.promise {
		val filterConverted: BaseSortableFilterOptions<Form> = baseSortableFilterOptions_fromJs(filter)
		val result = formBasicApi.filterFormsBySorted(
			filterConverted,
		)
		paginatedListIterator_toJs(
			result,
			{ x1: EncryptedForm ->
				form_toJs(x1)
			},
		)
	}

	override fun deleteFormUnsafe(entityId: String): Promise<DocIdentifierJs> = GlobalScope.promise {
		val entityIdConverted: String = entityId
		val result = formBasicApi.deleteFormUnsafe(
			entityIdConverted,
		)
		docIdentifier_toJs(result)
	}

	override fun deleteFormsUnsafe(entityIds: Array<String>): Promise<Array<DocIdentifierJs>> =
			GlobalScope.promise {
		val entityIdsConverted: List<String> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: String ->
				x1
			},
		)
		val result = formBasicApi.deleteFormsUnsafe(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: DocIdentifier ->
				docIdentifier_toJs(x1)
			},
		)
	}

	override fun deleteFormById(entityId: String, rev: String): Promise<DocIdentifierJs> =
			GlobalScope.promise {
		val entityIdConverted: String = entityId
		val revConverted: String = rev
		val result = formBasicApi.deleteFormById(
			entityIdConverted,
			revConverted,
		)
		docIdentifier_toJs(result)
	}

	override fun deleteFormsByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<DocIdentifierJs>> = GlobalScope.promise {
		val entityIdsConverted: List<StoredDocumentIdentifier> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: StoredDocumentIdentifierJs ->
				storedDocumentIdentifier_fromJs(x1)
			},
		)
		val result = formBasicApi.deleteFormsByIds(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: DocIdentifier ->
				docIdentifier_toJs(x1)
			},
		)
	}

	override fun purgeFormById(id: String, rev: String): Promise<Unit> = GlobalScope.promise {
		val idConverted: String = id
		val revConverted: String = rev
		formBasicApi.purgeFormById(
			idConverted,
			revConverted,
		)

	}

	override fun deleteForm(form: FormJs): Promise<DocIdentifierJs> = GlobalScope.promise {
		val formConverted: Form = form_fromJs(form)
		val result = formBasicApi.deleteForm(
			formConverted,
		)
		docIdentifier_toJs(result)
	}

	override fun deleteForms(forms: Array<FormJs>): Promise<Array<DocIdentifierJs>> =
			GlobalScope.promise {
		val formsConverted: List<Form> = arrayToList(
			forms,
			"forms",
			{ x1: FormJs ->
				form_fromJs(x1)
			},
		)
		val result = formBasicApi.deleteForms(
			formsConverted,
		)
		listToArray(
			result,
			{ x1: DocIdentifier ->
				docIdentifier_toJs(x1)
			},
		)
	}

	override fun purgeForm(form: FormJs): Promise<Unit> = GlobalScope.promise {
		val formConverted: Form = form_fromJs(form)
		formBasicApi.purgeForm(
			formConverted,
		)

	}

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
			val result = formBasicApi.getFormTemplate(
				formTemplateIdConverted,
				rawConverted,
			)
			formTemplate_toJs(result)
		}
	}

	override fun listFormTemplatesBySpeciality(specialityCode: String, options: dynamic):
			Promise<Array<FormTemplateJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val specialityCodeConverted: String = specialityCode
			val rawConverted: Boolean? = convertingOptionOrDefaultNullable(
				_options,
				"raw",
				null
			) { raw: Boolean? ->
				undefinedToNull(raw)
			}
			val result = formBasicApi.listFormTemplatesBySpeciality(
				specialityCodeConverted,
				rawConverted,
			)
			listToArray(
				result,
				{ x1: FormTemplate ->
					formTemplate_toJs(x1)
				},
			)
		}
	}

	override fun getFormTemplates(options: dynamic): Promise<Array<FormTemplateJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val loadLayoutConverted: Boolean? = convertingOptionOrDefaultNullable(
				_options,
				"loadLayout",
				null
			) { loadLayout: Boolean? ->
				undefinedToNull(loadLayout)
			}
			val rawConverted: Boolean? = convertingOptionOrDefaultNullable(
				_options,
				"raw",
				null
			) { raw: Boolean? ->
				undefinedToNull(raw)
			}
			val result = formBasicApi.getFormTemplates(
				loadLayoutConverted,
				rawConverted,
			)
			listToArray(
				result,
				{ x1: FormTemplate ->
					formTemplate_toJs(x1)
				},
			)
		}
	}

	override fun createFormTemplate(formTemplate: FormTemplateJs): Promise<FormTemplateJs> =
			GlobalScope.promise {
		val formTemplateConverted: FormTemplate = formTemplate_fromJs(formTemplate)
		val result = formBasicApi.createFormTemplate(
			formTemplateConverted,
		)
		formTemplate_toJs(result)
	}

	override fun deleteFormTemplate(formTemplateId: String): Promise<DocIdentifierJs> =
			GlobalScope.promise {
		val formTemplateIdConverted: String = formTemplateId
		val result = formBasicApi.deleteFormTemplate(
			formTemplateIdConverted,
		)
		docIdentifier_toJs(result)
	}

	override fun updateFormTemplate(formTemplate: FormTemplateJs): Promise<FormTemplateJs> =
			GlobalScope.promise {
		val formTemplateConverted: FormTemplate = formTemplate_fromJs(formTemplate)
		val result = formBasicApi.updateFormTemplate(
			formTemplateConverted,
		)
		formTemplate_toJs(result)
	}

	override fun setTemplateAttachment(formTemplateId: String, payload: ByteArray): Promise<String> =
			GlobalScope.promise {
		val formTemplateIdConverted: String = formTemplateId
		val payloadConverted: ByteArray = payload
		val result = formBasicApi.setTemplateAttachment(
			formTemplateIdConverted,
			payloadConverted,
		)
		result
	}

	override fun createForm(entity: EncryptedFormJs): Promise<EncryptedFormJs> = GlobalScope.promise {
		val entityConverted: EncryptedForm = form_fromJs(entity)
		val result = formBasicApi.createForm(
			entityConverted,
		)
		form_toJs(result)
	}

	override fun createForms(entities: Array<EncryptedFormJs>): Promise<Array<EncryptedFormJs>> =
			GlobalScope.promise {
		val entitiesConverted: List<EncryptedForm> = arrayToList(
			entities,
			"entities",
			{ x1: EncryptedFormJs ->
				form_fromJs(x1)
			},
		)
		val result = formBasicApi.createForms(
			entitiesConverted,
		)
		listToArray(
			result,
			{ x1: EncryptedForm ->
				form_toJs(x1)
			},
		)
	}

	override fun modifyForm(entity: EncryptedFormJs): Promise<EncryptedFormJs> = GlobalScope.promise {
		val entityConverted: EncryptedForm = form_fromJs(entity)
		val result = formBasicApi.modifyForm(
			entityConverted,
		)
		form_toJs(result)
	}

	override fun undeleteFormById(id: String, rev: String): Promise<EncryptedFormJs> =
			GlobalScope.promise {
		val idConverted: String = id
		val revConverted: String = rev
		val result = formBasicApi.undeleteFormById(
			idConverted,
			revConverted,
		)
		form_toJs(result)
	}

	override fun undeleteForm(form: FormJs): Promise<EncryptedFormJs> = GlobalScope.promise {
		val formConverted: Form = form_fromJs(form)
		val result = formBasicApi.undeleteForm(
			formConverted,
		)
		form_toJs(result)
	}

	override fun modifyForms(entities: Array<EncryptedFormJs>): Promise<Array<EncryptedFormJs>> =
			GlobalScope.promise {
		val entitiesConverted: List<EncryptedForm> = arrayToList(
			entities,
			"entities",
			{ x1: EncryptedFormJs ->
				form_fromJs(x1)
			},
		)
		val result = formBasicApi.modifyForms(
			entitiesConverted,
		)
		listToArray(
			result,
			{ x1: EncryptedForm ->
				form_toJs(x1)
			},
		)
	}

	override fun getForm(entityId: String): Promise<EncryptedFormJs?> = GlobalScope.promise {
		val entityIdConverted: String = entityId
		val result = formBasicApi.getForm(
			entityIdConverted,
		)
		nullToUndefined(
			result?.let { nonNull1 ->
				form_toJs(nonNull1)
			}
		)
	}

	override fun getForms(entityIds: Array<String>): Promise<Array<EncryptedFormJs>> =
			GlobalScope.promise {
		val entityIdsConverted: List<String> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: String ->
				x1
			},
		)
		val result = formBasicApi.getForms(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: EncryptedForm ->
				form_toJs(x1)
			},
		)
	}

	override fun getLatestFormByLogicalUuid(logicalUuid: String): Promise<EncryptedFormJs> =
			GlobalScope.promise {
		val logicalUuidConverted: String = logicalUuid
		val result = formBasicApi.getLatestFormByLogicalUuid(
			logicalUuidConverted,
		)
		form_toJs(result)
	}

	override fun getLatestFormByUniqueId(uniqueId: String): Promise<EncryptedFormJs> =
			GlobalScope.promise {
		val uniqueIdConverted: String = uniqueId
		val result = formBasicApi.getLatestFormByUniqueId(
			uniqueIdConverted,
		)
		form_toJs(result)
	}

	override fun getFormsByLogicalUuid(logicalUuid: String): Promise<Array<EncryptedFormJs>> =
			GlobalScope.promise {
		val logicalUuidConverted: String = logicalUuid
		val result = formBasicApi.getFormsByLogicalUuid(
			logicalUuidConverted,
		)
		listToArray(
			result,
			{ x1: EncryptedForm ->
				form_toJs(x1)
			},
		)
	}

	override fun getFormsByUniqueId(uniqueId: String): Promise<Array<EncryptedFormJs>> =
			GlobalScope.promise {
		val uniqueIdConverted: String = uniqueId
		val result = formBasicApi.getFormsByUniqueId(
			uniqueIdConverted,
		)
		listToArray(
			result,
			{ x1: EncryptedForm ->
				form_toJs(x1)
			},
		)
	}

	override fun getChildrenForms(hcPartyId: String, parentId: String): Promise<Array<EncryptedFormJs>>
			= GlobalScope.promise {
		val hcPartyIdConverted: String = hcPartyId
		val parentIdConverted: String = parentId
		val result = formBasicApi.getChildrenForms(
			hcPartyIdConverted,
			parentIdConverted,
		)
		listToArray(
			result,
			{ x1: EncryptedForm ->
				form_toJs(x1)
			},
		)
	}
}
