package com.icure.cardinal.sdk.api.raw

import com.icure.cardinal.sdk.model.EncryptedCustomEntityBase
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.ListOfIdsAndRev
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.model.requests.BulkShareOrUpdateMetadataParams
import com.icure.cardinal.sdk.model.requests.EntityBulkShareResult
import com.icure.utils.InternalIcureApi
import kotlin.Boolean
import kotlin.ByteArray
import kotlin.Long
import kotlin.Nothing
import kotlin.String
import kotlin.collections.List

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
public interface RawCustomEntityApi {
	// region common endpoints

	suspend fun createCustomEntity(
		entityType: String,
		entityDto: EncryptedCustomEntityBase,
	): HttpResponse<EncryptedCustomEntityBase>

	suspend fun createCustomEntities(
		entityType: String,
		entityDtos: List<EncryptedCustomEntityBase>,
	): HttpResponse<List<EncryptedCustomEntityBase>>

	suspend fun getCustomEntity(
		entityType: String,
		entityId: String,
	): HttpResponse<EncryptedCustomEntityBase>

	suspend fun getCustomEntities(
		entityType: String,
		entityIds: ListOfIds,
	): HttpResponse<List<EncryptedCustomEntityBase>>

	suspend fun modifyCustomEntity(
		entityType: String,
		customEntityDto: EncryptedCustomEntityBase,
	): HttpResponse<EncryptedCustomEntityBase>

	suspend fun modifyCustomEntities(
		entityType: String,
		customEntityDtos: List<EncryptedCustomEntityBase>,
	): HttpResponse<List<EncryptedCustomEntityBase>>

	suspend fun deleteCustomEntity(
		entityType: String,
		entityId: String,
		rev: String? = null,
	): HttpResponse<DocIdentifier>

	suspend fun deleteCustomEntities(
		entityType: String,
		entityIds: ListOfIdsAndRev,
	): HttpResponse<List<DocIdentifier>>

	suspend fun undeleteCustomEntity(
		entityType: String,
		entityId: String,
		rev: String,
	): HttpResponse<EncryptedCustomEntityBase>

	suspend fun undeleteCustomEntities(
		entityType: String,
		entityIds: ListOfIdsAndRev,
	): HttpResponse<List<EncryptedCustomEntityBase>>

	suspend fun purgeCustomEntity(
		entityType: String,
		entityId: String,
		rev: String,
	): HttpResponse<DocIdentifier>

	suspend fun purgeCustomEntities(
		entityType: String,
		entityIds: ListOfIdsAndRev,
	): HttpResponse<List<DocIdentifier>>

	suspend fun bulkShare(
		entityType: String,
		request: BulkShareOrUpdateMetadataParams,
	): HttpResponse<List<EntityBulkShareResult<EncryptedCustomEntityBase>>>

	suspend fun bulkShareMinimal(
		entityType: String,
		request: BulkShareOrUpdateMetadataParams,
	): HttpResponse<List<EntityBulkShareResult<Nothing>>>

	suspend fun getAttachment(
		entityType: String,
		entityId: String,
		key: String,
		fileName: String? = null,
	): HttpResponse<ByteArray>

	suspend fun setAttachment(
		entityType: String,
		entityId: String,
		key: String,
		rev: String,
		utis: List<String>? = null,
		compressionAlgorithm: String? = null,
		triedCompressionAlgorithmsVersion: String? = null,
		realDataSize: Long? = null,
		payload: ByteArray,
		lengthHeader: Long?,
		encrypted: Boolean? = null,
	): HttpResponse<EncryptedCustomEntityBase>

	suspend fun deleteAttachment(
		entityType: String,
		entityId: String,
		key: String,
		rev: String,
	): HttpResponse<EncryptedCustomEntityBase>
	// endregion
}
