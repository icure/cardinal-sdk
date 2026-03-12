package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.model.base.CodeStub
import com.icure.cardinal.sdk.model.base.HasEncryptionMetadata
import com.icure.cardinal.sdk.model.base.HasEndOfLife
import com.icure.cardinal.sdk.model.base.ICureDocument
import com.icure.cardinal.sdk.model.base.Identifier
import com.icure.cardinal.sdk.model.base.StoredDocument
import com.icure.cardinal.sdk.model.embed.Annotation
import com.icure.cardinal.sdk.model.embed.CareTeamMember
import com.icure.cardinal.sdk.model.embed.DecryptedCareTeamMember
import com.icure.cardinal.sdk.model.embed.DecryptedEpisode
import com.icure.cardinal.sdk.model.embed.DecryptedPlanOfAction
import com.icure.cardinal.sdk.model.embed.Delegation
import com.icure.cardinal.sdk.model.embed.Encryptable
import com.icure.cardinal.sdk.model.embed.EncryptedCareTeamMember
import com.icure.cardinal.sdk.model.embed.EncryptedEpisode
import com.icure.cardinal.sdk.model.embed.EncryptedPlanOfAction
import com.icure.cardinal.sdk.model.embed.Episode
import com.icure.cardinal.sdk.model.embed.Laterality
import com.icure.cardinal.sdk.model.embed.PlanOfAction
import com.icure.cardinal.sdk.model.embed.SecurityMetadata
import com.icure.cardinal.sdk.model.specializations.Base64String
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.Set

/**
 * Represents a healthcare element. A healthcare element is a patient-centric representation of a
 * healthcare problem
 * that evolves over time in its name/label and characteristics. It is a central element in the
 * organisation of the
 * electronic health record, used to filter and link medical data in a meaningful way.
 * /
 */
