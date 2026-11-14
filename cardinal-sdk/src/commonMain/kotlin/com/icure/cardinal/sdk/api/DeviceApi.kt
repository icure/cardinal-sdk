package com.icure.cardinal.sdk.api

import com.icure.cardinal.sdk.exceptions.RevisionConflictException
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.model.Device
import com.icure.cardinal.sdk.model.GroupScoped
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
import com.icure.cardinal.sdk.model.conflicts.ConflictResolutionRequest
import com.icure.cardinal.sdk.model.conflicts.ConflictResolutionResult
import com.icure.cardinal.sdk.model.conflicts.ConflictResolutionStrategy
import com.icure.cardinal.sdk.model.conflicts.MergeResult
import com.icure.cardinal.sdk.model.toStoredDocumentIdentifier
import com.icure.cardinal.sdk.subscription.Subscribable
import com.icure.cardinal.sdk.utils.DefaultValue
import com.icure.cardinal.sdk.utils.pagination.PaginatedListIterator

interface DeviceApi: Subscribable<Device, Device, FilterOptions<Device>> {

	val inGroup: DeviceInGroupApi

	suspend fun getDevice(deviceId: String): Device?
	suspend fun getDevices(deviceIds: List<String>): List<Device>

	suspend fun createDevice(device: Device): Device
	suspend fun createDevices(devices: List<Device>): List<Device>

	suspend fun modifyDevice(device: Device): Device
	suspend fun modifyDevices(devices: List<Device>): List<Device>

	/**
	 * Deletes a device. If you don't have write access to the device the method will fail.
	 * @param entityId id of the device.
	 * @param rev the latest known rev of the device to delete
	 * @return the id and revision of the deleted device.
	 * @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	suspend fun deleteDeviceById(entityId: String, rev: String): StoredDocumentIdentifier

	/**
	 * Deletes many devices. Ids that do not correspond to an entity, or that correspond to an entity for which
	 * you don't have write access will be ignored.
	 * @param entityIds ids and revisions of the devices to delete.
	 * @return the id and revision of the deleted devices. If some entities could not be deleted (for example
	 * because you had no write access to them) they will not be included in this list.
	 */
	suspend fun deleteDevicesByIds(entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier>

	suspend fun deleteDevice(device: Device): StoredDocumentIdentifier =
		deleteDeviceById(device.id, checkNotNull(device.rev) { "Cannot delete a device with a null revision." })
	suspend fun deleteDevices(devices: List<Device>): List<StoredDocumentIdentifier> =
		deleteDevicesByIds(devices.map { it.toStoredDocumentIdentifier() })

	/**
	 * Restores a device that was marked as deleted.
	 * @param id the id of the entity
	 * @param rev the latest revision of the entity.
	 * @return the restored entity.
	 * @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	suspend fun undeleteDeviceById(id: String, rev: String): Device
	suspend fun undeleteDevicesByIds(entityIds: List<StoredDocumentIdentifier>): List<Device>

	suspend fun undeleteDevice(device: Device): Device =
		undeleteDeviceById(device.id, checkNotNull(device.rev) { "Cannot undelete a device with a null revision." })
	suspend fun undeleteDevices(devices: List<Device>): List<Device> =
		undeleteDevicesByIds(devices.map { it.toStoredDocumentIdentifier() })

	/**
	 * Permanently deletes a device.
	 * @param id id of the device to purge
	 * @param rev latest revision of the device
	 * @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	suspend fun purgeDeviceById(id: String, rev: String)
	suspend fun purgeDevicesByIds(entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier>

	suspend fun purgeDevice(device: Device) =
		purgeDeviceById(device.id, checkNotNull(device.rev) { "Cannot purge a device with a null revision." })
	suspend fun purgeDevices(devices: List<Device>): List<StoredDocumentIdentifier> =
		purgeDevicesByIds(devices.map { it.toStoredDocumentIdentifier() })

	suspend fun filterDevicesBy(
		filter: BaseFilterOptions<Device>
	): PaginatedListIterator<Device>

	suspend fun filterDevicesBySorted(
		filter: BaseSortableFilterOptions<Device>
	): PaginatedListIterator<Device>

	suspend fun matchDevicesBy(filter: BaseFilterOptions<Device>): List<String>
	suspend fun matchDevicesBySorted(filter: BaseSortableFilterOptions<Device>): List<String>

	/**
	 * Get the ids of all the devices that have conflicting revisions.
	 * Requires the permission to manually resolve conflicts.
	 * @return the ids of the devices with conflicts.
	 */
	suspend fun getConflictingEntitiesIds(): List<String>

	/**
	 * Get the conflicting revisions of a device.
	 * Requires read access to all the conflicting revisions of the device.
	 * If the device has too many conflicts, only part of them are returned.
	 * @param entityId the id of a device with conflicts, for example obtained through [getConflictingEntitiesIds].
	 * @return the conflicting revisions of the device.
	 */
	suspend fun getConflictsForEntity(entityId: String): List<Device>

	/**
	 * Resolves the conflicts of a device by declaring the version that should be kept and the conflicting revisions that
	 * should be purged.
	 * Requires the permission to manually resolve conflicts and write access to all the conflicting revisions of the device.
	 * @param request the device to keep and the conflicting revisions to purge.
	 * @return the updated device and the revisions that are still in conflict.
	 */
	suspend fun declareConflictWinner(request: ConflictResolutionRequest<Device>): ConflictResolutionResult<Device>

	/**
	 * Automatically resolves the conflicts of the devices with the provided ids.
	 * Requires the permission to automatically resolve conflicts.
	 * @param entityIds ids of devices with conflicts, for example obtained through [getConflictingEntitiesIds].
	 * @param strategy the strategy to use to resolve the conflicts. If null the backend uses its default strategy.
	 * @return the outcome of the conflict resolution for each device.
	 */
	suspend fun autoSolveConflicts(
		entityIds: List<String>,
		@DefaultValue("null")
		strategy: ConflictResolutionStrategy? = null,
	): List<MergeResult>
}

interface DeviceInGroupApi {

