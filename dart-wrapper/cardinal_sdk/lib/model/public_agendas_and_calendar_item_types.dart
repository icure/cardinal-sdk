// auto-generated file
import 'package:cardinal_sdk/model/agenda.dart';
import 'package:cardinal_sdk/model/calendar_item_type.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
part "public_agendas_and_calendar_item_types.freezed.dart";


@freezed
abstract class PublicAgendasAndCalendarItemTypes with _$PublicAgendasAndCalendarItemTypes {
	const factory PublicAgendasAndCalendarItemTypes({
		required List<Agenda> agendas,
		required List<CalendarItemType> calendarItemTypes,
	}) = _PublicAgendasAndCalendarItemTypes;


	static Map<String, dynamic> encode(PublicAgendasAndCalendarItemTypes value) {
		Map<String, dynamic> entityAsMap = {
			"agendas" : value.agendas.map((x0) => Agenda.encode(x0)).toList(),
			"calendarItemTypes" : value.calendarItemTypes.map((x0) => CalendarItemType.encode(x0)).toList()
		};
		return entityAsMap;
	}

	static PublicAgendasAndCalendarItemTypes fromJSON(Map<String, dynamic> data) {
		return PublicAgendasAndCalendarItemTypes(
			agendas: (data["agendas"] as List<dynamic>).map((x0) => Agenda.fromJSON(x0) ).toList(),
			calendarItemTypes: (data["calendarItemTypes"] as List<dynamic>).map((x0) => CalendarItemType.fromJSON(x0) ).toList()
		);
	}
}