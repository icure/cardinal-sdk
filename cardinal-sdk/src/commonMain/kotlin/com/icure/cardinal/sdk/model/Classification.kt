// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.model.base.CodeStub
import com.icure.cardinal.sdk.model.base.HasEncryptionMetadata
import com.icure.cardinal.sdk.model.base.HasEndOfLife
import com.icure.cardinal.sdk.model.base.ICureDocument
import com.icure.cardinal.sdk.model.base.StoredDocument
import com.icure.cardinal.sdk.model.embed.Delegation
import com.icure.cardinal.sdk.model.embed.Encryptable
import com.icure.cardinal.sdk.model.embed.SecurityMetadata
import com.icure.cardinal.sdk.model.specializations.Base64String
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Long
import kotlin.String
import kotlin.collections.Map
import kotlin.collections.Set

/**
 * Represents a classification used to organize and categorize medical data. Classifications can be
 * nested
 * through parent-child relationships and linked to classification templates.
 * /
 */

sealed interface Classification :
	StoredDocument,
	ICureDocument<String>,
	HasEncryptionMetadata,
	Encryptable,
	HasEndOfLife {
	/**
	 * The Id of the classification. We encourage using either a v4 UUID or a HL7 Id.
	 */
	override val id: String

	/**
	 * The revision of the classification in the database, used for conflict management / optimistic
	 * locking.
	 */
	override val rev: String?

	/**
	 * The timestamp (unix epoch in ms) of creation of this entity.
	 */
	override val created: Long?

	/**
	 * The timestamp (unix epoch in ms) of the latest modification of this entity.
	 */
	override val modified: Long?

	/**
	 * The id of the User that created this classification.
	 */
	override val author: String?

	/**
	 * The id of the data owner that is responsible for this classification.
	 */
	override val responsible: String?

	/**
	 * Tags that qualify the classification as being member of a certain class.
	 */
	override val tags: Set<CodeStub>

	/**
	 * Codes that identify or qualify this particular classification.
	 */
	override val codes: Set<CodeStub>

	/**
	 * Soft delete (unix epoch in ms) timestamp of the object.
	 */
	override val endOfLife: Long?

	/**
	 * Hard delete (unix epoch in ms) timestamp of the object.
	 */
	override val deletionDate: Long?

	/**
	 * The id of the parent classification, for nesting.
	 */
	public val parentId: String?

	/**
	 * A human-readable label for this classification.
	 */
	public val label: String

	/**
	 * The id of the classification template this classification is based on.
	 */
	public val templateId: String?

	/**
	 * The secret foreign keys, used for secure linking to patients.
	 */
	override val secretForeignKeys: Set<String>

	/**
	 * The encrypted foreign keys.
	 */
	override val cryptedForeignKeys: Map<String, Set<Delegation>>

	/**
	 * The delegations giving access to connected healthcare information.
	 */
	override val delegations: Map<String, Set<Delegation>>

	/**
	 * The encryption keys used to encrypt secured properties, encrypted for separate Crypto Actors.
	 */
	override val encryptionKeys: Map<String, Set<Delegation>>

	/**
	 * The base64-encoded encrypted fields of this classification.
	 */
	override val encryptedSelf: Base64String?

	/**
	 * The security metadata of this entity, for access control.
	 */
	override val securityMetadata: SecurityMetadata?
	// region Classification-Classification

	// endregion
}

/**
 * Represents a classification used to organize and categorize medical data. Classifications can be
 * nested
 * through parent-child relationships and linked to classification templates.
 * /
 */
