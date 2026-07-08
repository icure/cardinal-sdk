package com.icure.cardinal.sdk.api.impl

import com.icure.cardinal.sdk.api.InsuranceInGroupApi
import com.icure.cardinal.sdk.api.InsuranceApi
import com.icure.cardinal.sdk.api.raw.RawInsuranceApi
import com.icure.cardinal.sdk.api.raw.successBodyOrNull404
import com.icure.cardinal.sdk.api.raw.successBodyOrThrowRevisionConflict
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.filters.mapInsuranceFilterOptions
import com.icure.cardinal.sdk.model.Insurance
import com.icure.cardinal.sdk.model.GroupScoped
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.ListOfIdsAndRev
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
import com.icure.cardinal.sdk.model.toStoredDocumentIdentifier
import com.icure.cardinal.sdk.options.BasicApiConfiguration
import com.icure.cardinal.sdk.utils.pagination.IdsPageIterator
import com.icure.cardinal.sdk.utils.pagination.PaginatedListIterator
import com.icure.utils.InternalIcureApi

@OptIn(InternalIcureApi::class)
internal abstract class AbstractInsuranceApi(
	protected val rawApi: RawInsuranceApi,
	private val config: BasicApiConfiguration
) {

	protected suspend fun doCreateInsurance(groupId: String?, entity: Insurance): Insurance {
		requireIsValidForCreation(entity)
		return if (groupId == null) {
			rawApi.createInsurance(insuranceDto = entity)
		} else {
			rawApi.createInsuranceInGroup(groupId = groupId, insurance = entity)
		}.successBody()
	}

	protected suspend fun doCreateInsurances(groupId: String?, entities: List<Insurance>): List<Insurance> =
		skipRequestOnEmptyList(entities) { insurances ->
			if (groupId == null) {
				rawApi.createInsurances(insuranceDtos = insurances)
			} else {
				rawApi.createInsurancesInGroup(groupId = groupId, insuranceBatch = insurances)
			}.successBody()
		}

	protected suspend fun doGetInsurance(groupId: String?, entityId: String): Insurance? =
		if (groupId == null) {
			rawApi.getInsurance(insuranceId = entityId)
		} else {
			rawApi.getInsuranceInGroup(groupId = groupId, insuranceId = entityId)
		}.successBodyOrNull404()

	protected suspend fun doGetInsurances(groupId: String?, entityIds: List<String>): List<Insurance> =
		skipRequestOnEmptyList(entityIds) { ids ->
			if (groupId == null) {
				rawApi.getInsurances(insuranceIds = ListOfIds(ids))
			} else {
				rawApi.getInsurancesInGroup(groupId = groupId, insuranceIds = ListOfIds(ids))
			}.successBody()
		}

	protected suspend fun doModifyInsurance(groupId: String?, entity: Insurance): Insurance {
		requireIsValidForModification(entity)
		return if (groupId == null) {
			rawApi.modifyInsurance(insuranceDto = entity)
		} else {
			rawApi.modifyInsuranceInGroup(groupId = groupId, insurance = entity)
		}.successBodyOrThrowRevisionConflict()
	}

	protected suspend fun doModifyInsurances(groupId: String?, entities: List<Insurance>): List<Insurance> =
		skipRequestOnEmptyList(entities) { insurances ->
			if (groupId == null) {
				rawApi.modifyInsurances(insuranceDtos = insurances)
			} else {
				rawApi.modifyInsurancesInGroup(groupId = groupId, insuranceBatch = insurances)
			}.successBody()
		}

	protected suspend fun doDeleteInsurance(groupId: String?, entityId: String, rev: String): StoredDocumentIdentifier =
		if (groupId == null) {
			rawApi.deleteInsurance(insuranceId = entityId, rev = rev)
		} else {
			rawApi.deleteInsuranceInGroup(groupId = groupId, insuranceId = entityId, rev = rev)
		}.successBodyOrThrowRevisionConflict().toStoredDocumentIdentifier()

	protected suspend fun doDeleteInsurances(groupId: String?, entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier> =
		skipRequestOnEmptyList(entityIds) { ids ->
			if (groupId == null) {
				rawApi.deleteInsurances(insuranceIds = ListOfIdsAndRev(ids))
			} else {
				rawApi.deleteInsurancesInGroup(groupId = groupId, insuranceIds = ListOfIdsAndRev(ids))
			}.successBody().map { it.toStoredDocumentIdentifier() }
		}

	protected suspend fun doUndeleteInsurance(groupId: String?, entityId: String, rev: String): Insurance =
		if (groupId == null) {
			rawApi.undeleteInsurance(insuranceId = entityId, rev = rev)
		} else {
			rawApi.undeleteInsuranceInGroup(groupId = groupId, insuranceId = entityId, rev = rev)
		}.successBodyOrThrowRevisionConflict()

	protected suspend fun doUndeleteInsurances(groupId: String?, entityIds: List<StoredDocumentIdentifier>): List<Insurance> =
		skipRequestOnEmptyList(entityIds) { ids ->
			if (groupId == null) {
				rawApi.undeleteInsurances(insuranceIds = ListOfIdsAndRev(ids))
			} else {
				rawApi.undeleteInsurancesInGroup(groupId = groupId, insuranceIds = ListOfIdsAndRev(ids))
			}.successBody()
		}

	protected suspend fun doPurgeInsurance(groupId: String?, entityId: String, rev: String) {
		if (groupId == null) {
			rawApi.purgeInsurance(insuranceId = entityId, rev = rev)
		} else {
			rawApi.purgeInsuranceInGroup(groupId = groupId, insuranceId = entityId, rev = rev)
		}.successBodyOrThrowRevisionConflict()
	}

	protected suspend fun doPurgeInsurances(groupId: String?, entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier> =
		skipRequestOnEmptyList(entityIds) { ids ->
			if (groupId == null) {
				rawApi.purgeInsurances(insuranceIds = ListOfIdsAndRev(ids))
			} else {
				rawApi.purgeInsurancesInGroup(groupId = groupId, insuranceIds = ListOfIdsAndRev(ids))
			}.successBody().map { it.toStoredDocumentIdentifier() }
		}

	protected suspend fun doMatchInsurancesBy(groupId: String?, filter: BaseFilterOptions<Insurance>) =
		if (groupId == null) {
			rawApi.matchInsurancesBy(filter = mapInsuranceFilterOptions(filter, config))
		} else {
			rawApi.matchInsurancesBy(groupId = groupId, filter = mapInsuranceFilterOptions(filter, config, groupId))
		}.successBody()

	protected suspend fun doMatchInsurancesBySorted(groupId: String?, filter: BaseSortableFilterOptions<Insurance>) =
		doMatchInsurancesBy(groupId = groupId, filter = filter)
}

@InternalIcureApi
internal class InsuranceApiImpl(
	rawApi: RawInsuranceApi,
	config: BasicApiConfiguration
) : InsuranceApi, AbstractInsuranceApi(rawApi, config) {

	override val inGroup: InsuranceInGroupApi = InsuranceInGroupApiImpl(rawApi, config)

	override suspend fun getInsurance(insuranceId: String) = doGetInsurance(groupId = null, entityId = insuranceId)

	override suspend fun getInsurances(insurancesIds: List<String>) =
		doGetInsurances(groupId = null, entityIds = insurancesIds)

	override suspend fun createInsurance(insurance: Insurance) = doCreateInsurance(groupId = null, entity = insurance)
	override suspend fun createInsurances(insurances: List<Insurance>): List<Insurance> {
		requireIsValidForCreation(insurances)
		return doCreateInsurances(groupId = null, entities = insurances)
	}

	override suspend fun modifyInsurance(insurance: Insurance) = doModifyInsurance(groupId = null, entity = insurance)
	override suspend fun modifyInsurances(insurances: List<Insurance>): List<Insurance> {
		requireIsValidForModification(insurances)
		return doModifyInsurances(groupId = null, entities = insurances)
	}

	override suspend fun deleteInsuranceById(
		entityId: String,
		rev: String,
	): StoredDocumentIdentifier = doDeleteInsurance(groupId = null, entityId = entityId, rev = rev)

	override suspend fun deleteInsuranceByIds(entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier> =
		doDeleteInsurances(groupId = null, entityIds = entityIds)

	override suspend fun undeleteInsuranceById(entityId: String, rev: String): Insurance =
		doUndeleteInsurance(groupId = null, entityId = entityId, rev = rev)

	override suspend fun undeleteInsuranceByIds(entityIds: List<StoredDocumentIdentifier>): List<Insurance> =
		doUndeleteInsurances(groupId = null, entityIds = entityIds)

	override suspend fun purgeInsuranceById(entityId: String, rev: String) {
		doPurgeInsurance(groupId = null, entityId = entityId, rev = rev)
	}

	override suspend fun purgeInsuranceByIds(entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier> =
		doPurgeInsurances(groupId = null, entityIds = entityIds)

	override suspend fun listInsurancesByCode(insuranceCode: String) =
		rawApi.listInsurancesByCode(insuranceCode = insuranceCode).successBody()

	override suspend fun listInsurancesByName(insuranceName: String) =
		rawApi.listInsurancesByName(insuranceName = insuranceName).successBody()

	override suspend fun matchInsurancesBy(filter: BaseFilterOptions<Insurance>): List<String> =
		doMatchInsurancesBy(groupId = null, filter = filter)

	override suspend fun filterInsurancesBy(filter: BaseFilterOptions<Insurance>): PaginatedListIterator<Insurance> =
		IdsPageIterator(matchInsurancesBy(filter), this::getInsurances)

	override suspend fun matchInsurancesBySorted(filter: BaseSortableFilterOptions<Insurance>): List<String> =
		doMatchInsurancesBySorted(groupId = null, filter = filter)

	override suspend fun filterInsurancesBySorted(filter: BaseSortableFilterOptions<Insurance>): PaginatedListIterator<Insurance> =
		IdsPageIterator(matchInsurancesBySorted(filter), this::getInsurances)
}

@OptIn(InternalIcureApi::class)
internal class InsuranceInGroupApiImpl(
	rawApi: RawInsuranceApi,
	config: BasicApiConfiguration
) : InsuranceInGroupApi, AbstractInsuranceApi(rawApi, config) {

	override suspend fun createInsurance(insurance: GroupScoped<Insurance>): GroupScoped<Insurance> =
		groupScopedWith(insurance) { groupId, entity -> doCreateInsurance(groupId, entity) }

	override suspend fun createInsurances(insurances: List<GroupScoped<Insurance>>): List<GroupScoped<Insurance>> {
		requireIsValidForCreationInGroup(insurances)
		return insurances.mapUniqueIdentifiablesChunkedByGroup { groupId, chunk ->
			doCreateInsurances(groupId, chunk)
		}
	}

	override suspend fun getInsurance(groupId: String, insuranceId: String): GroupScoped<Insurance>? =
		groupScopedIn(groupId) { doGetInsurance(groupId = groupId, entityId = insuranceId) }

	override suspend fun getInsurances(groupId: String, insurancesIds: List<String>): List<GroupScoped<Insurance>> =
		groupScopedListIn(groupId) { doGetInsurances(groupId = groupId, insurancesIds) }

	override suspend fun modifyInsurance(insurance: GroupScoped<Insurance>): GroupScoped<Insurance> =
		groupScopedWith(insurance) { groupId, entity -> doModifyInsurance(groupId, entity) }

	override suspend fun modifyInsurances(insurances: List<GroupScoped<Insurance>>): List<GroupScoped<Insurance>> {
		requireIsValidForModificationInGroup(insurances)
		return insurances.mapUniqueIdentifiablesChunkedByGroup { groupId, chunk ->
			doModifyInsurances(groupId, chunk)
		}
	}

	override suspend fun deleteInsuranceById(entityId: GroupScoped<StoredDocumentIdentifier>): GroupScoped<StoredDocumentIdentifier> =
		groupScopedWith(entityId) { groupId, entity -> doDeleteInsurance(groupId = groupId, entityId = entity.id, rev = entity.rev) }

	override suspend fun deleteInsuranceByIds(entityIds: List<GroupScoped<StoredDocumentIdentifier>>): List<GroupScoped<StoredDocumentIdentifier>> =
		entityIds.mapUniqueIdentifiablesChunkedByGroup { groupId, chunk ->
			doDeleteInsurances(groupId = groupId, entityIds = chunk)
		}

	override suspend fun undeleteInsuranceById(entityId: GroupScoped<StoredDocumentIdentifier>): GroupScoped<Insurance> =
		groupScopedWith(entityId) { groupId, entity -> doUndeleteInsurance(groupId = groupId, entityId = entity.id, rev = entity.rev) }

	override suspend fun undeleteInsuranceByIds(entityIds: List<GroupScoped<StoredDocumentIdentifier>>): List<GroupScoped<Insurance>> =
		entityIds.mapUniqueIdentifiablesChunkedByGroup { groupId, chunk ->
			doUndeleteInsurances(groupId = groupId, entityIds = chunk)
		}

	override suspend fun purgeInsuranceById(entityId: GroupScoped<StoredDocumentIdentifier>) {
		doPurgeInsurance(groupId = entityId.groupId, entityId = entityId.entity.id, rev = entityId.entity.rev)
	}

	override suspend fun purgeInsuranceByIds(entityIds: List<GroupScoped<StoredDocumentIdentifier>>): List<GroupScoped<StoredDocumentIdentifier>> =
		entityIds.mapUniqueIdentifiablesChunkedByGroup { groupId, chunk ->
			doPurgeInsurances(groupId = groupId, entityIds = chunk)
		}

	override suspend fun matchInsurancesBy(
		groupId: String,
		filter: BaseFilterOptions<Insurance>,
	): List<String> = doMatchInsurancesBy(groupId = groupId, filter = filter)

	override suspend fun matchInsurancesBySorted(
		groupId: String,
		filter: BaseSortableFilterOptions<Insurance>,
	): List<String> = doMatchInsurancesBySorted(groupId = groupId, filter = filter)

	override suspend fun filterInsurancesBy(
		groupId: String,
		filter: BaseFilterOptions<Insurance>,
	): PaginatedListIterator<GroupScoped<Insurance>> =
		IdsPageIterator(matchInsurancesBy(groupId, filter)) { ids ->
			getInsurances(groupId = groupId, insurancesIds = ids)
		}

	override suspend fun filterInsurancesBySorted(
		groupId: String,
		filter: BaseSortableFilterOptions<Insurance>,
	): PaginatedListIterator<GroupScoped<Insurance>> =
		IdsPageIterator(matchInsurancesBySorted(groupId, filter)) { ids ->
			getInsurances(groupId = groupId, insurancesIds = ids)
		}

}
