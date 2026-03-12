package com.icure.cardinal.sdk.model.filter.form

import com.icure.cardinal.sdk.model.Form
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Long
import kotlin.String
import kotlin.collections.Set

/**
 * Filter that matches forms by data owner, patient, and opening date range.
 * /
 */
@SerialName("FormByDataOwnerPatientOpeningDateFilter")
@Serializable
public data class FormByDataOwnerPatientOpeningDateFilter(
	/**
	 * The identifier of the data owner.
	 */
	public val dataOwnerId: String,
	/**
	 * The set of secret patient keys used for secure delegation matching.
	 */
	public val secretPatientKeys: Set<String>,
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
) : AbstractFilter<Form>
