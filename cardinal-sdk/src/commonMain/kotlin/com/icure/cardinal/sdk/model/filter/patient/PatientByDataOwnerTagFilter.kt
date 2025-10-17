package com.icure.cardinal.sdk.model.filter.patient

import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

@SerialName("PatientByDataOwnerTagFilter")
@Serializable
public data class PatientByDataOwnerTagFilter(
	override val desc: String? = null,
	public val dataOwnerId: String,
	public val tagType: String,
	public val tagCode: String? = null,
) : AbstractFilter<Patient>
