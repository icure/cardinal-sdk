// auto-generated file
@file:JsQualifier("model")

package com.icure.sdk.js.model

import com.icure.sdk.js.model.base.CodeIdentificationJs
import com.icure.sdk.js.model.base.StoredDocumentJs
import com.icure.sdk.js.model.embed.PeriodicityJs
import com.icure.sdk.js.utils.Record
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("Code")
public external class CodeJs(
	partial: dynamic,
) : StoredDocumentJs, CodeIdentificationJs<String> {
	override val id: String

	override val rev: String?

	override val deletionDate: Double?

	override val context: String?

	override val type: String?

	override val code: String?

	override val version: String?

	override val label: Record<String, String>?

	public val author: String?

	public val regions: Array<String>

	public val periodicity: Array<PeriodicityJs>

	public val level: Double?

	public val links: Array<String>

	public val qualifiedLinks: Record<String, Array<String>>

	public val flags: Array<String>

	public val searchTerms: Record<String, Array<String>>

	public val `data`: String?

	public val appendices: Record<String, String>

	public val disabled: Boolean
}
