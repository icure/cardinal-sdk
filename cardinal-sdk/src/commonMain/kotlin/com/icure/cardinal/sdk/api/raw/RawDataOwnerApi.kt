package com.icure.cardinal.sdk.api.raw

import com.icure.cardinal.sdk.model.CryptoActorStubWithType
import com.icure.cardinal.sdk.model.DataOwnerWithType
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.utils.InternalIcureApi
import kotlin.String
import kotlin.collections.List

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
public interface RawDataOwnerApi {
	// region common endpoints

	suspend fun getDataOwner(dataOwnerId: String): HttpResponse<DataOwnerWithType>

	suspend fun getDataOwners(dataOwnerIds: ListOfIds): HttpResponse<List<DataOwnerWithType>>

	suspend fun getDataOwnerStub(dataOwnerId: String): HttpResponse<CryptoActorStubWithType>

	suspend fun getDataOwnerStubs(dataOwnerIds: ListOfIds): HttpResponse<List<CryptoActorStubWithType>>

	suspend fun modifyDataOwnerStub(updated: CryptoActorStubWithType): HttpResponse<CryptoActorStubWithType>

	suspend fun getCurrentDataOwner(): HttpResponse<DataOwnerWithType>

	suspend fun getCurrentDataOwnerStub(): HttpResponse<CryptoActorStubWithType>

	suspend fun getCurrentDataOwnerHierarchy(): HttpResponse<List<DataOwnerWithType>>

	suspend fun getCurrentDataOwnerHierarchyStub(): HttpResponse<List<CryptoActorStubWithType>>
	// endregion

	// region cloud endpoints

	suspend fun getCryptoActorStubInGroup(
		groupId: String,
		dataOwnerId: String,
	): HttpResponse<CryptoActorStubWithType>
	// endregion
}
