package com.icure.cardinal.sdk.model.base

import kotlin.collections.Set

/**
 *
 *  Interface for entities that can be qualified with codes from codification systems such as
 * SNOMED-CT, ICPC-2, or ICD-10.
 */
public interface HasCodes {
	public val codes: Set<CodeStub>
}
