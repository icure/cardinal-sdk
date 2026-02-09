// auto-generated file
import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';
import 'package:cardinal_sdk/model/application_settings.dart';


class ApplicationSettingsApi {
	final String _sdkId;
	final Object _dartSdk;
	ApplicationSettingsApi(
		this._sdkId,
		this._dartSdk
		);

	Future<List<EncryptedApplicationSettings>> getApplicationSettings() async {
		return await CardinalSdkPlatformInterface.instance.apis.applicationSettings.getApplicationSettings(
			_sdkId,
		);
	}

	Future<EncryptedApplicationSettings> createApplicationSettings(EncryptedApplicationSettings applicationSettings) async {
		return await CardinalSdkPlatformInterface.instance.apis.applicationSettings.createApplicationSettings(
			_sdkId,
			applicationSettings,
		);
	}

	Future<EncryptedApplicationSettings> updateApplicationSettings(EncryptedApplicationSettings applicationSettings) async {
		return await CardinalSdkPlatformInterface.instance.apis.applicationSettings.updateApplicationSettings(
			_sdkId,
			applicationSettings,
		);
	}
}