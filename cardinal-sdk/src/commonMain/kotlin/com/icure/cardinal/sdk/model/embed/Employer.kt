package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.model.base.Named
import kotlinx.serialization.Serializable
import kotlin.String

/**
 * Represents an employer with a name and address.
 * /
 */
@Serializable
public data class Employer(
	/**
	 * The name of the employer.
	 */
	override val name: String? = null,
	/**
	 * The address of the employer.
	 */
	public val addresse: DecryptedAddress? = null,
) : Named
