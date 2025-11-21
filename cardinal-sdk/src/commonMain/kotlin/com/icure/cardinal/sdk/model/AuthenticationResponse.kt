package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.String

@Serializable
public class AuthenticationResponse(
	public val healthcarePartyId: String? = null,
	public val reason: String? = null,
	@DefaultValue("false")
	public val successful: Boolean = false,
	public val username: String? = null,
)
