package com.icure.cardinal.sdk.model

import kotlinx.serialization.Serializable
import kotlin.String

@Serializable
public data class GroupDeletionReport(
	public val type: String,
	public val id: String,
	public val server: String,
)
