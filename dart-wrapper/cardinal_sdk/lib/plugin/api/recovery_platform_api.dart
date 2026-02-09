// auto-generated file
import 'package:flutter/services.dart';
import 'package:cardinal_sdk/crypto/entities/recovery_key_options.dart';
import 'package:cardinal_sdk/crypto/entities/recovery_data_key.dart';
import 'dart:convert';
import 'package:cardinal_sdk/utils/internal/platform_exception_convertion.dart';
import 'package:cardinal_sdk/crypto/entities/recovery_result.dart';
import 'package:cardinal_sdk/crypto/entities/cardinal_keys.dart';
import 'package:cardinal_sdk/crypto/entities/recovery_data_use_failure_reason.dart';
import 'package:cardinal_sdk/crypto/entities/raw_decrypted_exchange_data.dart';
import 'package:cardinal_sdk/crypto/entities/recovery_key_size.dart';


class RecoveryPlatformApi {
	MethodChannel _methodChannel;
	RecoveryPlatformApi(this._methodChannel);

	Future<RecoveryDataKey> createRecoveryInfoForAvailableKeyPairs(String sdkId, bool includeParentsKeys, int? lifetimeSeconds, RecoveryKeyOptions? recoveryKeyOptions) async {
		final res = await _methodChannel.invokeMethod<String>(
			'RecoveryApi.createRecoveryInfoForAvailableKeyPairs',
			{
				"sdkId": sdkId,
				"includeParentsKeys": jsonEncode(includeParentsKeys),
				"lifetimeSeconds": jsonEncode(lifetimeSeconds),
				"recoveryKeyOptions": jsonEncode(recoveryKeyOptions == null ? null : RecoveryKeyOptions.encode(recoveryKeyOptions!)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method createRecoveryInfoForAvailableKeyPairs");
		final parsedResJson = jsonDecode(res);
		return RecoveryDataKey.fromJSON(parsedResJson);
	}

	Future<RecoveryResult<Map<String, Map<CardinalRsaPublicKey, CardinalRsaPrivateKey>>>> recoverKeyPairs(String sdkId, RecoveryDataKey recoveryKey, bool autoDelete) async {
		final res = await _methodChannel.invokeMethod<String>(
			'RecoveryApi.recoverKeyPairs',
			{
				"sdkId": sdkId,
				"recoveryKey": jsonEncode(RecoveryDataKey.encode(recoveryKey)),
				"autoDelete": jsonEncode(autoDelete),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method recoverKeyPairs");
		final parsedResJson = jsonDecode(res);
		return RecoveryResult.fromJSON(
			parsedResJson,
			(x1) {
				return (x1 as Map<String, dynamic>).map((k2, v2) => MapEntry((k2 as String), (v2 as Map<String, dynamic>).map((k3, v3) => MapEntry(CardinalRsaPublicKey.fromSpkiHex(k3), CardinalRsaPrivateKey.fromPkcs8Base64(v3)))));
			},
		);
	}

	Future<RecoveryResult<Map<String, Map<CardinalRsaPublicKey, CardinalRsaPrivateKey>>>> recoverKeyPairsWaitingForCreation(int cancellationToken, String sdkId, RecoveryDataKey recoveryKey, bool autoDelete, int waitSeconds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'RecoveryApi.recoverKeyPairsWaitingForCreation',
			{
				"cancellationToken": cancellationToken.toString(),
				"sdkId": sdkId,
				"recoveryKey": jsonEncode(RecoveryDataKey.encode(recoveryKey)),
				"autoDelete": jsonEncode(autoDelete),
				"waitSeconds": jsonEncode(waitSeconds),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method recoverKeyPairsWaitingForCreation");
		final parsedResJson = jsonDecode(res);
		return RecoveryResult.fromJSON(
			parsedResJson,
			(x1) {
				return (x1 as Map<String, dynamic>).map((k2, v2) => MapEntry((k2 as String), (v2 as Map<String, dynamic>).map((k3, v3) => MapEntry(CardinalRsaPublicKey.fromSpkiHex(k3), CardinalRsaPrivateKey.fromPkcs8Base64(v3)))));
			},
		);
	}

	Future<RecoveryDataKey?> createExchangeDataRecoveryInfo(String sdkId, String delegateId, int? lifetimeSeconds, RecoveryKeyOptions? recoveryKeyOptions, bool includeBiDirectional, bool includeAsParent) async {
		final res = await _methodChannel.invokeMethod<String>(
			'RecoveryApi.createExchangeDataRecoveryInfo',
			{
				"sdkId": sdkId,
				"delegateId": jsonEncode(delegateId),
				"lifetimeSeconds": jsonEncode(lifetimeSeconds),
				"recoveryKeyOptions": jsonEncode(recoveryKeyOptions == null ? null : RecoveryKeyOptions.encode(recoveryKeyOptions!)),
				"includeBiDirectional": jsonEncode(includeBiDirectional),
				"includeAsParent": jsonEncode(includeAsParent),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method createExchangeDataRecoveryInfo");
		final parsedResJson = jsonDecode(res);
		return parsedResJson == null ? null : RecoveryDataKey.fromJSON(parsedResJson);
	}

	Future<RecoveryDataUseFailureReason?> recoverExchangeData(String sdkId, RecoveryDataKey recoveryKey) async {
		final res = await _methodChannel.invokeMethod<String>(
			'RecoveryApi.recoverExchangeData',
			{
				"sdkId": sdkId,
				"recoveryKey": jsonEncode(RecoveryDataKey.encode(recoveryKey)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method recoverExchangeData");
		final parsedResJson = jsonDecode(res);
		return parsedResJson == null ? null : RecoveryDataUseFailureReason.fromJSON(parsedResJson);
	}

	Future<RecoveryResult<List<RawDecryptedExchangeData>>> getRecoveryExchangeData(String sdkId, RecoveryDataKey recoveryKey, bool autoDelete) async {
		final res = await _methodChannel.invokeMethod<String>(
			'RecoveryApi.getRecoveryExchangeData',
			{
				"sdkId": sdkId,
				"recoveryKey": jsonEncode(RecoveryDataKey.encode(recoveryKey)),
				"autoDelete": jsonEncode(autoDelete),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getRecoveryExchangeData");
		final parsedResJson = jsonDecode(res);
		return RecoveryResult.fromJSON(
			parsedResJson,
			(x1) {
				return (x1 as List<dynamic>).map((x2) => RawDecryptedExchangeData.fromJSON(x2) ).toList();
			},
		);
	}

	Future<void> purgeRecoveryInfo(String sdkId, RecoveryDataKey recoveryKey) async {
		final res = await _methodChannel.invokeMethod<String>(
			'RecoveryApi.purgeRecoveryInfo',
			{
				"sdkId": sdkId,
				"recoveryKey": jsonEncode(RecoveryDataKey.encode(recoveryKey)),
			}
		).catchError(convertPlatformException);
	}

	Future<int> purgeAllRecoveryInfoFor(String sdkId, String dataOwnerId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'RecoveryApi.purgeAllRecoveryInfoFor',
			{
				"sdkId": sdkId,
				"dataOwnerId": jsonEncode(dataOwnerId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method purgeAllRecoveryInfoFor");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as int);
	}

	Future<int> purgeAllKeyPairRecoveryInfoFor(String sdkId, String dataOwnerId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'RecoveryApi.purgeAllKeyPairRecoveryInfoFor',
			{
				"sdkId": sdkId,
				"dataOwnerId": jsonEncode(dataOwnerId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method purgeAllKeyPairRecoveryInfoFor");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as int);
	}

	Future<int> purgeAllExchangeDataRecoveryInfoFor(String sdkId, String dataOwnerId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'RecoveryApi.purgeAllExchangeDataRecoveryInfoFor',
			{
				"sdkId": sdkId,
				"dataOwnerId": jsonEncode(dataOwnerId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method purgeAllExchangeDataRecoveryInfoFor");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as int);
	}

	Future<RecoveryDataKey> preGenerateRecoveryKey(String sdkId, RecoveryKeySize keySize) async {
		final res = await _methodChannel.invokeMethod<String>(
			'RecoveryApi.preGenerateRecoveryKey',
			{
				"sdkId": sdkId,
				"keySize": jsonEncode(RecoveryKeySize.encode(keySize)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method preGenerateRecoveryKey");
		final parsedResJson = jsonDecode(res);
		return RecoveryDataKey.fromJSON(parsedResJson);
	}
}