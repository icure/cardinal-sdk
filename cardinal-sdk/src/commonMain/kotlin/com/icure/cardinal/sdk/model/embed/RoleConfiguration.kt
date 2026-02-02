package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.Set

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class RoleConfiguration(
	public val source: Source,
	@param:DefaultValue("emptySet()")
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
  // region RoleConfiguration-RoleConfiguration

  // endregion
}
