// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.requests.topic

import kotlinx.serialization.Serializable
import kotlin.String

/**
 *
 *  Request payload to remove an existing participant from a topic.
 */
@Serializable
data class RemoveParticipant(
	/**
	 * The identifier of the data owner to remove from the topic.
	 */
	public val dataOwnerId: String,
) {
	// region RemoveParticipant-RemoveParticipant

	// endregion
}
