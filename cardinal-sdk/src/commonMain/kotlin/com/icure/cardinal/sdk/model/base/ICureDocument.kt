package com.icure.cardinal.sdk.model.base

import kotlin.Long
import kotlin.String

public interface ICureDocument<T> : Identifiable<T>, HasTags, HasCodes {
	public val created: Long?

	public val modified: Long?

	public val author: String?

	public val responsible: String?

	public val medicalLocationId: String?

	public val endOfLife: Long?
}
