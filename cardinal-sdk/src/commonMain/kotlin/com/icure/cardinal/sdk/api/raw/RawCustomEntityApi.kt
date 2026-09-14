package com.icure.cardinal.sdk.api.raw

import com.icure.cardinal.sdk.model.CustomEntityBase
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.ListOfIdsAndRev
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.utils.InternalIcureApi
import kotlin.String
import kotlin.collections.List

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
public interface RawCustomEntityApi {
	// region common endpoints

	suspend fun createCustomEntity(
		entityType: String,
		entityDto: CustomEntityBase,
	): HttpResponse<CustomEntityBase>

	suspend fun createCustomEntities(
		entityType: String,
		entityDtos: List<CustomEntityBase>,
	): HttpResponse<List<CustomEntityBase>>

	suspend fun getCustomEntity(
		entityType: String,
		entityId: String,
	): HttpResponse<CustomEntityBase>

	suspend fun getCustomEntities(
		entityType: String,
		entityIds: ListOfIds,
	): HttpResponse<List<CustomEntityBase>>

	suspend fun modifyCustomEntity(
		entityType: String,
		customEntityDto: CustomEntityBase,
	): HttpResponse<CustomEntityBase>

	suspend fun modifyCustomEntities(
		entityType: String,
		customEntityDtos: List<CustomEntityBase>,
	): HttpResponse<List<CustomEntityBase>>

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
	): HttpResponse<CustomEntityBase>

	suspend fun undeleteCustomEntities(
		entityType: String,
		entityIds: ListOfIdsAndRev,
	): HttpResponse<List<CustomEntityBase>>

	suspend fun purgeCustomEntity(
		entityType: String,
		entityId: String,
		rev: String,
	): HttpResponse<DocIdentifier>

	suspend fun purgeCustomEntities(
		entityType: String,
		entityIds: ListOfIdsAndRev,
	): HttpResponse<List<DocIdentifier>>
	// endregion
}
