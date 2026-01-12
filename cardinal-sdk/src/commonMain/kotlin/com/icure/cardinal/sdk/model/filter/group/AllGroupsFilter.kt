package com.icure.cardinal.sdk.model.filter.group

import com.icure.cardinal.sdk.model.Group
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

@SerialName("AllGroupsFilter")
@Serializable
public data class AllGroupsFilter(
	override val desc: String? = null,
) : AbstractFilter<Group>
