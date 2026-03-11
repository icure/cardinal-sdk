package com.icure.cardinal.sdk.model.base

import com.icure.cardinal.sdk.model.PropertyStub
import kotlin.String
import kotlin.collections.Set

/**
 *
 *  Interface for entities that represent a security principal with an identity, a name, and a set
 * of properties.
 */
public interface Principal : Identifiable<String>, Named {
	public val properties: Set<PropertyStub>
}
