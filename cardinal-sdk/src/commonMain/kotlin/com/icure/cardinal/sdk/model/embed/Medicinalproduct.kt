package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.model.base.CodeStub
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.List

@Serializable
public data class Medicinalproduct(
	@DefaultValue("emptyList()")
	public val intendedcds: List<CodeStub> = emptyList(),
	@DefaultValue("emptyList()")
	public val deliveredcds: List<CodeStub> = emptyList(),
	public val intendedname: String? = null,
	public val deliveredname: String? = null,
	public val productId: String? = null,
)
