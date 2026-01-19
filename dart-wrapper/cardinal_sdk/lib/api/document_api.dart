// auto-generated file
import 'package:cardinal_sdk/model/document.dart';
import 'package:cardinal_sdk/model/message.dart';
import 'package:cardinal_sdk/model/user.dart';
import 'package:cardinal_sdk/model/embed/access_level.dart';
import 'package:cardinal_sdk/crypto/entities/secret_id_use_option.dart';
import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';
import 'package:cardinal_sdk/model/patient.dart';
import 'dart:typed_data';
import 'package:cardinal_sdk/model/specializations/hex_string.dart';
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'package:cardinal_sdk/model/couchdb/doc_identifier.dart';
import 'package:cardinal_sdk/model/stored_document_identifier.dart';
import 'package:cardinal_sdk/crypto/entities/document_share_options.dart';
import 'package:cardinal_sdk/utils/pagination/paginated_list_iterator.dart';


class DocumentApi {
	final String _sdkId;
	final Object _dartSdk;
	final DocumentEncryptedApi encrypted;
	final DocumentTryAndRecoverApi tryAndRecover;
	DocumentApi(
		this._sdkId,
		this._dartSdk
		) : encrypted = DocumentEncryptedApi(_sdkId, _dartSdk),
		tryAndRecover = DocumentTryAndRecoverApi(_sdkId, _dartSdk);

	Future<DecryptedDocument> withEncryptionMetadataLinkedToMessage(DecryptedDocument? base, Message message, { User? user, Map<String, AccessLevel> delegates = const {}, SecretIdUseOption secretId = SecretIdUseOption.UseAnySharedWithParent, String? alternateRootDelegateId }) async {
		return await CardinalSdkPlatformInterface.instance.apis.document.withEncryptionMetadataLinkedToMessage(
			_sdkId,
			base,
			message,
			user,
			delegates,
			secretId,
			alternateRootDelegateId,
		);
	}

	Future<DecryptedDocument> withEncryptionMetadataLinkedToPatient(DecryptedDocument? base, Patient patient, { User? user, Map<String, AccessLevel> delegates = const {}, SecretIdUseOption secretId = SecretIdUseOption.UseAnySharedWithParent, String? alternateRootDelegateId }) async {
		return await CardinalSdkPlatformInterface.instance.apis.document.withEncryptionMetadataLinkedToPatient(
			_sdkId,
			base,
			patient,
			user,
			delegates,
			secretId,
			alternateRootDelegateId,
		);
	}

	Future<DecryptedDocument> withEncryptionMetadataUnlinked(DecryptedDocument? base, { User? user, Map<String, AccessLevel> delegates = const {}, String? alternateRootDelegateId }) async {
		return await CardinalSdkPlatformInterface.instance.apis.document.withEncryptionMetadataUnlinked(
			_sdkId,
			base,
			user,
			delegates,
			alternateRootDelegateId,
		);
	}

	Future<Uint8List?> getAndTryDecryptMainAttachment(Document document, { bool Function(Uint8List)? decryptedAttachmentValidator }) async {
		return await CardinalSdkPlatformInterface.instance.apis.document.getAndTryDecryptMainAttachment(
			_sdkId,
			document,
			decryptedAttachmentValidator,
		);
	}

	Future<Uint8List> getAndDecryptMainAttachment(Document document, { bool Function(Uint8List)? decryptedAttachmentValidator }) async {
		return await CardinalSdkPlatformInterface.instance.apis.document.getAndDecryptMainAttachment(
			_sdkId,
			document,
			decryptedAttachmentValidator,
		);
	}

	Future<EncryptedDocument> encryptAndSetMainAttachment(Document document, List<String>? utis, Uint8List attachment) async {
		return await CardinalSdkPlatformInterface.instance.apis.document.encryptAndSetMainAttachment(
			_sdkId,
			document,
			utis,
			attachment,
		);
	}

