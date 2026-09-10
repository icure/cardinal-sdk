// auto-generated file
@file:JsQualifier("model")

package com.icure.cardinal.sdk.js.model

import com.icure.cardinal.sdk.js.model.base.CryptoActorJs
import com.icure.cardinal.sdk.js.model.base.DataOwnerGroupLinkJs
import com.icure.cardinal.sdk.js.model.base.VersionableJs
import com.icure.cardinal.sdk.js.utils.Record
import kotlin.Array
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("CryptoActorStub")
public external class CryptoActorStubJs(
	partial: dynamic,
) : VersionableJs<String>, CryptoActorJs {
	override val id: String

	override val rev: String

	override val hcPartyKeys: Record<String, Array<String>>

	override val aesExchangeKeys: Record<String, Record<String, Record<String, String>>>

	override val transferKeys: Record<String, Record<String, String>>

	override val privateKeyShamirPartitions: Record<String, String>

	override val publicKey: String?

	override val publicKeysForOaepWithSha256: Array<String>

	override val dataOwnerGroups: Array<DataOwnerGroupLinkJs>

	override val groupLinkType: String?

	override val cryptoActorProperties: Array<DecryptedPropertyStubJs>?

	override val ktClass: String
}
