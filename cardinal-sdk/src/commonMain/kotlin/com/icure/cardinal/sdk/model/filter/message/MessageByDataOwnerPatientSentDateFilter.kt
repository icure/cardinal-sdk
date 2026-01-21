package com.icure.cardinal.sdk.model.filter.message

import com.icure.cardinal.sdk.model.Message
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.String
import kotlin.collections.Set
import kotlin.time.Instant
import com.icure.cardinal.sdk.serialization.InstantSerializer

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@SerialName("MessageByDataOwnerPatientSentDateFilter")
@Serializable
data class MessageByDataOwnerPatientSentDateFilter(
	dataOwnerId: String,
	secretPatientKeys: Set<String>,
	startDate: Instant? = null,
	endDate: Instant? = null,
	descending: Boolean?,
	desc: String? = null,
) : AbstractFilter<Message> {
	// region MessageByDataOwnerPatientSentDateFilter-MessageByDataOwnerPatientSentDateFilter

	// endregion
}
