package com.icure.cardinal.sdk.model.filter.agenda

import com.icure.cardinal.sdk.model.Agenda
import com.icure.cardinal.sdk.model.DecryptedPropertyStub
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

@SerialName("AgendaByTypedPropertyFilter")
@Serializable
public data class AgendaByTypedPropertyFilter(
	public val `property`: DecryptedPropertyStub,
	override val desc: String?,
) : AbstractFilter<Agenda>
