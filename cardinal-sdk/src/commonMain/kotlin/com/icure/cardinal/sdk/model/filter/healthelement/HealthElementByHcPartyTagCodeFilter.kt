package com.icure.cardinal.sdk.model.filter.healthelement

import com.icure.cardinal.sdk.model.HealthElement
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Int
import kotlin.String

@SerialName("HealthElementByHcPartyTagCodeFilter")
@Serializable
public data class HealthElementByHcPartyTagCodeFilter(
	override val desc: String? = null,
	public val healthcarePartyId: String,
	public val codeType: String? = null,
	public val codeCode: String? = null,
	public val tagType: String? = null,
	public val tagCode: String? = null,
	public val status: Int? = null,
) : AbstractFilter<HealthElement>
