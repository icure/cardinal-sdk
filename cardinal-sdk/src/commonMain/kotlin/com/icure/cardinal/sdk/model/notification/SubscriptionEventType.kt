package com.icure.cardinal.sdk.model.notification

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

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
