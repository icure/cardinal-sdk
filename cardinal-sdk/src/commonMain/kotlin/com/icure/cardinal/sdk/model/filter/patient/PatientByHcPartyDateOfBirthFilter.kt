package com.icure.cardinal.sdk.model.filter.patient

import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Int
import kotlin.String

@SerialName("PatientByHcPartyDateOfBirthFilter")
@Serializable
public data class PatientByHcPartyDateOfBirthFilter(
	override val desc: String? = null,
	public val dateOfBirth: Int,
	public val healthcarePartyId: String? = null,
) : AbstractFilter<Patient>
