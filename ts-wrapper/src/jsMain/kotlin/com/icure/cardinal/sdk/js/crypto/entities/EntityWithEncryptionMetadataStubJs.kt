// auto-generated file
@file:JsQualifier("crypto")

package com.icure.cardinal.sdk.js.crypto.entities

import com.icure.cardinal.sdk.js.model.base.HasEncryptionMetadataJs
import com.icure.cardinal.sdk.js.model.embed.DelegationJs
import com.icure.cardinal.sdk.js.model.embed.SecurityMetadataJs
import com.icure.cardinal.sdk.js.utils.Record
import kotlin.Array
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("EntityWithEncryptionMetadataStub")
public external class EntityWithEncryptionMetadataStubJs(
	partial: dynamic,
) : HasEncryptionMetadataJs {
	override val id: String

	override val rev: String?

	override val secretForeignKeys: Array<String>

	override val cryptedForeignKeys: Record<String, Array<DelegationJs>>

	override val delegations: Record<String, Array<DelegationJs>>

	override val encryptionKeys: Record<String, Array<DelegationJs>>

	override val securityMetadata: SecurityMetadataJs?

	override val ktClass: String
}
