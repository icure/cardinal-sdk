// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, FilterOptions, InternalPatientFiltersObj, SortableFilterOptions} from '../cardinal-sdk-ts.mjs';
import {EntityReferenceInGroup} from '../model/EntityReferenceInGroup.mjs';
import {Patient} from '../model/Patient.mjs';
import {Identifier} from '../model/base/Identifier.mjs';
import {Gender} from '../model/embed/Gender.mjs';


interface PatientFiltersFactory {

	/**
	 *
	 *  Create options for patient filtering that will match all patients shared directly (i.e. ignoring hierarchies) with a specific data owner.
	 *
	 *  @param dataOwnerId a data owner id
	 *  @return options for patient filtering
	 */
	allPatientsForDataOwner(dataOwnerId: string): BaseFilterOptions<Patient>;

	/**
	 *
	 *  In-group version of [allPatientsForDataOwner].
	 *  The data owner can be from a different group than the group of the user executing the query.
	 */
	allPatientsForDataOwnerInGroup(dataOwner: EntityReferenceInGroup): BaseFilterOptions<Patient>;

	/**
	 *
	 *  Create options for patient filtering that will match all patients shared directly (i.e. ignoring hierarchies) with the current data owner.
	 *
	 *  @return options for patient filtering
	 */
	allPatientsForSelf(): FilterOptions<Patient>;

	/**
	 *
	 *  Filter options that match all patients with one of the provided ids.
	 *  These options are sortable. When sorting using these options the patients will have the same order as the input ids.
	 *
	 *  @param ids a list of unique patient ids.
	 *  @throws IllegalArgumentException if the provided [ids] list contains duplicate elements
	 */
	byIds(ids: Array<string>): SortableFilterOptions<Patient>;

	/**
	 *
	 *  Options for patient filtering which match all the patients shared directly (i.e. ignoring hierarchies) with a specific data owner that have at least
	 *  an identifier that has the same exact [Identifier.system] and [Identifier.value] as one of the provided
	 *  [identifiers]. Other properties of the provided identifiers are ignored.
	 *
	 *  These options are sortable. When sorting using these options the patients will be in the same order as the input
	 *  identifiers. In case an entity has multiple identifiers only the first matching identifier is considered for the
	 *  sorting.
	 *
	 *  @param identifiers a list of identifiers
	 *  @param dataOwnerId a data owner id
	 *  @return options for patient filtering
	 */
	byIdentifiersForDataOwner(dataOwnerId: string,
			identifiers: Array<Identifier>): BaseSortableFilterOptions<Patient>;

	/**
	 *
	 *  In-group version of [byIdentifiersForDataOwner].
	 *  The data owner can be from a different group than the group of the user executing the query.
	 */
	byIdentifiersForDataOwnerInGroup(dataOwner: EntityReferenceInGroup,
			identifiers: Array<Identifier>): BaseSortableFilterOptions<Patient>;

	/**
	 *
	 *  Options for patient filtering which match all the patients shared directly (i.e. ignoring hierarchies) with a specific data owner that have
	 *  [Patient.ssin] matching one of the provided ssins.
	 *  These options are sortable. When sorting using these options the patients will be in the same order as the
	 *  provided ssins.
	 *
	 *  @param ssins a list of ssins
	 *  @param dataOwnerId a data owner id
	 */
	bySsinsForDataOwner(dataOwnerId: string, ssins: Array<string>): BaseSortableFilterOptions<Patient>;

	/**
	 *
	 *  In-group version of [bySsinsForDataOwner].
	 *  The data owner can be from a different group than the group of the user executing the query.
	 */
	bySsinsForDataOwnerInGroup(dataOwner: EntityReferenceInGroup,
			ssins: Array<string>): BaseSortableFilterOptions<Patient>;

	/**
	 *
	 *  Options for patient filtering which match all the patients shared directly (i.e. ignoring hierarchies) with a specific data owner that have
	 *  [Patient.dateOfBirth] between the provided values (inclusive).
	 *  These options are sortable. When sorting using these options the patients will be ordered by date of birth.
	 *
	 *  @param fromDate the start date in YYYYMMDD format (inclusive)
	 *  @param toDate the end date in YYYYMMDD format (inclusive)
	 *  @param dataOwnerId a data owner id
	 */
	byDateOfBirthBetweenForDataOwner(dataOwnerId: string, fromDate: number,
			toDate: number): BaseSortableFilterOptions<Patient>;

