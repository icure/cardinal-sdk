// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.model.base.StoredDocument
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement
import kotlin.Boolean
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Set

/**
 * Represents a reusable template for creating entities. Entity templates store a JSON-based entity
 * definition
 * that can be used as a starting point for creating new entities of a given type.
 * /
 */
@Serializable
data class EntityTemplate(
	/**
	 * The Id of the entity template.
	 */
	override val id: String,
	/**
	 * The revision of the entity template in the database, used for conflict management / optimistic
	 * locking.
	 */
	override val rev: String? = null,
	/**
	 * Hard delete (unix epoch in ms) timestamp of the object.
	 */
	override val deletionDate: Long? = null,
	/**
	 * The id of the user who owns this entity template.
	 */
	public val userId: String? = null,
	/**
	 * A description of the entity template.
	 */
	public val descr: String? = null,
	/**
	 * A set of keywords for searching and categorizing the template.
	 */
	public val keywords: Set<String>? = null,
	/**
	 * The type of entity this template is for.
	 */
	public val entityType: String? = null,
	/**
	 * The sub-type of entity this template is for.
	 */
	public val subType: String? = null,
	/**
	 * Whether this is the default template for its entity type and sub-type.
	 */
	public val defaultTemplate: Boolean? = null,
	/**
	 * The JSON representation of the template entity content.
	 */
	@param:DefaultValue("emptyList()")
	public val entity: List<JsonElement> = emptyList(),
) : StoredDocument {
	// region EntityTemplate-EntityTemplate

	// endregion
}
