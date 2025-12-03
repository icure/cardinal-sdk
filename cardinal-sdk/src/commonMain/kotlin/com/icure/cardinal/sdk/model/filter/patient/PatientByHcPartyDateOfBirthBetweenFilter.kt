package com.icure.cardinal.sdk.model.filter.patient

import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Int
import kotlin.String

@SerialName("PatientByHcPartyDateOfBirthBetweenFilter")
@Serializable
public data class PatientByHcPartyDateOfBirthBetweenFilter(
	override val desc: String? = null,
	public val minDateOfBirth: Int? = null,
	public val maxDateOfBirth: Int? = null,
	public val healthcarePartyId: String? = null,
) : AbstractFilter<Patient>
