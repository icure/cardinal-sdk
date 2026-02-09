// auto-generated file
import 'package:cardinal_sdk/model/property_stub.dart';
import 'package:cardinal_sdk/model/base/stored_document.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
part "calendar_item_type.freezed.dart";


@freezed
abstract class CalendarItemType with _$CalendarItemType implements StoredDocument {
	const factory CalendarItemType({
		required String id,
		@Default(null) String? rev,
		@Default(null) int? deletionDate,
		@Default(null) String? healthcarePartyId,
		@Default(null) String? agendaId,
		@Default(false) bool defaultCalendarItemType,
		@Default(null) String? name,
		@Default(null) String? color,
		@Default(0) int duration,
		@Default(null) CalendarItemTypeDurationConfig? extraDurationsConfig,
		@Default(null) String? externalRef,
		@Default(null) String? mikronoId,
		@Default({}) Set<String> docIds,
		@Default({}) Map<String, String> otherInfos,
		@Default({}) Map<String, String> subjectByLanguage,
		@Default(null) Set<DecryptedPropertyStub>? publicProperties,
	}) = _CalendarItemType;


	static Map<String, dynamic> encode(CalendarItemType value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"rev" : value.rev,
			"deletionDate" : value.deletionDate,
			"healthcarePartyId" : value.healthcarePartyId,
			"agendaId" : value.agendaId,
			"defaultCalendarItemType" : value.defaultCalendarItemType,
			"name" : value.name,
			"color" : value.color,
			"duration" : value.duration,
			"extraDurationsConfig" : value.extraDurationsConfig == null ? null : CalendarItemTypeDurationConfig.encode(value.extraDurationsConfig!),
			"externalRef" : value.externalRef,
			"mikronoId" : value.mikronoId,
			"docIds" : value.docIds.map((x0) => x0).toList(),
			"otherInfos" : value.otherInfos.map((k0, v0) => MapEntry(k0, v0)),
			"subjectByLanguage" : value.subjectByLanguage.map((k0, v0) => MapEntry(k0, v0)),
			"publicProperties" : value.publicProperties?.map((x0) => DecryptedPropertyStub.encode(x0)).toList()
		};
		return entityAsMap;
	}

	static CalendarItemType fromJSON(Map<String, dynamic> data) {
		return CalendarItemType(
			id: (data["id"] as String),
			duration: (data["duration"] as int),
			rev: (data["rev"] as String?),
			deletionDate: (data["deletionDate"] as int?),
			healthcarePartyId: (data["healthcarePartyId"] as String?),
			agendaId: (data["agendaId"] as String?),
			defaultCalendarItemType: (data["defaultCalendarItemType"] as bool),
			name: (data["name"] as String?),
			color: (data["color"] as String?),
			extraDurationsConfig: data["extraDurationsConfig"] == null ? null : CalendarItemTypeDurationConfig.fromJSON(data["extraDurationsConfig"]),
			externalRef: (data["externalRef"] as String?),
			mikronoId: (data["mikronoId"] as String?),
			docIds: (data["docIds"] as List<dynamic>).map((x0) => (x0 as String) ).toSet(),
			otherInfos: (data["otherInfos"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as String))),
			subjectByLanguage: (data["subjectByLanguage"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as String))),
			publicProperties: (data["publicProperties"] as List<dynamic>?)?.map((x0) => DecryptedPropertyStub.fromJSON(x0) ).toSet(),
		);
	}
}

sealed class CalendarItemTypeDurationConfig {

	static Map<String, dynamic> encode(CalendarItemTypeDurationConfig value) {
		switch (value) {
			case CalendarItemTypeDurationConfigSet entity:
				Map<String, dynamic> entityJson = CalendarItemTypeDurationConfigSet.encode(entity);
				entityJson["kotlinType"] = "Set";
				return entityJson;
			case CalendarItemTypeDurationConfigFormula entity:
				Map<String, dynamic> entityJson = CalendarItemTypeDurationConfigFormula.encode(entity);
				entityJson["kotlinType"] = "Formula";
				return entityJson;
		}
	}

	static CalendarItemTypeDurationConfig fromJSON(Map<String, dynamic> data) {
		if (data["kotlinType"] == null) {
			throw ArgumentError('Missing discriminator: kotlinType');
		}
		String discriminator = data["kotlinType"];
		switch (discriminator) {
			case "Set":
				return CalendarItemTypeDurationConfigSet.fromJSON(data);
			case "Formula":
				return CalendarItemTypeDurationConfigFormula.fromJSON(data);
			default:
				throw ArgumentError('Invalid subclass $discriminator');
		}
	}
}

@freezed
abstract class CalendarItemTypeDurationConfigSet with _$CalendarItemTypeDurationConfigSet implements CalendarItemTypeDurationConfig {
	const factory CalendarItemTypeDurationConfigSet({
		@Default({}) Set<int> durations,
	}) = _CalendarItemTypeDurationConfigSet;


	static Map<String, dynamic> encode(CalendarItemTypeDurationConfigSet value) {
		Map<String, dynamic> entityAsMap = {
			"durations" : value.durations.map((x0) => x0).toList()
		};
		return entityAsMap;
	}

	static CalendarItemTypeDurationConfigSet fromJSON(Map<String, dynamic> data) {
		return CalendarItemTypeDurationConfigSet(
			durations: (data["durations"] as List<dynamic>).map((x0) => (x0 as int) ).toSet()
		);
	}
}

@freezed
abstract class CalendarItemTypeDurationConfigFormula with _$CalendarItemTypeDurationConfigFormula implements CalendarItemTypeDurationConfig {
	const factory CalendarItemTypeDurationConfigFormula({
		required int min,
		required int max,
		required int step,
	}) = _CalendarItemTypeDurationConfigFormula;


	static Map<String, dynamic> encode(CalendarItemTypeDurationConfigFormula value) {
		Map<String, dynamic> entityAsMap = {
			"min" : value.min,
			"max" : value.max,
			"step" : value.step
		};
		return entityAsMap;
	}

	static CalendarItemTypeDurationConfigFormula fromJSON(Map<String, dynamic> data) {
		return CalendarItemTypeDurationConfigFormula(
			min: (data["min"] as int),
			max: (data["max"] as int),
			step: (data["step"] as int)
		);
	}
}