package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.model.specializations.Base64String
import kotlinx.serialization.Serializable
import kotlin.Long
import kotlin.String

/**
 * Represents a tag associated with a calendar item, carrying metadata about who tagged it and when.
 * /
 */
public sealed interface CalendarItemTag : Encryptable {
	/**
	 * The code identifying this tag.
	 */
	public val code: String?

	/**
	 * The timestamp (unix epoch in ms) when the tag was applied.
	 */
	public val date: Long?

	/**
	 * The identifier of the user who applied the tag.
	 */
	public val userId: String?

	/**
	 * The display name of the user who applied the tag.
	 */
	public val userName: String?

	/**
	 * The base64-encoded encrypted content of this tag.
	 */
	override val encryptedSelf: Base64String?
}

/**
 * Represents a tag associated with a calendar item, carrying metadata about who tagged it and when.
 * /
 */
@Serializable
public data class DecryptedCalendarItemTag(
	/**
	 * The code identifying this tag.
	 */
	override val code: String? = null,
	/**
	 * The timestamp (unix epoch in ms) when the tag was applied.
	 */
	override val date: Long? = null,
	/**
	 * The identifier of the user who applied the tag.
	 */
	override val userId: String? = null,
	/**
	 * The display name of the user who applied the tag.
	 */
	override val userName: String? = null,
	/**
	 * The base64-encoded encrypted content of this tag.
	 */
	override val encryptedSelf: Base64String? = null,
) : CalendarItemTag

/**
 * Represents a tag associated with a calendar item, carrying metadata about who tagged it and when.
 * /
 */
@Serializable
public data class EncryptedCalendarItemTag(
	/**
	 * The code identifying this tag.
	 */
	override val code: String? = null,
	/**
	 * The timestamp (unix epoch in ms) when the tag was applied.
	 */
	override val date: Long? = null,
	/**
	 * The identifier of the user who applied the tag.
	 */
	override val userId: String? = null,
	/**
	 * The display name of the user who applied the tag.
	 */
	override val userName: String? = null,
	/**
	 * The base64-encoded encrypted content of this tag.
	 */
	override val encryptedSelf: Base64String? = null,
) : CalendarItemTag
