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
public data class RoleConfiguration(
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
}
