// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.filter.patient

import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.model.filter.Filter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.Set

/**
 * Filter that matches patients by their unique identifiers.
 * /
 */
@SerialName("PatientByIdsFilter")
@Serializable
data class PatientByIdsFilter(
	/**
	 * The set of patient identifiers to match.
	 */
	override val ids: Set<String>,
	/**
	 * Optional description of this filter.
	 */
	override val desc: String? = null,
) : AbstractFilter<Patient>, Filter.IdsFilter<String, Patient> {
	// region PatientByIdsFilter-PatientByIdsFilter

	// endregion
}
