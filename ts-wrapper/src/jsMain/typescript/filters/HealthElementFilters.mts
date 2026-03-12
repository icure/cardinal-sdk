// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, FilterOptions, InternalHealthElementFiltersObj, SortableFilterOptions} from '../cardinal-sdk-ts.mjs';
import {EntityReferenceInGroup} from '../model/EntityReferenceInGroup.mjs';
import {GroupScoped} from '../model/GroupScoped.mjs';
import {HealthElement} from '../model/HealthElement.mjs';
import {Patient} from '../model/Patient.mjs';
import {Identifier} from '../model/base/Identifier.mjs';


interface HealthElementFiltersFactory {

	/**
	 *
	 *  Create options for health element filtering that will match all health element shared directly (i.e. ignoring hierarchies) with a specific data owner.
	 *
	 *  @param dataOwnerId a data owner id
	 *  @return options for health element filtering
	 */
	allHealthElementsForDataOwner(dataOwnerId: string): BaseFilterOptions<HealthElement>;

	/**
	 *
	 *  In group version of [allHealthElementsForDataOwner].
	 */
	allHealthElementsForDataOwnerInGroup(dataOwner: EntityReferenceInGroup): BaseFilterOptions<HealthElement>;

	/**
	 *
	 *  Create options for health element filtering that will match all health element shared directly (i.e. ignoring hierarchies) with the current data owner.
	 *
	 *  @return options for health element filtering
	 */
	allHealthElementsForSelf(): FilterOptions<HealthElement>;

	/**
	 *
	 *  Options for health element filtering which match all the health elements shared directly (i.e. ignoring hierarchies) with a specific data owner that have at least
	 *  an identifier that has the same exact [Identifier.system] and [Identifier.value] as one of the provided
	 *  [identifiers]. Other properties of the provided identifiers are ignored.
	 *
	 *  These options are sortable. When sorting using these options the health elements will be in the same order as the input
	 *  identifiers. In case an entity has multiple identifiers only the first matching identifier is considered for the
	 *  sorting.
	 *
	 *  @param dataOwnerId a data owner id or null to use the current data owner id
	 *  @param identifiers a list of identifiers
	 *  @return options for health element filtering
	 */
	byIdentifiersForDataOwner(dataOwnerId: string,
			identifiers: Array<Identifier>): BaseSortableFilterOptions<HealthElement>;

	/**
	 *
	 *  In group version of [byIdentifiersForDataOwner].
	 */
	byIdentifiersForDataOwnerInGroup(dataOwner: EntityReferenceInGroup,
			identifiers: Array<Identifier>): BaseSortableFilterOptions<HealthElement>;

	/**
	 *
	 *  Options for health element filtering which match all the health elements shared directly (i.e. ignoring hierarchies) with the current data owner that have at least
	 *  an identifier that has the same exact [Identifier.system] and [Identifier.value] as one of the provided
	 *  [identifiers]. Other properties of the provided identifiers are ignored.
	 *
	 *  These options are sortable. When sorting using these options the health elements will be in the same order as the input
	 *  identifiers. In case an entity has multiple identifiers only the first matching identifier is considered for the
	 *  sorting.
	 *
	 *  @param identifiers a list of identifiers
	 *  @return options for health element filtering
	 */
	byIdentifiersForSelf(identifiers: Array<Identifier>): SortableFilterOptions<HealthElement>;

	/**
	 *
	 *  Options for health element filtering which match all health elements shared directly (i.e. ignoring hierarchies) with a specific data owner that have a certain code.
	 *  If you specify only the [codeType] you will get all entities that have at least a code of that type.
	 *
	 *  These options are sortable. When sorting using these options the health elements will be sorted by [codeCode].
	 *
	 *  @param dataOwnerId a data owner id
	 *  @param codeType a code type
	 *  @param codeCode a code for the provided code type, or null if you want the filter to accept any entity
	 *  with a code of the provided type.
	 */
	byCodeForDataOwner(dataOwnerId: string, codeType: string,
			options?: { codeCode?: string | undefined }): BaseSortableFilterOptions<HealthElement>;

	/**
	 *
	 *  In group version of [byCodeForDataOwner].
	 */
	byCodeForDataOwnerInGroup(dataOwner: EntityReferenceInGroup, codeType: string,
			options?: { codeCode?: string | undefined }): BaseSortableFilterOptions<HealthElement>;

