// auto-generated file
package com.icure.cardinal.sdk.js.crypto.entities

import com.icure.cardinal.sdk.crypto.entities.BulkShareByIdsResult
import com.icure.cardinal.sdk.crypto.entities.FailedRequestDetails
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToList
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.cardinal.sdk.js.model.CheckedConverters.listToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.mapToObject
import com.icure.cardinal.sdk.js.model.CheckedConverters.objectToMap
import com.icure.cardinal.sdk.js.model.CheckedConverters.setToArray
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
	val successfulDelegateIdsByEntityId = mapToObject(
		obj.successfulDelegateIdsByEntityId,
		{ x1: String ->
			x1
		},
		{ x1: Set<String> ->
			setToArray(
				x1,
				{ x2: String ->
					x2
				},
			)
		},
	)
	val unmodifiedDelegateIdsByEntityId = mapToObject(
		obj.unmodifiedDelegateIdsByEntityId,
		{ x1: String ->
			x1
		},
		{ x1: Set<String> ->
			setToArray(
				x1,
				{ x2: String ->
					x2
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
		"successfulDelegateIdsByEntityId:successfulDelegateIdsByEntityId," +
		"unmodifiedDelegateIdsByEntityId:unmodifiedDelegateIdsByEntityId," +
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
	val successfulDelegateIdsByEntityId = objectToMap(
		obj.successfulDelegateIdsByEntityId,
		"obj.successfulDelegateIdsByEntityId",
		{ x1: String ->
			x1
		},
		{ x1: Array<String> ->
			arrayToSet(
				x1,
				"x1",
				{ x2: String ->
					x2
				},
			)
		},
	)
	val unmodifiedDelegateIdsByEntityId = objectToMap(
		obj.unmodifiedDelegateIdsByEntityId,
		"obj.unmodifiedDelegateIdsByEntityId",
		{ x1: String ->
			x1
		},
		{ x1: Array<String> ->
			arrayToSet(
				x1,
				"x1",
				{ x2: String ->
					x2
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
		successfulDelegateIdsByEntityId = successfulDelegateIdsByEntityId,
		unmodifiedDelegateIdsByEntityId = unmodifiedDelegateIdsByEntityId,
		shareErrors = shareErrors,
	)
}
