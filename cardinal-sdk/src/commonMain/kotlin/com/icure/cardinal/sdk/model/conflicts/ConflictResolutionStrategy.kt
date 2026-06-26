// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.conflicts

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 *
 *  Describes the strategy that should be used when automatically resolving the conflicting
 * revisions of an entity.
 *
 *  Maps to `org.taktik.icure.entities.conflicts.ConflictResolutionStrategy`.
 */
@Serializable
enum class ConflictResolutionStrategy(
	internal val dtoSerialName: String,
) {
	@SerialName("FullMergeability")
	FullMergeability("FullMergeability"),

	@SerialName("LatestRevision")
	LatestRevision("LatestRevision"),
}
