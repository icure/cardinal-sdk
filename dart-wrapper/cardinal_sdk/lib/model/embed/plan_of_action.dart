// auto-generated file
import 'package:cardinal_sdk/model/base/code_stub.dart';
import 'package:cardinal_sdk/annotations/actual_int32.dart';
import 'package:cardinal_sdk/model/embed/care_team_membership.dart';
import 'package:cardinal_sdk/model/specializations/base64string.dart';
import 'package:cardinal_sdk/model/embed/plan_of_action.dart';
import 'package:cardinal_sdk/model/embed/encryptable.dart';
import 'package:cardinal_sdk/model/base/icure_document.dart';
import 'package:cardinal_sdk/model/base/named.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
part "plan_of_action.freezed.dart";


sealed class PlanOfAction implements Encryptable, ICureDocument<String>, Named {
	@override abstract final String id;
	@override abstract final int? created;
	@override abstract final int? modified;
	@override abstract final String? author;
	@override abstract final String? responsible;
	@override abstract final String? medicalLocationId;
	@override abstract final Set<CodeStub> tags;
	@override abstract final Set<CodeStub> codes;
	@override abstract final int? endOfLife;
	abstract final String? prescriberId;
	abstract final int? valueDate;
	abstract final int? openingDate;
	abstract final int? closingDate;
	abstract final int? deadlineDate;
	@override abstract final String? name;
	abstract final String? descr;
	abstract final String? note;
	abstract final String? idOpeningContact;
	abstract final String? idClosingContact;
	@actualInt32 abstract final int status;
	abstract final Set<String> documentIds;
	@actualInt32 abstract final int? numberOfCares;
	List<CareTeamMembership> get careTeamMemberships;
	abstract final bool relevant;
	@override abstract final Base64String? encryptedSelf;

	static Map<String, dynamic> encode(PlanOfAction value) {
		switch (value) {
			case EncryptedPlanOfAction entity:
				Map<String, dynamic> entityJson = EncryptedPlanOfAction.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.embed.EncryptedPlanOfAction";
				return entityJson;
			case DecryptedPlanOfAction entity:
				Map<String, dynamic> entityJson = DecryptedPlanOfAction.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.embed.DecryptedPlanOfAction";
				return entityJson;
		}
	}

	static PlanOfAction fromJSON(Map<String, dynamic> data) {
		if (data["kotlinType"] == null) {
			throw ArgumentError('Missing discriminator: kotlinType');
		}
		String discriminator = data["kotlinType"];
		switch (discriminator) {
			case "com.icure.cardinal.sdk.model.embed.EncryptedPlanOfAction":
				return EncryptedPlanOfAction.fromJSON(data);
			case "com.icure.cardinal.sdk.model.embed.DecryptedPlanOfAction":
				return DecryptedPlanOfAction.fromJSON(data);
			default:
				throw ArgumentError('Invalid subclass $discriminator');
		}
	}
}

@freezed
abstract class EncryptedPlanOfAction with _$EncryptedPlanOfAction implements PlanOfAction {
	const factory EncryptedPlanOfAction({
		required String id,
		@Default(null) int? created,
		@Default(null) int? modified,
		@Default(null) String? author,
		@Default(null) String? responsible,
		@Default(null) String? medicalLocationId,
		@Default({}) Set<CodeStub> tags,
		@Default({}) Set<CodeStub> codes,
		@Default(null) int? endOfLife,
		@Default(null) String? prescriberId,
		@Default(null) int? valueDate,
		@Default(null) int? openingDate,
		@Default(null) int? closingDate,
		@Default(null) int? deadlineDate,
		@Default(null) String? name,
		@Default(null) String? descr,
		@Default(null) String? note,
		@Default(null) String? idOpeningContact,
		@Default(null) String? idClosingContact,
		@Default(0) int status,
		@Default({}) Set<String> documentIds,
		@Default(null) int? numberOfCares,
		@Default([]) List<EncryptedCareTeamMembership> careTeamMemberships,
		@Default(true) bool relevant,
		@Default(null) Base64String? encryptedSelf,
	}) = _EncryptedPlanOfAction;


	static Map<String, dynamic> encode(EncryptedPlanOfAction value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"created" : value.created,
			"modified" : value.modified,
			"author" : value.author,
			"responsible" : value.responsible,
			"medicalLocationId" : value.medicalLocationId,
			"tags" : value.tags.map((x0) => CodeStub.encode(x0)).toList(),
			"codes" : value.codes.map((x0) => CodeStub.encode(x0)).toList(),
			"endOfLife" : value.endOfLife,
			"prescriberId" : value.prescriberId,
			"valueDate" : value.valueDate,
			"openingDate" : value.openingDate,
			"closingDate" : value.closingDate,
			"deadlineDate" : value.deadlineDate,
			"name" : value.name,
			"descr" : value.descr,
			"note" : value.note,
			"idOpeningContact" : value.idOpeningContact,
			"idClosingContact" : value.idClosingContact,
			"status" : value.status,
			"documentIds" : value.documentIds.map((x0) => x0).toList(),
			"numberOfCares" : value.numberOfCares,
			"careTeamMemberships" : value.careTeamMemberships.map((x0) => EncryptedCareTeamMembership.encode(x0)).toList(),
			"relevant" : value.relevant,
			"encryptedSelf" : value.encryptedSelf
		};
		return entityAsMap;
	}

	static EncryptedPlanOfAction fromJSON(Map<String, dynamic> data) {
		return EncryptedPlanOfAction(
			id: (data["id"] as String),
			status: (data["status"] as int),
			numberOfCares: (data["numberOfCares"] as int?),
			created: (data["created"] as int?),
			modified: (data["modified"] as int?),
			author: (data["author"] as String?),
			responsible: (data["responsible"] as String?),
			medicalLocationId: (data["medicalLocationId"] as String?),
			tags: (data["tags"] as List<dynamic>).map((x0) => CodeStub.fromJSON(x0) ).toSet(),
			codes: (data["codes"] as List<dynamic>).map((x0) => CodeStub.fromJSON(x0) ).toSet(),
			endOfLife: (data["endOfLife"] as int?),
			prescriberId: (data["prescriberId"] as String?),
			valueDate: (data["valueDate"] as int?),
			openingDate: (data["openingDate"] as int?),
			closingDate: (data["closingDate"] as int?),
			deadlineDate: (data["deadlineDate"] as int?),
			name: (data["name"] as String?),
			descr: (data["descr"] as String?),
			note: (data["note"] as String?),
			idOpeningContact: (data["idOpeningContact"] as String?),
			idClosingContact: (data["idClosingContact"] as String?),
			documentIds: (data["documentIds"] as List<dynamic>).map((x0) => (x0 as String) ).toSet(),
			careTeamMemberships: (data["careTeamMemberships"] as List<dynamic>).map((x0) => EncryptedCareTeamMembership.fromJSON(x0) ).toList(),
			relevant: (data["relevant"] as bool),
			encryptedSelf: (data["encryptedSelf"] as Base64String?),
		);
	}
}

