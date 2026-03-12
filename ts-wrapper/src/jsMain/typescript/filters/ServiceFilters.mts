// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, FilterOptions, InternalServiceFiltersObj, SortableFilterOptions} from '../cardinal-sdk-ts.mjs';
import {EntityReferenceInGroup} from '../model/EntityReferenceInGroup.mjs';
import {Patient} from '../model/Patient.mjs';
import {Identifier} from '../model/base/Identifier.mjs';
import {LinkQualification} from '../model/base/LinkQualification.mjs';
import {Service} from '../model/embed/Service.mjs';


interface ServiceFiltersFactory {

	/**
	 *
	 *  Create options for service filtering that will match all services shared directly (i.e. ignoring hierarchies) with a specific data owner.
	 *  @param dataOwnerId a data owner id
	 *  @return options for service filtering
	 */
	allServicesForDataOwner(dataOwnerId: string): BaseFilterOptions<Service>;

	/**
	 *
	 *  In group version of [allServicesForDataOwner].
	 */
	allServicesForDataOwnerInGroup(dataOwner: EntityReferenceInGroup): BaseFilterOptions<Service>;

	/**
	 *
	 *  Create options for service filtering that will match all services shared directly (i.e. ignoring hierarchies) with the current data owner.
	 *  @return options for service filtering
	 */
	allServicesForSelf(): FilterOptions<Service>;

	/**
	 *
	 *  Options for service filtering which match all the services shared directly (i.e. ignoring hierarchies) with a specific data owner that have at least
	 *  an identifier that has the same exact [Identifier.system] and [Identifier.value] as one of the provided
	 *  [identifiers]. Other properties of the provided identifiers are ignored.
	 *
	 *  These options are sortable. When sorting using these options the services will be in the same order as the input
	 *  identifiers. In case an entity has multiple identifiers only the first matching identifier is considered for the
	 *  sorting.
	 *  @param identifiers a list of identifiers
	 *  @param dataOwnerId a data owner id
	 *  @return options for service filtering
	 */
	byIdentifiersForDataOwner(dataOwnerId: string,
			identifiers: Array<Identifier>): BaseSortableFilterOptions<Service>;

	/**
	 *
	 *  In group version of [byIdentifiersForDataOwner].
	 */
	byIdentifiersForDataOwnerInGroup(dataOwner: EntityReferenceInGroup,
			identifiers: Array<Identifier>): BaseSortableFilterOptions<Service>;

	/**
	 *
	 *  Options for service filtering which match all services shared directly (i.e. ignoring hierarchies) with a specific data owner that have a certain code.
	 *  If you specify only the [codeType] you will get all entities that have at least a code of that type.
	 *
	 *  You can also limit the result to only services that are within a certain [Service.valueDate] timeframe (or [Service.openingDate]
	 *  if the first is missing), but in that case you must specify the [codeCode].
	 *
	 *  These options are sortable. When sorting using these options the services will be sorted first by [codeCode] then
	 *  by [Service.valueDate].
	 *
	 *  @param codeType a code type
	 *  @param codeCode a code for the provided code type, or null if you want the filter to accept any entity
	 *  with a code of the provided type.
	 *  @param startOfServiceValueDate if provided the options will match only services with a value date
	 *  that is after this value (inclusive).
	 *  @param endOfServiceValueDate if provided the options will match only services with a value date
	 *  that is before this value (inclusive).
	 *  @param dataOwnerId a data owner id
	 *  @throws IllegalArgumentException if you provide a range for the value date but no [codeCode].
	 */
	byCodeAndValueDateForDataOwner(dataOwnerId: string, codeType: string,
			options?: { codeCode?: string | undefined, startOfServiceValueDate?: number | undefined, endOfServiceValueDate?: number | undefined }): BaseSortableFilterOptions<Service>;

	/**
	 *
	 *  In group version of [byCodeAndValueDateForDataOwner].
	 */
	byCodeAndValueDateForDataOwnerInGroup(dataOwner: EntityReferenceInGroup, codeType: string,
			options?: { codeCode?: string | undefined, startOfServiceValueDate?: number | undefined, endOfServiceValueDate?: number | undefined }): BaseSortableFilterOptions<Service>;

