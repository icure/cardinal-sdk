package com.icure.cardinal.sdk.model.filter.insurance

import com.icure.cardinal.sdk.model.Insurance
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.model.filter.Filter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@SerialName("AllInsurancesFilter")
@Serializable
data class AllInsurancesFilter(
	override val desc: String? = null,
) : AbstractFilter<Insurance>, Filter.AllFilter<Insurance> {
	// region AllInsurancesFilter-AllInsurancesFilter

	// endregion
}
