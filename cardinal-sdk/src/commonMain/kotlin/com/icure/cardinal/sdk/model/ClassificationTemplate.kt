package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.model.base.CodeStub
import com.icure.cardinal.sdk.model.base.ICureDocument
import com.icure.cardinal.sdk.model.base.StoredDocument
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Long
import kotlin.String
import kotlin.collections.Set

@Serializable
public data class ClassificationTemplate(
	override val id: String,
	override val rev: String? = null,
	override val created: Long? = null,
	override val modified: Long? = null,
	override val author: String? = null,
	override val responsible: String? = null,
	override val medicalLocationId: String? = null,
	@DefaultValue("emptySet()")
	override val tags: Set<CodeStub> = emptySet(),
	@DefaultValue("emptySet()")
	override val codes: Set<CodeStub> = emptySet(),
	override val endOfLife: Long? = null,
	override val deletionDate: Long? = null,
	public val parentId: String? = null,
	public val label: String,
) : StoredDocument, ICureDocument<String>