	/**
	 *
	 *  In-group version of [byDateOfBirthBetweenForDataOwner].
	 *  The data owner can be from a different group than the group of the user executing the query.
	 */
	byDateOfBirthBetweenForDataOwnerInGroup(dataOwner: EntityReferenceInGroup, fromDate: number,
			toDate: number): BaseSortableFilterOptions<Patient>;

	/**
	 *
	 *  Options for patient filtering which match all the patients shared directly (i.e. ignoring hierarchies) with a specific data owner that have the
	 *  provided search string contained within [Patient.firstName], [Patient.lastName], [Patient.maidenName], or
	 *  [Patient.spouseName].
	 *
	 *  @param searchString part of a patient name.
	 *  @param dataOwnerId a data owner id
	 */
	byFuzzyNameForDataOwner(dataOwnerId: string, searchString: string): BaseFilterOptions<Patient>;

	/**
	 *
	 *  In-group version of [byFuzzyNameForDataOwner].
	 *  The data owner can be from a different group than the group of the user executing the query.
	 */
	byFuzzyNameForDataOwnerInGroup(dataOwner: EntityReferenceInGroup,
			searchString: string): BaseFilterOptions<Patient>;

	/**
	 *
	 *  Options for patient filtering which match all the patients shared directly (i.e. ignoring hierarchies) with a specific data owner that have the
	 *  provided [Patient.gender], and optionally also the provided [Patient.education] and [Patient.profession].
	 *  Note you can only provide profession if you have provided the education.
	 *
	 *  These options are sortable. When sorting using these options the patients will be ordered first by education
	 *  then by profession.
	 *
	 *  @param gender the patient gender.
	 *  @param education the patient education. If not provided patient the education of the patient will be ignored by
	 *  this filter.
	 *  @param profession the patient profession. If not provided patient the profession of the patient will be ignored by
	 *  this filter.
	 *  @param dataOwnerId a data owner id
	 *  @throws IllegalArgumentException if [profession] is not null and [education] is null.
	 */
	byGenderEducationProfessionForDataOwner(dataOwnerId: string, gender: Gender,
			options?: { education?: string | undefined, profession?: string | undefined }): BaseSortableFilterOptions<Patient>;

	/**
	 *
	 *  In-group version of [byGenderEducationProfessionForDataOwner].
	 *  The data owner can be from a different group than the group of the user executing the query.
	 */
	byGenderEducationProfessionForDataOwnerInGroup(dataOwner: EntityReferenceInGroup, gender: Gender,
			options?: { education?: string | undefined, profession?: string | undefined }): BaseSortableFilterOptions<Patient>;

	/**
	 *
	 *  Options for patient filtering which match all the patients shared directly (i.e. ignoring hierarchies) with a specific data owner that have the
	 *  provided [Patient.active] value.
	 *
	 *  @param active true if the options should match active patients, false if it should match inactive patients.
	 *  @param dataOwnerId a data owner id
	 */
	byActiveForDataOwner(dataOwnerId: string, active: boolean): BaseFilterOptions<Patient>;

	/**
	 *
	 *  In-group version of [byActiveForDataOwner].
	 *  The data owner can be from a different group than the group of the user executing the query.
	 */
	byActiveForDataOwnerInGroup(dataOwner: EntityReferenceInGroup,
			active: boolean): BaseFilterOptions<Patient>;

	/**
	 *
	 *  Options for patient filtering which match all the patients shared directly (i.e. ignoring hierarchies) with a specific data owner that have at least
	 *  an address with a [Patient.addresses] where one of the [Address.telecoms] has a [Telecom.telecomNumber] that
	 *  starts with the provided [searchString].
	 *
	 *  These options are sortable. When sorting using these options the patients will be ordered lexicographically by
	 *  the matching telecom number.
	 *
	 *  @param searchString start of a patient telecom. Non-alphanumeric characters are ignored.
	 *  @param dataOwnerId a data owner id
	 */
	byTelecomForDataOwner(dataOwnerId: string,
			searchString: string): BaseSortableFilterOptions<Patient>;

	/**
	 *
	 *  In-group version of [byTelecomForDataOwner].
	 *  The data owner can be from a different group than the group of the user executing the query.
	 */
	byTelecomForDataOwnerInGroup(dataOwner: EntityReferenceInGroup,
			searchString: string): BaseSortableFilterOptions<Patient>;

