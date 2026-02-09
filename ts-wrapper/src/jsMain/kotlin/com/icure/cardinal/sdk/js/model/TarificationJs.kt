// auto-generated file
@file:JsQualifier("model")

package com.icure.cardinal.sdk.js.model

import com.icure.cardinal.sdk.js.model.base.CodeIdentificationJs
import com.icure.cardinal.sdk.js.model.base.StoredDocumentJs
import com.icure.cardinal.sdk.js.model.embed.DecryptedValorisationJs
import com.icure.cardinal.sdk.js.model.embed.LetterValueJs
import com.icure.cardinal.sdk.js.model.embed.PeriodicityJs
import com.icure.cardinal.sdk.js.utils.Record
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("Tarification")
public external class TarificationJs(
	partial: dynamic,
) : StoredDocumentJs, CodeIdentificationJs<String> {
	override val id: String

	override val rev: String?

	override val deletionDate: Double?

	public val label: Record<String, String>?

	override val context: String?

	override val type: String?

	override val code: String?

	override val version: String?

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

	public val valorisations: Array<DecryptedValorisationJs>

	public val category: Record<String, String>

	public val consultationCode: Boolean?

	public val hasRelatedCode: Boolean?

	public val needsPrescriber: Boolean?

	public val relatedCodes: Array<String>

	public val ngroup: String?

	public val letterValues: Array<LetterValueJs>
}
