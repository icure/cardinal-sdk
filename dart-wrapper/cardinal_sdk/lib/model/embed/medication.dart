// auto-generated file
import 'package:cardinal_sdk/model/embed/substanceproduct.dart';
import 'package:cardinal_sdk/model/embed/medicinalproduct.dart';
import 'package:cardinal_sdk/model/base/code_stub.dart';
import 'package:cardinal_sdk/model/embed/duration.dart';
import 'package:cardinal_sdk/model/embed/renewal.dart';
import 'package:cardinal_sdk/model/embed/regimen_item.dart';
import 'package:cardinal_sdk/model/embed/paragraph_agreement.dart';
import 'package:cardinal_sdk/model/embed/suspension.dart';
import 'package:cardinal_sdk/model/embed/address.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
part "medication.freezed.dart";


@freezed
abstract class Medication with _$Medication {
	const factory Medication({
		@Default(null) String? compoundPrescription,
		@Default(null) Substanceproduct? substanceProduct,
		@Default(null) Medicinalproduct? medicinalProduct,
		@Default(null) int? numberOfPackages,
		@Default(null) String? batch,
		@Default(null) int? expirationDate,
		@Default(null) String? instructionForPatient,
		@Default(null) String? instructionForReimbursement,
		@Default(null) String? commentForDelivery,
		@Default(null) String? drugRoute,
		@Default(null) String? temporality,
		@Default(null) CodeStub? frequency,
		@Default(null) CodeStub? reimbursementReason,
		@Default(null) bool? substitutionAllowed,
		@Default(null) int? beginMoment,
		@Default(null) int? endMoment,
		@Default(null) int? deliveryMoment,
		@Default(null) int? endExecutionMoment,
		@Default(null) Duration? duration,
		@Default(null) Renewal? renewal,
		@Default(null) bool? knownUsage,
		@Default(null) List<RegimenItem>? regimen,
		@Default(null) String? posology,
		@Default(null) Map<String, ParagraphAgreement>? agreements,
		@Default(null) String? medicationSchemeIdOnSafe,
		@Default(null) int? medicationSchemeSafeVersion,
		@Default(null) int? medicationSchemeTimeStampOnSafe,
		@Default(null) String? medicationSchemeDocumentId,
		@Default(null) String? safeIdName,
		@Default(null) String? idOnSafes,
		@Default(null) int? timestampOnSafe,
		@Default(null) bool? changeValidated,
		@Default(null) bool? newSafeMedication,
		@Default(null) String? medicationUse,
		@Default(null) String? beginCondition,
		@Default(null) String? endCondition,
		@Default(null) String? origin,
		@Default(null) bool? medicationChanged,
		@Default(null) bool? posologyChanged,
		@Default(null) List<Suspension>? suspension,
		@Default(null) String? prescriptionRID,
		@Default(null) int? status,
		@Default(null) DecryptedAddress? stockLocation,
	}) = _Medication;


	static Map<String, dynamic> encode(Medication value) {
		Map<String, dynamic> entityAsMap = {
			"compoundPrescription" : value.compoundPrescription,
			"substanceProduct" : value.substanceProduct == null ? null : Substanceproduct.encode(value.substanceProduct!),
			"medicinalProduct" : value.medicinalProduct == null ? null : Medicinalproduct.encode(value.medicinalProduct!),
			"numberOfPackages" : value.numberOfPackages,
			"batch" : value.batch,
			"expirationDate" : value.expirationDate,
			"instructionForPatient" : value.instructionForPatient,
			"instructionForReimbursement" : value.instructionForReimbursement,
			"commentForDelivery" : value.commentForDelivery,
			"drugRoute" : value.drugRoute,
			"temporality" : value.temporality,
			"frequency" : value.frequency == null ? null : CodeStub.encode(value.frequency!),
			"reimbursementReason" : value.reimbursementReason == null ? null : CodeStub.encode(value.reimbursementReason!),
			"substitutionAllowed" : value.substitutionAllowed,
			"beginMoment" : value.beginMoment,
			"endMoment" : value.endMoment,
			"deliveryMoment" : value.deliveryMoment,
			"endExecutionMoment" : value.endExecutionMoment,
			"duration" : value.duration == null ? null : Duration.encode(value.duration!),
			"renewal" : value.renewal == null ? null : Renewal.encode(value.renewal!),
			"knownUsage" : value.knownUsage,
			"regimen" : value.regimen?.map((x0) => RegimenItem.encode(x0)).toList(),
			"posology" : value.posology,
			"agreements" : value.agreements?.map((k0, v0) => MapEntry(k0, ParagraphAgreement.encode(v0))),
			"medicationSchemeIdOnSafe" : value.medicationSchemeIdOnSafe,
			"medicationSchemeSafeVersion" : value.medicationSchemeSafeVersion,
			"medicationSchemeTimeStampOnSafe" : value.medicationSchemeTimeStampOnSafe,
			"medicationSchemeDocumentId" : value.medicationSchemeDocumentId,
			"safeIdName" : value.safeIdName,
			"idOnSafes" : value.idOnSafes,
			"timestampOnSafe" : value.timestampOnSafe,
			"changeValidated" : value.changeValidated,
			"newSafeMedication" : value.newSafeMedication,
			"medicationUse" : value.medicationUse,
			"beginCondition" : value.beginCondition,
			"endCondition" : value.endCondition,
			"origin" : value.origin,
			"medicationChanged" : value.medicationChanged,
			"posologyChanged" : value.posologyChanged,
			"suspension" : value.suspension?.map((x0) => Suspension.encode(x0)).toList(),
			"prescriptionRID" : value.prescriptionRID,
			"status" : value.status,
			"stockLocation" : value.stockLocation == null ? null : DecryptedAddress.encode(value.stockLocation!)
		};
		return entityAsMap;
	}

