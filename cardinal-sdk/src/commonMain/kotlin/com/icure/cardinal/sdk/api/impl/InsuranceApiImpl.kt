package com.icure.cardinal.sdk.api.impl

import com.icure.cardinal.sdk.api.InsuranceInGroupApi
import com.icure.cardinal.sdk.api.InsuranceApi
import com.icure.cardinal.sdk.api.raw.RawInsuranceApi
import com.icure.cardinal.sdk.api.raw.successBodyOrNull404
import com.icure.cardinal.sdk.api.raw.successBodyOrThrowRevisionConflict
import com.icure.cardinal.sdk.model.Insurance
import com.icure.cardinal.sdk.model.GroupScoped
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.ListOfIdsAndRev
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
import com.icure.cardinal.sdk.model.toStoredDocumentIdentifier
import com.icure.utils.InternalIcureApi

@OptIn(InternalIcureApi::class)
internal abstract class AbstractInsuranceApi(
	protected val rawApi: RawInsuranceApi,
) {

	protected suspend fun doCreateInsurance(groupId: String?, entity: Insurance): Insurance {
		basicRequireIsValidForCreation(entity)
		return if (groupId == null) {
			rawApi.createInsurance(entity)
		} else {
			rawApi.createInsuranceInGroup(groupId, entity)
		}.successBody()
	}

	protected suspend fun doCreateInsurances(groupId: String?, entities: List<Insurance>): List<Insurance> =
		skipRequestOnEmptyList(entities) { insurances ->
			if (groupId == null) {
				rawApi.createInsurances(insurances)
			} else {
				rawApi.createInsurancesInGroup(groupId, insurances)
			}.successBody()
		}

	protected suspend fun doGetInsurance(groupId: String?, entityId: String): Insurance? =
		if (groupId == null) {
			rawApi.getInsurance(entityId)
		} else {
			rawApi.getInsuranceInGroup(groupId, entityId)
		}.successBodyOrNull404()

	protected suspend fun doGetInsurances(groupId: String?, entityIds: List<String>): List<Insurance> =
		skipRequestOnEmptyList(entityIds) { ids ->
			if (groupId == null) {
				rawApi.getInsurances(ListOfIds(ids))
			} else {
				rawApi.getInsurancesInGroup(groupId, ListOfIds(ids))
			}.successBody()
		}

	protected suspend fun doModifyInsurance(groupId: String?, entity: Insurance): Insurance {
		requireIsValidForModification(entity)
		return if (groupId == null) {
			rawApi.modifyInsurance(entity)
		} else {
			rawApi.modifyInsuranceInGroup(groupId, entity)
		}.successBodyOrThrowRevisionConflict()
	}

	protected suspend fun doModifyInsurances(groupId: String?, entities: List<Insurance>): List<Insurance> =
		skipRequestOnEmptyList(entities) { insurances ->
			if (groupId == null) {
				rawApi.modifyInsurances(insurances)
			} else {
				rawApi.modifyInsurancesInGroup(groupId, insurances)
			}.successBody()
		}

	protected suspend fun doDeleteInsurance(groupId: String?, entityId: String, rev: String): StoredDocumentIdentifier =
		if (groupId == null) {
			rawApi.deleteInsurance(entityId, rev)
		} else {
			rawApi.deleteInsuranceInGroup(groupId, entityId, rev)
		}.successBodyOrThrowRevisionConflict().toStoredDocumentIdentifier()

	protected suspend fun doDeleteInsurances(groupId: String?, entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier> =
		skipRequestOnEmptyList(entityIds) { ids ->
			if (groupId == null) {
				rawApi.deleteInsurances(ListOfIdsAndRev(ids))
			} else {
				rawApi.deleteInsurancesInGroup(groupId = groupId, ListOfIdsAndRev(ids))
			}.successBody().map { it.toStoredDocumentIdentifier() }
		}

	protected suspend fun doUndeleteInsurance(groupId: String?, entityId: String, rev: String): Insurance =
		if (groupId == null) {
			rawApi.undeleteInsurance(entityId, rev)
		} else {
			rawApi.undeleteInsuranceInGroup(groupId, entityId, rev)
		}.successBodyOrThrowRevisionConflict()

	protected suspend fun doUndeleteInsurances(groupId: String?, entityIds: List<StoredDocumentIdentifier>): List<Insurance> =
		skipRequestOnEmptyList(entityIds) { ids ->
			if (groupId == null) {
				rawApi.undeleteInsurances(ListOfIdsAndRev(ids))
			} else {
				rawApi.undeleteInsurancesInGroup(groupId = groupId, ListOfIdsAndRev(ids))
			}.successBody()
		}

	protected suspend fun doPurgeInsurance(groupId: String?, entityId: String, rev: String) {
		if (groupId == null) {
			rawApi.purgeInsurance(entityId, rev)
		} else {
			rawApi.purgeInsuranceInGroup(groupId, entityId, rev)
		}.successBodyOrThrowRevisionConflict()
	}

	protected suspend fun doPurgeInsurances(groupId: String?, entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier> =
		skipRequestOnEmptyList(entityIds) { ids ->
			if (groupId == null) {
				rawApi.purgeInsurances(ListOfIdsAndRev(ids))
			} else {
				rawApi.purgeInsurancesInGroup(groupId = groupId, ListOfIdsAndRev(ids))
			}.successBody().map { it.toStoredDocumentIdentifier() }
		}
}

@InternalIcureApi
internal class InsuranceApiImpl(
	rawApi: RawInsuranceApi,
) : InsuranceApi, AbstractInsuranceApi(rawApi) {

	override val inGroup: InsuranceInGroupApi = InsuranceInGroupApiImpl(rawApi)

	override suspend fun getInsurance(insuranceId: String) = doGetInsurance(groupId = null, entityId = insuranceId)

	override suspend fun getInsurances(insurancesIds: List<String>) =
		doGetInsurances(groupId = null, entityIds = insurancesIds)

	override suspend fun createInsurance(insurance: Insurance) = doCreateInsurance(groupId = null, entity = insurance)
	override suspend fun createInsurances(insurances: List<Insurance>): List<Insurance> {
		basicRequireIsValidForCreation(insurances)
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
		rawApi.listInsurancesByCode(insuranceCode).successBody()

	override suspend fun listInsurancesByName(insuranceName: String) =
		rawApi.listInsurancesByName(insuranceName).successBody()

}

@OptIn(InternalIcureApi::class)
internal class InsuranceInGroupApiImpl(
	rawApi: RawInsuranceApi
) : InsuranceInGroupApi, AbstractInsuranceApi(rawApi) {

	override suspend fun createInsurance(insurance: GroupScoped<Insurance>): GroupScoped<Insurance> =
		groupScopedWith(insurance) { groupId, entity -> doCreateInsurance(groupId, entity) }

	override suspend fun createInsurances(insurances: List<GroupScoped<Insurance>>): List<GroupScoped<Insurance>> {
		basicRequireIsValidForCreationInGroup(insurances)
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

}
