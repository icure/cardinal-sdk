// auto-generated file
@file:JsQualifier("model")

package com.icure.cardinal.sdk.js.model.embed

import com.icure.cardinal.sdk.js.utils.Record
import kotlin.Array
import kotlin.Boolean
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("FlatRateTarification")
public sealed external interface FlatRateTarificationJs : EncryptableJs {
	public val code: String?

	public val flatRateType: String?

	public val label: Record<String, out String>?

	public val valorisations: Array<out ValorisationJs>

	public val isEncrypted: Boolean
}

@JsName("DecryptedFlatRateTarification")
public external class DecryptedFlatRateTarificationJs(
	partial: dynamic,
) : FlatRateTarificationJs {
	override val code: String?

	override val flatRateType: String?

	override val label: Record<String, String>?

	override val valorisations: Array<DecryptedValorisationJs>

	override val encryptedSelf: String?

	override val isEncrypted: Boolean
}

@JsName("EncryptedFlatRateTarification")
public external class EncryptedFlatRateTarificationJs(
	partial: dynamic,
) : FlatRateTarificationJs {
	override val code: String?

	override val flatRateType: String?

	override val label: Record<String, String>?

	override val valorisations: Array<EncryptedValorisationJs>

	override val encryptedSelf: String?

	override val isEncrypted: Boolean
}
