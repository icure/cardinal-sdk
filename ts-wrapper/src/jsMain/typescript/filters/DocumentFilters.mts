// auto-generated file
import {BaseSortableFilterOptions, FilterOptions, InternalDocumentFiltersObj, SortableFilterOptions} from '../cardinal-sdk-ts.mjs';
import {Document} from '../model/Document.mjs';
import {EntityReferenceInGroup} from '../model/EntityReferenceInGroup.mjs';
import {GroupScoped} from '../model/GroupScoped.mjs';
import {Message} from '../model/Message.mjs';
import {Patient} from '../model/Patient.mjs';
import {DocumentType} from '../model/embed/DocumentType.mjs';


interface DocumentFiltersFactory {

	/**
	 *
	 *  Options for document filtering which match all documents shared directly (i.e. ignoring hierarchies) with a specific data owner
	 *  that are linked with one of the provided patients.
	 *  This Options also allows to restrict the documents based on [Document.created]:
	 *  - if the [from] is not null, only the documents where [Document.created] is greater than or equal to [from] will be returned.
	 *  - if the [to] is not null, only the documents where [Document.created] is less than or equal to [to] will be returned.
	 *
	 *  When using these options the sdk will automatically extract the secret ids from the provided patients and use
	 *  those for filtering.
	 *  If you already have the secret ids of the patient you may instead use [byOwningEntitySecretIdsCreatedForDataOwner].
	 *  If the current data owner does not have access to any secret id of one of the provide patients the patient will
	 *  simply be ignored.
	 *  Note that these may not be used in methods of apis from [CardinalBaseApis].
	 *
	 *  These options are sortable. When sorting using these options the documents will be sorted by [Document.created] in ascending or
	 *  descending order according to the value of the [descending] parameter.
	 *
	 *  @param dataOwnerId a data owner id
	 *  @param patients a list of patients.
	 *  @param from the minimum value for [Document.created] (default: no limit).
	 *  @param to the maximum value for [Document.created] (default: no limit).
	 *  @param descending whether to sort the result in descending or ascending order by [Document.created] (default: ascending).
	 */
	byPatientsCreatedForDataOwner(dataOwnerId: string, patients: Array<Patient>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): SortableFilterOptions<Document>;

	/**
	 *
	 *  In group version of [byPatientsCreatedForDataOwner].
	 */
	byPatientsCreatedForDataOwnerInGroup(dataOwner: EntityReferenceInGroup,
			patients: Array<GroupScoped<Patient>>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): SortableFilterOptions<Document>;

	/**
	 *
	 *  Options for document filtering which match all documents shared directly (i.e. ignoring hierarchies) with a specific data owner
	 *  that are linked with one of the provided messages.
	 *  This Options also allows to restrict the documents based on [Document.created]:
	 *  - if the [from] is not null, only the documents where [Document.created] is greater than or equal to [from] will be returned.
	 *  - if the [to] is not null, only the documents where [Document.created] is less than or equal to [to] will be returned.
	 *
	 *  When using these options the sdk will automatically extract the secret ids from the provided patients and use
	 *  those for filtering.
	 *  If you already have the secret ids of the message you may instead use [byOwningEntitySecretIdsCreatedForDataOwner].
	 *  If the current data owner does not have access to any secret id of one of the provided messages the message will
	 *  simply be ignored.
	 *  Note that these may not be used in methods of apis from [CardinalBaseApis].
	 *
	 *  These options are sortable. When sorting using these options the documents will be sorted by [Document.created] in ascending or
	 *  descending order according to the value of the [descending] parameter.
	 *
	 *  @param dataOwnerId a data owner id
	 *  @param messages a list of messages.
	 *  @param from the minimum value for [Document.created] (default: no limit).
	 *  @param to the maximum value for [Document.created] (default: no limit).
	 *  @param descending whether to sort the result in descending or ascending order by [Document.created] (default: ascending).
	 */
	byMessagesCreatedForDataOwner(dataOwnerId: string, messages: Array<Message>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): SortableFilterOptions<Document>;

	/**
	 *
	 *  In group version of [byMessagesCreatedForDataOwner].
	 */
	byMessagesCreatedForDataOwnerInGroup(dataOwner: EntityReferenceInGroup,
			messages: Array<GroupScoped<Message>>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): SortableFilterOptions<Document>;

