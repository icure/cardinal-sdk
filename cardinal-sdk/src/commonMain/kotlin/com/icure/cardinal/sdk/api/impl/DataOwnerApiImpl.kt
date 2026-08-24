package com.icure.cardinal.sdk.api.impl

import com.icure.cardinal.sdk.api.DataOwnerApi
import com.icure.cardinal.sdk.api.raw.RawDataOwnerApi
import com.icure.cardinal.sdk.api.raw.RawDeviceApi
import com.icure.cardinal.sdk.api.raw.RawHealthcarePartyApi
import com.icure.cardinal.sdk.api.raw.RawPatientApi
import com.icure.cardinal.sdk.api.raw.successBodyOrThrowRevisionConflict
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.crypto.entities.SdkBoundGroup
import com.icure.cardinal.sdk.crypto.entities.resolve
import com.icure.cardinal.sdk.model.CryptoActorStubWithType
import com.icure.cardinal.sdk.model.DataOwnerType
import com.icure.cardinal.sdk.model.DataOwnerWithType
import com.icure.cardinal.sdk.model.GroupScoped
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.base.CryptoActor
import com.icure.cardinal.sdk.model.base.DataOwnerGroupLinkType
import com.icure.cardinal.sdk.model.base.DataOwnerHierarchyInfo
import com.icure.cardinal.sdk.model.extensions.asStub
import com.icure.cardinal.sdk.model.extensions.publicKeysSpki
import com.icure.cardinal.sdk.model.requests.PublicKeyInfo
import com.icure.cardinal.sdk.model.requests.RsaEncryptionAlgorithm
import com.icure.cardinal.sdk.model.specializations.SpkiHexString
import com.icure.cardinal.sdk.utils.IllegalEntityException
import com.icure.cardinal.sdk.utils.SingleValueAsyncCache
import com.icure.cardinal.sdk.utils.pagination.exhaustPaginatedRequest
import com.icure.kryptom.crypto.RsaAlgorithm
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonPrimitive

@OptIn(InternalIcureApi::class)
class DataOwnerApiImpl(
	private val rawApi: RawDataOwnerApi,
	private val rawHealthcarePartyApi: RawHealthcarePartyApi,
	private val rawPatientApi: RawPatientApi,
	private val rawDeviceApi: RawDeviceApi,
	private val boundGroup: SdkBoundGroup?,
) : DataOwnerApi {
	companion object {
		private const val RETRIEVE_GROUP_CHUNK_LIMIT = 10
	}

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

	override suspend fun getCurrentDataOwnerHierarchyInfo(): DataOwnerHierarchyInfo =
		getOrCacheInfo()

	override suspend fun getCryptoActorStubs(ids: Set<String>): List<CryptoActorStubWithType> =
		rawApi.getDataOwnerStubs(ListOfIds(ids.toList())).successBody()

	override suspend fun getSimpleGroupDelegateMembersIds(dataOwnerGroup: CryptoActorStubWithType, groupId: String?): Set<String> {
		require (dataOwnerGroup.stub.groupLinkType == DataOwnerGroupLinkType.Simple) {
			"Only simple groups are supported"
		}
		val remainingChunks = ArrayDeque<String>()
		remainingChunks.add(dataOwnerGroup.stub.id)
		val expanded = mutableSetOf(dataOwnerGroup.stub.id)
		val result = mutableSetOf<String>()
		val resolvedGroup = boundGroup.resolve(groupId)
		while (remainingChunks.isNotEmpty()) {
			val currRetrieveChunk = List(minOf(RETRIEVE_GROUP_CHUNK_LIMIT, remainingChunks.size)) { remainingChunks.removeFirst() }
			exhaustPaginatedRequest { next ->
				val nextGroups = (
					if (next == null) {
						JsonArray(currRetrieveChunk.map { JsonPrimitive(it) })
					} else {
						next.startKey
					}
				).toString()
				resolvedGroup?.let {
					rawApi.findDataOwnersLinkedToGroups(
						dataOwnerType = dataOwnerGroup.type.dtoSerialName,
						dataOwnerGroupIds = nextGroups,
						startDocumentId = next?.startKeyDocId,
						groupId = it,
					).successBody()
				} ?: rawApi.findDataOwnersLinkedToGroups(
					dataOwnerType = dataOwnerGroup.type.dtoSerialName,
					dataOwnerGroupIds = nextGroups,
					startDocumentId = next?.startKeyDocId,
				).successBody()
			}.collect {
				if (it.effectiveGroupLinkTypeFor(dataOwnerGroup.type) == DataOwnerGroupLinkType.Simple) {
					if (expanded.add(it.dataOwnerId)) {
						remainingChunks.add(it.dataOwnerId)
					}
				} else {
					result.add(it.dataOwnerId)
				}
			}
		}
		return result
	}

	override suspend fun getDataOwnersPublicKeys(
		dataOwnerType: DataOwnerType,
		dataOwners: Set<String>,
		groupId: String?,
	): Map<String, Map<SpkiHexString, RsaAlgorithm.RsaEncryptionAlgorithm>> {
		val result = mutableMapOf<String, Map<SpkiHexString, RsaAlgorithm.RsaEncryptionAlgorithm>>()
		val resolvedGroup = boundGroup.resolve(groupId)
		dataOwners.chunked(1000).forEach { chunk ->
			val currChunkResult = resolvedGroup?.let {
				rawApi.getDataOwnersPublicKeys(
					dataOwnerType = dataOwnerType.dtoSerialName,
					dataOwnerIds = ListOfIds(chunk),
					groupId = it,
				).successBody()
			} ?: rawApi.getDataOwnersPublicKeys(
				dataOwnerType = dataOwnerType.dtoSerialName,
				dataOwnerIds = ListOfIds(chunk),
			).successBody()
			currChunkResult.forEach {
				result[it.dataOwnerId] = it.publicKeys.associate { k ->
					k.publicKey to when (k.algorithm) {
						RsaEncryptionAlgorithm.OaepWithSha1 -> RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha1
						RsaEncryptionAlgorithm.OaepWithSha256 -> RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha256
					}
				}
			}
		}
		return result
	}
}
