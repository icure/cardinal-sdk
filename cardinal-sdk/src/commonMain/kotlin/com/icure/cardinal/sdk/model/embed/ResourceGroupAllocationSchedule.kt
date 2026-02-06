package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.model.base.CodeStub
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Set

@Serializable
public data class ResourceGroupAllocationSchedule(
	public val resourceGroup: CodeStub? = null,
	@param:DefaultValue("emptySet()")
	public val tags: Set<CodeStub> = emptySet(),
	@param:DefaultValue("emptySet()")
	public val codes: Set<CodeStub> = emptySet(),
	public val name: String? = null,
	public val startDateTime: Long? = null,
	public val endDateTime: Long? = null,
	@param:DefaultValue("emptyList()")
	public val items: List<EmbeddedTimeTableItem> = emptyList(),
)
