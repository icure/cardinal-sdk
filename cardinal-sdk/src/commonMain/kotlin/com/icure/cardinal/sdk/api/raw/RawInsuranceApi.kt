package com.icure.cardinal.sdk.api.raw

import com.icure.cardinal.sdk.model.Insurance
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.ListOfIdsAndRev
import com.icure.cardinal.sdk.model.PaginatedList
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.utils.InternalIcureApi
import kotlin.Int
import kotlin.String
import kotlin.collections.List

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
public interface RawInsuranceApi {
	// region common endpoints

	suspend fun getAllInsurances(
		startDocumentId: String? = null,
		limit: Int? = null,
	): HttpResponse<PaginatedList<Insurance>>

	suspend fun createInsurance(insuranceDto: Insurance): HttpResponse<Insurance>

	suspend fun createInsurances(insuranceDtos: List<Insurance>): HttpResponse<List<Insurance>>

	suspend fun deleteInsurance(
		insuranceId: String,
		rev: String? = null,
	): HttpResponse<DocIdentifier>

	suspend fun deleteInsurances(insuranceIds: ListOfIdsAndRev): HttpResponse<List<DocIdentifier>>

	suspend fun undeleteInsurance(
		insuranceId: String,
		rev: String,
	): HttpResponse<Insurance>

	suspend fun undeleteInsurances(insuranceIds: ListOfIdsAndRev): HttpResponse<List<Insurance>>

	suspend fun purgeInsurance(
		insuranceId: String,
		rev: String,
	): HttpResponse<DocIdentifier>

	suspend fun purgeInsurances(insuranceIds: ListOfIdsAndRev): HttpResponse<List<DocIdentifier>>

	suspend fun getInsurance(insuranceId: String): HttpResponse<Insurance>

	suspend fun getInsurances(insuranceIds: ListOfIds): HttpResponse<List<Insurance>>

	suspend fun listInsurancesByCode(insuranceCode: String): HttpResponse<List<Insurance>>

	suspend fun listInsurancesByName(insuranceName: String): HttpResponse<List<Insurance>>

	suspend fun modifyInsurance(insuranceDto: Insurance): HttpResponse<Insurance>

	suspend fun modifyInsurances(insuranceDtos: List<Insurance>): HttpResponse<List<Insurance>>
	// endregion

	// region cloud endpoints

	suspend fun createInsuranceInGroup(
		groupId: String,
		insurance: Insurance,
	): HttpResponse<Insurance>

	suspend fun createInsurancesInGroup(
		groupId: String,
		insuranceBatch: List<Insurance>,
	): HttpResponse<List<Insurance>>

	suspend fun getInsuranceInGroup(
		groupId: String,
		insuranceId: String,
	): HttpResponse<Insurance>

	suspend fun getInsurancesInGroup(
		groupId: String,
		insuranceIds: ListOfIds,
	): HttpResponse<List<Insurance>>

	suspend fun modifyInsuranceInGroup(
		groupId: String,
		insurance: Insurance,
	): HttpResponse<Insurance>

	suspend fun modifyInsurancesInGroup(
		groupId: String,
		insuranceBatch: List<Insurance>,
	): HttpResponse<List<Insurance>>

	suspend fun deleteInsuranceInGroup(
		groupId: String,
		insuranceId: String,
		rev: String,
	): HttpResponse<DocIdentifier>

	suspend fun deleteInsurancesInGroup(
		groupId: String,
		insuranceIds: ListOfIdsAndRev,
	): HttpResponse<List<DocIdentifier>>

	suspend fun undeleteInsuranceInGroup(
		groupId: String,
		insuranceId: String,
		rev: String,
	): HttpResponse<Insurance>

	suspend fun undeleteInsurancesInGroup(
		groupId: String,
		insuranceIds: ListOfIdsAndRev,
	): HttpResponse<List<Insurance>>

	suspend fun purgeInsuranceInGroup(
		groupId: String,
		insuranceId: String,
		rev: String,
	): HttpResponse<DocIdentifier>

	suspend fun purgeInsurancesInGroup(
		groupId: String,
		insuranceIds: ListOfIdsAndRev,
	): HttpResponse<List<DocIdentifier>>

	suspend fun matchInsurancesBy(
		groupId: String,
		filter: AbstractFilter<Insurance>,
	): HttpResponse<List<String>>
	// endregion
}
