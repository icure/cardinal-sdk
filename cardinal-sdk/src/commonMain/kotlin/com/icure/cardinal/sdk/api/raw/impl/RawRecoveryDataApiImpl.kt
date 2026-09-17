package com.icure.cardinal.sdk.api.raw.`impl`

import com.icure.cardinal.sdk.api.raw.BaseRawApi
import com.icure.cardinal.sdk.api.raw.HttpResponse
import com.icure.cardinal.sdk.api.raw.RawApiConfig
import com.icure.cardinal.sdk.api.raw.RawRecoveryDataApi
import com.icure.cardinal.sdk.api.raw.wrap
import com.icure.cardinal.sdk.auth.services.AuthProvider
import com.icure.cardinal.sdk.model.RecoveryData
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.model.embed.EncryptedContent
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

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
class RawRecoveryDataApiImpl(
	internal val apiUrl: String,
	private val authProvider: AuthProvider,
	rawApiConfig: RawApiConfig,
) : BaseRawApi(rawApiConfig),
	RawRecoveryDataApi {
	// region common endpoints

	override suspend fun createRecoveryData(recoveryData: RecoveryData): HttpResponse<RecoveryData> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "recoverydata")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(recoveryData)
		}.wrap()

	override suspend fun getRecoveryData(id: String): HttpResponse<RecoveryData> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "recoverydata", id)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun deleteRecoveryData(id: String): HttpResponse<DocIdentifier> =
		delete(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "recoverydata", id)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun deleteAllRecoveryDataForRecipient(recipientId: String): HttpResponse<EncryptedContent> =
		delete(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "recoverydata", "forRecipient", recipientId)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun deleteAllRecoveryDataOfTypeForRecipient(
		type: RecoveryData.Type,
		recipientId: String,
	): HttpResponse<EncryptedContent> =
		delete(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "recoverydata", "forRecipient", recipientId, "ofType", "$type")
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun getRecoveryDataWaiting(
		id: String,
		timeoutSeconds: Int?,
	): HttpResponse<RecoveryData> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "recoverydata", "waiting", id)
				parameter("timeoutSeconds", timeoutSeconds)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	// endregion
}
