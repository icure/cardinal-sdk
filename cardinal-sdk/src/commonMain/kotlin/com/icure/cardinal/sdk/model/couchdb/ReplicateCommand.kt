package com.icure.cardinal.sdk.model.couchdb

import com.icure.cardinal.sdk.model.base.Versionable
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.String
import kotlin.collections.List

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class ReplicateCommand(
	override val id: String,
	override val rev: String? = null,
	@param:DefaultValue("false")
	public val continuous: Boolean = false,
	@param:DefaultValue("false")
	public val createTarget: Boolean = false,
	public val docIds: List<String>? = null,
	public val cancel: Boolean? = null,
	public val filter: String? = null,
	public val selector: String? = null,
	public val source: Remote,
	public val target: Remote,
) : Versionable<String> {
	// region ReplicateCommand-ReplicateCommand

	// endregion
}
