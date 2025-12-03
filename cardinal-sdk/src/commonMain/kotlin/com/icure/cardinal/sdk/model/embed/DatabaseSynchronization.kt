package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

@Serializable
public data class DatabaseSynchronization(
	public val source: String? = null,
	public val target: String? = null,
	public val filter: String? = null,
	public val localTarget: Target? = null,
) {
	@Serializable
	public enum class Target(
		internal val dtoSerialName: String,
	) {
		@SerialName("base")
		Base("base"),

		@SerialName("healthdata")
		Healthdata("healthdata"),

		@SerialName("patient")
		Patient("patient"),
	}
}
