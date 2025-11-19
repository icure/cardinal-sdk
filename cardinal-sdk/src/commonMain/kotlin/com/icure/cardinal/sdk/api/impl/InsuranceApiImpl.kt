package com.icure.cardinal.sdk.api.impl

import com.icure.cardinal.sdk.api.InsuranceApi
import com.icure.cardinal.sdk.api.raw.RawInsuranceApi
import com.icure.cardinal.sdk.api.raw.successBodyOrNull404
import com.icure.cardinal.sdk.api.raw.successBodyOrThrowRevisionConflict
import com.icure.cardinal.sdk.model.Insurance
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.utils.InternalIcureApi

@InternalIcureApi
internal class InsuranceApiImpl(
	private val rawApi: RawInsuranceApi,
) : InsuranceApi {
	override suspend fun getInsurance(insuranceId: String) = rawApi.getInsurance(insuranceId).successBodyOrNull404()

	override suspend fun getInsurances(insuranceIds: List<String>) = rawApi.getInsurances(
		ListOfIds(insuranceIds)
	).successBody()

	override suspend fun createInsurance(insurance: Insurance) = rawApi.createInsurance(insurance).successBody()

	override suspend fun deleteInsurance(insuranceId: String) = rawApi.deleteInsurance(insuranceId).successBody()

	@Deprecated("Will be replaced by filters")
	override suspend fun getAllInsurances(
		startDocumentId: String?,
		limit: Int?,
	) = rawApi.getAllInsurances(startDocumentId, limit).successBody()

	override suspend fun listInsurancesByCode(insuranceCode: String) = rawApi.listInsurancesByCode(insuranceCode).successBody()

	override suspend fun listInsurancesByName(insuranceName: String) = rawApi.listInsurancesByName(insuranceName).successBody()

	override suspend fun modifyInsurance(insurance: Insurance) = rawApi.modifyInsurance(insurance).successBodyOrThrowRevisionConflict()

	override suspend fun createInsurancesInGroup(groupId: String, insuranceBatch: List<Insurance>): List<Insurance> =
		rawApi.createInsurancesInGroup(groupId, insuranceBatch).successBody()

	override suspend fun getInsurancesInGroup(groupId: String, insuranceIds: List<String>): List<Insurance> =
		rawApi.getInsurancesInGroup(groupId, ListOfIds(insuranceIds)).successBody()

	override suspend fun modifyInsurancesInGroup(groupId: String, insuranceBatch: List<Insurance>): List<Insurance> =
		rawApi.modifyInsurancesInGroup(groupId, insuranceBatch).successBody()
}
