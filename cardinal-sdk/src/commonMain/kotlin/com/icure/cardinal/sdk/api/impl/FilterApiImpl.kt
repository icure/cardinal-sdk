package com.icure.cardinal.sdk.api.impl

import com.icure.cardinal.sdk.api.FilterApi
import com.icure.cardinal.sdk.api.raw.RawFilterApi
import com.icure.cardinal.sdk.filters.FilterOptionsCatalog
import com.icure.cardinal.sdk.model.filter.FilterOptionGroupWithViews
import com.icure.utils.InternalIcureApi

@InternalIcureApi
class FilterApiImpl(
	private val rawApi: RawFilterApi,
) : FilterApi {
	override suspend fun getFilterOptionsDefinitions(): Map<String, List<FilterOptionGroupWithViews>> {
		val viewsByEntityFilter = rawApi.allFilterDefinitions().successBody().mapValues { (_, definitions) ->
			definitions.associateBy { it.filter }
		}
		return FilterOptionsCatalog.byEntity.entries.mapNotNull { (entity, values) ->
			if (viewsByEntityFilter.containsKey(entity)) {
				entity to values.mapNotNull { option ->
					viewsByEntityFilter[entity]?.get(option.targetFilter)?.let {
						FilterOptionGroupWithViews(
							name = option.name,
							factoryMethods = option.factoryMethods,
							targetFilter = option.targetFilter,
							views = it.views
						)
					}
				}
			} else {
				null
			}
		}.toMap()
	}
}
