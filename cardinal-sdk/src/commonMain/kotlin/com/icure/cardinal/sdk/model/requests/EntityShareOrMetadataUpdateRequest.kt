// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.requests

import kotlinx.serialization.Serializable

/**
 * A request that combines an optional entity share operation with an optional shared-metadata
 * update into a single payload.
 * Exactly one of the two fields should be populated for each entry in a bulk request.
 * /
 */
@Serializable
data class EntityShareOrMetadataUpdateRequest(
	/**
	 * The share request to grant access to an entity, if applicable.
	 */
	public val share: EntityShareRequest? = null,
	/**
	 * The metadata update request to modify sharing metadata of an already-shared entity, if
	 * applicable.
	 */
	public val update: EntitySharedMetadataUpdateRequest? = null,
) {
	// region EntityShareOrMetadataUpdateRequest-EntityShareOrMetadataUpdateRequest

	// endregion
}
