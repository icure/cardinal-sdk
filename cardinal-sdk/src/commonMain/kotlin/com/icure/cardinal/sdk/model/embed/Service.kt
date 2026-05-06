// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.model.base.CodeStub
import com.icure.cardinal.sdk.model.base.HasEndOfLife
import com.icure.cardinal.sdk.model.base.ICureDocument
import com.icure.cardinal.sdk.model.base.Identifier
import com.icure.cardinal.sdk.model.base.LinkQualification
import com.icure.cardinal.sdk.model.specializations.Base64String
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.Set
import kotlin.Int

sealed interface Service : Encryptable, ICureDocument<String>, HasEndOfLife {
	/**
	 * The Id of the Service. We encourage using either a v4 UUID or a HL7 Id.
	 */
	override val id: String

	/**
	 * The transactionId is used when a single service had to be split into parts for technical
	 * reasons. Several services with the same non null transaction id form one single service
	 */
	public val transactionId: String?

	public val identifier: List<Identifier>

	/**
	 * Id of the contact during which the service is provided. Only used when the Service is emitted
	 * outside of its contact
	 */
	public val contactId: String?

	public val subContactIds: Set<String>?

	/**
	 * List of IDs of all plans of actions (healthcare approaches) as a part of which the Service is
	 * provided. Only used when the Service is emitted outside of its contact
	 */
	public val plansOfActionIds: Set<String>?

	/**
	 * List of IDs of all healthcare elements for which the service is provided. Only used when the
	 * Service is emitted outside of its contact
	 */
	public val healthElementsIds: Set<String>?

	/**
	 * List of Ids of all forms linked to the Service. Only used when the Service is emitted outside of
	 * its contact.
	 */
	public val formIds: Set<String>?

	public val secretForeignKeys: Set<String>?

	/**
	 * The public patient key, encrypted here for separate Crypto Actors.
	 */
	public val cryptedForeignKeys: Map<String, Set<Delegation>>

	/**
	 * The delegations giving access to connected healthcare information.
	 */
	public val delegations: Map<String, Set<Delegation>>

	/**
	 * The contact secret encryption key used to encrypt the secured properties (like services for
	 * example), encrypted for separate Crypto Actors.
	 */
	public val encryptionKeys: Map<String, Set<Delegation>>

	/**
	 * Description / Unambiguous qualification (LOINC code) of the type of information contained in the
	 * service. Could be a code to qualify temperature, complaint, diagnostic, ...
	 */
	public val label: String?

	/**
	 * Used for sorting services inside an upper object (A contact, a transaction, a FHIR bundle, ...)
	 */
	public val index: Long?

	/**
	 * Information contained in the service. Content is localized, using ISO language code as key
	 */
	public val content: Map<String, Content>

	/**
	 * Information contained in the service. Content is localized, using ISO language code as key
	 */
	public val textIndexes: Map<String, String>

	/**
	 * The date (YYYYMMDDhhmmss) when the Service is noted to have started and also closes on the same
	 * date
	 */
	public val valueDate: Long?

	/**
	 * The date (YYYYMMDDhhmmss) of the start of the Service
	 */
	public val openingDate: Long?

	/**
	 * The date (YYYYMMDDhhmmss) marking the end of the Service
	 */
	public val closingDate: Long?

	/**
	 * The timestamp (unix epoch in ms) of creation of the service, will be filled automatically if
	 * missing. Not enforced by the application server.
	 */
	override val created: Long?

	/**
	 * The date (unix epoch in ms) of the latest modification of the service, will be filled
	 * automatically if missing. Not enforced by the application server.
	 */
	override val modified: Long?

	override val endOfLife: Long?

	/**
	 * The id of the User that has created this service, if absent, falls back on the contact's author
	 */
	override val author: String?

	/**
	 * The id of the HealthcareParty that is responsible for this service, if absent, falls back on the
	 * contact's responsible
	 */
	override val responsible: String?

	/**
	 * Text, comments on the Service provided
	 */
	public val comment: String?

	/**
	 * List of invoicing codes
	 */
	public val invoicingCodes: Set<String>

	/**
	 * Comments - Notes recorded by a HCP about this service
	 */
	public val notes: List<Annotation>

	/**
	 * Links towards related services (possibly in other contacts)
	 */
	public val qualifiedLinks: Map<LinkQualification, Map<String, String>>

	/**
	 * Links towards related services (possibly in other contacts)
	 */
	override val codes: Set<CodeStub>

	override val tags: Set<CodeStub>

	override val encryptedSelf: Base64String?

	public val securityMetadata: SecurityMetadata?
	// region Service-Service
	companion object {
		const val KRAKEN_QUALIFIED_NAME = "org.taktik.icure.entities.embed.Service"
	}
	// endregion
}

