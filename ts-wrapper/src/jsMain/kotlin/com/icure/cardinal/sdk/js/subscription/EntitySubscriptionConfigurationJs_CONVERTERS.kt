// auto-generated file
package com.icure.cardinal.sdk.js.subscription

import com.icure.cardinal.sdk.js.model.CheckedConverters.durationToNumber
import com.icure.cardinal.sdk.js.model.CheckedConverters.intToNumber
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToDuration
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToInt
import com.icure.cardinal.sdk.subscription.EntitySubscriptionConfiguration
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun entitySubscriptionConfiguration_toJs(obj: EntitySubscriptionConfiguration): EntitySubscriptionConfigurationJs {
	val channelBufferCapacity = intToNumber(obj.channelBufferCapacity)
	val onBufferFull = obj.onBufferFull.name
	val reconnectionDelay = durationToNumber(obj.reconnectionDelay)
	val retryDelayExponentFactor = obj.retryDelayExponentFactor
	val connectionMaxRetries = intToNumber(obj.connectionMaxRetries)
	return EntitySubscriptionConfigurationJs(js("{" +
		"channelBufferCapacity:channelBufferCapacity," +
		"onBufferFull:onBufferFull," +
		"reconnectionDelay:reconnectionDelay," +
		"retryDelayExponentFactor:retryDelayExponentFactor," +
		"connectionMaxRetries:connectionMaxRetries" +
	"}"))
}

public fun entitySubscriptionConfiguration_fromJs(obj: EntitySubscriptionConfigurationJs): EntitySubscriptionConfiguration {
	val channelBufferCapacity = numberToInt(obj.channelBufferCapacity, "obj.channelBufferCapacity")
	val onBufferFull = EntitySubscriptionConfiguration.FullBufferBehaviour.valueOf(obj.onBufferFull)
	val reconnectionDelay = numberToDuration(obj.reconnectionDelay, "obj.reconnectionDelay")
	val retryDelayExponentFactor = obj.retryDelayExponentFactor
	val connectionMaxRetries = numberToInt(obj.connectionMaxRetries, "obj.connectionMaxRetries")
	return EntitySubscriptionConfiguration(
		channelBufferCapacity = channelBufferCapacity,
		onBufferFull = onBufferFull,
		reconnectionDelay = reconnectionDelay,
		retryDelayExponentFactor = retryDelayExponentFactor,
		connectionMaxRetries = connectionMaxRetries,
	)
}
