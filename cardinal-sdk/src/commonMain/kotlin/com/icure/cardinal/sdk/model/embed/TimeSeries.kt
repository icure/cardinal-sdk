package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Double
import kotlin.String
import kotlin.collections.List

@Serializable
public data class TimeSeries(
	@DefaultValue("emptyList()")
	public val fields: List<String> = emptyList(),
	@DefaultValue("emptyList()")
	public val samples: List<List<Double>> = emptyList(),
	@DefaultValue("emptyList()")
	public val min: List<Double> = emptyList(),
	@DefaultValue("emptyList()")
	public val max: List<Double> = emptyList(),
	@DefaultValue("emptyList()")
	public val mean: List<Double> = emptyList(),
	@DefaultValue("emptyList()")
	public val median: List<Double> = emptyList(),
	@DefaultValue("emptyList()")
	public val variance: List<Double> = emptyList(),
)
