// auto-generated file
import 'package:flutter/services.dart';
import 'package:cardinal_sdk/model/document.dart';
import 'package:cardinal_sdk/model/message.dart';
import 'package:cardinal_sdk/model/user.dart';
import 'package:cardinal_sdk/model/embed/access_level.dart';
import 'package:cardinal_sdk/crypto/entities/secret_id_use_option.dart';
import 'dart:convert';
import 'package:cardinal_sdk/utils/internal/platform_exception_convertion.dart';
import 'package:cardinal_sdk/model/patient.dart';
import 'dart:typed_data';
import 'package:cardinal_sdk/utils/internal/callback_references.dart';
import 'package:cardinal_sdk/model/specializations/hex_string.dart';
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'package:cardinal_sdk/model/couchdb/doc_identifier.dart';
import 'package:cardinal_sdk/model/stored_document_identifier.dart';
import 'package:cardinal_sdk/crypto/entities/document_share_options.dart';
import 'package:cardinal_sdk/utils/pagination/paginated_list_iterator.dart';


class DocumentPlatformApi {
	MethodChannel _methodChannel;
	DocumentEncryptedPlatformApi encrypted;
	DocumentTryAndRecoverPlatformApi tryAndRecover;
	DocumentPlatformApi(
		this._methodChannel
		) : encrypted = DocumentEncryptedPlatformApi(_methodChannel),
		tryAndRecover = DocumentTryAndRecoverPlatformApi(_methodChannel);

