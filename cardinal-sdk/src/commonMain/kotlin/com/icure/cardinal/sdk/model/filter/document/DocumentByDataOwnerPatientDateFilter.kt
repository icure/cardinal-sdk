// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.filter.document

import com.icure.cardinal.sdk.model.Document
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.serialization.InstantSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.String
import kotlin.collections.Set
import kotlin.time.Instant

/**
 * Filter that matches documents by data owner, patient, and date range.
 * /
 */
@SerialName("DocumentByDataOwnerPatientDateFilter")
@Serializable
data class DocumentByDataOwnerPatientDateFilter(
	/**
	 * The identifier of the data owner.
	 */
	public val dataOwnerId: String,
	/**
	 * The set of secret patient keys used for secure delegation matching.
	 */
	public val secretPatientKeys: Set<String>,
	/**
	 * The start of the date range (inclusive).
	 */
	@Serializable(with = InstantSerializer::class)
	public val startDate: Instant? = null,
	/**
	 * The end of the date range (inclusive).
	 */
	@Serializable(with = InstantSerializer::class)
	public val endDate: Instant? = null,
	/**
	 * Whether to return results in descending order.
	 */
	public val descending: Boolean? = null,
	/**
	 * Optional description of this filter.
	 */
	override val desc: String? = null,
) : AbstractFilter<Document> {
	// region DocumentByDataOwnerPatientDateFilter-DocumentByDataOwnerPatientDateFilter

	// endregion
}
