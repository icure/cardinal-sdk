// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 *
 *  Enumerates the types of signatures used for medical house contracts, by holder or legal
 * representative, via eID or paper.
 */
@Serializable
enum class MhcSignatureType(
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
