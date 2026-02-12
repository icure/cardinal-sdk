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
import kotlin.Long
import kotlin.String
import kotlin.collections.Map
import kotlin.collections.Set

public sealed interface CalendarItem :
	StoredDocument,
	ICureDocument<String>,
	HasEncryptionMetadata,
	Encryptable {
	override val id: String

	override val rev: String?

	override val created: Long?

	override val modified: Long?

	override val author: String?

	override val responsible: String?

	override val tags: Set<CodeStub>

	override val codes: Set<CodeStub>

	override val deletionDate: Long?

	public val title: String?

	public val calendarItemTypeId: String?

	public val masterCalendarItemId: String?

	public val important: Boolean?

	public val homeVisit: Boolean?

	public val placeId: String?

	public val address: Address?

	public val addressText: String?

	public val startTime: Long?

	public val endTime: Long?

	public val details: String?

	public val wasMigrated: Boolean?

	public val agendaId: String?

	public val resourceGroup: CodeStub?

	public val availabilitiesAssignmentStrategy: AvailabilitiesAssignmentStrategy?

	public val recurrenceId: String?

	public val meetingTags: Set<CalendarItemTag>

	override val secretForeignKeys: Set<String>

	override val cryptedForeignKeys: Map<String, Set<Delegation>>

	override val delegations: Map<String, Set<Delegation>>

	override val encryptionKeys: Map<String, Set<Delegation>>

	override val encryptedSelf: Base64String?

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
}

@Serializable
public data class DecryptedCalendarItem(
	override val id: String,
	override val rev: String? = null,
	override val created: Long? = null,
	override val modified: Long? = null,
	override val author: String? = null,
	override val responsible: String? = null,
	@param:DefaultValue("emptySet()")
	override val tags: Set<CodeStub> = emptySet(),
	@param:DefaultValue("emptySet()")
	override val codes: Set<CodeStub> = emptySet(),
	override val deletionDate: Long? = null,
	override val title: String? = null,
	override val calendarItemTypeId: String? = null,
	override val masterCalendarItemId: String? = null,
	override val important: Boolean? = null,
	override val homeVisit: Boolean? = null,
	override val placeId: String? = null,
	override val address: DecryptedAddress? = null,
	override val addressText: String? = null,
	override val startTime: Long? = null,
	override val endTime: Long? = null,
	override val details: String? = null,
	override val wasMigrated: Boolean? = null,
	override val agendaId: String? = null,
	override val resourceGroup: CodeStub? = null,
	override val availabilitiesAssignmentStrategy: CalendarItem.AvailabilitiesAssignmentStrategy? =
		null,
	override val recurrenceId: String? = null,
	@param:DefaultValue("emptySet()")
	override val meetingTags: Set<DecryptedCalendarItemTag> = emptySet(),
	@param:DefaultValue("emptySet()")
	override val secretForeignKeys: Set<String> = emptySet(),
	@param:DefaultValue("emptyMap()")
	override val cryptedForeignKeys: Map<String, Set<Delegation>> = emptyMap(),
	@param:DefaultValue("emptyMap()")
	override val delegations: Map<String, Set<Delegation>> = emptyMap(),
	@param:DefaultValue("emptyMap()")
	override val encryptionKeys: Map<String, Set<Delegation>> = emptyMap(),
	override val encryptedSelf: Base64String? = null,
	override val securityMetadata: SecurityMetadata? = null,
) : CalendarItem

@Serializable
public data class EncryptedCalendarItem(
	override val id: String,
	override val rev: String? = null,
	override val created: Long? = null,
	override val modified: Long? = null,
	override val author: String? = null,
	override val responsible: String? = null,
	@param:DefaultValue("emptySet()")
	override val tags: Set<CodeStub> = emptySet(),
	@param:DefaultValue("emptySet()")
	override val codes: Set<CodeStub> = emptySet(),
	override val deletionDate: Long? = null,
	override val title: String? = null,
	override val calendarItemTypeId: String? = null,
	override val masterCalendarItemId: String? = null,
	override val important: Boolean? = null,
	override val homeVisit: Boolean? = null,
	override val placeId: String? = null,
	override val address: EncryptedAddress? = null,
	override val addressText: String? = null,
	override val startTime: Long? = null,
	override val endTime: Long? = null,
	override val details: String? = null,
	override val wasMigrated: Boolean? = null,
	override val agendaId: String? = null,
	override val resourceGroup: CodeStub? = null,
	override val availabilitiesAssignmentStrategy: CalendarItem.AvailabilitiesAssignmentStrategy? =
		null,
	override val recurrenceId: String? = null,
	@param:DefaultValue("emptySet()")
	override val meetingTags: Set<EncryptedCalendarItemTag> = emptySet(),
	@param:DefaultValue("emptySet()")
	override val secretForeignKeys: Set<String> = emptySet(),
	@param:DefaultValue("emptyMap()")
	override val cryptedForeignKeys: Map<String, Set<Delegation>> = emptyMap(),
	@param:DefaultValue("emptyMap()")
	override val delegations: Map<String, Set<Delegation>> = emptyMap(),
	@param:DefaultValue("emptyMap()")
	override val encryptionKeys: Map<String, Set<Delegation>> = emptyMap(),
	override val encryptedSelf: Base64String? = null,
	override val securityMetadata: SecurityMetadata? = null,
) : CalendarItem
