package com.icure.cardinal.sdk.model.security

import com.icure.cardinal.sdk.model.filter.predicate.Predicate
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonClassDiscriminator
import kotlin.OptIn

@OptIn(ExperimentalSerializationApi::class)
@JsonClassDiscriminator("itemType")
@Serializable
public sealed interface PermissionItem {
	public val type: PermissionType

	public val predicate: Predicate
}
