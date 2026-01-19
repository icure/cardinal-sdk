// auto-generated file
import 'package:flutter/services.dart';
import 'package:cardinal_sdk/model/application_settings.dart';
import 'package:cardinal_sdk/utils/internal/platform_exception_convertion.dart';
import 'dart:convert';


class ApplicationSettingsPlatformApi {
	MethodChannel _methodChannel;
	ApplicationSettingsPlatformApi(this._methodChannel);

	Future<List<EncryptedApplicationSettings>> getApplicationSettings(String sdkId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ApplicationSettingsApi.getApplicationSettings',
			{
				"sdkId": sdkId,
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getApplicationSettings");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => EncryptedApplicationSettings.fromJSON(x1) ).toList();
	}

	Future<EncryptedApplicationSettings> createApplicationSettings(String sdkId, EncryptedApplicationSettings applicationSettings) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ApplicationSettingsApi.createApplicationSettings',
			{
				"sdkId": sdkId,
				"applicationSettings": jsonEncode(EncryptedApplicationSettings.encode(applicationSettings)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method createApplicationSettings");
		final parsedResJson = jsonDecode(res);
		return EncryptedApplicationSettings.fromJSON(parsedResJson);
	}

	Future<EncryptedApplicationSettings> updateApplicationSettings(String sdkId, EncryptedApplicationSettings applicationSettings) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ApplicationSettingsApi.updateApplicationSettings',
			{
				"sdkId": sdkId,
				"applicationSettings": jsonEncode(EncryptedApplicationSettings.encode(applicationSettings)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method updateApplicationSettings");
		final parsedResJson = jsonDecode(res);
		return EncryptedApplicationSettings.fromJSON(parsedResJson);
	}
}