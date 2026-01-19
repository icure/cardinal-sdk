// auto-generated file
import 'package:cardinal_sdk/model/embed/payment_type.dart';
import 'package:cardinal_sdk/annotations/actual_int32.dart';
import 'package:cardinal_sdk/model/specializations/base64string.dart';
import 'package:cardinal_sdk/model/embed/invoicing_code.dart';
import 'package:cardinal_sdk/model/embed/encryptable.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
part "invoicing_code.freezed.dart";


sealed class InvoicingCode implements Encryptable {
	abstract final String? id;
	abstract final int? dateCode;
	abstract final String? logicalId;
	abstract final String? label;
	abstract final String? userId;
	abstract final String? contactId;
	abstract final String? serviceId;
	abstract final String? tarificationId;
	abstract final String? code;
	abstract final PaymentType? paymentType;
	abstract final double? paid;
	abstract final double? totalAmount;
	abstract final double? reimbursement;
	abstract final double? patientIntervention;
	abstract final double? amiIntervention;
	abstract final double? doctorSupplement;
	abstract final double? conventionAmount;
	abstract final double? vat;
	abstract final String? error;
	abstract final String? contract;
	abstract final int? contractDate;
	@actualInt32 abstract final int? units;
	@actualInt32 abstract final int? side;
	@actualInt32 abstract final int? timeOfDay;
	@actualInt32 abstract final int? eidReadingHour;
	abstract final String? eidReadingValue;
	@actualInt32 abstract final int? override3rdPayerCode;
	abstract final String? override3rdPayerReason;
	@actualInt32 abstract final int? transplantationCode;
	@actualInt32 abstract final int? prescriberNorm;
	abstract final String? productLabel;
	@actualInt32 abstract final int? percentNorm;
	abstract final String? prescriberNihii;
	abstract final String? relatedCode;
	abstract final int? prescriptionDate;
	@actualInt32 abstract final int? derogationMaxNumber;
	abstract final String? prescriberSsin;
	abstract final String? prescriberLastName;
	abstract final String? prescriberFirstName;
	abstract final String? prescriberCdHcParty;
	abstract final String? locationNihii;
	abstract final String? locationCdHcParty;
	@actualInt32 abstract final int? locationService;
	abstract final int? admissionDate;
	abstract final bool? canceled;
	abstract final bool? accepted;
	abstract final bool? pending;
	abstract final bool? resent;
	abstract final bool? archived;
	abstract final bool? lost;
	@actualInt32 abstract final int? insuranceJustification;
	@actualInt32 abstract final int? cancelPatientInterventionReason;
	abstract final int? status;
	abstract final String? codeLabel;
	abstract final Map<String, String> options;
	@override abstract final Base64String? encryptedSelf;

	static Map<String, dynamic> encode(InvoicingCode value) {
		switch (value) {
			case DecryptedInvoicingCode entity:
				Map<String, dynamic> entityJson = DecryptedInvoicingCode.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.embed.DecryptedInvoicingCode";
				return entityJson;
			case EncryptedInvoicingCode entity:
				Map<String, dynamic> entityJson = EncryptedInvoicingCode.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.embed.EncryptedInvoicingCode";
				return entityJson;
		}
	}

	static InvoicingCode fromJSON(Map<String, dynamic> data) {
		if (data["kotlinType"] == null) {
			throw ArgumentError('Missing discriminator: kotlinType');
		}
		String discriminator = data["kotlinType"];
		switch (discriminator) {
			case "com.icure.cardinal.sdk.model.embed.DecryptedInvoicingCode":
				return DecryptedInvoicingCode.fromJSON(data);
			case "com.icure.cardinal.sdk.model.embed.EncryptedInvoicingCode":
				return EncryptedInvoicingCode.fromJSON(data);
			default:
				throw ArgumentError('Invalid subclass $discriminator');
		}
	}
}

