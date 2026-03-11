// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.model.base.CodeStub
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Set

/**
 * Represents an allocation schedule for a resource group, defining time table items within a date
 * range.
 * /
 */
@Serializable
data class ResourceGroupAllocationSchedule(
	/**
	 * The code identifying the resource group.
	 */
	public val resourceGroup: CodeStub? = null,
	/**
	 * Tags associated with this schedule.
	 */
	@param:DefaultValue("emptySet()")
	public val tags: Set<CodeStub> = emptySet(),
	/**
	 * Codes associated with this schedule.
	 */
	@param:DefaultValue("emptySet()")
	public val codes: Set<CodeStub> = emptySet(),
	/**
	 * The name of this allocation schedule.
	 */
	public val name: String? = null,
	/**
	 * The start date-time in YYYYMMDDHHMMSS format.
	 */
	public val startDateTime: Long? = null,
	/**
	 * The end date-time in YYYYMMDDHHMMSS format.
	 */
	public val endDateTime: Long? = null,
	/**
	 * The list of time table items in this schedule.
	 */
	@param:DefaultValue("emptyList()")
	public val items: List<EmbeddedTimeTableItem> = emptyList(),
) {
	// region ResourceGroupAllocationSchedule-ResourceGroupAllocationSchedule

	// endregion
}