@Serializable
data class DecryptedService(
	/**
	 * The Id of the Service. We encourage using either a v4 UUID or a HL7 Id.
	 */
	override val id: String,
	/**
	 * The transactionId is used when a single service had to be split into parts for technical
	 * reasons. Several services with the same non null transaction id form one single service
	 */
	override val transactionId: String? = null,
	@param:DefaultValue("emptyList()")
	override val identifier: List<Identifier> = emptyList(),
	/**
	 * Id of the contact during which the service is provided. Only used when the Service is emitted
	 * outside of its contact
	 */
	override val contactId: String? = null,
	override val subContactIds: Set<String>? = null,
	/**
	 * List of IDs of all plans of actions (healthcare approaches) as a part of which the Service is
	 * provided. Only used when the Service is emitted outside of its contact
	 */
	override val plansOfActionIds: Set<String>? = null,
	/**
	 * List of IDs of all healthcare elements for which the service is provided. Only used when the
	 * Service is emitted outside of its contact
	 */
	override val healthElementsIds: Set<String>? = null,
	/**
	 * List of Ids of all forms linked to the Service. Only used when the Service is emitted outside of
	 * its contact.
	 */
	override val formIds: Set<String>? = null,
	@param:DefaultValue("emptySet()")
	override val secretForeignKeys: Set<String>? = emptySet(),
	/**
	 * The public patient key, encrypted here for separate Crypto Actors.
	 */
	@param:DefaultValue("emptyMap()")
	override val cryptedForeignKeys: Map<String, Set<Delegation>> = emptyMap(),
	/**
	 * The delegations giving access to connected healthcare information.
	 */
	@param:DefaultValue("emptyMap()")
	override val delegations: Map<String, Set<Delegation>> = emptyMap(),
	/**
	 * The contact secret encryption key used to encrypt the secured properties (like services for
	 * example), encrypted for separate Crypto Actors.
	 */
	@param:DefaultValue("emptyMap()")
	override val encryptionKeys: Map<String, Set<Delegation>> = emptyMap(),
	/**
	 * Description / Unambiguous qualification (LOINC code) of the type of information contained in the
	 * service. Could be a code to qualify temperature, complaint, diagnostic, ...
	 */
	override val label: String? = null,
	/**
	 * Used for sorting services inside an upper object (A contact, a transaction, a FHIR bundle, ...)
	 */
	override val index: Long? = null,
	/**
	 * Information contained in the service. Content is localized, using ISO language code as key
	 */
	@param:DefaultValue("emptyMap()")
	override val content: Map<String, DecryptedContent> = emptyMap(),
	/**
	 * Information contained in the service. Content is localized, using ISO language code as key
	 */
	@param:DefaultValue("emptyMap()")
	override val textIndexes: Map<String, String> = emptyMap(),
	/**
	 * The date (YYYYMMDDhhmmss) when the Service is noted to have started and also closes on the same
	 * date
	 */
	override val valueDate: Long? = null,
	/**
	 * The date (YYYYMMDDhhmmss) of the start of the Service
	 */
	override val openingDate: Long? = null,
	/**
	 * The date (YYYYMMDDhhmmss) marking the end of the Service
	 */
	override val closingDate: Long? = null,
	/**
	 * The timestamp (unix epoch in ms) of creation of the service, will be filled automatically if
	 * missing. Not enforced by the application server.
	 */
	override val created: Long? = null,
	/**
	 * The date (unix epoch in ms) of the latest modification of the service, will be filled
	 * automatically if missing. Not enforced by the application server.
	 */
	override val modified: Long? = null,
	override val endOfLife: Long? = null,
	/**
	 * The id of the User that has created this service, if absent, falls back on the contact's author
	 */
	override val author: String? = null,
	/**
	 * The id of the HealthcareParty that is responsible for this service, if absent, falls back on the
	 * contact's responsible
	 */
	override val responsible: String? = null,
	/**
	 * Text, comments on the Service provided
	 */
	override val comment: String? = null,
	/**
	 * List of invoicing codes
	 */
	@param:DefaultValue("emptySet()")
	override val invoicingCodes: Set<String> = emptySet(),
	/**
	 * Comments - Notes recorded by a HCP about this service
	 */
	@param:DefaultValue("emptyList()")
	override val notes: List<Annotation> = emptyList(),
	/**
	 * Links towards related services (possibly in other contacts)
	 */
	@param:DefaultValue("emptyMap()")
	override val qualifiedLinks: Map<LinkQualification, Map<String, String>> = emptyMap(),
	/**
	 * Links towards related services (possibly in other contacts)
	 */
	@param:DefaultValue("emptySet()")
	override val codes: Set<CodeStub> = emptySet(),
	@param:DefaultValue("emptySet()")
	override val tags: Set<CodeStub> = emptySet(),
	override val encryptedSelf: Base64String? = null,
	override val securityMetadata: SecurityMetadata? = null,
) : Service {
	// region Service-DecryptedService

	// endregion
}

