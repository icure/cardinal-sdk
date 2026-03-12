// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, FilterOptions, InternalMessageFiltersObj, SortableFilterOptions} from '../cardinal-sdk-ts.mjs';
import {EntityReferenceInGroup} from '../model/EntityReferenceInGroup.mjs';
import {GroupScoped} from '../model/GroupScoped.mjs';
import {Message} from '../model/Message.mjs';
import {Patient} from '../model/Patient.mjs';


interface MessageFiltersFactory {

	/**
	 *
	 *  Create options for message filtering that will match all messages shared directly (i.e. ignoring hierarchies) with a specific data owner.
	 *  @param dataOwnerId a data owner id
	 *  @return options for message filtering
	 */
	allMessagesForDataOwner(dataOwnerId: string): BaseFilterOptions<Message>;

	/**
	 *
	 *  Create options for message filtering that will match all messages shared directly (i.e. ignoring hierarchies) with the current data owner.
	 *  @return options for message filtering
	 */
	allMessagesForSelf(): FilterOptions<Message>;

	/**
	 *
	 *  Creates options for message filtering that will match all messages shared directly (i.e. ignoring hierarchies) with a specific data owner that have the
	 *  provided transportGuid.
	 *
	 *  These options are sortable. When sorting using these options the messages will be sorted by [Message.sent].
	 *
	 *  @param dataOwnerId a data owner id
	 *  @param transportGuid a message transport guid
	 */
	byTransportGuidForDataOwner(dataOwnerId: string,
			transportGuid: string): BaseSortableFilterOptions<Message>;

	/**
	 *
	 *  In group version of [byTransportGuidForDataOwner].
	 */
	byTransportGuidForDataOwnerInGroup(dataOwner: EntityReferenceInGroup,
			transportGuid: string): BaseSortableFilterOptions<Message>;

	/**
	 *
	 *  Creates options for message filtering that will match all messages shared directly (i.e. ignoring hierarchies) with the current data owner that have the
	 *  provided transportGuid.
	 *
	 *  These options are sortable. When sorting using these options the messages will be sorted by [Message.sent].
	 *
	 *  @param transportGuid a message transport guid
	 */
	byTransportGuidForSelf(transportGuid: string): SortableFilterOptions<Message>;

	/**
	 *
	 *  Filter options for message filtering that will match all messages shared directly (i.e. ignoring hierarchies) with a specific data owner
	 *  where [Message.fromAddress] is equal to [address].
	 *
	 *  @param dataOwnerId the id of a data owner.
	 *  @param address the sender address.
	 */
	fromAddressForDataOwner(dataOwnerId: string, address: string): BaseFilterOptions<Message>;

	/**
	 *
	 *  In group version of [fromAddressForDataOwner].
	 */
	fromAddressForDataOwnerInGroup(dataOwner: EntityReferenceInGroup,
			address: string): BaseFilterOptions<Message>;

	/**
	 *
	 *  Filter options for message filtering that will match all messages shared directly (i.e. ignoring hierarchies) with the current data owner
	 *  where [Message.fromAddress] is equal to [address].
	 *
	 *  @param address the sender address.
	 */
	fromAddressForSelf(address: string): FilterOptions<Message>;

