package com.icure.cardinal.sdk.model.filter.agenda

import com.icure.cardinal.sdk.model.Agenda
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

@SerialName("AgendaWithPropertyFilter")
@Serializable
public data class AgendaWithPropertyFilter(
	public val propertyId: String,
	override val desc: String? = null,
) : AbstractFilter<Agenda>
