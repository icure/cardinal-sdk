// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, FilterOptions, InternalContactFiltersObj, SortableFilterOptions} from '../cardinal-sdk-ts.mjs';
import {Contact} from '../model/Contact.mjs';
import {EntityReferenceInGroup} from '../model/EntityReferenceInGroup.mjs';
import {GroupScoped} from '../model/GroupScoped.mjs';
import {Patient} from '../model/Patient.mjs';
import {Identifier} from '../model/base/Identifier.mjs';


interface ContactFiltersFactory {

	/**
	 *
	 *  Create options for contact filtering that will match all contacts shared directly (i.e. ignoring hierarchies) with a specific data owner.
	 *  @param dataOwnerId a data owner id
	 */
	allContactsForDataOwner(dataOwnerId: string): BaseFilterOptions<Contact>;

	/**
	 *
	 *  A version of [allContactsForDataOwner] for a data owner in a group.
	 */
	allContactsForDataOwnerInGroup(dataOwner: EntityReferenceInGroup): BaseFilterOptions<Contact>;

	/**
	 *
	 *  Create options for contact filtering that will match all contacts shared directly (i.e. ignoring hierarchies) with the current data owner.
	 */
	allContactsForSelf(): FilterOptions<Contact>;

	/**
	 *
	 *  Options for contact filtering which match all the contacts shared directly (i.e. ignoring hierarchies) with a specific data owner where
	 *  there is at least one [Contact.subContacts] or [Contact.services] with one of the provided [formIds] in [SubContact.formId] or
	 *  [Service.formIds], respectively.
	 *
	 *  @param dataOwnerId a data owner id.
	 *  @param formIds a set of form ids.
	 */
	byFormIdsForDataOwner(dataOwnerId: string, formIds: Array<string>): BaseFilterOptions<Contact>;

	/**
	 *
	 *  A version of [byFormIdsForDataOwner] for a data owner in a group.
	 */
	byFormIdsForDataOwnerInGroup(dataOwner: EntityReferenceInGroup,
			formIds: Array<string>): BaseFilterOptions<Contact>;

	/**
	 *
	 *  Options for contact filtering which match all the contacts shared directly (i.e. ignoring hierarchies) with the current data owner where
	 *  there is at least one [Contact.subContacts] or [Contact.services] with one of the provided [formIds] in [SubContact.formId] or
	 *  [Service.formIds], respectively.
	 *
	 *  @param formIds a set of form ids.
	 */
	byFormIdsForSelf(formIds: Array<string>): FilterOptions<Contact>;

	/**
	 *
	 *  Options for contact filtering which match all contacts shared directly (i.e. ignoring hierarchies) with a specific data owner
	 *  that are linked with one of the provided patients.
	 *  This Options also allows to restrict the contacts based on [Contact.openingDate]:
	 *  - if the [from] fuzzy date is not null, only the contacts where [Contact.openingDate] is greater than or equal to [from] will be returned.
	 *  - if the [to] fuzzy date is not null, only the contacts where [Contact.openingDate] is less than or equal to [to] will be returned.
	 *
	 *  When using these options the sdk will automatically extract the secret ids from the provided patients and use
	 *  those for filtering.
	 *  If you already have the secret ids of the patient you may instead use [byPatientSecretIdsOpeningDateForDataOwner].
	 *  If the current data owner does not have access to any secret id of one of the provide patients the patient will
	 *  simply be ignored.
	 *  Note that these may not be used in methods of apis from [CardinalBaseApis].
	 *
	 *  These options are sortable. When sorting using these options the contacts will be sorted by [Contact.openingDate] in ascending or
	 *  descending order according to the value of the [descending] parameter.
	 *
	 *  @param dataOwnerId a data owner id
	 *  @param patients a list of patients.
	 *  @param from the minimum fuzzy date for [Contact.openingDate], in the YYYYMMDDHHMMSS format (default: no limit).
	 *  @param to the maximum fuzzy date for [Contact.openingDate], in the YYYYMMDDHHMMSS format (default: no limit).
	 *  @param descending whether to sort the result in descending or ascending order by [Contact.openingDate] (default: ascending).
	 */
	byPatientsOpeningDateForDataOwner(dataOwnerId: string, patients: Array<Patient>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): SortableFilterOptions<Contact>;

