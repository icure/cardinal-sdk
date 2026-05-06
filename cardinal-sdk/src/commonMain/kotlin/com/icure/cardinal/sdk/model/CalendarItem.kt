// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.model.base.CodeStub
import com.icure.cardinal.sdk.model.base.HasEncryptionMetadata
import com.icure.cardinal.sdk.model.base.ICureDocument
import com.icure.cardinal.sdk.model.base.StoredDocument
import com.icure.cardinal.sdk.model.embed.Address
import com.icure.cardinal.sdk.model.embed.CalendarItemTag
import com.icure.cardinal.sdk.model.embed.DecryptedAddress
import com.icure.cardinal.sdk.model.embed.DecryptedCalendarItemTag
import com.icure.cardinal.sdk.model.embed.Delegation
import com.icure.cardinal.sdk.model.embed.Encryptable
import com.icure.cardinal.sdk.model.embed.EncryptedAddress
import com.icure.cardinal.sdk.model.embed.EncryptedCalendarItemTag
import com.icure.cardinal.sdk.model.embed.SecurityMetadata
import com.icure.cardinal.sdk.model.specializations.Base64String
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Deprecated
import kotlin.Long
import kotlin.String
import kotlin.collections.Map
import kotlin.collections.Set
import com.icure.cardinal.sdk.model.embed.FlowItem

/**
 *
 *  Represents an appointment or event in a calendar. Calendar items are linked to an agenda and can
 * block
 *  availabilities for scheduling purposes.
 */

