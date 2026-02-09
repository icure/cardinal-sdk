// auto-generated file
package com.icure.cardinal.sdk.js.api.`impl`

import com.icure.cardinal.sdk.api.FormApi
import com.icure.cardinal.sdk.crypto.entities.FormShareOptions
import com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNonNull
import com.icure.cardinal.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNullable
import com.icure.cardinal.sdk.js.api.FormApiJs
import com.icure.cardinal.sdk.js.api.FormFlavouredApiJs
import com.icure.cardinal.sdk.js.api.FormFlavouredInGroupApiJs
import com.icure.cardinal.sdk.js.api.FormInGroupApiJs
import com.icure.cardinal.sdk.js.crypto.entities.FormShareOptionsJs
import com.icure.cardinal.sdk.js.crypto.entities.SecretIdUseOptionJs
import com.icure.cardinal.sdk.js.crypto.entities.formShareOptions_fromJs
import com.icure.cardinal.sdk.js.crypto.entities.secretIdUseOption_fromJs
import com.icure.cardinal.sdk.js.filters.FilterOptionsJs
import com.icure.cardinal.sdk.js.filters.SortableFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.filterOptions_fromJs
import com.icure.cardinal.sdk.js.filters.sortableFilterOptions_fromJs
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToList
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.cardinal.sdk.js.model.CheckedConverters.listToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.CheckedConverters.objectToMap
import com.icure.cardinal.sdk.js.model.CheckedConverters.setToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.js.model.DecryptedFormJs
import com.icure.cardinal.sdk.js.model.EncryptedFormJs
import com.icure.cardinal.sdk.js.model.EntityReferenceInGroupJs
import com.icure.cardinal.sdk.js.model.FormJs
import com.icure.cardinal.sdk.js.model.FormTemplateJs
import com.icure.cardinal.sdk.js.model.GroupScopedJs
import com.icure.cardinal.sdk.js.model.PatientJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.model.UserJs
import com.icure.cardinal.sdk.js.model.entityReferenceInGroup_fromJs
import com.icure.cardinal.sdk.js.model.entityReferenceInGroup_toJs
import com.icure.cardinal.sdk.js.model.formTemplate_fromJs
import com.icure.cardinal.sdk.js.model.formTemplate_toJs
import com.icure.cardinal.sdk.js.model.form_fromJs
import com.icure.cardinal.sdk.js.model.form_toJs
import com.icure.cardinal.sdk.js.model.groupScoped_fromJs
import com.icure.cardinal.sdk.js.model.groupScoped_toJs
import com.icure.cardinal.sdk.js.model.patient_fromJs
import com.icure.cardinal.sdk.js.model.specializations.hexString_toJs
import com.icure.cardinal.sdk.js.model.storedDocumentIdentifier_fromJs
import com.icure.cardinal.sdk.js.model.storedDocumentIdentifier_toJs
import com.icure.cardinal.sdk.js.model.user_fromJs
import com.icure.cardinal.sdk.js.synthetic.mapasobjectarray.EntityReferenceInGroupToAccessLevelMapObject_delegate_accessLevel
import com.icure.cardinal.sdk.js.synthetic.mapasobjectarray.EntityReferenceInGroupToAccessLevelMapObject_delegate_accessLevel_fromJs
import com.icure.cardinal.sdk.js.synthetic.mapasobjectarray.EntityReferenceInGroupToFormShareOptionsMapObject_delegate_shareOptions
import com.icure.cardinal.sdk.js.synthetic.mapasobjectarray.EntityReferenceInGroupToFormShareOptionsMapObject_delegate_shareOptions_fromJs
import com.icure.cardinal.sdk.js.utils.Record
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import com.icure.cardinal.sdk.js.utils.pagination.paginatedListIterator_toJs
import com.icure.cardinal.sdk.model.DecryptedForm
import com.icure.cardinal.sdk.model.EncryptedForm
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.model.Form
import com.icure.cardinal.sdk.model.FormTemplate
import com.icure.cardinal.sdk.model.GroupScoped
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
import com.icure.cardinal.sdk.model.User
import com.icure.cardinal.sdk.model.embed.AccessLevel
import com.icure.cardinal.sdk.model.specializations.HexString
import kotlin.Array
import kotlin.Boolean
import kotlin.ByteArray
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.Set
import kotlin.js.Promise
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise

