// auto-generated file
import 'package:flutter/services.dart';
import 'package:cardinal_sdk/crypto/entities/entity_with_encryption_metadata_type_name.dart';
import 'dart:convert';
import 'package:cardinal_sdk/utils/internal/platform_exception_convertion.dart';
import 'package:cardinal_sdk/crypto/entities/cardinal_keys.dart';
import 'package:cardinal_sdk/crypto/entities/raw_decrypted_exchange_data.dart';
import 'package:cardinal_sdk/crypto/entities/exchange_data_injection_details.dart';
import 'package:cardinal_sdk/model/entity_reference_in_group.dart';


class CryptoPlatformApi {
	MethodChannel _methodChannel;
	CryptoInGroupPlatformApi inGroup;
	CryptoPlatformApi(
		this._methodChannel
		) : inGroup = CryptoInGroupPlatformApi(_methodChannel);

	Future<List<String>> getAccessControlKeys(String sdkId, EntityWithEncryptionMetadataTypeName entityType) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CryptoApi.getAccessControlKeys',
			{
				"sdkId": sdkId,
				"entityType": jsonEncode(EntityWithEncryptionMetadataTypeName.encode(entityType)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getAccessControlKeys");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => (x1 as String) ).toList();
	}

	Future<void> forceReload(String sdkId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CryptoApi.forceReload',
			{
				"sdkId": sdkId,
			}
		).catchError(convertPlatformException);
	}

	Future<Map<String, Map<CardinalRsaPublicKeyFingerprint, CardinalRsaPrivateKey>>> currentDataOwnerKeys(String sdkId, bool filterTrustedKeys) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CryptoApi.currentDataOwnerKeys',
			{
				"sdkId": sdkId,
				"filterTrustedKeys": jsonEncode(filterTrustedKeys),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method currentDataOwnerKeys");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as Map<String, dynamic>).map((k1, v1) => MapEntry((k1 as String), (v1 as Map<String, dynamic>).map((k2, v2) => MapEntry(CardinalRsaPublicKeyFingerprint(k2), (v2 as CardinalRsaPrivateKey)))));
	}

	Future<RawDecryptedExchangeData> keylessCreateExchangeDataTo(String sdkId, String delegate) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CryptoApi.keylessCreateExchangeDataTo',
			{
				"sdkId": sdkId,
				"delegate": jsonEncode(delegate),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method keylessCreateExchangeDataTo");
		final parsedResJson = jsonDecode(res);
		return RawDecryptedExchangeData.fromJSON(parsedResJson);
	}

	Future<void> injectExchangeData(String sdkId, String? groupId, List<ExchangeDataInjectionDetails> details, bool reEncryptWithOwnKeys) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CryptoApi.injectExchangeData',
			{
				"sdkId": sdkId,
				"groupId": jsonEncode(groupId),
				"details": jsonEncode(details.map((x0) => ExchangeDataInjectionDetails.encode(x0)).toList()),
				"reEncryptWithOwnKeys": jsonEncode(reEncryptWithOwnKeys),
			}
		).catchError(convertPlatformException);
	}
}

class CryptoInGroupPlatformApi {
	MethodChannel _methodChannel;
	CryptoInGroupPlatformApi(this._methodChannel);

	Future<RawDecryptedExchangeData> keylessCreateExchangeDataTo(String sdkId, String? groupId, EntityReferenceInGroup delegate) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CryptoApi.inGroup.keylessCreateExchangeDataTo',
			{
				"sdkId": sdkId,
				"groupId": jsonEncode(groupId),
				"delegate": jsonEncode(EntityReferenceInGroup.encode(delegate)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method keylessCreateExchangeDataTo");
		final parsedResJson = jsonDecode(res);
		return RawDecryptedExchangeData.fromJSON(parsedResJson);
	}

	Future<List<String>> getAccessControlKeys(String sdkId, String? groupId, EntityWithEncryptionMetadataTypeName entityType) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CryptoApi.inGroup.getAccessControlKeys',
			{
				"sdkId": sdkId,
				"groupId": jsonEncode(groupId),
				"entityType": jsonEncode(EntityWithEncryptionMetadataTypeName.encode(entityType)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getAccessControlKeys");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => (x1 as String) ).toList();
	}
}