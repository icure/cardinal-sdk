// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.notification

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 *
 *  The types of entity lifecycle events that can be observed via a subscription.
 */
@Serializable
enum class SubscriptionEventType(
	internal val dtoSerialName: String,
) {
	@SerialName("CREATE")
	Create("CREATE"),

	@SerialName("UPDATE")
	Update("UPDATE"),

	@SerialName("DELETE")
	Delete("DELETE"),
}
