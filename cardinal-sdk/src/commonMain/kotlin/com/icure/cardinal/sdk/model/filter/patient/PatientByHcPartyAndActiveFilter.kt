package com.icure.cardinal.sdk.model.filter.patient

import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.String

@SerialName("PatientByHcPartyAndActiveFilter")
@Serializable
public data class PatientByHcPartyAndActiveFilter(
	override val desc: String? = null,
	@DefaultValue("false")
	public val active: Boolean = false,
	public val healthcarePartyId: String? = null,
) : AbstractFilter<Patient>
