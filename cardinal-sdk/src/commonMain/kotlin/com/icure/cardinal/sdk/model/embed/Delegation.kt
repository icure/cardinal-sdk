package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.model.specializations.HexString
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.List

@Serializable
public data class Delegation(
	public val owner: String? = null,
	public val delegatedTo: String? = null,
	public val key: HexString? = null,
	@DefaultValue("emptyList()")
	public val tags: List<String> = emptyList(),
)
