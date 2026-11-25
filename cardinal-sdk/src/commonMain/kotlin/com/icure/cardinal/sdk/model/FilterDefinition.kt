// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model

import kotlinx.serialization.Serializable
import kotlin.String
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlin.collections.List

/**
 *
 *  Metadata describing a single filter exposed by the API.
 *
 *  @property filter the name of the concrete filter DTO type.
 *  @property entity the simple name of the entity owning the configuration view(s) this filter
 * relies on (null if none).
 */
@Serializable
data class FilterDefinition(
	public val filter: String,
	public val entity: String? = null,
) {
	// region FilterDefinition-FilterDefinition

	// endregion
}
