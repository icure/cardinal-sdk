package com.icure.cardinal.sdk.api.raw.`impl`

import com.icure.cardinal.sdk.api.raw.BaseRawApi
import com.icure.cardinal.sdk.api.raw.HttpResponse
import com.icure.cardinal.sdk.api.raw.RawApiConfig
import com.icure.cardinal.sdk.api.raw.RawEntityTemplateApi
import com.icure.cardinal.sdk.api.raw.wrap
import com.icure.cardinal.sdk.auth.services.AuthProvider
import com.icure.cardinal.sdk.model.EntityTemplate
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.ListOfIdsAndRev
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.utils.InternalIcureApi
import io.ktor.client.request.accept
import io.ktor.client.request.parameter
import io.ktor.client.request.setBody
import io.ktor.http.ContentType.Application
import io.ktor.http.appendPathSegments
import io.ktor.http.contentType
import io.ktor.http.takeFrom
import io.ktor.util.date.GMTDate
import kotlin.Boolean
import kotlin.String
import kotlin.collections.List

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
class RawEntityTemplateApiImpl(
	internal val apiUrl: String,
	private val authProvider: AuthProvider,
	rawApiConfig: RawApiConfig,
) : BaseRawApi(rawApiConfig), RawEntityTemplateApi {
	// region common endpoints

	override suspend fun listEntityTemplatesBy(
		userId: String,
		type: String,
		searchString: String?,
		includeEntities: Boolean?,
	): HttpResponse<List<EntityTemplate>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "entitytemplate", "find", userId, type)
				parameter("searchString", searchString)
				parameter("includeEntities", includeEntities)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun listAllEntityTemplatesBy(
		type: String,
		searchString: String?,
		includeEntities: Boolean?,
	): HttpResponse<List<EntityTemplate>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "entitytemplate", "findAll", type)
				parameter("searchString", searchString)
				parameter("includeEntities", includeEntities)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun listEntityTemplatesByKeyword(
		userId: String,
		type: String,
		keyword: String,
		includeEntities: Boolean?,
	): HttpResponse<List<EntityTemplate>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "entitytemplate", "find", userId, type, "keyword", keyword)
				parameter("includeEntities", includeEntities)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun findAllEntityTemplatesByKeyword(
		type: String,
		keyword: String,
		includeEntities: Boolean?,
	): HttpResponse<List<EntityTemplate>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "entitytemplate", "findAll", type, "keyword", keyword)
				parameter("includeEntities", includeEntities)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun createEntityTemplate(c: EntityTemplate): HttpResponse<EntityTemplate> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "entitytemplate")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(c)
		}.wrap()

	override suspend fun getEntityTemplates(entityTemplateIds: ListOfIds): HttpResponse<List<EntityTemplate>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "entitytemplate", "byIds")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(entityTemplateIds)
		}.wrap()

	override suspend fun getEntityTemplate(entityTemplateId: String): HttpResponse<EntityTemplate> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "entitytemplate", entityTemplateId)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun modifyEntityTemplate(entityTemplateDto: EntityTemplate): HttpResponse<EntityTemplate> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "entitytemplate")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(entityTemplateDto)
		}.wrap()

	override suspend fun modifyEntityTemplates(entityTemplateDtos: List<EntityTemplate>): HttpResponse<List<EntityTemplate>> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "entitytemplate", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(entityTemplateDtos)
		}.wrap()

	override suspend fun createEntityTemplates(entityTemplateDtos: List<EntityTemplate>): HttpResponse<List<EntityTemplate>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "entitytemplate", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(entityTemplateDtos)
		}.wrap()

	override suspend fun deleteEntityTemplates(entityTemplateIds: ListOfIds): HttpResponse<List<DocIdentifier>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "entitytemplate", "delete", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(entityTemplateIds)
		}.wrap()

	override suspend fun deleteEntityTemplatesWithRev(entityTemplateIds: ListOfIdsAndRev): HttpResponse<List<DocIdentifier>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "entitytemplate", "delete", "batch", "withrev")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(entityTemplateIds)
		}.wrap()

	// endregion
}
