package com.icure.cardinal.sdk.model.filter.form

import com.icure.cardinal.sdk.model.Form
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.String

@SerialName("FormByLogicalUuidFilter")
@Serializable
public data class FormByLogicalUuidFilter(
	public val logicalUuid: String,
	public val descending: Boolean? = null,
	override val desc: String? = null,
) : AbstractFilter<Form>
