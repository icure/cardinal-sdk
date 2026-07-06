// auto-generated file
@file:JsQualifier("model")

package com.icure.cardinal.sdk.js.model.embed

import com.icure.cardinal.sdk.js.model.base.CodeStubJs
import com.icure.cardinal.sdk.js.model.base.IdentifiableJs
import com.icure.cardinal.sdk.js.utils.Record
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("Annotation")
public sealed external interface AnnotationJs : IdentifiableJs<String>, EncryptableJs {
	public val author: String?

	public val created: Double?

	public val modified: Double?

	public val text: String?

	public val markdown: Record<String, out String>

	public val location: String?

	public val confidential: Boolean?

	public val tags: Array<out CodeStubJs>

	public val isEncrypted: Boolean
}

@JsName("DecryptedAnnotation")
public external class DecryptedAnnotationJs(
	partial: dynamic,
) : AnnotationJs {
	override val id: String

	override val author: String?

	override val created: Double?

	override val modified: Double?

	override val text: String?

	override val markdown: Record<String, String>

	override val location: String?

	override val confidential: Boolean?

	override val tags: Array<CodeStubJs>

	override val encryptedSelf: String?

	override val isEncrypted: Boolean
}

@JsName("EncryptedAnnotation")
public external class EncryptedAnnotationJs(
	partial: dynamic,
) : AnnotationJs {
	override val id: String

	override val author: String?

	override val created: Double?

	override val modified: Double?

	override val text: String?

	override val markdown: Record<String, String>

	override val location: String?

	override val confidential: Boolean?

	override val tags: Array<CodeStubJs>

	override val encryptedSelf: String?

	override val isEncrypted: Boolean
}