	Future<DecryptedDocument> withEncryptionMetadataLinkedToMessage(String sdkId, DecryptedDocument? base, Message message, User? user, Map<String, AccessLevel> delegates, SecretIdUseOption secretId, String? alternateRootDelegateId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.withEncryptionMetadataLinkedToMessage',
			{
				"sdkId": sdkId,
				"base": jsonEncode(base == null ? null : DecryptedDocument.encode(base!)),
				"message": jsonEncode(Message.encode(message)),
				"user": jsonEncode(user == null ? null : User.encode(user!)),
				"delegates": jsonEncode(delegates.map((k0, v0) => MapEntry(k0, AccessLevel.encode(v0)))),
				"secretId": jsonEncode(SecretIdUseOption.encode(secretId)),
				"alternateRootDelegateId": jsonEncode(alternateRootDelegateId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method withEncryptionMetadataLinkedToMessage");
		final parsedResJson = jsonDecode(res);
		return DecryptedDocument.fromJSON(parsedResJson);
	}

	Future<DecryptedDocument> withEncryptionMetadataLinkedToPatient(String sdkId, DecryptedDocument? base, Patient patient, User? user, Map<String, AccessLevel> delegates, SecretIdUseOption secretId, String? alternateRootDelegateId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.withEncryptionMetadataLinkedToPatient',
			{
				"sdkId": sdkId,
				"base": jsonEncode(base == null ? null : DecryptedDocument.encode(base!)),
				"patient": jsonEncode(Patient.encode(patient)),
				"user": jsonEncode(user == null ? null : User.encode(user!)),
				"delegates": jsonEncode(delegates.map((k0, v0) => MapEntry(k0, AccessLevel.encode(v0)))),
				"secretId": jsonEncode(SecretIdUseOption.encode(secretId)),
				"alternateRootDelegateId": jsonEncode(alternateRootDelegateId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method withEncryptionMetadataLinkedToPatient");
		final parsedResJson = jsonDecode(res);
		return DecryptedDocument.fromJSON(parsedResJson);
	}

	Future<DecryptedDocument> withEncryptionMetadataUnlinked(String sdkId, DecryptedDocument? base, User? user, Map<String, AccessLevel> delegates, String? alternateRootDelegateId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.withEncryptionMetadataUnlinked',
			{
				"sdkId": sdkId,
				"base": jsonEncode(base == null ? null : DecryptedDocument.encode(base!)),
				"user": jsonEncode(user == null ? null : User.encode(user!)),
				"delegates": jsonEncode(delegates.map((k0, v0) => MapEntry(k0, AccessLevel.encode(v0)))),
				"alternateRootDelegateId": jsonEncode(alternateRootDelegateId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method withEncryptionMetadataUnlinked");
		final parsedResJson = jsonDecode(res);
		return DecryptedDocument.fromJSON(parsedResJson);
	}

	Future<Uint8List?> getAndTryDecryptMainAttachment(String sdkId, Document document, bool Function(Uint8List)? decryptedAttachmentValidator) async {
		final decryptedAttachmentValidatorCallbackId = decryptedAttachmentValidator != null ? CallbackReferences.create((data) async {
			final x0 = base64Decode(data["x0"] as String);
			final res = decryptedAttachmentValidator(x0);
			return jsonEncode(res);
		}) : null;
		try {
			final res = await _methodChannel.invokeMethod<String>(
				'DocumentApi.getAndTryDecryptMainAttachment',
				{
					"sdkId": sdkId,
					"document": jsonEncode(Document.encode(document)),
					"decryptedAttachmentValidator": jsonEncode(decryptedAttachmentValidatorCallbackId),
				}
			).catchError(convertPlatformException);
			if (res == null) throw AssertionError("received null result from platform method getAndTryDecryptMainAttachment");
			final parsedResJson = jsonDecode(res);
			return parsedResJson == null ? null : base64Decode(parsedResJson as String);
		} finally {
			if (decryptedAttachmentValidatorCallbackId != null) CallbackReferences.delete(decryptedAttachmentValidatorCallbackId);
		}
	}

	Future<Uint8List> getAndDecryptMainAttachment(String sdkId, Document document, bool Function(Uint8List)? decryptedAttachmentValidator) async {
		final decryptedAttachmentValidatorCallbackId = decryptedAttachmentValidator != null ? CallbackReferences.create((data) async {
			final x0 = base64Decode(data["x0"] as String);
			final res = decryptedAttachmentValidator(x0);
			return jsonEncode(res);
		}) : null;
		try {
			final res = await _methodChannel.invokeMethod<String>(
				'DocumentApi.getAndDecryptMainAttachment',
				{
					"sdkId": sdkId,
					"document": jsonEncode(Document.encode(document)),
					"decryptedAttachmentValidator": jsonEncode(decryptedAttachmentValidatorCallbackId),
				}
			).catchError(convertPlatformException);
			if (res == null) throw AssertionError("received null result from platform method getAndDecryptMainAttachment");
			final parsedResJson = jsonDecode(res);
			return base64Decode(parsedResJson as String);
		} finally {
			if (decryptedAttachmentValidatorCallbackId != null) CallbackReferences.delete(decryptedAttachmentValidatorCallbackId);
		}
	}

	Future<EncryptedDocument> encryptAndSetMainAttachment(String sdkId, Document document, List<String>? utis, Uint8List attachment) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.encryptAndSetMainAttachment',
			{
				"sdkId": sdkId,
				"document": jsonEncode(Document.encode(document)),
				"utis": jsonEncode(utis?.map((x0) => x0).toList()),
				"attachment": jsonEncode(base64Encode(attachment as List<int>)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method encryptAndSetMainAttachment");
		final parsedResJson = jsonDecode(res);
		return EncryptedDocument.fromJSON(parsedResJson);
	}

	Future<Uint8List> getAndDecryptSecondaryAttachment(String sdkId, Document document, String key, bool Function(Uint8List)? decryptedAttachmentValidator) async {
		final decryptedAttachmentValidatorCallbackId = decryptedAttachmentValidator != null ? CallbackReferences.create((data) async {
			final x0 = base64Decode(data["x0"] as String);
			final res = decryptedAttachmentValidator(x0);
			return jsonEncode(res);
		}) : null;
		try {
			final res = await _methodChannel.invokeMethod<String>(
				'DocumentApi.getAndDecryptSecondaryAttachment',
				{
					"sdkId": sdkId,
					"document": jsonEncode(Document.encode(document)),
					"key": jsonEncode(key),
					"decryptedAttachmentValidator": jsonEncode(decryptedAttachmentValidatorCallbackId),
				}
			).catchError(convertPlatformException);
			if (res == null) throw AssertionError("received null result from platform method getAndDecryptSecondaryAttachment");
			final parsedResJson = jsonDecode(res);
			return base64Decode(parsedResJson as String);
		} finally {
			if (decryptedAttachmentValidatorCallbackId != null) CallbackReferences.delete(decryptedAttachmentValidatorCallbackId);
		}
	}

	Future<EncryptedDocument> encryptAndSetSecondaryAttachment(String sdkId, Document document, String key, List<String>? utis, Uint8List attachment) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.encryptAndSetSecondaryAttachment',
			{
				"sdkId": sdkId,
				"document": jsonEncode(Document.encode(document)),
				"key": jsonEncode(key),
				"utis": jsonEncode(utis?.map((x0) => x0).toList()),
				"attachment": jsonEncode(base64Encode(attachment as List<int>)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method encryptAndSetSecondaryAttachment");
		final parsedResJson = jsonDecode(res);
		return EncryptedDocument.fromJSON(parsedResJson);
	}

	Future<Set<HexString>> getEncryptionKeysOf(String sdkId, Document document) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.getEncryptionKeysOf',
			{
				"sdkId": sdkId,
				"document": jsonEncode(Document.encode(document)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getEncryptionKeysOf");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => (x1 as HexString) ).toSet();
	}

	Future<bool> hasWriteAccess(String sdkId, Document document) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.hasWriteAccess',
			{
				"sdkId": sdkId,
				"document": jsonEncode(Document.encode(document)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method hasWriteAccess");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as bool);
	}

	Future<Set<String>> decryptOwningEntityIdsOf(String sdkId, Document document) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.decryptOwningEntityIdsOf',
			{
				"sdkId": sdkId,
				"document": jsonEncode(Document.encode(document)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method decryptOwningEntityIdsOf");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => (x1 as String) ).toSet();
	}

	Future<void> createDelegationDeAnonymizationMetadata(String sdkId, Document entity, Set<String> delegates) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.createDelegationDeAnonymizationMetadata',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(Document.encode(entity)),
				"delegates": jsonEncode(delegates.map((x0) => x0).toList()),
			}
		).catchError(convertPlatformException);
	}

	Future<DecryptedDocument> decrypt(String sdkId, EncryptedDocument document) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.decrypt',
			{
				"sdkId": sdkId,
				"document": jsonEncode(EncryptedDocument.encode(document)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method decrypt");
		final parsedResJson = jsonDecode(res);
		return DecryptedDocument.fromJSON(parsedResJson);
	}

	Future<Document> tryDecrypt(String sdkId, EncryptedDocument document) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.tryDecrypt',
			{
				"sdkId": sdkId,
				"document": jsonEncode(EncryptedDocument.encode(document)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method tryDecrypt");
		final parsedResJson = jsonDecode(res);
		return Document.fromJSON(parsedResJson);
	}

	Future<Uint8List?> tryDecryptAttachment(String sdkId, Document document, Uint8List encryptedAttachment, bool Function(Uint8List)? decryptedAttachmentValidator) async {
		final decryptedAttachmentValidatorCallbackId = decryptedAttachmentValidator != null ? CallbackReferences.create((data) async {
			final x0 = base64Decode(data["x0"] as String);
			final res = decryptedAttachmentValidator(x0);
			return jsonEncode(res);
		}) : null;
		try {
			final res = await _methodChannel.invokeMethod<String>(
				'DocumentApi.tryDecryptAttachment',
				{
					"sdkId": sdkId,
					"document": jsonEncode(Document.encode(document)),
					"encryptedAttachment": jsonEncode(base64Encode(encryptedAttachment as List<int>)),
					"decryptedAttachmentValidator": jsonEncode(decryptedAttachmentValidatorCallbackId),
				}
			).catchError(convertPlatformException);
			if (res == null) throw AssertionError("received null result from platform method tryDecryptAttachment");
			final parsedResJson = jsonDecode(res);
			return parsedResJson == null ? null : base64Decode(parsedResJson as String);
		} finally {
			if (decryptedAttachmentValidatorCallbackId != null) CallbackReferences.delete(decryptedAttachmentValidatorCallbackId);
		}
	}

	Future<List<String>> matchDocumentsBy(String sdkId, FilterOptions<Document> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.matchDocumentsBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(FilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method matchDocumentsBy");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => (x1 as String) ).toList();
	}

	Future<List<String>> matchDocumentsBySorted(String sdkId, SortableFilterOptions<Document> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.matchDocumentsBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(SortableFilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method matchDocumentsBySorted");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => (x1 as String) ).toList();
	}

	Future<DocIdentifier> deleteDocumentById(String sdkId, String entityId, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.deleteDocumentById',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
				"rev": jsonEncode(rev),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method deleteDocumentById");
		final parsedResJson = jsonDecode(res);
		return DocIdentifier.fromJSON(parsedResJson);
	}

	Future<List<DocIdentifier>> deleteDocumentsByIds(String sdkId, List<StoredDocumentIdentifier> entityIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.deleteDocumentsByIds',
			{
				"sdkId": sdkId,
				"entityIds": jsonEncode(entityIds.map((x0) => StoredDocumentIdentifier.encode(x0)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method deleteDocumentsByIds");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => DocIdentifier.fromJSON(x1) ).toList();
	}

	Future<void> purgeDocumentById(String sdkId, String id, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.purgeDocumentById',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
				"rev": jsonEncode(rev),
			}
		).catchError(convertPlatformException);
	}

	Future<DocIdentifier> deleteDocument(String sdkId, Document document) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.deleteDocument',
			{
				"sdkId": sdkId,
				"document": jsonEncode(Document.encode(document)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method deleteDocument");
		final parsedResJson = jsonDecode(res);
		return DocIdentifier.fromJSON(parsedResJson);
	}

	Future<List<DocIdentifier>> deleteDocuments(String sdkId, List<Document> documents) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.deleteDocuments',
			{
				"sdkId": sdkId,
				"documents": jsonEncode(documents.map((x0) => Document.encode(x0)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method deleteDocuments");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => DocIdentifier.fromJSON(x1) ).toList();
	}

	Future<void> purgeDocument(String sdkId, Document document) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.purgeDocument',
			{
				"sdkId": sdkId,
				"document": jsonEncode(Document.encode(document)),
			}
		).catchError(convertPlatformException);
	}

	Future<Uint8List> getRawMainAttachment(String sdkId, String documentId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.getRawMainAttachment',
			{
				"sdkId": sdkId,
				"documentId": jsonEncode(documentId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getRawMainAttachment");
		final parsedResJson = jsonDecode(res);
		return base64Decode(parsedResJson as String);
	}

	Future<Uint8List> getRawSecondaryAttachment(String sdkId, String documentId, String key) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.getRawSecondaryAttachment',
			{
				"sdkId": sdkId,
				"documentId": jsonEncode(documentId),
				"key": jsonEncode(key),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getRawSecondaryAttachment");
		final parsedResJson = jsonDecode(res);
		return base64Decode(parsedResJson as String);
	}

	Future<EncryptedDocument> setRawMainAttachment(String sdkId, String documentId, String rev, List<String>? utis, Uint8List attachment, bool encrypted) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.setRawMainAttachment',
			{
				"sdkId": sdkId,
				"documentId": jsonEncode(documentId),
				"rev": jsonEncode(rev),
				"utis": jsonEncode(utis?.map((x0) => x0).toList()),
				"attachment": jsonEncode(base64Encode(attachment as List<int>)),
				"encrypted": jsonEncode(encrypted),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method setRawMainAttachment");
		final parsedResJson = jsonDecode(res);
		return EncryptedDocument.fromJSON(parsedResJson);
	}

	Future<EncryptedDocument> setRawSecondaryAttachment(String sdkId, String documentId, String key, String rev, List<String>? utis, Uint8List attachment, bool encrypted) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.setRawSecondaryAttachment',
			{
				"sdkId": sdkId,
				"documentId": jsonEncode(documentId),
				"key": jsonEncode(key),
				"rev": jsonEncode(rev),
				"utis": jsonEncode(utis?.map((x0) => x0).toList()),
				"attachment": jsonEncode(base64Encode(attachment as List<int>)),
				"encrypted": jsonEncode(encrypted),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method setRawSecondaryAttachment");
		final parsedResJson = jsonDecode(res);
		return EncryptedDocument.fromJSON(parsedResJson);
	}

	Future<EncryptedDocument> deleteMainAttachment(String sdkId, String entityId, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.deleteMainAttachment',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
				"rev": jsonEncode(rev),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method deleteMainAttachment");
		final parsedResJson = jsonDecode(res);
		return EncryptedDocument.fromJSON(parsedResJson);
	}

	Future<EncryptedDocument> deleteSecondaryAttachment(String sdkId, String documentId, String key, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.deleteSecondaryAttachment',
			{
				"sdkId": sdkId,
				"documentId": jsonEncode(documentId),
				"key": jsonEncode(key),
				"rev": jsonEncode(rev),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method deleteSecondaryAttachment");
		final parsedResJson = jsonDecode(res);
		return EncryptedDocument.fromJSON(parsedResJson);
	}

	Future<DecryptedDocument> shareWith(String sdkId, String delegateId, DecryptedDocument document, DocumentShareOptions? options) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.shareWith',
			{
				"sdkId": sdkId,
				"delegateId": jsonEncode(delegateId),
				"document": jsonEncode(DecryptedDocument.encode(document)),
				"options": jsonEncode(options == null ? null : DocumentShareOptions.encode(options!)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method shareWith");
		final parsedResJson = jsonDecode(res);
		return DecryptedDocument.fromJSON(parsedResJson);
	}

	Future<DecryptedDocument> shareWithMany(String sdkId, DecryptedDocument document, Map<String, DocumentShareOptions> delegates) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.shareWithMany',
			{
				"sdkId": sdkId,
				"document": jsonEncode(DecryptedDocument.encode(document)),
				"delegates": jsonEncode(delegates.map((k0, v0) => MapEntry(k0, DocumentShareOptions.encode(v0)))),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method shareWithMany");
		final parsedResJson = jsonDecode(res);
		return DecryptedDocument.fromJSON(parsedResJson);
	}

	Future<PaginatedListIterator<DecryptedDocument>> filterDocumentsBy(String sdkId, FilterOptions<Document> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.filterDocumentsBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(FilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method filterDocumentsBy");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => DecryptedDocument.fromJSON(x0));
	}

	Future<PaginatedListIterator<DecryptedDocument>> filterDocumentsBySorted(String sdkId, SortableFilterOptions<Document> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.filterDocumentsBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(SortableFilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method filterDocumentsBySorted");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => DecryptedDocument.fromJSON(x0));
	}

	Future<DecryptedDocument> createDocument(String sdkId, DecryptedDocument entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.createDocument',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(DecryptedDocument.encode(entity)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method createDocument");
		final parsedResJson = jsonDecode(res);
		return DecryptedDocument.fromJSON(parsedResJson);
	}

	Future<DecryptedDocument> undeleteDocumentById(String sdkId, String id, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.undeleteDocumentById',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
				"rev": jsonEncode(rev),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method undeleteDocumentById");
		final parsedResJson = jsonDecode(res);
		return DecryptedDocument.fromJSON(parsedResJson);
	}

	Future<DecryptedDocument> undeleteDocument(String sdkId, Document document) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.undeleteDocument',
			{
				"sdkId": sdkId,
				"document": jsonEncode(Document.encode(document)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method undeleteDocument");
		final parsedResJson = jsonDecode(res);
		return DecryptedDocument.fromJSON(parsedResJson);
	}

	Future<DecryptedDocument> modifyDocument(String sdkId, DecryptedDocument entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.modifyDocument',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(DecryptedDocument.encode(entity)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method modifyDocument");
		final parsedResJson = jsonDecode(res);
		return DecryptedDocument.fromJSON(parsedResJson);
	}

	Future<DecryptedDocument?> getDocument(String sdkId, String entityId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.getDocument',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getDocument");
		final parsedResJson = jsonDecode(res);
		return parsedResJson == null ? null : DecryptedDocument.fromJSON(parsedResJson);
	}

	Future<List<DecryptedDocument>> getDocuments(String sdkId, List<String> entityIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.getDocuments',
			{
				"sdkId": sdkId,
				"entityIds": jsonEncode(entityIds.map((x0) => x0).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getDocuments");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => DecryptedDocument.fromJSON(x1) ).toList();
	}

	Future<List<DecryptedDocument>> modifyDocuments(String sdkId, List<DecryptedDocument> entities) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.modifyDocuments',
			{
				"sdkId": sdkId,
				"entities": jsonEncode(entities.map((x0) => DecryptedDocument.encode(x0)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method modifyDocuments");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => DecryptedDocument.fromJSON(x1) ).toList();
	}
}

class DocumentTryAndRecoverPlatformApi {
	MethodChannel _methodChannel;
	DocumentTryAndRecoverPlatformApi(this._methodChannel);

	Future<Document> shareWith(String sdkId, String delegateId, Document document, DocumentShareOptions? options) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.tryAndRecover.shareWith',
			{
				"sdkId": sdkId,
				"delegateId": jsonEncode(delegateId),
				"document": jsonEncode(Document.encode(document)),
				"options": jsonEncode(options == null ? null : DocumentShareOptions.encode(options!)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method shareWith");
		final parsedResJson = jsonDecode(res);
		return Document.fromJSON(parsedResJson);
	}

	Future<Document> shareWithMany(String sdkId, Document document, Map<String, DocumentShareOptions> delegates) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.tryAndRecover.shareWithMany',
			{
				"sdkId": sdkId,
				"document": jsonEncode(Document.encode(document)),
				"delegates": jsonEncode(delegates.map((k0, v0) => MapEntry(k0, DocumentShareOptions.encode(v0)))),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method shareWithMany");
		final parsedResJson = jsonDecode(res);
		return Document.fromJSON(parsedResJson);
	}

	Future<PaginatedListIterator<Document>> filterDocumentsBy(String sdkId, FilterOptions<Document> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.tryAndRecover.filterDocumentsBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(FilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method filterDocumentsBy");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => Document.fromJSON(x0));
	}

	Future<PaginatedListIterator<Document>> filterDocumentsBySorted(String sdkId, SortableFilterOptions<Document> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.tryAndRecover.filterDocumentsBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(SortableFilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method filterDocumentsBySorted");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => Document.fromJSON(x0));
	}

	Future<Document> createDocument(String sdkId, Document entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.tryAndRecover.createDocument',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(Document.encode(entity)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method createDocument");
		final parsedResJson = jsonDecode(res);
		return Document.fromJSON(parsedResJson);
	}

	Future<Document> undeleteDocumentById(String sdkId, String id, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.tryAndRecover.undeleteDocumentById',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
				"rev": jsonEncode(rev),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method undeleteDocumentById");
		final parsedResJson = jsonDecode(res);
		return Document.fromJSON(parsedResJson);
	}

	Future<Document> undeleteDocument(String sdkId, Document document) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.tryAndRecover.undeleteDocument',
			{
				"sdkId": sdkId,
				"document": jsonEncode(Document.encode(document)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method undeleteDocument");
		final parsedResJson = jsonDecode(res);
		return Document.fromJSON(parsedResJson);
	}

	Future<Document> modifyDocument(String sdkId, Document entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.tryAndRecover.modifyDocument',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(Document.encode(entity)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method modifyDocument");
		final parsedResJson = jsonDecode(res);
		return Document.fromJSON(parsedResJson);
	}

	Future<Document?> getDocument(String sdkId, String entityId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.tryAndRecover.getDocument',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getDocument");
		final parsedResJson = jsonDecode(res);
		return parsedResJson == null ? null : Document.fromJSON(parsedResJson);
	}

	Future<List<Document>> getDocuments(String sdkId, List<String> entityIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.tryAndRecover.getDocuments',
			{
				"sdkId": sdkId,
				"entityIds": jsonEncode(entityIds.map((x0) => x0).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getDocuments");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => Document.fromJSON(x1) ).toList();
	}

	Future<List<Document>> modifyDocuments(String sdkId, List<Document> entities) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.tryAndRecover.modifyDocuments',
			{
				"sdkId": sdkId,
				"entities": jsonEncode(entities.map((x0) => Document.encode(x0)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method modifyDocuments");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => Document.fromJSON(x1) ).toList();
	}
}

class DocumentEncryptedPlatformApi {
	MethodChannel _methodChannel;
	DocumentEncryptedPlatformApi(this._methodChannel);

	Future<EncryptedDocument> shareWith(String sdkId, String delegateId, EncryptedDocument document, DocumentShareOptions? options) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.encrypted.shareWith',
			{
				"sdkId": sdkId,
				"delegateId": jsonEncode(delegateId),
				"document": jsonEncode(EncryptedDocument.encode(document)),
				"options": jsonEncode(options == null ? null : DocumentShareOptions.encode(options!)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method shareWith");
		final parsedResJson = jsonDecode(res);
		return EncryptedDocument.fromJSON(parsedResJson);
	}

	Future<EncryptedDocument> shareWithMany(String sdkId, EncryptedDocument document, Map<String, DocumentShareOptions> delegates) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.encrypted.shareWithMany',
			{
				"sdkId": sdkId,
				"document": jsonEncode(EncryptedDocument.encode(document)),
				"delegates": jsonEncode(delegates.map((k0, v0) => MapEntry(k0, DocumentShareOptions.encode(v0)))),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method shareWithMany");
		final parsedResJson = jsonDecode(res);
		return EncryptedDocument.fromJSON(parsedResJson);
	}

	Future<PaginatedListIterator<EncryptedDocument>> filterDocumentsBy(String sdkId, FilterOptions<Document> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.encrypted.filterDocumentsBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(FilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method filterDocumentsBy");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => EncryptedDocument.fromJSON(x0));
	}

	Future<PaginatedListIterator<EncryptedDocument>> filterDocumentsBySorted(String sdkId, SortableFilterOptions<Document> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.encrypted.filterDocumentsBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(SortableFilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method filterDocumentsBySorted");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => EncryptedDocument.fromJSON(x0));
	}

	Future<EncryptedDocument> createDocument(String sdkId, EncryptedDocument entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.encrypted.createDocument',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(EncryptedDocument.encode(entity)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method createDocument");
		final parsedResJson = jsonDecode(res);
		return EncryptedDocument.fromJSON(parsedResJson);
	}

	Future<EncryptedDocument> undeleteDocumentById(String sdkId, String id, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.encrypted.undeleteDocumentById',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
				"rev": jsonEncode(rev),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method undeleteDocumentById");
		final parsedResJson = jsonDecode(res);
		return EncryptedDocument.fromJSON(parsedResJson);
	}

	Future<EncryptedDocument> undeleteDocument(String sdkId, Document document) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.encrypted.undeleteDocument',
			{
				"sdkId": sdkId,
				"document": jsonEncode(Document.encode(document)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method undeleteDocument");
		final parsedResJson = jsonDecode(res);
		return EncryptedDocument.fromJSON(parsedResJson);
	}

	Future<EncryptedDocument> modifyDocument(String sdkId, EncryptedDocument entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.encrypted.modifyDocument',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(EncryptedDocument.encode(entity)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method modifyDocument");
		final parsedResJson = jsonDecode(res);
		return EncryptedDocument.fromJSON(parsedResJson);
	}

	Future<EncryptedDocument?> getDocument(String sdkId, String entityId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.encrypted.getDocument',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getDocument");
		final parsedResJson = jsonDecode(res);
		return parsedResJson == null ? null : EncryptedDocument.fromJSON(parsedResJson);
	}

	Future<List<EncryptedDocument>> getDocuments(String sdkId, List<String> entityIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.encrypted.getDocuments',
			{
				"sdkId": sdkId,
				"entityIds": jsonEncode(entityIds.map((x0) => x0).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getDocuments");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => EncryptedDocument.fromJSON(x1) ).toList();
	}

	Future<List<EncryptedDocument>> modifyDocuments(String sdkId, List<EncryptedDocument> entities) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.encrypted.modifyDocuments',
			{
				"sdkId": sdkId,
				"entities": jsonEncode(entities.map((x0) => EncryptedDocument.encode(x0)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method modifyDocuments");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => EncryptedDocument.fromJSON(x1) ).toList();
	}
}