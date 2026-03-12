package com.icure.cardinal.sdk.model.filter.patient

import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Long
import kotlin.String

/**
 * Filter that matches patients by data owner and modification date range.
 * /
 */
@SerialName("PatientByDataOwnerModifiedAfterFilter")
@Serializable
public data class PatientByDataOwnerModifiedAfterFilter(
	/**
	 * The identifier of the data owner.
	 */
	public val dataOwnerId: String,
	/**
	 * The start of the modification date range (inclusive).
	 */
	public val startDate: Long?,
	/**
	 * The end of the modification date range (inclusive).
	 */
	public val endDate: Long?,
	/**
	 * Whether to return results in descending order.
	 */
	public val descending: Boolean?,
	/**
	 * Optional description of this filter.
	 */
	override val desc: String?,
) : AbstractFilter<Patient>