sealed interface CalendarItem :
	StoredDocument,
	ICureDocument<String>,
	HasEncryptionMetadata,
	Encryptable {
	/**
	 * The Id of the calendar item. We encourage using either a v4 UUID or a HL7 Id.
	 */
	override val id: String

	/**
	 * The revision of the calendar item in the database, used for conflict management / optimistic
	 * locking.
	 */
	override val rev: String?

	/**
	 * The timestamp (unix epoch in ms) of creation of this entity.
	 */
	override val created: Long?

	/**
	 * The timestamp (unix epoch in ms) of the latest modification of this entity.
	 */
	override val modified: Long?

	/**
	 * The id of the User that created this calendar item.
	 */
	override val author: String?

	/**
	 * The id of the data owner that is responsible for this calendar item.
	 */
	override val responsible: String?

	/**
	 * Tags that qualify the calendar item as being member of a certain class.
	 */
	override val tags: Set<CodeStub>

	/**
	 * Codes that identify or qualify this particular calendar item.
	 */
	override val codes: Set<CodeStub>

	/**
	 * Hard delete (unix epoch in ms) timestamp of the object.
	 */
	override val deletionDate: Long?

	/**
	 * The title of the calendar item.
	 */
	public val title: String?

	/**
	 * The id of the calendar item type associated with this item.
	 */
	public val calendarItemTypeId: String?

	/**
	 * The id of the master calendar item if this is a recurring instance.
	 */
	public val masterCalendarItemId: String?

	/**
	 * Whether this calendar item is marked as important.
	 */
	public val important: Boolean?

	/**
	 * Whether this calendar item represents a home visit.
	 */
	public val homeVisit: Boolean?

	/**
	 * A phone number associated with this calendar item.
	 */
	public val phoneNumber: String?

	/**
	 * The id of the place where the appointment takes place.
	 */
	public val placeId: String?

	/**
	 * The address where the appointment takes place.
	 */
	public val address: Address?

	/**
	 * The textual representation of the address.
	 */
	public val addressText: String?

	/**
	 * The start time of the calendar item in YYYYMMDDHHMMSS format.
	 */
	public val startTime: Long?

	/**
	 * The end time of the calendar item in YYYYMMDDHHMMSS format.
	 */
	public val endTime: Long?

	/**
	 * The time of confirmation in YYYYMMDDHHMMSS format.
	 */
	@Deprecated("Ignored by availabilities algorithm, will be replaced by another more descriptive field")
	public val confirmationTime: Long?

	/**
	 * The timestamp of cancellation.
	 */
	@Deprecated("Ignored by availabilities algorithm, will be replaced by another more descriptive field")
	public val cancellationTimestamp: Long?

	/**
	 * An id associated with the confirmation.
	 */
	@Deprecated("Ignored by availabilities algorithm, will be replaced by another more descriptive field")
	public val confirmationId: String?

	/**
	 * The duration of the appointment.
	 */
	@Deprecated("Ignored by availabilities algorithm, use appropriate startTime and endTime")
	public val duration: Long?

	/**
	 * Whether this calendar item spans the entire day.
	 */
	@Deprecated("Ignored by availabilities algorithm, use appropriate startTime and endTime")
	public val allDay: Boolean?

	/**
	 * Additional details about the calendar item.
	 */
	public val details: String?

	/**
	 * Whether this calendar item was migrated from another system.
	 */
	public val wasMigrated: Boolean?

	/**
	 * The id of the agenda linked to this calendar item.
	 */
	public val agendaId: String?

	/**
	 * The resource group of the agenda that will handle this calendar item.
	 */
	public val resourceGroup: CodeStub?

	/**
	 * How this calendar item is considered by the availabilities algorithm.
	 */
	public val availabilitiesAssignmentStrategy: AvailabilitiesAssignmentStrategy?

	/**
	 * The healthcare party id associated with this calendar item. Deprecated: This field is scheduled
	 * for deletion
	 */
	public val hcpId: String?

	/**
	 * An id for linking recurring calendar items.
	 */
	public val recurrenceId: String?

	/**
	 * Tags for the meeting associated with this calendar item.
	 */
	public val meetingTags: Set<CalendarItemTag>

	/**
	 * Custom properties of this calendar item.
	 */
	public val properties: Set<PropertyStub>

	/**
	 * The secret foreign keys, used for secure linking to patients.
	 */
	override val secretForeignKeys: Set<String>

	/**
	 * The encrypted foreign keys.
	 */
	override val cryptedForeignKeys: Map<String, Set<Delegation>>

	/**
	 * The delegations giving access to connected healthcare information.
	 */
	override val delegations: Map<String, Set<Delegation>>

	/**
	 * The encryption keys used to encrypt secured properties, encrypted for separate Crypto Actors.
	 */
	override val encryptionKeys: Map<String, Set<Delegation>>

	/**
	 * The base64-encoded encrypted fields of this calendar item.
	 */
	override val encryptedSelf: Base64String?

	/**
	 * The security metadata of this entity, for access control.
	 */
	override val securityMetadata: SecurityMetadata?

	@Serializable
	public enum class AvailabilitiesAssignmentStrategy(
		internal val dtoSerialName: String,
	) {
		@SerialName("S")
		Strict("S"),

		@SerialName("L")
		Loose("L"),
	}
	// region CalendarItem-CalendarItem

	companion object {
		const val KRAKEN_QUALIFIED_NAME = "org.taktik.icure.entities.CalendarItem"
	}
	// endregion
}

/**
 *
 *  Represents an appointment or event in a calendar. Calendar items are linked to an agenda and can
 * block
 *  availabilities for scheduling purposes.
 */
