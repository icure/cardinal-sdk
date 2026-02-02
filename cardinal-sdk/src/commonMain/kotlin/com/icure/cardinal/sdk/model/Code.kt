package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.model.base.CodeIdentification
import com.icure.cardinal.sdk.model.base.StoredDocument
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.Set

@Serializable
public data class Code(
	override val id: String,
	override val rev: String? = null,
	override val deletionDate: Long? = null,
	override val context: String? = null,
	override val type: String? = null,
	override val code: String? = null,
	override val version: String? = null,
	override val label: Map<String, String>? = null,
	public val author: String? = null,
	@param:DefaultValue("emptySet()")
	public val regions: Set<String> = emptySet(),
	@param:DefaultValue("emptySet()")
	public val links: Set<String> = emptySet(),
	@param:DefaultValue("emptyMap()")
	public val qualifiedLinks: Map<String, List<String>> = emptyMap(),
	@param:DefaultValue("emptyMap()")
	public val searchTerms: Map<String, Set<String>> = emptyMap(),
	@param:DefaultValue("false")
	public val disabled: Boolean = false,
) : StoredDocument, CodeIdentification<String>
