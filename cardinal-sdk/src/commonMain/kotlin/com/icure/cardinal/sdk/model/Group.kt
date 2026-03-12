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

/**
 * Represents a group in the iCure platform. A group corresponds to a practice, hospital, or
 * organization
 * that contains its own set of databases and users.
 * /
 */
@Serializable
public data class Group(
	/**
	 * The id of the group. We encourage using either a v4 UUID or a HL7 Id.
	 */
	override val id: String,
	/**
	 * The revision of the group in the database, used for conflict management / optimistic locking.
	 */
	override val rev: String? = null,
	/**
	 * Hard delete (unix epoch in ms) timestamp of the object.
	 */
	override val deletionDate: Long? = null,
	/**
	 * Tags that qualify the group as being member of a certain class.
	 */
	@param:DefaultValue("emptySet()")
	override val tags: Set<CodeStub> = emptySet(),
	/**
	 * Tags that are publicly visible for the group.
	 */
	@param:DefaultValue("emptySet()")
	public val publicTags: Set<CodeStub> = emptySet(),
	/**
	 * Username for the group.
	 */
	public val name: String? = null,
	/**
	 * Password for the group access.
	 */
	public val password: String? = null,
	/**
	 * List of servers accessible to the group.
	 */
	public val servers: List<String>? = null,
	/**
	 * Whether the group has a super admin permission.
	 */
	@param:DefaultValue("false")
	public val superAdmin: Boolean = false,
	/**
	 * Extra properties for the group. Those properties are typed (see class Property).
	 */
	@param:DefaultValue("emptySet()")
	public val properties: Set<DecryptedPropertyStub> = emptySet(),
	/**
	 * The default roles for each user type, if not otherwise specified on the user.
	 */
	@param:DefaultValue("emptyMap()")
	public val defaultUserRoles: Map<UserType, Set<String>> = emptyMap(),
	/**
	 * Single-used token to perform specific operations.
	 */
	@param:DefaultValue("emptyMap()")
	public val operationTokens: Map<String, OperationToken> = emptyMap(),
	/**
	 * List of entities that have to be collected from a shared database.
	 */
	@param:DefaultValue("emptyMap()")
	public val sharedEntities: Map<String, String> = emptyMap(),
	/**
	 * Minimum version of Kraken required to access API.
	 */
	public val minimumKrakenVersion: String? = null,
	/**
	 * Verified public keys that can be used to allow log in with external JWTs.
	 */
	@param:DefaultValue("emptyMap()")
	public val externalJwtConfig: Map<String, ExternalJwtConfig> = emptyMap(),
	/**
	 * The minimum authentication class required for elevated privileges.
	 */
	public val minimumAuthenticationClassForElevatedPrivileges: AuthenticationClass,
	/**
	 * The id of the parent super group, if any.
	 */
	public val superGroup: String? = null,
	/**
	 * A user-chosen identifier for the applications for which this group holds data.
	 */
	@JsonNames("applicationId")
	public val projectId: String? = null,
	public val templates: TemplatesConfiguration? = null,
) : StoredDocument, HasTags {
	@Serializable
	public data class TemplatesConfiguration(
		public val specId: String,
		public val emailSender: String? = null,
		public val smsSender: String? = null,
		public val emailVerificationTemplateId: String? = null,
		public val mobilePhoneVerificationTemplateId: String? = null,
		public val existingEmailNotificationTemplateId: String? = null,
		public val existingMobilePhoneNotificationTemplateId: String? = null,
	)
}
