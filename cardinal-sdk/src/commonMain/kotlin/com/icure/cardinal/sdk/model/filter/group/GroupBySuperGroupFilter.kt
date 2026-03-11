package com.icure.cardinal.sdk.model.filter.group

import com.icure.cardinal.sdk.model.Group
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 *
 *  Filter that matches groups belonging to a specific super group.
 */
@SerialName("GroupBySuperGroupFilter")
@Serializable
public class GroupBySuperGroupFilter(
	/**
	 * The identifier of the super group.
	 */
	public val superGroupId: String,
	/**
	 * Optional description of this filter.
	 */
	override val desc: String? = null,
) : AbstractFilter<Group>
