package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

@Serializable
public enum class PartnershipType(
	internal val dtoSerialName: String,
) {
	@SerialName("primary_contact")
	PrimaryContact("primary_contact"),

	@SerialName("primary_contact_for")
	PrimaryContactFor("primary_contact_for"),

	@SerialName("family")
	Family("family"),

	@SerialName("friend")
	Friend("friend"),

	@SerialName("counselor")
	Counselor("counselor"),

	@SerialName("contact")
	Contact("contact"),

	@SerialName("brother")
	Brother("brother"),

	@SerialName("brotherinlaw")
	Brotherinlaw("brotherinlaw"),

	@SerialName("child")
	Child("child"),

	@SerialName("daughter")
	Daughter("daughter"),

	@SerialName("employer")
	Employer("employer"),

	@SerialName("father")
	Father("father"),

	@SerialName("grandchild")
	Grandchild("grandchild"),

	@SerialName("grandparent")
	Grandparent("grandparent"),

	@SerialName("husband")
	Husband("husband"),

	@SerialName("lawyer")
	Lawyer("lawyer"),

	@SerialName("mother")
	Mother("mother"),

	@SerialName("neighbour")
	Neighbour("neighbour"),

	@SerialName("notary")
	Notary("notary"),

	@SerialName("partner")
	Partner("partner"),

	@SerialName("sister")
	Sister("sister"),

	@SerialName("sisterinlaw")
	Sisterinlaw("sisterinlaw"),

	@SerialName("son")
	Son("son"),

	@SerialName("spouse")
	Spouse("spouse"),

	@SerialName("stepdaughter")
	Stepdaughter("stepdaughter"),

	@SerialName("stepfather")
	Stepfather("stepfather"),

	@SerialName("stepmother")
	Stepmother("stepmother"),

	@SerialName("stepson")
	Stepson("stepson"),

	@SerialName("tutor")
	Tutor("tutor"),

	@SerialName("cohabiting")
	Cohabiting("cohabiting"),

	@SerialName("registered_partner")
	RegisteredPartner("registered_partner"),

	@SerialName("next_of_kin")
	NextOfKin("next_of_kin"),

	@SerialName("federal_agency")
	FederalAgency("federal_agency"),

	@SerialName("insurance_company")
	InsuranceCompany("insurance_company"),

	@SerialName("state_agency")
	StateAgency("state_agency"),

	@SerialName("unknown")
	Unknown("unknown"),

	@SerialName("seealso")
	Seealso("seealso"),

	@SerialName("refer")
	Refer("refer"),
}
