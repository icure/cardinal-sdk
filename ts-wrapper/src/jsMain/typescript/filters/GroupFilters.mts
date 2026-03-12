// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, InternalGroupFiltersObj} from '../cardinal-sdk-ts.mjs';
import {Group} from '../model/Group.mjs';


interface GroupFiltersFactory {

	/**
	 *
	 *  Filter options to match all agendas.
	 *  These options are not sortable.
	 */
	all(): BaseFilterOptions<Group>;

	/**
	 *
	 *  Options for group filtering that returns all the groups where [Group.superGroup] is equal to [superGroupId].
	 *
	 *  @param superGroupId the id of the super group.
	 */
	bySuperGroup(superGroupId: string): BaseFilterOptions<Group>;

	/**
	 *
	 *  Options for group filtering that returns all the groups where [Group.superGroup] is equal to [superGroupId] and one or more of the
	 *  following is true:
	 *  - [Group.id] starts with the provided [searchString].
	 *  - [Group.name] starts with the provided [searchString].
	 *  - In [Group.properties] there is at least one property where the identifier in the property type starts with [searchString] or where
	 *    property string value starts with [searchString].
	 *  If a group matches for more than one option, only the first will be considered.
	 *
	 *  These options are sortable. When sorting using these options the groups will be sorted lexicographically by the aforementioned
	 *  properties.
	 *
	 *  @param superGroupId the id of the super group.
	 *  @param searchString the query to search in the group id, name, or properties.
	 */
	withContent(superGroupId: string, searchString: string): BaseSortableFilterOptions<Group>;

}

export const GroupFilters: GroupFiltersFactory = {
			all: () => InternalGroupFiltersObj.getInstance().all(),
			bySuperGroup: (superGroupId) => InternalGroupFiltersObj.getInstance().bySuperGroup(superGroupId),
			withContent: (superGroupId, searchString) => InternalGroupFiltersObj.getInstance().withContent(superGroupId, searchString)
		};
