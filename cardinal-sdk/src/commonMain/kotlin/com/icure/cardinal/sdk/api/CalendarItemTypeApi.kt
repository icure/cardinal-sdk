package com.icure.cardinal.sdk.api

import com.icure.cardinal.sdk.model.CalendarItemType
import com.icure.cardinal.sdk.model.GroupScoped
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
import com.icure.cardinal.sdk.model.conflicts.ConflictResolutionRequest
import com.icure.cardinal.sdk.model.conflicts.ConflictResolutionResult
import com.icure.cardinal.sdk.model.conflicts.ConflictResolutionStrategy
import com.icure.cardinal.sdk.model.conflicts.MergeResult
import com.icure.cardinal.sdk.model.toStoredDocumentIdentifier
import com.icure.cardinal.sdk.utils.DefaultValue

interface CalendarItemTypeApi {

	val inGroup: CalendarItemTypeInGroupApi

	suspend fun createCalendarItemType(calendarItemType: CalendarItemType): CalendarItemType
	suspend fun createCalendarItemTypes(calendarItemTypes: List<CalendarItemType>): List<CalendarItemType>

	suspend fun getCalendarItemType(calendarItemTypeId: String): CalendarItemType?
	suspend fun getCalendarItemTypes(calendarItemTypesIds: List<String>): List<CalendarItemType>

	suspend fun modifyCalendarItemType(calendarItemType: CalendarItemType): CalendarItemType
	suspend fun modifyCalendarItemTypes(calendarItemTypes: List<CalendarItemType>): List<CalendarItemType>

