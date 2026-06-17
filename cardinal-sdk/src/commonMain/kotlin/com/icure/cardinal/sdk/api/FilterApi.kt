package com.icure.cardinal.sdk.api

import com.icure.cardinal.sdk.model.filter.FilterOptionGroupWithViews

interface FilterApi {

	suspend fun getFilterOptionsDefinitions(): Map<String, List<FilterOptionGroupWithViews>>

}
