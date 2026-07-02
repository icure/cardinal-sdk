// auto-generated file
@file:JsQualifier("model")

package com.icure.cardinal.sdk.js.model

import com.icure.cardinal.sdk.js.model.base.CodeStubJs
import com.icure.cardinal.sdk.js.model.base.HasCodesJs
import com.icure.cardinal.sdk.js.model.base.HasIdentifierJs
import com.icure.cardinal.sdk.js.model.base.HasTagsJs
import com.icure.cardinal.sdk.js.model.base.IdentifierJs
import com.icure.cardinal.sdk.js.model.base.StoredDocumentJs
import com.icure.cardinal.sdk.js.model.embed.DecryptedAddressJs
import com.icure.cardinal.sdk.js.utils.Record
import kotlin.Array
import kotlin.Double
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("Insurance")
public external class InsuranceJs(
	partial: dynamic,
) : StoredDocumentJs, HasTagsJs, HasCodesJs, HasIdentifierJs {
	override val id: String

	override val rev: String?

	override val deletionDate: Double?

	public val name: Record<String, String>

	override val identifier: Array<IdentifierJs>

	override val tags: Array<CodeStubJs>

	override val codes: Array<CodeStubJs>

	public val code: String?

	public val agreementNumber: String?

	public val parent: String?

	public val address: DecryptedAddressJs
}
