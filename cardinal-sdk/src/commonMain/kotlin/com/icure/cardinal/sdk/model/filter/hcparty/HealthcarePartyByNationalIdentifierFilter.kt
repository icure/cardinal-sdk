package com.icure.cardinal.sdk.model.filter.hcparty

import com.icure.cardinal.sdk.model.HealthcareParty
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.String

@SerialName("HealthcarePartyByNationalIdentifierFilter")
@Serializable
public data class HealthcarePartyByNationalIdentifierFilter(
	public val searchValue: String,
	public val descending: Boolean? = null,
	override val desc: String? = null,
) : AbstractFilter<HealthcareParty>
