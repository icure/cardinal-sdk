package com.icure.cardinal.sdk.model.notification

import com.icure.cardinal.sdk.model.base.Identifiable
import com.icure.cardinal.sdk.model.filter.chain.FilterChain
import com.icure.cardinal.sdk.model.specializations.AccessControlKeyHexString
import kotlin.Boolean
import kotlin.String
import kotlin.collections.List

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
data class Subscription<O : Identifiable<String>>(
	public val eventTypes: List<SubscriptionEventType>,
	public val entityClass: String,
	public val filter: FilterChain<O>?,
	public val accessControlKeys: List<AccessControlKeyHexString>?,
	public val useCardinalModelSerialization: Boolean? = null,
) {
  // region Subscription-Subscription

  // endregion
}
