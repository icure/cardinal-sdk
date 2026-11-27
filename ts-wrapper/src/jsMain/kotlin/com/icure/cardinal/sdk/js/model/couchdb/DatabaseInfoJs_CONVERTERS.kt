// auto-generated file
package com.icure.cardinal.sdk.js.model.couchdb

import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.cardinal.sdk.js.model.CheckedConverters.intToNumber
import com.icure.cardinal.sdk.js.model.CheckedConverters.longToNumber
import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToInt
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToLong
import com.icure.cardinal.sdk.js.model.CheckedConverters.setToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.model.couchdb.DatabaseInfo
import kotlin.String
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun databaseInfo_toJs(obj: DatabaseInfo): DatabaseInfoJs {
	val id = obj.id
	val updateSeq = nullToUndefined(
		obj.updateSeq
	)
	val fileSize = nullToUndefined(
		longToNumber(obj.fileSize)
	)
	val externalSize = nullToUndefined(
		longToNumber(obj.externalSize)
	)
	val activeSize = nullToUndefined(
		longToNumber(obj.activeSize)
	)
	val docs = nullToUndefined(
		longToNumber(obj.docs)
	)
	val q = nullToUndefined(
		intToNumber(obj.q)
	)
	val n = nullToUndefined(
		intToNumber(obj.n)
	)
	val w = nullToUndefined(
		intToNumber(obj.w)
	)
	val r = nullToUndefined(
		intToNumber(obj.r)
	)
	val zones = setToArray(
		obj.zones,
		{ x1: String ->
			x1
		},
	)
	return DatabaseInfoJs(js("{" +
		"id:id," +
		"updateSeq:updateSeq," +
		"fileSize:fileSize," +
		"externalSize:externalSize," +
		"activeSize:activeSize," +
		"docs:docs," +
		"q:q," +
		"n:n," +
		"w:w," +
		"r:r," +
		"zones:zones" +
	"}"))
}

public fun databaseInfo_fromJs(obj: DatabaseInfoJs): DatabaseInfo {
	val id = obj.id
	val updateSeq = undefinedToNull(obj.updateSeq)
	val fileSize = numberToLong(obj.fileSize, "obj.fileSize")
	val externalSize = numberToLong(obj.externalSize, "obj.externalSize")
	val activeSize = numberToLong(obj.activeSize, "obj.activeSize")
	val docs = numberToLong(obj.docs, "obj.docs")
	val q = numberToInt(obj.q, "obj.q")
	val n = numberToInt(obj.n, "obj.n")
	val w = numberToInt(obj.w, "obj.w")
	val r = numberToInt(obj.r, "obj.r")
	val zones = arrayToSet(
		obj.zones,
		"obj.zones",
		{ x1: String ->
			x1
		},
	)
	return DatabaseInfo(
		id = id,
		updateSeq = updateSeq,
		fileSize = fileSize,
		externalSize = externalSize,
		activeSize = activeSize,
		docs = docs,
		q = q,
		n = n,
		w = w,
		r = r,
		zones = zones,
	)
}
