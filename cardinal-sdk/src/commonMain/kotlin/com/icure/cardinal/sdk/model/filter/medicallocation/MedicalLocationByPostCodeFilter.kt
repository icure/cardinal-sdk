package com.icure.cardinal.sdk.model.filter.medicallocation

import com.icure.cardinal.sdk.model.MedicalLocation
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

@SerialName("MedicalLocationByPostCodeFilter")
@Serializable
public data class MedicalLocationByPostCodeFilter(
	public val postCode: String,
	override val desc: String? = null,
) : AbstractFilter<MedicalLocation>
