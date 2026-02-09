// auto-generated file
import 'package:cardinal_sdk/model/base/code_stub.dart';
import 'package:cardinal_sdk/model/embed/employer.dart';
import 'package:cardinal_sdk/model/specializations/base64string.dart';
import 'package:cardinal_sdk/model/embed/employment_info.dart';
import 'package:cardinal_sdk/model/embed/encryptable.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
part "employment_info.freezed.dart";


sealed class EmploymentInfo implements Encryptable {
	abstract final int? startDate;
	abstract final int? endDate;
	abstract final CodeStub? professionType;
	abstract final Employer? employer;
	@override abstract final Base64String? encryptedSelf;

	static Map<String, dynamic> encode(EmploymentInfo value) {
		switch (value) {
			case DecryptedEmploymentInfo entity:
				Map<String, dynamic> entityJson = DecryptedEmploymentInfo.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.embed.DecryptedEmploymentInfo";
				return entityJson;
			case EncryptedEmploymentInfo entity:
				Map<String, dynamic> entityJson = EncryptedEmploymentInfo.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.embed.EncryptedEmploymentInfo";
				return entityJson;
		}
	}

	static EmploymentInfo fromJSON(Map<String, dynamic> data) {
		if (data["kotlinType"] == null) {
			throw ArgumentError('Missing discriminator: kotlinType');
		}
		String discriminator = data["kotlinType"];
		switch (discriminator) {
			case "com.icure.cardinal.sdk.model.embed.DecryptedEmploymentInfo":
				return DecryptedEmploymentInfo.fromJSON(data);
			case "com.icure.cardinal.sdk.model.embed.EncryptedEmploymentInfo":
				return EncryptedEmploymentInfo.fromJSON(data);
			default:
				throw ArgumentError('Invalid subclass $discriminator');
		}
	}
}

@freezed
abstract class DecryptedEmploymentInfo with _$DecryptedEmploymentInfo implements EmploymentInfo {
	const factory DecryptedEmploymentInfo({
		@Default(null) int? startDate,
		@Default(null) int? endDate,
		@Default(null) CodeStub? professionType,
		@Default(null) Employer? employer,
		@Default(null) Base64String? encryptedSelf,
	}) = _DecryptedEmploymentInfo;


	static Map<String, dynamic> encode(DecryptedEmploymentInfo value) {
		Map<String, dynamic> entityAsMap = {
			"startDate" : value.startDate,
			"endDate" : value.endDate,
			"professionType" : value.professionType == null ? null : CodeStub.encode(value.professionType!),
			"employer" : value.employer == null ? null : Employer.encode(value.employer!),
			"encryptedSelf" : value.encryptedSelf
		};
		return entityAsMap;
	}

	static DecryptedEmploymentInfo fromJSON(Map<String, dynamic> data) {
		return DecryptedEmploymentInfo(
			startDate: (data["startDate"] as int?),
			endDate: (data["endDate"] as int?),
			professionType: data["professionType"] == null ? null : CodeStub.fromJSON(data["professionType"]),
			employer: data["employer"] == null ? null : Employer.fromJSON(data["employer"]),
			encryptedSelf: (data["encryptedSelf"] as Base64String?)
		);
	}
}

@freezed
abstract class EncryptedEmploymentInfo with _$EncryptedEmploymentInfo implements EmploymentInfo {
	const factory EncryptedEmploymentInfo({
		@Default(null) int? startDate,
		@Default(null) int? endDate,
		@Default(null) CodeStub? professionType,
		@Default(null) Employer? employer,
		@Default(null) Base64String? encryptedSelf,
	}) = _EncryptedEmploymentInfo;


	static Map<String, dynamic> encode(EncryptedEmploymentInfo value) {
		Map<String, dynamic> entityAsMap = {
			"startDate" : value.startDate,
			"endDate" : value.endDate,
			"professionType" : value.professionType == null ? null : CodeStub.encode(value.professionType!),
			"employer" : value.employer == null ? null : Employer.encode(value.employer!),
			"encryptedSelf" : value.encryptedSelf
		};
		return entityAsMap;
	}

	static EncryptedEmploymentInfo fromJSON(Map<String, dynamic> data) {
		return EncryptedEmploymentInfo(
			startDate: (data["startDate"] as int?),
			endDate: (data["endDate"] as int?),
			professionType: data["professionType"] == null ? null : CodeStub.fromJSON(data["professionType"]),
			employer: data["employer"] == null ? null : Employer.fromJSON(data["employer"]),
			encryptedSelf: (data["encryptedSelf"] as Base64String?)
		);
	}
}