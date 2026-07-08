package com.icure.cardinal.sdk.api.impl

import com.icure.cardinal.sdk.api.DataOwnerApi
import com.icure.cardinal.sdk.api.raw.RawDataOwnerApi
import com.icure.cardinal.sdk.api.raw.successBodyOrThrowRevisionConflict
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.crypto.entities.SdkBoundGroup
import com.icure.cardinal.sdk.model.CryptoActorStubWithType
import com.icure.cardinal.sdk.model.DataOwnerType
import com.icure.cardinal.sdk.model.DataOwnerWithType
import com.icure.cardinal.sdk.model.HealthcareParty
import com.icure.cardinal.sdk.model.base.CryptoActor
import com.icure.cardinal.sdk.model.extensions.asStub
import com.icure.cardinal.sdk.model.extensions.publicKeysSpki
import com.icure.cardinal.sdk.model.extensions.type
import com.icure.cardinal.sdk.utils.IllegalEntityException
import com.icure.cardinal.sdk.utils.SingleValueAsyncCache
import com.icure.utils.InternalIcureApi

@OptIn(InternalIcureApi::class)
class DataOwnerApiImpl(
	private val rawApi: RawDataOwnerApi,
	private val boundGroup: SdkBoundGroup?,
) : DataOwnerApi {
	private data class DataOwnerInfo(
		val hierarchy: List<String>,
		val type: DataOwnerType,
	)
	private val dataOwnerInfoCache: SingleValueAsyncCache<DataOwnerInfo, List<DataOwnerWithType>> =
		SingleValueAsyncCache()

	override suspend fun getCurrentDataOwner(): DataOwnerWithType =
		rawApi.getCurrentDataOwner().successBody()

	override suspend fun getCurrentDataOwnerStub(): CryptoActorStubWithType =
		getCurrentDataOwner().asStub()

	override suspend fun getCurrentDataOwnerId(): String =
		getOrCacheInfo().first.hierarchy.last()

	override suspend fun getCurrentDataOwnerHierarchyIds(): List<String> =
		getOrCacheInfo().first.hierarchy

	override suspend fun getDataOwner(ownerId: String): DataOwnerWithType =
		rawApi.getDataOwner(dataOwnerId = ownerId).successBody()

	override suspend fun getCryptoActorStub(ownerId: String): CryptoActorStubWithType =
		rawApi.getDataOwnerStub(dataOwnerId = ownerId).successBody()

	override suspend fun getCurrentDataOwnerHierarchyIdsFrom(parentId: String): List<String> {
		getCurrentDataOwnerHierarchyIds()
			.indexOfFirst { it == parentId }
			.takeIf { it >= 0 }
			?.let { return getCurrentDataOwnerHierarchyIds().subList(0, it + 1) }
			?: throw IllegalArgumentException("$parentId is not part of the current data owner hierarchy")
	}

	override suspend fun getCurrentDataOwnerHierarchy(): List<DataOwnerWithType> =
		getOrCacheInfo().let { (cachedInfo, retrievedHierarchy) ->
			// TODO bulk get hierarchy
			retrievedHierarchy ?: cachedInfo.hierarchy.map { getDataOwner(it) }
		}

	override suspend fun modifyDataOwnerStub(cryptoActorStubWithTypeDto: CryptoActorStubWithType): CryptoActorStubWithType =
		rawApi.modifyDataOwnerStub(updated = cryptoActorStubWithTypeDto).successBodyOrThrowRevisionConflict()

	override suspend fun getCurrentDataOwnerType(): DataOwnerType =
		getOrCacheInfo().first.type

	override fun clearCurrentDataOwnerIdsCache() {
		dataOwnerInfoCache.deleteCache()
	}

	private val DataOwnerWithType.parentId: String? get() = (dataOwner as? HealthcareParty)?.parentId

	// Left will always be available, taken from the cache or cached; second will be available only if the caller is
	// the user actually filling the cache.
	private suspend fun getOrCacheInfo(): Pair<DataOwnerInfo, List<DataOwnerWithType>?> =
		dataOwnerInfoCache.getCachedOrRetrieve {
			// TODO method to get full hierarchy in one call to server.
			var curr = getCurrentDataOwner()
			val type = curr.type
			checkDataOwnerIntegrity(curr.dataOwner)
			val res = mutableListOf(curr)
			while (!curr.parentId.isNullOrEmpty()) {
				curr = getDataOwner(curr.parentId!!)
				res.add(curr)
			}
			res.reversed().let { hierarchy ->
				DataOwnerInfo(hierarchy.map { it.dataOwner.id }, type) to hierarchy
			}
		}

	private fun checkDataOwnerIntegrity(dataOwner: CryptoActor) {
		val keys = dataOwner.publicKeysSpki
		if (keys.distinct().size != keys.size) throw IllegalEntityException(
			"Different public keys for ${dataOwner.id} have the same fingerprint; this should not happen in normal circumstances. Please report this error to iCure."
		)
	}

	override suspend fun getCryptoActorStubInGroup(entityReferenceInGroup: EntityReferenceInGroup): CryptoActorStubWithType {
		val dataOwnerGroup = entityReferenceInGroup.normalized(boundGroup).groupId
		return if (dataOwnerGroup == null) {
			rawApi.getDataOwnerStub(dataOwnerId = entityReferenceInGroup.entityId).successBody()
		} else {
			rawApi.getCryptoActorStubInGroup(groupId = dataOwnerGroup, dataOwnerId = entityReferenceInGroup.entityId).successBody()
		}
	}

	override suspend fun getCurrentDataOwnerHierarchyIdsReference(): List<EntityReferenceInGroup> =
		getCurrentDataOwnerHierarchyIds().map { EntityReferenceInGroup(it, null) }

	override suspend fun getCurrentDataOwnerReference(): EntityReferenceInGroup =
		EntityReferenceInGroup(getCurrentDataOwnerId(), null)
}
