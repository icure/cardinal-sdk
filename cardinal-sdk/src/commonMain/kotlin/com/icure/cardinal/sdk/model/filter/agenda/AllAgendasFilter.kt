package com.icure.cardinal.sdk.model.filter.agenda

import com.icure.cardinal.sdk.model.Agenda
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 * Filter that matches all agendas without any filtering criteria.
 * /
 */
@SerialName("AllAgendasFilter")
@Serializable
public data class AllAgendasFilter(
	/**
	 * Optional description of this filter.
	 */
	override val desc: String? = null,
) : AbstractFilter<Agenda>
