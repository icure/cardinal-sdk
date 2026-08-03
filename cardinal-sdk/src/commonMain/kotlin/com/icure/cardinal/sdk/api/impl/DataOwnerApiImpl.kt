package com.icure.cardinal.sdk.api.impl

import com.icure.cardinal.sdk.api.DataOwnerApi
import com.icure.cardinal.sdk.api.raw.RawDataOwnerApi
import com.icure.cardinal.sdk.api.raw.RawDeviceApi
import com.icure.cardinal.sdk.api.raw.RawHealthcarePartyApi
import com.icure.cardinal.sdk.api.raw.RawPatientApi
import com.icure.cardinal.sdk.api.raw.successBodyOrThrowRevisionConflict
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.crypto.entities.SdkBoundGroup
import com.icure.cardinal.sdk.model.CryptoActorStubWithType
import com.icure.cardinal.sdk.model.DataOwnerType
import com.icure.cardinal.sdk.model.DataOwnerWithType
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.base.CryptoActor
import com.icure.cardinal.sdk.model.base.DataOwnerHierarchyInfo
import com.icure.cardinal.sdk.model.extensions.asStub
import com.icure.cardinal.sdk.model.extensions.publicKeysSpki
import com.icure.cardinal.sdk.utils.IllegalEntityException
import com.icure.cardinal.sdk.utils.SingleValueAsyncCache
import com.icure.utils.InternalIcureApi

@OptIn(InternalIcureApi::class)
class DataOwnerApiImpl(
	private val rawApi: RawDataOwnerApi,
	private val rawHealthcarePartyApi: RawHealthcarePartyApi,
	private val rawPatientApi: RawPatientApi,
	private val rawDeviceApi: RawDeviceApi,
	private val boundGroup: SdkBoundGroup?,
) : DataOwnerApi {
	private val dataOwnerInfoCache: SingleValueAsyncCache<DataOwnerHierarchyInfo, DataOwnerHierarchyInfo> =
		SingleValueAsyncCache()

	override suspend fun getCurrentDataOwner(): DataOwnerWithType =
		rawApi.getCurrentDataOwner().successBody()

	override suspend fun getCurrentDataOwnerStub(): CryptoActorStubWithType =
		getCurrentDataOwner().asStub()

	override suspend fun getCurrentDataOwnerId(): String =
		getOrCacheInfo().id

	override suspend fun getDataOwner(ownerId: String): DataOwnerWithType =
		rawApi.getDataOwner(dataOwnerId = ownerId).successBody()

	override suspend fun getDataOwners(ids: Set<String>): List<DataOwnerWithType> =
		rawApi.getDataOwners(ListOfIds(ids.toList())).successBody()

	override suspend fun getDataOwnersWithKnownType(ids: Set<String>, type: DataOwnerType): List<DataOwnerWithType> {
		val listOfIds = ListOfIds(ids.toList())
		return when (type) {
			DataOwnerType.Hcp -> rawHealthcarePartyApi.getHealthcareParties(listOfIds).successBody().map { DataOwnerWithType.HcpDataOwner(it) }
			DataOwnerType.Patient -> rawPatientApi.getPatients(listOfIds).successBody().map { DataOwnerWithType.PatientDataOwner(it) }
			DataOwnerType.Device -> rawDeviceApi.getDevices(listOfIds).successBody().map { DataOwnerWithType.DeviceDataOwner(it) }
		}
	}

	override suspend fun getCryptoActorStub(ownerId: String): CryptoActorStubWithType =
		rawApi.getDataOwnerStub(dataOwnerId = ownerId).successBody()

	override suspend fun modifyDataOwnerStub(cryptoActorStubWithTypeDto: CryptoActorStubWithType): CryptoActorStubWithType =
		rawApi.modifyDataOwnerStub(updated = cryptoActorStubWithTypeDto).successBodyOrThrowRevisionConflict()

	override suspend fun getCurrentDataOwnerType(): DataOwnerType =
		getOrCacheInfo().dataOwnerType

	override fun clearCurrentDataOwnerHierarchyCache() {
		dataOwnerInfoCache.deleteCache()
	}

	// Left will always be available, taken from the cache or cached; second will be available only if the caller is
	// the user actually filling the cache.
	private suspend fun getOrCacheInfo(): DataOwnerHierarchyInfo =
		dataOwnerInfoCache.getCachedOrRetrieve {
			rawApi.getCurrentDataOwnerHierarchyInfo().successBody().let { it to it }
		}.first

	override suspend fun getCryptoActorStubInGroup(entityReferenceInGroup: EntityReferenceInGroup): CryptoActorStubWithType {
		val dataOwnerGroup = entityReferenceInGroup.normalized(boundGroup).groupId
		return if (dataOwnerGroup == null) {
			rawApi.getDataOwnerStub(dataOwnerId = entityReferenceInGroup.entityId).successBody()
		} else {
			rawApi.getCryptoActorStubInGroup(groupId = dataOwnerGroup, dataOwnerId = entityReferenceInGroup.entityId).successBody()
		}
	}

	override suspend fun getCurrentDataOwnerReference(): EntityReferenceInGroup =
		EntityReferenceInGroup(getCurrentDataOwnerId(), null)

	override suspend fun getCurrentDataOwnerHierarchyIds(): DataOwnerHierarchyInfo =
		getOrCacheInfo()

	override suspend fun getCurrentDataOwnerParentHierarchy(from: String?): DataOwnerHierarchyInfo =
		getOrCacheInfo().parentHierarchy(from)

	override suspend fun getCryptoActorStubs(ids: Set<String>): List<CryptoActorStubWithType> =
		rawApi.getDataOwnerStubs(ListOfIds(ids.toList())).successBody()
}
