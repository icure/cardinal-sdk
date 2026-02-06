package com.icure.cardinal.sdk.model.filter.healthelement

import com.icure.cardinal.sdk.model.HealthElement
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.model.filter.VersionFiltering
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Long
import kotlin.String

@SerialName("HealthElementByHcPartyCodeFilter")
@Serializable
public data class HealthElementByHcPartyCodeFilter(
	override val desc: String? = null,
	public val healthcarePartyId: String,
	public val codeType: String,
	public val codeCode: String,
	public val startOfHealthElementDate: Long? = null,
	public val endOfHealthElementDate: Long? = null,
	public val versionFiltering: VersionFiltering? = null,
) : AbstractFilter<HealthElement>
