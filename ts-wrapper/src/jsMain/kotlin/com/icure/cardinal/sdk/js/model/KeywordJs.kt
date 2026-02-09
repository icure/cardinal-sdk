// auto-generated file
@file:JsQualifier("model")

package com.icure.cardinal.sdk.js.model

import com.icure.cardinal.sdk.js.model.base.CodeStubJs
import com.icure.cardinal.sdk.js.model.base.HasEndOfLifeJs
import com.icure.cardinal.sdk.js.model.base.ICureDocumentJs
import com.icure.cardinal.sdk.js.model.base.StoredDocumentJs
import com.icure.cardinal.sdk.js.model.embed.KeywordSubwordJs
import kotlin.Array
import kotlin.Double
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("Keyword")
public external class KeywordJs(
	partial: dynamic,
) : StoredDocumentJs, ICureDocumentJs<String>, HasEndOfLifeJs {
	override val id: String

	override val rev: String?

	override val created: Double?

	override val modified: Double?

	override val author: String?

	override val responsible: String?

	override val tags: Array<CodeStubJs>

	override val codes: Array<CodeStubJs>

	override val endOfLife: Double?

	override val deletionDate: Double?

	public val `value`: String?

	public val subWords: Array<KeywordSubwordJs>

	public val userId: String?
}
