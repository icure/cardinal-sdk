// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, FilterOptions, InternalHealthElementFiltersObj, SortableFilterOptions} from '../cardinal-sdk-ts.mjs';
import {EntityReferenceInGroup} from '../model/EntityReferenceInGroup.mjs';
import {GroupScoped} from '../model/GroupScoped.mjs';
import {HealthElement} from '../model/HealthElement.mjs';
import {Patient} from '../model/Patient.mjs';
import {Identifier} from '../model/base/Identifier.mjs';


interface HealthElementFiltersFactory {

	allHealthElementsForDataOwner(dataOwnerId: string): BaseFilterOptions<HealthElement>;

	allHealthElementsForDataOwnerInGroup(dataOwner: EntityReferenceInGroup): BaseFilterOptions<HealthElement>;

	allHealthElementsForSelf(): FilterOptions<HealthElement>;

	byIdentifiersForDataOwner(dataOwnerId: string,
			identifiers: Array<Identifier>): BaseSortableFilterOptions<HealthElement>;

	byIdentifiersForDataOwnerInGroup(dataOwner: EntityReferenceInGroup,
			identifiers: Array<Identifier>): BaseSortableFilterOptions<HealthElement>;

	byIdentifiersForSelf(identifiers: Array<Identifier>): SortableFilterOptions<HealthElement>;

	byCodeForDataOwner(dataOwnerId: string, codeType: string,
			options?: { codeCode?: string | undefined }): BaseSortableFilterOptions<HealthElement>;

	byCodeForDataOwnerInGroup(dataOwner: EntityReferenceInGroup, codeType: string,
			options?: { codeCode?: string | undefined }): BaseSortableFilterOptions<HealthElement>;

	byCodeForSelf(codeType: string,
			options?: { codeCode?: string | undefined }): SortableFilterOptions<HealthElement>;

	byTagForDataOwner(dataOwnerId: string, tagType: string,
			options?: { tagCode?: string | undefined }): BaseSortableFilterOptions<HealthElement>;

	byTagForDataOwnerInGroup(dataOwner: EntityReferenceInGroup, tagType: string,
			options?: { tagCode?: string | undefined }): BaseSortableFilterOptions<HealthElement>;

	byTagForSelf(tagType: string,
			options?: { tagCode?: string | undefined }): SortableFilterOptions<HealthElement>;

	byPatientsForDataOwner(dataOwnerId: string,
			patients: Array<Patient>): SortableFilterOptions<HealthElement>;

	byPatientsForDataOwnerInGroup(dataOwner: EntityReferenceInGroup,
			patients: Array<GroupScoped<Patient>>): SortableFilterOptions<HealthElement>;

	byPatientsForSelf(patients: Array<Patient>): SortableFilterOptions<HealthElement>;

	byPatientsSecretIdsForDataOwner(dataOwnerId: string,
			secretIds: Array<string>): BaseSortableFilterOptions<HealthElement>;

	byPatientsSecretIdsForDataOwnerInGroup(dataOwner: EntityReferenceInGroup,
			secretIds: Array<string>): BaseSortableFilterOptions<HealthElement>;

	byPatientsSecretIdsForSelf(secretIds: Array<string>): SortableFilterOptions<HealthElement>;

	byIds(ids: Array<string>): BaseSortableFilterOptions<HealthElement>;

	byPatientsOpeningDateForDataOwner(dataOwnerId: string, patients: Array<Patient>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): SortableFilterOptions<HealthElement>;

	byPatientsOpeningDateForDataOwnerInGroup(dataOwner: EntityReferenceInGroup,
			patients: Array<GroupScoped<Patient>>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): SortableFilterOptions<HealthElement>;

	byPatientsOpeningDateForSelf(patients: Array<Patient>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): SortableFilterOptions<HealthElement>;

	byPatientSecretIdsOpeningDateForDataOwner(dataOwnerId: string, secretIds: Array<string>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): BaseSortableFilterOptions<HealthElement>;

	byPatientSecretIdsOpeningDateForDataOwnerInGroup(dataOwner: EntityReferenceInGroup,
			secretIds: Array<string>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): BaseSortableFilterOptions<HealthElement>;

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
