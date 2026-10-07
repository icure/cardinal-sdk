// auto-generated file
@file:JsQualifier("model")

package com.icure.cardinal.sdk.js.model

import com.icure.cardinal.sdk.js.model.embed.DecryptedTypedValueJs
import com.icure.cardinal.sdk.js.model.embed.EncryptableJs
import com.icure.cardinal.sdk.js.model.embed.EncryptedTypedValueJs
import com.icure.cardinal.sdk.js.model.embed.TypedValueJs
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("PropertyStub")
public sealed external interface PropertyStubJs : EncryptableJs {
	public val id: String?

	public val type: PropertyTypeStubJs?

	public val typedValue: TypedValueJs?

	public val deletionDate: Double?

	public val isEncrypted: Boolean
}

@JsName("DecryptedPropertyStub")
public external class DecryptedPropertyStubJs(
	partial: dynamic,
) : PropertyStubJs {
	override val id: String?

	override val type: PropertyTypeStubJs?

	override val typedValue: DecryptedTypedValueJs?

	override val deletionDate: Double?

	override val encryptedSelf: String?

	override val isEncrypted: Boolean
}

@JsName("EncryptedPropertyStub")
public external class EncryptedPropertyStubJs(
	partial: dynamic,
) : PropertyStubJs {
	override val id: String?

	override val type: PropertyTypeStubJs?

	override val typedValue: EncryptedTypedValueJs?

	override val deletionDate: Double?

	override val encryptedSelf: String?

	override val isEncrypted: Boolean
}
