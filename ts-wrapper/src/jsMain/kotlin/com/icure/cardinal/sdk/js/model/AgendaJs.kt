// auto-generated file
@file:JsQualifier("model")

package com.icure.cardinal.sdk.js.model

import com.icure.cardinal.sdk.js.model.base.CodeStubJs
import com.icure.cardinal.sdk.js.model.base.ICureDocumentJs
import com.icure.cardinal.sdk.js.model.base.StoredDocumentJs
import com.icure.cardinal.sdk.js.model.embed.AgendaSlottingAlgorithmJs
import com.icure.cardinal.sdk.js.model.embed.ResourceGroupAllocationScheduleJs
import com.icure.cardinal.sdk.js.model.embed.RightJs
import com.icure.cardinal.sdk.js.utils.Record
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("Agenda")
public external class AgendaJs(
	partial: dynamic,
) : StoredDocumentJs, ICureDocumentJs<String> {
	override val id: String

	override val rev: String?

	override val created: Double?

	override val modified: Double?

	override val author: String?

	override val responsible: String?

	override val medicalLocationId: String?

	override val tags: Array<CodeStubJs>

	override val codes: Array<CodeStubJs>

	override val endOfLife: Double?

	override val deletionDate: Double?

	public val daySplitHour: Double?

	public val unpublished: Boolean

	public val name: String?

	public val userId: String?

	public val zoneId: String?

	public val lockCalendarItemsBeforeInMinutes: Double?

	public val rights: Array<RightJs>

	public val userRights: Record<String, String>

	public val slottingAlgorithm: AgendaSlottingAlgorithmJs?

	public val properties: Array<DecryptedPropertyStubJs>

	public val schedules: Array<ResourceGroupAllocationScheduleJs>
}