	Future<Uint8List> getAndDecryptSecondaryAttachment(Document document, String key, { bool Function(Uint8List)? decryptedAttachmentValidator }) async {
		return await CardinalSdkPlatformInterface.instance.apis.document.getAndDecryptSecondaryAttachment(
			_sdkId,
			document,
			key,
			decryptedAttachmentValidator,
		);
	}

	Future<EncryptedDocument> encryptAndSetSecondaryAttachment(Document document, String key, List<String>? utis, Uint8List attachment) async {
		return await CardinalSdkPlatformInterface.instance.apis.document.encryptAndSetSecondaryAttachment(
			_sdkId,
			document,
			key,
			utis,
			attachment,
		);
	}

	Future<Set<HexString>> getEncryptionKeysOf(Document document) async {
		return await CardinalSdkPlatformInterface.instance.apis.document.getEncryptionKeysOf(
			_sdkId,
			document,
		);
	}

	Future<bool> hasWriteAccess(Document document) async {
		return await CardinalSdkPlatformInterface.instance.apis.document.hasWriteAccess(
			_sdkId,
			document,
		);
	}

	Future<Set<String>> decryptOwningEntityIdsOf(Document document) async {
		return await CardinalSdkPlatformInterface.instance.apis.document.decryptOwningEntityIdsOf(
			_sdkId,
			document,
		);
	}

	Future<void> createDelegationDeAnonymizationMetadata(Document entity, Set<String> delegates) async {
		return await CardinalSdkPlatformInterface.instance.apis.document.createDelegationDeAnonymizationMetadata(
			_sdkId,
			entity,
			delegates,
		);
	}

	Future<DecryptedDocument> decrypt(EncryptedDocument document) async {
		return await CardinalSdkPlatformInterface.instance.apis.document.decrypt(
			_sdkId,
			document,
		);
	}

	Future<Document> tryDecrypt(EncryptedDocument document) async {
		return await CardinalSdkPlatformInterface.instance.apis.document.tryDecrypt(
			_sdkId,
			document,
		);
	}

	Future<Uint8List?> tryDecryptAttachment(Document document, Uint8List encryptedAttachment, { bool Function(Uint8List)? decryptedAttachmentValidator }) async {
		return await CardinalSdkPlatformInterface.instance.apis.document.tryDecryptAttachment(
			_sdkId,
			document,
			encryptedAttachment,
			decryptedAttachmentValidator,
		);
	}

	Future<List<String>> matchDocumentsBy(FilterOptions<Document> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.document.matchDocumentsBy(
			_sdkId,
			filter,
		);
	}

	Future<List<String>> matchDocumentsBySorted(SortableFilterOptions<Document> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.document.matchDocumentsBySorted(
			_sdkId,
			filter,
		);
	}

	Future<DocIdentifier> deleteDocumentById(String entityId, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.document.deleteDocumentById(
			_sdkId,
			entityId,
			rev,
		);
	}

	Future<List<DocIdentifier>> deleteDocumentsByIds(List<StoredDocumentIdentifier> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.document.deleteDocumentsByIds(
			_sdkId,
			entityIds,
		);
	}

	Future<void> purgeDocumentById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.document.purgeDocumentById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<DocIdentifier> deleteDocument(Document document) async {
		return await CardinalSdkPlatformInterface.instance.apis.document.deleteDocument(
			_sdkId,
			document,
		);
	}

	Future<List<DocIdentifier>> deleteDocuments(List<Document> documents) async {
		return await CardinalSdkPlatformInterface.instance.apis.document.deleteDocuments(
			_sdkId,
			documents,
		);
	}

	Future<void> purgeDocument(Document document) async {
		return await CardinalSdkPlatformInterface.instance.apis.document.purgeDocument(
			_sdkId,
			document,
		);
	}

	Future<Uint8List> getRawMainAttachment(String documentId) async {
		return await CardinalSdkPlatformInterface.instance.apis.document.getRawMainAttachment(
			_sdkId,
			documentId,
		);
	}

