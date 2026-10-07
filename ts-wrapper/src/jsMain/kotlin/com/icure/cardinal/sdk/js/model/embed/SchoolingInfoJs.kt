// auto-generated file
@file:JsQualifier("model")

package com.icure.cardinal.sdk.js.model.embed

import com.icure.cardinal.sdk.js.model.base.CodeStubJs
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("SchoolingInfo")
public sealed external interface SchoolingInfoJs : EncryptableJs {
	public val startDate: Double?

	public val endDate: Double?

	public val school: String?

	public val typeOfEducation: CodeStubJs?

	public val isEncrypted: Boolean
}

@JsName("DecryptedSchoolingInfo")
public external class DecryptedSchoolingInfoJs(
	partial: dynamic,
) : SchoolingInfoJs {
	override val startDate: Double?

	override val endDate: Double?

	override val school: String?

	override val typeOfEducation: CodeStubJs?

	override val encryptedSelf: String?

	override val isEncrypted: Boolean
}

@JsName("EncryptedSchoolingInfo")
public external class EncryptedSchoolingInfoJs(
	partial: dynamic,
) : SchoolingInfoJs {
	override val startDate: Double?

	override val endDate: Double?

	override val school: String?

	override val typeOfEducation: CodeStubJs?

	override val encryptedSelf: String?

	override val isEncrypted: Boolean
}
