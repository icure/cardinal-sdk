// auto-generated file
import 'package:cardinal_sdk/model/embed/embedded_time_table_hour.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
part "embedded_time_table_item.freezed.dart";


@freezed
abstract class EmbeddedTimeTableItem with _$EmbeddedTimeTableItem {
	const factory EmbeddedTimeTableItem({
		required String rrule,
		@Default(null) int? rruleStartDate,
		@Default(null) int? notBeforeInMinutes,
		@Default(null) int? notAfterInMinutes,
		required List<EmbeddedTimeTableHour> hours,
		required Set<String> calendarItemTypesIds,
		@Default(1) int availabilities,
		@Default({}) Set<String> reservingRights,
		@Default(false) bool public,
	}) = _EmbeddedTimeTableItem;


	static Map<String, dynamic> encode(EmbeddedTimeTableItem value) {
		Map<String, dynamic> entityAsMap = {
			"rrule" : value.rrule,
			"rruleStartDate" : value.rruleStartDate,
			"notBeforeInMinutes" : value.notBeforeInMinutes,
			"notAfterInMinutes" : value.notAfterInMinutes,
			"hours" : value.hours.map((x0) => EmbeddedTimeTableHour.encode(x0)).toList(),
			"calendarItemTypesIds" : value.calendarItemTypesIds.map((x0) => x0).toList(),
			"availabilities" : value.availabilities,
			"reservingRights" : value.reservingRights.map((x0) => x0).toList(),
			"public" : value.public
		};
		return entityAsMap;
	}

	static EmbeddedTimeTableItem fromJSON(Map<String, dynamic> data) {
		return EmbeddedTimeTableItem(
			rrule: (data["rrule"] as String),
			hours: (data["hours"] as List<dynamic>).map((x0) => EmbeddedTimeTableHour.fromJSON(x0) ).toList(),
			calendarItemTypesIds: (data["calendarItemTypesIds"] as List<dynamic>).map((x0) => (x0 as String) ).toSet(),
			rruleStartDate: (data["rruleStartDate"] as int?),
			notBeforeInMinutes: (data["notBeforeInMinutes"] as int?),
			notAfterInMinutes: (data["notAfterInMinutes"] as int?),
			availabilities: (data["availabilities"] as int),
			reservingRights: (data["reservingRights"] as List<dynamic>).map((x0) => (x0 as String) ).toSet(),
			public: (data["public"] as bool),
		);
	}
}