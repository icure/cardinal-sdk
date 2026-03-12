// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.collections.List

/**
 *
 *  DTO containing publicly accessible agendas and their associated calendar item types,
 *  used for public appointment booking.
 */
@Serializable
data class PublicAgendasAndCalendarItemTypes(
	/**
	 * The list of publicly available agendas.
	 */
	@param:DefaultValue("emptyList()")
	public val agendas: List<Agenda> = emptyList(),
	/**
	 * The list of calendar item types associated with the public agendas.
	 */
	@param:DefaultValue("emptyList()")
	public val calendarItemTypes: List<CalendarItemType> = emptyList(),
) {
	// region PublicAgendasAndCalendarItemTypes-PublicAgendasAndCalendarItemTypes

	// endregion
}
