package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.model.base.StoredDocument
import com.icure.cardinal.sdk.model.constants.PropertyTypeScope
import com.icure.cardinal.sdk.model.embed.TypedValuesType
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Long
import kotlin.String

@Serializable
public data class PropertyType(
	override val id: String,
	override val rev: String? = null,
	override val deletionDate: Long? = null,
	public val identifier: String,
	public val type: TypedValuesType? = null,
	public val scope: PropertyTypeScope? = null,
	@DefaultValue("false")
	public val unique: Boolean = false,
	public val editor: String? = null,
	@DefaultValue("false")
	public val localized: Boolean = false,
) : StoredDocument
