package com.icure.cardinal.sdk.api.raw

import com.icure.cardinal.sdk.model.EntityReference
import com.icure.utils.InternalIcureApi
import kotlin.String

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
public interface RawEntityReferenceApi {
	// region common endpoints

	suspend fun getLatest(prefix: String): HttpResponse<EntityReference>

	suspend fun createEntityReference(er: EntityReference): HttpResponse<EntityReference>
	// endregion
}
