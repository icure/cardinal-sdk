// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.model.base.Identifiable
import com.icure.cardinal.sdk.model.base.Named
import com.icure.cardinal.sdk.model.specializations.Base64String
import kotlinx.serialization.Serializable
import kotlin.Long
import kotlin.String

/**
 * Represents a medical episode, which is a time-bounded grouping of healthcare elements related to
 * a specific concern.
 * /
 */

sealed interface Episode : Encryptable, Identifiable<String>, Named {
	/**
	 * The unique identifier of this episode.
	 */
	override val id: String

	/**
	 * The name of the episode.
	 */
	override val name: String?

	/**
	 * A comment associated with the episode.
	 */
	public val comment: String?

	/**
	 * The start date in YYYYMMDDHHMMSS format. Unknown components are set to 00.
	 */
	public val startDate: Long?

	/**
	 * The end date in YYYYMMDDHHMMSS format. Unknown components are set to 00.
	 */
	public val endDate: Long?

	/**
	 * The base64-encoded encrypted content of this episode.
	 */
	override val encryptedSelf: Base64String?
	// region Episode-Episode

	// endregion
}

/**
 * Represents a medical episode, which is a time-bounded grouping of healthcare elements related to
 * a specific concern.
 * /
 */
@Serializable
data class DecryptedEpisode(
	/**
	 * The unique identifier of this episode.
	 */
	override val id: String,
	/**
	 * The name of the episode.
	 */
	override val name: String? = null,
	/**
	 * A comment associated with the episode.
	 */
	override val comment: String? = null,
	/**
	 * The start date in YYYYMMDDHHMMSS format. Unknown components are set to 00.
	 */
	override val startDate: Long? = null,
	/**
	 * The end date in YYYYMMDDHHMMSS format. Unknown components are set to 00.
	 */
	override val endDate: Long? = null,
	/**
	 * The base64-encoded encrypted content of this episode.
	 */
	override val encryptedSelf: Base64String? = null,
) : Episode {
	// region Episode-DecryptedEpisode

	// endregion
}

/**
 * Represents a medical episode, which is a time-bounded grouping of healthcare elements related to
 * a specific concern.
 * /
 */
@Serializable
data class EncryptedEpisode(
	/**
	 * The unique identifier of this episode.
	 */
	override val id: String,
	/**
	 * The name of the episode.
	 */
	override val name: String? = null,
	/**
	 * A comment associated with the episode.
	 */
	override val comment: String? = null,
	/**
	 * The start date in YYYYMMDDHHMMSS format. Unknown components are set to 00.
	 */
	override val startDate: Long? = null,
	/**
	 * The end date in YYYYMMDDHHMMSS format. Unknown components are set to 00.
	 */
	override val endDate: Long? = null,
	/**
	 * The base64-encoded encrypted content of this episode.
	 */
	override val encryptedSelf: Base64String? = null,
) : Episode {
	// region Episode-EncryptedEpisode

	// endregion
}
