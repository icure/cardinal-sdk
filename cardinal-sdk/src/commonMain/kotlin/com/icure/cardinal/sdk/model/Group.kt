package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.model.base.CodeStub
import com.icure.cardinal.sdk.model.base.HasTags
import com.icure.cardinal.sdk.model.base.StoredDocument
import com.icure.cardinal.sdk.model.embed.AuthenticationClass
import com.icure.cardinal.sdk.model.embed.UserType
import com.icure.cardinal.sdk.model.security.ExternalJwtConfig
import com.icure.cardinal.sdk.model.security.OperationToken
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames
import kotlin.Boolean
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.Set

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class Group(
	override val id: String,
	override val rev: String? = null,
	override val deletionDate: Long? = null,
	@DefaultValue("emptySet()")
	override val tags: Set<CodeStub> = emptySet(),
	@DefaultValue("emptySet()")
	public val publicTags: Set<CodeStub> = emptySet(),
	public val name: String? = null,
	public val password: String? = null,
	public val servers: List<String>? = null,
	@DefaultValue("false")
	public val superAdmin: Boolean = false,
	@DefaultValue("emptySet()")
	public val properties: Set<DecryptedPropertyStub> = emptySet(),
	@DefaultValue("emptyMap()")
	public val defaultUserRoles: Map<UserType, Set<String>> = emptyMap(),
	@DefaultValue("emptyMap()")
	public val operationTokens: Map<String, OperationToken> = emptyMap(),
	@DefaultValue("emptyMap()")
	public val sharedEntities: Map<String, String> = emptyMap(),
	public val minimumKrakenVersion: String? = null,
	@DefaultValue("emptyMap()")
	public val externalJwtConfig: Map<String, ExternalJwtConfig> = emptyMap(),
	public val minimumAuthenticationClassForElevatedPrivileges: AuthenticationClass,
	public val superGroup: String? = null,
	@JsonNames("applicationId")
	public val projectId: String? = null,
) : StoredDocument, HasTags {
	// region Group-Group

	// endregion
}
