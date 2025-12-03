package com.icure.cardinal.sdk.model.filter.hcparty

import com.icure.cardinal.sdk.model.HealthcareParty
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.model.filter.Filter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

@SerialName("AllHealthcarePartiesFilter")
@Serializable
public data class AllHealthcarePartiesFilter(
	override val desc: String? = null,
) : AbstractFilter<HealthcareParty>, Filter.AllFilter<HealthcareParty>
