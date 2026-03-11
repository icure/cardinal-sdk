// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.Serializable
import kotlin.String

/**
 * Represents a group of forms, identified by a GUID and a human-readable name.
 * /
 */
@Serializable
data class FormGroup(
	/**
	 * The globally unique identifier for this form group.
	 */
	public val guid: String? = null,
	/**
	 * The human-readable name of the form group.
	 */
	public val name: String? = null,
) {
	// region FormGroup-FormGroup

	// endregion
}
