// auto-generated file
@file:JsQualifier("model")

package com.icure.cardinal.sdk.js.model

import com.icure.cardinal.sdk.js.model.base.HasEncryptionMetadataJs
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

@JsName("SecureDelegationKeyMap")
public sealed external interface SecureDelegationKeyMapJs : StoredDocumentJs,
		HasEncryptionMetadataJs, EncryptableJs {
	public val delegationKey: String

	public val delegator: String?

	public val `delegate`: String?

	public val isEncrypted: Boolean
}

@JsName("DecryptedSecureDelegationKeyMap")
public external class DecryptedSecureDelegationKeyMapJs(
	partial: dynamic,
) : SecureDelegationKeyMapJs {
	override val id: String

	override val rev: String?

	override val delegationKey: String

	override val delegator: String?

	override val `delegate`: String?

	override val secretForeignKeys: Array<String>

	override val cryptedForeignKeys: Record<String, Array<DelegationJs>>

	override val delegations: Record<String, Array<DelegationJs>>

	override val encryptionKeys: Record<String, Array<DelegationJs>>

	override val encryptedSelf: String?

	override val securityMetadata: SecurityMetadataJs?

	override val deletionDate: Double?

	override val isEncrypted: Boolean

	override val ktClass: String
}

@JsName("EncryptedSecureDelegationKeyMap")
public external class EncryptedSecureDelegationKeyMapJs(
	partial: dynamic,
) : SecureDelegationKeyMapJs {
	override val id: String

	override val rev: String?

	override val delegationKey: String

	override val delegator: String?

	override val `delegate`: String?

	override val secretForeignKeys: Array<String>

	override val cryptedForeignKeys: Record<String, Array<DelegationJs>>

	override val delegations: Record<String, Array<DelegationJs>>

	override val encryptionKeys: Record<String, Array<DelegationJs>>

	override val encryptedSelf: String?

	override val securityMetadata: SecurityMetadataJs?

	override val deletionDate: Double?

	override val isEncrypted: Boolean

	override val ktClass: String
}
