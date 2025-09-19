package com.icure.cardinal.sdk.model.filter.agenda

import com.icure.cardinal.sdk.model.Agenda
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

@SerialName("AgendaReadableByUserIdFilter")
@Serializable
public data class AgendaReadableByUserIdFilter(
	public val userId: String,
	override val desc: String?,
) : AbstractFilter<Agenda>
