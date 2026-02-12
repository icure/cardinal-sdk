// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, FilterOptions, InternalMessageFiltersObj, SortableFilterOptions} from '../cardinal-sdk-ts.mjs';
import {EntityReferenceInGroup} from '../model/EntityReferenceInGroup.mjs';
import {GroupScoped} from '../model/GroupScoped.mjs';
import {Message} from '../model/Message.mjs';
import {Patient} from '../model/Patient.mjs';


interface MessageFiltersFactory {

	allMessagesForDataOwner(dataOwnerId: string): BaseFilterOptions<Message>;

	allMessagesForSelf(): FilterOptions<Message>;

	byTransportGuidForDataOwner(dataOwnerId: string,
			transportGuid: string): BaseSortableFilterOptions<Message>;

	byTransportGuidForDataOwnerInGroup(dataOwner: EntityReferenceInGroup,
			transportGuid: string): BaseSortableFilterOptions<Message>;

	byTransportGuidForSelf(transportGuid: string): SortableFilterOptions<Message>;

	fromAddressForDataOwner(dataOwnerId: string, address: string): BaseFilterOptions<Message>;

	fromAddressForDataOwnerInGroup(dataOwner: EntityReferenceInGroup,
			address: string): BaseFilterOptions<Message>;

	fromAddressForSelf(address: string): FilterOptions<Message>;

	byPatientsSentDateForDataOwner(dataOwnerId: string, patients: Array<Patient>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): SortableFilterOptions<Message>;

	byPatientsSentDateForDataOwnerInGroup(dataOwner: EntityReferenceInGroup,
			patients: Array<GroupScoped<Patient>>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): SortableFilterOptions<Message>;

	byPatientsSentDateForSelf(patients: Array<Patient>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): SortableFilterOptions<Message>;

	byPatientSecretIdsSentDateForDataOwner(dataOwnerId: string, secretIds: Array<string>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): BaseSortableFilterOptions<Message>;

	byPatientSecretIdsSentDateForDataOwnerInGroup(dataOwner: EntityReferenceInGroup,
			secretIds: Array<string>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): BaseSortableFilterOptions<Message>;

	byPatientSecretIdsSentDateForSelf(secretIds: Array<string>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): SortableFilterOptions<Message>;

	toAddressForDataOwner(dataOwnerId: string, address: string): BaseFilterOptions<Message>;

	toAddressForDataOwnerInGroup(dataOwner: EntityReferenceInGroup,
			address: string): BaseFilterOptions<Message>;

	toAddressForSelf(address: string): FilterOptions<Message>;

	byTransportGuidSentDateForDataOwner(
			dataOwnerId: string,
			transportGuid: string,
			from: number | undefined,
			to: number | undefined,
			options?: { descending?: boolean }
	): BaseSortableFilterOptions<Message>;

	byTransportGuidSentDateForDataOwnerInGroup(
			dataOwner: EntityReferenceInGroup,
			transportGuid: string,
			from: number | undefined,
			to: number | undefined,
			options?: { descending?: boolean }
	): BaseSortableFilterOptions<Message>;

	byTransportGuidSentDateForSelf(transportGuid: string, from: number | undefined,
			to: number | undefined, options?: { descending?: boolean }): SortableFilterOptions<Message>;

	latestByTransportGuidForDataOwner(dataOwnerId: string,
			transportGuid: string): BaseFilterOptions<Message>;

	latestByTransportGuidForDataOwnerInGroup(dataOwner: EntityReferenceInGroup,
			transportGuid: string): BaseFilterOptions<Message>;

	latestByTransportGuidForSelf(transportGuid: string): FilterOptions<Message>;

	byInvoiceIds(invoiceIds: Array<string>): BaseFilterOptions<Message>;

	byParentIds(parentIds: Array<string>): BaseFilterOptions<Message>;

