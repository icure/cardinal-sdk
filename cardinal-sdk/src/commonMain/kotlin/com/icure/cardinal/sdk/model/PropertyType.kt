package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.model.base.StoredDocument
import com.icure.cardinal.sdk.model.constants.PropertyTypeScope
import com.icure.cardinal.sdk.model.embed.TypedValuesType
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Long
import kotlin.String

/**
 * DTO representing the definition of a property type, including its value type, scope, and
 * uniqueness constraints.
 * /
 */
@Serializable
public data class PropertyType(
	/**
	 * The unique identifier of the property type.
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
	 * The human-readable identifier of this property type.
	 */
	public val identifier: String,
	/**
	 * The value type of this property type.
	 */
	public val type: TypedValuesType? = null,
	/**
	 * The scope in which this property type is applicable.
	 */
	public val scope: PropertyTypeScope? = null,
	/**
	 * Whether values of this property type must be unique.
	 */
	@param:DefaultValue("false")
	public val unique: Boolean = false,
	/**
	 * The identifier of the editor component used to edit this property type.
	 */
	public val editor: String? = null,
	/**
	 * Whether this property type supports localized values.
	 */
	@param:DefaultValue("false")
	public val localized: Boolean = false,
) : StoredDocument
