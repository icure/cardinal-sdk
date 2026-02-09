package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.model.base.Identifiable
import com.icure.cardinal.sdk.model.base.Named
import com.icure.cardinal.sdk.model.base.StoredDocument
import com.icure.cardinal.sdk.model.embed.DatabaseSynchronization
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Long
import kotlin.String
import kotlin.collections.List

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class Replication(
	override val id: String,
	override val rev: String? = null,
	override val deletionDate: Long? = null,
	override val name: String? = null,
	public val context: String? = null,
	@param:DefaultValue("emptyList()")
	public val databaseSynchronizations: List<DatabaseSynchronization> = emptyList(),
) : StoredDocument, Identifiable<String>, Named {
	// region Replication-Replication

	// endregion
}
