// auto-generated file
import 'package:cardinal_sdk/model/base/code_stub.dart';
import 'package:cardinal_sdk/model/specializations/base64string.dart';
import 'package:cardinal_sdk/model/embed/schooling_info.dart';
import 'package:cardinal_sdk/model/embed/encryptable.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
part "schooling_info.freezed.dart";


sealed class SchoolingInfo implements Encryptable {
	abstract final int? startDate;
	abstract final int? endDate;
	abstract final String? school;
	abstract final CodeStub? typeOfEducation;
	@override abstract final Base64String? encryptedSelf;

	static Map<String, dynamic> encode(SchoolingInfo value) {
		switch (value) {
			case EncryptedSchoolingInfo entity:
				Map<String, dynamic> entityJson = EncryptedSchoolingInfo.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.embed.EncryptedSchoolingInfo";
				return entityJson;
			case DecryptedSchoolingInfo entity:
				Map<String, dynamic> entityJson = DecryptedSchoolingInfo.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.embed.DecryptedSchoolingInfo";
				return entityJson;
		}
	}

	static SchoolingInfo fromJSON(Map<String, dynamic> data) {
		if (data["kotlinType"] == null) {
			throw ArgumentError('Missing discriminator: kotlinType');
		}
		String discriminator = data["kotlinType"];
		switch (discriminator) {
			case "com.icure.cardinal.sdk.model.embed.EncryptedSchoolingInfo":
				return EncryptedSchoolingInfo.fromJSON(data);
			case "com.icure.cardinal.sdk.model.embed.DecryptedSchoolingInfo":
				return DecryptedSchoolingInfo.fromJSON(data);
			default:
				throw ArgumentError('Invalid subclass $discriminator');
		}
	}
}

@freezed
abstract class EncryptedSchoolingInfo with _$EncryptedSchoolingInfo implements SchoolingInfo {
	const factory EncryptedSchoolingInfo({
		@Default(null) int? startDate,
		@Default(null) int? endDate,
		@Default(null) String? school,
		@Default(null) CodeStub? typeOfEducation,
		@Default(null) Base64String? encryptedSelf,
	}) = _EncryptedSchoolingInfo;


	static Map<String, dynamic> encode(EncryptedSchoolingInfo value) {
		Map<String, dynamic> entityAsMap = {
			"startDate" : value.startDate,
			"endDate" : value.endDate,
			"school" : value.school,
			"typeOfEducation" : value.typeOfEducation == null ? null : CodeStub.encode(value.typeOfEducation!),
			"encryptedSelf" : value.encryptedSelf
		};
		return entityAsMap;
	}

	static EncryptedSchoolingInfo fromJSON(Map<String, dynamic> data) {
		return EncryptedSchoolingInfo(
			startDate: (data["startDate"] as int?),
			endDate: (data["endDate"] as int?),
			school: (data["school"] as String?),
			typeOfEducation: data["typeOfEducation"] == null ? null : CodeStub.fromJSON(data["typeOfEducation"]),
			encryptedSelf: (data["encryptedSelf"] as Base64String?)
		);
	}
}

@freezed
abstract class DecryptedSchoolingInfo with _$DecryptedSchoolingInfo implements SchoolingInfo {
	const factory DecryptedSchoolingInfo({
		@Default(null) int? startDate,
		@Default(null) int? endDate,
		@Default(null) String? school,
		@Default(null) CodeStub? typeOfEducation,
		@Default(null) Base64String? encryptedSelf,
	}) = _DecryptedSchoolingInfo;


	static Map<String, dynamic> encode(DecryptedSchoolingInfo value) {
		Map<String, dynamic> entityAsMap = {
			"startDate" : value.startDate,
			"endDate" : value.endDate,
			"school" : value.school,
			"typeOfEducation" : value.typeOfEducation == null ? null : CodeStub.encode(value.typeOfEducation!),
			"encryptedSelf" : value.encryptedSelf
		};
		return entityAsMap;
	}

	static DecryptedSchoolingInfo fromJSON(Map<String, dynamic> data) {
		return DecryptedSchoolingInfo(
			startDate: (data["startDate"] as int?),
			endDate: (data["endDate"] as int?),
			school: (data["school"] as String?),
			typeOfEducation: data["typeOfEducation"] == null ? null : CodeStub.fromJSON(data["typeOfEducation"]),
			encryptedSelf: (data["encryptedSelf"] as Base64String?)
		);
	}
}