package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.model.base.Identifiable
import com.icure.cardinal.sdk.model.base.Named
import com.icure.cardinal.sdk.model.base.StoredDocument
import com.icure.cardinal.sdk.model.embed.DatabaseSynchronization
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Long
import kotlin.String
import kotlin.collections.List

/**
 * DTO representing a replication configuration, defining how databases are synchronized between
 * CouchDB instances.
 * /
 */
@Serializable
public data class Replication(
	/**
	 * The unique identifier of the replication.
	 */
	override val id: String,
	/**
	 * The revision identifier for optimistic locking.
	 */
	override val rev: String? = null,
	/**
	 * The soft-delete timestamp in epoch milliseconds.
	 */
	override val deletionDate: Long? = null,
	/**
	 * The display name of this replication configuration.
	 */
	override val name: String? = null,
	/**
	 * The context or environment for this replication.
	 */
	public val context: String? = null,
	/**
	 * The list of database synchronization rules defined in this replication.
	 */
	@param:DefaultValue("emptyList()")
	public val databaseSynchronizations: List<DatabaseSynchronization> = emptyList(),
) : StoredDocument, Identifiable<String>, Named
