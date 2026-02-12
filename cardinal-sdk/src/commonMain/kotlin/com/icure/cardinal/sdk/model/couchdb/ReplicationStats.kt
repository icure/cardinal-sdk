package com.icure.cardinal.sdk.model.couchdb

import com.icure.cardinal.sdk.serialization.ZonedDateTimeSerializer
import com.icure.cardinal.sdk.utils.time.ZonedDateTime
import kotlinx.serialization.Serializable
import kotlin.Int
import kotlin.String

@Serializable
public data class ReplicationStats(
	public val revisionsChecked: Int? = null,
	public val missingRevisionsFound: Int? = null,
	public val docsRead: Int? = null,
	public val docsWritten: Int? = null,
	public val changesPending: Int? = null,
	public val docWriteFailures: Int? = null,
	public val checkpointedSourceSeq: String? = null,
	@Serializable(with = ZonedDateTimeSerializer::class)
	public val startTime: ZonedDateTime? = null,
	public val error: String? = null,
)