@Serializable
data class DecryptedCalendarItem(
	/**
	 * The Id of the calendar item. We encourage using either a v4 UUID or a HL7 Id.
	 */
	override val id: String,
	/**
	 * The revision of the calendar item in the database, used for conflict management / optimistic
	 * locking.
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
	 * The id of the User that created this calendar item.
	 */
	override val author: String? = null,
	/**
	 * The id of the data owner that is responsible for this calendar item.
	 */
	override val responsible: String? = null,
	/**
	 * Tags that qualify the calendar item as being member of a certain class.
	 */
	@param:DefaultValue("emptySet()")
	override val tags: Set<CodeStub> = emptySet(),
	/**
	 * Codes that identify or qualify this particular calendar item.
	 */
	@param:DefaultValue("emptySet()")
	override val codes: Set<CodeStub> = emptySet(),
	/**
	 * Hard delete (unix epoch in ms) timestamp of the object.
	 */
	override val deletionDate: Long? = null,
	/**
	 * The title of the calendar item.
	 */
	override val title: String? = null,
	/**
	 * The id of the calendar item type associated with this item.
	 */
	override val calendarItemTypeId: String? = null,
	/**
	 * The id of the master calendar item if this is a recurring instance.
	 */
	override val masterCalendarItemId: String? = null,
	/**
	 * Whether this calendar item is marked as important.
	 */
	override val important: Boolean? = null,
	/**
	 * Whether this calendar item represents a home visit.
	 */
	override val homeVisit: Boolean? = null,
	/**
	 * A phone number associated with this calendar item.
	 */
	override val phoneNumber: String? = null,
	/**
	 * The id of the place where the appointment takes place.
	 */
	override val placeId: String? = null,
	/**
	 * The address where the appointment takes place.
	 */
	override val address: DecryptedAddress? = null,
	/**
	 * The textual representation of the address.
	 */
	override val addressText: String? = null,
	/**
	 * The start time of the calendar item in YYYYMMDDHHMMSS format.
	 */
	override val startTime: Long? = null,
	/**
	 * The end time of the calendar item in YYYYMMDDHHMMSS format.
	 */
	override val endTime: Long? = null,
	/**
	 * The time of confirmation in YYYYMMDDHHMMSS format.
	 */
	@Deprecated("Ignored by availabilities algorithm, will be replaced by another more descriptive field")
	override val confirmationTime: Long? = null,
	/**
	 * The timestamp of cancellation.
	 */
	@Deprecated("Ignored by availabilities algorithm, will be replaced by another more descriptive field")
	override val cancellationTimestamp: Long? = null,
	/**
	 * An id associated with the confirmation.
	 */
	@Deprecated("Ignored by availabilities algorithm, will be replaced by another more descriptive field")
	override val confirmationId: String? = null,
	/**
	 * The duration of the appointment.
	 */
	@Deprecated("Ignored by availabilities algorithm, use appropriate startTime and endTime")
	override val duration: Long? = null,
	/**
	 * Whether this calendar item spans the entire day.
	 */
	@Deprecated("Ignored by availabilities algorithm, use appropriate startTime and endTime")
	override val allDay: Boolean? = null,
	/**
	 * Additional details about the calendar item.
	 */
	override val details: String? = null,
	/**
	 * Whether this calendar item was migrated from another system.
	 */
	override val wasMigrated: Boolean? = null,
	/**
	 * The id of the agenda linked to this calendar item.
	 */
	override val agendaId: String? = null,
	/**
	 * The resource group of the agenda that will handle this calendar item.
	 */
	override val resourceGroup: CodeStub? = null,
	/**
	 * How this calendar item is considered by the availabilities algorithm.
	 */
	override val availabilitiesAssignmentStrategy: CalendarItem.AvailabilitiesAssignmentStrategy? =
		null,
	/**
	 * The healthcare party id associated with this calendar item. Deprecated: This field is scheduled
	 * for deletion
	 */
	override val hcpId: String? = null,
	/**
	 * An id for linking recurring calendar items.
	 */
	override val recurrenceId: String? = null,
	/**
	 * Tags for the meeting associated with this calendar item.
	 */
	@param:DefaultValue("emptySet()")
	override val meetingTags: Set<DecryptedCalendarItemTag> = emptySet(),
	/**
	 * Custom properties of this calendar item.
	 */
	@param:DefaultValue("emptySet()")
	override val properties: Set<DecryptedPropertyStub> = emptySet(),
	/**
	 * The secret foreign keys, used for secure linking to patients.
	 */
	@param:DefaultValue("emptySet()")
	override val secretForeignKeys: Set<String> = emptySet(),
	/**
	 * The encrypted foreign keys.
	 */
	@param:DefaultValue("emptyMap()")
	override val cryptedForeignKeys: Map<String, Set<Delegation>> = emptyMap(),
	/**
	 * The delegations giving access to connected healthcare information.
	 */
	@param:DefaultValue("emptyMap()")
	override val delegations: Map<String, Set<Delegation>> = emptyMap(),
	/**
	 * The encryption keys used to encrypt secured properties, encrypted for separate Crypto Actors.
	 */
	@param:DefaultValue("emptyMap()")
	override val encryptionKeys: Map<String, Set<Delegation>> = emptyMap(),
	/**
	 * The base64-encoded encrypted fields of this calendar item.
	 */
	override val encryptedSelf: Base64String? = null,
	/**
	 * The security metadata of this entity, for access control.
	 */
	override val securityMetadata: SecurityMetadata? = null,
) : CalendarItem {
	// region CalendarItem-DecryptedCalendarItem
override fun copyWithSecurityMetadata(securityMetadata: SecurityMetadata, secretForeignKeys: Set<String>): DecryptedCalendarItem =
		copy(securityMetadata = securityMetadata, secretForeignKeys = secretForeignKeys)

	/**
	 * Resets the following delegation objects from the
	 * [CalendarItem] instance: [CalendarItem.cryptedForeignKeys], [CalendarItem.secretForeignKeys].
	 *
	 * The [CalendarItem.delegations] & [CalendarItem.encryptionKeys] objects are not removed because
	 * in the case the [CalendarItem] is saved in the DB & then encrypted,
	 * if later we remove the patient from it, it'd reset the delegations
	 * and encryptionKeys thus making impossible to further access it.
	 */
	fun resetCalendarDelegationObjects(): DecryptedCalendarItem = copy(
		cryptedForeignKeys = emptyMap(),
		secretForeignKeys = emptySet()
	)
	// endregion
}

