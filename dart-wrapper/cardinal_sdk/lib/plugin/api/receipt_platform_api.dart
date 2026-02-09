// auto-generated file
import 'package:flutter/services.dart';
import 'package:cardinal_sdk/model/receipt.dart';
import 'package:cardinal_sdk/model/patient.dart';
import 'package:cardinal_sdk/model/user.dart';
import 'package:cardinal_sdk/model/embed/access_level.dart';
import 'package:cardinal_sdk/crypto/entities/secret_id_use_option.dart';
import 'dart:convert';
import 'package:cardinal_sdk/utils/internal/platform_exception_convertion.dart';
import 'dart:typed_data';
import 'package:cardinal_sdk/model/specializations/hex_string.dart';
import 'package:cardinal_sdk/model/couchdb/doc_identifier.dart';
import 'package:cardinal_sdk/crypto/entities/receipt_share_options.dart';


class ReceiptPlatformApi {
	MethodChannel _methodChannel;
	ReceiptEncryptedPlatformApi encrypted;
	ReceiptTryAndRecoverPlatformApi tryAndRecover;
	ReceiptPlatformApi(
		this._methodChannel
		) : encrypted = ReceiptEncryptedPlatformApi(_methodChannel),
		tryAndRecover = ReceiptTryAndRecoverPlatformApi(_methodChannel);

