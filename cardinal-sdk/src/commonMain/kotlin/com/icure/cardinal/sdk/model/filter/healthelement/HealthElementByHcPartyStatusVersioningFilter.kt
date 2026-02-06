package com.icure.cardinal.sdk.model.filter.healthelement

import com.icure.cardinal.sdk.model.HealthElement
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.model.filter.VersionFiltering
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Int
import kotlin.String

@SerialName("HealthElementByHcPartyStatusVersioningFilter")
@Serializable
public data class HealthElementByHcPartyStatusVersioningFilter(
	override val desc: String? = null,
	public val hcPartyId: String,
	public val status: Int,
	public val versionFiltering: VersionFiltering? = null,
) : AbstractFilter<HealthElement>
