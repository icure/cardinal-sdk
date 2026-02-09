// auto-generated file
package com.icure.cardinal.sdk.js.api.`impl`

import com.icure.cardinal.sdk.api.AgendaApi
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.js.api.AgendaApiJs
import com.icure.cardinal.sdk.js.api.AgendaInGroupApiJs
import com.icure.cardinal.sdk.js.filters.BaseFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.BaseSortableFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.baseFilterOptions_fromJs
import com.icure.cardinal.sdk.js.filters.baseSortableFilterOptions_fromJs
import com.icure.cardinal.sdk.js.model.AgendaJs
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToList
import com.icure.cardinal.sdk.js.model.CheckedConverters.listToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.GroupScopedJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.model.agenda_fromJs
import com.icure.cardinal.sdk.js.model.agenda_toJs
import com.icure.cardinal.sdk.js.model.groupScoped_fromJs
import com.icure.cardinal.sdk.js.model.groupScoped_toJs
import com.icure.cardinal.sdk.js.model.storedDocumentIdentifier_fromJs
import com.icure.cardinal.sdk.js.model.storedDocumentIdentifier_toJs
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import com.icure.cardinal.sdk.js.utils.pagination.paginatedListIterator_toJs
import com.icure.cardinal.sdk.model.Agenda
import com.icure.cardinal.sdk.model.GroupScoped
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
internal class AgendaApiImplJs(
	private val agendaApi: AgendaApi,
) : AgendaApiJs {
	override val inGroup: AgendaInGroupApiJs = object : AgendaInGroupApiJs {
		override fun getAgenda(groupId: String, entityId: String): Promise<GroupScopedJs<AgendaJs>?> =
				GlobalScope.promise {
			val groupIdConverted: String = groupId
			val entityIdConverted: String = entityId
			val result = agendaApi.inGroup.getAgenda(
				groupIdConverted,
				entityIdConverted,
			)
			nullToUndefined(
				result?.let { nonNull1 ->
					groupScoped_toJs(
						nonNull1,
						{ x1: Agenda ->
							agenda_toJs(x1)
						},
					)
				}
			)
		}

		override fun getAgendas(groupId: String, entityIds: Array<String>):
				Promise<Array<GroupScopedJs<AgendaJs>>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val entityIdsConverted: List<String> = arrayToList(
				entityIds,
				"entityIds",
				{ x1: String ->
					x1
				},
			)
			val result = agendaApi.inGroup.getAgendas(
				groupIdConverted,
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<Agenda> ->
					groupScoped_toJs(
						x1,
						{ x2: Agenda ->
							agenda_toJs(x2)
						},
					)
				},
			)
		}

		override fun createAgenda(entity: GroupScopedJs<AgendaJs>): Promise<GroupScopedJs<AgendaJs>> =
				GlobalScope.promise {
			val entityConverted: GroupScoped<Agenda> = groupScoped_fromJs(
				entity,
				{ x1: AgendaJs ->
					agenda_fromJs(x1)
				},
			)
			val result = agendaApi.inGroup.createAgenda(
				entityConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: Agenda ->
					agenda_toJs(x1)
				},
			)
		}

		override fun createAgendas(entities: Array<GroupScopedJs<AgendaJs>>):
				Promise<Array<GroupScopedJs<AgendaJs>>> = GlobalScope.promise {
			val entitiesConverted: List<GroupScoped<Agenda>> = arrayToList(
				entities,
				"entities",
				{ x1: GroupScopedJs<AgendaJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: AgendaJs ->
							agenda_fromJs(x2)
						},
					)
				},
			)
			val result = agendaApi.inGroup.createAgendas(
				entitiesConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<Agenda> ->
					groupScoped_toJs(
						x1,
						{ x2: Agenda ->
							agenda_toJs(x2)
						},
					)
				},
			)
		}

		override fun modifyAgenda(entity: GroupScopedJs<AgendaJs>): Promise<GroupScopedJs<AgendaJs>> =
				GlobalScope.promise {
			val entityConverted: GroupScoped<Agenda> = groupScoped_fromJs(
				entity,
				{ x1: AgendaJs ->
					agenda_fromJs(x1)
				},
			)
			val result = agendaApi.inGroup.modifyAgenda(
				entityConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: Agenda ->
					agenda_toJs(x1)
				},
			)
		}

		override fun modifyAgendas(entities: Array<GroupScopedJs<AgendaJs>>):
				Promise<Array<GroupScopedJs<AgendaJs>>> = GlobalScope.promise {
			val entitiesConverted: List<GroupScoped<Agenda>> = arrayToList(
				entities,
				"entities",
				{ x1: GroupScopedJs<AgendaJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: AgendaJs ->
							agenda_fromJs(x2)
						},
					)
				},
			)
			val result = agendaApi.inGroup.modifyAgendas(
				entitiesConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<Agenda> ->
					groupScoped_toJs(
						x1,
						{ x2: Agenda ->
							agenda_toJs(x2)
						},
					)
				},
			)
		}

		override fun deleteAgendasByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
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
			val result = agendaApi.inGroup.deleteAgendasByIds(
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

		override fun deleteAgendaById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
				Promise<GroupScopedJs<StoredDocumentIdentifierJs>> = GlobalScope.promise {
			val entityIdConverted: GroupScoped<StoredDocumentIdentifier> = groupScoped_fromJs(
				entityId,
				{ x1: StoredDocumentIdentifierJs ->
					storedDocumentIdentifier_fromJs(x1)
				},
			)
			val result = agendaApi.inGroup.deleteAgendaById(
				entityIdConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: StoredDocumentIdentifier ->
					storedDocumentIdentifier_toJs(x1)
				},
			)
		}

		override fun deleteAgendas(agendas: Array<GroupScopedJs<AgendaJs>>):
				Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>> = GlobalScope.promise {
			val agendasConverted: List<GroupScoped<Agenda>> = arrayToList(
				agendas,
				"agendas",
				{ x1: GroupScopedJs<AgendaJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: AgendaJs ->
							agenda_fromJs(x2)
						},
					)
				},
			)
			val result = agendaApi.inGroup.deleteAgendas(
				agendasConverted,
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

		override fun deleteAgenda(agenda: GroupScopedJs<AgendaJs>):
				Promise<GroupScopedJs<StoredDocumentIdentifierJs>> = GlobalScope.promise {
			val agendaConverted: GroupScoped<Agenda> = groupScoped_fromJs(
				agenda,
				{ x1: AgendaJs ->
					agenda_fromJs(x1)
				},
			)
			val result = agendaApi.inGroup.deleteAgenda(
				agendaConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: StoredDocumentIdentifier ->
					storedDocumentIdentifier_toJs(x1)
				},
			)
		}

		override fun undeleteAgendasByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
				Promise<Array<GroupScopedJs<AgendaJs>>> = GlobalScope.promise {
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
			val result = agendaApi.inGroup.undeleteAgendasByIds(
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<Agenda> ->
					groupScoped_toJs(
						x1,
						{ x2: Agenda ->
							agenda_toJs(x2)
						},
					)
				},
			)
		}

		override fun undeleteAgendaById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
				Promise<GroupScopedJs<AgendaJs>> = GlobalScope.promise {
			val entityIdConverted: GroupScoped<StoredDocumentIdentifier> = groupScoped_fromJs(
				entityId,
				{ x1: StoredDocumentIdentifierJs ->
					storedDocumentIdentifier_fromJs(x1)
				},
			)
			val result = agendaApi.inGroup.undeleteAgendaById(
				entityIdConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: Agenda ->
					agenda_toJs(x1)
				},
			)
		}

		override fun undeleteAgendas(agendas: Array<GroupScopedJs<AgendaJs>>):
				Promise<Array<GroupScopedJs<AgendaJs>>> = GlobalScope.promise {
			val agendasConverted: List<GroupScoped<Agenda>> = arrayToList(
				agendas,
				"agendas",
				{ x1: GroupScopedJs<AgendaJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: AgendaJs ->
							agenda_fromJs(x2)
						},
					)
				},
			)
			val result = agendaApi.inGroup.undeleteAgendas(
				agendasConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<Agenda> ->
					groupScoped_toJs(
						x1,
						{ x2: Agenda ->
							agenda_toJs(x2)
						},
					)
				},
			)
		}

		override fun undeleteAgenda(agenda: GroupScopedJs<AgendaJs>): Promise<GroupScopedJs<AgendaJs>> =
				GlobalScope.promise {
			val agendaConverted: GroupScoped<Agenda> = groupScoped_fromJs(
				agenda,
				{ x1: AgendaJs ->
					agenda_fromJs(x1)
				},
			)
			val result = agendaApi.inGroup.undeleteAgenda(
				agendaConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: Agenda ->
					agenda_toJs(x1)
				},
			)
		}

		override fun purgeAgendasByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
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
			val result = agendaApi.inGroup.purgeAgendasByIds(
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

		override fun purgeAgendaById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>): Promise<Unit> =
				GlobalScope.promise {
			val entityIdConverted: GroupScoped<StoredDocumentIdentifier> = groupScoped_fromJs(
				entityId,
				{ x1: StoredDocumentIdentifierJs ->
					storedDocumentIdentifier_fromJs(x1)
				},
			)
			agendaApi.inGroup.purgeAgendaById(
				entityIdConverted,
			)

		}

		override fun purgeAgendas(agendas: Array<GroupScopedJs<AgendaJs>>):
				Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>> = GlobalScope.promise {
			val agendasConverted: List<GroupScoped<Agenda>> = arrayToList(
				agendas,
				"agendas",
				{ x1: GroupScopedJs<AgendaJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: AgendaJs ->
							agenda_fromJs(x2)
						},
					)
				},
			)
			val result = agendaApi.inGroup.purgeAgendas(
				agendasConverted,
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

		override fun purgeAgenda(agenda: GroupScopedJs<AgendaJs>): Promise<Unit> = GlobalScope.promise {
			val agendaConverted: GroupScoped<Agenda> = groupScoped_fromJs(
				agenda,
				{ x1: AgendaJs ->
					agenda_fromJs(x1)
				},
			)
			agendaApi.inGroup.purgeAgenda(
				agendaConverted,
			)

		}

		override fun matchAgendasBy(groupId: String, filter: BaseFilterOptionsJs<AgendaJs>):
				Promise<Array<String>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val filterConverted: BaseFilterOptions<Agenda> = baseFilterOptions_fromJs(filter)
			val result = agendaApi.inGroup.matchAgendasBy(
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

		override fun matchAgendasBySorted(groupId: String, filter: BaseSortableFilterOptionsJs<AgendaJs>):
				Promise<Array<String>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val filterConverted: BaseSortableFilterOptions<Agenda> = baseSortableFilterOptions_fromJs(filter)
			val result = agendaApi.inGroup.matchAgendasBySorted(
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

		override fun filterAgendasBy(groupId: String, filter: BaseFilterOptionsJs<AgendaJs>):
				Promise<PaginatedListIteratorJs<GroupScopedJs<AgendaJs>>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val filterConverted: BaseFilterOptions<Agenda> = baseFilterOptions_fromJs(filter)
			val result = agendaApi.inGroup.filterAgendasBy(
				groupIdConverted,
				filterConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: GroupScoped<Agenda> ->
					groupScoped_toJs(
						x1,
						{ x2: Agenda ->
							agenda_toJs(x2)
						},
					)
				},
			)
		}

		override fun filterAgendasBySorted(groupId: String,
				filter: BaseSortableFilterOptionsJs<AgendaJs>):
				Promise<PaginatedListIteratorJs<GroupScopedJs<AgendaJs>>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val filterConverted: BaseSortableFilterOptions<Agenda> = baseSortableFilterOptions_fromJs(filter)
			val result = agendaApi.inGroup.filterAgendasBySorted(
				groupIdConverted,
				filterConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: GroupScoped<Agenda> ->
					groupScoped_toJs(
						x1,
						{ x2: Agenda ->
							agenda_toJs(x2)
						},
					)
				},
			)
		}
	}

	override fun createAgenda(agenda: AgendaJs): Promise<AgendaJs> = GlobalScope.promise {
		val agendaConverted: Agenda = agenda_fromJs(agenda)
		val result = agendaApi.createAgenda(
			agendaConverted,
		)
		agenda_toJs(result)
	}

	override fun createAgendas(agendas: Array<AgendaJs>): Promise<Array<AgendaJs>> =
			GlobalScope.promise {
		val agendasConverted: List<Agenda> = arrayToList(
			agendas,
			"agendas",
			{ x1: AgendaJs ->
				agenda_fromJs(x1)
			},
		)
		val result = agendaApi.createAgendas(
			agendasConverted,
		)
		listToArray(
			result,
			{ x1: Agenda ->
				agenda_toJs(x1)
			},
		)
	}

	override fun deleteAgendaById(entityId: String, rev: String): Promise<StoredDocumentIdentifierJs> =
			GlobalScope.promise {
		val entityIdConverted: String = entityId
		val revConverted: String = rev
		val result = agendaApi.deleteAgendaById(
			entityIdConverted,
			revConverted,
		)
		storedDocumentIdentifier_toJs(result)
	}

	override fun deleteAgendasByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<StoredDocumentIdentifierJs>> = GlobalScope.promise {
		val entityIdsConverted: List<StoredDocumentIdentifier> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: StoredDocumentIdentifierJs ->
				storedDocumentIdentifier_fromJs(x1)
			},
		)
		val result = agendaApi.deleteAgendasByIds(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: StoredDocumentIdentifier ->
				storedDocumentIdentifier_toJs(x1)
			},
		)
	}

	override fun purgeAgendaById(id: String, rev: String): Promise<Unit> = GlobalScope.promise {
		val idConverted: String = id
		val revConverted: String = rev
		agendaApi.purgeAgendaById(
			idConverted,
			revConverted,
		)

	}

	override fun purgeAgendasByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<StoredDocumentIdentifierJs>> = GlobalScope.promise {
		val entityIdsConverted: List<StoredDocumentIdentifier> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: StoredDocumentIdentifierJs ->
				storedDocumentIdentifier_fromJs(x1)
			},
		)
		val result = agendaApi.purgeAgendasByIds(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: StoredDocumentIdentifier ->
				storedDocumentIdentifier_toJs(x1)
			},
		)
	}

	override fun undeleteAgendaById(id: String, rev: String): Promise<AgendaJs> = GlobalScope.promise {
		val idConverted: String = id
		val revConverted: String = rev
		val result = agendaApi.undeleteAgendaById(
			idConverted,
			revConverted,
		)
		agenda_toJs(result)
	}

	override fun undeleteAgendasByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<AgendaJs>> = GlobalScope.promise {
		val entityIdsConverted: List<StoredDocumentIdentifier> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: StoredDocumentIdentifierJs ->
				storedDocumentIdentifier_fromJs(x1)
			},
		)
		val result = agendaApi.undeleteAgendasByIds(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: Agenda ->
				agenda_toJs(x1)
			},
		)
	}

	override fun deleteAgenda(agenda: AgendaJs): Promise<StoredDocumentIdentifierJs> =
			GlobalScope.promise {
		val agendaConverted: Agenda = agenda_fromJs(agenda)
		val result = agendaApi.deleteAgenda(
			agendaConverted,
		)
		storedDocumentIdentifier_toJs(result)
	}

	override fun deleteAgendas(agendas: Array<AgendaJs>): Promise<Array<StoredDocumentIdentifierJs>> =
			GlobalScope.promise {
		val agendasConverted: List<Agenda> = arrayToList(
			agendas,
			"agendas",
			{ x1: AgendaJs ->
				agenda_fromJs(x1)
			},
		)
		val result = agendaApi.deleteAgendas(
			agendasConverted,
		)
		listToArray(
			result,
			{ x1: StoredDocumentIdentifier ->
				storedDocumentIdentifier_toJs(x1)
			},
		)
	}

	override fun purgeAgenda(agenda: AgendaJs): Promise<Unit> = GlobalScope.promise {
		val agendaConverted: Agenda = agenda_fromJs(agenda)
		agendaApi.purgeAgenda(
			agendaConverted,
		)

	}

	override fun purgeAgendas(agendas: Array<AgendaJs>): Promise<Array<StoredDocumentIdentifierJs>> =
			GlobalScope.promise {
		val agendasConverted: List<Agenda> = arrayToList(
			agendas,
			"agendas",
			{ x1: AgendaJs ->
				agenda_fromJs(x1)
			},
		)
		val result = agendaApi.purgeAgendas(
			agendasConverted,
		)
		listToArray(
			result,
			{ x1: StoredDocumentIdentifier ->
				storedDocumentIdentifier_toJs(x1)
			},
		)
	}

	override fun undeleteAgenda(agenda: AgendaJs): Promise<AgendaJs> = GlobalScope.promise {
		val agendaConverted: Agenda = agenda_fromJs(agenda)
		val result = agendaApi.undeleteAgenda(
			agendaConverted,
		)
		agenda_toJs(result)
	}

	override fun undeleteAgendas(agendas: Array<AgendaJs>): Promise<Array<AgendaJs>> =
			GlobalScope.promise {
		val agendasConverted: List<Agenda> = arrayToList(
			agendas,
			"agendas",
			{ x1: AgendaJs ->
				agenda_fromJs(x1)
			},
		)
		val result = agendaApi.undeleteAgendas(
			agendasConverted,
		)
		listToArray(
			result,
			{ x1: Agenda ->
				agenda_toJs(x1)
			},
		)
	}

	override fun getAgenda(agendaId: String): Promise<AgendaJs?> = GlobalScope.promise {
		val agendaIdConverted: String = agendaId
		val result = agendaApi.getAgenda(
			agendaIdConverted,
		)
		nullToUndefined(
			result?.let { nonNull1 ->
				agenda_toJs(nonNull1)
			}
		)
	}

	override fun getAgendas(agendaIds: Array<String>): Promise<Array<AgendaJs>> = GlobalScope.promise {
		val agendaIdsConverted: List<String> = arrayToList(
			agendaIds,
			"agendaIds",
			{ x1: String ->
				x1
			},
		)
		val result = agendaApi.getAgendas(
			agendaIdsConverted,
		)
		listToArray(
			result,
			{ x1: Agenda ->
				agenda_toJs(x1)
			},
		)
	}

	override fun modifyAgenda(agenda: AgendaJs): Promise<AgendaJs> = GlobalScope.promise {
		val agendaConverted: Agenda = agenda_fromJs(agenda)
		val result = agendaApi.modifyAgenda(
			agendaConverted,
		)
		agenda_toJs(result)
	}

	override fun modifyAgendas(agendas: Array<AgendaJs>): Promise<Array<AgendaJs>> =
			GlobalScope.promise {
		val agendasConverted: List<Agenda> = arrayToList(
			agendas,
			"agendas",
			{ x1: AgendaJs ->
				agenda_fromJs(x1)
			},
		)
		val result = agendaApi.modifyAgendas(
			agendasConverted,
		)
		listToArray(
			result,
			{ x1: Agenda ->
				agenda_toJs(x1)
			},
		)
	}

	override fun matchAgendasBy(filter: BaseFilterOptionsJs<AgendaJs>): Promise<Array<String>> =
			GlobalScope.promise {
		val filterConverted: BaseFilterOptions<Agenda> = baseFilterOptions_fromJs(filter)
		val result = agendaApi.matchAgendasBy(
			filterConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun matchAgendasBySorted(filter: BaseSortableFilterOptionsJs<AgendaJs>):
			Promise<Array<String>> = GlobalScope.promise {
		val filterConverted: BaseSortableFilterOptions<Agenda> = baseSortableFilterOptions_fromJs(filter)
		val result = agendaApi.matchAgendasBySorted(
			filterConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun filterAgendasBy(filter: BaseFilterOptionsJs<AgendaJs>):
			Promise<PaginatedListIteratorJs<AgendaJs>> = GlobalScope.promise {
		val filterConverted: BaseFilterOptions<Agenda> = baseFilterOptions_fromJs(filter)
		val result = agendaApi.filterAgendasBy(
			filterConverted,
		)
		paginatedListIterator_toJs(
			result,
			{ x1: Agenda ->
				agenda_toJs(x1)
			},
		)
	}

	override fun filterAgendasBySorted(filter: BaseSortableFilterOptionsJs<AgendaJs>):
			Promise<PaginatedListIteratorJs<AgendaJs>> = GlobalScope.promise {
		val filterConverted: BaseSortableFilterOptions<Agenda> = baseSortableFilterOptions_fromJs(filter)
		val result = agendaApi.filterAgendasBySorted(
			filterConverted,
		)
		paginatedListIterator_toJs(
			result,
			{ x1: Agenda ->
				agenda_toJs(x1)
			},
		)
	}
}
