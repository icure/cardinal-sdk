// auto-generated file
import {BaseSortableFilterOptions, InternalAccessLogFiltersObj, SortableFilterOptions} from '../cardinal-sdk-ts.mjs';
import {AccessLog} from '../model/AccessLog.mjs';
import {EntityReferenceInGroup} from '../model/EntityReferenceInGroup.mjs';
import {GroupScoped} from '../model/GroupScoped.mjs';
import {Patient} from '../model/Patient.mjs';


interface AccessLogFiltersFactory {

	byPatientsDateForDataOwner(dataOwnerId: string, patients: Array<Patient>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): SortableFilterOptions<AccessLog>;

	byPatientsDateForDataOwnerInGroup(dataOwner: EntityReferenceInGroup,
			patients: Array<GroupScoped<Patient>>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): SortableFilterOptions<AccessLog>;

	byPatientsDateForSelf(patients: Array<Patient>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): SortableFilterOptions<AccessLog>;

	byPatientSecretIdsDateForDataOwner(dataOwnerId: string, secretIds: Array<string>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): BaseSortableFilterOptions<AccessLog>;

	byPatientSecretIdsDateForSelf(secretIds: Array<string>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): SortableFilterOptions<AccessLog>;

	byDate(options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): BaseSortableFilterOptions<AccessLog>;

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
