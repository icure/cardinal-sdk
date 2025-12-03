package com.icure.cardinal.sdk.model.filter.insurance

import com.icure.cardinal.sdk.model.Insurance
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.model.filter.Filter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

@SerialName("AllInsurancesFilter")
@Serializable
public data class AllInsurancesFilter(
	override val desc: String? = null,
) : AbstractFilter<Insurance>, Filter.AllFilter<Insurance>
