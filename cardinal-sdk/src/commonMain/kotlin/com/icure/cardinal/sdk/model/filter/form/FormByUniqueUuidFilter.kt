package com.icure.cardinal.sdk.model.filter.form

import com.icure.cardinal.sdk.model.Form
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.String

@SerialName("FormByUniqueUuidFilter")
@Serializable
public data class FormByUniqueUuidFilter(
	public val uniqueId: String,
	public val descending: Boolean? = null,
	override val desc: String? = null,
) : AbstractFilter<Form>
