// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.model.base.StoredDocument
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.Map
import kotlin.collections.Set

/**
 * Represents a type of calendar item, defining properties like duration, color, and name for
 * appointments.
 * Calendar item types are used to categorize calendar items within an agenda.
 * /
 */
@Serializable
data class CalendarItemType(
	/**
	 * The Id of the calendar item type.
	 */
	override val id: String,
	/**
	 * The revision of the calendar item type in the database, used for conflict management /
	 * optimistic locking.
	 */
	override val rev: String? = null,
	/**
	 * Hard delete (unix epoch in ms) timestamp of the object.
	 */
	override val deletionDate: Long? = null,
	/**
	 * The id of the healthcare party associated with this type.
	 */
	public val healthcarePartyId: String? = null,
	/**
	 * The id of the agenda this type belongs to.
	 */
	public val agendaId: String? = null,
	/**
	 * Whether this is the default calendar item type for its agenda.
	 */
	@param:DefaultValue("false")
	public val defaultCalendarItemType: Boolean = false,
	/**
	 * The display name of this calendar item type.
	 */
	public val name: String? = null,
	/**
	 * The color associated with this type, in hex format (e.g. "#123456").
	 */
	public val color: String? = null,
	/**
	 * The default duration in minutes for calendar items of this type.
	 */
	@param:DefaultValue("0")
	public val duration: Int = 0,
	/**
	 * Optional configuration for additional allowed durations.
	 */
	public val extraDurationsConfig: DurationConfig? = null,
	/**
	 * An external reference identifier.
	 */
	public val externalRef: String? = null,
	/**
	 * An external Mikrono identifier.
	 */
	public val mikronoId: String? = null,
	/**
	 * A set of document ids associated with this type.
	 */
	@param:DefaultValue("emptySet()")
	public val docIds: Set<String> = emptySet(),
	/**
	 * Additional information stored as key-value pairs.
	 */
	@param:DefaultValue("emptyMap()")
	public val otherInfos: Map<String, String> = emptyMap(),
	/**
	 * Subject text for this calendar item type, by language.
	 */
	@param:DefaultValue("emptyMap()")
	public val subjectByLanguage: Map<String, String> = emptyMap(),
	/**
	 * Public properties exposed to anonymous endpoints for public calendar items.
	 */
	public val publicProperties: Set<DecryptedPropertyStub>? = null,
) : StoredDocument {
	@Serializable
	public sealed interface DurationConfig {
		@Serializable
		@SerialName("Set")
		public data class Set(
			@param:DefaultValue("emptySet()")
			public val durations: kotlin.collections.Set<Int> = emptySet(),
		) : DurationConfig

		@Serializable
		@SerialName("Formula")
		public data class Formula(
			public val min: Int,
			public val max: Int,
			public val step: Int,
		) : DurationConfig
	}
	// region CalendarItemType-CalendarItemType

	// endregion
}
