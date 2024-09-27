package com.icure.cardinal.sdk.api.raw

import com.icure.cardinal.sdk.model.Device
import com.icure.cardinal.sdk.model.IdWithRev
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.ListOfIdsAndRev
import com.icure.cardinal.sdk.model.PaginatedList
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.model.filter.chain.FilterChain
import com.icure.cardinal.sdk.model.specializations.AesExchangeKeyEncryptionKeypairIdentifier
import com.icure.cardinal.sdk.model.specializations.HexString
import com.icure.utils.InternalIcureApi
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
public interface RawDeviceApi {
	// region common endpoints

	suspend fun getDevice(deviceId: String): HttpResponse<Device>

	suspend fun getDevices(deviceIds: ListOfIds): HttpResponse<List<Device>>

	suspend fun createDevice(p: Device): HttpResponse<Device>

	suspend fun updateDevice(deviceDto: Device): HttpResponse<Device>

	suspend fun createDevices(deviceDtos: List<Device>): HttpResponse<List<IdWithRev>>

	suspend fun updateDevices(deviceDtos: List<Device>): HttpResponse<List<IdWithRev>>

	suspend fun filterDevicesBy(
		startDocumentId: String? = null,
		limit: Int? = null,
		filterChain: FilterChain<Device>,
	): HttpResponse<PaginatedList<Device>>

	suspend fun getDeviceAesExchangeKeysForDelegate(
		deviceId: String,
	): HttpResponse<Map<String, Map<String, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>>>

	suspend fun matchDevicesBy(filter: AbstractFilter<Device>): HttpResponse<List<String>>

	suspend fun deleteDevices(deviceIds: ListOfIds): HttpResponse<List<DocIdentifier>>

	suspend fun deleteDevicesWithRev(deviceIds: ListOfIdsAndRev): HttpResponse<List<DocIdentifier>>

	suspend fun deleteDevice(deviceId: String): HttpResponse<DocIdentifier>

	suspend fun undeleteDevice(deviceId: String): HttpResponse<Device>

	suspend fun purgeDevice(deviceId: String): HttpResponse<DocIdentifier>
	// endregion

	// region cloud endpoints

	suspend fun getDevicesInGroup(
		groupId: String,
		deviceIds: ListOfIds? = null,
	): HttpResponse<List<Device>>

	suspend fun modifyDeviceInGroup(
		groupId: String,
		deviceDto: Device,
	): HttpResponse<Device>

	suspend fun createDeviceInGroup(
		groupId: String,
		deviceDto: Device,
	): HttpResponse<Device>

	suspend fun deleteDevicesInGroup(
		groupId: String,
		deviceIds: String,
	): HttpResponse<List<DocIdentifier>>

	suspend fun deleteDevicesInGroupWithRev(
		groupId: String,
		deviceIds: ListOfIdsAndRev,
	): HttpResponse<List<DocIdentifier>>

	suspend fun matchDevicesInGroupBy(
		groupId: String,
		filter: AbstractFilter<Device>,
	): HttpResponse<List<String>>
	// endregion
}
