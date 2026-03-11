// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.enums

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 *
 *  Enumerates the authentication backend types supported for user accounts.
 */
@Serializable
enum class UsersType(
	internal val dtoSerialName: String,
) {
	@SerialName("database")
	Database("database"),

	@SerialName("ldap")
	Ldap("ldap"),

	@SerialName("token")
	Token("token"),
}