	/**
	 *
	 *  Options for document filtering which match all documents shared directly (i.e. ignoring hierarchies) with the current data owner
	 *  that are linked with one of the provided patients.
	 *  This Options also allows to restrict the documents based on [Document.created]:
	 *  - if the [from] is not null, only the documents where [Document.created] is greater than or equal to [from] will be returned.
	 *  - if the [to] is not null, only the documents where [Document.created] is less than or equal to [to] will be returned.
	 *
	 *  When using these options the sdk will automatically extract the secret ids from the provided patients and use
	 *  those for filtering.
	 *  If you already have the secret ids of the patient you may instead use [byOwningEntitySecretIdsCreatedForSelf].
	 *  If the current data owner does not have access to any secret id of one of the provide patients the patient will
	 *  simply be ignored.
	 *  Note that these may not be used in methods of apis from [CardinalBaseApis].
	 *
	 *  These options are sortable. When sorting using these options the documents will be sorted by [Document.created] in ascending or
	 *  descending order according to the value of the [descending] parameter.
	 *
	 *  @param patients a list of patients.
	 *  @param from the minimum value for [Document.created] (default: no limit).
	 *  @param to the maximum value for [Document.created] (default: no limit).
	 *  @param descending whether to sort the result in descending or ascending order by [Document.created] (default: ascending).
	 */
	byPatientsCreatedForSelf(patients: Array<Patient>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): SortableFilterOptions<Document>;

	/**
	 *
	 *  Options for document filtering which match all documents shared directly (i.e. ignoring hierarchies) with the current data owner
	 *  that are linked with one of the provided messages.
	 *  This Options also allows to restrict the documents based on [Document.created]:
	 *  - if the [from] is not null, only the documents where [Document.created] is greater than or equal to [from] will be returned.
	 *  - if the [to] is not null, only the documents where [Document.created] is less than or equal to [to] will be returned.
	 *
	 *  When using these options the sdk will automatically extract the secret ids from the provided messages and use
	 *  those for filtering.
	 *  If you already have the secret ids of the message you may instead use [byOwningEntitySecretIdsCreatedForSelf].
	 *  If the current data owner does not have access to any secret id of one of the provided messages the message will
	 *  simply be ignored.
	 *  Note that these may not be used in methods of apis from [CardinalBaseApis].
	 *
	 *  These options are sortable. When sorting using these options the documents will be sorted by [Document.created] in ascending or
	 *  descending order according to the value of the [descending] parameter.
	 *
	 *  @param messages a list of messages.
	 *  @param from the minimum value for [Document.created] (default: no limit).
	 *  @param to the maximum value for [Document.created] (default: no limit).
	 *  @param descending whether to sort the result in descending or ascending order by [Document.created] (default: ascending).
	 */
	byMessagesCreatedForSelf(messages: Array<Message>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): SortableFilterOptions<Document>;

	/**
	 *
	 *  Options for document filtering which match all documents shared directly (i.e. ignoring hierarchies) with a specific owner
	 *  that are linked with one of the provided patients through one of the provided secret ids.
	 *  This Options also allows to restrict the documents based on [Document.created]:
	 *  - if the [from] is not null, only the documents where [Document.created] is greater than or equal to [from] will be returned.
	 *  - if the [to] is not null, only the documents where [Document.created] is less than or equal to [to] will be returned.
	 *
	 *  If the current data owner does not have access to any secret id of one of the provide patients the patient will
	 *  simply be ignored.
	 *
	 *  These options are sortable. When sorting using these options the documents will be sorted by [Document.created] in ascending or
	 *  descending order according to the value of the [descending] parameter.
	 *
	 *  @param dataOwnerId the id of a data owner.
	 *  @param secretIds a list of patient secret ids.
	 *  @param from the minimum value for [Document.created] (default: no limit).
	 *  @param to the maximum value for [Document.created] (default: no limit).
	 *  @param descending whether to sort the result in descending or ascending order by [Document.created] (default: ascending).
	 */
	byOwningEntitySecretIdsCreatedForDataOwner(dataOwnerId: string, secretIds: Array<string>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): BaseSortableFilterOptions<Document>;

	byOwningEntitySecretIdsCreatedForDataOwnerInGroup(dataOwner: EntityReferenceInGroup,
			secretIds: Array<string>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): BaseSortableFilterOptions<Document>;

	/**
	 *
	 *  Options for document filtering which match all documents shared directly (i.e. ignoring hierarchies) with the current data owner
	 *  that are linked with one of the provided owning entities through one of the provided secret ids.
	 *  This Options also allows to restrict the documents based on [Document.created]:
	 *  - if the [from] is not null, only the documents where [Document.created] is greater than or equal to [from] will be returned.
	 *  - if the [to] is not null, only the documents where [Document.created] is less than or equal to [to] will be returned.
	 *
	 *  If the current data owner does not have access to any secret id of one of the provide owning entities the owning entity will
	 *  simply be ignored.
	 *  Note that these may not be used in methods of apis from [CardinalBaseApis].
	 *
	 *  These options are sortable. When sorting using these options the documents will be sorted by [Document.created] in ascending or
	 *  descending order according to the value of the [descending] parameter.
	 *
	 *  @param secretIds a list of owning entity secret ids.
	 *  @param from the minimum value for [Document.created] (default: no limit).
	 *  @param to the maximum value for [Document.created] (default: no limit).
	 *  @param descending whether to sort the result in descending or ascending order by [Document.created] (default: ascending).
	 */
	byOwningEntitySecretIdsCreatedForSelf(secretIds: Array<string>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): SortableFilterOptions<Document>;

