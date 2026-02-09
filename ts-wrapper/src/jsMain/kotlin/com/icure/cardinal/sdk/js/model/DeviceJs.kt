// auto-generated file
@file:JsQualifier("model")

package com.icure.cardinal.sdk.js.model

import com.icure.cardinal.sdk.js.model.base.CodeStubJs
import com.icure.cardinal.sdk.js.model.base.CryptoActorJs
import com.icure.cardinal.sdk.js.model.base.DataOwnerJs
import com.icure.cardinal.sdk.js.model.base.ICureDocumentJs
import com.icure.cardinal.sdk.js.model.base.IdentifierJs
import com.icure.cardinal.sdk.js.model.base.NamedJs
import com.icure.cardinal.sdk.js.model.base.StoredDocumentJs
import com.icure.cardinal.sdk.js.utils.Record
import kotlin.Array
import kotlin.Double
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("Device")
public external class DeviceJs(
	partial: dynamic,
) : StoredDocumentJs, ICureDocumentJs<String>, NamedJs, CryptoActorJs, DataOwnerJs {
	override val id: String

	override val rev: String?

	override val deletionDate: Double?

	public val identifiers: Array<IdentifierJs>

	override val created: Double?

	override val modified: Double?

	override val author: String?

	override val responsible: String?

	override val tags: Array<CodeStubJs>

	override val codes: Array<CodeStubJs>

	override val name: String?

	public val type: String?

	public val brand: String?

	public val model: String?

	public val serialNumber: String?

	override val parentId: String?

	override val properties: Array<DecryptedPropertyStubJs>

	override val hcPartyKeys: Record<String, Array<String>>

	override val aesExchangeKeys: Record<String, Record<String, Record<String, String>>>

	override val transferKeys: Record<String, Record<String, String>>

	override val privateKeyShamirPartitions: Record<String, String>

	override val publicKey: String?

	override val publicKeysForOaepWithSha256: Array<String>

	override val cryptoActorProperties: Array<DecryptedPropertyStubJs>?

	override val ktClass: String
}
