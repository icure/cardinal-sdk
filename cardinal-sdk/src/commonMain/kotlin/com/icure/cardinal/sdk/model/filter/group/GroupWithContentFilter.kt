package com.icure.cardinal.sdk.model.filter.group

import com.icure.cardinal.sdk.model.Group
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 * Filter that matches groups within a super group whose content matches a search string.
 * /
 */
@SerialName("GroupWithContentFilter")
@Serializable
public data class GroupWithContentFilter(
	/**
	 * The identifier of the super group to search within.
	 */
	public val superGroupId: String,
	/**
	 * The string to search for in group content.
	 */
	public val searchString: String,
	/**
	 * Optional description of this filter.
	 */
	override val desc: String? = null,
) : AbstractFilter<Group>
