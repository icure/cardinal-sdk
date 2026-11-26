// auto-generated file
@file:JsQualifier("model")

package com.icure.cardinal.sdk.js.model.couchdb

import com.icure.cardinal.sdk.js.utils.Record
import kotlin.Array
import kotlin.Double
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("GroupDatabasesInfo")
public external class GroupDatabasesInfoJs(
	partial: dynamic,
) {
	public val groupId: String

	public val databasesInfo: Array<DatabaseInfoJs>

	public val objectStorageSize: Double

	public val objectStorageInfo: Record<String, GroupDatabasesInfoJs_ObjectStorageInfoJs>
}
