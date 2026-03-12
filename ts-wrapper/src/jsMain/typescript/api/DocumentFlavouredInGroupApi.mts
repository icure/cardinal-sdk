// auto-generated file
import {FilterOptions, PaginatedListIterator, SortableFilterOptions} from '../cardinal-sdk-ts.mjs';
import {DocumentShareOptions} from '../crypto/entities/DocumentShareOptions.mjs';
import {Document} from '../model/Document.mjs';
import {EntityReferenceInGroup} from '../model/EntityReferenceInGroup.mjs';
import {GroupScoped} from '../model/GroupScoped.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';
import {ArrayWithUniqueKeys} from '../utils/ArrayWithUniqueKeys.mjs';


export interface DocumentFlavouredInGroupApi<E extends Document> {

	/**
	 *
	 *  In-group version of [DocumentFlavouredApi.shareWith]
	 */
	shareWith(delegate: EntityReferenceInGroup, document: GroupScoped<E>,
			options?: { options?: DocumentShareOptions | undefined }): Promise<GroupScoped<E>>;

	/**
	 *
	 *  In-group version of [DocumentFlavouredApi.shareWithMany]
	 */
	shareWithMany(document: GroupScoped<E>,
			delegates: ArrayWithUniqueKeys<{ delegate: EntityReferenceInGroup, shareOptions: DocumentShareOptions }, 'delegate'>): Promise<GroupScoped<E>>;

	/**
	 *
	 *  In-group version of [DocumentFlavouredApi.filterDocumentsBy]
	 */
	filterDocumentsBy(groupId: string,
			filter: FilterOptions<Document>): Promise<PaginatedListIterator<GroupScoped<E>>>;

	/**
	 *
	 *  In-group version of [DocumentFlavouredApi.filterDocumentsBySorted]
	 */
	filterDocumentsBySorted(groupId: string,
			filter: SortableFilterOptions<Document>): Promise<PaginatedListIterator<GroupScoped<E>>>;

	/**
	 *
	 *  In-group version of [DocumentBasicFlavouredApi.createDocument].
	 */
	createDocument(entity: GroupScoped<E>): Promise<GroupScoped<E>>;

	/**
	 *
	 *  In-group version of [DocumentBasicFlavouredApi.createDocuments].
	 */
	createDocuments(entities: Array<GroupScoped<E>>): Promise<Array<GroupScoped<E>>>;

	/**
	 *
	 *  In-group version of [DocumentBasicFlavouredApi.undeleteDocumentById]
	 */
	undeleteDocumentById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<E>>;

	/**
	 *
	 *  In-group version of [DocumentBasicFlavouredApi.undeleteDocumentsByIds]
	 */
	undeleteDocumentsByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<E>>>;

	/**
	 *
	 *  In-group version of [DocumentBasicFlavouredApi.undeleteDocument]
	 */
	undeleteDocument(document: GroupScoped<Document>): Promise<GroupScoped<E>>;

	/**
	 *
	 *  In-group version of [DocumentBasicFlavouredApi.undeleteDocuments]
	 */
	undeleteDocuments(documents: Array<GroupScoped<E>>): Promise<Array<GroupScoped<E>>>;

	/**
	 *
	 *  In-group version of [DocumentBasicFlavouredApi.modifyDocument]
	 */
	modifyDocument(entity: GroupScoped<E>): Promise<GroupScoped<E>>;

	/**
	 *
	 *  In-group version of [DocumentBasicFlavouredApi.modifyDocuments]
	 */
	modifyDocuments(entities: Array<GroupScoped<E>>): Promise<Array<GroupScoped<E>>>;

	/**
	 *
	 *  In-group version of [DocumentBasicFlavouredApi.getDocument]
	 */
	getDocument(groupId: string, entityId: string): Promise<GroupScoped<E> | undefined>;

	/**
	 *
	 *  In-group version of [DocumentBasicFlavouredApi.getDocuments]
	 */
	getDocuments(groupId: string, entityIds: Array<string>): Promise<Array<GroupScoped<E>>>;

}
