package com.icure.cardinal.sdk.model.filter.agenda

import com.icure.cardinal.sdk.model.Agenda
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 * Filter that matches agendas readable by a specific user.
 * /
 */
@SerialName("AgendaReadableByUserIdFilter")
@Serializable
public data class AgendaReadableByUserIdFilter(
	/**
	 * The identifier of the user who has read access to the agendas.
	 */
	public val userId: String,
	/**
	 * Optional description of this filter.
	 */
	override val desc: String?,
) : AbstractFilter<Agenda>
