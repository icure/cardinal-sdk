// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 *
 *  Enumerates the lifecycle statuses of a document, from draft through finalization, review,
 * signature, and delivery.
 */
@Serializable
enum class DocumentStatus(
	internal val dtoSerialName: String,
) {
	@SerialName("draft")
	Draft("draft"),

	@SerialName("finalized")
	Finalized("finalized"),

	@SerialName("pending_review")
	PendingReview("pending_review"),

	@SerialName("reviewed")
	Reviewed("reviewed"),

	@SerialName("pending_signature")
	PendingSignature("pending_signature"),

	@SerialName("signed")
	Signed("signed"),

	@SerialName("canceled")
	Canceled("canceled"),

	@SerialName("sent")
	Sent("sent"),

	@SerialName("delivered")
	Delivered("delivered"),
}
