// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.filter.service

import com.icure.cardinal.sdk.model.embed.Service
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.model.filter.VersionFiltering
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Long
import kotlin.String
import kotlin.collections.Collection
import kotlin.collections.Map
import kotlin.collections.Set

/**
 *
 *  Filter that matches services shared with a data owner and linked to a patient, having at least one of the
 *  given codes, optionally within a value date range.
 *  With [filterVersion] = [VersionFilteringDto.LATEST] only services whose latest version matches are returned;
 *  with [VersionFilteringDto.ANY] (default) a service is returned if any of its versions matches.
 */
@SerialName("ServiceByDataOwnerPatientCodeCodesFilter")
@Serializable
data class ServiceByDataOwnerPatientCodeCodesFilter(
	/**
	 * The id of the data owner.
	 */
	public val dataOwnerId: String,
	/**
	 * Secret foreign keys of the patients the services must be linked to.
	 */
	public val patientSecretForeignKeys: Set<String>,
	/**
	 * Map of code type to the accepted code codes.
	 */
	public val codeCodes: Map<String, Collection<String>>,
	/**
	 * Optional minimum value date (fuzzy date, inclusive).
	 */
	public val startValueDate: Long? = null,
	/**
	 * Optional maximum value date (fuzzy date, inclusive).
	 */
	public val endValueDate: Long? = null,
	/**
	 * Optional version filtering; defaults to ANY.
	 */
	public val filterVersion: VersionFiltering? = null,
	/**
	 * Optional version filtering; defaults to ANY.
	 */
	override val desc: String? = null,
) : AbstractFilter<Service> {
	// region ServiceByDataOwnerPatientCodeCodesFilter-ServiceByDataOwnerPatientCodeCodesFilter

	// endregion
}
