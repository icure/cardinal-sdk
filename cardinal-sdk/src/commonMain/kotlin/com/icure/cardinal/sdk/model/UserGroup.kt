package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.List

/**
 *
 *  DTO representing a user within the context of a specific group, including the group hierarchy
 *  and the user's associated data owner identifiers.
 */
@Serializable
public data class UserGroup(
	/**
	 * The identifier of the group this user belongs to.
	 */
	public val groupId: String? = null,
	/**
	 * The name of the group this user belongs to.
	 */
	public val groupName: String? = null,
	/**
	 * The list of groups forming the hierarchy from the topmost group down to this group.
	 */
	@param:DefaultValue("emptyList()")
	public val groupsHierarchy: List<Group> = emptyList(),
	/**
	 * The identifier of the user.
	 */
	public val userId: String? = null,
	/**
	 * The login identifier of the user.
	 */
	public val login: String? = null,
	/**
	 * The display name of the user.
	 */
	public val name: String? = null,
	/**
	 * The email address of the user.
	 */
	public val email: String? = null,
	/**
	 * The phone number of the user.
	 */
	public val phone: String? = null,
	/**
	 * The identifier of the patient linked to this user, if any.
	 */
	public val patientId: String? = null,
	/**
	 * The identifier of the healthcare party linked to this user, if any.
	 */
	public val healthcarePartyId: String? = null,
	/**
	 * The identifier of the device linked to this user, if any.
	 */
	public val deviceId: String? = null,
	/**
	 * The name of the parent group of the topmost group in the hierarchy.
	 */
	public val nameOfParentOfTopmostGroupInHierarchy: String? = null,
)
