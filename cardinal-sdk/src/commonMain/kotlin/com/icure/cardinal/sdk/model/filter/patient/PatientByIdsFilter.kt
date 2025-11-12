package com.icure.cardinal.sdk.model.filter.patient

import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.model.filter.Filter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.Set

@SerialName("PatientByIdsFilter")
@Serializable
public data class PatientByIdsFilter(
	override val ids: Set<String>,
	override val desc: String? = null,
) : AbstractFilter<Patient>, Filter.IdsFilter<String, Patient>
