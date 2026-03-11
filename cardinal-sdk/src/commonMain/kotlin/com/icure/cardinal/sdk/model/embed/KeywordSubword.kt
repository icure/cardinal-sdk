// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.List

/**
 * Represents a subword within a keyword hierarchy. Subwords can be nested recursively to form a
 * tree structure.
 * /
 */
@Serializable
data class KeywordSubword(
	/**
	 * The string value of this subword.
	 */
	public val `value`: String? = null,
	/**
	 * The list of child subwords forming a tree.
	 */
	public val subWords: List<KeywordSubword>? = null,
) {
	// region KeywordSubword-KeywordSubword

	// endregion
}
