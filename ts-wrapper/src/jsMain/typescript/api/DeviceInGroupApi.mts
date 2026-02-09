// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, PaginatedListIterator} from '../cardinal-sdk-ts.mjs';
import {Device} from '../model/Device.mjs';
import {GroupScoped} from '../model/GroupScoped.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';


export interface DeviceInGroupApi {

	createDevice(device: GroupScoped<Device>): Promise<GroupScoped<Device>>;

	createDevices(devices: Array<GroupScoped<Device>>): Promise<Array<GroupScoped<Device>>>;

	getDevice(groupId: string, deviceId: string): Promise<GroupScoped<Device> | undefined>;

	getDevices(groupId: string, devicesIds: Array<string>): Promise<Array<GroupScoped<Device>>>;

	modifyDevice(device: GroupScoped<Device>): Promise<GroupScoped<Device>>;

	modifyDevices(devices: Array<GroupScoped<Device>>): Promise<Array<GroupScoped<Device>>>;

	deleteDeviceById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<StoredDocumentIdentifier>>;

	deleteDeviceByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	deleteDevice(device: GroupScoped<Device>): Promise<GroupScoped<StoredDocumentIdentifier>>;

	deleteDevices(devices: Array<GroupScoped<Device>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	undeleteDeviceById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<Device>>;

	undeleteDeviceByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<Device>>>;

	undeleteDevice(device: GroupScoped<Device>): Promise<GroupScoped<Device>>;

	undeleteDevices(devices: Array<GroupScoped<Device>>): Promise<Array<GroupScoped<Device>>>;

	purgeDeviceById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<void>;

	purgeDeviceByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	purgeDevice(device: GroupScoped<Device>): Promise<void>;

	purgeDevices(devices: Array<GroupScoped<Device>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	filterDevicesBy(groupId: string,
			filter: BaseFilterOptions<Device>): Promise<PaginatedListIterator<GroupScoped<Device>>>;

	filterDevicesBySorted(groupId: string,
			filter: BaseSortableFilterOptions<Device>): Promise<PaginatedListIterator<GroupScoped<Device>>>;

	matchDevicesBy(groupId: string, filter: BaseFilterOptions<Device>): Promise<Array<string>>;

	matchDevicesBySorted(groupId: string,
			filter: BaseSortableFilterOptions<Device>): Promise<Array<string>>;

}
