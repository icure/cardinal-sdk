package com.icure.cardinal.sdk.model.filter.predicate

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonClassDiscriminator
import kotlin.OptIn

/**
 * Sealed interface for filter predicates that can be used to post-filter results from a filter
 * chain.
 * /
 */
@OptIn(ExperimentalSerializationApi::class)
@JsonClassDiscriminator("${'$'}type")
@Serializable
public sealed interface Predicate
