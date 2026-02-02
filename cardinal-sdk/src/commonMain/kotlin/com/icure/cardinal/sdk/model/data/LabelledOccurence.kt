package com.icure.cardinal.sdk.model.`data`

import kotlinx.serialization.Serializable
import kotlin.Long
import kotlin.String

@Serializable
public data class LabelledOccurence(
	public val label: String,
	public val occurence: Long,
)