	/**
	 *
	 *  Options for service filtering which match all services shared directly (i.e. ignoring hierarchies) with a specific data owner that have a certain tag.
	 *  If you specify only the [tagType] you will get all entities that have at least a tag of that type.
	 *
	 *  You can also limit the result to only services that are within a certain [Service.valueDate] timeframe (or [Service.openingDate]
	 *  if the first is missing), but in that case you must specify the [tagCode].
	 *
	 *  These options are sortable. When sorting using these options the services will be sorted first by [tagCode] then
	 *  by [Service.valueDate].
	 *
	 *  @param tagType a tag type
	 *  @param tagCode a code for the provided tag type, or null if you want the filter to accept any entity
	 *  with a tag of the provided type.
	 *  @param startOfServiceValueDate if provided the options will match only services with a value date
	 *  that is after this value (inclusive).
	 *  @param endOfServiceValueDate if provided the options will match only services with a value date
	 *  that is before this value (inclusive).
	 *  @param dataOwnerId a data owner id
	 *  @throws IllegalArgumentException if you provide a range for the value date but no [tagCode].
	 */
	byTagAndValueDateForDataOwner(dataOwnerId: string, tagType: string,
			options?: { tagCode?: string | undefined, startOfServiceValueDate?: number | undefined, endOfServiceValueDate?: number | undefined }): BaseSortableFilterOptions<Service>;

	/**
	 *
	 *  In group version of [byTagAndValueDateForDataOwner].
	 */
	byTagAndValueDateForDataOwnerInGroup(dataOwner: EntityReferenceInGroup, tagType: string,
			options?: { tagCode?: string | undefined, startOfServiceValueDate?: number | undefined, endOfServiceValueDate?: number | undefined }): BaseSortableFilterOptions<Service>;

	/**
	 *
	 *  Options for service filtering which match all services shared directly (i.e. ignoring hierarchies) with a specific data owner that are linked with one
	 *  of the provided patients.
	 *
	 *  When using these options the sdk will automatically extract the secret ids from the provided patients and use
	 *  those for filtering.
	 *  If you already have the secret ids of the patient you may instead use [byPatientsSecretIdsForDataOwner].
	 *  If the current data owner does not have access to any secret id of one of the provide patients the patient will
	 *  simply be ignored.
	 *  Note that these may not be used in methods of apis from [CardinalBaseApis].
	 *
	 *  These options are sortable. When sorting using these options the services will be sorted by the patients, using
	 *  the same order as the input patients.
	 *  @param patients a list of patients.
	 *  @param dataOwnerId a data owner id
	 */
	byPatientsForDataOwner(dataOwnerId: string,
			patients: Array<Patient>): SortableFilterOptions<Service>;

	/**
	 *
	 *  In group version of [byPatientsForDataOwner].
	 */
	byPatientsForDataOwnerInGroup(dataOwner: EntityReferenceInGroup,
			patients: Array<Patient>): SortableFilterOptions<Service>;

	/**
	 *
	 *  Options for service filtering which match all services shared directly (i.e. ignoring hierarchies) with a specific data owner that are linked with a
	 *  patient through one of the provided secret ids.
	 *  These options are sortable. When sorting using these options the services will be sorted by the linked patients
	 *  secret id, using the same order as the input.
	 *  @param secretIds a list of patients secret ids
	 *  @param dataOwnerId a data owner id
	 */
	byPatientsSecretIdsForDataOwner(dataOwnerId: string,
			secretIds: Array<string>): BaseSortableFilterOptions<Service>;

	/**
	 *
	 *  In group version of [byPatientsSecretIdsForDataOwner].
	 */
	byPatientsSecretIdsForDataOwnerInGroup(dataOwner: EntityReferenceInGroup,
			secretIds: Array<string>): BaseSortableFilterOptions<Service>;

	/**
	 *
	 *  Options for service filtering which match all services from shared directly (i.e. ignoring hierarchies) with a specific data owner that exist in at
	 *  least a [SubContact] (from [Contact.subContacts]) where [SubContact.healthElementId] matches one of the provided
	 *  id.
	 *
	 *  These options are sortable. When sorting using these options the services will be sorted in the same order as the
	 *  input health element ids. If a service exists in multiple subcontacts only the first subcontact with matching
	 *  health element service is considered for the ordering.
	 *  @param healthElementIds a list of health element ids
	 *  @param dataOwnerId a data owner id
	 */
	byHealthElementIdFromSubContactForDataOwner(dataOwnerId: string,
			healthElementIds: Array<string>): BaseSortableFilterOptions<Service>;

	/**
	 *
	 *  In group version of [byHealthElementIdFromSubContactForDataOwner].
	 */
	byHealthElementIdFromSubContactForDataOwnerInGroup(dataOwner: EntityReferenceInGroup,
			healthElementIds: Array<string>): BaseSortableFilterOptions<Service>;

