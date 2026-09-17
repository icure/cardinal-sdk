package com.icure.cardinal.sdk.api.raw.`impl`

import com.icure.cardinal.sdk.api.raw.BaseRawApi
import com.icure.cardinal.sdk.api.raw.HttpResponse
import com.icure.cardinal.sdk.api.raw.RawApiConfig
import com.icure.cardinal.sdk.api.raw.RawClassificationTemplateApi
import com.icure.cardinal.sdk.api.raw.wrap
import com.icure.cardinal.sdk.auth.services.AuthProvider
import com.icure.cardinal.sdk.crypto.AccessControlKeysHeadersProvider
import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.cardinal.sdk.model.ClassificationTemplate
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.PaginatedList
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
import kotlin.Int
import kotlin.String
import kotlin.collections.List

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
class RawClassificationTemplateApiImpl(
	internal val apiUrl: String,
	private val authProvider: AuthProvider,
	private val accessControlKeysHeadersProvider: AccessControlKeysHeadersProvider?,
	rawApiConfig: RawApiConfig,
) : BaseRawApi(rawApiConfig),
	RawClassificationTemplateApi {
	override suspend fun getAccessControlKeysHeaderValues(groupId: String?): List<String>? =
		accessControlKeysHeadersProvider?.getAccessControlKeysHeadersFor(groupId, EntityWithEncryptionMetadataTypeName.ClassificationTemplate)

	// region common endpoints

	override suspend fun createClassificationTemplate(c: ClassificationTemplate): HttpResponse<ClassificationTemplate> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "classificationTemplate")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(c)
		}.wrap()

	override suspend fun getClassificationTemplate(classificationTemplateId: String): HttpResponse<ClassificationTemplate> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "classificationTemplate", classificationTemplateId)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun getClassificationTemplateByIds(ids: String): HttpResponse<List<ClassificationTemplate>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "classificationTemplate", "byIds", ids)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun deleteClassificationTemplates(classificationTemplateIds: ListOfIds): HttpResponse<List<DocIdentifier>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "classificationTemplate", "delete", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(classificationTemplateIds)
		}.wrap()

	override suspend fun deleteClassificationTemplate(classificationTemplateId: String): HttpResponse<DocIdentifier> =
		delete(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "classificationTemplate", classificationTemplateId)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun modifyClassificationTemplate(
		classificationTemplateDto: ClassificationTemplate,
	): HttpResponse<ClassificationTemplate> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "classificationTemplate")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(classificationTemplateDto)
		}.wrap()

	override suspend fun findClassificationTemplatesBy(
		startKey: String?,
		startDocumentId: String?,
		limit: Int?,
	): HttpResponse<PaginatedList<ClassificationTemplate>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "classificationTemplate")
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	// endregion
}
