// auto-generated file
@file:JsQualifier("model")

package com.icure.sdk.js.model

import com.icure.sdk.js.model.base.NamedJs
import com.icure.sdk.js.model.base.StoredDocumentJs
import com.icure.sdk.js.model.embed.DecryptedAddressJs
import kotlin.Double
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("Place")
public external class PlaceJs(
	partial: dynamic,
) : StoredDocumentJs, NamedJs {
	override val id: String

	override val rev: String?

	override val deletionDate: Double?

	override val name: String?

	public val address: DecryptedAddressJs?
}
