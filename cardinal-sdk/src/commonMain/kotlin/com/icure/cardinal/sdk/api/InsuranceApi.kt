package com.icure.cardinal.sdk.api

import com.icure.cardinal.sdk.model.Insurance
import com.icure.cardinal.sdk.model.PaginatedList
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.utils.DefaultValue

interface InsuranceApi {
	suspend fun getInsurance(insuranceId: String): Insurance?
	suspend fun getInsurances(insuranceIds: List<String>): List<Insurance>
	suspend fun createInsurance(insurance: Insurance): Insurance
	suspend fun deleteInsurance(insuranceId: String): DocIdentifier
	@Deprecated("Will be replaced by filters")
	suspend fun getAllInsurances(
		@DefaultValue("null")
		startDocumentId: String? = null,
		@DefaultValue("null")
		limit: Int? = null
	): PaginatedList<Insurance>
	suspend fun listInsurancesByCode(insuranceCode: String): List<Insurance>
	suspend fun listInsurancesByName(insuranceName: String): List<Insurance>
	suspend fun modifyInsurance(insurance: Insurance): Insurance

	// Wrappers for missing methods in rawApi
	suspend fun createInsurancesInGroup(groupId: String, insuranceBatch: List<Insurance>): List<Insurance>
	suspend fun getInsurancesInGroup(groupId: String, insuranceIds: List<String>): List<Insurance>
	suspend fun modifyInsurancesInGroup(groupId: String, insuranceBatch: List<Insurance>): List<Insurance>
}
