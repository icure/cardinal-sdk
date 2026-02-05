package com.icure.cardinal.sdk.api.raw

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
import com.icure.utils.InternalIcureApi
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
public interface RawHealthcarePartyApi {
	// region common endpoints

	suspend fun getCurrentHealthcareParty(): HttpResponse<HealthcareParty>

	suspend fun findHealthcarePartiesBy(
		startKey: String? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
		desc: Boolean? = null,
	): HttpResponse<PaginatedList<HealthcareParty>>

	suspend fun findHealthcarePartiesByName(
		name: String? = null,
		startKey: String? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
		desc: Boolean? = null,
	): HttpResponse<PaginatedList<HealthcareParty>>

	suspend fun findHealthcarePartiesBySsinOrNihii(
		searchValue: String,
		startKey: String? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
		desc: Boolean = false,
	): HttpResponse<PaginatedList<HealthcareParty>>

	suspend fun listHealthcarePartiesByName(name: String): HttpResponse<List<HealthcareParty>>

	suspend fun findHealthcarePartiesBySpecialityAndPostCode(
		type: String,
		spec: String,
		firstCode: String,
		lastCode: String,
		startKey: String? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
	): HttpResponse<PaginatedList<HealthcareParty>>

	suspend fun createHealthcareParty(h: HealthcareParty): HttpResponse<HealthcareParty>

	suspend fun createHealthcareParties(healthcareParties: List<HealthcareParty>): HttpResponse<List<HealthcareParty>>

	suspend fun getAesExchangeKeysForDelegate(
		healthcarePartyId: String,
	): HttpResponse<Map<String, Map<String, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>>>

	suspend fun getHealthcareParty(healthcarePartyId: String): HttpResponse<HealthcareParty>

	suspend fun getHealthcareParties(healthcarePartyIds: ListOfIds): HttpResponse<List<HealthcareParty>>

	suspend fun listHealthcarePartiesByParentId(parentId: String): HttpResponse<List<HealthcareParty>>

	suspend fun getPublicKey(healthcarePartyId: String): HttpResponse<PublicKey>

	suspend fun deleteHealthcareParties(healthcarePartyIds: ListOfIds): HttpResponse<List<DocIdentifier>>

	suspend fun deleteHealthcarePartiesWithRev(healthcarePartyIds: ListOfIdsAndRev): HttpResponse<List<DocIdentifier>>

	suspend fun deleteHealthcareParty(
		healthcarePartyId: String,
		rev: String? = null,
	): HttpResponse<DocIdentifier>

	suspend fun undeleteHealthcareParty(
		healthcarePartyId: String,
		rev: String,
	): HttpResponse<HealthcareParty>

	suspend fun undeleteHealthcareParties(healthcarePartyIds: ListOfIdsAndRev): HttpResponse<List<HealthcareParty>>

	suspend fun purgeHealthcareParty(
		healthcarePartyId: String,
		rev: String,
	): HttpResponse<DocIdentifier>

	suspend fun purgeHealthcareParties(healthcarePartyIds: ListOfIdsAndRev): HttpResponse<List<DocIdentifier>>

	suspend fun modifyHealthcareParty(healthcarePartyDto: HealthcareParty): HttpResponse<HealthcareParty>

	suspend fun modifyHealthcareParties(healthcareParties: List<HealthcareParty>): HttpResponse<List<HealthcareParty>>

	suspend fun matchHealthcarePartiesBy(filter: AbstractFilter<HealthcareParty>): HttpResponse<List<String>>

	suspend fun filterHealthPartiesBy(
		startDocumentId: String? = null,
		limit: Int? = null,
		filterChain: FilterChain<HealthcareParty>,
	): HttpResponse<PaginatedList<HealthcareParty>>
	// endregion

	// region cloud endpoints

	suspend fun getHealthcarePartyInGroup(
		groupId: String,
		healthcarePartyId: String,
	): HttpResponse<HealthcareParty>

	suspend fun getHealthcarePartiesInGroup(
		groupId: String,
		healthcarePartyIds: ListOfIds? =
			null,
	): HttpResponse<List<HealthcareParty>>

	suspend fun deleteHealthcarePartiesInGroup(
		groupId: String,
		healthcarePartyIds: ListOfIds,
	): HttpResponse<List<DocIdentifier>>

	suspend fun deleteHealthcarePartiesInGroupWithRev(
		groupId: String,
		healthcarePartyIds: ListOfIdsAndRev,
	): HttpResponse<List<DocIdentifier>>

	suspend fun deleteHealthcarePartiesInGroupWithRevNew(
		groupId: String,
		healthcarePartyIds: ListOfIdsAndRev,
	): HttpResponse<List<DocIdentifier>>

	suspend fun deleteHealthcarePartyInGroup(
		healthcarePartyId: String,
		groupId: String,
		rev: String? = null,
	): HttpResponse<DocIdentifier>

	suspend fun deleteHealthcarePartyInGroupNew(
		groupId: String,
		healthcarePartyId: String,
		rev: String? = null,
	): HttpResponse<DocIdentifier>

	suspend fun undeleteHealthcarePartyInGroup(
		groupId: String,
		healthcarePartyId: String,
		rev: String,
	): HttpResponse<HealthcareParty>

	suspend fun undeleteHealthcarePartiesInGroup(
		groupId: String,
		healthcarePartyIds: ListOfIdsAndRev,
	): HttpResponse<List<HealthcareParty>>

	suspend fun purgeHealthcarePartyInGroup(
		groupId: String,
		healthcarePartyId: String,
		rev: String,
	): HttpResponse<DocIdentifier>

	suspend fun purgeHealthcarePartiesInGroup(
		groupId: String,
		healthcarePartyIds: ListOfIdsAndRev,
	): HttpResponse<List<DocIdentifier>>

	suspend fun modifyHealthcarePartyInGroup(
		groupId: String,
		healthcarePartyDto: HealthcareParty,
	): HttpResponse<HealthcareParty>

	suspend fun modifyHealthcarePartiesInGroup(
		groupId: String,
		healthcareParties: List<HealthcareParty>,
	): HttpResponse<List<HealthcareParty>>

	suspend fun createHealthcarePartyInGroup(
		groupId: String,
		h: HealthcareParty,
	): HttpResponse<HealthcareParty>

	suspend fun createHealthcarePartiesInGroup(
		groupId: String,
		healthcareParties: List<HealthcareParty>,
	): HttpResponse<List<HealthcareParty>>

	suspend fun registerPatient(
		groupId: String,
		parentHcPartyId: String? = null,
		token: String? = null,
		useShortToken: Boolean? = null,
		hcp: HealthcareParty,
	): HttpResponse<DataOwnerRegistrationSuccess>

	suspend fun matchHealthcarePartiesInGroupBy(
		groupId: String,
		filter: AbstractFilter<HealthcareParty>,
	): HttpResponse<List<String>>
	// endregion
}
