package com.icure.cardinal.sdk.model.base

import kotlin.String

/**
 *
 *  Interface for entities that can be identified by a code from a codification system.
 *  The id is typically composed as type|code|version.
 */
public interface CodeIdentification<K> {
	public val id: K

	public val code: String?

	public val context: String?

	public val type: String?

	public val version: String?
}
