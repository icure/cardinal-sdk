package com.icure.cardinal.sdk.model.filter.service

import com.icure.cardinal.sdk.model.embed.Service
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.Set

@SerialName("ServiceBySecretForeignKeys")
@Serializable
public data class ServiceBySecretForeignKeys(
	override val desc: String? = null,
	public val healthcarePartyId: String? = null,
	public val patientSecretForeignKeys: Set<String>,
) : AbstractFilter<Service>
