// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.filter.patient

import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.String

/**
 * Filter that matches patients by healthcare party and active status.
 * /
 */
@SerialName("PatientByHcPartyAndActiveFilter")
@Serializable
data class PatientByHcPartyAndActiveFilter(
	/**
	 * Optional description of this filter.
	 */
	override val desc: String? = null,
	/**
	 * Whether to match active or inactive patients.
	 */
	@param:DefaultValue("false")
	public val active: Boolean = false,
	/**
	 * The identifier of the healthcare party.
	 */
	public val healthcarePartyId: String? = null,
) : AbstractFilter<Patient> {
	// region PatientByHcPartyAndActiveFilter-PatientByHcPartyAndActiveFilter

	// endregion
}