	/**
	 *
	 *  Options for message filtering which match all messages shared directly (i.e. ignoring hierarchies) with a specific data owner
	 *  that are linked with one of the provided patients.
	 *  This Options also allows to restrict the messages based on [Message.sent]:
	 *  - if [from] is not null, only the messages where [Message.sent] is greater than or equal to [from] will be returned.
	 *  - if [to] is not null, only the messages where [Message.sent] is less than or equal to [to] will be returned.
	 *
	 *  When using these options the sdk will automatically extract the secret ids from the provided patients and use
	 *  those for filtering.
	 *  If you already have the secret ids of the patient you may instead use [byPatientSecretIdsSentDateForDataOwner].
	 *  If the current data owner does not have access to any secret id of one of the provide patients the patient will
	 *  simply be ignored.
	 *  Note that these may not be used in methods of apis from [CardinalBaseApis].
	 *
	 *  These options are sortable. When sorting using these options the messages will be sorted by [Message.sent] in ascending or
	 *  descending order according to the value of the [descending] parameter.
	 *
	 *  @param dataOwnerId a data owner id
	 *  @param patients a list of patients.
	 *  @param from the minimum value for [Message.sent] (default: no limit).
	 *  @param to the maximum value for [Message.sent] (default: no limit).
	 *  @param descending whether to sort the result in descending or ascending order by [Message.sent] (default: ascending).
	 */
	byPatientsSentDateForDataOwner(dataOwnerId: string, patients: Array<Patient>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): SortableFilterOptions<Message>;

	/**
	 *
	 *  In-group version of [byPatientsSentDateForDataOwner].
	 */
	byPatientsSentDateForDataOwnerInGroup(dataOwner: EntityReferenceInGroup,
			patients: Array<GroupScoped<Patient>>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): SortableFilterOptions<Message>;

	/**
	 *
	 *  Options for message filtering which match all messages shared directly (i.e. ignoring hierarchies) with a specific data owner
	 *  that are linked with one of the provided patients.
	 *  This Options also allows to restrict the messages based on [Message.sent]:
	 *  - if [from] is not null, only the messages where [Message.sent] is greater than or equal to [from] will be returned.
	 *  - if [to] is not null, only the messages where [Message.sent] is less than or equal to [to] will be returned.
	 *
	 *  When using these options the sdk will automatically extract the secret ids from the provided patients and use
	 *  those for filtering.
	 *  If you already have the secret ids of the patient you may instead use [byPatientSecretIdsSentDateForSelf].
	 *  If the current data owner does not have access to any secret id of one of the provide patients the patient will
	 *  simply be ignored.
	 *  Note that these may not be used in methods of apis from [CardinalBaseApis].
	 *
	 *  These options are sortable. When sorting using these options the messages will be sorted by [Message.sent] in ascending or
	 *  descending order according to the value of the [descending] parameter.
	 *
	 *  @param patients a list of patients.
	 *  @param from the minimum value for [Message.sent] (default: no limit).
	 *  @param to the maximum value for [Message.sent] (default: no limit).
	 *  @param descending whether to sort the result in descending or ascending order by [Message.sent] (default: ascending).
	 */
	byPatientsSentDateForSelf(patients: Array<Patient>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): SortableFilterOptions<Message>;

	/**
	 *
	 *  Options for message filtering which match all messages shared directly (i.e. ignoring hierarchies) with a specific data owner
	 *  that are linked with one of the provided patients through one of the provided secret ids.
	 *  This Options also allows to restrict the messages based on [Message.sent]:
	 *  - if [from] is not null, only the messages where [Message.sent] is greater than or equal to [from] will be returned.
	 *  - if [to] is not null, only the messages where [Message.sent] is less than or equal to [to] will be returned.
	 *
	 *  If the current data owner does not have access to any secret id of one of the provide patients the patient will
	 *  simply be ignored.
	 *
	 *  These options are sortable. When sorting using these options the messages will be sorted by [Message.sent] in ascending or
	 *  descending order according to the value of the [descending] parameter.
	 *
	 *  @param dataOwnerId the id of a data owner.
	 *  @param secretIds a list of patient secret ids.
	 *  @param from the minimum value for [Message.sent] (default: no limit).
	 *  @param to the maximum value for [Message.sent] (default: no limit).
	 *  @param descending whether to sort the result in descending or ascending order by [Message.sent] (default: ascending).
	 */
	byPatientSecretIdsSentDateForDataOwner(dataOwnerId: string, secretIds: Array<string>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): BaseSortableFilterOptions<Message>;

