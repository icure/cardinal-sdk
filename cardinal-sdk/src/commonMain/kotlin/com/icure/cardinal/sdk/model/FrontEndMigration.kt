package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.model.base.StoredDocument
import com.icure.cardinal.sdk.model.embed.FrontEndMigrationStatus
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Long
import kotlin.String
import kotlin.collections.Set

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class FrontEndMigration(
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
	@param:DefaultValue("emptySet()")
	public val properties: Set<DecryptedPropertyStub> = emptySet(),
) : StoredDocument {
	// region FrontEndMigration-FrontEndMigration

	// endregion
}
