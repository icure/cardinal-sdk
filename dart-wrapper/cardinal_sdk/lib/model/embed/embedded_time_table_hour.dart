// auto-generated file
import 'package:freezed_annotation/freezed_annotation.dart';
part "embedded_time_table_hour.freezed.dart";


@freezed
abstract class EmbeddedTimeTableHour with _$EmbeddedTimeTableHour {
	const factory EmbeddedTimeTableHour({
		required int startHour,
		required int endHour,
	}) = _EmbeddedTimeTableHour;


	static Map<String, dynamic> encode(EmbeddedTimeTableHour value) {
		Map<String, dynamic> entityAsMap = {
			"startHour" : value.startHour,
			"endHour" : value.endHour
		};
		return entityAsMap;
	}

	static EmbeddedTimeTableHour fromJSON(Map<String, dynamic> data) {
		return EmbeddedTimeTableHour(
			startHour: (data["startHour"] as int),
			endHour: (data["endHour"] as int)
		);
	}
}