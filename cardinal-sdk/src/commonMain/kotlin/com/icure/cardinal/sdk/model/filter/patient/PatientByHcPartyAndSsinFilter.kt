package com.icure.cardinal.sdk.model.filter.patient

import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

@SerialName("PatientByHcPartyAndSsinFilter")
@Serializable
public data class PatientByHcPartyAndSsinFilter(
	override val desc: String? = null,
	public val ssin: String,
	public val healthcarePartyId: String? = null,
) : AbstractFilter<Patient>
