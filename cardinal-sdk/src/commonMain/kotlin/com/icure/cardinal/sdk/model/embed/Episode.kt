package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.model.base.Identifiable
import com.icure.cardinal.sdk.model.base.Named
import com.icure.cardinal.sdk.model.specializations.Base64String
import kotlinx.serialization.Serializable
import kotlin.Long
import kotlin.String

public sealed interface Episode : Encryptable, Identifiable<String>, Named {
	override val id: String

	override val name: String?

	public val comment: String?

	public val startDate: Long?

	public val endDate: Long?

	override val encryptedSelf: Base64String?
}

@Serializable
public data class DecryptedEpisode(
	override val id: String,
	override val name: String? = null,
	override val comment: String? = null,
	override val startDate: Long? = null,
	override val endDate: Long? = null,
	override val encryptedSelf: Base64String? = null,
) : Episode

@Serializable
public data class EncryptedEpisode(
	override val id: String,
	override val name: String? = null,
	override val comment: String? = null,
	override val startDate: Long? = null,
	override val endDate: Long? = null,
	override val encryptedSelf: Base64String? = null,
) : Episode
