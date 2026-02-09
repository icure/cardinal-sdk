package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.model.base.CodeStub
import com.icure.cardinal.sdk.model.base.HasEndOfLife
import com.icure.cardinal.sdk.model.base.ICureDocument
import com.icure.cardinal.sdk.model.base.StoredDocument
import com.icure.cardinal.sdk.model.embed.AgendaSlottingAlgorithm
import com.icure.cardinal.sdk.model.embed.ResourceGroupAllocationSchedule
import com.icure.cardinal.sdk.model.embed.UserAccessLevel
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.Set
import com.icure.cardinal.sdk.model.embed.Right
import kotlin.Deprecated

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class Agenda(
	override val id: String,
	override val rev: String? = null,
	override val created: Long? = null,
	override val modified: Long? = null,
	override val author: String? = null,
	override val responsible: String? = null,
	@param:DefaultValue("emptySet()")
	override val tags: Set<CodeStub> = emptySet(),
	@param:DefaultValue("emptySet()")
	override val codes: Set<CodeStub> = emptySet(),
	override val endOfLife: Long? = null,
	override val deletionDate: Long? = null,
	public val daySplitHour: Int? = null,
	@param:DefaultValue("false")
	public val unpublished: Boolean = false,
	public val name: String? = null,
	public val userId: String? = null,
	public val zoneId: String? = null,
	@param:DefaultValue("emptyMap()")
	public val userRights: Map<String, UserAccessLevel> = emptyMap(),
	public val slottingAlgorithm: AgendaSlottingAlgorithm? = null,
	public val publicBookingQuota: Int? = null,
	@param:DefaultValue("emptySet()")
	public val properties: Set<DecryptedPropertyStub> = emptySet(),
	@param:DefaultValue("emptyList()")
	public val schedules: List<ResourceGroupAllocationSchedule> = emptyList(),
) : StoredDocument, ICureDocument<String>, HasEndOfLife {
	// region Agenda-Agenda

	// endregion
}
