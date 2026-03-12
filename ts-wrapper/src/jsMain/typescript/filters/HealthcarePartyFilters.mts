// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, InternalHealthcarePartyFiltersObj, SortableFilterOptions} from '../cardinal-sdk-ts.mjs';
import {HealthcareParty} from '../model/HealthcareParty.mjs';
import {Identifier} from '../model/base/Identifier.mjs';


interface HealthcarePartyFiltersFactory {

	/**
	 *
	 *  Filter options to match all healthcare parties.
	 *  These options are not sortable.
	 */
	all(): BaseFilterOptions<HealthcareParty>;

	/**
	 *
	 *  Options for healthcare party filtering which match all the healthcare parties that have at least
	 *  an identifier that has the same exact [Identifier.system] and [Identifier.value] as one of the provided
	 *  [identifiers]. Other properties of the provided identifiers are ignored.
	 *
	 *  These options are sortable. When sorting using these options the healthcare parties will be in the same order as
	 *  the input identifiers. In case an entity has multiple identifiers only the first matching identifier is considered
	 *  for the sorting.
	 *
	 *  @param identifiers a list of identifiers
	 */
	byIdentifiers(identifiers: Array<Identifier>): BaseFilterOptions<HealthcareParty>;

	/**
	 *
	 *  Options for healthcare party filtering which match all healthcare parties shared directly (i.e. ignoring hierarchies) with a specific data owner that have a certain code.
	 *  If you specify only the [codeType] you will get all entities that have at least a code of that type.
	 *
	 *  These options are sortable. When sorting using these options the healthcare parties will be sorted by [codeCode]
	 *
	 *  @param codeType a code type
	 *  @param codeCode a code for the provided code type, or null if you want the filter to accept any entity
	 *  with a code of the provided type.
	 */
	byCode(codeType: string,
			options?: { codeCode?: string | undefined }): BaseSortableFilterOptions<HealthcareParty>;

	/**
	 *
	 *  Options for healthcare party filtering which match all healthcare parties shared directly (i.e. ignoring hierarchies) with a specific data owner that have a certain tag.
	 *  If you specify only the [tagType] you will get all entities that have at least a tag of that type.
	 *
	 *  These options are sortable. When sorting using these options the healthcare parties will be sorted by [tagCode]
	 *
	 *  @param tagType a tag type
	 *  @param tagCode a code for the provided tag type, or null if you want the filter to accept any entity
	 *  with a tag of the provided type.
	 */
	byTag(tagType: string,
			options?: { tagCode?: string | undefined }): BaseSortableFilterOptions<HealthcareParty>;

	/**
	 *
	 *  Filter options that match all healthcare parties with one of the provided ids.
	 *  These options are sortable. When sorting using these options the healthcare parties will have the same order as the input ids.
	 *
	 *  @param ids a list of unique healthcare party ids.
	 *  @throws IllegalArgumentException if the provided [ids] list contains duplicate elements
	 */
	byIds(ids: Array<string>): SortableFilterOptions<HealthcareParty>;

	/**
	 *
	 *  Get all healthcare parties where the normalized last_name+first_name or speciality contain the provided
	 *  search string.
	 *
	 *  These options are sortable. When sorting using these options the healthcare parties will be sorted lexicographically
	 *  by the matching part of the last_name+first_name or speciality substring. If a healthcare party has multiple
	 *  matching substrings only the first will be returned.
	 *
	 *  @param searchString a string to search for.
	 *  @param descending when using these options to sort if true inverts the sorting order.
	 */
	byName(searchString: string,
			options?: { descending?: boolean }): BaseSortableFilterOptions<HealthcareParty>;

	/**
	 *
	 *  Get all the healthcare parties where [HealthcareParty.ssin]start with the provided [searchString].
	 *
	 *  These options are sortable. When sorting using these options, the healthcare parties will be sorted lexicographically by the
	 *  aforementioned identifiers. If multiple identifiers match the search string, only the first one will be considered.
	 *
	 *  @param searchString a string to search for.
	 *  @param descending whether to sort the results in descending or ascending order (default: ascending).
	 */
	byNationalIdentifier(searchString: string,
			options?: { descending?: boolean }): BaseSortableFilterOptions<HealthcareParty>;

	/**
	 *
	 *  Get all the healthcare parties where [HealthcareParty.parentId] is equal to [parentId].
	 *
	 *  @param parentId the healthcare party parent id.
	 */
	byParentId(parentId: string): BaseFilterOptions<HealthcareParty>;

}

export const HealthcarePartyFilters: HealthcarePartyFiltersFactory = {
			all: () => InternalHealthcarePartyFiltersObj.getInstance().all(),
			byIdentifiers: (identifiers) => InternalHealthcarePartyFiltersObj.getInstance().byIdentifiers(identifiers),
			byCode: (codeType, options) => InternalHealthcarePartyFiltersObj.getInstance().byCode(codeType, options),
			byTag: (tagType, options) => InternalHealthcarePartyFiltersObj.getInstance().byTag(tagType, options),
			byIds: (ids) => InternalHealthcarePartyFiltersObj.getInstance().byIds(ids),
			byName: (searchString, options) => InternalHealthcarePartyFiltersObj.getInstance().byName(searchString, options),
			byNationalIdentifier: (searchString, options) => InternalHealthcarePartyFiltersObj.getInstance().byNationalIdentifier(searchString, options),
			byParentId: (parentId) => InternalHealthcarePartyFiltersObj.getInstance().byParentId(parentId)
		};
