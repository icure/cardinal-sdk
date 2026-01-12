package com.icure.cardinal.sdk.model

import kotlinx.serialization.Serializable
import kotlin.collections.List

@Serializable
public data class ListOfIdsAndRev(
	public val ids: List<IdWithRev>,
)
