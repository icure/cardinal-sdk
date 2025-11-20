package com.icure.cardinal.sdk.model.filter.agenda

import com.icure.cardinal.sdk.model.Agenda
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

@SerialName("AllAgendasFilter")
@Serializable
public data class AllAgendasFilter(
	override val desc: String? = null,
) : AbstractFilter<Agenda>
