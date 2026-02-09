package com.icure.cardinal.sdk.api.impl

import com.icure.cardinal.sdk.api.HealthcarePartyInGroupApi
import com.icure.cardinal.sdk.api.HealthcarePartyApi
import com.icure.cardinal.sdk.api.raw.RawHealthcarePartyApi
import com.icure.cardinal.sdk.api.raw.successBodyOrNull404
import com.icure.cardinal.sdk.api.raw.successBodyOrThrowRevisionConflict
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.mapHealthcarePartyFilterOptions
import com.icure.cardinal.sdk.model.HealthcareParty
import com.icure.cardinal.sdk.model.GroupScoped
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.options.BasicApiConfiguration
import com.icure.cardinal.sdk.serialization.HealthcarePartyAbstractFilterSerializer
import com.icure.cardinal.sdk.serialization.SubscriptionSerializer
import com.icure.cardinal.sdk.subscription.EntitySubscription
import com.icure.cardinal.sdk.subscription.EntitySubscriptionConfiguration
import com.icure.cardinal.sdk.subscription.SubscriptionEventType
import com.icure.cardinal.sdk.subscription.WebSocketSubscription
import com.icure.cardinal.sdk.utils.Serialization
import com.icure.cardinal.sdk.model.ListOfIdsAndRev
import com.icure.cardinal.sdk.model.toStoredDocumentIdentifier
import com.icure.cardinal.sdk.utils.pagination.IdsPageIterator
import com.icure.cardinal.sdk.utils.pagination.PaginatedListIterator
import com.icure.utils.InternalIcureApi

