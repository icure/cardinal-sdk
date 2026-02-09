// auto-generated file
@file:JsQualifier("model")

package com.icure.cardinal.sdk.js.model

import com.icure.cardinal.sdk.js.model.base.CodeStubJs
import com.icure.cardinal.sdk.js.model.base.HasEncryptionMetadataJs
import com.icure.cardinal.sdk.js.model.base.ICureDocumentJs
import com.icure.cardinal.sdk.js.model.base.StoredDocumentJs
import com.icure.cardinal.sdk.js.model.embed.DelegationJs
import com.icure.cardinal.sdk.js.model.embed.EncryptableJs
import com.icure.cardinal.sdk.js.model.embed.MessageReadStatusJs
import com.icure.cardinal.sdk.js.model.embed.SecurityMetadataJs
import com.icure.cardinal.sdk.js.utils.Record
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("Message")
public sealed external interface MessageJs : StoredDocumentJs, ICureDocumentJs<String>,
		HasEncryptionMetadataJs, EncryptableJs {
	public val fromAddress: String?

	public val fromHealthcarePartyId: String?

	public val recipients: Array<out String>

	public val toAddresses: Array<out String>

	public val received: Double?

	public val sent: Double?

	public val metas: Record<String, out String>

	public val readStatus: Record<String, out MessageReadStatusJs>

	public val transportGuid: String?

	public val remark: String?

	public val conversationGuid: String?

	public val subject: String?

	public val invoiceIds: Array<out String>

	public val parentId: String?

	public val isEncrypted: Boolean
}

@JsName("DecryptedMessage")
public external class DecryptedMessageJs(
	partial: dynamic,
) : MessageJs {
	override val id: String

	override val rev: String?

	override val created: Double?

	override val modified: Double?

	override val author: String?

	override val responsible: String?

	override val tags: Array<CodeStubJs>

	override val codes: Array<CodeStubJs>

	override val deletionDate: Double?

	override val fromAddress: String?

	override val fromHealthcarePartyId: String?

	override val recipients: Array<String>

	override val toAddresses: Array<String>

	override val received: Double?

	override val sent: Double?

	override val metas: Record<String, String>

	override val readStatus: Record<String, MessageReadStatusJs>

	override val transportGuid: String?

	override val remark: String?

	override val conversationGuid: String?

	override val subject: String?

	override val invoiceIds: Array<String>

	override val parentId: String?

	override val secretForeignKeys: Array<String>

	override val cryptedForeignKeys: Record<String, Array<DelegationJs>>

	override val delegations: Record<String, Array<DelegationJs>>

	override val encryptionKeys: Record<String, Array<DelegationJs>>

	override val encryptedSelf: String?

	override val securityMetadata: SecurityMetadataJs?

	override val isEncrypted: Boolean
}

@JsName("EncryptedMessage")
public external class EncryptedMessageJs(
	partial: dynamic,
) : MessageJs {
	override val id: String

	override val rev: String?

	override val created: Double?

	override val modified: Double?

	override val author: String?

	override val responsible: String?

	override val tags: Array<CodeStubJs>

	override val codes: Array<CodeStubJs>

	override val deletionDate: Double?

	override val fromAddress: String?

	override val fromHealthcarePartyId: String?

	override val recipients: Array<String>

	override val toAddresses: Array<String>

	override val received: Double?

	override val sent: Double?

	override val metas: Record<String, String>

	override val readStatus: Record<String, MessageReadStatusJs>

	override val transportGuid: String?

	override val remark: String?

	override val conversationGuid: String?

	override val subject: String?

	override val invoiceIds: Array<String>

	override val parentId: String?

	override val secretForeignKeys: Array<String>

	override val cryptedForeignKeys: Record<String, Array<DelegationJs>>

	override val delegations: Record<String, Array<DelegationJs>>

	override val encryptionKeys: Record<String, Array<DelegationJs>>

	override val encryptedSelf: String?

	override val securityMetadata: SecurityMetadataJs?

	override val isEncrypted: Boolean
}
