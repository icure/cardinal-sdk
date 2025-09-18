package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.model.specializations.Base64String
import com.icure.cardinal.sdk.model.specializations.SecureDelegationKeyString
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.Set

@Serializable
public data class SecureDelegation(
	public val delegator: String? = null,
	public val `delegate`: String? = null,
	@DefaultValue("emptySet()")
	public val secretIds: Set<Base64String> = emptySet(),
	@DefaultValue("emptySet()")
	public val encryptionKeys: Set<Base64String> = emptySet(),
	@DefaultValue("emptySet()")
	public val owningEntityIds: Set<Base64String> = emptySet(),
	@DefaultValue("emptySet()")
	public val parentDelegations: Set<SecureDelegationKeyString> = emptySet(),
	public val exchangeDataId: String? = null,
	public val permissions: AccessLevel,
)
