package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
class AuthenticationResponse(
	public val healthcarePartyId: String? = null,
	public val reason: String? = null,
	@param:DefaultValue("false")
	public val successful: Boolean = false,
	public val username: String? = null,
) {
	// region AuthenticationResponse-AuthenticationResponse

	// endregion
}
