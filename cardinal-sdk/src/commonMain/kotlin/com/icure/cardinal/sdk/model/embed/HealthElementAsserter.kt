// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.model.base.Identifier
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
 *  The party is named in exactly one of two ways, and exactly one of the two fields must be set:
 *  - [localAsserterIdentifier] names a party stored in this iCure instance: an id, plus the
 * [AsserterTypeDto] saying
 *    which kind of record that id points at;
 *  - [externalAsserterIdentifier] names a party that has no record here, through a business
 * [IdentifierDto] issued by
 *    another system. There is deliberately no [AsserterTypeDto] on this branch: the kind of a
 * record we do not store is
 *    not knowable to us.
 *
 *  The exactly-one rule is **not** checked on this DTO. It is checked one layer down, in
 * `HealthElementAsserter`'s
 *  `init`: mapping this DTO constructs one, so a violation still surfaces as a `400`, and the rule
 * also covers the write
 *  paths that never build a DTO at all. This class only checks that [LocalAsserterIdentifier.id] is
 * not blank. Nothing
 *  enforces the *pairing* inside [LocalAsserterIdentifier]: [AsserterTypeDto] bounds the
 * vocabulary, not what
 *  [LocalAsserterIdentifier.id] actually points at; that invariant is owned by the SDK.
 *
 *  Note on organisations: an organisation (hospital, practice, care home, ...) is not a distinct
 * asserter type.
 *  Organisations are stored as healthcare party records, distinguished from individual
 * practitioners by tags set by the
 *  client, so an organisation asserter is a [localAsserterIdentifier] with `type =
 * AsserterTypeDto.healthcareParty`
 *  whose `id` points to such a record. The association between a practitioner and the organisation
 * they were acting for
 *  at the time of the assertion is deliberately NOT modelled here.
 */
@Serializable
data class HealthElementAsserter(
	/**
	 *
	 *  The asserting party, as a reference to a record stored in this instance. Null when the party is
	 * named by
	 *  [externalAsserterIdentifier].
	 */
	public val localAsserterIdentifier: LocalAsserterIdentifier? = null,
	/**
	 *
	 *  The asserting party, as a business identifier from a system that is not this one. Null when the
	 * party is named by
	 *  [localAsserterIdentifier]. Carries no [AsserterTypeDto].
	 */
	public val externalAsserterIdentifier: Identifier? = null,
) {
	/**
	 *
	 *  A reference to the record, stored in iCure.
	 */
	@Serializable
	public data class LocalAsserterIdentifier(
		/**
		 * The id of the entity making the assertion. Which entity it refers to is given by [type].
		 */
		public val id: String,
		/**
		 *
		 *  The kind of entity [id] refers to. This is the kind of entity, not the role the party played -
		 * do not
		 *  confuse it with ParticipantTypeDto.
		 */
		public val type: AsserterType,
	)

	// region HealthElementAsserter-HealthElementAsserter


	// endregion
}
