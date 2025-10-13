package com.icure.cardinal.sdk.api.raw

import com.icure.cardinal.sdk.model.EncryptedApplicationSettings
import com.icure.cardinal.sdk.model.requests.BulkShareOrUpdateMetadataParams
import com.icure.cardinal.sdk.model.requests.EntityBulkShareResult
import com.icure.utils.InternalIcureApi
import kotlin.Nothing
import kotlin.collections.List

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
public interface RawApplicationSettingsApi {
	// region common endpoints

	suspend fun getApplicationSettings(): HttpResponse<List<EncryptedApplicationSettings>>

	suspend fun createApplicationSettings(applicationSettingsDto: EncryptedApplicationSettings): HttpResponse<EncryptedApplicationSettings>

	suspend fun updateApplicationSettings(applicationSettingsDto: EncryptedApplicationSettings): HttpResponse<EncryptedApplicationSettings>

	suspend fun bulkShare(request: BulkShareOrUpdateMetadataParams): HttpResponse<List<EntityBulkShareResult<EncryptedApplicationSettings>>>

	suspend fun bulkShareMinimal(request: BulkShareOrUpdateMetadataParams): HttpResponse<List<EntityBulkShareResult<Nothing>>>
	// endregion
}
