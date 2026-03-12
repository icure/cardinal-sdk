// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.couchdb

import kotlinx.serialization.Serializable
import kotlin.Long
import kotlin.String
import kotlin.collections.List

/**
 * Data transfer object aggregating database information for all databases belonging to a specific
 * group,
 * including their storage sizes and GCP storage usage.
 * /
 */
@Serializable
data class GroupDatabasesInfo(
	/**
	 * The identifier of the group.
	 */
	public val groupId: String,
	/**
	 * The list of database information entries for this group.
	 */
	public val databasesInfo: List<DatabaseInfo>,
	/**
	 * The total GCP storage size in bytes used by this group.
	 */
	public val gcpStorageSize: Long,
) {
	// region GroupDatabasesInfo-GroupDatabasesInfo

	// endregion
}
