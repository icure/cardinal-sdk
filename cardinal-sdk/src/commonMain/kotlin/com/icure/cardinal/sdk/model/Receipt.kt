package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.model.base.CodeStub
import com.icure.cardinal.sdk.model.base.HasEncryptionMetadata
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
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.Set

/**
 * Represents a receipt for a healthcare transaction. Receipts are used to store acknowledgements
 * and responses
 * from external systems such as eFact, eAttest, or other healthcare messaging platforms. They can
 * be linked
 * to invoices or other documents.
 * /
 */
public sealed interface Receipt :
	StoredDocument,
	ICureDocument<String>,
	HasEncryptionMetadata,
	Encryptable {
	/**
	 * The unique identifier of the receipt.
	 */
	override val id: String

	/**
	 * The revision of the receipt in the database, used for conflict management / optimistic locking.
	 */
	override val rev: String?

	/**
	 * The timestamp (unix epoch in ms) of creation.
	 */
	override val created: Long?

	/**
	 * The timestamp (unix epoch in ms) of the latest modification.
	 */
	override val modified: Long?

	/**
	 * The id of the User that created this receipt.
	 */
	override val author: String?

	/**
	 * The id of the HealthcareParty that is responsible for this receipt.
	 */
	override val responsible: String?

	/**
	 * Tags that qualify the receipt as being member of a certain class.
	 */
	override val tags: Set<CodeStub>

	/**
	 * Codes that identify or qualify this particular receipt.
	 */
	override val codes: Set<CodeStub>

	/**
	 * Hard delete (unix epoch in ms) timestamp of the object.
	 */
	override val deletionDate: Long?

	/**
	 * List of references (e.g., nipReference, errorCode, errorPath, tarification, invoice UUID).
	 */
	public val references: List<String>

	/**
	 * The id of the document (InvoiceDto, ContactDto, ...) this receipt is linked to.
	 */
	public val documentId: String?

	/**
	 * The category of the receipt.
	 */
	public val category: String?

	/**
	 * The sub-category of the receipt.
	 */
	public val subCategory: String?

	/**
	 * The secret patient key, encrypted in the patient's own AES key.
	 */
	override val secretForeignKeys: Set<String>

	/**
	 * The patient id encrypted in the delegates' AES keys.
	 */
	override val cryptedForeignKeys: Map<String, Set<Delegation>>

	/**
	 * The delegations giving access to connected healthcare information.
	 */
	override val delegations: Map<String, Set<Delegation>>

	/**
	 * The keys used to encrypt this entity when stored encrypted.
	 */
	override val encryptionKeys: Map<String, Set<Delegation>>

	/**
	 * The base64-encoded encrypted fields of this entity.
	 */
	override val encryptedSelf: Base64String?

	/**
	 * The security metadata of the entity.
	 */
	override val securityMetadata: SecurityMetadata?
}

/**
 * Represents a receipt for a healthcare transaction. Receipts are used to store acknowledgements
 * and responses
 * from external systems such as eFact, eAttest, or other healthcare messaging platforms. They can
 * be linked
 * to invoices or other documents.
 * /
 */
