// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
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
sealed interface Predicate {
	// region Predicate-Predicate

	// endregion
}
