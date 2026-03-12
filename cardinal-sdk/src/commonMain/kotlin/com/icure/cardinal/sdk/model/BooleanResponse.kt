package com.icure.cardinal.sdk.model

import kotlinx.serialization.Serializable
import kotlin.Boolean

/**
 *
 *  Simple wrapper DTO containing a single boolean response value.
 */
@Serializable
public data class BooleanResponse(
	/**
	 * The boolean result of the operation.
	 */
	public val response: Boolean,
)
