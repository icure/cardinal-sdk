// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.couchdb

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 *
 *  Enumeration of sort directions for ordering query results.
 */
@Serializable
enum class SortDirection(
	internal val dtoSerialName: String,
) {
	@SerialName("asc")
	Asc("asc"),

	@SerialName("desc")
	Desc("desc"),
}
