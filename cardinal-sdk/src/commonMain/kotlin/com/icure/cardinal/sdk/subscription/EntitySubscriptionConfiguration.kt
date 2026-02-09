package com.icure.cardinal.sdk.subscription

import com.icure.cardinal.sdk.serialization.DurationAsMillisecondsSerializer
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.time.Duration
import kotlin.time.Duration.Companion.seconds

/**
 * Configurations for a subscription,
 */
@Serializable
data class EntitySubscriptionConfiguration(
	/**
	 * The amount of (unconsumed) events that the subscription can buffer
	 */
	@param:DefaultValue("100")
	val channelBufferCapacity: Int = 100,
	/**
	 * How the subscription should behave if a new event is received but it does not fit in the buffer
	 */
	@param:DefaultValue("com.icure.cardinal.sdk.subscription.EntitySubscriptionConfiguration.FullBufferBehaviour.Close")
	val onBufferFull: FullBufferBehaviour = FullBufferBehaviour.Close,
	/**
	 * If the (re)connection fails how long to wait before another attempt.
	 */
	@param:DefaultValue("2.seconds")
	@Serializable(with = DurationAsMillisecondsSerializer::class)
	val reconnectionDelay: Duration = 2.seconds,
	/**
	 * Factor for increasing the delay between (re)connection attempts in case of repeated failures.
	 */
	@param:DefaultValue("2.0")
	val retryDelayExponentFactor: Double = 2.0,
	/**
	 * How many times should the subscription attempt to (re)connect before closing with a [EntitySubscription.ConnectionException]
	 */
	@param:DefaultValue("5")
	val connectionMaxRetries: Int = 5,
) {
	@Serializable
	enum class FullBufferBehaviour {
		/**
		 * The subscription will be closed, and the [EntitySubscription.eventChannel] will fail with a [EntitySubscription.ChannelFullException]
		 */
		Close,
		/**
		 * The oldest event will be dropped (i.e. the next element in the [EntitySubscription.eventChannel]), and the new
		 * event will be added.
		 */
		DropOldest,
		/**
		 * The event will simply be ignored, the [EntitySubscription.eventChannel] will not be changed.
		 */
		Ignore
	}
}
