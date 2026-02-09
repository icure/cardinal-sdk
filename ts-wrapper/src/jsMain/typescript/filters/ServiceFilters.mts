// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, FilterOptions, InternalServiceFiltersObj, SortableFilterOptions} from '../cardinal-sdk-ts.mjs';
import {EntityReferenceInGroup} from '../model/EntityReferenceInGroup.mjs';
import {Patient} from '../model/Patient.mjs';
import {Identifier} from '../model/base/Identifier.mjs';
import {LinkQualification} from '../model/base/LinkQualification.mjs';
import {Service} from '../model/embed/Service.mjs';


interface ServiceFiltersFactory {

	allServicesForDataOwner(dataOwnerId: string): BaseFilterOptions<Service>;

	allServicesForDataOwnerInGroup(dataOwner: EntityReferenceInGroup): BaseFilterOptions<Service>;

	allServicesForSelf(): FilterOptions<Service>;

	byIdentifiersForDataOwner(dataOwnerId: string,
			identifiers: Array<Identifier>): BaseSortableFilterOptions<Service>;

	byIdentifiersForDataOwnerInGroup(dataOwner: EntityReferenceInGroup,
			identifiers: Array<Identifier>): BaseSortableFilterOptions<Service>;

	byCodeAndValueDateForDataOwner(dataOwnerId: string, codeType: string,
			options?: { codeCode?: string | undefined, startOfServiceValueDate?: number | undefined, endOfServiceValueDate?: number | undefined }): BaseSortableFilterOptions<Service>;

	byCodeAndValueDateForDataOwnerInGroup(dataOwner: EntityReferenceInGroup, codeType: string,
			options?: { codeCode?: string | undefined, startOfServiceValueDate?: number | undefined, endOfServiceValueDate?: number | undefined }): BaseSortableFilterOptions<Service>;

	byTagAndValueDateForDataOwner(dataOwnerId: string, tagType: string,
			options?: { tagCode?: string | undefined, startOfServiceValueDate?: number | undefined, endOfServiceValueDate?: number | undefined }): BaseSortableFilterOptions<Service>;

	byTagAndValueDateForDataOwnerInGroup(dataOwner: EntityReferenceInGroup, tagType: string,
			options?: { tagCode?: string | undefined, startOfServiceValueDate?: number | undefined, endOfServiceValueDate?: number | undefined }): BaseSortableFilterOptions<Service>;

	byPatientsForDataOwner(dataOwnerId: string,
			patients: Array<Patient>): SortableFilterOptions<Service>;

	byPatientsForDataOwnerInGroup(dataOwner: EntityReferenceInGroup,
			patients: Array<Patient>): SortableFilterOptions<Service>;

	byPatientsSecretIdsForDataOwner(dataOwnerId: string,
			secretIds: Array<string>): BaseSortableFilterOptions<Service>;

	byPatientsSecretIdsForDataOwnerInGroup(dataOwner: EntityReferenceInGroup,
			secretIds: Array<string>): BaseSortableFilterOptions<Service>;

	byHealthElementIdFromSubContactForDataOwner(dataOwnerId: string,
			healthElementIds: Array<string>): BaseSortableFilterOptions<Service>;

	byHealthElementIdFromSubContactForDataOwnerInGroup(dataOwner: EntityReferenceInGroup,
			healthElementIds: Array<string>): BaseSortableFilterOptions<Service>;

	byIdentifiersForSelf(identifiers: Array<Identifier>): SortableFilterOptions<Service>;

	byCodeAndValueDateForSelf(codeType: string,
			options?: { codeCode?: string | undefined, startOfServiceValueDate?: number | undefined, endOfServiceValueDate?: number | undefined }): SortableFilterOptions<Service>;

	byTagAndValueDateForSelf(tagType: string,
			options?: { tagCode?: string | undefined, startOfServiceValueDate?: number | undefined, endOfServiceValueDate?: number | undefined }): SortableFilterOptions<Service>;

	byPatientsForSelf(patients: Array<Patient>): SortableFilterOptions<Service>;

	byPatientsSecretIdsForSelf(secretIds: Array<string>): SortableFilterOptions<Service>;

	byHealthElementIdFromSubContactForSelf(healthElementIds: Array<string>): SortableFilterOptions<Service>;

	byIds(ids: Array<string>): BaseSortableFilterOptions<Service>;

	byAssociationId(associationId: string): BaseFilterOptions<Service>;

	byQualifiedLink(linkValues: Array<string>,
			options?: { linkQualification?: LinkQualification | undefined }): BaseFilterOptions<Service>;

	byPatientsDateForDataOwner(dataOwnerId: string, patients: Array<Patient>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): SortableFilterOptions<Service>;

	byPatientsDateForDataOwnerInGroup(dataOwner: EntityReferenceInGroup, patients: Array<Patient>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): SortableFilterOptions<Service>;

	byPatientsDateForSelf(patients: Array<Patient>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): SortableFilterOptions<Service>;

	byPatientSecretIdsDateForDataOwner(dataOwnerId: string, secretIds: Array<string>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): BaseSortableFilterOptions<Service>;

	byPatientSecretIdsDateForDataOwnerInGroup(dataOwner: EntityReferenceInGroup,
			secretIds: Array<string>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): BaseSortableFilterOptions<Service>;

	byPatientSecretIdsDateForSelf(secretIds: Array<string>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): SortableFilterOptions<Service>;

}

