package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.Map

@Serializable
public data class AnonymousMedicalLocation(
	public val id: String,
	@DefaultValue("emptyMap()")
	public val publicInformations: Map<String, String> = emptyMap(),
)
