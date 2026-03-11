package com.icure.cardinal.sdk.model.base

/**
 *
 *  Base interface for all entities that have a unique identifier.
 */
public interface Identifiable<T> {
	public val id: T
}