	/**
	 *
	 *  Options for health element filtering which match all health elements shared directly (i.e. ignoring hierarchies) with the current data owner that have a certain code.
	 *  If you specify only the [codeType] you will get all entities that have at least a code of that type.
	 *
	 *  These options are sortable. When sorting using these options the health elements will be sorted by [codeCode].
	 *
	 *  @param codeType a code type
	 *  @param codeCode a code for the provided code type, or null if you want the filter to accept any entity
	 *  with a code of the provided type.
	 */
	byCodeForSelf(codeType: string,
			options?: { codeCode?: string | undefined }): SortableFilterOptions<HealthElement>;

	/**
	 *
	 *  Options for health element filtering which match all health elements shared directly (i.e. ignoring hierarchies) with a specific data owner that have a certain tag.
	 *  If you specify only the [tagType] you will get all entities that have at least a tag of that type.
	 *
	 *  These options are sortable. When sorting using these options the health elements will be sorted by [tagCode].
	 *
	 *  @param dataOwnerId a data owner id
	 *  @param tagType a tag type
	 *  @param tagCode a code for the provided tag type, or null if you want the filter to accept any entity
	 *  with a tag of the provided type.
	 */
	byTagForDataOwner(dataOwnerId: string, tagType: string,
			options?: { tagCode?: string | undefined }): BaseSortableFilterOptions<HealthElement>;

	/**
	 *
	 *  In group version of [byTagForDataOwner].
	 */
	byTagForDataOwnerInGroup(dataOwner: EntityReferenceInGroup, tagType: string,
			options?: { tagCode?: string | undefined }): BaseSortableFilterOptions<HealthElement>;

	/**
	 *
	 *  Options for health element filtering which match all health elements shared directly (i.e. ignoring hierarchies) with the current data owner that have a certain tag.
	 *  If you specify only the [tagType] you will get all entities that have at least a tag of that type.
	 *
	 *  These options are sortable. When sorting using these options the health elements will be sorted by [tagCode].
	 *
	 *  @param tagType a tag type
	 *  @param tagCode a code for the provided tag type, or null if you want the filter to accept any entity
	 *  with a tag of the provided type.
	 */
	byTagForSelf(tagType: string,
			options?: { tagCode?: string | undefined }): SortableFilterOptions<HealthElement>;

	/**
	 *
	 *  Options for health element filtering which match all health elements shared directly (i.e. ignoring hierarchies) with a specific data owner that are linked with one
	 *  of the provided patients.
	 *
	 *  When using these options the sdk will automatically extract the secret ids from the provided patients and use
	 *  those for filtering.
	 *  If you already have the secret ids of the patient you may instead use [byPatientsSecretIdsForDataOwner].
	 *  If the current data owner does not have access to any secret id of one of the provide patients the patient will
	 *  simply be ignored.
	 *  Note that these may not be used in methods of apis from [CardinalBaseApis].
	 *
	 *  These options are sortable. When sorting using these options the health elements will be sorted by the patients, using
	 *  the same order as the input patients.
	 *
	 *  @param dataOwnerId a data owner id
	 *  @param patients a list of patients.
	 */
	byPatientsForDataOwner(dataOwnerId: string,
			patients: Array<Patient>): SortableFilterOptions<HealthElement>;

	/**
	 *
	 *  In group version of [byPatientsForDataOwner].
	 */
	byPatientsForDataOwnerInGroup(dataOwner: EntityReferenceInGroup,
			patients: Array<GroupScoped<Patient>>): SortableFilterOptions<HealthElement>;

	/**
	 *
	 *  Options for health element filtering which match all health elements shared directly (i.e. ignoring hierarchies) with the current data owner that are linked with one
	 *  of the provided patients.
	 *
	 *  When using these options the sdk will automatically extract the secret ids from the provided patients and use
	 *  those for filtering.
	 *  If you already have the secret ids of the patient you may instead use [byPatientsSecretIdsForSelf].
	 *  If the current data owner does not have access to any secret id of one of the provide patients the patient will
	 *  simply be ignored.
	 *  Note that these may not be used in methods of apis from [CardinalBaseApis].
	 *
	 *  These options are sortable. When sorting using these options the health elements will be sorted by the patients, using
	 *  the same order as the input patients.
	 *
	 *  @param patients a list of patients.
	 */
	byPatientsForSelf(patients: Array<Patient>): SortableFilterOptions<HealthElement>;

