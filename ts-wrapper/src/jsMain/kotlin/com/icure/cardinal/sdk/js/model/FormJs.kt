// auto-generated file
@file:JsQualifier("model")

package com.icure.cardinal.sdk.js.model

import com.icure.cardinal.sdk.js.model.base.CodeStubJs
import com.icure.cardinal.sdk.js.model.base.HasEncryptionMetadataJs
import com.icure.cardinal.sdk.js.model.base.ICureDocumentJs
import com.icure.cardinal.sdk.js.model.base.StoredDocumentJs
import com.icure.cardinal.sdk.js.model.embed.DelegationJs
import com.icure.cardinal.sdk.js.model.embed.EncryptableJs
import com.icure.cardinal.sdk.js.model.embed.SecurityMetadataJs
import com.icure.cardinal.sdk.js.utils.Record
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("Form")
public sealed external interface FormJs : StoredDocumentJs, ICureDocumentJs<String>,
		HasEncryptionMetadataJs, EncryptableJs {
	public val openingDate: Double?

	public val status: String?

	public val version: Double?

	public val descr: String?

	public val uniqueId: String?

	public val formTemplateId: String?

	public val contactId: String?

	public val healthElementId: String?

	public val planOfActionId: String?

	public val parent: String?

	public val anchorId: String?

	public val isEncrypted: Boolean
}

@JsName("DecryptedForm")
public external class DecryptedFormJs(
	partial: dynamic,
) : FormJs {
	override val id: String

	override val rev: String?

	override val created: Double?

	override val modified: Double?

	override val author: String?

	override val responsible: String?

	override val tags: Array<CodeStubJs>

	override val codes: Array<CodeStubJs>

	override val deletionDate: Double?

	override val openingDate: Double?

	override val status: String?

	override val version: Double?

	override val descr: String?

	override val uniqueId: String?

	override val formTemplateId: String?

	override val contactId: String?

	override val healthElementId: String?

	override val planOfActionId: String?

	override val parent: String?

	override val anchorId: String?

	override val secretForeignKeys: Array<String>

	override val cryptedForeignKeys: Record<String, Array<DelegationJs>>

	override val delegations: Record<String, Array<DelegationJs>>

	override val encryptionKeys: Record<String, Array<DelegationJs>>

	override val encryptedSelf: String?

	override val securityMetadata: SecurityMetadataJs?

	override val isEncrypted: Boolean
}

@JsName("EncryptedForm")
public external class EncryptedFormJs(
	partial: dynamic,
) : FormJs {
	override val id: String

	override val rev: String?

	override val created: Double?

	override val modified: Double?

	override val author: String?

	override val responsible: String?

	override val tags: Array<CodeStubJs>

	override val codes: Array<CodeStubJs>

	override val deletionDate: Double?

	override val openingDate: Double?

	override val status: String?

	override val version: Double?

	override val descr: String?

	override val uniqueId: String?

	override val formTemplateId: String?

	override val contactId: String?

	override val healthElementId: String?

	override val planOfActionId: String?

	override val parent: String?

	override val anchorId: String?

	override val secretForeignKeys: Array<String>

	override val cryptedForeignKeys: Record<String, Array<DelegationJs>>

	override val delegations: Record<String, Array<DelegationJs>>

	override val encryptionKeys: Record<String, Array<DelegationJs>>

	override val encryptedSelf: String?

	override val securityMetadata: SecurityMetadataJs?

	override val isEncrypted: Boolean
}
