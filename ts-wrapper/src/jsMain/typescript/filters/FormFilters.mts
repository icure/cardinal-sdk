// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, FilterOptions, InternalFormFiltersObj, SortableFilterOptions} from '../cardinal-sdk-ts.mjs';
import {EntityReferenceInGroup} from '../model/EntityReferenceInGroup.mjs';
import {Form} from '../model/Form.mjs';
import {GroupScoped} from '../model/GroupScoped.mjs';
import {Patient} from '../model/Patient.mjs';


interface FormFiltersFactory {

	/**
	 *
	 *  Options for form filter which match all the forms shared directly (i.e. ignoring hierarchies) with a specific data owner and where
	 *  [Form.parent] is equal to [parentId].
	 *
	 *  @param dataOwnerId the id of a data owner.
	 *  @param parentId the form parent id.
	 */
	byParentIdForDataOwner(dataOwnerId: string, parentId: string): BaseFilterOptions<Form>;

	/**
	 *
	 *  In group version of [byParentIdForDataOwner].
	 */
	byParentIdForDataOwnerInGroup(dataOwner: EntityReferenceInGroup,
			parentId: string): BaseFilterOptions<Form>;

	/**
	 *
	 *  Options for form filter which match all the forms shared directly (i.e. ignoring hierarchies) with the current data owner and where
	 *  [Form.parent] is equal to [parentId].
	 *
	 *  @param parentId the form parent id.
	 */
	byParentIdForSelf(parentId: string): FilterOptions<Form>;

	/**
	 *
	 *  Options for form filtering which match all forms shared directly (i.e. ignoring hierarchies) with a specific data owner
	 *  that are linked with one of the provided patients.
	 *  This Options also allows to restrict the forms based on [Form.openingDate]:
	 *  - if the [from] fuzzy date is not null, only the forms where [Form.openingDate] is greater than or equal to [from] will be returned.
	 *  - if the [to] fuzzy date is not null, only the forms where [Form.openingDate] is less than or equal to [to] will be returned.
	 *
	 *  When using these options the sdk will automatically extract the secret ids from the provided patients and use
	 *  those for filtering.
	 *  If you already have the secret ids of the patient you may instead use [byPatientSecretIdsOpeningDateForDataOwner].
	 *  If the current data owner does not have access to any secret id of one of the provide patients the patient will
	 *  simply be ignored.
	 *  Note that these may not be used in methods of apis from [CardinalBaseApis].
	 *
	 *  These options are sortable. When sorting using these options the forms will be sorted by [Form.openingDate] in ascending or
	 *  descending order according to the value of the [descending] parameter.
	 *
	 *  @param dataOwnerId a data owner id
	 *  @param patients a list of patients.
	 *  @param from the minimum fuzzy date for [Form.openingDate], in the YYYYMMDDHHMMSS format (default: no limit).
	 *  @param to the maximum fuzzy date for [Form.openingDate], in the YYYYMMDDHHMMSS format (default: no limit).
	 *  @param descending whether to sort the result in descending or ascending order by [Form.openingDate] (default: ascending).
	 */
	byPatientsOpeningDateForDataOwner(dataOwnerId: string, patients: Array<Patient>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): SortableFilterOptions<Form>;

	byPatientsOpeningDateForDataOwnerInGroup(dataOwner: EntityReferenceInGroup,
			patients: Array<GroupScoped<Patient>>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): SortableFilterOptions<Form>;

	/**
	 *
	 *  Options for form filtering which match all forms shared directly (i.e. ignoring hierarchies) with the current data owner
	 *  that are linked with one of the provided patients.
	 *  This Options also allows to restrict the forms based on [Form.openingDate]:
	 *  - if the [from] fuzzy date is not null, only the forms where [Form.openingDate] is greater than or equal to [from] will be returned.
	 *  - if the [to] fuzzy date is not null, only the forms where [Form.openingDate] is less than or equal to [to] will be returned.
	 *
	 *  When using these options the sdk will automatically extract the secret ids from the provided patients and use
	 *  those for filtering.
	 *  If you already have the secret ids of the patient you may instead use [byPatientSecretIdsOpeningDateForSelf].
	 *  If the current data owner does not have access to any secret id of one of the provide patients the patient will
	 *  simply be ignored.
	 *  Note that these may not be used in methods of apis from [CardinalBaseApis].
	 *
	 *  These options are sortable. When sorting using these options the forms will be sorted by [Form.openingDate] in ascending or
	 *  descending order according to the value of the [descending] parameter.
	 *
	 *  @param patients a list of patients.
	 *  @param from the minimum fuzzy date for [Form.openingDate], in the YYYYMMDDHHMMSS format (default: no limit).
	 *  @param to the maximum fuzzy date for [Form.openingDate], in the YYYYMMDDHHMMSS format (default: no limit).
	 *  @param descending whether to sort the result in descending or ascending order by [Form.openingDate] (default: ascending).
	 */
	byPatientsOpeningDateForSelf(patients: Array<Patient>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): SortableFilterOptions<Form>;

