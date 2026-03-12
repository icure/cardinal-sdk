package com.icure.cardinal.sdk.model.filter.agenda

import com.icure.cardinal.sdk.model.Agenda
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 * Filter that matches agendas owned by a specific user.
 * /
 */
@SerialName("AgendaByUserIdFilter")
@Serializable
public data class AgendaByUserIdFilter(
	/**
	 * The identifier of the user whose agendas to retrieve.
	 */
	public val userId: String,
	/**
	 * Optional description of this filter.
	 */
	override val desc: String?,
) : AbstractFilter<Agenda>
