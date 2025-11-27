package com.icure.cardinal.sdk.model.base

import com.icure.cardinal.sdk.model.PropertyStub
import kotlin.String
import kotlin.collections.Set

public interface Principal : Identifiable<String>, Named {
	public val properties: Set<PropertyStub>
}
