// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.model.base.StoredDocument
import com.icure.cardinal.sdk.model.embed.FrontEndMigrationStatus
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Long
import kotlin.String
import kotlin.collections.Set

/**
 * Represents a front-end migration task. A front-end migration tracks the progress of data
 * migration operations
 * initiated from the front-end application.
 * /
 */
@Serializable
data class FrontEndMigration(
	/**
	 * The unique identifier of the front-end migration.
	 */
	override val id: String,
	/**
	 * The revision of the front-end migration in the database, used for conflict management /
	 * optimistic locking.
	 */
	override val rev: String? = null,
	/**
	 * Hard delete (unix epoch in ms) timestamp of the object.
	 */
	override val deletionDate: Long? = null,
	/**
	 * The name of the migration.
	 */
	public val name: String? = null,
	/**
	 * The start date (unix epoch in ms) of the migration.
	 */
	public val startDate: Long? = null,
	/**
	 * The end date (unix epoch in ms) of the migration.
	 */
	public val endDate: Long? = null,
	/**
	 * The current status of the migration.
	 */
	public val status: FrontEndMigrationStatus? = null,
	/**
	 * Logs produced during the migration process.
	 */
	public val logs: String? = null,
	/**
	 * The id of the user that initiated the migration.
	 */
	public val userId: String? = null,
	/**
	 * The start key used for pagination during migration.
	 */
	public val startKey: String? = null,
	/**
	 * The start key document id used for pagination during migration.
	 */
	public val startKeyDocId: String? = null,
	/**
	 * The number of items processed during the migration.
	 */
	public val processCount: Long? = null,
	/**
	 * Extra properties for the front-end migration. Those properties are typed (see class Property).
	 */
	@param:DefaultValue("emptySet()")
	public val properties: Set<DecryptedPropertyStub> = emptySet(),
) : StoredDocument {
	// region FrontEndMigration-FrontEndMigration

	// endregion
}
