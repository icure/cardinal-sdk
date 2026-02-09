// auto-generated file
import 'package:flutter/services.dart';
import 'package:cardinal_sdk/model/public_agendas_and_calendar_item_types.dart';
import 'dart:convert';
import 'package:cardinal_sdk/utils/internal/platform_exception_convertion.dart';


class AnonymousAgendaPlatformApi {
	MethodChannel _methodChannel;
	AnonymousAgendaPlatformApi(this._methodChannel);

	Future<PublicAgendasAndCalendarItemTypes> listAnonymousAgendaAndAppointmentTypes(String sdkId, String groupId, String propertyId, String propertyValue) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AnonymousAgendaApi.listAnonymousAgendaAndAppointmentTypes',
			{
				"sdkId": sdkId,
				"groupId": jsonEncode(groupId),
				"propertyId": jsonEncode(propertyId),
				"propertyValue": jsonEncode(propertyValue),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method listAnonymousAgendaAndAppointmentTypes");
		final parsedResJson = jsonDecode(res);
		return PublicAgendasAndCalendarItemTypes.fromJSON(parsedResJson);
	}

	Future<List<int>> listAnonymousAvailabilities(String sdkId, String groupId, String agendaId, String calendarItemTypeId, int startDate, int endDate, int? limit) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AnonymousAgendaApi.listAnonymousAvailabilities',
			{
				"sdkId": sdkId,
				"groupId": jsonEncode(groupId),
				"agendaId": jsonEncode(agendaId),
				"calendarItemTypeId": jsonEncode(calendarItemTypeId),
				"startDate": jsonEncode(startDate),
				"endDate": jsonEncode(endDate),
				"limit": jsonEncode(limit),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method listAnonymousAvailabilities");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => (x1 as int) ).toList();
	}
}