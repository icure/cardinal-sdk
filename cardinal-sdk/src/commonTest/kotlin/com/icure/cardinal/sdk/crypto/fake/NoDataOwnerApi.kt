package com.icure.cardinal.sdk.crypto.fake

import com.icure.cardinal.sdk.api.DataOwnerApi
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.model.CryptoActorStubWithType
import com.icure.cardinal.sdk.model.DataOwnerType
import com.icure.cardinal.sdk.model.DataOwnerWithType
import com.icure.cardinal.sdk.model.base.DataOwnerHierarchyInfo

object NoDataOwnerApi : DataOwnerApi {
	override suspend fun getCurrentDataOwner(): DataOwnerWithType {
		TODO("Not yet implemented")
	}

	override suspend fun getCurrentDataOwnerStub(): CryptoActorStubWithType {
		TODO("Not yet implemented")
	}

	override suspend fun getCurrentDataOwnerId(): String {
		TODO("Not yet implemented")
	}

	override suspend fun getCurrentDataOwnerReference(): EntityReferenceInGroup {
		TODO("Not yet implemented")
	}

	override suspend fun getCurrentDataOwnerHierarchyIds(): DataOwnerHierarchyInfo {
		TODO("Not yet implemented")
	}

	override suspend fun getDataOwner(ownerId: String): DataOwnerWithType {
		TODO("Not yet implemented")
	}

	override suspend fun getDataOwners(ids: Set<String>): List<DataOwnerWithType> {
		TODO("Not yet implemented")
	}

	override suspend fun getDataOwnersWithKnownType(ids: Set<String>, type: DataOwnerType): List<DataOwnerWithType> {
		TODO("Not yet implemented")
	}

	override suspend fun getCryptoActorStub(ownerId: String): CryptoActorStubWithType {
		TODO("Not yet implemented")
	}

	override suspend fun getCryptoActorStubInGroup(entityReferenceInGroup: EntityReferenceInGroup): CryptoActorStubWithType {
		TODO("Not yet implemented")
	}

	override suspend fun getCurrentDataOwnerParentHierarchy(from: String?): DataOwnerHierarchyInfo {
		TODO("Not yet implemented")
	}

	override suspend fun modifyDataOwnerStub(cryptoActorStubWithTypeDto: CryptoActorStubWithType): CryptoActorStubWithType {
		TODO("Not yet implemented")
	}

	override suspend fun getCurrentDataOwnerType(): DataOwnerType {
		TODO("Not yet implemented")
	}

	override fun clearCurrentDataOwnerHierarchyCache() {
		TODO("Not yet implemented")
	}

	override suspend fun getCryptoActorStubs(ids: Set<String>): List<CryptoActorStubWithType> {
		TODO("Not yet implemented")
	}
}
