package com.icure.cardinal.sdk.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 * DTO representing a command to set up database replication between a source and target CouchDB
 * instance.
 * /
 */
@Serializable
public data class ReplicateCommand(
	/**
	 * The URL of the source CouchDB database.
	 */
	@SerialName("source_url")
	public val sourceUrl: String,
	/**
	 * The username for authenticating with the source database.
	 */
	@SerialName("source_username")
	public val sourceUsername: String,
	/**
	 * The password for authenticating with the source database.
	 */
	@SerialName("source_password")
	public val sourcePassword: String,
	/**
	 * The URL of the target CouchDB database.
	 */
	@SerialName("target_url")
	public val targetUrl: String,
	/**
	 * The username for authenticating with the target database.
	 */
	@SerialName("target_username")
	public val targetUsername: String,
	/**
	 * The password for authenticating with the target database.
	 */
	@SerialName("target_password")
	public val targetPassword: String,
	/**
	 * The optional identifier of this replication command.
	 */
	public val id: String? = null,
)
