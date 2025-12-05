package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.model.base.StoredDocument
import kotlinx.serialization.Serializable
import kotlin.Long
import kotlin.String

@Serializable
public data class EntityReference(
	override val id: String,
	override val rev: String? = null,
	override val deletionDate: Long? = null,
	public val docId: String? = null,
) : StoredDocument
