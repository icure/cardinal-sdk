// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.model.base.StoredDocument
import kotlinx.serialization.Serializable
import kotlin.Long
import kotlin.String

/**
 * Represents a reference to another entity by its document id. Entity references provide a
 * lightweight
 * way to create links between entities.
 * /
 */
@Serializable
data class EntityReference(
	/**
	 * The Id of the entity reference.
	 */
	override val id: String,
	/**
	 * The revision of the entity reference in the database, used for conflict management / optimistic
	 * locking.
	 */
	override val rev: String? = null,
	/**
	 * Hard delete (unix epoch in ms) timestamp of the object.
	 */
	override val deletionDate: Long? = null,
	/**
	 * The id of the referenced document.
	 */
	public val docId: String? = null,
) : StoredDocument {
	// region EntityReference-EntityReference

	// endregion
}