	/**
	 *
	 *  In group version of [byPatientSecretIdsSentDateForDataOwner].
	 */
	byPatientSecretIdsSentDateForDataOwnerInGroup(dataOwner: EntityReferenceInGroup,
			secretIds: Array<string>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): BaseSortableFilterOptions<Message>;

	/**
	 *
	 *  Options for message filtering which match all messages shared directly (i.e. ignoring hierarchies) with the current data owner
	 *  that are linked with one of the provided patients through one of the provided secret ids.
	 *  This Options also allows to restrict the messages based on [Message.sent]:
	 *  - if [from] is not null, only the messages where [Message.sent] is greater than or equal to [from] will be returned.
	 *  - if [to] is not null, only the messages where [Message.sent] is less than or equal to [to] will be returned.
	 *
	 *  If the current data owner does not have access to any secret id of one of the provide patients the patient will
	 *  simply be ignored.
	 *  Note that these may not be used in methods of apis from [CardinalBaseApis].
	 *
	 *  These options are sortable. When sorting using these options the messages will be sorted by [Message.sent] in ascending or
	 *  descending order according to the value of the [descending] parameter.
	 *
	 *  @param secretIds a list of patient secret ids.
	 *  @param from the minimum value for [Message.sent] (default: no limit).
	 *  @param to the maximum value for [Message.sent] (default: no limit).
	 *  @param descending whether to sort the result in descending or ascending order by [Message.sent] (default: ascending).
	 */
	byPatientSecretIdsSentDateForSelf(secretIds: Array<string>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): SortableFilterOptions<Message>;

	/**
	 *
	 *  Filter options for message filtering that will match all messages shared directly (i.e. ignoring hierarchies) with a specific data owner
	 *  where [Message.toAddresses] contains [address].
	 *
	 *  @param dataOwnerId the id of a data owner.
	 *  @param address a receiver address.
	 */
	toAddressForDataOwner(dataOwnerId: string, address: string): BaseFilterOptions<Message>;

	/**
	 *
	 *  In-group version of [toAddressForDataOwner].
	 */
	toAddressForDataOwnerInGroup(dataOwner: EntityReferenceInGroup,
			address: string): BaseFilterOptions<Message>;

	/**
	 *
	 *  Filter options for message filtering that will match all messages shared directly (i.e. ignoring hierarchies) with the current data owner
	 *  where [Message.toAddresses] contains [address].
	 *
	 *  @param address a receiver address.
	 */
	toAddressForSelf(address: string): FilterOptions<Message>;

	/**
	 *
	 *  Filter options for message filtering that will match all messages shared directly (i.e. ignoring hierarchies) with a specific data owner
	 *  where [Message.transportGuid] is equal to [transportGuid] and [Message.sent] is between [from] (inclusive) and [to] (inclusive).
	 *
	 *  These options are sortable. When sorting using these options the messages will be sorted by [Message.sent] in ascending or
	 *  descending order according to the value of the [descending] parameter.
	 *
	 *  @param dataOwnerId the id of a data owner.
	 *  @param transportGuid the transport guid to use in the filter.
	 *  @param from the minimum value for [Message.sent].
	 *  @param to the maximum value for [Message.sent].
	 *  @param descending whether to sort the results in descending or ascending order by [Message.sent] (default: ascending).
	 */
	byTransportGuidSentDateForDataOwner(
			dataOwnerId: string,
			transportGuid: string,
			from: number | undefined,
			to: number | undefined,
			options?: { descending?: boolean }
	): BaseSortableFilterOptions<Message>;

	/**
	 *
	 *  In group version of [byTransportGuidSentDateForDataOwner].
	 */
	byTransportGuidSentDateForDataOwnerInGroup(
			dataOwner: EntityReferenceInGroup,
			transportGuid: string,
			from: number | undefined,
			to: number | undefined,
			options?: { descending?: boolean }
	): BaseSortableFilterOptions<Message>;

