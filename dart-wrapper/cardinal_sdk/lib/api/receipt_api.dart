// auto-generated file
import 'package:cardinal_sdk/model/receipt.dart';
import 'package:cardinal_sdk/model/patient.dart';
import 'package:cardinal_sdk/model/user.dart';
import 'package:cardinal_sdk/model/embed/access_level.dart';
import 'package:cardinal_sdk/crypto/entities/secret_id_use_option.dart';
import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';
import 'dart:typed_data';
import 'package:cardinal_sdk/model/specializations/hex_string.dart';
import 'package:cardinal_sdk/model/couchdb/doc_identifier.dart';
import 'package:cardinal_sdk/crypto/entities/receipt_share_options.dart';


class ReceiptApi {
	final String _sdkId;
	final Object _dartSdk;
	final ReceiptEncryptedApi encrypted;
	final ReceiptTryAndRecoverApi tryAndRecover;
	ReceiptApi(
		this._sdkId,
		this._dartSdk
		) : encrypted = ReceiptEncryptedApi(_sdkId, _dartSdk),
		tryAndRecover = ReceiptTryAndRecoverApi(_sdkId, _dartSdk);

	Future<DecryptedReceipt> withEncryptionMetadata(DecryptedReceipt? base, Patient? patient, { User? user, Map<String, AccessLevel> delegates = const {}, SecretIdUseOption secretId = SecretIdUseOption.UseAnySharedWithParent, String? alternateRootDelegateId }) async {
		return await CardinalSdkPlatformInterface.instance.apis.receipt.withEncryptionMetadata(
			_sdkId,
			base,
			patient,
			user,
			delegates,
			secretId,
			alternateRootDelegateId,
		);
	}

	Future<Uint8List> getAndDecryptReceiptAttachment(Receipt receipt, String attachmentId) async {
		return await CardinalSdkPlatformInterface.instance.apis.receipt.getAndDecryptReceiptAttachment(
			_sdkId,
			receipt,
			attachmentId,
		);
	}

	Future<EncryptedReceipt> encryptAndSetReceiptAttachment(Receipt receipt, String blobType, Uint8List attachment) async {
		return await CardinalSdkPlatformInterface.instance.apis.receipt.encryptAndSetReceiptAttachment(
			_sdkId,
			receipt,
			blobType,
			attachment,
		);
	}

	Future<Set<HexString>> getEncryptionKeysOf(Receipt receipt) async {
		return await CardinalSdkPlatformInterface.instance.apis.receipt.getEncryptionKeysOf(
			_sdkId,
			receipt,
		);
	}

	Future<bool> hasWriteAccess(Receipt receipt) async {
		return await CardinalSdkPlatformInterface.instance.apis.receipt.hasWriteAccess(
			_sdkId,
			receipt,
		);
	}

	Future<Set<String>> decryptPatientIdOf(Receipt receipt) async {
		return await CardinalSdkPlatformInterface.instance.apis.receipt.decryptPatientIdOf(
			_sdkId,
			receipt,
		);
	}

	Future<void> createDelegationDeAnonymizationMetadata(Receipt entity, Set<String> delegates) async {
		return await CardinalSdkPlatformInterface.instance.apis.receipt.createDelegationDeAnonymizationMetadata(
			_sdkId,
			entity,
			delegates,
		);
	}

	Future<Receipt> logReceipt(User user, String docId, List<String> refs, String blobType, Uint8List blob) async {
		return await CardinalSdkPlatformInterface.instance.apis.receipt.logReceipt(
			_sdkId,
			user,
			docId,
			refs,
			blobType,
			blob,
		);
	}

	Future<DecryptedReceipt> decrypt(EncryptedReceipt receipt) async {
		return await CardinalSdkPlatformInterface.instance.apis.receipt.decrypt(
			_sdkId,
			receipt,
		);
	}

	Future<Receipt> tryDecrypt(EncryptedReceipt receipt) async {
		return await CardinalSdkPlatformInterface.instance.apis.receipt.tryDecrypt(
			_sdkId,
			receipt,
		);
	}

	Future<DocIdentifier> deleteReceipt(String entityId) async {
		return await CardinalSdkPlatformInterface.instance.apis.receipt.deleteReceipt(
			_sdkId,
			entityId,
		);
	}

	Future<List<DocIdentifier>> deleteReceipts(List<String> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.receipt.deleteReceipts(
			_sdkId,
			entityIds,
		);
	}

	Future<Uint8List> getRawReceiptAttachment(String receiptId, String attachmentId) async {
		return await CardinalSdkPlatformInterface.instance.apis.receipt.getRawReceiptAttachment(
			_sdkId,
			receiptId,
			attachmentId,
		);
	}

