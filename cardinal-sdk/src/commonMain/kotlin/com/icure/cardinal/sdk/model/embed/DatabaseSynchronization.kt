package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 * Represents a database synchronization configuration between a source and a target, with optional
 * filtering.
 * /
 */
@Serializable
public data class DatabaseSynchronization(
	/**
	 * The source database URL or identifier.
	 */
	public val source: String? = null,
	/**
	 * The target database URL or identifier.
	 */
	public val target: String? = null,
	/**
	 * A filter expression to apply during synchronization.
	 */
	public val filter: String? = null,
	/**
	 * The local target type for the synchronization (base, healthdata, or patient).
	 */
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
