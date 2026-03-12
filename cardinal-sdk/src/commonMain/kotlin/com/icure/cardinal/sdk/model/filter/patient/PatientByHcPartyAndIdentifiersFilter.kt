// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.filter.patient

import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.base.Identifier
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.List

/**
 * Filter that matches patients by healthcare party and a list of identifiers.
 * /
 */
@SerialName("PatientByHcPartyAndIdentifiersFilter")
@Serializable
data class PatientByHcPartyAndIdentifiersFilter(
	/**
	 * The identifier of the healthcare party.
	 */
	public val healthcarePartyId: String? = null,
	/**
	 * The list of identifiers to match.
	 */
	@param:DefaultValue("emptyList()")
	public val identifiers: List<Identifier> = emptyList(),
	/**
	 * Optional description of this filter.
	 */
	override val desc: String? = null,
) : AbstractFilter<Patient> {
	// region PatientByHcPartyAndIdentifiersFilter-PatientByHcPartyAndIdentifiersFilter

	// endregion
}
