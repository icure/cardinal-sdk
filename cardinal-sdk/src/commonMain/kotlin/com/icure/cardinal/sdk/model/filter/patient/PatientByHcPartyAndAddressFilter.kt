// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.filter.patient

import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 * Filter that matches patients by healthcare party and address criteria.
 * /
 */
@SerialName("PatientByHcPartyAndAddressFilter")
@Serializable
data class PatientByHcPartyAndAddressFilter(
	/**
	 * Optional description of this filter.
	 */
	override val desc: String? = null,
	/**
	 * The address search string to match.
	 */
	public val searchString: String? = null,
	/**
	 * The identifier of the healthcare party.
	 */
	public val healthcarePartyId: String? = null,
	/**
	 * The postal code to match.
	 */
	public val postalCode: String? = null,
	/**
	 * The house number to match.
	 */
	public val houseNumber: String? = null,
) : AbstractFilter<Patient> {
	// region PatientByHcPartyAndAddressFilter-PatientByHcPartyAndAddressFilter

	// endregion
}
