// auto-generated file
import {BaseSortableFilterOptions, InternalAccessLogFiltersObj, SortableFilterOptions} from '../cardinal-sdk-ts.mjs';
import {AccessLog} from '../model/AccessLog.mjs';
import {EntityReferenceInGroup} from '../model/EntityReferenceInGroup.mjs';
import {GroupScoped} from '../model/GroupScoped.mjs';
import {Patient} from '../model/Patient.mjs';


interface AccessLogFiltersFactory {

	/**
	 *
	 *  Options for access log filtering which match all access logs shared directly (i.e. ignoring hierarchies) with a specific data owner
	 *  that are linked with one of the provided patients.
	 *  This Options also allows to restrict the access logs based on [AccessLog.date]:
	 *  - if [from] is not null, only the access logs where [AccessLog.date] is greater than or equal to [from] will be returned.
	 *  - if [to] is not null, only the access logs where [AccessLog.date] is less than or equal to [to] will be returned.
	 *
	 *  When using these options the sdk will automatically extract the secret ids from the provided patients and use
	 *  those for filtering.
	 *  If you already have the secret ids of the patient you may instead use [byPatientSecretIdsDateForDataOwner].
	 *  If the current data owner does not have access to any secret id of one of the provide patients the patient will
	 *  simply be ignored.
	 *  Note that these may not be used in methods of apis from [CardinalBaseApis].
	 *
	 *  These options are sortable. When sorting using these options the access logs will be sorted by [AccessLog.date] in ascending or
	 *  descending order according to the value of the [descending] parameter.
	 *
	 *  @param dataOwnerId a data owner id
	 *  @param patients a list of patients.
	 *  @param from the minimum value for [AccessLog.date] (default: no limit).
	 *  @param to the maximum value for [AccessLog.date] (default: no limit).
	 *  @param descending whether to sort the result in descending or ascending order by [AccessLog.date] (default: ascending).
	 */
	byPatientsDateForDataOwner(dataOwnerId: string, patients: Array<Patient>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): SortableFilterOptions<AccessLog>;

	/**
	 *
	 *  In group version of [byPatientsDateForDataOwner].
	 */
	byPatientsDateForDataOwnerInGroup(dataOwner: EntityReferenceInGroup,
			patients: Array<GroupScoped<Patient>>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): SortableFilterOptions<AccessLog>;

	/**
	 *
	 *  Options for access log filtering which match all access logs shared directly (i.e. ignoring hierarchies) with the current data owner
	 *  that are linked with one of the provided patients.
	 *  This Options also allows to restrict the access logs based on [AccessLog.date]:
	 *  - if [from] is not null, only the access logs where [AccessLog.date] is greater than or equal to [from] will be returned.
	 *  - if [to] is not null, only the access logs where [AccessLog.date] is less than or equal to [to] will be returned.
	 *
	 *  When using these options the sdk will automatically extract the secret ids from the provided patients and use
	 *  those for filtering.
	 *  If you already have the secret ids of the patient you may instead use [byPatientSecretIdsDateForSelf].
	 *  If the current data owner does not have access to any secret id of one of the provide patients the patient will
	 *  simply be ignored.
	 *  Note that these may not be used in methods of apis from [CardinalBaseApis].
	 *
	 *  These options are sortable. When sorting using these options the access logs will be sorted by [AccessLog.date] in ascending or
	 *  descending order according to the value of the [descending] parameter.
	 *
	 *  @param patients a list of patients.
	 *  @param from the minimum value for [AccessLog.date] (default: no limit).
	 *  @param to the maximum value for [AccessLog.date] (default: no limit).
	 *  @param descending whether to sort the result in descending or ascending order by [AccessLog.date] (default: ascending).
	 */
	byPatientsDateForSelf(patients: Array<Patient>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): SortableFilterOptions<AccessLog>;

	/**
	 *
	 *  Options for access log filtering which match all access logs shared directly (i.e. ignoring hierarchies) with a specific data owner
	 *  that are linked with a patient through one of the provided secret ids.
	 *  This Options also allows to restrict the access logs based on [AccessLog.date]:
	 *  - if [from] is not null, only the access logs where [AccessLog.date] is greater than or equal to [from] will be returned.
	 *  - if [to] is not null, only the access logs where [AccessLog.date] is less than or equal to [to] will be returned.
	 *
	 *  If the current data owner does not have access to any secret id of one of the provide patients the patient will
	 *  simply be ignored.
	 *
	 *  These options are sortable. When sorting using these options the access logs will be sorted by [AccessLog.date] in ascending or
	 *  descending order according to the value of the [descending] parameter.
	 *
	 *  @param dataOwnerId a data owner id
	 *  @param secretIds a list of patient secret ids.
	 *  @param from the minimum value for [AccessLog.date] (default: no limit).
	 *  @param to the maximum value for [AccessLog.date] (default: no limit).
	 *  @param descending whether to sort the result in descending or ascending order by [AccessLog.date] (default: ascending).
	 */
	byPatientSecretIdsDateForDataOwner(dataOwnerId: string, secretIds: Array<string>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): BaseSortableFilterOptions<AccessLog>;