public sealed interface HealthElement :
	StoredDocument,
	ICureDocument<String>,
	HasEncryptionMetadata,
	Encryptable,
	HasEndOfLife {
	/**
	 * The Id of the healthcare element. We encourage using either a v4 UUID or a HL7 Id.
	 */
	override val id: String

	/**
	 * The identifiers of the healthcare element.
	 */
	public val identifiers: List<Identifier>

	/**
	 * The revision of the healthcare element in the database, used for conflict management /
	 * optimistic locking.
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
	 * The id of the User that created this healthcare element.
	 */
	override val author: String?

	/**
	 * The id of the HealthcareParty that is responsible for this healthcare element.
	 */
	override val responsible: String?

	/**
	 * Tags that qualify the healthcare element as being member of a certain class.
	 */
	override val tags: Set<CodeStub>

	/**
	 * Codes that identify or qualify this particular healthcare element.
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
	 * The logical id of the healthcare element, used to link together different versions of the same
	 * healthcare element.
	 */
	public val healthElementId: String?

	/**
	 * The date (unix epoch in ms) when the healthcare element is noted to have started and also closes
	 * on the same date.
	 */
	public val valueDate: Long?

	/**
	 * The date (unix epoch in ms) of the start of the healthcare element.
	 */
	public val openingDate: Long?

	/**
	 * The date (unix epoch in ms) marking the end of the healthcare element.
	 */
	public val closingDate: Long?

	/**
	 * Description of the healthcare element.
	 */
	public val descr: String?

	/**
	 * A text note (can be confidential, encrypted by default).
	 */
	public val note: String?

	/**
	 * Localized text annotations for the healthcare element.
	 */
	public val notes: List<Annotation>

	/**
	 * Whether the healthcare element is relevant or not.
	 */
	public val relevant: Boolean

	/**
	 * Id of the opening contact when the healthcare element was created.
	 */
	public val idOpeningContact: String?

	/**
	 * Id of the closing contact for the healthcare element.
	 */
	public val idClosingContact: String?

	/**
	 * Id of the service when a service is used to create a healthcare element.
	 */
	public val idService: String?

	/**
	 * Left or right dominance/preference.
	 */
	public val laterality: Laterality?

	/**
	 * List of healthcare approaches.
	 */
	public val plansOfAction: List<PlanOfAction>

	/**
	 * List of episodes of occurrences of the healthcare element.
	 */
	public val episodes: List<Episode>

	/**
	 * List of care team members assigned for the healthcare element.
	 */
	public val careTeam: List<CareTeamMember>

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
	 * The keys used to encrypt this entity when the entity is stored encrypted.
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
 * Represents a healthcare element. A healthcare element is a patient-centric representation of a
 * healthcare problem
 * that evolves over time in its name/label and characteristics. It is a central element in the
 * organisation of the
 * electronic health record, used to filter and link medical data in a meaningful way.
 * /
 */
@Serializable
public data class DecryptedHealthElement(
	/**
	 * The Id of the healthcare element. We encourage using either a v4 UUID or a HL7 Id.
	 */
	override val id: String,
	/**
	 * The identifiers of the healthcare element.
	 */
	@param:DefaultValue("emptyList()")
	override val identifiers: List<Identifier> = emptyList(),
	/**
	 * The revision of the healthcare element in the database, used for conflict management /
	 * optimistic locking.
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
	 * The id of the User that created this healthcare element.
	 */
	override val author: String? = null,
	/**
	 * The id of the HealthcareParty that is responsible for this healthcare element.
	 */
	override val responsible: String? = null,
	/**
	 * Tags that qualify the healthcare element as being member of a certain class.
	 */
	@param:DefaultValue("emptySet()")
	override val tags: Set<CodeStub> = emptySet(),
	/**
	 * Codes that identify or qualify this particular healthcare element.
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
	 * The logical id of the healthcare element, used to link together different versions of the same
	 * healthcare element.
	 */
	override val healthElementId: String? = null,
	/**
	 * The date (unix epoch in ms) when the healthcare element is noted to have started and also closes
	 * on the same date.
	 */
	override val valueDate: Long? = null,
	/**
	 * The date (unix epoch in ms) of the start of the healthcare element.
	 */
	override val openingDate: Long? = null,
	/**
	 * The date (unix epoch in ms) marking the end of the healthcare element.
	 */
	override val closingDate: Long? = null,
	/**
	 * Description of the healthcare element.
	 */
	override val descr: String? = null,
	/**
	 * A text note (can be confidential, encrypted by default).
	 */
	override val note: String? = null,
	/**
	 * Localized text annotations for the healthcare element.
	 */
	@param:DefaultValue("emptyList()")
	override val notes: List<Annotation> = emptyList(),
	/**
	 * Whether the healthcare element is relevant or not.
	 */
	@param:DefaultValue("true")
	override val relevant: Boolean = true,
	/**
	 * Id of the opening contact when the healthcare element was created.
	 */
	override val idOpeningContact: String? = null,
	/**
	 * Id of the closing contact for the healthcare element.
	 */
	override val idClosingContact: String? = null,
	/**
	 * Id of the service when a service is used to create a healthcare element.
	 */
	override val idService: String? = null,
	/**
	 * Left or right dominance/preference.
	 */
	override val laterality: Laterality? = null,
	/**
	 * List of healthcare approaches.
	 */
	@param:DefaultValue("emptyList()")
	override val plansOfAction: List<DecryptedPlanOfAction> = emptyList(),
	/**
	 * List of episodes of occurrences of the healthcare element.
	 */
	@param:DefaultValue("emptyList()")
	override val episodes: List<DecryptedEpisode> = emptyList(),
	/**
	 * List of care team members assigned for the healthcare element.
	 */
	@param:DefaultValue("emptyList()")
	override val careTeam: List<DecryptedCareTeamMember> = emptyList(),
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
	 * The keys used to encrypt this entity when the entity is stored encrypted.
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
) : HealthElement

/**
 * Represents a healthcare element. A healthcare element is a patient-centric representation of a
 * healthcare problem
 * that evolves over time in its name/label and characteristics. It is a central element in the
 * organisation of the
 * electronic health record, used to filter and link medical data in a meaningful way.
 * /
 */
@Serializable
public data class EncryptedHealthElement(
	/**
	 * The Id of the healthcare element. We encourage using either a v4 UUID or a HL7 Id.
	 */
	override val id: String,
	/**
	 * The identifiers of the healthcare element.
	 */
	@param:DefaultValue("emptyList()")
	override val identifiers: List<Identifier> = emptyList(),
	/**
	 * The revision of the healthcare element in the database, used for conflict management /
	 * optimistic locking.
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
	 * The id of the User that created this healthcare element.
	 */
	override val author: String? = null,
	/**
	 * The id of the HealthcareParty that is responsible for this healthcare element.
	 */
	override val responsible: String? = null,
	/**
	 * Tags that qualify the healthcare element as being member of a certain class.
	 */
	@param:DefaultValue("emptySet()")
	override val tags: Set<CodeStub> = emptySet(),
	/**
	 * Codes that identify or qualify this particular healthcare element.
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
	 * The logical id of the healthcare element, used to link together different versions of the same
	 * healthcare element.
	 */
	override val healthElementId: String? = null,
	/**
	 * The date (unix epoch in ms) when the healthcare element is noted to have started and also closes
	 * on the same date.
	 */
	override val valueDate: Long? = null,
	/**
	 * The date (unix epoch in ms) of the start of the healthcare element.
	 */
	override val openingDate: Long? = null,
	/**
	 * The date (unix epoch in ms) marking the end of the healthcare element.
	 */
	override val closingDate: Long? = null,
	/**
	 * Description of the healthcare element.
	 */
	override val descr: String? = null,
	/**
	 * A text note (can be confidential, encrypted by default).
	 */
	override val note: String? = null,
	/**
	 * Localized text annotations for the healthcare element.
	 */
	@param:DefaultValue("emptyList()")
	override val notes: List<Annotation> = emptyList(),
	/**
	 * Whether the healthcare element is relevant or not.
	 */
	@param:DefaultValue("true")
	override val relevant: Boolean = true,
	/**
	 * Id of the opening contact when the healthcare element was created.
	 */
	override val idOpeningContact: String? = null,
	/**
	 * Id of the closing contact for the healthcare element.
	 */
	override val idClosingContact: String? = null,
	/**
	 * Id of the service when a service is used to create a healthcare element.
	 */
	override val idService: String? = null,
	/**
	 * Left or right dominance/preference.
	 */
	override val laterality: Laterality? = null,
	/**
	 * List of healthcare approaches.
	 */
	@param:DefaultValue("emptyList()")
	override val plansOfAction: List<EncryptedPlanOfAction> = emptyList(),
	/**
	 * List of episodes of occurrences of the healthcare element.
	 */
	@param:DefaultValue("emptyList()")
	override val episodes: List<EncryptedEpisode> = emptyList(),
	/**
	 * List of care team members assigned for the healthcare element.
	 */
	@param:DefaultValue("emptyList()")
	override val careTeam: List<EncryptedCareTeamMember> = emptyList(),
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
	 * The keys used to encrypt this entity when the entity is stored encrypted.
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
) : HealthElement
