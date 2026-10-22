package com.icure.cardinal.sdk.api.raw

import com.icure.cardinal.sdk.crypto.AccessControlKeysHeadersProvider
import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.utils.InternalIcureApi

@InternalIcureApi
abstract class BaseRawCustomEntityApi(
	config: RawApiConfig,
	protected val customEntityType: String,
	private val accessControlKeysHeadersProvider: AccessControlKeysHeadersProvider?,
	private val usesAccessControlKeys: Boolean,
) : BaseRawApi(config) {
	private val customTypeName = EntityWithEncryptionMetadataTypeName.Custom(customEntityType)

	override suspend fun getAccessControlKeysHeaderValues(groupId: String?): List<String>? =
		if (usesAccessControlKeys) {
			accessControlKeysHeadersProvider?.getAccessControlKeysHeadersFor(groupId, customTypeName)
		} else null
}