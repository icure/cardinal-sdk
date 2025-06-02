package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.model.base.CodeStub
import com.icure.cardinal.sdk.model.base.ICureDocument
import com.icure.cardinal.sdk.model.base.StoredDocument
import com.icure.cardinal.sdk.model.embed.EmbeddedTimeTable
import com.icure.cardinal.sdk.model.embed.Right
import com.icure.cardinal.sdk.model.embed.UserAccessLevel
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Deprecated
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.Set

@Serializable
public data class Agenda(
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
	public val name: String? = null,
	public val userId: String? = null,
	@DefaultValue("emptyList()")
	@Deprecated("Use `userRights` instead")
	public val rights: List<Right> = emptyList(),
	@DefaultValue("emptyMap()")
	public val userRights: Map<String, UserAccessLevel> = emptyMap(),
	@DefaultValue("emptySet()")
	public val properties: Set<DecryptedPropertyStub> = emptySet(),
	@DefaultValue("emptyList()")
	public val timeTables: List<EmbeddedTimeTable> = emptyList(),
) : StoredDocument, ICureDocument<String>
