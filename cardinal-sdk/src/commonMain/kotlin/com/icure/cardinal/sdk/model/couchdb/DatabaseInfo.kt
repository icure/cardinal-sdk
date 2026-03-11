package com.icure.cardinal.sdk.model.couchdb

import kotlinx.serialization.Serializable
import kotlin.Int
import kotlin.Long
import kotlin.String

/**
 * Data transfer object containing information about a CouchDB database, including size metrics and
 * cluster configuration.
 * /
 */
@Serializable
public data class DatabaseInfo(
	/**
	 * The database identifier.
	 */
	public val id: String,
	/**
	 * The current update sequence for the database.
	 */
	public val updateSeq: String? = null,
	/**
	 * The size of the database file on disk in bytes.
	 */
	public val fileSize: Long? = null,
	/**
	 * The uncompressed size of the database contents in bytes.
	 */
	public val externalSize: Long? = null,
	/**
	 * The size of live data in the database in bytes.
	 */
	public val activeSize: Long? = null,
	/**
	 * The number of documents in the database.
	 */
	public val docs: Long? = null,
	/**
	 * The number of shards for the database.
	 */
	public val q: Int? = null,
	/**
	 * The number of replicas of each shard.
	 */
	public val n: Int? = null,
	/**
	 * The number of copies that must be written before a write is considered successful.
	 */
	public val w: Int? = null,
	/**
	 * The number of copies that must be read before a read is considered successful.
	 */
	public val r: Int? = null,
)