	/**
	 *
	 *  Options for patient filtering which match all the patients shared directly (i.e. ignoring hierarchies) with a specific data owner that have at least
	 *  an [Patient.addresses] where the [Address.street] or [Address.city] contain the provided [searchString] and
	 *  [Address.postalCode] matches the provided [postalCode].
	 *  Additionally you can limit the search to a specific house number.
	 *
	 *  These options are sortable. When sorting using these options the patients will be ordered lexicographically first
	 *  by the matching portion of street+city, then by postal code and finally by house number.
	 *
	 *  @param searchString part of a patient address street or city
	 *  @param postalCode the patient postal code
	 *  @param houseNumber the patient house number
	 *  @param dataOwnerId a data owner id
	 */
	byAddressPostalCodeHouseNumberForDataOwner(dataOwnerId: string, searchString: string,
			postalCode: string,
			options?: { houseNumber?: string | undefined }): BaseSortableFilterOptions<Patient>;

	/**
	 *
	 *  In-group version of [byAddressPostalCodeHouseNumberForDataOwner].
	 *  The data owner can be from a different group than the group of the user executing the query.
	 */
	byAddressPostalCodeHouseNumberForDataOwnerInGroup(dataOwner: EntityReferenceInGroup,
			searchString: string, postalCode: string,
			options?: { houseNumber?: string | undefined }): BaseSortableFilterOptions<Patient>;

	/**
	 *
	 *  Options for patient filtering which match all the patients shared directly (i.e. ignoring hierarchies) with a specific data owner that have at least
	 *  an [Patient.addresses] where the [Address.street], [Address.postalCode] or [Address.city] contain the provided
	 *  [searchString].
	 *
	 *  These options are sortable. When sorting using these options the patients will be ordered lexicographically first
	 *  by the matching portion of street+postalCode+city, then by postal code and finally by house number.
	 *
	 *  @param searchString part of a patient address street, postal code, or city
	 *  @param dataOwnerId a data owner id
	 */
	byAddressForDataOwner(dataOwnerId: string,
			searchString: string): BaseSortableFilterOptions<Patient>;

	/**
	 *
	 *  In-group version of [byAddressForDataOwner].
	 *  The data owner can be from a different group than the group of the user executing the query.
	 */
	byAddressForDataOwnerInGroup(dataOwner: EntityReferenceInGroup,
			searchString: string): BaseSortableFilterOptions<Patient>;

	/**
	 *
	 *  Options for patient filtering which match all the patients shared directly (i.e. ignoring hierarchies) with the current data owner that have at least
	 *  an identifier that has the same exact [Identifier.system] and [Identifier.value] as one of the provided
	 *  [identifiers]. Other properties of the provided identifiers are ignored.
	 *
	 *  These options are sortable. When sorting using these options the patients will be in the same order as the input
	 *  identifiers. In case an entity has multiple identifiers only the first matching identifier is considered for the
	 *  sorting.
	 *
	 *  @param identifiers a list of identifiers
	 *  @return options for patient filtering
	 */
	byIdentifiersForSelf(identifiers: Array<Identifier>): SortableFilterOptions<Patient>;

	/**
	 *
	 *  Options for patient filtering which match all the patients shared directly (i.e. ignoring hierarchies) with the current data owner that have
	 *  [Patient.ssin] matching one of the provided ssins.
	 *  These options are sortable. When sorting using these options the patients will be in the same order as the
	 *  provided ssins.
	 *
	 *  @param ssins a list of ssins
	 */
	bySsinsForSelf(ssins: Array<string>): SortableFilterOptions<Patient>;

	/**
	 *
	 *  Options for patient filtering which match all the patients shared directly (i.e. ignoring hierarchies) with the current data owner that have
	 *  [Patient.dateOfBirth] between the provided values (inclusive).
	 *  These options are sortable. When sorting using these options the patients will be ordered by date of birth.
	 *
	 *  @param fromDate the start date in YYYYMMDD format (inclusive)
	 *  @param toDate the end date in YYYYMMDD format (inclusive)
	 */
	byDateOfBirthBetweenForSelf(fromDate: number, toDate: number): SortableFilterOptions<Patient>;

	/**
	 *
	 *  Options for patient filtering which match all the patients shared directly (i.e. ignoring hierarchies) with the current data owner that have the
	 *  provided search string contained within [Patient.firstName], [Patient.lastName], [Patient.maidenName], or
	 *  [Patient.spouseName].
	 *
	 *  @param searchString part of a patient name.
	 */
	byNameForSelf(searchString: string): FilterOptions<Patient>;

