// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.model.base.CodeStub
import com.icure.cardinal.sdk.model.base.HasEndOfLife
import com.icure.cardinal.sdk.model.base.ICureDocument
import com.icure.cardinal.sdk.model.base.StoredDocument
import com.icure.cardinal.sdk.model.embed.AgendaSlottingAlgorithm
import com.icure.cardinal.sdk.model.embed.ResourceGroupAllocationSchedule
import com.icure.cardinal.sdk.model.embed.UserAccessLevel
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.Set
import com.icure.cardinal.sdk.model.embed.Right
import kotlin.Deprecated

/**
 * Represents an agenda that keeps track of appointments (calendar items) for a resource or group of
 * resources.
 * An agenda can specify a schedule for its resources and allows managing availabilities for
 * booking.
 * /
 */
@Serializable
data class Agenda(
	/**
	 * The Id of the agenda. We encourage using either a v4 UUID or a HL7 Id.
	 */
	override val id: String,
	/**
	 * The revision of the agenda in the database, used for conflict management / optimistic locking.
	 */
	override val rev: String? = null,
	/**
	 * The timestamp (unix epoch in ms) of creation of this entity.
	 */
	override val created: Long? = null,
	/**
	 * The timestamp (unix epoch in ms) of the latest modification of this entity.
	 */
	override val modified: Long? = null,
	/**
	 * The id of the User that created this agenda.
	 */
	override val author: String? = null,
	/**
	 * The id of the data owner that is responsible for this agenda.
	 */
	override val responsible: String? = null,
	/**
	 * Tags that qualify the agenda as being member of a certain class.
	 */
	@param:DefaultValue("emptySet()")
	override val tags: Set<CodeStub> = emptySet(),
	/**
	 * Codes that identify or qualify this particular agenda.
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
	 * A fuzzy time in HHMMSS format used to split working hours into blocks for availabilities
	 * computation.
	 */
	public val daySplitHour: Int? = null,
	/**
	 * If true the agenda is not available for availabilities and safe booking requests.
	 */
	@param:DefaultValue("false")
	public val unpublished: Boolean = false,
	/**
	 * The name of the agenda.
	 */
	public val name: String? = null,
	/**
	 * The id of the user associated with this agenda.
	 */
	public val userId: String? = null,
	/**
	 * An identifier for the time zone of the agenda, must be an id accepted by java's ZoneId.
	 */
	public val zoneId: String? = null,
	/**
	 * Associates a user id to the permission that user has on the entity.
	 */
	@param:DefaultValue("emptyMap()")
	public val userRights: Map<String, UserAccessLevel> = emptyMap(),
	/**
	 * The algorithm to use for computing time slots in the agenda.
	 */
	public val slottingAlgorithm: AgendaSlottingAlgorithm? = null,
	/**
	 * If not null, limits the amount of monthly appointments per unprivileged user for this agenda.
	 */
	public val publicBookingQuota: Int? = null,
	/**
	 * Custom properties of the agenda.
	 */
	@param:DefaultValue("emptySet()")
	public val properties: Set<DecryptedPropertyStub> = emptySet(),
	/**
	 * The resource group allocation schedules defining availability rules for this agenda.
	 */
	@param:DefaultValue("emptyList()")
	public val schedules: List<ResourceGroupAllocationSchedule> = emptyList(),
) : StoredDocument, ICureDocument<String>, HasEndOfLife {
	// region Agenda-Agenda

	// endregion
}
