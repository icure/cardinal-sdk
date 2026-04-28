// auto-generated file
package com.icure.cardinal.sdk.js.model.embed

import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToList
import com.icure.cardinal.sdk.js.model.CheckedConverters.listToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.longToNumber
import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToLong
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.model.embed.DataAttachment
import kotlin.String
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun dataAttachment_toJs(obj: DataAttachment): DataAttachmentJs {
	val couchDbAttachmentId = nullToUndefined(
		obj.couchDbAttachmentId
	)
	val objectStoreAttachmentId = nullToUndefined(
		obj.objectStoreAttachmentId
	)
	val utis = listToArray(
		obj.utis,
		{ x1: String ->
			x1
		},
	)
	val compressionAlgorithm = nullToUndefined(
		obj.compressionAlgorithm
	)
	val triedCompressionAlgorithmsVersion = nullToUndefined(
		obj.triedCompressionAlgorithmsVersion
	)
	val storedDataSize = nullToUndefined(
		longToNumber(obj.storedDataSize)
	)
	val realDataSize = nullToUndefined(
		longToNumber(obj.realDataSize)
	)
	return DataAttachmentJs(js("{" +
		"couchDbAttachmentId:couchDbAttachmentId," +
		"objectStoreAttachmentId:objectStoreAttachmentId," +
		"utis:utis," +
		"compressionAlgorithm:compressionAlgorithm," +
		"triedCompressionAlgorithmsVersion:triedCompressionAlgorithmsVersion," +
		"storedDataSize:storedDataSize," +
		"realDataSize:realDataSize" +
	"}"))
}

public fun dataAttachment_fromJs(obj: DataAttachmentJs): DataAttachment {
	val couchDbAttachmentId = undefinedToNull(obj.couchDbAttachmentId)
	val objectStoreAttachmentId = undefinedToNull(obj.objectStoreAttachmentId)
	val utis = arrayToList(
		obj.utis,
		"obj.utis",
		{ x1: String ->
			x1
		},
	)
	val compressionAlgorithm = undefinedToNull(obj.compressionAlgorithm)
	val triedCompressionAlgorithmsVersion = undefinedToNull(obj.triedCompressionAlgorithmsVersion)
	val storedDataSize = numberToLong(obj.storedDataSize, "obj.storedDataSize")
	val realDataSize = numberToLong(obj.realDataSize, "obj.realDataSize")
	return DataAttachment(
		couchDbAttachmentId = couchDbAttachmentId,
		objectStoreAttachmentId = objectStoreAttachmentId,
		utis = utis,
		compressionAlgorithm = compressionAlgorithm,
		triedCompressionAlgorithmsVersion = triedCompressionAlgorithmsVersion,
		storedDataSize = storedDataSize,
		realDataSize = realDataSize,
	)
}
