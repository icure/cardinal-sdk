package com.icure.cardinal.sdk.api.impl

import com.icure.cardinal.sdk.api.CalendarItemTypeApi
import com.icure.cardinal.sdk.api.CalendarItemTypeInGroupApi
import com.icure.cardinal.sdk.api.raw.RawCalendarItemTypeApi
import com.icure.cardinal.sdk.api.raw.successBodyOrNull404
import com.icure.cardinal.sdk.api.raw.successBodyOrThrowRevisionConflict
import com.icure.cardinal.sdk.model.CalendarItemType
import com.icure.cardinal.sdk.model.GroupScoped
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.ListOfIdsAndRev
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
import com.icure.cardinal.sdk.model.toStoredDocumentIdentifier
import com.icure.utils.InternalIcureApi

@OptIn(InternalIcureApi::class)
internal abstract class AbstractCalendarItemTypeApi(
	protected val rawApi: RawCalendarItemTypeApi,
) {

	protected suspend fun doCreateCalendarItemType(groupId: String?, entity: CalendarItemType): CalendarItemType {
		requireIsValidForCreation(entity)
		return if (groupId == null) {
			rawApi.createCalendarItemType(calendarItemTypeDto = entity)
		} else {
			rawApi.createCalendarItemTypeInGroup(groupId = groupId, calendarItemTypeDto = entity)
		}.successBody()
	}

	protected suspend fun doCreateCalendarItemTypes(groupId: String?, entities: List<CalendarItemType>): List<CalendarItemType> =
		skipRequestOnEmptyList(entities) { calendarItemTypes ->
			if (groupId == null) {
				rawApi.createCalendarItemTypes(calendarItemTypeDtos = calendarItemTypes)
			} else {
				rawApi.createCalendarItemTypesInGroup(groupId = groupId, calendarItemTypeDtos = calendarItemTypes)
			}.successBody()
		}

	protected suspend fun doGetCalendarItemType(groupId: String?, entityId: String): CalendarItemType? =
		if (groupId == null) {
			rawApi.getCalendarItemType(calendarItemTypeId = entityId)
		} else {
			rawApi.getCalendarItemTypeInGroup(groupId = groupId, calendarItemTypeId = entityId)
		}.successBodyOrNull404()

	protected suspend fun doGetCalendarItemTypes(groupId: String?, entityIds: List<String>): List<CalendarItemType> =
		skipRequestOnEmptyList(entityIds) { ids ->
			if (groupId == null) {
				rawApi.getCalendarItemTypesByIds(calendarItemTypeIds = ListOfIds(ids))
			} else {
				rawApi.getCalendarItemTypesInGroup(groupId = groupId, calendarItemTypeIds = ListOfIds(ids))
			}.successBody()
		}

	protected suspend fun doModifyCalendarItemType(groupId: String?, entity: CalendarItemType): CalendarItemType {
		requireIsValidForModification(entity)
		return if (groupId == null) {
			rawApi.modifyCalendarItemType(calendarItemTypeDto = entity)
		} else {
			rawApi.modifyCalendarItemTypeInGroup(groupId = groupId, calendarItemTypeDto = entity)
		}.successBodyOrThrowRevisionConflict()
	}

	protected suspend fun doModifyCalendarItemTypes(groupId: String?, entities: List<CalendarItemType>): List<CalendarItemType> =
		skipRequestOnEmptyList(entities) { calendarItemTypes ->
			if (groupId == null) {
				rawApi.modifyCalendarItemTypes(calendarItemTypeDtos = calendarItemTypes)
			} else {
				rawApi.modifyCalendarItemTypesInGroup(groupId = groupId, calendarItemTypeDtos = calendarItemTypes)
			}.successBody()
		}

	protected suspend fun doDeleteCalendarItemType(groupId: String?, entityId: String, rev: String): StoredDocumentIdentifier =
		if (groupId == null) {
			rawApi.deleteCalendarItemType(calendarItemTypeId = entityId, rev = rev)
		} else {
			rawApi.deleteCalendarItemTypeInGroup(groupId = groupId, calendarItemTypeId = entityId, rev = rev)
		}.successBodyOrThrowRevisionConflict().toStoredDocumentIdentifier()

	protected suspend fun doDeleteCalendarItemTypes(groupId: String?, entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier> =
		skipRequestOnEmptyList(entityIds) { ids ->
			if (groupId == null) {
				rawApi.deleteCalendarItemTypesWithRev(calendarItemTypeIds = ListOfIdsAndRev(ids))
			} else {
				rawApi.deleteCalendarItemTypesInGroup(groupId = groupId, calendarItemIdsAndRevs = ListOfIdsAndRev(ids))
			}.successBody().map { it.toStoredDocumentIdentifier() }
		}

	protected suspend fun doUndeleteCalendarItemType(groupId: String?, entityId: String, rev: String): CalendarItemType =
		if (groupId == null) {
			rawApi.undeleteCalendarItemType(calendarItemTypeId = entityId, rev = rev)
		} else {
			rawApi.undeleteCalendarItemTypeInGroup(groupId = groupId, calendarItemTypeId = entityId, rev = rev)
		}.successBodyOrThrowRevisionConflict()

	protected suspend fun doUndeleteCalendarItemTypes(groupId: String?, entityIds: List<StoredDocumentIdentifier>): List<CalendarItemType> =
		skipRequestOnEmptyList(entityIds) { ids ->
			if (groupId == null) {
				rawApi.undeleteCalendarItemTypes(calendarItemTypeIds = ListOfIdsAndRev(ids))
			} else {
				rawApi.undeleteCalendarItemTypesInGroup(groupId = groupId, calendarItemIdsAndRevs = ListOfIdsAndRev(ids))
			}.successBody()
		}

	protected suspend fun doPurgeCalendarItemType(groupId: String?, entityId: String, rev: String) {
		if (groupId == null) {
			rawApi.purgeCalendarItemType(calendarItemTypeId = entityId, rev = rev)
		} else {
			rawApi.purgeCalendarItemTypeInGroup(groupId = groupId, calendarItemTypeId = entityId, rev = rev)
		}.successBodyOrThrowRevisionConflict()
	}

	protected suspend fun doPurgeCalendarItemTypes(groupId: String?, entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier> =
		skipRequestOnEmptyList(entityIds) { ids ->
			if (groupId == null) {
				rawApi.purgeCalendarItemTypesWithRev(calendarItemTypeIds = ListOfIdsAndRev(ids))
			} else {
				rawApi.purgeCalendarItemTypesInGroup(groupId = groupId, calendarItemIdsAndRevs = ListOfIdsAndRev(ids))
			}.successBody().map { it.toStoredDocumentIdentifier() }
		}
}

@InternalIcureApi
internal class CalendarItemTypeApiImpl(
	rawApi: RawCalendarItemTypeApi,
): CalendarItemTypeApi, AbstractCalendarItemTypeApi(rawApi) {

	override val inGroup: CalendarItemTypeInGroupApi = CalendarItemTypeInGroupApiImpl(rawApi)

	override suspend fun createCalendarItemType(calendarItemType: CalendarItemType): CalendarItemType =
		doCreateCalendarItemType(groupId = null, calendarItemType)

	override suspend fun createCalendarItemTypes(calendarItemTypes: List<CalendarItemType>): List<CalendarItemType> {
		requireIsValidForCreation(calendarItemTypes)
		return doCreateCalendarItemTypes(groupId = null, calendarItemTypes)
	}

	override suspend fun getCalendarItemType(calendarItemTypeId: String): CalendarItemType? =
		doGetCalendarItemType(groupId = null, calendarItemTypeId)

	override suspend fun getCalendarItemTypes(calendarItemTypesIds: List<String>): List<CalendarItemType> =
		doGetCalendarItemTypes(groupId = null, calendarItemTypesIds)

	override suspend fun modifyCalendarItemType(calendarItemType: CalendarItemType): CalendarItemType =
		doModifyCalendarItemType(groupId = null, calendarItemType)

	override suspend fun modifyCalendarItemTypes(calendarItemTypes: List<CalendarItemType>): List<CalendarItemType> {
		requireIsValidForModification(calendarItemTypes)
		return doModifyCalendarItemTypes(groupId = null, calendarItemTypes)
	}

	override suspend fun deleteCalendarItemTypeById(entityId: String, rev: String): StoredDocumentIdentifier =
		doDeleteCalendarItemType(groupId = null, entityId = entityId, rev = rev)

	override suspend fun deleteCalendarItemTypeByIds(entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier> =
		doDeleteCalendarItemTypes(groupId = null, entityIds = entityIds)

	override suspend fun undeleteCalendarItemTypeById(entityId: String, rev: String): CalendarItemType =
		doUndeleteCalendarItemType(groupId = null, entityId = entityId, rev = rev)

	override suspend fun undeleteCalendarItemTypeByIds(entityIds: List<StoredDocumentIdentifier>): List<CalendarItemType> =
		doUndeleteCalendarItemTypes(groupId = null, entityIds = entityIds)

	override suspend fun purgeCalendarItemTypeById(entityId: String, rev: String) {
		doPurgeCalendarItemType(groupId = null, entityId = entityId, rev = rev)
	}

	override suspend fun purgeCalendarItemTypeByIds(entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier> =
		doPurgeCalendarItemTypes(groupId = null, entityIds)

	override suspend fun listCalendarItemTypesByAgendaId(agendaId: String): List<CalendarItemType> =
		rawApi.listCalendarItemTypesByAgendaId(agendaId).successBody()
}

@OptIn(InternalIcureApi::class)
internal class CalendarItemTypeInGroupApiImpl(
	rawApi: RawCalendarItemTypeApi
) : CalendarItemTypeInGroupApi, AbstractCalendarItemTypeApi(rawApi) {

	override suspend fun createCalendarItemType(calendarItemType: GroupScoped<CalendarItemType>): GroupScoped<CalendarItemType> =
		groupScopedWith(calendarItemType) { groupId, entity -> doCreateCalendarItemType(groupId, entity) }

	override suspend fun createCalendarItemTypes(calendarItemTypes: List<GroupScoped<CalendarItemType>>): List<GroupScoped<CalendarItemType>> {
		requireIsValidForCreationInGroup(calendarItemTypes)
		return calendarItemTypes.mapUniqueIdentifiablesChunkedByGroup { groupId, chunk ->
			doCreateCalendarItemTypes(groupId, chunk)
		}
	}

	override suspend fun getCalendarItemType(groupId: String, calendarItemTypeId: String): GroupScoped<CalendarItemType>? =
		groupScopedIn(groupId) { doGetCalendarItemType(groupId = groupId, entityId = calendarItemTypeId) }

	override suspend fun getCalendarItemTypes(groupId: String, calendarItemTypesIds: List<String>): List<GroupScoped<CalendarItemType>> =
		groupScopedListIn(groupId) { doGetCalendarItemTypes(groupId = groupId, calendarItemTypesIds) }

	override suspend fun modifyCalendarItemType(calendarItemType: GroupScoped<CalendarItemType>): GroupScoped<CalendarItemType> =
		groupScopedWith(calendarItemType) { groupId, entity -> doModifyCalendarItemType(groupId, entity) }

	override suspend fun modifyCalendarItemTypes(calendarItemTypes: List<GroupScoped<CalendarItemType>>): List<GroupScoped<CalendarItemType>> {
		requireIsValidForModificationInGroup(calendarItemTypes)
		return calendarItemTypes.mapUniqueIdentifiablesChunkedByGroup { groupId, chunk ->
			doModifyCalendarItemTypes(groupId, chunk)
		}
	}

	override suspend fun deleteCalendarItemTypeById(entityId: GroupScoped<StoredDocumentIdentifier>): GroupScoped<StoredDocumentIdentifier> =
		groupScopedWith(entityId) { groupId, entity -> doDeleteCalendarItemType(groupId = groupId, entityId = entity.id, rev = entity.rev) }

	override suspend fun deleteCalendarItemTypeByIds(entityIds: List<GroupScoped<StoredDocumentIdentifier>>): List<GroupScoped<StoredDocumentIdentifier>> =
		entityIds.mapUniqueIdentifiablesChunkedByGroup { groupId, chunk ->
			doDeleteCalendarItemTypes(groupId = groupId, entityIds = chunk)
		}

	override suspend fun undeleteCalendarItemTypeById(entityId: GroupScoped<StoredDocumentIdentifier>): GroupScoped<CalendarItemType> =
		groupScopedWith(entityId) { groupId, entity -> doUndeleteCalendarItemType(groupId = groupId, entityId = entity.id, rev = entity.rev) }

	override suspend fun undeleteCalendarItemTypeByIds(entityIds: List<GroupScoped<StoredDocumentIdentifier>>): List<GroupScoped<CalendarItemType>> =
		entityIds.mapUniqueIdentifiablesChunkedByGroup { groupId, chunk ->
			doUndeleteCalendarItemTypes(groupId = groupId, entityIds = chunk)
		}

	override suspend fun purgeCalendarItemTypeById(entityId: GroupScoped<StoredDocumentIdentifier>) {
		doPurgeCalendarItemType(groupId = entityId.groupId, entityId = entityId.entity.id, rev = entityId.entity.rev)
	}

	override suspend fun purgeCalendarItemTypeByIds(entityIds: List<GroupScoped<StoredDocumentIdentifier>>): List<GroupScoped<StoredDocumentIdentifier>> =
		entityIds.mapUniqueIdentifiablesChunkedByGroup { groupId, chunk ->
			doPurgeCalendarItemTypes(groupId = groupId, entityIds = chunk)
		}

}