@Serializable
data class EncryptedService(
	/**
	 * The Id of the Service. We encourage using either a v4 UUID or a HL7 Id.
	 */
	override val id: String,
	/**
	 * The transactionId is used when a single service had to be split into parts for technical
	 * reasons. Several services with the same non null transaction id form one single service
	 */
	override val transactionId: String? = null,
	@param:DefaultValue("emptyList()")
	override val identifier: List<Identifier> = emptyList(),
	/**
	 * Id of the contact during which the service is provided. Only used when the Service is emitted
	 * outside of its contact
	 */
	override val contactId: String? = null,
	override val subContactIds: Set<String>? = null,
	/**
	 * List of IDs of all plans of actions (healthcare approaches) as a part of which the Service is
	 * provided. Only used when the Service is emitted outside of its contact
	 */
	override val plansOfActionIds: Set<String>? = null,
	/**
	 * List of IDs of all healthcare elements for which the service is provided. Only used when the
	 * Service is emitted outside of its contact
	 */
	override val healthElementsIds: Set<String>? = null,
	/**
	 * List of Ids of all forms linked to the Service. Only used when the Service is emitted outside of
	 * its contact.
	 */
	override val formIds: Set<String>? = null,
	@param:DefaultValue("emptySet()")
	override val secretForeignKeys: Set<String>? = emptySet(),
	/**
	 * The public patient key, encrypted here for separate Crypto Actors.
	 */
	@param:DefaultValue("emptyMap()")
	override val cryptedForeignKeys: Map<String, Set<Delegation>> = emptyMap(),
	/**
	 * The delegations giving access to connected healthcare information.
	 */
	@param:DefaultValue("emptyMap()")
	override val delegations: Map<String, Set<Delegation>> = emptyMap(),
	/**
	 * The contact secret encryption key used to encrypt the secured properties (like services for
	 * example), encrypted for separate Crypto Actors.
	 */
	@param:DefaultValue("emptyMap()")
	override val encryptionKeys: Map<String, Set<Delegation>> = emptyMap(),
	/**
	 * Description / Unambiguous qualification (LOINC code) of the type of information contained in the
	 * service. Could be a code to qualify temperature, complaint, diagnostic, ...
	 */
	override val label: String? = null,
	/**
	 * Used for sorting services inside an upper object (A contact, a transaction, a FHIR bundle, ...)
	 */
	override val index: Long? = null,
	/**
	 * Information contained in the service. Content is localized, using ISO language code as key
	 */
	@param:DefaultValue("emptyMap()")
	override val content: Map<String, EncryptedContent> = emptyMap(),
	/**
	 * Information contained in the service. Content is localized, using ISO language code as key
	 */
	@param:DefaultValue("emptyMap()")
	override val textIndexes: Map<String, String> = emptyMap(),
	/**
	 * The date (YYYYMMDDhhmmss) when the Service is noted to have started and also closes on the same
	 * date
	 */
	override val valueDate: Long? = null,
	/**
	 * The date (YYYYMMDDhhmmss) of the start of the Service
	 */
	override val openingDate: Long? = null,
	/**
	 * The date (YYYYMMDDhhmmss) marking the end of the Service
	 */
	override val closingDate: Long? = null,
	/**
	 * The timestamp (unix epoch in ms) of creation of the service, will be filled automatically if
	 * missing. Not enforced by the application server.
	 */
	override val created: Long? = null,
	/**
	 * The date (unix epoch in ms) of the latest modification of the service, will be filled
	 * automatically if missing. Not enforced by the application server.
	 */
	override val modified: Long? = null,
	override val endOfLife: Long? = null,
	/**
	 * The id of the User that has created this service, if absent, falls back on the contact's author
	 */
	override val author: String? = null,
	/**
	 * The id of the HealthcareParty that is responsible for this service, if absent, falls back on the
	 * contact's responsible
	 */
	override val responsible: String? = null,
	/**
	 * Text, comments on the Service provided
	 */
	override val comment: String? = null,
	/**
	 * List of invoicing codes
	 */
	@param:DefaultValue("emptySet()")
	override val invoicingCodes: Set<String> = emptySet(),
	/**
	 * Comments - Notes recorded by a HCP about this service
	 */
	@param:DefaultValue("emptyList()")
	override val notes: List<Annotation> = emptyList(),
	/**
	 * Links towards related services (possibly in other contacts)
	 */
	@param:DefaultValue("emptyMap()")
	override val qualifiedLinks: Map<LinkQualification, Map<String, String>> = emptyMap(),
	/**
	 * Links towards related services (possibly in other contacts)
	 */
	@param:DefaultValue("emptySet()")
	override val codes: Set<CodeStub> = emptySet(),
	@param:DefaultValue("emptySet()")
	override val tags: Set<CodeStub> = emptySet(),
	override val encryptedSelf: Base64String? = null,
	override val securityMetadata: SecurityMetadata? = null,
) : Service {
	// region Service-EncryptedService

	// endregion
}