	Future<EncryptedReceipt> setRawReceiptAttachment(String receiptId, String rev, String blobType, Uint8List attachment) async {
		return await CardinalSdkPlatformInterface.instance.apis.receipt.setRawReceiptAttachment(
			_sdkId,
			receiptId,
			rev,
			blobType,
			attachment,
		);
	}

	Future<DecryptedReceipt> shareWith(String delegateId, DecryptedReceipt receipt, { ReceiptShareOptions? options }) async {
		return await CardinalSdkPlatformInterface.instance.apis.receipt.shareWith(
			_sdkId,
			delegateId,
			receipt,
			options,
		);
	}

	Future<DecryptedReceipt> shareWithMany(DecryptedReceipt receipt, Map<String, ReceiptShareOptions> delegates) async {
		return await CardinalSdkPlatformInterface.instance.apis.receipt.shareWithMany(
			_sdkId,
			receipt,
			delegates,
		);
	}

	Future<DecryptedReceipt> createReceipt(DecryptedReceipt entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.receipt.createReceipt(
			_sdkId,
			entity,
		);
	}

	Future<DecryptedReceipt> modifyReceipt(DecryptedReceipt entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.receipt.modifyReceipt(
			_sdkId,
			entity,
		);
	}

	Future<DecryptedReceipt?> getReceipt(String entityId) async {
		return await CardinalSdkPlatformInterface.instance.apis.receipt.getReceipt(
			_sdkId,
			entityId,
		);
	}

	Future<List<DecryptedReceipt>> listByReference(String reference) async {
		return await CardinalSdkPlatformInterface.instance.apis.receipt.listByReference(
			_sdkId,
			reference,
		);
	}
}

class ReceiptTryAndRecoverApi {
	final String _sdkId;
	final Object _dartSdk;
	ReceiptTryAndRecoverApi(
		this._sdkId,
		this._dartSdk
		);

	Future<Receipt> shareWith(String delegateId, Receipt receipt, { ReceiptShareOptions? options }) async {
		return await CardinalSdkPlatformInterface.instance.apis.receipt.tryAndRecover.shareWith(
			_sdkId,
			delegateId,
			receipt,
			options,
		);
	}

	Future<Receipt> shareWithMany(Receipt receipt, Map<String, ReceiptShareOptions> delegates) async {
		return await CardinalSdkPlatformInterface.instance.apis.receipt.tryAndRecover.shareWithMany(
			_sdkId,
			receipt,
			delegates,
		);
	}

	Future<Receipt> createReceipt(Receipt entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.receipt.tryAndRecover.createReceipt(
			_sdkId,
			entity,
		);
	}

	Future<Receipt> modifyReceipt(Receipt entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.receipt.tryAndRecover.modifyReceipt(
			_sdkId,
			entity,
		);
	}

	Future<Receipt?> getReceipt(String entityId) async {
		return await CardinalSdkPlatformInterface.instance.apis.receipt.tryAndRecover.getReceipt(
			_sdkId,
			entityId,
		);
	}

	Future<List<Receipt>> listByReference(String reference) async {
		return await CardinalSdkPlatformInterface.instance.apis.receipt.tryAndRecover.listByReference(
			_sdkId,
			reference,
		);
	}
}

class ReceiptEncryptedApi {
	final String _sdkId;
	final Object _dartSdk;
	ReceiptEncryptedApi(
		this._sdkId,
		this._dartSdk
		);

	Future<EncryptedReceipt> shareWith(String delegateId, EncryptedReceipt receipt, { ReceiptShareOptions? options }) async {
		return await CardinalSdkPlatformInterface.instance.apis.receipt.encrypted.shareWith(
			_sdkId,
			delegateId,
			receipt,
			options,
		);
	}

	Future<EncryptedReceipt> shareWithMany(EncryptedReceipt receipt, Map<String, ReceiptShareOptions> delegates) async {
		return await CardinalSdkPlatformInterface.instance.apis.receipt.encrypted.shareWithMany(
			_sdkId,
			receipt,
			delegates,
		);
	}

	Future<EncryptedReceipt> createReceipt(EncryptedReceipt entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.receipt.encrypted.createReceipt(
			_sdkId,
			entity,
		);
	}

	Future<EncryptedReceipt> modifyReceipt(EncryptedReceipt entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.receipt.encrypted.modifyReceipt(
			_sdkId,
			entity,
		);
	}

	Future<EncryptedReceipt?> getReceipt(String entityId) async {
		return await CardinalSdkPlatformInterface.instance.apis.receipt.encrypted.getReceipt(
			_sdkId,
			entityId,
		);
	}

	Future<List<EncryptedReceipt>> listByReference(String reference) async {
		return await CardinalSdkPlatformInterface.instance.apis.receipt.encrypted.listByReference(
			_sdkId,
			reference,
		);
	}
}