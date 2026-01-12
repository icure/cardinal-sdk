package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.List

@Serializable
public data class UserGroup(
	public val groupId: String? = null,
	public val groupName: String? = null,
	@DefaultValue("emptyList()")
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
)
