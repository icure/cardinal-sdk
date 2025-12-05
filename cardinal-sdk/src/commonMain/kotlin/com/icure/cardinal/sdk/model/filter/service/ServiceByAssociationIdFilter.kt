package com.icure.cardinal.sdk.model.filter.service

import com.icure.cardinal.sdk.model.embed.Service
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

@SerialName("ServiceByAssociationIdFilter")
@Serializable
public data class ServiceByAssociationIdFilter(
	public val associationId: String,
	override val desc: String? = null,
) : AbstractFilter<Service>
