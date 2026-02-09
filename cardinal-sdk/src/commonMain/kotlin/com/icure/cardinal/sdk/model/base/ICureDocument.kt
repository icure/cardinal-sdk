package com.icure.cardinal.sdk.model.base

import kotlin.Long
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
interface ICureDocument<T> : Identifiable<T>, HasTags, HasCodes {
	public val created: Long?

	public val modified: Long?

	public val author: String?

	public val responsible: String?
	// region ICureDocument-ICureDocument

	// endregion
}
