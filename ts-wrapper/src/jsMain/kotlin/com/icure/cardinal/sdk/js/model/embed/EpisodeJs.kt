// auto-generated file
@file:JsQualifier("model")

package com.icure.cardinal.sdk.js.model.embed

import com.icure.cardinal.sdk.js.model.base.ExtendableJs
import com.icure.cardinal.sdk.js.model.base.IdentifiableJs
import com.icure.cardinal.sdk.js.model.base.NamedJs
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("Episode")
public sealed external interface EpisodeJs : EncryptableJs, IdentifiableJs<String>, NamedJs,
		ExtendableJs {
	public val comment: String?

	public val startDate: Double?

	public val endDate: Double?

	public val isEncrypted: Boolean
}

@JsName("DecryptedEpisode")
public external class DecryptedEpisodeJs(
	partial: dynamic,
) : EpisodeJs {
	override val id: String

	override val name: String?

	override val comment: String?

	override val startDate: Double?

	override val endDate: Double?

	override val encryptedSelf: String?

	override val extensions: dynamic

	override val isEncrypted: Boolean
}

@JsName("EncryptedEpisode")
public external class EncryptedEpisodeJs(
	partial: dynamic,
) : EpisodeJs {
	override val id: String

	override val name: String?

	override val comment: String?

	override val startDate: Double?

	override val endDate: Double?

	override val encryptedSelf: String?

	override val extensions: dynamic

	override val isEncrypted: Boolean
}
