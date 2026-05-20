// auto-generated file
@file:JsQualifier("model")

package com.icure.cardinal.sdk.js.model.embed

import kotlin.Boolean
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("Partnership")
public sealed external interface PartnershipJs : EncryptableJs {
	public val type: String?

	public val status: String?

	public val partnerId: String?

	public val isEncrypted: Boolean
}

@JsName("DecryptedPartnership")
public external class DecryptedPartnershipJs(
	partial: dynamic,
) : PartnershipJs {
	override val type: String?

	override val status: String?

	override val partnerId: String?

	override val encryptedSelf: String?

	override val isEncrypted: Boolean
}

@JsName("EncryptedPartnership")
public external class EncryptedPartnershipJs(
	partial: dynamic,
) : PartnershipJs {
	override val type: String?

	override val status: String?

	override val partnerId: String?

	override val encryptedSelf: String?

	override val isEncrypted: Boolean
}
