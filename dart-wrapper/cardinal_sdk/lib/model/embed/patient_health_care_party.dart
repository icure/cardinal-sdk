// auto-generated file
import 'package:cardinal_sdk/model/embed/patient_health_care_party_type.dart';
import 'package:cardinal_sdk/model/embed/telecom_type.dart';
import 'package:cardinal_sdk/model/embed/referral_period.dart';
import 'package:cardinal_sdk/model/property_stub.dart';
import 'package:cardinal_sdk/model/specializations/base64string.dart';
import 'package:cardinal_sdk/model/embed/patient_health_care_party.dart';
import 'package:cardinal_sdk/model/embed/encryptable.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
part "patient_health_care_party.freezed.dart";


sealed class PatientHealthCareParty implements Encryptable {
	abstract final PatientHealthCarePartyType? type;
	abstract final String? healthcarePartyId;
	abstract final Map<TelecomType, String> sendFormats;
	abstract final List<ReferralPeriod> referralPeriods;
	abstract final bool referral;
	Set<PropertyStub>? get properties;
	@override abstract final Base64String? encryptedSelf;

	static Map<String, dynamic> encode(PatientHealthCareParty value) {
		switch (value) {
			case EncryptedPatientHealthCareParty entity:
				Map<String, dynamic> entityJson = EncryptedPatientHealthCareParty.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.embed.EncryptedPatientHealthCareParty";
				return entityJson;
			case DecryptedPatientHealthCareParty entity:
				Map<String, dynamic> entityJson = DecryptedPatientHealthCareParty.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.embed.DecryptedPatientHealthCareParty";
				return entityJson;
		}
	}

	static PatientHealthCareParty fromJSON(Map<String, dynamic> data) {
		if (data["kotlinType"] == null) {
			throw ArgumentError('Missing discriminator: kotlinType');
		}
		String discriminator = data["kotlinType"];
		switch (discriminator) {
			case "com.icure.cardinal.sdk.model.embed.EncryptedPatientHealthCareParty":
				return EncryptedPatientHealthCareParty.fromJSON(data);
			case "com.icure.cardinal.sdk.model.embed.DecryptedPatientHealthCareParty":
				return DecryptedPatientHealthCareParty.fromJSON(data);
			default:
				throw ArgumentError('Invalid subclass $discriminator');
		}
	}
}

@freezed
abstract class EncryptedPatientHealthCareParty with _$EncryptedPatientHealthCareParty implements PatientHealthCareParty {
	const factory EncryptedPatientHealthCareParty({
		@Default(null) PatientHealthCarePartyType? type,
		@Default(null) String? healthcarePartyId,
		@Default({}) Map<TelecomType, String> sendFormats,
		@Default([]) List<ReferralPeriod> referralPeriods,
		@Default(false) bool referral,
		@Default(null) Set<EncryptedPropertyStub>? properties,
		@Default(null) Base64String? encryptedSelf,
	}) = _EncryptedPatientHealthCareParty;


	static Map<String, dynamic> encode(EncryptedPatientHealthCareParty value) {
		Map<String, dynamic> entityAsMap = {
			"type" : value.type == null ? null : PatientHealthCarePartyType.encode(value.type!),
			"healthcarePartyId" : value.healthcarePartyId,
			"sendFormats" : value.sendFormats.map((k0, v0) => MapEntry(TelecomType.encode(k0), v0)),
			"referralPeriods" : value.referralPeriods.map((x0) => ReferralPeriod.encode(x0)).toList(),
			"referral" : value.referral,
			"properties" : value.properties?.map((x0) => EncryptedPropertyStub.encode(x0)).toList(),
			"encryptedSelf" : value.encryptedSelf
		};
		return entityAsMap;
	}

	static EncryptedPatientHealthCareParty fromJSON(Map<String, dynamic> data) {
		return EncryptedPatientHealthCareParty(
			type: data["type"] == null ? null : PatientHealthCarePartyType.fromJSON(data["type"]),
			healthcarePartyId: (data["healthcarePartyId"] as String?),
			sendFormats: (data["sendFormats"] as Map<String, dynamic>).map((k0, v0) => MapEntry(TelecomType.fromJSON(k0), (v0 as String))),
			referralPeriods: (data["referralPeriods"] as List<dynamic>).map((x0) => ReferralPeriod.fromJSON(x0) ).toList(),
			referral: (data["referral"] as bool),
			properties: (data["properties"] as List<dynamic>?)?.map((x0) => EncryptedPropertyStub.fromJSON(x0) ).toSet(),
			encryptedSelf: (data["encryptedSelf"] as Base64String?)
		);
	}
}

@freezed
abstract class DecryptedPatientHealthCareParty with _$DecryptedPatientHealthCareParty implements PatientHealthCareParty {
	const factory DecryptedPatientHealthCareParty({
		@Default(null) PatientHealthCarePartyType? type,
		@Default(null) String? healthcarePartyId,
		@Default({}) Map<TelecomType, String> sendFormats,
		@Default([]) List<ReferralPeriod> referralPeriods,
		@Default(false) bool referral,
		@Default(null) Set<DecryptedPropertyStub>? properties,
		@Default(null) Base64String? encryptedSelf,
	}) = _DecryptedPatientHealthCareParty;


	static Map<String, dynamic> encode(DecryptedPatientHealthCareParty value) {
		Map<String, dynamic> entityAsMap = {
			"type" : value.type == null ? null : PatientHealthCarePartyType.encode(value.type!),
			"healthcarePartyId" : value.healthcarePartyId,
			"sendFormats" : value.sendFormats.map((k0, v0) => MapEntry(TelecomType.encode(k0), v0)),
			"referralPeriods" : value.referralPeriods.map((x0) => ReferralPeriod.encode(x0)).toList(),
			"referral" : value.referral,
			"properties" : value.properties?.map((x0) => DecryptedPropertyStub.encode(x0)).toList(),
			"encryptedSelf" : value.encryptedSelf
		};
		return entityAsMap;
	}

	static DecryptedPatientHealthCareParty fromJSON(Map<String, dynamic> data) {
		return DecryptedPatientHealthCareParty(
			type: data["type"] == null ? null : PatientHealthCarePartyType.fromJSON(data["type"]),
			healthcarePartyId: (data["healthcarePartyId"] as String?),
			sendFormats: (data["sendFormats"] as Map<String, dynamic>).map((k0, v0) => MapEntry(TelecomType.fromJSON(k0), (v0 as String))),
			referralPeriods: (data["referralPeriods"] as List<dynamic>).map((x0) => ReferralPeriod.fromJSON(x0) ).toList(),
			referral: (data["referral"] as bool),
			properties: (data["properties"] as List<dynamic>?)?.map((x0) => DecryptedPropertyStub.fromJSON(x0) ).toSet(),
			encryptedSelf: (data["encryptedSelf"] as Base64String?)
		);
	}
}