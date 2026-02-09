// auto-generated file
package com.icure.cardinal.sdk.js.api.`impl`

import com.icure.cardinal.sdk.api.DeviceApi
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNullable
import com.icure.cardinal.sdk.js.api.DeviceApiJs
import com.icure.cardinal.sdk.js.api.DeviceInGroupApiJs
import com.icure.cardinal.sdk.js.filters.BaseFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.BaseSortableFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.FilterOptionsJs
import com.icure.cardinal.sdk.js.filters.baseFilterOptions_fromJs
import com.icure.cardinal.sdk.js.filters.baseSortableFilterOptions_fromJs
import com.icure.cardinal.sdk.js.filters.filterOptions_fromJs
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToList
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.cardinal.sdk.js.model.CheckedConverters.listToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.DeviceJs
import com.icure.cardinal.sdk.js.model.GroupScopedJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.model.device_fromJs
import com.icure.cardinal.sdk.js.model.device_toJs
import com.icure.cardinal.sdk.js.model.groupScoped_fromJs
import com.icure.cardinal.sdk.js.model.groupScoped_toJs
import com.icure.cardinal.sdk.js.model.storedDocumentIdentifier_fromJs
import com.icure.cardinal.sdk.js.model.storedDocumentIdentifier_toJs
import com.icure.cardinal.sdk.js.subscription.EntitySubscriptionConfigurationJs
import com.icure.cardinal.sdk.js.subscription.EntitySubscriptionJs
import com.icure.cardinal.sdk.js.subscription.entitySubscriptionConfiguration_fromJs
import com.icure.cardinal.sdk.js.subscription.entitySubscription_toJs
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import com.icure.cardinal.sdk.js.utils.pagination.paginatedListIterator_toJs
import com.icure.cardinal.sdk.model.Device
import com.icure.cardinal.sdk.model.GroupScoped
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
import com.icure.cardinal.sdk.subscription.EntitySubscriptionConfiguration
import com.icure.cardinal.sdk.subscription.SubscriptionEventType
import kotlin.Array
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlin.collections.List
import kotlin.collections.Set
import kotlin.js.Promise
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise

@OptIn(DelicateCoroutinesApi::class)
internal class DeviceApiImplJs(
	private val deviceApi: DeviceApi,
) : DeviceApiJs {
	override val inGroup: DeviceInGroupApiJs = object : DeviceInGroupApiJs {
		override fun createDevice(device: GroupScopedJs<DeviceJs>): Promise<GroupScopedJs<DeviceJs>> =
				GlobalScope.promise {
			val deviceConverted: GroupScoped<Device> = groupScoped_fromJs(
				device,
				{ x1: DeviceJs ->
					device_fromJs(x1)
				},
			)
			val result = deviceApi.inGroup.createDevice(
				deviceConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: Device ->
					device_toJs(x1)
				},
			)
		}

		override fun createDevices(devices: Array<GroupScopedJs<DeviceJs>>):
				Promise<Array<GroupScopedJs<DeviceJs>>> = GlobalScope.promise {
			val devicesConverted: List<GroupScoped<Device>> = arrayToList(
				devices,
				"devices",
				{ x1: GroupScopedJs<DeviceJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: DeviceJs ->
							device_fromJs(x2)
						},
					)
				},
			)
			val result = deviceApi.inGroup.createDevices(
				devicesConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<Device> ->
					groupScoped_toJs(
						x1,
						{ x2: Device ->
							device_toJs(x2)
						},
					)
				},
			)
		}

		override fun getDevice(groupId: String, deviceId: String): Promise<GroupScopedJs<DeviceJs>?> =
				GlobalScope.promise {
			val groupIdConverted: String = groupId
			val deviceIdConverted: String = deviceId
			val result = deviceApi.inGroup.getDevice(
				groupIdConverted,
				deviceIdConverted,
			)
			nullToUndefined(
				result?.let { nonNull1 ->
					groupScoped_toJs(
						nonNull1,
						{ x1: Device ->
							device_toJs(x1)
						},
					)
				}
			)
		}

		override fun getDevices(groupId: String, devicesIds: Array<String>):
				Promise<Array<GroupScopedJs<DeviceJs>>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val devicesIdsConverted: List<String> = arrayToList(
				devicesIds,
				"devicesIds",
				{ x1: String ->
					x1
				},
			)
			val result = deviceApi.inGroup.getDevices(
				groupIdConverted,
				devicesIdsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<Device> ->
					groupScoped_toJs(
						x1,
						{ x2: Device ->
							device_toJs(x2)
						},
					)
				},
			)
		}

		override fun modifyDevice(device: GroupScopedJs<DeviceJs>): Promise<GroupScopedJs<DeviceJs>> =
				GlobalScope.promise {
			val deviceConverted: GroupScoped<Device> = groupScoped_fromJs(
				device,
				{ x1: DeviceJs ->
					device_fromJs(x1)
				},
			)
			val result = deviceApi.inGroup.modifyDevice(
				deviceConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: Device ->
					device_toJs(x1)
				},
			)
		}

		override fun modifyDevices(devices: Array<GroupScopedJs<DeviceJs>>):
				Promise<Array<GroupScopedJs<DeviceJs>>> = GlobalScope.promise {
			val devicesConverted: List<GroupScoped<Device>> = arrayToList(
				devices,
				"devices",
				{ x1: GroupScopedJs<DeviceJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: DeviceJs ->
							device_fromJs(x2)
						},
					)
				},
			)
			val result = deviceApi.inGroup.modifyDevices(
				devicesConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<Device> ->
					groupScoped_toJs(
						x1,
						{ x2: Device ->
							device_toJs(x2)
						},
					)
				},
			)
		}

		override fun deleteDeviceById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
				Promise<GroupScopedJs<StoredDocumentIdentifierJs>> = GlobalScope.promise {
			val entityIdConverted: GroupScoped<StoredDocumentIdentifier> = groupScoped_fromJs(
				entityId,
				{ x1: StoredDocumentIdentifierJs ->
					storedDocumentIdentifier_fromJs(x1)
				},
			)
			val result = deviceApi.inGroup.deleteDeviceById(
				entityIdConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: StoredDocumentIdentifier ->
					storedDocumentIdentifier_toJs(x1)
				},
			)
		}

		override fun deleteDeviceByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
				Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>> = GlobalScope.promise {
			val entityIdsConverted: List<GroupScoped<StoredDocumentIdentifier>> = arrayToList(
				entityIds,
				"entityIds",
				{ x1: GroupScopedJs<StoredDocumentIdentifierJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: StoredDocumentIdentifierJs ->
							storedDocumentIdentifier_fromJs(x2)
						},
					)
				},
			)
			val result = deviceApi.inGroup.deleteDeviceByIds(
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<StoredDocumentIdentifier> ->
					groupScoped_toJs(
						x1,
						{ x2: StoredDocumentIdentifier ->
							storedDocumentIdentifier_toJs(x2)
						},
					)
				},
			)
		}

		override fun deleteDevice(device: GroupScopedJs<DeviceJs>):
				Promise<GroupScopedJs<StoredDocumentIdentifierJs>> = GlobalScope.promise {
			val deviceConverted: GroupScoped<Device> = groupScoped_fromJs(
				device,
				{ x1: DeviceJs ->
					device_fromJs(x1)
				},
			)
			val result = deviceApi.inGroup.deleteDevice(
				deviceConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: StoredDocumentIdentifier ->
					storedDocumentIdentifier_toJs(x1)
				},
			)
		}

		override fun deleteDevices(devices: Array<GroupScopedJs<DeviceJs>>):
				Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>> = GlobalScope.promise {
			val devicesConverted: List<GroupScoped<Device>> = arrayToList(
				devices,
				"devices",
				{ x1: GroupScopedJs<DeviceJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: DeviceJs ->
							device_fromJs(x2)
						},
					)
				},
			)
			val result = deviceApi.inGroup.deleteDevices(
				devicesConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<StoredDocumentIdentifier> ->
					groupScoped_toJs(
						x1,
						{ x2: StoredDocumentIdentifier ->
							storedDocumentIdentifier_toJs(x2)
						},
					)
				},
			)
		}

		override fun undeleteDeviceById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
				Promise<GroupScopedJs<DeviceJs>> = GlobalScope.promise {
			val entityIdConverted: GroupScoped<StoredDocumentIdentifier> = groupScoped_fromJs(
				entityId,
				{ x1: StoredDocumentIdentifierJs ->
					storedDocumentIdentifier_fromJs(x1)
				},
			)
			val result = deviceApi.inGroup.undeleteDeviceById(
				entityIdConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: Device ->
					device_toJs(x1)
				},
			)
		}

		override fun undeleteDeviceByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
				Promise<Array<GroupScopedJs<DeviceJs>>> = GlobalScope.promise {
			val entityIdsConverted: List<GroupScoped<StoredDocumentIdentifier>> = arrayToList(
				entityIds,
				"entityIds",
				{ x1: GroupScopedJs<StoredDocumentIdentifierJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: StoredDocumentIdentifierJs ->
							storedDocumentIdentifier_fromJs(x2)
						},
					)
				},
			)
			val result = deviceApi.inGroup.undeleteDeviceByIds(
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<Device> ->
					groupScoped_toJs(
						x1,
						{ x2: Device ->
							device_toJs(x2)
						},
					)
				},
			)
		}

		override fun undeleteDevice(device: GroupScopedJs<DeviceJs>): Promise<GroupScopedJs<DeviceJs>> =
				GlobalScope.promise {
			val deviceConverted: GroupScoped<Device> = groupScoped_fromJs(
				device,
				{ x1: DeviceJs ->
					device_fromJs(x1)
				},
			)
			val result = deviceApi.inGroup.undeleteDevice(
				deviceConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: Device ->
					device_toJs(x1)
				},
			)
		}

		override fun undeleteDevices(devices: Array<GroupScopedJs<DeviceJs>>):
				Promise<Array<GroupScopedJs<DeviceJs>>> = GlobalScope.promise {
			val devicesConverted: List<GroupScoped<Device>> = arrayToList(
				devices,
				"devices",
				{ x1: GroupScopedJs<DeviceJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: DeviceJs ->
							device_fromJs(x2)
						},
					)
				},
			)
			val result = deviceApi.inGroup.undeleteDevices(
				devicesConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<Device> ->
					groupScoped_toJs(
						x1,
						{ x2: Device ->
							device_toJs(x2)
						},
					)
				},
			)
		}

		override fun purgeDeviceById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>): Promise<Unit> =
				GlobalScope.promise {
			val entityIdConverted: GroupScoped<StoredDocumentIdentifier> = groupScoped_fromJs(
				entityId,
				{ x1: StoredDocumentIdentifierJs ->
					storedDocumentIdentifier_fromJs(x1)
				},
			)
			deviceApi.inGroup.purgeDeviceById(
				entityIdConverted,
			)

		}

		override fun purgeDeviceByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
				Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>> = GlobalScope.promise {
			val entityIdsConverted: List<GroupScoped<StoredDocumentIdentifier>> = arrayToList(
				entityIds,
				"entityIds",
				{ x1: GroupScopedJs<StoredDocumentIdentifierJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: StoredDocumentIdentifierJs ->
							storedDocumentIdentifier_fromJs(x2)
						},
					)
				},
			)
			val result = deviceApi.inGroup.purgeDeviceByIds(
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<StoredDocumentIdentifier> ->
					groupScoped_toJs(
						x1,
						{ x2: StoredDocumentIdentifier ->
							storedDocumentIdentifier_toJs(x2)
						},
					)
				},
			)
		}

		override fun purgeDevice(device: GroupScopedJs<DeviceJs>): Promise<Unit> = GlobalScope.promise {
			val deviceConverted: GroupScoped<Device> = groupScoped_fromJs(
				device,
				{ x1: DeviceJs ->
					device_fromJs(x1)
				},
			)
			deviceApi.inGroup.purgeDevice(
				deviceConverted,
			)

		}

		override fun purgeDevices(devices: Array<GroupScopedJs<DeviceJs>>):
				Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>> = GlobalScope.promise {
			val devicesConverted: List<GroupScoped<Device>> = arrayToList(
				devices,
				"devices",
				{ x1: GroupScopedJs<DeviceJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: DeviceJs ->
							device_fromJs(x2)
						},
					)
				},
			)
			val result = deviceApi.inGroup.purgeDevices(
				devicesConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<StoredDocumentIdentifier> ->
					groupScoped_toJs(
						x1,
						{ x2: StoredDocumentIdentifier ->
							storedDocumentIdentifier_toJs(x2)
						},
					)
				},
			)
		}

		override fun filterDevicesBy(groupId: String, filter: BaseFilterOptionsJs<DeviceJs>):
				Promise<PaginatedListIteratorJs<GroupScopedJs<DeviceJs>>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val filterConverted: BaseFilterOptions<Device> = baseFilterOptions_fromJs(filter)
			val result = deviceApi.inGroup.filterDevicesBy(
				groupIdConverted,
				filterConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: GroupScoped<Device> ->
					groupScoped_toJs(
						x1,
						{ x2: Device ->
							device_toJs(x2)
						},
					)
				},
			)
		}

		override fun filterDevicesBySorted(groupId: String,
				filter: BaseSortableFilterOptionsJs<DeviceJs>):
				Promise<PaginatedListIteratorJs<GroupScopedJs<DeviceJs>>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val filterConverted: BaseSortableFilterOptions<Device> = baseSortableFilterOptions_fromJs(filter)
			val result = deviceApi.inGroup.filterDevicesBySorted(
				groupIdConverted,
				filterConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: GroupScoped<Device> ->
					groupScoped_toJs(
						x1,
						{ x2: Device ->
							device_toJs(x2)
						},
					)
				},
			)
		}

		override fun matchDevicesBy(groupId: String, filter: BaseFilterOptionsJs<DeviceJs>):
				Promise<Array<String>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val filterConverted: BaseFilterOptions<Device> = baseFilterOptions_fromJs(filter)
			val result = deviceApi.inGroup.matchDevicesBy(
				groupIdConverted,
				filterConverted,
			)
			listToArray(
				result,
				{ x1: String ->
					x1
				},
			)
		}

		override fun matchDevicesBySorted(groupId: String, filter: BaseSortableFilterOptionsJs<DeviceJs>):
				Promise<Array<String>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val filterConverted: BaseSortableFilterOptions<Device> = baseSortableFilterOptions_fromJs(filter)
			val result = deviceApi.inGroup.matchDevicesBySorted(
				groupIdConverted,
				filterConverted,
			)
			listToArray(
				result,
				{ x1: String ->
					x1
				},
			)
		}
	}

	override fun getDevice(deviceId: String): Promise<DeviceJs?> = GlobalScope.promise {
		val deviceIdConverted: String = deviceId
		val result = deviceApi.getDevice(
			deviceIdConverted,
		)
		nullToUndefined(
			result?.let { nonNull1 ->
				device_toJs(nonNull1)
			}
		)
	}

	override fun getDevices(deviceIds: Array<String>): Promise<Array<DeviceJs>> = GlobalScope.promise {
		val deviceIdsConverted: List<String> = arrayToList(
			deviceIds,
			"deviceIds",
			{ x1: String ->
				x1
			},
		)
		val result = deviceApi.getDevices(
			deviceIdsConverted,
		)
		listToArray(
			result,
			{ x1: Device ->
				device_toJs(x1)
			},
		)
	}

	override fun createDevice(device: DeviceJs): Promise<DeviceJs> = GlobalScope.promise {
		val deviceConverted: Device = device_fromJs(device)
		val result = deviceApi.createDevice(
			deviceConverted,
		)
		device_toJs(result)
	}

	override fun createDevices(devices: Array<DeviceJs>): Promise<Array<DeviceJs>> =
			GlobalScope.promise {
		val devicesConverted: List<Device> = arrayToList(
			devices,
			"devices",
			{ x1: DeviceJs ->
				device_fromJs(x1)
			},
		)
		val result = deviceApi.createDevices(
			devicesConverted,
		)
		listToArray(
			result,
			{ x1: Device ->
				device_toJs(x1)
			},
		)
	}

	override fun modifyDevice(device: DeviceJs): Promise<DeviceJs> = GlobalScope.promise {
		val deviceConverted: Device = device_fromJs(device)
		val result = deviceApi.modifyDevice(
			deviceConverted,
		)
		device_toJs(result)
	}

	override fun modifyDevices(devices: Array<DeviceJs>): Promise<Array<DeviceJs>> =
			GlobalScope.promise {
		val devicesConverted: List<Device> = arrayToList(
			devices,
			"devices",
			{ x1: DeviceJs ->
				device_fromJs(x1)
			},
		)
		val result = deviceApi.modifyDevices(
			devicesConverted,
		)
		listToArray(
			result,
			{ x1: Device ->
				device_toJs(x1)
			},
		)
	}

	override fun deleteDeviceById(entityId: String, rev: String): Promise<StoredDocumentIdentifierJs> =
			GlobalScope.promise {
		val entityIdConverted: String = entityId
		val revConverted: String = rev
		val result = deviceApi.deleteDeviceById(
			entityIdConverted,
			revConverted,
		)
		storedDocumentIdentifier_toJs(result)
	}

	override fun deleteDevicesByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<StoredDocumentIdentifierJs>> = GlobalScope.promise {
		val entityIdsConverted: List<StoredDocumentIdentifier> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: StoredDocumentIdentifierJs ->
				storedDocumentIdentifier_fromJs(x1)
			},
		)
		val result = deviceApi.deleteDevicesByIds(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: StoredDocumentIdentifier ->
				storedDocumentIdentifier_toJs(x1)
			},
		)
	}

	override fun deleteDevice(device: DeviceJs): Promise<StoredDocumentIdentifierJs> =
			GlobalScope.promise {
		val deviceConverted: Device = device_fromJs(device)
		val result = deviceApi.deleteDevice(
			deviceConverted,
		)
		storedDocumentIdentifier_toJs(result)
	}

	override fun deleteDevices(devices: Array<DeviceJs>): Promise<Array<StoredDocumentIdentifierJs>> =
			GlobalScope.promise {
		val devicesConverted: List<Device> = arrayToList(
			devices,
			"devices",
			{ x1: DeviceJs ->
				device_fromJs(x1)
			},
		)
		val result = deviceApi.deleteDevices(
			devicesConverted,
		)
		listToArray(
			result,
			{ x1: StoredDocumentIdentifier ->
				storedDocumentIdentifier_toJs(x1)
			},
		)
	}

	override fun undeleteDeviceById(id: String, rev: String): Promise<DeviceJs> = GlobalScope.promise {
		val idConverted: String = id
		val revConverted: String = rev
		val result = deviceApi.undeleteDeviceById(
			idConverted,
			revConverted,
		)
		device_toJs(result)
	}

	override fun undeleteDevicesByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<DeviceJs>> = GlobalScope.promise {
		val entityIdsConverted: List<StoredDocumentIdentifier> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: StoredDocumentIdentifierJs ->
				storedDocumentIdentifier_fromJs(x1)
			},
		)
		val result = deviceApi.undeleteDevicesByIds(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: Device ->
				device_toJs(x1)
			},
		)
	}

	override fun undeleteDevice(device: DeviceJs): Promise<DeviceJs> = GlobalScope.promise {
		val deviceConverted: Device = device_fromJs(device)
		val result = deviceApi.undeleteDevice(
			deviceConverted,
		)
		device_toJs(result)
	}

	override fun undeleteDevices(devices: Array<DeviceJs>): Promise<Array<DeviceJs>> =
			GlobalScope.promise {
		val devicesConverted: List<Device> = arrayToList(
			devices,
			"devices",
			{ x1: DeviceJs ->
				device_fromJs(x1)
			},
		)
		val result = deviceApi.undeleteDevices(
			devicesConverted,
		)
		listToArray(
			result,
			{ x1: Device ->
				device_toJs(x1)
			},
		)
	}

	override fun purgeDeviceById(id: String, rev: String): Promise<Unit> = GlobalScope.promise {
		val idConverted: String = id
		val revConverted: String = rev
		deviceApi.purgeDeviceById(
			idConverted,
			revConverted,
		)

	}

	override fun purgeDevicesByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<StoredDocumentIdentifierJs>> = GlobalScope.promise {
		val entityIdsConverted: List<StoredDocumentIdentifier> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: StoredDocumentIdentifierJs ->
				storedDocumentIdentifier_fromJs(x1)
			},
		)
		val result = deviceApi.purgeDevicesByIds(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: StoredDocumentIdentifier ->
				storedDocumentIdentifier_toJs(x1)
			},
		)
	}

	override fun purgeDevice(device: DeviceJs): Promise<Unit> = GlobalScope.promise {
		val deviceConverted: Device = device_fromJs(device)
		deviceApi.purgeDevice(
			deviceConverted,
		)

	}

	override fun purgeDevices(devices: Array<DeviceJs>): Promise<Array<StoredDocumentIdentifierJs>> =
			GlobalScope.promise {
		val devicesConverted: List<Device> = arrayToList(
			devices,
			"devices",
			{ x1: DeviceJs ->
				device_fromJs(x1)
			},
		)
		val result = deviceApi.purgeDevices(
			devicesConverted,
		)
		listToArray(
			result,
			{ x1: StoredDocumentIdentifier ->
				storedDocumentIdentifier_toJs(x1)
			},
		)
	}

	override fun filterDevicesBy(filter: BaseFilterOptionsJs<DeviceJs>):
			Promise<PaginatedListIteratorJs<DeviceJs>> = GlobalScope.promise {
		val filterConverted: BaseFilterOptions<Device> = baseFilterOptions_fromJs(filter)
		val result = deviceApi.filterDevicesBy(
			filterConverted,
		)
		paginatedListIterator_toJs(
			result,
			{ x1: Device ->
				device_toJs(x1)
			},
		)
	}

	override fun filterDevicesBySorted(filter: BaseSortableFilterOptionsJs<DeviceJs>):
			Promise<PaginatedListIteratorJs<DeviceJs>> = GlobalScope.promise {
		val filterConverted: BaseSortableFilterOptions<Device> = baseSortableFilterOptions_fromJs(filter)
		val result = deviceApi.filterDevicesBySorted(
			filterConverted,
		)
		paginatedListIterator_toJs(
			result,
			{ x1: Device ->
				device_toJs(x1)
			},
		)
	}

	override fun matchDevicesBy(filter: BaseFilterOptionsJs<DeviceJs>): Promise<Array<String>> =
			GlobalScope.promise {
		val filterConverted: BaseFilterOptions<Device> = baseFilterOptions_fromJs(filter)
		val result = deviceApi.matchDevicesBy(
			filterConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun matchDevicesBySorted(filter: BaseSortableFilterOptionsJs<DeviceJs>):
			Promise<Array<String>> = GlobalScope.promise {
		val filterConverted: BaseSortableFilterOptions<Device> = baseSortableFilterOptions_fromJs(filter)
		val result = deviceApi.matchDevicesBySorted(
			filterConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun subscribeToEvents(
		events: Array<String>,
		filter: FilterOptionsJs<DeviceJs>,
		options: dynamic,
	): Promise<EntitySubscriptionJs<DeviceJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val eventsConverted: Set<SubscriptionEventType> = arrayToSet(
				events,
				"events",
				{ x1: String ->
					SubscriptionEventType.valueOf(x1)
				},
			)
			val filterConverted: FilterOptions<Device> = filterOptions_fromJs(filter)
			val subscriptionConfigConverted: EntitySubscriptionConfiguration? =
					convertingOptionOrDefaultNullable(
				_options,
				"subscriptionConfig",
				null
			) { subscriptionConfig: EntitySubscriptionConfigurationJs? ->
				subscriptionConfig?.let { nonNull1 ->
					entitySubscriptionConfiguration_fromJs(nonNull1)
				}
			}
			val result = deviceApi.subscribeToEvents(
				eventsConverted,
				filterConverted,
				subscriptionConfigConverted,
			)
			entitySubscription_toJs(
				result,
				{ x1: Device ->
					device_toJs(x1)
				},
			)
		}
	}
}