	/**
	 *
	 *  A version of [byPatientsOpeningDateForDataOwner] for a data owner in a group.
	 */
	byPatientsOpeningDateForDataOwnerInGroup(dataOwner: EntityReferenceInGroup,
			patients: Array<GroupScoped<Patient>>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): SortableFilterOptions<Contact>;

	/**
	 *
	 *  Options for contact filtering which match all contacts shared directly (i.e. ignoring hierarchies) with the current data owner
	 *  that are linked with one of the provided patients.
	 *  This Options also allows to restrict the contacts based on [Contact.openingDate]:
	 *  - if the [from] fuzzy date is not null, only the contacts where [Contact.openingDate] is greater than or equal to [from] will be returned.
	 *  - if the [to] fuzzy date is not null, only the contacts where [Contact.openingDate] is less than or equal to [to] will be returned.
	 *
	 *  When using these options the sdk will automatically extract the secret ids from the provided patients and use
	 *  those for filtering.
	 *  If you already have the secret ids of the patient you may instead use [byPatientSecretIdsOpeningDateForSelf].
	 *  If the current data owner does not have access to any secret id of one of the provide patients the patient will
	 *  simply be ignored.
	 *  Note that these may not be used in methods of apis from [CardinalBaseApis].
	 *
	 *  These options are sortable. When sorting using these options the contacts will be sorted by [Contact.openingDate] in ascending or
	 *  descending order according to the value of the [descending] parameter.
	 *
	 *  @param patients a list of patients.
	 *  @param from the minimum fuzzy date for [Contact.openingDate], in the YYYYMMDDHHMMSS format (default: no limit).
	 *  @param to the maximum fuzzy date for [Contact.openingDate], in the YYYYMMDDHHMMSS format (default: no limit).
	 *  @param descending whether to sort the result in descending or ascending order by [Contact.openingDate] (default: ascending).
	 */
	byPatientsOpeningDateForSelf(patients: Array<Patient>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): SortableFilterOptions<Contact>;

	/**
	 *
	 *  Options for contact filtering which match all contacts shared directly (i.e. ignoring hierarchies) with a specific data owner
	 *  that are linked with one of the provided patients through one of the provided secret ids.
	 *  This Options also allows to restrict the contacts based on [Contact.openingDate]:
	 *  - if the [from] fuzzy date is not null, only the contacts where [Contact.openingDate] is greater than or equal to [from] will be returned.
	 *  - if the [to] fuzzy date is not null, only the contacts where [Contact.openingDate] is less than or equal to [to] will be returned.
	 *
	 *  If the current data owner does not have access to any secret id of one of the provide patients the patient will
	 *  simply be ignored.
	 *
	 *  These options are sortable. When sorting using these options the contacts will be sorted by [Contact.openingDate] in ascending or
	 *  descending order according to the value of the [descending] parameter.
	 *
	 *  @param dataOwnerId the id of a data owner.
	 *  @param secretIds a list of patient secret ids.
	 *  @param from the minimum fuzzy date for [Contact.openingDate], in the YYYYMMDDHHMMSS format (default: no limit).
	 *  @param to the maximum fuzzy date for [Contact.openingDate], in the YYYYMMDDHHMMSS format (default: no limit).
	 *  @param descending whether to sort the result in descending or ascending order by [Contact.openingDate] (default: ascending).
	 */
	byPatientSecretIdsOpeningDateForDataOwner(dataOwnerId: string, secretIds: Array<string>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): BaseSortableFilterOptions<Contact>;

	/**
	 *
	 *  In group version of [byPatientSecretIdsOpeningDateForDataOwner].
	 */
	byPatientSecretIdsOpeningDateForDataOwnerInGroup(dataOwner: EntityReferenceInGroup,
			secretIds: Array<string>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): BaseSortableFilterOptions<Contact>;

