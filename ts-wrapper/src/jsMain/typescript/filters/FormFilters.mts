// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, FilterOptions, InternalFormFiltersObj, SortableFilterOptions} from '../cardinal-sdk-ts.mjs';
import {EntityReferenceInGroup} from '../model/EntityReferenceInGroup.mjs';
import {Form} from '../model/Form.mjs';
import {GroupScoped} from '../model/GroupScoped.mjs';
import {Patient} from '../model/Patient.mjs';


interface FormFiltersFactory {

	byParentIdForDataOwner(dataOwnerId: string, parentId: string): BaseFilterOptions<Form>;

	byParentIdForDataOwnerInGroup(dataOwner: EntityReferenceInGroup,
			parentId: string): BaseFilterOptions<Form>;

	byParentIdForSelf(parentId: string): FilterOptions<Form>;

	byPatientsOpeningDateForDataOwner(dataOwnerId: string, patients: Array<Patient>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): SortableFilterOptions<Form>;

	byPatientsOpeningDateForDataOwnerInGroup(dataOwner: EntityReferenceInGroup,
			patients: Array<GroupScoped<Patient>>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): SortableFilterOptions<Form>;

	byPatientsOpeningDateForSelf(patients: Array<Patient>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): SortableFilterOptions<Form>;

	byPatientSecretIdsOpeningDateForDataOwner(dataOwnerId: string, secretIds: Array<string>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): BaseSortableFilterOptions<Form>;

	byPatientSecretIdsOpeningDateForDataOwnerInGroup(dataOwner: EntityReferenceInGroup,
			secretIds: Array<string>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): BaseSortableFilterOptions<Form>;

	byPatientSecretIdsOpeningDateForSelf(secretIds: Array<string>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): SortableFilterOptions<Form>;

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
