package com.icure.cardinal.sdk.filters

import com.icure.cardinal.sdk.crypto.entities.SdkBoundGroup
import com.icure.cardinal.sdk.model.Insurance
import com.icure.cardinal.sdk.model.base.Identifier
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.model.filter.insurance.AllInsurancesFilter
import com.icure.cardinal.sdk.model.filter.insurance.InsuranceByIdentifiersFilter
import com.icure.cardinal.sdk.model.filter.insurance.InsuranceByTagCodeFilter
import com.icure.cardinal.sdk.options.BasicApiConfiguration
import com.icure.cardinal.sdk.utils.DefaultValue
import com.icure.utils.InternalIcureApi
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.serialization.Serializable

object InsuranceFilters {

	/**
	 * Filter options to match all insurances.
	 * These options are not sortable.
	 */
	fun all(): BaseFilterOptions<Insurance> = All

	/**
	 * Options for insurance filtering which match all the insurances that have at least
	 * an identifier that has the same exact [Identifier.system] and [Identifier.value] as one of the provided
	 * [identifiers]. Other properties of the provided identifiers are ignored.
	 *
	 * These options are sortable. When sorting using these options the insurances will be in the same order as
	 * the input identifiers. In case an entity has multiple identifiers only the first matching identifier is considered
	 * for the sorting.
	 *
	 * @param identifiers a list of identifiers
	 */
	fun byIdentifiers(identifiers: List<Identifier>): BaseFilterOptions<Insurance> = ByIdentifiers(identifiers)

	/**
	 * Options for insurance filtering which match all insurances shared directly (i.e. ignoring hierarchies) ƒthat have a certain code.
	 * If you specify only the [codeType] you will get all entities that have at least a code of that type.
	 *
	 * These options are sortable. When sorting using these options the insurances will be sorted by [codeCode]
	 *
	 * @param codeType a code type
	 * @param codeCode a code for the provided code type, or null if you want the filter to accept any entity
	 * with a code of the provided type.
	 */
	fun byCode(
		codeType: String,
		@DefaultValue("null")
		codeCode: String? = null
	): BaseSortableFilterOptions<Insurance> = ByCode(codeType, codeCode)

	/**
	 * Options for insurance filtering which match all insurances shared directly (i.e. ignoring hierarchies) that have a certain tag.
	 * If you specify only the [tagType] you will get all entities that have at least a tag of that type.
	 *
	 * These options are sortable. When sorting using these options the insurances will be sorted by [tagCode]
	 *
	 * @param tagType a tag type
	 * @param tagCode a code for the provided tag type, or null if you want the filter to accept any entity
	 * with a tag of the provided type.
	 */
	fun byTag(
		tagType: String,
		@DefaultValue("null")
		tagCode: String? = null
	): BaseSortableFilterOptions<Insurance> = ByTag(tagType, tagCode)

	@Serializable
	internal data object All : BaseFilterOptions<Insurance>

	@Serializable
	internal class ByIdentifiers(val identifiers: List<Identifier>): BaseFilterOptions<Insurance>

	@Serializable
	internal class ByCode(
		val codeType: String,
		val codeCode: String?
	): BaseSortableFilterOptions<Insurance>

	@Serializable
	internal class ByTag(
		val tagType: String,
		val tagCode: String?
	): BaseSortableFilterOptions<Insurance>
}

@InternalIcureApi
internal suspend fun mapInsuranceFilterOptions(
	filterOptions: FilterOptions<Insurance>,
	config: BasicApiConfiguration,
	requestGroupId: String? = null,
): AbstractFilter<Insurance> = mapInsuranceFilterOptions(
	filterOptions = filterOptions,
	boundGroup = config.getBoundGroup(currentCoroutineContext()),
	requestGroupId = requestGroupId,
)

@InternalIcureApi
internal suspend fun mapInsuranceFilterOptions(
	filterOptions: FilterOptions<Insurance>,
	boundGroup: SdkBoundGroup?,
	requestGroupId: String? = null,
): AbstractFilter<Insurance> = mapIfMetaFilterOptions(filterOptions) {
	mapInsuranceFilterOptions(it, boundGroup, requestGroupId)
} ?: when (filterOptions) {
	InsuranceFilters.All -> AllInsurancesFilter()
	is InsuranceFilters.ByIdentifiers -> InsuranceByIdentifiersFilter(
		identifiers = filterOptions.identifiers,
	)
	is InsuranceFilters.ByCode -> InsuranceByTagCodeFilter(
		tagType = null,
		tagCode = null,
		codeType = filterOptions.codeType,
		codeCode = filterOptions.codeCode,
	)
	is InsuranceFilters.ByTag -> InsuranceByTagCodeFilter(
		tagType = filterOptions.tagType,
		tagCode = filterOptions.tagCode,
		codeType = null,
		codeCode = null,
	)
	else -> throw IllegalArgumentException("Filter options ${filterOptions::class.simpleName} are not valid for filtering Insurances")
}
