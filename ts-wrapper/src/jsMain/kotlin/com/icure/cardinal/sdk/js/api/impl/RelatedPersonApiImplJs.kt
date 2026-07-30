// auto-generated file
package com.icure.cardinal.sdk.js.api.`impl`

import com.icure.cardinal.sdk.api.RelatedPersonApi
import com.icure.cardinal.sdk.crypto.entities.RelatedPersonDelegateOptions
import com.icure.cardinal.sdk.crypto.entities.RelatedPersonShareOptions
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNonNull
import com.icure.cardinal.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNullable
import com.icure.cardinal.sdk.js.api.RelatedPersonApiJs
import com.icure.cardinal.sdk.js.api.RelatedPersonFlavouredApiJs
import com.icure.cardinal.sdk.js.api.RelatedPersonFlavouredInGroupApiJs
import com.icure.cardinal.sdk.js.api.RelatedPersonInGroupApiJs
import com.icure.cardinal.sdk.js.crypto.entities.RelatedPersonDelegateOptionsJs
import com.icure.cardinal.sdk.js.crypto.entities.RelatedPersonShareOptionsJs
import com.icure.cardinal.sdk.js.crypto.entities.relatedPersonDelegateOptions_fromJs
import com.icure.cardinal.sdk.js.crypto.entities.relatedPersonShareOptions_fromJs
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
import com.icure.cardinal.sdk.js.model.DecryptedRelatedPersonJs
import com.icure.cardinal.sdk.js.model.EncryptedRelatedPersonJs
import com.icure.cardinal.sdk.js.model.EntityReferenceInGroupJs
import com.icure.cardinal.sdk.js.model.GroupScopedJs
import com.icure.cardinal.sdk.js.model.RelatedPersonJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.model.UserJs
import com.icure.cardinal.sdk.js.model.entityReferenceInGroup_fromJs
import com.icure.cardinal.sdk.js.model.groupScoped_fromJs
import com.icure.cardinal.sdk.js.model.groupScoped_toJs
import com.icure.cardinal.sdk.js.model.relatedPerson_fromJs
import com.icure.cardinal.sdk.js.model.relatedPerson_toJs
import com.icure.cardinal.sdk.js.model.specializations.hexString_toJs
import com.icure.cardinal.sdk.js.model.storedDocumentIdentifier_fromJs
import com.icure.cardinal.sdk.js.model.storedDocumentIdentifier_toJs
import com.icure.cardinal.sdk.js.model.user_fromJs
import com.icure.cardinal.sdk.js.subscription.EntitySubscriptionConfigurationJs
import com.icure.cardinal.sdk.js.subscription.EntitySubscriptionJs
import com.icure.cardinal.sdk.js.subscription.entitySubscriptionConfiguration_fromJs
import com.icure.cardinal.sdk.js.subscription.entitySubscription_toJs
import com.icure.cardinal.sdk.js.synthetic.mapasobjectarray.EntityReferenceInGroupToAccessLevelMapObject_delegate_accessLevel
import com.icure.cardinal.sdk.js.synthetic.mapasobjectarray.EntityReferenceInGroupToAccessLevelMapObject_delegate_accessLevel_fromJs
import com.icure.cardinal.sdk.js.synthetic.mapasobjectarray.EntityReferenceInGroupToRelatedPersonDelegateOptionsMapObject_delegate_delegateOptions
import com.icure.cardinal.sdk.js.synthetic.mapasobjectarray.EntityReferenceInGroupToRelatedPersonDelegateOptionsMapObject_delegate_delegateOptions_fromJs
import com.icure.cardinal.sdk.js.synthetic.mapasobjectarray.EntityReferenceInGroupToRelatedPersonShareOptionsMapObject_delegate_shareOptions
import com.icure.cardinal.sdk.js.synthetic.mapasobjectarray.EntityReferenceInGroupToRelatedPersonShareOptionsMapObject_delegate_shareOptions_fromJs
import com.icure.cardinal.sdk.js.utils.Record
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import com.icure.cardinal.sdk.js.utils.pagination.paginatedListIterator_toJs
import com.icure.cardinal.sdk.model.DecryptedRelatedPerson
import com.icure.cardinal.sdk.model.EncryptedRelatedPerson
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.model.GroupScoped
import com.icure.cardinal.sdk.model.RelatedPerson
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
import com.icure.cardinal.sdk.model.User
import com.icure.cardinal.sdk.model.embed.AccessLevel
import com.icure.cardinal.sdk.model.specializations.HexString
import com.icure.cardinal.sdk.subscription.EntitySubscriptionConfiguration
import com.icure.cardinal.sdk.subscription.SubscriptionEventType
import kotlin.Array
import kotlin.Boolean
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
internal class RelatedPersonApiImplJs(
	private val relatedPersonApi: RelatedPersonApi,
) : RelatedPersonApiJs {
	override val encrypted: RelatedPersonFlavouredApiJs<EncryptedRelatedPersonJs> = object :
			RelatedPersonFlavouredApiJs<EncryptedRelatedPersonJs> {
		override fun shareWith(
			delegateId: String,
			relatedPerson: EncryptedRelatedPersonJs,
			options: dynamic,
		): Promise<EncryptedRelatedPersonJs> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val delegateIdConverted: String = delegateId
				val relatedPersonConverted: EncryptedRelatedPerson = relatedPerson_fromJs(relatedPerson)
				val optionsConverted: RelatedPersonShareOptions? = convertingOptionOrDefaultNullable(
					_options,
					"options",
					null
				) { options: RelatedPersonShareOptionsJs? ->
					options?.let { nonNull1 ->
						relatedPersonShareOptions_fromJs(nonNull1)
					}
				}
				val result = relatedPersonApi.encrypted.shareWith(
					delegateIdConverted,
					relatedPersonConverted,
					optionsConverted,
				)
				relatedPerson_toJs(result)
			}
		}

		override fun shareWithMany(relatedPerson: EncryptedRelatedPersonJs,
				delegates: Record<String, RelatedPersonShareOptionsJs>): Promise<EncryptedRelatedPersonJs> =
				GlobalScope.promise {
			val relatedPersonConverted: EncryptedRelatedPerson = relatedPerson_fromJs(relatedPerson)
			val delegatesConverted: Map<String, RelatedPersonShareOptions> = objectToMap(
				delegates,
				"delegates",
				{ x1: String ->
					x1
				},
				{ x1: RelatedPersonShareOptionsJs ->
					relatedPersonShareOptions_fromJs(x1)
				},
			)
			val result = relatedPersonApi.encrypted.shareWithMany(
				relatedPersonConverted,
				delegatesConverted,
			)
			relatedPerson_toJs(result)
		}

		override fun filterRelatedPersonsBy(filter: FilterOptionsJs<RelatedPersonJs>):
				Promise<PaginatedListIteratorJs<EncryptedRelatedPersonJs>> = GlobalScope.promise {
			val filterConverted: FilterOptions<RelatedPerson> = filterOptions_fromJs(filter)
			val result = relatedPersonApi.encrypted.filterRelatedPersonsBy(
				filterConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: EncryptedRelatedPerson ->
					relatedPerson_toJs(x1)
				},
			)
		}

		override fun filterRelatedPersonsBySorted(filter: SortableFilterOptionsJs<RelatedPersonJs>):
				Promise<PaginatedListIteratorJs<EncryptedRelatedPersonJs>> = GlobalScope.promise {
			val filterConverted: SortableFilterOptions<RelatedPerson> = sortableFilterOptions_fromJs(filter)
			val result = relatedPersonApi.encrypted.filterRelatedPersonsBySorted(
				filterConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: EncryptedRelatedPerson ->
					relatedPerson_toJs(x1)
				},
			)
		}

		override fun createRelatedPerson(entity: EncryptedRelatedPersonJs):
				Promise<EncryptedRelatedPersonJs> = GlobalScope.promise {
			val entityConverted: EncryptedRelatedPerson = relatedPerson_fromJs(entity)
			val result = relatedPersonApi.encrypted.createRelatedPerson(
				entityConverted,
			)
			relatedPerson_toJs(result)
		}

		override fun createRelatedPersons(entities: Array<EncryptedRelatedPersonJs>):
				Promise<Array<EncryptedRelatedPersonJs>> = GlobalScope.promise {
			val entitiesConverted: List<EncryptedRelatedPerson> = arrayToList(
				entities,
				"entities",
				{ x1: EncryptedRelatedPersonJs ->
					relatedPerson_fromJs(x1)
				},
			)
			val result = relatedPersonApi.encrypted.createRelatedPersons(
				entitiesConverted,
			)
			listToArray(
				result,
				{ x1: EncryptedRelatedPerson ->
					relatedPerson_toJs(x1)
				},
			)
		}

		override fun undeleteRelatedPersonById(id: String, rev: String): Promise<EncryptedRelatedPersonJs>
				= GlobalScope.promise {
			val idConverted: String = id
			val revConverted: String = rev
			val result = relatedPersonApi.encrypted.undeleteRelatedPersonById(
				idConverted,
				revConverted,
			)
			relatedPerson_toJs(result)
		}

		override fun undeleteRelatedPersonsByIds(entityIds: Array<StoredDocumentIdentifierJs>):
				Promise<Array<EncryptedRelatedPersonJs>> = GlobalScope.promise {
			val entityIdsConverted: List<StoredDocumentIdentifier> = arrayToList(
				entityIds,
				"entityIds",
				{ x1: StoredDocumentIdentifierJs ->
					storedDocumentIdentifier_fromJs(x1)
				},
			)
			val result = relatedPersonApi.encrypted.undeleteRelatedPersonsByIds(
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: EncryptedRelatedPerson ->
					relatedPerson_toJs(x1)
				},
			)
		}

		override fun undeleteRelatedPerson(relatedPerson: RelatedPersonJs):
				Promise<EncryptedRelatedPersonJs> = GlobalScope.promise {
			val relatedPersonConverted: RelatedPerson = relatedPerson_fromJs(relatedPerson)
			val result = relatedPersonApi.encrypted.undeleteRelatedPerson(
				relatedPersonConverted,
			)
			relatedPerson_toJs(result)
		}

		override fun undeleteRelatedPersons(relatedPersons: Array<RelatedPersonJs>):
				Promise<Array<EncryptedRelatedPersonJs>> = GlobalScope.promise {
			val relatedPersonsConverted: List<RelatedPerson> = arrayToList(
				relatedPersons,
				"relatedPersons",
				{ x1: RelatedPersonJs ->
					relatedPerson_fromJs(x1)
				},
			)
			val result = relatedPersonApi.encrypted.undeleteRelatedPersons(
				relatedPersonsConverted,
			)
			listToArray(
				result,
				{ x1: EncryptedRelatedPerson ->
					relatedPerson_toJs(x1)
				},
			)
		}

		override fun modifyRelatedPerson(entity: EncryptedRelatedPersonJs):
				Promise<EncryptedRelatedPersonJs> = GlobalScope.promise {
			val entityConverted: EncryptedRelatedPerson = relatedPerson_fromJs(entity)
			val result = relatedPersonApi.encrypted.modifyRelatedPerson(
				entityConverted,
			)
			relatedPerson_toJs(result)
		}

		override fun modifyRelatedPersons(entities: Array<EncryptedRelatedPersonJs>):
				Promise<Array<EncryptedRelatedPersonJs>> = GlobalScope.promise {
			val entitiesConverted: List<EncryptedRelatedPerson> = arrayToList(
				entities,
				"entities",
				{ x1: EncryptedRelatedPersonJs ->
					relatedPerson_fromJs(x1)
				},
			)
			val result = relatedPersonApi.encrypted.modifyRelatedPersons(
				entitiesConverted,
			)
			listToArray(
				result,
				{ x1: EncryptedRelatedPerson ->
					relatedPerson_toJs(x1)
				},
			)
		}

		override fun getRelatedPerson(entityId: String): Promise<EncryptedRelatedPersonJs?> =
				GlobalScope.promise {
			val entityIdConverted: String = entityId
			val result = relatedPersonApi.encrypted.getRelatedPerson(
				entityIdConverted,
			)
			nullToUndefined(
				result?.let { nonNull1 ->
					relatedPerson_toJs(nonNull1)
				}
			)
		}

		override fun getRelatedPersons(entityIds: Array<String>): Promise<Array<EncryptedRelatedPersonJs>>
				= GlobalScope.promise {
			val entityIdsConverted: List<String> = arrayToList(
				entityIds,
				"entityIds",
				{ x1: String ->
					x1
				},
			)
			val result = relatedPersonApi.encrypted.getRelatedPersons(
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: EncryptedRelatedPerson ->
					relatedPerson_toJs(x1)
				},
			)
		}
	}

	override val tryAndRecover: RelatedPersonFlavouredApiJs<RelatedPersonJs> = object :
			RelatedPersonFlavouredApiJs<RelatedPersonJs> {
		override fun shareWith(
			delegateId: String,
			relatedPerson: RelatedPersonJs,
			options: dynamic,
		): Promise<RelatedPersonJs> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val delegateIdConverted: String = delegateId
				val relatedPersonConverted: RelatedPerson = relatedPerson_fromJs(relatedPerson)
				val optionsConverted: RelatedPersonShareOptions? = convertingOptionOrDefaultNullable(
					_options,
					"options",
					null
				) { options: RelatedPersonShareOptionsJs? ->
					options?.let { nonNull1 ->
						relatedPersonShareOptions_fromJs(nonNull1)
					}
				}
				val result = relatedPersonApi.tryAndRecover.shareWith(
					delegateIdConverted,
					relatedPersonConverted,
					optionsConverted,
				)
				relatedPerson_toJs(result)
			}
		}

		override fun shareWithMany(relatedPerson: RelatedPersonJs,
				delegates: Record<String, RelatedPersonShareOptionsJs>): Promise<RelatedPersonJs> =
				GlobalScope.promise {
			val relatedPersonConverted: RelatedPerson = relatedPerson_fromJs(relatedPerson)
			val delegatesConverted: Map<String, RelatedPersonShareOptions> = objectToMap(
				delegates,
				"delegates",
				{ x1: String ->
					x1
				},
				{ x1: RelatedPersonShareOptionsJs ->
					relatedPersonShareOptions_fromJs(x1)
				},
			)
			val result = relatedPersonApi.tryAndRecover.shareWithMany(
				relatedPersonConverted,
				delegatesConverted,
			)
			relatedPerson_toJs(result)
		}

		override fun filterRelatedPersonsBy(filter: FilterOptionsJs<RelatedPersonJs>):
				Promise<PaginatedListIteratorJs<RelatedPersonJs>> = GlobalScope.promise {
			val filterConverted: FilterOptions<RelatedPerson> = filterOptions_fromJs(filter)
			val result = relatedPersonApi.tryAndRecover.filterRelatedPersonsBy(
				filterConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: RelatedPerson ->
					relatedPerson_toJs(x1)
				},
			)
		}

		override fun filterRelatedPersonsBySorted(filter: SortableFilterOptionsJs<RelatedPersonJs>):
				Promise<PaginatedListIteratorJs<RelatedPersonJs>> = GlobalScope.promise {
			val filterConverted: SortableFilterOptions<RelatedPerson> = sortableFilterOptions_fromJs(filter)
			val result = relatedPersonApi.tryAndRecover.filterRelatedPersonsBySorted(
				filterConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: RelatedPerson ->
					relatedPerson_toJs(x1)
				},
			)
		}

		override fun createRelatedPerson(entity: RelatedPersonJs): Promise<RelatedPersonJs> =
				GlobalScope.promise {
			val entityConverted: RelatedPerson = relatedPerson_fromJs(entity)
			val result = relatedPersonApi.tryAndRecover.createRelatedPerson(
				entityConverted,
			)
			relatedPerson_toJs(result)
		}

		override fun createRelatedPersons(entities: Array<RelatedPersonJs>):
				Promise<Array<RelatedPersonJs>> = GlobalScope.promise {
			val entitiesConverted: List<RelatedPerson> = arrayToList(
				entities,
				"entities",
				{ x1: RelatedPersonJs ->
					relatedPerson_fromJs(x1)
				},
			)
			val result = relatedPersonApi.tryAndRecover.createRelatedPersons(
				entitiesConverted,
			)
			listToArray(
				result,
				{ x1: RelatedPerson ->
					relatedPerson_toJs(x1)
				},
			)
		}

		override fun undeleteRelatedPersonById(id: String, rev: String): Promise<RelatedPersonJs> =
				GlobalScope.promise {
			val idConverted: String = id
			val revConverted: String = rev
			val result = relatedPersonApi.tryAndRecover.undeleteRelatedPersonById(
				idConverted,
				revConverted,
			)
			relatedPerson_toJs(result)
		}

		override fun undeleteRelatedPersonsByIds(entityIds: Array<StoredDocumentIdentifierJs>):
				Promise<Array<RelatedPersonJs>> = GlobalScope.promise {
			val entityIdsConverted: List<StoredDocumentIdentifier> = arrayToList(
				entityIds,
				"entityIds",
				{ x1: StoredDocumentIdentifierJs ->
					storedDocumentIdentifier_fromJs(x1)
				},
			)
			val result = relatedPersonApi.tryAndRecover.undeleteRelatedPersonsByIds(
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: RelatedPerson ->
					relatedPerson_toJs(x1)
				},
			)
		}

		override fun undeleteRelatedPerson(relatedPerson: RelatedPersonJs): Promise<RelatedPersonJs> =
				GlobalScope.promise {
			val relatedPersonConverted: RelatedPerson = relatedPerson_fromJs(relatedPerson)
			val result = relatedPersonApi.tryAndRecover.undeleteRelatedPerson(
				relatedPersonConverted,
			)
			relatedPerson_toJs(result)
		}

		override fun undeleteRelatedPersons(relatedPersons: Array<RelatedPersonJs>):
				Promise<Array<RelatedPersonJs>> = GlobalScope.promise {
			val relatedPersonsConverted: List<RelatedPerson> = arrayToList(
				relatedPersons,
				"relatedPersons",
				{ x1: RelatedPersonJs ->
					relatedPerson_fromJs(x1)
				},
			)
			val result = relatedPersonApi.tryAndRecover.undeleteRelatedPersons(
				relatedPersonsConverted,
			)
			listToArray(
				result,
				{ x1: RelatedPerson ->
					relatedPerson_toJs(x1)
				},
			)
		}

		override fun modifyRelatedPerson(entity: RelatedPersonJs): Promise<RelatedPersonJs> =
				GlobalScope.promise {
			val entityConverted: RelatedPerson = relatedPerson_fromJs(entity)
			val result = relatedPersonApi.tryAndRecover.modifyRelatedPerson(
				entityConverted,
			)
			relatedPerson_toJs(result)
		}

		override fun modifyRelatedPersons(entities: Array<RelatedPersonJs>):
				Promise<Array<RelatedPersonJs>> = GlobalScope.promise {
			val entitiesConverted: List<RelatedPerson> = arrayToList(
				entities,
				"entities",
				{ x1: RelatedPersonJs ->
					relatedPerson_fromJs(x1)
				},
			)
			val result = relatedPersonApi.tryAndRecover.modifyRelatedPersons(
				entitiesConverted,
			)
			listToArray(
				result,
				{ x1: RelatedPerson ->
					relatedPerson_toJs(x1)
				},
			)
		}

		override fun getRelatedPerson(entityId: String): Promise<RelatedPersonJs?> = GlobalScope.promise {
			val entityIdConverted: String = entityId
			val result = relatedPersonApi.tryAndRecover.getRelatedPerson(
				entityIdConverted,
			)
			nullToUndefined(
				result?.let { nonNull1 ->
					relatedPerson_toJs(nonNull1)
				}
			)
		}

		override fun getRelatedPersons(entityIds: Array<String>): Promise<Array<RelatedPersonJs>> =
				GlobalScope.promise {
			val entityIdsConverted: List<String> = arrayToList(
				entityIds,
				"entityIds",
				{ x1: String ->
					x1
				},
			)
			val result = relatedPersonApi.tryAndRecover.getRelatedPersons(
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: RelatedPerson ->
					relatedPerson_toJs(x1)
				},
			)
		}
	}

	override val inGroup: RelatedPersonInGroupApiJs = object : RelatedPersonInGroupApiJs {
		override val encrypted: RelatedPersonFlavouredInGroupApiJs<EncryptedRelatedPersonJs> = object :
				RelatedPersonFlavouredInGroupApiJs<EncryptedRelatedPersonJs> {
			override fun shareWith(
				`delegate`: EntityReferenceInGroupJs,
				relatedPerson: GroupScopedJs<EncryptedRelatedPersonJs>,
				options: dynamic,
			): Promise<GroupScopedJs<EncryptedRelatedPersonJs>> {
				val _options = options ?: js("{}")
				return GlobalScope.promise {
					val delegateConverted: EntityReferenceInGroup = entityReferenceInGroup_fromJs(delegate)
					val relatedPersonConverted: GroupScoped<EncryptedRelatedPerson> = groupScoped_fromJs(
						relatedPerson,
						{ x1: EncryptedRelatedPersonJs ->
							relatedPerson_fromJs(x1)
						},
					)
					val optionsConverted: RelatedPersonShareOptions? = convertingOptionOrDefaultNullable(
						_options,
						"options",
						null
					) { options: RelatedPersonShareOptionsJs? ->
						options?.let { nonNull1 ->
							relatedPersonShareOptions_fromJs(nonNull1)
						}
					}
					val result = relatedPersonApi.inGroup.encrypted.shareWith(
						delegateConverted,
						relatedPersonConverted,
						optionsConverted,
					)
					groupScoped_toJs(
						result,
						{ x1: EncryptedRelatedPerson ->
							relatedPerson_toJs(x1)
						},
					)
				}
			}

			override fun shareWithMany(relatedPerson: GroupScopedJs<EncryptedRelatedPersonJs>,
					delegates: Array<EntityReferenceInGroupToRelatedPersonShareOptionsMapObject_delegate_shareOptions>):
					Promise<GroupScopedJs<EncryptedRelatedPersonJs>> = GlobalScope.promise {
				val relatedPersonConverted: GroupScoped<EncryptedRelatedPerson> = groupScoped_fromJs(
					relatedPerson,
					{ x1: EncryptedRelatedPersonJs ->
						relatedPerson_fromJs(x1)
					},
				)
				val delegatesConverted: Map<EntityReferenceInGroup, RelatedPersonShareOptions> =
						EntityReferenceInGroupToRelatedPersonShareOptionsMapObject_delegate_shareOptions_fromJs(delegates)
				val result = relatedPersonApi.inGroup.encrypted.shareWithMany(
					relatedPersonConverted,
					delegatesConverted,
				)
				groupScoped_toJs(
					result,
					{ x1: EncryptedRelatedPerson ->
						relatedPerson_toJs(x1)
					},
				)
			}

			override fun filterRelatedPersonsBy(groupId: String, filter: FilterOptionsJs<RelatedPersonJs>):
					Promise<PaginatedListIteratorJs<GroupScopedJs<EncryptedRelatedPersonJs>>> =
					GlobalScope.promise {
				val groupIdConverted: String = groupId
				val filterConverted: FilterOptions<RelatedPerson> = filterOptions_fromJs(filter)
				val result = relatedPersonApi.inGroup.encrypted.filterRelatedPersonsBy(
					groupIdConverted,
					filterConverted,
				)
				paginatedListIterator_toJs(
					result,
					{ x1: GroupScoped<EncryptedRelatedPerson> ->
						groupScoped_toJs(
							x1,
							{ x2: EncryptedRelatedPerson ->
								relatedPerson_toJs(x2)
							},
						)
					},
				)
			}

			override fun filterRelatedPersonsBySorted(groupId: String,
					filter: SortableFilterOptionsJs<RelatedPersonJs>):
					Promise<PaginatedListIteratorJs<GroupScopedJs<EncryptedRelatedPersonJs>>> =
					GlobalScope.promise {
				val groupIdConverted: String = groupId
				val filterConverted: SortableFilterOptions<RelatedPerson> = sortableFilterOptions_fromJs(filter)
				val result = relatedPersonApi.inGroup.encrypted.filterRelatedPersonsBySorted(
					groupIdConverted,
					filterConverted,
				)
				paginatedListIterator_toJs(
					result,
					{ x1: GroupScoped<EncryptedRelatedPerson> ->
						groupScoped_toJs(
							x1,
							{ x2: EncryptedRelatedPerson ->
								relatedPerson_toJs(x2)
							},
						)
					},
				)
			}

			override fun createRelatedPerson(entity: GroupScopedJs<EncryptedRelatedPersonJs>):
					Promise<GroupScopedJs<EncryptedRelatedPersonJs>> = GlobalScope.promise {
				val entityConverted: GroupScoped<EncryptedRelatedPerson> = groupScoped_fromJs(
					entity,
					{ x1: EncryptedRelatedPersonJs ->
						relatedPerson_fromJs(x1)
					},
				)
				val result = relatedPersonApi.inGroup.encrypted.createRelatedPerson(
					entityConverted,
				)
				groupScoped_toJs(
					result,
					{ x1: EncryptedRelatedPerson ->
						relatedPerson_toJs(x1)
					},
				)
			}

			override fun createRelatedPersons(entities: Array<GroupScopedJs<EncryptedRelatedPersonJs>>):
					Promise<Array<GroupScopedJs<EncryptedRelatedPersonJs>>> = GlobalScope.promise {
				val entitiesConverted: List<GroupScoped<EncryptedRelatedPerson>> = arrayToList(
					entities,
					"entities",
					{ x1: GroupScopedJs<EncryptedRelatedPersonJs> ->
						groupScoped_fromJs(
							x1,
							{ x2: EncryptedRelatedPersonJs ->
								relatedPerson_fromJs(x2)
							},
						)
					},
				)
				val result = relatedPersonApi.inGroup.encrypted.createRelatedPersons(
					entitiesConverted,
				)
				listToArray(
					result,
					{ x1: GroupScoped<EncryptedRelatedPerson> ->
						groupScoped_toJs(
							x1,
							{ x2: EncryptedRelatedPerson ->
								relatedPerson_toJs(x2)
							},
						)
					},
				)
			}

			override fun undeleteRelatedPersonById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
					Promise<GroupScopedJs<EncryptedRelatedPersonJs>> = GlobalScope.promise {
				val entityIdConverted: GroupScoped<StoredDocumentIdentifier> = groupScoped_fromJs(
					entityId,
					{ x1: StoredDocumentIdentifierJs ->
						storedDocumentIdentifier_fromJs(x1)
					},
				)
				val result = relatedPersonApi.inGroup.encrypted.undeleteRelatedPersonById(
					entityIdConverted,
				)
				groupScoped_toJs(
					result,
					{ x1: EncryptedRelatedPerson ->
						relatedPerson_toJs(x1)
					},
				)
			}

			override
					fun undeleteRelatedPersonsByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
					Promise<Array<GroupScopedJs<EncryptedRelatedPersonJs>>> = GlobalScope.promise {
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
				val result = relatedPersonApi.inGroup.encrypted.undeleteRelatedPersonsByIds(
					entityIdsConverted,
				)
				listToArray(
					result,
					{ x1: GroupScoped<EncryptedRelatedPerson> ->
						groupScoped_toJs(
							x1,
							{ x2: EncryptedRelatedPerson ->
								relatedPerson_toJs(x2)
							},
						)
					},
				)
			}

			override fun undeleteRelatedPerson(relatedPerson: GroupScopedJs<RelatedPersonJs>):
					Promise<GroupScopedJs<EncryptedRelatedPersonJs>> = GlobalScope.promise {
				val relatedPersonConverted: GroupScoped<RelatedPerson> = groupScoped_fromJs(
					relatedPerson,
					{ x1: RelatedPersonJs ->
						relatedPerson_fromJs(x1)
					},
				)
				val result = relatedPersonApi.inGroup.encrypted.undeleteRelatedPerson(
					relatedPersonConverted,
				)
				groupScoped_toJs(
					result,
					{ x1: EncryptedRelatedPerson ->
						relatedPerson_toJs(x1)
					},
				)
			}

			override
					fun undeleteRelatedPersons(relatedPersons: Array<GroupScopedJs<EncryptedRelatedPersonJs>>):
					Promise<Array<GroupScopedJs<EncryptedRelatedPersonJs>>> = GlobalScope.promise {
				val relatedPersonsConverted: List<GroupScoped<EncryptedRelatedPerson>> = arrayToList(
					relatedPersons,
					"relatedPersons",
					{ x1: GroupScopedJs<EncryptedRelatedPersonJs> ->
						groupScoped_fromJs(
							x1,
							{ x2: EncryptedRelatedPersonJs ->
								relatedPerson_fromJs(x2)
							},
						)
					},
				)
				val result = relatedPersonApi.inGroup.encrypted.undeleteRelatedPersons(
					relatedPersonsConverted,
				)
				listToArray(
					result,
					{ x1: GroupScoped<EncryptedRelatedPerson> ->
						groupScoped_toJs(
							x1,
							{ x2: EncryptedRelatedPerson ->
								relatedPerson_toJs(x2)
							},
						)
					},
				)
			}

			override fun modifyRelatedPerson(entity: GroupScopedJs<EncryptedRelatedPersonJs>):
					Promise<GroupScopedJs<EncryptedRelatedPersonJs>> = GlobalScope.promise {
				val entityConverted: GroupScoped<EncryptedRelatedPerson> = groupScoped_fromJs(
					entity,
					{ x1: EncryptedRelatedPersonJs ->
						relatedPerson_fromJs(x1)
					},
				)
				val result = relatedPersonApi.inGroup.encrypted.modifyRelatedPerson(
					entityConverted,
				)
				groupScoped_toJs(
					result,
					{ x1: EncryptedRelatedPerson ->
						relatedPerson_toJs(x1)
					},
				)
			}

			override fun modifyRelatedPersons(entities: Array<GroupScopedJs<EncryptedRelatedPersonJs>>):
					Promise<Array<GroupScopedJs<EncryptedRelatedPersonJs>>> = GlobalScope.promise {
				val entitiesConverted: List<GroupScoped<EncryptedRelatedPerson>> = arrayToList(
					entities,
					"entities",
					{ x1: GroupScopedJs<EncryptedRelatedPersonJs> ->
						groupScoped_fromJs(
							x1,
							{ x2: EncryptedRelatedPersonJs ->
								relatedPerson_fromJs(x2)
							},
						)
					},
				)
				val result = relatedPersonApi.inGroup.encrypted.modifyRelatedPersons(
					entitiesConverted,
				)
				listToArray(
					result,
					{ x1: GroupScoped<EncryptedRelatedPerson> ->
						groupScoped_toJs(
							x1,
							{ x2: EncryptedRelatedPerson ->
								relatedPerson_toJs(x2)
							},
						)
					},
				)
			}

			override fun getRelatedPerson(groupId: String, entityId: String):
					Promise<GroupScopedJs<EncryptedRelatedPersonJs>?> = GlobalScope.promise {
				val groupIdConverted: String = groupId
				val entityIdConverted: String = entityId
				val result = relatedPersonApi.inGroup.encrypted.getRelatedPerson(
					groupIdConverted,
					entityIdConverted,
				)
				nullToUndefined(
					result?.let { nonNull1 ->
						groupScoped_toJs(
							nonNull1,
							{ x1: EncryptedRelatedPerson ->
								relatedPerson_toJs(x1)
							},
						)
					}
				)
			}

			override fun getRelatedPersons(groupId: String, entityIds: Array<String>):
					Promise<Array<GroupScopedJs<EncryptedRelatedPersonJs>>> = GlobalScope.promise {
				val groupIdConverted: String = groupId
				val entityIdsConverted: List<String> = arrayToList(
					entityIds,
					"entityIds",
					{ x1: String ->
						x1
					},
				)
				val result = relatedPersonApi.inGroup.encrypted.getRelatedPersons(
					groupIdConverted,
					entityIdsConverted,
				)
				listToArray(
					result,
					{ x1: GroupScoped<EncryptedRelatedPerson> ->
						groupScoped_toJs(
							x1,
							{ x2: EncryptedRelatedPerson ->
								relatedPerson_toJs(x2)
							},
						)
					},
				)
			}
		}

		override val tryAndRecover: RelatedPersonFlavouredInGroupApiJs<RelatedPersonJs> = object :
				RelatedPersonFlavouredInGroupApiJs<RelatedPersonJs> {
			override fun shareWith(
				`delegate`: EntityReferenceInGroupJs,
				relatedPerson: GroupScopedJs<RelatedPersonJs>,
				options: dynamic,
			): Promise<GroupScopedJs<RelatedPersonJs>> {
				val _options = options ?: js("{}")
				return GlobalScope.promise {
					val delegateConverted: EntityReferenceInGroup = entityReferenceInGroup_fromJs(delegate)
					val relatedPersonConverted: GroupScoped<RelatedPerson> = groupScoped_fromJs(
						relatedPerson,
						{ x1: RelatedPersonJs ->
							relatedPerson_fromJs(x1)
						},
					)
					val optionsConverted: RelatedPersonShareOptions? = convertingOptionOrDefaultNullable(
						_options,
						"options",
						null
					) { options: RelatedPersonShareOptionsJs? ->
						options?.let { nonNull1 ->
							relatedPersonShareOptions_fromJs(nonNull1)
						}
					}
					val result = relatedPersonApi.inGroup.tryAndRecover.shareWith(
						delegateConverted,
						relatedPersonConverted,
						optionsConverted,
					)
					groupScoped_toJs(
						result,
						{ x1: RelatedPerson ->
							relatedPerson_toJs(x1)
						},
					)
				}
			}

			override fun shareWithMany(relatedPerson: GroupScopedJs<RelatedPersonJs>,
					delegates: Array<EntityReferenceInGroupToRelatedPersonShareOptionsMapObject_delegate_shareOptions>):
					Promise<GroupScopedJs<RelatedPersonJs>> = GlobalScope.promise {
				val relatedPersonConverted: GroupScoped<RelatedPerson> = groupScoped_fromJs(
					relatedPerson,
					{ x1: RelatedPersonJs ->
						relatedPerson_fromJs(x1)
					},
				)
				val delegatesConverted: Map<EntityReferenceInGroup, RelatedPersonShareOptions> =
						EntityReferenceInGroupToRelatedPersonShareOptionsMapObject_delegate_shareOptions_fromJs(delegates)
				val result = relatedPersonApi.inGroup.tryAndRecover.shareWithMany(
					relatedPersonConverted,
					delegatesConverted,
				)
				groupScoped_toJs(
					result,
					{ x1: RelatedPerson ->
						relatedPerson_toJs(x1)
					},
				)
			}

			override fun filterRelatedPersonsBy(groupId: String, filter: FilterOptionsJs<RelatedPersonJs>):
					Promise<PaginatedListIteratorJs<GroupScopedJs<RelatedPersonJs>>> = GlobalScope.promise {
				val groupIdConverted: String = groupId
				val filterConverted: FilterOptions<RelatedPerson> = filterOptions_fromJs(filter)
				val result = relatedPersonApi.inGroup.tryAndRecover.filterRelatedPersonsBy(
					groupIdConverted,
					filterConverted,
				)
				paginatedListIterator_toJs(
					result,
					{ x1: GroupScoped<RelatedPerson> ->
						groupScoped_toJs(
							x1,
							{ x2: RelatedPerson ->
								relatedPerson_toJs(x2)
							},
						)
					},
				)
			}

			override fun filterRelatedPersonsBySorted(groupId: String,
					filter: SortableFilterOptionsJs<RelatedPersonJs>):
					Promise<PaginatedListIteratorJs<GroupScopedJs<RelatedPersonJs>>> = GlobalScope.promise {
				val groupIdConverted: String = groupId
				val filterConverted: SortableFilterOptions<RelatedPerson> = sortableFilterOptions_fromJs(filter)
				val result = relatedPersonApi.inGroup.tryAndRecover.filterRelatedPersonsBySorted(
					groupIdConverted,
					filterConverted,
				)
				paginatedListIterator_toJs(
					result,
					{ x1: GroupScoped<RelatedPerson> ->
						groupScoped_toJs(
							x1,
							{ x2: RelatedPerson ->
								relatedPerson_toJs(x2)
							},
						)
					},
				)
			}

			override fun createRelatedPerson(entity: GroupScopedJs<RelatedPersonJs>):
					Promise<GroupScopedJs<RelatedPersonJs>> = GlobalScope.promise {
				val entityConverted: GroupScoped<RelatedPerson> = groupScoped_fromJs(
					entity,
					{ x1: RelatedPersonJs ->
						relatedPerson_fromJs(x1)
					},
				)
				val result = relatedPersonApi.inGroup.tryAndRecover.createRelatedPerson(
					entityConverted,
				)
				groupScoped_toJs(
					result,
					{ x1: RelatedPerson ->
						relatedPerson_toJs(x1)
					},
				)
			}

			override fun createRelatedPersons(entities: Array<GroupScopedJs<RelatedPersonJs>>):
					Promise<Array<GroupScopedJs<RelatedPersonJs>>> = GlobalScope.promise {
				val entitiesConverted: List<GroupScoped<RelatedPerson>> = arrayToList(
					entities,
					"entities",
					{ x1: GroupScopedJs<RelatedPersonJs> ->
						groupScoped_fromJs(
							x1,
							{ x2: RelatedPersonJs ->
								relatedPerson_fromJs(x2)
							},
						)
					},
				)
				val result = relatedPersonApi.inGroup.tryAndRecover.createRelatedPersons(
					entitiesConverted,
				)
				listToArray(
					result,
					{ x1: GroupScoped<RelatedPerson> ->
						groupScoped_toJs(
							x1,
							{ x2: RelatedPerson ->
								relatedPerson_toJs(x2)
							},
						)
					},
				)
			}

			override fun undeleteRelatedPersonById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
					Promise<GroupScopedJs<RelatedPersonJs>> = GlobalScope.promise {
				val entityIdConverted: GroupScoped<StoredDocumentIdentifier> = groupScoped_fromJs(
					entityId,
					{ x1: StoredDocumentIdentifierJs ->
						storedDocumentIdentifier_fromJs(x1)
					},
				)
				val result = relatedPersonApi.inGroup.tryAndRecover.undeleteRelatedPersonById(
					entityIdConverted,
				)
				groupScoped_toJs(
					result,
					{ x1: RelatedPerson ->
						relatedPerson_toJs(x1)
					},
				)
			}

			override
					fun undeleteRelatedPersonsByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
					Promise<Array<GroupScopedJs<RelatedPersonJs>>> = GlobalScope.promise {
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
				val result = relatedPersonApi.inGroup.tryAndRecover.undeleteRelatedPersonsByIds(
					entityIdsConverted,
				)
				listToArray(
					result,
					{ x1: GroupScoped<RelatedPerson> ->
						groupScoped_toJs(
							x1,
							{ x2: RelatedPerson ->
								relatedPerson_toJs(x2)
							},
						)
					},
				)
			}

			override fun undeleteRelatedPerson(relatedPerson: GroupScopedJs<RelatedPersonJs>):
					Promise<GroupScopedJs<RelatedPersonJs>> = GlobalScope.promise {
				val relatedPersonConverted: GroupScoped<RelatedPerson> = groupScoped_fromJs(
					relatedPerson,
					{ x1: RelatedPersonJs ->
						relatedPerson_fromJs(x1)
					},
				)
				val result = relatedPersonApi.inGroup.tryAndRecover.undeleteRelatedPerson(
					relatedPersonConverted,
				)
				groupScoped_toJs(
					result,
					{ x1: RelatedPerson ->
						relatedPerson_toJs(x1)
					},
				)
			}

			override fun undeleteRelatedPersons(relatedPersons: Array<GroupScopedJs<RelatedPersonJs>>):
					Promise<Array<GroupScopedJs<RelatedPersonJs>>> = GlobalScope.promise {
				val relatedPersonsConverted: List<GroupScoped<RelatedPerson>> = arrayToList(
					relatedPersons,
					"relatedPersons",
					{ x1: GroupScopedJs<RelatedPersonJs> ->
						groupScoped_fromJs(
							x1,
							{ x2: RelatedPersonJs ->
								relatedPerson_fromJs(x2)
							},
						)
					},
				)
				val result = relatedPersonApi.inGroup.tryAndRecover.undeleteRelatedPersons(
					relatedPersonsConverted,
				)
				listToArray(
					result,
					{ x1: GroupScoped<RelatedPerson> ->
						groupScoped_toJs(
							x1,
							{ x2: RelatedPerson ->
								relatedPerson_toJs(x2)
							},
						)
					},
				)
			}

			override fun modifyRelatedPerson(entity: GroupScopedJs<RelatedPersonJs>):
					Promise<GroupScopedJs<RelatedPersonJs>> = GlobalScope.promise {
				val entityConverted: GroupScoped<RelatedPerson> = groupScoped_fromJs(
					entity,
					{ x1: RelatedPersonJs ->
						relatedPerson_fromJs(x1)
					},
				)
				val result = relatedPersonApi.inGroup.tryAndRecover.modifyRelatedPerson(
					entityConverted,
				)
				groupScoped_toJs(
					result,
					{ x1: RelatedPerson ->
						relatedPerson_toJs(x1)
					},
				)
			}

			override fun modifyRelatedPersons(entities: Array<GroupScopedJs<RelatedPersonJs>>):
					Promise<Array<GroupScopedJs<RelatedPersonJs>>> = GlobalScope.promise {
				val entitiesConverted: List<GroupScoped<RelatedPerson>> = arrayToList(
					entities,
					"entities",
					{ x1: GroupScopedJs<RelatedPersonJs> ->
						groupScoped_fromJs(
							x1,
							{ x2: RelatedPersonJs ->
								relatedPerson_fromJs(x2)
							},
						)
					},
				)
				val result = relatedPersonApi.inGroup.tryAndRecover.modifyRelatedPersons(
					entitiesConverted,
				)
				listToArray(
					result,
					{ x1: GroupScoped<RelatedPerson> ->
						groupScoped_toJs(
							x1,
							{ x2: RelatedPerson ->
								relatedPerson_toJs(x2)
							},
						)
					},
				)
			}

			override fun getRelatedPerson(groupId: String, entityId: String):
					Promise<GroupScopedJs<RelatedPersonJs>?> = GlobalScope.promise {
				val groupIdConverted: String = groupId
				val entityIdConverted: String = entityId
				val result = relatedPersonApi.inGroup.tryAndRecover.getRelatedPerson(
					groupIdConverted,
					entityIdConverted,
				)
				nullToUndefined(
					result?.let { nonNull1 ->
						groupScoped_toJs(
							nonNull1,
							{ x1: RelatedPerson ->
								relatedPerson_toJs(x1)
							},
						)
					}
				)
			}

			override fun getRelatedPersons(groupId: String, entityIds: Array<String>):
					Promise<Array<GroupScopedJs<RelatedPersonJs>>> = GlobalScope.promise {
				val groupIdConverted: String = groupId
				val entityIdsConverted: List<String> = arrayToList(
					entityIds,
					"entityIds",
					{ x1: String ->
						x1
					},
				)
				val result = relatedPersonApi.inGroup.tryAndRecover.getRelatedPersons(
					groupIdConverted,
					entityIdsConverted,
				)
				listToArray(
					result,
					{ x1: GroupScoped<RelatedPerson> ->
						groupScoped_toJs(
							x1,
							{ x2: RelatedPerson ->
								relatedPerson_toJs(x2)
							},
						)
					},
				)
			}
		}

		override fun withEncryptionMetadata(
			entityGroupId: String,
			base: DecryptedRelatedPersonJs?,
			options: dynamic,
		): Promise<GroupScopedJs<DecryptedRelatedPersonJs>> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val entityGroupIdConverted: String = entityGroupId
				val baseConverted: DecryptedRelatedPerson? = base?.let { nonNull1 ->
					relatedPerson_fromJs(nonNull1)
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
				val result = relatedPersonApi.inGroup.withEncryptionMetadata(
					entityGroupIdConverted,
					baseConverted,
					userConverted,
					delegatesConverted,
					alternateRootDelegateReferenceConverted,
				)
				groupScoped_toJs(
					result,
					{ x1: DecryptedRelatedPerson ->
						relatedPerson_toJs(x1)
					},
				)
			}
		}

		override fun withEncryptionMetadataAndDelegates(
			entityGroupId: String,
			base: DecryptedRelatedPersonJs?,
			delegates: Array<EntityReferenceInGroupToRelatedPersonDelegateOptionsMapObject_delegate_delegateOptions>,
			options: dynamic,
		): Promise<GroupScopedJs<DecryptedRelatedPersonJs>> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val entityGroupIdConverted: String = entityGroupId
				val baseConverted: DecryptedRelatedPerson? = base?.let { nonNull1 ->
					relatedPerson_fromJs(nonNull1)
				}
				val delegatesConverted: Map<EntityReferenceInGroup, RelatedPersonDelegateOptions> =
						EntityReferenceInGroupToRelatedPersonDelegateOptionsMapObject_delegate_delegateOptions_fromJs(delegates)
				val userConverted: User? = convertingOptionOrDefaultNullable(
					_options,
					"user",
					null
				) { user: UserJs? ->
					user?.let { nonNull1 ->
						user_fromJs(nonNull1)
					}
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
				val result = relatedPersonApi.inGroup.withEncryptionMetadataAndDelegates(
					entityGroupIdConverted,
					baseConverted,
					delegatesConverted,
					userConverted,
					alternateRootDelegateReferenceConverted,
				)
				groupScoped_toJs(
					result,
					{ x1: DecryptedRelatedPerson ->
						relatedPerson_toJs(x1)
					},
				)
			}
		}

		override fun getEncryptionKeysOf(relatedPerson: GroupScopedJs<RelatedPersonJs>):
				Promise<Array<String>> = GlobalScope.promise {
			val relatedPersonConverted: GroupScoped<RelatedPerson> = groupScoped_fromJs(
				relatedPerson,
				{ x1: RelatedPersonJs ->
					relatedPerson_fromJs(x1)
				},
			)
			val result = relatedPersonApi.inGroup.getEncryptionKeysOf(
				relatedPersonConverted,
			)
			setToArray(
				result,
				{ x1: HexString ->
					hexString_toJs(x1)
				},
			)
		}

		override fun hasWriteAccess(relatedPerson: GroupScopedJs<RelatedPersonJs>): Promise<Boolean> =
				GlobalScope.promise {
			val relatedPersonConverted: GroupScoped<RelatedPerson> = groupScoped_fromJs(
				relatedPerson,
				{ x1: RelatedPersonJs ->
					relatedPerson_fromJs(x1)
				},
			)
			val result = relatedPersonApi.inGroup.hasWriteAccess(
				relatedPersonConverted,
			)
			result
		}

		override fun getSecretIdsOf(relatedPerson: GroupScopedJs<RelatedPersonJs>): Promise<Array<String>>
				= GlobalScope.promise {
			val relatedPersonConverted: GroupScoped<RelatedPerson> = groupScoped_fromJs(
				relatedPerson,
				{ x1: RelatedPersonJs ->
					relatedPerson_fromJs(x1)
				},
			)
			val result = relatedPersonApi.inGroup.getSecretIdsOf(
				relatedPersonConverted,
			)
			setToArray(
				result,
				{ x1: String ->
					x1
				},
			)
		}

		override fun createDelegationDeAnonymizationMetadata(entity: GroupScopedJs<RelatedPersonJs>,
				delegates: Array<EntityReferenceInGroupJs>): Promise<Unit> = GlobalScope.promise {
			val entityConverted: GroupScoped<RelatedPerson> = groupScoped_fromJs(
				entity,
				{ x1: RelatedPersonJs ->
					relatedPerson_fromJs(x1)
				},
			)
			val delegatesConverted: Set<EntityReferenceInGroup> = arrayToSet(
				delegates,
				"delegates",
				{ x1: EntityReferenceInGroupJs ->
					entityReferenceInGroup_fromJs(x1)
				},
			)
			relatedPersonApi.inGroup.createDelegationDeAnonymizationMetadata(
				entityConverted,
				delegatesConverted,
			)

		}

		override fun decrypt(relatedPersons: Array<GroupScopedJs<EncryptedRelatedPersonJs>>):
				Promise<Array<GroupScopedJs<DecryptedRelatedPersonJs>>> = GlobalScope.promise {
			val relatedPersonsConverted: List<GroupScoped<EncryptedRelatedPerson>> = arrayToList(
				relatedPersons,
				"relatedPersons",
				{ x1: GroupScopedJs<EncryptedRelatedPersonJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: EncryptedRelatedPersonJs ->
							relatedPerson_fromJs(x2)
						},
					)
				},
			)
			val result = relatedPersonApi.inGroup.decrypt(
				relatedPersonsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<DecryptedRelatedPerson> ->
					groupScoped_toJs(
						x1,
						{ x2: DecryptedRelatedPerson ->
							relatedPerson_toJs(x2)
						},
					)
				},
			)
		}

		override fun tryDecrypt(relatedPersons: Array<GroupScopedJs<EncryptedRelatedPersonJs>>):
				Promise<Array<GroupScopedJs<RelatedPersonJs>>> = GlobalScope.promise {
			val relatedPersonsConverted: List<GroupScoped<EncryptedRelatedPerson>> = arrayToList(
				relatedPersons,
				"relatedPersons",
				{ x1: GroupScopedJs<EncryptedRelatedPersonJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: EncryptedRelatedPersonJs ->
							relatedPerson_fromJs(x2)
						},
					)
				},
			)
			val result = relatedPersonApi.inGroup.tryDecrypt(
				relatedPersonsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<RelatedPerson> ->
					groupScoped_toJs(
						x1,
						{ x2: RelatedPerson ->
							relatedPerson_toJs(x2)
						},
					)
				},
			)
		}

		override fun encryptOrValidate(relatedPersons: Array<GroupScopedJs<RelatedPersonJs>>):
				Promise<Array<GroupScopedJs<EncryptedRelatedPersonJs>>> = GlobalScope.promise {
			val relatedPersonsConverted: List<GroupScoped<RelatedPerson>> = arrayToList(
				relatedPersons,
				"relatedPersons",
				{ x1: GroupScopedJs<RelatedPersonJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: RelatedPersonJs ->
							relatedPerson_fromJs(x2)
						},
					)
				},
			)
			val result = relatedPersonApi.inGroup.encryptOrValidate(
				relatedPersonsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<EncryptedRelatedPerson> ->
					groupScoped_toJs(
						x1,
						{ x2: EncryptedRelatedPerson ->
							relatedPerson_toJs(x2)
						},
					)
				},
			)
		}

		override fun matchRelatedPersonsBy(groupId: String, filter: FilterOptionsJs<RelatedPersonJs>):
				Promise<Array<String>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val filterConverted: FilterOptions<RelatedPerson> = filterOptions_fromJs(filter)
			val result = relatedPersonApi.inGroup.matchRelatedPersonsBy(
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

		override fun matchRelatedPersonsBySorted(groupId: String,
				filter: SortableFilterOptionsJs<RelatedPersonJs>): Promise<Array<String>> =
				GlobalScope.promise {
			val groupIdConverted: String = groupId
			val filterConverted: SortableFilterOptions<RelatedPerson> = sortableFilterOptions_fromJs(filter)
			val result = relatedPersonApi.inGroup.matchRelatedPersonsBySorted(
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

		override fun deleteRelatedPersonById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
				Promise<GroupScopedJs<StoredDocumentIdentifierJs>> = GlobalScope.promise {
			val entityIdConverted: GroupScoped<StoredDocumentIdentifier> = groupScoped_fromJs(
				entityId,
				{ x1: StoredDocumentIdentifierJs ->
					storedDocumentIdentifier_fromJs(x1)
				},
			)
			val result = relatedPersonApi.inGroup.deleteRelatedPersonById(
				entityIdConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: StoredDocumentIdentifier ->
					storedDocumentIdentifier_toJs(x1)
				},
			)
		}

		override
				fun deleteRelatedPersonsByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
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
			val result = relatedPersonApi.inGroup.deleteRelatedPersonsByIds(
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

		override fun purgeRelatedPersonById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
				Promise<Unit> = GlobalScope.promise {
			val entityIdConverted: GroupScoped<StoredDocumentIdentifier> = groupScoped_fromJs(
				entityId,
				{ x1: StoredDocumentIdentifierJs ->
					storedDocumentIdentifier_fromJs(x1)
				},
			)
			relatedPersonApi.inGroup.purgeRelatedPersonById(
				entityIdConverted,
			)

		}

		override
				fun purgeRelatedPersonsByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
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
			val result = relatedPersonApi.inGroup.purgeRelatedPersonsByIds(
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

		override fun deleteRelatedPerson(relatedPerson: GroupScopedJs<RelatedPersonJs>):
				Promise<GroupScopedJs<StoredDocumentIdentifierJs>> = GlobalScope.promise {
			val relatedPersonConverted: GroupScoped<RelatedPerson> = groupScoped_fromJs(
				relatedPerson,
				{ x1: RelatedPersonJs ->
					relatedPerson_fromJs(x1)
				},
			)
			val result = relatedPersonApi.inGroup.deleteRelatedPerson(
				relatedPersonConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: StoredDocumentIdentifier ->
					storedDocumentIdentifier_toJs(x1)
				},
			)
		}

		override fun deleteRelatedPersons(relatedPersons: Array<GroupScopedJs<RelatedPersonJs>>):
				Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>> = GlobalScope.promise {
			val relatedPersonsConverted: List<GroupScoped<RelatedPerson>> = arrayToList(
				relatedPersons,
				"relatedPersons",
				{ x1: GroupScopedJs<RelatedPersonJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: RelatedPersonJs ->
							relatedPerson_fromJs(x2)
						},
					)
				},
			)
			val result = relatedPersonApi.inGroup.deleteRelatedPersons(
				relatedPersonsConverted,
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

		override fun purgeRelatedPerson(relatedPerson: GroupScopedJs<RelatedPersonJs>): Promise<Unit> =
				GlobalScope.promise {
			val relatedPersonConverted: GroupScoped<RelatedPerson> = groupScoped_fromJs(
				relatedPerson,
				{ x1: RelatedPersonJs ->
					relatedPerson_fromJs(x1)
				},
			)
			relatedPersonApi.inGroup.purgeRelatedPerson(
				relatedPersonConverted,
			)

		}

		override fun purgeRelatedPersons(relatedPersons: Array<GroupScopedJs<RelatedPersonJs>>):
				Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>> = GlobalScope.promise {
			val relatedPersonsConverted: List<GroupScoped<RelatedPerson>> = arrayToList(
				relatedPersons,
				"relatedPersons",
				{ x1: GroupScopedJs<RelatedPersonJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: RelatedPersonJs ->
							relatedPerson_fromJs(x2)
						},
					)
				},
			)
			val result = relatedPersonApi.inGroup.purgeRelatedPersons(
				relatedPersonsConverted,
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
			relatedPerson: GroupScopedJs<DecryptedRelatedPersonJs>,
			options: dynamic,
		): Promise<GroupScopedJs<DecryptedRelatedPersonJs>> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val delegateConverted: EntityReferenceInGroup = entityReferenceInGroup_fromJs(delegate)
				val relatedPersonConverted: GroupScoped<DecryptedRelatedPerson> = groupScoped_fromJs(
					relatedPerson,
					{ x1: DecryptedRelatedPersonJs ->
						relatedPerson_fromJs(x1)
					},
				)
				val optionsConverted: RelatedPersonShareOptions? = convertingOptionOrDefaultNullable(
					_options,
					"options",
					null
				) { options: RelatedPersonShareOptionsJs? ->
					options?.let { nonNull1 ->
						relatedPersonShareOptions_fromJs(nonNull1)
					}
				}
				val result = relatedPersonApi.inGroup.shareWith(
					delegateConverted,
					relatedPersonConverted,
					optionsConverted,
				)
				groupScoped_toJs(
					result,
					{ x1: DecryptedRelatedPerson ->
						relatedPerson_toJs(x1)
					},
				)
			}
		}

		override fun shareWithMany(relatedPerson: GroupScopedJs<DecryptedRelatedPersonJs>,
				delegates: Array<EntityReferenceInGroupToRelatedPersonShareOptionsMapObject_delegate_shareOptions>):
				Promise<GroupScopedJs<DecryptedRelatedPersonJs>> = GlobalScope.promise {
			val relatedPersonConverted: GroupScoped<DecryptedRelatedPerson> = groupScoped_fromJs(
				relatedPerson,
				{ x1: DecryptedRelatedPersonJs ->
					relatedPerson_fromJs(x1)
				},
			)
			val delegatesConverted: Map<EntityReferenceInGroup, RelatedPersonShareOptions> =
					EntityReferenceInGroupToRelatedPersonShareOptionsMapObject_delegate_shareOptions_fromJs(delegates)
			val result = relatedPersonApi.inGroup.shareWithMany(
				relatedPersonConverted,
				delegatesConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: DecryptedRelatedPerson ->
					relatedPerson_toJs(x1)
				},
			)
		}

		override fun filterRelatedPersonsBy(groupId: String, filter: FilterOptionsJs<RelatedPersonJs>):
				Promise<PaginatedListIteratorJs<GroupScopedJs<DecryptedRelatedPersonJs>>> =
				GlobalScope.promise {
			val groupIdConverted: String = groupId
			val filterConverted: FilterOptions<RelatedPerson> = filterOptions_fromJs(filter)
			val result = relatedPersonApi.inGroup.filterRelatedPersonsBy(
				groupIdConverted,
				filterConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: GroupScoped<DecryptedRelatedPerson> ->
					groupScoped_toJs(
						x1,
						{ x2: DecryptedRelatedPerson ->
							relatedPerson_toJs(x2)
						},
					)
				},
			)
		}

		override fun filterRelatedPersonsBySorted(groupId: String,
				filter: SortableFilterOptionsJs<RelatedPersonJs>):
				Promise<PaginatedListIteratorJs<GroupScopedJs<DecryptedRelatedPersonJs>>> =
				GlobalScope.promise {
			val groupIdConverted: String = groupId
			val filterConverted: SortableFilterOptions<RelatedPerson> = sortableFilterOptions_fromJs(filter)
			val result = relatedPersonApi.inGroup.filterRelatedPersonsBySorted(
				groupIdConverted,
				filterConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: GroupScoped<DecryptedRelatedPerson> ->
					groupScoped_toJs(
						x1,
						{ x2: DecryptedRelatedPerson ->
							relatedPerson_toJs(x2)
						},
					)
				},
			)
		}

		override fun createRelatedPerson(entity: GroupScopedJs<DecryptedRelatedPersonJs>):
				Promise<GroupScopedJs<DecryptedRelatedPersonJs>> = GlobalScope.promise {
			val entityConverted: GroupScoped<DecryptedRelatedPerson> = groupScoped_fromJs(
				entity,
				{ x1: DecryptedRelatedPersonJs ->
					relatedPerson_fromJs(x1)
				},
			)
			val result = relatedPersonApi.inGroup.createRelatedPerson(
				entityConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: DecryptedRelatedPerson ->
					relatedPerson_toJs(x1)
				},
			)
		}

		override fun createRelatedPersons(entities: Array<GroupScopedJs<DecryptedRelatedPersonJs>>):
				Promise<Array<GroupScopedJs<DecryptedRelatedPersonJs>>> = GlobalScope.promise {
			val entitiesConverted: List<GroupScoped<DecryptedRelatedPerson>> = arrayToList(
				entities,
				"entities",
				{ x1: GroupScopedJs<DecryptedRelatedPersonJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: DecryptedRelatedPersonJs ->
							relatedPerson_fromJs(x2)
						},
					)
				},
			)
			val result = relatedPersonApi.inGroup.createRelatedPersons(
				entitiesConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<DecryptedRelatedPerson> ->
					groupScoped_toJs(
						x1,
						{ x2: DecryptedRelatedPerson ->
							relatedPerson_toJs(x2)
						},
					)
				},
			)
		}

		override fun undeleteRelatedPersonById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
				Promise<GroupScopedJs<DecryptedRelatedPersonJs>> = GlobalScope.promise {
			val entityIdConverted: GroupScoped<StoredDocumentIdentifier> = groupScoped_fromJs(
				entityId,
				{ x1: StoredDocumentIdentifierJs ->
					storedDocumentIdentifier_fromJs(x1)
				},
			)
			val result = relatedPersonApi.inGroup.undeleteRelatedPersonById(
				entityIdConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: DecryptedRelatedPerson ->
					relatedPerson_toJs(x1)
				},
			)
		}

		override
				fun undeleteRelatedPersonsByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
				Promise<Array<GroupScopedJs<DecryptedRelatedPersonJs>>> = GlobalScope.promise {
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
			val result = relatedPersonApi.inGroup.undeleteRelatedPersonsByIds(
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<DecryptedRelatedPerson> ->
					groupScoped_toJs(
						x1,
						{ x2: DecryptedRelatedPerson ->
							relatedPerson_toJs(x2)
						},
					)
				},
			)
		}

		override fun undeleteRelatedPerson(relatedPerson: GroupScopedJs<RelatedPersonJs>):
				Promise<GroupScopedJs<DecryptedRelatedPersonJs>> = GlobalScope.promise {
			val relatedPersonConverted: GroupScoped<RelatedPerson> = groupScoped_fromJs(
				relatedPerson,
				{ x1: RelatedPersonJs ->
					relatedPerson_fromJs(x1)
				},
			)
			val result = relatedPersonApi.inGroup.undeleteRelatedPerson(
				relatedPersonConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: DecryptedRelatedPerson ->
					relatedPerson_toJs(x1)
				},
			)
		}

		override
				fun undeleteRelatedPersons(relatedPersons: Array<GroupScopedJs<DecryptedRelatedPersonJs>>):
				Promise<Array<GroupScopedJs<DecryptedRelatedPersonJs>>> = GlobalScope.promise {
			val relatedPersonsConverted: List<GroupScoped<DecryptedRelatedPerson>> = arrayToList(
				relatedPersons,
				"relatedPersons",
				{ x1: GroupScopedJs<DecryptedRelatedPersonJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: DecryptedRelatedPersonJs ->
							relatedPerson_fromJs(x2)
						},
					)
				},
			)
			val result = relatedPersonApi.inGroup.undeleteRelatedPersons(
				relatedPersonsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<DecryptedRelatedPerson> ->
					groupScoped_toJs(
						x1,
						{ x2: DecryptedRelatedPerson ->
							relatedPerson_toJs(x2)
						},
					)
				},
			)
		}

		override fun modifyRelatedPerson(entity: GroupScopedJs<DecryptedRelatedPersonJs>):
				Promise<GroupScopedJs<DecryptedRelatedPersonJs>> = GlobalScope.promise {
			val entityConverted: GroupScoped<DecryptedRelatedPerson> = groupScoped_fromJs(
				entity,
				{ x1: DecryptedRelatedPersonJs ->
					relatedPerson_fromJs(x1)
				},
			)
			val result = relatedPersonApi.inGroup.modifyRelatedPerson(
				entityConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: DecryptedRelatedPerson ->
					relatedPerson_toJs(x1)
				},
			)
		}

		override fun modifyRelatedPersons(entities: Array<GroupScopedJs<DecryptedRelatedPersonJs>>):
				Promise<Array<GroupScopedJs<DecryptedRelatedPersonJs>>> = GlobalScope.promise {
			val entitiesConverted: List<GroupScoped<DecryptedRelatedPerson>> = arrayToList(
				entities,
				"entities",
				{ x1: GroupScopedJs<DecryptedRelatedPersonJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: DecryptedRelatedPersonJs ->
							relatedPerson_fromJs(x2)
						},
					)
				},
			)
			val result = relatedPersonApi.inGroup.modifyRelatedPersons(
				entitiesConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<DecryptedRelatedPerson> ->
					groupScoped_toJs(
						x1,
						{ x2: DecryptedRelatedPerson ->
							relatedPerson_toJs(x2)
						},
					)
				},
			)
		}

		override fun getRelatedPerson(groupId: String, entityId: String):
				Promise<GroupScopedJs<DecryptedRelatedPersonJs>?> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val entityIdConverted: String = entityId
			val result = relatedPersonApi.inGroup.getRelatedPerson(
				groupIdConverted,
				entityIdConverted,
			)
			nullToUndefined(
				result?.let { nonNull1 ->
					groupScoped_toJs(
						nonNull1,
						{ x1: DecryptedRelatedPerson ->
							relatedPerson_toJs(x1)
						},
					)
				}
			)
		}

		override fun getRelatedPersons(groupId: String, entityIds: Array<String>):
				Promise<Array<GroupScopedJs<DecryptedRelatedPersonJs>>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val entityIdsConverted: List<String> = arrayToList(
				entityIds,
				"entityIds",
				{ x1: String ->
					x1
				},
			)
			val result = relatedPersonApi.inGroup.getRelatedPersons(
				groupIdConverted,
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<DecryptedRelatedPerson> ->
					groupScoped_toJs(
						x1,
						{ x2: DecryptedRelatedPerson ->
							relatedPerson_toJs(x2)
						},
					)
				},
			)
		}
	}

	override fun withEncryptionMetadata(base: DecryptedRelatedPersonJs?, options: dynamic):
			Promise<DecryptedRelatedPersonJs> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val baseConverted: DecryptedRelatedPerson? = base?.let { nonNull1 ->
				relatedPerson_fromJs(nonNull1)
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
			val alternateRootDelegateIdConverted: String? = convertingOptionOrDefaultNullable(
				_options,
				"alternateRootDelegateId",
				null
			) { alternateRootDelegateId: String? ->
				undefinedToNull(alternateRootDelegateId)
			}
			val result = relatedPersonApi.withEncryptionMetadata(
				baseConverted,
				userConverted,
				delegatesConverted,
				alternateRootDelegateIdConverted,
			)
			relatedPerson_toJs(result)
		}
	}

	override fun withEncryptionMetadataAndDelegates(
		base: DecryptedRelatedPersonJs?,
		delegates: Record<String, RelatedPersonDelegateOptionsJs>,
		options: dynamic,
	): Promise<DecryptedRelatedPersonJs> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val baseConverted: DecryptedRelatedPerson? = base?.let { nonNull1 ->
				relatedPerson_fromJs(nonNull1)
			}
			val delegatesConverted: Map<String, RelatedPersonDelegateOptions> = objectToMap(
				delegates,
				"delegates",
				{ x1: String ->
					x1
				},
				{ x1: RelatedPersonDelegateOptionsJs ->
					relatedPersonDelegateOptions_fromJs(x1)
				},
			)
			val userConverted: User? = convertingOptionOrDefaultNullable(
				_options,
				"user",
				null
			) { user: UserJs? ->
				user?.let { nonNull1 ->
					user_fromJs(nonNull1)
				}
			}
			val alternateRootDelegateIdConverted: String? = convertingOptionOrDefaultNullable(
				_options,
				"alternateRootDelegateId",
				null
			) { alternateRootDelegateId: String? ->
				undefinedToNull(alternateRootDelegateId)
			}
			val result = relatedPersonApi.withEncryptionMetadataAndDelegates(
				baseConverted,
				delegatesConverted,
				userConverted,
				alternateRootDelegateIdConverted,
			)
			relatedPerson_toJs(result)
		}
	}

	override fun getEncryptionKeysOf(relatedPerson: RelatedPersonJs): Promise<Array<String>> =
			GlobalScope.promise {
		val relatedPersonConverted: RelatedPerson = relatedPerson_fromJs(relatedPerson)
		val result = relatedPersonApi.getEncryptionKeysOf(
			relatedPersonConverted,
		)
		setToArray(
			result,
			{ x1: HexString ->
				hexString_toJs(x1)
			},
		)
	}

	override fun hasWriteAccess(relatedPerson: RelatedPersonJs): Promise<Boolean> =
			GlobalScope.promise {
		val relatedPersonConverted: RelatedPerson = relatedPerson_fromJs(relatedPerson)
		val result = relatedPersonApi.hasWriteAccess(
			relatedPersonConverted,
		)
		result
	}

	override fun getSecretIdsOf(relatedPerson: RelatedPersonJs): Promise<Array<String>> =
			GlobalScope.promise {
		val relatedPersonConverted: RelatedPerson = relatedPerson_fromJs(relatedPerson)
		val result = relatedPersonApi.getSecretIdsOf(
			relatedPersonConverted,
		)
		setToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun createDelegationDeAnonymizationMetadata(entity: RelatedPersonJs,
			delegates: Array<String>): Promise<Unit> = GlobalScope.promise {
		val entityConverted: RelatedPerson = relatedPerson_fromJs(entity)
		val delegatesConverted: Set<String> = arrayToSet(
			delegates,
			"delegates",
			{ x1: String ->
				x1
			},
		)
		relatedPersonApi.createDelegationDeAnonymizationMetadata(
			entityConverted,
			delegatesConverted,
		)

	}

	override fun decrypt(relatedPersons: Array<EncryptedRelatedPersonJs>):
			Promise<Array<DecryptedRelatedPersonJs>> = GlobalScope.promise {
		val relatedPersonsConverted: List<EncryptedRelatedPerson> = arrayToList(
			relatedPersons,
			"relatedPersons",
			{ x1: EncryptedRelatedPersonJs ->
				relatedPerson_fromJs(x1)
			},
		)
		val result = relatedPersonApi.decrypt(
			relatedPersonsConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedRelatedPerson ->
				relatedPerson_toJs(x1)
			},
		)
	}

	override fun tryDecrypt(relatedPersons: Array<EncryptedRelatedPersonJs>):
			Promise<Array<RelatedPersonJs>> = GlobalScope.promise {
		val relatedPersonsConverted: List<EncryptedRelatedPerson> = arrayToList(
			relatedPersons,
			"relatedPersons",
			{ x1: EncryptedRelatedPersonJs ->
				relatedPerson_fromJs(x1)
			},
		)
		val result = relatedPersonApi.tryDecrypt(
			relatedPersonsConverted,
		)
		listToArray(
			result,
			{ x1: RelatedPerson ->
				relatedPerson_toJs(x1)
			},
		)
	}

	override fun encryptOrValidate(relatedPersons: Array<RelatedPersonJs>):
			Promise<Array<EncryptedRelatedPersonJs>> = GlobalScope.promise {
		val relatedPersonsConverted: List<RelatedPerson> = arrayToList(
			relatedPersons,
			"relatedPersons",
			{ x1: RelatedPersonJs ->
				relatedPerson_fromJs(x1)
			},
		)
		val result = relatedPersonApi.encryptOrValidate(
			relatedPersonsConverted,
		)
		listToArray(
			result,
			{ x1: EncryptedRelatedPerson ->
				relatedPerson_toJs(x1)
			},
		)
	}

	override fun matchRelatedPersonsBy(filter: FilterOptionsJs<RelatedPersonJs>):
			Promise<Array<String>> = GlobalScope.promise {
		val filterConverted: FilterOptions<RelatedPerson> = filterOptions_fromJs(filter)
		val result = relatedPersonApi.matchRelatedPersonsBy(
			filterConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun matchRelatedPersonsBySorted(filter: SortableFilterOptionsJs<RelatedPersonJs>):
			Promise<Array<String>> = GlobalScope.promise {
		val filterConverted: SortableFilterOptions<RelatedPerson> = sortableFilterOptions_fromJs(filter)
		val result = relatedPersonApi.matchRelatedPersonsBySorted(
			filterConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun deleteRelatedPersonById(entityId: String, rev: String):
			Promise<StoredDocumentIdentifierJs> = GlobalScope.promise {
		val entityIdConverted: String = entityId
		val revConverted: String = rev
		val result = relatedPersonApi.deleteRelatedPersonById(
			entityIdConverted,
			revConverted,
		)
		storedDocumentIdentifier_toJs(result)
	}

	override fun deleteRelatedPersonsByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<StoredDocumentIdentifierJs>> = GlobalScope.promise {
		val entityIdsConverted: List<StoredDocumentIdentifier> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: StoredDocumentIdentifierJs ->
				storedDocumentIdentifier_fromJs(x1)
			},
		)
		val result = relatedPersonApi.deleteRelatedPersonsByIds(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: StoredDocumentIdentifier ->
				storedDocumentIdentifier_toJs(x1)
			},
		)
	}

	override fun purgeRelatedPersonById(id: String, rev: String): Promise<Unit> = GlobalScope.promise {
		val idConverted: String = id
		val revConverted: String = rev
		relatedPersonApi.purgeRelatedPersonById(
			idConverted,
			revConverted,
		)

	}

	override fun purgeRelatedPersonsByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<StoredDocumentIdentifierJs>> = GlobalScope.promise {
		val entityIdsConverted: List<StoredDocumentIdentifier> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: StoredDocumentIdentifierJs ->
				storedDocumentIdentifier_fromJs(x1)
			},
		)
		val result = relatedPersonApi.purgeRelatedPersonsByIds(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: StoredDocumentIdentifier ->
				storedDocumentIdentifier_toJs(x1)
			},
		)
	}

	override fun deleteRelatedPerson(relatedPerson: RelatedPersonJs):
			Promise<StoredDocumentIdentifierJs> = GlobalScope.promise {
		val relatedPersonConverted: RelatedPerson = relatedPerson_fromJs(relatedPerson)
		val result = relatedPersonApi.deleteRelatedPerson(
			relatedPersonConverted,
		)
		storedDocumentIdentifier_toJs(result)
	}

	override fun deleteRelatedPersons(relatedPersons: Array<RelatedPersonJs>):
			Promise<Array<StoredDocumentIdentifierJs>> = GlobalScope.promise {
		val relatedPersonsConverted: List<RelatedPerson> = arrayToList(
			relatedPersons,
			"relatedPersons",
			{ x1: RelatedPersonJs ->
				relatedPerson_fromJs(x1)
			},
		)
		val result = relatedPersonApi.deleteRelatedPersons(
			relatedPersonsConverted,
		)
		listToArray(
			result,
			{ x1: StoredDocumentIdentifier ->
				storedDocumentIdentifier_toJs(x1)
			},
		)
	}

	override fun purgeRelatedPerson(relatedPerson: RelatedPersonJs): Promise<Unit> =
			GlobalScope.promise {
		val relatedPersonConverted: RelatedPerson = relatedPerson_fromJs(relatedPerson)
		relatedPersonApi.purgeRelatedPerson(
			relatedPersonConverted,
		)

	}

	override fun purgeRelatedPersons(relatedPersons: Array<RelatedPersonJs>):
			Promise<Array<StoredDocumentIdentifierJs>> = GlobalScope.promise {
		val relatedPersonsConverted: List<RelatedPerson> = arrayToList(
			relatedPersons,
			"relatedPersons",
			{ x1: RelatedPersonJs ->
				relatedPerson_fromJs(x1)
			},
		)
		val result = relatedPersonApi.purgeRelatedPersons(
			relatedPersonsConverted,
		)
		listToArray(
			result,
			{ x1: StoredDocumentIdentifier ->
				storedDocumentIdentifier_toJs(x1)
			},
		)
	}

	override fun shareWith(
		delegateId: String,
		relatedPerson: DecryptedRelatedPersonJs,
		options: dynamic,
	): Promise<DecryptedRelatedPersonJs> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val delegateIdConverted: String = delegateId
			val relatedPersonConverted: DecryptedRelatedPerson = relatedPerson_fromJs(relatedPerson)
			val optionsConverted: RelatedPersonShareOptions? = convertingOptionOrDefaultNullable(
				_options,
				"options",
				null
			) { options: RelatedPersonShareOptionsJs? ->
				options?.let { nonNull1 ->
					relatedPersonShareOptions_fromJs(nonNull1)
				}
			}
			val result = relatedPersonApi.shareWith(
				delegateIdConverted,
				relatedPersonConverted,
				optionsConverted,
			)
			relatedPerson_toJs(result)
		}
	}

	override fun shareWithMany(relatedPerson: DecryptedRelatedPersonJs,
			delegates: Record<String, RelatedPersonShareOptionsJs>): Promise<DecryptedRelatedPersonJs> =
			GlobalScope.promise {
		val relatedPersonConverted: DecryptedRelatedPerson = relatedPerson_fromJs(relatedPerson)
		val delegatesConverted: Map<String, RelatedPersonShareOptions> = objectToMap(
			delegates,
			"delegates",
			{ x1: String ->
				x1
			},
			{ x1: RelatedPersonShareOptionsJs ->
				relatedPersonShareOptions_fromJs(x1)
			},
		)
		val result = relatedPersonApi.shareWithMany(
			relatedPersonConverted,
			delegatesConverted,
		)
		relatedPerson_toJs(result)
	}

	override fun filterRelatedPersonsBy(filter: FilterOptionsJs<RelatedPersonJs>):
			Promise<PaginatedListIteratorJs<DecryptedRelatedPersonJs>> = GlobalScope.promise {
		val filterConverted: FilterOptions<RelatedPerson> = filterOptions_fromJs(filter)
		val result = relatedPersonApi.filterRelatedPersonsBy(
			filterConverted,
		)
		paginatedListIterator_toJs(
			result,
			{ x1: DecryptedRelatedPerson ->
				relatedPerson_toJs(x1)
			},
		)
	}

	override fun filterRelatedPersonsBySorted(filter: SortableFilterOptionsJs<RelatedPersonJs>):
			Promise<PaginatedListIteratorJs<DecryptedRelatedPersonJs>> = GlobalScope.promise {
		val filterConverted: SortableFilterOptions<RelatedPerson> = sortableFilterOptions_fromJs(filter)
		val result = relatedPersonApi.filterRelatedPersonsBySorted(
			filterConverted,
		)
		paginatedListIterator_toJs(
			result,
			{ x1: DecryptedRelatedPerson ->
				relatedPerson_toJs(x1)
			},
		)
	}

	override fun createRelatedPerson(entity: DecryptedRelatedPersonJs):
			Promise<DecryptedRelatedPersonJs> = GlobalScope.promise {
		val entityConverted: DecryptedRelatedPerson = relatedPerson_fromJs(entity)
		val result = relatedPersonApi.createRelatedPerson(
			entityConverted,
		)
		relatedPerson_toJs(result)
	}

	override fun createRelatedPersons(entities: Array<DecryptedRelatedPersonJs>):
			Promise<Array<DecryptedRelatedPersonJs>> = GlobalScope.promise {
		val entitiesConverted: List<DecryptedRelatedPerson> = arrayToList(
			entities,
			"entities",
			{ x1: DecryptedRelatedPersonJs ->
				relatedPerson_fromJs(x1)
			},
		)
		val result = relatedPersonApi.createRelatedPersons(
			entitiesConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedRelatedPerson ->
				relatedPerson_toJs(x1)
			},
		)
	}

	override fun undeleteRelatedPersonById(id: String, rev: String): Promise<DecryptedRelatedPersonJs>
			= GlobalScope.promise {
		val idConverted: String = id
		val revConverted: String = rev
		val result = relatedPersonApi.undeleteRelatedPersonById(
			idConverted,
			revConverted,
		)
		relatedPerson_toJs(result)
	}

	override fun undeleteRelatedPersonsByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<DecryptedRelatedPersonJs>> = GlobalScope.promise {
		val entityIdsConverted: List<StoredDocumentIdentifier> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: StoredDocumentIdentifierJs ->
				storedDocumentIdentifier_fromJs(x1)
			},
		)
		val result = relatedPersonApi.undeleteRelatedPersonsByIds(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedRelatedPerson ->
				relatedPerson_toJs(x1)
			},
		)
	}

	override fun undeleteRelatedPerson(relatedPerson: RelatedPersonJs):
			Promise<DecryptedRelatedPersonJs> = GlobalScope.promise {
		val relatedPersonConverted: RelatedPerson = relatedPerson_fromJs(relatedPerson)
		val result = relatedPersonApi.undeleteRelatedPerson(
			relatedPersonConverted,
		)
		relatedPerson_toJs(result)
	}

	override fun undeleteRelatedPersons(relatedPersons: Array<RelatedPersonJs>):
			Promise<Array<DecryptedRelatedPersonJs>> = GlobalScope.promise {
		val relatedPersonsConverted: List<RelatedPerson> = arrayToList(
			relatedPersons,
			"relatedPersons",
			{ x1: RelatedPersonJs ->
				relatedPerson_fromJs(x1)
			},
		)
		val result = relatedPersonApi.undeleteRelatedPersons(
			relatedPersonsConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedRelatedPerson ->
				relatedPerson_toJs(x1)
			},
		)
	}

	override fun modifyRelatedPerson(entity: DecryptedRelatedPersonJs):
			Promise<DecryptedRelatedPersonJs> = GlobalScope.promise {
		val entityConverted: DecryptedRelatedPerson = relatedPerson_fromJs(entity)
		val result = relatedPersonApi.modifyRelatedPerson(
			entityConverted,
		)
		relatedPerson_toJs(result)
	}

	override fun modifyRelatedPersons(entities: Array<DecryptedRelatedPersonJs>):
			Promise<Array<DecryptedRelatedPersonJs>> = GlobalScope.promise {
		val entitiesConverted: List<DecryptedRelatedPerson> = arrayToList(
			entities,
			"entities",
			{ x1: DecryptedRelatedPersonJs ->
				relatedPerson_fromJs(x1)
			},
		)
		val result = relatedPersonApi.modifyRelatedPersons(
			entitiesConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedRelatedPerson ->
				relatedPerson_toJs(x1)
			},
		)
	}

	override fun getRelatedPerson(entityId: String): Promise<DecryptedRelatedPersonJs?> =
			GlobalScope.promise {
		val entityIdConverted: String = entityId
		val result = relatedPersonApi.getRelatedPerson(
			entityIdConverted,
		)
		nullToUndefined(
			result?.let { nonNull1 ->
				relatedPerson_toJs(nonNull1)
			}
		)
	}

	override fun getRelatedPersons(entityIds: Array<String>): Promise<Array<DecryptedRelatedPersonJs>>
			= GlobalScope.promise {
		val entityIdsConverted: List<String> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: String ->
				x1
			},
		)
		val result = relatedPersonApi.getRelatedPersons(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedRelatedPerson ->
				relatedPerson_toJs(x1)
			},
		)
	}

	override fun subscribeToEvents(
		events: Array<String>,
		filter: FilterOptionsJs<RelatedPersonJs>,
		options: dynamic,
	): Promise<EntitySubscriptionJs<EncryptedRelatedPersonJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val eventsConverted: Set<SubscriptionEventType> = arrayToSet(
				events,
				"events",
				{ x1: String ->
					SubscriptionEventType.valueOf(x1)
				},
			)
			val filterConverted: FilterOptions<RelatedPerson> = filterOptions_fromJs(filter)
			val subscriptionConfigConverted: EntitySubscriptionConfiguration? =
					convertingOptionOrDefaultNullable(
				_options,
				"subscriptionConfig",
				null
			) { subscriptionConfig: EntitySubscriptionConfigurationJs? ->
				subscriptionConfig?.let { nonNull1 ->
					entitySubscriptionConfiguration_fromJs(nonNull1)
				}
			}
			val result = relatedPersonApi.subscribeToEvents(
				eventsConverted,
				filterConverted,
				subscriptionConfigConverted,
			)
			entitySubscription_toJs(
				result,
				{ x1: EncryptedRelatedPerson ->
					relatedPerson_toJs(x1)
				},
			)
		}
	}
}
