package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.model.base.CodeStub
import kotlinx.serialization.Serializable
import kotlin.Double

/**
 * Represents a duration with a numeric value and a time unit code.
 * /
 */
@Serializable
public data class Duration(
	/**
	 * The numeric value of the duration.
	 */
	public val `value`: Double? = null,
	/**
	 * The coded time unit (CD-TIMEUNIT) for this duration.
	 */
	public val unit: CodeStub? = null,
)
