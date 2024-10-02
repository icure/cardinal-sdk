package com.icure.cardinal.sdk.api.impl

import com.icure.cardinal.sdk.api.HealthcarePartyApi
import com.icure.cardinal.sdk.api.raw.RawHealthcarePartyApi
import com.icure.cardinal.sdk.api.raw.successBodyOrThrowRevisionConflict
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.filters.mapHealthcarePartyFilterOptions
import com.icure.cardinal.sdk.model.HealthcareParty
import com.icure.cardinal.sdk.model.IdWithMandatoryRev
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.ListOfIdsAndRev
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.utils.pagination.IdsPageIterator
import com.icure.cardinal.sdk.utils.pagination.PaginatedListIterator
import com.icure.utils.InternalIcureApi

@InternalIcureApi
internal class HealthcarePartyApiImpl(
	private val rawApi: RawHealthcarePartyApi,
) : HealthcarePartyApi {

	@Deprecated("Deletion without rev is unsafe")
	override suspend fun deleteHealthcareParty(entityId: String): DocIdentifier =
		rawApi.deleteHealthcareParty(entityId).successBodyOrThrowRevisionConflict()

	@Deprecated("Deletion without rev is unsafe")
	override suspend fun deleteHealthcareParties(entityIds: List<String>): List<DocIdentifier> =
		rawApi.deleteHealthcareParties(ListOfIds(entityIds)).successBody()
	
	override suspend fun getHealthcareParty(healthcarePartyId: String) = rawApi.getHealthcareParty(healthcarePartyId).successBody()

	override suspend fun createHealthcareParty(p: HealthcareParty) = rawApi.createHealthcareParty(p).successBody()

	override suspend fun modifyHealthcarePartyInGroup(groupId: String, healthcareParty: HealthcareParty) =
		rawApi.modifyHealthcarePartyInGroup(groupId, healthcareParty).successBodyOrThrowRevisionConflict()

	override suspend fun createHealthcarePartyInGroup(groupId: String, healthcareParty: HealthcareParty) =
		rawApi.createHealthcarePartyInGroup(groupId, healthcareParty).successBody()


	override suspend fun getCurrentHealthcareParty() = rawApi.getCurrentHealthcareParty().successBody()

	@Deprecated(
		"Find methods are deprecated",
		ReplaceWith(
			expression = "filterHealthPartiesBy(AllHealthcarePartiesFilter())",
			imports = arrayOf("com.icure.cardinal.sdk.model.filter.hcparty.AllHealthcarePartiesFilter")
		)
	)
	override suspend fun findHealthcarePartiesBy(
		startKey: String?,
		startDocumentId: String?,
		limit: Int?,
		desc: Boolean?,
	) = rawApi.findHealthcarePartiesBy(startKey, startDocumentId, limit, desc).successBody()

	@Deprecated(
		"Find methods are deprecated",
		ReplaceWith(
			expression = "filterHealthPartiesBy(HealthcarePartyByNameFilter(name = name, descending = desc)",
			imports = arrayOf("com.icure.cardinal.sdk.model.filter.hcparty.HealthcarePartyByNameFilter")
		)
	)
	override suspend fun findHealthcarePartiesByName(
		name: String?,
		startKey: String?,
		startDocumentId: String?,
		limit: Int?,
		desc: Boolean?,
	) = rawApi.findHealthcarePartiesByName(name, startKey, startDocumentId, limit, desc).successBody()

	@Deprecated("Find methods are deprecated", replaceWith = ReplaceWith("filterHealthPartiesBy(filter)"))
	override suspend fun findHealthcarePartiesBySsinOrNihii(
		searchValue: String,
		startKey: String?,
		startDocumentId: String?,
		limit: Int?,
		desc: Boolean,
	) = rawApi.findHealthcarePartiesBySsinOrNihii(searchValue, startKey, startDocumentId, limit, desc).successBody()

	override suspend fun listHealthcarePartiesByName(name: String) = rawApi.listHealthcarePartiesByName(name).successBody()
	@Deprecated("Find methods are deprecated", replaceWith = ReplaceWith("filterHealthPartiesBy(filter)"))
	override suspend fun findHealthcarePartiesBySpecialityAndPostCode(
		type: String,
		spec: String,
		firstCode: String,
		lastCode: String,
		startKey: String?,
		startDocumentId: String?,
		limit: Int?,
	) = rawApi.findHealthcarePartiesBySpecialityAndPostCode(type, spec, firstCode, lastCode, startKey, startDocumentId, limit).successBody()

	override suspend fun getHealthcareParties(healthcarePartyIds: List<String>) =
		rawApi.getHealthcareParties(ListOfIds(healthcarePartyIds)).successBody()

	override suspend fun listHealthcarePartiesByParentId(parentId: String) = rawApi.listHealthcarePartiesByParentId(parentId).successBody()
	override suspend fun getPublicKey(healthcarePartyId: String) = rawApi.getPublicKey(healthcarePartyId).successBody()

	override suspend fun modifyHealthcareParty(healthcareParty: HealthcareParty) =
		rawApi.modifyHealthcareParty(healthcareParty).successBodyOrThrowRevisionConflict()

	override suspend fun matchHealthcarePartiesBy(filter: BaseFilterOptions<HealthcareParty>) =
		rawApi.matchHealthcarePartiesBy(mapHealthcarePartyFilterOptions(filter)).successBody()

	override suspend fun filterHealthPartiesBy(filter: BaseFilterOptions<HealthcareParty>): PaginatedListIterator<HealthcareParty> =
		IdsPageIterator(matchHealthcarePartiesBy(filter), this::getHealthcareParties)

	override suspend fun matchHealthcarePartiesBySorted(filter: BaseSortableFilterOptions<HealthcareParty>) =
		matchHealthcarePartiesBy(filter)

	override suspend fun filterHealthPartiesBySorted(filter: BaseSortableFilterOptions<HealthcareParty>): PaginatedListIterator<HealthcareParty> =
		filterHealthPartiesBy(filter)

	override suspend fun getHealthcarePartiesInGroup(
		groupId: String,
		healthcarePartyIds: List<String>?,
	) = rawApi.getHealthcarePartiesInGroup(groupId, healthcarePartyIds?.let { ListOfIds(it) }).successBody()

	override suspend fun deleteHealthcarePartyById(entityId: String, rev: String): DocIdentifier =
		rawApi.deleteHealthcareParty(entityId, rev).successBodyOrThrowRevisionConflict()

	override suspend fun deleteHealthcarePartiesByIds(entityIds: List<IdWithMandatoryRev>): List<DocIdentifier> =
		rawApi.deleteHealthcarePartiesWithRev(ListOfIdsAndRev(entityIds)).successBody()

	override suspend fun deleteHealthcarePartyInGroupById(groupId: String, entityId: String, rev: String): DocIdentifier =
		rawApi.deleteHealthcarePartyInGroup(
			healthcarePartyId = entityId,
			rev = rev,
			groupId = groupId
		).successBodyOrThrowRevisionConflict()

	override suspend fun deleteHealthcarePartiesInGroupByIds(
		groupId: String,
		entityIds: List<IdWithMandatoryRev>
	): List<DocIdentifier> =
		rawApi.deleteHealthcarePartiesInGroupWithRev(groupId, ListOfIdsAndRev(entityIds)).successBody()

	override suspend fun purgeHealthcarePartyById(id: String, rev: String) {
		rawApi.purgeHealthcareParty(id, rev).successBodyOrThrowRevisionConflict()
	}

	override suspend fun undeleteHealthcarePartyById(id: String, rev: String): HealthcareParty =
		rawApi.undeleteHealthcareParty(id, rev).successBodyOrThrowRevisionConflict()

	override suspend fun registerPatient(
		groupId: String,
		parentHcPartyId: String?,
		token: String?,
		useShortToken: Boolean?,
		hcp: HealthcareParty,
	) = rawApi.registerPatient(groupId, parentHcPartyId, token, useShortToken, hcp).successBody()

}