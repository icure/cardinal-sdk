// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.filter.contact

import com.icure.cardinal.sdk.model.Contact
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Long
import kotlin.String
import kotlin.collections.Set

/**
 * Filter that matches contacts by data owner, patient, and opening date range.
 * /
 */
@SerialName("ContactByDataOwnerPatientOpeningDateFilter")
@Serializable
data class ContactByDataOwnerPatientOpeningDateFilter(
	/**
	 * The identifier of the data owner.
	 */
	public val dataOwnerId: String,
	/**
	 * The set of secret foreign keys used for secure delegation matching.
	 */
	public val secretForeignKeys: Set<String>,
	/**
	 * The start of the opening date range (inclusive).
	 */
	public val startDate: Long? = null,
	/**
	 * The end of the opening date range (inclusive).
	 */
	public val endDate: Long? = null,
	/**
	 * Whether to return results in descending order.
	 */
	public val descending: Boolean? = null,
	/**
	 * Optional description of this filter.
	 */
	override val desc: String? = null,
) : AbstractFilter<Contact> {
	// region ContactByDataOwnerPatientOpeningDateFilter-ContactByDataOwnerPatientOpeningDateFilter

	// endregion
}
