package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Long
import kotlin.String
import kotlin.collections.List

@Serializable
public data class PersonName(
	public val lastName: String? = null,
	@DefaultValue("emptyList()")
	public val firstNames: List<String> = emptyList(),
	public val start: Long? = null,
	public val end: Long? = null,
	@DefaultValue("emptyList()")
	public val prefix: List<String> = emptyList(),
	@DefaultValue("emptyList()")
	public val suffix: List<String> = emptyList(),
	public val text: String? = null,
	public val use: PersonNameUse? = null,
)
