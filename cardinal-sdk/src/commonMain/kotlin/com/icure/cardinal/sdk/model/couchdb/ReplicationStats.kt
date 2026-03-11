package com.icure.cardinal.sdk.model.couchdb

import com.icure.cardinal.sdk.serialization.ZonedDateTimeSerializer
import com.icure.cardinal.sdk.utils.time.ZonedDateTime
import kotlinx.serialization.Serializable
import kotlin.Int
import kotlin.String

/**
 * Data transfer object containing statistics about a CouchDB replication process.
 * /
 */
@Serializable
public data class ReplicationStats(
	/**
	 * The number of revisions checked during replication.
	 */
	public val revisionsChecked: Int? = null,
	/**
	 * The number of missing revisions found on the target.
	 */
	public val missingRevisionsFound: Int? = null,
	/**
	 * The number of documents read from the source.
	 */
	public val docsRead: Int? = null,
	/**
	 * The number of documents written to the target.
	 */
	public val docsWritten: Int? = null,
	/**
	 * The number of changes still pending replication.
	 */
	public val changesPending: Int? = null,
	/**
	 * The number of document write failures on the target.
	 */
	public val docWriteFailures: Int? = null,
	/**
	 * The last checkpointed source sequence identifier.
	 */
	public val checkpointedSourceSeq: String? = null,
	/**
	 * The time when the replication started.
	 */
	@Serializable(with = ZonedDateTimeSerializer::class)
	public val startTime: ZonedDateTime? = null,
	/**
	 * An error message if the replication encountered an error.
	 */
	public val error: String? = null,
)
