// auto-generated file
@file:JsQualifier("model")

package com.icure.cardinal.sdk.js.model

import com.icure.cardinal.sdk.js.model.base.StoredDocumentJs
import com.icure.cardinal.sdk.js.utils.Record
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("CalendarItemType")
public external class CalendarItemTypeJs(
	partial: dynamic,
) : StoredDocumentJs {
	override val id: String

	override val rev: String?

	override val deletionDate: Double?

	public val healthcarePartyId: String?

	public val agendaId: String?

	public val defaultCalendarItemType: Boolean

	public val name: String?

	public val color: String?

	public val duration: Double

	public val extraDurationsConfig: CalendarItemTypeJs_DurationConfigJs?

	public val externalRef: String?

	public val mikronoId: String?

	public val docIds: Array<String>

	public val otherInfos: Record<String, String>

	public val subjectByLanguage: Record<String, String>
}
