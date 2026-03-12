package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.Serializable
import kotlin.Int

/**
 * Represents the renewal information for a medication prescription, including the number of
 * renewals and their duration.
 * /
 */
@Serializable
public data class Renewal(
	/**
	 * The number of authorized renewals.
	 */
	public val decimal: Int? = null,
	/**
	 * The duration of each renewal period.
	 */
	public val duration: Duration? = null,
)
