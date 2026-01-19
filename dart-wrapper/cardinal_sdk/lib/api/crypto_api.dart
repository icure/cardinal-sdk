// auto-generated file
import 'package:cardinal_sdk/api/shamir_keys_manager_api.dart';
import 'package:cardinal_sdk/crypto/entities/entity_with_encryption_metadata_type_name.dart';
import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';
import 'package:cardinal_sdk/crypto/entities/cardinal_keys.dart';
import 'package:cardinal_sdk/crypto/entities/raw_decrypted_exchange_data.dart';
import 'package:cardinal_sdk/crypto/entities/exchange_data_injection_details.dart';
import 'package:cardinal_sdk/model/entity_reference_in_group.dart';


class CryptoApi {
	final String _sdkId;
	final Object _dartSdk;
	final ShamirKeysManagerApi shamirKeysManager;
	final CryptoInGroupApi inGroup;
	CryptoApi(
		this._sdkId,
		this._dartSdk
		) : shamirKeysManager = ShamirKeysManagerApi(_sdkId, _dartSdk),
		inGroup = CryptoInGroupApi(_sdkId, _dartSdk);

	Future<List<String>> getAccessControlKeys(EntityWithEncryptionMetadataTypeName entityType) async {
		return await CardinalSdkPlatformInterface.instance.apis.crypto.getAccessControlKeys(
			_sdkId,
			entityType,
		);
	}

	Future<void> forceReload() async {
		return await CardinalSdkPlatformInterface.instance.apis.crypto.forceReload(
			_sdkId,
		);
	}

	Future<Map<String, Map<CardinalRsaPublicKeyFingerprint, CardinalRsaPrivateKey>>> currentDataOwnerKeys({ bool filterTrustedKeys = true }) async {
		return await CardinalSdkPlatformInterface.instance.apis.crypto.currentDataOwnerKeys(
			_sdkId,
			filterTrustedKeys,
		);
	}

	Future<RawDecryptedExchangeData> keylessCreateExchangeDataTo(String delegate) async {
		return await CardinalSdkPlatformInterface.instance.apis.crypto.keylessCreateExchangeDataTo(
			_sdkId,
			delegate,
		);
	}

	Future<void> injectExchangeData(String? groupId, List<ExchangeDataInjectionDetails> details, bool reEncryptWithOwnKeys) async {
		return await CardinalSdkPlatformInterface.instance.apis.crypto.injectExchangeData(
			_sdkId,
			groupId,
			details,
			reEncryptWithOwnKeys,
		);
	}
}

class CryptoInGroupApi {
	final String _sdkId;
	final Object _dartSdk;
	CryptoInGroupApi(
		this._sdkId,
		this._dartSdk
		);

	Future<RawDecryptedExchangeData> keylessCreateExchangeDataTo(String? groupId, EntityReferenceInGroup delegate) async {
		return await CardinalSdkPlatformInterface.instance.apis.crypto.inGroup.keylessCreateExchangeDataTo(
			_sdkId,
			groupId,
			delegate,
		);
	}

	Future<List<String>> getAccessControlKeys(String? groupId, EntityWithEncryptionMetadataTypeName entityType) async {
		return await CardinalSdkPlatformInterface.instance.apis.crypto.inGroup.getAccessControlKeys(
			_sdkId,
			groupId,
			entityType,
		);
	}
}