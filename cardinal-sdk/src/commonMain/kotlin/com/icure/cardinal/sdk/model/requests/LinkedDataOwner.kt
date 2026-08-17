// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.requests

import com.icure.cardinal.sdk.model.base.DataOwnerGroupLinkType
import kotlinx.serialization.Serializable
import kotlin.String

/**
 *
 *  A data owner that declares a direct link to one of the queried data owner groups, through the
 * legacy
 *  `parentId` or a `dataOwnerGroups` entry.
 *
 *  Group membership is transitive, but this is **not**: only the data owners declaring a link to a
 * queried group
 *  are returned, never the data owners linked to *them*. Following the chain is up to the client,
 * which has to
 *  decide whether it wants to, based on [groupLinkType].
 */
@Serializable
data class LinkedDataOwner(
	public val dataOwnerId: String,
	/**
	 *
	 *  The group link type of this data owner, that is the type any link pointing at *it* has. Omitted
	 * when it is
	 *  the default for the type of data owner that was queried (`parent` for healthcare parties,
	 * `notAllowed` for
	 *  patients and devices), which is the common case: an absent value is not a fourth type.
	 */
	public val groupLinkType: DataOwnerGroupLinkType? = null,
) {
	// region LinkedDataOwner-LinkedDataOwner
	// endregion
}
