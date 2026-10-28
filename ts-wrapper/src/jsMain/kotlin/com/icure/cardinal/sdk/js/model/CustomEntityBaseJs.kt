// auto-generated file
@file:JsQualifier("model")

package com.icure.cardinal.sdk.js.model

import com.icure.cardinal.sdk.js.model.base.CodeStubJs
import com.icure.cardinal.sdk.js.model.base.CustomisableRootJs
import com.icure.cardinal.sdk.js.model.base.ExtendableJs
import com.icure.cardinal.sdk.js.model.base.HasEncryptionMetadataJs
import com.icure.cardinal.sdk.js.model.base.ICureDocumentJs
import com.icure.cardinal.sdk.js.model.base.StoredDocumentJs
import com.icure.cardinal.sdk.js.model.embed.DataAttachmentJs
import com.icure.cardinal.sdk.js.model.embed.DelegationJs
import com.icure.cardinal.sdk.js.model.embed.EncryptableJs
import com.icure.cardinal.sdk.js.model.embed.SecurityMetadataJs
import com.icure.cardinal.sdk.js.utils.Record
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.Nothing
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("CustomEntityBase")
public sealed external interface CustomEntityBaseJs : HasEncryptionMetadataJs, StoredDocumentJs,
		ICureDocumentJs<String>, CustomisableRootJs, ExtendableJs, EncryptableJs {
	public val endOfLife: Double?

	public val dataAttachments: Record<String, out DataAttachmentJs>

	public val deletedAttachments: Array<dynamic>

	public val isEncrypted: Boolean
}

@JsName("DecryptedCustomEntityBase")
public external class DecryptedCustomEntityBaseJs(
	partial: dynamic,
) : CustomEntityBaseJs {
	override val id: String

	override val rev: String?

	override val deletionDate: Double?

	override val secretForeignKeys: Array<String>

	override val cryptedForeignKeys: Record<String, Array<DelegationJs>>

	override val delegations: Record<String, Array<DelegationJs>>

	override val encryptionKeys: Record<String, Array<DelegationJs>>

	override val securityMetadata: SecurityMetadataJs?

	override val created: Double?

	override val modified: Double?

	override val author: String?

	override val responsible: String?

	override val endOfLife: Double?

	override val tags: Array<CodeStubJs>

	override val codes: Array<CodeStubJs>

	override val customisedModelVersion: Double?

	override val extensions: dynamic

	override val dataAttachments: Record<String, DataAttachmentJs>

	override val deletedAttachments: Array<dynamic>

	override val encryptedSelf: Nothing?

	override val isEncrypted: Boolean

	override val ktClass: String
}

@JsName("EncryptedCustomEntityBase")
public external class EncryptedCustomEntityBaseJs(
	partial: dynamic,
) : CustomEntityBaseJs {
	override val id: String

	override val rev: String?

	override val deletionDate: Double?

	override val secretForeignKeys: Array<String>

	override val cryptedForeignKeys: Record<String, Array<DelegationJs>>

	override val delegations: Record<String, Array<DelegationJs>>

	override val encryptionKeys: Record<String, Array<DelegationJs>>

	override val securityMetadata: SecurityMetadataJs?

	override val created: Double?

	override val modified: Double?

	override val author: String?

	override val responsible: String?

	override val endOfLife: Double?

	override val tags: Array<CodeStubJs>

	override val codes: Array<CodeStubJs>

	override val customisedModelVersion: Double?

	override val extensions: dynamic

	override val dataAttachments: Record<String, DataAttachmentJs>

	override val deletedAttachments: Array<dynamic>

	override val encryptedSelf: Nothing?

	override val isEncrypted: Boolean

	override val ktClass: String
}
