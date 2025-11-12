package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Int

@Serializable
public sealed interface AgendaSlottingAlgorithm {
	@Serializable
	@SerialName("FixedIntervals")
	public data class FixedIntervals(
		public val intervalMinutes: Int,
	) : AgendaSlottingAlgorithm
}