	Future<Uint8List> getRawSecondaryAttachment(String documentId, String key) async {
		return await CardinalSdkPlatformInterface.instance.apis.document.getRawSecondaryAttachment(
			_sdkId,
			documentId,
			key,
		);
	}

	Future<EncryptedDocument> setRawMainAttachment(String documentId, String rev, List<String>? utis, Uint8List attachment, bool encrypted) async {
		return await CardinalSdkPlatformInterface.instance.apis.document.setRawMainAttachment(
			_sdkId,
			documentId,
			rev,
			utis,
			attachment,
			encrypted,
		);
	}

	Future<EncryptedDocument> setRawSecondaryAttachment(String documentId, String key, String rev, List<String>? utis, Uint8List attachment, bool encrypted) async {
		return await CardinalSdkPlatformInterface.instance.apis.document.setRawSecondaryAttachment(
			_sdkId,
			documentId,
			key,
			rev,
			utis,
			attachment,
			encrypted,
		);
	}

	Future<EncryptedDocument> deleteMainAttachment(String entityId, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.document.deleteMainAttachment(
			_sdkId,
			entityId,
			rev,
		);
	}

	Future<EncryptedDocument> deleteSecondaryAttachment(String documentId, String key, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.document.deleteSecondaryAttachment(
			_sdkId,
			documentId,
			key,
			rev,
		);
	}

	Future<DecryptedDocument> shareWith(String delegateId, DecryptedDocument document, { DocumentShareOptions? options }) async {
		return await CardinalSdkPlatformInterface.instance.apis.document.shareWith(
			_sdkId,
			delegateId,
			document,
			options,
		);
	}

	Future<DecryptedDocument> shareWithMany(DecryptedDocument document, Map<String, DocumentShareOptions> delegates) async {
		return await CardinalSdkPlatformInterface.instance.apis.document.shareWithMany(
			_sdkId,
			document,
			delegates,
		);
	}

