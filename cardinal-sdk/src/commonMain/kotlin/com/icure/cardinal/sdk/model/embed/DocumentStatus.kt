package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

@Serializable
public enum class DocumentStatus(
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
