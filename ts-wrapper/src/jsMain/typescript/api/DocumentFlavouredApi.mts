// auto-generated file
import {FilterOptions, PaginatedListIterator, SortableFilterOptions} from '../cardinal-sdk-ts.mjs';
import {DocumentShareOptions} from '../crypto/entities/DocumentShareOptions.mjs';
import {Document} from '../model/Document.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';


export interface DocumentFlavouredApi<E extends Document> {

	shareWith(delegateId: string, document: E,
			options?: { options?: DocumentShareOptions | undefined }): Promise<E>;

	shareWithMany(document: E, delegates: { [ key: string ]: DocumentShareOptions }): Promise<E>;

	filterDocumentsBy(filter: FilterOptions<Document>): Promise<PaginatedListIterator<E>>;

	filterDocumentsBySorted(filter: SortableFilterOptions<Document>): Promise<PaginatedListIterator<E>>;

	createDocument(entity: E): Promise<E>;

	createDocuments(entities: Array<E>): Promise<Array<E>>;

	undeleteDocumentById(id: string, rev: string): Promise<E>;

	undeleteDocumentsByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<E>>;

	undeleteDocument(document: Document): Promise<E>;

	undeleteDocuments(documents: Array<E>): Promise<Array<E>>;

	modifyDocument(entity: E): Promise<E>;

	modifyDocuments(entities: Array<E>): Promise<Array<E>>;

	getDocument(entityId: string): Promise<E | undefined>;

	getDocuments(entityIds: Array<string>): Promise<Array<E>>;

}
