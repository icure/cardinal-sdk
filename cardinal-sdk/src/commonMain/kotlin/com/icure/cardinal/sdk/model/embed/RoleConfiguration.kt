// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.Set

/**
 *
 *  Represents the role configuration for a user, specifying the source of the roles and the set of
 * assigned roles.
 */
@Serializable
data class RoleConfiguration(
	/**
	 * The source from which the roles are derived (configuration, inherited, or default).
	 */
	public val source: Source,
	/**
	 * The set of role identifiers assigned.
	 */
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
