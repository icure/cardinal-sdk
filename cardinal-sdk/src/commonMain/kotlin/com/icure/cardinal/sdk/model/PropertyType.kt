package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.model.base.StoredDocument
import com.icure.cardinal.sdk.model.constants.PropertyTypeScope
import com.icure.cardinal.sdk.model.embed.TypedValuesType
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Long
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class PropertyType(
	override val id: String,
	override val rev: String? = null,
	override val deletionDate: Long? = null,
	public val identifier: String,
	public val type: TypedValuesType? = null,
	public val scope: PropertyTypeScope? = null,
	@param:DefaultValue("false")
	public val unique: Boolean = false,
	public val editor: String? = null,
	@param:DefaultValue("false")
	public val localized: Boolean = false,
) : StoredDocument {
	// region PropertyType-PropertyType

	// endregion
}
