// auto-generated file
@file:JsQualifier("model")

package com.icure.cardinal.sdk.js.model

import com.icure.cardinal.sdk.js.model.base.CodeStubJs
import com.icure.cardinal.sdk.js.model.base.HasEncryptionMetadataJs
import com.icure.cardinal.sdk.js.model.base.HasEndOfLifeJs
import com.icure.cardinal.sdk.js.model.base.HasIdentifierJs
import com.icure.cardinal.sdk.js.model.base.ICureDocumentJs
import com.icure.cardinal.sdk.js.model.base.IdentifierJs
import com.icure.cardinal.sdk.js.model.base.PersonJs
import com.icure.cardinal.sdk.js.model.base.StoredDocumentJs
import com.icure.cardinal.sdk.js.model.embed.DecryptedAddressJs
import com.icure.cardinal.sdk.js.model.embed.DelegationJs
import com.icure.cardinal.sdk.js.model.embed.EncryptableJs
import com.icure.cardinal.sdk.js.model.embed.EncryptedAddressJs
import com.icure.cardinal.sdk.js.model.embed.PersonNameJs
import com.icure.cardinal.sdk.js.model.embed.SecurityMetadataJs
import com.icure.cardinal.sdk.js.utils.Record
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("RelatedPerson")
public sealed external interface RelatedPersonJs : StoredDocumentJs, ICureDocumentJs<String>,
		PersonJs, HasEncryptionMetadataJs, EncryptableJs, HasIdentifierJs, HasEndOfLifeJs {
	public val properties: Array<out PropertyStubJs>

	public val isEncrypted: Boolean
}

@JsName("DecryptedRelatedPerson")
public external class DecryptedRelatedPersonJs(
	partial: dynamic,
) : RelatedPersonJs {
	override val id: String

	override val rev: String?

	override val identifier: Array<IdentifierJs>

	override val created: Double?

	override val modified: Double?

	override val author: String?

	override val responsible: String?

	override val tags: Array<CodeStubJs>

	override val codes: Array<CodeStubJs>

	override val endOfLife: Double?

	override val deletionDate: Double?

	override val firstName: String?

	override val lastName: String?

	override val names: Array<PersonNameJs>

	override val companyName: String?

	override val languages: Array<String>

	override val addresses: Array<DecryptedAddressJs>

	override val civility: String?

	override val gender: String?

	override val properties: Array<DecryptedPropertyStubJs>

	override val secretForeignKeys: Array<String>

	override val cryptedForeignKeys: Record<String, Array<DelegationJs>>

	override val delegations: Record<String, Array<DelegationJs>>

	override val encryptionKeys: Record<String, Array<DelegationJs>>

	override val encryptedSelf: String?

	override val securityMetadata: SecurityMetadataJs?

	override val isEncrypted: Boolean
}

@JsName("EncryptedRelatedPerson")
public external class EncryptedRelatedPersonJs(
	partial: dynamic,
) : RelatedPersonJs {
	override val id: String

	override val rev: String?

	override val identifier: Array<IdentifierJs>

	override val created: Double?

	override val modified: Double?

	override val author: String?

	override val responsible: String?

	override val tags: Array<CodeStubJs>

	override val codes: Array<CodeStubJs>

	override val endOfLife: Double?

	override val deletionDate: Double?

	override val firstName: String?

	override val lastName: String?

	override val names: Array<PersonNameJs>

	override val companyName: String?

	override val languages: Array<String>

	override val addresses: Array<EncryptedAddressJs>

	override val civility: String?

	override val gender: String?

	override val properties: Array<EncryptedPropertyStubJs>

	override val secretForeignKeys: Array<String>

	override val cryptedForeignKeys: Record<String, Array<DelegationJs>>

	override val delegations: Record<String, Array<DelegationJs>>

	override val encryptionKeys: Record<String, Array<DelegationJs>>

	override val encryptedSelf: String?

	override val securityMetadata: SecurityMetadataJs?

	override val isEncrypted: Boolean
}
