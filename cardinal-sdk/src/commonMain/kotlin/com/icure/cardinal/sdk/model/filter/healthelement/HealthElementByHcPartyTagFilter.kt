package com.icure.cardinal.sdk.model.filter.healthelement

import com.icure.cardinal.sdk.model.HealthElement
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.model.filter.VersionFiltering
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Long
import kotlin.String

@SerialName("HealthElementByHcPartyTagFilter")
@Serializable
public data class HealthElementByHcPartyTagFilter(
	override val desc: String? = null,
	public val healthcarePartyId: String,
	public val tagType: String,
	public val tagCode: String,
	public val startOfHealthElementDate: Long? = null,
	public val endOfHealthElementDate: Long? = null,
	public val versionFiltering: VersionFiltering? = null,
) : AbstractFilter<HealthElement>
