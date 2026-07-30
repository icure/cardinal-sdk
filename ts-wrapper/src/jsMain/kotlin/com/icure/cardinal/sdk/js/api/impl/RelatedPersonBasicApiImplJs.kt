// auto-generated file
package com.icure.cardinal.sdk.js.api.`impl`

import com.icure.cardinal.sdk.api.RelatedPersonBasicApi
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.js.api.RelatedPersonBasicApiJs
import com.icure.cardinal.sdk.js.api.RelatedPersonBasicInGroupApiJs
import com.icure.cardinal.sdk.js.filters.BaseFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.BaseSortableFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.baseFilterOptions_fromJs
import com.icure.cardinal.sdk.js.filters.baseSortableFilterOptions_fromJs
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToList
import com.icure.cardinal.sdk.js.model.CheckedConverters.listToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.EncryptedRelatedPersonJs
import com.icure.cardinal.sdk.js.model.GroupScopedJs
import com.icure.cardinal.sdk.js.model.RelatedPersonJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.model.groupScoped_fromJs
import com.icure.cardinal.sdk.js.model.groupScoped_toJs
import com.icure.cardinal.sdk.js.model.relatedPerson_fromJs
import com.icure.cardinal.sdk.js.model.relatedPerson_toJs
import com.icure.cardinal.sdk.js.model.storedDocumentIdentifier_fromJs
import com.icure.cardinal.sdk.js.model.storedDocumentIdentifier_toJs
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import com.icure.cardinal.sdk.js.utils.pagination.paginatedListIterator_toJs
import com.icure.cardinal.sdk.model.EncryptedRelatedPerson
import com.icure.cardinal.sdk.model.GroupScoped
import com.icure.cardinal.sdk.model.RelatedPerson
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
import kotlin.Array
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlin.collections.List
import kotlin.js.Promise
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise

