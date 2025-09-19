package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.Set

@Serializable
public data class RoleConfiguration(
	public val source: Source,
	@DefaultValue("emptySet()")
	public val roles: Set<String> = emptySet(),
) {
	@Serializable
	public enum class Source(
		internal val dtoSerialName: String,
	) {
		@SerialName("CONFIGURATION")
		Configuration("CONFIGURATION"),

		@SerialName("INHERITED")
		Inherited("INHERITED"),

		@SerialName("DEFAULT")
		Default("DEFAULT"),
	}
}
