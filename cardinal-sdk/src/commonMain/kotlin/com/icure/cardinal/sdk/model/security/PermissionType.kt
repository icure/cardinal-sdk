package com.icure.cardinal.sdk.model.security

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
enum class PermissionType() {
	@SerialName("AUTHENTICATE")
	Authenticate("AUTHENTICATE"),

	@SerialName("HCP")
	Hcp("HCP"),

	@SerialName("PHYSICIAN")
	Physician("PHYSICIAN"),

	@SerialName("ADMIN")
	Admin("ADMIN"),

	@SerialName("PATIENT_VIEW")
	PatientView("PATIENT_VIEW"),

	@SerialName("PATIENT_CREATE")
	PatientCreate("PATIENT_CREATE"),

	@SerialName("PATIENT_CHANGE_DELETE")
	PatientChangeDelete("PATIENT_CHANGE_DELETE"),

	@SerialName("MEDICAL_DATA_VIEW")
	MedicalDataView("MEDICAL_DATA_VIEW"),

	@SerialName("MEDICAL_DATA_CREATE")
	MedicalDataCreate("MEDICAL_DATA_CREATE"),

	@SerialName("MEDICAL_CHANGE_DELETE")
	MedicalChangeDelete("MEDICAL_CHANGE_DELETE"),

	@SerialName("FINANCIAL_DATA_VIEW")
	FinancialDataView("FINANCIAL_DATA_VIEW"),

	@SerialName("FINANCIAL_DATA_CREATE")
	FinancialDataCreate("FINANCIAL_DATA_CREATE"),

	@SerialName("FINANCIAL_CHANGE_DELETE")
	FinancialChangeDelete("FINANCIAL_CHANGE_DELETE"),

	@SerialName("LEGACY_DATA_VIEW")
	LegacyDataView("LEGACY_DATA_VIEW"),
	;

	public val dtoSerialName: String
}