@Serializable
data class DecryptedClassification(
	/**
	 * The Id of the classification. We encourage using either a v4 UUID or a HL7 Id.
	 */
	override val id: String,
	/**
	 * The revision of the classification in the database, used for conflict management / optimistic
	 * locking.
	 */
	override val rev: String? = null,
	/**
	 * The timestamp (unix epoch in ms) of creation of this entity.
	 */
	override val created: Long? = null,
	/**
	 * The timestamp (unix epoch in ms) of the latest modification of this entity.
	 */
	override val modified: Long? = null,
	/**
	 * The id of the User that created this classification.
	 */
	override val author: String? = null,
	/**
	 * The id of the data owner that is responsible for this classification.
	 */
	override val responsible: String? = null,
	/**
	 * Tags that qualify the classification as being member of a certain class.
	 */
	@param:DefaultValue("emptySet()")
	override val tags: Set<CodeStub> = emptySet(),
	/**
	 * Codes that identify or qualify this particular classification.
	 */
	@param:DefaultValue("emptySet()")
	override val codes: Set<CodeStub> = emptySet(),
	/**
	 * Soft delete (unix epoch in ms) timestamp of the object.
	 */
	override val endOfLife: Long? = null,
	/**
	 * Hard delete (unix epoch in ms) timestamp of the object.
	 */
	override val deletionDate: Long? = null,
	/**
	 * The id of the parent classification, for nesting.
	 */
	override val parentId: String? = null,
	/**
	 * A human-readable label for this classification.
	 */
	@param:DefaultValue("\"\"")
	override val label: String = "",
	/**
	 * The id of the classification template this classification is based on.
	 */
	override val templateId: String? = null,
	/**
	 * The secret foreign keys, used for secure linking to patients.
	 */
	@param:DefaultValue("emptySet()")
	override val secretForeignKeys: Set<String> = emptySet(),
	/**
	 * The encrypted foreign keys.
	 */
	@param:DefaultValue("emptyMap()")
	override val cryptedForeignKeys: Map<String, Set<Delegation>> = emptyMap(),
	/**
	 * The delegations giving access to connected healthcare information.
	 */
	@param:DefaultValue("emptyMap()")
	override val delegations: Map<String, Set<Delegation>> = emptyMap(),
	/**
	 * The encryption keys used to encrypt secured properties, encrypted for separate Crypto Actors.
	 */
	@param:DefaultValue("emptyMap()")
	override val encryptionKeys: Map<String, Set<Delegation>> = emptyMap(),
	/**
	 * The base64-encoded encrypted fields of this classification.
	 */
	override val encryptedSelf: Base64String? = null,
	/**
	 * The security metadata of this entity, for access control.
	 */
	override val securityMetadata: SecurityMetadata? = null,
) : Classification {
	// region Classification-DecryptedClassification
override fun copyWithSecurityMetadata(securityMetadata: SecurityMetadata, secretForeignKeys: Set<String>): DecryptedClassification =
		copy(securityMetadata = securityMetadata, secretForeignKeys = secretForeignKeys)
	// endregion
}

/**
 * Represents a classification used to organize and categorize medical data. Classifications can be
 * nested
 * through parent-child relationships and linked to classification templates.
 * /
 */
@Serializable
data class EncryptedClassification(
	/**
	 * The Id of the classification. We encourage using either a v4 UUID or a HL7 Id.
	 */
	override val id: String,
	/**
	 * The revision of the classification in the database, used for conflict management / optimistic
	 * locking.
	 */
	override val rev: String? = null,
	/**
	 * The timestamp (unix epoch in ms) of creation of this entity.
	 */
	override val created: Long? = null,
	/**
	 * The timestamp (unix epoch in ms) of the latest modification of this entity.
	 */
	override val modified: Long? = null,
	/**
	 * The id of the User that created this classification.
	 */
	override val author: String? = null,
	/**
	 * The id of the data owner that is responsible for this classification.
	 */
	override val responsible: String? = null,
	/**
	 * Tags that qualify the classification as being member of a certain class.
	 */
	@param:DefaultValue("emptySet()")
	override val tags: Set<CodeStub> = emptySet(),
	/**
	 * Codes that identify or qualify this particular classification.
	 */
	@param:DefaultValue("emptySet()")
	override val codes: Set<CodeStub> = emptySet(),
	/**
	 * Soft delete (unix epoch in ms) timestamp of the object.
	 */
	override val endOfLife: Long? = null,
	/**
	 * Hard delete (unix epoch in ms) timestamp of the object.
	 */
	override val deletionDate: Long? = null,
	/**
	 * The id of the parent classification, for nesting.
	 */
	override val parentId: String? = null,
	/**
	 * A human-readable label for this classification.
	 */
	@param:DefaultValue("\"\"")
	override val label: String = "",
	/**
	 * The id of the classification template this classification is based on.
	 */
	override val templateId: String? = null,
	/**
	 * The secret foreign keys, used for secure linking to patients.
	 */
	@param:DefaultValue("emptySet()")
	override val secretForeignKeys: Set<String> = emptySet(),
	/**
	 * The encrypted foreign keys.
	 */
	@param:DefaultValue("emptyMap()")
	override val cryptedForeignKeys: Map<String, Set<Delegation>> = emptyMap(),
	/**
	 * The delegations giving access to connected healthcare information.
	 */
	@param:DefaultValue("emptyMap()")
	override val delegations: Map<String, Set<Delegation>> = emptyMap(),
	/**
	 * The encryption keys used to encrypt secured properties, encrypted for separate Crypto Actors.
	 */
	@param:DefaultValue("emptyMap()")
	override val encryptionKeys: Map<String, Set<Delegation>> = emptyMap(),
	/**
	 * The base64-encoded encrypted fields of this classification.
	 */
	override val encryptedSelf: Base64String? = null,
	/**
	 * The security metadata of this entity, for access control.
	 */
	override val securityMetadata: SecurityMetadata? = null,
) : Classification {
	// region Classification-EncryptedClassification
override fun copyWithSecurityMetadata(securityMetadata: SecurityMetadata, secretForeignKeys: Set<String>): EncryptedClassification =
		copy(securityMetadata = securityMetadata, secretForeignKeys = secretForeignKeys)
	// endregion
}
