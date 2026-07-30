// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 *
 *  The type of entity a partnership's partnerId refers to. When null the partner is either a
 * patient or a healthcare
 *  party (legacy behavior, the client has to resolve the ambiguity).
 */
@Serializable
enum class PartnerType(
	internal val dtoSerialName: String,
) {
	@SerialName("patient")
	Patient("patient"),

	@SerialName("healthcareParty")
	HealthcareParty("healthcareParty"),

	@SerialName("relatedPerson")
	RelatedPerson("relatedPerson"),
}