	/**
	 *
	 *  Options for health element filtering which match all health elements shared directly (i.e. ignoring hierarchies) with a specific data owner that are linked with a
	 *  patient through one of the provided secret ids.
	 *  These options are sortable. When sorting using these options the health elements will be sorted by the linked patients
	 *  secret id, using the same order as the input.
	 *
	 *  @param dataOwnerId a data owner id
	 *  @param secretIds a list of patients secret ids
	 */
	byPatientsSecretIdsForDataOwner(dataOwnerId: string,
			secretIds: Array<string>): BaseSortableFilterOptions<HealthElement>;

	/**
	 *
	 *  In group version of [byPatientsSecretIdsForDataOwner].
	 */
	byPatientsSecretIdsForDataOwnerInGroup(dataOwner: EntityReferenceInGroup,
			secretIds: Array<string>): BaseSortableFilterOptions<HealthElement>;

	/**
	 *
	 *  Options for health element filtering which match all health elements shared directly (i.e. ignoring hierarchies) with the current data owner that are linked with a
	 *  patient through one of the provided secret ids.
	 *  These options are sortable. When sorting using these options the health elements will be sorted by the linked patients
	 *  secret id, using the same order as the input.
	 *  @param secretIds a list of patients secret ids
	 */
	byPatientsSecretIdsForSelf(secretIds: Array<string>): SortableFilterOptions<HealthElement>;

	/**
	 *
	 *  Filter options that match all health elements with one of the provided ids.
	 *  These options are sortable. When sorting using these options the health elements will have the same order as the input ids.
	 *
	 *  @param ids a list of unique health element ids.
	 *  @throws IllegalArgumentException if the provided [ids] list contains duplicate elements
	 */
	byIds(ids: Array<string>): BaseSortableFilterOptions<HealthElement>;

	/**
	 *
	 *  Options for health element filtering which match all health elements shared directly (i.e. ignoring hierarchies) with a specific data owner
	 *  that are linked with one of the provided patients.
	 *  This Options also allows to restrict the health elements based on [HealthElement.openingDate]:
	 *  - if the [from] fuzzy date is not null, only the health elements where [HealthElement.openingDate] is greater than or equal to [from] will be returned.
	 *  - if the [to] fuzzy date is not null, only the health elements where [HealthElement.openingDate] is less than or equal to [to] will be returned.
	 *
	 *  When using these options the sdk will automatically extract the secret ids from the provided patients and use
	 *  those for filtering.
	 *  If you already have the secret ids of the patient you may instead use [byPatientSecretIdsOpeningDateForDataOwner].
	 *  If the current data owner does not have access to any secret id of one of the provide patients the patient will
	 *  simply be ignored.
	 *  Note that these may not be used in methods of apis from [CardinalBaseApis].
	 *
	 *  These options are sortable. When sorting using these options the health elements will be sorted by [HealthElement.openingDate] in ascending or
	 *  descending order according to the value of the [descending] parameter.
	 *
	 *  @param dataOwnerId a data owner id
	 *  @param patients a list of patients.
	 *  @param from the minimum fuzzy date for [HealthElement.openingDate], in the YYYYMMDDHHMMSS format (default: no limit).
	 *  @param to the maximum fuzzy date for [HealthElement.openingDate], in the YYYYMMDDHHMMSS format (default: no limit).
	 *  @param descending whether to sort the result in descending or ascending order by [HealthElement.openingDate] (default: ascending).
	 */
	byPatientsOpeningDateForDataOwner(dataOwnerId: string, patients: Array<Patient>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): SortableFilterOptions<HealthElement>;

	/**
	 *
	 *  In group version of [byPatientsOpeningDateForDataOwner].
	 */
	byPatientsOpeningDateForDataOwnerInGroup(dataOwner: EntityReferenceInGroup,
			patients: Array<GroupScoped<Patient>>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): SortableFilterOptions<HealthElement>;

