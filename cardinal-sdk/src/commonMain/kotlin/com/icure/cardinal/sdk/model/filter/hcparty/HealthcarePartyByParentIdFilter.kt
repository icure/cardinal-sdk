package com.icure.cardinal.sdk.model.filter.hcparty

import com.icure.cardinal.sdk.model.HealthcareParty
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@SerialName("HealthcarePartyByParentIdFilter")
@Serializable
data class HealthcarePartyByParentIdFilter(
	public val parentId: String,
	override val desc: String? = null,
	internal val dtoSerialName: String,
) : AbstractFilter<HealthcareParty> {
	// region HealthcarePartyByParentIdFilter-HealthcarePartyByParentIdFilter

	// endregion
}
