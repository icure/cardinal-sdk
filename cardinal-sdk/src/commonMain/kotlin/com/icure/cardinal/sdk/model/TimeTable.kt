package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.model.base.CodeStub
import com.icure.cardinal.sdk.model.base.HasEndOfLife
import com.icure.cardinal.sdk.model.base.ICureDocument
import com.icure.cardinal.sdk.model.base.StoredDocument
import com.icure.cardinal.sdk.model.embed.TimeTableItem
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Set

/**
 * Represents a timetable for scheduling appointments and availability. A timetable is linked to an
 * agenda
 * and defines time slots within a given period.
 * /
 */
@Serializable
public data class TimeTable(
	/**
	 * The unique identifier of the timetable.
	 */
	override val id: String,
	/**
	 * The revision of the timetable in the database, used for conflict management / optimistic
	 * locking.
	 */
	override val rev: String? = null,
	/**
	 * The timestamp (unix epoch in ms) of creation.
	 */
	override val created: Long? = null,
	/**
	 * The timestamp (unix epoch in ms) of the latest modification.
	 */
	override val modified: Long? = null,
	/**
	 * The id of the User that created this timetable.
	 */
	override val author: String? = null,
	/**
	 * The id of the HealthcareParty that is responsible for this timetable.
	 */
	override val responsible: String? = null,
	/**
	 * Tags that qualify the timetable as being member of a certain class.
	 */
	@param:DefaultValue("emptySet()")
	override val tags: Set<CodeStub> = emptySet(),
	/**
	 * Codes that identify or qualify this particular timetable.
	 */
	@param:DefaultValue("emptySet()")
	override val codes: Set<CodeStub> = emptySet(),
	/**
	 * Soft delete (unix epoch in ms) timestamp of the object.
	 */
	override val endOfLife: Long? = null,
	/**
	 * Hard delete (unix epoch in ms) timestamp of the object.
	 */
	override val deletionDate: Long? = null,
	/**
	 * The name of the timetable.
	 */
	public val name: String? = null,
	/**
	 * The id of the agenda this timetable belongs to.
	 */
	public val agendaId: String? = null,
	/**
	 * The start time of the timetable period (format: YYYYMMDDHHMMSS).
	 */
	public val startTime: Long? = null,
	/**
	 * The end time of the timetable period (format: YYYYMMDDHHMMSS).
	 */
	public val endTime: Long? = null,
	/**
	 * The list of time table items defining individual time slots.
	 */
	@param:DefaultValue("emptyList()")
	public val items: List<TimeTableItem> = emptyList(),
) : StoredDocument, ICureDocument<String>, HasEndOfLife
