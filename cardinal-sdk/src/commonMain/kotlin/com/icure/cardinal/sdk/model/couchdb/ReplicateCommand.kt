package com.icure.cardinal.sdk.model.couchdb

import com.icure.cardinal.sdk.model.base.Versionable
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.String
import kotlin.collections.List

/**
 * Data transfer object representing a CouchDB replication command, used to configure and trigger
 * database replication between a source and a target.
 * /
 */
@Serializable
public data class ReplicateCommand(
	/**
	 * The unique identifier of this replication command.
	 */
	override val id: String,
	/**
	 * The current revision of this replication command document.
	 */
	override val rev: String? = null,
	/**
	 * Whether the replication should run continuously.
	 */
	@param:DefaultValue("false")
	public val continuous: Boolean = false,
	/**
	 * Whether to create the target database if it does not exist.
	 */
	@param:DefaultValue("false")
	public val createTarget: Boolean = false,
	/**
	 * An optional list of document ids to replicate.
	 */
	public val docIds: List<String>? = null,
	/**
	 * Whether to cancel an existing replication.
	 */
	public val cancel: Boolean? = null,
	/**
	 * An optional filter function name to apply during replication.
	 */
	public val filter: String? = null,
	/**
	 * An optional selector for filtering documents during replication.
	 */
	public val selector: String? = null,
	/**
	 * The source remote endpoint for the replication.
	 */
	public val source: Remote,
	/**
	 * The target remote endpoint for the replication.
	 */
	public val target: Remote,
) : Versionable<String>