export const ServiceFilters: ServiceFiltersFactory = {
			allServicesForDataOwner: (dataOwnerId) => InternalServiceFiltersObj.getInstance().allServicesForDataOwner(dataOwnerId),
			allServicesForDataOwnerInGroup: (dataOwner) => InternalServiceFiltersObj.getInstance().allServicesForDataOwnerInGroup(dataOwner),
			allServicesForSelf: () => InternalServiceFiltersObj.getInstance().allServicesForSelf(),
			byIdentifiersForDataOwner: (dataOwnerId, identifiers) => InternalServiceFiltersObj.getInstance().byIdentifiersForDataOwner(dataOwnerId, identifiers),
			byIdentifiersForDataOwnerInGroup: (dataOwner, identifiers) => InternalServiceFiltersObj.getInstance().byIdentifiersForDataOwnerInGroup(dataOwner, identifiers),
			byCodeAndValueDateForDataOwner: (dataOwnerId, codeType, options) => InternalServiceFiltersObj.getInstance().byCodeAndValueDateForDataOwner(dataOwnerId, codeType, options),
			byCodeAndValueDateForDataOwnerInGroup: (dataOwner, codeType, options) => InternalServiceFiltersObj.getInstance().byCodeAndValueDateForDataOwnerInGroup(dataOwner, codeType, options),
			byTagAndValueDateForDataOwner: (dataOwnerId, tagType, options) => InternalServiceFiltersObj.getInstance().byTagAndValueDateForDataOwner(dataOwnerId, tagType, options),
			byTagAndValueDateForDataOwnerInGroup: (dataOwner, tagType, options) => InternalServiceFiltersObj.getInstance().byTagAndValueDateForDataOwnerInGroup(dataOwner, tagType, options),
			byPatientsForDataOwner: (dataOwnerId, patients) => InternalServiceFiltersObj.getInstance().byPatientsForDataOwner(dataOwnerId, patients),
			byPatientsForDataOwnerInGroup: (dataOwner, patients) => InternalServiceFiltersObj.getInstance().byPatientsForDataOwnerInGroup(dataOwner, patients),
			byPatientsSecretIdsForDataOwner: (dataOwnerId, secretIds) => InternalServiceFiltersObj.getInstance().byPatientsSecretIdsForDataOwner(dataOwnerId, secretIds),
			byPatientsSecretIdsForDataOwnerInGroup: (dataOwner, secretIds) => InternalServiceFiltersObj.getInstance().byPatientsSecretIdsForDataOwnerInGroup(dataOwner, secretIds),
			byHealthElementIdFromSubContactForDataOwner: (dataOwnerId, healthElementIds) => InternalServiceFiltersObj.getInstance().byHealthElementIdFromSubContactForDataOwner(dataOwnerId, healthElementIds),
			byHealthElementIdFromSubContactForDataOwnerInGroup: (dataOwner, healthElementIds) => InternalServiceFiltersObj.getInstance().byHealthElementIdFromSubContactForDataOwnerInGroup(dataOwner, healthElementIds),
			byIdentifiersForSelf: (identifiers) => InternalServiceFiltersObj.getInstance().byIdentifiersForSelf(identifiers),
			byCodeAndValueDateForSelf: (codeType, options) => InternalServiceFiltersObj.getInstance().byCodeAndValueDateForSelf(codeType, options),
			byTagAndValueDateForSelf: (tagType, options) => InternalServiceFiltersObj.getInstance().byTagAndValueDateForSelf(tagType, options),
			byPatientsForSelf: (patients) => InternalServiceFiltersObj.getInstance().byPatientsForSelf(patients),
			byPatientsSecretIdsForSelf: (secretIds) => InternalServiceFiltersObj.getInstance().byPatientsSecretIdsForSelf(secretIds),
			byHealthElementIdFromSubContactForSelf: (healthElementIds) => InternalServiceFiltersObj.getInstance().byHealthElementIdFromSubContactForSelf(healthElementIds),
			byIds: (ids) => InternalServiceFiltersObj.getInstance().byIds(ids),
			byAssociationId: (associationId) => InternalServiceFiltersObj.getInstance().byAssociationId(associationId),
			byQualifiedLink: (linkValues, options) => InternalServiceFiltersObj.getInstance().byQualifiedLink(linkValues, options),
			byPatientsDateForDataOwner: (dataOwnerId, patients, options) => InternalServiceFiltersObj.getInstance().byPatientsDateForDataOwner(dataOwnerId, patients, options),
			byPatientsDateForDataOwnerInGroup: (dataOwner, patients, options) => InternalServiceFiltersObj.getInstance().byPatientsDateForDataOwnerInGroup(dataOwner, patients, options),
			byPatientsDateForSelf: (patients, options) => InternalServiceFiltersObj.getInstance().byPatientsDateForSelf(patients, options),
			byPatientSecretIdsDateForDataOwner: (dataOwnerId, secretIds, options) => InternalServiceFiltersObj.getInstance().byPatientSecretIdsDateForDataOwner(dataOwnerId, secretIds, options),
			byPatientSecretIdsDateForDataOwnerInGroup: (dataOwner, secretIds, options) => InternalServiceFiltersObj.getInstance().byPatientSecretIdsDateForDataOwnerInGroup(dataOwner, secretIds, options),
			byPatientSecretIdsDateForSelf: (secretIds, options) => InternalServiceFiltersObj.getInstance().byPatientSecretIdsDateForSelf(secretIds, options)
		};
