package com.icure.cardinal.sdk.model.filter.service

import com.icure.cardinal.sdk.model.embed.Service
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 * Filter that matches services by their association identifier.
 * /
 */
@SerialName("ServiceByAssociationIdFilter")
@Serializable
public data class ServiceByAssociationIdFilter(
	/**
	 * The association identifier to match.
	 */
	public val associationId: String,
	/**
	 * Optional description of this filter.
	 */
	override val desc: String? = null,
) : AbstractFilter<Service>
