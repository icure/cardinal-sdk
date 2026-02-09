// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, InternalDeviceFiltersObj} from '../cardinal-sdk-ts.mjs';
import {Device} from '../model/Device.mjs';
import {EntityReferenceInGroup} from '../model/EntityReferenceInGroup.mjs';


interface DeviceFiltersFactory {

	all(): BaseFilterOptions<Device>;

	byResponsible(responsibleId: string): BaseFilterOptions<Device>;

	byResponsibleInGroup(responsible: EntityReferenceInGroup): BaseFilterOptions<Device>;

	byIds(ids: Array<string>): BaseSortableFilterOptions<Device>;

}

export const DeviceFilters: DeviceFiltersFactory = {
			all: () => InternalDeviceFiltersObj.getInstance().all(),
			byResponsible: (responsibleId) => InternalDeviceFiltersObj.getInstance().byResponsible(responsibleId),
			byResponsibleInGroup: (responsible) => InternalDeviceFiltersObj.getInstance().byResponsibleInGroup(responsible),
			byIds: (ids) => InternalDeviceFiltersObj.getInstance().byIds(ids)
		};
