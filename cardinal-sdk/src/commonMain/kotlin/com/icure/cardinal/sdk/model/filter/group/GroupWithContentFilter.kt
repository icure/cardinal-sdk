package com.icure.cardinal.sdk.model.filter.group

import com.icure.cardinal.sdk.model.Group
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

@SerialName("GroupWithContentFilter")
@Serializable
public data class GroupWithContentFilter(
	public val superGroupId: String,
	public val searchString: String,
	override val desc: String? = null,
) : AbstractFilter<Group>
