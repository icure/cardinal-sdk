package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.Serializable
import kotlin.String

/**
 *
 *  Represents a planned sending schedule defined by a cron expression.
 */
@Serializable
public class PlannedSending(
	/**
	 * The cron expression defining the sending schedule.
	 */
	public val cronExpression: String? = null,
)
