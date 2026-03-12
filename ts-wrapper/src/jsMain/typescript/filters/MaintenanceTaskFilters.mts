// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, FilterOptions, InternalMaintenanceTaskFiltersObj, SortableFilterOptions} from '../cardinal-sdk-ts.mjs';
import {MaintenanceTask} from '../model/MaintenanceTask.mjs';
import {Identifier} from '../model/base/Identifier.mjs';


interface MaintenanceTaskFiltersFactory {

	/**
	 *
	 *  Filter options that match all maintenance tasks with one of the provided ids.
	 *  These options are sortable. When sorting using these options the maintenance tasks will have the same order as the input ids.
	 *  @param ids a list of unique maintenance task ids.
	 *  @throws IllegalArgumentException if the provided [ids] list contains duplicate elements
	 */
	byIds(ids: Array<string>): BaseSortableFilterOptions<MaintenanceTask>;

	/**
	 *
	 *  Options for maintenance task filtering which match all the maintenance tasks shared directly (i.e. ignoring hierarchies) with a specific data owner that have at least
	 *  an identifier that has the same exact [Identifier.system] and [Identifier.value] as one of the provided
	 *  [identifiers]. Other properties of the provided identifiers are ignored.
	 *
	 *  These options are sortable. When sorting using these options the maintenance tasks will be in the same order as the input
	 *  identifiers. In case an entity has multiple identifiers only the first matching identifier is considered for the
	 *  sorting.
	 *  @param dataOwnerId a data owner id
	 *  @param identifiers a list of identifiers
	 *  @return options for maintenance task filtering
	 */
	byIdentifiersForDataOwner(dataOwnerId: string,
			identifiers: Array<Identifier>): BaseSortableFilterOptions<MaintenanceTask>;

	/**
	 *
	 *  Options for maintenance task filtering which match all the maintenance tasks shared directly (i.e. ignoring hierarchies) with the current data owner that have at least
	 *  an identifier that has the same exact [Identifier.system] and [Identifier.value] as one of the provided
	 *  [identifiers]. Other properties of the provided identifiers are ignored.
	 *
	 *  These options are sortable. When sorting using these options the maintenance tasks will be in the same order as the input
	 *  identifiers. In case an entity has multiple identifiers only the first matching identifier is considered for the
	 *  sorting.
	 *  @param identifiers a list of identifiers
	 *  @return options for maintenance task filtering
	 */
	byIdentifiersForSelf(identifiers: Array<Identifier>): SortableFilterOptions<MaintenanceTask>;

	/**
	 *
	 *  Options for maintenance task filtering which match all the maintenance tasks shared directly (i.e. ignoring hierarchies) with a specific data owner
	 *  that have the provided type.
	 *
	 *  @param type a maintenance task type
	 *  @param dataOwnerId a data owner id
	 */
	byTypeForDataOwner(dataOwnerId: string, type: string): BaseFilterOptions<MaintenanceTask>;

	/**
	 *
	 *  Options for maintenance task filtering which match all the maintenance tasks shared directly (i.e. ignoring hierarchies) with the current data owner
	 *  that have the provided type.
	 *
	 *  @param type a maintenance task type
	 */
	byTypeForSelf(type: string): FilterOptions<MaintenanceTask>;

	/**
	 *
	 *  Options for maintenance task filtering which match all the maintenance tasks shared directly (i.e. ignoring hierarchies) with a specific data owner
	 *  that have a [MaintenanceTask.created] after the provided date.
	 *
	 *  These options are sortable. When sorting using these options the maintenance tasks will be ordered by their
	 *  [MaintenanceTask.created].
	 *
	 *  @param dataOwnerId a data owner id
	 *  @param date a unix timestamp
	 */
	afterDateForDataOwner(dataOwnerId: string,
			date: number): BaseSortableFilterOptions<MaintenanceTask>;

	/**
	 *
	 *  Options for maintenance task filtering which match all the maintenance tasks shared directly (i.e. ignoring hierarchies) with the current data owner
	 *  that have a [MaintenanceTask.created] after the provided date.
	 *
	 *  These options are sortable. When sorting using these options the maintenance tasks will be ordered by their
	 *  [MaintenanceTask.created].
	 *
	 *  @param date a unix timestamp
	 */
	afterDateForSelf(date: number): SortableFilterOptions<MaintenanceTask>;

}

export const MaintenanceTaskFilters: MaintenanceTaskFiltersFactory = {
			byIds: (ids) => InternalMaintenanceTaskFiltersObj.getInstance().byIds(ids),
			byIdentifiersForDataOwner: (dataOwnerId, identifiers) => InternalMaintenanceTaskFiltersObj.getInstance().byIdentifiersForDataOwner(dataOwnerId, identifiers),
			byIdentifiersForSelf: (identifiers) => InternalMaintenanceTaskFiltersObj.getInstance().byIdentifiersForSelf(identifiers),
			byTypeForDataOwner: (dataOwnerId, type) => InternalMaintenanceTaskFiltersObj.getInstance().byTypeForDataOwner(dataOwnerId, type),
			byTypeForSelf: (type) => InternalMaintenanceTaskFiltersObj.getInstance().byTypeForSelf(type),
			afterDateForDataOwner: (dataOwnerId, date) => InternalMaintenanceTaskFiltersObj.getInstance().afterDateForDataOwner(dataOwnerId, date),
			afterDateForSelf: (date) => InternalMaintenanceTaskFiltersObj.getInstance().afterDateForSelf(date)
		};
