package com.icure.cardinal.sdk.model.filter.patient

import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 * Filter that matches patients by healthcare party and telecom (phone/email) search string.
 * /
 */
@SerialName("PatientByHcPartyAndTelecomFilter")
@Serializable
public data class PatientByHcPartyAndTelecomFilter(
	/**
	 * Optional description of this filter.
	 */
	override val desc: String? = null,
	/**
	 * The telecom value to search for.
	 */
	public val searchString: String? = null,
	/**
	 * The identifier of the healthcare party.
	 */
	public val healthcarePartyId: String? = null,
) : AbstractFilter<Patient>
