// auto-generated file
import {BaseSortableFilterOptions, InternalClassificationFiltersObj, SortableFilterOptions} from '../cardinal-sdk-ts.mjs';
import {Classification} from '../model/Classification.mjs';
import {Patient} from '../model/Patient.mjs';


interface ClassificationFiltersFactory {

	/**
	 *
	 *  Options for classification filtering which match all classifications shared directly (i.e. ignoring hierarchies) with a specific data owner
	 *  that are linked with one of the provided patients.
	 *  This Options also allows to restrict the classifications based on [Classification.created]:
	 *  - if the [from] timestamp is not null, only the classifications where [Classification.created] is greater than or equal to [from] will be returned.
	 *  - if the [to] timestamp is not null, only the classifications where [Classification.created] is less than or equal to [to] will be returned.
	 *
	 *  When using these options the sdk will automatically extract the secret ids from the provided patients and use
	 *  those for filtering.
	 *  If you already have the secret ids of the patient you may instead use [byPatientSecretIdsCreatedForDataOwner].
	 *  If the current data owner does not have access to any secret id of one of the provide patients the patient will
	 *  simply be ignored.
	 *  Note that these may not be used in methods of apis from [CardinalBaseApis].
	 *
	 *  These options are sortable. When sorting using these options the classifications will be sorted by [Classification.created] in ascending or
	 *  descending order according to the value of the [descending] parameter.
	 *
	 *  @param dataOwnerId a data owner id
	 *  @param patients a list of patients.
	 *  @param from the minimum timestamp for [Classification.created] (default: no limit).
	 *  @param to the maximum timestamp for [Classification.created] (default: no limit).
	 *  @param descending whether to sort the result in descending or ascending order by [Classification.created] (default: ascending).
	 */
	byPatientsCreatedForDataOwner(dataOwnerId: string, patients: Array<Patient>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): SortableFilterOptions<Classification>;

	/**
	 *
	 *  Options for classification filtering which match all classifications shared directly (i.e. ignoring hierarchies) with the current data owner
	 *  that are linked with one of the provided patients.
	 *  This Options also allows to restrict the classifications based on [Classification.created]:
	 *  - if the [from] timestamp is not null, only the classifications where [Classification.created] is greater than or equal to [from] will be returned.
	 *  - if the [to] timestamp is not null, only the classifications where [Classification.created] is less than or equal to [to] will be returned.
	 *
	 *  When using these options the sdk will automatically extract the secret ids from the provided patients and use
	 *  those for filtering.
	 *  If you already have the secret ids of the patient you may instead use [byPatientSecretIdsCreatedForSelf].
	 *  If the current data owner does not have access to any secret id of one of the provide patients the patient will
	 *  simply be ignored.
	 *  Note that these may not be used in methods of apis from [CardinalBaseApis].
	 *
	 *  These options are sortable. When sorting using these options the classifications will be sorted by [Classification.created] in ascending or
	 *  descending order according to the value of the [descending] parameter.
	 *
	 *  @param patients a list of patients.
	 *  @param from the minimum timestamp for [Classification.created] (default: no limit).
	 *  @param to the maximum timestamp for [Classification.created] (default: no limit).
	 *  @param descending whether to sort the result in descending or ascending order by [Classification.created] (default: ascending).
	 */
	byPatientsCreatedForSelf(patients: Array<Patient>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): SortableFilterOptions<Classification>;

	/**
	 *
	 *  Options for classification filtering which match all classifications shared directly (i.e. ignoring hierarchies) with a specific data owner
	 *  that are linked with one of the provided patients through one of the provided secret ids.
	 *  This Options also allows to restrict the classifications based on [Classification.created]:
	 *  - if the [from] timestamp is not null, only the classifications where [Classification.created] is greater than or equal to [from] will be returned.
	 *  - if the [to] timestamp is not null, only the classifications where [Classification.created] is less than or equal to [to] will be returned.
	 *
	 *  If the current data owner does not have access to any secret id of one of the provide patients the patient will
	 *  simply be ignored.
	 *
	 *  These options are sortable. When sorting using these options the classifications will be sorted by [Classification.created] in ascending or
	 *  descending order according to the value of the [descending] parameter.
	 *
	 *  @param dataOwnerId a data owner id.
	 *  @param secretIds a list of secret ids from one or more patients.
	 *  @param from the minimum timestamp for [Classification.created] (default: no limit).
	 *  @param to the maximum timestamp for [Classification.created] (default: no limit).
	 *  @param descending whether to sort the result in descending or ascending order by [Classification.created] (default: ascending).
	 */
	byPatientSecretIdsCreatedForDataOwner(dataOwnerId: string, secretIds: Array<string>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): BaseSortableFilterOptions<Classification>;

	/**
	 *
	 *  Options for classification filtering which match all classifications shared directly (i.e. ignoring hierarchies) with the current data owner
	 *  that are linked with one of the provided patients through one of the provided secret ids.
	 *  This Options also allows to restrict the classifications based on [Classification.created]:
	 *  - if the [from] timestamp is not null, only the classifications where [Classification.created] is greater than or equal to [from] will be returned.
	 *  - if the [to] timestamp is not null, only the classifications where [Classification.created] is less than or equal to [to] will be returned.
	 *
	 *  If the current data owner does not have access to any secret id of one of the provide patients the patient will
	 *  simply be ignored.
	 *  Note that these may not be used in methods of apis from [CardinalBaseApis].
	 *
	 *  These options are sortable. When sorting using these options the classifications will be sorted by [Classification.created] in ascending or
	 *  descending order according to the value of the [descending] parameter.
	 *
	 *  @param secretIds a list of secret ids from one or more patients.
	 *  @param from the minimum timestamp for [Classification.created] (default: no limit).
	 *  @param to the maximum timestamp for [Classification.created] (default: no limit).
	 *  @param descending whether to sort the result in descending or ascending order by [Classification.created] (default: ascending).
	 */
	byPatientSecretIdsCreatedForSelf(secretIds: Array<string>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): SortableFilterOptions<Classification>;

}

export const ClassificationFilters: ClassificationFiltersFactory = {
			byPatientsCreatedForDataOwner: (dataOwnerId, patients, options) => InternalClassificationFiltersObj.getInstance().byPatientsCreatedForDataOwner(dataOwnerId, patients, options),
			byPatientsCreatedForSelf: (patients, options) => InternalClassificationFiltersObj.getInstance().byPatientsCreatedForSelf(patients, options),
			byPatientSecretIdsCreatedForDataOwner: (dataOwnerId, secretIds, options) => InternalClassificationFiltersObj.getInstance().byPatientSecretIdsCreatedForDataOwner(dataOwnerId, secretIds, options),
			byPatientSecretIdsCreatedForSelf: (secretIds, options) => InternalClassificationFiltersObj.getInstance().byPatientSecretIdsCreatedForSelf(secretIds, options)
		};
