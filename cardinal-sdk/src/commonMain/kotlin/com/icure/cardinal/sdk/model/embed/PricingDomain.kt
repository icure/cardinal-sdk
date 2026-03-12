// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 *
 *  Enumerates the pricing domains for tarifications.
 */
@Serializable
enum class PricingDomain(
	internal val dtoSerialName: String,
) {
	@SerialName("ambulatory")
	Ambulatory("ambulatory"),

	@SerialName("hospital")
	Hospital("hospital"),

	@SerialName("both")
	Both("both"),
}