	/**
	 *
	 *  Options for service filtering which match all the services shared directly (i.e. ignoring hierarchies) with the current data owner that have at least
	 *  an identifier that has the same exact [Identifier.system] and [Identifier.value] as one of the provided
	 *  [identifiers]. Other properties of the provided identifiers are ignored.
	 *
	 *  These options are sortable. When sorting using these options the services will be in the same order as the input
	 *  identifiers. In case an entity has multiple identifiers only the first matching identifier is considered for the
	 *  sorting.
	 *  @param identifiers a list of identifiers
	 *  @return options for service filtering
	 */
	byIdentifiersForSelf(identifiers: Array<Identifier>): SortableFilterOptions<Service>;

	/**
	 *
	 *  Options for service filtering which match all services shared directly (i.e. ignoring hierarchies) with the current data owner that have a certain code.
	 *  If you specify only the [codeType] you will get all entities that have at least a code of that type.
	 *
	 *  You can also limit the result to only services that are within a certain [Service.valueDate] timeframe (or [Service.openingDate]
	 *  if the first is missing), but in that case you must specify the [codeCode].
	 *
	 *  These options are sortable. When sorting using these options the services will be sorted first by [codeCode] then
	 *  by [Service.valueDate].
	 *
	 *  @param codeType a code type
	 *  @param codeCode a code for the provided code type, or null if you want the filter to accept any entity
	 *  with a code of the provided type.
	 *  @param startOfServiceValueDate if provided the options will match only services with a value date
	 *  that is after this value (inclusive).
	 *  @param endOfServiceValueDate if provided the options will match only services with a value date
	 *  that is before this value (inclusive).
	 *  @throws IllegalArgumentException if you provide a range for the value date but no [codeCode].
	 */
	byCodeAndValueDateForSelf(codeType: string,
			options?: { codeCode?: string | undefined, startOfServiceValueDate?: number | undefined, endOfServiceValueDate?: number | undefined }): SortableFilterOptions<Service>;

	/**
	 *
	 *  Options for service filtering which match all services shared directly (i.e. ignoring hierarchies) with the current data owner that have a certain tag.
	 *  If you specify only the [tagType] you will get all entities that have at least a tag of that type.
	 *
	 *  You can also limit the result to only services that are within a certain [Service.valueDate] timeframe (or [Service.openingDate]
	 *  if the first is missing), but in that case you must specify the [tagCode].
	 *
	 *  These options are sortable. When sorting using these options the services will be sorted first by [tagCode] then
	 *  by [Service.valueDate].
	 *
	 *  @param tagType a tag type
	 *  @param tagCode a code for the provided tag type, or null if you want the filter to accept any entity
	 *  with a tag of the provided type.
	 *  @param startOfServiceValueDate if provided the options will match only services with a value date
	 *  that is after this value (inclusive).
	 *  @param endOfServiceValueDate if provided the options will match only services with a value date
	 *  that is before this value (inclusive).
	 *  @throws IllegalArgumentException if you provide a range for the value date but no [tagCode].
	 */
	byTagAndValueDateForSelf(tagType: string,
			options?: { tagCode?: string | undefined, startOfServiceValueDate?: number | undefined, endOfServiceValueDate?: number | undefined }): SortableFilterOptions<Service>;

	/**
	 *
	 *  Options for service filtering which match all services shared directly (i.e. ignoring hierarchies) with the current data owner that are linked with one
	 *  of the provided patients.
	 *
	 *  When using these options the sdk will automatically extract the secret ids from the provided patients and use
	 *  those for filtering.
	 *  If you already have the secret ids of the patient you may instead use [byPatientsSecretIdsForSelf].
	 *  If the current data owner does not have access to any secret id of one of the provide patients the patient will
	 *  simply be ignored.
	 *  Note that these may not be used in methods of apis from [CardinalBaseApis].
	 *
	 *  These options are sortable. When sorting using these options the services will be sorted by the patients, using
	 *  the same order as the input patients.
	 *
	 *  @param patients a list of patients.
	 */
	byPatientsForSelf(patients: Array<Patient>): SortableFilterOptions<Service>;

	/**
	 *
	 *  Options for service filtering which match all services shared directly (i.e. ignoring hierarchies) with the current data owner that are linked with a
	 *  patient through one of the provided secret ids.
	 *  These options are sortable. When sorting using these options the services will be sorted by the linked patients
	 *  secret id, using the same order as the input.
	 *
	 *  @param secretIds a list of patients secret ids
	 */
	byPatientsSecretIdsForSelf(secretIds: Array<string>): SortableFilterOptions<Service>;