@OptIn(DelicateCoroutinesApi::class)
internal class FormApiImplJs(
	private val formApi: FormApi,
) : FormApiJs {
	override val encrypted: FormFlavouredApiJs<EncryptedFormJs> = object :
			FormFlavouredApiJs<EncryptedFormJs> {
		override fun shareWith(
			delegateId: String,
			form: EncryptedFormJs,
			options: dynamic,
		): Promise<EncryptedFormJs> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val delegateIdConverted: String = delegateId
				val formConverted: EncryptedForm = form_fromJs(form)
				val optionsConverted: FormShareOptions? = convertingOptionOrDefaultNullable(
					_options,
					"options",
					null
				) { options: FormShareOptionsJs? ->
					options?.let { nonNull1 ->
						formShareOptions_fromJs(nonNull1)
					}
				}
				val result = formApi.encrypted.shareWith(
					delegateIdConverted,
					formConverted,
					optionsConverted,
				)
				form_toJs(result)
			}
		}

		override fun shareWithMany(form: EncryptedFormJs, delegates: Record<String, FormShareOptionsJs>):
				Promise<EncryptedFormJs> = GlobalScope.promise {
			val formConverted: EncryptedForm = form_fromJs(form)
			val delegatesConverted: Map<String, FormShareOptions> = objectToMap(
				delegates,
				"delegates",
				{ x1: String ->
					x1
				},
				{ x1: FormShareOptionsJs ->
					formShareOptions_fromJs(x1)
				},
			)
			val result = formApi.encrypted.shareWithMany(
				formConverted,
				delegatesConverted,
			)
			form_toJs(result)
		}

		override fun filterFormsBy(filter: FilterOptionsJs<FormJs>):
				Promise<PaginatedListIteratorJs<EncryptedFormJs>> = GlobalScope.promise {
			val filterConverted: FilterOptions<Form> = filterOptions_fromJs(filter)
			val result = formApi.encrypted.filterFormsBy(
				filterConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: EncryptedForm ->
					form_toJs(x1)
				},
			)
		}

		override fun filterFormsBySorted(filter: SortableFilterOptionsJs<FormJs>):
				Promise<PaginatedListIteratorJs<EncryptedFormJs>> = GlobalScope.promise {
			val filterConverted: SortableFilterOptions<Form> = sortableFilterOptions_fromJs(filter)
			val result = formApi.encrypted.filterFormsBySorted(
				filterConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: EncryptedForm ->
					form_toJs(x1)
				},
			)
		}

		override fun createForm(entity: EncryptedFormJs): Promise<EncryptedFormJs> = GlobalScope.promise {
			val entityConverted: EncryptedForm = form_fromJs(entity)
			val result = formApi.encrypted.createForm(
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
			val result = formApi.encrypted.createForms(
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
			val result = formApi.encrypted.modifyForm(
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
			val result = formApi.encrypted.modifyForms(
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
			val result = formApi.encrypted.undeleteFormById(
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
			val result = formApi.encrypted.undeleteFormsByIds(
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
			val result = formApi.encrypted.undeleteForm(
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
			val result = formApi.encrypted.undeleteForms(
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
			val result = formApi.encrypted.getForm(
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
			val result = formApi.encrypted.getForms(
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
			val result = formApi.encrypted.getLatestFormByUniqueId(
				uniqueIdConverted,
			)
			form_toJs(result)
		}
	}

	override val tryAndRecover: FormFlavouredApiJs<FormJs> = object : FormFlavouredApiJs<FormJs> {
		override fun shareWith(
			delegateId: String,
			form: FormJs,
			options: dynamic,
		): Promise<FormJs> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val delegateIdConverted: String = delegateId
				val formConverted: Form = form_fromJs(form)
				val optionsConverted: FormShareOptions? = convertingOptionOrDefaultNullable(
					_options,
					"options",
					null
				) { options: FormShareOptionsJs? ->
					options?.let { nonNull1 ->
						formShareOptions_fromJs(nonNull1)
					}
				}
				val result = formApi.tryAndRecover.shareWith(
					delegateIdConverted,
					formConverted,
					optionsConverted,
				)
				form_toJs(result)
			}
		}

		override fun shareWithMany(form: FormJs, delegates: Record<String, FormShareOptionsJs>):
				Promise<FormJs> = GlobalScope.promise {
			val formConverted: Form = form_fromJs(form)
			val delegatesConverted: Map<String, FormShareOptions> = objectToMap(
				delegates,
				"delegates",
				{ x1: String ->
					x1
				},
				{ x1: FormShareOptionsJs ->
					formShareOptions_fromJs(x1)
				},
			)
			val result = formApi.tryAndRecover.shareWithMany(
				formConverted,
				delegatesConverted,
			)
			form_toJs(result)
		}

		override fun filterFormsBy(filter: FilterOptionsJs<FormJs>):
				Promise<PaginatedListIteratorJs<FormJs>> = GlobalScope.promise {
			val filterConverted: FilterOptions<Form> = filterOptions_fromJs(filter)
			val result = formApi.tryAndRecover.filterFormsBy(
				filterConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: Form ->
					form_toJs(x1)
				},
			)
		}

		override fun filterFormsBySorted(filter: SortableFilterOptionsJs<FormJs>):
				Promise<PaginatedListIteratorJs<FormJs>> = GlobalScope.promise {
			val filterConverted: SortableFilterOptions<Form> = sortableFilterOptions_fromJs(filter)
			val result = formApi.tryAndRecover.filterFormsBySorted(
				filterConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: Form ->
					form_toJs(x1)
				},
			)
		}

		override fun createForm(entity: FormJs): Promise<FormJs> = GlobalScope.promise {
			val entityConverted: Form = form_fromJs(entity)
			val result = formApi.tryAndRecover.createForm(
				entityConverted,
			)
			form_toJs(result)
		}

		override fun createForms(entities: Array<FormJs>): Promise<Array<FormJs>> = GlobalScope.promise {
			val entitiesConverted: List<Form> = arrayToList(
				entities,
				"entities",
				{ x1: FormJs ->
					form_fromJs(x1)
				},
			)
			val result = formApi.tryAndRecover.createForms(
				entitiesConverted,
			)
			listToArray(
				result,
				{ x1: Form ->
					form_toJs(x1)
				},
			)
		}

		override fun modifyForm(entity: FormJs): Promise<FormJs> = GlobalScope.promise {
			val entityConverted: Form = form_fromJs(entity)
			val result = formApi.tryAndRecover.modifyForm(
				entityConverted,
			)
			form_toJs(result)
		}

		override fun modifyForms(entities: Array<FormJs>): Promise<Array<FormJs>> = GlobalScope.promise {
			val entitiesConverted: List<Form> = arrayToList(
				entities,
				"entities",
				{ x1: FormJs ->
					form_fromJs(x1)
				},
			)
			val result = formApi.tryAndRecover.modifyForms(
				entitiesConverted,
			)
			listToArray(
				result,
				{ x1: Form ->
					form_toJs(x1)
				},
			)
		}

		override fun undeleteFormById(id: String, rev: String): Promise<FormJs> = GlobalScope.promise {
			val idConverted: String = id
			val revConverted: String = rev
			val result = formApi.tryAndRecover.undeleteFormById(
				idConverted,
				revConverted,
			)
			form_toJs(result)
		}

		override fun undeleteFormsByIds(entityIds: Array<StoredDocumentIdentifierJs>):
				Promise<Array<FormJs>> = GlobalScope.promise {
			val entityIdsConverted: List<StoredDocumentIdentifier> = arrayToList(
				entityIds,
				"entityIds",
				{ x1: StoredDocumentIdentifierJs ->
					storedDocumentIdentifier_fromJs(x1)
				},
			)
			val result = formApi.tryAndRecover.undeleteFormsByIds(
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: Form ->
					form_toJs(x1)
				},
			)
		}

		override fun undeleteForm(form: FormJs): Promise<FormJs> = GlobalScope.promise {
			val formConverted: Form = form_fromJs(form)
			val result = formApi.tryAndRecover.undeleteForm(
				formConverted,
			)
			form_toJs(result)
		}

		override fun undeleteForms(forms: Array<FormJs>): Promise<Array<FormJs>> = GlobalScope.promise {
			val formsConverted: List<Form> = arrayToList(
				forms,
				"forms",
				{ x1: FormJs ->
					form_fromJs(x1)
				},
			)
			val result = formApi.tryAndRecover.undeleteForms(
				formsConverted,
			)
			listToArray(
				result,
				{ x1: Form ->
					form_toJs(x1)
				},
			)
		}

		override fun getForm(entityId: String): Promise<FormJs?> = GlobalScope.promise {
			val entityIdConverted: String = entityId
			val result = formApi.tryAndRecover.getForm(
				entityIdConverted,
			)
			nullToUndefined(
				result?.let { nonNull1 ->
					form_toJs(nonNull1)
				}
			)
		}

		override fun getForms(entityIds: Array<String>): Promise<Array<FormJs>> = GlobalScope.promise {
			val entityIdsConverted: List<String> = arrayToList(
				entityIds,
				"entityIds",
				{ x1: String ->
					x1
				},
			)
			val result = formApi.tryAndRecover.getForms(
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: Form ->
					form_toJs(x1)
				},
			)
		}

		override fun getLatestFormByUniqueId(uniqueId: String): Promise<FormJs> = GlobalScope.promise {
			val uniqueIdConverted: String = uniqueId
			val result = formApi.tryAndRecover.getLatestFormByUniqueId(
				uniqueIdConverted,
			)
			form_toJs(result)
		}
	}

	override val inGroup: FormInGroupApiJs = object : FormInGroupApiJs {
		override val encrypted: FormFlavouredInGroupApiJs<EncryptedFormJs> = object :
				FormFlavouredInGroupApiJs<EncryptedFormJs> {
			override fun shareWith(
				`delegate`: EntityReferenceInGroupJs,
				form: GroupScopedJs<EncryptedFormJs>,
				options: dynamic,
			): Promise<GroupScopedJs<EncryptedFormJs>> {
				val _options = options ?: js("{}")
				return GlobalScope.promise {
					val delegateConverted: EntityReferenceInGroup = entityReferenceInGroup_fromJs(delegate)
					val formConverted: GroupScoped<EncryptedForm> = groupScoped_fromJs(
						form,
						{ x1: EncryptedFormJs ->
							form_fromJs(x1)
						},
					)
					val optionsConverted: FormShareOptions? = convertingOptionOrDefaultNullable(
						_options,
						"options",
						null
					) { options: FormShareOptionsJs? ->
						options?.let { nonNull1 ->
							formShareOptions_fromJs(nonNull1)
						}
					}
					val result = formApi.inGroup.encrypted.shareWith(
						delegateConverted,
						formConverted,
						optionsConverted,
					)
					groupScoped_toJs(
						result,
						{ x1: EncryptedForm ->
							form_toJs(x1)
						},
					)
				}
			}

			override fun shareWithMany(form: GroupScopedJs<EncryptedFormJs>,
					delegates: Array<EntityReferenceInGroupToFormShareOptionsMapObject_delegate_shareOptions>):
					Promise<GroupScopedJs<EncryptedFormJs>> = GlobalScope.promise {
				val formConverted: GroupScoped<EncryptedForm> = groupScoped_fromJs(
					form,
					{ x1: EncryptedFormJs ->
						form_fromJs(x1)
					},
				)
				val delegatesConverted: Map<EntityReferenceInGroup, FormShareOptions> =
						EntityReferenceInGroupToFormShareOptionsMapObject_delegate_shareOptions_fromJs(delegates)
				val result = formApi.inGroup.encrypted.shareWithMany(
					formConverted,
					delegatesConverted,
				)
				groupScoped_toJs(
					result,
					{ x1: EncryptedForm ->
						form_toJs(x1)
					},
				)
			}

			override fun filterFormsBy(groupId: String, filter: FilterOptionsJs<FormJs>):
					Promise<PaginatedListIteratorJs<GroupScopedJs<EncryptedFormJs>>> = GlobalScope.promise {
				val groupIdConverted: String = groupId
				val filterConverted: FilterOptions<Form> = filterOptions_fromJs(filter)
				val result = formApi.inGroup.encrypted.filterFormsBy(
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

			override fun filterFormsBySorted(groupId: String, filter: SortableFilterOptionsJs<FormJs>):
					Promise<PaginatedListIteratorJs<GroupScopedJs<EncryptedFormJs>>> = GlobalScope.promise {
				val groupIdConverted: String = groupId
				val filterConverted: SortableFilterOptions<Form> = sortableFilterOptions_fromJs(filter)
				val result = formApi.inGroup.encrypted.filterFormsBySorted(
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

			override fun createForm(entity: GroupScopedJs<EncryptedFormJs>):
					Promise<GroupScopedJs<EncryptedFormJs>> = GlobalScope.promise {
				val entityConverted: GroupScoped<EncryptedForm> = groupScoped_fromJs(
					entity,
					{ x1: EncryptedFormJs ->
						form_fromJs(x1)
					},
				)
				val result = formApi.inGroup.encrypted.createForm(
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
				val result = formApi.inGroup.encrypted.createForms(
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
				val result = formApi.inGroup.encrypted.undeleteFormById(
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
				val result = formApi.inGroup.encrypted.undeleteFormsByIds(
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
				val result = formApi.inGroup.encrypted.undeleteForm(
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
				val result = formApi.inGroup.encrypted.undeleteForms(
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
				val result = formApi.inGroup.encrypted.modifyForm(
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
				val result = formApi.inGroup.encrypted.modifyForms(
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
				val result = formApi.inGroup.encrypted.getForm(
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
				val result = formApi.inGroup.encrypted.getForms(
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

		override val tryAndRecover: FormFlavouredInGroupApiJs<FormJs> = object :
				FormFlavouredInGroupApiJs<FormJs> {
			override fun shareWith(
				`delegate`: EntityReferenceInGroupJs,
				form: GroupScopedJs<FormJs>,
				options: dynamic,
			): Promise<GroupScopedJs<FormJs>> {
				val _options = options ?: js("{}")
				return GlobalScope.promise {
					val delegateConverted: EntityReferenceInGroup = entityReferenceInGroup_fromJs(delegate)
					val formConverted: GroupScoped<Form> = groupScoped_fromJs(
						form,
						{ x1: FormJs ->
							form_fromJs(x1)
						},
					)
					val optionsConverted: FormShareOptions? = convertingOptionOrDefaultNullable(
						_options,
						"options",
						null
					) { options: FormShareOptionsJs? ->
						options?.let { nonNull1 ->
							formShareOptions_fromJs(nonNull1)
						}
					}
					val result = formApi.inGroup.tryAndRecover.shareWith(
						delegateConverted,
						formConverted,
						optionsConverted,
					)
					groupScoped_toJs(
						result,
						{ x1: Form ->
							form_toJs(x1)
						},
					)
				}
			}

			override fun shareWithMany(form: GroupScopedJs<FormJs>,
					delegates: Array<EntityReferenceInGroupToFormShareOptionsMapObject_delegate_shareOptions>):
					Promise<GroupScopedJs<FormJs>> = GlobalScope.promise {
				val formConverted: GroupScoped<Form> = groupScoped_fromJs(
					form,
					{ x1: FormJs ->
						form_fromJs(x1)
					},
				)
				val delegatesConverted: Map<EntityReferenceInGroup, FormShareOptions> =
						EntityReferenceInGroupToFormShareOptionsMapObject_delegate_shareOptions_fromJs(delegates)
				val result = formApi.inGroup.tryAndRecover.shareWithMany(
					formConverted,
					delegatesConverted,
				)
				groupScoped_toJs(
					result,
					{ x1: Form ->
						form_toJs(x1)
					},
				)
			}

			override fun filterFormsBy(groupId: String, filter: FilterOptionsJs<FormJs>):
					Promise<PaginatedListIteratorJs<GroupScopedJs<FormJs>>> = GlobalScope.promise {
				val groupIdConverted: String = groupId
				val filterConverted: FilterOptions<Form> = filterOptions_fromJs(filter)
				val result = formApi.inGroup.tryAndRecover.filterFormsBy(
					groupIdConverted,
					filterConverted,
				)
				paginatedListIterator_toJs(
					result,
					{ x1: GroupScoped<Form> ->
						groupScoped_toJs(
							x1,
							{ x2: Form ->
								form_toJs(x2)
							},
						)
					},
				)
			}

			override fun filterFormsBySorted(groupId: String, filter: SortableFilterOptionsJs<FormJs>):
					Promise<PaginatedListIteratorJs<GroupScopedJs<FormJs>>> = GlobalScope.promise {
				val groupIdConverted: String = groupId
				val filterConverted: SortableFilterOptions<Form> = sortableFilterOptions_fromJs(filter)
				val result = formApi.inGroup.tryAndRecover.filterFormsBySorted(
					groupIdConverted,
					filterConverted,
				)
				paginatedListIterator_toJs(
					result,
					{ x1: GroupScoped<Form> ->
						groupScoped_toJs(
							x1,
							{ x2: Form ->
								form_toJs(x2)
							},
						)
					},
				)
			}

			override fun createForm(entity: GroupScopedJs<FormJs>): Promise<GroupScopedJs<FormJs>> =
					GlobalScope.promise {
				val entityConverted: GroupScoped<Form> = groupScoped_fromJs(
					entity,
					{ x1: FormJs ->
						form_fromJs(x1)
					},
				)
				val result = formApi.inGroup.tryAndRecover.createForm(
					entityConverted,
				)
				groupScoped_toJs(
					result,
					{ x1: Form ->
						form_toJs(x1)
					},
				)
			}

			override fun createForms(entities: Array<GroupScopedJs<FormJs>>):
					Promise<Array<GroupScopedJs<FormJs>>> = GlobalScope.promise {
				val entitiesConverted: List<GroupScoped<Form>> = arrayToList(
					entities,
					"entities",
					{ x1: GroupScopedJs<FormJs> ->
						groupScoped_fromJs(
							x1,
							{ x2: FormJs ->
								form_fromJs(x2)
							},
						)
					},
				)
				val result = formApi.inGroup.tryAndRecover.createForms(
					entitiesConverted,
				)
				listToArray(
					result,
					{ x1: GroupScoped<Form> ->
						groupScoped_toJs(
							x1,
							{ x2: Form ->
								form_toJs(x2)
							},
						)
					},
				)
			}

			override fun undeleteFormById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
					Promise<GroupScopedJs<FormJs>> = GlobalScope.promise {
				val entityIdConverted: GroupScoped<StoredDocumentIdentifier> = groupScoped_fromJs(
					entityId,
					{ x1: StoredDocumentIdentifierJs ->
						storedDocumentIdentifier_fromJs(x1)
					},
				)
				val result = formApi.inGroup.tryAndRecover.undeleteFormById(
					entityIdConverted,
				)
				groupScoped_toJs(
					result,
					{ x1: Form ->
						form_toJs(x1)
					},
				)
			}

			override fun undeleteFormsByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
					Promise<Array<GroupScopedJs<FormJs>>> = GlobalScope.promise {
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
				val result = formApi.inGroup.tryAndRecover.undeleteFormsByIds(
					entityIdsConverted,
				)
				listToArray(
					result,
					{ x1: GroupScoped<Form> ->
						groupScoped_toJs(
							x1,
							{ x2: Form ->
								form_toJs(x2)
							},
						)
					},
				)
			}

			override fun undeleteForm(form: GroupScopedJs<FormJs>): Promise<GroupScopedJs<FormJs>> =
					GlobalScope.promise {
				val formConverted: GroupScoped<Form> = groupScoped_fromJs(
					form,
					{ x1: FormJs ->
						form_fromJs(x1)
					},
				)
				val result = formApi.inGroup.tryAndRecover.undeleteForm(
					formConverted,
				)
				groupScoped_toJs(
					result,
					{ x1: Form ->
						form_toJs(x1)
					},
				)
			}

			override fun undeleteForms(forms: Array<GroupScopedJs<FormJs>>):
					Promise<Array<GroupScopedJs<FormJs>>> = GlobalScope.promise {
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
				val result = formApi.inGroup.tryAndRecover.undeleteForms(
					formsConverted,
				)
				listToArray(
					result,
					{ x1: GroupScoped<Form> ->
						groupScoped_toJs(
							x1,
							{ x2: Form ->
								form_toJs(x2)
							},
						)
					},
				)
			}

			override fun modifyForm(entity: GroupScopedJs<FormJs>): Promise<GroupScopedJs<FormJs>> =
					GlobalScope.promise {
				val entityConverted: GroupScoped<Form> = groupScoped_fromJs(
					entity,
					{ x1: FormJs ->
						form_fromJs(x1)
					},
				)
				val result = formApi.inGroup.tryAndRecover.modifyForm(
					entityConverted,
				)
				groupScoped_toJs(
					result,
					{ x1: Form ->
						form_toJs(x1)
					},
				)
			}

			override fun modifyForms(entities: Array<GroupScopedJs<FormJs>>):
					Promise<Array<GroupScopedJs<FormJs>>> = GlobalScope.promise {
				val entitiesConverted: List<GroupScoped<Form>> = arrayToList(
					entities,
					"entities",
					{ x1: GroupScopedJs<FormJs> ->
						groupScoped_fromJs(
							x1,
							{ x2: FormJs ->
								form_fromJs(x2)
							},
						)
					},
				)
				val result = formApi.inGroup.tryAndRecover.modifyForms(
					entitiesConverted,
				)
				listToArray(
					result,
					{ x1: GroupScoped<Form> ->
						groupScoped_toJs(
							x1,
							{ x2: Form ->
								form_toJs(x2)
							},
						)
					},
				)
			}

			override fun getForm(groupId: String, entityId: String): Promise<GroupScopedJs<FormJs>?> =
					GlobalScope.promise {
				val groupIdConverted: String = groupId
				val entityIdConverted: String = entityId
				val result = formApi.inGroup.tryAndRecover.getForm(
					groupIdConverted,
					entityIdConverted,
				)
				nullToUndefined(
					result?.let { nonNull1 ->
						groupScoped_toJs(
							nonNull1,
							{ x1: Form ->
								form_toJs(x1)
							},
						)
					}
				)
			}

			override fun getForms(groupId: String, entityIds: Array<String>):
					Promise<Array<GroupScopedJs<FormJs>>> = GlobalScope.promise {
				val groupIdConverted: String = groupId
				val entityIdsConverted: List<String> = arrayToList(
					entityIds,
					"entityIds",
					{ x1: String ->
						x1
					},
				)
				val result = formApi.inGroup.tryAndRecover.getForms(
					groupIdConverted,
					entityIdsConverted,
				)
				listToArray(
					result,
					{ x1: GroupScoped<Form> ->
						groupScoped_toJs(
							x1,
							{ x2: Form ->
								form_toJs(x2)
							},
						)
					},
				)
			}
		}

		override fun withEncryptionMetadata(
			entityGroupId: String,
			base: DecryptedFormJs?,
			patient: GroupScopedJs<PatientJs>?,
			options: dynamic,
		): Promise<GroupScopedJs<DecryptedFormJs>> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val entityGroupIdConverted: String = entityGroupId
				val baseConverted: DecryptedForm? = base?.let { nonNull1 ->
					form_fromJs(nonNull1)
				}
				val patientConverted: GroupScoped<Patient>? = patient?.let { nonNull1 ->
					groupScoped_fromJs(
						nonNull1,
						{ x1: PatientJs ->
							patient_fromJs(x1)
						},
					)
				}
				val userConverted: User? = convertingOptionOrDefaultNullable(
					_options,
					"user",
					null
				) { user: UserJs? ->
					user?.let { nonNull1 ->
						user_fromJs(nonNull1)
					}
				}
				val delegatesConverted: Map<EntityReferenceInGroup, AccessLevel> =
						convertingOptionOrDefaultNonNull(
					_options,
					"delegates",
					emptyMap()
				) { delegates: Array<EntityReferenceInGroupToAccessLevelMapObject_delegate_accessLevel> ->
					EntityReferenceInGroupToAccessLevelMapObject_delegate_accessLevel_fromJs(delegates)
				}
				val secretIdConverted: SecretIdUseOption = convertingOptionOrDefaultNonNull(
					_options,
					"secretId",
					com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption.UseAnySharedWithParent
				) { secretId: SecretIdUseOptionJs ->
					secretIdUseOption_fromJs(secretId)
				}
				val alternateRootDelegateReferenceConverted: EntityReferenceInGroup? =
						convertingOptionOrDefaultNullable(
					_options,
					"alternateRootDelegateReference",
					null
				) { alternateRootDelegateReference: EntityReferenceInGroupJs? ->
					alternateRootDelegateReference?.let { nonNull1 ->
						entityReferenceInGroup_fromJs(nonNull1)
					}
				}
				val result = formApi.inGroup.withEncryptionMetadata(
					entityGroupIdConverted,
					baseConverted,
					patientConverted,
					userConverted,
					delegatesConverted,
					secretIdConverted,
					alternateRootDelegateReferenceConverted,
				)
				groupScoped_toJs(
					result,
					{ x1: DecryptedForm ->
						form_toJs(x1)
					},
				)
			}
		}

		override fun getEncryptionKeysOf(form: GroupScopedJs<FormJs>): Promise<Array<String>> =
				GlobalScope.promise {
			val formConverted: GroupScoped<Form> = groupScoped_fromJs(
				form,
				{ x1: FormJs ->
					form_fromJs(x1)
				},
			)
			val result = formApi.inGroup.getEncryptionKeysOf(
				formConverted,
			)
			setToArray(
				result,
				{ x1: HexString ->
					hexString_toJs(x1)
				},
			)
		}

		override fun hasWriteAccess(form: GroupScopedJs<FormJs>): Promise<Boolean> = GlobalScope.promise {
			val formConverted: GroupScoped<Form> = groupScoped_fromJs(
				form,
				{ x1: FormJs ->
					form_fromJs(x1)
				},
			)
			val result = formApi.inGroup.hasWriteAccess(
				formConverted,
			)
			result
		}

		override fun decryptPatientIdOf(form: GroupScopedJs<FormJs>):
				Promise<Array<EntityReferenceInGroupJs>> = GlobalScope.promise {
			val formConverted: GroupScoped<Form> = groupScoped_fromJs(
				form,
				{ x1: FormJs ->
					form_fromJs(x1)
				},
			)
			val result = formApi.inGroup.decryptPatientIdOf(
				formConverted,
			)
			setToArray(
				result,
				{ x1: EntityReferenceInGroup ->
					entityReferenceInGroup_toJs(x1)
				},
			)
		}

		override fun createDelegationDeAnonymizationMetadata(entity: GroupScopedJs<FormJs>,
				delegates: Array<EntityReferenceInGroupJs>): Promise<Unit> = GlobalScope.promise {
			val entityConverted: GroupScoped<Form> = groupScoped_fromJs(
				entity,
				{ x1: FormJs ->
					form_fromJs(x1)
				},
			)
			val delegatesConverted: Set<EntityReferenceInGroup> = arrayToSet(
				delegates,
				"delegates",
				{ x1: EntityReferenceInGroupJs ->
					entityReferenceInGroup_fromJs(x1)
				},
			)
			formApi.inGroup.createDelegationDeAnonymizationMetadata(
				entityConverted,
				delegatesConverted,
			)

		}

		override fun decrypt(forms: Array<GroupScopedJs<EncryptedFormJs>>):
				Promise<Array<GroupScopedJs<DecryptedFormJs>>> = GlobalScope.promise {
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
			val result = formApi.inGroup.decrypt(
				formsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<DecryptedForm> ->
					groupScoped_toJs(
						x1,
						{ x2: DecryptedForm ->
							form_toJs(x2)
						},
					)
				},
			)
		}

		override fun tryDecrypt(forms: Array<GroupScopedJs<EncryptedFormJs>>):
				Promise<Array<GroupScopedJs<FormJs>>> = GlobalScope.promise {
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
			val result = formApi.inGroup.tryDecrypt(
				formsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<Form> ->
					groupScoped_toJs(
						x1,
						{ x2: Form ->
							form_toJs(x2)
						},
					)
				},
			)
		}

		override fun matchFormsBy(groupId: String, filter: FilterOptionsJs<FormJs>):
				Promise<Array<String>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val filterConverted: FilterOptions<Form> = filterOptions_fromJs(filter)
			val result = formApi.inGroup.matchFormsBy(
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

		override fun matchFormsBySorted(groupId: String, filter: SortableFilterOptionsJs<FormJs>):
				Promise<Array<String>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val filterConverted: SortableFilterOptions<Form> = sortableFilterOptions_fromJs(filter)
			val result = formApi.inGroup.matchFormsBySorted(
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

		override fun deleteFormById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
				Promise<GroupScopedJs<StoredDocumentIdentifierJs>> = GlobalScope.promise {
			val entityIdConverted: GroupScoped<StoredDocumentIdentifier> = groupScoped_fromJs(
				entityId,
				{ x1: StoredDocumentIdentifierJs ->
					storedDocumentIdentifier_fromJs(x1)
				},
			)
			val result = formApi.inGroup.deleteFormById(
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
			val result = formApi.inGroup.deleteFormsByIds(
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
			formApi.inGroup.purgeFormById(
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
			val result = formApi.inGroup.purgeFormsByIds(
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
			val result = formApi.inGroup.deleteForm(
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
			val result = formApi.inGroup.deleteForms(
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
			formApi.inGroup.purgeForm(
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
			val result = formApi.inGroup.purgeForms(
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
			val result = formApi.inGroup.createFormTemplate(
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
			val result = formApi.inGroup.createFormTemplates(
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
			val result = formApi.inGroup.getFormTemplate(
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
			val result = formApi.inGroup.getFormTemplates(
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
			val result = formApi.inGroup.modifyFormTemplate(
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
			val result = formApi.inGroup.modifyFormTemplates(
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
			val result = formApi.inGroup.deleteFormTemplateById(
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
			val result = formApi.inGroup.deleteFormTemplateByIds(
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
			val result = formApi.inGroup.deleteFormTemplate(
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
			val result = formApi.inGroup.deleteFormTemplates(
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
			val result = formApi.inGroup.undeleteFormTemplateById(
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
			val result = formApi.inGroup.undeleteFormTemplateByIds(
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
			val result = formApi.inGroup.undeleteFormTemplate(
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
			val result = formApi.inGroup.undeleteFormTemplates(
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
			formApi.inGroup.purgeFormTemplateById(
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
			val result = formApi.inGroup.purgeFormTemplateByIds(
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
			formApi.inGroup.purgeFormTemplate(
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
			val result = formApi.inGroup.purgeFormTemplates(
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

		override fun shareWith(
			`delegate`: EntityReferenceInGroupJs,
			form: GroupScopedJs<DecryptedFormJs>,
			options: dynamic,
		): Promise<GroupScopedJs<DecryptedFormJs>> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val delegateConverted: EntityReferenceInGroup = entityReferenceInGroup_fromJs(delegate)
				val formConverted: GroupScoped<DecryptedForm> = groupScoped_fromJs(
					form,
					{ x1: DecryptedFormJs ->
						form_fromJs(x1)
					},
				)
				val optionsConverted: FormShareOptions? = convertingOptionOrDefaultNullable(
					_options,
					"options",
					null
				) { options: FormShareOptionsJs? ->
					options?.let { nonNull1 ->
						formShareOptions_fromJs(nonNull1)
					}
				}
				val result = formApi.inGroup.shareWith(
					delegateConverted,
					formConverted,
					optionsConverted,
				)
				groupScoped_toJs(
					result,
					{ x1: DecryptedForm ->
						form_toJs(x1)
					},
				)
			}
		}

		override fun shareWithMany(form: GroupScopedJs<DecryptedFormJs>,
				delegates: Array<EntityReferenceInGroupToFormShareOptionsMapObject_delegate_shareOptions>):
				Promise<GroupScopedJs<DecryptedFormJs>> = GlobalScope.promise {
			val formConverted: GroupScoped<DecryptedForm> = groupScoped_fromJs(
				form,
				{ x1: DecryptedFormJs ->
					form_fromJs(x1)
				},
			)
			val delegatesConverted: Map<EntityReferenceInGroup, FormShareOptions> =
					EntityReferenceInGroupToFormShareOptionsMapObject_delegate_shareOptions_fromJs(delegates)
			val result = formApi.inGroup.shareWithMany(
				formConverted,
				delegatesConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: DecryptedForm ->
					form_toJs(x1)
				},
			)
		}

		override fun filterFormsBy(groupId: String, filter: FilterOptionsJs<FormJs>):
				Promise<PaginatedListIteratorJs<GroupScopedJs<DecryptedFormJs>>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val filterConverted: FilterOptions<Form> = filterOptions_fromJs(filter)
			val result = formApi.inGroup.filterFormsBy(
				groupIdConverted,
				filterConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: GroupScoped<DecryptedForm> ->
					groupScoped_toJs(
						x1,
						{ x2: DecryptedForm ->
							form_toJs(x2)
						},
					)
				},
			)
		}

		override fun filterFormsBySorted(groupId: String, filter: SortableFilterOptionsJs<FormJs>):
				Promise<PaginatedListIteratorJs<GroupScopedJs<DecryptedFormJs>>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val filterConverted: SortableFilterOptions<Form> = sortableFilterOptions_fromJs(filter)
			val result = formApi.inGroup.filterFormsBySorted(
				groupIdConverted,
				filterConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: GroupScoped<DecryptedForm> ->
					groupScoped_toJs(
						x1,
						{ x2: DecryptedForm ->
							form_toJs(x2)
						},
					)
				},
			)
		}

		override fun createForm(entity: GroupScopedJs<DecryptedFormJs>):
				Promise<GroupScopedJs<DecryptedFormJs>> = GlobalScope.promise {
			val entityConverted: GroupScoped<DecryptedForm> = groupScoped_fromJs(
				entity,
				{ x1: DecryptedFormJs ->
					form_fromJs(x1)
				},
			)
			val result = formApi.inGroup.createForm(
				entityConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: DecryptedForm ->
					form_toJs(x1)
				},
			)
		}

		override fun createForms(entities: Array<GroupScopedJs<DecryptedFormJs>>):
				Promise<Array<GroupScopedJs<DecryptedFormJs>>> = GlobalScope.promise {
			val entitiesConverted: List<GroupScoped<DecryptedForm>> = arrayToList(
				entities,
				"entities",
				{ x1: GroupScopedJs<DecryptedFormJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: DecryptedFormJs ->
							form_fromJs(x2)
						},
					)
				},
			)
			val result = formApi.inGroup.createForms(
				entitiesConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<DecryptedForm> ->
					groupScoped_toJs(
						x1,
						{ x2: DecryptedForm ->
							form_toJs(x2)
						},
					)
				},
			)
		}

		override fun undeleteFormById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
				Promise<GroupScopedJs<DecryptedFormJs>> = GlobalScope.promise {
			val entityIdConverted: GroupScoped<StoredDocumentIdentifier> = groupScoped_fromJs(
				entityId,
				{ x1: StoredDocumentIdentifierJs ->
					storedDocumentIdentifier_fromJs(x1)
				},
			)
			val result = formApi.inGroup.undeleteFormById(
				entityIdConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: DecryptedForm ->
					form_toJs(x1)
				},
			)
		}

		override fun undeleteFormsByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
				Promise<Array<GroupScopedJs<DecryptedFormJs>>> = GlobalScope.promise {
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
			val result = formApi.inGroup.undeleteFormsByIds(
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<DecryptedForm> ->
					groupScoped_toJs(
						x1,
						{ x2: DecryptedForm ->
							form_toJs(x2)
						},
					)
				},
			)
		}

		override fun undeleteForm(form: GroupScopedJs<FormJs>): Promise<GroupScopedJs<DecryptedFormJs>> =
				GlobalScope.promise {
			val formConverted: GroupScoped<Form> = groupScoped_fromJs(
				form,
				{ x1: FormJs ->
					form_fromJs(x1)
				},
			)
			val result = formApi.inGroup.undeleteForm(
				formConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: DecryptedForm ->
					form_toJs(x1)
				},
			)
		}

		override fun undeleteForms(forms: Array<GroupScopedJs<DecryptedFormJs>>):
				Promise<Array<GroupScopedJs<DecryptedFormJs>>> = GlobalScope.promise {
			val formsConverted: List<GroupScoped<DecryptedForm>> = arrayToList(
				forms,
				"forms",
				{ x1: GroupScopedJs<DecryptedFormJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: DecryptedFormJs ->
							form_fromJs(x2)
						},
					)
				},
			)
			val result = formApi.inGroup.undeleteForms(
				formsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<DecryptedForm> ->
					groupScoped_toJs(
						x1,
						{ x2: DecryptedForm ->
							form_toJs(x2)
						},
					)
				},
			)
		}

		override fun modifyForm(entity: GroupScopedJs<DecryptedFormJs>):
				Promise<GroupScopedJs<DecryptedFormJs>> = GlobalScope.promise {
			val entityConverted: GroupScoped<DecryptedForm> = groupScoped_fromJs(
				entity,
				{ x1: DecryptedFormJs ->
					form_fromJs(x1)
				},
			)
			val result = formApi.inGroup.modifyForm(
				entityConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: DecryptedForm ->
					form_toJs(x1)
				},
			)
		}

		override fun modifyForms(entities: Array<GroupScopedJs<DecryptedFormJs>>):
				Promise<Array<GroupScopedJs<DecryptedFormJs>>> = GlobalScope.promise {
			val entitiesConverted: List<GroupScoped<DecryptedForm>> = arrayToList(
				entities,
				"entities",
				{ x1: GroupScopedJs<DecryptedFormJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: DecryptedFormJs ->
							form_fromJs(x2)
						},
					)
				},
			)
			val result = formApi.inGroup.modifyForms(
				entitiesConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<DecryptedForm> ->
					groupScoped_toJs(
						x1,
						{ x2: DecryptedForm ->
							form_toJs(x2)
						},
					)
				},
			)
		}

		override fun getForm(groupId: String, entityId: String): Promise<GroupScopedJs<DecryptedFormJs>?>
				= GlobalScope.promise {
			val groupIdConverted: String = groupId
			val entityIdConverted: String = entityId
			val result = formApi.inGroup.getForm(
				groupIdConverted,
				entityIdConverted,
			)
			nullToUndefined(
				result?.let { nonNull1 ->
					groupScoped_toJs(
						nonNull1,
						{ x1: DecryptedForm ->
							form_toJs(x1)
						},
					)
				}
			)
		}

		override fun getForms(groupId: String, entityIds: Array<String>):
				Promise<Array<GroupScopedJs<DecryptedFormJs>>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val entityIdsConverted: List<String> = arrayToList(
				entityIds,
				"entityIds",
				{ x1: String ->
					x1
				},
			)
			val result = formApi.inGroup.getForms(
				groupIdConverted,
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<DecryptedForm> ->
					groupScoped_toJs(
						x1,
						{ x2: DecryptedForm ->
							form_toJs(x2)
						},
					)
				},
			)
		}
	}

	override fun withEncryptionMetadata(
		base: DecryptedFormJs?,
		patient: PatientJs,
		options: dynamic,
	): Promise<DecryptedFormJs> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val baseConverted: DecryptedForm? = base?.let { nonNull1 ->
				form_fromJs(nonNull1)
			}
			val patientConverted: Patient = patient_fromJs(patient)
			val userConverted: User? = convertingOptionOrDefaultNullable(
				_options,
				"user",
				null
			) { user: UserJs? ->
				user?.let { nonNull1 ->
					user_fromJs(nonNull1)
				}
			}
			val delegatesConverted: Map<String, AccessLevel> = convertingOptionOrDefaultNonNull(
				_options,
				"delegates",
				emptyMap()
			) { delegates: Record<String, String> ->
				objectToMap(
					delegates,
					"delegates",
					{ x1: String ->
						x1
					},
					{ x1: String ->
						AccessLevel.valueOf(x1)
					},
				)
			}
			val secretIdConverted: SecretIdUseOption = convertingOptionOrDefaultNonNull(
				_options,
				"secretId",
				com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption.UseAnySharedWithParent
			) { secretId: SecretIdUseOptionJs ->
				secretIdUseOption_fromJs(secretId)
			}
			val alternateRootDelegateIdConverted: String? = convertingOptionOrDefaultNullable(
				_options,
				"alternateRootDelegateId",
				null
			) { alternateRootDelegateId: String? ->
				undefinedToNull(alternateRootDelegateId)
			}
			val result = formApi.withEncryptionMetadata(
				baseConverted,
				patientConverted,
				userConverted,
				delegatesConverted,
				secretIdConverted,
				alternateRootDelegateIdConverted,
			)
			form_toJs(result)
		}
	}

	override fun getEncryptionKeysOf(form: FormJs): Promise<Array<String>> = GlobalScope.promise {
		val formConverted: Form = form_fromJs(form)
		val result = formApi.getEncryptionKeysOf(
			formConverted,
		)
		setToArray(
			result,
			{ x1: HexString ->
				hexString_toJs(x1)
			},
		)
	}

	override fun hasWriteAccess(form: FormJs): Promise<Boolean> = GlobalScope.promise {
		val formConverted: Form = form_fromJs(form)
		val result = formApi.hasWriteAccess(
			formConverted,
		)
		result
	}

	override fun decryptPatientIdOf(form: FormJs): Promise<Array<EntityReferenceInGroupJs>> =
			GlobalScope.promise {
		val formConverted: Form = form_fromJs(form)
		val result = formApi.decryptPatientIdOf(
			formConverted,
		)
		setToArray(
			result,
			{ x1: EntityReferenceInGroup ->
				entityReferenceInGroup_toJs(x1)
			},
		)
	}

	override fun createDelegationDeAnonymizationMetadata(entity: FormJs, delegates: Array<String>):
			Promise<Unit> = GlobalScope.promise {
		val entityConverted: Form = form_fromJs(entity)
		val delegatesConverted: Set<String> = arrayToSet(
			delegates,
			"delegates",
			{ x1: String ->
				x1
			},
		)
		formApi.createDelegationDeAnonymizationMetadata(
			entityConverted,
			delegatesConverted,
		)

	}

	override fun decrypt(form: EncryptedFormJs): Promise<DecryptedFormJs> = GlobalScope.promise {
		val formConverted: EncryptedForm = form_fromJs(form)
		val result = formApi.decrypt(
			formConverted,
		)
		form_toJs(result)
	}

	override fun tryDecrypt(form: EncryptedFormJs): Promise<FormJs> = GlobalScope.promise {
		val formConverted: EncryptedForm = form_fromJs(form)
		val result = formApi.tryDecrypt(
			formConverted,
		)
		form_toJs(result)
	}

	override fun matchFormsBy(filter: FilterOptionsJs<FormJs>): Promise<Array<String>> =
			GlobalScope.promise {
		val filterConverted: FilterOptions<Form> = filterOptions_fromJs(filter)
		val result = formApi.matchFormsBy(
			filterConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun matchFormsBySorted(filter: SortableFilterOptionsJs<FormJs>): Promise<Array<String>> =
			GlobalScope.promise {
		val filterConverted: SortableFilterOptions<Form> = sortableFilterOptions_fromJs(filter)
		val result = formApi.matchFormsBySorted(
			filterConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun deleteFormById(entityId: String, rev: String): Promise<StoredDocumentIdentifierJs> =
			GlobalScope.promise {
		val entityIdConverted: String = entityId
		val revConverted: String = rev
		val result = formApi.deleteFormById(
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
		val result = formApi.deleteFormsByIds(
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
		formApi.purgeFormById(
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
		val result = formApi.purgeFormsByIds(
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
		val result = formApi.deleteForm(
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
		val result = formApi.deleteForms(
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
		formApi.purgeForm(
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
		val result = formApi.purgeForms(
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
			val result = formApi.getFormTemplate(
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
		val result = formApi.getFormTemplates(
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
		val result = formApi.createFormTemplate(
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
		val result = formApi.createFormTemplates(
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
		val result = formApi.modifyFormTemplate(
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
		val result = formApi.modifyFormTemplates(
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
		val result = formApi.deleteFormTemplateById(
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
		val result = formApi.deleteFormTemplatesByIds(
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
		val result = formApi.deleteFormTemplate(
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
		val result = formApi.deleteFormTemplates(
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
		val result = formApi.undeleteFormTemplateById(
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
		val result = formApi.undeleteFormTemplatesByIds(
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
		val result = formApi.undeleteFormTemplate(
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
		val result = formApi.undeleteFormTemplates(
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
		formApi.purgeFormTemplateById(
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
		val result = formApi.purgeFormTemplatesByIds(
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
		formApi.purgeFormTemplate(
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
		val result = formApi.purgeFormTemplates(
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
		val result = formApi.setTemplateAttachment(
			formTemplateIdConverted,
			payloadConverted,
		)
		result
	}

	override fun shareWith(
		delegateId: String,
		form: DecryptedFormJs,
		options: dynamic,
	): Promise<DecryptedFormJs> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val delegateIdConverted: String = delegateId
			val formConverted: DecryptedForm = form_fromJs(form)
			val optionsConverted: FormShareOptions? = convertingOptionOrDefaultNullable(
				_options,
				"options",
				null
			) { options: FormShareOptionsJs? ->
				options?.let { nonNull1 ->
					formShareOptions_fromJs(nonNull1)
				}
			}
			val result = formApi.shareWith(
				delegateIdConverted,
				formConverted,
				optionsConverted,
			)
			form_toJs(result)
		}
	}

	override fun shareWithMany(form: DecryptedFormJs, delegates: Record<String, FormShareOptionsJs>):
			Promise<DecryptedFormJs> = GlobalScope.promise {
		val formConverted: DecryptedForm = form_fromJs(form)
		val delegatesConverted: Map<String, FormShareOptions> = objectToMap(
			delegates,
			"delegates",
			{ x1: String ->
				x1
			},
			{ x1: FormShareOptionsJs ->
				formShareOptions_fromJs(x1)
			},
		)
		val result = formApi.shareWithMany(
			formConverted,
			delegatesConverted,
		)
		form_toJs(result)
	}

	override fun filterFormsBy(filter: FilterOptionsJs<FormJs>):
			Promise<PaginatedListIteratorJs<DecryptedFormJs>> = GlobalScope.promise {
		val filterConverted: FilterOptions<Form> = filterOptions_fromJs(filter)
		val result = formApi.filterFormsBy(
			filterConverted,
		)
		paginatedListIterator_toJs(
			result,
			{ x1: DecryptedForm ->
				form_toJs(x1)
			},
		)
	}

	override fun filterFormsBySorted(filter: SortableFilterOptionsJs<FormJs>):
			Promise<PaginatedListIteratorJs<DecryptedFormJs>> = GlobalScope.promise {
		val filterConverted: SortableFilterOptions<Form> = sortableFilterOptions_fromJs(filter)
		val result = formApi.filterFormsBySorted(
			filterConverted,
		)
		paginatedListIterator_toJs(
			result,
			{ x1: DecryptedForm ->
				form_toJs(x1)
			},
		)
	}

	override fun createForm(entity: DecryptedFormJs): Promise<DecryptedFormJs> = GlobalScope.promise {
		val entityConverted: DecryptedForm = form_fromJs(entity)
		val result = formApi.createForm(
			entityConverted,
		)
		form_toJs(result)
	}

	override fun createForms(entities: Array<DecryptedFormJs>): Promise<Array<DecryptedFormJs>> =
			GlobalScope.promise {
		val entitiesConverted: List<DecryptedForm> = arrayToList(
			entities,
			"entities",
			{ x1: DecryptedFormJs ->
				form_fromJs(x1)
			},
		)
		val result = formApi.createForms(
			entitiesConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedForm ->
				form_toJs(x1)
			},
		)
	}

	override fun modifyForm(entity: DecryptedFormJs): Promise<DecryptedFormJs> = GlobalScope.promise {
		val entityConverted: DecryptedForm = form_fromJs(entity)
		val result = formApi.modifyForm(
			entityConverted,
		)
		form_toJs(result)
	}

	override fun modifyForms(entities: Array<DecryptedFormJs>): Promise<Array<DecryptedFormJs>> =
			GlobalScope.promise {
		val entitiesConverted: List<DecryptedForm> = arrayToList(
			entities,
			"entities",
			{ x1: DecryptedFormJs ->
				form_fromJs(x1)
			},
		)
		val result = formApi.modifyForms(
			entitiesConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedForm ->
				form_toJs(x1)
			},
		)
	}

	override fun undeleteFormById(id: String, rev: String): Promise<DecryptedFormJs> =
			GlobalScope.promise {
		val idConverted: String = id
		val revConverted: String = rev
		val result = formApi.undeleteFormById(
			idConverted,
			revConverted,
		)
		form_toJs(result)
	}

	override fun undeleteFormsByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<DecryptedFormJs>> = GlobalScope.promise {
		val entityIdsConverted: List<StoredDocumentIdentifier> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: StoredDocumentIdentifierJs ->
				storedDocumentIdentifier_fromJs(x1)
			},
		)
		val result = formApi.undeleteFormsByIds(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedForm ->
				form_toJs(x1)
			},
		)
	}

	override fun undeleteForm(form: FormJs): Promise<DecryptedFormJs> = GlobalScope.promise {
		val formConverted: Form = form_fromJs(form)
		val result = formApi.undeleteForm(
			formConverted,
		)
		form_toJs(result)
	}

	override fun undeleteForms(forms: Array<FormJs>): Promise<Array<DecryptedFormJs>> =
			GlobalScope.promise {
		val formsConverted: List<Form> = arrayToList(
			forms,
			"forms",
			{ x1: FormJs ->
				form_fromJs(x1)
			},
		)
		val result = formApi.undeleteForms(
			formsConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedForm ->
				form_toJs(x1)
			},
		)
	}

	override fun getForm(entityId: String): Promise<DecryptedFormJs?> = GlobalScope.promise {
		val entityIdConverted: String = entityId
		val result = formApi.getForm(
			entityIdConverted,
		)
		nullToUndefined(
			result?.let { nonNull1 ->
				form_toJs(nonNull1)
			}
		)
	}

	override fun getForms(entityIds: Array<String>): Promise<Array<DecryptedFormJs>> =
			GlobalScope.promise {
		val entityIdsConverted: List<String> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: String ->
				x1
			},
		)
		val result = formApi.getForms(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedForm ->
				form_toJs(x1)
			},
		)
	}

	override fun getLatestFormByUniqueId(uniqueId: String): Promise<DecryptedFormJs> =
			GlobalScope.promise {
		val uniqueIdConverted: String = uniqueId
		val result = formApi.getLatestFormByUniqueId(
			uniqueIdConverted,
		)
		form_toJs(result)
	}
}