@freezed
abstract class DecryptedInvoicingCode with _$DecryptedInvoicingCode implements InvoicingCode {
	const factory DecryptedInvoicingCode({
		required String? id,
		@Default(null) int? dateCode,
		@Default(null) String? logicalId,
		@Default(null) String? label,
		@Default(null) String? userId,
		@Default(null) String? contactId,
		@Default(null) String? serviceId,
		@Default(null) String? tarificationId,
		@Default(null) String? code,
		@Default(null) PaymentType? paymentType,
		@Default(null) double? paid,
		@Default(null) double? totalAmount,
		@Default(null) double? reimbursement,
		@Default(null) double? patientIntervention,
		@Default(null) double? amiIntervention,
		@Default(null) double? doctorSupplement,
		@Default(null) double? conventionAmount,
		@Default(null) double? vat,
		@Default(null) String? error,
		@Default(null) String? contract,
		@Default(null) int? contractDate,
		@Default(null) int? units,
		@Default(null) int? side,
		@Default(null) int? timeOfDay,
		@Default(null) int? eidReadingHour,
		@Default(null) String? eidReadingValue,
		@Default(null) int? override3rdPayerCode,
		@Default(null) String? override3rdPayerReason,
		@Default(null) int? transplantationCode,
		@Default(null) int? prescriberNorm,
		@Default(null) String? productLabel,
		@Default(null) int? percentNorm,
		@Default(null) String? prescriberNihii,
		@Default(null) String? relatedCode,
		@Default(null) int? prescriptionDate,
		@Default(null) int? derogationMaxNumber,
		@Default(null) String? prescriberSsin,
		@Default(null) String? prescriberLastName,
		@Default(null) String? prescriberFirstName,
		@Default(null) String? prescriberCdHcParty,
		@Default(null) String? locationNihii,
		@Default(null) String? locationCdHcParty,
		@Default(null) int? locationService,
		@Default(null) int? admissionDate,
		@Default(null) bool? canceled,
		@Default(null) bool? accepted,
		@Default(null) bool? pending,
		@Default(null) bool? resent,
		@Default(null) bool? archived,
		@Default(null) bool? lost,
		@Default(null) int? insuranceJustification,
		@Default(null) int? cancelPatientInterventionReason,
		@Default(null) int? status,
		@Default(null) String? codeLabel,
		@Default({}) Map<String, String> options,
		@Default(null) Base64String? encryptedSelf,
	}) = _DecryptedInvoicingCode;


