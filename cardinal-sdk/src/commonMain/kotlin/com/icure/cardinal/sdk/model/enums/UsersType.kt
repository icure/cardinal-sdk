package com.icure.cardinal.sdk.model.enums

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

@Serializable
public enum class UsersType(
	internal val dtoSerialName: String,
) {
	@SerialName("database")
	Database("database"),

	@SerialName("ldap")
	Ldap("ldap"),

	@SerialName("token")
	Token("token"),
}
