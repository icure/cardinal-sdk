package com.icure.cardinal.sdk.model.filter.contact

import com.icure.cardinal.sdk.model.Contact
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Long
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@SerialName("ContactByHcPartyTagCodeDateFilter")
@Serializable
data class ContactByHcPartyTagCodeDateFilter(
	desc: String? = null,
	healthcarePartyId: String? = null,
	tagType: String? = null,
	tagCode: String? = null,
	codeType: String? = null,
	codeCode: String? = null,
	startOfContactOpeningDate: Long? = null,
	endOfContactOpeningDate: Long? = null,
) : AbstractFilter<Contact> {
	// region ContactByHcPartyTagCodeDateFilter-ContactByHcPartyTagCodeDateFilter

	// endregion
}
