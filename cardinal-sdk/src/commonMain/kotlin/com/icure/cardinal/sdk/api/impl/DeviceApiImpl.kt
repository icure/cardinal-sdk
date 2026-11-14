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
import com.icure.cardinal.sdk.model.conflicts.ConflictResolutionRequest
import com.icure.cardinal.sdk.model.conflicts.ConflictResolutionResult
import com.icure.cardinal.sdk.model.conflicts.ConflictResolutionStrategy
import com.icure.cardinal.sdk.model.conflicts.MergeResult
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
		requireIsValidForCreation(entity)
		return if (groupId == null) {
			rawApi.createDevice(p = entity)
		} else {
			rawApi.createDeviceInGroup(groupId = groupId, deviceDto = entity)
		}.successBody()
	}

	protected suspend fun doCreateDevices(groupId: String?, entities: List<Device>): List<Device> =
		skipRequestOnEmptyList(entities) { calendarItemTypes ->
			if (groupId == null) {
				rawApi.createDevices(deviceDtos = calendarItemTypes)
			} else {
				rawApi.createDevicesInGroup(groupId = groupId, deviceDtos = calendarItemTypes)
			}.successBody()
		}

	protected suspend fun doGetDevice(groupId: String?, entityId: String): Device? =
		if (groupId == null) {
			rawApi.getDevice(deviceId = entityId)
		} else {
			rawApi.getDeviceInGroup(groupId = groupId, deviceId = entityId)
		}.successBodyOrNull404()

	protected suspend fun doGetDevices(groupId: String?, entityIds: List<String>): List<Device> =
		skipRequestOnEmptyList(entityIds) { ids ->
			if (groupId == null) {
				rawApi.getDevices(deviceIds = ListOfIds(ids))
			} else {
				rawApi.getDevicesInGroup(groupId = groupId, deviceIds = ListOfIds(ids))
			}.successBody()
		}

	protected suspend fun doModifyDevice(groupId: String?, entity: Device): Device {
		requireIsValidForModification(entity)
		return if (groupId == null) {
			rawApi.updateDevice(deviceDto = entity)
		} else {
			rawApi.modifyDeviceInGroup(groupId = groupId, deviceDto = entity)
		}.successBodyOrThrowRevisionConflict()
	}

	protected suspend fun doModifyDevices(groupId: String?, entities: List<Device>): List<Device> =
		skipRequestOnEmptyList(entities) { calendarItemTypes ->
			if (groupId == null) {
				rawApi.updateDevices(deviceDtos = calendarItemTypes)
			} else {
				rawApi.modifyDevicesInGroup(groupId = groupId, deviceDtos = calendarItemTypes)
			}.successBody()
		}

	protected suspend fun doDeleteDevice(groupId: String?, entityId: String, rev: String): StoredDocumentIdentifier =
		if (groupId == null) {
			rawApi.deleteDevice(deviceId = entityId, rev = rev)
		} else {
			rawApi.deleteDeviceInGroup(groupId = groupId, deviceId = entityId, rev = rev)
		}.successBodyOrThrowRevisionConflict().toStoredDocumentIdentifier()

	protected suspend fun doDeleteDevices(groupId: String?, entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier> =
		skipRequestOnEmptyList(entityIds) { ids ->
			if (groupId == null) {
				rawApi.deleteDevicesWithRev(deviceIds = ListOfIdsAndRev(ids))
			} else {
				rawApi.deleteDevicesInGroupWithRev(groupId = groupId, deviceIds = ListOfIdsAndRev(ids))
			}.successBody().map { it.toStoredDocumentIdentifier() }
		}

	protected suspend fun doUndeleteDevice(groupId: String?, entityId: String, rev: String): Device =
		if (groupId == null) {
			rawApi.undeleteDevice(deviceId = entityId, rev = rev)
		} else {
			rawApi.undeleteDeviceInGroup(groupId = groupId, deviceId = entityId, rev = rev)
		}.successBodyOrThrowRevisionConflict()

	protected suspend fun doUndeleteDevices(groupId: String?, entityIds: List<StoredDocumentIdentifier>): List<Device> =
		skipRequestOnEmptyList(entityIds) { ids ->
			if (groupId == null) {
				rawApi.undeleteDevices(deviceIds = ListOfIdsAndRev(ids))
			} else {
				rawApi.undeleteDevicesInGroup(groupId = groupId, deviceIds = ListOfIdsAndRev(ids))
			}.successBody()
		}

	protected suspend fun doPurgeDevice(groupId: String?, entityId: String, rev: String) {
		if (groupId == null) {
			rawApi.purgeDevice(deviceId = entityId, rev = rev)
		} else {
			rawApi.purgeDeviceInGroup(groupId = groupId, deviceId = entityId, rev = rev)
		}.successBodyOrThrowRevisionConflict()
	}

	protected suspend fun doPurgeDevices(groupId: String?, entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier> =
		skipRequestOnEmptyList(entityIds) { ids ->
			if (groupId == null) {
				rawApi.purgeDevices(deviceIds = ListOfIdsAndRev(ids))
			} else {
				rawApi.purgeDevicesInGroup(groupId = groupId, deviceIds = ListOfIdsAndRev(ids))
			}.successBody().map { it.toStoredDocumentIdentifier() }
		}

	protected suspend fun doMatchDevicesBy(groupId: String?, filter: BaseFilterOptions<Device>): List<String> =
		if (groupId == null) {
			rawApi.matchDevicesBy(filter = mapDeviceFilterOptions(filter, config))
		} else {
			rawApi.matchDevicesInGroupBy(groupId = groupId, filter = mapDeviceFilterOptions(filter, config, groupId))
		}.successBody()

	protected suspend fun doGetConflictingEntitiesIds(groupId: String?): List<String> =
		if (groupId == null) {
			rawApi.getConflictingEntitiesIds()
		} else {
			rawApi.getConflictingEntitiesIdsInGroup(groupId = groupId)
		}.successBody()

	protected suspend fun doAutoSolveConflicts(
		groupId: String?,
		entityIds: List<String>,
		strategy: ConflictResolutionStrategy?,
	): List<MergeResult> = skipRequestOnEmptyList(entityIds) { ids ->
		if (groupId == null) {
			rawApi.autoSolveConflicts(entityIds = ids, strategy = strategy)
		} else {
			rawApi.autoSolveConflictsInGroup(groupId = groupId, entityIds = ids, strategy = strategy)
		}.successBody()
	}

	protected suspend fun doGetConflictsForEntity(groupId: String?, entityId: String): List<Device> =
		if (groupId == null) {
			rawApi.getConflictsForEntity(entityId = entityId)
		} else {
			rawApi.getConflictsForEntityInGroup(groupId = groupId, entityId = entityId)
		}.successBody()

	protected suspend fun doDeclareConflictWinner(
		groupId: String?,
		request: ConflictResolutionRequest<Device>,
	): ConflictResolutionResult<Device> {
		requireIsValidForModification(request.document)
		return if (groupId == null) {
			rawApi.declareConflictWinner(request = request)
		} else {
			rawApi.declareConflictWinnerInGroup(groupId = groupId, request = request)
		}.successBodyOrThrowRevisionConflict()
	}
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
		requireIsValidForCreation(devices)
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

	override suspend fun getConflictingEntitiesIds(): List<String> =
		doGetConflictingEntitiesIds(groupId = null)

	override suspend fun autoSolveConflicts(entityIds: List<String>, strategy: ConflictResolutionStrategy?): List<MergeResult> =
		doAutoSolveConflicts(groupId = null, entityIds = entityIds, strategy = strategy)

	override suspend fun getConflictsForEntity(entityId: String): List<Device> =
		doGetConflictsForEntity(groupId = null, entityId = entityId)

	override suspend fun declareConflictWinner(request: ConflictResolutionRequest<Device>): ConflictResolutionResult<Device> =
		doDeclareConflictWinner(groupId = null, request = request)
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
		requireIsValidForCreationInGroup(devices)
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
		requireIsValidForModificationInGroup(devices)
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

	override suspend fun getConflictingEntitiesIds(groupId: String): List<String> =
		doGetConflictingEntitiesIds(groupId = groupId)

	override suspend fun autoSolveConflicts(
		groupId: String,
		entityIds: List<String>,
		strategy: ConflictResolutionStrategy?,
	): List<MergeResult> =
		doAutoSolveConflicts(groupId = groupId, entityIds = entityIds, strategy = strategy)

	override suspend fun getConflictsForEntity(groupId: String, entityId: String): List<GroupScoped<Device>> =
		doGetConflictsForEntity(groupId = groupId, entityId = entityId).map { GroupScoped(it, groupId) }

	override suspend fun declareConflictWinner(
		groupId: String,
		request: ConflictResolutionRequest<Device>,
	): ConflictResolutionResult<Device> =
		doDeclareConflictWinner(groupId = groupId, request = request)
}