	Future<PaginatedListIterator<DecryptedDocument>> filterDocumentsBy(FilterOptions<Document> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.document.filterDocumentsBy(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<DecryptedDocument>> filterDocumentsBySorted(SortableFilterOptions<Document> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.document.filterDocumentsBySorted(
			_sdkId,
			filter,
		);
	}

	Future<DecryptedDocument> createDocument(DecryptedDocument entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.document.createDocument(
			_sdkId,
			entity,
		);
	}

	Future<DecryptedDocument> undeleteDocumentById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.document.undeleteDocumentById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<DecryptedDocument> undeleteDocument(Document document) async {
		return await CardinalSdkPlatformInterface.instance.apis.document.undeleteDocument(
			_sdkId,
			document,
		);
	}

	Future<DecryptedDocument> modifyDocument(DecryptedDocument entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.document.modifyDocument(
			_sdkId,
			entity,
		);
	}

	Future<DecryptedDocument?> getDocument(String entityId) async {
		return await CardinalSdkPlatformInterface.instance.apis.document.getDocument(
			_sdkId,
			entityId,
		);
	}

	Future<List<DecryptedDocument>> getDocuments(List<String> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.document.getDocuments(
			_sdkId,
			entityIds,
		);
	}

	Future<List<DecryptedDocument>> modifyDocuments(List<DecryptedDocument> entities) async {
		return await CardinalSdkPlatformInterface.instance.apis.document.modifyDocuments(
			_sdkId,
			entities,
		);
	}
}

class DocumentTryAndRecoverApi {
	final String _sdkId;
	final Object _dartSdk;
	DocumentTryAndRecoverApi(
		this._sdkId,
		this._dartSdk
		);

	Future<Document> shareWith(String delegateId, Document document, { DocumentShareOptions? options }) async {
		return await CardinalSdkPlatformInterface.instance.apis.document.tryAndRecover.shareWith(
			_sdkId,
			delegateId,
			document,
			options,
		);
	}

	Future<Document> shareWithMany(Document document, Map<String, DocumentShareOptions> delegates) async {
		return await CardinalSdkPlatformInterface.instance.apis.document.tryAndRecover.shareWithMany(
			_sdkId,
			document,
			delegates,
		);
	}

	Future<PaginatedListIterator<Document>> filterDocumentsBy(FilterOptions<Document> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.document.tryAndRecover.filterDocumentsBy(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<Document>> filterDocumentsBySorted(SortableFilterOptions<Document> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.document.tryAndRecover.filterDocumentsBySorted(
			_sdkId,
			filter,
		);
	}

	Future<Document> createDocument(Document entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.document.tryAndRecover.createDocument(
			_sdkId,
			entity,
		);
	}

	Future<Document> undeleteDocumentById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.document.tryAndRecover.undeleteDocumentById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<Document> undeleteDocument(Document document) async {
		return await CardinalSdkPlatformInterface.instance.apis.document.tryAndRecover.undeleteDocument(
			_sdkId,
			document,
		);
	}

	Future<Document> modifyDocument(Document entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.document.tryAndRecover.modifyDocument(
			_sdkId,
			entity,
		);
	}

	Future<Document?> getDocument(String entityId) async {
		return await CardinalSdkPlatformInterface.instance.apis.document.tryAndRecover.getDocument(
			_sdkId,
			entityId,
		);
	}

	Future<List<Document>> getDocuments(List<String> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.document.tryAndRecover.getDocuments(
			_sdkId,
			entityIds,
		);
	}

	Future<List<Document>> modifyDocuments(List<Document> entities) async {
		return await CardinalSdkPlatformInterface.instance.apis.document.tryAndRecover.modifyDocuments(
			_sdkId,
			entities,
		);
	}
}

class DocumentEncryptedApi {
	final String _sdkId;
	final Object _dartSdk;
	DocumentEncryptedApi(
		this._sdkId,
		this._dartSdk
		);

	Future<EncryptedDocument> shareWith(String delegateId, EncryptedDocument document, { DocumentShareOptions? options }) async {
		return await CardinalSdkPlatformInterface.instance.apis.document.encrypted.shareWith(
			_sdkId,
			delegateId,
			document,
			options,
		);
	}

	Future<EncryptedDocument> shareWithMany(EncryptedDocument document, Map<String, DocumentShareOptions> delegates) async {
		return await CardinalSdkPlatformInterface.instance.apis.document.encrypted.shareWithMany(
			_sdkId,
			document,
			delegates,
		);
	}

	Future<PaginatedListIterator<EncryptedDocument>> filterDocumentsBy(FilterOptions<Document> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.document.encrypted.filterDocumentsBy(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<EncryptedDocument>> filterDocumentsBySorted(SortableFilterOptions<Document> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.document.encrypted.filterDocumentsBySorted(
			_sdkId,
			filter,
		);
	}

	Future<EncryptedDocument> createDocument(EncryptedDocument entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.document.encrypted.createDocument(
			_sdkId,
			entity,
		);
	}

	Future<EncryptedDocument> undeleteDocumentById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.document.encrypted.undeleteDocumentById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<EncryptedDocument> undeleteDocument(Document document) async {
		return await CardinalSdkPlatformInterface.instance.apis.document.encrypted.undeleteDocument(
			_sdkId,
			document,
		);
	}

	Future<EncryptedDocument> modifyDocument(EncryptedDocument entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.document.encrypted.modifyDocument(
			_sdkId,
			entity,
		);
	}

	Future<EncryptedDocument?> getDocument(String entityId) async {
		return await CardinalSdkPlatformInterface.instance.apis.document.encrypted.getDocument(
			_sdkId,
			entityId,
		);
	}

	Future<List<EncryptedDocument>> getDocuments(List<String> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.document.encrypted.getDocuments(
			_sdkId,
			entityIds,
		);
	}

	Future<List<EncryptedDocument>> modifyDocuments(List<EncryptedDocument> entities) async {
		return await CardinalSdkPlatformInterface.instance.apis.document.encrypted.modifyDocuments(
			_sdkId,
			entities,
		);
	}
}