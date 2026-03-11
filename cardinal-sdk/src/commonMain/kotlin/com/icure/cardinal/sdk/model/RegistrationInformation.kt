// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames
import kotlin.String
import kotlin.collections.Set

/**
 * DTO containing the information required to register a new user and group in the iCure platform.
 * /
 */
@Serializable
data class RegistrationInformation(
	/**
	 * The identifier of the application or project for this registration.
	 */
	@JsonNames("applicationId")
	public val projectId: String? = null,
	/**
	 * The first name of the person registering.
	 */
	public val firstName: String? = null,
	/**
	 * The last name of the person registering.
	 */
	public val lastName: String? = null,
	/**
	 * The name of the company or organization.
	 */
	public val companyName: String? = null,
	/**
	 * The email address of the person registering.
	 */
	public val emailAddress: String,
	/**
	 * Additional user options serialized as a string.
	 */
	public val userOptions: String? = null,
	/**
	 * The set of roles to assign to the newly created user.
	 */
	@param:DefaultValue("emptySet()")
	public val userRoles: Set<String> = emptySet(),
	/**
	 * The minimum required Kraken version for this registration.
	 */
	public val minimumKrakenVersion: String? = null,
	/**
	 * The target cluster for the registration.
	 */
	public val cluster: String? = null,
) {
	// region RegistrationInformation-RegistrationInformation

	// endregion
}
