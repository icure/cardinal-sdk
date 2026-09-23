package com.icure.cardinal.sdk.api.raw.`impl`

import com.icure.cardinal.sdk.api.raw.BaseRawApi
import com.icure.cardinal.sdk.api.raw.HttpResponse
import com.icure.cardinal.sdk.api.raw.RawApiConfig
import com.icure.cardinal.sdk.api.raw.RawClassificationApi
import com.icure.cardinal.sdk.api.raw.wrap
import com.icure.cardinal.sdk.auth.services.AuthProvider
import com.icure.cardinal.sdk.crypto.AccessControlKeysHeadersProvider
import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.cardinal.sdk.model.Classification
import com.icure.cardinal.sdk.model.EncryptedClassification
import com.icure.cardinal.sdk.model.IcureStub
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.ListOfIdsAndRev
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.model.requests.BulkShareOrUpdateMetadataParams
import com.icure.cardinal.sdk.model.requests.EntityBulkShareResult
import com.icure.cardinal.sdk.serialization.ClassificationAbstractFilterSerializer
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
import kotlin.Long
import kotlin.Nothing
import kotlin.String
import kotlin.collections.List

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
class RawClassificationApiImpl(
	internal val apiUrl: String,
	private val authProvider: AuthProvider,
	private val accessControlKeysHeadersProvider: AccessControlKeysHeadersProvider?,
	rawApiConfig: RawApiConfig,
) : BaseRawApi(rawApiConfig), RawClassificationApi {
	override suspend fun getAccessControlKeysHeaderValues(groupId: String?): List<String>? =
		accessControlKeysHeadersProvider?.getAccessControlKeysHeadersFor(
			groupId,
			EntityWithEncryptionMetadataTypeName.Classification,
		)

	// region common endpoints

	override suspend fun createClassification(c: EncryptedClassification): HttpResponse<EncryptedClassification> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "classification")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(c)
		}.wrap()

	override suspend fun getClassification(classificationId: String): HttpResponse<EncryptedClassification> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "classification", classificationId)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun getClassifications(classificationIds: ListOfIds): HttpResponse<List<EncryptedClassification>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "classification", "byIds")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(classificationIds)
		}.wrapList()

	override suspend fun listClassificationIdsByDataOwnerPatientCreated(
		dataOwnerId: String,
		startDate: Long?,
		endDate: Long?,
		descending: Boolean?,
		secretPatientKeys: ListOfIds,
	): HttpResponse<List<String>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "classification", "byDataOwnerPatientCreated")
				parameter("dataOwnerId", dataOwnerId)
				parameter("startDate", startDate)
				parameter("endDate", endDate)
				parameter("descending", descending)
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(secretPatientKeys)
		}.wrap()

	override suspend fun deleteClassifications(classificationIds: ListOfIds): HttpResponse<List<DocIdentifier>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "classification", "delete", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(classificationIds)
		}.wrap()

	override suspend fun deleteClassificationsWithRev(classificationIds: ListOfIdsAndRev): HttpResponse<List<DocIdentifier>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "classification", "delete", "batch", "withrev")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(classificationIds)
		}.wrap()

	override suspend fun deleteClassification(
		classificationId: String,
		rev: String?,
	): HttpResponse<DocIdentifier> =
		delete(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "classification", classificationId)
				parameter("rev", rev)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun undeleteClassification(
		classificationId: String,
		rev: String,
	): HttpResponse<EncryptedClassification> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "classification", "undelete", classificationId)
				parameter("rev", rev)
			}
			contentType(Application.Json)
			accept(Application.Json)
		}.wrap()

	override suspend fun purgeClassification(
		classificationId: String,
		rev: String,
	): HttpResponse<DocIdentifier> =
		delete(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "classification", "purge", classificationId)
				parameter("rev", rev)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun modifyClassification(classificationDto: EncryptedClassification): HttpResponse<EncryptedClassification> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "classification")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(classificationDto)
		}.wrap()

	override suspend fun findClassificationsDelegationsStubsByIds(classificationIds: ListOfIds): HttpResponse<List<IcureStub>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "classification", "delegations")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(classificationIds)
		}.wrap()

	override suspend fun matchClassificationBy(filter: AbstractFilter<Classification>): HttpResponse<List<String>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "classification", "match")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBodyWithSerializer(ClassificationAbstractFilterSerializer, filter)
		}.wrap()

	override suspend fun bulkShare(
		request: BulkShareOrUpdateMetadataParams,
	): HttpResponse<List<EntityBulkShareResult<EncryptedClassification>>> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "classification", "bulkSharedMetadataUpdate")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(request)
		}.wrap()

	override suspend fun bulkShareMinimal(request: BulkShareOrUpdateMetadataParams): HttpResponse<List<EntityBulkShareResult<Nothing>>> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "classification", "bulkSharedMetadataUpdateMinimal")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(request)
		}.wrap()

	// endregion
}
