// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.filters.BaseFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.BaseSortableFilterOptionsJs
import com.icure.cardinal.sdk.js.model.DeviceJs
import com.icure.cardinal.sdk.js.model.GroupScopedJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.String
import kotlin.Unit
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("DeviceInGroupApi")
public external interface DeviceInGroupApiJs {
	public fun createDevice(device: GroupScopedJs<DeviceJs>): Promise<GroupScopedJs<DeviceJs>>

	public fun createDevices(devices: Array<GroupScopedJs<DeviceJs>>):
			Promise<Array<GroupScopedJs<DeviceJs>>>

	public fun getDevice(groupId: String, deviceId: String): Promise<GroupScopedJs<DeviceJs>?>

	public fun getDevices(groupId: String, devicesIds: Array<String>):
			Promise<Array<GroupScopedJs<DeviceJs>>>

	public fun modifyDevice(device: GroupScopedJs<DeviceJs>): Promise<GroupScopedJs<DeviceJs>>

	public fun modifyDevices(devices: Array<GroupScopedJs<DeviceJs>>):
			Promise<Array<GroupScopedJs<DeviceJs>>>

	public fun deleteDeviceById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
			Promise<GroupScopedJs<StoredDocumentIdentifierJs>>

	public fun deleteDeviceByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
			Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>>

	public fun deleteDevice(device: GroupScopedJs<DeviceJs>):
			Promise<GroupScopedJs<StoredDocumentIdentifierJs>>

	public fun deleteDevices(devices: Array<GroupScopedJs<DeviceJs>>):
			Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>>

	public fun undeleteDeviceById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
			Promise<GroupScopedJs<DeviceJs>>

	public fun undeleteDeviceByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
			Promise<Array<GroupScopedJs<DeviceJs>>>

	public fun undeleteDevice(device: GroupScopedJs<DeviceJs>): Promise<GroupScopedJs<DeviceJs>>

	public fun undeleteDevices(devices: Array<GroupScopedJs<DeviceJs>>):
			Promise<Array<GroupScopedJs<DeviceJs>>>

	public fun purgeDeviceById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>): Promise<Unit>

	public fun purgeDeviceByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
			Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>>

	public fun purgeDevice(device: GroupScopedJs<DeviceJs>): Promise<Unit>

	public fun purgeDevices(devices: Array<GroupScopedJs<DeviceJs>>):
			Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>>

	public fun filterDevicesBy(groupId: String, filter: BaseFilterOptionsJs<DeviceJs>):
			Promise<PaginatedListIteratorJs<GroupScopedJs<DeviceJs>>>

	public fun filterDevicesBySorted(groupId: String, filter: BaseSortableFilterOptionsJs<DeviceJs>):
			Promise<PaginatedListIteratorJs<GroupScopedJs<DeviceJs>>>

	public fun matchDevicesBy(groupId: String, filter: BaseFilterOptionsJs<DeviceJs>):
			Promise<Array<String>>

	public fun matchDevicesBySorted(groupId: String, filter: BaseSortableFilterOptionsJs<DeviceJs>):
			Promise<Array<String>>
}
