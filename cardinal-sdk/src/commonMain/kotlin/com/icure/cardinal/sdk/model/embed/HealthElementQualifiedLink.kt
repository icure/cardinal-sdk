// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.Serializable
import kotlin.String

/**
 * A directed, qualified link from one healthcare element to another. Links should be created in a
 * single direction:
 * the reverse link can be found through a view.
 * /
 */
@Serializable
data class HealthElementQualifiedLink(
	/**
	 * The qualification of the link. Free string; using the names of LinkQualification entries is
	 * encouraged but not enforced.
	 */
	public val type: String,
	/**
	 * A caller-chosen correlation id that groups related links across entities.
	 */
	public val associationId: String? = null,
	/**
	 * The id of the linked healthcare element.
	 */
	public val healthElementId: String,
) {
	// region HealthElementQualifiedLink-HealthElementQualifiedLink
	// endregion
}
