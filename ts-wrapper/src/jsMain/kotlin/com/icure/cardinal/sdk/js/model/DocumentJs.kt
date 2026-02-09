// auto-generated file
@file:JsQualifier("model")

package com.icure.cardinal.sdk.js.model

import com.icure.cardinal.sdk.js.model.base.CodeStubJs
import com.icure.cardinal.sdk.js.model.base.HasEncryptionMetadataJs
import com.icure.cardinal.sdk.js.model.base.ICureDocumentJs
import com.icure.cardinal.sdk.js.model.base.StoredDocumentJs
import com.icure.cardinal.sdk.js.model.embed.DataAttachmentJs
import com.icure.cardinal.sdk.js.model.embed.DelegationJs
import com.icure.cardinal.sdk.js.model.embed.DeletedAttachmentJs
import com.icure.cardinal.sdk.js.model.embed.EncryptableJs
import com.icure.cardinal.sdk.js.model.embed.SecurityMetadataJs
import com.icure.cardinal.sdk.js.utils.Record
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("Document")
public sealed external interface DocumentJs : StoredDocumentJs, ICureDocumentJs<String>,
		HasEncryptionMetadataJs, EncryptableJs {
	public val documentType: String?

	public val documentStatus: String?

	public val externalUri: String?

	public val name: String?

	public val version: String?

	public val size: Double?

	public val hash: String?

	public val openingContactId: String?

	public val attachmentId: String?

	public val objectStoreReference: String?

	public val mainUti: String?

	public val otherUtis: Array<out String>

	public val secondaryAttachments: Record<String, out DataAttachmentJs>

	public val deletedAttachments: Array<out DeletedAttachmentJs>

	public val isEncrypted: Boolean
}

@JsName("DecryptedDocument")
public external class DecryptedDocumentJs(
	partial: dynamic,
) : DocumentJs {
	override val id: String

	override val rev: String?

	override val created: Double?

	override val modified: Double?

	override val author: String?

	override val responsible: String?

	override val tags: Array<CodeStubJs>

	override val codes: Array<CodeStubJs>

	override val deletionDate: Double?

	override val documentType: String?

	override val documentStatus: String?

	override val externalUri: String?

	override val name: String?

	override val version: String?

	override val size: Double?

	override val hash: String?

	override val openingContactId: String?

	override val attachmentId: String?

	override val objectStoreReference: String?

	override val mainUti: String?

	override val otherUtis: Array<String>

	override val secondaryAttachments: Record<String, DataAttachmentJs>

	override val deletedAttachments: Array<DeletedAttachmentJs>

	override val secretForeignKeys: Array<String>

	override val cryptedForeignKeys: Record<String, Array<DelegationJs>>

	override val delegations: Record<String, Array<DelegationJs>>

	override val encryptionKeys: Record<String, Array<DelegationJs>>

	override val encryptedSelf: String?

	override val securityMetadata: SecurityMetadataJs?

	override val isEncrypted: Boolean
}

@JsName("EncryptedDocument")
public external class EncryptedDocumentJs(
	partial: dynamic,
) : DocumentJs {
	override val id: String

	override val rev: String?

	override val created: Double?

	override val modified: Double?

	override val author: String?

	override val responsible: String?

	override val tags: Array<CodeStubJs>

	override val codes: Array<CodeStubJs>

	override val deletionDate: Double?

	override val documentType: String?

	override val documentStatus: String?

	override val externalUri: String?

	override val name: String?

	override val version: String?

	override val size: Double?

	override val hash: String?

	override val openingContactId: String?

	override val attachmentId: String?

	override val objectStoreReference: String?

	override val mainUti: String?

	override val otherUtis: Array<String>

	override val secondaryAttachments: Record<String, DataAttachmentJs>

	override val deletedAttachments: Array<DeletedAttachmentJs>

	override val secretForeignKeys: Array<String>

	override val cryptedForeignKeys: Record<String, Array<DelegationJs>>

	override val delegations: Record<String, Array<DelegationJs>>

	override val encryptionKeys: Record<String, Array<DelegationJs>>

	override val encryptedSelf: String?

	override val securityMetadata: SecurityMetadataJs?

	override val isEncrypted: Boolean
}
