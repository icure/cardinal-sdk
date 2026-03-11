// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.base

import kotlin.collections.Set

/**
 *
 *  Interface for entities that can be qualified with codes from codification systems such as
 * SNOMED-CT, ICPC-2, or ICD-10.
 */

interface HasCodes {
	public val codes: Set<CodeStub>
	// region HasCodes-HasCodes

	// endregion
}
