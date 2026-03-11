package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Double
import kotlin.String
import kotlin.collections.List

/**
 *
 *  Represents a high-frequency time series with named fields, sample data, and statistical
 * summaries.
 */
@Serializable
public data class TimeSeries(
	/**
	 * The names of the fields (columns) in the time series.
	 */
	@param:DefaultValue("emptyList()")
	public val fields: List<String> = emptyList(),
	/**
	 * The sample data, where each inner list represents one sample across all fields.
	 */
	@param:DefaultValue("emptyList()")
	public val samples: List<List<Double>> = emptyList(),
	/**
	 * The minimum values for each field.
	 */
	@param:DefaultValue("emptyList()")
	public val min: List<Double> = emptyList(),
	/**
	 * The maximum values for each field.
	 */
	@param:DefaultValue("emptyList()")
	public val max: List<Double> = emptyList(),
	/**
	 * The mean values for each field.
	 */
	@param:DefaultValue("emptyList()")
	public val mean: List<Double> = emptyList(),
	/**
	 * The median values for each field.
	 */
	@param:DefaultValue("emptyList()")
	public val median: List<Double> = emptyList(),
	/**
	 * The variance values for each field.
	 */
	@param:DefaultValue("emptyList()")
	public val variance: List<Double> = emptyList(),
)
