package com.icure.cardinal.sdk.model.filter.service

import com.icure.cardinal.sdk.model.embed.Service
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import com.icure.cardinal.sdk.utils.DefaultValue

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@SerialName("ServiceByHcPartyTagCodeDateFilter")
@Serializable
data class ServiceByHcPartyTagCodeDateFilter(
	desc: String? = null,
	healthcarePartyId: String? = null,
	patientSecretForeignKeys: List<String>? = null,
	tagType: String? = null,
	tagCode: String? = null,
	codeType: String? = null,
	codeCode: String? = null,
	startValueDate: Long? = null,
	endValueDate: Long? = null,
	descending: Boolean = false,
) : AbstractFilter<Service> {
	// region ServiceByHcPartyTagCodeDateFilter-ServiceByHcPartyTagCodeDateFilter

	// endregion
}
