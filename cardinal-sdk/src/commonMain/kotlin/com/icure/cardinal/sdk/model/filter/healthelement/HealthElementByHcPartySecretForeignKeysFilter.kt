package com.icure.cardinal.sdk.model.filter.healthelement

import com.icure.cardinal.sdk.model.HealthElement
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Long
import kotlin.String
import kotlin.collections.Set

/**
 * Filter that matches health elements by healthcare party and patient secret foreign keys.
 * /
 */
@SerialName("HealthElementByHcPartySecretForeignKeysFilter")
@Serializable
public data class HealthElementByHcPartySecretForeignKeysFilter(
	/**
	 * Optional description of this filter.
	 */
	override val desc: String? = null,
	/**
	 * The identifier of the healthcare party.
	 */
	public val healthcarePartyId: String,
	/**
	 * The set of secret foreign keys for patient matching.
	 */
	@param:DefaultValue("emptySet()")
	public val patientSecretForeignKeys: Set<String> = emptySet(),
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
	@param:DefaultValue("false")
	public val descending: Boolean = false,
) : AbstractFilter<HealthElement>