	/**
	 *
	 *  Options for form filtering which match all forms shared directly (i.e. ignoring hierarchies) with the current data owner
	 *  that are linked with one of the provided patients through one of the provided secret ids.
	 *  This Options also allows to restrict the forms based on [Form.openingDate]:
	 *  - if the [from] fuzzy date is not null, only the forms where [Form.openingDate] is greater than or equal to [from] will be returned.
	 *  - if the [to] fuzzy date is not null, only the forms where [Form.openingDate] is less than or equal to [to] will be returned.
	 *
	 *  If the current data owner does not have access to any secret id of one of the provide patients the patient will
	 *  simply be ignored.
	 *
	 *  These options are sortable. When sorting using these options the forms will be sorted by [Form.openingDate] in ascending or
	 *  descending order according to the value of the [descending] parameter.
	 *
	 *  @param dataOwnerId a data owner id.
	 *  @param secretIds a list of patient secret ids.
	 *  @param from the minimum fuzzy date for [Form.openingDate], in the YYYYMMDDHHMMSS format (default: no limit).
	 *  @param to the maximum fuzzy date for [Form.openingDate], in the YYYYMMDDHHMMSS format (default: no limit).
	 *  @param descending whether to sort the result in descending or ascending order by [Form.openingDate] (default: ascending).
	 */
	byPatientSecretIdsOpeningDateForDataOwner(dataOwnerId: string, secretIds: Array<string>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): BaseSortableFilterOptions<Form>;

	/**
	 *
	 *  In group version of [byPatientSecretIdsOpeningDateForDataOwner].
	 */
	byPatientSecretIdsOpeningDateForDataOwnerInGroup(dataOwner: EntityReferenceInGroup,
			secretIds: Array<string>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): BaseSortableFilterOptions<Form>;

	/**
	 *
	 *  Options for form filtering which match all forms shared directly (i.e. ignoring hierarchies) with the current data owner
	 *  that are linked with one of the provided patients through one of the provided secret ids.
	 *  This Options also allows to restrict the forms based on [Form.openingDate]:
	 *  - if the [from] fuzzy date is not null, only the forms where [Form.openingDate] is greater than or equal to [from] will be returned.
	 *  - if the [to] fuzzy date is not null, only the forms where [Form.openingDate] is less than or equal to [to] will be returned.
	 *
	 *  If the current data owner does not have access to any secret id of one of the provide patients the patient will
	 *  simply be ignored.
	 *  Note that these may not be used in methods of apis from [CardinalBaseApis].
	 *
	 *  These options are sortable. When sorting using these options the forms will be sorted by [Form.openingDate] in ascending or
	 *  descending order according to the value of the [descending] parameter.
	 *
	 *  @param secretIds a list of patient secret ids.
	 *  @param from the minimum fuzzy date for [Form.openingDate], in the YYYYMMDDHHMMSS format (default: no limit).
	 *  @param to the maximum fuzzy date for [Form.openingDate], in the YYYYMMDDHHMMSS format (default: no limit).
	 *  @param descending whether to sort the result in descending or ascending order by [Form.openingDate] (default: ascending).
	 */
	byPatientSecretIdsOpeningDateForSelf(secretIds: Array<string>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): SortableFilterOptions<Form>;

	/**
	 *
	 *  Options for form filtering which mach all the forms where [Form.uniqueId] is equal to [uniqueId].
	 *
	 *  These options are sortable. When sorting using these options, the forms will be sorted by [Form.created] in ascending or descending
	 *  order according to the value of the [descending] parameter.
	 *
	 *  @param uniqueId the [Form.uniqueId] to use for filtering.
	 *  @param descending whether to sort the results in descending or ascending order by [Form.created] (default: ascending).
	 */
	byUniqueId(uniqueId: string, options?: { descending?: boolean }): BaseSortableFilterOptions<Form>;

}

export const FormFilters: FormFiltersFactory = {
			byParentIdForDataOwner: (dataOwnerId, parentId) => InternalFormFiltersObj.getInstance().byParentIdForDataOwner(dataOwnerId, parentId),
			byParentIdForDataOwnerInGroup: (dataOwner, parentId) => InternalFormFiltersObj.getInstance().byParentIdForDataOwnerInGroup(dataOwner, parentId),
			byParentIdForSelf: (parentId) => InternalFormFiltersObj.getInstance().byParentIdForSelf(parentId),
			byPatientsOpeningDateForDataOwner: (dataOwnerId, patients, options) => InternalFormFiltersObj.getInstance().byPatientsOpeningDateForDataOwner(dataOwnerId, patients, options),
			byPatientsOpeningDateForDataOwnerInGroup: (dataOwner, patients, options) => InternalFormFiltersObj.getInstance().byPatientsOpeningDateForDataOwnerInGroup(dataOwner, patients, options),
			byPatientsOpeningDateForSelf: (patients, options) => InternalFormFiltersObj.getInstance().byPatientsOpeningDateForSelf(patients, options),
			byPatientSecretIdsOpeningDateForDataOwner: (dataOwnerId, secretIds, options) => InternalFormFiltersObj.getInstance().byPatientSecretIdsOpeningDateForDataOwner(dataOwnerId, secretIds, options),
			byPatientSecretIdsOpeningDateForDataOwnerInGroup: (dataOwner, secretIds, options) => InternalFormFiltersObj.getInstance().byPatientSecretIdsOpeningDateForDataOwnerInGroup(dataOwner, secretIds, options),
			byPatientSecretIdsOpeningDateForSelf: (secretIds, options) => InternalFormFiltersObj.getInstance().byPatientSecretIdsOpeningDateForSelf(secretIds, options),
			byUniqueId: (uniqueId, options) => InternalFormFiltersObj.getInstance().byUniqueId(uniqueId, options)
		};
