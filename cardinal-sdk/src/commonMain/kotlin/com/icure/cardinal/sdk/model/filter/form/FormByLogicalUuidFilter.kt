package com.icure.cardinal.sdk.model.filter.form

import com.icure.cardinal.sdk.model.Form
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.String

/**
 * Filter that matches forms by their logical UUID.
 * /
 */
@SerialName("FormByLogicalUuidFilter")
@Serializable
public data class FormByLogicalUuidFilter(
	/**
	 * The logical UUID to match.
	 */
	public val logicalUuid: String,
	/**
	 * Whether to return results in descending order.
	 */
	public val descending: Boolean? = null,
	/**
	 * Optional description of this filter.
	 */
	override val desc: String? = null,
) : AbstractFilter<Form>
