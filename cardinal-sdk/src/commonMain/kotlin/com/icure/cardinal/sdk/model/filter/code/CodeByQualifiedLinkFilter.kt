package com.icure.cardinal.sdk.model.filter.code

import com.icure.cardinal.sdk.model.Code
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

@SerialName("CodeByQualifiedLinkFilter")
@Serializable
public data class CodeByQualifiedLinkFilter(
	public val linkType: String,
	public val linkedId: String? = null,
	override val desc: String? = null,
) : AbstractFilter<Code>
