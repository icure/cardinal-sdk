// auto-generated file
import 'package:cardinal_sdk/model/base/code_stub.dart';
import 'package:cardinal_sdk/model/embed/right.dart';
import 'package:cardinal_sdk/model/embed/user_access_level.dart';
import 'package:cardinal_sdk/model/embed/agenda_slotting_algorithm.dart';
import 'package:cardinal_sdk/model/property_stub.dart';
import 'package:cardinal_sdk/model/embed/resource_group_allocation_schedule.dart';
import 'package:cardinal_sdk/model/base/stored_document.dart';
import 'package:cardinal_sdk/model/base/icure_document.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
part "agenda.freezed.dart";


@freezed
abstract class Agenda with _$Agenda implements StoredDocument, ICureDocument<String> {
	const factory Agenda({
		required String id,
		@Default(null) String? rev,
		@Default(null) int? created,
		@Default(null) int? modified,
		@Default(null) String? author,
		@Default(null) String? responsible,
		@Default(null) String? medicalLocationId,
		@Default({}) Set<CodeStub> tags,
		@Default({}) Set<CodeStub> codes,
		@Default(null) int? endOfLife,
		@Default(null) int? deletionDate,
		@Default(null) int? daySplitHour,
		@Default(false) bool unpublished,
		@Default(null) String? name,
		@Default(null) String? userId,
		@Default(null) String? zoneId,
		@Default([]) List<Right> rights,
		@Default({}) Map<String, UserAccessLevel> userRights,
		@Default(null) AgendaSlottingAlgorithm? slottingAlgorithm,
		@Default(null) int? publicBookingQuota,
		@Default({}) Set<DecryptedPropertyStub> properties,
		@Default([]) List<ResourceGroupAllocationSchedule> schedules,
	}) = _Agenda;


	static Map<String, dynamic> encode(Agenda value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"rev" : value.rev,
			"created" : value.created,
			"modified" : value.modified,
			"author" : value.author,
			"responsible" : value.responsible,
			"medicalLocationId" : value.medicalLocationId,
			"tags" : value.tags.map((x0) => CodeStub.encode(x0)).toList(),
			"codes" : value.codes.map((x0) => CodeStub.encode(x0)).toList(),
			"endOfLife" : value.endOfLife,
			"deletionDate" : value.deletionDate,
			"daySplitHour" : value.daySplitHour,
			"unpublished" : value.unpublished,
			"name" : value.name,
			"userId" : value.userId,
			"zoneId" : value.zoneId,
			"rights" : value.rights.map((x0) => Right.encode(x0)).toList(),
			"userRights" : value.userRights.map((k0, v0) => MapEntry(k0, UserAccessLevel.encode(v0))),
			"slottingAlgorithm" : value.slottingAlgorithm == null ? null : AgendaSlottingAlgorithm.encode(value.slottingAlgorithm!),
			"publicBookingQuota" : value.publicBookingQuota,
			"properties" : value.properties.map((x0) => DecryptedPropertyStub.encode(x0)).toList(),
			"schedules" : value.schedules.map((x0) => ResourceGroupAllocationSchedule.encode(x0)).toList()
		};
		return entityAsMap;
	}

	static Agenda fromJSON(Map<String, dynamic> data) {
		return Agenda(
			id: (data["id"] as String),
			daySplitHour: (data["daySplitHour"] as int?),
			publicBookingQuota: (data["publicBookingQuota"] as int?),
			rev: (data["rev"] as String?),
			created: (data["created"] as int?),
			modified: (data["modified"] as int?),
			author: (data["author"] as String?),
			responsible: (data["responsible"] as String?),
			medicalLocationId: (data["medicalLocationId"] as String?),
			tags: (data["tags"] as List<dynamic>).map((x0) => CodeStub.fromJSON(x0) ).toSet(),
			codes: (data["codes"] as List<dynamic>).map((x0) => CodeStub.fromJSON(x0) ).toSet(),
			endOfLife: (data["endOfLife"] as int?),
			deletionDate: (data["deletionDate"] as int?),
			unpublished: (data["unpublished"] as bool),
			name: (data["name"] as String?),
			userId: (data["userId"] as String?),
			zoneId: (data["zoneId"] as String?),
			rights: (data["rights"] as List<dynamic>).map((x0) => Right.fromJSON(x0) ).toList(),
			userRights: (data["userRights"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), UserAccessLevel.fromJSON(v0))),
			slottingAlgorithm: data["slottingAlgorithm"] == null ? null : AgendaSlottingAlgorithm.fromJSON(data["slottingAlgorithm"]),
			properties: (data["properties"] as List<dynamic>).map((x0) => DecryptedPropertyStub.fromJSON(x0) ).toSet(),
			schedules: (data["schedules"] as List<dynamic>).map((x0) => ResourceGroupAllocationSchedule.fromJSON(x0) ).toList(),
		);
	}
}