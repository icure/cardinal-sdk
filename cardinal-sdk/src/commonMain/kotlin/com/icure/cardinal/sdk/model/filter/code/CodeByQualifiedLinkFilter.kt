package com.icure.cardinal.sdk.model.filter.code

import com.icure.cardinal.sdk.model.Code
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 * Filter that matches codes by their qualified link type and optionally by linked entity
 * identifier.
 * /
 */
@SerialName("CodeByQualifiedLinkFilter")
@Serializable
public data class CodeByQualifiedLinkFilter(
	/**
	 * The type of qualified link to match.
	 */
	public val linkType: String,
	/**
	 * The optional identifier of the linked entity.
	 */
	public val linkedId: String? = null,
	/**
	 * Optional description of this filter.
	 */
	override val desc: String? = null,
) : AbstractFilter<Code>
