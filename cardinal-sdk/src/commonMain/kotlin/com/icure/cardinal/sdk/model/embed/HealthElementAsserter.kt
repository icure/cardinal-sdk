// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.Serializable
import kotlin.String

/**
 *
 *  The party asserting that the patient has the healthcare element this asserter is attached to.
 *
 *  This is the FHIR-style *asserter* concept: it does not say who recorded or authored the
 * healthcare element, it says
 *  on whose word the healthcare element is held to be true. A patient may self-report an allergy, a
 * family member may
 *  report a condition on behalf of the patient, and a physician may assert a diagnosis: all three
 * are asserters, and the
 *  same healthcare element may carry more than one of them.
 *
 *  The two fields must agree: [asserterType] declares which kind of entity [asserterId] points at.
 * [AsserterTypeDto]
 *  bounds the vocabulary, but nothing enforces the *pairing* - the field is encrypted, so the
 * server never sees the
 *  values and cannot validate or repair them; that invariant is owned by the SDK.
 *
 *  Note on organisations: an organisation (hospital, practice, care home, ...) is not a distinct
 * asserter type.
 *  Organisations are stored as healthcare party records, distinguished from individual
 * practitioners by tags set by the
 *  client, so an organisation asserter is an entry with `asserterType =
 * AsserterTypeDto.healthcareParty` whose
 *  [asserterId] points to such a record. The association between a practitioner and the
 * organisation they were acting
 *  for at the time of the assertion is deliberately NOT modelled here.
 */
@Serializable
data class HealthElementAsserter(
	/**
	 * The id of the entity making the assertion. Which entity it refers to is given by [asserterType].
	 *
	 */
	public val asserterId: String,
	/**
	 *
	 *  The kind of entity [asserterId] refers to. This is the kind of entity, not the role the party
	 * played - do not
	 *  confuse it with ParticipantTypeDto.
	 */
	public val asserterType: AsserterType,
) {
	// region HealthElementAsserter-HealthElementAsserter
	// endregion
}