	/**
	 *
	 *  Options for patient filtering which match all the patients shared directly (i.e. ignoring hierarchies) with the current data owner that have the
	 *  provided [Patient.gender], and optionally also the provided [Patient.education] and [Patient.profession].
	 *  Note you can only provide profession if you have provided the education.
	 *
	 *  These options are sortable. When sorting using these options the patients will be ordered first by education
	 *  then by profession.
	 *
	 *  @param gender the patient gender.
	 *  @param education the patient education. If not provided patient the education of the patient will be ignored by
	 *  this filter.
	 *  @param profession the patient profession. If not provided patient the profession of the patient will be ignored by
	 *  this filter.
	 *  @throws IllegalArgumentException if [profession] is not null and [education] is null.
	 */
	byGenderEducationProfessionForSelf(gender: Gender,
			options?: { education?: string | undefined, profession?: string | undefined }): SortableFilterOptions<Patient>;

	/**
	 *
	 *  Options for patient filtering which match all the patients shared directly (i.e. ignoring hierarchies) with the current data owner that have the
	 *  provided [Patient.active] value.
	 *
	 *  @param active true if the options should match active patients, false if it should match inactive patients.
	 */
	byActiveForSelf(active: boolean): FilterOptions<Patient>;

	/**
	 *
	 *  Options for patient filtering which match all the patients shared directly (i.e. ignoring hierarchies) with the current data owner that have at least
	 *  an address with a [Patient.addresses] where one of the [Address.telecoms] has a [Telecom.telecomNumber] that
	 *  starts with the provided [searchString].
	 *
	 *  These options are sortable. When sorting using these options the patients will be ordered lexicographically by
	 *  the matching telecom number.
	 *
	 *  @param searchString start of a patient telecom. Non-alphanumeric characters are ignored.
	 */
	byTelecomForSelf(searchString: string): SortableFilterOptions<Patient>;

	/**
	 *
	 *  Options for patient filtering which match all the patients shared directly (i.e. ignoring hierarchies) with the current data owner that have at least
	 *  an [Patient.addresses] where the [Address.street] or [Address.city] contain the provided [searchString] and
	 *  [Address.postalCode] matches the provided [postalCode].
	 *  Additionally you can limit the search to a specific house number.
	 *
	 *  These options are sortable. When sorting using these options the patients will be ordered lexicographically first
	 *  by the matching portion of street+city, then by postal code and finally by house number.
	 *
	 *  @param searchString part of a patient address street or city
	 *  @param postalCode the patient postal code
	 *  @param houseNumber the patient house number
	 */
	byAddressPostalCodeHouseNumberForSelf(searchString: string, postalCode: string,
			options?: { houseNumber?: string | undefined }): SortableFilterOptions<Patient>;

	/**
	 *
	 *  Options for patient filtering which match all the patients shared directly (i.e. ignoring hierarchies) with the current data owner that have at least
	 *  an [Patient.addresses] where the [Address.street], [Address.postalCode] or [Address.city] contain the provided
	 *  [searchString].
	 *
	 *  These options are sortable. When sorting using these options the patients will be ordered lexicographically first
	 *  by the matching portion of street+postalCode+city, then by postal code and finally by house number.
	 *
	 *  @param searchString part of a patient address street, postal code, or city
	 */
	byAddressForSelf(searchString: string): SortableFilterOptions<Patient>;

	/**
	 *
	 *  Options for patient filtering which match all the patients shared directly (i.e. ignoring hierarchies) with the current data owner
	 *  where in [Patient.tags] there is at least one tag with type equal to [tagType] and code equal to [tagCode].
	 *
	 *  @param tagType the tag type to search.
	 *  @param tagCode the code type.
	 */
	byTagForSelf(tagType: string, tagCode: string | undefined): FilterOptions<Patient>;

	/**
	 *
	 *  Options for patient filtering which match all the patients shared directly (i.e. ignoring hierarchies) with a specific data owner
	 *  where in [Patient.tags] there is at least one tag with type equal to [tagType] and code equal to [tagCode].
	 *
	 *  @param dataOwnerId the id of the data owner.
	 *  @param tagType the tag type to search.
	 *  @param tagCode the code type.
	 */
	byTagForDataOwner(dataOwnerId: string, tagType: string,
			tagCode: string | undefined): BaseFilterOptions<Patient>;

	/**
	 *
	 *  In-group version of [byTagForDataOwner].
	 *  The data owner can be from a different group than the group of the user executing the query.
	 */
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