	suspend fun createDevice(device: GroupScoped<Device>): GroupScoped<Device>
	suspend fun createDevices(devices: List<GroupScoped<Device>>): List<GroupScoped<Device>>

	suspend fun getDevice(groupId: String, deviceId: String): GroupScoped<Device>?
	suspend fun getDevices(groupId: String, devicesIds: List<String>): List<GroupScoped<Device>>

	suspend fun modifyDevice(device: GroupScoped<Device>): GroupScoped<Device>
	suspend fun modifyDevices(devices: List<GroupScoped<Device>>): List<GroupScoped<Device>>

	suspend fun deleteDeviceById(entityId: GroupScoped<StoredDocumentIdentifier>): GroupScoped<StoredDocumentIdentifier>
	suspend fun deleteDeviceByIds(entityIds: List<GroupScoped<StoredDocumentIdentifier>>): List<GroupScoped<StoredDocumentIdentifier>>

	suspend fun deleteDevice(device: GroupScoped<Device>): GroupScoped<StoredDocumentIdentifier> =
		deleteDeviceById(device.toStoredDocumentIdentifier())
	suspend fun deleteDevices(devices: List<GroupScoped<Device>>): List<GroupScoped<StoredDocumentIdentifier>> =
		deleteDeviceByIds(devices.map { it.toStoredDocumentIdentifier() })

	suspend fun undeleteDeviceById(entityId: GroupScoped<StoredDocumentIdentifier>): GroupScoped<Device>
	suspend fun undeleteDeviceByIds(entityIds: List<GroupScoped<StoredDocumentIdentifier>>): List<GroupScoped<Device>>

	suspend fun undeleteDevice(device: GroupScoped<Device>): GroupScoped<Device> =
		undeleteDeviceById(device.toStoredDocumentIdentifier())
	suspend fun undeleteDevices(devices: List<GroupScoped<Device>>): List<GroupScoped<Device>> =
		undeleteDeviceByIds(devices.map { it.toStoredDocumentIdentifier() })

	suspend fun purgeDeviceById(entityId: GroupScoped<StoredDocumentIdentifier>)
	suspend fun purgeDeviceByIds(entityIds: List<GroupScoped<StoredDocumentIdentifier>>): List<GroupScoped<StoredDocumentIdentifier>>

	suspend fun purgeDevice(device: GroupScoped<Device>) {
		purgeDeviceById(device.toStoredDocumentIdentifier())
	}
	suspend fun purgeDevices(devices: List<GroupScoped<Device>>): List<GroupScoped<StoredDocumentIdentifier>> =
		purgeDeviceByIds(devices.map { it.toStoredDocumentIdentifier() })

	suspend fun filterDevicesBy(
		groupId: String,
		filter: BaseFilterOptions<Device>
	): PaginatedListIterator<GroupScoped<Device>>

	suspend fun filterDevicesBySorted(
		groupId: String,
		filter: BaseSortableFilterOptions<Device>
	): PaginatedListIterator<GroupScoped<Device>>

	suspend fun matchDevicesBy(groupId: String, filter: BaseFilterOptions<Device>): List<String>
	suspend fun matchDevicesBySorted(groupId: String, filter: BaseSortableFilterOptions<Device>): List<String>

	/**
	 * In-group version of [DeviceApi.getConflictingEntitiesIds].
	 */
	suspend fun getConflictingEntitiesIds(groupId: String): List<String>

	/**
	 * In-group version of [DeviceApi.getConflictsForEntity].
	 */
	suspend fun getConflictsForEntity(groupId: String, entityId: String): List<GroupScoped<Device>>

	/**
	 * In-group version of [DeviceApi.declareConflictWinner].
	 */
	suspend fun declareConflictWinner(groupId: String, request: ConflictResolutionRequest<Device>): ConflictResolutionResult<Device>

	/**
	 * In-group version of [DeviceApi.autoSolveConflicts].
	 */
	suspend fun autoSolveConflicts(
		groupId: String,
		entityIds: List<String>,
		@DefaultValue("null")
		strategy: ConflictResolutionStrategy? = null,
	): List<MergeResult>
}
