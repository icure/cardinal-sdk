package com.icure.cardinal.sdk.model.filter.patient

import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

@SerialName("PatientByHcPartyFilter")
@Serializable
public data class PatientByHcPartyFilter(
	override val desc: String? = null,
	public val healthcarePartyId: String? = null,
) : AbstractFilter<Patient>
