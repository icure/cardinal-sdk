// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, FilterOptions, InternalPatientFiltersObj, SortableFilterOptions} from '../cardinal-sdk-ts.mjs';
import {EntityReferenceInGroup} from '../model/EntityReferenceInGroup.mjs';
import {Patient} from '../model/Patient.mjs';
import {Identifier} from '../model/base/Identifier.mjs';
import {Gender} from '../model/embed/Gender.mjs';


interface PatientFiltersFactory {

	allPatientsForDataOwner(dataOwnerId: string): BaseFilterOptions<Patient>;

	allPatientsForDataOwnerInGroup(dataOwner: EntityReferenceInGroup): BaseFilterOptions<Patient>;

	allPatientsForSelf(): FilterOptions<Patient>;

	byIds(ids: Array<string>): SortableFilterOptions<Patient>;

	byIdentifiersForDataOwner(dataOwnerId: string,
			identifiers: Array<Identifier>): BaseSortableFilterOptions<Patient>;

	byIdentifiersForDataOwnerInGroup(dataOwner: EntityReferenceInGroup,
			identifiers: Array<Identifier>): BaseSortableFilterOptions<Patient>;

	bySsinsForDataOwner(dataOwnerId: string, ssins: Array<string>): BaseSortableFilterOptions<Patient>;

	bySsinsForDataOwnerInGroup(dataOwner: EntityReferenceInGroup,
			ssins: Array<string>): BaseSortableFilterOptions<Patient>;

	byDateOfBirthBetweenForDataOwner(dataOwnerId: string, fromDate: number,
			toDate: number): BaseSortableFilterOptions<Patient>;

	byDateOfBirthBetweenForDataOwnerInGroup(dataOwner: EntityReferenceInGroup, fromDate: number,
			toDate: number): BaseSortableFilterOptions<Patient>;

	byFuzzyNameForDataOwner(dataOwnerId: string, searchString: string): BaseFilterOptions<Patient>;

	byFuzzyNameForDataOwnerInGroup(dataOwner: EntityReferenceInGroup,
			searchString: string): BaseFilterOptions<Patient>;

	byGenderEducationProfessionForDataOwner(dataOwnerId: string, gender: Gender,
			options?: { education?: string | undefined, profession?: string | undefined }): BaseSortableFilterOptions<Patient>;

	byGenderEducationProfessionForDataOwnerInGroup(dataOwner: EntityReferenceInGroup, gender: Gender,
			options?: { education?: string | undefined, profession?: string | undefined }): BaseSortableFilterOptions<Patient>;

	byActiveForDataOwner(dataOwnerId: string, active: boolean): BaseFilterOptions<Patient>;

	byActiveForDataOwnerInGroup(dataOwner: EntityReferenceInGroup,
			active: boolean): BaseFilterOptions<Patient>;

	byTelecomForDataOwner(dataOwnerId: string,
			searchString: string): BaseSortableFilterOptions<Patient>;

	byTelecomForDataOwnerInGroup(dataOwner: EntityReferenceInGroup,
			searchString: string): BaseSortableFilterOptions<Patient>;

	byAddressPostalCodeHouseNumberForDataOwner(dataOwnerId: string, searchString: string,
			postalCode: string,
			options?: { houseNumber?: string | undefined }): BaseSortableFilterOptions<Patient>;

	byAddressPostalCodeHouseNumberForDataOwnerInGroup(dataOwner: EntityReferenceInGroup,
			searchString: string, postalCode: string,
			options?: { houseNumber?: string | undefined }): BaseSortableFilterOptions<Patient>;

	byAddressForDataOwner(dataOwnerId: string,
			searchString: string): BaseSortableFilterOptions<Patient>;

	byAddressForDataOwnerInGroup(dataOwner: EntityReferenceInGroup,
			searchString: string): BaseSortableFilterOptions<Patient>;

	byIdentifiersForSelf(identifiers: Array<Identifier>): SortableFilterOptions<Patient>;

	bySsinsForSelf(ssins: Array<string>): SortableFilterOptions<Patient>;

	byDateOfBirthBetweenForSelf(fromDate: number, toDate: number): SortableFilterOptions<Patient>;

	byNameForSelf(searchString: string): FilterOptions<Patient>;

	byGenderEducationProfessionForSelf(gender: Gender,
			options?: { education?: string | undefined, profession?: string | undefined }): SortableFilterOptions<Patient>;

	byActiveForSelf(active: boolean): FilterOptions<Patient>;

	byTelecomForSelf(searchString: string): SortableFilterOptions<Patient>;

	byAddressPostalCodeHouseNumberForSelf(searchString: string, postalCode: string,
			options?: { houseNumber?: string | undefined }): SortableFilterOptions<Patient>;

	byAddressForSelf(searchString: string): SortableFilterOptions<Patient>;

	byTagForSelf(tagType: string, tagCode: string | undefined): FilterOptions<Patient>;

	byTagForDataOwner(dataOwnerId: string, tagType: string,
			tagCode: string | undefined): BaseFilterOptions<Patient>;

	byTagForDataOwnerInGroup(dataOwner: EntityReferenceInGroup, tagType: string,
			tagCode: string | undefined): BaseFilterOptions<Patient>;

}

