// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.base

import kotlin.collections.Set

/**
 *
 *  Interface for entities that can be classified using tags from codification systems such as
 * LOINC.
 *  Tags qualify an entity as belonging to a certain class regardless of its value.
 */

interface HasTags {
	public val tags: Set<CodeStub>
	// region HasTags-HasTags

	// endregion
}
