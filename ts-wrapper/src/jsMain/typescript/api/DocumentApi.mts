// auto-generated file
import {FilterOptions, PaginatedListIterator, SortableFilterOptions} from '../cardinal-sdk-ts.mjs';
import {DocumentShareOptions} from '../crypto/entities/DocumentShareOptions.mjs';
import {SecretIdUseOption} from '../crypto/entities/SecretIdUseOption.mjs';
import {DecryptedDocument, Document, EncryptedDocument} from '../model/Document.mjs';
import {EntityReferenceInGroup} from '../model/EntityReferenceInGroup.mjs';
import {Message} from '../model/Message.mjs';
import {Patient} from '../model/Patient.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';
import {User} from '../model/User.mjs';
import {AccessLevel} from '../model/embed/AccessLevel.mjs';
import {HexString} from '../model/specializations/HexString.mjs';
import {DocumentFlavouredApi} from './DocumentFlavouredApi.mjs';
import {DocumentInGroupApi} from './DocumentInGroupApi.mjs';


export interface DocumentApi {

	encrypted: DocumentFlavouredApi<EncryptedDocument>;

	tryAndRecover: DocumentFlavouredApi<Document>;

	inGroup: DocumentInGroupApi;

	withEncryptionMetadataLinkedToMessage(base: DecryptedDocument | undefined, message: Message,
			options?: { user?: User | undefined, delegates?: { [ key: string ]: AccessLevel }, secretId?: SecretIdUseOption, alternateRootDelegateId?: string | undefined }): Promise<DecryptedDocument>;

	withEncryptionMetadataLinkedToPatient(base: DecryptedDocument | undefined, patient: Patient,
			options?: { user?: User | undefined, delegates?: { [ key: string ]: AccessLevel }, secretId?: SecretIdUseOption, alternateRootDelegateId?: string | undefined }): Promise<DecryptedDocument>;

	withEncryptionMetadataUnlinked(base: DecryptedDocument | undefined,
			options?: { user?: User | undefined, delegates?: { [ key: string ]: AccessLevel }, alternateRootDelegateId?: string | undefined }): Promise<DecryptedDocument>;

	getAndTryDecryptMainAttachment(document: Document,
			options?: { decryptedAttachmentValidator?: (x1: Int8Array) => Promise<boolean> }): Promise<Int8Array | undefined>;

	getAndDecryptMainAttachment(document: Document,
			options?: { decryptedAttachmentValidator?: (x1: Int8Array) => Promise<boolean> }): Promise<Int8Array>;

	encryptAndSetMainAttachment(document: Document, utis: Array<string> | undefined,
			attachment: Int8Array): Promise<EncryptedDocument>;

	getAndDecryptSecondaryAttachment(document: Document, key: string,
			options?: { decryptedAttachmentValidator?: (x1: Int8Array) => Promise<boolean> }): Promise<Int8Array>;

	encryptAndSetSecondaryAttachment(document: Document, key: string, utis: Array<string> | undefined,
			attachment: Int8Array): Promise<EncryptedDocument>;

	getEncryptionKeysOf(document: Document): Promise<Array<HexString>>;

	hasWriteAccess(document: Document): Promise<boolean>;

	decryptOwningEntityIdsOf(document: Document): Promise<Array<EntityReferenceInGroup>>;

	createDelegationDeAnonymizationMetadata(entity: Document, delegates: Array<string>): Promise<void>;

	decrypt(document: EncryptedDocument): Promise<DecryptedDocument>;

	tryDecrypt(document: EncryptedDocument): Promise<Document>;

	tryDecryptAttachment(document: Document, encryptedAttachment: Int8Array,
			options?: { decryptedAttachmentValidator?: (x1: Int8Array) => Promise<boolean> }): Promise<Int8Array | undefined>;

	matchDocumentsBy(filter: FilterOptions<Document>): Promise<Array<string>>;

	matchDocumentsBySorted(filter: SortableFilterOptions<Document>): Promise<Array<string>>;

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

	shareWith(delegateId: string, document: DecryptedDocument,
			options?: { options?: DocumentShareOptions | undefined }): Promise<DecryptedDocument>;

	shareWithMany(document: DecryptedDocument,
			delegates: { [ key: string ]: DocumentShareOptions }): Promise<DecryptedDocument>;

	filterDocumentsBy(filter: FilterOptions<Document>): Promise<PaginatedListIterator<DecryptedDocument>>;

	filterDocumentsBySorted(filter: SortableFilterOptions<Document>): Promise<PaginatedListIterator<DecryptedDocument>>;

	createDocument(entity: DecryptedDocument): Promise<DecryptedDocument>;

	createDocuments(entities: Array<DecryptedDocument>): Promise<Array<DecryptedDocument>>;

	undeleteDocumentById(id: string, rev: string): Promise<DecryptedDocument>;

	undeleteDocumentsByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<DecryptedDocument>>;

	undeleteDocument(document: Document): Promise<DecryptedDocument>;

	undeleteDocuments(documents: Array<DecryptedDocument>): Promise<Array<DecryptedDocument>>;

	modifyDocument(entity: DecryptedDocument): Promise<DecryptedDocument>;

	modifyDocuments(entities: Array<DecryptedDocument>): Promise<Array<DecryptedDocument>>;

	getDocument(entityId: string): Promise<DecryptedDocument | undefined>;

	getDocuments(entityIds: Array<string>): Promise<Array<DecryptedDocument>>;

}