	/**
	 *
	 *  Options for contact filtering which match all contacts shared directly (i.e. ignoring hierarchies) with the current data owner
	 *  that are linked with one of the provided patients through one of the provided secret ids.
	 *  This Options also allows to restrict the contacts based on [Contact.openingDate]:
	 *  - if the [from] fuzzy date is not null, only the contacts where [Contact.openingDate] is greater than or equal to [from] will be returned.
	 *  - if the [to] fuzzy date is not null, only the contacts where [Contact.openingDate] is less than or equal to [to] will be returned.
	 *
	 *  If the current data owner does not have access to any secret id of one of the provide patients the patient will
	 *  simply be ignored.
	 *  Note that these may not be used in methods of apis from [CardinalBaseApis].
	 *
	 *  These options are sortable. When sorting using these options the contacts will be sorted by [Contact.openingDate] in ascending or
	 *  descending order according to the value of the [descending] parameter.
	 *
	 *  @param secretIds a list of patient secret ids.
	 *  @param from the minimum fuzzy date for [Contact.openingDate], in the YYYYMMDDHHMMSS format (default: no limit).
	 *  @param to the maximum fuzzy date for [Contact.openingDate], in the YYYYMMDDHHMMSS format (default: no limit).
	 *  @param descending whether to sort the result in descending or ascending order by [Contact.openingDate] (default: ascending).
	 */
	byPatientSecretIdsOpeningDateForSelf(secretIds: Array<string>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): SortableFilterOptions<Contact>;

	/**
	 *
	 *  Options for contact filtering which match all the contacts shared directly (i.e. ignoring hierarchies) with the current data owner that
	 *  have at least an identifier that has the same exact [Identifier.system] and [Identifier.value] as one of the provided
	 *  [identifiers]. Other properties of the provided identifiers are ignored.
	 *
	 *  These options are sortable. When sorting using these options the contacts will be in the same order as the input
	 *  identifiers. In case an entity has multiple identifiers only the first matching identifier is considered for the
	 *  sorting.
	 *
	 *  @param identifiers a list of identifiers
	 */
	byIdentifiersForSelf(identifiers: Array<Identifier>): SortableFilterOptions<Contact>;

	/**
	 *
	 *  Options for contact filtering which match all the contacts shared directly (i.e. ignoring hierarchies) with a specific data owner
	 *  that have at least an identifier that has the same exact [Identifier.system] and [Identifier.value] as one of the provided
	 *  [identifiers]. Other properties of the provided identifiers are ignored.
	 *
	 *  These options are sortable. When sorting using these options the contacts will be in the same order as the input
	 *  identifiers. In case an entity has multiple identifiers only the first matching identifier is considered for the
	 *  sorting.
	 *  @param dataOwnerId a data owner id
	 *  @param identifiers a list of identifiers
	 */
	byIdentifiersForDataOwner(dataOwnerId: string,
			identifiers: Array<Identifier>): BaseSortableFilterOptions<Contact>;

	/**
	 *
	 *  In group version of [byIdentifiersForDataOwner].
	 */
	byIdentifiersForDataOwnerInGroup(dataOwner: EntityReferenceInGroup,
			identifiers: Array<Identifier>): BaseSortableFilterOptions<Contact>;

	/**
	 *
	 *  Options for contact filtering which match all contacts shared directly (i.e. ignoring hierarchies) with a specific
	 *  data owner that have a certain code.
	 *  If you specify only the [codeType] you will get all entities that have at least a code of that type.
	 *
	 *  You can also limit the result to only contacts that are within a certain opening date timeframe, but in that case
	 *  you must specify the [codeCode].
	 *
	 *  These options are sortable. When sorting using these options the contacts will be sorted first by [codeCode] then
	 *  by [Contact.openingDate].
	 *
	 *  @param dataOwnerId a data owner id
	 *  @param codeType a code type
	 *  @param codeCode a code for the provided code type, or null if you want the filter to accept any entity
	 *  with a code of the provided type.
	 *  @param startOfContactOpeningDate if provided the options will match only contacts with an opening date
	 *  that is after this value (inclusive).
	 *  @param endOfContactOpeningDate if provided the options will match only contacts with an opening date
	 *  that is before this value (inclusive).
	 *  @throws IllegalArgumentException if you provide a range for the opening date but no [codeCode].
	 */
	byCodeAndOpeningDateForDataOwner(dataOwnerId: string, codeType: string,
			options?: { codeCode?: string | undefined, startOfContactOpeningDate?: number | undefined, endOfContactOpeningDate?: number | undefined }): BaseSortableFilterOptions<Contact>;

