// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, PaginatedListIterator} from '../cardinal-sdk-ts.mjs';
import {Document, EncryptedDocument} from '../model/Document.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';
import {DocumentBasicInGroupApi} from './DocumentBasicInGroupApi.mjs';


export interface DocumentBasicApi {

	inGroup: DocumentBasicInGroupApi;

	/**
	 *
	 *  Get the ids of all documents matching the provided filter.
	 *
	 *  This method does not guarantee that the returned data will be ordered when using sortable filter options.
	 *  Even if the data obtained from an invocation of the method appears to be ordered, any changes to the stored data,
	 *  or to the internal iCure implementations, may cause future invocations to return unordered data.
	 *  If you need ordered data use [matchDocumentsBySorted] instead.
	 *
	 *  @param filter a document filter
	 *  @return a list of document ids
	 */
	matchDocumentsBy(filter: BaseFilterOptions<Document>): Promise<Array<string>>;

	/**
	 *
	 *  Get the ids of all documents matching the provided filter.
	 *
	 *  This method guarantees that the returned data will be ordered using the rules specified by the provided filter,
	 *  but the operation may take longer than [matchDocumentsBy].
	 *
	 *  @param filter a document filter
	 *  @return a list of document ids
	 */
	matchDocumentsBySorted(filter: BaseSortableFilterOptions<Document>): Promise<Array<string>>;

	/**
	 *
	 *  Get an iterator that iterates through all documents matching the provided filter, executing multiple requests to
	 *  the api if needed.
	 *
	 *  This method does not guarantee that the returned data will be ordered when using sortable filter options.
	 *  Even if the data obtained from an invocation of the method appears to be ordered, any changes to the stored data,
	 *  or to the internal iCure implementations, may cause future invocations to return unordered data.
	 *  If you need ordered data use [filterDocumentsBySorted] instead.
	 *
	 *  @param filter a document filter
	 *  @return an iterator that iterates over all documents matching the provided filter.
	 */
	filterDocumentsBy(filter: BaseFilterOptions<Document>): Promise<PaginatedListIterator<EncryptedDocument>>;

	/**
	 *
	 *  Get an iterator that iterates through all documents matching the provided filter, executing multiple requests to
	 *  the api if needed.
	 *
	 *  This method guarantees that the returned data will be ordered using the rules specified by the provided filter,
	 *  but the operation may take longer than [filterDocumentsBy].
	 *
	 *  @param filter a document filter
	 *  @return an iterator that iterates over all documents matching the provided filter.
	 */
	filterDocumentsBySorted(filter: BaseSortableFilterOptions<Document>): Promise<PaginatedListIterator<EncryptedDocument>>;

	/**
	 *
	 *  Deletes a document. If you don't have write access to the document the method will fail.
	 *  @param entityId id of the document.
	 *  @param rev the latest known rev of the document to delete
	 *  @return the id and revision of the deleted document.
	 *  @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	deleteDocumentById(entityId: string, rev: string): Promise<StoredDocumentIdentifier>;

	/**
	 *
	 *  Deletes many documents. Ids that don't correspond to an entity, or that correspond to an entity for which
	 *  you don't have write access will be ignored.
	 *  @param entityIds ids and revisions of the documents to delete.
	 *  @return the id and revision of the deleted documents. If some entities couldn't be deleted (for example
	 *  because you had no write access to them) they will not be included in this list.
	 */
	deleteDocumentsByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<StoredDocumentIdentifier>>;

	/**
	 *
	 *  Permanently deletes a document.
	 *  @param id id of the document to purge
	 *  @param rev latest revision of the document
	 *  @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	purgeDocumentById(id: string, rev: string): Promise<void>;

	/**
	 *
	 *  Permanently deletes many documents.
	 *  @param entityIds ids and revisions of the documents to delete
	 *  @return the id and revision of the deleted documents. If some entities couldn't be deleted (for example
	 *  because you had no write access to them) they will not be included in this list.
	 */
	purgeDocumentsByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<StoredDocumentIdentifier>>;

	/**
	 *
	 *  Deletes a document. If you don't have write access to the document the method will fail.
	 *  @param document the document to delete
	 *  @return the id and revision of the deleted document.
	 *  @throws RevisionConflictException if the provided document doesn't match the latest known revision
	 */
	deleteDocument(document: Document): Promise<StoredDocumentIdentifier>;

