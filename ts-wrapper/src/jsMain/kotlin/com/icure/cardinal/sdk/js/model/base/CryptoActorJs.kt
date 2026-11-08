// auto-generated file
@file:JsQualifier("model")

package com.icure.cardinal.sdk.js.model.base

import com.icure.cardinal.sdk.js.model.DecryptedPropertyStubJs
import com.icure.cardinal.sdk.js.utils.Record
import kotlin.Array
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("CryptoActor")
public external interface CryptoActorJs : VersionableJs<String> {
	public val hcPartyKeys: Record<String, out Array<out String>>

	public val aesExchangeKeys: Record<String, out Record<String, out Record<String, out String>>>

	public val transferKeys: Record<String, out Record<String, out String>>

	public val privateKeyShamirPartitions: Record<String, out String>

	public val publicKey: String?

	public val publicKeysForOaepWithSha256: Array<out String>

	public val dataOwnerGroups: Array<out DataOwnerGroupLinkJs>

	public val groupLinkType: String?

	public val cryptoActorProperties: Array<out DecryptedPropertyStubJs>?

	@JsName("${'$'}ktClass")
	public val ktClass: String
}
