package com.icure.cardinal.sdk.model.requests

import com.icure.cardinal.sdk.model.specializations.Base64String
import com.icure.cardinal.sdk.model.specializations.SecureDelegationKeyString
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.collections.Map

@Serializable
public data class EntitySharedMetadataUpdateRequest(
	public val metadataAccessControlHash: SecureDelegationKeyString,
	@DefaultValue("emptyMap()")
	public val secretIds: Map<Base64String, EntryUpdateType> = emptyMap(),
	@DefaultValue("emptyMap()")
	public val encryptionKeys: Map<Base64String, EntryUpdateType> = emptyMap(),
	@DefaultValue("emptyMap()")
	public val owningEntityIds: Map<Base64String, EntryUpdateType> = emptyMap(),
)
