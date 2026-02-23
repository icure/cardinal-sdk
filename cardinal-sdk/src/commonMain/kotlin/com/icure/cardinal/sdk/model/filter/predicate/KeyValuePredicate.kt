package com.icure.cardinal.sdk.model.filter.predicate

import com.icure.cardinal.sdk.model.specializations.AnyPrimitive
import com.icure.cardinal.sdk.serialization.AnyPrimitiveSerializer
import kotlinx.serialization.Serializable
import kotlin.String

@Serializable
public data class KeyValuePredicate(
	public val key: String? = null,
	public val `operator`: Operator? = null,
	@Serializable(with = AnyPrimitiveSerializer::class)
	public val `value`: AnyPrimitive? = null,
) : Predicate
