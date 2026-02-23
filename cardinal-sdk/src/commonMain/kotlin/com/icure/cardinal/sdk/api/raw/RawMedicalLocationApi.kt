package com.icure.cardinal.sdk.api.raw

import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.MedicalLocation
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
public interface RawMedicalLocationApi {
	// region common endpoints

	suspend fun createMedicalLocation(medicalLocationDto: MedicalLocation): HttpResponse<MedicalLocation>

	suspend fun deleteMedicalLocations(locationIds: ListOfIds): HttpResponse<List<DocIdentifier>>

	suspend fun getMedicalLocation(locationId: String): HttpResponse<MedicalLocation>

	suspend fun getMedicalLocations(
		startDocumentId: String? = null,
		limit: Int? = null,
	): HttpResponse<PaginatedList<MedicalLocation>>

	suspend fun modifyMedicalLocation(medicalLocationDto: MedicalLocation): HttpResponse<MedicalLocation>

	suspend fun getMedicalLocationsByIds(accessLogIds: ListOfIds): HttpResponse<List<MedicalLocation>>

	suspend fun matchMedicalLocationsBy(filter: AbstractFilter<MedicalLocation>): HttpResponse<List<String>>
	// endregion
}