	/**
	 *
	 *  Deletes many documents. Ignores document for which you don't have write access or that don't match the latest revision.
	 *  @param documents the documents to delete
	 *  @return the id and revision of the deleted documents. If some entities couldn't be deleted they will not be
	 *  included in this list.
	 */
	deleteDocuments(documents: Array<Document>): Promise<Array<StoredDocumentIdentifier>>;

	/**
	 *
	 *  Permanently deletes a document.
	 *  @param document the document to purge.
	 *  @throws RevisionConflictException if the provided document doesn't match the latest known revision
	 */
	purgeDocument(document: Document): Promise<void>;

	/**
	 *
	 *  Permanently deletes many documents.
	 *  @param documents the documents to purge.
	 *  @return the id and revision of the deleted documents. If some entities couldn't be deleted (for example
	 *  because you had no write access to them) they will not be included in this list.
	 */
	purgeDocuments(documents: Array<Document>): Promise<Array<StoredDocumentIdentifier>>;

	/**
	 *
	 *  Get the main attachment from the document with the provided id as raw bytes. This method will not
	 *  perform any transformation on the attachment, and if the attachment was encrypted the returned data is encrypted.
	 *  @param documentId a document id
	 *  @return the main attachment of the document with id [documentId], as stored in the backend.
	 */
	getRawMainAttachment(documentId: string): Promise<Int8Array>;

	/**
	 *
	 *  Get the secondary attachment at [key] from the document with the provided id as raw bytes. This method will not
	 *  perform any transformation on the attachment, and if the attachment was encrypted the returned data is encrypted.
	 *  @param documentId a document id
	 *  @param key the key of the secondary attachment to retrieve.
	 *  @return the secondary attachment at [key] of the document with id [documentId], as stored in the backend.
	 */
	getRawSecondaryAttachment(documentId: string, key: string): Promise<Int8Array>;

	/**
	 *
	 *  Sets the main attachment for a document without performing any transformation. Most notably the attachment
	 *  will not be encrypted by this method.
	 *  If a main attachment already exist on the document it will be replaced.
	 *  @param documentId the id of the document.
	 *
	 *  @param rev the revision of the document
	 *  @param utis uniform type identifiers for the attachment (https://en.wikipedia.org/wiki/Uniform_Type_Identifier).
	 *  If null and there is already a main attachment for the document the current utis will be reused, otherwise it
	 *  null will be considered as an empty list. In all other cases overwrites any existing value.
	 *  @param attachment the attachment to set
	 *  @param encrypted specifies if the attachment you provided is encrypted or not. This will only be used to
	 *  have a more accurate representation of the type of attachment in the attachment storage servers; the document
	 *  entity won't be affected by this value.
	 *  @return the updated document
	 */
	setRawMainAttachment(
			documentId: string,
			rev: string,
			utis: Array<string> | undefined,
			attachment: Int8Array,
			encrypted: boolean
	): Promise<EncryptedDocument>;

	/**
	 *
	 *  Sets the secondary attachment at the provided key for a document without performing any transformation. Most
	 *  notably the attachment will not be encrypted by this method.
	 *  If there is already a secondary attachment for the provided key on the document it will be replaced.
	 *  @param documentId the id of the document.
	 *  @param key a key to distinguish the secondary attachment from other secondary attachments. The key can be any
	 *  string except for the [documentId], which is by convention reserved for the main attachment of the document.
	 *  @param rev the revision of the document
	 *  @param utis uniform type identifiers for the attachment (https://en.wikipedia.org/wiki/Uniform_Type_Identifier).
	 *  If null and there is already a secondary attachment at key for the document the current utis will be reused,
	 *  otherwise it null will be considered as an empty list. In all other cases overwrites any existing value.
	 *  @param attachment the attachment to set
	 *  @param encrypted specifies if the attachment you provided is encrypted or not. This will only be used to
	 *  have a more accurate representation of the type of attachment in the attachment storage servers; the document
	 *  entity won't be affected by this value.
	 *  @return the updated document
	 */
	setRawSecondaryAttachment(
			documentId: string,
			key: string,
			rev: string,
			utis: Array<string> | undefined,
			attachment: Int8Array,
			encrypted: boolean
	): Promise<EncryptedDocument>;

	/**
	 *
	 *  Deletes the main attachment of a document.
	 *  @param entityId the id of the document
	 *  @param rev the last known revision of the document
	 *  @return the updated document
	 */
	deleteMainAttachment(entityId: string, rev: string): Promise<EncryptedDocument>;