	/**
	 *
	 *  Options for health element filtering which match all health elements shared directly (i.e. ignoring hierarchies) with the current data owner
	 *  that are linked with one of the provided patients.
	 *  This Options also allows to restrict the health elements based on [HealthElement.openingDate]:
	 *  - if the [from] fuzzy date is not null, only the health elements where [HealthElement.openingDate] is greater than or equal to [from] will be returned.
	 *  - if the [to] fuzzy date is not null, only the health elements where [HealthElement.openingDate] is less than or equal to [to] will be returned.
	 *
	 *  When using these options the sdk will automatically extract the secret ids from the provided patients and use
	 *  those for filtering.
	 *  If you already have the secret ids of the patient you may instead use [byPatientSecretIdsOpeningDateForSelf].
	 *  If the current data owner does not have access to any secret id of one of the provide patients the patient will
	 *  simply be ignored.
	 *  Note that these may not be used in methods of apis from [CardinalBaseApis].
	 *
	 *  These options are sortable. When sorting using these options the health elements will be sorted by [HealthElement.openingDate] in ascending or
	 *  descending order according to the value of the [descending] parameter.
	 *
	 *  @param patients a list of patients.
	 *  @param from the minimum fuzzy date for [HealthElement.openingDate], in the YYYYMMDDHHMMSS format (default: no limit).
	 *  @param to the maximum fuzzy date for [HealthElement.openingDate], in the YYYYMMDDHHMMSS format (default: no limit).
	 *  @param descending whether to sort the result in descending or ascending order by [HealthElement.openingDate] (default: ascending).
	 */
	byPatientsOpeningDateForSelf(patients: Array<Patient>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): SortableFilterOptions<HealthElement>;

	/**
	 *
	 *  Options for health element filtering which match all health elements shared directly (i.e. ignoring hierarchies) with a specific data owner
	 *  that are linked with one of the provided patients through one of the provided secret ids.
	 *  This Options also allows to restrict the health elements based on [HealthElement.openingDate]:
	 *  - if the [from] fuzzy date is not null, only the health elements where [HealthElement.openingDate] is greater than or equal to [from] will be returned.
	 *  - if the [to] fuzzy date is not null, only the health elements where [HealthElement.openingDate] is less than or equal to [to] will be returned.
	 *
	 *  If the current data owner does not have access to any secret id of one of the provide patients the patient will
	 *  simply be ignored.
	 *
	 *  These options are sortable. When sorting using these options the health elements will be sorted by [HealthElement.openingDate] in ascending or
	 *  descending order according to the value of the [descending] parameter.
	 *
	 *  @param dataOwnerId the id of a data owner.
	 *  @param secretIds a list of patient secret ids.
	 *  @param from the minimum fuzzy date for [HealthElement.openingDate], in the YYYYMMDDHHMMSS format (default: no limit).
	 *  @param to the maximum fuzzy date for [HealthElement.openingDate], in the YYYYMMDDHHMMSS format (default: no limit).
	 *  @param descending whether to sort the result in descending or ascending order by [HealthElement.openingDate] (default: ascending).
	 */
	byPatientSecretIdsOpeningDateForDataOwner(dataOwnerId: string, secretIds: Array<string>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): BaseSortableFilterOptions<HealthElement>;

	/**
	 *
	 *  In group version of [byPatientSecretIdsOpeningDateForDataOwner].
	 */
	byPatientSecretIdsOpeningDateForDataOwnerInGroup(dataOwner: EntityReferenceInGroup,
			secretIds: Array<string>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): BaseSortableFilterOptions<HealthElement>;

	/**
	 *
	 *  Options for health element filtering which match all health elements shared directly (i.e. ignoring hierarchies) with the current data owner
	 *  that are linked with one of the provided patients through one of the provided secret ids.
	 *  This Options also allows to restrict the health elements based on [HealthElement.openingDate]:
	 *  - if the [from] fuzzy date is not null, only the health elements where [HealthElement.openingDate] is greater than or equal to [from] will be returned.
	 *  - if the [to] fuzzy date is not null, only the health elements where [HealthElement.openingDate] is less than or equal to [to] will be returned.
	 *
	 *  If the current data owner does not have access to any secret id of one of the provide patients the patient will
	 *  simply be ignored.
	 *  Note that these may not be used in methods of apis from [CardinalBaseApis].
	 *
	 *  These options are sortable. When sorting using these options the health elements will be sorted by [HealthElement.openingDate] in ascending or
	 *  descending order according to the value of the [descending] parameter.
	 *
	 *  @param secretIds a list of patient secret ids.
	 *  @param from the minimum fuzzy date for [HealthElement.openingDate], in the YYYYMMDDHHMMSS format (default: no limit).
	 *  @param to the maximum fuzzy date for [HealthElement.openingDate], in the YYYYMMDDHHMMSS format (default: no limit).
	 *  @param descending whether to sort the result in descending or ascending order by [HealthElement.openingDate] (default: ascending).
	 */
	byPatientSecretIdsOpeningDateForSelf(secretIds: Array<string>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): SortableFilterOptions<HealthElement>;

}

