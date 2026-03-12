package com.icure.cardinal.sdk.model.filter.agenda

import com.icure.cardinal.sdk.model.Agenda
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 * Filter that matches agendas that have a specific property.
 * /
 */
@SerialName("AgendaWithPropertyFilter")
@Serializable
public data class AgendaWithPropertyFilter(
	/**
	 * The identifier of the property to match.
	 */
	public val propertyId: String,
	/**
	 * Optional description of this filter.
	 */
	override val desc: String? = null,
) : AbstractFilter<Agenda>
