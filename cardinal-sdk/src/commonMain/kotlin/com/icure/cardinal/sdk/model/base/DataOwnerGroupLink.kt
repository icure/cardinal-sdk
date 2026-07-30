// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.base

import kotlinx.serialization.Serializable
import kotlin.String

/**
 *
 *  A link from a crypto actor to a data owner that represents a group it belongs to.
 */
@Serializable
data class DataOwnerGroupLink(
	/**
	 * The nature of the link. Membership propagates transitively through all link types.
	 */
	public val linkType: DataOwnerGroupLinkType,
	/**
	 * The id of the data owner representing the group.
	 */
	public val dataOwnerId: String,
) {
	// region DataOwnerGroupLink-DataOwnerGroupLink
	// endregion
}
