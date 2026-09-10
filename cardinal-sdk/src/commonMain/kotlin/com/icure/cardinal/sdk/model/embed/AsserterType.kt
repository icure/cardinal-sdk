// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 *
 *  The kind of entity a health element asserter's
 * [HealthElementAsserterDto.LocalAsserterIdentifier.id] refers to.
 *
 *  This is the *entity-kind* axis, not the role axis: it says what sort of record the id points at,
 * not what part the
 *  party played in the assertion. Do not confuse it with ParticipantTypeDto.
 *
 *  It applies to the *local* branch of [HealthElementAsserterDto] only: an asserter named by
 *  [HealthElementAsserterDto.externalAsserterIdentifier] has no record here, so it carries no
 * entity kind.
 *
 *  The entries deliberately mirror [PartnerTypeDto], which answers the same question for a
 * partnership's partnerId. The
 *  two enums are kept separate on purpose: partnership vocabulary and asserter vocabulary are free
 * to diverge, and
 *  neither should widen because the other did.
 *
 *  Note that an organisation (hospital, practice, care home, ...) is not a distinct entry:
 * organisations are stored as
 *  healthcare party records, so they use [healthcareParty].
 */
@Serializable
enum class AsserterType(
	internal val dtoSerialName: String,
) {
	@SerialName("patient")
	Patient("patient"),

	@SerialName("healthcareParty")
	HealthcareParty("healthcareParty"),

	@SerialName("relatedPerson")
	RelatedPerson("relatedPerson"),
}
