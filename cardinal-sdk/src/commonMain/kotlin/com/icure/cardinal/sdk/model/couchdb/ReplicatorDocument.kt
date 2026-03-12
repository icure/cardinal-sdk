package com.icure.cardinal.sdk.model.couchdb

import com.icure.cardinal.sdk.model.base.Versionable
import com.icure.cardinal.sdk.serialization.ZonedDateTimeSerializer
import com.icure.cardinal.sdk.utils.time.ZonedDateTime
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map

/**
 * Data transfer object representing a CouchDB replicator document that tracks the state of a
 * replication task.
 * /
 */
@Serializable
public data class ReplicatorDocument(
	/**
	 * The unique identifier of this replicator document.
	 */
	override val id: String,
	/**
	 * The current revision of this document.
	 */
	override val rev: String? = null,
	/**
	 * The source remote endpoint for the replication.
	 */
	public val source: Remote? = null,
	/**
	 * The target remote endpoint for the replication.
	 */
	public val target: Remote? = null,
	/**
	 * The owner of this replication task.
	 */
	public val owner: String? = null,
	/**
	 * Whether to create the target database if it does not exist.
	 */
	public val create_target: Boolean? = null,
	/**
	 * Whether the replication runs continuously.
	 */
	public val continuous: Boolean? = null,
	/**
	 * An optional list of document ids to replicate.
	 */
	public val doc_ids: List<String>? = null,
	/**
	 * The current state of the replication (e.g. triggered, completed, error).
	 */
	public val replicationState: String? = null,
	/**
	 * The time when the replication state was last updated.
	 */
	@Serializable(with = ZonedDateTimeSerializer::class)
	public val replicationStateTime: ZonedDateTime? = null,
	/**
	 * Statistics about the replication process.
	 */
	public val replicationStats: ReplicationStats? = null,
	/**
	 * The number of errors encountered during replication.
	 */
	public val errorCount: Int? = null,
	/**
	 * Information about the document revisions.
	 */
	public val revsInfo: List<Map<String, String>>? = null,
	/**
	 * A map of the document revision history.
	 */
	public val revHistory: Map<String, String>? = null,
) : Versionable<String>
