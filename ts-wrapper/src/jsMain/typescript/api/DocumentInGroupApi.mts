// auto-generated file
import {FilterOptions, PaginatedListIterator, SortableFilterOptions} from '../cardinal-sdk-ts.mjs';
import {DocumentShareOptions} from '../crypto/entities/DocumentShareOptions.mjs';
import {SecretIdUseOption} from '../crypto/entities/SecretIdUseOption.mjs';
import {DecryptedDocument, Document, EncryptedDocument} from '../model/Document.mjs';
import {EntityReferenceInGroup} from '../model/EntityReferenceInGroup.mjs';
import {GroupScoped} from '../model/GroupScoped.mjs';
import {Message} from '../model/Message.mjs';
import {Patient} from '../model/Patient.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';
import {User} from '../model/User.mjs';
import {AccessLevel} from '../model/embed/AccessLevel.mjs';
import {HexString} from '../model/specializations/HexString.mjs';
import {ArrayWithUniqueKeys} from '../utils/ArrayWithUniqueKeys.mjs';
import {DocumentFlavouredInGroupApi} from './DocumentFlavouredInGroupApi.mjs';


export interface DocumentInGroupApi {

	encrypted: DocumentFlavouredInGroupApi<EncryptedDocument>;

	tryAndRecover: DocumentFlavouredInGroupApi<Document>;

	withEncryptionMetadataLinkedToMessage(entityGroupId: string, base: DecryptedDocument | undefined,
			message: GroupScoped<Message>,
			options?: { user?: User | undefined, delegates?: { [ key: string ]: AccessLevel }, secretId?: SecretIdUseOption, alternateRootDelegateId?: string | undefined }): Promise<GroupScoped<DecryptedDocument>>;

	withEncryptionMetadataLinkedToPatient(entityGroupId: string, base: DecryptedDocument | undefined,
			patient: GroupScoped<Patient>,
			options?: { user?: User | undefined, delegates?: { [ key: string ]: AccessLevel }, secretId?: SecretIdUseOption, alternateRootDelegateId?: string | undefined }): Promise<GroupScoped<DecryptedDocument>>;

	withEncryptionMetadataUnlinked(entityGroupId: string, base: DecryptedDocument | undefined,
			options?: { user?: User | undefined, delegates?: { [ key: string ]: AccessLevel }, alternateRootDelegateId?: string | undefined }): Promise<GroupScoped<DecryptedDocument>>;

	getEncryptionKeysOf(document: GroupScoped<Document>): Promise<Array<HexString>>;

	hasWriteAccess(document: GroupScoped<Document>): Promise<boolean>;

	decryptOwningEntityIdsOf(document: GroupScoped<Document>): Promise<Array<EntityReferenceInGroup>>;

	createDelegationDeAnonymizationMetadata(entity: GroupScoped<Document>,
			delegates: Array<EntityReferenceInGroup>): Promise<void>;

	decrypt(documents: Array<GroupScoped<EncryptedDocument>>): Promise<Array<GroupScoped<DecryptedDocument>>>;

	tryDecrypt(documents: Array<GroupScoped<EncryptedDocument>>): Promise<Array<GroupScoped<Document>>>;

	matchDocumentsBy(groupId: string, filter: FilterOptions<Document>): Promise<Array<string>>;

	matchDocumentsBySorted(groupId: string,
			filter: SortableFilterOptions<Document>): Promise<Array<string>>;

	deleteDocumentById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<StoredDocumentIdentifier>>;

	deleteDocumentsByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	purgeDocumentById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<void>;

	purgeDocumentsByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	deleteDocument(document: GroupScoped<Document>): Promise<GroupScoped<StoredDocumentIdentifier>>;

	deleteDocuments(documents: Array<GroupScoped<Document>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	purgeDocument(document: GroupScoped<Document>): Promise<void>;

	purgeDocuments(documents: Array<GroupScoped<Document>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	shareWith(delegate: EntityReferenceInGroup, document: GroupScoped<DecryptedDocument>,
			options?: { options?: DocumentShareOptions | undefined }): Promise<GroupScoped<DecryptedDocument>>;

	shareWithMany(document: GroupScoped<DecryptedDocument>,
			delegates: ArrayWithUniqueKeys<{ delegate: EntityReferenceInGroup, shareOptions: DocumentShareOptions }, 'delegate'>): Promise<GroupScoped<DecryptedDocument>>;

	filterDocumentsBy(groupId: string,
			filter: FilterOptions<Document>): Promise<PaginatedListIterator<GroupScoped<DecryptedDocument>>>;

	filterDocumentsBySorted(groupId: string,
			filter: SortableFilterOptions<Document>): Promise<PaginatedListIterator<GroupScoped<DecryptedDocument>>>;

	createDocument(entity: GroupScoped<DecryptedDocument>): Promise<GroupScoped<DecryptedDocument>>;

	createDocuments(entities: Array<GroupScoped<DecryptedDocument>>): Promise<Array<GroupScoped<DecryptedDocument>>>;

	undeleteDocumentById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<DecryptedDocument>>;

	undeleteDocumentsByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<DecryptedDocument>>>;

	undeleteDocument(document: GroupScoped<Document>): Promise<GroupScoped<DecryptedDocument>>;

	undeleteDocuments(documents: Array<GroupScoped<DecryptedDocument>>): Promise<Array<GroupScoped<DecryptedDocument>>>;

	modifyDocument(entity: GroupScoped<DecryptedDocument>): Promise<GroupScoped<DecryptedDocument>>;

	modifyDocuments(entities: Array<GroupScoped<DecryptedDocument>>): Promise<Array<GroupScoped<DecryptedDocument>>>;

	getDocument(groupId: string,
			entityId: string): Promise<GroupScoped<DecryptedDocument> | undefined>;

	getDocuments(groupId: string,
			entityIds: Array<string>): Promise<Array<GroupScoped<DecryptedDocument>>>;

}
