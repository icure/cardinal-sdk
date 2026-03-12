// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.filter.service

import com.icure.cardinal.sdk.model.embed.Service
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Long
import kotlin.String
import kotlin.collections.Set

/**
 * Filter that matches services by healthcare party, patient, tag prefix, and value date range.
 * /
 */
@SerialName("ServiceByHcPartyPatientTagPrefixFilter")
@Serializable
data class ServiceByHcPartyPatientTagPrefixFilter(
	/**
	 * The identifier of the healthcare party.
	 */
	public val healthcarePartyId: String,
	/**
	 * The set of secret foreign keys for patient matching.
	 */
	public val patientSecretForeignKeys: Set<String>,
	/**
	 * The type of the tag to match.
	 */
	public val tagType: String,
	/**
	 * The tag code prefix to match.
	 */
	public val tagCodePrefix: String,
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
) : AbstractFilter<Service> {
	// region ServiceByHcPartyPatientTagPrefixFilter-ServiceByHcPartyPatientTagPrefixFilter

	// endregion
}
