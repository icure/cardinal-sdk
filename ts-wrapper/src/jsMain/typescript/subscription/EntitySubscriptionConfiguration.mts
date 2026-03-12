// auto-generated file
import {DurationMs} from '../utils/DurationMs.mjs';


/**
 *
 *  Configurations for a subscription,
 */
export class EntitySubscriptionConfiguration {

	/**
	 *
	 *  The amount of (unconsumed) events that the subscription can buffer
	 */
	channelBufferCapacity: number = 100;

	/**
	 *
	 *  How the subscription should behave if a new event is received but it does not fit in the buffer
	 */
	onBufferFull: EntitySubscriptionConfiguration.FullBufferBehaviour = EntitySubscriptionConfiguration.FullBufferBehaviour.Close;

	/**
	 *
	 *  If the (re)connection fails how long to wait before another attempt.
	 */
	reconnectionDelay: DurationMs = 2000;

	/**
	 *
	 *  Factor for increasing the delay between (re)connection attempts in case of repeated failures.
	 */
	retryDelayExponentFactor: number = 2.0;

	/**
	 *
	 *  How many times should the subscription attempt to (re)connect before closing with a [EntitySubscription.ConnectionException]
	 */
	connectionMaxRetries: number = 5;

	constructor(partial: Partial<EntitySubscriptionConfiguration>) {
		if ('channelBufferCapacity' in partial && partial.channelBufferCapacity !== undefined) this.channelBufferCapacity = partial.channelBufferCapacity;
		if ('onBufferFull' in partial && partial.onBufferFull !== undefined) this.onBufferFull = partial.onBufferFull;
		if ('reconnectionDelay' in partial && partial.reconnectionDelay !== undefined) this.reconnectionDelay = partial.reconnectionDelay;
		if ('retryDelayExponentFactor' in partial && partial.retryDelayExponentFactor !== undefined) this.retryDelayExponentFactor = partial.retryDelayExponentFactor;
		if ('connectionMaxRetries' in partial && partial.connectionMaxRetries !== undefined) this.connectionMaxRetries = partial.connectionMaxRetries;
	}

}

export namespace EntitySubscriptionConfiguration {

	export enum FullBufferBehaviour {
		Close = "Close",
		DropOldest = "DropOldest",
		Ignore = "Ignore"
	}

}
