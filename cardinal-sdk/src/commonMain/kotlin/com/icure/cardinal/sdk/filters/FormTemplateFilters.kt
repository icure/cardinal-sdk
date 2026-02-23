package com.icure.cardinal.sdk.filters

import com.icure.cardinal.sdk.crypto.entities.SdkBoundGroup
import com.icure.cardinal.sdk.model.FormTemplate
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.model.filter.formtemplate.FormTemplateBySpecialtyFilter
import com.icure.cardinal.sdk.options.BasicApiConfiguration
import com.icure.utils.InternalIcureApi
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.serialization.Serializable

object FormTemplateFilters {

	/**
	 * Filter options that match all form template with the specified specialty code.
	 *
	 * @param specialtyCode the specialty code.
	 */
	fun bySpecialtyCode(
		specialtyCode: String,
	): BaseFilterOptions<FormTemplate> = BySpecialtyCode(specialtyCode)

	@Serializable
	internal class BySpecialtyCode(
		val specialtyCode: String,
	): BaseFilterOptions<FormTemplate>

}

@InternalIcureApi
internal suspend fun mapFormTemplateFilterOptions(
	filterOptions: FilterOptions<FormTemplate>,
	config: BasicApiConfiguration,
	requestGroupId: String? = null,
): AbstractFilter<FormTemplate> = mapFormTemplateFilterOptions(
	filterOptions = filterOptions,
	boundGroup = config.getBoundGroup(currentCoroutineContext()),
	requestGroupId = requestGroupId,
)

@InternalIcureApi
internal suspend fun mapFormTemplateFilterOptions(
	filterOptions: FilterOptions<FormTemplate>,
	boundGroup: SdkBoundGroup?,
	requestGroupId: String? = null,
): AbstractFilter<FormTemplate> = mapIfMetaFilterOptions(filterOptions) {
	mapFormTemplateFilterOptions(it, boundGroup, requestGroupId)
} ?: when (filterOptions) {
	is FormTemplateFilters.BySpecialtyCode -> FormTemplateBySpecialtyFilter(filterOptions.specialtyCode)
	else -> throw IllegalArgumentException("Filter options ${filterOptions::class.simpleName} are not valid for filtering Form Templates")
}
