// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, FilterOptions, InternalRelatedPersonFiltersObj} from '../cardinal-sdk-ts.mjs';
import {EntityReferenceInGroup} from '../model/EntityReferenceInGroup.mjs';
import {RelatedPerson} from '../model/RelatedPerson.mjs';
import {Identifier} from '../model/base/Identifier.mjs';


interface RelatedPersonFiltersFactory {

	/**
	 *
	 *  Create options for related person filtering that will match all related persons shared directly (i.e. ignoring
	 *  hierarchies) with a specific data owner.
	 *
	 *  @param dataOwnerId a data owner id
	 *  @return options for related person filtering
	 */
	allRelatedPersonsForDataOwner(dataOwnerId: string): BaseFilterOptions<RelatedPerson>;

	/**
	 *
	 *  In group version of [allRelatedPersonsForDataOwner].
	 */
	allRelatedPersonsForDataOwnerInGroup(dataOwner: EntityReferenceInGroup): BaseFilterOptions<RelatedPerson>;

	/**
	 *
	 *  Create options for related person filtering that will match all related persons shared directly (i.e. ignoring
	 *  hierarchies) with the current data owner.
	 *
	 *  @return options for related person filtering
	 */
	allRelatedPersonsForSelf(): FilterOptions<RelatedPerson>;

	/**
	 *
	 *  Options for related person filtering which match all the related persons shared directly (i.e. ignoring
	 *  hierarchies) with a specific data owner that have at least an identifier that has the same exact
	 *  [Identifier.system] and [Identifier.value] as one of the provided [identifiers]. Other properties of the provided
	 *  identifiers are ignored.
	 *
	 *  @param dataOwnerId a data owner id
	 *  @param identifiers a list of identifiers
	 *  @return options for related person filtering
	 */
	byIdentifiersForDataOwner(dataOwnerId: string,
			identifiers: Array<Identifier>): BaseFilterOptions<RelatedPerson>;

	/**
	 *
	 *  In group version of [byIdentifiersForDataOwner].
	 */
	byIdentifiersForDataOwnerInGroup(dataOwner: EntityReferenceInGroup,
			identifiers: Array<Identifier>): BaseFilterOptions<RelatedPerson>;

	/**
	 *
	 *  Options for related person filtering which match all the related persons shared directly (i.e. ignoring
	 *  hierarchies) with the current data owner that have at least an identifier that has the same exact
	 *  [Identifier.system] and [Identifier.value] as one of the provided [identifiers]. Other properties of the provided
	 *  identifiers are ignored.
	 *
	 *  @param identifiers a list of identifiers
	 *  @return options for related person filtering
	 */
	byIdentifiersForSelf(identifiers: Array<Identifier>): FilterOptions<RelatedPerson>;

	/**
	 *
	 *  Options for related person filtering which match all the related persons shared directly (i.e. ignoring
	 *  hierarchies) with a specific data owner where the concatenation of [RelatedPerson.lastName] and
	 *  [RelatedPerson.firstName] contains the provided (sanitized) [name].
	 *
	 *  @param dataOwnerId a data owner id
	 *  @param name the name to search
	 *  @return options for related person filtering
	 */
	byNameForDataOwner(dataOwnerId: string, name: string): BaseFilterOptions<RelatedPerson>;

	/**
	 *
	 *  In group version of [byNameForDataOwner].
	 */
	byNameForDataOwnerInGroup(dataOwner: EntityReferenceInGroup,
			name: string): BaseFilterOptions<RelatedPerson>;

	/**
	 *
	 *  Options for related person filtering which match all the related persons shared directly (i.e. ignoring
	 *  hierarchies) with the current data owner where the concatenation of [RelatedPerson.lastName] and
	 *  [RelatedPerson.firstName] contains the provided (sanitized) [name].
	 *
	 *  @param name the name to search
	 *  @return options for related person filtering
	 */
	byNameForSelf(name: string): FilterOptions<RelatedPerson>;

	/**
	 *
	 *  Filter options that match all related persons with one of the provided ids.
	 *  These options are sortable. When sorting using these options the related persons will have the same order as the
	 *  input ids.
	 *
	 *  @param ids a list of unique related person ids.
	 *  @throws IllegalArgumentException if the provided [ids] list contains duplicate elements
	 */
	byIds(ids: Array<string>): BaseSortableFilterOptions<RelatedPerson>;

}

export const RelatedPersonFilters: RelatedPersonFiltersFactory = {
			allRelatedPersonsForDataOwner: (dataOwnerId) => InternalRelatedPersonFiltersObj.getInstance().allRelatedPersonsForDataOwner(dataOwnerId),
			allRelatedPersonsForDataOwnerInGroup: (dataOwner) => InternalRelatedPersonFiltersObj.getInstance().allRelatedPersonsForDataOwnerInGroup(dataOwner),
			allRelatedPersonsForSelf: () => InternalRelatedPersonFiltersObj.getInstance().allRelatedPersonsForSelf(),
			byIdentifiersForDataOwner: (dataOwnerId, identifiers) => InternalRelatedPersonFiltersObj.getInstance().byIdentifiersForDataOwner(dataOwnerId, identifiers),
			byIdentifiersForDataOwnerInGroup: (dataOwner, identifiers) => InternalRelatedPersonFiltersObj.getInstance().byIdentifiersForDataOwnerInGroup(dataOwner, identifiers),
			byIdentifiersForSelf: (identifiers) => InternalRelatedPersonFiltersObj.getInstance().byIdentifiersForSelf(identifiers),
			byNameForDataOwner: (dataOwnerId, name) => InternalRelatedPersonFiltersObj.getInstance().byNameForDataOwner(dataOwnerId, name),
			byNameForDataOwnerInGroup: (dataOwner, name) => InternalRelatedPersonFiltersObj.getInstance().byNameForDataOwnerInGroup(dataOwner, name),
			byNameForSelf: (name) => InternalRelatedPersonFiltersObj.getInstance().byNameForSelf(name),
			byIds: (ids) => InternalRelatedPersonFiltersObj.getInstance().byIds(ids)
		};
