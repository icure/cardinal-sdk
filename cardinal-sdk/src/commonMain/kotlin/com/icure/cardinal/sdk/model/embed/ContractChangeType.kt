package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

@Serializable
public enum class ContractChangeType(
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
