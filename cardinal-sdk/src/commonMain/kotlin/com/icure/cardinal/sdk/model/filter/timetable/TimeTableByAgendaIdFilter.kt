package com.icure.cardinal.sdk.model.filter.timetable

import com.icure.cardinal.sdk.model.TimeTable
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@SerialName("TimeTableByAgendaIdFilter")
@Serializable
data class TimeTableByAgendaIdFilter(
	agendaId: String,
	desc: String? = null,
) : AbstractFilter<TimeTable> {
	// region TimeTableByAgendaIdFilter-TimeTableByAgendaIdFilter

	// endregion
}