/**
 *
 *  Represents an appointment or event in a calendar. Calendar items are linked to an agenda and can
 * block
 *  availabilities for scheduling purposes.
 */
@Serializable
data class EncryptedCalendarItem(
	/**
	 * The Id of the calendar item. We encourage using either a v4 UUID or a HL7 Id.
	 */
	override val id: String,
	/**
	 * The revision of the calendar item in the database, used for conflict management / optimistic
	 * locking.
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
	 * The id of the User that created this calendar item.
	 */
	override val author: String? = null,
	/**
	 * The id of the data owner that is responsible for this calendar item.
	 */
	override val responsible: String? = null,
	/**
	 * Tags that qualify the calendar item as being member of a certain class.
	 */
	@param:DefaultValue("emptySet()")
	override val tags: Set<CodeStub> = emptySet(),
	/**
	 * Codes that identify or qualify this particular calendar item.
	 */
	@param:DefaultValue("emptySet()")
	override val codes: Set<CodeStub> = emptySet(),
	/**
	 * Hard delete (unix epoch in ms) timestamp of the object.
	 */
	override val deletionDate: Long? = null,
	/**
	 * The title of the calendar item.
	 */
	override val title: String? = null,
	/**
	 * The id of the calendar item type associated with this item.
	 */
	override val calendarItemTypeId: String? = null,
	/**
	 * The id of the master calendar item if this is a recurring instance.
	 */
	override val masterCalendarItemId: String? = null,
	/**
	 * Whether this calendar item is marked as important.
	 */
	override val important: Boolean? = null,
	/**
	 * Whether this calendar item represents a home visit.
	 */
	override val homeVisit: Boolean? = null,
	/**
	 * A phone number associated with this calendar item.
	 */
	override val phoneNumber: String? = null,
	/**
	 * The id of the place where the appointment takes place.
	 */
	override val placeId: String? = null,
	/**
	 * The address where the appointment takes place.
	 */
	override val address: EncryptedAddress? = null,
	/**
	 * The textual representation of the address.
	 */
	override val addressText: String? = null,
	/**
	 * The start time of the calendar item in YYYYMMDDHHMMSS format.
	 */
	override val startTime: Long? = null,
	/**
	 * The end time of the calendar item in YYYYMMDDHHMMSS format.
	 */
	override val endTime: Long? = null,
	/**
	 * The time of confirmation in YYYYMMDDHHMMSS format.
	 */
	@Deprecated("Ignored by availabilities algorithm, will be replaced by another more descriptive field")
	override val confirmationTime: Long? = null,
	/**
	 * The timestamp of cancellation.
	 */
	@Deprecated("Ignored by availabilities algorithm, will be replaced by another more descriptive field")
	override val cancellationTimestamp: Long? = null,
	/**
	 * An id associated with the confirmation.
	 */
	@Deprecated("Ignored by availabilities algorithm, will be replaced by another more descriptive field")
	override val confirmationId: String? = null,
	/**
	 * The duration of the appointment.
	 */
	@Deprecated("Ignored by availabilities algorithm, use appropriate startTime and endTime")
	override val duration: Long? = null,
	/**
	 * Whether this calendar item spans the entire day.
	 */
	@Deprecated("Ignored by availabilities algorithm, use appropriate startTime and endTime")
	override val allDay: Boolean? = null,
	/**
	 * Additional details about the calendar item.
	 */
	override val details: String? = null,
	/**
	 * Whether this calendar item was migrated from another system.
	 */
	override val wasMigrated: Boolean? = null,
	/**
	 * The id of the agenda linked to this calendar item.
	 */
	override val agendaId: String? = null,
	/**
	 * The resource group of the agenda that will handle this calendar item.
	 */
	override val resourceGroup: CodeStub? = null,
	/**
	 * How this calendar item is considered by the availabilities algorithm.
	 */
	override val availabilitiesAssignmentStrategy: CalendarItem.AvailabilitiesAssignmentStrategy? =
		null,
	/**
	 * The healthcare party id associated with this calendar item. Deprecated: This field is scheduled
	 * for deletion
	 */
	override val hcpId: String? = null,
	/**
	 * An id for linking recurring calendar items.
	 */
	override val recurrenceId: String? = null,
	/**
	 * Tags for the meeting associated with this calendar item.
	 */
	@param:DefaultValue("emptySet()")
	override val meetingTags: Set<EncryptedCalendarItemTag> = emptySet(),
	/**
	 * Custom properties of this calendar item.
	 */
	@param:DefaultValue("emptySet()")
	override val properties: Set<EncryptedPropertyStub> = emptySet(),
	/**
	 * The secret foreign keys, used for secure linking to patients.
	 */
	@param:DefaultValue("emptySet()")
	override val secretForeignKeys: Set<String> = emptySet(),
	/**
	 * The encrypted foreign keys.
	 */
	@param:DefaultValue("emptyMap()")
	override val cryptedForeignKeys: Map<String, Set<Delegation>> = emptyMap(),
	/**
	 * The delegations giving access to connected healthcare information.
	 */
	@param:DefaultValue("emptyMap()")
	override val delegations: Map<String, Set<Delegation>> = emptyMap(),
	/**
	 * The encryption keys used to encrypt secured properties, encrypted for separate Crypto Actors.
	 */
	@param:DefaultValue("emptyMap()")
	override val encryptionKeys: Map<String, Set<Delegation>> = emptyMap(),
	/**
	 * The base64-encoded encrypted fields of this calendar item.
	 */
	override val encryptedSelf: Base64String? = null,
	/**
	 * The security metadata of this entity, for access control.
	 */
	override val securityMetadata: SecurityMetadata? = null,
) : CalendarItem {
	// region CalendarItem-EncryptedCalendarItem
override fun copyWithSecurityMetadata(securityMetadata: SecurityMetadata, secretForeignKeys: Set<String>): EncryptedCalendarItem =
		copy(securityMetadata = securityMetadata, secretForeignKeys = secretForeignKeys)

	/**
	 * Resets the following delegation objects from the
	 * [CalendarItem] instance: [CalendarItem.cryptedForeignKeys], [CalendarItem.secretForeignKeys].
	 *
	 * The [CalendarItem.delegations] & [CalendarItem.encryptionKeys] objects are not removed because
	 * in the case the [CalendarItem] is saved in the DB & then encrypted,
	 * if later we remove the patient from it, it'd reset the delegations
	 * and encryptionKeys thus making impossible to further access it.
	 */
	fun resetCalendarDelegationObjects(): EncryptedCalendarItem = copy(
		cryptedForeignKeys = emptyMap(),
		secretForeignKeys = emptySet()
	)
	// endregion
}
