package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.model.base.Identifier
import com.icure.cardinal.sdk.model.base.StoredDocument
import com.icure.cardinal.sdk.model.embed.DelegationTag
import com.icure.cardinal.sdk.model.enums.UsersStatus
import com.icure.cardinal.sdk.model.enums.UsersType
import com.icure.cardinal.sdk.model.security.AuthenticationToken
import com.icure.cardinal.sdk.model.security.LoginIdentifier
import com.icure.cardinal.sdk.model.security.Permission
import com.icure.cardinal.sdk.serialization.InstantSerializer
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.Set

@Serializable
public data class User(
	override val id: String,
	override val rev: String? = null,
	override val deletionDate: Long? = null,
	public val created: Long? = null,
	@DefaultValue("emptyList()")
	public val identifier: List<Identifier> = emptyList(),
	public val name: String? = null,
	@DefaultValue("emptySet()")
	public val properties: Set<DecryptedPropertyStub> = emptySet(),
	@DefaultValue("emptySet()")
	public val permissions: Set<Permission> = emptySet(),
	@DefaultValue("emptySet()")
	public val roles: Set<String> = emptySet(),
	public val type: UsersType? = null,
	public val status: UsersStatus? = null,
	public val login: String? = null,
	public val passwordHash: String? = null,
	public val groupId: String? = null,
	public val healthcarePartyId: String? = null,
	public val patientId: String? = null,
	public val deviceId: String? = null,
	@DefaultValue("emptyMap()")
	public val autoDelegations: Map<DelegationTag, Set<String>> = emptyMap(),
	@Serializable(with = InstantSerializer::class)
	public val createdDate: Instant? = null,
	@Serializable(with = InstantSerializer::class)
	public val termsOfUseDate: Instant? = null,
	public val email: String? = null,
	public val mobilePhone: String? = null,
	@DefaultValue("emptyMap()")
	public val applicationTokens: Map<String, String> = emptyMap(),
	@DefaultValue("emptyMap()")
	public val authenticationTokens: Map<String, AuthenticationToken> = emptyMap(),
	public val systemMetadata: SystemMetadata? = null,
) : StoredDocument {
	@Serializable
	public data class SystemMetadata(
		public val roles: Set<String>,
		public val isAdmin: Boolean,
		public val inheritsRoles: Boolean,
		@DefaultValue("emptyList()")
		public val loginIdentifiers: List<LoginIdentifier> = emptyList(),
	)
}
