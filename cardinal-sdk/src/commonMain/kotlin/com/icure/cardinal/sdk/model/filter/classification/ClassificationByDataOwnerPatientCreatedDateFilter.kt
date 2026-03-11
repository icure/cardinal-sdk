package com.icure.cardinal.sdk.model.filter.classification

import com.icure.cardinal.sdk.model.Classification
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Long
import kotlin.String
import kotlin.collections.Set

/**
 * Filter that matches classifications by data owner, patient, and creation date range.
 * /
 */
@SerialName("ClassificationByDataOwnerPatientCreatedDateFilter")
@Serializable
public data class ClassificationByDataOwnerPatientCreatedDateFilter(
	/**
	 * The identifier of the data owner.
	 */
	public val dataOwnerId: String,
	/**
	 * The start of the creation date range (inclusive).
	 */
	public val startDate: Long?,
	/**
	 * The end of the creation date range (inclusive).
	 */
	public val endDate: Long?,
	/**
	 * The set of secret foreign keys used for secure delegation matching.
	 */
	public val secretForeignKeys: Set<String>,
	/**
	 * Whether to return results in descending order.
	 */
	public val descending: Boolean?,
	/**
	 * Optional description of this filter.
	 */
	override val desc: String? = null,
) : AbstractFilter<Classification>
