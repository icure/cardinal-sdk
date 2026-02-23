package com.icure.cardinal.sdk.api.raw

import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.ListOfIdsAndRev
import com.icure.cardinal.sdk.model.TimeTable
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.utils.InternalIcureApi
import kotlin.Long
import kotlin.String
import kotlin.collections.List

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
public interface RawTimeTableApi {
	// region common endpoints

	suspend fun createTimeTable(timeTableDto: TimeTable): HttpResponse<TimeTable>

	suspend fun deleteTimeTables(timeTableIds: ListOfIds): HttpResponse<List<DocIdentifier>>

	suspend fun deleteTimeTablesWithRev(timeTableIds: ListOfIdsAndRev): HttpResponse<List<DocIdentifier>>

	suspend fun deleteTimeTable(
		timeTableId: String,
		rev: String? = null,
	): HttpResponse<DocIdentifier>

	suspend fun undeleteTimeTable(
		timeTableId: String,
		rev: String,
	): HttpResponse<TimeTable>

	suspend fun purgeTimeTable(
		timeTableId: String,
		rev: String,
	): HttpResponse<DocIdentifier>

	suspend fun getTimeTable(timeTableId: String): HttpResponse<TimeTable>

	suspend fun getTimeTables(timeTableIds: ListOfIds): HttpResponse<List<TimeTable>>

	suspend fun modifyTimeTable(timeTableDto: TimeTable): HttpResponse<TimeTable>

	suspend fun getTimeTablesByPeriodAndAgendaId(
		startDate: Long,
		endDate: Long,
		agendaId: String,
	): HttpResponse<List<TimeTable>>

	suspend fun getTimeTablesByAgendaId(agendaId: String): HttpResponse<List<TimeTable>>

	suspend fun matchTimeTablesBy(filter: AbstractFilter<TimeTable>): HttpResponse<List<String>>
	// endregion
}
