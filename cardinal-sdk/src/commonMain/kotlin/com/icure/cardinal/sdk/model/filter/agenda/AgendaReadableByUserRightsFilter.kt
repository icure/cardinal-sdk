package com.icure.cardinal.sdk.model.filter.agenda

import com.icure.cardinal.sdk.model.Agenda
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 * Filter that matches agendas readable by a user based on their access rights.
 * /
 */
@SerialName("AgendaReadableByUserRightsFilter")
@Serializable
public data class AgendaReadableByUserRightsFilter(
	/**
	 * The identifier of the user whose rights determine readable agendas.
	 */
	public val userId: String,
	/**
	 * Optional description of this filter.
	 */
	override val desc: String?,
) : AbstractFilter<Agenda>
