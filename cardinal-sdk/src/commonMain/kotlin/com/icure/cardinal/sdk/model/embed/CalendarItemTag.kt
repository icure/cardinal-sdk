package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.model.specializations.Base64String
import kotlinx.serialization.Serializable
import kotlin.Long
import kotlin.String

public sealed interface CalendarItemTag : Encryptable {
	public val code: String?

	public val date: Long?

	public val userId: String?

	public val userName: String?

	override val encryptedSelf: Base64String?
}

@Serializable
public data class DecryptedCalendarItemTag(
	override val code: String? = null,
	override val date: Long? = null,
	override val userId: String? = null,
	override val userName: String? = null,
	override val encryptedSelf: Base64String?,
) : CalendarItemTag

@Serializable
public data class EncryptedCalendarItemTag(
	override val code: String? = null,
	override val date: Long? = null,
	override val userId: String? = null,
	override val userName: String? = null,
	override val encryptedSelf: Base64String?,
) : CalendarItemTag
