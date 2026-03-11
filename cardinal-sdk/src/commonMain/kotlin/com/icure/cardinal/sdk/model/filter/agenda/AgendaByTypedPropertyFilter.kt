package com.icure.cardinal.sdk.model.filter.agenda

import com.icure.cardinal.sdk.model.Agenda
import com.icure.cardinal.sdk.model.DecryptedPropertyStub
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 * Filter that matches agendas having a specific typed property.
 * /
 */
@SerialName("AgendaByTypedPropertyFilter")
@Serializable
public data class AgendaByTypedPropertyFilter(
	/**
	 * The property stub to match against agenda properties.
	 */
	public val `property`: DecryptedPropertyStub,
	/**
	 * Optional description of this filter.
	 */
	override val desc: String?,
) : AbstractFilter<Agenda>
