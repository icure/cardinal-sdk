// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, InternalDeviceFiltersObj} from '../cardinal-sdk-ts.mjs';
import {Device} from '../model/Device.mjs';
import {EntityReferenceInGroup} from '../model/EntityReferenceInGroup.mjs';


interface DeviceFiltersFactory {

	/**
	 *
	 *  Filter options to match all devices.
	 *  These options are not sortable.
	 */
	all(): BaseFilterOptions<Device>;

	/**
	 *
	 *  Filter options to match all devices where the [Device.responsible] is the provided [responsibleId]
	 *
	 *  @param responsibleId the id of the responsible
	 */
	byResponsible(responsibleId: string): BaseFilterOptions<Device>;

	byResponsibleInGroup(responsible: EntityReferenceInGroup): BaseFilterOptions<Device>;

	/**
	 *
	 *  Filter options that match all devices with one of the provided ids.
	 *  These options are sortable. When sorting using these options the devices will have the same order as the input ids.
	 *
	 *  @param ids a list of unique device ids.
	 *  @throws IllegalArgumentException if the provided [ids] list contains duplicate elements
	 */
	byIds(ids: Array<string>): BaseSortableFilterOptions<Device>;

}

export const DeviceFilters: DeviceFiltersFactory = {
			all: () => InternalDeviceFiltersObj.getInstance().all(),
			byResponsible: (responsibleId) => InternalDeviceFiltersObj.getInstance().byResponsible(responsibleId),
			byResponsibleInGroup: (responsible) => InternalDeviceFiltersObj.getInstance().byResponsibleInGroup(responsible),
			byIds: (ids) => InternalDeviceFiltersObj.getInstance().byIds(ids)
		};
