package com.icure.cardinal.sdk.model.filter.patient

import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Long
import kotlin.String

@SerialName("PatientByDataOwnerModifiedAfterFilter")
@Serializable
public data class PatientByDataOwnerModifiedAfterFilter(
	public val dataOwnerId: String,
	public val startDate: Long?,
	public val endDate: Long?,
	public val descending: Boolean?,
	override val desc: String?,
) : AbstractFilter<Patient>
