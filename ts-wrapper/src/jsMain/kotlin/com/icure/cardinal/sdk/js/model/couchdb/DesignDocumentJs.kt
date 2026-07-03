// auto-generated file
@file:JsQualifier("model")

package com.icure.cardinal.sdk.js.model.couchdb

import com.icure.cardinal.sdk.js.utils.Record
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("DesignDocument")
public external class DesignDocumentJs(
	partial: dynamic,
) {
	public val id: String

	public val rev: String?

	public val language: String?

	public val views: Record<String, ViewJs>

	public val lists: Record<String, String>

	public val shows: Record<String, String>

	public val updateHandlers: Record<String, String>?

	public val filters: Record<String, String>
}
