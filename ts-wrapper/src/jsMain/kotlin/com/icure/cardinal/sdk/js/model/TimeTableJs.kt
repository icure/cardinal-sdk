// auto-generated file
@file:JsQualifier("model")

package com.icure.cardinal.sdk.js.model

import com.icure.cardinal.sdk.js.model.base.CodeStubJs
import com.icure.cardinal.sdk.js.model.base.HasEndOfLifeJs
import com.icure.cardinal.sdk.js.model.base.ICureDocumentJs
import com.icure.cardinal.sdk.js.model.base.StoredDocumentJs
import com.icure.cardinal.sdk.js.model.embed.TimeTableItemJs
import kotlin.Array
import kotlin.Double
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("TimeTable")
public external class TimeTableJs(
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

	public val name: String?

	public val agendaId: String?

	public val startTime: Double?

	public val endTime: Double?

	public val items: Array<TimeTableItemJs>
}
