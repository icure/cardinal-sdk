package com.icure.cardinal.sdk.model.notification

import com.icure.cardinal.sdk.model.base.Identifiable
import com.icure.cardinal.sdk.model.filter.chain.FilterChain
import com.icure.cardinal.sdk.model.specializations.AccessControlKeyHexString
import kotlin.String
import kotlin.collections.List

public data class Subscription<O : Identifiable<String>>(
	public val eventTypes: List<SubscriptionEventType>,
	public val entityClass: String,
	public val filter: FilterChain<O>?,
	public val accessControlKeys: List<AccessControlKeyHexString>?,
)
