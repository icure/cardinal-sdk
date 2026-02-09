// auto-generated file
import 'package:flutter/services.dart';
import 'package:cardinal_sdk/model/healthcare_party.dart';
import 'dart:convert';
import 'package:cardinal_sdk/utils/internal/platform_exception_convertion.dart';


class AnonymousHealthcarePartyPlatformApi {
	MethodChannel _methodChannel;
	AnonymousHealthcarePartyPlatformApi(this._methodChannel);

	Future<List<HealthcareParty>> getPublicHealthcarePartiesInGroup(String sdkId, String groupId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AnonymousHealthcarePartyApi.getPublicHealthcarePartiesInGroup',
			{
				"sdkId": sdkId,
				"groupId": jsonEncode(groupId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getPublicHealthcarePartiesInGroup");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => HealthcareParty.fromJSON(x1) ).toList();
	}
}