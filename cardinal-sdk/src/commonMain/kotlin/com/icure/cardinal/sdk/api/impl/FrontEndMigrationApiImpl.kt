package com.icure.cardinal.sdk.api.impl

import com.icure.cardinal.sdk.api.FrontEndMigrationApi
import com.icure.cardinal.sdk.api.raw.RawFrontEndMigrationApi
import com.icure.cardinal.sdk.api.raw.successBodyOrNull404
import com.icure.cardinal.sdk.api.raw.successBodyOrThrowRevisionConflict
import com.icure.cardinal.sdk.model.FrontEndMigration
import com.icure.utils.InternalIcureApi

@InternalIcureApi
internal  class FrontEndMigrationApiImpl(
	private val rawApi: RawFrontEndMigrationApi,
) : FrontEndMigrationApi {
	override suspend fun getFrontEndMigration(frontEndMigrationId: String) =
		rawApi.getFrontEndMigration(frontEndMigrationId = frontEndMigrationId).successBodyOrNull404()

	override suspend fun createFrontEndMigration(frontEndMigration: FrontEndMigration) =
		rawApi.createFrontEndMigration(frontEndMigrationDto = frontEndMigration).successBody()

	override suspend fun getFrontEndMigrations() = rawApi.getFrontEndMigrations().successBody()

	override suspend fun deleteFrontEndMigration(frontEndMigrationId: String) =
		rawApi.deleteFrontEndMigration(frontEndMigrationId = frontEndMigrationId).successBody()

	override suspend fun getFrontEndMigrationByName(frontEndMigrationName: String) =
		rawApi.getFrontEndMigrationByName(frontEndMigrationName = frontEndMigrationName).successBody()

	override suspend fun modifyFrontEndMigration(frontEndMigration: FrontEndMigration) =
		rawApi.modifyFrontEndMigration(frontEndMigrationDto = frontEndMigration).successBodyOrThrowRevisionConflict()
}
