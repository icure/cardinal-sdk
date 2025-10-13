package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.Set

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class RegistrationInformation(
	public val applicationId: String? = null,
	public val firstName: String? = null,
	public val lastName: String? = null,
	public val companyName: String? = null,
	public val emailAddress: String,
	public val userOptions: String? = null,
	@DefaultValue("emptySet()")
	public val userRoles: Set<String> = emptySet(),
	public val minimumKrakenVersion: String? = null,
	public val cluster: String? = null,
) {
	// region RegistrationInformation-RegistrationInformation

	// endregion
}
