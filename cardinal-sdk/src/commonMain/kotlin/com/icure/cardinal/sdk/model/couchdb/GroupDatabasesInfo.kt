package com.icure.cardinal.sdk.model.couchdb

import kotlinx.serialization.Serializable
import kotlin.Long
import kotlin.String
import kotlin.collections.List

@Serializable
public data class GroupDatabasesInfo(
	public val groupId: String,
	public val databasesInfo: List<DatabaseInfo>,
	public val gcpStorageSize: Long,
)
