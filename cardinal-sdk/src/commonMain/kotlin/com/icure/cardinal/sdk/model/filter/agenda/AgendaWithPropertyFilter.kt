// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
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
data class AgendaWithPropertyFilter(
	/**
	 * The identifier of the property to match.
	 */
	public val propertyId: String,
	/**
	 * Optional description of this filter.
	 */
	override val desc: String? = null,
) : AbstractFilter<Agenda> {
	// region AgendaWithPropertyFilter-AgendaWithPropertyFilter

	// endregion
}
