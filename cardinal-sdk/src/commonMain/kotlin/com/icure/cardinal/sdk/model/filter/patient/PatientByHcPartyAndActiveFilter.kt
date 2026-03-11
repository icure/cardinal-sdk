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
public data class PatientByHcPartyAndActiveFilter(
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
) : AbstractFilter<Patient>
