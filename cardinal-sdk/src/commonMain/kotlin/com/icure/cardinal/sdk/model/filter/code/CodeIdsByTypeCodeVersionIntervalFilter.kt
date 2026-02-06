package com.icure.cardinal.sdk.model.filter.code

import com.icure.cardinal.sdk.model.Code
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

@SerialName("CodeIdsByTypeCodeVersionIntervalFilter")
@Serializable
public data class CodeIdsByTypeCodeVersionIntervalFilter(
	override val desc: String? = null,
	public val startType: String? = null,
	public val startCode: String? = null,
	public val startVersion: String? = null,
	public val endType: String? = null,
	public val endCode: String? = null,
	public val endVersion: String? = null,
) : AbstractFilter<Code>
