// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.filter.service

import com.icure.cardinal.sdk.model.embed.Service
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Long
import kotlin.String
import kotlin.collections.Collection
import kotlin.collections.Map

@SerialName("ServiceByHcPartyTagCodesFilter")
@Serializable
data class ServiceByHcPartyTagCodesFilter(
	public val healthcarePartyId: String,
	public val tagCodes: Map<String, Collection<String>>,
	public val startValueDate: Long? = null,
	public val endValueDate: Long? = null,
	override val desc: String? = null,
) : AbstractFilter<Service> {
	// region ServiceByHcPartyTagCodesFilter-ServiceByHcPartyTagCodesFilter

	// endregion
}
