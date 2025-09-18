package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.model.base.StoredDocument
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.Set

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class Role(
	override val id: String,
	override val rev: String? = null,
	override val deletionDate: Long? = null,
	public val name: String? = null,
	public val inheritableUpTo: Int? = null,
	@DefaultValue("emptySet()")
	public val permissions: Set<String> = emptySet(),
) : StoredDocument {
	// region Role-Role

	// endregion
}