	/**
	 *
	 *  In group version of [byCodeAndOpeningDateForDataOwner].
	 */
	byCodeAndOpeningDateForDataOwnerInGroup(dataOwner: EntityReferenceInGroup, codeType: string,
			options?: { codeCode?: string | undefined, startOfContactOpeningDate?: number | undefined, endOfContactOpeningDate?: number | undefined }): BaseSortableFilterOptions<Contact>;

	/**
	 *
	 *  Options for contact filtering which match all contacts shared directly (i.e. ignoring hierarchies) with the current data owner that have a certain code.
	 *  If you specify only the [codeType] you will get all entities that have at least a code of that type.
	 *
	 *  You can also limit the result to only contacts that are within a certain opening date timeframe, but in that case
	 *  you must specify the [codeCode].
	 *
	 *  These options are sortable. When sorting using these options the contacts will be sorted first by [codeCode] then
	 *  by [Contact.openingDate].
	 *
	 *  @param codeType a code type
	 *  @param codeCode a code for the provided code type, or null if you want the filter to accept any entity
	 *  with a code of the provided type.
	 *  @param startOfContactOpeningDate if provided the options will match only contacts with an opening date
	 *  that is after this value (inclusive).
	 *  @param endOfContactOpeningDate if provided the options will match only contacts with an opening date
	 *  that is before this value (inclusive).
	 *  @throws IllegalArgumentException if you provide a range for the opening date but no [codeCode].
	 */
	byCodeAndOpeningDateForSelf(codeType: string,
			options?: { codeCode?: string | undefined, startOfContactOpeningDate?: number | undefined, endOfContactOpeningDate?: number | undefined }): SortableFilterOptions<Contact>;

	/**
	 *
	 *  Options for contact filtering which match all contacts shared directly (i.e. ignoring hierarchies) with a specific data owner that have a certain tag.
	 *  If you specify only the [tagType] you will get all entities that have at least a tag of that type.
	 *
	 *  You can also limit the result to only contacts that are within a certain opening date timeframe, but in that case
	 *  you must specify the [tagCode].
	 *
	 *  These options are sortable. When sorting using these options the contacts will be sorted first by [tagCode] then
	 *  by [Contact.openingDate].
	 *
	 *  @param dataOwnerId a data owner id
	 *  @param tagType a tag type
	 *  @param tagCode a code for the provided tag type, or null if you want the filter to accept any entity
	 *  with a tag of the provided type.
	 *  @param startOfContactOpeningDate if provided the options will match only contacts with an opening date
	 *  that is after this value (inclusive).
	 *  @param endOfContactOpeningDate if provided the options will match only contacts with an opening date
	 *  that is before this value (inclusive).
	 *  @throws IllegalArgumentException if you provide a range for the opening date but no [tagCode].
	 */
	byTagAndOpeningDateForDataOwner(dataOwnerId: string, tagType: string,
			options?: { tagCode?: string | undefined, startOfContactOpeningDate?: number | undefined, endOfContactOpeningDate?: number | undefined }): BaseSortableFilterOptions<Contact>;

	/**
	 *
	 *  In group version of [byTagAndOpeningDateForDataOwner].
	 */
	byTagAndOpeningDateForDataOwnerInGroup(dataOwner: EntityReferenceInGroup, tagType: string,
			options?: { tagCode?: string | undefined, startOfContactOpeningDate?: number | undefined, endOfContactOpeningDate?: number | undefined }): BaseSortableFilterOptions<Contact>;

	/**
	 *
	 *  Options for contact filtering which match all contacts shared directly (i.e. ignoring hierarchies) with a specific data owner.
	 *  You can also limit the timeframe of the contacts:
	 *  - If the [startDate] fuzzy date is specified, only the contacts where [Contact.openingDate] is greater than or equal to [startDate] will be returned.
	 *  - If the [endDate] fuzzy date is specified, only the contacts where [Contact.openingDate] is less than or equal to [startDate] will be returned.
	 *
	 *  These options are sortable. When sorting using these options the contacts will be sorted first by [Contact.openingDate].
	 *
	 *  @param dataOwnerId a data owner id.
	 *  with a tag of the provided type.
	 *  @param startDate a fuzzy date. If provided the options will match only contacts with an opening date
	 *  that is after this value (inclusive).
	 *  @param endDate a fuzzy date. If provided the options will match only contacts with an opening date
	 *  that is before this value (inclusive).
	 *  @param descending whether to return in descending or ascending order by [Contact.openingDate]. (default: ascending).
	 */
	byOpeningDateForDataOwner(dataOwnerId: string,
			options?: { startDate?: number | undefined, endDate?: number | undefined, descending?: boolean }): BaseSortableFilterOptions<Contact>;

