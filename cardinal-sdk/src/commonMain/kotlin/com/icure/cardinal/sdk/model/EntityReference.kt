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
public data class EntityReference(
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
) : StoredDocument
