package com.icure.cardinal.sdk.api.impl

import com.icure.cardinal.sdk.api.AgendaApi
import com.icure.cardinal.sdk.api.AgendaInGroupApi
import com.icure.cardinal.sdk.api.raw.RawAgendaApi
import com.icure.cardinal.sdk.api.raw.successBodyOrNull404
import com.icure.cardinal.sdk.api.raw.successBodyOrThrowRevisionConflict
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.filters.mapAgendaFilterOptions
import com.icure.cardinal.sdk.model.Agenda
import com.icure.cardinal.sdk.model.GroupScoped
import com.icure.cardinal.sdk.model.IdWithRev
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.ListOfIdsAndRev
import com.icure.cardinal.sdk.model.toStoredDocumentIdentifier
import com.icure.cardinal.sdk.options.BasicApiConfiguration
import com.icure.cardinal.sdk.utils.pagination.IdsPageIterator
import com.icure.cardinal.sdk.utils.pagination.PaginatedListIterator
import com.icure.utils.InternalIcureApi

@InternalIcureApi
internal class AgendaApiImpl (
	private val rawApi: RawAgendaApi,
	private val config: BasicApiConfiguration,
) : AgendaApi {

	override val inGroup: AgendaInGroupApi = AgendaGroupApiImpl(rawApi, config)

	override suspend fun createAgenda(agenda: Agenda): Agenda {
		basicRequireIsValidForCreation(agenda)
		return rawApi.createAgenda(agenda).successBody()
	}

	override suspend fun createAgendas(agendas: List<Agenda>): List<Agenda> = skipRequestOnNullList(agendas) { entities ->
		basicRequireIsValidForCreation(agendas)
		rawApi.createAgendas(entities).successBody()
	}

	override suspend fun deleteAgendaById(entityId: String, rev: String): StoredDocumentIdentifier =
		rawApi.deleteAgenda(entityId, rev).successBodyOrThrowRevisionConflict().toStoredDocumentIdentifier()

	override suspend fun deleteAgendasByIds(entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier> =
		skipRequestOnNullList(entityIds) { ids ->
			rawApi.deleteAgendasWithRev(ListOfIdsAndRev(ids)).successBody().map { it.toStoredDocumentIdentifier() }
		}

	override suspend fun purgeAgendaById(id: String, rev: String) {
		rawApi.purgeAgenda(id, rev).successBodyOrThrowRevisionConflict()
	}

	override suspend fun purgeAgendasByIds(entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier> =
		skipRequestOnNullList(entityIds) { ids ->
			rawApi.purgeAgendas(ListOfIdsAndRev(ids = ids)).successBody().map { it.toStoredDocumentIdentifier() }
		}

	override suspend fun undeleteAgendaById(id: String, rev: String): Agenda =
		rawApi.undeleteAgenda(id, rev).successBodyOrThrowRevisionConflict()

	override suspend fun undeleteAgendasByIds(entityIds: List<StoredDocumentIdentifier>): List<Agenda> =
		skipRequestOnNullList(entityIds) { ids ->
			rawApi.undeleteAgendas(ListOfIdsAndRev(ids = ids)).successBodyOrThrowRevisionConflict()
		}

	override suspend fun getAgenda(agendaId: String): Agenda? = rawApi.getAgenda(agendaId).successBodyOrNull404()

	override suspend fun getAgendas(agendaIds: List<String>): List<Agenda> = skipRequestOnNullList(agendaIds) { ids ->
		rawApi.getAgendasByIds(ListOfIds(ids)).successBody()
	}

	override suspend fun modifyAgenda(agenda: Agenda): Agenda {
		basicRequireIsValidForCreation(agenda)
		return rawApi.modifyAgenda(agenda).successBodyOrThrowRevisionConflict()
	}

	override suspend fun modifyAgendas(agendas: List<Agenda>): List<Agenda> = skipRequestOnNullList(agendas) { entities ->
		basicRequireIsValidForCreation(entities)
		rawApi.modifyAgendas(entities).successBody()
	}

	override suspend fun matchAgendasBy(filter: BaseFilterOptions<Agenda>): List<String> =
		rawApi.matchAgendasBy(mapAgendaFilterOptions(filter, config)).successBody()

	override suspend fun matchAgendasBySorted(filter: BaseSortableFilterOptions<Agenda>): List<String> =
		matchAgendasBy(filter)

	override suspend fun filterAgendasBy(filter: BaseFilterOptions<Agenda>): PaginatedListIterator<Agenda> =
		IdsPageIterator(matchAgendasBy(filter), ::getAgendas)

	override suspend fun filterAgendasBySorted(filter: BaseSortableFilterOptions<Agenda>): PaginatedListIterator<Agenda> =
		filterAgendasBy(filter)
}

@InternalIcureApi
internal class AgendaGroupApiImpl (
	private val rawApi: RawAgendaApi,
	private val config: BasicApiConfiguration,
) : AgendaInGroupApi {

	override suspend fun getAgenda(
		groupId: String,
		entityId: String,
	): GroupScoped<Agenda>? =
		rawApi.getAgendaInGroup(groupId, entityId).successBodyOrNull404()?.let { GroupScoped(it, groupId) }

	override suspend fun getAgendas(
		groupId: String,
		entityIds: List<String>,
	): List<GroupScoped<Agenda>> = skipRequestOnNullList(entityIds) { ids ->
		rawApi.getAgendasInGroup(groupId, ListOfIds(ids)).successBody().map { GroupScoped(it, groupId) }
	}

	override suspend fun createAgenda(entity: GroupScoped<Agenda>): GroupScoped<Agenda> {
		basicRequireIsValidForCreation(entity)
		return rawApi.createAgendaInGroup(entity.groupId, entity.entity ).successBody().let {
			GroupScoped(it, entity.groupId)
		}
	}


	override suspend fun createAgendas(entities: List<GroupScoped<Agenda>>): List<GroupScoped<Agenda>> {
		basicRequireIsValidForCreation(entities)
		return entities.mapUniqueIdentifiablesChunkedByGroup { groupId, batch ->
			rawApi.createAgendasInGroup(groupId, batch).successBody()
		}
	}

	override suspend fun modifyAgenda(entity: GroupScoped<Agenda>): GroupScoped<Agenda> {
		requireIsValidForModification(entity)
		return rawApi.modifyAgendaInGroup(entity.groupId, entity.entity ).successBody().let {
			GroupScoped(it, entity.groupId)
		}
	}

	override suspend fun modifyAgendas(entities: List<GroupScoped<Agenda>>): List<GroupScoped<Agenda>> {
		requireIsValidForModification(entities)
		return entities.mapUniqueIdentifiablesChunkedByGroup { groupId, batch ->
			rawApi.modifyAgendasInGroup(groupId, batch).successBody()
		}
	}

	override suspend fun deleteAgendasByIds(
		entityIds: List<GroupScoped<StoredDocumentIdentifier>>
	): List<GroupScoped<StoredDocumentIdentifier>> = entityIds.mapUniqueIdentifiablesChunkedByGroup { groupId, entityIds ->
		rawApi.deleteAgendasInGroup(
			groupId = groupId,
			agendaIdsAndRevs = ListOfIdsAndRev(entityIds.map { IdWithRev(it.id, it.rev) })
		).successBody().map { it.toStoredDocumentIdentifier() }
	}

	override suspend fun deleteAgendaById(entityId: GroupScoped<StoredDocumentIdentifier>): GroupScoped<StoredDocumentIdentifier> =
		 rawApi.deleteAgendaInGroup(entityId.groupId, entityId.entity.id, entityId.entity.rev).successBody().let {
			 GroupScoped(it.toStoredDocumentIdentifier(), entityId.groupId)
		 }

	override suspend fun undeleteAgendaById(entityId: GroupScoped<StoredDocumentIdentifier>): GroupScoped<Agenda> =
		rawApi.undeleteAgendaInGroup(entityId.groupId, entityId.entity.id, entityId.entity.rev).successBody().let {
			GroupScoped(it, entityId.groupId)
		}

	override suspend fun undeleteAgendasByIds(
		entityIds: List<GroupScoped<StoredDocumentIdentifier>>
	): List<GroupScoped<Agenda>> = entityIds.mapUniqueIdentifiablesChunkedByGroup { groupId, entityIds ->
		rawApi.undeleteAgendasInGroup(
			groupId = groupId,
			agendaIdsAndRevs = ListOfIdsAndRev(entityIds.map { IdWithRev(it.id, it.rev) })
		).successBody()
	}

	override suspend fun purgeAgendaById(entityId: GroupScoped<StoredDocumentIdentifier>) {
		rawApi.purgeAgendaInGroup(entityId.groupId, entityId.entity.id, entityId.entity.rev).successBody().let {
			GroupScoped(it.toStoredDocumentIdentifier(), entityId.groupId)
		}
	}

	override suspend fun purgeAgendasByIds(
		entityIds: List<GroupScoped<StoredDocumentIdentifier>>
	): List<GroupScoped<StoredDocumentIdentifier>> = entityIds.mapUniqueIdentifiablesChunkedByGroup { groupId, entityIds ->
		rawApi.purgeAgendasInGroup(
			groupId = groupId,
			agendaIdsAndRevs = ListOfIdsAndRev(entityIds.map { IdWithRev(it.id, it.rev) })
		).successBody().map { it.toStoredDocumentIdentifier() }
	}

	override suspend fun matchAgendasBy(
		groupId: String,
		filter: BaseFilterOptions<Agenda>,
	): List<String> = rawApi.matchAgendasInGroupBy(
		groupId = groupId,
		filter = mapAgendaFilterOptions(filter, config, groupId)
	).successBody()

	override suspend fun matchAgendasBySorted(
		groupId: String,
		filter: BaseSortableFilterOptions<Agenda>,
	): List<String> = matchAgendasBy(groupId, filter)

	override suspend fun filterAgendasBy(
		groupId: String,
		filter: BaseFilterOptions<Agenda>,
	): PaginatedListIterator<GroupScoped<Agenda>> {
		val ids = matchAgendasBy(groupId, filter)
		return IdsPageIterator(ids) { getAgendas(groupId, it) }
	}

	override suspend fun filterAgendasBySorted(
		groupId: String,
		filter: BaseSortableFilterOptions<Agenda>,
	): PaginatedListIterator<GroupScoped<Agenda>> = filterAgendasBy(groupId, filter)


}
