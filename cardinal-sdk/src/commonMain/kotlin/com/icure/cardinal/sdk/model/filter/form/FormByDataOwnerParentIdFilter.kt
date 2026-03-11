// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.filter.form

import com.icure.cardinal.sdk.model.Form
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 * Filter that matches forms by data owner and parent form identifier.
 * /
 */
@SerialName("FormByDataOwnerParentIdFilter")
@Serializable
data class FormByDataOwnerParentIdFilter(
	/**
	 * The identifier of the data owner.
	 */
	public val dataOwnerId: String,
	/**
	 * The identifier of the parent form.
	 */
	public val parentId: String,
	/**
	 * Optional description of this filter.
	 */
	override val desc: String? = null,
) : AbstractFilter<Form> {
	// region FormByDataOwnerParentIdFilter-FormByDataOwnerParentIdFilter

	// endregion
}
