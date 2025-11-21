package com.icure.cardinal.sdk.model.filter.classification

import com.icure.cardinal.sdk.model.Classification
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Long
import kotlin.String
import kotlin.collections.Set

@SerialName("ClassificationByDataOwnerPatientCreatedDateFilter")
@Serializable
public data class ClassificationByDataOwnerPatientCreatedDateFilter(
	public val dataOwnerId: String,
	public val startDate: Long?,
	public val endDate: Long?,
	public val secretForeignKeys: Set<String>,
	public val descending: Boolean?,
	override val desc: String? = null,
) : AbstractFilter<Classification>
