package com.icure.cardinal.sdk.model.filter.service

import com.icure.cardinal.sdk.model.embed.Service
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Long
import kotlin.String
import kotlin.collections.Set

/**
 * Filter that matches services by healthcare party, patient, code prefix, and value date range.
 * /
 */
@SerialName("ServiceByHcPartyPatientCodePrefixFilter")
@Serializable
public data class ServiceByHcPartyPatientCodePrefixFilter(
	/**
	 * The identifier of the healthcare party.
	 */
	public val healthcarePartyId: String,
	/**
	 * The set of secret foreign keys for patient matching.
	 */
	public val patientSecretForeignKeys: Set<String>,
	/**
	 * The type of the code to match.
	 */
	public val codeType: String,
	/**
	 * The code prefix to match.
	 */
	public val codeCodePrefix: String,
	/**
	 * The start of the value date range.
	 */
	public val startValueDate: Long? = null,
	/**
	 * The end of the value date range.
	 */
	public val endValueDate: Long? = null,
	/**
	 * Optional description of this filter.
	 */
	override val desc: String? = null,
) : AbstractFilter<Service>
