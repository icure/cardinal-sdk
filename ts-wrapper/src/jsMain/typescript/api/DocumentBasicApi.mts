// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, PaginatedListIterator} from '../cardinal-sdk-ts.mjs';
import {Document, EncryptedDocument} from '../model/Document.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';
import {DocumentBasicInGroupApi} from './DocumentBasicInGroupApi.mjs';


export interface DocumentBasicApi {

	inGroup: DocumentBasicInGroupApi;

	matchDocumentsBy(filter: BaseFilterOptions<Document>): Promise<Array<string>>;

	matchDocumentsBySorted(filter: BaseSortableFilterOptions<Document>): Promise<Array<string>>;

	filterDocumentsBy(filter: BaseFilterOptions<Document>): Promise<PaginatedListIterator<EncryptedDocument>>;

	filterDocumentsBySorted(filter: BaseSortableFilterOptions<Document>): Promise<PaginatedListIterator<EncryptedDocument>>;

	deleteDocumentById(entityId: string, rev: string): Promise<StoredDocumentIdentifier>;

	deleteDocumentsByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<StoredDocumentIdentifier>>;

	purgeDocumentById(id: string, rev: string): Promise<void>;

	purgeDocumentsByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<StoredDocumentIdentifier>>;

	deleteDocument(document: Document): Promise<StoredDocumentIdentifier>;

	deleteDocuments(documents: Array<Document>): Promise<Array<StoredDocumentIdentifier>>;

	purgeDocument(document: Document): Promise<void>;

	purgeDocuments(documents: Array<Document>): Promise<Array<StoredDocumentIdentifier>>;

	getRawMainAttachment(documentId: string): Promise<Int8Array>;

	getRawSecondaryAttachment(documentId: string, key: string): Promise<Int8Array>;

	setRawMainAttachment(
			documentId: string,
			rev: string,
			utis: Array<string> | undefined,
			attachment: Int8Array,
			encrypted: boolean
	): Promise<EncryptedDocument>;

	setRawSecondaryAttachment(
			documentId: string,
			key: string,
			rev: string,
			utis: Array<string> | undefined,
			attachment: Int8Array,
			encrypted: boolean
	): Promise<EncryptedDocument>;

	deleteMainAttachment(entityId: string, rev: string): Promise<EncryptedDocument>;

	deleteSecondaryAttachment(documentId: string, key: string,
			rev: string): Promise<EncryptedDocument>;

	createDocument(entity: EncryptedDocument): Promise<EncryptedDocument>;

	createDocuments(entities: Array<EncryptedDocument>): Promise<Array<EncryptedDocument>>;

	undeleteDocumentById(id: string, rev: string): Promise<EncryptedDocument>;

	undeleteDocumentsByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<EncryptedDocument>>;

	undeleteDocument(document: Document): Promise<EncryptedDocument>;

	undeleteDocuments(documents: Array<EncryptedDocument>): Promise<Array<EncryptedDocument>>;

	modifyDocument(entity: EncryptedDocument): Promise<EncryptedDocument>;

	modifyDocuments(entities: Array<EncryptedDocument>): Promise<Array<EncryptedDocument>>;

	getDocument(entityId: string): Promise<EncryptedDocument | undefined>;

	getDocuments(entityIds: Array<string>): Promise<Array<EncryptedDocument>>;

}
