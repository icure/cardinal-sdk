// auto-generated file
@file:JsQualifier("model")

package com.icure.cardinal.sdk.js.model

import com.icure.cardinal.sdk.js.model.base.CodeStubJs
import com.icure.cardinal.sdk.js.model.base.HasEndOfLifeJs
import com.icure.cardinal.sdk.js.model.base.ICureDocumentJs
import com.icure.cardinal.sdk.js.model.base.StoredDocumentJs
import com.icure.cardinal.sdk.js.model.embed.DocumentGroupJs
import kotlin.Array
import kotlin.ByteArray
import kotlin.Double
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("DocumentTemplate")
public external class DocumentTemplateJs(
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

	public val attachment: ByteArray?

	public val documentType: String?

	public val mainUti: String?

	public val name: String?

	public val otherUtis: Array<String>

	public val attachmentId: String?

	public val version: String?

	public val owner: String?

	public val guid: String?

	public val group: DocumentGroupJs?

	public val descr: String?

	public val disabled: String?

	public val specialty: CodeStubJs?
}