	lifecycleBetweenForDataOwner(dataOwnerId: string, startTimestamp: number | undefined,
			endTimestamp: number | undefined, descending: boolean): BaseFilterOptions<Message>;

	lifecycleBetweenForDataOwnerInGroupInGroup(dataOwner: EntityReferenceInGroup,
			startTimestamp: number | undefined, endTimestamp: number | undefined,
			descending: boolean): BaseFilterOptions<Message>;

	lifecycleBetweenForSelf(startTimestamp: number | undefined, endTimestamp: number | undefined,
			descending: boolean): FilterOptions<Message>;

	byCodeForDataOwner(dataOwnerId: string, codeType: string,
			options?: { codeCode?: string | undefined }): BaseSortableFilterOptions<Message>;

	byCodeForDataOwnerInGroup(dataOwner: EntityReferenceInGroup, codeType: string,
			options?: { codeCode?: string | undefined }): BaseSortableFilterOptions<Message>;

	byCodeForSelf(codeType: string,
			options?: { codeCode?: string | undefined }): SortableFilterOptions<Message>;

	byTagForDataOwner(dataOwnerId: string, tagType: string,
			options?: { tagCode?: string | undefined }): BaseSortableFilterOptions<Message>;

	byTagForDataOwnerInGroup(dataOwner: EntityReferenceInGroup, tagType: string,
			options?: { tagCode?: string | undefined }): BaseSortableFilterOptions<Message>;

	byTagForSelf(tagType: string,
			options?: { tagCode?: string | undefined }): SortableFilterOptions<Message>;

}

