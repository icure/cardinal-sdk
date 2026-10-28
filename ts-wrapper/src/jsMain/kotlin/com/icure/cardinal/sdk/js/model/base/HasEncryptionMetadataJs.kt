// auto-generated file
@file:JsQualifier("model")

package com.icure.cardinal.sdk.js.model.base

import com.icure.cardinal.sdk.js.model.embed.DelegationJs
import com.icure.cardinal.sdk.js.model.embed.SecurityMetadataJs
import com.icure.cardinal.sdk.js.utils.Record
import kotlin.Array
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("HasEncryptionMetadata")
public external interface HasEncryptionMetadataJs : VersionableJs<String> {
	public val secretForeignKeys: Array<out String>

	public val cryptedForeignKeys: Record<String, out Array<out DelegationJs>>

	public val delegations: Record<String, out Array<out DelegationJs>>

	public val encryptionKeys: Record<String, out Array<out DelegationJs>>

	public val securityMetadata: SecurityMetadataJs?

	@JsName("${'$'}ktClass")
	public val ktClass: String
}