@OptIn(DelicateCoroutinesApi::class)
internal class RelatedPersonBasicApiImplJs(
	private val relatedPersonBasicApi: RelatedPersonBasicApi,
) : RelatedPersonBasicApiJs {
	override val inGroup: RelatedPersonBasicInGroupApiJs = object : RelatedPersonBasicInGroupApiJs {
		override fun matchRelatedPersonsBy(groupId: String, filter: BaseFilterOptionsJs<RelatedPersonJs>):
				Promise<Array<String>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val filterConverted: BaseFilterOptions<RelatedPerson> = baseFilterOptions_fromJs(filter)
			val result = relatedPersonBasicApi.inGroup.matchRelatedPersonsBy(
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
				filter: BaseSortableFilterOptionsJs<RelatedPersonJs>): Promise<Array<String>> =
				GlobalScope.promise {
			val groupIdConverted: String = groupId
			val filterConverted: BaseSortableFilterOptions<RelatedPerson> =
					baseSortableFilterOptions_fromJs(filter)
			val result = relatedPersonBasicApi.inGroup.matchRelatedPersonsBySorted(
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

		override fun filterRelatedPersonsBy(groupId: String,
				filter: BaseFilterOptionsJs<RelatedPersonJs>):
				Promise<PaginatedListIteratorJs<GroupScopedJs<EncryptedRelatedPersonJs>>> =
				GlobalScope.promise {
			val groupIdConverted: String = groupId
			val filterConverted: BaseFilterOptions<RelatedPerson> = baseFilterOptions_fromJs(filter)
			val result = relatedPersonBasicApi.inGroup.filterRelatedPersonsBy(
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
				filter: BaseSortableFilterOptionsJs<RelatedPersonJs>):
				Promise<PaginatedListIteratorJs<GroupScopedJs<EncryptedRelatedPersonJs>>> =
				GlobalScope.promise {
			val groupIdConverted: String = groupId
			val filterConverted: BaseSortableFilterOptions<RelatedPerson> =
					baseSortableFilterOptions_fromJs(filter)
			val result = relatedPersonBasicApi.inGroup.filterRelatedPersonsBySorted(
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

		override fun deleteRelatedPersonById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
				Promise<GroupScopedJs<StoredDocumentIdentifierJs>> = GlobalScope.promise {
			val entityIdConverted: GroupScoped<StoredDocumentIdentifier> = groupScoped_fromJs(
				entityId,
				{ x1: StoredDocumentIdentifierJs ->
					storedDocumentIdentifier_fromJs(x1)
				},
			)
			val result = relatedPersonBasicApi.inGroup.deleteRelatedPersonById(
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
			val result = relatedPersonBasicApi.inGroup.deleteRelatedPersonsByIds(
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
			relatedPersonBasicApi.inGroup.purgeRelatedPersonById(
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
			val result = relatedPersonBasicApi.inGroup.purgeRelatedPersonsByIds(
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
			val result = relatedPersonBasicApi.inGroup.deleteRelatedPerson(
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
			val result = relatedPersonBasicApi.inGroup.deleteRelatedPersons(
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
			relatedPersonBasicApi.inGroup.purgeRelatedPerson(
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
			val result = relatedPersonBasicApi.inGroup.purgeRelatedPersons(
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

		override fun createRelatedPerson(entity: GroupScopedJs<EncryptedRelatedPersonJs>):
				Promise<GroupScopedJs<EncryptedRelatedPersonJs>> = GlobalScope.promise {
			val entityConverted: GroupScoped<EncryptedRelatedPerson> = groupScoped_fromJs(
				entity,
				{ x1: EncryptedRelatedPersonJs ->
					relatedPerson_fromJs(x1)
				},
			)
			val result = relatedPersonBasicApi.inGroup.createRelatedPerson(
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
			val result = relatedPersonBasicApi.inGroup.createRelatedPersons(
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
			val result = relatedPersonBasicApi.inGroup.undeleteRelatedPersonById(
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
			val result = relatedPersonBasicApi.inGroup.undeleteRelatedPersonsByIds(
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
			val result = relatedPersonBasicApi.inGroup.undeleteRelatedPerson(
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
			val result = relatedPersonBasicApi.inGroup.undeleteRelatedPersons(
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
			val result = relatedPersonBasicApi.inGroup.modifyRelatedPerson(
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
			val result = relatedPersonBasicApi.inGroup.modifyRelatedPersons(
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
			val result = relatedPersonBasicApi.inGroup.getRelatedPerson(
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
			val result = relatedPersonBasicApi.inGroup.getRelatedPersons(
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

	override fun matchRelatedPersonsBy(filter: BaseFilterOptionsJs<RelatedPersonJs>):
			Promise<Array<String>> = GlobalScope.promise {
		val filterConverted: BaseFilterOptions<RelatedPerson> = baseFilterOptions_fromJs(filter)
		val result = relatedPersonBasicApi.matchRelatedPersonsBy(
			filterConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun matchRelatedPersonsBySorted(filter: BaseSortableFilterOptionsJs<RelatedPersonJs>):
			Promise<Array<String>> = GlobalScope.promise {
		val filterConverted: BaseSortableFilterOptions<RelatedPerson> =
				baseSortableFilterOptions_fromJs(filter)
		val result = relatedPersonBasicApi.matchRelatedPersonsBySorted(
			filterConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun filterRelatedPersonsBy(filter: BaseFilterOptionsJs<RelatedPersonJs>):
			Promise<PaginatedListIteratorJs<EncryptedRelatedPersonJs>> = GlobalScope.promise {
		val filterConverted: BaseFilterOptions<RelatedPerson> = baseFilterOptions_fromJs(filter)
		val result = relatedPersonBasicApi.filterRelatedPersonsBy(
			filterConverted,
		)
		paginatedListIterator_toJs(
			result,
			{ x1: EncryptedRelatedPerson ->
				relatedPerson_toJs(x1)
			},
		)
	}

	override fun filterRelatedPersonsBySorted(filter: BaseSortableFilterOptionsJs<RelatedPersonJs>):
			Promise<PaginatedListIteratorJs<EncryptedRelatedPersonJs>> = GlobalScope.promise {
		val filterConverted: BaseSortableFilterOptions<RelatedPerson> =
				baseSortableFilterOptions_fromJs(filter)
		val result = relatedPersonBasicApi.filterRelatedPersonsBySorted(
			filterConverted,
		)
		paginatedListIterator_toJs(
			result,
			{ x1: EncryptedRelatedPerson ->
				relatedPerson_toJs(x1)
			},
		)
	}

	override fun deleteRelatedPersonById(entityId: String, rev: String):
			Promise<StoredDocumentIdentifierJs> = GlobalScope.promise {
		val entityIdConverted: String = entityId
		val revConverted: String = rev
		val result = relatedPersonBasicApi.deleteRelatedPersonById(
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
		val result = relatedPersonBasicApi.deleteRelatedPersonsByIds(
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
		relatedPersonBasicApi.purgeRelatedPersonById(
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
		val result = relatedPersonBasicApi.purgeRelatedPersonsByIds(
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
		val result = relatedPersonBasicApi.deleteRelatedPerson(
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
		val result = relatedPersonBasicApi.deleteRelatedPersons(
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
		relatedPersonBasicApi.purgeRelatedPerson(
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
		val result = relatedPersonBasicApi.purgeRelatedPersons(
			relatedPersonsConverted,
		)
		listToArray(
			result,
			{ x1: StoredDocumentIdentifier ->
				storedDocumentIdentifier_toJs(x1)
			},
		)
	}

	override fun createRelatedPerson(entity: EncryptedRelatedPersonJs):
			Promise<EncryptedRelatedPersonJs> = GlobalScope.promise {
		val entityConverted: EncryptedRelatedPerson = relatedPerson_fromJs(entity)
		val result = relatedPersonBasicApi.createRelatedPerson(
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
		val result = relatedPersonBasicApi.createRelatedPersons(
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
		val result = relatedPersonBasicApi.undeleteRelatedPersonById(
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
		val result = relatedPersonBasicApi.undeleteRelatedPersonsByIds(
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
		val result = relatedPersonBasicApi.undeleteRelatedPerson(
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
		val result = relatedPersonBasicApi.undeleteRelatedPersons(
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
		val result = relatedPersonBasicApi.modifyRelatedPerson(
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
		val result = relatedPersonBasicApi.modifyRelatedPersons(
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
		val result = relatedPersonBasicApi.getRelatedPerson(
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
		val result = relatedPersonBasicApi.getRelatedPersons(
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