export const MessageFilters: MessageFiltersFactory = {
			allMessagesForDataOwner: (dataOwnerId) => InternalMessageFiltersObj.getInstance().allMessagesForDataOwner(dataOwnerId),
			allMessagesForSelf: () => InternalMessageFiltersObj.getInstance().allMessagesForSelf(),
			byTransportGuidForDataOwner: (dataOwnerId, transportGuid) => InternalMessageFiltersObj.getInstance().byTransportGuidForDataOwner(dataOwnerId, transportGuid),
			byTransportGuidForDataOwnerInGroup: (dataOwner, transportGuid) => InternalMessageFiltersObj.getInstance().byTransportGuidForDataOwnerInGroup(dataOwner, transportGuid),
			byTransportGuidForSelf: (transportGuid) => InternalMessageFiltersObj.getInstance().byTransportGuidForSelf(transportGuid),
			fromAddressForDataOwner: (dataOwnerId, address) => InternalMessageFiltersObj.getInstance().fromAddressForDataOwner(dataOwnerId, address),
			fromAddressForDataOwnerInGroup: (dataOwner, address) => InternalMessageFiltersObj.getInstance().fromAddressForDataOwnerInGroup(dataOwner, address),
			fromAddressForSelf: (address) => InternalMessageFiltersObj.getInstance().fromAddressForSelf(address),
			byPatientsSentDateForDataOwner: (dataOwnerId, patients, options) => InternalMessageFiltersObj.getInstance().byPatientsSentDateForDataOwner(dataOwnerId, patients, options),
			byPatientsSentDateForDataOwnerInGroup: (dataOwner, patients, options) => InternalMessageFiltersObj.getInstance().byPatientsSentDateForDataOwnerInGroup(dataOwner, patients, options),
			byPatientsSentDateForSelf: (patients, options) => InternalMessageFiltersObj.getInstance().byPatientsSentDateForSelf(patients, options),
			byPatientSecretIdsSentDateForDataOwner: (dataOwnerId, secretIds, options) => InternalMessageFiltersObj.getInstance().byPatientSecretIdsSentDateForDataOwner(dataOwnerId, secretIds, options),
			byPatientSecretIdsSentDateForDataOwnerInGroup: (dataOwner, secretIds, options) => InternalMessageFiltersObj.getInstance().byPatientSecretIdsSentDateForDataOwnerInGroup(dataOwner, secretIds, options),
			byPatientSecretIdsSentDateForSelf: (secretIds, options) => InternalMessageFiltersObj.getInstance().byPatientSecretIdsSentDateForSelf(secretIds, options),
			toAddressForDataOwner: (dataOwnerId, address) => InternalMessageFiltersObj.getInstance().toAddressForDataOwner(dataOwnerId, address),
			toAddressForDataOwnerInGroup: (dataOwner, address) => InternalMessageFiltersObj.getInstance().toAddressForDataOwnerInGroup(dataOwner, address),
			toAddressForSelf: (address) => InternalMessageFiltersObj.getInstance().toAddressForSelf(address),
			byTransportGuidSentDateForDataOwner: (dataOwnerId, transportGuid, from, to, options) => InternalMessageFiltersObj.getInstance().byTransportGuidSentDateForDataOwner(dataOwnerId, transportGuid, from, to, options),
			byTransportGuidSentDateForDataOwnerInGroup: (dataOwner, transportGuid, from, to, options) => InternalMessageFiltersObj.getInstance().byTransportGuidSentDateForDataOwnerInGroup(dataOwner, transportGuid, from, to, options),
			byTransportGuidSentDateForSelf: (transportGuid, from, to, options) => InternalMessageFiltersObj.getInstance().byTransportGuidSentDateForSelf(transportGuid, from, to, options),
			latestByTransportGuidForDataOwner: (dataOwnerId, transportGuid) => InternalMessageFiltersObj.getInstance().latestByTransportGuidForDataOwner(dataOwnerId, transportGuid),
			latestByTransportGuidForDataOwnerInGroup: (dataOwner, transportGuid) => InternalMessageFiltersObj.getInstance().latestByTransportGuidForDataOwnerInGroup(dataOwner, transportGuid),
			latestByTransportGuidForSelf: (transportGuid) => InternalMessageFiltersObj.getInstance().latestByTransportGuidForSelf(transportGuid),
			byInvoiceIds: (invoiceIds) => InternalMessageFiltersObj.getInstance().byInvoiceIds(invoiceIds),
			byParentIds: (parentIds) => InternalMessageFiltersObj.getInstance().byParentIds(parentIds),
			lifecycleBetweenForDataOwner: (dataOwnerId, startTimestamp, endTimestamp, descending) => InternalMessageFiltersObj.getInstance().lifecycleBetweenForDataOwner(dataOwnerId, startTimestamp, endTimestamp, descending),
			lifecycleBetweenForDataOwnerInGroupInGroup: (dataOwner, startTimestamp, endTimestamp, descending) => InternalMessageFiltersObj.getInstance().lifecycleBetweenForDataOwnerInGroupInGroup(dataOwner, startTimestamp, endTimestamp, descending),
			lifecycleBetweenForSelf: (startTimestamp, endTimestamp, descending) => InternalMessageFiltersObj.getInstance().lifecycleBetweenForSelf(startTimestamp, endTimestamp, descending),
			byCodeForDataOwner: (dataOwnerId, codeType, options) => InternalMessageFiltersObj.getInstance().byCodeForDataOwner(dataOwnerId, codeType, options),
			byCodeForDataOwnerInGroup: (dataOwner, codeType, options) => InternalMessageFiltersObj.getInstance().byCodeForDataOwnerInGroup(dataOwner, codeType, options),
			byCodeForSelf: (codeType, options) => InternalMessageFiltersObj.getInstance().byCodeForSelf(codeType, options),
			byTagForDataOwner: (dataOwnerId, tagType, options) => InternalMessageFiltersObj.getInstance().byTagForDataOwner(dataOwnerId, tagType, options),
			byTagForDataOwnerInGroup: (dataOwner, tagType, options) => InternalMessageFiltersObj.getInstance().byTagForDataOwnerInGroup(dataOwner, tagType, options),
			byTagForSelf: (tagType, options) => InternalMessageFiltersObj.getInstance().byTagForSelf(tagType, options)
		};
