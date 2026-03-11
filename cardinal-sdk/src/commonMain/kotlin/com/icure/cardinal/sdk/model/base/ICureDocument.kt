package com.icure.cardinal.sdk.model.base

import kotlin.Long
import kotlin.String

/**
 *
 *  Interface for iCure document entities that track creation and modification metadata.
 *  Extends [IdentifiableDto], [HasTagsDto], and [HasCodesDto] to provide a common base for all
 * medical documents.
 */
public interface ICureDocument<T> : Identifiable<T>, HasTags, HasCodes {
	public val created: Long?

	public val modified: Long?

	public val author: String?

	public val responsible: String?
}
