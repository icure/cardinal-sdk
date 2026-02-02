package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.List

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class UserGroup(
	public val groupId: String? = null,
	public val groupName: String? = null,
	@param:DefaultValue("emptyList()")
	public val groupsHierarchy: List<Group> = emptyList(),
	public val userId: String? = null,
	public val login: String? = null,
	public val name: String? = null,
	public val email: String? = null,
	public val phone: String? = null,
	public val patientId: String? = null,
	public val healthcarePartyId: String? = null,
	public val deviceId: String? = null,
	public val nameOfParentOfTopmostGroupInHierarchy: String? = null,
) {
	// region UserGroup-UserGroup

	// endregion
}
