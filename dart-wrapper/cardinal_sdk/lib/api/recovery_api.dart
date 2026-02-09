// auto-generated file
import 'package:cardinal_sdk/crypto/entities/recovery_key_options.dart';
import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';
import 'package:cardinal_sdk/crypto/entities/recovery_data_key.dart';
import 'package:cardinal_sdk/crypto/entities/recovery_result.dart';
import 'package:cardinal_sdk/crypto/entities/cardinal_keys.dart';
import 'package:cardinal_sdk/utils/internal/cancellation_token_provider.dart';
import 'package:cardinal_sdk/utils/cancellable_future.dart';
import 'package:cardinal_sdk/crypto/entities/recovery_data_use_failure_reason.dart';
import 'package:cardinal_sdk/crypto/entities/raw_decrypted_exchange_data.dart';
import 'package:cardinal_sdk/crypto/entities/recovery_key_size.dart';


class RecoveryApi {
	final String _sdkId;
	final Object _dartSdk;
	RecoveryApi(
		this._sdkId,
		this._dartSdk
		);

	Future<RecoveryDataKey> createRecoveryInfoForAvailableKeyPairs({ bool includeParentsKeys = false, int? lifetimeSeconds, RecoveryKeyOptions? recoveryKeyOptions }) async {
		return await CardinalSdkPlatformInterface.instance.apis.recovery.createRecoveryInfoForAvailableKeyPairs(
			_sdkId,
			includeParentsKeys,
			lifetimeSeconds,
			recoveryKeyOptions,
		);
	}

	Future<RecoveryResult<Map<String, Map<CardinalRsaPublicKey, CardinalRsaPrivateKey>>>> recoverKeyPairs(RecoveryDataKey recoveryKey, bool autoDelete) async {
		return await CardinalSdkPlatformInterface.instance.apis.recovery.recoverKeyPairs(
			_sdkId,
			recoveryKey,
			autoDelete,
		);
	}

	CancellableFuture<RecoveryResult<Map<String, Map<CardinalRsaPublicKey, CardinalRsaPrivateKey>>>> recoverKeyPairsWaitingForCreation(RecoveryDataKey recoveryKey, bool autoDelete, int waitSeconds) {
		final cancellationToken = CancellationTokenProvider.getNextToken();
		return CancellableFuture.internalConstructor(
			CardinalSdkPlatformInterface.instance.apis.recovery.recoverKeyPairsWaitingForCreation(
				cancellationToken,
				_sdkId,
				recoveryKey,
				autoDelete,
				waitSeconds,
			),
			cancellationToken
		);
	}

	Future<RecoveryDataKey?> createExchangeDataRecoveryInfo(String delegateId, { int? lifetimeSeconds, RecoveryKeyOptions? recoveryKeyOptions, bool includeBiDirectional = false, bool includeAsParent = false }) async {
		return await CardinalSdkPlatformInterface.instance.apis.recovery.createExchangeDataRecoveryInfo(
			_sdkId,
			delegateId,
			lifetimeSeconds,
			recoveryKeyOptions,
			includeBiDirectional,
			includeAsParent,
		);
	}

	Future<RecoveryDataUseFailureReason?> recoverExchangeData(RecoveryDataKey recoveryKey) async {
		return await CardinalSdkPlatformInterface.instance.apis.recovery.recoverExchangeData(
			_sdkId,
			recoveryKey,
		);
	}

	Future<RecoveryResult<List<RawDecryptedExchangeData>>> getRecoveryExchangeData(RecoveryDataKey recoveryKey, bool autoDelete) async {
		return await CardinalSdkPlatformInterface.instance.apis.recovery.getRecoveryExchangeData(
			_sdkId,
			recoveryKey,
			autoDelete,
		);
	}

	Future<void> purgeRecoveryInfo(RecoveryDataKey recoveryKey) async {
		return await CardinalSdkPlatformInterface.instance.apis.recovery.purgeRecoveryInfo(
			_sdkId,
			recoveryKey,
		);
	}

	Future<int> purgeAllRecoveryInfoFor(String dataOwnerId) async {
		return await CardinalSdkPlatformInterface.instance.apis.recovery.purgeAllRecoveryInfoFor(
			_sdkId,
			dataOwnerId,
		);
	}

	Future<int> purgeAllKeyPairRecoveryInfoFor(String dataOwnerId) async {
		return await CardinalSdkPlatformInterface.instance.apis.recovery.purgeAllKeyPairRecoveryInfoFor(
			_sdkId,
			dataOwnerId,
		);
	}

	Future<int> purgeAllExchangeDataRecoveryInfoFor(String dataOwnerId) async {
		return await CardinalSdkPlatformInterface.instance.apis.recovery.purgeAllExchangeDataRecoveryInfoFor(
			_sdkId,
			dataOwnerId,
		);
	}

	Future<RecoveryDataKey> preGenerateRecoveryKey(RecoveryKeySize keySize) async {
		return await CardinalSdkPlatformInterface.instance.apis.recovery.preGenerateRecoveryKey(
			_sdkId,
			keySize,
		);
	}
}