package com.icure.cardinal.sdk.model.base

import kotlin.String
import kotlin.collections.Map

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
interface CodeIdentification<K> {
	public val id: K

	public val code: String?

	public val context: String?

	public val type: String?

	public val version: String?
	// region CodeIdentification-CodeIdentification

	// endregion
}
