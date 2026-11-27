// auto-generated file
package com.icure.cardinal.sdk.js.model.couchdb

import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToList
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.cardinal.sdk.js.model.CheckedConverters.listToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.longToNumber
import com.icure.cardinal.sdk.js.model.CheckedConverters.mapToObject
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToLong
import com.icure.cardinal.sdk.js.model.CheckedConverters.objectToMap
import com.icure.cardinal.sdk.js.model.CheckedConverters.setToArray
import com.icure.cardinal.sdk.model.couchdb.DatabaseInfo
import com.icure.cardinal.sdk.model.couchdb.GroupDatabasesInfo
import kotlin.String
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun groupDatabasesInfo_toJs(obj: GroupDatabasesInfo): GroupDatabasesInfoJs {
	val groupId = obj.groupId
	val databasesInfo = listToArray(
		obj.databasesInfo,
		{ x1: DatabaseInfo ->
			databaseInfo_toJs(x1)
		},
	)
	val objectStorageSize = longToNumber(obj.objectStorageSize)
	val objectStorageInfo = mapToObject(
		obj.objectStorageInfo,
		{ x1: String ->
			x1
		},
		{ x1: GroupDatabasesInfo.ObjectStorageInfo ->
			groupDatabasesInfo_ObjectStorageInfo_toJs(x1)
		},
	)
	return GroupDatabasesInfoJs(js("{" +
		"groupId:groupId," +
		"databasesInfo:databasesInfo," +
		"objectStorageSize:objectStorageSize," +
		"objectStorageInfo:objectStorageInfo" +
	"}"))
}

public fun groupDatabasesInfo_fromJs(obj: GroupDatabasesInfoJs): GroupDatabasesInfo {
	val groupId = obj.groupId
	val databasesInfo = arrayToList(
		obj.databasesInfo,
		"obj.databasesInfo",
		{ x1: DatabaseInfoJs ->
			databaseInfo_fromJs(x1)
		},
	)
	val objectStorageSize = numberToLong(obj.objectStorageSize, "obj.objectStorageSize")
	val objectStorageInfo = objectToMap(
		obj.objectStorageInfo,
		"obj.objectStorageInfo",
		{ x1: String ->
			x1
		},
		{ x1: GroupDatabasesInfoJs_ObjectStorageInfoJs ->
			groupDatabasesInfo_ObjectStorageInfo_fromJs(x1)
		},
	)
	return GroupDatabasesInfo(
		groupId = groupId,
		databasesInfo = databasesInfo,
		objectStorageSize = objectStorageSize,
		objectStorageInfo = objectStorageInfo,
	)
}

@Suppress("UNUSED_VARIABLE")
public fun groupDatabasesInfo_ObjectStorageInfo_toJs(obj: GroupDatabasesInfo.ObjectStorageInfo): GroupDatabasesInfoJs_ObjectStorageInfoJs {
	val size = longToNumber(obj.size)
	val regions = setToArray(
		obj.regions,
		{ x1: String ->
			x1
		},
	)
	return GroupDatabasesInfoJs_ObjectStorageInfoJs(js("{" +
		"size:size," +
		"regions:regions" +
	"}"))
}

public fun groupDatabasesInfo_ObjectStorageInfo_fromJs(obj: GroupDatabasesInfoJs_ObjectStorageInfoJs): GroupDatabasesInfo.ObjectStorageInfo {
	val size = numberToLong(obj.size, "obj.size")
	val regions = arrayToSet(
		obj.regions,
		"obj.regions",
		{ x1: String ->
			x1
		},
	)
	return GroupDatabasesInfo.ObjectStorageInfo(
		size = size,
		regions = regions,
	)
}
