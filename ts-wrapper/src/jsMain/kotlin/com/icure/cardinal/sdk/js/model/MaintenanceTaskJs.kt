// auto-generated file
@file:JsQualifier("model")

package com.icure.cardinal.sdk.js.model

import com.icure.cardinal.sdk.js.model.base.CodeStubJs
import com.icure.cardinal.sdk.js.model.base.HasEncryptionMetadataJs
import com.icure.cardinal.sdk.js.model.base.HasEndOfLifeJs
import com.icure.cardinal.sdk.js.model.base.ICureDocumentJs
import com.icure.cardinal.sdk.js.model.base.IdentifierJs
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

@JsName("MaintenanceTask")
public sealed external interface MaintenanceTaskJs : StoredDocumentJs, ICureDocumentJs<String>,
		HasEncryptionMetadataJs, EncryptableJs, HasEndOfLifeJs {
	public val identifier: Array<out IdentifierJs>

	public val taskType: String?

	public val properties: Array<out PropertyStubJs>

	public val status: String

	public val isEncrypted: Boolean
}

@JsName("DecryptedMaintenanceTask")
public external class DecryptedMaintenanceTaskJs(
	partial: dynamic,
) : MaintenanceTaskJs {
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

	override val taskType: String?

	override val properties: Array<DecryptedPropertyStubJs>

	override val status: String

	override val secretForeignKeys: Array<String>

	override val cryptedForeignKeys: Record<String, Array<DelegationJs>>

	override val delegations: Record<String, Array<DelegationJs>>

	override val encryptionKeys: Record<String, Array<DelegationJs>>

	override val encryptedSelf: String?

	override val securityMetadata: SecurityMetadataJs?

	override val isEncrypted: Boolean
}

@JsName("EncryptedMaintenanceTask")
public external class EncryptedMaintenanceTaskJs(
	partial: dynamic,
) : MaintenanceTaskJs {
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

	override val taskType: String?

	override val properties: Array<EncryptedPropertyStubJs>

	override val status: String

	override val secretForeignKeys: Array<String>

	override val cryptedForeignKeys: Record<String, Array<DelegationJs>>

	override val delegations: Record<String, Array<DelegationJs>>

	override val encryptionKeys: Record<String, Array<DelegationJs>>

	override val encryptedSelf: String?

	override val securityMetadata: SecurityMetadataJs?

	override val isEncrypted: Boolean
}
