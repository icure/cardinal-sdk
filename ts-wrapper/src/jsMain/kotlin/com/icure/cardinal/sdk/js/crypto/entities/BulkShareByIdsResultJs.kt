// auto-generated file
@file:JsQualifier("crypto")

package com.icure.cardinal.sdk.js.crypto.entities

import com.icure.cardinal.sdk.js.utils.Record
import kotlin.Array
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("BulkShareByIdsResult")
public external class BulkShareByIdsResultJs(
	partial: dynamic,
) {
	public val notFoundIds: Array<String>

	public val successfulDelegateIdsByEntityId: Record<String, Array<String>>

	public val unmodifiedDelegateIdsByEntityId: Record<String, Array<String>>

	public val shareErrors: Array<FailedRequestDetailsJs>
}
