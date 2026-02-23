package com.icure.cardinal.sdk.model.filter.service

import com.icure.cardinal.sdk.model.embed.Service
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Long
import kotlin.String
import kotlin.collections.Set

@SerialName("ServiceByHcPartyPatientCodePrefixFilter")
@Serializable
public data class ServiceByHcPartyPatientCodePrefixFilter(
	public val healthcarePartyId: String,
	public val patientSecretForeignKeys: Set<String>,
	public val codeType: String,
	public val codeCodePrefix: String,
	public val startValueDate: Long? = null,
	public val endValueDate: Long? = null,
	override val desc: String? = null,
) : AbstractFilter<Service>
