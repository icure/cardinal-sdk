package com.icure.cardinal.sdk.api.raw.`impl`

import com.icure.cardinal.sdk.api.raw.BaseRawApi
import com.icure.cardinal.sdk.api.raw.HttpResponse
import com.icure.cardinal.sdk.api.raw.RawApiConfig
import com.icure.cardinal.sdk.api.raw.RawCodeApi
import com.icure.cardinal.sdk.api.raw.wrap
import com.icure.cardinal.sdk.auth.services.AuthProvider
import com.icure.cardinal.sdk.model.BooleanResponse
import com.icure.cardinal.sdk.model.Code
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.PaginatedList
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.model.filter.chain.FilterChain
import com.icure.cardinal.sdk.serialization.CodeAbstractFilterSerializer
import com.icure.cardinal.sdk.serialization.FilterChainSerializer
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
import kotlin.Int
import kotlin.String
import kotlin.Unit
import kotlin.collections.List

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
class RawCodeApiImpl(
	internal val apiUrl: String,
	private val authProvider: AuthProvider,
	rawApiConfig: RawApiConfig,
) : BaseRawApi(rawApiConfig), RawCodeApi {
	// region common endpoints

	override suspend fun findCodesByLabel(
		region: String?,
		types: String,
		language: String,
		label: String,
		version: String?,
		startKey: String?,
		startDocumentId: String?,
		limit: Int?,
	): HttpResponse<PaginatedList<Code>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "code", "byLabel")
				parameter("region", region)
				parameter("types", types)
				parameter("language", language)
				parameter("label", label)
				parameter("version", version)
				parameter("startKey", startKey)
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun findCodesByType(
		region: String,
		type: String?,
		code: String?,
		version: String?,
		startKey: String?,
		startDocumentId: String?,
		limit: Int?,
	): HttpResponse<PaginatedList<Code>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "code")
				parameter("region", region)
				parameter("type", type)
				parameter("code", code)
				parameter("version", version)
				parameter("startKey", startKey)
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun findCodesByLink(
		linkType: String,
		linkedId: String?,
		startKey: String?,
		startDocumentId: String?,
		limit: Int?,
	): HttpResponse<PaginatedList<Code>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "code", "byLink", linkType)
				parameter("linkedId", linkedId)
				parameter("startKey", startKey)
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun listCodesByRegionTypeCodeVersion(
		region: String,
		type: String?,
		code: String?,
		version: String?,
	): HttpResponse<List<Code>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "code", "byRegionTypeCode")
				parameter("region", region)
				parameter("type", type)
				parameter("code", code)
				parameter("version", version)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun listCodeTypesBy(
		region: String?,
		type: String?,
	): HttpResponse<List<String>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "code", "codetype", "byRegionType")
				parameter("region", region)
				parameter("type", type)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun listTagTypesBy(
		region: String?,
		type: String?,
	): HttpResponse<List<String>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "code", "tagtype", "byRegionType")
				parameter("region", region)
				parameter("type", type)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun createCode(c: Code): HttpResponse<Code> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "code")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(c)
		}.wrap()

	override suspend fun createCodes(codeBatch: List<Code>): HttpResponse<List<Code>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "code", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(codeBatch)
		}.wrap()

	override suspend fun isCodeValid(
		type: String,
		code: String,
		version: String?,
	): HttpResponse<BooleanResponse> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "code", "isValid")
				parameter("type", type)
				parameter("code", code)
				parameter("version", version)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun getCodeByRegionLanguageTypeLabelOr404(
		region: String,
		label: String,
		type: String,
		languages: String?,
	): HttpResponse<Code> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "code", "getCodeByRegionLanguageTypeLabelOr404")
				parameter("region", region)
				parameter("label", label)
				parameter("type", type)
				parameter("languages", languages)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun getCodes(codeIds: ListOfIds): HttpResponse<List<Code>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "code", "byIds")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(codeIds)
		}.wrap()

	override suspend fun getCode(codeId: String): HttpResponse<Code> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "code", codeId)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun getCodeWithParts(
		type: String,
		code: String,
		version: String,
	): HttpResponse<Code> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "code", type, code, version)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun modifyCode(codeDto: Code): HttpResponse<Code> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "code")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(codeDto)
		}.wrap()

	override suspend fun modifyCodes(codeBatch: List<Code>): HttpResponse<List<Code>> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "code", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(codeBatch)
		}.wrap()

	override suspend fun filterCodesBy(
		startKey: String?,
		startDocumentId: String?,
		limit: Int?,
		skip: Int?,
		sort: String?,
		desc: Boolean?,
		filterChain: FilterChain<Code>,
	): HttpResponse<PaginatedList<Code>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "code", "filter")
				parameter("startKey", startKey)
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
				parameter("skip", skip)
				parameter("sort", sort)
				parameter("desc", desc)
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBodyWithSerializer(FilterChainSerializer(CodeAbstractFilterSerializer), filterChain)
		}.wrap()

	override suspend fun matchCodesBy(filter: AbstractFilter<Code>): HttpResponse<List<String>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "code", "match")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBodyWithSerializer(CodeAbstractFilterSerializer, filter)
		}.wrap()

	override suspend fun importCodes(codeType: String): HttpResponse<Unit> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "code", codeType)
			}
			contentType(Application.Json)
			accept(Application.Json)
		}.wrap()

	// endregion

	// region cloud endpoints

	override suspend fun createCodesInGroup(
		groupId: String,
		codeBatch: List<Code>,
	): HttpResponse<List<Code>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "code", "inGroup", groupId, "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(codeBatch)
		}.wrap()

	override suspend fun getCodes(
		groupId: String,
		codeIds: ListOfIds,
	): HttpResponse<List<Code>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "code", "inGroup", groupId, "byIds")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(codeIds)
		}.wrap()

	override suspend fun modifyCodesInGroup(
		groupId: String,
		codeBatch: List<Code>,
	): HttpResponse<List<Code>> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "code", "inGroup", groupId, "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(codeBatch)
		}.wrap()

	override suspend fun matchCodesBy(
		groupId: String,
		filter: AbstractFilter<Code>,
	): HttpResponse<List<String>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "code", "inGroup", groupId, "match")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBodyWithSerializer(CodeAbstractFilterSerializer, filter)
		}.wrap()

	// endregion
}
