package com.icure.cardinal.sdk.model.filter.service

import com.icure.cardinal.sdk.model.embed.Service
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Long
import kotlin.String
import kotlin.collections.Set

/**
 * Filter that matches services by data owner, patient, and date range.
 * /
 */
@SerialName("ServiceByDataOwnerPatientDateFilter")
@Serializable
public data class ServiceByDataOwnerPatientDateFilter(
	/**
	 * The identifier of the data owner.
	 */
	public val dataOwnerId: String,
	/**
	 * The set of secret foreign keys for patient matching.
	 */
	public val secretForeignKeys: Set<String>,
	/**
	 * The start of the date range (inclusive).
	 */
	public val startDate: Long? = null,
	/**
	 * The end of the date range (inclusive).
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
) : AbstractFilter<Service>