	Future<DecryptedReceipt> withEncryptionMetadata(String sdkId, DecryptedReceipt? base, Patient? patient, User? user, Map<String, AccessLevel> delegates, SecretIdUseOption secretId, String? alternateRootDelegateId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ReceiptApi.withEncryptionMetadata',
			{
				"sdkId": sdkId,
				"base": jsonEncode(base == null ? null : DecryptedReceipt.encode(base!)),
				"patient": jsonEncode(patient == null ? null : Patient.encode(patient!)),
				"user": jsonEncode(user == null ? null : User.encode(user!)),
				"delegates": jsonEncode(delegates.map((k0, v0) => MapEntry(k0, AccessLevel.encode(v0)))),
				"secretId": jsonEncode(SecretIdUseOption.encode(secretId)),
				"alternateRootDelegateId": jsonEncode(alternateRootDelegateId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method withEncryptionMetadata");
		final parsedResJson = jsonDecode(res);
		return DecryptedReceipt.fromJSON(parsedResJson);
	}

	Future<Uint8List> getAndDecryptReceiptAttachment(String sdkId, Receipt receipt, String attachmentId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ReceiptApi.getAndDecryptReceiptAttachment',
			{
				"sdkId": sdkId,
				"receipt": jsonEncode(Receipt.encode(receipt)),
				"attachmentId": jsonEncode(attachmentId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getAndDecryptReceiptAttachment");
		final parsedResJson = jsonDecode(res);
		return base64Decode(parsedResJson as String);
	}

	Future<EncryptedReceipt> encryptAndSetReceiptAttachment(String sdkId, Receipt receipt, String blobType, Uint8List attachment) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ReceiptApi.encryptAndSetReceiptAttachment',
			{
				"sdkId": sdkId,
				"receipt": jsonEncode(Receipt.encode(receipt)),
				"blobType": jsonEncode(blobType),
				"attachment": jsonEncode(base64Encode(attachment as List<int>)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method encryptAndSetReceiptAttachment");
		final parsedResJson = jsonDecode(res);
		return EncryptedReceipt.fromJSON(parsedResJson);
	}

	Future<Set<HexString>> getEncryptionKeysOf(String sdkId, Receipt receipt) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ReceiptApi.getEncryptionKeysOf',
			{
				"sdkId": sdkId,
				"receipt": jsonEncode(Receipt.encode(receipt)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getEncryptionKeysOf");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => (x1 as HexString) ).toSet();
	}

	Future<bool> hasWriteAccess(String sdkId, Receipt receipt) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ReceiptApi.hasWriteAccess',
			{
				"sdkId": sdkId,
				"receipt": jsonEncode(Receipt.encode(receipt)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method hasWriteAccess");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as bool);
	}

	Future<Set<String>> decryptPatientIdOf(String sdkId, Receipt receipt) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ReceiptApi.decryptPatientIdOf',
			{
				"sdkId": sdkId,
				"receipt": jsonEncode(Receipt.encode(receipt)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method decryptPatientIdOf");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => (x1 as String) ).toSet();
	}

	Future<void> createDelegationDeAnonymizationMetadata(String sdkId, Receipt entity, Set<String> delegates) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ReceiptApi.createDelegationDeAnonymizationMetadata',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(Receipt.encode(entity)),
				"delegates": jsonEncode(delegates.map((x0) => x0).toList()),
			}
		).catchError(convertPlatformException);
	}

	Future<Receipt> logReceipt(String sdkId, User user, String docId, List<String> refs, String blobType, Uint8List blob) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ReceiptApi.logReceipt',
			{
				"sdkId": sdkId,
				"user": jsonEncode(User.encode(user)),
				"docId": jsonEncode(docId),
				"refs": jsonEncode(refs.map((x0) => x0).toList()),
				"blobType": jsonEncode(blobType),
				"blob": jsonEncode(base64Encode(blob as List<int>)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method logReceipt");
		final parsedResJson = jsonDecode(res);
		return Receipt.fromJSON(parsedResJson);
	}

	Future<DecryptedReceipt> decrypt(String sdkId, EncryptedReceipt receipt) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ReceiptApi.decrypt',
			{
				"sdkId": sdkId,
				"receipt": jsonEncode(EncryptedReceipt.encode(receipt)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method decrypt");
		final parsedResJson = jsonDecode(res);
		return DecryptedReceipt.fromJSON(parsedResJson);
	}

	Future<Receipt> tryDecrypt(String sdkId, EncryptedReceipt receipt) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ReceiptApi.tryDecrypt',
			{
				"sdkId": sdkId,
				"receipt": jsonEncode(EncryptedReceipt.encode(receipt)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method tryDecrypt");
		final parsedResJson = jsonDecode(res);
		return Receipt.fromJSON(parsedResJson);
	}

	Future<DocIdentifier> deleteReceipt(String sdkId, String entityId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ReceiptApi.deleteReceipt',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method deleteReceipt");
		final parsedResJson = jsonDecode(res);
		return DocIdentifier.fromJSON(parsedResJson);
	}

	Future<List<DocIdentifier>> deleteReceipts(String sdkId, List<String> entityIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ReceiptApi.deleteReceipts',
			{
				"sdkId": sdkId,
				"entityIds": jsonEncode(entityIds.map((x0) => x0).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method deleteReceipts");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => DocIdentifier.fromJSON(x1) ).toList();
	}

	Future<Uint8List> getRawReceiptAttachment(String sdkId, String receiptId, String attachmentId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ReceiptApi.getRawReceiptAttachment',
			{
				"sdkId": sdkId,
				"receiptId": jsonEncode(receiptId),
				"attachmentId": jsonEncode(attachmentId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getRawReceiptAttachment");
		final parsedResJson = jsonDecode(res);
		return base64Decode(parsedResJson as String);
	}

	Future<EncryptedReceipt> setRawReceiptAttachment(String sdkId, String receiptId, String rev, String blobType, Uint8List attachment) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ReceiptApi.setRawReceiptAttachment',
			{
				"sdkId": sdkId,
				"receiptId": jsonEncode(receiptId),
				"rev": jsonEncode(rev),
				"blobType": jsonEncode(blobType),
				"attachment": jsonEncode(base64Encode(attachment as List<int>)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method setRawReceiptAttachment");
		final parsedResJson = jsonDecode(res);
		return EncryptedReceipt.fromJSON(parsedResJson);
	}

	Future<DecryptedReceipt> shareWith(String sdkId, String delegateId, DecryptedReceipt receipt, ReceiptShareOptions? options) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ReceiptApi.shareWith',
			{
				"sdkId": sdkId,
				"delegateId": jsonEncode(delegateId),
				"receipt": jsonEncode(DecryptedReceipt.encode(receipt)),
				"options": jsonEncode(options == null ? null : ReceiptShareOptions.encode(options!)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method shareWith");
		final parsedResJson = jsonDecode(res);
		return DecryptedReceipt.fromJSON(parsedResJson);
	}

	Future<DecryptedReceipt> shareWithMany(String sdkId, DecryptedReceipt receipt, Map<String, ReceiptShareOptions> delegates) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ReceiptApi.shareWithMany',
			{
				"sdkId": sdkId,
				"receipt": jsonEncode(DecryptedReceipt.encode(receipt)),
				"delegates": jsonEncode(delegates.map((k0, v0) => MapEntry(k0, ReceiptShareOptions.encode(v0)))),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method shareWithMany");
		final parsedResJson = jsonDecode(res);
		return DecryptedReceipt.fromJSON(parsedResJson);
	}

	Future<DecryptedReceipt> createReceipt(String sdkId, DecryptedReceipt entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ReceiptApi.createReceipt',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(DecryptedReceipt.encode(entity)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method createReceipt");
		final parsedResJson = jsonDecode(res);
		return DecryptedReceipt.fromJSON(parsedResJson);
	}

	Future<DecryptedReceipt> modifyReceipt(String sdkId, DecryptedReceipt entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ReceiptApi.modifyReceipt',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(DecryptedReceipt.encode(entity)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method modifyReceipt");
		final parsedResJson = jsonDecode(res);
		return DecryptedReceipt.fromJSON(parsedResJson);
	}

	Future<DecryptedReceipt?> getReceipt(String sdkId, String entityId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ReceiptApi.getReceipt',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getReceipt");
		final parsedResJson = jsonDecode(res);
		return parsedResJson == null ? null : DecryptedReceipt.fromJSON(parsedResJson);
	}

	Future<List<DecryptedReceipt>> listByReference(String sdkId, String reference) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ReceiptApi.listByReference',
			{
				"sdkId": sdkId,
				"reference": jsonEncode(reference),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method listByReference");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => DecryptedReceipt.fromJSON(x1) ).toList();
	}
}

class ReceiptTryAndRecoverPlatformApi {
	MethodChannel _methodChannel;
	ReceiptTryAndRecoverPlatformApi(this._methodChannel);

	Future<Receipt> shareWith(String sdkId, String delegateId, Receipt receipt, ReceiptShareOptions? options) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ReceiptApi.tryAndRecover.shareWith',
			{
				"sdkId": sdkId,
				"delegateId": jsonEncode(delegateId),
				"receipt": jsonEncode(Receipt.encode(receipt)),
				"options": jsonEncode(options == null ? null : ReceiptShareOptions.encode(options!)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method shareWith");
		final parsedResJson = jsonDecode(res);
		return Receipt.fromJSON(parsedResJson);
	}

	Future<Receipt> shareWithMany(String sdkId, Receipt receipt, Map<String, ReceiptShareOptions> delegates) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ReceiptApi.tryAndRecover.shareWithMany',
			{
				"sdkId": sdkId,
				"receipt": jsonEncode(Receipt.encode(receipt)),
				"delegates": jsonEncode(delegates.map((k0, v0) => MapEntry(k0, ReceiptShareOptions.encode(v0)))),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method shareWithMany");
		final parsedResJson = jsonDecode(res);
		return Receipt.fromJSON(parsedResJson);
	}

	Future<Receipt> createReceipt(String sdkId, Receipt entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ReceiptApi.tryAndRecover.createReceipt',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(Receipt.encode(entity)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method createReceipt");
		final parsedResJson = jsonDecode(res);
		return Receipt.fromJSON(parsedResJson);
	}

	Future<Receipt> modifyReceipt(String sdkId, Receipt entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ReceiptApi.tryAndRecover.modifyReceipt',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(Receipt.encode(entity)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method modifyReceipt");
		final parsedResJson = jsonDecode(res);
		return Receipt.fromJSON(parsedResJson);
	}

	Future<Receipt?> getReceipt(String sdkId, String entityId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ReceiptApi.tryAndRecover.getReceipt',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getReceipt");
		final parsedResJson = jsonDecode(res);
		return parsedResJson == null ? null : Receipt.fromJSON(parsedResJson);
	}

	Future<List<Receipt>> listByReference(String sdkId, String reference) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ReceiptApi.tryAndRecover.listByReference',
			{
				"sdkId": sdkId,
				"reference": jsonEncode(reference),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method listByReference");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => Receipt.fromJSON(x1) ).toList();
	}
}

class ReceiptEncryptedPlatformApi {
	MethodChannel _methodChannel;
	ReceiptEncryptedPlatformApi(this._methodChannel);

	Future<EncryptedReceipt> shareWith(String sdkId, String delegateId, EncryptedReceipt receipt, ReceiptShareOptions? options) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ReceiptApi.encrypted.shareWith',
			{
				"sdkId": sdkId,
				"delegateId": jsonEncode(delegateId),
				"receipt": jsonEncode(EncryptedReceipt.encode(receipt)),
				"options": jsonEncode(options == null ? null : ReceiptShareOptions.encode(options!)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method shareWith");
		final parsedResJson = jsonDecode(res);
		return EncryptedReceipt.fromJSON(parsedResJson);
	}

	Future<EncryptedReceipt> shareWithMany(String sdkId, EncryptedReceipt receipt, Map<String, ReceiptShareOptions> delegates) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ReceiptApi.encrypted.shareWithMany',
			{
				"sdkId": sdkId,
				"receipt": jsonEncode(EncryptedReceipt.encode(receipt)),
				"delegates": jsonEncode(delegates.map((k0, v0) => MapEntry(k0, ReceiptShareOptions.encode(v0)))),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method shareWithMany");
		final parsedResJson = jsonDecode(res);
		return EncryptedReceipt.fromJSON(parsedResJson);
	}

	Future<EncryptedReceipt> createReceipt(String sdkId, EncryptedReceipt entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ReceiptApi.encrypted.createReceipt',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(EncryptedReceipt.encode(entity)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method createReceipt");
		final parsedResJson = jsonDecode(res);
		return EncryptedReceipt.fromJSON(parsedResJson);
	}

	Future<EncryptedReceipt> modifyReceipt(String sdkId, EncryptedReceipt entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ReceiptApi.encrypted.modifyReceipt',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(EncryptedReceipt.encode(entity)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method modifyReceipt");
		final parsedResJson = jsonDecode(res);
		return EncryptedReceipt.fromJSON(parsedResJson);
	}

	Future<EncryptedReceipt?> getReceipt(String sdkId, String entityId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ReceiptApi.encrypted.getReceipt',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getReceipt");
		final parsedResJson = jsonDecode(res);
		return parsedResJson == null ? null : EncryptedReceipt.fromJSON(parsedResJson);
	}

	Future<List<EncryptedReceipt>> listByReference(String sdkId, String reference) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ReceiptApi.encrypted.listByReference',
			{
				"sdkId": sdkId,
				"reference": jsonEncode(reference),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method listByReference");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => EncryptedReceipt.fromJSON(x1) ).toList();
	}
}