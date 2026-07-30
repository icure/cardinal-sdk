// auto-generated file

/**
 *
 *
 *   The type of entity a partnership's partnerId refers to. When null the partner is either a
 *  patient or a healthcare
 *   party (legacy behavior, the client has to resolve the ambiguity).
 */
export enum PartnerType {
	Patient = "Patient",
	HealthcareParty = "HealthcareParty",
	RelatedPerson = "RelatedPerson"
}
