// auto-generated file
@file:JsQualifier("crypto")

package com.icure.cardinal.sdk.js.crypto.entities

import com.icure.cardinal.sdk.js.model.EntityReferenceInGroupJs
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

	public val successfulRequestsByEntityId: Record<String, Array<SuccessfulRequestDetailsJs>>

	public val unmodifiedDelegatesByEntityId: Record<String, Array<EntityReferenceInGroupJs>>

	public val shareErrors: Array<FailedRequestDetailsJs>
}
