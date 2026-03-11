// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.model.base.Identifier
import com.icure.cardinal.sdk.model.base.StoredDocument
import com.icure.cardinal.sdk.model.embed.DelegationTag
import com.icure.cardinal.sdk.model.enums.UsersStatus
import com.icure.cardinal.sdk.model.security.AuthenticationToken
import com.icure.cardinal.sdk.model.security.LoginIdentifier
import com.icure.cardinal.sdk.model.security.Permission
import com.icure.cardinal.sdk.serialization.InstantSerializer
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.Set
import kotlin.time.Instant
import com.icure.cardinal.sdk.model.enums.UsersType

/**
 * Represents a user that can log in to the iCure platform. A user can be linked to a healthcare
 * party,
 * a patient, or a device, and holds authentication credentials, roles, and permissions.
 * /
 */
@Serializable
data class User(
	/**
	 * The Id of the user. We encourage using either a v4 UUID or a HL7 Id.
	 */
	override val id: String,
	/**
	 * The revision of the user in the database, used for conflict management / optimistic locking.
	 */
	override val rev: String? = null,
	/**
	 * Hard delete (unix epoch in ms) timestamp of the object.
	 */
	override val deletionDate: Long? = null,
	/**
	 * The timestamp (unix epoch in ms) of creation.
	 */
	public val created: Long? = null,
	/**
	 * The identifiers of the user.
	 */
	@param:DefaultValue("emptyList()")
	public val identifier: List<Identifier> = emptyList(),
	/**
	 * Last name of the user.
	 */
	public val name: String? = null,
	/**
	 * Extra properties for the user. Those properties are typed (see class Property).
	 */
	@param:DefaultValue("emptySet()")
	public val properties: Set<DecryptedPropertyStub> = emptySet(),
	/**
	 * Local permissions specified for the user.
	 */
	@param:DefaultValue("emptySet()")
	public val permissions: Set<Permission> = emptySet(),
	/**
	 * Local roles specified for the user.
	 */
	@param:DefaultValue("emptySet()")
	public val roles: Set<String> = emptySet(),
	/**
	 * State of user's activeness: 'Active', 'Disabled' or 'Registering'.
	 */
	public val status: UsersStatus? = null,
	/**
	 * Username for this user. We encourage using an email address.
	 */
	public val login: String? = null,
	/**
	 * Hashed version of the password (BCrypt is used for hashing).
	 */
	public val passwordHash: String? = null,
	/**
	 * The id of the group (practice/hospital) the user is member of.
	 */
	public val groupId: String? = null,
	/**
	 * Id of the healthcare party if the user is a healthcare party.
	 */
	public val healthcarePartyId: String? = null,
	/**
	 * Id of the patient if the user is a patient.
	 */
	public val patientId: String? = null,
	/**
	 * Id of the device if the user is a device.
	 */
	public val deviceId: String? = null,
	/**
	 * Delegations that are automatically generated client side when a new database object is created
	 * by this user.
	 */
	@param:DefaultValue("emptyMap()")
	public val autoDelegations: Map<DelegationTag, Set<String>> = emptyMap(),
	/**
	 * The timestamp (unix epoch in ms) of the latest validation of the terms of use.
	 */
	@Serializable(with = InstantSerializer::class)
	public val termsOfUseDate: Instant? = null,
	/**
	 * Email address of the user (used for token exchange or password recovery).
	 */
	public val email: String? = null,
	/**
	 * Mobile phone of the user (used for token exchange or password recovery).
	 */
	public val mobilePhone: String? = null,
	/**
	 * Encrypted and time-limited authentication tokens used for inter-applications authentication.
	 */
	@param:DefaultValue("emptyMap()")
	public val authenticationTokens: Map<String, AuthenticationToken> = emptyMap(),
	/**
	 * Metadata used to enrich the user with information from the cloud environment.
	 */
	public val systemMetadata: SystemMetadata? = null,
) : StoredDocument {
	@Serializable
	public data class SystemMetadata(
		public val roles: Set<String>,
		public val isAdmin: Boolean,
		public val inheritsRoles: Boolean,
		@param:DefaultValue("emptyList()")
		public val loginIdentifiers: List<LoginIdentifier> = emptyList(),
		public val verifiedEmail: Boolean? = null,
		public val verifiedMobilePhone: Boolean? = null,
	)
	// region User-User

	companion object {
		const val KRAKEN_QUALIFIED_NAME = "org.taktik.icure.entities.User"
	}
	// endregion
}
