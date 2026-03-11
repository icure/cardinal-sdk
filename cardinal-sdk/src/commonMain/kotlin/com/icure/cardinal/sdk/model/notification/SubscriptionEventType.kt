package com.icure.cardinal.sdk.model.notification

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 *
 *  The types of entity lifecycle events that can be observed via a subscription.
 */
@Serializable
public enum class SubscriptionEventType(
	internal val dtoSerialName: String,
) {
	@SerialName("CREATE")
	Create("CREATE"),

	@SerialName("UPDATE")
	Update("UPDATE"),

	@SerialName("DELETE")
	Delete("DELETE"),
}