	/**
	 *
	 *  Options for service filtering which match all services from shared directly (i.e. ignoring hierarchies) with the current data owner that exist in at
	 *  least a [SubContact] (from [Contact.subContacts]) where [SubContact.healthElementId] matches one of the provided
	 *  id.
	 *
	 *  These options are sortable. When sorting using these options the services will be sorted in the same order as the
	 *  input health element ids. If a service exists in multiple subcontacts only the first subcontact with matching
	 *  health element service is considered for the ordering.
	 *
	 *  @param healthElementIds a list of health element ids
	 */
	byHealthElementIdFromSubContactForSelf(healthElementIds: Array<string>): SortableFilterOptions<Service>;

	/**
	 *
	 *  Filter options that match all services with one of the provided ids.
	 *  These options are sortable. When sorting using these options the services will have the same order as the input ids.
	 *
	 *  @param ids a list of unique service ids.
	 *  @throws IllegalArgumentException if the provided [ids] list contains duplicate elements
	 */
	byIds(ids: Array<string>): BaseSortableFilterOptions<Service>;

	/**
	 *
	 *  Filter options that match all the services where in at least one of the maps in [Service.qualifiedLinks] values there is a key equal
	 *  to [associationId].
	 *
	 *  @param associationId the association id to search for.
	 */
	byAssociationId(associationId: string): BaseFilterOptions<Service>;

	/**
	 *
	 *  Filter options that match all the services where in the values of the maps that are in the values of [Service.qualifiedLinks] there
	 *  is a value contained in [linkValues].
	 *  If a [linkQualification] is provided, the search will be restricted to the map corresponding to the [linkQualification] key in
	 *  [Service.qualifiedLinks].
	 *
	 *  @param linkValues the values to search in the values of the maps that are values of [Service.qualifiedLinks].
	 *  @param linkQualification a key of [Service.qualifiedLinks].
	 */
	byQualifiedLink(linkValues: Array<string>,
			options?: { linkQualification?: LinkQualification | undefined }): BaseFilterOptions<Service>;

	/**
	 *
	 *  Options for service filtering which match all services shared directly (i.e. ignoring hierarchies) with a specific data owner
	 *  that are linked with one of the provided patients.
	 *  This Options also allows to restrict the services based on [Service.valueDate]:
	 *  - if the [from] fuzzy date is not null, only the services where [Service.valueDate] is greater than or equal to [from] will be returned.
	 *  - if the [to] fuzzy date is not null, only the services where [Service.valueDate] is less than or equal to [to] will be returned.
	 *  If the [Service.valueDate] is null for a specific service, [Service.openingDate] will be used instead.
	 *
	 *  When using these options the sdk will automatically extract the secret ids from the provided patients and use
	 *  those for filtering.
	 *  If you already have the secret ids of the patient you may instead use [byPatientSecretIdsDateForDataOwner].
	 *  If the current data owner does not have access to any secret id of one of the provide patients the patient will
	 *  simply be ignored.
	 *  Note that these may not be used in methods of apis from [CardinalBaseApis].
	 *
	 *  These options are sortable. When sorting using these options the services will be sorted by [Service.valueDate] in ascending or
	 *  descending order according to the value of the [descending] parameter.
	 *
	 *  @param dataOwnerId a data owner id
	 *  @param patients a list of patients.
	 *  @param from the minimum fuzzy date for [Service.valueDate], in the YYYYMMDDHHMMSS format (default: no limit).
	 *  @param to the maximum fuzzy date for [Service.valueDate], in the YYYYMMDDHHMMSS format (default: no limit).
	 *  @param descending whether to sort the result in descending or ascending order by [Service.valueDate] (default: ascending).
	 */
	byPatientsDateForDataOwner(dataOwnerId: string, patients: Array<Patient>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): SortableFilterOptions<Service>;

	/**
	 *
	 *  In group version of [byPatientsDateForDataOwner].
	 */
	byPatientsDateForDataOwnerInGroup(dataOwner: EntityReferenceInGroup, patients: Array<Patient>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): SortableFilterOptions<Service>;