	/**
	 *
	 *  In group version of [byOpeningDateForDataOwner].
	 */
	byOpeningDateForDataOwnerInGroup(dataOwner: EntityReferenceInGroup,
			options?: { startDate?: number | undefined, endDate?: number | undefined, descending?: boolean }): BaseSortableFilterOptions<Contact>;

	/**
	 *
	 *  Options for contact filtering which match all contacts shared directly (i.e. ignoring hierarchies) with the current data owner.
	 *  You can also limit the timeframe of the contacts:
	 *  - If the [startDate] fuzzy date is specified, only the contacts where [Contact.openingDate] is greater than or equal to [startDate] will be returned.
	 *  - If the [endDate] fuzzy date is specified, only the contacts where [Contact.openingDate] is less than or equal to [startDate] will be returned.
	 *
	 *  These options are sortable. When sorting using these options the contacts will be sorted first by [Contact.openingDate].
	 *
	 *  with a tag of the provided type.
	 *  @param startDate a fuzzy date. If provided the options will match only contacts with an opening date
	 *  that is after this value (inclusive).
	 *  @param endDate a fuzzy date. If provided the options will match only contacts with an opening date
	 *  that is before this value (inclusive).
	 *  @param descending whether to return in descending or ascending order by [Contact.openingDate]. (default: ascending).
	 */
	byOpeningDateForSelf(options?: { startDate?: number | undefined, endDate?: number | undefined, descending?: boolean }): SortableFilterOptions<Contact>;

	/**
	 *
	 *  Options for contact filtering which match all contacts shared directly (i.e. ignoring hierarchies) with the current data owner
	 *  where in [Contact.services] there is at least one service that in his tags has a code stub with the specified type and the specified
	 *  code (if provided).
	 *
	 *  @param tagType a tag type
	 *  @param tagCode a code for the provided tag type, or null if you want the filter to accept any entity
	 *  with a tag of the provided type.
	 */
	byServiceTagForSelf(tagType: string,
			options?: { tagCode?: string | undefined }): FilterOptions<Contact>;

	/**
	 *
	 *  Options for contact filtering which match all contacts shared directly (i.e. ignoring hierarchies) with a specific data owner
	 *  where in [Contact.services] there is at least one service that in his tags has a code stub with the specified type and the specified
	 *  code (if provided).
	 *
	 *  @param tagType a tag type
	 *  @param tagCode a code for the provided tag type, or null if you want the filter to accept any entity
	 *  with a tag of the provided type.
	 */
	byServiceTagForDataOwner(dataOwnerId: string, tagType: string,
			options?: { tagCode?: string | undefined }): BaseFilterOptions<Contact>;

	/**
	 *
	 *  In group version of [byServiceTagForDataOwner].
	 */
	byServiceTagForDataOwnerInGroup(dataOwner: EntityReferenceInGroup, tagType: string,
			options?: { tagCode?: string | undefined }): BaseFilterOptions<Contact>;

	/**
	 *
	 *  Options for contact filtering which match all contacts shared directly (i.e. ignoring hierarchies) with the current data owner
	 *  where in [Contact.services] there is at least one service that in his codes has a code stub with the specified type and the specified
	 *  code (if provided).
	 *
	 *  @param codeType a code type
	 *  @param codeCode a code for the provided code type, or null if you want the filter to accept any entity
	 *  with a code of the provided type.
	 */
	byServiceCodeForSelf(codeType: string,
			options?: { codeCode?: string | undefined }): FilterOptions<Contact>;

