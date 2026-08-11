// auto-generated file

/**
 *
 *
 *   The kind of entity a health element asserter's asserterId refers to.
 *
 *   This is the *entity-kind* axis, not the role axis: it says what sort of record the id points at,
 *  not what part the
 *   party played in the assertion. Do not confuse it with ParticipantTypeDto.
 *
 *   The entries deliberately mirror [PartnerTypeDto], which answers the same question for a
 *  partnership's partnerId. The
 *   two enums are kept separate on purpose: partnership vocabulary and asserter vocabulary are free
 *  to diverge, and
 *   neither should widen because the other did.
 *
 *   Note that an organisation (hospital, practice, care home, ...) is not a distinct entry:
 *  organisations are stored as
 *   healthcare party records, so they use [healthcareParty].
 */
export enum AsserterType {
	Patient = "Patient",
	HealthcareParty = "HealthcareParty",
	RelatedPerson = "RelatedPerson"
}
