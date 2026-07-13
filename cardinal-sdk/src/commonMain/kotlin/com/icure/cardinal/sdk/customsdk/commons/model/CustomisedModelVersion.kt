package com.icure.cardinal.sdk.customsdk.commons.model

import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName

data class CustomisedModelVersion(
	val modelType: EntityWithEncryptionMetadataTypeName,
	val typeVersion: Int,
)
