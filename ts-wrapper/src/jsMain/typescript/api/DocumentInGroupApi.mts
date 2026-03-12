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

	/**
	 *
	 *  In-group version of [DocumentApi.withEncryptionMetadataLinkedToMessage]
	 */
	withEncryptionMetadataLinkedToMessage(entityGroupId: string, base: DecryptedDocument | undefined,
			message: GroupScoped<Message>,
			options?: { user?: User | undefined, delegates?: { [ key: string ]: AccessLevel }, secretId?: SecretIdUseOption, alternateRootDelegateId?: string | undefined }): Promise<GroupScoped<DecryptedDocument>>;

	/**
	 *
	 *  In-group version of [DocumentApi.withEncryptionMetadataLinkedToPatient]
	 */
	withEncryptionMetadataLinkedToPatient(entityGroupId: string, base: DecryptedDocument | undefined,
			patient: GroupScoped<Patient>,
			options?: { user?: User | undefined, delegates?: { [ key: string ]: AccessLevel }, secretId?: SecretIdUseOption, alternateRootDelegateId?: string | undefined }): Promise<GroupScoped<DecryptedDocument>>;

	/**
	 *
	 *  In-group version of [DocumentApi.withEncryptionMetadataUnlinked]
	 */
	withEncryptionMetadataUnlinked(entityGroupId: string, base: DecryptedDocument | undefined,
			options?: { user?: User | undefined, delegates?: { [ key: string ]: AccessLevel }, alternateRootDelegateId?: string | undefined }): Promise<GroupScoped<DecryptedDocument>>;

	/**
	 *
	 *  In-group version of [DocumentApi.getEncryptionKeysOf]
	 */
	getEncryptionKeysOf(document: GroupScoped<Document>): Promise<Array<HexString>>;

	/**
	 *
	 *  In-group version of [DocumentApi.hasWriteAccess]
	 */
	hasWriteAccess(document: GroupScoped<Document>): Promise<boolean>;

	/**
	 *
	 *  In-group version of [DocumentApi.decryptOwningEntityIdsOf]
	 */
	decryptOwningEntityIdsOf(document: GroupScoped<Document>): Promise<Array<EntityReferenceInGroup>>;

	/**
	 *
	 *  In-group version of [DocumentApi.createDelegationDeAnonymizationMetadata]
	 */
	createDelegationDeAnonymizationMetadata(entity: GroupScoped<Document>,
			delegates: Array<EntityReferenceInGroup>): Promise<void>;

	/**
	 *
	 *  In-group version of [DocumentApi.decrypt]
	 */
	decrypt(documents: Array<GroupScoped<EncryptedDocument>>): Promise<Array<GroupScoped<DecryptedDocument>>>;

	/**
	 *
	 *  In-group version of [DocumentApi.tryDecrypt]
	 */
	tryDecrypt(documents: Array<GroupScoped<EncryptedDocument>>): Promise<Array<GroupScoped<Document>>>;

	/**
	 *
	 *  In-group version of [DocumentApi.matchDocumentsBy]
	 */
	matchDocumentsBy(groupId: string, filter: FilterOptions<Document>): Promise<Array<string>>;

	/**
	 *
	 *  In-group version of [DocumentApi.matchDocumentsBySorted]
	 */
	matchDocumentsBySorted(groupId: string,
			filter: SortableFilterOptions<Document>): Promise<Array<string>>;

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
	 *  In-group version of [DocumentFlavouredApi.shareWith]
	 */
	shareWith(delegate: EntityReferenceInGroup, document: GroupScoped<DecryptedDocument>,
			options?: { options?: DocumentShareOptions | undefined }): Promise<GroupScoped<DecryptedDocument>>;

	/**
	 *
	 *  In-group version of [DocumentFlavouredApi.shareWithMany]
	 */
	shareWithMany(document: GroupScoped<DecryptedDocument>,
			delegates: ArrayWithUniqueKeys<{ delegate: EntityReferenceInGroup, shareOptions: DocumentShareOptions }, 'delegate'>): Promise<GroupScoped<DecryptedDocument>>;

	/**
	 *
	 *  In-group version of [DocumentFlavouredApi.filterDocumentsBy]
	 */
	filterDocumentsBy(groupId: string,
			filter: FilterOptions<Document>): Promise<PaginatedListIterator<GroupScoped<DecryptedDocument>>>;

	/**
	 *
	 *  In-group version of [DocumentFlavouredApi.filterDocumentsBySorted]
	 */
	filterDocumentsBySorted(groupId: string,
			filter: SortableFilterOptions<Document>): Promise<PaginatedListIterator<GroupScoped<DecryptedDocument>>>;

	/**
	 *
	 *  In-group version of [DocumentBasicFlavouredApi.createDocument].
	 */
	createDocument(entity: GroupScoped<DecryptedDocument>): Promise<GroupScoped<DecryptedDocument>>;

	/**
	 *
	 *  In-group version of [DocumentBasicFlavouredApi.createDocuments].
	 */
	createDocuments(entities: Array<GroupScoped<DecryptedDocument>>): Promise<Array<GroupScoped<DecryptedDocument>>>;

	/**
	 *
	 *  In-group version of [DocumentBasicFlavouredApi.undeleteDocumentById]
	 */
	undeleteDocumentById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<DecryptedDocument>>;

	/**
	 *
	 *  In-group version of [DocumentBasicFlavouredApi.undeleteDocumentsByIds]
	 */
	undeleteDocumentsByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<DecryptedDocument>>>;

	/**
	 *
	 *  In-group version of [DocumentBasicFlavouredApi.undeleteDocument]
	 */
	undeleteDocument(document: GroupScoped<Document>): Promise<GroupScoped<DecryptedDocument>>;

	/**
	 *
	 *  In-group version of [DocumentBasicFlavouredApi.undeleteDocuments]
	 */
	undeleteDocuments(documents: Array<GroupScoped<DecryptedDocument>>): Promise<Array<GroupScoped<DecryptedDocument>>>;

	/**
	 *
	 *  In-group version of [DocumentBasicFlavouredApi.modifyDocument]
	 */
	modifyDocument(entity: GroupScoped<DecryptedDocument>): Promise<GroupScoped<DecryptedDocument>>;

	/**
	 *
	 *  In-group version of [DocumentBasicFlavouredApi.modifyDocuments]
	 */
	modifyDocuments(entities: Array<GroupScoped<DecryptedDocument>>): Promise<Array<GroupScoped<DecryptedDocument>>>;

	/**
	 *
	 *  In-group version of [DocumentBasicFlavouredApi.getDocument]
	 */
	getDocument(groupId: string,
			entityId: string): Promise<GroupScoped<DecryptedDocument> | undefined>;

	/**
	 *
	 *  In-group version of [DocumentBasicFlavouredApi.getDocuments]
	 */
	getDocuments(groupId: string,
			entityIds: Array<string>): Promise<Array<GroupScoped<DecryptedDocument>>>;

}
