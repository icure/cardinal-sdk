package com.icure.cardinal.sdk.api.impl

import com.icure.cardinal.sdk.api.DeviceApi
import com.icure.cardinal.sdk.api.DeviceInGroupApi
import com.icure.cardinal.sdk.api.raw.RawDeviceApi
import com.icure.cardinal.sdk.api.raw.successBodyOrNull404
import com.icure.cardinal.sdk.api.raw.successBodyOrThrowRevisionConflict
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.mapDeviceFilterOptions
import com.icure.cardinal.sdk.model.Device
import com.icure.cardinal.sdk.model.GroupScoped
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.options.BasicApiConfiguration
import com.icure.cardinal.sdk.serialization.DeviceAbstractFilterSerializer
import com.icure.cardinal.sdk.serialization.SubscriptionSerializer
import com.icure.cardinal.sdk.subscription.EntitySubscription
import com.icure.cardinal.sdk.subscription.EntitySubscriptionConfiguration
import com.icure.cardinal.sdk.subscription.SubscriptionEventType
import com.icure.cardinal.sdk.subscription.WebSocketSubscription
import com.icure.cardinal.sdk.utils.Serialization
import com.icure.cardinal.sdk.model.ListOfIdsAndRev
import com.icure.cardinal.sdk.model.toStoredDocumentIdentifier
import com.icure.cardinal.sdk.utils.pagination.IdsPageIterator
import com.icure.utils.InternalIcureApi

