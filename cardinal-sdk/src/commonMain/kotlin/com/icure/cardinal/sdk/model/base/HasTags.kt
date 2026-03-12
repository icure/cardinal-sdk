package com.icure.cardinal.sdk.model.base

import kotlin.collections.Set

/**
 *
 *  Interface for entities that can be classified using tags from codification systems such as
 * LOINC.
 *  Tags qualify an entity as belonging to a certain class regardless of its value.
 */
public interface HasTags {
	public val tags: Set<CodeStub>
}
