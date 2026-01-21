package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

@Serializable
public enum class MhcSignatureType(
	internal val dtoSerialName: String,
) {
	@SerialName("holderEid")
	HolderEid("holderEid"),

	@SerialName("holderPaper")
	HolderPaper("holderPaper"),

	@SerialName("legalrepresentativeEid")
	LegalrepresentativeEid("legalrepresentativeEid"),

	@SerialName("legalrepresentativePaper")
	LegalrepresentativePaper("legalrepresentativePaper"),
}
