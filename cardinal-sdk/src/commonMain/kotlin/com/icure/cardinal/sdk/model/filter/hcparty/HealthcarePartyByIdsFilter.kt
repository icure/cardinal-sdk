package com.icure.cardinal.sdk.model.filter.hcparty

import com.icure.cardinal.sdk.model.HealthcareParty
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.model.filter.Filter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.Set

@SerialName("HealthcarePartyByIdsFilter")
@Serializable
public data class HealthcarePartyByIdsFilter(
	override val ids: Set<String>,
	override val desc: String? = null,
) : AbstractFilter<HealthcareParty>, Filter.IdsFilter<String, HealthcareParty>
