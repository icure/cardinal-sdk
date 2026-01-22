package com.icure.cardinal.sdk.api

import com.icure.cardinal.sdk.model.CalendarItemType
import com.icure.cardinal.sdk.model.GroupScoped
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
import com.icure.cardinal.sdk.model.toStoredDocumentIdentifier

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

}
