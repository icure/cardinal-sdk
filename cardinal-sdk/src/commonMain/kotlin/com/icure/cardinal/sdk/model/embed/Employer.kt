// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.model.base.Named
import kotlinx.serialization.Serializable
import kotlin.String

/**
 * Represents an employer with a name and address.
 * /
 */
@Serializable
data class Employer(
	/**
	 * The name of the employer.
	 */
	override val name: String? = null,
	/**
	 * The address of the employer.
	 */
	public val addresse: DecryptedAddress? = null,
) : Named {
	// region Employer-Employer

	// endregion
}
