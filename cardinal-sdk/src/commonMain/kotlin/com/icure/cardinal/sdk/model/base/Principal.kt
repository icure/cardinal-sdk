// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.base

import com.icure.cardinal.sdk.model.PropertyStub
import kotlin.String
import kotlin.collections.Set

/**
 *
 *  Interface for entities that represent a security principal with an identity, a name, and a set
 * of properties.
 */

interface Principal : Identifiable<String>, Named {
	public val properties: Set<PropertyStub>
	// region Principal-Principal

	// endregion
}
