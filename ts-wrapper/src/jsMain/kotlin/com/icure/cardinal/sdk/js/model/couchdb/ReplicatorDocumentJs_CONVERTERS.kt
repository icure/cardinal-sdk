// auto-generated file
package com.icure.cardinal.sdk.js.model.couchdb

import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToList
import com.icure.cardinal.sdk.js.model.CheckedConverters.intToNumber
import com.icure.cardinal.sdk.js.model.CheckedConverters.listToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.mapToObject
import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToInt
import com.icure.cardinal.sdk.js.model.CheckedConverters.objectToMap
import com.icure.cardinal.sdk.js.model.CheckedConverters.stringToZonedDateTime
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.js.model.CheckedConverters.zonedDateTimeToString
import com.icure.cardinal.sdk.js.utils.Record
import com.icure.cardinal.sdk.model.couchdb.ReplicatorDocument
import kotlin.String
import kotlin.Suppress
import kotlin.collections.Map

@Suppress("UNUSED_VARIABLE")
public fun replicatorDocument_toJs(obj: ReplicatorDocument): ReplicatorDocumentJs {
	val id = obj.id
	val rev = nullToUndefined(
		obj.rev
	)
	val source = nullToUndefined(
		obj.source?.let { nonNull1 ->
			remote_toJs(nonNull1)
		}
	)
	val target = nullToUndefined(
		obj.target?.let { nonNull1 ->
			remote_toJs(nonNull1)
		}
	)
	val owner = nullToUndefined(
		obj.owner
	)
	val create_target = nullToUndefined(
		obj.create_target
	)
	val continuous = nullToUndefined(
		obj.continuous
	)
	val doc_ids = nullToUndefined(
		listToArray(
			obj.doc_ids,
			{ x1: String ->
				x1
			},
		)
	)
	val replicationState = nullToUndefined(
		obj.replicationState
	)
	val replicationStateTime = nullToUndefined(
		zonedDateTimeToString(obj.replicationStateTime)
	)
	val replicationStats = nullToUndefined(
		obj.replicationStats?.let { nonNull1 ->
			replicationStats_toJs(nonNull1)
		}
	)
	val errorCount = nullToUndefined(
		intToNumber(obj.errorCount)
	)
	val revsInfo = nullToUndefined(
		listToArray(
			obj.revsInfo,
			{ x1: Map<String, String> ->
				mapToObject(
					x1,
					{ x2: String ->
						x2
					},
					{ x2: String ->
						x2
					},
				)
			},
		)
	)
	return ReplicatorDocumentJs(js("{" +
		"id:id," +
		"rev:rev," +
		"source:source," +
		"target:target," +
		"owner:owner," +
		"create_target:create_target," +
		"continuous:continuous," +
		"doc_ids:doc_ids," +
		"replicationState:replicationState," +
		"replicationStateTime:replicationStateTime," +
		"replicationStats:replicationStats," +
		"errorCount:errorCount," +
		"revsInfo:revsInfo" +
	"}"))
}

public fun replicatorDocument_fromJs(obj: ReplicatorDocumentJs): ReplicatorDocument {
	val id = obj.id
	val rev = undefinedToNull(obj.rev)
	val source = obj.source?.let { nonNull1 ->
		remote_fromJs(nonNull1)
	}
	val target = obj.target?.let { nonNull1 ->
		remote_fromJs(nonNull1)
	}
	val owner = undefinedToNull(obj.owner)
	val create_target = undefinedToNull(obj.create_target)
	val continuous = undefinedToNull(obj.continuous)
	val doc_ids = arrayToList(
		obj.doc_ids,
		"obj.doc_ids",
		{ x1: String ->
			x1
		},
	)
	val replicationState = undefinedToNull(obj.replicationState)
	val replicationStateTime = stringToZonedDateTime(obj.replicationStateTime,
			"obj.replicationStateTime")
	val replicationStats = obj.replicationStats?.let { nonNull1 ->
		replicationStats_fromJs(nonNull1)
	}
	val errorCount = numberToInt(obj.errorCount, "obj.errorCount")
	val revsInfo = arrayToList(
		obj.revsInfo,
		"obj.revsInfo",
		{ x1: Record<String, String> ->
			objectToMap(
				x1,
				"x1",
				{ x2: String ->
					x2
				},
				{ x2: String ->
					x2
				},
			)
		},
	)
	return ReplicatorDocument(
		id = id,
		rev = rev,
		source = source,
		target = target,
		owner = owner,
		create_target = create_target,
		continuous = continuous,
		doc_ids = doc_ids,
		replicationState = replicationState,
		replicationStateTime = replicationStateTime,
		replicationStats = replicationStats,
		errorCount = errorCount,
		revsInfo = revsInfo,
	)
}