	/**
	 *
	 *  Options for access log filtering which match all access logs shared directly (i.e. ignoring hierarchies) with the current data owner
	 *  that are linked with a patient through one of the provided secret ids.
	 *  This Options also allows to restrict the access logs based on [AccessLog.date]:
	 *  - if [from] is not null, only the access logs where [AccessLog.date] is greater than or equal to [from] will be returned.
	 *  - if [to] is not null, only the access logs where [AccessLog.date] is less than or equal to [to] will be returned.
	 *
	 *  If the current data owner does not have access to any secret id of one of the provide patients the patient will
	 *  simply be ignored.
	 *  Note that these may not be used in methods of apis from [CardinalBaseApis].
	 *
	 *  These options are sortable. When sorting using these options the access logs will be sorted by [AccessLog.date] in ascending or
	 *  descending order according to the value of the [descending] parameter.
	 *
	 *  @param secretIds a list of patient secret ids.
	 *  @param from the minimum value for [AccessLog.date] (default: no limit).
	 *  @param to the maximum value for [AccessLog.date] (default: no limit).
	 *  @param descending whether to sort the result in descending or ascending order by [AccessLog.date] (default: ascending).
	 */
	byPatientSecretIdsDateForSelf(secretIds: Array<string>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): SortableFilterOptions<AccessLog>;

	/**
	 *
	 *  Options for access log filtering based on [AccessLog.date]:
	 *  - if [from] is not null, only the access logs where [AccessLog.date] is greater than or equal to [from] will be returned.
	 *  - if [to] is not null, only the access logs where [AccessLog.date] is less than or equal to [to] will be returned.
	 *
	 *  These options are sortable. When sorting using these options the access logs will be sorted by [AccessLog.date] in ascending or
	 *  descending order according to the value of the [descending] parameter.
	 *
	 *  @param from the minimum value for [AccessLog.date] (default: no limit).
	 *  @param to the maximum value for [AccessLog.date] (default: no limit).
	 *  @param descending whether to sort the result in descending or ascending order by [AccessLog.date] (default: ascending).
	 */
	byDate(options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): BaseSortableFilterOptions<AccessLog>;

	/**
	 *
	 *  Options for access log filtering where [AccessLog.user] is equal to [userId], [AccessLog.accessType] is equal to [accessType] (if
	 *  provided), and [AccessLog.date] is greater than or equal to [from] (if provided).
	 *  If [from] is not null, then also [accessType] must not be null.
	 *
	 *  These options are sortable. When sorting using these options the access logs will be sorted by [AccessLog.accessType] and then by
	 *  [AccessLog.date] in ascending or
	 *  descending order according to the value of the [descending] parameter.
	 *
	 *  @param userId the id of the user associated to the access log.
	 *  @param accessType the [AccessLog.accessType] (default: any type).
	 *  @param from the minimum value for [AccessLog.date] (default: no limit).
	 *  @param descending whether to sort the result in descending or ascending order by [AccessLog.accessType] and [AccessLog.date  ] (default: ascending).
	 *  @throws IllegalArgumentException if [from] is not null and [accessType] is null.
	 */
	byUserTypeDate(userId: string,
			options?: { accessType?: string | undefined, from?: number | undefined, descending?: boolean }): BaseSortableFilterOptions<AccessLog>;

}

export const AccessLogFilters: AccessLogFiltersFactory = {
			byPatientsDateForDataOwner: (dataOwnerId, patients, options) => InternalAccessLogFiltersObj.getInstance().byPatientsDateForDataOwner(dataOwnerId, patients, options),
			byPatientsDateForDataOwnerInGroup: (dataOwner, patients, options) => InternalAccessLogFiltersObj.getInstance().byPatientsDateForDataOwnerInGroup(dataOwner, patients, options),
			byPatientsDateForSelf: (patients, options) => InternalAccessLogFiltersObj.getInstance().byPatientsDateForSelf(patients, options),
			byPatientSecretIdsDateForDataOwner: (dataOwnerId, secretIds, options) => InternalAccessLogFiltersObj.getInstance().byPatientSecretIdsDateForDataOwner(dataOwnerId, secretIds, options),
			byPatientSecretIdsDateForSelf: (secretIds, options) => InternalAccessLogFiltersObj.getInstance().byPatientSecretIdsDateForSelf(secretIds, options),
			byDate: (options) => InternalAccessLogFiltersObj.getInstance().byDate(options),
			byUserTypeDate: (userId, options) => InternalAccessLogFiltersObj.getInstance().byUserTypeDate(userId, options)
		};
