package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.model.base.CodeStub
import kotlinx.serialization.Serializable
import kotlin.Int
import kotlin.Long

@Serializable
public data class RegimenItem(
	public val date: Long? = null,
	public val dayNumber: Int? = null,
	public val weekday: Weekday? = null,
	public val dayPeriod: CodeStub? = null,
	public val timeOfDay: Long? = null,
	public val administratedQuantity: AdministrationQuantity? = null,
)