	static Map<String, dynamic> encode(DecryptedInvoicingCode value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"dateCode" : value.dateCode,
			"logicalId" : value.logicalId,
			"label" : value.label,
			"userId" : value.userId,
			"contactId" : value.contactId,
			"serviceId" : value.serviceId,
			"tarificationId" : value.tarificationId,
			"code" : value.code,
			"paymentType" : value.paymentType == null ? null : PaymentType.encode(value.paymentType!),
			"paid" : value.paid,
			"totalAmount" : value.totalAmount,
			"reimbursement" : value.reimbursement,
			"patientIntervention" : value.patientIntervention,
			"amiIntervention" : value.amiIntervention,
			"doctorSupplement" : value.doctorSupplement,
			"conventionAmount" : value.conventionAmount,
			"vat" : value.vat,
			"error" : value.error,
			"contract" : value.contract,
			"contractDate" : value.contractDate,
			"units" : value.units,
			"side" : value.side,
			"timeOfDay" : value.timeOfDay,
			"eidReadingHour" : value.eidReadingHour,
			"eidReadingValue" : value.eidReadingValue,
			"override3rdPayerCode" : value.override3rdPayerCode,
			"override3rdPayerReason" : value.override3rdPayerReason,
			"transplantationCode" : value.transplantationCode,
			"prescriberNorm" : value.prescriberNorm,
			"productLabel" : value.productLabel,
			"percentNorm" : value.percentNorm,
			"prescriberNihii" : value.prescriberNihii,
			"relatedCode" : value.relatedCode,
			"prescriptionDate" : value.prescriptionDate,
			"derogationMaxNumber" : value.derogationMaxNumber,
			"prescriberSsin" : value.prescriberSsin,
			"prescriberLastName" : value.prescriberLastName,
			"prescriberFirstName" : value.prescriberFirstName,
			"prescriberCdHcParty" : value.prescriberCdHcParty,
			"locationNihii" : value.locationNihii,
			"locationCdHcParty" : value.locationCdHcParty,
			"locationService" : value.locationService,
			"admissionDate" : value.admissionDate,
			"canceled" : value.canceled,
			"accepted" : value.accepted,
			"pending" : value.pending,
			"resent" : value.resent,
			"archived" : value.archived,
			"lost" : value.lost,
			"insuranceJustification" : value.insuranceJustification,
			"cancelPatientInterventionReason" : value.cancelPatientInterventionReason,
			"status" : value.status,
			"codeLabel" : value.codeLabel,
			"options" : value.options.map((k0, v0) => MapEntry(k0, v0)),
			"encryptedSelf" : value.encryptedSelf
		};
		return entityAsMap;
	}

	static DecryptedInvoicingCode fromJSON(Map<String, dynamic> data) {
		return DecryptedInvoicingCode(
			units: (data["units"] as int?),
			side: (data["side"] as int?),
			timeOfDay: (data["timeOfDay"] as int?),
			eidReadingHour: (data["eidReadingHour"] as int?),
			override3rdPayerCode: (data["override3rdPayerCode"] as int?),
			transplantationCode: (data["transplantationCode"] as int?),
			prescriberNorm: (data["prescriberNorm"] as int?),
			percentNorm: (data["percentNorm"] as int?),
			derogationMaxNumber: (data["derogationMaxNumber"] as int?),
			locationService: (data["locationService"] as int?),
			insuranceJustification: (data["insuranceJustification"] as int?),
			cancelPatientInterventionReason: (data["cancelPatientInterventionReason"] as int?),
			id: (data["id"] as String?),
			dateCode: (data["dateCode"] as int?),
			logicalId: (data["logicalId"] as String?),
			label: (data["label"] as String?),
			userId: (data["userId"] as String?),
			contactId: (data["contactId"] as String?),
			serviceId: (data["serviceId"] as String?),
			tarificationId: (data["tarificationId"] as String?),
			code: (data["code"] as String?),
			paymentType: data["paymentType"] == null ? null : PaymentType.fromJSON(data["paymentType"]),
			paid: (data["paid"] as num?)?.toDouble(),
			totalAmount: (data["totalAmount"] as num?)?.toDouble(),
			reimbursement: (data["reimbursement"] as num?)?.toDouble(),
			patientIntervention: (data["patientIntervention"] as num?)?.toDouble(),
			amiIntervention: (data["amiIntervention"] as num?)?.toDouble(),
			doctorSupplement: (data["doctorSupplement"] as num?)?.toDouble(),
			conventionAmount: (data["conventionAmount"] as num?)?.toDouble(),
			vat: (data["vat"] as num?)?.toDouble(),
			error: (data["error"] as String?),
			contract: (data["contract"] as String?),
			contractDate: (data["contractDate"] as int?),
			eidReadingValue: (data["eidReadingValue"] as String?),
			override3rdPayerReason: (data["override3rdPayerReason"] as String?),
			productLabel: (data["productLabel"] as String?),
			prescriberNihii: (data["prescriberNihii"] as String?),
			relatedCode: (data["relatedCode"] as String?),
			prescriptionDate: (data["prescriptionDate"] as int?),
			prescriberSsin: (data["prescriberSsin"] as String?),
			prescriberLastName: (data["prescriberLastName"] as String?),
			prescriberFirstName: (data["prescriberFirstName"] as String?),
			prescriberCdHcParty: (data["prescriberCdHcParty"] as String?),
			locationNihii: (data["locationNihii"] as String?),
			locationCdHcParty: (data["locationCdHcParty"] as String?),
			admissionDate: (data["admissionDate"] as int?),
			canceled: (data["canceled"] as bool?),
			accepted: (data["accepted"] as bool?),
			pending: (data["pending"] as bool?),
			resent: (data["resent"] as bool?),
			archived: (data["archived"] as bool?),
			lost: (data["lost"] as bool?),
			status: (data["status"] as int?),
			codeLabel: (data["codeLabel"] as String?),
			options: (data["options"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as String))),
			encryptedSelf: (data["encryptedSelf"] as Base64String?)
		);
	}
}