	static Medication fromJSON(Map<String, dynamic> data) {
		return Medication(
			numberOfPackages: (data["numberOfPackages"] as int?),
			medicationSchemeSafeVersion: (data["medicationSchemeSafeVersion"] as int?),
			status: (data["status"] as int?),
			compoundPrescription: (data["compoundPrescription"] as String?),
			substanceProduct: data["substanceProduct"] == null ? null : Substanceproduct.fromJSON(data["substanceProduct"]),
			medicinalProduct: data["medicinalProduct"] == null ? null : Medicinalproduct.fromJSON(data["medicinalProduct"]),
			batch: (data["batch"] as String?),
			expirationDate: (data["expirationDate"] as int?),
			instructionForPatient: (data["instructionForPatient"] as String?),
			instructionForReimbursement: (data["instructionForReimbursement"] as String?),
			commentForDelivery: (data["commentForDelivery"] as String?),
			drugRoute: (data["drugRoute"] as String?),
			temporality: (data["temporality"] as String?),
			frequency: data["frequency"] == null ? null : CodeStub.fromJSON(data["frequency"]),
			reimbursementReason: data["reimbursementReason"] == null ? null : CodeStub.fromJSON(data["reimbursementReason"]),
			substitutionAllowed: (data["substitutionAllowed"] as bool?),
			beginMoment: (data["beginMoment"] as int?),
			endMoment: (data["endMoment"] as int?),
			deliveryMoment: (data["deliveryMoment"] as int?),
			endExecutionMoment: (data["endExecutionMoment"] as int?),
			duration: data["duration"] == null ? null : Duration.fromJSON(data["duration"]),
			renewal: data["renewal"] == null ? null : Renewal.fromJSON(data["renewal"]),
			knownUsage: (data["knownUsage"] as bool?),
			regimen: (data["regimen"] as List<dynamic>?)?.map((x0) => RegimenItem.fromJSON(x0) ).toList(),
			posology: (data["posology"] as String?),
			agreements: (data["agreements"] as Map<String, dynamic>?)?.map((k0, v0) => MapEntry((k0 as String), ParagraphAgreement.fromJSON(v0))),
			medicationSchemeIdOnSafe: (data["medicationSchemeIdOnSafe"] as String?),
			medicationSchemeTimeStampOnSafe: (data["medicationSchemeTimeStampOnSafe"] as int?),
			medicationSchemeDocumentId: (data["medicationSchemeDocumentId"] as String?),
			safeIdName: (data["safeIdName"] as String?),
			idOnSafes: (data["idOnSafes"] as String?),
			timestampOnSafe: (data["timestampOnSafe"] as int?),
			changeValidated: (data["changeValidated"] as bool?),
			newSafeMedication: (data["newSafeMedication"] as bool?),
			medicationUse: (data["medicationUse"] as String?),
			beginCondition: (data["beginCondition"] as String?),
			endCondition: (data["endCondition"] as String?),
			origin: (data["origin"] as String?),
			medicationChanged: (data["medicationChanged"] as bool?),
			posologyChanged: (data["posologyChanged"] as bool?),
			suspension: (data["suspension"] as List<dynamic>?)?.map((x0) => Suspension.fromJSON(x0) ).toList(),
			prescriptionRID: (data["prescriptionRID"] as String?),
			stockLocation: data["stockLocation"] == null ? null : DecryptedAddress.fromJSON(data["stockLocation"])
		);
	}
}