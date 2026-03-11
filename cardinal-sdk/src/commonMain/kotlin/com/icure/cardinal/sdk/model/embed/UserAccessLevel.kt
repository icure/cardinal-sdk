package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 *
 *  Specifies the access level of a user that is not necessarily a data owner on an entity. The
 * interpretation of the
 *  entities is the following:
 *  - Read: the user only has read permissions on the entity.
 *  - Write: the user has read and write permissions on the entity, but they cannot modify the
 * access of users to the entity.
 *  - Admin: the user has full control over the entity.
 */
@Serializable
public enum class UserAccessLevel(
	internal val dtoSerialName: String,
) {
	@SerialName("Admin")
	Admin("Admin"),

	@SerialName("Read")
	Read("Read"),

	@SerialName("Write")
	Write("Write"),
}
