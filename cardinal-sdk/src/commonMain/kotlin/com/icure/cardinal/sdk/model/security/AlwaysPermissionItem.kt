package com.icure.cardinal.sdk.model.security

import com.icure.cardinal.sdk.model.filter.predicate.AlwaysPredicate
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@SerialName("AlwaysPermissionItemDto")
@Serializable
public data class AlwaysPermissionItem(
	override val type: PermissionType,
) : PermissionItem {
	@DefaultValue("AlwaysPredicate()")
	override val predicate: AlwaysPredicate = AlwaysPredicate()
}
