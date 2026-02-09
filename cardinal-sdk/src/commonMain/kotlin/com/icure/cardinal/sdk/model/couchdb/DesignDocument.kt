package com.icure.cardinal.sdk.model.couchdb

import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.Map

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class DesignDocument(
	public val id: String,
	public val rev: String? = null,
	@param:DefaultValue("emptyMap()")
	public val revHistory: Map<String, String> = emptyMap(),
	public val language: String? = null,
	@param:DefaultValue("emptyMap()")
	public val views: Map<String, View> = emptyMap(),
	@param:DefaultValue("emptyMap()")
	public val lists: Map<String, String> = emptyMap(),
	@param:DefaultValue("emptyMap()")
	public val shows: Map<String, String> = emptyMap(),
	public val updateHandlers: Map<String, String>? = null,
	@param:DefaultValue("emptyMap()")
	public val filters: Map<String, String> = emptyMap(),
) {
	// region DesignDocument-DesignDocument

	// endregion
}
