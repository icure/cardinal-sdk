package com.icure.cardinal.sdk.api.raw.`impl`

import com.icure.cardinal.sdk.api.raw.BaseRawApi
import com.icure.cardinal.sdk.api.raw.HttpResponse
import com.icure.cardinal.sdk.api.raw.RawApiConfig
import com.icure.cardinal.sdk.api.raw.RawObjectStorageApi
import com.icure.cardinal.sdk.api.raw.wrap
import com.icure.cardinal.sdk.auth.services.AuthProvider
import com.icure.cardinal.sdk.model.objectstorage.StoredObjectInformation
import com.icure.utils.InternalIcureApi
import io.ktor.client.request.accept
import io.ktor.client.request.parameter
import io.ktor.client.request.setBody
import io.ktor.http.ContentType.Application
import io.ktor.http.appendPathSegments
import io.ktor.http.content.ByteArrayContent
import io.ktor.http.takeFrom
import io.ktor.util.date.GMTDate
import kotlin.ByteArray
import kotlin.Long
import kotlin.String
import kotlin.Unit

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
class RawObjectStorageApiImpl(
	internal val apiUrl: String,
	private val authProvider: AuthProvider,
	rawApiConfig: RawApiConfig,
) : BaseRawApi(rawApiConfig),
	RawObjectStorageApi {
	// region cloud endpoints

	override suspend fun createAttachment(
		entityGroup: String,
		entityId: String,
		attachmentId: String,
		size: Long,
		md5Hash: String,
		startByte: Long?,
		content: ByteArray,
	): HttpResponse<Unit> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "objectstorage{entityGroup}", entityId, attachmentId)
				parameter("size", size)
				parameter("md5Hash", md5Hash)
				parameter("startByte", startByte)
			}
			accept(Application.Json)
			setBody(ByteArrayContent(content, Application.OctetStream))
		}.wrap()

	override suspend fun getAttachment(
		entityGroup: String,
		entityId: String,
		attachmentId: String,
	): HttpResponse<ByteArray> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "objectstorage{entityGroup}", entityId, attachmentId)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun getAttachmentInfo(
		entityGroup: String,
		entityId: String,
		attachmentId: String,
	): HttpResponse<StoredObjectInformation> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "objectstorage{entityGroup}", entityId, attachmentId, "info")
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	// endregion
}