	/**
	 *
	 *  Filter options for message filtering that will match all messages shared directly (i.e. ignoring hierarchies) with the current data owner
	 *  where [Message.transportGuid] is equal to [transportGuid] and [Message.sent] is between [from] (inclusive) and [to] (inclusive).
	 *
	 *  These options are sortable. When sorting using these options the messages will be sorted by [Message.sent] in ascending or
	 *  descending order according to the value of the [descending] parameter.
	 *
	 *  @param transportGuid the transport guid to use in the filter.
	 *  @param from the minimum value for [Message.sent].
	 *  @param to the maximum value for [Message.sent].
	 *  @param descending whether to sort the results in descending or ascending order by [Message.sent] (default: ascending).
	 */
	byTransportGuidSentDateForSelf(transportGuid: string, from: number | undefined,
			to: number | undefined, options?: { descending?: boolean }): SortableFilterOptions<Message>;

	/**
	 *
	 *  Filter options for message filtering that will match all messages shared directly (i.e. ignoring hierarchies) with a specific data owner
	 *  where [Message.transportGuid] is equal to [transportGuid].
	 *
	 *  This filter will return only the message with the greatest [Message.created].
	 *
	 *  @param dataOwnerId a data owner id.
	 *  @param transportGuid the transport guid to use in the filter.
	 */
	latestByTransportGuidForDataOwner(dataOwnerId: string,
			transportGuid: string): BaseFilterOptions<Message>;

	/**
	 *
	 *  In group version of [latestByTransportGuidForDataOwner].
	 */
	latestByTransportGuidForDataOwnerInGroup(dataOwner: EntityReferenceInGroup,
			transportGuid: string): BaseFilterOptions<Message>;

	/**
	 *
	 *  Filter options for message filtering that will match all messages shared directly (i.e. ignoring hierarchies) with the current data owner
	 *  where [Message.transportGuid] is equal to [transportGuid].
	 *
	 *  This filter will return only the message with the greatest [Message.created].
	 *
	 *  @param transportGuid the transport guid to use in the filter.
	 */
	latestByTransportGuidForSelf(transportGuid: string): FilterOptions<Message>;

	/**
	 *
	 *  Filter options for message filtering that will match all messages where [Message.invoiceIds] contains at least one of the provided
	 *  [invoiceIds].
	 *
	 *  @param invoiceIds the invoice ids to search.
	 */
	byInvoiceIds(invoiceIds: Array<string>): BaseFilterOptions<Message>;

	/**
	 *
	 *  Filter options for message filtering that will match all messages where [Message.parentId] is among the provided [parentIds].
	 *
	 *  @param parentIds the parent ids to search.
	 */
	byParentIds(parentIds: Array<string>): BaseFilterOptions<Message>;

	/**
	 *
	 *  Options for message filtering which match all messages shared directly (i.e. ignoring hierarchies) with a specific data owner
	 *  and where the max among [Message.created], [Message.modified], and [Message.deletionDate] is greater or equal than
	 *  [startTimestamp] (if provided) and less than or equal to [endTimestamp] (if provided).
	 *
	 *  @param dataOwnerId a data owner id.
	 *  @param startTimestamp the smallest lifecycle update that the filter will return.
	 *  @param endTimestamp the biggest lifecycle update that the filter will return.
	 *  @param descending whether to return the results sorted in ascending or descending order by last lifecycle update.
	 */
	lifecycleBetweenForDataOwner(dataOwnerId: string, startTimestamp: number | undefined,
			endTimestamp: number | undefined, descending: boolean): BaseFilterOptions<Message>;

	/**
	 *
	 *  In-group version of [lifecycleBetweenForDataOwner].
	 *  The data owner can be from a different group than the group of the user executing the query.
	 */
	lifecycleBetweenForDataOwnerInGroupInGroup(dataOwner: EntityReferenceInGroup,
			startTimestamp: number | undefined, endTimestamp: number | undefined,
			descending: boolean): BaseFilterOptions<Message>;

