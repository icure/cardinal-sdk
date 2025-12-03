package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.Serializable
import kotlin.String

@Serializable
public data class Partnership(
	public val type: PartnershipType? = null,
	public val status: PartnershipStatus? = null,
	public val partnerId: String? = null,
	public val meToOtherRelationshipDescription: String? = null,
	public val otherToMeRelationshipDescription: String? = null,
)
