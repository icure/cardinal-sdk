package com.icure.cardinal.sdk.model.filter.patient

import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.List

/**
 * Filter that matches patients by healthcare party and a list of SSINs.
 * /
 */
@SerialName("PatientByHcPartyAndSsinsFilter")
@Serializable
public data class PatientByHcPartyAndSsinsFilter(
	/**
	 * Optional description of this filter.
	 */
	override val desc: String? = null,
	/**
	 * The list of social security identification numbers to match.
	 */
	public val ssins: List<String>? = null,
	/**
	 * The identifier of the healthcare party.
	 */
	public val healthcarePartyId: String? = null,
) : AbstractFilter<Patient>
