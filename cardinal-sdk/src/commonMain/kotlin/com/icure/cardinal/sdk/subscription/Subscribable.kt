package com.icure.cardinal.sdk.subscription

import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.model.base.Identifiable
import com.icure.cardinal.sdk.utils.DefaultValue

interface Subscribable<EntityBaseType : Identifiable<String>, EntityEventType : EntityBaseType, FilterOptionsType : FilterOptions<EntityBaseType>> {
	/**
	 * Subscribe to receive real-time notifications when an entity is updated.
	 *
	 * # Access control
	 *
	 * The subscription will only receive notifications about entities that the SDK user can access; currently this
	 * validation varies slightly from standard read methods.
	 *
	 * ## Encryptable entities
	 *
	 * Applies the same access control rules as the standard read methods; depending on the permissions of the user the
	 * entity might need to have a direct delegation to the user, or to a parent, or if the user has the permission to
	 * read any entity of the type regardless of delegations then all notification of entities (matching the filter)
	 * will be received.
	 *
	 * ## Healthcare party
	 *
	 * Currently, regardless of user permissions, only notifications about healthcare parties that have the current SDK
	 * data owner as a DIRECT link will be returned.
	 *
	 * This behaviour is not in line with current Cardinal SDK ideology and is subject to change in future versions.
	 *
	 * @param events the type of events that will be notified to the subscription
	 * @param filter the subscription will receive notifications only for entities matching this filter, you should
	 * make the filter as restrictive as possible.
	 * @param subscriptionConfig customize the configuration for the subscription
	 * @return a subscription that receives notifications for the configured events.
	 */
	suspend fun subscribeToEvents(
		events: Set<SubscriptionEventType>,
		filter: FilterOptionsType,
		@DefaultValue("null")
		subscriptionConfig: EntitySubscriptionConfiguration? = null
	): EntitySubscription<EntityEventType>
}
