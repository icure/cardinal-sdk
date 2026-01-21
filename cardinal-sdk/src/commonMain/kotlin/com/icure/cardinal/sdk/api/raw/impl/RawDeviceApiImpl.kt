package com.icure.cardinal.sdk.api.raw.`impl`

import com.icure.cardinal.sdk.api.raw.BaseRawApi
import com.icure.cardinal.sdk.api.raw.HttpResponse
import com.icure.cardinal.sdk.api.raw.RawApiConfig
import com.icure.cardinal.sdk.api.raw.RawDeviceApi
import com.icure.cardinal.sdk.api.raw.wrap
import com.icure.cardinal.sdk.auth.services.AuthProvider
import com.icure.cardinal.sdk.model.Device
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.ListOfIdsAndRev
import com.icure.cardinal.sdk.model.PaginatedList
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.model.filter.chain.FilterChain
import com.icure.cardinal.sdk.model.specializations.AesExchangeKeyEncryptionKeypairIdentifier
import com.icure.cardinal.sdk.model.specializations.HexString
import com.icure.cardinal.sdk.serialization.DeviceAbstractFilterSerializer
import com.icure.cardinal.sdk.serialization.FilterChainSerializer
import com.icure.utils.InternalIcureApi
import io.ktor.client.request.accept
import io.ktor.client.request.parameter
import io.ktor.client.request.setBody
import io.ktor.http.ContentType.Application
import io.ktor.http.appendPathSegments
import io.ktor.http.contentType
import io.ktor.http.takeFrom
import io.ktor.util.date.GMTDate
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
class RawDeviceApiImpl(
	internal val apiUrl: String,
	private val authProvider: AuthProvider,
	rawApiConfig: RawApiConfig,
) : BaseRawApi(rawApiConfig), RawDeviceApi {
	// region common endpoints

	override suspend fun getDevice(deviceId: String): HttpResponse<Device> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "device", deviceId)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun getDevices(deviceIds: ListOfIds): HttpResponse<List<Device>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "device", "byIds")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(deviceIds)
		}.wrap()

	override suspend fun createDevice(p: Device): HttpResponse<Device> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "device")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(p)
		}.wrap()

	override suspend fun updateDevice(deviceDto: Device): HttpResponse<Device> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "device")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(deviceDto)
		}.wrap()

	override suspend fun createDevices(deviceDtos: List<Device>): HttpResponse<List<Device>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "device", "bulk")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(deviceDtos)
		}.wrap()

	override suspend fun updateDevices(deviceDtos: List<Device>): HttpResponse<List<Device>> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "device", "bulk")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(deviceDtos)
		}.wrap()

	override suspend fun filterDevicesBy(
		startDocumentId: String?,
		limit: Int?,
		filterChain: FilterChain<Device>,
	): HttpResponse<PaginatedList<Device>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "device", "filter")
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBodyWithSerializer(FilterChainSerializer(DeviceAbstractFilterSerializer), filterChain)
		}.wrap()

	override suspend fun getDeviceAesExchangeKeysForDelegate(
		deviceId: String,
	): HttpResponse<Map<String, Map<String, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "device", deviceId, "aesExchangeKeys")
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun matchDevicesBy(filter: AbstractFilter<Device>): HttpResponse<List<String>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "device", "match")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBodyWithSerializer(DeviceAbstractFilterSerializer, filter)
		}.wrap()

	override suspend fun deleteDevices(deviceIds: ListOfIds): HttpResponse<List<DocIdentifier>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "device", "delete", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(deviceIds)
		}.wrap()

	override suspend fun deleteDevicesWithRev(deviceIds: ListOfIdsAndRev): HttpResponse<List<DocIdentifier>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "device", "delete", "batch", "withrev")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(deviceIds)
		}.wrap()

	override suspend fun deleteDevice(
		deviceId: String,
		rev: String?,
	): HttpResponse<DocIdentifier> =
		delete(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "device", deviceId)
				parameter("rev", rev)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun undeleteDevice(
		deviceId: String,
		rev: String,
	): HttpResponse<Device> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "device", "undelete", deviceId)
				parameter("rev", rev)
			}
			contentType(Application.Json)
			accept(Application.Json)
		}.wrap()

	override suspend fun undeleteDevices(deviceIds: ListOfIdsAndRev): HttpResponse<List<Device>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "device", "undelete", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(deviceIds)
		}.wrap()

	override suspend fun purgeDevice(
		deviceId: String,
		rev: String,
	): HttpResponse<DocIdentifier> =
		delete(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "device", "purge", deviceId)
				parameter("rev", rev)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun purgeDevices(deviceIds: ListOfIdsAndRev): HttpResponse<List<DocIdentifier>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "device", "purge", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(deviceIds)
		}.wrap()

	// endregion

	// region cloud endpoints

	override suspend fun getDeviceInGroup(
		groupId: String,
		deviceId: String,
	): HttpResponse<Device> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "device", "inGroup", groupId, deviceId)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun getDevicesInGroup(
		groupId: String,
		deviceIds: ListOfIds,
	): HttpResponse<List<Device>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "device", "inGroup", groupId, "byIds")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(deviceIds)
		}.wrap()

	override suspend fun modifyDeviceInGroup(
		groupId: String,
		deviceDto: Device,
	): HttpResponse<Device> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "device", "inGroup", groupId)
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(deviceDto)
		}.wrap()

	override suspend fun modifyDevicesInGroup(
		groupId: String,
		deviceDtos: List<Device>,
	): HttpResponse<List<Device>> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "device", "inGroup", groupId, "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(deviceDtos)
		}.wrap()

	override suspend fun createDeviceInGroup(
		groupId: String,
		deviceDto: Device,
	): HttpResponse<Device> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "device", "inGroup", groupId)
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(deviceDto)
		}.wrap()

	override suspend fun createDevicesInGroup(
		groupId: String,
		deviceDtos: List<Device>,
	): HttpResponse<List<Device>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "device", "inGroup", groupId, "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(deviceDtos)
		}.wrap()

	override suspend fun deleteDeviceInGroup(
		groupId: String,
		deviceId: String,
		rev: String,
	): HttpResponse<DocIdentifier> =
		delete(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "device", "inGroup", groupId, deviceId)
				parameter("rev", rev)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun deleteDevicesInGroupWithRev(
		groupId: String,
		deviceIds: ListOfIdsAndRev,
	): HttpResponse<List<DocIdentifier>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "device", "inGroup", groupId, "delete", "batch", "withrev")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(deviceIds)
		}.wrap()

	override suspend fun undeleteDeviceInGroup(
		groupId: String,
		deviceId: String,
		rev: String,
	): HttpResponse<Device> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "device", "inGroup", groupId, "undelete", deviceId)
				parameter("rev", rev)
			}
			contentType(Application.Json)
			accept(Application.Json)
		}.wrap()

	override suspend fun undeleteDevicesInGroup(
		groupId: String,
		deviceIds: ListOfIdsAndRev,
	): HttpResponse<List<Device>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "device", "inGroup", groupId, "undelete", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(deviceIds)
		}.wrap()

	override suspend fun purgeDeviceInGroup(
		groupId: String,
		deviceId: String,
		rev: String,
	): HttpResponse<DocIdentifier> =
		delete(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "device", "inGroup", groupId, "purge", deviceId)
				parameter("rev", rev)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun purgeDevicesInGroup(
		groupId: String,
		deviceIds: ListOfIdsAndRev,
	): HttpResponse<List<DocIdentifier>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "device", "inGroup", groupId, "purge", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(deviceIds)
		}.wrap()

	override suspend fun matchDevicesInGroupBy(
		groupId: String,
		filter: AbstractFilter<Device>,
	): HttpResponse<List<String>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "device", "inGroup", groupId, "match")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBodyWithSerializer(DeviceAbstractFilterSerializer, filter)
		}.wrap()

	// endregion
}
