package com.icure.cardinal.sdk.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

@Serializable
public data class ReplicateCommand(
	@SerialName("source_url")
	public val sourceUrl: String,
	@SerialName("source_username")
	public val sourceUsername: String,
	@SerialName("source_password")
	public val sourcePassword: String,
	@SerialName("target_url")
	public val targetUrl: String,
	@SerialName("target_username")
	public val targetUsername: String,
	@SerialName("target_password")
	public val targetPassword: String,
	public val id: String? = null,
)