	/**
	 *
	 *  Deletes a secondary attachment of a document.
	 *  @param documentId the id of the document
	 *  @param key key of the secondary attachment to delete
	 *  @param rev the last known revision of the document
	 *  @return the updated document
	 */
	deleteSecondaryAttachment(documentId: string, key: string,
			rev: string): Promise<EncryptedDocument>;

	/**
	 *
	 *  Create a new document. The provided document must have the encryption metadata initialized.
	 *  @param entity a document with initialized encryption metadata
	 *  @return the created document with updated revision.
	 *  @throws IllegalArgumentException if the encryption metadata of the input was not initialized.
	 */
	createDocument(entity: EncryptedDocument): Promise<EncryptedDocument>;

	/**
	 *
	 *  Create a batch of new documents. All the provided documents must have the encryption metadata initialized.
	 *  @param entities the documents with initialized encryption metadata
	 *  @return the created documents with updated revision.
	 *  @throws IllegalArgumentException if the encryption metadata was not initialized in any of the entities.
	 */
	createDocuments(entities: Array<EncryptedDocument>): Promise<Array<EncryptedDocument>>;

	/**
	 *
	 *  Restores a document that was marked as deleted.
	 *  @param id the id of the entity
	 *  @param rev the latest revision of the entity.
	 *  @return the restored entity.
	 *  @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	undeleteDocumentById(id: string, rev: string): Promise<EncryptedDocument>;

	/**
	 *
	 *  Restores a batch of documents that were marked as deleted.
	 *  @param entityIds the ids and the revisions of the documents to restore.
	 *  @return the restored documents. If some entities couldn't be restored (because the user does not have access or the revision is not
	 *  up-to-date), then those entities will not be restored and will not appear in this list.
	 */
	undeleteDocumentsByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<EncryptedDocument>>;

	/**
	 *
	 *  Restores a document that was marked as deleted.
	 *  @param document the document to undelete
	 *  @return the restored document.
	 *  @throws RevisionConflictException if the provided document doesn't match the latest known revision
	 */
	undeleteDocument(document: Document): Promise<EncryptedDocument>;

	/**
	 *
	 *  Restores a batch of documents that were marked as deleted.
	 *  @param documents the documents to restore.
	 *  @return the restored documents. If some entities couldn't be restored (because the user does not have access or the revision is not
	 *  up-to-date), then those entities will not be restored and will not appear in this list.
	 */
	undeleteDocuments(documents: Array<EncryptedDocument>): Promise<Array<EncryptedDocument>>;

	/**
	 *
	 *  Modifies a document. You need to have write access to the entity. Note that you can't use this method to
	 *  change the attachments and/or attachment metadata on the document. You should use various set attachment methods
	 *  instead.
	 *  Flavoured method.
	 *  @param entity a document with update content
	 *  @return the document updated with the provided content and a new revision.
	 */
	modifyDocument(entity: EncryptedDocument): Promise<EncryptedDocument>;

	/**
	 *
	 *  Modifies multiple documents. Ignores all documents for which you don't have write access.
	 *  Flavoured method.
	 *  @param entities documents with update content
	 *  @return the updated documents with a new revision. If some entities couldn't be updated (because the user does not have access or the revision is not
	 *  up-to-date), then those entities will not be updated and will not appear in this list.
	 */
	modifyDocuments(entities: Array<EncryptedDocument>): Promise<Array<EncryptedDocument>>;

	/**
	 *
	 *  Get a document by its id. You must have read access to the entity. Fails if the id does not correspond to any
	 *  entity, corresponds to an entity that is not a document, or corresponds to an entity for which you don't have
	 *  read access.
	 *  Flavoured method.
	 *  @param entityId a document id.
	 *  @return the document with id [entityId].
	 */
	getDocument(entityId: string): Promise<EncryptedDocument | undefined>;

	/**
	 *
	 *  Get multiple documents by their ids. Ignores all ids that do not correspond to an entity, correspond to
	 *  an entity that is not a document, or correspond to an entity for which you don't have read access.
	 *  Flavoured method.
	 *  @param entityIds a list of documents ids
	 *  @return all documents that you can access with one of the provided ids.
	 */
	getDocuments(entityIds: Array<string>): Promise<Array<EncryptedDocument>>;

}
