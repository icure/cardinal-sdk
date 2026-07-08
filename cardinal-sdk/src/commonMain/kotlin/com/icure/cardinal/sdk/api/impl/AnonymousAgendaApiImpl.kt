package com.icure.cardinal.sdk.api.impl

import com.icure.cardinal.sdk.api.AnonymousAgendaApi
import com.icure.cardinal.sdk.api.raw.RawAnonymousApi
import com.icure.cardinal.sdk.model.PublicAgendasAndCalendarItemTypes
import com.icure.utils.InternalIcureApi

@OptIn(InternalIcureApi::class)
class AnonymousAgendaApiImpl(
	val raw: RawAnonymousApi
): AnonymousAgendaApi {
	override suspend fun listAnonymousAgendaAndAppointmentTypes(
		groupId: String,
		propertyId: String,
		propertyValue: String,
	): PublicAgendasAndCalendarItemTypes = raw.listAnonymousAgendaAndAppointmentTypes(
		groupId = groupId,
		propertyId = propertyId,
		propertyValue = propertyValue
	).successBody()

	override suspend fun listAnonymousAvailabilities(
		groupId: String,
		agendaId: String,
		calendarItemTypeId: String,
		startDate: Long,
		endDate: Long,
		limit: Int?
	): List<Long> = raw.listAnonymousAvailabilities(
		groupId = groupId,
		agendaId = agendaId,
		calendarItemTypeId = calendarItemTypeId,
		startDate = startDate,
		endDate = endDate,
		limit = limit,
	).successBody()
}