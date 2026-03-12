// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.model.specializations.Base64String
import kotlinx.serialization.Serializable
import kotlin.Long
import kotlin.String

/**
 * Represents a tag associated with a calendar item, carrying metadata about who tagged it and when.
 * /
 */

sealed interface CalendarItemTag : Encryptable {
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
	// region CalendarItemTag-CalendarItemTag

	// endregion
}

/**
 * Represents a tag associated with a calendar item, carrying metadata about who tagged it and when.
 * /
 */
@Serializable
data class DecryptedCalendarItemTag(
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
) : CalendarItemTag {
	// region CalendarItemTag-DecryptedCalendarItemTag

	// endregion
}

/**
 * Represents a tag associated with a calendar item, carrying metadata about who tagged it and when.
 * /
 */
@Serializable
data class EncryptedCalendarItemTag(
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
) : CalendarItemTag {
	// region CalendarItemTag-EncryptedCalendarItemTag

	// endregion
}
