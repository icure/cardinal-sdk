// auto-generated file
package com.icure.cardinal.sdk.js.api.`impl`

import com.icure.cardinal.sdk.api.FormBasicApi
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNullable
import com.icure.cardinal.sdk.js.api.FormBasicApiJs
import com.icure.cardinal.sdk.js.api.FormBasicInGroupApiJs
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
import com.icure.cardinal.sdk.js.model.GroupScopedJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.model.formTemplate_fromJs
import com.icure.cardinal.sdk.js.model.formTemplate_toJs
import com.icure.cardinal.sdk.js.model.form_fromJs
import com.icure.cardinal.sdk.js.model.form_toJs
import com.icure.cardinal.sdk.js.model.groupScoped_fromJs
import com.icure.cardinal.sdk.js.model.groupScoped_toJs
import com.icure.cardinal.sdk.js.model.storedDocumentIdentifier_fromJs
import com.icure.cardinal.sdk.js.model.storedDocumentIdentifier_toJs
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import com.icure.cardinal.sdk.js.utils.pagination.paginatedListIterator_toJs
import com.icure.cardinal.sdk.model.EncryptedForm
import com.icure.cardinal.sdk.model.Form
import com.icure.cardinal.sdk.model.FormTemplate
import com.icure.cardinal.sdk.model.GroupScoped
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
internal class FormBasicApiImplJs(
	private val formBasicApi: FormBasicApi,
) : FormBasicApiJs {
	override val inGroup: FormBasicInGroupApiJs = object : FormBasicInGroupApiJs {
		override fun matchFormsBy(groupId: String, filter: BaseFilterOptionsJs<FormJs>):
				Promise<Array<String>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val filterConverted: BaseFilterOptions<Form> = baseFilterOptions_fromJs(filter)
			val result = formBasicApi.inGroup.matchFormsBy(
				groupIdConverted,
				filterConverted,
			)
			listToArray(
				result,
				{ x1: String ->
					x1
				},
			)
		}

		override fun matchFormsBySorted(groupId: String, filter: BaseSortableFilterOptionsJs<FormJs>):
				Promise<Array<String>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val filterConverted: BaseSortableFilterOptions<Form> = baseSortableFilterOptions_fromJs(filter)
			val result = formBasicApi.inGroup.matchFormsBySorted(
				groupIdConverted,
				filterConverted,
			)
			listToArray(
				result,
				{ x1: String ->
					x1
				},
			)
		}

		override fun filterFormsBy(groupId: String, filter: BaseFilterOptionsJs<FormJs>):
				Promise<PaginatedListIteratorJs<GroupScopedJs<EncryptedFormJs>>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val filterConverted: BaseFilterOptions<Form> = baseFilterOptions_fromJs(filter)
			val result = formBasicApi.inGroup.filterFormsBy(
				groupIdConverted,
				filterConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: GroupScoped<EncryptedForm> ->
					groupScoped_toJs(
						x1,
						{ x2: EncryptedForm ->
							form_toJs(x2)
						},
					)
				},
			)
		}

		override fun filterFormsBySorted(groupId: String, filter: BaseSortableFilterOptionsJs<FormJs>):
				Promise<PaginatedListIteratorJs<GroupScopedJs<EncryptedFormJs>>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val filterConverted: BaseSortableFilterOptions<Form> = baseSortableFilterOptions_fromJs(filter)
			val result = formBasicApi.inGroup.filterFormsBySorted(
				groupIdConverted,
				filterConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: GroupScoped<EncryptedForm> ->
					groupScoped_toJs(
						x1,
						{ x2: EncryptedForm ->
							form_toJs(x2)
						},
					)
				},
			)
		}

		override fun deleteFormById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
				Promise<GroupScopedJs<StoredDocumentIdentifierJs>> = GlobalScope.promise {
			val entityIdConverted: GroupScoped<StoredDocumentIdentifier> = groupScoped_fromJs(
				entityId,
				{ x1: StoredDocumentIdentifierJs ->
					storedDocumentIdentifier_fromJs(x1)
				},
			)
			val result = formBasicApi.inGroup.deleteFormById(
				entityIdConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: StoredDocumentIdentifier ->
					storedDocumentIdentifier_toJs(x1)
				},
			)
		}

		override fun deleteFormsByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
				Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>> = GlobalScope.promise {
			val entityIdsConverted: List<GroupScoped<StoredDocumentIdentifier>> = arrayToList(
				entityIds,
				"entityIds",
				{ x1: GroupScopedJs<StoredDocumentIdentifierJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: StoredDocumentIdentifierJs ->
							storedDocumentIdentifier_fromJs(x2)
						},
					)
				},
			)
			val result = formBasicApi.inGroup.deleteFormsByIds(
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<StoredDocumentIdentifier> ->
					groupScoped_toJs(
						x1,
						{ x2: StoredDocumentIdentifier ->
							storedDocumentIdentifier_toJs(x2)
						},
					)
				},
			)
		}

		override fun purgeFormById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>): Promise<Unit> =
				GlobalScope.promise {
			val entityIdConverted: GroupScoped<StoredDocumentIdentifier> = groupScoped_fromJs(
				entityId,
				{ x1: StoredDocumentIdentifierJs ->
					storedDocumentIdentifier_fromJs(x1)
				},
			)
			formBasicApi.inGroup.purgeFormById(
				entityIdConverted,
			)

		}

		override fun purgeFormsByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
				Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>> = GlobalScope.promise {
			val entityIdsConverted: List<GroupScoped<StoredDocumentIdentifier>> = arrayToList(
				entityIds,
				"entityIds",
				{ x1: GroupScopedJs<StoredDocumentIdentifierJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: StoredDocumentIdentifierJs ->
							storedDocumentIdentifier_fromJs(x2)
						},
					)
				},
			)
			val result = formBasicApi.inGroup.purgeFormsByIds(
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<StoredDocumentIdentifier> ->
					groupScoped_toJs(
						x1,
						{ x2: StoredDocumentIdentifier ->
							storedDocumentIdentifier_toJs(x2)
						},
					)
				},
			)
		}

		override fun deleteForm(form: GroupScopedJs<FormJs>):
				Promise<GroupScopedJs<StoredDocumentIdentifierJs>> = GlobalScope.promise {
			val formConverted: GroupScoped<Form> = groupScoped_fromJs(
				form,
				{ x1: FormJs ->
					form_fromJs(x1)
				},
			)
			val result = formBasicApi.inGroup.deleteForm(
				formConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: StoredDocumentIdentifier ->
					storedDocumentIdentifier_toJs(x1)
				},
			)
		}

		override fun deleteForms(forms: Array<GroupScopedJs<FormJs>>):
				Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>> = GlobalScope.promise {
			val formsConverted: List<GroupScoped<Form>> = arrayToList(
				forms,
				"forms",
				{ x1: GroupScopedJs<FormJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: FormJs ->
							form_fromJs(x2)
						},
					)
				},
			)
			val result = formBasicApi.inGroup.deleteForms(
				formsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<StoredDocumentIdentifier> ->
					groupScoped_toJs(
						x1,
						{ x2: StoredDocumentIdentifier ->
							storedDocumentIdentifier_toJs(x2)
						},
					)
				},
			)
		}

		override fun purgeForm(form: GroupScopedJs<FormJs>): Promise<Unit> = GlobalScope.promise {
			val formConverted: GroupScoped<Form> = groupScoped_fromJs(
				form,
				{ x1: FormJs ->
					form_fromJs(x1)
				},
			)
			formBasicApi.inGroup.purgeForm(
				formConverted,
			)

		}

		override fun purgeForms(forms: Array<GroupScopedJs<FormJs>>):
				Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>> = GlobalScope.promise {
			val formsConverted: List<GroupScoped<Form>> = arrayToList(
				forms,
				"forms",
				{ x1: GroupScopedJs<FormJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: FormJs ->
							form_fromJs(x2)
						},
					)
				},
			)
			val result = formBasicApi.inGroup.purgeForms(
				formsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<StoredDocumentIdentifier> ->
					groupScoped_toJs(
						x1,
						{ x2: StoredDocumentIdentifier ->
							storedDocumentIdentifier_toJs(x2)
						},
					)
				},
			)
		}

		override fun createFormTemplate(formTemplate: GroupScopedJs<FormTemplateJs>):
				Promise<GroupScopedJs<FormTemplateJs>> = GlobalScope.promise {
			val formTemplateConverted: GroupScoped<FormTemplate> = groupScoped_fromJs(
				formTemplate,
				{ x1: FormTemplateJs ->
					formTemplate_fromJs(x1)
				},
			)
			val result = formBasicApi.inGroup.createFormTemplate(
				formTemplateConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: FormTemplate ->
					formTemplate_toJs(x1)
				},
			)
		}

		override fun createFormTemplates(formTemplates: Array<GroupScopedJs<FormTemplateJs>>):
				Promise<Array<GroupScopedJs<FormTemplateJs>>> = GlobalScope.promise {
			val formTemplatesConverted: List<GroupScoped<FormTemplate>> = arrayToList(
				formTemplates,
				"formTemplates",
				{ x1: GroupScopedJs<FormTemplateJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: FormTemplateJs ->
							formTemplate_fromJs(x2)
						},
					)
				},
			)
			val result = formBasicApi.inGroup.createFormTemplates(
				formTemplatesConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<FormTemplate> ->
					groupScoped_toJs(
						x1,
						{ x2: FormTemplate ->
							formTemplate_toJs(x2)
						},
					)
				},
			)
		}

		override fun getFormTemplate(groupId: String, formTemplateId: String):
				Promise<GroupScopedJs<FormTemplateJs>?> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val formTemplateIdConverted: String = formTemplateId
			val result = formBasicApi.inGroup.getFormTemplate(
				groupIdConverted,
				formTemplateIdConverted,
			)
			nullToUndefined(
				result?.let { nonNull1 ->
					groupScoped_toJs(
						nonNull1,
						{ x1: FormTemplate ->
							formTemplate_toJs(x1)
						},
					)
				}
			)
		}

		override fun getFormTemplates(groupId: String, formTemplatesIds: Array<String>):
				Promise<Array<GroupScopedJs<FormTemplateJs>>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val formTemplatesIdsConverted: List<String> = arrayToList(
				formTemplatesIds,
				"formTemplatesIds",
				{ x1: String ->
					x1
				},
			)
			val result = formBasicApi.inGroup.getFormTemplates(
				groupIdConverted,
				formTemplatesIdsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<FormTemplate> ->
					groupScoped_toJs(
						x1,
						{ x2: FormTemplate ->
							formTemplate_toJs(x2)
						},
					)
				},
			)
		}

		override fun modifyFormTemplate(formTemplate: GroupScopedJs<FormTemplateJs>):
				Promise<GroupScopedJs<FormTemplateJs>> = GlobalScope.promise {
			val formTemplateConverted: GroupScoped<FormTemplate> = groupScoped_fromJs(
				formTemplate,
				{ x1: FormTemplateJs ->
					formTemplate_fromJs(x1)
				},
			)
			val result = formBasicApi.inGroup.modifyFormTemplate(
				formTemplateConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: FormTemplate ->
					formTemplate_toJs(x1)
				},
			)
		}

		override fun modifyFormTemplates(formTemplates: Array<GroupScopedJs<FormTemplateJs>>):
				Promise<Array<GroupScopedJs<FormTemplateJs>>> = GlobalScope.promise {
			val formTemplatesConverted: List<GroupScoped<FormTemplate>> = arrayToList(
				formTemplates,
				"formTemplates",
				{ x1: GroupScopedJs<FormTemplateJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: FormTemplateJs ->
							formTemplate_fromJs(x2)
						},
					)
				},
			)
			val result = formBasicApi.inGroup.modifyFormTemplates(
				formTemplatesConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<FormTemplate> ->
					groupScoped_toJs(
						x1,
						{ x2: FormTemplate ->
							formTemplate_toJs(x2)
						},
					)
				},
			)
		}

		override fun deleteFormTemplateById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
				Promise<GroupScopedJs<StoredDocumentIdentifierJs>> = GlobalScope.promise {
			val entityIdConverted: GroupScoped<StoredDocumentIdentifier> = groupScoped_fromJs(
				entityId,
				{ x1: StoredDocumentIdentifierJs ->
					storedDocumentIdentifier_fromJs(x1)
				},
			)
			val result = formBasicApi.inGroup.deleteFormTemplateById(
				entityIdConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: StoredDocumentIdentifier ->
					storedDocumentIdentifier_toJs(x1)
				},
			)
		}

		override fun deleteFormTemplateByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
				Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>> = GlobalScope.promise {
			val entityIdsConverted: List<GroupScoped<StoredDocumentIdentifier>> = arrayToList(
				entityIds,
				"entityIds",
				{ x1: GroupScopedJs<StoredDocumentIdentifierJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: StoredDocumentIdentifierJs ->
							storedDocumentIdentifier_fromJs(x2)
						},
					)
				},
			)
			val result = formBasicApi.inGroup.deleteFormTemplateByIds(
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<StoredDocumentIdentifier> ->
					groupScoped_toJs(
						x1,
						{ x2: StoredDocumentIdentifier ->
							storedDocumentIdentifier_toJs(x2)
						},
					)
				},
			)
		}

		override fun deleteFormTemplate(formTemplate: GroupScopedJs<FormTemplateJs>):
				Promise<GroupScopedJs<StoredDocumentIdentifierJs>> = GlobalScope.promise {
			val formTemplateConverted: GroupScoped<FormTemplate> = groupScoped_fromJs(
				formTemplate,
				{ x1: FormTemplateJs ->
					formTemplate_fromJs(x1)
				},
			)
			val result = formBasicApi.inGroup.deleteFormTemplate(
				formTemplateConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: StoredDocumentIdentifier ->
					storedDocumentIdentifier_toJs(x1)
				},
			)
		}

		override fun deleteFormTemplates(formTemplates: Array<GroupScopedJs<FormTemplateJs>>):
				Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>> = GlobalScope.promise {
			val formTemplatesConverted: List<GroupScoped<FormTemplate>> = arrayToList(
				formTemplates,
				"formTemplates",
				{ x1: GroupScopedJs<FormTemplateJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: FormTemplateJs ->
							formTemplate_fromJs(x2)
						},
					)
				},
			)
			val result = formBasicApi.inGroup.deleteFormTemplates(
				formTemplatesConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<StoredDocumentIdentifier> ->
					groupScoped_toJs(
						x1,
						{ x2: StoredDocumentIdentifier ->
							storedDocumentIdentifier_toJs(x2)
						},
					)
				},
			)
		}

		override fun undeleteFormTemplateById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
				Promise<GroupScopedJs<FormTemplateJs>> = GlobalScope.promise {
			val entityIdConverted: GroupScoped<StoredDocumentIdentifier> = groupScoped_fromJs(
				entityId,
				{ x1: StoredDocumentIdentifierJs ->
					storedDocumentIdentifier_fromJs(x1)
				},
			)
			val result = formBasicApi.inGroup.undeleteFormTemplateById(
				entityIdConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: FormTemplate ->
					formTemplate_toJs(x1)
				},
			)
		}

		override
				fun undeleteFormTemplateByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
				Promise<Array<GroupScopedJs<FormTemplateJs>>> = GlobalScope.promise {
			val entityIdsConverted: List<GroupScoped<StoredDocumentIdentifier>> = arrayToList(
				entityIds,
				"entityIds",
				{ x1: GroupScopedJs<StoredDocumentIdentifierJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: StoredDocumentIdentifierJs ->
							storedDocumentIdentifier_fromJs(x2)
						},
					)
				},
			)
			val result = formBasicApi.inGroup.undeleteFormTemplateByIds(
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<FormTemplate> ->
					groupScoped_toJs(
						x1,
						{ x2: FormTemplate ->
							formTemplate_toJs(x2)
						},
					)
				},
			)
		}

		override fun undeleteFormTemplate(formTemplate: GroupScopedJs<FormTemplateJs>):
				Promise<GroupScopedJs<FormTemplateJs>> = GlobalScope.promise {
			val formTemplateConverted: GroupScoped<FormTemplate> = groupScoped_fromJs(
				formTemplate,
				{ x1: FormTemplateJs ->
					formTemplate_fromJs(x1)
				},
			)
			val result = formBasicApi.inGroup.undeleteFormTemplate(
				formTemplateConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: FormTemplate ->
					formTemplate_toJs(x1)
				},
			)
		}

		override fun undeleteFormTemplates(formTemplates: Array<GroupScopedJs<FormTemplateJs>>):
				Promise<Array<GroupScopedJs<FormTemplateJs>>> = GlobalScope.promise {
			val formTemplatesConverted: List<GroupScoped<FormTemplate>> = arrayToList(
				formTemplates,
				"formTemplates",
				{ x1: GroupScopedJs<FormTemplateJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: FormTemplateJs ->
							formTemplate_fromJs(x2)
						},
					)
				},
			)
			val result = formBasicApi.inGroup.undeleteFormTemplates(
				formTemplatesConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<FormTemplate> ->
					groupScoped_toJs(
						x1,
						{ x2: FormTemplate ->
							formTemplate_toJs(x2)
						},
					)
				},
			)
		}

		override fun purgeFormTemplateById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
				Promise<Unit> = GlobalScope.promise {
			val entityIdConverted: GroupScoped<StoredDocumentIdentifier> = groupScoped_fromJs(
				entityId,
				{ x1: StoredDocumentIdentifierJs ->
					storedDocumentIdentifier_fromJs(x1)
				},
			)
			formBasicApi.inGroup.purgeFormTemplateById(
				entityIdConverted,
			)

		}

		override fun purgeFormTemplateByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
				Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>> = GlobalScope.promise {
			val entityIdsConverted: List<GroupScoped<StoredDocumentIdentifier>> = arrayToList(
				entityIds,
				"entityIds",
				{ x1: GroupScopedJs<StoredDocumentIdentifierJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: StoredDocumentIdentifierJs ->
							storedDocumentIdentifier_fromJs(x2)
						},
					)
				},
			)
			val result = formBasicApi.inGroup.purgeFormTemplateByIds(
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<StoredDocumentIdentifier> ->
					groupScoped_toJs(
						x1,
						{ x2: StoredDocumentIdentifier ->
							storedDocumentIdentifier_toJs(x2)
						},
					)
				},
			)
		}

		override fun purgeFormTemplate(formTemplate: GroupScopedJs<FormTemplateJs>): Promise<Unit> =
				GlobalScope.promise {
			val formTemplateConverted: GroupScoped<FormTemplate> = groupScoped_fromJs(
				formTemplate,
				{ x1: FormTemplateJs ->
					formTemplate_fromJs(x1)
				},
			)
			formBasicApi.inGroup.purgeFormTemplate(
				formTemplateConverted,
			)

		}

		override fun purgeFormTemplates(formTemplates: Array<GroupScopedJs<FormTemplateJs>>):
				Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>> = GlobalScope.promise {
			val formTemplatesConverted: List<GroupScoped<FormTemplate>> = arrayToList(
				formTemplates,
				"formTemplates",
				{ x1: GroupScopedJs<FormTemplateJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: FormTemplateJs ->
							formTemplate_fromJs(x2)
						},
					)
				},
			)
			val result = formBasicApi.inGroup.purgeFormTemplates(
				formTemplatesConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<StoredDocumentIdentifier> ->
					groupScoped_toJs(
						x1,
						{ x2: StoredDocumentIdentifier ->
							storedDocumentIdentifier_toJs(x2)
						},
					)
				},
			)
		}

		override fun createForm(entity: GroupScopedJs<EncryptedFormJs>):
				Promise<GroupScopedJs<EncryptedFormJs>> = GlobalScope.promise {
			val entityConverted: GroupScoped<EncryptedForm> = groupScoped_fromJs(
				entity,
				{ x1: EncryptedFormJs ->
					form_fromJs(x1)
				},
			)
			val result = formBasicApi.inGroup.createForm(
				entityConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: EncryptedForm ->
					form_toJs(x1)
				},
			)
		}

		override fun createForms(entities: Array<GroupScopedJs<EncryptedFormJs>>):
				Promise<Array<GroupScopedJs<EncryptedFormJs>>> = GlobalScope.promise {
			val entitiesConverted: List<GroupScoped<EncryptedForm>> = arrayToList(
				entities,
				"entities",
				{ x1: GroupScopedJs<EncryptedFormJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: EncryptedFormJs ->
							form_fromJs(x2)
						},
					)
				},
			)
			val result = formBasicApi.inGroup.createForms(
				entitiesConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<EncryptedForm> ->
					groupScoped_toJs(
						x1,
						{ x2: EncryptedForm ->
							form_toJs(x2)
						},
					)
				},
			)
		}

		override fun undeleteFormById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
				Promise<GroupScopedJs<EncryptedFormJs>> = GlobalScope.promise {
			val entityIdConverted: GroupScoped<StoredDocumentIdentifier> = groupScoped_fromJs(
				entityId,
				{ x1: StoredDocumentIdentifierJs ->
					storedDocumentIdentifier_fromJs(x1)
				},
			)
			val result = formBasicApi.inGroup.undeleteFormById(
				entityIdConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: EncryptedForm ->
					form_toJs(x1)
				},
			)
		}

		override fun undeleteFormsByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
				Promise<Array<GroupScopedJs<EncryptedFormJs>>> = GlobalScope.promise {
			val entityIdsConverted: List<GroupScoped<StoredDocumentIdentifier>> = arrayToList(
				entityIds,
				"entityIds",
				{ x1: GroupScopedJs<StoredDocumentIdentifierJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: StoredDocumentIdentifierJs ->
							storedDocumentIdentifier_fromJs(x2)
						},
					)
				},
			)
			val result = formBasicApi.inGroup.undeleteFormsByIds(
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<EncryptedForm> ->
					groupScoped_toJs(
						x1,
						{ x2: EncryptedForm ->
							form_toJs(x2)
						},
					)
				},
			)
		}

		override fun undeleteForm(form: GroupScopedJs<FormJs>): Promise<GroupScopedJs<EncryptedFormJs>> =
				GlobalScope.promise {
			val formConverted: GroupScoped<Form> = groupScoped_fromJs(
				form,
				{ x1: FormJs ->
					form_fromJs(x1)
				},
			)
			val result = formBasicApi.inGroup.undeleteForm(
				formConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: EncryptedForm ->
					form_toJs(x1)
				},
			)
		}

		override fun undeleteForms(forms: Array<GroupScopedJs<EncryptedFormJs>>):
				Promise<Array<GroupScopedJs<EncryptedFormJs>>> = GlobalScope.promise {
			val formsConverted: List<GroupScoped<EncryptedForm>> = arrayToList(
				forms,
				"forms",
				{ x1: GroupScopedJs<EncryptedFormJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: EncryptedFormJs ->
							form_fromJs(x2)
						},
					)
				},
			)
			val result = formBasicApi.inGroup.undeleteForms(
				formsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<EncryptedForm> ->
					groupScoped_toJs(
						x1,
						{ x2: EncryptedForm ->
							form_toJs(x2)
						},
					)
				},
			)
		}

		override fun modifyForm(entity: GroupScopedJs<EncryptedFormJs>):
				Promise<GroupScopedJs<EncryptedFormJs>> = GlobalScope.promise {
			val entityConverted: GroupScoped<EncryptedForm> = groupScoped_fromJs(
				entity,
				{ x1: EncryptedFormJs ->
					form_fromJs(x1)
				},
			)
			val result = formBasicApi.inGroup.modifyForm(
				entityConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: EncryptedForm ->
					form_toJs(x1)
				},
			)
		}

		override fun modifyForms(entities: Array<GroupScopedJs<EncryptedFormJs>>):
				Promise<Array<GroupScopedJs<EncryptedFormJs>>> = GlobalScope.promise {
			val entitiesConverted: List<GroupScoped<EncryptedForm>> = arrayToList(
				entities,
				"entities",
				{ x1: GroupScopedJs<EncryptedFormJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: EncryptedFormJs ->
							form_fromJs(x2)
						},
					)
				},
			)
			val result = formBasicApi.inGroup.modifyForms(
				entitiesConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<EncryptedForm> ->
					groupScoped_toJs(
						x1,
						{ x2: EncryptedForm ->
							form_toJs(x2)
						},
					)
				},
			)
		}

		override fun getForm(groupId: String, entityId: String): Promise<GroupScopedJs<EncryptedFormJs>?>
				= GlobalScope.promise {
			val groupIdConverted: String = groupId
			val entityIdConverted: String = entityId
			val result = formBasicApi.inGroup.getForm(
				groupIdConverted,
				entityIdConverted,
			)
			nullToUndefined(
				result?.let { nonNull1 ->
					groupScoped_toJs(
						nonNull1,
						{ x1: EncryptedForm ->
							form_toJs(x1)
						},
					)
				}
			)
		}

		override fun getForms(groupId: String, entityIds: Array<String>):
				Promise<Array<GroupScopedJs<EncryptedFormJs>>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val entityIdsConverted: List<String> = arrayToList(
				entityIds,
				"entityIds",
				{ x1: String ->
					x1
				},
			)
			val result = formBasicApi.inGroup.getForms(
				groupIdConverted,
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<EncryptedForm> ->
					groupScoped_toJs(
						x1,
						{ x2: EncryptedForm ->
							form_toJs(x2)
						},
					)
				},
			)
		}
	}

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

	override fun deleteFormById(entityId: String, rev: String): Promise<StoredDocumentIdentifierJs> =
			GlobalScope.promise {
		val entityIdConverted: String = entityId
		val revConverted: String = rev
		val result = formBasicApi.deleteFormById(
			entityIdConverted,
			revConverted,
		)
		storedDocumentIdentifier_toJs(result)
	}

	override fun deleteFormsByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<StoredDocumentIdentifierJs>> = GlobalScope.promise {
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
			{ x1: StoredDocumentIdentifier ->
				storedDocumentIdentifier_toJs(x1)
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

	override fun purgeFormsByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<StoredDocumentIdentifierJs>> = GlobalScope.promise {
		val entityIdsConverted: List<StoredDocumentIdentifier> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: StoredDocumentIdentifierJs ->
				storedDocumentIdentifier_fromJs(x1)
			},
		)
		val result = formBasicApi.purgeFormsByIds(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: StoredDocumentIdentifier ->
				storedDocumentIdentifier_toJs(x1)
			},
		)
	}

	override fun deleteForm(form: FormJs): Promise<StoredDocumentIdentifierJs> = GlobalScope.promise {
		val formConverted: Form = form_fromJs(form)
		val result = formBasicApi.deleteForm(
			formConverted,
		)
		storedDocumentIdentifier_toJs(result)
	}

	override fun deleteForms(forms: Array<FormJs>): Promise<Array<StoredDocumentIdentifierJs>> =
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
			{ x1: StoredDocumentIdentifier ->
				storedDocumentIdentifier_toJs(x1)
			},
		)
	}

	override fun purgeForm(form: FormJs): Promise<Unit> = GlobalScope.promise {
		val formConverted: Form = form_fromJs(form)
		formBasicApi.purgeForm(
			formConverted,
		)

	}

	override fun purgeForms(forms: Array<FormJs>): Promise<Array<StoredDocumentIdentifierJs>> =
			GlobalScope.promise {
		val formsConverted: List<Form> = arrayToList(
			forms,
			"forms",
			{ x1: FormJs ->
				form_fromJs(x1)
			},
		)
		val result = formBasicApi.purgeForms(
			formsConverted,
		)
		listToArray(
			result,
			{ x1: StoredDocumentIdentifier ->
				storedDocumentIdentifier_toJs(x1)
			},
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

	override fun getFormTemplates(formTemplateIds: Array<String>): Promise<Array<FormTemplateJs>> =
			GlobalScope.promise {
		val formTemplateIdsConverted: List<String> = arrayToList(
			formTemplateIds,
			"formTemplateIds",
			{ x1: String ->
				x1
			},
		)
		val result = formBasicApi.getFormTemplates(
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
		val result = formBasicApi.createFormTemplate(
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
		val result = formBasicApi.createFormTemplates(
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
		val result = formBasicApi.modifyFormTemplate(
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
		val result = formBasicApi.modifyFormTemplates(
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
		val result = formBasicApi.deleteFormTemplateById(
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
		val result = formBasicApi.deleteFormTemplatesByIds(
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
		val result = formBasicApi.deleteFormTemplate(
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
		val result = formBasicApi.deleteFormTemplates(
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
		val result = formBasicApi.undeleteFormTemplateById(
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
		val result = formBasicApi.undeleteFormTemplatesByIds(
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
		val result = formBasicApi.undeleteFormTemplate(
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
		val result = formBasicApi.undeleteFormTemplates(
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
		formBasicApi.purgeFormTemplateById(
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
		val result = formBasicApi.purgeFormTemplatesByIds(
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
		formBasicApi.purgeFormTemplate(
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
		val result = formBasicApi.purgeFormTemplates(
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

	override fun undeleteFormsByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<EncryptedFormJs>> = GlobalScope.promise {
		val entityIdsConverted: List<StoredDocumentIdentifier> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: StoredDocumentIdentifierJs ->
				storedDocumentIdentifier_fromJs(x1)
			},
		)
		val result = formBasicApi.undeleteFormsByIds(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: EncryptedForm ->
				form_toJs(x1)
			},
		)
	}

	override fun undeleteForm(form: FormJs): Promise<EncryptedFormJs> = GlobalScope.promise {
		val formConverted: Form = form_fromJs(form)
		val result = formBasicApi.undeleteForm(
			formConverted,
		)
		form_toJs(result)
	}

	override fun undeleteForms(forms: Array<FormJs>): Promise<Array<EncryptedFormJs>> =
			GlobalScope.promise {
		val formsConverted: List<Form> = arrayToList(
			forms,
			"forms",
			{ x1: FormJs ->
				form_fromJs(x1)
			},
		)
		val result = formBasicApi.undeleteForms(
			formsConverted,
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

	override fun getLatestFormByUniqueId(uniqueId: String): Promise<EncryptedFormJs> =
			GlobalScope.promise {
		val uniqueIdConverted: String = uniqueId
		val result = formBasicApi.getLatestFormByUniqueId(
			uniqueIdConverted,
		)
		form_toJs(result)
	}
}
