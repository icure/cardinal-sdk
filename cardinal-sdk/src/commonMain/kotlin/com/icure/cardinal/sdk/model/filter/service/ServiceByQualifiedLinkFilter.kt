// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.filter.service

import com.icure.cardinal.sdk.model.base.LinkQualification
import com.icure.cardinal.sdk.model.embed.Service
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.List

/**
 * Filter that matches services by their qualified links.
 * /
 */
@SerialName("ServiceByQualifiedLinkFilter")
@Serializable
data class ServiceByQualifiedLinkFilter(
	/**
	 * The list of link values to match.
	 */
	public val linkValues: List<String>,
	/**
	 * The optional link qualification to filter by.
	 */
	public val linkQualification: LinkQualification? = null,
	/**
	 * Optional description of this filter.
	 */
	override val desc: String? = null,
) : AbstractFilter<Service> {
	// region ServiceByQualifiedLinkFilter-ServiceByQualifiedLinkFilter

	// endregion
}
