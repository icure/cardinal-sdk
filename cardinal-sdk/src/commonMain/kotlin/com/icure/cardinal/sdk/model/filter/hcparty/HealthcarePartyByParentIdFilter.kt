package com.icure.cardinal.sdk.model.filter.hcparty

import com.icure.cardinal.sdk.model.HealthcareParty
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

@SerialName("HealthcarePartyByParentIdFilter")
@Serializable
public data class HealthcarePartyByParentIdFilter(
	public val parentId: String,
	override val desc: String? = null,
) : AbstractFilter<HealthcareParty>
