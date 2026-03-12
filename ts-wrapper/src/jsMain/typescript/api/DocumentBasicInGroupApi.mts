// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, PaginatedListIterator} from '../cardinal-sdk-ts.mjs';
import {Document, EncryptedDocument} from '../model/Document.mjs';
import {GroupScoped} from '../model/GroupScoped.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';


export interface DocumentBasicInGroupApi {

	/**
	 *
	 *  In-group version of [DocumentBasicApi.matchDocumentsBy]
	 */
	matchDocumentsBy(groupId: string, filter: BaseFilterOptions<Document>): Promise<Array<string>>;

	/**
	 *
	 *  In-group version of [DocumentBasicApi.matchDocumentsBySorted]
	 */
	matchDocumentsBySorted(groupId: string,
			filter: BaseSortableFilterOptions<Document>): Promise<Array<string>>;

	/**
	 *
	 *  In-group version of [DocumentBasicApi.filterDocumentsBy]
	 */
	filterDocumentsBy(groupId: string,
			filter: BaseFilterOptions<Document>): Promise<PaginatedListIterator<GroupScoped<EncryptedDocument>>>;

	/**
	 *
	 *  In-group version of [DocumentBasicApi.filterDocumentsBySorted]
	 */
	filterDocumentsBySorted(groupId: string,
			filter: BaseSortableFilterOptions<Document>): Promise<PaginatedListIterator<GroupScoped<EncryptedDocument>>>;

	/**
	 *
	 *  In-group version of [DocumentBasicFlavourlessApi.deleteDocumentById]
	 */
	deleteDocumentById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<StoredDocumentIdentifier>>;

	/**
	 *
	 *  In-group version of [DocumentBasicFlavourlessApi.deleteDocumentsByIds]
	 */
	deleteDocumentsByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	/**
	 *
	 *  In-group version of [DocumentBasicFlavourlessApi.purgeDocumentById]
	 */
	purgeDocumentById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<void>;

	/**
	 *
	 *  In-group version of [DocumentBasicFlavourlessApi.purgeDocumentsByIds]
	 */
	purgeDocumentsByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	/**
	 *
	 *  In-group version of [DocumentBasicFlavourlessApi.deleteDocument]
	 */
	deleteDocument(document: GroupScoped<Document>): Promise<GroupScoped<StoredDocumentIdentifier>>;

	/**
	 *
	 *  In-group version of [DocumentBasicFlavourlessApi.deleteDocuments]
	 */
	deleteDocuments(documents: Array<GroupScoped<Document>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	/**
	 *
	 *  In-group version of [DocumentBasicFlavourlessApi.purgeDocument]
	 */
	purgeDocument(document: GroupScoped<Document>): Promise<void>;

	/**
	 *
	 *  In-group version of [DocumentBasicFlavourlessApi.purgeDocuments]
	 */
	purgeDocuments(documents: Array<GroupScoped<Document>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	/**
	 *
	 *  In-group version of [DocumentBasicFlavouredApi.createDocument].
	 */
	createDocument(entity: GroupScoped<EncryptedDocument>): Promise<GroupScoped<EncryptedDocument>>;

	/**
	 *
	 *  In-group version of [DocumentBasicFlavouredApi.createDocuments].
	 */
	createDocuments(entities: Array<GroupScoped<EncryptedDocument>>): Promise<Array<GroupScoped<EncryptedDocument>>>;

	/**
	 *
	 *  In-group version of [DocumentBasicFlavouredApi.undeleteDocumentById]
	 */
	undeleteDocumentById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<EncryptedDocument>>;

	/**
	 *
	 *  In-group version of [DocumentBasicFlavouredApi.undeleteDocumentsByIds]
	 */
	undeleteDocumentsByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<EncryptedDocument>>>;

	/**
	 *
	 *  In-group version of [DocumentBasicFlavouredApi.undeleteDocument]
	 */
	undeleteDocument(document: GroupScoped<Document>): Promise<GroupScoped<EncryptedDocument>>;

	/**
	 *
	 *  In-group version of [DocumentBasicFlavouredApi.undeleteDocuments]
	 */
	undeleteDocuments(documents: Array<GroupScoped<EncryptedDocument>>): Promise<Array<GroupScoped<EncryptedDocument>>>;

	/**
	 *
	 *  In-group version of [DocumentBasicFlavouredApi.modifyDocument]
	 */
	modifyDocument(entity: GroupScoped<EncryptedDocument>): Promise<GroupScoped<EncryptedDocument>>;

	/**
	 *
	 *  In-group version of [DocumentBasicFlavouredApi.modifyDocuments]
	 */
	modifyDocuments(entities: Array<GroupScoped<EncryptedDocument>>): Promise<Array<GroupScoped<EncryptedDocument>>>;

	/**
	 *
	 *  In-group version of [DocumentBasicFlavouredApi.getDocument]
	 */
	getDocument(groupId: string,
			entityId: string): Promise<GroupScoped<EncryptedDocument> | undefined>;

	/**
	 *
	 *  In-group version of [DocumentBasicFlavouredApi.getDocuments]
	 */
	getDocuments(groupId: string,
			entityIds: Array<string>): Promise<Array<GroupScoped<EncryptedDocument>>>;

}
