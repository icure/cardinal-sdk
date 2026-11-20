// auto-generated file
package com.icure.cardinal.sdk.js.subscription

import com.icure.cardinal.sdk.js.model.base.IdentifiableJs
import com.icure.cardinal.sdk.model.base.Identifiable
import com.icure.cardinal.sdk.subscription.EntitySubscriptionEvent
import kotlin.String
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun <E : Identifiable<String>, E_JS : IdentifiableJs<String>> entitySubscriptionEvent_toJs(obj: EntitySubscriptionEvent<E>, convertE: (E) -> E_JS): EntitySubscriptionEventJs<E_JS> = when (obj) {
	is EntitySubscriptionEvent.Connected -> entitySubscriptionEvent_Connected_toJs(obj) as EntitySubscriptionEventJs<E_JS>
	is EntitySubscriptionEvent.Reconnected -> entitySubscriptionEvent_Reconnected_toJs(obj) as EntitySubscriptionEventJs<E_JS>
	is EntitySubscriptionEvent.ClosedByClient -> entitySubscriptionEvent_ClosedByClient_toJs(obj) as EntitySubscriptionEventJs<E_JS>
	is EntitySubscriptionEvent.UnexpectedError -> entitySubscriptionEvent_UnexpectedError_toJs(obj) as EntitySubscriptionEventJs<E_JS>
	is EntitySubscriptionEvent.ConnectionError.MissedPing -> entitySubscriptionEvent_ConnectionError_MissedPing_toJs(obj) as EntitySubscriptionEventJs<E_JS>
	is EntitySubscriptionEvent.ConnectionError.ClosedByServer -> entitySubscriptionEvent_ConnectionError_ClosedByServer_toJs(obj) as EntitySubscriptionEventJs<E_JS>
	is EntitySubscriptionEvent.ConnectionError.ConnectionLost -> entitySubscriptionEvent_ConnectionError_ConnectionLost_toJs(obj) as EntitySubscriptionEventJs<E_JS>
	is EntitySubscriptionEvent.EntityNotification<E> -> entitySubscriptionEvent_EntityNotification_toJs(
		obj,
		{ x1: E ->
			convertE(x1)
		},
	) as EntitySubscriptionEventJs<E_JS>
	is EntitySubscriptionEvent.EntityError.DeserializationError -> entitySubscriptionEvent_EntityError_DeserializationError_toJs(obj) as EntitySubscriptionEventJs<E_JS>
}