@freezed
abstract class DecryptedPlanOfAction with _$DecryptedPlanOfAction implements PlanOfAction {
	const factory DecryptedPlanOfAction({
		required String id,
		@Default(null) int? created,
		@Default(null) int? modified,
		@Default(null) String? author,
		@Default(null) String? responsible,
		@Default(null) String? medicalLocationId,
		@Default({}) Set<CodeStub> tags,
		@Default({}) Set<CodeStub> codes,
		@Default(null) int? endOfLife,
		@Default(null) String? prescriberId,
		@Default(null) int? valueDate,
		@Default(null) int? openingDate,
		@Default(null) int? closingDate,
		@Default(null) int? deadlineDate,
		@Default(null) String? name,
		@Default(null) String? descr,
		@Default(null) String? note,
		@Default(null) String? idOpeningContact,
		@Default(null) String? idClosingContact,
		@Default(0) int status,
		@Default({}) Set<String> documentIds,
		@Default(null) int? numberOfCares,
		@Default([]) List<DecryptedCareTeamMembership> careTeamMemberships,
		@Default(true) bool relevant,
		@Default(null) Base64String? encryptedSelf,
	}) = _DecryptedPlanOfAction;


	static Map<String, dynamic> encode(DecryptedPlanOfAction value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"created" : value.created,
			"modified" : value.modified,
			"author" : value.author,
			"responsible" : value.responsible,
			"medicalLocationId" : value.medicalLocationId,
			"tags" : value.tags.map((x0) => CodeStub.encode(x0)).toList(),
			"codes" : value.codes.map((x0) => CodeStub.encode(x0)).toList(),
			"endOfLife" : value.endOfLife,
			"prescriberId" : value.prescriberId,
			"valueDate" : value.valueDate,
			"openingDate" : value.openingDate,
			"closingDate" : value.closingDate,
			"deadlineDate" : value.deadlineDate,
			"name" : value.name,
			"descr" : value.descr,
			"note" : value.note,
			"idOpeningContact" : value.idOpeningContact,
			"idClosingContact" : value.idClosingContact,
			"status" : value.status,
			"documentIds" : value.documentIds.map((x0) => x0).toList(),
			"numberOfCares" : value.numberOfCares,
			"careTeamMemberships" : value.careTeamMemberships.map((x0) => DecryptedCareTeamMembership.encode(x0)).toList(),
			"relevant" : value.relevant,
			"encryptedSelf" : value.encryptedSelf
		};
		return entityAsMap;
	}

	static DecryptedPlanOfAction fromJSON(Map<String, dynamic> data) {
		return DecryptedPlanOfAction(
			id: (data["id"] as String),
			status: (data["status"] as int),
			numberOfCares: (data["numberOfCares"] as int?),
			created: (data["created"] as int?),
			modified: (data["modified"] as int?),
			author: (data["author"] as String?),
			responsible: (data["responsible"] as String?),
			medicalLocationId: (data["medicalLocationId"] as String?),
			tags: (data["tags"] as List<dynamic>).map((x0) => CodeStub.fromJSON(x0) ).toSet(),
			codes: (data["codes"] as List<dynamic>).map((x0) => CodeStub.fromJSON(x0) ).toSet(),
			endOfLife: (data["endOfLife"] as int?),
			prescriberId: (data["prescriberId"] as String?),
			valueDate: (data["valueDate"] as int?),
			openingDate: (data["openingDate"] as int?),
			closingDate: (data["closingDate"] as int?),
			deadlineDate: (data["deadlineDate"] as int?),
			name: (data["name"] as String?),
			descr: (data["descr"] as String?),
			note: (data["note"] as String?),
			idOpeningContact: (data["idOpeningContact"] as String?),
			idClosingContact: (data["idClosingContact"] as String?),
			documentIds: (data["documentIds"] as List<dynamic>).map((x0) => (x0 as String) ).toSet(),
			careTeamMemberships: (data["careTeamMemberships"] as List<dynamic>).map((x0) => DecryptedCareTeamMembership.fromJSON(x0) ).toList(),
			relevant: (data["relevant"] as bool),
			encryptedSelf: (data["encryptedSelf"] as Base64String?),
		);
	}
}