export const PatientFilters: PatientFiltersFactory = {
			allPatientsForDataOwner: (dataOwnerId) => InternalPatientFiltersObj.getInstance().allPatientsForDataOwner(dataOwnerId),
			allPatientsForDataOwnerInGroup: (dataOwner) => InternalPatientFiltersObj.getInstance().allPatientsForDataOwnerInGroup(dataOwner),
			allPatientsForSelf: () => InternalPatientFiltersObj.getInstance().allPatientsForSelf(),
			byIds: (ids) => InternalPatientFiltersObj.getInstance().byIds(ids),
			byIdentifiersForDataOwner: (dataOwnerId, identifiers) => InternalPatientFiltersObj.getInstance().byIdentifiersForDataOwner(dataOwnerId, identifiers),
			byIdentifiersForDataOwnerInGroup: (dataOwner, identifiers) => InternalPatientFiltersObj.getInstance().byIdentifiersForDataOwnerInGroup(dataOwner, identifiers),
			bySsinsForDataOwner: (dataOwnerId, ssins) => InternalPatientFiltersObj.getInstance().bySsinsForDataOwner(dataOwnerId, ssins),
			bySsinsForDataOwnerInGroup: (dataOwner, ssins) => InternalPatientFiltersObj.getInstance().bySsinsForDataOwnerInGroup(dataOwner, ssins),
			byDateOfBirthBetweenForDataOwner: (dataOwnerId, fromDate, toDate) => InternalPatientFiltersObj.getInstance().byDateOfBirthBetweenForDataOwner(dataOwnerId, fromDate, toDate),
			byDateOfBirthBetweenForDataOwnerInGroup: (dataOwner, fromDate, toDate) => InternalPatientFiltersObj.getInstance().byDateOfBirthBetweenForDataOwnerInGroup(dataOwner, fromDate, toDate),
			byFuzzyNameForDataOwner: (dataOwnerId, searchString) => InternalPatientFiltersObj.getInstance().byFuzzyNameForDataOwner(dataOwnerId, searchString),
			byFuzzyNameForDataOwnerInGroup: (dataOwner, searchString) => InternalPatientFiltersObj.getInstance().byFuzzyNameForDataOwnerInGroup(dataOwner, searchString),
			byGenderEducationProfessionForDataOwner: (dataOwnerId, gender, options) => InternalPatientFiltersObj.getInstance().byGenderEducationProfessionForDataOwner(dataOwnerId, gender, options),
			byGenderEducationProfessionForDataOwnerInGroup: (dataOwner, gender, options) => InternalPatientFiltersObj.getInstance().byGenderEducationProfessionForDataOwnerInGroup(dataOwner, gender, options),
			byActiveForDataOwner: (dataOwnerId, active) => InternalPatientFiltersObj.getInstance().byActiveForDataOwner(dataOwnerId, active),
			byActiveForDataOwnerInGroup: (dataOwner, active) => InternalPatientFiltersObj.getInstance().byActiveForDataOwnerInGroup(dataOwner, active),
			byTelecomForDataOwner: (dataOwnerId, searchString) => InternalPatientFiltersObj.getInstance().byTelecomForDataOwner(dataOwnerId, searchString),
			byTelecomForDataOwnerInGroup: (dataOwner, searchString) => InternalPatientFiltersObj.getInstance().byTelecomForDataOwnerInGroup(dataOwner, searchString),
			byAddressPostalCodeHouseNumberForDataOwner: (dataOwnerId, searchString, postalCode, options) => InternalPatientFiltersObj.getInstance().byAddressPostalCodeHouseNumberForDataOwner(dataOwnerId, searchString, postalCode, options),
			byAddressPostalCodeHouseNumberForDataOwnerInGroup: (dataOwner, searchString, postalCode, options) => InternalPatientFiltersObj.getInstance().byAddressPostalCodeHouseNumberForDataOwnerInGroup(dataOwner, searchString, postalCode, options),
			byAddressForDataOwner: (dataOwnerId, searchString) => InternalPatientFiltersObj.getInstance().byAddressForDataOwner(dataOwnerId, searchString),
			byAddressForDataOwnerInGroup: (dataOwner, searchString) => InternalPatientFiltersObj.getInstance().byAddressForDataOwnerInGroup(dataOwner, searchString),
			byIdentifiersForSelf: (identifiers) => InternalPatientFiltersObj.getInstance().byIdentifiersForSelf(identifiers),
			bySsinsForSelf: (ssins) => InternalPatientFiltersObj.getInstance().bySsinsForSelf(ssins),
			byDateOfBirthBetweenForSelf: (fromDate, toDate) => InternalPatientFiltersObj.getInstance().byDateOfBirthBetweenForSelf(fromDate, toDate),
			byNameForSelf: (searchString) => InternalPatientFiltersObj.getInstance().byNameForSelf(searchString),
			byGenderEducationProfessionForSelf: (gender, options) => InternalPatientFiltersObj.getInstance().byGenderEducationProfessionForSelf(gender, options),
			byActiveForSelf: (active) => InternalPatientFiltersObj.getInstance().byActiveForSelf(active),
			byTelecomForSelf: (searchString) => InternalPatientFiltersObj.getInstance().byTelecomForSelf(searchString),
			byAddressPostalCodeHouseNumberForSelf: (searchString, postalCode, options) => InternalPatientFiltersObj.getInstance().byAddressPostalCodeHouseNumberForSelf(searchString, postalCode, options),
			byAddressForSelf: (searchString) => InternalPatientFiltersObj.getInstance().byAddressForSelf(searchString),
			byTagForSelf: (tagType, tagCode) => InternalPatientFiltersObj.getInstance().byTagForSelf(tagType, tagCode),
			byTagForDataOwner: (dataOwnerId, tagType, tagCode) => InternalPatientFiltersObj.getInstance().byTagForDataOwner(dataOwnerId, tagType, tagCode),
			byTagForDataOwnerInGroup: (dataOwner, tagType, tagCode) => InternalPatientFiltersObj.getInstance().byTagForDataOwnerInGroup(dataOwner, tagType, tagCode)
		};
