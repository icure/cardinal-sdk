package com.icure.cardinal.sdk.model.filter.healthelement

import com.icure.cardinal.sdk.model.HealthElement
import com.icure.cardinal.sdk.model.base.Identifier
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.model.filter.VersionFiltering
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.List

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@SerialName("HealthElementByHcPartyIdentifiersVersioningFilter")
@Serializable
data class HealthElementByHcPartyIdentifiersVersioningFilter(
	override val desc: String? = null,
	public val hcPartyId: String,
	@param:DefaultValue("emptyList()")
	public val identifiers: List<Identifier> = emptyList(),
	public val versionFiltering: VersionFiltering? = null,
) : AbstractFilter<HealthElement> {
	// region HealthElementByHcPartyIdentifiersVersioningFilter-HealthElementByHcPartyIdentifiersVersioningFilter

	// endregion
}
