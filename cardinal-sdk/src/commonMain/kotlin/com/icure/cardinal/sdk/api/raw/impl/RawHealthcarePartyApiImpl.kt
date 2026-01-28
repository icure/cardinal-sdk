package com.icure.cardinal.sdk.api.raw.`impl`

import com.icure.cardinal.sdk.api.raw.BaseRawApi
import com.icure.cardinal.sdk.api.raw.HttpResponse
import com.icure.cardinal.sdk.api.raw.RawApiConfig
import com.icure.cardinal.sdk.api.raw.RawHealthcarePartyApi
import com.icure.cardinal.sdk.api.raw.wrap
import com.icure.cardinal.sdk.auth.services.AuthProvider
import com.icure.cardinal.sdk.model.DataOwnerRegistrationSuccess
import com.icure.cardinal.sdk.model.HealthcareParty
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.ListOfIdsAndRev
import com.icure.cardinal.sdk.model.PaginatedList
import com.icure.cardinal.sdk.model.PublicKey
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.model.filter.chain.FilterChain
import com.icure.cardinal.sdk.model.specializations.AesExchangeKeyEncryptionKeypairIdentifier
import com.icure.cardinal.sdk.model.specializations.HexString
import com.icure.cardinal.sdk.serialization.FilterChainSerializer
import com.icure.cardinal.sdk.serialization.HealthcarePartyAbstractFilterSerializer
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
import kotlin.collections.List
import kotlin.collections.Map

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
class RawHealthcarePartyApiImpl(
	internal val apiUrl: String,
	private val authProvider: AuthProvider,
	rawApiConfig: RawApiConfig,
) : BaseRawApi(rawApiConfig), RawHealthcarePartyApi {
	// region common endpoints

	override suspend fun getCurrentHealthcareParty(): HttpResponse<HealthcareParty> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "hcparty", "current")
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun findHealthcarePartiesBy(
		startKey: String?,
		startDocumentId: String?,
		limit: Int?,
		desc: Boolean?,
	): HttpResponse<PaginatedList<HealthcareParty>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "hcparty")
				parameter("startKey", startKey)
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
				parameter("desc", desc)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun findHealthcarePartiesByName(
		name: String?,
		startKey: String?,
		startDocumentId: String?,
		limit: Int?,
		desc: Boolean?,
	): HttpResponse<PaginatedList<HealthcareParty>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "hcparty", "byName")
				parameter("name", name)
				parameter("startKey", startKey)
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
				parameter("desc", desc)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun findHealthcarePartiesBySsinOrNihii(
		searchValue: String,
		startKey: String?,
		startDocumentId: String?,
		limit: Int?,
		desc: Boolean,
	): HttpResponse<PaginatedList<HealthcareParty>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "hcparty", "byNihiiOrSsin", searchValue)
				parameter("startKey", startKey)
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
				parameter("desc", desc)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun listHealthcarePartiesByName(name: String): HttpResponse<List<HealthcareParty>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "hcparty", "byNameStrict", name)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun findHealthcarePartiesBySpecialityAndPostCode(
		type: String,
		spec: String,
		firstCode: String,
		lastCode: String,
		startKey: String?,
		startDocumentId: String?,
		limit: Int?,
	): HttpResponse<PaginatedList<HealthcareParty>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "hcparty", "bySpecialityAndPostCode", type, spec, firstCode, "to", lastCode)
				parameter("startKey", startKey)
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun createHealthcareParty(h: HealthcareParty): HttpResponse<HealthcareParty> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "hcparty")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(h)
		}.wrap()

	override suspend fun createHealthcareParties(healthcareParties: List<HealthcareParty>): HttpResponse<List<HealthcareParty>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "hcparty", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(healthcareParties)
		}.wrap()

	override suspend fun getAesExchangeKeysForDelegate(
		healthcarePartyId: String,
	): HttpResponse<Map<String, Map<String, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "hcparty", healthcarePartyId, "aesExchangeKeys")
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun getHealthcareParty(healthcarePartyId: String): HttpResponse<HealthcareParty> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "hcparty", healthcarePartyId)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun getHealthcareParties(healthcarePartyIds: ListOfIds): HttpResponse<List<HealthcareParty>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "hcparty", "byIds")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(healthcarePartyIds)
		}.wrap()

	override suspend fun listHealthcarePartiesByParentId(parentId: String): HttpResponse<List<HealthcareParty>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "hcparty", parentId, "children")
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun getPublicKey(healthcarePartyId: String): HttpResponse<PublicKey> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "hcparty", healthcarePartyId, "publicKey")
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun deleteHealthcareParties(healthcarePartyIds: ListOfIds): HttpResponse<List<DocIdentifier>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "hcparty", "delete", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(healthcarePartyIds)
		}.wrap()

	override suspend fun deleteHealthcarePartiesWithRev(healthcarePartyIds: ListOfIdsAndRev): HttpResponse<List<DocIdentifier>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "hcparty", "delete", "batch", "withrev")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(healthcarePartyIds)
		}.wrap()

	override suspend fun deleteHealthcareParty(
		healthcarePartyId: String,
		rev: String?,
	): HttpResponse<DocIdentifier> =
		delete(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "hcparty", healthcarePartyId)
				parameter("rev", rev)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun undeleteHealthcareParty(
		healthcarePartyId: String,
		rev: String,
	): HttpResponse<HealthcareParty> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "hcparty", "undelete", healthcarePartyId)
				parameter("rev", rev)
			}
			contentType(Application.Json)
			accept(Application.Json)
		}.wrap()

	override suspend fun undeleteHealthcareParties(healthcarePartyIds: ListOfIdsAndRev): HttpResponse<List<HealthcareParty>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "hcparty", "undelete", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(healthcarePartyIds)
		}.wrap()

	override suspend fun purgeHealthcareParty(
		healthcarePartyId: String,
		rev: String,
	): HttpResponse<DocIdentifier> =
		delete(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "hcparty", "purge", healthcarePartyId)
				parameter("rev", rev)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun purgeHealthcareParties(healthcarePartyIds: ListOfIdsAndRev): HttpResponse<List<DocIdentifier>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "hcparty", "purge", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(healthcarePartyIds)
		}.wrap()

	override suspend fun modifyHealthcareParty(healthcarePartyDto: HealthcareParty): HttpResponse<HealthcareParty> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "hcparty")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(healthcarePartyDto)
		}.wrap()

	override suspend fun modifyHealthcareParties(healthcareParties: List<HealthcareParty>): HttpResponse<List<HealthcareParty>> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "hcparty", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(healthcareParties)
		}.wrap()

	override suspend fun matchHealthcarePartiesBy(filter: AbstractFilter<HealthcareParty>): HttpResponse<List<String>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "hcparty", "match")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBodyWithSerializer(HealthcarePartyAbstractFilterSerializer, filter)
		}.wrap()

	override suspend fun filterHealthPartiesBy(
		startDocumentId: String?,
		limit: Int?,
		filterChain: FilterChain<HealthcareParty>,
	): HttpResponse<PaginatedList<HealthcareParty>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "hcparty", "filter")
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBodyWithSerializer(
				FilterChainSerializer(HealthcarePartyAbstractFilterSerializer),
				filterChain,
			)
		}.wrap()

	// endregion

	// region cloud endpoints

	override suspend fun getHealthcarePartyInGroup(
		groupId: String,
		healthcarePartyId: String,
	): HttpResponse<HealthcareParty> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "hcparty", "inGroup", groupId, healthcarePartyId)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun getHealthcarePartiesInGroup(
		groupId: String,
		healthcarePartyIds: ListOfIds?,
	): HttpResponse<List<HealthcareParty>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "hcparty", "inGroup", groupId, "byIds")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(healthcarePartyIds)
		}.wrap()

	override suspend fun deleteHealthcarePartiesInGroup(
		groupId: String,
		healthcarePartyIds: ListOfIds,
	): HttpResponse<List<DocIdentifier>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "hcparty", "delete", "batch", "inGroup", groupId)
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(healthcarePartyIds)
		}.wrap()

	override suspend fun deleteHealthcarePartiesInGroupWithRev(
		groupId: String,
		healthcarePartyIds: ListOfIdsAndRev,
	): HttpResponse<List<DocIdentifier>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "hcparty", "delete", "batch", "withrev", "inGroup", groupId)
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(healthcarePartyIds)
		}.wrap()

	override suspend fun deleteHealthcarePartiesInGroupWithRevNew(
		groupId: String,
		healthcarePartyIds: ListOfIdsAndRev,
	): HttpResponse<List<DocIdentifier>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "hcparty", "inGroup", groupId, "delete", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(healthcarePartyIds)
		}.wrap()

	override suspend fun deleteHealthcarePartyInGroup(
		healthcarePartyId: String,
		groupId: String,
		rev: String?,
	): HttpResponse<DocIdentifier> =
		delete(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "hcparty", healthcarePartyId, "inGroup", groupId)
				parameter("rev", rev)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun deleteHealthcarePartyInGroupNew(
		groupId: String,
		healthcarePartyId: String,
		rev: String?,
	): HttpResponse<DocIdentifier> =
		delete(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "hcparty", "inGroup", groupId, healthcarePartyId)
				parameter("rev", rev)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun undeleteHealthcarePartyInGroup(
		groupId: String,
		healthcarePartyId: String,
		rev: String,
	): HttpResponse<HealthcareParty> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "hcparty", "inGroup", groupId, "undelete", healthcarePartyId)
				parameter("rev", rev)
			}
			contentType(Application.Json)
			accept(Application.Json)
		}.wrap()

	override suspend fun undeleteHealthcarePartiesInGroup(
		groupId: String,
		healthcarePartyIds: ListOfIdsAndRev,
	): HttpResponse<List<HealthcareParty>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "hcparty", "inGroup", groupId, "undelete", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(healthcarePartyIds)
		}.wrap()

	override suspend fun purgeHealthcarePartyInGroup(
		groupId: String,
		healthcarePartyId: String,
		rev: String,
	): HttpResponse<DocIdentifier> =
		delete(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "hcparty", "inGroup", groupId, "purge", healthcarePartyId)
				parameter("rev", rev)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun purgeHealthcarePartiesInGroup(
		groupId: String,
		healthcarePartyIds: ListOfIdsAndRev,
	): HttpResponse<List<DocIdentifier>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "hcparty", "inGroup", groupId, "purge", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(healthcarePartyIds)
		}.wrap()

	override suspend fun modifyHealthcarePartyInGroup(
		groupId: String,
		healthcarePartyDto: HealthcareParty,
	): HttpResponse<HealthcareParty> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "hcparty", "inGroup", groupId)
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(healthcarePartyDto)
		}.wrap()

	override suspend fun modifyHealthcarePartiesInGroup(
		groupId: String,
		healthcareParties: List<HealthcareParty>,
	): HttpResponse<List<HealthcareParty>> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "hcparty", "inGroup", groupId, "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(healthcareParties)
		}.wrap()

	override suspend fun createHealthcarePartyInGroup(
		groupId: String,
		h: HealthcareParty,
	): HttpResponse<HealthcareParty> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "hcparty", "inGroup", groupId)
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(h)
		}.wrap()

	override suspend fun createHealthcarePartiesInGroup(
		groupId: String,
		healthcareParties: List<HealthcareParty>,
	): HttpResponse<List<HealthcareParty>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "hcparty", "inGroup", groupId, "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(healthcareParties)
		}.wrap()

	override suspend fun registerPatient(
		groupId: String,
		parentHcPartyId: String?,
		token: String?,
		useShortToken: Boolean?,
		hcp: HealthcareParty,
	): HttpResponse<DataOwnerRegistrationSuccess> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "hcparty", "register", "inGroup", groupId)
				parameter("parentHcPartyId", parentHcPartyId)
				parameter("token", token)
				parameter("useShortToken", useShortToken)
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(hcp)
		}.wrap()

	override suspend fun matchHealthcarePartiesInGroupBy(
		groupId: String,
		filter: AbstractFilter<HealthcareParty>,
	): HttpResponse<List<String>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "hcparty", "inGroup", groupId, "match")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBodyWithSerializer(HealthcarePartyAbstractFilterSerializer, filter)
		}.wrap()

	// endregion
}
