package com.icure.cardinal.sdk.model.filter.agenda

import com.icure.cardinal.sdk.model.Agenda
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

@SerialName("AgendaByUserIdFilter")
@Serializable
public data class AgendaByUserIdFilter(
	public val userId: String,
	override val desc: String?,
) : AbstractFilter<Agenda>
