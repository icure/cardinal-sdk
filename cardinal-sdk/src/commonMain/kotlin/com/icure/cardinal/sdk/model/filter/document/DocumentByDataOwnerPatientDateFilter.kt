package com.icure.cardinal.sdk.model.filter.document

import com.icure.cardinal.sdk.model.Document
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.serialization.InstantSerializer
import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.String
import kotlin.collections.Set

@SerialName("DocumentByDataOwnerPatientDateFilter")
@Serializable
public data class DocumentByDataOwnerPatientDateFilter(
	public val dataOwnerId: String,
	public val secretPatientKeys: Set<String>,
	@Serializable(with = InstantSerializer::class)
	public val startDate: Instant? = null,
	@Serializable(with = InstantSerializer::class)
	public val endDate: Instant? = null,
	public val descending: Boolean? = null,
	override val desc: String? = null,
) : AbstractFilter<Document>
