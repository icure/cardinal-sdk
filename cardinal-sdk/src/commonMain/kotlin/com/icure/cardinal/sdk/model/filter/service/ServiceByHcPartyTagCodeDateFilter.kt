package com.icure.cardinal.sdk.model.filter.service

import com.icure.cardinal.sdk.model.embed.Service
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Long
import kotlin.String
import kotlin.collections.List

@SerialName("ServiceByHcPartyTagCodeDateFilter")
@Serializable
public data class ServiceByHcPartyTagCodeDateFilter(
	override val desc: String? = null,
	public val healthcarePartyId: String? = null,
	public val patientSecretForeignKeys: List<String>? = null,
	public val tagType: String? = null,
	public val tagCode: String? = null,
	public val codeType: String? = null,
	public val codeCode: String? = null,
	public val startValueDate: Long? = null,
	public val endValueDate: Long? = null,
	@DefaultValue("false")
	public val descending: Boolean = false,
) : AbstractFilter<Service>
