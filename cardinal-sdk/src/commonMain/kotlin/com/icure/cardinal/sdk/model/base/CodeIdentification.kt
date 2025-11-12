package com.icure.cardinal.sdk.model.base

import kotlin.String
import kotlin.collections.Map

public interface CodeIdentification<K> {
	public val id: K

	public val code: String?

	public val context: String?

	public val type: String?

	public val version: String?

	public val label: Map<String, String>?
}
