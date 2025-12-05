package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.model.base.CodeStub
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Double
import kotlin.String
import kotlin.collections.List

@Serializable
public data class ReferenceRange(
	public val low: Double? = null,
	public val high: Double? = null,
	public val stringValue: String? = null,
	@DefaultValue("emptyList()")
	public val tags: List<CodeStub> = emptyList(),
	@DefaultValue("emptyList()")
	public val codes: List<CodeStub> = emptyList(),
	@DefaultValue("emptyList()")
	public val notes: List<Annotation> = emptyList(),
	public val age: Range? = null,
)
