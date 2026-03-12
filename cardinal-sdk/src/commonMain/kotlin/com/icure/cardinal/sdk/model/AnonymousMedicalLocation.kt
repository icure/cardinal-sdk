// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.Map

/**
 * DTO representing a medical location with only publicly accessible information, stripped of
 * sensitive data.
 * /
 */
@Serializable
data class AnonymousMedicalLocation(
	/**
	 * The unique identifier of the medical location.
	 */
	public val id: String,
	/**
	 * A map of publicly available information about the medical location, keyed by information type.
	 */
	@param:DefaultValue("emptyMap()")
	public val publicInformations: Map<String, String> = emptyMap(),
) {
	// region AnonymousMedicalLocation-AnonymousMedicalLocation

	// endregion
}
