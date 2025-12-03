package com.icure.cardinal.sdk.model.couchdb

import kotlinx.serialization.Serializable
import kotlin.Int
import kotlin.Long
import kotlin.String

@Serializable
public data class DatabaseInfo(
	public val id: String,
	public val updateSeq: String? = null,
	public val fileSize: Long? = null,
	public val externalSize: Long? = null,
	public val activeSize: Long? = null,
	public val docs: Long? = null,
	public val q: Int? = null,
	public val n: Int? = null,
	public val w: Int? = null,
	public val r: Int? = null,
)