	suspend fun deleteCalendarItemTypeById(entityId: String, rev: String): StoredDocumentIdentifier
	suspend fun deleteCalendarItemTypeByIds(entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier>

	suspend fun deleteCalendarItemType(calendarItemType: CalendarItemType): StoredDocumentIdentifier =
		deleteCalendarItemTypeById(entityId = calendarItemType.id, rev = requireNotNull(calendarItemType.rev) { "Can't delete a calendarItemType that has no rev" })
	suspend fun deleteCalendarItemTypes(calendarItemTypes: List<CalendarItemType>): List<StoredDocumentIdentifier> =
		deleteCalendarItemTypeByIds(calendarItemTypes.map { it.toStoredDocumentIdentifier() })

	suspend fun undeleteCalendarItemTypeById(entityId: String, rev: String): CalendarItemType
	suspend fun undeleteCalendarItemTypeByIds(entityIds: List<StoredDocumentIdentifier>): List<CalendarItemType>

	suspend fun undeleteCalendarItemType(calendarItemType: CalendarItemType): CalendarItemType =
		undeleteCalendarItemTypeById(entityId = calendarItemType.id, rev = requireNotNull(calendarItemType.rev) { "Can't undelete a calendarItemType that has no rev" })
	suspend fun undeleteCalendarItemTypes(calendarItemTypes: List<CalendarItemType>): List<CalendarItemType> =
		undeleteCalendarItemTypeByIds(calendarItemTypes.map { it.toStoredDocumentIdentifier() })

	suspend fun purgeCalendarItemTypeById(entityId: String, rev: String)
	suspend fun purgeCalendarItemTypeByIds(entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier>

	suspend fun purgeCalendarItemType(calendarItemType: CalendarItemType) {
		purgeCalendarItemTypeById(entityId = calendarItemType.id, rev = requireNotNull(calendarItemType.rev) { "Can't purge a calendarItemType that has no rev" })
	}
	suspend fun purgeCalendarItemTypes(calendarItemTypes: List<CalendarItemType>): List<StoredDocumentIdentifier> =
		purgeCalendarItemTypeByIds(calendarItemTypes.map { it.toStoredDocumentIdentifier() })

	suspend fun listCalendarItemTypesByAgendaId(agendaId: String): List<CalendarItemType>

	/**
	 * Get the ids of all the calendar item types that have conflicting revisions.
	 * Requires the permission to manually resolve conflicts.
	 * @return the ids of the calendar item types with conflicts.
	 */
	suspend fun getConflictingEntitiesIds(): List<String>

	/**
	 * Get the conflicting revisions of a calendar item type.
	 * Requires read access to all the conflicting revisions of the calendar item type.
	 * If the calendar item type has too many conflicts, only part of them are returned.
	 * @param entityId the id of a calendar item type with conflicts, for example obtained through [getConflictingEntitiesIds].
	 * @return the conflicting revisions of the calendar item type.
	 */
	suspend fun getConflictsForEntity(entityId: String): List<CalendarItemType>

	/**
	 * Resolves the conflicts of a calendar item type by declaring the version that should be kept and the conflicting revisions that
	 * should be purged.
	 * Requires the permission to manually resolve conflicts and write access to all the conflicting revisions of the calendar item type.
	 * @param request the calendar item type to keep and the conflicting revisions to purge.
	 * @return the updated calendar item type and the revisions that are still in conflict.
	 */
	suspend fun declareConflictWinner(request: ConflictResolutionRequest<CalendarItemType>): ConflictResolutionResult<CalendarItemType>

	/**
	 * Automatically resolves the conflicts of the calendar item types with the provided ids.
	 * Requires the permission to automatically resolve conflicts.
	 * @param entityIds ids of calendar item types with conflicts, for example obtained through [getConflictingEntitiesIds].
	 * @param strategy the strategy to use to resolve the conflicts. If null the backend uses its default strategy.
	 * @return the outcome of the conflict resolution for each calendar item type.
	 */
	suspend fun autoSolveConflicts(
		entityIds: List<String>,
		@DefaultValue("null")
		strategy: ConflictResolutionStrategy? = null,
	): List<MergeResult>
}

interface CalendarItemTypeInGroupApi {

	suspend fun createCalendarItemType(calendarItemType: GroupScoped<CalendarItemType>): GroupScoped<CalendarItemType>
	suspend fun createCalendarItemTypes(calendarItemTypes: List<GroupScoped<CalendarItemType>>): List<GroupScoped<CalendarItemType>>

	suspend fun getCalendarItemType(groupId: String, calendarItemTypeId: String): GroupScoped<CalendarItemType>?
	suspend fun getCalendarItemTypes(groupId: String, calendarItemTypesIds: List<String>): List<GroupScoped<CalendarItemType>>

	suspend fun modifyCalendarItemType(calendarItemType: GroupScoped<CalendarItemType>): GroupScoped<CalendarItemType>
	suspend fun modifyCalendarItemTypes(calendarItemTypes: List<GroupScoped<CalendarItemType>>): List<GroupScoped<CalendarItemType>>

	suspend fun deleteCalendarItemTypeById(entityId: GroupScoped<StoredDocumentIdentifier>): GroupScoped<StoredDocumentIdentifier>
	suspend fun deleteCalendarItemTypeByIds(entityIds: List<GroupScoped<StoredDocumentIdentifier>>): List<GroupScoped<StoredDocumentIdentifier>>

	suspend fun deleteCalendarItemType(calendarItemType: GroupScoped<CalendarItemType>): GroupScoped<StoredDocumentIdentifier> =
		deleteCalendarItemTypeById(calendarItemType.toStoredDocumentIdentifier())
	suspend fun deleteCalendarItemTypes(calendarItemTypes: List<GroupScoped<CalendarItemType>>): List<GroupScoped<StoredDocumentIdentifier>> =
		deleteCalendarItemTypeByIds(calendarItemTypes.map { it.toStoredDocumentIdentifier() })

	suspend fun undeleteCalendarItemTypeById(entityId: GroupScoped<StoredDocumentIdentifier>): GroupScoped<CalendarItemType>
	suspend fun undeleteCalendarItemTypeByIds(entityIds: List<GroupScoped<StoredDocumentIdentifier>>): List<GroupScoped<CalendarItemType>>

	suspend fun undeleteCalendarItemType(calendarItemType: GroupScoped<CalendarItemType>): GroupScoped<CalendarItemType> =
		undeleteCalendarItemTypeById(calendarItemType.toStoredDocumentIdentifier())
	suspend fun undeleteCalendarItemTypes(calendarItemTypes: List<GroupScoped<CalendarItemType>>): List<GroupScoped<CalendarItemType>> =
		undeleteCalendarItemTypeByIds(calendarItemTypes.map { it.toStoredDocumentIdentifier() })

	suspend fun purgeCalendarItemTypeById(entityId: GroupScoped<StoredDocumentIdentifier>)
	suspend fun purgeCalendarItemTypeByIds(entityIds: List<GroupScoped<StoredDocumentIdentifier>>): List<GroupScoped<StoredDocumentIdentifier>>

	suspend fun purgeCalendarItemType(calendarItemType: GroupScoped<CalendarItemType>) {
		purgeCalendarItemTypeById(calendarItemType.toStoredDocumentIdentifier())
	}
	suspend fun purgeCalendarItemTypes(calendarItemTypes: List<GroupScoped<CalendarItemType>>): List<GroupScoped<StoredDocumentIdentifier>> =
		purgeCalendarItemTypeByIds(calendarItemTypes.map { it.toStoredDocumentIdentifier() })

	/**
	 * In-group version of [CalendarItemTypeApi.getConflictingEntitiesIds].
	 */
	suspend fun getConflictingEntitiesIds(groupId: String): List<String>

	/**
	 * In-group version of [CalendarItemTypeApi.getConflictsForEntity].
	 */
	suspend fun getConflictsForEntity(groupId: String, entityId: String): List<GroupScoped<CalendarItemType>>

	/**
	 * In-group version of [CalendarItemTypeApi.declareConflictWinner].
	 */
	suspend fun declareConflictWinner(
		groupId: String,
		request: ConflictResolutionRequest<CalendarItemType>,
	): ConflictResolutionResult<CalendarItemType>

	/**
	 * In-group version of [CalendarItemTypeApi.autoSolveConflicts].
	 */
	suspend fun autoSolveConflicts(
		groupId: String,
		entityIds: List<String>,
		@DefaultValue("null")
		strategy: ConflictResolutionStrategy? = null,
	): List<MergeResult>
}
