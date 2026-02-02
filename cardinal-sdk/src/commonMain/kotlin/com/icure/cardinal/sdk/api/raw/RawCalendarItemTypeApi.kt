package com.icure.cardinal.sdk.api.raw

import com.icure.cardinal.sdk.model.CalendarItemType
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.ListOfIdsAndRev
import com.icure.cardinal.sdk.model.PaginatedList
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.utils.InternalIcureApi
import kotlin.Int
import kotlin.String
import kotlin.collections.List

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
public interface RawCalendarItemTypeApi {
	// region common endpoints

	suspend fun getCalendarItemTypes(
		startDocumentId: String? = null,
		limit: Int? = null,
	): HttpResponse<PaginatedList<CalendarItemType>>

	suspend fun getCalendarItemTypesByIds(calendarItemTypeIds: ListOfIds): HttpResponse<List<CalendarItemType>>

	suspend fun listCalendarItemTypesByAgendaId(agendaId: String): HttpResponse<List<CalendarItemType>>

	suspend fun getCalendarItemTypesIncludingDeleted(
		startKey: String? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
	): HttpResponse<PaginatedList<CalendarItemType>>

	suspend fun createCalendarItemType(calendarItemTypeDto: CalendarItemType): HttpResponse<CalendarItemType>

	suspend fun createCalendarItemTypes(calendarItemTypeDtos: List<CalendarItemType>): HttpResponse<List<CalendarItemType>>

	suspend fun deleteCalendarItemTypes(calendarItemTypeIds: ListOfIds): HttpResponse<List<DocIdentifier>>

	suspend fun deleteCalendarItemTypesWithRev(calendarItemTypeIds: ListOfIdsAndRev): HttpResponse<List<DocIdentifier>>

	suspend fun deleteCalendarItemType(
		calendarItemTypeId: String,
		rev: String,
	): HttpResponse<DocIdentifier>

	suspend fun undeleteCalendarItemType(
		calendarItemTypeId: String,
		rev: String,
	): HttpResponse<CalendarItemType>

	suspend fun undeleteCalendarItemTypes(calendarItemTypeIds: ListOfIdsAndRev): HttpResponse<List<CalendarItemType>>

	suspend fun purgeCalendarItemType(
		calendarItemTypeId: String,
		rev: String,
	): HttpResponse<DocIdentifier>

	suspend fun purgeCalendarItemTypesWithRev(calendarItemTypeIds: ListOfIdsAndRev): HttpResponse<List<DocIdentifier>>

	suspend fun getCalendarItemType(calendarItemTypeId: String): HttpResponse<CalendarItemType>

	suspend fun modifyCalendarItemType(calendarItemTypeDto: CalendarItemType): HttpResponse<CalendarItemType>

	suspend fun modifyCalendarItemTypes(calendarItemTypeDtos: List<CalendarItemType>): HttpResponse<List<CalendarItemType>>
	// endregion

	// region cloud endpoints

	suspend fun createCalendarItemTypeInGroup(
		groupId: String,
		calendarItemTypeDto: CalendarItemType,
	): HttpResponse<CalendarItemType>

	suspend fun createCalendarItemTypesInGroup(
		groupId: String,
		calendarItemTypeDtos: List<CalendarItemType>,
	): HttpResponse<List<CalendarItemType>>

	suspend fun modifyCalendarItemTypeInGroup(
		groupId: String,
		calendarItemTypeDto: CalendarItemType,
	): HttpResponse<CalendarItemType>

	suspend fun modifyCalendarItemTypesInGroup(
		groupId: String,
		calendarItemTypeDtos: List<CalendarItemType>,
	): HttpResponse<List<CalendarItemType>>

	suspend fun getCalendarItemTypeInGroup(
		groupId: String,
		calendarItemTypeId: String,
	): HttpResponse<CalendarItemType>

	suspend fun getCalendarItemTypesInGroup(
		groupId: String,
		calendarItemTypeIds: ListOfIds,
	): HttpResponse<List<CalendarItemType>>

	suspend fun deleteCalendarItemTypesInGroup(
		groupId: String,
		calendarItemIdsAndRevs: ListOfIdsAndRev,
	): HttpResponse<List<DocIdentifier>>

	suspend fun deleteCalendarItemTypeInGroup(
		groupId: String,
		calendarItemTypeId: String,
		rev: String,
	): HttpResponse<DocIdentifier>

	suspend fun undeleteCalendarItemTypesInGroup(
		groupId: String,
		calendarItemIdsAndRevs: ListOfIdsAndRev,
	): HttpResponse<List<CalendarItemType>>

	suspend fun undeleteCalendarItemTypeInGroup(
		groupId: String,
		calendarItemTypeId: String,
		rev: String,
	): HttpResponse<CalendarItemType>

	suspend fun purgeCalendarItemTypesInGroup(
		groupId: String,
		calendarItemIdsAndRevs: ListOfIdsAndRev,
	): HttpResponse<List<DocIdentifier>>

	suspend fun purgeCalendarItemTypeInGroup(
		groupId: String,
		calendarItemTypeId: String,
		rev: String,
	): HttpResponse<DocIdentifier>
	// endregion
}
