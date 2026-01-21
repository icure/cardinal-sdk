package com.icure.cardinal.sdk.model.filter.contact

import com.icure.cardinal.sdk.model.Contact
import com.icure.cardinal.sdk.model.base.Identifier
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.List
import com.icure.cardinal.sdk.utils.DefaultValue

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@SerialName("ContactByHcPartyIdentifiersFilter")
@Serializable
data class ContactByHcPartyIdentifiersFilter(
	healthcarePartyId: String? = null,
	desc: String? = null,
	identifiers: List<Identifier> = emptyList(),
) : AbstractFilter<Contact> {
	// region ContactByHcPartyIdentifiersFilter-ContactByHcPartyIdentifiersFilter

	// endregion
}
