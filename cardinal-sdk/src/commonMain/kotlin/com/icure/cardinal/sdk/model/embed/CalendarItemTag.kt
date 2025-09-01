package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.model.specializations.Base64String
import kotlinx.serialization.Serializable
import kotlin.Long
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
sealed interface CalendarItemTag : Encryptable {
	public val code: String?

	public val date: Long?

	public val userId: String?

	public val userName: String?

	override val encryptedSelf: Base64String?
	// region CalendarItemTag-CalendarItemTag

	// endregion
}

@Serializable
data class DecryptedCalendarItemTag(
	override val code: String? = null,
	override val date: Long? = null,
	override val userId: String? = null,
	override val userName: String? = null,
	override val encryptedSelf: Base64String? = null,
) : CalendarItemTag {
	// region CalendarItemTag-DecryptedCalendarItemTag

	// endregion
}

@Serializable
data class EncryptedCalendarItemTag(
	override val code: String? = null,
	override val date: Long? = null,
	override val userId: String? = null,
	override val userName: String? = null,
	override val encryptedSelf: Base64String? = null,
) : CalendarItemTag {
	// region CalendarItemTag-EncryptedCalendarItemTag

	// endregion
}
