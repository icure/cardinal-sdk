package com.icure.cardinal.sdk.api.raw

import com.icure.cardinal.sdk.model.EncryptedSecureDelegationKeyMap
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.requests.BulkShareOrUpdateMetadataParams
import com.icure.cardinal.sdk.model.requests.EntityBulkShareResult
import com.icure.utils.InternalIcureApi
import kotlin.String
import kotlin.collections.List

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
public interface RawSecureDelegationKeyMapApi {
	// region common endpoints

	suspend fun createSecureDelegationKeyMap(
		secureDelegationKeyMap: EncryptedSecureDelegationKeyMap,
		accessControlKeysHeaderValues: List<String>,
	): HttpResponse<EncryptedSecureDelegationKeyMap>

	suspend fun findByDelegationKeys(
		delegationKeys: ListOfIds,
		accessControlKeysHeaderValues: List<String>,
	): HttpResponse<List<EncryptedSecureDelegationKeyMap>>

	suspend fun bulkShare(
		request: BulkShareOrUpdateMetadataParams,
		accessControlKeysHeaderValues: List<String>,
	): HttpResponse<List<EntityBulkShareResult<EncryptedSecureDelegationKeyMap>>>
	// endregion

	// region cloud endpoints

	suspend fun createSecureDelegationKeyMap(
		secureDelegationKeyMap: EncryptedSecureDelegationKeyMap,
		groupId: String,
		accessControlKeysHeaderValues: List<String>,
	): HttpResponse<EncryptedSecureDelegationKeyMap>

	suspend fun findByDelegationKeys(
		delegationKeys: ListOfIds,
		groupId: String,
		accessControlKeysHeaderValues: List<String>,
	): HttpResponse<List<EncryptedSecureDelegationKeyMap>>

	suspend fun bulkShare(
		request: BulkShareOrUpdateMetadataParams,
		groupId: String,
		accessControlKeysHeaderValues: List<String>,
	): HttpResponse<List<EntityBulkShareResult<EncryptedSecureDelegationKeyMap>>>
	// endregion
}
