// auto-generated file
import {BaseSortableFilterOptions, FilterOptions, InternalDocumentFiltersObj, SortableFilterOptions} from '../cardinal-sdk-ts.mjs';
import {Document} from '../model/Document.mjs';
import {EntityReferenceInGroup} from '../model/EntityReferenceInGroup.mjs';
import {GroupScoped} from '../model/GroupScoped.mjs';
import {Message} from '../model/Message.mjs';
import {Patient} from '../model/Patient.mjs';
import {DocumentType} from '../model/embed/DocumentType.mjs';


interface DocumentFiltersFactory {

	byPatientsCreatedForDataOwner(dataOwnerId: string, patients: Array<Patient>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): SortableFilterOptions<Document>;

	byPatientsCreatedForDataOwnerInGroup(dataOwner: EntityReferenceInGroup,
			patients: Array<GroupScoped<Patient>>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): SortableFilterOptions<Document>;

	byMessagesCreatedForDataOwner(dataOwnerId: string, messages: Array<Message>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): SortableFilterOptions<Document>;

	byMessagesCreatedForDataOwnerInGroup(dataOwner: EntityReferenceInGroup,
			messages: Array<GroupScoped<Message>>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): SortableFilterOptions<Document>;

	byPatientsCreatedForSelf(patients: Array<Patient>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): SortableFilterOptions<Document>;

	byMessagesCreatedForSelf(messages: Array<Message>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): SortableFilterOptions<Document>;

	byOwningEntitySecretIdsCreatedForDataOwner(dataOwnerId: string, secretIds: Array<string>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): BaseSortableFilterOptions<Document>;

	byOwningEntitySecretIdsCreatedForDataOwnerInGroup(dataOwner: EntityReferenceInGroup,
			secretIds: Array<string>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): BaseSortableFilterOptions<Document>;

	byOwningEntitySecretIdsCreatedForSelf(secretIds: Array<string>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): SortableFilterOptions<Document>;

	byPatientsAndTypeForDataOwner(dataOwnerId: string, documentType: DocumentType,
			patients: Array<Patient>): FilterOptions<Document>;

	byPatientsAndTypeForDataOwnerInGroup(dataOwner: EntityReferenceInGroup, documentType: DocumentType,
			patients: Array<GroupScoped<Patient>>): FilterOptions<Document>;

	byMessagesAndTypeForDataOwner(dataOwnerId: string, documentType: DocumentType,
			messages: Array<Message>): FilterOptions<Document>;

	byMessagesAndTypeForDataOwnerInGroup(dataOwner: EntityReferenceInGroup, documentType: DocumentType,
			messages: Array<GroupScoped<Message>>): FilterOptions<Document>;

	byPatientsAndTypeForSelf(documentType: DocumentType,
			patients: Array<Patient>): FilterOptions<Document>;

	byMessagesAndTypeForSelf(documentType: DocumentType,
			messages: Array<Message>): FilterOptions<Document>;

	byOwningEntitySecretIdsAndTypeForDataOwner(dataOwnerId: string, documentType: DocumentType,
			secretIds: Array<string>): FilterOptions<Document>;

	byOwningEntitySecretIdsAndTypeForDataOwnerInGroup(dataOwner: EntityReferenceInGroup,
			documentType: DocumentType, secretIds: Array<string>): FilterOptions<Document>;

	byOwningEntitySecretIdsAndTypeForSelf(documentType: DocumentType,
			secretIds: Array<string>): FilterOptions<Document>;

	byCodeForDataOwner(dataOwnerId: string, codeType: string,
			options?: { codeCode?: string | undefined }): BaseSortableFilterOptions<Document>;

	byCodeForDataOwnerInGroup(dataOwner: EntityReferenceInGroup, codeType: string,
			options?: { codeCode?: string | undefined }): BaseSortableFilterOptions<Document>;

	byCodeForSelf(codeType: string,
			options?: { codeCode?: string | undefined }): SortableFilterOptions<Document>;

	byTagForDataOwner(dataOwnerId: string, tagType: string,
			options?: { tagCode?: string | undefined }): BaseSortableFilterOptions<Document>;

	byTagForDataOwnerInGroup(dataOwner: EntityReferenceInGroup, tagType: string,
			options?: { tagCode?: string | undefined }): BaseSortableFilterOptions<Document>;

	byTagForSelf(tagType: string,
			options?: { tagCode?: string | undefined }): SortableFilterOptions<Document>;

}

