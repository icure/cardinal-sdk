// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 *
 *  Enumerates the types of changes that can occur on a medical house contract.
 */
@Serializable
enum class ContractChangeType(
	internal val dtoSerialName: String,
) {
	@SerialName("inscriptionStart")
	InscriptionStart("inscriptionStart"),

	@SerialName("inscriptionEnd")
	InscriptionEnd("inscriptionEnd"),

	@SerialName("suspension")
	Suspension("suspension"),

	@SerialName("coverageChange")
	CoverageChange("coverageChange"),
}
