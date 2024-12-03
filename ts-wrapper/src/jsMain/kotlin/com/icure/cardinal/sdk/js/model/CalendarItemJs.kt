// auto-generated file
@file:JsQualifier("model")

package com.icure.cardinal.sdk.js.model

import com.icure.cardinal.sdk.js.model.base.CodeStubJs
import com.icure.cardinal.sdk.js.model.base.HasEncryptionMetadataJs
import com.icure.cardinal.sdk.js.model.base.ICureDocumentJs
import com.icure.cardinal.sdk.js.model.base.StoredDocumentJs
import com.icure.cardinal.sdk.js.model.embed.AddressJs
import com.icure.cardinal.sdk.js.model.embed.CalendarItemTagJs
import com.icure.cardinal.sdk.js.model.embed.DecryptedAddressJs
import com.icure.cardinal.sdk.js.model.embed.DecryptedCalendarItemTagJs
import com.icure.cardinal.sdk.js.model.embed.DelegationJs
import com.icure.cardinal.sdk.js.model.embed.EncryptableJs
import com.icure.cardinal.sdk.js.model.embed.EncryptedAddressJs
import com.icure.cardinal.sdk.js.model.embed.EncryptedCalendarItemTagJs
import com.icure.cardinal.sdk.js.model.embed.FlowItemJs
import com.icure.cardinal.sdk.js.model.embed.SecurityMetadataJs
import com.icure.cardinal.sdk.js.utils.Record
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("CalendarItem")
public sealed external interface CalendarItemJs : StoredDocumentJs, ICureDocumentJs<String>,
		HasEncryptionMetadataJs, EncryptableJs {
	public val title: String?

	public val calendarItemTypeId: String?

	public val masterCalendarItemId: String?

	public val patientId: String?

	public val important: Boolean?

	public val homeVisit: Boolean?

	public val phoneNumber: String?

	public val placeId: String?

	public val address: AddressJs?

	public val addressText: String?

	public val startTime: Double?

	public val endTime: Double?

	public val confirmationTime: Double?

	public val cancellationTimestamp: Double?

	public val confirmationId: String?

	public val duration: Double?

	public val allDay: Boolean?

	public val details: String?

	public val wasMigrated: Boolean?

	public val agendaId: String?

	public val hcpId: String?

	public val recurrenceId: String?

	public val meetingTags: Array<out CalendarItemTagJs>

	public val flowItem: FlowItemJs?

	public val isEncrypted: Boolean
}

@JsName("DecryptedCalendarItem")
public external class DecryptedCalendarItemJs(
	partial: dynamic,
) : CalendarItemJs {
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

	override val title: String?

	override val calendarItemTypeId: String?

	override val masterCalendarItemId: String?

	override val patientId: String?

	override val important: Boolean?

	override val homeVisit: Boolean?

	override val phoneNumber: String?

	override val placeId: String?

	override val address: DecryptedAddressJs?

	override val addressText: String?

	override val startTime: Double?

	override val endTime: Double?

	override val confirmationTime: Double?

	override val cancellationTimestamp: Double?

	override val confirmationId: String?

	override val duration: Double?

	override val allDay: Boolean?

	override val details: String?

	override val wasMigrated: Boolean?

	override val agendaId: String?

	override val hcpId: String?

	override val recurrenceId: String?

	override val meetingTags: Array<DecryptedCalendarItemTagJs>

	override val flowItem: FlowItemJs?

	override val secretForeignKeys: Array<String>

	override val cryptedForeignKeys: Record<String, Array<DelegationJs>>

	override val delegations: Record<String, Array<DelegationJs>>

	override val encryptionKeys: Record<String, Array<DelegationJs>>

	override val encryptedSelf: String?

	override val securityMetadata: SecurityMetadataJs?

	override val isEncrypted: Boolean
}

@JsName("EncryptedCalendarItem")
public external class EncryptedCalendarItemJs(
	partial: dynamic,
) : CalendarItemJs {
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

	override val title: String?

	override val calendarItemTypeId: String?

	override val masterCalendarItemId: String?

	override val patientId: String?

	override val important: Boolean?

	override val homeVisit: Boolean?

	override val phoneNumber: String?

	override val placeId: String?

	override val address: EncryptedAddressJs?

	override val addressText: String?

	override val startTime: Double?

	override val endTime: Double?

	override val confirmationTime: Double?

	override val cancellationTimestamp: Double?

	override val confirmationId: String?

	override val duration: Double?

	override val allDay: Boolean?

	override val details: String?

	override val wasMigrated: Boolean?

	override val agendaId: String?

	override val hcpId: String?

	override val recurrenceId: String?

	override val meetingTags: Array<EncryptedCalendarItemTagJs>

	override val flowItem: FlowItemJs?

	override val secretForeignKeys: Array<String>

	override val cryptedForeignKeys: Record<String, Array<DelegationJs>>

	override val delegations: Record<String, Array<DelegationJs>>

	override val encryptionKeys: Record<String, Array<DelegationJs>>

	override val encryptedSelf: String?

	override val securityMetadata: SecurityMetadataJs?

	override val isEncrypted: Boolean
}
