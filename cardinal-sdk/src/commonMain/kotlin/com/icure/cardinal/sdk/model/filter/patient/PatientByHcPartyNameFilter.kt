package com.icure.cardinal.sdk.model.filter.patient

import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

@SerialName("PatientByHcPartyNameFilter")
@Serializable
public data class PatientByHcPartyNameFilter(
	override val desc: String? = null,
	public val name: String? = null,
	public val healthcarePartyId: String? = null,
) : AbstractFilter<Patient>
