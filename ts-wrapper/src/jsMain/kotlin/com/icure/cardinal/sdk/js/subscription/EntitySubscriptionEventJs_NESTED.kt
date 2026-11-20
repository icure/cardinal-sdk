// auto-generated file
@file:JsQualifier("subscription.EntitySubscriptionEvent")

package com.icure.cardinal.sdk.js.subscription

import com.icure.cardinal.sdk.js.model.base.IdentifiableJs
import kotlin.Nothing
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("Connected")
public external object EntitySubscriptionEventJs_ConnectedJs : EntitySubscriptionEventJs<Nothing> {
	override val ktClass: String
}

@JsName("Reconnected")
public external object EntitySubscriptionEventJs_ReconnectedJs : EntitySubscriptionEventJs<Nothing> {
	override val ktClass: String
}

@JsName("ClosedByClient")
public external object EntitySubscriptionEventJs_ClosedByClientJs : EntitySubscriptionEventJs<Nothing> {
	override val ktClass: String
}

@JsName("UnexpectedError")
public external class EntitySubscriptionEventJs_UnexpectedErrorJs(
	partial: dynamic,
) : EntitySubscriptionEventJs<Nothing> {
	public val message: String

	override val ktClass: String
}

@JsName("ConnectionError")
public sealed external interface EntitySubscriptionEventJs_ConnectionErrorJs : EntitySubscriptionEventJs<Nothing>

@JsName("EntityNotification")
public external class EntitySubscriptionEventJs_EntityNotificationJs<E : IdentifiableJs<String>>(
	partial: dynamic,
) : EntitySubscriptionEventJs<E> {
	public val entity: E

	override val ktClass: String
}

@JsName("EntityError")
public sealed external interface EntitySubscriptionEventJs_EntityErrorJs : EntitySubscriptionEventJs<Nothing>
