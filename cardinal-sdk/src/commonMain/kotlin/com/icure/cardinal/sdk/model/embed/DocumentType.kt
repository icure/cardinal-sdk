package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

@Serializable
public enum class DocumentType(
	internal val dtoSerialName: String,
) {
	@SerialName("admission")
	Admission("admission"),

	@SerialName("alert")
	Alert("alert"),

	@SerialName("bvt_sample")
	BvtSample("bvt_sample"),

	@SerialName("clinicalpath")
	Clinicalpath("clinicalpath"),

	@SerialName("clinicalsummary")
	Clinicalsummary("clinicalsummary"),

	@SerialName("contactreport")
	Contactreport("contactreport"),

	@SerialName("quote")
	Quote("quote"),

	@SerialName("invoice")
	Invoice("invoice"),

	@SerialName("death")
	Death("death"),

	@SerialName("discharge")
	Discharge("discharge"),

	@SerialName("dischargereport")
	Dischargereport("dischargereport"),

	@SerialName("ebirth_baby_medicalform")
	EbirthBabyMedicalform("ebirth_baby_medicalform"),

	@SerialName("ebirth_baby_notification")
	EbirthBabyNotification("ebirth_baby_notification"),

	@SerialName("ebirth_mother_medicalform")
	EbirthMotherMedicalform("ebirth_mother_medicalform"),

	@SerialName("ebirth_mother_notification")
	EbirthMotherNotification("ebirth_mother_notification"),

	@SerialName("ecare_safe_consultation")
	EcareSafeConsultation("ecare_safe_consultation"),

	@SerialName("epidemiology")
	Epidemiology("epidemiology"),

	@SerialName("intervention")
	Intervention("intervention"),

	@SerialName("labrequest")
	Labrequest("labrequest"),

	@SerialName("labresult")
	Labresult("labresult"),

	@SerialName("medicaladvisoragreement")
	Medicaladvisoragreement("medicaladvisoragreement"),

	@SerialName("medicationschemeelement")
	Medicationschemeelement("medicationschemeelement"),

	@SerialName("note")
	Note("note"),

	@SerialName("notification")
	Notification("notification"),

	@SerialName("pharmaceuticalprescription")
	Pharmaceuticalprescription("pharmaceuticalprescription"),

	@SerialName("prescription")
	Prescription("prescription"),

	@SerialName("productdelivery")
	Productdelivery("productdelivery"),

	@SerialName("quickdischargereport")
	Quickdischargereport("quickdischargereport"),

	@SerialName("radiationexposuremonitoring")
	Radiationexposuremonitoring("radiationexposuremonitoring"),

	@SerialName("referral")
	Referral("referral"),

	@SerialName("report")
	Report("report"),

	@SerialName("request")
	Request("request"),

	@SerialName("result")
	Result("result"),

	@SerialName("sumehr")
	Sumehr("sumehr"),

	@SerialName("telemonitoring")
	Telemonitoring("telemonitoring"),

	@SerialName("template")
	Template("template"),

	@SerialName("template_admin")
	TemplateAdmin("template_admin"),

	@SerialName("treatmentsuspension")
	Treatmentsuspension("treatmentsuspension"),

	@SerialName("vaccination")
	Vaccination("vaccination"),
}