	/**
	 *
	 *  Options for contact filtering which match all contacts shared directly (i.e. ignoring hierarchies) with a specific data owner
	 *  where in [Contact.services] there is at least one service that in his codes has a code stub with the specified type and the specified
	 *  code (if provided).
	 *
	 *  @param codeType a code type
	 *  @param codeCode a code for the provided code type, or null if you want the filter to accept any entity
	 *  with a code of the provided type.
	 */
	byServiceCodeForDataOwner(dataOwnerId: string, codeType: string,
			options?: { codeCode?: string | undefined }): BaseFilterOptions<Contact>;

	/**
	 *
	 *  In group version of [byServiceCodeForDataOwner].
	 */
	byServiceCodeForDataOwnerInGroup(dataOwner: EntityReferenceInGroup, codeType: string,
			options?: { codeCode?: string | undefined }): BaseFilterOptions<Contact>;

	/**
	 *
	 *  Options for contact filtering which match all contacts shared directly (i.e. ignoring hierarchies) with the current data owner that have a certain tag.
	 *  If you specify only the [tagType] you will get all entities that have at least a tag of that type.
	 *
	 *  You can also limit the result to only contacts that are within a certain opening date timeframe, but in that case
	 *  you must specify the [tagCode].
	 *
	 *  These options are sortable. When sorting using these options the contacts will be sorted first by [tagCode] then
	 *  by [Contact.openingDate].
	 *
	 *  @param tagType a tag type
	 *  @param tagCode a code for the provided tag type, or null if you want the filter to accept any entity
	 *  with a tag of the provided type.
	 *  @param startOfContactOpeningDate if provided the options will match only contacts with an opening date
	 *  that is after this value (inclusive).
	 *  @param endOfContactOpeningDate if provided the options will match only contacts with an opening date
	 *  that is before this value (inclusive).
	 *  @throws IllegalArgumentException if you provide a range for the opening date but no [tagCode].
	 */
	byTagAndOpeningDateForSelf(tagType: string,
			options?: { tagCode?: string | undefined, startOfContactOpeningDate?: number | undefined, endOfContactOpeningDate?: number | undefined }): SortableFilterOptions<Contact>;

	/**
	 *
	 *  Options for contact filtering which match all contacts shared directly (i.e. ignoring hierarchies) with a specific data owner that are linked with one
	 *  of the provided patients.
	 *
	 *  When using these options the sdk will automatically extract the secret ids from the provided patients and use
	 *  those for filtering.
	 *  If you already have the secret ids of the patient you may instead use [byPatientsSecretIdsForDataOwner].
	 *  If the current data owner does not have access to any secret id of one of the provide patients the patient will
	 *  simply be ignored.
	 *  Note that these may not be used in methods of apis from [CardinalBaseApis].
	 *
	 *  These options are sortable. When sorting using these options the contacts will be sorted by the patients, using
	 *  the same order as the input patients.
	 *
	 *  @param dataOwnerId a data owner id
	 *  @param patients a list of patients.
	 */
	byPatientsForDataOwner(dataOwnerId: string,
			patients: Array<Patient>): SortableFilterOptions<Contact>;

	/**
	 *
	 *  In group version of [byPatientsForDataOwner].
	 */
	byPatientsForDataOwnerInGroup(dataOwner: EntityReferenceInGroup,
			patients: Array<GroupScoped<Patient>>): SortableFilterOptions<Contact>;

	/**
	 *
	 *  Options for contact filtering which match all contacts shared directly (i.e. ignoring hierarchies) with the current data owner that are linked with one
	 *  of the provided patients.
	 *
	 *  When using these options the sdk will automatically extract the secret ids from the provided patients and use
	 *  those for filtering.
	 *  If you already have the secret ids of the patient you may instead use [byPatientsSecretIdsForSelf].
	 *  If the current data owner does not have access to any secret id of one of the provide patients the patient will
	 *  simply be ignored.
	 *  Note that these may not be used in methods of apis from [CardinalBaseApis].
	 *
	 *  These options are sortable. When sorting using these options the contacts will be sorted by the patients, using
	 *  the same order as the input patients.
	 *
	 *  @param patients a list of patients.
	 */
	byPatientsForSelf(patients: Array<Patient>): SortableFilterOptions<Contact>;

