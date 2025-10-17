package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.model.base.CodeStub
import kotlinx.serialization.Serializable
import kotlin.Double
import kotlin.String

@Serializable
public data class AdministrationQuantity(
	public val quantity: Double? = null,
	public val administrationUnit: CodeStub? = null,
	public val unit: String? = null,
)
