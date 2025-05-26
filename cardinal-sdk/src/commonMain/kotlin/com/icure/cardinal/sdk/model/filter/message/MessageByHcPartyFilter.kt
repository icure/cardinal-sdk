package com.icure.cardinal.sdk.model.filter.message

import com.icure.cardinal.sdk.model.Message
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.model.filter.Filter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@SerialName("MessageByHcPartyFilter")
@Serializable
data class MessageByHcPartyFilter(
	override val hcpId: String,
	override val desc: String? = null,
	internal val dtoSerialName: String,
) : AbstractFilter<Message>, Filter.ByHcpartyFilter<Message> {
	// region MessageByHcPartyFilter-MessageByHcPartyFilter

	// endregion
}
