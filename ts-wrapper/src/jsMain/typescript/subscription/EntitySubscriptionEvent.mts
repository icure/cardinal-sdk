// auto-generated file
import {Identifiable} from '../model/base/Identifiable.mjs';


/**
 *
 *  Events that a subscription observes.
 */
export type EntitySubscriptionEvent<E extends Identifiable<string>> = typeof EntitySubscriptionEvent.Connected | typeof EntitySubscriptionEvent.Reconnected | typeof EntitySubscriptionEvent.ClosedByClient | EntitySubscriptionEvent.UnexpectedError | EntitySubscriptionEvent.ConnectionError | EntitySubscriptionEvent.EntityNotification<E> | EntitySubscriptionEvent.EntityError;

export namespace EntitySubscriptionEvent {

	export const Connected: {
		readonly $ktClass: 'com.icure.cardinal.sdk.subscription.EntitySubscriptionEvent.Connected'
	} = {
		$ktClass: 'com.icure.cardinal.sdk.subscription.EntitySubscriptionEvent.Connected'
	}

	export const Reconnected: {
		readonly $ktClass: 'com.icure.cardinal.sdk.subscription.EntitySubscriptionEvent.Reconnected'
	} = {
		$ktClass: 'com.icure.cardinal.sdk.subscription.EntitySubscriptionEvent.Reconnected'
	}

	export const ClosedByClient: {
		readonly $ktClass: 'com.icure.cardinal.sdk.subscription.EntitySubscriptionEvent.ClosedByClient'
	} = {
		$ktClass: 'com.icure.cardinal.sdk.subscription.EntitySubscriptionEvent.ClosedByClient'
	}

	/**
	 *
	 *  A general unexpected error.
	 */
	export class UnexpectedError {

		message: string;

		readonly $ktClass: 'com.icure.cardinal.sdk.subscription.EntitySubscriptionEvent.UnexpectedError' = 'com.icure.cardinal.sdk.subscription.EntitySubscriptionEvent.UnexpectedError';

		constructor(partial: Partial<UnexpectedError> & Pick<UnexpectedError, "message">) {
			this.message = partial.message;
		}

	}

	export namespace ConnectionError {

		export const MissedPing: {
			readonly $ktClass: 'com.icure.cardinal.sdk.subscription.EntitySubscriptionEvent.ConnectionError.MissedPing'
		} = {
			$ktClass: 'com.icure.cardinal.sdk.subscription.EntitySubscriptionEvent.ConnectionError.MissedPing'
		}

		export const ClosedByServer: {
			readonly $ktClass: 'com.icure.cardinal.sdk.subscription.EntitySubscriptionEvent.ConnectionError.ClosedByServer'
		} = {
			$ktClass: 'com.icure.cardinal.sdk.subscription.EntitySubscriptionEvent.ConnectionError.ClosedByServer'
		}

		export const ConnectionLost: {
			readonly $ktClass: 'com.icure.cardinal.sdk.subscription.EntitySubscriptionEvent.ConnectionError.ConnectionLost'
		} = {
			$ktClass: 'com.icure.cardinal.sdk.subscription.EntitySubscriptionEvent.ConnectionError.ConnectionLost'
		}

	}

	/**
	 *
	 *  There was an error in the connection with the backend.
	 */
	export type ConnectionError = typeof ConnectionError.MissedPing | typeof ConnectionError.ClosedByServer | typeof ConnectionError.ConnectionLost;

	/**
	 *
	 *  A change has been made to an entity that matches the configured filters.
	 *  @param entity the updated entity.
	 */
	export class EntityNotification<E extends Identifiable<string>> {

		entity: E;

		readonly $ktClass: 'com.icure.cardinal.sdk.subscription.EntitySubscriptionEvent.EntityNotification' = 'com.icure.cardinal.sdk.subscription.EntitySubscriptionEvent.EntityNotification';

		constructor(partial: Partial<EntityNotification<E>> & Pick<EntityNotification<E>, "entity">) {
			this.entity = partial.entity;
		}

	}

	export namespace EntityError {

		export const DeserializationError: {
			readonly $ktClass: 'com.icure.cardinal.sdk.subscription.EntitySubscriptionEvent.EntityError.DeserializationError'
		} = {
			$ktClass: 'com.icure.cardinal.sdk.subscription.EntitySubscriptionEvent.EntityError.DeserializationError'
		}

	}

	/**
	 *
	 *  The backend has notified the subscription of a change to an entity, but the entity can't be used by the client.
	 */
	export type EntityError = typeof EntityError.DeserializationError;

}
