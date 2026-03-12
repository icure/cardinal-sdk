// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.base

import kotlin.String

/**
 *
 *  @param <T> The type of the entity identity (a String, a UUID, etc.)
 * </T>
 */

interface Versionable<T> : Identifiable<T> {
	public val rev: String?
	// region Versionable-Versionable

	// endregion
}
