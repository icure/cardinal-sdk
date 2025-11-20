package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.collections.Set

@Serializable
public data class ListOfProperties(
	@DefaultValue("emptySet()")
	public val properties: Set<DecryptedPropertyStub> = emptySet(),
)
