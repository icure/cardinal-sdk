package com.icure.cardinal.sdk.model.filter.form

import com.icure.cardinal.sdk.model.Form
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Long
import kotlin.String
import kotlin.collections.Set

@SerialName("FormByDataOwnerPatientOpeningDateFilter")
@Serializable
public data class FormByDataOwnerPatientOpeningDateFilter(
	public val dataOwnerId: String,
	public val secretPatientKeys: Set<String>,
	public val startDate: Long? = null,
	public val endDate: Long? = null,
	public val descending: Boolean? = null,
	override val desc: String? = null,
) : AbstractFilter<Form>