@freezed
abstract class EncryptedInvoicingCode with _$EncryptedInvoicingCode implements InvoicingCode {
	const factory EncryptedInvoicingCode({
		required String? id,
		@Default(null) int? dateCode,
		@Default(null) String? logicalId,
		@Default(null) String? label,
		@Default(null) String? userId,
		@Default(null) String? contactId,
		@Default(null) String? serviceId,
		@Default(null) String? tarificationId,
		@Default(null) String? code,
		@Default(null) PaymentType? paymentType,
		@Default(null) double? paid,
		@Default(null) double? totalAmount,
		@Default(null) double? reimbursement,
		@Default(null) double? patientIntervention,
		@Default(null) double? amiIntervention,
		@Default(null) double? doctorSupplement,
		@Default(null) double? conventionAmount,
		@Default(null) double? vat,
		@Default(null) String? error,
		@Default(null) String? contract,
		@Default(null) int? contractDate,
		@Default(null) int? units,
		@Default(null) int? side,
		@Default(null) int? timeOfDay,
		@Default(null) int? eidReadingHour,
		@Default(null) String? eidReadingValue,
		@Default(null) int? override3rdPayerCode,
		@Default(null) String? override3rdPayerReason,
		@Default(null) int? transplantationCode,
		@Default(null) int? prescriberNorm,
		@Default(null) String? productLabel,
		@Default(null) int? percentNorm,
		@Default(null) String? prescriberNihii,
		@Default(null) String? relatedCode,
		@Default(null) int? prescriptionDate,
		@Default(null) int? derogationMaxNumber,
		@Default(null) String? prescriberSsin,
		@Default(null) String? prescriberLastName,
		@Default(null) String? prescriberFirstName,
		@Default(null) String? prescriberCdHcParty,
		@Default(null) String? locationNihii,
		@Default(null) String? locationCdHcParty,
		@Default(null) int? locationService,
		@Default(null) int? admissionDate,
		@Default(null) bool? canceled,
		@Default(null) bool? accepted,
		@Default(null) bool? pending,
		@Default(null) bool? resent,
		@Default(null) bool? archived,
		@Default(null) bool? lost,
		@Default(null) int? insuranceJustification,
		@Default(null) int? cancelPatientInterventionReason,
		@Default(null) int? status,
		@Default(null) String? codeLabel,
		@Default({}) Map<String, String> options,
		@Default(null) Base64String? encryptedSelf,
	}) = _EncryptedInvoicingCode;


