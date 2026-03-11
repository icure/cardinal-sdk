package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.model.base.CodeStub
import kotlinx.serialization.Serializable
import kotlin.Int
import kotlin.Long

/**
 * Represents a single item in a medication regimen, defining when and how much medication should be
 * administered.
 * The day can be specified as a specific date, day number in treatment, or weekday. The time can be
 * a day period or exact time.
 * /
 */
@Serializable
public data class RegimenItem(
	/**
	 * A specific date (yyyyMMdd) for this regimen item.
	 */
	public val date: Long? = null,
	/**
	 * The day number in the treatment (1-based).
	 */
	public val dayNumber: Int? = null,
	/**
	 * The weekday for this regimen item.
	 */
	public val weekday: Weekday? = null,
	/**
	 * The period of the day (CD-DAYPERIOD) for administration.
	 */
	public val dayPeriod: CodeStub? = null,
	/**
	 * The time of day (hhmmss) for administration.
	 */
	public val timeOfDay: Long? = null,
	/**
	 * The quantity to administer.
	 */
	public val administratedQuantity: AdministrationQuantity? = null,
)
