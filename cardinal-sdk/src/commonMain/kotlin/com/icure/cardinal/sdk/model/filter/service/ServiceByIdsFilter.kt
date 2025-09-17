package com.icure.cardinal.sdk.model.filter.service

import com.icure.cardinal.sdk.model.embed.Service
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.model.filter.Filter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.Set

@SerialName("ServiceByIdsFilter")
@Serializable
public data class ServiceByIdsFilter(
	override val ids: Set<String>,
	override val desc: String? = null,
) : AbstractFilter<Service>, Filter.IdsFilter<String, Service>
