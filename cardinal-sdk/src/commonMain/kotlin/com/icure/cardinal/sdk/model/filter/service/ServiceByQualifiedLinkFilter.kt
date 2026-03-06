package com.icure.cardinal.sdk.model.filter.service

import com.icure.cardinal.sdk.model.base.LinkQualification
import com.icure.cardinal.sdk.model.embed.Service
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.List

@SerialName("ServiceByQualifiedLinkFilter")
@Serializable
public data class ServiceByQualifiedLinkFilter(
	public val linkValues: List<String>,
	public val linkQualification: LinkQualification? = null,
	override val desc: String? = null,
) : AbstractFilter<Service>
