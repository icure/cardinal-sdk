// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, FilterOptions, InternalContactFiltersObj, SortableFilterOptions} from '../cardinal-sdk-ts.mjs';
import {Contact} from '../model/Contact.mjs';
import {EntityReferenceInGroup} from '../model/EntityReferenceInGroup.mjs';
import {GroupScoped} from '../model/GroupScoped.mjs';
import {Patient} from '../model/Patient.mjs';
import {Identifier} from '../model/base/Identifier.mjs';


interface ContactFiltersFactory {

	allContactsForDataOwner(dataOwnerId: string): BaseFilterOptions<Contact>;

	allContactsForDataOwnerInGroup(dataOwner: EntityReferenceInGroup): BaseFilterOptions<Contact>;

	allContactsForSelf(): FilterOptions<Contact>;

	byFormIdsForDataOwner(dataOwnerId: string, formIds: Array<string>): BaseFilterOptions<Contact>;

	byFormIdsForDataOwnerInGroup(dataOwner: EntityReferenceInGroup,
			formIds: Array<string>): BaseFilterOptions<Contact>;

	byFormIdsForSelf(formIds: Array<string>): FilterOptions<Contact>;

	byPatientsOpeningDateForDataOwner(dataOwnerId: string, patients: Array<Patient>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): SortableFilterOptions<Contact>;

	byPatientsOpeningDateForDataOwnerInGroup(dataOwner: EntityReferenceInGroup,
			patients: Array<GroupScoped<Patient>>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): SortableFilterOptions<Contact>;

	byPatientsOpeningDateForSelf(patients: Array<Patient>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): SortableFilterOptions<Contact>;

	byPatientSecretIdsOpeningDateForDataOwner(dataOwnerId: string, secretIds: Array<string>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): BaseSortableFilterOptions<Contact>;

	byPatientSecretIdsOpeningDateForDataOwnerInGroup(dataOwner: EntityReferenceInGroup,
			secretIds: Array<string>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): BaseSortableFilterOptions<Contact>;

	byPatientSecretIdsOpeningDateForSelf(secretIds: Array<string>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): SortableFilterOptions<Contact>;

	byIdentifiersForSelf(identifiers: Array<Identifier>): SortableFilterOptions<Contact>;

	byIdentifiersForDataOwner(dataOwnerId: string,
			identifiers: Array<Identifier>): BaseSortableFilterOptions<Contact>;

	byIdentifiersForDataOwnerInGroup(dataOwner: EntityReferenceInGroup,
			identifiers: Array<Identifier>): BaseSortableFilterOptions<Contact>;

	byCodeAndOpeningDateForDataOwner(dataOwnerId: string, codeType: string,
			options?: { codeCode?: string | undefined, startOfContactOpeningDate?: number | undefined, endOfContactOpeningDate?: number | undefined }): BaseSortableFilterOptions<Contact>;

	byCodeAndOpeningDateForDataOwnerInGroup(dataOwner: EntityReferenceInGroup, codeType: string,
			options?: { codeCode?: string | undefined, startOfContactOpeningDate?: number | undefined, endOfContactOpeningDate?: number | undefined }): BaseSortableFilterOptions<Contact>;

	byCodeAndOpeningDateForSelf(codeType: string,
			options?: { codeCode?: string | undefined, startOfContactOpeningDate?: number | undefined, endOfContactOpeningDate?: number | undefined }): SortableFilterOptions<Contact>;

	byTagAndOpeningDateForDataOwner(dataOwnerId: string, tagType: string,
			options?: { tagCode?: string | undefined, startOfContactOpeningDate?: number | undefined, endOfContactOpeningDate?: number | undefined }): BaseSortableFilterOptions<Contact>;

	byTagAndOpeningDateForDataOwnerInGroup(dataOwner: EntityReferenceInGroup, tagType: string,
			options?: { tagCode?: string | undefined, startOfContactOpeningDate?: number | undefined, endOfContactOpeningDate?: number | undefined }): BaseSortableFilterOptions<Contact>;

	byOpeningDateForDataOwner(dataOwnerId: string,
			options?: { startDate?: number | undefined, endDate?: number | undefined, descending?: boolean }): BaseSortableFilterOptions<Contact>;

	byOpeningDateForDataOwnerInGroup(dataOwner: EntityReferenceInGroup,
			options?: { startDate?: number | undefined, endDate?: number | undefined, descending?: boolean }): BaseSortableFilterOptions<Contact>;

	byOpeningDateForSelf(options?: { startDate?: number | undefined, endDate?: number | undefined, descending?: boolean }): SortableFilterOptions<Contact>;

	byServiceTagForSelf(tagType: string,
			options?: { tagCode?: string | undefined }): FilterOptions<Contact>;

	byServiceTagForDataOwner(dataOwnerId: string, tagType: string,
			options?: { tagCode?: string | undefined }): BaseFilterOptions<Contact>;

	byServiceTagForDataOwnerInGroup(dataOwner: EntityReferenceInGroup, tagType: string,
			options?: { tagCode?: string | undefined }): BaseFilterOptions<Contact>;

	byServiceCodeForSelf(codeType: string,
			options?: { codeCode?: string | undefined }): FilterOptions<Contact>;

	byServiceCodeForDataOwner(dataOwnerId: string, codeType: string,
			options?: { codeCode?: string | undefined }): BaseFilterOptions<Contact>;

	byServiceCodeForDataOwnerInGroup(dataOwner: EntityReferenceInGroup, codeType: string,
			options?: { codeCode?: string | undefined }): BaseFilterOptions<Contact>;

	byTagAndOpeningDateForSelf(tagType: string,
			options?: { tagCode?: string | undefined, startOfContactOpeningDate?: number | undefined, endOfContactOpeningDate?: number | undefined }): SortableFilterOptions<Contact>;

	byPatientsForDataOwner(dataOwnerId: string,
			patients: Array<Patient>): SortableFilterOptions<Contact>;

	byPatientsForDataOwnerInGroup(dataOwner: EntityReferenceInGroup,
			patients: Array<GroupScoped<Patient>>): SortableFilterOptions<Contact>;

	byPatientsForSelf(patients: Array<Patient>): SortableFilterOptions<Contact>;

	byPatientsSecretIdsForDataOwner(dataOwnerId: string,
			secretIds: Array<string>): BaseSortableFilterOptions<Contact>;

	byPatientsSecretIdsForDataOwnerInGroup(dataOwner: EntityReferenceInGroup,
			secretIds: Array<string>): BaseSortableFilterOptions<Contact>;

	byPatientsSecretIdsForSelf(secretIds: Array<string>): SortableFilterOptions<Contact>;

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