public fun <E : IdentifiableJs<String>, E_KT : Identifiable<String>> entitySubscriptionEvent_fromJs(obj: EntitySubscriptionEventJs<E>, convertE: (E) -> E_KT): EntitySubscriptionEvent<E_KT> = when {
	obj is EntitySubscriptionEventJs_ConnectedJs || obj.ktClass == "com.icure.cardinal.sdk.subscription.EntitySubscriptionEvent.Connected" ->entitySubscriptionEvent_Connected_fromJs(obj as com.icure.cardinal.sdk.js.subscription.EntitySubscriptionEventJs_ConnectedJs) as EntitySubscriptionEvent<E_KT>
	obj is EntitySubscriptionEventJs_ReconnectedJs || obj.ktClass == "com.icure.cardinal.sdk.subscription.EntitySubscriptionEvent.Reconnected" ->entitySubscriptionEvent_Reconnected_fromJs(obj as com.icure.cardinal.sdk.js.subscription.EntitySubscriptionEventJs_ReconnectedJs) as EntitySubscriptionEvent<E_KT>
	obj is EntitySubscriptionEventJs_ClosedByClientJs || obj.ktClass == "com.icure.cardinal.sdk.subscription.EntitySubscriptionEvent.ClosedByClient" ->entitySubscriptionEvent_ClosedByClient_fromJs(obj as com.icure.cardinal.sdk.js.subscription.EntitySubscriptionEventJs_ClosedByClientJs) as EntitySubscriptionEvent<E_KT>
	obj is EntitySubscriptionEventJs_UnexpectedErrorJs || obj.ktClass == "com.icure.cardinal.sdk.subscription.EntitySubscriptionEvent.UnexpectedError" ->entitySubscriptionEvent_UnexpectedError_fromJs(obj as com.icure.cardinal.sdk.js.subscription.EntitySubscriptionEventJs_UnexpectedErrorJs) as EntitySubscriptionEvent<E_KT>
	obj is EntitySubscriptionEventJs_ConnectionErrorJs_MissedPingJs || obj.ktClass == "com.icure.cardinal.sdk.subscription.EntitySubscriptionEvent.ConnectionError.MissedPing" ->entitySubscriptionEvent_ConnectionError_MissedPing_fromJs(obj as com.icure.cardinal.sdk.js.subscription.EntitySubscriptionEventJs_ConnectionErrorJs_MissedPingJs) as EntitySubscriptionEvent<E_KT>
	obj is EntitySubscriptionEventJs_ConnectionErrorJs_ClosedByServerJs || obj.ktClass == "com.icure.cardinal.sdk.subscription.EntitySubscriptionEvent.ConnectionError.ClosedByServer" ->entitySubscriptionEvent_ConnectionError_ClosedByServer_fromJs(obj as com.icure.cardinal.sdk.js.subscription.EntitySubscriptionEventJs_ConnectionErrorJs_ClosedByServerJs) as EntitySubscriptionEvent<E_KT>
	obj is EntitySubscriptionEventJs_ConnectionErrorJs_ConnectionLostJs || obj.ktClass == "com.icure.cardinal.sdk.subscription.EntitySubscriptionEvent.ConnectionError.ConnectionLost" ->entitySubscriptionEvent_ConnectionError_ConnectionLost_fromJs(obj as com.icure.cardinal.sdk.js.subscription.EntitySubscriptionEventJs_ConnectionErrorJs_ConnectionLostJs) as EntitySubscriptionEvent<E_KT>
	obj is EntitySubscriptionEventJs_EntityNotificationJs<E> || obj.ktClass == "com.icure.cardinal.sdk.subscription.EntitySubscriptionEvent.EntityNotification" ->entitySubscriptionEvent_EntityNotification_fromJs(
		obj as com.icure.cardinal.sdk.js.subscription.EntitySubscriptionEventJs_EntityNotificationJs<E>,
		{ x1: E ->
			convertE(x1)
		},
	) as EntitySubscriptionEvent<E_KT>
	obj is EntitySubscriptionEventJs_EntityErrorJs_DeserializationErrorJs || obj.ktClass == "com.icure.cardinal.sdk.subscription.EntitySubscriptionEvent.EntityError.DeserializationError" ->entitySubscriptionEvent_EntityError_DeserializationError_fromJs(obj as com.icure.cardinal.sdk.js.subscription.EntitySubscriptionEventJs_EntityErrorJs_DeserializationErrorJs) as EntitySubscriptionEvent<E_KT>
	else -> throw IllegalArgumentException("""Unknown concrete implementation for com.icure.cardinal.sdk.subscription.EntitySubscriptionEvent: $obj""")
}

@Suppress("UNUSED_VARIABLE")
public fun entitySubscriptionEvent_Connected_toJs(obj: EntitySubscriptionEvent.Connected): EntitySubscriptionEventJs_ConnectedJs = EntitySubscriptionEventJs_ConnectedJs

public fun entitySubscriptionEvent_Connected_fromJs(obj: EntitySubscriptionEventJs_ConnectedJs): EntitySubscriptionEvent.Connected = EntitySubscriptionEvent.Connected

@Suppress("UNUSED_VARIABLE")
public fun entitySubscriptionEvent_Reconnected_toJs(obj: EntitySubscriptionEvent.Reconnected): EntitySubscriptionEventJs_ReconnectedJs = EntitySubscriptionEventJs_ReconnectedJs

public fun entitySubscriptionEvent_Reconnected_fromJs(obj: EntitySubscriptionEventJs_ReconnectedJs): EntitySubscriptionEvent.Reconnected = EntitySubscriptionEvent.Reconnected

@Suppress("UNUSED_VARIABLE")
public fun entitySubscriptionEvent_ClosedByClient_toJs(obj: EntitySubscriptionEvent.ClosedByClient): EntitySubscriptionEventJs_ClosedByClientJs = EntitySubscriptionEventJs_ClosedByClientJs

public fun entitySubscriptionEvent_ClosedByClient_fromJs(obj: EntitySubscriptionEventJs_ClosedByClientJs): EntitySubscriptionEvent.ClosedByClient = EntitySubscriptionEvent.ClosedByClient

