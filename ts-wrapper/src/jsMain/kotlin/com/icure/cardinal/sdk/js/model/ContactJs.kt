// auto-generated file
@file:JsQualifier("model")

package com.icure.cardinal.sdk.js.model

import com.icure.cardinal.sdk.js.model.base.CodeStubJs
import com.icure.cardinal.sdk.js.model.base.HasEncryptionMetadataJs
import com.icure.cardinal.sdk.js.model.base.ICureDocumentJs
import com.icure.cardinal.sdk.js.model.base.IdentifierJs
import com.icure.cardinal.sdk.js.model.base.StoredDocumentJs
import com.icure.cardinal.sdk.js.model.embed.AddressJs
import com.icure.cardinal.sdk.js.model.embed.AnnotationJs
import com.icure.cardinal.sdk.js.model.embed.ContactParticipantJs
import com.icure.cardinal.sdk.js.model.embed.DecryptedAddressJs
import com.icure.cardinal.sdk.js.model.embed.DecryptedServiceJs
import com.icure.cardinal.sdk.js.model.embed.DecryptedSubContactJs
import com.icure.cardinal.sdk.js.model.embed.DelegationJs
import com.icure.cardinal.sdk.js.model.embed.EncryptableJs
import com.icure.cardinal.sdk.js.model.embed.EncryptedAddressJs
import com.icure.cardinal.sdk.js.model.embed.EncryptedServiceJs
import com.icure.cardinal.sdk.js.model.embed.EncryptedSubContactJs
import com.icure.cardinal.sdk.js.model.embed.SecurityMetadataJs
import com.icure.cardinal.sdk.js.model.embed.ServiceJs
import com.icure.cardinal.sdk.js.model.embed.SubContactJs
import com.icure.cardinal.sdk.js.utils.Record
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("Contact")
public sealed external interface ContactJs : StoredDocumentJs, ICureDocumentJs<String>,
		HasEncryptionMetadataJs, EncryptableJs {
	public val identifier: Array<out IdentifierJs>

	public val groupId: String?

	public val openingDate: Double?

	public val closingDate: Double?

	public val descr: String?

	public val location: String?

	public val externalId: String?

	public val encounterType: CodeStubJs?

	public val encounterLocation: AddressJs?

	public val subContacts: Array<out SubContactJs>

	public val services: Array<out ServiceJs>

	public val participants: Record<String, out String>

	public val participantList: Array<out ContactParticipantJs>

	public val healthcarePartyId: String?

	public val modifiedContactId: String?

	public val notes: Array<out AnnotationJs>

	public val isEncrypted: Boolean
}

@JsName("DecryptedContact")
public external class DecryptedContactJs(
	partial: dynamic,
) : ContactJs {
	override val id: String

	override val rev: String?

	override val created: Double?

	override val modified: Double?

	override val author: String?

	override val responsible: String?

	override val medicalLocationId: String?

	override val tags: Array<CodeStubJs>

	override val codes: Array<CodeStubJs>

	override val identifier: Array<IdentifierJs>

	override val endOfLife: Double?

	override val deletionDate: Double?

	override val groupId: String?

	override val openingDate: Double?

	override val closingDate: Double?

	override val descr: String?

	override val location: String?

	override val externalId: String?

	override val encounterType: CodeStubJs?

	override val encounterLocation: DecryptedAddressJs?

	override val subContacts: Array<DecryptedSubContactJs>

	override val services: Array<DecryptedServiceJs>

	override val participants: Record<String, String>

	override val participantList: Array<ContactParticipantJs>

	override val healthcarePartyId: String?

	override val modifiedContactId: String?

	override val secretForeignKeys: Array<String>

	override val cryptedForeignKeys: Record<String, Array<DelegationJs>>

	override val delegations: Record<String, Array<DelegationJs>>

	override val encryptionKeys: Record<String, Array<DelegationJs>>

	override val encryptedSelf: String?

	override val securityMetadata: SecurityMetadataJs?

	override val notes: Array<AnnotationJs>

	override val isEncrypted: Boolean
}

@JsName("EncryptedContact")
public external class EncryptedContactJs(
	partial: dynamic,
) : ContactJs {
	override val id: String

	override val rev: String?

	override val created: Double?

	override val modified: Double?

	override val author: String?

	override val responsible: String?

	override val medicalLocationId: String?

	override val tags: Array<CodeStubJs>

	override val codes: Array<CodeStubJs>

	override val identifier: Array<IdentifierJs>

	override val endOfLife: Double?

	override val deletionDate: Double?

	override val groupId: String?

	override val openingDate: Double?

	override val closingDate: Double?

	override val descr: String?

	override val location: String?

	override val externalId: String?

	override val encounterType: CodeStubJs?

	override val encounterLocation: EncryptedAddressJs?

	override val subContacts: Array<EncryptedSubContactJs>

	override val services: Array<EncryptedServiceJs>

	override val participants: Record<String, String>

	override val participantList: Array<ContactParticipantJs>

	override val healthcarePartyId: String?

	override val modifiedContactId: String?

	override val secretForeignKeys: Array<String>

	override val cryptedForeignKeys: Record<String, Array<DelegationJs>>

	override val delegations: Record<String, Array<DelegationJs>>

	override val encryptionKeys: Record<String, Array<DelegationJs>>

	override val encryptedSelf: String?

	override val securityMetadata: SecurityMetadataJs?

	override val notes: Array<AnnotationJs>

	override val isEncrypted: Boolean
}