@OptIn(InternalIcureApi::class)
internal abstract class AbstractDeviceApi(
	private val rawApi: RawDeviceApi,
	protected val config: BasicApiConfiguration,
) {

	protected suspend fun doCreateDevice(groupId: String?, entity: Device): Device {
		basicRequireIsValidForCreation(entity)
		return if (groupId == null) {
			rawApi.createDevice(entity)
		} else {
			rawApi.createDeviceInGroup(groupId, entity)
		}.successBody()
	}

	protected suspend fun doCreateDevices(groupId: String?, entities: List<Device>): List<Device> =
		skipRequestOnNullList(entities) { calendarItemTypes ->
			if (groupId == null) {
				rawApi.createDevices(calendarItemTypes)
			} else {
				rawApi.createDevicesInGroup(groupId, calendarItemTypes)
			}.successBody()
		}

	protected suspend fun doGetDevice(groupId: String?, entityId: String): Device? =
		if (groupId == null) {
			rawApi.getDevice(entityId)
		} else {
			rawApi.getDeviceInGroup(groupId, entityId)
		}.successBodyOrNull404()

	protected suspend fun doGetDevices(groupId: String?, entityIds: List<String>): List<Device> =
		skipRequestOnNullList(entityIds) { ids ->
			if (groupId == null) {
				rawApi.getDevices(ListOfIds(ids))
			} else {
				rawApi.getDevicesInGroup(groupId, ListOfIds(ids))
			}.successBody()
		}

	protected suspend fun doModifyDevice(groupId: String?, entity: Device): Device {
		requireIsValidForModification(entity)
		return if (groupId == null) {
			rawApi.updateDevice(entity)
		} else {
			rawApi.modifyDeviceInGroup(groupId, entity)
		}.successBodyOrThrowRevisionConflict()
	}

	protected suspend fun doModifyDevices(groupId: String?, entities: List<Device>): List<Device> =
		skipRequestOnNullList(entities) { calendarItemTypes ->
			if (groupId == null) {
				rawApi.updateDevices(calendarItemTypes)
			} else {
				rawApi.modifyDevicesInGroup(groupId, calendarItemTypes)
			}.successBody()
		}

	protected suspend fun doDeleteDevice(groupId: String?, entityId: String, rev: String): StoredDocumentIdentifier =
		if (groupId == null) {
			rawApi.deleteDevice(entityId, rev)
		} else {
			rawApi.deleteDeviceInGroup(groupId, entityId, rev)
		}.successBodyOrThrowRevisionConflict().toStoredDocumentIdentifier()

	protected suspend fun doDeleteDevices(groupId: String?, entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier> =
		skipRequestOnNullList(entityIds) { ids ->
			if (groupId == null) {
				rawApi.deleteDevicesWithRev(ListOfIdsAndRev(ids))
			} else {
				rawApi.deleteDevicesInGroupWithRev(groupId = groupId, ListOfIdsAndRev(ids))
			}.successBody().map { it.toStoredDocumentIdentifier() }
		}

	protected suspend fun doUndeleteDevice(groupId: String?, entityId: String, rev: String): Device =
		if (groupId == null) {
			rawApi.undeleteDevice(entityId, rev)
		} else {
			rawApi.undeleteDeviceInGroup(groupId, entityId, rev)
		}.successBodyOrThrowRevisionConflict()

	protected suspend fun doUndeleteDevices(groupId: String?, entityIds: List<StoredDocumentIdentifier>): List<Device> =
		skipRequestOnNullList(entityIds) { ids ->
			if (groupId == null) {
				rawApi.undeleteDevices(ListOfIdsAndRev(ids))
			} else {
				rawApi.undeleteDevicesInGroup(groupId = groupId, ListOfIdsAndRev(ids))
			}.successBody()
		}

	protected suspend fun doPurgeDevice(groupId: String?, entityId: String, rev: String) {
		if (groupId == null) {
			rawApi.purgeDevice(entityId, rev)
		} else {
			rawApi.purgeDeviceInGroup(groupId, entityId, rev)
		}.successBodyOrThrowRevisionConflict()
	}

	protected suspend fun doPurgeDevices(groupId: String?, entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier> =
		skipRequestOnNullList(entityIds) { ids ->
			if (groupId == null) {
				rawApi.purgeDevices(ListOfIdsAndRev(ids))
			} else {
				rawApi.purgeDevicesInGroup(groupId = groupId, ListOfIdsAndRev(ids))
			}.successBody().map { it.toStoredDocumentIdentifier() }
		}

	protected suspend fun doMatchDevicesBy(groupId: String?, filter: BaseFilterOptions<Device>): List<String> =
		if (groupId == null) {
			rawApi.matchDevicesBy(mapDeviceFilterOptions(filter, config))
		} else {
			rawApi.matchDevicesInGroupBy(groupId = groupId, filter = mapDeviceFilterOptions(filter, config, groupId))
		}.successBody()
}

@InternalIcureApi
internal class DeviceApiImpl(
	rawApi: RawDeviceApi,
	config: BasicApiConfiguration,
) : DeviceApi, AbstractDeviceApi(rawApi, config) {

	override val inGroup: DeviceInGroupApi = DeviceApiInGroupImpl(rawApi, config)

	override suspend fun getDevice(deviceId: String) = doGetDevice(groupId = null, entityId = deviceId)

	override suspend fun getDevices(deviceIds: List<String>) = doGetDevices(groupId = null, entityIds = deviceIds)

	override suspend fun createDevice(device: Device) = doCreateDevice(groupId = null, entity = device)

	override suspend fun createDevices(devices: List<Device>): List<Device> {
		basicRequireIsValidForCreation(devices)
		return doCreateDevices(groupId = null, entities = devices)
	}

	override suspend fun modifyDevice(device: Device) = doModifyDevice(groupId = null, entity = device)

	override suspend fun modifyDevices(devices: List<Device>): List<Device> {
		requireIsValidForModification(devices)
		return doModifyDevices(groupId = null, entities = devices)
	}

	override suspend fun deleteDeviceById(entityId: String, rev: String): StoredDocumentIdentifier =
		doDeleteDevice(groupId = null, entityId = entityId, rev = rev)

	override suspend fun deleteDevicesByIds(entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier> =
		doDeleteDevices(groupId = null, entityIds = entityIds)

	override suspend fun undeleteDeviceById(id: String, rev: String): Device = doUndeleteDevice(groupId = null, entityId = id, rev = rev)

	override suspend fun undeleteDevicesByIds(entityIds: List<StoredDocumentIdentifier>): List<Device> =
		doUndeleteDevices(groupId = null, entityIds = entityIds)

	override suspend fun purgeDeviceById(id: String, rev: String) {
		doPurgeDevice(groupId = null, entityId = id, rev = rev)
	}

	override suspend fun purgeDevicesByIds(entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier> =
		doPurgeDevices(groupId = null, entityIds = entityIds)

	override suspend fun filterDevicesBy(filter: BaseFilterOptions<Device>) =
		IdsPageIterator(matchDevicesBy(filter), this::getDevices)

	override suspend fun filterDevicesBySorted(filter: BaseSortableFilterOptions<Device>) =
		IdsPageIterator(matchDevicesBySorted(filter), this::getDevices)

	override suspend fun matchDevicesBy(filter: BaseFilterOptions<Device>) =
		doMatchDevicesBy(groupId = null, filter)

	override suspend fun matchDevicesBySorted(filter: BaseSortableFilterOptions<Device>) =
		matchDevicesBy(filter)

	override suspend fun subscribeToEvents(
		events: Set<SubscriptionEventType>,
		filter: FilterOptions<Device>,
		subscriptionConfig: EntitySubscriptionConfiguration?,
	): EntitySubscription<Device> {
		return WebSocketSubscription.initialize(
			client = config.rawApiConfig.httpClient,
			hostname = config.apiUrl,
			path = "/ws/v2/notification/subscribe",
			clientJson = config.rawApiConfig.json,
			entitySerializer = Device.serializer(),
			events = events,
			filter = mapDeviceFilterOptions(
				filterOptions = filter,
				config = config,
				requestGroup = null
			),
			qualifiedName = Device.KRAKEN_QUALIFIED_NAME,
			subscriptionRequestSerializer = {
				Serialization.json.encodeToString(SubscriptionSerializer(DeviceAbstractFilterSerializer), it)
			},
			webSocketAuthProvider = config.requireWebSocketAuthProvider(),
			config = subscriptionConfig
		)
	}

}

@InternalIcureApi
internal class DeviceApiInGroupImpl(
	rawApi: RawDeviceApi,
	config: BasicApiConfiguration,
) : DeviceInGroupApi, AbstractDeviceApi(rawApi, config) {

	override suspend fun createDevice(device: GroupScoped<Device>): GroupScoped<Device> = groupScopedWith(device) { groupId, it ->
		doCreateDevice(groupId = groupId, entity = it)
	}

	override suspend fun createDevices(devices: List<GroupScoped<Device>>): List<GroupScoped<Device>> {
		basicRequireIsValidForCreation(devices)
		return devices.mapUniqueIdentifiablesChunkedByGroup { groupId, chunk ->
			doCreateDevices(groupId = groupId, entities = chunk)
		}
	}

	override suspend fun getDevice(
		groupId: String,
		deviceId: String,
	): GroupScoped<Device>? = groupScopedIn(groupId) { doGetDevice(groupId = groupId, entityId = deviceId) }

	override suspend fun getDevices(
		groupId: String,
		devicesIds: List<String>,
	): List<GroupScoped<Device>> = groupScopedListIn(groupId) { doGetDevices(groupId = groupId, entityIds = devicesIds) }

	override suspend fun modifyDevice(device: GroupScoped<Device>): GroupScoped<Device> = groupScopedWith(device) { groupId, it ->
		doModifyDevice(groupId = groupId, entity = it)
	}

	override suspend fun modifyDevices(devices: List<GroupScoped<Device>>): List<GroupScoped<Device>> {
		requireIsValidForModification(devices)
		return devices.mapUniqueIdentifiablesChunkedByGroup { groupId, chunk ->
			doModifyDevices(groupId = groupId, entities = chunk)
		}
	}

	override suspend fun deleteDeviceById(entityId: GroupScoped<StoredDocumentIdentifier>): GroupScoped<StoredDocumentIdentifier> =
		groupScopedWith(entityId) { groupId, it -> doDeleteDevice(groupId = groupId, entityId = it.id, rev = it.rev) }

	override suspend fun deleteDeviceByIds(entityIds: List<GroupScoped<StoredDocumentIdentifier>>): List<GroupScoped<StoredDocumentIdentifier>> =
		entityIds.mapUniqueIdentifiablesChunkedByGroup { groupId, chunk ->
			doDeleteDevices(groupId = groupId, entityIds = chunk)
		}

	override suspend fun undeleteDeviceById(entityId: GroupScoped<StoredDocumentIdentifier>): GroupScoped<Device> =
		groupScopedWith(entityId) { groupId, it -> doUndeleteDevice(groupId = groupId, entityId = it.id, rev = it.rev) }

	override suspend fun undeleteDeviceByIds(entityIds: List<GroupScoped<StoredDocumentIdentifier>>): List<GroupScoped<Device>> =
		entityIds.mapUniqueIdentifiablesChunkedByGroup { groupId, chunk ->
			doUndeleteDevices(groupId = groupId, entityIds = chunk)
		}

	override suspend fun purgeDeviceById(entityId: GroupScoped<StoredDocumentIdentifier>) {
		doPurgeDevice(groupId = entityId.groupId, entityId = entityId.entity.id, rev = entityId.entity.rev)
	}

	override suspend fun purgeDeviceByIds(entityIds: List<GroupScoped<StoredDocumentIdentifier>>): List<GroupScoped<StoredDocumentIdentifier>> =
		entityIds.mapUniqueIdentifiablesChunkedByGroup { groupId, chunk ->
			doPurgeDevices(groupId = groupId, entityIds = chunk)
		}

	override suspend fun filterDevicesBy(groupId: String, filter: BaseFilterOptions<Device>) =
		IdsPageIterator(matchDevicesBy(groupId, filter)) { ids ->
			getDevices(groupId, ids)
		}

	override suspend fun filterDevicesBySorted(groupId: String, filter: BaseSortableFilterOptions<Device>) =
		IdsPageIterator(matchDevicesBySorted(groupId, filter)) { ids ->
			getDevices(groupId, ids)
		}

	override suspend fun matchDevicesBy(groupId: String, filter: BaseFilterOptions<Device>) =
		doMatchDevicesBy(groupId = groupId, filter)

	override suspend fun matchDevicesBySorted(groupId: String, filter: BaseSortableFilterOptions<Device>) =
		matchDevicesBy(groupId, filter)
}