	/**
	 *
	 *  Options for document filter which match all the documents shared directly (i.e. ignoring hierarchies) with a specific data owner
	 *  that are linked with of the provided patients and where [Document.documentType] is equal to [documentType].
	 *
	 *  When using these options the sdk will automatically extract the secret ids from the provided patients and use
	 *  those for filtering.
	 *  If you already have the secret ids of the patient you may instead use [byOwningEntitySecretIdsAndTypeForDataOwner].
	 *  If the current data owner does not have access to any secret id of one of the provided patients the patient will
	 *  simply be ignored.
	 *  Note that these may not be used in methods of apis from [CardinalBaseApis].
	 *
	 *  @param dataOwnerId the id of a data owner.
	 *  @param documentType the document type to search.
	 *  @param patients a list of patients.
	 */
	byPatientsAndTypeForDataOwner(dataOwnerId: string, documentType: DocumentType,
			patients: Array<Patient>): FilterOptions<Document>;

	/**
	 *
	 *  In group version of [byPatientsAndTypeForDataOwner].
	 */
	byPatientsAndTypeForDataOwnerInGroup(dataOwner: EntityReferenceInGroup, documentType: DocumentType,
			patients: Array<GroupScoped<Patient>>): FilterOptions<Document>;

	/**
	 *
	 *  Options for document filter which match all the documents shared directly (i.e. ignoring hierarchies) with a specific data owner
	 *  that are linked with of the provided messages and where [Document.documentType] is equal to [documentType].
	 *
	 *  When using these options the sdk will automatically extract the secret ids from the provided messages and use
	 *  those for filtering.
	 *  If you already have the secret ids of the message you may instead use [byOwningEntitySecretIdsAndTypeForDataOwner].
	 *  If the current data owner does not have access to any secret id of one of the provided messages the message will
	 *  simply be ignored.
	 *  Note that these may not be used in methods of apis from [CardinalBaseApis].
	 *
	 *  @param dataOwnerId the id of a data owner.
	 *  @param documentType the document type to search.
	 *  @param messages a list of messages.
	 */
	byMessagesAndTypeForDataOwner(dataOwnerId: string, documentType: DocumentType,
			messages: Array<Message>): FilterOptions<Document>;

	/**
	 *
	 *  In group version of [byMessagesAndTypeForDataOwner].
	 */
	byMessagesAndTypeForDataOwnerInGroup(dataOwner: EntityReferenceInGroup, documentType: DocumentType,
			messages: Array<GroupScoped<Message>>): FilterOptions<Document>;

	/**
	 *
	 *  Options for document filter which match all the documents shared directly (i.e. ignoring hierarchies) with the current data owner
	 *  that are linked with of the provided patients and where [Document.documentType] is equal to [documentType].
	 *
	 *  When using these options the sdk will automatically extract the secret ids from the provided patients and use
	 *  those for filtering.
	 *  If you already have the secret ids of the patient you may instead use [byOwningEntitySecretIdsAndTypeForSelf].
	 *  If the current data owner does not have access to any secret id of one of the provide patients the patient will
	 *  simply be ignored.
	 *  Note that these may not be used in methods of apis from [CardinalBaseApis].
	 *
	 *  @param documentType the document type to search.
	 *  @param patients a list of patients.
	 */
	byPatientsAndTypeForSelf(documentType: DocumentType,
			patients: Array<Patient>): FilterOptions<Document>;

	/**
	 *
	 *  Options for document filter which match all the documents shared directly (i.e. ignoring hierarchies) with the current data owner
	 *  that are linked with of the provided messages and where [Document.documentType] is equal to [documentType].
	 *
	 *  When using these options the sdk will automatically extract the secret ids from the provided messages and use
	 *  those for filtering.
	 *  If you already have the secret ids of the message you may instead use [byOwningEntitySecretIdsAndTypeForSelf].
	 *  If the current data owner does not have access to any secret id of one of the provide messages the message will
	 *  simply be ignored.
	 *  Note that these may not be used in methods of apis from [CardinalBaseApis].
	 *
	 *  @param documentType the document type to search.
	 *  @param messages a list of messages.
	 */
	byMessagesAndTypeForSelf(documentType: DocumentType,
			messages: Array<Message>): FilterOptions<Document>;