export const DocumentFilters: DocumentFiltersFactory = {
			byPatientsCreatedForDataOwner: (dataOwnerId, patients, options) => InternalDocumentFiltersObj.getInstance().byPatientsCreatedForDataOwner(dataOwnerId, patients, options),
			byPatientsCreatedForDataOwnerInGroup: (dataOwner, patients, options) => InternalDocumentFiltersObj.getInstance().byPatientsCreatedForDataOwnerInGroup(dataOwner, patients, options),
			byMessagesCreatedForDataOwner: (dataOwnerId, messages, options) => InternalDocumentFiltersObj.getInstance().byMessagesCreatedForDataOwner(dataOwnerId, messages, options),
			byMessagesCreatedForDataOwnerInGroup: (dataOwner, messages, options) => InternalDocumentFiltersObj.getInstance().byMessagesCreatedForDataOwnerInGroup(dataOwner, messages, options),
			byPatientsCreatedForSelf: (patients, options) => InternalDocumentFiltersObj.getInstance().byPatientsCreatedForSelf(patients, options),
			byMessagesCreatedForSelf: (messages, options) => InternalDocumentFiltersObj.getInstance().byMessagesCreatedForSelf(messages, options),
			byOwningEntitySecretIdsCreatedForDataOwner: (dataOwnerId, secretIds, options) => InternalDocumentFiltersObj.getInstance().byOwningEntitySecretIdsCreatedForDataOwner(dataOwnerId, secretIds, options),
			byOwningEntitySecretIdsCreatedForDataOwnerInGroup: (dataOwner, secretIds, options) => InternalDocumentFiltersObj.getInstance().byOwningEntitySecretIdsCreatedForDataOwnerInGroup(dataOwner, secretIds, options),
			byOwningEntitySecretIdsCreatedForSelf: (secretIds, options) => InternalDocumentFiltersObj.getInstance().byOwningEntitySecretIdsCreatedForSelf(secretIds, options),
			byPatientsAndTypeForDataOwner: (dataOwnerId, documentType, patients) => InternalDocumentFiltersObj.getInstance().byPatientsAndTypeForDataOwner(dataOwnerId, documentType, patients),
			byPatientsAndTypeForDataOwnerInGroup: (dataOwner, documentType, patients) => InternalDocumentFiltersObj.getInstance().byPatientsAndTypeForDataOwnerInGroup(dataOwner, documentType, patients),
			byMessagesAndTypeForDataOwner: (dataOwnerId, documentType, messages) => InternalDocumentFiltersObj.getInstance().byMessagesAndTypeForDataOwner(dataOwnerId, documentType, messages),
			byMessagesAndTypeForDataOwnerInGroup: (dataOwner, documentType, messages) => InternalDocumentFiltersObj.getInstance().byMessagesAndTypeForDataOwnerInGroup(dataOwner, documentType, messages),
			byPatientsAndTypeForSelf: (documentType, patients) => InternalDocumentFiltersObj.getInstance().byPatientsAndTypeForSelf(documentType, patients),
			byMessagesAndTypeForSelf: (documentType, messages) => InternalDocumentFiltersObj.getInstance().byMessagesAndTypeForSelf(documentType, messages),
			byOwningEntitySecretIdsAndTypeForDataOwner: (dataOwnerId, documentType, secretIds) => InternalDocumentFiltersObj.getInstance().byOwningEntitySecretIdsAndTypeForDataOwner(dataOwnerId, documentType, secretIds),
			byOwningEntitySecretIdsAndTypeForDataOwnerInGroup: (dataOwner, documentType, secretIds) => InternalDocumentFiltersObj.getInstance().byOwningEntitySecretIdsAndTypeForDataOwnerInGroup(dataOwner, documentType, secretIds),
			byOwningEntitySecretIdsAndTypeForSelf: (documentType, secretIds) => InternalDocumentFiltersObj.getInstance().byOwningEntitySecretIdsAndTypeForSelf(documentType, secretIds),
			byCodeForDataOwner: (dataOwnerId, codeType, options) => InternalDocumentFiltersObj.getInstance().byCodeForDataOwner(dataOwnerId, codeType, options),
			byCodeForDataOwnerInGroup: (dataOwner, codeType, options) => InternalDocumentFiltersObj.getInstance().byCodeForDataOwnerInGroup(dataOwner, codeType, options),
			byCodeForSelf: (codeType, options) => InternalDocumentFiltersObj.getInstance().byCodeForSelf(codeType, options),
			byTagForDataOwner: (dataOwnerId, tagType, options) => InternalDocumentFiltersObj.getInstance().byTagForDataOwner(dataOwnerId, tagType, options),
			byTagForDataOwnerInGroup: (dataOwner, tagType, options) => InternalDocumentFiltersObj.getInstance().byTagForDataOwnerInGroup(dataOwner, tagType, options),
			byTagForSelf: (tagType, options) => InternalDocumentFiltersObj.getInstance().byTagForSelf(tagType, options)
		};
