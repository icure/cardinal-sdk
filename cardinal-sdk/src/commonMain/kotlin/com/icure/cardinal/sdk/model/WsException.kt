package com.icure.cardinal.sdk.model

import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.Map

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
class WsException(
	public val level: String,
	public val error: String,
	public val translations: Map<String, String>,
) {
	public val dtoSerialName: String
	// region WsException-WsException

	// endregion
}
