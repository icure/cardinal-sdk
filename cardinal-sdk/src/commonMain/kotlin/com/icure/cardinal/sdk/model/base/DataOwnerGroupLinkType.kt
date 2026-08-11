// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.base

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 *
 *  The nature of the link between a crypto actor and a data owner representing one of its groups.
 *
 *  All links are transitive, whatever their type: when the linked group is itself a member of
 * another group, the
 *  original actor is a member of that further group as well, so resolving the complete set of
 * groups of an actor
 *  requires following the links recursively.
 */
@Serializable
enum class DataOwnerGroupLinkType(
	internal val dtoSerialName: String,
) {
	@SerialName("parent")
	Parent("parent"),

	@SerialName("simple")
	Simple("simple"),
}
