// auto-generated file
@file:JsQualifier("crypto.FailedRequestDetails")

package com.icure.cardinal.sdk.js.crypto.entities

import com.icure.cardinal.sdk.js.model.EntityReferenceInGroupJs
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("ResolutionFailed")
public external class FailedRequestDetailsJs_ResolutionFailedJs(
	partial: dynamic,
) : FailedRequestDetailsJs {
	override val entityId: String

	override val delegateReference: EntityReferenceInGroupJs

	override val reason: String?

	override val ktClass: String
}

@JsName("RequestRejected")
public external class FailedRequestDetailsJs_RequestRejectedJs(
	partial: dynamic,
) : FailedRequestDetailsJs {
	override val entityId: String

	override val delegateReference: EntityReferenceInGroupJs

	override val reason: String?

	public val code: Double

	public val shouldRetry: Boolean

	public val updatedForMigration: Boolean

	public val request: DelegateShareOptionsJs?

	override val ktClass: String
}