@Serializable
public data class DecryptedReceipt(
	/**
	 * The unique identifier of the receipt.
	 */
	override val id: String,
	/**
	 * The revision of the receipt in the database, used for conflict management / optimistic locking.
	 */
	override val rev: String? = null,
	/**
	 * The timestamp (unix epoch in ms) of creation.
	 */
	override val created: Long? = null,
	/**
	 * The timestamp (unix epoch in ms) of the latest modification.
	 */
	override val modified: Long? = null,
	/**
	 * The id of the User that created this receipt.
	 */
	override val author: String? = null,
	/**
	 * The id of the HealthcareParty that is responsible for this receipt.
	 */
	override val responsible: String? = null,
	/**
	 * Tags that qualify the receipt as being member of a certain class.
	 */
	@param:DefaultValue("emptySet()")
	override val tags: Set<CodeStub> = emptySet(),
	/**
	 * Codes that identify or qualify this particular receipt.
	 */
	@param:DefaultValue("emptySet()")
	override val codes: Set<CodeStub> = emptySet(),
	/**
	 * Hard delete (unix epoch in ms) timestamp of the object.
	 */
	override val deletionDate: Long? = null,
	/**
	 * List of references (e.g., nipReference, errorCode, errorPath, tarification, invoice UUID).
	 */
	@param:DefaultValue("emptyList()")
	override val references: List<String> = emptyList(),
	/**
	 * The id of the document (InvoiceDto, ContactDto, ...) this receipt is linked to.
	 */
	override val documentId: String? = null,
	/**
	 * The category of the receipt.
	 */
	override val category: String? = null,
	/**
	 * The sub-category of the receipt.
	 */
	override val subCategory: String? = null,
	/**
	 * The secret patient key, encrypted in the patient's own AES key.
	 */
	@param:DefaultValue("emptySet()")
	override val secretForeignKeys: Set<String> = emptySet(),
	/**
	 * The patient id encrypted in the delegates' AES keys.
	 */
	@param:DefaultValue("emptyMap()")
	override val cryptedForeignKeys: Map<String, Set<Delegation>> = emptyMap(),
	/**
	 * The delegations giving access to connected healthcare information.
	 */
	@param:DefaultValue("emptyMap()")
	override val delegations: Map<String, Set<Delegation>> = emptyMap(),
	/**
	 * The keys used to encrypt this entity when stored encrypted.
	 */
	@param:DefaultValue("emptyMap()")
	override val encryptionKeys: Map<String, Set<Delegation>> = emptyMap(),
	/**
	 * The base64-encoded encrypted fields of this entity.
	 */
	override val encryptedSelf: Base64String? = null,
	/**
	 * The security metadata of the entity.
	 */
	override val securityMetadata: SecurityMetadata? = null,
) : Receipt

/**
 * Represents a receipt for a healthcare transaction. Receipts are used to store acknowledgements
 * and responses
 * from external systems such as eFact, eAttest, or other healthcare messaging platforms. They can
 * be linked
 * to invoices or other documents.
 * /
 */
@Serializable
public data class EncryptedReceipt(
	/**
	 * The unique identifier of the receipt.
	 */
	override val id: String,
	/**
	 * The revision of the receipt in the database, used for conflict management / optimistic locking.
	 */
	override val rev: String? = null,
	/**
	 * The timestamp (unix epoch in ms) of creation.
	 */
	override val created: Long? = null,
	/**
	 * The timestamp (unix epoch in ms) of the latest modification.
	 */
	override val modified: Long? = null,
	/**
	 * The id of the User that created this receipt.
	 */
	override val author: String? = null,
	/**
	 * The id of the HealthcareParty that is responsible for this receipt.
	 */
	override val responsible: String? = null,
	/**
	 * Tags that qualify the receipt as being member of a certain class.
	 */
	@param:DefaultValue("emptySet()")
	override val tags: Set<CodeStub> = emptySet(),
	/**
	 * Codes that identify or qualify this particular receipt.
	 */
	@param:DefaultValue("emptySet()")
	override val codes: Set<CodeStub> = emptySet(),
	/**
	 * Hard delete (unix epoch in ms) timestamp of the object.
	 */
	override val deletionDate: Long? = null,
	/**
	 * List of references (e.g., nipReference, errorCode, errorPath, tarification, invoice UUID).
	 */
	@param:DefaultValue("emptyList()")
	override val references: List<String> = emptyList(),
	/**
	 * The id of the document (InvoiceDto, ContactDto, ...) this receipt is linked to.
	 */
	override val documentId: String? = null,
	/**
	 * The category of the receipt.
	 */
	override val category: String? = null,
	/**
	 * The sub-category of the receipt.
	 */
	override val subCategory: String? = null,
	/**
	 * The secret patient key, encrypted in the patient's own AES key.
	 */
	@param:DefaultValue("emptySet()")
	override val secretForeignKeys: Set<String> = emptySet(),
	/**
	 * The patient id encrypted in the delegates' AES keys.
	 */
	@param:DefaultValue("emptyMap()")
	override val cryptedForeignKeys: Map<String, Set<Delegation>> = emptyMap(),
	/**
	 * The delegations giving access to connected healthcare information.
	 */
	@param:DefaultValue("emptyMap()")
	override val delegations: Map<String, Set<Delegation>> = emptyMap(),
	/**
	 * The keys used to encrypt this entity when stored encrypted.
	 */
	@param:DefaultValue("emptyMap()")
	override val encryptionKeys: Map<String, Set<Delegation>> = emptyMap(),
	/**
	 * The base64-encoded encrypted fields of this entity.
	 */
	override val encryptedSelf: Base64String? = null,
	/**
	 * The security metadata of the entity.
	 */
	override val securityMetadata: SecurityMetadata? = null,
) : Receipt
