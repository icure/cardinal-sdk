package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.model.specializations.SecureDelegationKeyString
import kotlinx.serialization.Serializable
import kotlin.collections.Map

@Serializable
public data class SecurityMetadata(
	public val secureDelegations: Map<SecureDelegationKeyString, SecureDelegation>,
)
