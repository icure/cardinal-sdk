// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.filter.hcparty

import com.icure.cardinal.sdk.model.HealthcareParty
import com.icure.cardinal.sdk.model.base.DataOwnerGroupLinkType
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 * Filter that matches the healthcare parties directly linked to a data owner group, through the
 * legacy parentId
 * (treated as a parent link) or a dataOwnerGroups link. Only direct links match: membership is not
 * propagated
 * through the group hierarchies.
 * /
 */
@SerialName("HealthcarePartyByDataOwnerGroupIdFilter")
@Serializable
data class HealthcarePartyByDataOwnerGroupIdFilter(
	/**
	 * The identifier of the data owner representing the group.
	 */
	public val dataOwnerGroupId: String,
	/**
	 * When not null, only healthcare parties whose effective link to the group has this type match.
	 */
	public val linkType: DataOwnerGroupLinkType? = null,
	/**
	 * Optional description of this filter.
	 */
	override val desc: String? = null,
) : AbstractFilter<HealthcareParty> {
	// region HealthcarePartyByDataOwnerGroupIdFilter-HealthcarePartyByDataOwnerGroupIdFilter

	// endregion
}
