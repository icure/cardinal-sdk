package com.icure.cardinal.sdk.api.raw

import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.Tarification
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.utils.InternalIcureApi
import kotlin.String
import kotlin.collections.List

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
public interface RawPricingApi {
	// region cloud endpoints

	suspend fun createCodesInGroup(
		groupId: String,
		pricingBatch: List<Tarification>,
	): HttpResponse<List<Tarification>>

	suspend fun getPricingItems(
		groupId: String,
		pricingIds: ListOfIds,
	): HttpResponse<List<Tarification>>

	suspend fun modifyPricingInGroup(
		groupId: String,
		pricingBatch: List<Tarification>,
	): HttpResponse<List<Tarification>>

	suspend fun matchPricingBy(
		groupId: String,
		filter: AbstractFilter<Tarification>,
	): HttpResponse<List<String>>
	// endregion
}
