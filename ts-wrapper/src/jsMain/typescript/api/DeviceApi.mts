// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, FilterOptions, PaginatedListIterator} from '../cardinal-sdk-ts.mjs';
import {Device} from '../model/Device.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';
import {EntitySubscription} from '../subscription/EntitySubscription.mjs';
import {EntitySubscriptionConfiguration} from '../subscription/EntitySubscriptionConfiguration.mjs';
import {SubscriptionEventType} from '../subscription/SubscriptionEventType.mjs';
import {DeviceInGroupApi} from './DeviceInGroupApi.mjs';


export interface DeviceApi {

	inGroup: DeviceInGroupApi;

	getDevice(deviceId: string): Promise<Device | undefined>;

	getDevices(deviceIds: Array<string>): Promise<Array<Device>>;

	createDevice(device: Device): Promise<Device>;

	createDevices(devices: Array<Device>): Promise<Array<Device>>;

	modifyDevice(device: Device): Promise<Device>;

	modifyDevices(devices: Array<Device>): Promise<Array<Device>>;

	deleteDeviceById(entityId: string, rev: string): Promise<StoredDocumentIdentifier>;

	deleteDevicesByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<StoredDocumentIdentifier>>;

	deleteDevice(device: Device): Promise<StoredDocumentIdentifier>;

	deleteDevices(devices: Array<Device>): Promise<Array<StoredDocumentIdentifier>>;

	undeleteDeviceById(id: string, rev: string): Promise<Device>;

	undeleteDevicesByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<Device>>;

	undeleteDevice(device: Device): Promise<Device>;

	undeleteDevices(devices: Array<Device>): Promise<Array<Device>>;

	purgeDeviceById(id: string, rev: string): Promise<void>;

	purgeDevicesByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<StoredDocumentIdentifier>>;

	purgeDevice(device: Device): Promise<void>;

	purgeDevices(devices: Array<Device>): Promise<Array<StoredDocumentIdentifier>>;

	filterDevicesBy(filter: BaseFilterOptions<Device>): Promise<PaginatedListIterator<Device>>;

	filterDevicesBySorted(filter: BaseSortableFilterOptions<Device>): Promise<PaginatedListIterator<Device>>;

	matchDevicesBy(filter: BaseFilterOptions<Device>): Promise<Array<string>>;

	matchDevicesBySorted(filter: BaseSortableFilterOptions<Device>): Promise<Array<string>>;

	subscribeToEvents(events: Array<SubscriptionEventType>, filter: FilterOptions<Device>,
			options?: { subscriptionConfig?: EntitySubscriptionConfiguration | undefined }): Promise<EntitySubscription<Device>>;

}