	static Map<String, dynamic> encode(EncryptedInvoicingCode value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"dateCode" : value.dateCode,
			"logicalId" : value.logicalId,
			"label" : value.label,
			"userId" : value.userId,
			"contactId" : value.contactId,
			"serviceId" : value.serviceId,
			"tarificationId" : value.tarificationId,
			"code" : value.code,
			"paymentType" : value.paymentType == null ? null : PaymentType.encode(value.paymentType!),
			"paid" : value.paid,
			"totalAmount" : value.totalAmount,
			"reimbursement" : value.reimbursement,
			"patientIntervention" : value.patientIntervention,
			"amiIntervention" : value.amiIntervention,
			"doctorSupplement" : value.doctorSupplement,
			"conventionAmount" : value.conventionAmount,
			"vat" : value.vat,
			"error" : value.error,
			"contract" : value.contract,
			"contractDate" : value.contractDate,
			"units" : value.units,
			"side" : value.side,
			"timeOfDay" : value.timeOfDay,
			"eidReadingHour" : value.eidReadingHour,
			"eidReadingValue" : value.eidReadingValue,
			"override3rdPayerCode" : value.override3rdPayerCode,
			"override3rdPayerReason" : value.override3rdPayerReason,
			"transplantationCode" : value.transplantationCode,
			"prescriberNorm" : value.prescriberNorm,
			"productLabel" : value.productLabel,
			"percentNorm" : value.percentNorm,
			"prescriberNihii" : value.prescriberNihii,
			"relatedCode" : value.relatedCode,
			"prescriptionDate" : value.prescriptionDate,
			"derogationMaxNumber" : value.derogationMaxNumber,
			"prescriberSsin" : value.prescriberSsin,
			"prescriberLastName" : value.prescriberLastName,
			"prescriberFirstName" : value.prescriberFirstName,
			"prescriberCdHcParty" : value.prescriberCdHcParty,
			"locationNihii" : value.locationNihii,
			"locationCdHcParty" : value.locationCdHcParty,
			"locationService" : value.locationService,
			"admissionDate" : value.admissionDate,
			"canceled" : value.canceled,
			"accepted" : value.accepted,
			"pending" : value.pending,
			"resent" : value.resent,
			"archived" : value.archived,
			"lost" : value.lost,
			"insuranceJustification" : value.insuranceJustification,
			"cancelPatientInterventionReason" : value.cancelPatientInterventionReason,
			"status" : value.status,
			"codeLabel" : value.codeLabel,
			"options" : value.options.map((k0, v0) => MapEntry(k0, v0)),
			"encryptedSelf" : value.encryptedSelf
		};
		return entityAsMap;
	}

	static EncryptedInvoicingCode fromJSON(Map<String, dynamic> data) {
		return EncryptedInvoicingCode(
			units: (data["units"] as int?),
			side: (data["side"] as int?),
			timeOfDay: (data["timeOfDay"] as int?),
			eidReadingHour: (data["eidReadingHour"] as int?),
			override3rdPayerCode: (data["override3rdPayerCode"] as int?),
			transplantationCode: (data["transplantationCode"] as int?),
			prescriberNorm: (data["prescriberNorm"] as int?),
			percentNorm: (data["percentNorm"] as int?),
			derogationMaxNumber: (data["derogationMaxNumber"] as int?),
			locationService: (data["locationService"] as int?),
			insuranceJustification: (data["insuranceJustification"] as int?),
			cancelPatientInterventionReason: (data["cancelPatientInterventionReason"] as int?),
			id: (data["id"] as String?),
			dateCode: (data["dateCode"] as int?),
			logicalId: (data["logicalId"] as String?),
			label: (data["label"] as String?),
			userId: (data["userId"] as String?),
			contactId: (data["contactId"] as String?),
			serviceId: (data["serviceId"] as String?),
			tarificationId: (data["tarificationId"] as String?),
			code: (data["code"] as String?),
			paymentType: data["paymentType"] == null ? null : PaymentType.fromJSON(data["paymentType"]),
			paid: (data["paid"] as num?)?.toDouble(),
			totalAmount: (data["totalAmount"] as num?)?.toDouble(),
			reimbursement: (data["reimbursement"] as num?)?.toDouble(),
			patientIntervention: (data["patientIntervention"] as num?)?.toDouble(),
			amiIntervention: (data["amiIntervention"] as num?)?.toDouble(),
			doctorSupplement: (data["doctorSupplement"] as num?)?.toDouble(),
			conventionAmount: (data["conventionAmount"] as num?)?.toDouble(),
			vat: (data["vat"] as num?)?.toDouble(),
			error: (data["error"] as String?),
			contract: (data["contract"] as String?),
			contractDate: (data["contractDate"] as int?),
			eidReadingValue: (data["eidReadingValue"] as String?),
			override3rdPayerReason: (data["override3rdPayerReason"] as String?),
			productLabel: (data["productLabel"] as String?),
			prescriberNihii: (data["prescriberNihii"] as String?),
			relatedCode: (data["relatedCode"] as String?),
			prescriptionDate: (data["prescriptionDate"] as int?),
			prescriberSsin: (data["prescriberSsin"] as String?),
			prescriberLastName: (data["prescriberLastName"] as String?),
			prescriberFirstName: (data["prescriberFirstName"] as String?),
			prescriberCdHcParty: (data["prescriberCdHcParty"] as String?),
			locationNihii: (data["locationNihii"] as String?),
			locationCdHcParty: (data["locationCdHcParty"] as String?),
			admissionDate: (data["admissionDate"] as int?),
			canceled: (data["canceled"] as bool?),
			accepted: (data["accepted"] as bool?),
			pending: (data["pending"] as bool?),
			resent: (data["resent"] as bool?),
			archived: (data["archived"] as bool?),
			lost: (data["lost"] as bool?),
			status: (data["status"] as int?),
			codeLabel: (data["codeLabel"] as String?),
			options: (data["options"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as String))),
			encryptedSelf: (data["encryptedSelf"] as Base64String?)
		);
	}
}