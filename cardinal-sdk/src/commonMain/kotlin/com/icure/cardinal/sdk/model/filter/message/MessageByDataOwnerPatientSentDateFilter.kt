package com.icure.cardinal.sdk.model.filter.message

import com.icure.cardinal.sdk.model.Message
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.serialization.InstantSerializer
import kotlin.time.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.String
import kotlin.collections.Set

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@SerialName("MessageByDataOwnerPatientSentDateFilter")
@Serializable
data class MessageByDataOwnerPatientSentDateFilter(
	public val dataOwnerId: String,
	public val secretPatientKeys: Set<String>,
	@Serializable(with = InstantSerializer::class)
	public val startDate: Instant? = null,
	@Serializable(with = InstantSerializer::class)
	public val endDate: Instant? = null,
	public val descending: Boolean?,
	override val desc: String? = null,
) : AbstractFilter<Message> {
	// region MessageByDataOwnerPatientSentDateFilter-MessageByDataOwnerPatientSentDateFilter

	// endregion
}