export const HealthElementFilters: HealthElementFiltersFactory = {
			allHealthElementsForDataOwner: (dataOwnerId) => InternalHealthElementFiltersObj.getInstance().allHealthElementsForDataOwner(dataOwnerId),
			allHealthElementsForDataOwnerInGroup: (dataOwner) => InternalHealthElementFiltersObj.getInstance().allHealthElementsForDataOwnerInGroup(dataOwner),
			allHealthElementsForSelf: () => InternalHealthElementFiltersObj.getInstance().allHealthElementsForSelf(),
			byIdentifiersForDataOwner: (dataOwnerId, identifiers) => InternalHealthElementFiltersObj.getInstance().byIdentifiersForDataOwner(dataOwnerId, identifiers),
			byIdentifiersForDataOwnerInGroup: (dataOwner, identifiers) => InternalHealthElementFiltersObj.getInstance().byIdentifiersForDataOwnerInGroup(dataOwner, identifiers),
			byIdentifiersForSelf: (identifiers) => InternalHealthElementFiltersObj.getInstance().byIdentifiersForSelf(identifiers),
			byCodeForDataOwner: (dataOwnerId, codeType, options) => InternalHealthElementFiltersObj.getInstance().byCodeForDataOwner(dataOwnerId, codeType, options),
			byCodeForDataOwnerInGroup: (dataOwner, codeType, options) => InternalHealthElementFiltersObj.getInstance().byCodeForDataOwnerInGroup(dataOwner, codeType, options),
			byCodeForSelf: (codeType, options) => InternalHealthElementFiltersObj.getInstance().byCodeForSelf(codeType, options),
			byTagForDataOwner: (dataOwnerId, tagType, options) => InternalHealthElementFiltersObj.getInstance().byTagForDataOwner(dataOwnerId, tagType, options),
			byTagForDataOwnerInGroup: (dataOwner, tagType, options) => InternalHealthElementFiltersObj.getInstance().byTagForDataOwnerInGroup(dataOwner, tagType, options),
			byTagForSelf: (tagType, options) => InternalHealthElementFiltersObj.getInstance().byTagForSelf(tagType, options),
			byPatientsForDataOwner: (dataOwnerId, patients) => InternalHealthElementFiltersObj.getInstance().byPatientsForDataOwner(dataOwnerId, patients),
			byPatientsForDataOwnerInGroup: (dataOwner, patients) => InternalHealthElementFiltersObj.getInstance().byPatientsForDataOwnerInGroup(dataOwner, patients),
			byPatientsForSelf: (patients) => InternalHealthElementFiltersObj.getInstance().byPatientsForSelf(patients),
			byPatientsSecretIdsForDataOwner: (dataOwnerId, secretIds) => InternalHealthElementFiltersObj.getInstance().byPatientsSecretIdsForDataOwner(dataOwnerId, secretIds),
			byPatientsSecretIdsForDataOwnerInGroup: (dataOwner, secretIds) => InternalHealthElementFiltersObj.getInstance().byPatientsSecretIdsForDataOwnerInGroup(dataOwner, secretIds),
			byPatientsSecretIdsForSelf: (secretIds) => InternalHealthElementFiltersObj.getInstance().byPatientsSecretIdsForSelf(secretIds),
			byIds: (ids) => InternalHealthElementFiltersObj.getInstance().byIds(ids),
			byPatientsOpeningDateForDataOwner: (dataOwnerId, patients, options) => InternalHealthElementFiltersObj.getInstance().byPatientsOpeningDateForDataOwner(dataOwnerId, patients, options),
			byPatientsOpeningDateForDataOwnerInGroup: (dataOwner, patients, options) => InternalHealthElementFiltersObj.getInstance().byPatientsOpeningDateForDataOwnerInGroup(dataOwner, patients, options),
			byPatientsOpeningDateForSelf: (patients, options) => InternalHealthElementFiltersObj.getInstance().byPatientsOpeningDateForSelf(patients, options),
			byPatientSecretIdsOpeningDateForDataOwner: (dataOwnerId, secretIds, options) => InternalHealthElementFiltersObj.getInstance().byPatientSecretIdsOpeningDateForDataOwner(dataOwnerId, secretIds, options),
			byPatientSecretIdsOpeningDateForDataOwnerInGroup: (dataOwner, secretIds, options) => InternalHealthElementFiltersObj.getInstance().byPatientSecretIdsOpeningDateForDataOwnerInGroup(dataOwner, secretIds, options),
			byPatientSecretIdsOpeningDateForSelf: (secretIds, options) => InternalHealthElementFiltersObj.getInstance().byPatientSecretIdsOpeningDateForSelf(secretIds, options)
		};
