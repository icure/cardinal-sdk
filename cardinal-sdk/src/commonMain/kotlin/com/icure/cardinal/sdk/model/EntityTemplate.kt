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

@Serializable
public data class EntityTemplate(
	override val id: String,
	override val rev: String? = null,
	override val deletionDate: Long? = null,
	public val userId: String? = null,
	public val descr: String? = null,
	public val keywords: Set<String>? = null,
	public val entityType: String? = null,
	public val subType: String? = null,
	public val defaultTemplate: Boolean? = null,
	@DefaultValue("emptyList()")
	public val entity: List<JsonElement> = emptyList(),
) : StoredDocument
