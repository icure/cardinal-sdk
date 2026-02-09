// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, PaginatedListIterator} from '../cardinal-sdk-ts.mjs';
import {Document, EncryptedDocument} from '../model/Document.mjs';
import {GroupScoped} from '../model/GroupScoped.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';


export interface DocumentBasicInGroupApi {

	matchDocumentsBy(groupId: string, filter: BaseFilterOptions<Document>): Promise<Array<string>>;

	matchDocumentsBySorted(groupId: string,
			filter: BaseSortableFilterOptions<Document>): Promise<Array<string>>;

	filterDocumentsBy(groupId: string,
			filter: BaseFilterOptions<Document>): Promise<PaginatedListIterator<GroupScoped<EncryptedDocument>>>;

	filterDocumentsBySorted(groupId: string,
			filter: BaseSortableFilterOptions<Document>): Promise<PaginatedListIterator<GroupScoped<EncryptedDocument>>>;

	deleteDocumentById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<StoredDocumentIdentifier>>;

	deleteDocumentsByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	purgeDocumentById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<void>;

	purgeDocumentsByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	deleteDocument(document: GroupScoped<Document>): Promise<GroupScoped<StoredDocumentIdentifier>>;

	deleteDocuments(documents: Array<GroupScoped<Document>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	purgeDocument(document: GroupScoped<Document>): Promise<void>;

	purgeDocuments(documents: Array<GroupScoped<Document>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	createDocument(entity: GroupScoped<EncryptedDocument>): Promise<GroupScoped<EncryptedDocument>>;

	createDocuments(entities: Array<GroupScoped<EncryptedDocument>>): Promise<Array<GroupScoped<EncryptedDocument>>>;

	undeleteDocumentById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<EncryptedDocument>>;

	undeleteDocumentsByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<EncryptedDocument>>>;

	undeleteDocument(document: GroupScoped<Document>): Promise<GroupScoped<EncryptedDocument>>;

	undeleteDocuments(documents: Array<GroupScoped<EncryptedDocument>>): Promise<Array<GroupScoped<EncryptedDocument>>>;

	modifyDocument(entity: GroupScoped<EncryptedDocument>): Promise<GroupScoped<EncryptedDocument>>;

	modifyDocuments(entities: Array<GroupScoped<EncryptedDocument>>): Promise<Array<GroupScoped<EncryptedDocument>>>;

	getDocument(groupId: string,
			entityId: string): Promise<GroupScoped<EncryptedDocument> | undefined>;

	getDocuments(groupId: string,
			entityIds: Array<string>): Promise<Array<GroupScoped<EncryptedDocument>>>;

}
