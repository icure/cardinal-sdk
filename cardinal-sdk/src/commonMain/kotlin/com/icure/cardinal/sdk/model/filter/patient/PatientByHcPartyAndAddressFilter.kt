package com.icure.cardinal.sdk.model.filter.patient

import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

@SerialName("PatientByHcPartyAndAddressFilter")
@Serializable
public data class PatientByHcPartyAndAddressFilter(
	override val desc: String? = null,
	public val searchString: String? = null,
	public val healthcarePartyId: String? = null,
	public val postalCode: String? = null,
	public val houseNumber: String? = null,
) : AbstractFilter<Patient>
