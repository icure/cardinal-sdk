package com.icure.cardinal.sdk.model

import kotlinx.serialization.Serializable
import kotlin.String

@Serializable
public data class PublicKey(
	public val hcPartyId: String? = null,
	public val hexString: String? = null,
)
