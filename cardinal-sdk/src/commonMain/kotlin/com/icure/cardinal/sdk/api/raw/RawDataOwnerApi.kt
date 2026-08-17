package com.icure.cardinal.sdk.api.raw

import com.icure.cardinal.sdk.model.CryptoActorStubWithType
import com.icure.cardinal.sdk.model.DataOwnerWithType
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.PaginatedList
import com.icure.cardinal.sdk.model.base.DataOwnerHierarchyInfo
import com.icure.cardinal.sdk.model.requests.DataOwnerPublicKeys
import com.icure.cardinal.sdk.model.requests.LinkedDataOwner
import com.icure.utils.InternalIcureApi
import kotlin.Int
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

	suspend fun getCurrentDataOwnerHierarchyInfo(): HttpResponse<DataOwnerHierarchyInfo>

	suspend fun findDataOwnersLinkedToGroups(
		dataOwnerType: String,
		dataOwnerGroupIds: String,
		startDocumentId: String? = null,
		limit: Int? = null,
	): HttpResponse<PaginatedList<LinkedDataOwner>>

	suspend fun getDataOwnersPublicKeys(
		dataOwnerType: String,
		dataOwnerIds: ListOfIds,
	): HttpResponse<List<DataOwnerPublicKeys>>
	// endregion

	// region cloud endpoints

	suspend fun getCryptoActorStubInGroup(
		groupId: String,
		dataOwnerId: String,
	): HttpResponse<CryptoActorStubWithType>

	suspend fun findDataOwnersLinkedToGroups(
		dataOwnerType: String,
		dataOwnerGroupIds: String,
		startDocumentId: String? = null,
		limit: Int? = null,
		groupId: String,
	): HttpResponse<PaginatedList<LinkedDataOwner>>

	suspend fun getDataOwnersPublicKeys(
		dataOwnerType: String,
		dataOwnerIds: ListOfIds,
		groupId: String,
	): HttpResponse<List<DataOwnerPublicKeys>>
	// endregion
}
