// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, InternalInsuranceFiltersObj} from '../cardinal-sdk-ts.mjs';
import {Insurance} from '../model/Insurance.mjs';
import {Identifier} from '../model/base/Identifier.mjs';


interface InsuranceFiltersFactory {

	/**
	 *
	 *  Filter options to match all insurances.
	 *  These options are not sortable.
	 */
	all(): BaseFilterOptions<Insurance>;

	/**
	 *
	 *  Options for insurance filtering which match all the insurances that have at least
	 *  an identifier that has the same exact [Identifier.system] and [Identifier.value] as one of the provided
	 *  [identifiers]. Other properties of the provided identifiers are ignored.
	 *
	 *  These options are sortable. When sorting using these options the insurances will be in the same order as
	 *  the input identifiers. In case an entity has multiple identifiers only the first matching identifier is considered
	 *  for the sorting.
	 *
	 *  @param identifiers a list of identifiers
	 */
	byIdentifiers(identifiers: Array<Identifier>): BaseFilterOptions<Insurance>;

	/**
	 *
	 *  Options for insurance filtering which match all insurances shared directly (i.e. ignoring hierarchies) ƒthat have a certain code.
	 *  If you specify only the [codeType] you will get all entities that have at least a code of that type.
	 *
	 *  These options are sortable. When sorting using these options the insurances will be sorted by [codeCode]
	 *
	 *  @param codeType a code type
	 *  @param codeCode a code for the provided code type, or null if you want the filter to accept any entity
	 *  with a code of the provided type.
	 */
	byCode(codeType: string,
			options?: { codeCode?: string | undefined }): BaseSortableFilterOptions<Insurance>;

	/**
	 *
	 *  Options for insurance filtering which match all insurances shared directly (i.e. ignoring hierarchies) that have a certain tag.
	 *  If you specify only the [tagType] you will get all entities that have at least a tag of that type.
	 *
	 *  These options are sortable. When sorting using these options the insurances will be sorted by [tagCode]
	 *
	 *  @param tagType a tag type
	 *  @param tagCode a code for the provided tag type, or null if you want the filter to accept any entity
	 *  with a tag of the provided type.
	 */
	byTag(tagType: string,
			options?: { tagCode?: string | undefined }): BaseSortableFilterOptions<Insurance>;

}

export const InsuranceFilters: InsuranceFiltersFactory = {
			all: () => InternalInsuranceFiltersObj.getInstance().all(),
			byIdentifiers: (identifiers) => InternalInsuranceFiltersObj.getInstance().byIdentifiers(identifiers),
			byCode: (codeType, options) => InternalInsuranceFiltersObj.getInstance().byCode(codeType, options),
			byTag: (tagType, options) => InternalInsuranceFiltersObj.getInstance().byTag(tagType, options)
		};
