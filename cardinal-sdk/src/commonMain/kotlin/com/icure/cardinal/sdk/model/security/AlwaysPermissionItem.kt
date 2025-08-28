package com.icure.cardinal.sdk.model.security

import com.icure.cardinal.sdk.model.filter.predicate.AlwaysPredicate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@SerialName("AlwaysPermissionItemDto")
@Serializable
public data class AlwaysPermissionItem(
	override val type: PermissionType,
) : PermissionItem {
	override val predicate: AlwaysPredicate
}