	/**
	 *
	 *  Options for contact filtering which match all contacts shared directly (i.e. ignoring hierarchies) with a specific data owner that are linked with a
	 *  patient through one of the provided secret ids.
	 *  These options are sortable. When sorting using these options the contacts will be sorted by the linked patients
	 *  secret id, using the same order as the input.
	 *
	 *  @param dataOwnerId a data owner id
	 *  @param secretIds a list of patients secret ids
	 */
	byPatientsSecretIdsForDataOwner(dataOwnerId: string,
			secretIds: Array<string>): BaseSortableFilterOptions<Contact>;

	/**
	 *
	 *  In group version of [byPatientsSecretIdsForDataOwner].
	 */
	byPatientsSecretIdsForDataOwnerInGroup(dataOwner: EntityReferenceInGroup,
			secretIds: Array<string>): BaseSortableFilterOptions<Contact>;

	/**
	 *
	 *  Options for contact filtering which match all contacts shared directly (i.e. ignoring hierarchies) with the current data owner that are linked with a
	 *  patient through one of the provided secret ids.
	 *  These options are sortable. When sorting using these options the contacts will be sorted by the linked patients
	 *  secret id, using the same order as the input.
	 *
	 *  @param secretIds a list of patients secret ids
	 */
	byPatientsSecretIdsForSelf(secretIds: Array<string>): SortableFilterOptions<Contact>;

	/**
	 *
	 *  Options for contact filtering which match all contacts that have at least a service with an id in [serviceIds].
	 *  These options are sortable. When sorting using these options the contacts will be sorted in the same order as the
	 *  input service ids. If a contact has multiple services only the first matching service is considered.
	 *
	 *  @param serviceIds a list of service ids
	 */
	byServiceIds(serviceIds: Array<string>): BaseSortableFilterOptions<Contact>;

}

