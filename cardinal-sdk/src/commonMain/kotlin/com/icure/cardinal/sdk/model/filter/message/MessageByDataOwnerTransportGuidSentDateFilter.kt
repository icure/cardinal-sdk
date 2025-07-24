package com.icure.cardinal.sdk.model.filter.message

import com.icure.cardinal.sdk.model.Message
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.serialization.InstantSerializer
import kotlin.time.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@SerialName("MessageByDataOwnerTransportGuidSentDateFilter")
@Serializable
data class MessageByDataOwnerTransportGuidSentDateFilter(
	public val dataOwnerId: String,
	public val transportGuid: String,
	@Serializable(with = InstantSerializer::class)
	public val fromDate: Instant?,
	@Serializable(with = InstantSerializer::class)
	public val toDate: Instant?,
	public val descending: Boolean? = null,
	override val desc: String? = null,
) : AbstractFilter<Message> {
	// region MessageByDataOwnerTransportGuidSentDateFilter-MessageByDataOwnerTransportGuidSentDateFilter

	// endregion
}
