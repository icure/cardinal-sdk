package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.model.base.StoredDocument
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Long
import kotlin.String
import kotlin.collections.Set

@Serializable
public data class Role(
	override val id: String,
	override val rev: String? = null,
	override val deletionDate: Long? = null,
	public val name: String? = null,
	@DefaultValue("emptySet()")
	public val permissions: Set<String> = emptySet(),
) : StoredDocument
