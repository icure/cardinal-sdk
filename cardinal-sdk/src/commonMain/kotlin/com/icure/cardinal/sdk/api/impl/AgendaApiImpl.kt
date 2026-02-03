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
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.ListOfIdsAndRev
import com.icure.cardinal.sdk.model.toStoredDocumentIdentifier
import com.icure.cardinal.sdk.options.BasicApiConfiguration
import com.icure.cardinal.sdk.utils.pagination.IdsPageIterator
import com.icure.cardinal.sdk.utils.pagination.PaginatedListIterator
import com.icure.utils.InternalIcureApi

@OptIn(InternalIcureApi::class)
internal abstract class AbstractAgendaApi(
	private val rawApi: RawAgendaApi,
	private val config: BasicApiConfiguration
) {

	protected suspend fun doCreateAgenda(groupId: String?, agenda: Agenda): Agenda {
		basicRequireIsValidForCreation(agenda)
		return if (groupId == null) {
			rawApi.createAgenda(agenda)
		} else {
			rawApi.createAgendaInGroup(groupId, agenda)
		}.successBody()
	}

	protected suspend fun doCreateAgendas(groupId: String?, entities: List<Agenda>): List<Agenda> = skipRequestOnEmptyList(entities) { agendas ->
		basicRequireIsValidForCreation(agendas)
		return if (groupId == null) {
			rawApi.createAgendas(entities)
		} else {
			rawApi.createAgendasInGroup(groupId, agendas)
		}.successBody()
	}

	protected suspend fun doDeleteAgendaById(groupId: String?, agendaId: String, rev: String): StoredDocumentIdentifier =
		if (groupId == null) {
			rawApi.deleteAgenda(agendaId, rev)
		} else {
			rawApi.deleteAgendaInGroup(groupId, agendaId, rev)
		}.successBodyOrThrowRevisionConflict().toStoredDocumentIdentifier()

	protected suspend fun doDeleteAgendasByIds(groupId: String?, entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier> =
		skipRequestOnEmptyList(entityIds) { agendaIds ->
			if (groupId == null) {
				rawApi.deleteAgendasWithRev(ListOfIdsAndRev(agendaIds))
			} else {
				rawApi.deleteAgendasInGroup(groupId = groupId, agendaIdsAndRevs = ListOfIdsAndRev(agendaIds))
			}.successBody().map { it.toStoredDocumentIdentifier() }
		}

	protected suspend fun doPurgeAgendaById(groupId: String?, agendaId: String, rev: String) {
		if (groupId == null) {
			rawApi.purgeAgenda(agendaId, rev)
		} else {
			rawApi.purgeAgendaInGroup(groupId, agendaId, rev)
		}.successBodyOrThrowRevisionConflict()
	}

	protected suspend fun doPurgeAgendasByIds(groupId: String?, entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier> =
		skipRequestOnEmptyList(entityIds) { agendaIds ->
			if (groupId == null) {
				rawApi.purgeAgendas(ListOfIdsAndRev(agendaIds))
			} else {
				rawApi.purgeAgendasInGroup(groupId = groupId, agendaIdsAndRevs = ListOfIdsAndRev(agendaIds))
			}.successBody().map { it.toStoredDocumentIdentifier() }
		}

	protected suspend fun doUndeleteAgendaById(groupId: String?, agendaId: String, rev: String): Agenda =
		if (groupId == null) {
			rawApi.undeleteAgenda(agendaId, rev)
		} else {
			rawApi.undeleteAgendaInGroup(groupId, agendaId, rev)
		}.successBodyOrThrowRevisionConflict()

	protected suspend fun doUndeleteAgendasByIds(groupId: String?, entityIds: List<StoredDocumentIdentifier>): List<Agenda> =
		skipRequestOnEmptyList(entityIds) { agendaIds ->
			if (groupId == null) {
				rawApi.undeleteAgendas(ListOfIdsAndRev(agendaIds))
			} else {
				rawApi.undeleteAgendasInGroup(groupId = groupId, agendaIdsAndRevs = ListOfIdsAndRev(agendaIds))
			}.successBody()
		}

	protected suspend fun doGetAgendasByIds(groupId: String?, entityIds: List<String>): List<Agenda> =
		skipRequestOnEmptyList(entityIds) { agendaIds ->
			if (groupId == null) {
				rawApi.getAgendasByIds(ListOfIds(agendaIds))
			} else {
				rawApi.getAgendasInGroup(groupId = groupId, ListOfIds(agendaIds))
			}.successBody()
		}

	protected suspend fun doGetAgenda(groupId: String?, agendaId: String): Agenda? =
		if (groupId == null) {
			rawApi.getAgenda(agendaId)
		} else {
			rawApi.getAgendaInGroup(groupId = groupId, agendaId = agendaId)
		}.successBodyOrNull404()

	protected suspend fun doModifyAgenda(groupId: String?, agenda: Agenda): Agenda {
		basicRequireIsValidForCreation(agenda)
		return if (groupId == null) {
			rawApi.modifyAgenda(agenda)
		} else {
			rawApi.modifyAgendaInGroup(groupId, agenda)
		}.successBodyOrThrowRevisionConflict()
	}

	protected suspend fun doModifyAgendas(groupId: String?, agendas: List<Agenda>): List<Agenda> = skipRequestOnEmptyList(agendas) { entities ->
		basicRequireIsValidForCreation(entities)
		return if (groupId == null) {
			rawApi.modifyAgendas(entities)
		} else {
			rawApi.modifyAgendasInGroup(groupId, entities)
		}.successBodyOrThrowRevisionConflict()
	}

	protected suspend fun doMatchAgendasBy(groupId: String?, filter: BaseFilterOptions<Agenda>): List<String> =
		if (groupId == null) {
			rawApi.matchAgendasBy(mapAgendaFilterOptions(filter, config))
		} else {
			rawApi.matchAgendasInGroupBy(groupId = groupId, filter = mapAgendaFilterOptions(filter, config, groupId))
		}.successBody()
}

@InternalIcureApi
internal class AgendaApiImpl (
	rawApi: RawAgendaApi,
	config: BasicApiConfiguration,
) : AgendaApi, AbstractAgendaApi(rawApi, config) {

	override val inGroup: AgendaInGroupApi = AgendaGroupApiImpl(rawApi, config)

	override suspend fun createAgenda(agenda: Agenda): Agenda = doCreateAgenda(groupId = null, agenda)

	override suspend fun createAgendas(agendas: List<Agenda>): List<Agenda> = doCreateAgendas(groupId = null, agendas)

	override suspend fun deleteAgendaById(entityId: String, rev: String): StoredDocumentIdentifier =
		doDeleteAgendaById(groupId = null, agendaId = entityId, rev = rev)

	override suspend fun deleteAgendasByIds(entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier> =
		doDeleteAgendasByIds(groupId = null, entityIds = entityIds)

	override suspend fun purgeAgendaById(id: String, rev: String) {
		doPurgeAgendaById(groupId = null, agendaId = id, rev = rev)
	}

	override suspend fun purgeAgendasByIds(entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier> =
		doPurgeAgendasByIds(groupId = null, entityIds = entityIds)

	override suspend fun undeleteAgendaById(id: String, rev: String): Agenda =
		doUndeleteAgendaById(groupId = null, agendaId = id, rev = rev)

	override suspend fun undeleteAgendasByIds(entityIds: List<StoredDocumentIdentifier>): List<Agenda> =
		doUndeleteAgendasByIds(groupId = null, entityIds = entityIds)

	override suspend fun getAgenda(agendaId: String): Agenda? = doGetAgenda(groupId = null, agendaId = agendaId)

	override suspend fun getAgendas(agendaIds: List<String>): List<Agenda> = doGetAgendasByIds(groupId = null, entityIds = agendaIds)

	override suspend fun modifyAgenda(agenda: Agenda): Agenda = doModifyAgenda(groupId = null, agenda)

	override suspend fun modifyAgendas(agendas: List<Agenda>): List<Agenda> = doModifyAgendas(groupId = null, agendas)

	override suspend fun matchAgendasBy(filter: BaseFilterOptions<Agenda>): List<String> = doMatchAgendasBy(groupId = null, filter = filter)

	override suspend fun matchAgendasBySorted(filter: BaseSortableFilterOptions<Agenda>): List<String> =
		matchAgendasBy(filter)

	override suspend fun filterAgendasBy(filter: BaseFilterOptions<Agenda>): PaginatedListIterator<Agenda> =
		IdsPageIterator(matchAgendasBy(filter), ::getAgendas)

	override suspend fun filterAgendasBySorted(filter: BaseSortableFilterOptions<Agenda>): PaginatedListIterator<Agenda> =
		filterAgendasBy(filter)
}

@InternalIcureApi
internal class AgendaGroupApiImpl (
	rawApi: RawAgendaApi,
	config: BasicApiConfiguration,
) : AgendaInGroupApi, AbstractAgendaApi(rawApi, config) {

	override suspend fun getAgenda(
		groupId: String,
		entityId: String,
	): GroupScoped<Agenda>? =
		doGetAgenda(groupId = groupId, agendaId = entityId)?.let { GroupScoped(entity = it, groupId = groupId) }

	override suspend fun getAgendas(
		groupId: String,
		entityIds: List<String>,
	): List<GroupScoped<Agenda>> = doGetAgendasByIds(groupId, entityIds).map { GroupScoped(entity = it, groupId = groupId) }

	override suspend fun createAgenda(entity: GroupScoped<Agenda>): GroupScoped<Agenda> =
		GroupScoped(entity = doCreateAgenda(entity.groupId, entity.entity), groupId = entity.groupId)

	override suspend fun createAgendas(entities: List<GroupScoped<Agenda>>): List<GroupScoped<Agenda>> {
		basicRequireIsValidForCreationInGroup(entities)
		return entities.mapUniqueIdentifiablesChunkedByGroup { groupId, batch ->
			doCreateAgendas(groupId, batch)
		}
	}


	override suspend fun modifyAgenda(entity: GroupScoped<Agenda>): GroupScoped<Agenda> = GroupScoped(
		entity = doModifyAgenda(entity.groupId, entity.entity),
		groupId = entity.groupId
	)

	override suspend fun modifyAgendas(entities: List<GroupScoped<Agenda>>): List<GroupScoped<Agenda>> {
		requireIsValidForModificationInGroup(entities)
		return entities.mapUniqueIdentifiablesChunkedByGroup { groupId, batch ->
			doModifyAgendas(groupId, batch)
		}
	}

	override suspend fun deleteAgendasByIds(
		entityIds: List<GroupScoped<StoredDocumentIdentifier>>
	): List<GroupScoped<StoredDocumentIdentifier>> = entityIds.mapUniqueIdentifiablesChunkedByGroup { groupId, entityIds ->
		doDeleteAgendasByIds(groupId, entityIds)
	}

	override suspend fun deleteAgendaById(entityId: GroupScoped<StoredDocumentIdentifier>): GroupScoped<StoredDocumentIdentifier> =
		GroupScoped(
			doDeleteAgendaById(groupId = entityId.groupId, agendaId = entityId.entity.id, rev = entityId.entity.rev),
			groupId = entityId.groupId,
		)

	override suspend fun undeleteAgendaById(entityId: GroupScoped<StoredDocumentIdentifier>): GroupScoped<Agenda> =
		GroupScoped(
			entity = doUndeleteAgendaById(groupId = entityId.groupId, agendaId = entityId.entity.id, rev = entityId.entity.rev),
			groupId = entityId.groupId
		)

	override suspend fun undeleteAgendasByIds(
		entityIds: List<GroupScoped<StoredDocumentIdentifier>>
	): List<GroupScoped<Agenda>> = entityIds.mapUniqueIdentifiablesChunkedByGroup { groupId, entityIds ->
		doUndeleteAgendasByIds(groupId, entityIds)
	}

	override suspend fun purgeAgendaById(entityId: GroupScoped<StoredDocumentIdentifier>) {
		doPurgeAgendaById(groupId = entityId.groupId, agendaId = entityId.entity.id, rev = entityId.entity.rev)
	}

	override suspend fun purgeAgendasByIds(
		entityIds: List<GroupScoped<StoredDocumentIdentifier>>
	): List<GroupScoped<StoredDocumentIdentifier>> = entityIds.mapUniqueIdentifiablesChunkedByGroup { groupId, entityIds ->
		doPurgeAgendasByIds(groupId, entityIds)
	}

	override suspend fun matchAgendasBy(
		groupId: String,
		filter: BaseFilterOptions<Agenda>,
	): List<String> = doMatchAgendasBy(groupId = groupId, filter = filter)

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
