// auto-generated file
@file:JsQualifier("model")

package com.icure.cardinal.sdk.js.model.embed

import com.icure.cardinal.sdk.js.model.base.CodeStubJs
import kotlin.Array
import kotlin.Double
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("ReferenceRange")
public external class ReferenceRangeJs(
	partial: dynamic,
) {
	public val low: Double?

	public val high: Double?

	public val stringValue: String?

	public val tags: Array<CodeStubJs>

	public val codes: Array<CodeStubJs>

	public val notes: Array<DecryptedAnnotationJs>

	public val age: RangeJs?
}
