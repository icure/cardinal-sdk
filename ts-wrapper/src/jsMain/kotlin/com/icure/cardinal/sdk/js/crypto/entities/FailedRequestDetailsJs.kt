// auto-generated file
@file:JsQualifier("crypto")

package com.icure.cardinal.sdk.js.crypto.entities

import com.icure.cardinal.sdk.js.model.EntityReferenceInGroupJs
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("FailedRequestDetails")
public sealed external interface FailedRequestDetailsJs {
	public val entityId: String

	public val delegateReference: EntityReferenceInGroupJs

	public val reason: String?

	@JsName("${'$'}ktClass")
	public val ktClass: String
}
