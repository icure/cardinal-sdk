package com.icure.cardinal.sdk.model.base

import com.icure.cardinal.sdk.model.PropertyStub
import kotlin.collections.Set

/**
 *
 *  Interface for entities that own and control access to encrypted data in the iCure system.
 *  Data owners (such as healthcare parties, patients, and devices) can grant access to their data
 * through delegations.
 */
public interface DataOwner {
	public val properties: Set<PropertyStub>
}
