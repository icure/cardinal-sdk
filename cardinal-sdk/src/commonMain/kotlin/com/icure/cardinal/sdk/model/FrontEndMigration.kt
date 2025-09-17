package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.model.base.StoredDocument
import com.icure.cardinal.sdk.model.embed.FrontEndMigrationStatus
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Long
import kotlin.String
import kotlin.collections.Set

@Serializable
public data class FrontEndMigration(
	override val id: String,
	override val rev: String? = null,
	override val deletionDate: Long? = null,
	public val name: String? = null,
	public val startDate: Long? = null,
	public val endDate: Long? = null,
	public val status: FrontEndMigrationStatus? = null,
	public val logs: String? = null,
	public val userId: String? = null,
	public val startKey: String? = null,
	public val startKeyDocId: String? = null,
	public val processCount: Long? = null,
	@DefaultValue("emptySet()")
	public val properties: Set<DecryptedPropertyStub> = emptySet(),
) : StoredDocument