	/**
	 *
	 *  Options for document filter which match all the documents shared directly (i.e. ignoring hierarchies) with a specific data owner
	 *  that are linked with of the provided owning entities through one of the provided secret ids and where [Document.documentType] is equal
	 *  to [documentType].
	 *
	 *  If the current data owner does not have access to any secret id of one of the provided owning entities the owning entity will
	 *  simply be ignored.
	 *
	 *  @param dataOwnerId the id of a data owner.
	 *  @param documentType the document type to search.
	 *  @param secretIds a list of patient secret ids.
	 */
	byOwningEntitySecretIdsAndTypeForDataOwner(dataOwnerId: string, documentType: DocumentType,
			secretIds: Array<string>): FilterOptions<Document>;

	/**
	 *
	 *  In group version of [byOwningEntitySecretIdsAndTypeForDataOwner].
	 */
	byOwningEntitySecretIdsAndTypeForDataOwnerInGroup(dataOwner: EntityReferenceInGroup,
			documentType: DocumentType, secretIds: Array<string>): FilterOptions<Document>;

	/**
	 *
	 *  Options for document filter which match all the documents shared directly (i.e. ignoring hierarchies) with the current data owner
	 *  that are linked with of the provided owning entities through one of the provided secret ids and where [Document.documentType] is equal
	 *  to [documentType].
	 *
	 *  If the current data owner does not have access to any secret id of one of the provide owning entities the owning entity will
	 *  simply be ignored.
	 *  Note that these may not be used in methods of apis from [CardinalBaseApis].
	 *
	 *  @param documentType the document type to search.
	 *  @param secretIds a list of patient secret ids.
	 */
	byOwningEntitySecretIdsAndTypeForSelf(documentType: DocumentType,
			secretIds: Array<string>): FilterOptions<Document>;

	/**
	 *
	 *  Options for document filtering which match all documents shared directly (i.e. ignoring hierarchies) with a specific data owner that have a certain code.
	 *  If you specify only the [codeType] you will get all entities that have at least a code of that type.
	 *
	 *  These options are sortable. When sorting using these options the documents will be sorted by [codeCode].
	 *
	 *  @param dataOwnerId a data owner id
	 *  @param codeType a code type
	 *  @param codeCode a code for the provided code type, or null if you want the filter to accept any entity
	 *  with a code of the provided type.
	 */
	byCodeForDataOwner(dataOwnerId: string, codeType: string,
			options?: { codeCode?: string | undefined }): BaseSortableFilterOptions<Document>;

	/**
	 *
	 *  In group version of [byCodeForDataOwner].
	 */
	byCodeForDataOwnerInGroup(dataOwner: EntityReferenceInGroup, codeType: string,
			options?: { codeCode?: string | undefined }): BaseSortableFilterOptions<Document>;

	/**
	 *
	 *  Options for document filtering which match all documents shared directly (i.e. ignoring hierarchies) with the current data owner that have a certain code.
	 *  If you specify only the [codeType] you will get all entities that have at least a code of that type.
	 *
	 *  These options are sortable. When sorting using these options the documents will be sorted by [codeCode].
	 *
	 *  @param codeType a code type
	 *  @param codeCode a code for the provided code type, or null if you want the filter to accept any entity
	 *  with a code of the provided type.
	 */
	byCodeForSelf(codeType: string,
			options?: { codeCode?: string | undefined }): SortableFilterOptions<Document>;

	/**
	 *
	 *  Options for document filtering which match all documents shared directly (i.e. ignoring hierarchies) with a specific data owner that have a certain tag.
	 *  If you specify only the [tagType] you will get all entities that have at least a tag of that type.
	 *
	 *  These options are sortable. When sorting using these options the documents will be sorted by [tagCode].
	 *
	 *  @param dataOwnerId a data owner id
	 *  @param tagType a tag type
	 *  @param tagCode a code for the provided tag type, or null if you want the filter to accept any entity
	 *  with a tag of the provided type.
	 */
	byTagForDataOwner(dataOwnerId: string, tagType: string,
			options?: { tagCode?: string | undefined }): BaseSortableFilterOptions<Document>;

	/**
	 *
	 *  In group version of [byTagForDataOwner].
	 */
	byTagForDataOwnerInGroup(dataOwner: EntityReferenceInGroup, tagType: string,
			options?: { tagCode?: string | undefined }): BaseSortableFilterOptions<Document>;

	/**
	 *
	 *  Options for document filtering which match all documents shared directly (i.e. ignoring hierarchies) with the current data owner that have a certain tag.
	 *  If you specify only the [tagType] you will get all entities that have at least a tag of that type.
	 *
	 *  These options are sortable. When sorting using these options the documents will be sorted by [tagCode].
	 *
	 *  @param tagType a tag type
	 *  @param tagCode a code for the provided tag type, or null if you want the filter to accept any entity
	 *  with a tag of the provided type.
	 */
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
