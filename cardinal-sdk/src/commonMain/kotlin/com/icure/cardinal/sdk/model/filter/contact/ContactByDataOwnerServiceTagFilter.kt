package com.icure.cardinal.sdk.model.filter.contact

import com.icure.cardinal.sdk.model.Contact
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@SerialName("ContactByDataOwnerServiceTagFilter")
@Serializable
data class ContactByDataOwnerServiceTagFilter(
	dataOwnerId: String,
	tagType: String,
	tagCode: String?,
	desc: String? = null,
) : AbstractFilter<Contact> {
	// region ContactByDataOwnerServiceTagFilter-ContactByDataOwnerServiceTagFilter

	// endregion
}
