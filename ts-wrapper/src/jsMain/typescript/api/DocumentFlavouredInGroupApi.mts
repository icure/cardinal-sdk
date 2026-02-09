// auto-generated file
import {FilterOptions, PaginatedListIterator, SortableFilterOptions} from '../cardinal-sdk-ts.mjs';
import {DocumentShareOptions} from '../crypto/entities/DocumentShareOptions.mjs';
import {Document} from '../model/Document.mjs';
import {EntityReferenceInGroup} from '../model/EntityReferenceInGroup.mjs';
import {GroupScoped} from '../model/GroupScoped.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';
import {ArrayWithUniqueKeys} from '../utils/ArrayWithUniqueKeys.mjs';


export interface DocumentFlavouredInGroupApi<E extends Document> {

	shareWith(delegate: EntityReferenceInGroup, document: GroupScoped<E>,
			options?: { options?: DocumentShareOptions | undefined }): Promise<GroupScoped<E>>;

	shareWithMany(document: GroupScoped<E>,
			delegates: ArrayWithUniqueKeys<{ delegate: EntityReferenceInGroup, shareOptions: DocumentShareOptions }, 'delegate'>): Promise<GroupScoped<E>>;

	filterDocumentsBy(groupId: string,
			filter: FilterOptions<Document>): Promise<PaginatedListIterator<GroupScoped<E>>>;

	filterDocumentsBySorted(groupId: string,
			filter: SortableFilterOptions<Document>): Promise<PaginatedListIterator<GroupScoped<E>>>;

	createDocument(entity: GroupScoped<E>): Promise<GroupScoped<E>>;

	createDocuments(entities: Array<GroupScoped<E>>): Promise<Array<GroupScoped<E>>>;

	undeleteDocumentById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<E>>;

	undeleteDocumentsByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<E>>>;

	undeleteDocument(document: GroupScoped<Document>): Promise<GroupScoped<E>>;

	undeleteDocuments(documents: Array<GroupScoped<E>>): Promise<Array<GroupScoped<E>>>;

	modifyDocument(entity: GroupScoped<E>): Promise<GroupScoped<E>>;

	modifyDocuments(entities: Array<GroupScoped<E>>): Promise<Array<GroupScoped<E>>>;

	getDocument(groupId: string, entityId: string): Promise<GroupScoped<E> | undefined>;

	getDocuments(groupId: string, entityIds: Array<string>): Promise<Array<GroupScoped<E>>>;

}
