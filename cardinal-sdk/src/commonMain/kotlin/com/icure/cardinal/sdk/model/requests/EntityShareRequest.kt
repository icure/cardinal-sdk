package com.icure.cardinal.sdk.model.requests

import com.icure.cardinal.sdk.model.specializations.AccessControlKeyHexString
import com.icure.cardinal.sdk.model.specializations.Base64String
import com.icure.cardinal.sdk.model.specializations.KeypairFingerprintV2String
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.Map
import kotlin.collections.Set
import com.icure.utils.InternalIcureApi

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class EntityShareRequest(
	public val explicitDelegator: String? = null,
	public val explicitDelegate: String? = null,
	public val accessControlKeys: Set<AccessControlKeyHexString>,
	@param:DefaultValue("emptySet()")
	public val secretIds: Set<Base64String> = emptySet(),
	@param:DefaultValue("emptySet()")
	public val encryptionKeys: Set<Base64String> = emptySet(),
	@param:DefaultValue("emptySet()")
	public val owningEntityIds: Set<Base64String> = emptySet(),
	public val exchangeDataId: String? = null,
	@param:DefaultValue("emptyMap()")
	public val encryptedExchangeDataId: Map<KeypairFingerprintV2String, Base64String> = emptyMap(),
	public val requestedPermissions: RequestedPermission,
) {
	// region EntityShareRequest-EntityShareRequest
	@InternalIcureApi
	fun wrap() = EntityShareOrMetadataUpdateRequest(share = this)
	// endregion
}
