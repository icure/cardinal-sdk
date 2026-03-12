// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.model.base.StoredDocument
import com.icure.cardinal.sdk.model.enums.UsersStatus
import com.icure.cardinal.sdk.model.enums.UsersType
import kotlinx.serialization.Serializable
import kotlin.Long
import kotlin.String

/**
 * Lightweight stub representation of a user, containing only the essential identification and
 * status fields. Used when the full user payload is not needed.
 * /
 */
@Serializable
data class UserStub(
	/**
	 * The unique identifier of the user.
	 */
	override val id: String,
	/**
	 * The revision identifier for optimistic locking.
	 */
	override val rev: String? = null,
	/**
	 * The soft-delete timestamp in epoch milliseconds.
	 */
	override val deletionDate: Long? = null,
	/**
	 * The display name of the user.
	 */
	public val name: String? = null,
	/**
	 * The type of user (e.g. database, external).
	 */
	public val type: UsersType? = null,
	/**
	 * The current status of the user (e.g. active, disabled).
	 */
	public val status: UsersStatus? = null,
	/**
	 * The login identifier of the user.
	 */
	public val login: String? = null,
	/**
	 * The identifier of the group this user belongs to.
	 */
	public val groupId: String? = null,
	/**
	 * The identifier of the healthcare party linked to this user.
	 */
	public val healthcarePartyId: String? = null,
	/**
	 * The identifier of the patient linked to this user.
	 */
	public val patientId: String? = null,
	/**
	 * The email address of the user.
	 */
	public val email: String? = null,
) : StoredDocument {
	// region UserStub-UserStub

	// endregion
}
