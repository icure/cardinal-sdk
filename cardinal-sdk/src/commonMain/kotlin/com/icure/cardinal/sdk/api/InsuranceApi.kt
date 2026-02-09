package com.icure.cardinal.sdk.api

import com.icure.cardinal.sdk.model.Insurance
import com.icure.cardinal.sdk.model.GroupScoped
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
import com.icure.cardinal.sdk.model.toStoredDocumentIdentifier

interface InsuranceApi {

	val inGroup: InsuranceInGroupApi

	suspend fun createInsurance(insurance: Insurance): Insurance
	suspend fun createInsurances(insurances: List<Insurance>): List<Insurance>

	suspend fun getInsurance(insuranceId: String): Insurance?
	suspend fun getInsurances(insurancesIds: List<String>): List<Insurance>

	suspend fun modifyInsurance(insurance: Insurance): Insurance
	suspend fun modifyInsurances(insurances: List<Insurance>): List<Insurance>

	suspend fun deleteInsuranceById(entityId: String, rev: String): StoredDocumentIdentifier
	suspend fun deleteInsuranceByIds(entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier>

	suspend fun deleteInsurance(insurance: Insurance): StoredDocumentIdentifier =
		deleteInsuranceById(entityId = insurance.id, rev = requireNotNull(insurance.rev) { "Can't delete a insurance that has no rev" })
	suspend fun deleteInsurances(insurances: List<Insurance>): List<StoredDocumentIdentifier> =
		deleteInsuranceByIds(insurances.map { it.toStoredDocumentIdentifier() })

	suspend fun undeleteInsuranceById(entityId: String, rev: String): Insurance
	suspend fun undeleteInsuranceByIds(entityIds: List<StoredDocumentIdentifier>): List<Insurance>

	suspend fun undeleteInsurance(insurance: Insurance): Insurance =
		undeleteInsuranceById(entityId = insurance.id, rev = requireNotNull(insurance.rev) { "Can't undelete a insurance that has no rev" })
	suspend fun undeleteInsurances(insurances: List<Insurance>): List<Insurance> =
		undeleteInsuranceByIds(insurances.map { it.toStoredDocumentIdentifier() })

	suspend fun purgeInsuranceById(entityId: String, rev: String)
	suspend fun purgeInsuranceByIds(entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier>

	suspend fun purgeInsurance(insurance: Insurance) {
		purgeInsuranceById(entityId = insurance.id, rev = requireNotNull(insurance.rev) { "Can't purge a insurance that has no rev" })
	}
	suspend fun purgeInsurances(insurances: List<Insurance>): List<StoredDocumentIdentifier> =
		purgeInsuranceByIds(insurances.map { it.toStoredDocumentIdentifier() })

	suspend fun listInsurancesByCode(insuranceCode: String): List<Insurance>
	suspend fun listInsurancesByName(insuranceName: String): List<Insurance>

}

interface InsuranceInGroupApi {

	suspend fun createInsurance(insurance: GroupScoped<Insurance>): GroupScoped<Insurance>
	suspend fun createInsurances(insurances: List<GroupScoped<Insurance>>): List<GroupScoped<Insurance>>

	suspend fun getInsurance(groupId: String, insuranceId: String): GroupScoped<Insurance>?
	suspend fun getInsurances(groupId: String, insurancesIds: List<String>): List<GroupScoped<Insurance>>

	suspend fun modifyInsurance(insurance: GroupScoped<Insurance>): GroupScoped<Insurance>
	suspend fun modifyInsurances(insurances: List<GroupScoped<Insurance>>): List<GroupScoped<Insurance>>

	suspend fun deleteInsuranceById(entityId: GroupScoped<StoredDocumentIdentifier>): GroupScoped<StoredDocumentIdentifier>
	suspend fun deleteInsuranceByIds(entityIds: List<GroupScoped<StoredDocumentIdentifier>>): List<GroupScoped<StoredDocumentIdentifier>>

	suspend fun deleteInsurance(insurance: GroupScoped<Insurance>): GroupScoped<StoredDocumentIdentifier> =
		deleteInsuranceById(insurance.toStoredDocumentIdentifier())
	suspend fun deleteInsurances(insurances: List<GroupScoped<Insurance>>): List<GroupScoped<StoredDocumentIdentifier>> =
		deleteInsuranceByIds(insurances.map { it.toStoredDocumentIdentifier() })

	suspend fun undeleteInsuranceById(entityId: GroupScoped<StoredDocumentIdentifier>): GroupScoped<Insurance>
	suspend fun undeleteInsuranceByIds(entityIds: List<GroupScoped<StoredDocumentIdentifier>>): List<GroupScoped<Insurance>>

	suspend fun undeleteInsurance(insurance: GroupScoped<Insurance>): GroupScoped<Insurance> =
		undeleteInsuranceById(insurance.toStoredDocumentIdentifier())
	suspend fun undeleteInsurances(insurances: List<GroupScoped<Insurance>>): List<GroupScoped<Insurance>> =
		undeleteInsuranceByIds(insurances.map { it.toStoredDocumentIdentifier() })

	suspend fun purgeInsuranceById(entityId: GroupScoped<StoredDocumentIdentifier>)
	suspend fun purgeInsuranceByIds(entityIds: List<GroupScoped<StoredDocumentIdentifier>>): List<GroupScoped<StoredDocumentIdentifier>>

	suspend fun purgeInsurance(insurance: GroupScoped<Insurance>) {
		purgeInsuranceById(insurance.toStoredDocumentIdentifier())
	}
	suspend fun purgeInsurances(insurances: List<GroupScoped<Insurance>>): List<GroupScoped<StoredDocumentIdentifier>> =
		purgeInsuranceByIds(insurances.map { it.toStoredDocumentIdentifier() })

}
