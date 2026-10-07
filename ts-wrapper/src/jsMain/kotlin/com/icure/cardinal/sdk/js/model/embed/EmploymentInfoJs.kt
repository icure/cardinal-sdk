// auto-generated file
@file:JsQualifier("model")

package com.icure.cardinal.sdk.js.model.embed

import com.icure.cardinal.sdk.js.model.base.CodeStubJs
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("EmploymentInfo")
public sealed external interface EmploymentInfoJs : EncryptableJs {
	public val startDate: Double?

	public val endDate: Double?

	public val professionType: CodeStubJs?

	public val employer: EmployerJs?

	public val isEncrypted: Boolean
}

@JsName("DecryptedEmploymentInfo")
public external class DecryptedEmploymentInfoJs(
	partial: dynamic,
) : EmploymentInfoJs {
	override val startDate: Double?

	override val endDate: Double?

	override val professionType: CodeStubJs?

	override val employer: EmployerJs?

	override val encryptedSelf: String?

	override val isEncrypted: Boolean
}

@JsName("EncryptedEmploymentInfo")
public external class EncryptedEmploymentInfoJs(
	partial: dynamic,
) : EmploymentInfoJs {
	override val startDate: Double?

	override val endDate: Double?

	override val professionType: CodeStubJs?

	override val employer: EmployerJs?

	override val encryptedSelf: String?

	override val isEncrypted: Boolean
}
