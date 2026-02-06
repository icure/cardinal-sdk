package com.icure.cardinal.sdk.model.filter.agenda

import com.icure.cardinal.sdk.model.Agenda
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

@SerialName("AgendaReadableByUserRightsFilter")
@Serializable
public data class AgendaReadableByUserRightsFilter(
	public val userId: String,
	override val desc: String?,
) : AbstractFilter<Agenda>
