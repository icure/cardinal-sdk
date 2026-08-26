// auto-generated file
package com.icure.cardinal.sdk.js.crypto.entities

import com.icure.cardinal.sdk.crypto.entities.FailedRequestDetails
import com.icure.cardinal.sdk.js.model.CheckedConverters.intToNumber
import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToInt
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.js.model.entityReferenceInGroup_fromJs
import com.icure.cardinal.sdk.js.model.entityReferenceInGroup_toJs
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun failedRequestDetails_toJs(obj: FailedRequestDetails): FailedRequestDetailsJs = when (obj)
		{
	is FailedRequestDetails.ResolutionFailed -> failedRequestDetails_ResolutionFailed_toJs(obj)
	is FailedRequestDetails.RequestRejected -> failedRequestDetails_RequestRejected_toJs(obj)
}

public fun failedRequestDetails_fromJs(obj: FailedRequestDetailsJs): FailedRequestDetails = when {
	obj is FailedRequestDetailsJs_ResolutionFailedJs || obj.ktClass ==
			"com.icure.cardinal.sdk.crypto.entities.FailedRequestDetails.ResolutionFailed" ->failedRequestDetails_ResolutionFailed_fromJs(obj
			as com.icure.cardinal.sdk.js.crypto.entities.FailedRequestDetailsJs_ResolutionFailedJs)
	obj is FailedRequestDetailsJs_RequestRejectedJs || obj.ktClass ==
			"com.icure.cardinal.sdk.crypto.entities.FailedRequestDetails.RequestRejected" ->failedRequestDetails_RequestRejected_fromJs(obj
			as com.icure.cardinal.sdk.js.crypto.entities.FailedRequestDetailsJs_RequestRejectedJs)
	else -> throw
			IllegalArgumentException("""Unknown concrete implementation for com.icure.cardinal.sdk.crypto.entities.FailedRequestDetails: $obj""")
}

@Suppress("UNUSED_VARIABLE")
public fun failedRequestDetails_ResolutionFailed_toJs(obj: FailedRequestDetails.ResolutionFailed):
		FailedRequestDetailsJs_ResolutionFailedJs {
	val entityId = obj.entityId
	val delegateReference = entityReferenceInGroup_toJs(obj.delegateReference)
	val reason = nullToUndefined(
		obj.reason
	)
	return FailedRequestDetailsJs_ResolutionFailedJs(js("{" +
		"entityId:entityId," +
		"delegateReference:delegateReference," +
		"reason:reason" +
	"}"))
}

public
		fun failedRequestDetails_ResolutionFailed_fromJs(obj: FailedRequestDetailsJs_ResolutionFailedJs):
		FailedRequestDetails.ResolutionFailed {
	val entityId = obj.entityId
	val delegateReference = entityReferenceInGroup_fromJs(obj.delegateReference)
	val reason = undefinedToNull(obj.reason)
	return FailedRequestDetails.ResolutionFailed(
		entityId = entityId,
		delegateReference = delegateReference,
		reason = reason,
	)
}

@Suppress("UNUSED_VARIABLE")
public fun failedRequestDetails_RequestRejected_toJs(obj: FailedRequestDetails.RequestRejected):
		FailedRequestDetailsJs_RequestRejectedJs {
	val entityId = obj.entityId
	val delegateReference = entityReferenceInGroup_toJs(obj.delegateReference)
	val reason = nullToUndefined(
		obj.reason
	)
	val code = intToNumber(obj.code)
	val shouldRetry = obj.shouldRetry
	val updatedForMigration = obj.updatedForMigration
	val request = nullToUndefined(
		obj.request?.let { nonNull1 ->
			delegateShareOptions_toJs(nonNull1)
		}
	)
	return FailedRequestDetailsJs_RequestRejectedJs(js("{" +
		"entityId:entityId," +
		"delegateReference:delegateReference," +
		"reason:reason," +
		"code:code," +
		"shouldRetry:shouldRetry," +
		"updatedForMigration:updatedForMigration," +
		"request:request" +
	"}"))
}

public
		fun failedRequestDetails_RequestRejected_fromJs(obj: FailedRequestDetailsJs_RequestRejectedJs):
		FailedRequestDetails.RequestRejected {
	val entityId = obj.entityId
	val delegateReference = entityReferenceInGroup_fromJs(obj.delegateReference)
	val reason = undefinedToNull(obj.reason)
	val code = numberToInt(obj.code, "obj.code")
	val shouldRetry = obj.shouldRetry
	val updatedForMigration = obj.updatedForMigration
	val request = obj.request?.let { nonNull1 ->
		delegateShareOptions_fromJs(nonNull1)
	}
	return FailedRequestDetails.RequestRejected(
		entityId = entityId,
		delegateReference = delegateReference,
		reason = reason,
		code = code,
		shouldRetry = shouldRetry,
		updatedForMigration = updatedForMigration,
		request = request,
	)
}
