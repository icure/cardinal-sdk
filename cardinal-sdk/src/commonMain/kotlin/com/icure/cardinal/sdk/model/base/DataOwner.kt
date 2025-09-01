package com.icure.cardinal.sdk.model.base

import com.icure.cardinal.sdk.model.PropertyStub
import kotlin.collections.Set

public interface DataOwner {
	public val properties: Set<PropertyStub>
}
