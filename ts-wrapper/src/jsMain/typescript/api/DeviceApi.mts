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

	/**
	 *
	 *  Deletes a device. If you don't have write access to the device the method will fail.
	 *  @param entityId id of the device.
	 *  @param rev the latest known rev of the device to delete
	 *  @return the id and revision of the deleted device.
	 *  @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	deleteDeviceById(entityId: string, rev: string): Promise<StoredDocumentIdentifier>;

	/**
	 *
	 *  Deletes many devices. Ids that do not correspond to an entity, or that correspond to an entity for which
	 *  you don't have write access will be ignored.
	 *  @param entityIds ids and revisions of the devices to delete.
	 *  @return the id and revision of the deleted devices. If some entities could not be deleted (for example
	 *  because you had no write access to them) they will not be included in this list.
	 */
	deleteDevicesByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<StoredDocumentIdentifier>>;

	deleteDevice(device: Device): Promise<StoredDocumentIdentifier>;

	deleteDevices(devices: Array<Device>): Promise<Array<StoredDocumentIdentifier>>;

	/**
	 *
	 *  Restores a device that was marked as deleted.
	 *  @param id the id of the entity
	 *  @param rev the latest revision of the entity.
	 *  @return the restored entity.
	 *  @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	undeleteDeviceById(id: string, rev: string): Promise<Device>;

	undeleteDevicesByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<Device>>;

	undeleteDevice(device: Device): Promise<Device>;

	undeleteDevices(devices: Array<Device>): Promise<Array<Device>>;

	/**
	 *
	 *  Permanently deletes a device.
	 *  @param id id of the device to purge
	 *  @param rev latest revision of the device
	 *  @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	purgeDeviceById(id: string, rev: string): Promise<void>;

	purgeDevicesByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<StoredDocumentIdentifier>>;

	purgeDevice(device: Device): Promise<void>;

	purgeDevices(devices: Array<Device>): Promise<Array<StoredDocumentIdentifier>>;

	filterDevicesBy(filter: BaseFilterOptions<Device>): Promise<PaginatedListIterator<Device>>;

	filterDevicesBySorted(filter: BaseSortableFilterOptions<Device>): Promise<PaginatedListIterator<Device>>;

	matchDevicesBy(filter: BaseFilterOptions<Device>): Promise<Array<string>>;

	matchDevicesBySorted(filter: BaseSortableFilterOptions<Device>): Promise<Array<string>>;

	/**
	 *
	 *  Subscribe to receive real-time notifications when an entity is updated.
	 *
	 *  # Access control
	 *
	 *  The subscription will only receive notifications about entities that the SDK user can access; currently this
	 *  validation varies slightly from standard read methods.
	 *
	 *  ## Encryptable entities
	 *
	 *  Applies the same access control rules as the standard read methods; depending on the permissions of the user the
	 *  entity might need to have a direct delegation to the user, or to a parent, or if the user has the permission to
	 *  read any entity of the type regardless of delegations then all notification of entities (matching the filter)
	 *  will be received.
	 *
	 *  ## Healthcare party
	 *
	 *  Currently, regardless of user permissions, only notifications about healthcare parties that have the current SDK
	 *  data owner as a DIRECT link will be returned.
	 *
	 *  This behaviour is not in line with current Cardinal SDK ideology and is subject to change in future versions.
	 *
	 *  @param events the type of events that will be notified to the subscription
	 *  @param filter the subscription will receive notifications only for entities matching this filter, you should
	 *  make the filter as restrictive as possible.
	 *  @param subscriptionConfig customize the configuration for the subscription
	 *  @return a subscription that receives notifications for the configured events.
	 */
	subscribeToEvents(events: Array<SubscriptionEventType>, filter: FilterOptions<Device>,
			options?: { subscriptionConfig?: EntitySubscriptionConfiguration | undefined }): Promise<EntitySubscription<Device>>;

}
