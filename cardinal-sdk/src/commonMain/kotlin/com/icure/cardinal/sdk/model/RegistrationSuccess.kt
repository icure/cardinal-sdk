package com.icure.cardinal.sdk.model

import kotlinx.serialization.Serializable
import kotlin.String

/**
 * DTO returned upon successful user and group registration, containing the identifiers and
 * initial authentication token needed to access the newly created environment.
 * /
 */
@Serializable
public data class RegistrationSuccess(
	/**
	 * The identifier of the newly created group.
	 */
	public val groupId: String,
	/**
	 * The identifier of the newly created user.
	 */
	public val userId: String,
	/**
	 * The initial authentication token for the newly registered user.
	 */
	public val token: String,
)
