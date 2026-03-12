package com.icure.cardinal.sdk.model.filter.patient

import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Int
import kotlin.String

/**
 * Filter that matches patients by healthcare party and date of birth range.
 * /
 */
@SerialName("PatientByHcPartyDateOfBirthBetweenFilter")
@Serializable
public data class PatientByHcPartyDateOfBirthBetweenFilter(
	/**
	 * Optional description of this filter.
	 */
	override val desc: String? = null,
	/**
	 * The minimum date of birth (inclusive, in YYYYMMDD format).
	 */
	public val minDateOfBirth: Int? = null,
	/**
	 * The maximum date of birth (inclusive, in YYYYMMDD format).
	 */
	public val maxDateOfBirth: Int? = null,
	/**
	 * The identifier of the healthcare party.
	 */
	public val healthcarePartyId: String? = null,
) : AbstractFilter<Patient>
