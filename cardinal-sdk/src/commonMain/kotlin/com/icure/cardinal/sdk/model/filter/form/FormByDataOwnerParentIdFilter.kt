package com.icure.cardinal.sdk.model.filter.form

import com.icure.cardinal.sdk.model.Form
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

@SerialName("FormByDataOwnerParentIdFilter")
@Serializable
public data class FormByDataOwnerParentIdFilter(
	public val dataOwnerId: String,
	public val parentId: String,
	override val desc: String? = null,
) : AbstractFilter<Form>
