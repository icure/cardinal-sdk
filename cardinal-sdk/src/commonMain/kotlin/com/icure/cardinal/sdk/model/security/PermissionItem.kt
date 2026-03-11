// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.security

import com.icure.cardinal.sdk.model.filter.predicate.Predicate
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonClassDiscriminator
import kotlin.OptIn

/**
 * Sealed interface representing a single permission entry that pairs a permission type with a
 * predicate.
 * The predicate defines the condition under which the permission applies.
 * /
 */
@OptIn(ExperimentalSerializationApi::class)
@JsonClassDiscriminator("itemType")
@Serializable
sealed interface PermissionItem {
	public val type: PermissionType

	public val predicate: Predicate
	// region PermissionItem-PermissionItem

	// endregion
}
