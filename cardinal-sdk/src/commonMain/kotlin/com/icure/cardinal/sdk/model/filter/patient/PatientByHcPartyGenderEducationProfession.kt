package com.icure.cardinal.sdk.model.filter.patient

import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.embed.Gender
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

@SerialName("PatientByHcPartyGenderEducationProfession")
@Serializable
public data class PatientByHcPartyGenderEducationProfession(
	override val desc: String? = null,
	public val healthcarePartyId: String? = null,
	public val gender: Gender? = null,
	public val education: String? = null,
	public val profession: String? = null,
) : AbstractFilter<Patient>
