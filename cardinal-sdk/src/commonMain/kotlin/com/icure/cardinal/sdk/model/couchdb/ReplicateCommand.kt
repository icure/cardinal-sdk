package com.icure.cardinal.sdk.model.couchdb

import com.icure.cardinal.sdk.model.base.Versionable
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.String
import kotlin.collections.List

@Serializable
public data class ReplicateCommand(
	override val id: String,
	override val rev: String? = null,
	@DefaultValue("false")
	public val continuous: Boolean = false,
	@DefaultValue("false")
	public val createTarget: Boolean = false,
	public val docIds: List<String>? = null,
	public val cancel: Boolean? = null,
	public val filter: String? = null,
	public val selector: String? = null,
	public val source: Remote,
	public val target: Remote,
) : Versionable<String>
