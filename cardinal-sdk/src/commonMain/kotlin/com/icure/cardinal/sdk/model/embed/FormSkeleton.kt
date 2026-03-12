// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.Serializable
import kotlin.String

/**
 * Represents a skeleton reference to a form template, used for defining form structure.
 * /
 */
@Serializable
data class FormSkeleton(
	/**
	 * A description of the form skeleton.
	 */
	public val descr: String? = null,
	/**
	 * The identifier of the associated form template.
	 */
	public val formTemplateId: String? = null,
) {
	// region FormSkeleton-FormSkeleton

	// endregion
}
