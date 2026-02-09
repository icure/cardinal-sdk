// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.filters.BaseFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.BaseSortableFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.FilterOptionsJs
import com.icure.cardinal.sdk.js.model.DeviceJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.subscription.EntitySubscriptionJs
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.String
import kotlin.Unit
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("DeviceApi")
public external interface DeviceApiJs {
	public val inGroup: DeviceInGroupApiJs

	public fun getDevice(deviceId: String): Promise<DeviceJs?>

	public fun getDevices(deviceIds: Array<String>): Promise<Array<DeviceJs>>

	public fun createDevice(device: DeviceJs): Promise<DeviceJs>

	public fun createDevices(devices: Array<DeviceJs>): Promise<Array<DeviceJs>>

	public fun modifyDevice(device: DeviceJs): Promise<DeviceJs>

	public fun modifyDevices(devices: Array<DeviceJs>): Promise<Array<DeviceJs>>

	public fun deleteDeviceById(entityId: String, rev: String): Promise<StoredDocumentIdentifierJs>

	public fun deleteDevicesByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<StoredDocumentIdentifierJs>>

	public fun deleteDevice(device: DeviceJs): Promise<StoredDocumentIdentifierJs>

	public fun deleteDevices(devices: Array<DeviceJs>): Promise<Array<StoredDocumentIdentifierJs>>

	public fun undeleteDeviceById(id: String, rev: String): Promise<DeviceJs>

	public fun undeleteDevicesByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<DeviceJs>>

	public fun undeleteDevice(device: DeviceJs): Promise<DeviceJs>

	public fun undeleteDevices(devices: Array<DeviceJs>): Promise<Array<DeviceJs>>

	public fun purgeDeviceById(id: String, rev: String): Promise<Unit>

	public fun purgeDevicesByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<StoredDocumentIdentifierJs>>

	public fun purgeDevice(device: DeviceJs): Promise<Unit>

	public fun purgeDevices(devices: Array<DeviceJs>): Promise<Array<StoredDocumentIdentifierJs>>

	public fun filterDevicesBy(filter: BaseFilterOptionsJs<DeviceJs>):
			Promise<PaginatedListIteratorJs<DeviceJs>>

	public fun filterDevicesBySorted(filter: BaseSortableFilterOptionsJs<DeviceJs>):
			Promise<PaginatedListIteratorJs<DeviceJs>>

	public fun matchDevicesBy(filter: BaseFilterOptionsJs<DeviceJs>): Promise<Array<String>>

	public fun matchDevicesBySorted(filter: BaseSortableFilterOptionsJs<DeviceJs>):
			Promise<Array<String>>

	public fun subscribeToEvents(
		events: Array<String>,
		filter: FilterOptionsJs<DeviceJs>,
		options: dynamic,
	): Promise<EntitySubscriptionJs<DeviceJs>>
}
