package com.icure.cardinal.sdk.model.filter.message

import com.icure.cardinal.sdk.model.Message
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.List

/**
 * Filter that matches messages by their parent message identifiers.
 * /
 */
@SerialName("MessageByParentIdsFilter")
@Serializable
public data class MessageByParentIdsFilter(
	/**
	 * The list of parent message identifiers to match.
	 */
	public val parentIds: List<String>,
	/**
	 * Optional description of this filter.
	 */
	override val desc: String? = null,
) : AbstractFilter<Message>
