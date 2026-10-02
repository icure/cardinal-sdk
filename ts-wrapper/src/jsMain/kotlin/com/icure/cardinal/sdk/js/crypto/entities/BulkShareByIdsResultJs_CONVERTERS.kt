// auto-generated file
package com.icure.cardinal.sdk.js.crypto.entities

import com.icure.cardinal.sdk.crypto.entities.BulkShareByIdsResult
import com.icure.cardinal.sdk.crypto.entities.FailedRequestDetails
import com.icure.cardinal.sdk.crypto.entities.SuccessfulRequestDetails
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToList
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.cardinal.sdk.js.model.CheckedConverters.listToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.mapToObject
import com.icure.cardinal.sdk.js.model.CheckedConverters.objectToMap
import com.icure.cardinal.sdk.js.model.CheckedConverters.setToArray
import com.icure.cardinal.sdk.js.model.EntityReferenceInGroupJs
import com.icure.cardinal.sdk.js.model.entityReferenceInGroup_fromJs
import com.icure.cardinal.sdk.js.model.entityReferenceInGroup_toJs
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import kotlin.Array
import kotlin.String
import kotlin.Suppress
import kotlin.collections.Set

@Suppress("UNUSED_VARIABLE")
public fun bulkShareByIdsResult_toJs(obj: BulkShareByIdsResult): BulkShareByIdsResultJs {
	val notFoundIds = setToArray(
		obj.notFoundIds,
		{ x1: String ->
			x1
		},
	)
	val successfulRequestsByEntityId = mapToObject(
		obj.successfulRequestsByEntityId,
		{ x1: String ->
			x1
		},
		{ x1: Set<SuccessfulRequestDetails> ->
			setToArray(
				x1,
				{ x2: SuccessfulRequestDetails ->
					successfulRequestDetails_toJs(x2)
				},
			)
		},
	)
	val unmodifiedDelegatesByEntityId = mapToObject(
		obj.unmodifiedDelegatesByEntityId,
		{ x1: String ->
			x1
		},
		{ x1: Set<EntityReferenceInGroup> ->
			setToArray(
				x1,
				{ x2: EntityReferenceInGroup ->
					entityReferenceInGroup_toJs(x2)
				},
			)
		},
	)
	val shareErrors = listToArray(
		obj.shareErrors,
		{ x1: FailedRequestDetails ->
			failedRequestDetails_toJs(x1)
		},
	)
	return BulkShareByIdsResultJs(js("{" +
		"notFoundIds:notFoundIds," +
		"successfulRequestsByEntityId:successfulRequestsByEntityId," +
		"unmodifiedDelegatesByEntityId:unmodifiedDelegatesByEntityId," +
		"shareErrors:shareErrors" +
	"}"))
}

public fun bulkShareByIdsResult_fromJs(obj: BulkShareByIdsResultJs): BulkShareByIdsResult {
	val notFoundIds = arrayToSet(
		obj.notFoundIds,
		"obj.notFoundIds",
		{ x1: String ->
			x1
		},
	)
	val successfulRequestsByEntityId = objectToMap(
		obj.successfulRequestsByEntityId,
		"obj.successfulRequestsByEntityId",
		{ x1: String ->
			x1
		},
		{ x1: Array<SuccessfulRequestDetailsJs> ->
			arrayToSet(
				x1,
				"x1",
				{ x2: SuccessfulRequestDetailsJs ->
					successfulRequestDetails_fromJs(x2)
				},
			)
		},
	)
	val unmodifiedDelegatesByEntityId = objectToMap(
		obj.unmodifiedDelegatesByEntityId,
		"obj.unmodifiedDelegatesByEntityId",
		{ x1: String ->
			x1
		},
		{ x1: Array<EntityReferenceInGroupJs> ->
			arrayToSet(
				x1,
				"x1",
				{ x2: EntityReferenceInGroupJs ->
					entityReferenceInGroup_fromJs(x2)
				},
			)
		},
	)
	val shareErrors = arrayToList(
		obj.shareErrors,
		"obj.shareErrors",
		{ x1: FailedRequestDetailsJs ->
			failedRequestDetails_fromJs(x1)
		},
	)
	return BulkShareByIdsResult(
		notFoundIds = notFoundIds,
		successfulRequestsByEntityId = successfulRequestsByEntityId,
		unmodifiedDelegatesByEntityId = unmodifiedDelegatesByEntityId,
		shareErrors = shareErrors,
	)
}
