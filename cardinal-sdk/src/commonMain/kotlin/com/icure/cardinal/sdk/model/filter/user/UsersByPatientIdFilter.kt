// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.filter.user

import com.icure.cardinal.sdk.model.User
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 * A filter that matches users linked to a specific patient entity.
 * /
 */
@SerialName("UsersByPatientIdFilter")
@Serializable
data class UsersByPatientIdFilter(
	/**
	 * The identifier of the patient whose associated users should be returned.
	 */
	public val patientId: String,
	/**
	 * Optional human-readable description of this filter instance.
	 */
	override val desc: String? = null,
) : AbstractFilter<User> {
	// region UsersByPatientIdFilter-UsersByPatientIdFilter

	// endregion
}