	/**
	 *
	 *  Options for message filtering which match all messages shared directly (i.e. ignoring hierarchies) with the current data owner
	 *  and where the max among [Message.created], [Message.modified], and [Message.deletionDate] is greater or equal than
	 *  [startTimestamp] (if provided) and less than or equal to [endTimestamp] (if provided).
	 *
	 *  @param startTimestamp the smallest lifecycle update that the filter will return.
	 *  @param endTimestamp the biggest lifecycle update that the filter will return.
	 *  @param descending whether to return the results sorted in ascending or descending order by last lifecycle update.
	 */
	lifecycleBetweenForSelf(startTimestamp: number | undefined, endTimestamp: number | undefined,
			descending: boolean): FilterOptions<Message>;

	/**
	 *
	 *  Options for message filtering which match all messages shared directly (i.e. ignoring hierarchies) with a specific data owner that have a certain code.
	 *  If you specify only the [codeType] you will get all entities that have at least a code of that type.
	 *
	 *  These options are sortable. When sorting using these options the messages will be sorted by [codeCode].
	 *
	 *  @param dataOwnerId a data owner id
	 *  @param codeType a code type
	 *  @param codeCode a code for the provided code type, or null if you want the filter to accept any entity
	 *  with a code of the provided type.
	 */
	byCodeForDataOwner(dataOwnerId: string, codeType: string,
			options?: { codeCode?: string | undefined }): BaseSortableFilterOptions<Message>;

	/**
	 *
	 *  In group version of [byCodeForDataOwner].
	 */
	byCodeForDataOwnerInGroup(dataOwner: EntityReferenceInGroup, codeType: string,
			options?: { codeCode?: string | undefined }): BaseSortableFilterOptions<Message>;

	/**
	 *
	 *  Options for message filtering which match all messages shared directly (i.e. ignoring hierarchies) with the current data owner that have a certain code.
	 *  If you specify only the [codeType] you will get all entities that have at least a code of that type.
	 *
	 *  These options are sortable. When sorting using these options the messages will be sorted by [codeCode].
	 *
	 *  @param codeType a code type
	 *  @param codeCode a code for the provided code type, or null if you want the filter to accept any entity
	 *  with a code of the provided type.
	 */
	byCodeForSelf(codeType: string,
			options?: { codeCode?: string | undefined }): SortableFilterOptions<Message>;

	/**
	 *
	 *  Options for message filtering which match all messages shared directly (i.e. ignoring hierarchies) with a specific data owner that have a certain tag.
	 *  If you specify only the [tagType] you will get all entities that have at least a tag of that type.
	 *
	 *  These options are sortable. When sorting using these options the messages will be sorted by [tagCode].
	 *
	 *  @param dataOwnerId a data owner id
	 *  @param tagType a tag type
	 *  @param tagCode a code for the provided tag type, or null if you want the filter to accept any entity
	 *  with a tag of the provided type.
	 */
	byTagForDataOwner(dataOwnerId: string, tagType: string,
			options?: { tagCode?: string | undefined }): BaseSortableFilterOptions<Message>;

	/**
	 *
	 *  In group version of [byTagForDataOwner].
	 */
	byTagForDataOwnerInGroup(dataOwner: EntityReferenceInGroup, tagType: string,
			options?: { tagCode?: string | undefined }): BaseSortableFilterOptions<Message>;

	/**
	 *
	 *  Options for message filtering which match all messages shared directly (i.e. ignoring hierarchies) with the current data owner that have a certain tag.
	 *  If you specify only the [tagType] you will get all entities that have at least a tag of that type.
	 *
	 *  These options are sortable. When sorting using these options the messages will be sorted by [tagCode].
	 *
	 *  @param tagType a tag type
	 *  @param tagCode a code for the provided tag type, or null if you want the filter to accept any entity
	 *  with a tag of the provided type.
	 */
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
