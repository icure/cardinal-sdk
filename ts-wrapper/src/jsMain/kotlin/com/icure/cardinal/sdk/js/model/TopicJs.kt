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

@JsName("Topic")
public sealed external interface TopicJs : StoredDocumentJs, ICureDocumentJs<String>,
		HasEncryptionMetadataJs, EncryptableJs {
	public val healthElementId: String?

	public val contactId: String?

	public val description: String?

	public val activeParticipants: Record<String, out String>

	public val linkedHealthElements: Array<out String>

	public val linkedServices: Array<out String>

	public val isEncrypted: Boolean
}

@JsName("DecryptedTopic")
public external class DecryptedTopicJs(
	partial: dynamic,
) : TopicJs {
	override val id: String

	override val rev: String?

	override val created: Double?

	override val modified: Double?

	override val healthElementId: String?

	override val contactId: String?

	override val description: String?

	override val codes: Array<CodeStubJs>

	override val tags: Array<CodeStubJs>

	override val author: String?

	override val responsible: String?

	override val deletionDate: Double?

	override val activeParticipants: Record<String, String>

	override val securityMetadata: SecurityMetadataJs?

	override val secretForeignKeys: Array<String>

	override val cryptedForeignKeys: Record<String, Array<DelegationJs>>

	override val delegations: Record<String, Array<DelegationJs>>

	override val encryptionKeys: Record<String, Array<DelegationJs>>

	override val encryptedSelf: String?

	override val linkedHealthElements: Array<String>

	override val linkedServices: Array<String>

	override val isEncrypted: Boolean
}

@JsName("EncryptedTopic")
public external class EncryptedTopicJs(
	partial: dynamic,
) : TopicJs {
	override val id: String

	override val rev: String?

	override val created: Double?

	override val modified: Double?

	override val healthElementId: String?

	override val contactId: String?

	override val description: String?

	override val codes: Array<CodeStubJs>

	override val tags: Array<CodeStubJs>

	override val author: String?

	override val responsible: String?

	override val deletionDate: Double?

	override val activeParticipants: Record<String, String>

	override val securityMetadata: SecurityMetadataJs?

	override val secretForeignKeys: Array<String>

	override val cryptedForeignKeys: Record<String, Array<DelegationJs>>

	override val delegations: Record<String, Array<DelegationJs>>

	override val encryptionKeys: Record<String, Array<DelegationJs>>

	override val encryptedSelf: String?

	override val linkedHealthElements: Array<String>

	override val linkedServices: Array<String>

	override val isEncrypted: Boolean
}