export const ContactFilters: ContactFiltersFactory = {
			allContactsForDataOwner: (dataOwnerId) => InternalContactFiltersObj.getInstance().allContactsForDataOwner(dataOwnerId),
			allContactsForDataOwnerInGroup: (dataOwner) => InternalContactFiltersObj.getInstance().allContactsForDataOwnerInGroup(dataOwner),
			allContactsForSelf: () => InternalContactFiltersObj.getInstance().allContactsForSelf(),
			byFormIdsForDataOwner: (dataOwnerId, formIds) => InternalContactFiltersObj.getInstance().byFormIdsForDataOwner(dataOwnerId, formIds),
			byFormIdsForDataOwnerInGroup: (dataOwner, formIds) => InternalContactFiltersObj.getInstance().byFormIdsForDataOwnerInGroup(dataOwner, formIds),
			byFormIdsForSelf: (formIds) => InternalContactFiltersObj.getInstance().byFormIdsForSelf(formIds),
			byPatientsOpeningDateForDataOwner: (dataOwnerId, patients, options) => InternalContactFiltersObj.getInstance().byPatientsOpeningDateForDataOwner(dataOwnerId, patients, options),
			byPatientsOpeningDateForDataOwnerInGroup: (dataOwner, patients, options) => InternalContactFiltersObj.getInstance().byPatientsOpeningDateForDataOwnerInGroup(dataOwner, patients, options),
			byPatientsOpeningDateForSelf: (patients, options) => InternalContactFiltersObj.getInstance().byPatientsOpeningDateForSelf(patients, options),
			byPatientSecretIdsOpeningDateForDataOwner: (dataOwnerId, secretIds, options) => InternalContactFiltersObj.getInstance().byPatientSecretIdsOpeningDateForDataOwner(dataOwnerId, secretIds, options),
			byPatientSecretIdsOpeningDateForDataOwnerInGroup: (dataOwner, secretIds, options) => InternalContactFiltersObj.getInstance().byPatientSecretIdsOpeningDateForDataOwnerInGroup(dataOwner, secretIds, options),
			byPatientSecretIdsOpeningDateForSelf: (secretIds, options) => InternalContactFiltersObj.getInstance().byPatientSecretIdsOpeningDateForSelf(secretIds, options),
			byIdentifiersForSelf: (identifiers) => InternalContactFiltersObj.getInstance().byIdentifiersForSelf(identifiers),
			byIdentifiersForDataOwner: (dataOwnerId, identifiers) => InternalContactFiltersObj.getInstance().byIdentifiersForDataOwner(dataOwnerId, identifiers),
			byIdentifiersForDataOwnerInGroup: (dataOwner, identifiers) => InternalContactFiltersObj.getInstance().byIdentifiersForDataOwnerInGroup(dataOwner, identifiers),
			byCodeAndOpeningDateForDataOwner: (dataOwnerId, codeType, options) => InternalContactFiltersObj.getInstance().byCodeAndOpeningDateForDataOwner(dataOwnerId, codeType, options),
			byCodeAndOpeningDateForDataOwnerInGroup: (dataOwner, codeType, options) => InternalContactFiltersObj.getInstance().byCodeAndOpeningDateForDataOwnerInGroup(dataOwner, codeType, options),
			byCodeAndOpeningDateForSelf: (codeType, options) => InternalContactFiltersObj.getInstance().byCodeAndOpeningDateForSelf(codeType, options),
			byTagAndOpeningDateForDataOwner: (dataOwnerId, tagType, options) => InternalContactFiltersObj.getInstance().byTagAndOpeningDateForDataOwner(dataOwnerId, tagType, options),
			byTagAndOpeningDateForDataOwnerInGroup: (dataOwner, tagType, options) => InternalContactFiltersObj.getInstance().byTagAndOpeningDateForDataOwnerInGroup(dataOwner, tagType, options),
			byOpeningDateForDataOwner: (dataOwnerId, options) => InternalContactFiltersObj.getInstance().byOpeningDateForDataOwner(dataOwnerId, options),
			byOpeningDateForDataOwnerInGroup: (dataOwner, options) => InternalContactFiltersObj.getInstance().byOpeningDateForDataOwnerInGroup(dataOwner, options),
			byOpeningDateForSelf: (options) => InternalContactFiltersObj.getInstance().byOpeningDateForSelf(options),
			byServiceTagForSelf: (tagType, options) => InternalContactFiltersObj.getInstance().byServiceTagForSelf(tagType, options),
			byServiceTagForDataOwner: (dataOwnerId, tagType, options) => InternalContactFiltersObj.getInstance().byServiceTagForDataOwner(dataOwnerId, tagType, options),
			byServiceTagForDataOwnerInGroup: (dataOwner, tagType, options) => InternalContactFiltersObj.getInstance().byServiceTagForDataOwnerInGroup(dataOwner, tagType, options),
			byServiceCodeForSelf: (codeType, options) => InternalContactFiltersObj.getInstance().byServiceCodeForSelf(codeType, options),
			byServiceCodeForDataOwner: (dataOwnerId, codeType, options) => InternalContactFiltersObj.getInstance().byServiceCodeForDataOwner(dataOwnerId, codeType, options),
			byServiceCodeForDataOwnerInGroup: (dataOwner, codeType, options) => InternalContactFiltersObj.getInstance().byServiceCodeForDataOwnerInGroup(dataOwner, codeType, options),
			byTagAndOpeningDateForSelf: (tagType, options) => InternalContactFiltersObj.getInstance().byTagAndOpeningDateForSelf(tagType, options),
			byPatientsForDataOwner: (dataOwnerId, patients) => InternalContactFiltersObj.getInstance().byPatientsForDataOwner(dataOwnerId, patients),
			byPatientsForDataOwnerInGroup: (dataOwner, patients) => InternalContactFiltersObj.getInstance().byPatientsForDataOwnerInGroup(dataOwner, patients),
			byPatientsForSelf: (patients) => InternalContactFiltersObj.getInstance().byPatientsForSelf(patients),
			byPatientsSecretIdsForDataOwner: (dataOwnerId, secretIds) => InternalContactFiltersObj.getInstance().byPatientsSecretIdsForDataOwner(dataOwnerId, secretIds),
			byPatientsSecretIdsForDataOwnerInGroup: (dataOwner, secretIds) => InternalContactFiltersObj.getInstance().byPatientsSecretIdsForDataOwnerInGroup(dataOwner, secretIds),
			byPatientsSecretIdsForSelf: (secretIds) => InternalContactFiltersObj.getInstance().byPatientsSecretIdsForSelf(secretIds),
			byServiceIds: (serviceIds) => InternalContactFiltersObj.getInstance().byServiceIds(serviceIds)
		};
