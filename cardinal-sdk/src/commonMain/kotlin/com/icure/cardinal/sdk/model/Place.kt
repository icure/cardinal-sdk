// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.model.base.Named
import com.icure.cardinal.sdk.model.base.StoredDocument
import com.icure.cardinal.sdk.model.embed.DecryptedAddress
import kotlinx.serialization.Serializable
import kotlin.Long
import kotlin.String

/**
 * DTO representing a physical place or location, such as a clinic or office.
 * /
 */
@Serializable
data class Place(
	/**
	 * The unique identifier of the place.
	 */
	override val id: String,
	/**
	 * The revision identifier for optimistic locking.
	 */
	override val rev: String? = null,
	/**
	 * The soft-delete timestamp in epoch milliseconds.
	 */
	override val deletionDate: Long? = null,
	/**
	 * The display name of the place.
	 */
	override val name: String? = null,
	/**
	 * The address of the place.
	 */
	public val address: DecryptedAddress? = null,
) : StoredDocument, Named {
	// region Place-Place

	// endregion
}
