package com.icure.cardinal.sdk.model.couchdb

import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.Map

@Serializable
public data class DesignDocument(
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
)
