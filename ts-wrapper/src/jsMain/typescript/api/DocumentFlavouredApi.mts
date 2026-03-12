// auto-generated file
import {FilterOptions, PaginatedListIterator, SortableFilterOptions} from '../cardinal-sdk-ts.mjs';
import {DocumentShareOptions} from '../crypto/entities/DocumentShareOptions.mjs';
import {Document} from '../model/Document.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';


export interface DocumentFlavouredApi<E extends Document> {

	/**
	 *
	 *  Share a document with another data owner. The document must already exist in the database for this method to
	 *  succeed. If you want to share the document before creation you should instead pass provide the delegates in
	 *  the initialize encryption metadata method.
	 *  Note: this method only updates the security metadata. If the input entity has unsaved changes they may be lost.
	 *  @param delegateId the owner that will gain access to the document
	 *  @param document the document to share with [delegateId]
	 *  @param options specifies how the document will be shared. By default, all data available to the current user
	 *  will be shared, and the delegate will have the same permissions as the current user on the document. Refer
	 *  to the documentation of [DocumentShareOptions] for more information.
	 *  @return the updated document if the sharing was successful, or details on the errors if the sharing failed.
	 */
	shareWith(delegateId: string, document: E,
			options?: { options?: DocumentShareOptions | undefined }): Promise<E>;

	/**
	 *
	 *  Share a document with multiple data owners. The document must already exist in the database for this method to
	 *  succeed. If you want to share the document before creation you should instead pass provide the delegates in
	 *  the initialize encryption metadata method.
	 *  Note: this method only updates the security metadata. If the input entity has unsaved changes they may be lost.
	 *  Throws an exception if the operation fails.
	 *  @param document the document to share
	 *  @param delegates specify the data owners which will gain access to the entity and the options for sharing with
	 *  each of them.
	 *  @return the updated document.
	 */
	shareWithMany(document: E, delegates: { [ key: string ]: DocumentShareOptions }): Promise<E>;

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
	filterDocumentsBy(filter: FilterOptions<Document>): Promise<PaginatedListIterator<E>>;

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
	filterDocumentsBySorted(filter: SortableFilterOptions<Document>): Promise<PaginatedListIterator<E>>;

	/**
	 *
	 *  Create a new document. The provided document must have the encryption metadata initialized.
	 *  @param entity a document with initialized encryption metadata
	 *  @return the created document with updated revision.
	 *  @throws IllegalArgumentException if the encryption metadata of the input was not initialized.
	 */
	createDocument(entity: E): Promise<E>;

	/**
	 *
	 *  Create a batch of new documents. All the provided documents must have the encryption metadata initialized.
	 *  @param entities the documents with initialized encryption metadata
	 *  @return the created documents with updated revision.
	 *  @throws IllegalArgumentException if the encryption metadata was not initialized in any of the entities.
	 */
	createDocuments(entities: Array<E>): Promise<Array<E>>;

	/**
	 *
	 *  Restores a document that was marked as deleted.
	 *  @param id the id of the entity
	 *  @param rev the latest revision of the entity.
	 *  @return the restored entity.
	 *  @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	undeleteDocumentById(id: string, rev: string): Promise<E>;

	/**
	 *
	 *  Restores a batch of documents that were marked as deleted.
	 *  @param entityIds the ids and the revisions of the documents to restore.
	 *  @return the restored documents. If some entities couldn't be restored (because the user does not have access or the revision is not
	 *  up-to-date), then those entities will not be restored and will not appear in this list.
	 */
	undeleteDocumentsByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<E>>;

	/**
	 *
	 *  Restores a document that was marked as deleted.
	 *  @param document the document to undelete
	 *  @return the restored document.
	 *  @throws RevisionConflictException if the provided document doesn't match the latest known revision
	 */
	undeleteDocument(document: Document): Promise<E>;

	/**
	 *
	 *  Restores a batch of documents that were marked as deleted.
	 *  @param documents the documents to restore.
	 *  @return the restored documents. If some entities couldn't be restored (because the user does not have access or the revision is not
	 *  up-to-date), then those entities will not be restored and will not appear in this list.
	 */
	undeleteDocuments(documents: Array<E>): Promise<Array<E>>;

	/**
	 *
	 *  Modifies a document. You need to have write access to the entity. Note that you can't use this method to
	 *  change the attachments and/or attachment metadata on the document. You should use various set attachment methods
	 *  instead.
	 *  Flavoured method.
	 *  @param entity a document with update content
	 *  @return the document updated with the provided content and a new revision.
	 */
	modifyDocument(entity: E): Promise<E>;

	/**
	 *
	 *  Modifies multiple documents. Ignores all documents for which you don't have write access.
	 *  Flavoured method.
	 *  @param entities documents with update content
	 *  @return the updated documents with a new revision. If some entities couldn't be updated (because the user does not have access or the revision is not
	 *  up-to-date), then those entities will not be updated and will not appear in this list.
	 */
	modifyDocuments(entities: Array<E>): Promise<Array<E>>;

	/**
	 *
	 *  Get a document by its id. You must have read access to the entity. Fails if the id does not correspond to any
	 *  entity, corresponds to an entity that is not a document, or corresponds to an entity for which you don't have
	 *  read access.
	 *  Flavoured method.
	 *  @param entityId a document id.
	 *  @return the document with id [entityId].
	 */
	getDocument(entityId: string): Promise<E | undefined>;

	/**
	 *
	 *  Get multiple documents by their ids. Ignores all ids that do not correspond to an entity, correspond to
	 *  an entity that is not a document, or correspond to an entity for which you don't have read access.
	 *  Flavoured method.
	 *  @param entityIds a list of documents ids
	 *  @return all documents that you can access with one of the provided ids.
	 */
	getDocuments(entityIds: Array<string>): Promise<Array<E>>;

}
