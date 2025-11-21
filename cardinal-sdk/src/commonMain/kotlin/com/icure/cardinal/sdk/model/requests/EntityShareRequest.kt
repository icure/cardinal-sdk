package com.icure.cardinal.sdk.model.requests

import com.icure.cardinal.sdk.model.specializations.AccessControlKeyHexString
import com.icure.cardinal.sdk.model.specializations.Base64String
import com.icure.cardinal.sdk.model.specializations.KeypairFingerprintV2String
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.Map
import kotlin.collections.Set

@Serializable
public data class EntityShareRequest(
	public val explicitDelegator: String? = null,
	public val explicitDelegate: String? = null,
	public val accessControlKeys: Set<AccessControlKeyHexString>,
	@DefaultValue("emptySet()")
	public val secretIds: Set<Base64String> = emptySet(),
	@DefaultValue("emptySet()")
	public val encryptionKeys: Set<Base64String> = emptySet(),
	@DefaultValue("emptySet()")
	public val owningEntityIds: Set<Base64String> = emptySet(),
	public val exchangeDataId: String? = null,
	@DefaultValue("emptyMap()")
	public val encryptedExchangeDataId: Map<KeypairFingerprintV2String, Base64String> = emptyMap(),
	public val requestedPermissions: RequestedPermission,
)
