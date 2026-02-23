package com.icure.cardinal.sdk.api.raw

import com.icure.cardinal.sdk.model.EntityTemplate
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.ListOfIdsAndRev
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.utils.InternalIcureApi
import kotlin.Boolean
import kotlin.String
import kotlin.collections.List

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
public interface RawEntityTemplateApi {
	// region common endpoints

	suspend fun listEntityTemplatesBy(
		userId: String,
		type: String,
		searchString: String? = null,
		includeEntities: Boolean? = null,
	): HttpResponse<List<EntityTemplate>>

	suspend fun listAllEntityTemplatesBy(
		type: String,
		searchString: String? = null,
		includeEntities: Boolean? = null,
	): HttpResponse<List<EntityTemplate>>

	suspend fun listEntityTemplatesByKeyword(
		userId: String,
		type: String,
		keyword: String,
		includeEntities: Boolean? = null,
	): HttpResponse<List<EntityTemplate>>

	suspend fun findAllEntityTemplatesByKeyword(
		type: String,
		keyword: String,
		includeEntities: Boolean? = null,
	): HttpResponse<List<EntityTemplate>>

	suspend fun createEntityTemplate(c: EntityTemplate): HttpResponse<EntityTemplate>

	suspend fun getEntityTemplates(entityTemplateIds: ListOfIds): HttpResponse<List<EntityTemplate>>

	suspend fun getEntityTemplate(entityTemplateId: String): HttpResponse<EntityTemplate>

	suspend fun modifyEntityTemplate(entityTemplateDto: EntityTemplate): HttpResponse<EntityTemplate>

	suspend fun modifyEntityTemplates(entityTemplateDtos: List<EntityTemplate>): HttpResponse<List<EntityTemplate>>

	suspend fun createEntityTemplates(entityTemplateDtos: List<EntityTemplate>): HttpResponse<List<EntityTemplate>>

	suspend fun deleteEntityTemplates(entityTemplateIds: ListOfIds): HttpResponse<List<DocIdentifier>>

	suspend fun deleteEntityTemplatesWithRev(entityTemplateIds: ListOfIdsAndRev): HttpResponse<List<DocIdentifier>>
	// endregion
}