	/**
	 *
	 *  Options for service filtering which match all services shared directly (i.e. ignoring hierarchies) with the current data owner
	 *  that are linked with one of the provided patients.
	 *  This Options also allows to restrict the services based on [Service.valueDate]:
	 *  - if the [from] fuzzy date is not null, only the services where [Service.valueDate] is greater than or equal to [from] will be returned.
	 *  - if the [to] fuzzy date is not null, only the services where [Service.valueDate] is less than or equal to [to] will be returned.
	 *  If the [Service.valueDate] is null for a specific service, [Service.openingDate] will be used instead.
	 *
	 *  When using these options the sdk will automatically extract the secret ids from the provided patients and use
	 *  those for filtering.
	 *  If you already have the secret ids of the patient you may instead use [byPatientSecretIdsDateForSelf].
	 *  If the current data owner does not have access to any secret id of one of the provide patients the patient will
	 *  simply be ignored.
	 *  Note that these may not be used in methods of apis from [CardinalBaseApis].
	 *
	 *  These options are sortable. When sorting using these options the services will be sorted by [Service.valueDate] in ascending or
	 *  descending order according to the value of the [descending] parameter.
	 *
	 *  @param patients a list of patients.
	 *  @param from the minimum fuzzy date for [Service.valueDate], in the YYYYMMDDHHMMSS format (default: no limit).
	 *  @param to the maximum fuzzy date for [Service.valueDate], in the YYYYMMDDHHMMSS format (default: no limit).
	 *  @param descending whether to sort the result in descending or ascending order by [Service.valueDate] (default: ascending).
	 */
	byPatientsDateForSelf(patients: Array<Patient>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): SortableFilterOptions<Service>;

	/**
	 *
	 *  Options for service filtering which match all services shared directly (i.e. ignoring hierarchies) with a specific data owner
	 *  that are linked with one of the provided patients through one of the provided secret ids.
	 *  This Options also allows to restrict the services based on [Service.valueDate]:
	 *  - if the [from] fuzzy date is not null, only the services where [Service.valueDate] is greater than or equal to [from] will be returned.
	 *  - if the [to] fuzzy date is not null, only the services where [Service.valueDate] is less than or equal to [to] will be returned.
	 *  If the [Service.valueDate] is null for a specific service, [Service.openingDate] will be used instead.
	 *
	 *  If the current data owner does not have access to any secret id of one of the provide patients the patient will
	 *  simply be ignored.
	 *
	 *  These options are sortable. When sorting using these options the services will be sorted by [Service.valueDate] in ascending or
	 *  descending order according to the value of the [descending] parameter.
	 *
	 *  @param dataOwnerId the id of a data owner.
	 *  @param secretIds a list of patient secret ids.
	 *  @param from the minimum fuzzy date for [Service.valueDate], in the YYYYMMDDHHMMSS format (default: no limit).
	 *  @param to the maximum fuzzy date for [Service.valueDate], in the YYYYMMDDHHMMSS format (default: no limit).
	 *  @param descending whether to sort the result in descending or ascending order by [Service.valueDate] (default: ascending).
	 */
	byPatientSecretIdsDateForDataOwner(dataOwnerId: string, secretIds: Array<string>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): BaseSortableFilterOptions<Service>;

	byPatientSecretIdsDateForDataOwnerInGroup(dataOwner: EntityReferenceInGroup,
			secretIds: Array<string>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): BaseSortableFilterOptions<Service>;

	/**
	 *
	 *  Options for service filtering which match all services shared directly (i.e. ignoring hierarchies) with the current data owner
	 *  that are linked with one of the provided patients through one of the provided secret ids.
	 *  This Options also allows to restrict the services based on [Service.valueDate]:
	 *  - if the [from] fuzzy date is not null, only the services where [Service.valueDate] is greater than or equal to [from] will be returned.
	 *  - if the [to] fuzzy date is not null, only the services where [Service.valueDate] is less than or equal to [to] will be returned.
	 *  If the [Service.valueDate] is null for a specific service, [Service.openingDate] will be used instead.
	 *
	 *  If the current data owner does not have access to any secret id of one of the provide patients the patient will
	 *  simply be ignored.
	 *  Note that these may not be used in methods of apis from [CardinalBaseApis].
	 *
	 *  These options are sortable. When sorting using these options the services will be sorted by [Service.valueDate] in ascending or
	 *  descending order according to the value of the [descending] parameter.
	 *
	 *  @param secretIds a list of patient secret ids.
	 *  @param from the minimum fuzzy date for [Service.valueDate], in the YYYYMMDDHHMMSS format (default: no limit).
	 *  @param to the maximum fuzzy date for [Service.valueDate], in the YYYYMMDDHHMMSS format (default: no limit).
	 *  @param descending whether to sort the result in descending or ascending order by [Service.valueDate] (default: ascending).
	 */
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