@Suppress("UNUSED_VARIABLE")
public fun entitySubscriptionEvent_UnexpectedError_toJs(obj: EntitySubscriptionEvent.UnexpectedError): EntitySubscriptionEventJs_UnexpectedErrorJs {
	val message = obj.message
	return EntitySubscriptionEventJs_UnexpectedErrorJs(js("{" +
		"message:message" +
	"}"))
}

public fun entitySubscriptionEvent_UnexpectedError_fromJs(obj: EntitySubscriptionEventJs_UnexpectedErrorJs): EntitySubscriptionEvent.UnexpectedError {
	val message = obj.message
	return EntitySubscriptionEvent.UnexpectedError(
		message = message,
	)
}

@Suppress("UNUSED_VARIABLE")
public fun entitySubscriptionEvent_ConnectionError_MissedPing_toJs(obj: EntitySubscriptionEvent.ConnectionError.MissedPing): EntitySubscriptionEventJs_ConnectionErrorJs_MissedPingJs = EntitySubscriptionEventJs_ConnectionErrorJs_MissedPingJs

public fun entitySubscriptionEvent_ConnectionError_MissedPing_fromJs(obj: EntitySubscriptionEventJs_ConnectionErrorJs_MissedPingJs): EntitySubscriptionEvent.ConnectionError.MissedPing = EntitySubscriptionEvent.ConnectionError.MissedPing

@Suppress("UNUSED_VARIABLE")
public fun entitySubscriptionEvent_ConnectionError_ClosedByServer_toJs(obj: EntitySubscriptionEvent.ConnectionError.ClosedByServer): EntitySubscriptionEventJs_ConnectionErrorJs_ClosedByServerJs = EntitySubscriptionEventJs_ConnectionErrorJs_ClosedByServerJs

public fun entitySubscriptionEvent_ConnectionError_ClosedByServer_fromJs(obj: EntitySubscriptionEventJs_ConnectionErrorJs_ClosedByServerJs): EntitySubscriptionEvent.ConnectionError.ClosedByServer = EntitySubscriptionEvent.ConnectionError.ClosedByServer

@Suppress("UNUSED_VARIABLE")
public fun entitySubscriptionEvent_ConnectionError_ConnectionLost_toJs(obj: EntitySubscriptionEvent.ConnectionError.ConnectionLost): EntitySubscriptionEventJs_ConnectionErrorJs_ConnectionLostJs = EntitySubscriptionEventJs_ConnectionErrorJs_ConnectionLostJs

public fun entitySubscriptionEvent_ConnectionError_ConnectionLost_fromJs(obj: EntitySubscriptionEventJs_ConnectionErrorJs_ConnectionLostJs): EntitySubscriptionEvent.ConnectionError.ConnectionLost = EntitySubscriptionEvent.ConnectionError.ConnectionLost

@Suppress("UNUSED_VARIABLE")
public fun <E : Identifiable<String>, E_JS : IdentifiableJs<String>> entitySubscriptionEvent_EntityNotification_toJs(obj: EntitySubscriptionEvent.EntityNotification<E>, convertE: (E) -> E_JS): EntitySubscriptionEventJs_EntityNotificationJs<E_JS> {
	val entity = convertE(obj.entity)
	return EntitySubscriptionEventJs_EntityNotificationJs<E_JS>(js("{" +
		"entity:entity" +
	"}"))
}

public fun <E : IdentifiableJs<String>, E_KT : Identifiable<String>> entitySubscriptionEvent_EntityNotification_fromJs(obj: EntitySubscriptionEventJs_EntityNotificationJs<E>, convertE: (E) -> E_KT): EntitySubscriptionEvent.EntityNotification<E_KT> {
	val entity = convertE(obj.entity)
	return EntitySubscriptionEvent.EntityNotification<E_KT>(
		entity = entity,
	)
}

@Suppress("UNUSED_VARIABLE")
public fun entitySubscriptionEvent_EntityError_DeserializationError_toJs(obj: EntitySubscriptionEvent.EntityError.DeserializationError): EntitySubscriptionEventJs_EntityErrorJs_DeserializationErrorJs = EntitySubscriptionEventJs_EntityErrorJs_DeserializationErrorJs

public fun entitySubscriptionEvent_EntityError_DeserializationError_fromJs(obj: EntitySubscriptionEventJs_EntityErrorJs_DeserializationErrorJs): EntitySubscriptionEvent.EntityError.DeserializationError = EntitySubscriptionEvent.EntityError.DeserializationError