@OptIn(InternalIcureApi::class)
internal abstract class AbstractHealthcarePartyApi(
	protected val rawApi: RawHealthcarePartyApi,
	protected val config: BasicApiConfiguration
) {

	protected suspend fun doCreateHealthcareParty(groupId: String?, entity: HealthcareParty): HealthcareParty {
		basicRequireIsValidForCreation(entity)
		return if (groupId == null) {
			rawApi.createHealthcareParty(entity)
		} else {
			rawApi.createHealthcarePartyInGroup(groupId, entity)
		}.successBody()
	}

	protected suspend fun doCreateHealthcareParties(groupId: String?, entities: List<HealthcareParty>): List<HealthcareParty> =
		skipRequestOnEmptyList(entities) { healthcareParties ->
			if (groupId == null) {
				rawApi.createHealthcareParties(healthcareParties)
			} else {
				rawApi.createHealthcarePartiesInGroup(groupId, healthcareParties)
			}.successBody()
		}

	protected suspend fun doGetHealthcareParty(groupId: String?, entityId: String): HealthcareParty? =
		if (groupId == null) {
			rawApi.getHealthcareParty(entityId)
		} else {
			rawApi.getHealthcarePartyInGroup(groupId, entityId)
		}.successBodyOrNull404()

	protected suspend fun doGetHealthcareParties(groupId: String?, entityIds: List<String>): List<HealthcareParty> =
		skipRequestOnEmptyList(entityIds) { ids ->
			if (groupId == null) {
				rawApi.getHealthcareParties(ListOfIds(ids))
			} else {
				rawApi.getHealthcarePartiesInGroup(groupId, ListOfIds(ids))
			}.successBody()
		}

	protected suspend fun doModifyHealthcareParty(groupId: String?, entity: HealthcareParty): HealthcareParty {
		requireIsValidForModification(entity)
		return if (groupId == null) {
			rawApi.modifyHealthcareParty(entity)
		} else {
			rawApi.modifyHealthcarePartyInGroup(groupId, entity)
		}.successBodyOrThrowRevisionConflict()
	}

	protected suspend fun doModifyHealthcareParties(groupId: String?, entities: List<HealthcareParty>): List<HealthcareParty> =
		skipRequestOnEmptyList(entities) { healthcareParties ->
			if (groupId == null) {
				rawApi.modifyHealthcareParties(healthcareParties)
			} else {
				rawApi.modifyHealthcarePartiesInGroup(groupId, healthcareParties)
			}.successBody()
		}

	protected suspend fun doDeleteHealthcareParty(groupId: String?, entityId: String, rev: String): StoredDocumentIdentifier =
		if (groupId == null) {
			rawApi.deleteHealthcareParty(entityId, rev)
		} else {
			rawApi.deleteHealthcarePartyInGroup(groupId, entityId, rev)
		}.successBodyOrThrowRevisionConflict().toStoredDocumentIdentifier()

	protected suspend fun doDeleteHealthcareParties(groupId: String?, entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier> =
		skipRequestOnEmptyList(entityIds) { ids ->
			if (groupId == null) {
				rawApi.deleteHealthcarePartiesWithRev(ListOfIdsAndRev(ids))
			} else {
				rawApi.deleteHealthcarePartiesInGroupWithRev(groupId = groupId, ListOfIdsAndRev(ids))
			}.successBody().map { it.toStoredDocumentIdentifier() }
		}

	protected suspend fun doUndeleteHealthcareParty(groupId: String?, entityId: String, rev: String): HealthcareParty =
		if (groupId == null) {
			rawApi.undeleteHealthcareParty(entityId, rev)
		} else {
			rawApi.undeleteHealthcarePartyInGroup(groupId, entityId, rev)
		}.successBodyOrThrowRevisionConflict()

	protected suspend fun doUndeleteHealthcareParties(groupId: String?, entityIds: List<StoredDocumentIdentifier>): List<HealthcareParty> =
		skipRequestOnEmptyList(entityIds) { ids ->
			if (groupId == null) {
				rawApi.undeleteHealthcareParties(ListOfIdsAndRev(ids))
			} else {
				rawApi.undeleteHealthcarePartiesInGroup(groupId = groupId, ListOfIdsAndRev(ids))
			}.successBody()
		}

	protected suspend fun doPurgeHealthcareParty(groupId: String?, entityId: String, rev: String) {
		if (groupId == null) {
			rawApi.purgeHealthcareParty(entityId, rev)
		} else {
			rawApi.purgeHealthcarePartyInGroup(groupId, entityId, rev)
		}.successBodyOrThrowRevisionConflict()
	}

	protected suspend fun doPurgeHealthcareParties(groupId: String?, entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier> =
		skipRequestOnEmptyList(entityIds) { ids ->
			if (groupId == null) {
				rawApi.purgeHealthcareParties(ListOfIdsAndRev(ids))
			} else {
				rawApi.purgeHealthcarePartiesInGroup(groupId = groupId, ListOfIdsAndRev(ids))
			}.successBody().map { it.toStoredDocumentIdentifier() }
		}

	protected suspend fun doMatchHealthcarePartiesBy(groupId: String?, filter: BaseFilterOptions<HealthcareParty>) =
		if (groupId == null) {
			rawApi.matchHealthcarePartiesBy(mapHealthcarePartyFilterOptions(filter))
		} else {
			rawApi.matchHealthcarePartiesInGroupBy(groupId, mapHealthcarePartyFilterOptions(filter))
		}.successBody()

	protected suspend fun doMatchHealthcarePartiesBySorted(groupId: String?, filter: BaseSortableFilterOptions<HealthcareParty>) =
		doMatchHealthcarePartiesBy(groupId = groupId, filter = filter)
}

@InternalIcureApi
internal class HealthcarePartyApiImpl(
	rawApi: RawHealthcarePartyApi,
	config: BasicApiConfiguration,
) : HealthcarePartyApi, AbstractHealthcarePartyApi(rawApi, config) {

	override val inGroup: HealthcarePartyInGroupApi = HealthcarePartyInGroupApiImpl(rawApi, config)

	override suspend fun getCurrentHealthcareParty() = rawApi.getCurrentHealthcareParty().successBody()

	override suspend fun getHealthcareParty(healthcarePartyId: String) =
		doGetHealthcareParty(groupId = null, entityId = healthcarePartyId)

	override suspend fun getHealthcareParties(healthcarePartyIds: List<String>): List<HealthcareParty> =
		doGetHealthcareParties(groupId = null, entityIds = healthcarePartyIds)

	override suspend fun createHealthcareParty(healthcareParty: HealthcareParty) =
		doCreateHealthcareParty(groupId = null, entity = healthcareParty)

	override suspend fun createHealthcareParties(healthcareParties: List<HealthcareParty>): List<HealthcareParty> {
		basicRequireIsValidForCreation(healthcareParties)
		return doCreateHealthcareParties(groupId = null, entities = healthcareParties)
	}

	override suspend fun modifyHealthcareParty(healthcareParty: HealthcareParty) =
		doModifyHealthcareParty(groupId = null, entity = healthcareParty)

	override suspend fun modifyHealthcareParties(healthcareParties: List<HealthcareParty>): List<HealthcareParty> {
		requireIsValidForModification(healthcareParties)
		return doModifyHealthcareParties(groupId = null, entities = healthcareParties)
	}

	override suspend fun getPublicKey(healthcarePartyId: String) = rawApi.getPublicKey(healthcarePartyId).successBody()

	override suspend fun matchHealthcarePartiesBy(filter: BaseFilterOptions<HealthcareParty>) =
		doMatchHealthcarePartiesBy(groupId = null, filter = filter)

	override suspend fun filterHealthPartiesBy(filter: BaseFilterOptions<HealthcareParty>): PaginatedListIterator<HealthcareParty> =
		IdsPageIterator(matchHealthcarePartiesBy(filter), this::getHealthcareParties)

	override suspend fun matchHealthcarePartiesBySorted(filter: BaseSortableFilterOptions<HealthcareParty>) =
		doMatchHealthcarePartiesBySorted(groupId = null, filter = filter)

	override suspend fun filterHealthPartiesBySorted(filter: BaseSortableFilterOptions<HealthcareParty>): PaginatedListIterator<HealthcareParty> =
		filterHealthPartiesBy(filter)

	override suspend fun deleteHealthcarePartyById(entityId: String, rev: String): StoredDocumentIdentifier =
		doDeleteHealthcareParty(groupId = null, entityId = entityId, rev = rev)

	override suspend fun deleteHealthcarePartiesByIds(entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier> =
		doDeleteHealthcareParties(groupId = null, entityIds = entityIds)

	override suspend fun purgeHealthcarePartyById(id: String, rev: String) {
		doPurgeHealthcareParty(groupId = null, entityId = id, rev = rev)
	}

	override suspend fun purgeHealthcarePartiesByIds(entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier> =
		doPurgeHealthcareParties(groupId = null, entityIds = entityIds)

	override suspend fun undeleteHealthcarePartyById(id: String, rev: String): HealthcareParty =
		doUndeleteHealthcareParty(groupId = null, entityId = id, rev = rev)

	override suspend fun undeleteHealthcarePartiesByIds(entityIds: List<StoredDocumentIdentifier>): List<HealthcareParty> =
		doUndeleteHealthcareParties(groupId = null, entityIds = entityIds)

	override suspend fun registerPatient(
		groupId: String,
		parentHcPartyId: String?,
		token: String?,
		useShortToken: Boolean?,
		hcp: HealthcareParty,
	) = rawApi.registerPatient(groupId, parentHcPartyId, token, useShortToken, hcp).successBody()

	override suspend fun subscribeToEvents(
		events: Set<SubscriptionEventType>,
		filter: FilterOptions<HealthcareParty>,
		subscriptionConfig: EntitySubscriptionConfiguration?,
	): EntitySubscription<HealthcareParty> {
		return WebSocketSubscription.initialize(
			client = config.rawApiConfig.httpClient,
			hostname = config.apiUrl,
			path = "/ws/v2/notification/subscribe",
			clientJson = config.rawApiConfig.json,
			entitySerializer = HealthcareParty.serializer(),
			events = events,
			filter = mapHealthcarePartyFilterOptions(filter),
			qualifiedName = HealthcareParty.KRAKEN_QUALIFIED_NAME,
			subscriptionRequestSerializer = {
				Serialization.json.encodeToString(SubscriptionSerializer(HealthcarePartyAbstractFilterSerializer), it)
			},
			webSocketAuthProvider = config.requireWebSocketAuthProvider(),
			config = subscriptionConfig
		)
	}
}

@OptIn(InternalIcureApi::class)
internal class HealthcarePartyInGroupApiImpl(
	rawApi: RawHealthcarePartyApi,
	config: BasicApiConfiguration
) : HealthcarePartyInGroupApi, AbstractHealthcarePartyApi(rawApi, config) {

	override suspend fun createHealthcareParty(healthcareParty: GroupScoped<HealthcareParty>): GroupScoped<HealthcareParty> =
		groupScopedWith(healthcareParty) { groupId, entity -> doCreateHealthcareParty(groupId, entity) }

	override suspend fun createHealthcareParties(healthcareParties: List<GroupScoped<HealthcareParty>>): List<GroupScoped<HealthcareParty>> {
		basicRequireIsValidForCreationInGroup(healthcareParties)
		return healthcareParties.mapUniqueIdentifiablesChunkedByGroup { groupId, chunk ->
			doCreateHealthcareParties(groupId, chunk)
		}
	}

	override suspend fun getHealthcareParty(groupId: String, healthcarePartyId: String): GroupScoped<HealthcareParty>? =
		groupScopedIn(groupId) { doGetHealthcareParty(groupId = groupId, entityId = healthcarePartyId) }

	override suspend fun getHealthcareParties(groupId: String, healthcarePartiesIds: List<String>): List<GroupScoped<HealthcareParty>> =
		groupScopedListIn(groupId) { doGetHealthcareParties(groupId = groupId, healthcarePartiesIds) }

	override suspend fun modifyHealthcareParty(healthcareParty: GroupScoped<HealthcareParty>): GroupScoped<HealthcareParty> =
		groupScopedWith(healthcareParty) { groupId, entity -> doModifyHealthcareParty(groupId, entity) }

	override suspend fun modifyHealthcareParties(healthcareParties: List<GroupScoped<HealthcareParty>>): List<GroupScoped<HealthcareParty>> {
		requireIsValidForModificationInGroup(healthcareParties)
		return healthcareParties.mapUniqueIdentifiablesChunkedByGroup { groupId, chunk ->
			doModifyHealthcareParties(groupId, chunk)
		}
	}

	override suspend fun deleteHealthcarePartyById(entityId: GroupScoped<StoredDocumentIdentifier>): GroupScoped<StoredDocumentIdentifier> =
		groupScopedWith(entityId) { groupId, entity -> doDeleteHealthcareParty(groupId = groupId, entityId = entity.id, rev = entity.rev) }

	override suspend fun deleteHealthcarePartyByIds(entityIds: List<GroupScoped<StoredDocumentIdentifier>>): List<GroupScoped<StoredDocumentIdentifier>> =
		entityIds.mapUniqueIdentifiablesChunkedByGroup { groupId, chunk ->
			doDeleteHealthcareParties(groupId = groupId, entityIds = chunk)
		}

	override suspend fun undeleteHealthcarePartyById(entityId: GroupScoped<StoredDocumentIdentifier>): GroupScoped<HealthcareParty> =
		groupScopedWith(entityId) { groupId, entity -> doUndeleteHealthcareParty(groupId = groupId, entityId = entity.id, rev = entity.rev) }

	override suspend fun undeleteHealthcarePartyByIds(entityIds: List<GroupScoped<StoredDocumentIdentifier>>): List<GroupScoped<HealthcareParty>> =
		entityIds.mapUniqueIdentifiablesChunkedByGroup { groupId, chunk ->
			doUndeleteHealthcareParties(groupId = groupId, entityIds = chunk)
		}

	override suspend fun purgeHealthcarePartyById(entityId: GroupScoped<StoredDocumentIdentifier>) {
		doPurgeHealthcareParty(groupId = entityId.groupId, entityId = entityId.entity.id, rev = entityId.entity.rev)
	}

	override suspend fun purgeHealthcarePartyByIds(entityIds: List<GroupScoped<StoredDocumentIdentifier>>): List<GroupScoped<StoredDocumentIdentifier>> =
		entityIds.mapUniqueIdentifiablesChunkedByGroup { groupId, chunk ->
			doPurgeHealthcareParties(groupId = groupId, entityIds = chunk)
		}

	override suspend fun matchHealthcarePartiesBy(
		groupId: String,
		filter: BaseFilterOptions<HealthcareParty>,
	): List<String> = doMatchHealthcarePartiesBy(groupId = groupId, filter = filter)

	override suspend fun matchHealthcarePartiesBySorted(
		groupId: String,
		filter: BaseSortableFilterOptions<HealthcareParty>,
	): List<String> = doMatchHealthcarePartiesBySorted(groupId, filter = filter)

	override suspend fun filterHealthPartiesBy(
		groupId: String,
		filter: BaseFilterOptions<HealthcareParty>,
	): PaginatedListIterator<GroupScoped<HealthcareParty>> =
		IdsPageIterator(matchHealthcarePartiesBy(groupId = groupId, filter = filter)) { ids ->
			doGetHealthcareParties(groupId = groupId, entityIds = ids).map {
				GroupScoped(groupId = groupId, entity = it)
			}
		}

	override suspend fun filterHealthPartiesBySorted(
		groupId: String,
		filter: BaseSortableFilterOptions<HealthcareParty>,
	): PaginatedListIterator<GroupScoped<HealthcareParty>> = filterHealthPartiesBy(groupId, filter = filter)

}
