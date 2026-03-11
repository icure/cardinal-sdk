package com.icure.cardinal.sdk.model.base

import kotlin.Long

/**
 *
 *  Interface for entities that support soft deletion through an end-of-life timestamp.
 */
public interface HasEndOfLife {
	public val endOfLife: Long?
}
