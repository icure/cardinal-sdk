// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.filter.service

import com.icure.cardinal.sdk.model.embed.Service
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Long
import kotlin.String
import kotlin.collections.List

/**
 * Filter that matches services by healthcare party, patient secret foreign keys, tag, code, and
 * value date range.
 * /
 */
@SerialName("ServiceByHcPartyTagCodeDateFilter")
@Serializable
data class ServiceByHcPartyTagCodeDateFilter(
	/**
	 * Optional description of this filter.
	 */
	override val desc: String? = null,
	/**
	 * The identifier of the healthcare party.
	 */
	public val healthcarePartyId: String? = null,
	/**
	 * The list of secret foreign keys for patient matching.
	 */
	public val patientSecretForeignKeys: List<String>? = null,
	/**
	 * The type of the tag to filter on.
	 */
	public val tagType: String? = null,
	/**
	 * The tag code value to match.
	 */
	public val tagCode: String? = null,
	/**
	 * The type of the code to filter on.
	 */
	public val codeType: String? = null,
	/**
	 * The code value to match.
	 */
	public val codeCode: String? = null,
	/**
	 * The start of the value date range.
	 */
	public val startValueDate: Long? = null,
	/**
	 * The end of the value date range.
	 */
	public val endValueDate: Long? = null,
	/**
	 * Whether to return results in descending order.
	 */
	@param:DefaultValue("false")
	public val descending: Boolean = false,
) : AbstractFilter<Service> {
	// region ServiceByHcPartyTagCodeDateFilter-ServiceByHcPartyTagCodeDateFilter

	// endregion
}
