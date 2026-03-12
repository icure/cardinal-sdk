package com.icure.cardinal.sdk.model.notification

import com.icure.cardinal.sdk.model.base.Identifiable
import com.icure.cardinal.sdk.model.filter.chain.FilterChain
import com.icure.cardinal.sdk.model.specializations.AccessControlKeyHexString
import kotlin.Boolean
import kotlin.String
import kotlin.collections.List

/**
 * Represents a real-time event subscription for a specific entity class. Clients use this DTO to
 * declare which event types and optional filter criteria they want to be notified about.
 * /
 */
public data class Subscription<O : Identifiable<String>>(
	/**
	 * The list of event types (CREATE, UPDATE, DELETE) to subscribe to.
	 */
	public val eventTypes: List<SubscriptionEventType>,
	/**
	 * The fully-qualified or short class name of the entity to observe.
	 */
	public val entityClass: String,
	/**
	 * An optional filter chain that narrows which entity instances trigger notifications.
	 */
	public val filter: FilterChain<O>?,
	/**
	 * Optional access-control keys used to scope the subscription to specific encrypted data.
	 */
	public val accessControlKeys: List<AccessControlKeyHexString>?,
	/**
	 * When true, uses Cardinal model serialization for the entity payloads.
	 */
	public val useCardinalModelSerialization: Boolean? = null,
)
