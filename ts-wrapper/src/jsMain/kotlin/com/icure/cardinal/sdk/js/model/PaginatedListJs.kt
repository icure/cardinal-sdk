// auto-generated file
@file:JsQualifier("model")

package com.icure.cardinal.sdk.js.model

import kotlin.Array
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("PaginatedList")
public external class PaginatedListJs<T>(
	partial: dynamic,
) {
	public val rows: Array<T>

	public val nextKeyPair: PaginatedDocumentKeyIdPairJs?

	public val error: PaginationErrorJs?
}
