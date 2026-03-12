package com.icure.cardinal.sdk.model.filter.medicallocation

import com.icure.cardinal.sdk.model.MedicalLocation
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 * Filter that matches all medical locations without any filtering criteria.
 * /
 */
@SerialName("AllMedicalLocationsFilter")
@Serializable
public data class AllMedicalLocationsFilter(
	/**
	 * Optional description of this filter.
	 */
	override val desc: String? = null,
) : AbstractFilter<MedicalLocation>
