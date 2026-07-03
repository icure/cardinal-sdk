package com.icure.cardinal.sdk.api.raw

import com.icure.cardinal.sdk.model.FilterDefinition
import com.icure.utils.InternalIcureApi
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
public interface RawFilterApi {
	// region common endpoints

	suspend fun allFilterDefinitions(): HttpResponse<Map<String, List<FilterDefinition>>>
	// endregion
}
