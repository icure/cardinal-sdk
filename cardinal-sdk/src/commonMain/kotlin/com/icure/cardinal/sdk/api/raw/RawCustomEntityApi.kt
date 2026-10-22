package com.icure.cardinal.sdk.api.raw

import com.icure.cardinal.sdk.model.EncryptedCustomEntityBase
import com.icure.cardinal.sdk.model.IcureStub
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

	suspend fun createCustomEntity(entityDto: EncryptedCustomEntityBase): HttpResponse<EncryptedCustomEntityBase>

	suspend fun createCustomEntities(entityDtos: List<EncryptedCustomEntityBase>): HttpResponse<List<EncryptedCustomEntityBase>>

	suspend fun getCustomEntity(entityId: String): HttpResponse<EncryptedCustomEntityBase>

	suspend fun getCustomEntities(entityIds: ListOfIds): HttpResponse<List<EncryptedCustomEntityBase>>

	suspend fun findCustomEntitiesDelegationsStubsByIds(entityIds: ListOfIds): HttpResponse<List<IcureStub>>

	suspend fun modifyCustomEntity(customEntityDto: EncryptedCustomEntityBase): HttpResponse<EncryptedCustomEntityBase>

	suspend fun modifyCustomEntities(customEntityDtos: List<EncryptedCustomEntityBase>): HttpResponse<List<EncryptedCustomEntityBase>>

	suspend fun deleteCustomEntity(
		entityId: String,
		rev: String? = null,
	): HttpResponse<DocIdentifier>

	suspend fun deleteCustomEntities(entityIds: ListOfIdsAndRev): HttpResponse<List<DocIdentifier>>

	suspend fun undeleteCustomEntity(
		entityId: String,
		rev: String,
	): HttpResponse<EncryptedCustomEntityBase>

	suspend fun undeleteCustomEntities(entityIds: ListOfIdsAndRev): HttpResponse<List<EncryptedCustomEntityBase>>

	suspend fun purgeCustomEntity(
		entityId: String,
		rev: String,
	): HttpResponse<DocIdentifier>

	suspend fun purgeCustomEntities(entityIds: ListOfIdsAndRev): HttpResponse<List<DocIdentifier>>

	suspend fun bulkShare(request: BulkShareOrUpdateMetadataParams): HttpResponse<List<EntityBulkShareResult<EncryptedCustomEntityBase>>>

	suspend fun bulkShareMinimal(request: BulkShareOrUpdateMetadataParams): HttpResponse<List<EntityBulkShareResult<Nothing>>>

	suspend fun getAttachment(
		entityId: String,
		key: String,
		fileName: String? = null,
	): HttpResponse<ByteArray>

	suspend fun setAttachment(
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
		entityId: String,
		key: String,
		rev: String,
	): HttpResponse<EncryptedCustomEntityBase>
	// endregion

	// region cloud endpoints

	suspend fun createCustomEntityInGroup(
		groupId: String,
		entityDto: EncryptedCustomEntityBase,
	): HttpResponse<EncryptedCustomEntityBase>

	suspend fun createCustomEntitiesInGroup(
		groupId: String,
		entityDtos: List<EncryptedCustomEntityBase>,
	): HttpResponse<List<EncryptedCustomEntityBase>>

	suspend fun getCustomEntityInGroup(
		groupId: String,
		entityId: String,
	): HttpResponse<EncryptedCustomEntityBase>

	suspend fun getCustomEntitiesInGroup(
		groupId: String,
		entityIds: ListOfIds,
	): HttpResponse<List<EncryptedCustomEntityBase>>

	suspend fun modifyCustomEntityInGroup(
		groupId: String,
		customEntityDto: EncryptedCustomEntityBase,
	): HttpResponse<EncryptedCustomEntityBase>

	suspend fun modifyCustomEntitiesInGroup(
		groupId: String,
		customEntityDtos: List<EncryptedCustomEntityBase>,
	): HttpResponse<List<EncryptedCustomEntityBase>>

	suspend fun deleteCustomEntityInGroup(
		groupId: String,
		entityId: String,
		rev: String? = null,
	): HttpResponse<DocIdentifier>

	suspend fun deleteCustomEntitiesInGroup(
		groupId: String,
		entityIds: ListOfIdsAndRev,
	): HttpResponse<List<DocIdentifier>>

	suspend fun undeleteCustomEntityInGroup(
		groupId: String,
		entityId: String,
		rev: String,
	): HttpResponse<EncryptedCustomEntityBase>

	suspend fun undeleteCustomEntitiesInGroup(
		groupId: String,
		entityIds: ListOfIdsAndRev,
	): HttpResponse<List<EncryptedCustomEntityBase>>

	suspend fun purgeCustomEntityInGroup(
		groupId: String,
		entityId: String,
		rev: String,
	): HttpResponse<DocIdentifier>

	suspend fun purgeCustomEntitiesInGroup(
		groupId: String,
		entityIds: ListOfIdsAndRev,
	): HttpResponse<List<DocIdentifier>>

	suspend fun bulkShareInGroup(
		groupId: String,
		request: BulkShareOrUpdateMetadataParams,
	): HttpResponse<List<EntityBulkShareResult<EncryptedCustomEntityBase>>>
	// endregion
}
