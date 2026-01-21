package com.icure.cardinal.sdk.model.filter.topic

import com.icure.cardinal.sdk.model.Topic
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.model.filter.Filter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@SerialName("TopicByHcPartyFilter")
@Serializable
data class TopicByHcPartyFilter(
	hcpId: String,
	desc: String? = null,
) : AbstractFilter<Topic>, Filter.ByHcpartyFilter<Topic> {
	// region TopicByHcPartyFilter-TopicByHcPartyFilter

	// endregion
}
